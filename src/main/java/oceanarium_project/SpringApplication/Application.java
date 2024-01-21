package oceanarium_project.SpringApplication;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application {
	@Autowired private static JdbcTemplate jdbcTemplate;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);
	//	run();
	}

	public static void runSqlStatement(String sql) throws SQLException {
		Connection connection =
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe?user=SYSTEM&password=system");
		PreparedStatement p = connection.prepareStatement(sql);
		p.executeQuery();
	}

	public static void run() throws SQLException {
		deleteAllData();
		runSqlStatement("INSERT INTO Adresy (Miejscowosc, Kod_pocztowy, Ulica, Nr_budynku, Nr_lokalu) VALUES ('Warszawa','09-234','Mazowiecka','26','8')");
		runSqlStatement("INSERT INTO Adresy (Miejscowosc, Kod_pocztowy, Ulica, Nr_budynku, Nr_lokalu) VALUES ('Warszawa2','09-234','Mazowiecka','26','8')");
		runSqlStatement("INSERT INTO Adresy (Miejscowosc, Kod_pocztowy, Ulica, Nr_budynku, Nr_lokalu) VALUES ('Warszawa3','09-234','Mazowiecka','26','8')");
	}

	public static void deleteAllData() throws SQLException {
		runSqlStatement("DELETE FROM wlasciciele");
		runSqlStatement("DELETE FROM adresy");
		runSqlStatement("DELETE FROM oceanaria");
		runSqlStatement("DELETE FROM zbiorniki");
		runSqlStatement("DELETE FROM klienci");
		runSqlStatement("DELETE FROM organizmy");
		runSqlStatement("DELETE FROM pracownicy");
		runSqlStatement("DELETE FROM bilety");
	}


}
/*
	runSqlStatement("INSERT INTO Adresy (Miejscowosc, Kod_pocztowy, Ulica, Nr_budynku, Nr_lokalu) VALUES ('Warszawa','09-234','Mazowiecka','26','8')");

	runSqlStatement("INSERT INTO Wlasciciele (Imie, Nazwisko, PESEL) VALUES ('Henryk','Kowalski','03261406719')");
	runSqlStatement("INSERT INTO Wlasciciele (Imie, Nazwisko, PESEL) VALUES ('Antoni','Dabrowski','96261128231')");

	runSqlStatement("INSERT INTO Oceanaria (Nazwa, Data_zalozenia, Godziny_otwarcia, Nr_adresu, Nr_wlasciciela) VALUES ('OceanariumABC',TO_DATE('2005-11-12','YYYY-MM-DD'),'08-20','1','2')");

	runSqlStatement("INSERT INTO Zbiorniki (Material, Stan, Data_ostatniego_czyszczenia, Wymiary, Nr_Oceanarium) VALUES ('Szklo','Dobry',TO_DATE('2024-01-01','YYYY-MM-DD'),'12x14x9','1')");
	runSqlStatement("INSERT INTO Zbiorniki (Material, Stan, Data_ostatniego_czyszczenia, Wymiary, Nr_Oceanarium) VALUES ('Stal','Dobry',TO_DATE('2023-09-08','YYYY-MM-DD'),'90x14x25','1')");
	runSqlStatement("INSERT INTO Zbiorniki (Material, Stan, Data_ostatniego_czyszczenia, Wymiary, Nr_Oceanarium) VALUES ('Szklo','Do konserwacji',TO_DATE('2023-03-04','YYYY-MM-DD'),'12x140x10','1')");

	runSqlStatement("INSERT INTO Klienci (Imie, Nazwisko, Plec, Nr_telefonu, Email, Rodzaj_dokumentu, Numer_dokumentu, Nr_Oceanarium) VALUES ('Kamil','Ciecierewicz','M','+48123321911','kcie@gmail.com','Paszport','CE3425BFD3','1')");
	runSqlStatement("INSERT INTO Klienci (Imie, Nazwisko, Plec, Nr_telefonu, Email, Rodzaj_dokumentu, Numer_dokumentu, Nr_Oceanarium) VALUES ('Magda','Pawlowska','K','+48122651911','mag@onet.pl','Paszport','DEXD5B903','1')");
	runSqlStatement("INSERT INTO Klienci (Imie, Nazwisko, Plec, Nr_telefonu, Email, Rodzaj_dokumentu, Numer_dokumentu, Nr_Oceanarium) VALUES ('Tadeusz','Kokon','M','+48926734911','kokot@gmail.com','Paszport','S2359CBFD3','1')");

	runSqlStatement("INSERT INTO Organizmy (Czy_ekspozycja, Umaszczenie, Notatki, Nr_Zbiornika) VALUES ('T','Czerwone','Duza ryba','2')");
	runSqlStatement("INSERT INTO Organizmy (Czy_ekspozycja, Umaszczenie, Notatki, Nr_Zbiornika) VALUES ('N','Biale','Maly rekin','2')");
	runSqlStatement("INSERT INTO Organizmy (Czy_ekspozycja, Umaszczenie, Notatki, Nr_Zbiornika) VALUES ('T','Szare','Ogromny szczupak','1')");

	runSqlStatement("INSERT INTO Pracownicy (Imie, Nazwisko, Plec, PESEL, Nr_telefonu, Email, Data_urodzenia, Wyksztalcenie, Data_zatrudnienia, Nr_konta, Nr_Oceanarium, Nr_adresu) VALUES ('Stefan','Cieszyn','M','98276392391','+48723917833','stc@gmail.com',TO_DATE('1998-06-12','YYYY-MM-DD'),'Srednie',TO_DATE('2023-04-06','YYYY-MM-DD'),'32183821839083','1','1')");
	runSqlStatement("INSERT INTO Pracownicy (Imie, Nazwisko, Plec, PESEL, Nr_telefonu, Email, Data_urodzenia, Wyksztalcenie, Data_zatrudnienia, Nr_konta, Nr_Oceanarium, Nr_adresu) VALUES ('Kamila','Kafan','K','39002392391','+48020097233','jastrzab@gmail.com',TO_DATE('1996-09-01','YYYY-MM-DD'),'Wyzsze',TO_DATE('2023-09-02','YYYY-MM-DD'),'11083899805633','1','1')");

	runSqlStatement("INSERT INTO Bilety (Data_kupienia, Data_waznosci, Rodzaj_biletu, Ulga, Nr_Klienta, Nr_Pracownika, Nr_Oceanarium) VALUES (TO_DATE('2024-01-02','YYYY-MM-DD'),TO_DATE('2024-01-03','YYYY-MM-DD'),'Ulgowy','20%','2','1','1')");

 */