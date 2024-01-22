package oceanarium_project.SpringApplication;

public class Wlasciciel {
    private int nr_wlasciciela;
    private String imie;
    private String nazwisko;
    private int pesel;

    public Wlasciciel() {
    }

    public Wlasciciel(int nr_wlasciciela, String imie, String nazwisko, int pesel) {
        this.nr_wlasciciela = nr_wlasciciela;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public int getNr_wlasciciela() {
        return nr_wlasciciela;
    }

    public void setNr_wlasciciela(int nr_wlasciciela) {
        this.nr_wlasciciela = nr_wlasciciela;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Wlasciciel{" +
                "nr_wlasciciela=" + nr_wlasciciela +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                '}';
    }
}
