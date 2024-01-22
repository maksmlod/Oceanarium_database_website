package oceanarium_project.SpringApplication;

public class Klient {
    private int nr_klienta;
    private String imie;
    private String nazwisko;
    private String plec;
    private int nr_telefonu;
    private String email;
    private String rodzaj_dokumentu;
    private String numer_dokumentu;
    private int nr_oceanarium;



    public Klient() {}
    public Klient(int nr_klienta, String imie, String nazwisko, String plec, int nr_telefonu, String email, String rodzaj_dokumentu, String numer_dokumentu, int nr_oceanarium) {
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.rodzaj_dokumentu = rodzaj_dokumentu;
        this.numer_dokumentu = numer_dokumentu;
        this.nr_oceanarium = nr_oceanarium;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(int nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRodzaj_dokumentu() {
        return rodzaj_dokumentu;
    }

    public void setRodzaj_dokumentu(String rodzaj_dokumentu) {
        this.rodzaj_dokumentu = rodzaj_dokumentu;
    }

    public String getNumer_dokumentu() {
        return numer_dokumentu;
    }

    public void setNumer_dokumentu(String numer_dokumentu) {
        this.numer_dokumentu = numer_dokumentu;
    }

    public int getNr_oceanarium() {
        return nr_oceanarium;
    }

    public void setNr_oceanarium(int nr_oceanarium) {
        this.nr_oceanarium = nr_oceanarium;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nr_klienta=" + nr_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", nr_telefonu=" + nr_telefonu +
                ", email='" + email + '\'' +
                ", rodzaj_dokumentu='" + rodzaj_dokumentu + '\'' +
                ", numer_dokumentu='" + numer_dokumentu + '\'' +
                ", nr_oceanarium=" + nr_oceanarium +
                '}';
    }
}
