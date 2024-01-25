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
public class KlientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list(){
        String sql = "SELECT * FROM KLIENCI";

        List<Klient> listKlient = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return listKlient;

    }

    public List<Klient> list2(){
        String sql = "SELECT * FROM KLIENCI WHERE imie = 'user' AND nazwisko = 'user'";

        List<Klient> listKlient = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return listKlient;

    }

    public void save(Klient klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klienci").usingColumns("imie","nazwisko","plec","nr_telefonu","email",
                "rodzaj_dokumentu","numer_dokumentu","nr_oceanarium");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param);
    }

    public Klient get(int nr_klienta) {
        String sql = "SELECT * FROM Klienci WHERE nr_klienta = ?";
        Object[] args = {nr_klienta};
        Klient klient = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    public Klient get1(int nr_klienta) {
        Object[] args = {nr_klienta};
        String sql = "SELECT * FROM Klienci WHERE nr_klienta = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }

    public void update(Klient klient) {
        String sql = "UPDATE Klienci SET imie=:imie, nazwisko=:nazwisko, plec=:plec, " +
                "nr_telefonu=:nr_telefonu, email=:email, rodzaj_dokumentu=:rodzaj_dokumentu," +
                "numer_dokumentu=:numer_dokumentu, nr_oceanarium=:nr_oceanarium WHERE nr_klienta=:nr_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_klienta) {
        String sql = "DELETE FROM Klienci WHERE nr_klienta = ?";
        jdbcTemplate.update(sql, nr_klienta);
    }

}