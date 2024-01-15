package oceanarium_project.SpringApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);

/*
		java.sql.Connection connect = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe?user=SYSTEM&password=system");
		System.out.println(connect);

 */
		run();
	}

	public static void run() throws SQLException {
		String sql = "INSERT INTO Adresy (Nr_Adresu, Miejscowosc, Kod_pocztowy, Ulica, Nr_budynku)\n" +
				" VALUES ('2', 'Inazuma', '12-345', 'domekRaiden', '420')";
		Connection connection =
				DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe?user=SYSTEM&password=system");
		PreparedStatement p = connection.prepareStatement(sql);
		System.out.println("Executing SQL: " + sql);
		p.executeQuery();



		/*
		String sqlDel = "DELETE FROM Klienci " +
				"WHERE Nr_klienta = '1';";
		PreparedStatement pDel = connection.prepareStatement(sqlDel);
		pDel.execute();
		 */
		}
	}

