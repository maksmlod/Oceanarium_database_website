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
public class PracownikDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return listPracownik;

    }

    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("imie","nazwisko","plec","pesel","nr_telefonu",
                "email","data_urodzenia","wyksztalcenie","data_zatrudnienia","nr_konta",
                "nr_oceanarium","nr_adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    public Pracownik get(int nr_pracownika) {
        String sql = "SELECT * FROM Pracownicy WHERE nr_pracownika = ?";
        Object[] args = {nr_pracownika};
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }
    public Pracownik get1(int nr_pracownika) {
        Object[] args = {nr_pracownika};
        String sql = "SELECT * FROM Pracownicy WHERE nr_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }

    public void update(Pracownik pracownik) {
        String sql = "UPDATE Pracownicy SET imie=:imie, nazwisko=:nazwisko, plec=:plec," +
                "pesel=:pesel, nr_telefonu=:nr_telefonu, email=:email," +
                "data_urodzenia=:data_urodzenia, wyksztalcenie=:wyksztalcenie," +
                "data_zatrudnienia=:data_zatrudnienia, nr_konta=:nr_konta, " +
                "nr_oceanarium=:nr_oceanarium, nr_adresu=:nr_adresu WHERE nr_pracownika=:nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_pracownika) {
        String sql = "DELETE FROM Pracownicy WHERE nr_pracownika = ?";
        jdbcTemplate.update(sql, nr_pracownika);
    }

}
