package oceanarium_project.SpringApplication;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.hibernate.annotations.GeneratorType;


public class Adres {

    private int nr_adresu;
    private String miejscowosc;
    private String kod_pocztowy;
    private String ulica;
    private int nr_budynku;
    private int nr_lokalu;

    public Adres() {
    }

    public Adres(int nr_adresu, String miejscowosc, String kod_pocztowy, String ulica, int nr_budynku, int nr_lokalu) {
        this.nr_adresu = nr_adresu;
        this.miejscowosc = miejscowosc;
        this.kod_pocztowy = kod_pocztowy;
        this.ulica = ulica;
        this.nr_budynku = nr_budynku;
        this.nr_lokalu = nr_lokalu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNr_budynku() {
        return nr_budynku;
    }

    public void setNr_budynku(int nr_budynku) {
        this.nr_budynku = nr_budynku;
    }

    public int getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(int nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nr_adresu=" + nr_adresu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_budynku=" + nr_budynku +
                ", nr_lokalu=" + nr_lokalu +
                '}';
    }
}
