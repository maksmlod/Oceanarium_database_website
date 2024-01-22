package oceanarium_project.SpringApplication;

public class Pracownik {
    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private String plec;
    private int pesel;
    private int nr_telefonu;
    private String email;
    private String data_urodzenia;
    private String wyksztalcenie;
    private String data_zatrudnienia;
    private int nr_konta;
    private int nr_oceanarium;
    private int nr_adresu;

    public Pracownik() {}
    public Pracownik(int nr_pracownika, String imie, String nazwisko, String plec, int pesel, int nr_telefonu, String email, String data_urodzenia, String wyksztalcenie, String data_zatrudnienia, int nr_konta, int nr_oceanarium, int nr_adresu) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.pesel = pesel;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.data_urodzenia = data_urodzenia;
        this.wyksztalcenie = wyksztalcenie;
        this.data_zatrudnienia = data_zatrudnienia;
        this.nr_konta = nr_konta;
        this.nr_oceanarium = nr_oceanarium;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
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

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public int getNr_konta() {
        return nr_konta;
    }

    public void setNr_konta(int nr_konta) {
        this.nr_konta = nr_konta;
    }

    public int getNr_oceanarium() {
        return nr_oceanarium;
    }

    public void setNr_oceanarium(int nr_oceanarium) {
        this.nr_oceanarium = nr_oceanarium;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", pesel=" + pesel +
                ", nr_telefonu=" + nr_telefonu +
                ", email='" + email + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", wyksztalcenie='" + wyksztalcenie + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", nr_konta=" + nr_konta +
                ", nr_oceanarium=" + nr_oceanarium +
                ", nr_adresu=" + nr_adresu +
                '}';
    }
}
