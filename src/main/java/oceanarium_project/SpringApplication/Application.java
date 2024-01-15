package oceanarium_project.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);

		/*
		java.sql.Connection connect = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe?user=SYSTEM&password=system");
		System.out.println(connect);

		 */

	}


}
