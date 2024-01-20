package oceanarium_project.SpringApplication;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

public class Adres {
    private int id;
    private String miejscowosc;
    private String kod_pocztowy;
    private String ulica;
    private int nr_budynku;
    private int nr_lokalu;

    public Adres() {
    }

    public Adres(int id, String miejscowosc, String kod_pocztowy, String ulica, int nr_budynku, int nr_lokalu) {
        this.id = id;
        this.miejscowosc = miejscowosc;
        this.kod_pocztowy = kod_pocztowy;
        this.ulica = ulica;
        this.nr_budynku = nr_budynku;
        this.nr_lokalu = nr_lokalu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_budynku=" + nr_budynku +
                ", nr_lokalu=" + nr_lokalu +
                '}';
    }
}
