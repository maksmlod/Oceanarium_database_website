package oceanarium_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class AdresDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";

        List<Adres> listAdres = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return listAdres;

    }

    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("miejscowosc","kod_pocztowy","ulica","nr_budynku","nr_lokalu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }

    public Adres get(int nr_adresu) {
        String sql = "SELECT * FROM Adresy WHERE nr_adresu = ?";
        Object[] args = {nr_adresu};
        Adres adres = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }
    public Adres get1(int nr_adresu) {
        Object[] args = {nr_adresu};
        String sql = "SELECT * FROM Adresy WHERE nr_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    public void update(Adres adres) {
        String sql = "UPDATE Adresy SET miejscowosc=:miejscowosc, kod_pocztowy=:kod_pocztowy, ulica=:ulica," +
                "nr_budynku=:nr_budynku, nr_lokalu=:nr_lokalu WHERE nr_adresu=:nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_adresu) {
        String sql = "DELETE FROM Adresy WHERE nr_adresu = ?";
        jdbcTemplate.update(sql, nr_adresu);
    }

}
