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
public class WlascicielDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WlascicielDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wlasciciel> list(){
        String sql = "SELECT * FROM WLASCICIELE";

        List<Wlasciciel> listWlasciciel = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Wlasciciel.class));
        return listWlasciciel;

    }

    public void save(Wlasciciel wlasciciel) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("wlasciciele").usingColumns("imie","nazwisko","pesel");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wlasciciel);
        insertActor.execute(param);
    }

    public Wlasciciel get(int nr_wlasciciela) {
        String sql = "SELECT * FROM Wlasciciele WHERE nr_wlasciciela = ?";
        Object[] args = {nr_wlasciciela};
        Wlasciciel wlasciciel = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Wlasciciel.class));
        return wlasciciel;
    }
    public Wlasciciel get1(int nr_wlasciciela) {
        Object[] args = {nr_wlasciciela};
        String sql = "SELECT * FROM Wlasciciele WHERE nr_wlasciciela = " + args[0];
        Wlasciciel wlasciciel = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Wlasciciel.class));
        return wlasciciel;
    }

    public void update(Wlasciciel wlasciciel) {
        String sql = "UPDATE Wlasciciele SET imie=:imie, nazwisko=:nazwisko, " +
                "pesel=:pesel WHERE nr_wlasciciela=:nr_wlasciciela";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wlasciciel);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_wlasciciela) {
        String sql = "DELETE FROM Wlasciciele WHERE nr_wlasciciela = ?";
        jdbcTemplate.update(sql, nr_wlasciciela);
    }

}
