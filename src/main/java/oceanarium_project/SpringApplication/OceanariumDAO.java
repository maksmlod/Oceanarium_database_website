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
public class OceanariumDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OceanariumDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oceanarium> list(){
        String sql = "SELECT * FROM OCEANARIA";

        List<Oceanarium> listOceanarium = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Oceanarium.class));
        return listOceanarium;

    }

    public void save(Oceanarium oceanarium) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("oceanaria").usingColumns("nazwa","data_zalozenia","godziny_otwarcia",
                "nr_adresu","nr_wlasciciela");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oceanarium);
        insertActor.execute(param);
    }

    public Oceanarium get(int nr_oceanarium) {
        String sql = "SELECT * FROM Oceanaria WHERE nr_oceanarium = ?";
        Object[] args = {nr_oceanarium};
        Oceanarium oceanarium = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Oceanarium.class));
        return oceanarium;
    }
    public Oceanarium get1(int nr_oceanarium) {
        Object[] args = {nr_oceanarium};
        String sql = "SELECT * FROM Oceanaria WHERE nr_oceanarium = " + args[0];
        Oceanarium oceanarium = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Oceanarium.class));
        return oceanarium;
    }

    public void update(Oceanarium oceanarium) {
        String sql = "UPDATE Oceanaria SET nazwa=:nazwa, data_zalozenia=:data_zalozenia," +
                "godziny_otwarcia=:godziny_otwarcia, nr_adresu=:nr_adresu, nr_wlasciciela=:nr_wlasciciela WHERE nr_oceanarium=:nr_oceanarium";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oceanarium);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_oceanarium) {
        String sql = "DELETE FROM Oceanaria WHERE nr_oceanarium = ?";
        jdbcTemplate.update(sql, nr_oceanarium);
    }

}
