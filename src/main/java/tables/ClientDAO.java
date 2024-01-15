package tables;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ClientDAO {

    private JdbcTemplate jdbcTemplate;

    public List<Client> list() {
        String sql = "SELECT * FROM KLIENCI";
        List<Client> list = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Client.class));
        return list;
    }
    public void save(Client client) {

    }
    public Client get(int id) {
        return null;
    }
    public void update(Client client) {

    }
    public void delete(int id) {

    }

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
