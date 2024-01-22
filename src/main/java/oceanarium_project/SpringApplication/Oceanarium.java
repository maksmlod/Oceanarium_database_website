package oceanarium_project.SpringApplication;


import java.sql.Date;

public class Oceanarium {
    private int nr_oceanarium;
    private String nazwa;
    private String data_zalozenia;
    private String godziny_otwarcia;
    private int nr_adresu;
    private int nr_wlasciciela;

    public Oceanarium() {
    }

    public Oceanarium(int nr_oceanarium, String nazwa, String data_zalozenia, String godziny_otwarcia, int nr_adresu, int nr_wlasciciela) {
        this.nr_oceanarium = nr_oceanarium;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.godziny_otwarcia = godziny_otwarcia;
        this.nr_adresu = nr_adresu;
        this.nr_wlasciciela = nr_wlasciciela;
    }

    public int getNr_oceanarium() {
        return nr_oceanarium;
    }

    public void setNr_oceanarium(int nr_oceanarium) {
        this.nr_oceanarium = nr_oceanarium;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(String data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public String getGodziny_otwarcia() {
        return godziny_otwarcia;
    }

    public void setGodziny_otwarcia(String godziny_otwarcia) {
        this.godziny_otwarcia = godziny_otwarcia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public int getNr_wlasciciela() {
        return nr_wlasciciela;
    }

    public void setNr_wlasciciela(int nr_wlasciciela) {
        this.nr_wlasciciela = nr_wlasciciela;
    }

    @Override
    public String toString() {
        return "Oceanarium{" +
                "nr_oceanarium=" + nr_oceanarium +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + data_zalozenia +
                ", godziny_otwarcia='" + godziny_otwarcia + '\'' +
                ", nr_adresu=" + nr_adresu +
                ", nr_wlasciciela=" + nr_wlasciciela +
                '}';
    }
}
