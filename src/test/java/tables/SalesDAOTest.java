package tables;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalesDAOTest {
    private ClientDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        datasource.setUsername("SYSTEM");
        datasource.setPassword("system");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new ClientDAO(new JdbcTemplate(datasource));
    }
    @Test
     void testList() {
        List<Client> listClient = dao.list();
        assertTrue(listClient.isEmpty());
    }
    @Test
    void testSave() {

    }
    @Test
    void testGet() {

    }
    @Test
    void testUpdate() {

    }
    @Test
    void testDelete() {

    }
}
