public class Pojazd {
    private String nazwa;
    private String model;
    double objetosc;
    private String typSilnika;
    private double pojemnoscSilnika;
    private String numerRejestracyjny;


    Pojazd(String nazwa, String model, double objetosc,
           String typSilnika,double pojemnoscSilnika, String numerRejestracyjny){
        this.nazwa=nazwa;
        this.model=model;
        this.objetosc=objetosc;
        this.typSilnika=typSilnika;
        this.pojemnoscSilnika=pojemnoscSilnika;
        this.numerRejestracyjny=numerRejestracyjny;
    }
    Pojazd(String nazwa, String model, String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, double szerokosc,
           double wysokosc, double dlugosc){
        this.nazwa=nazwa;
        this.model=model;
        this.objetosc=szerokosc* dlugosc* wysokosc;
        this.typSilnika=typSilnika;
        this.pojemnoscSilnika=pojemnoscSilnika;
        this.numerRejestracyjny=numerRejestracyjny;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getObjetosc() {
        return objetosc;
    }

    public void setObjetosc(double objetosc) {
        this.objetosc = objetosc;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypSilnika() {
        return typSilnika;
    }

    public void setTypSilnika(String typSilnika) {
        this.typSilnika = typSilnika;
    }

    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public void setPojemnoscSilnika(double pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String toString(){
        return "Nazwa:" + nazwa + "\nModel: "+ model + "\nObjetosc:" + objetosc +
                "\nTyp silnika: "+ typSilnika + "\nPojemnosc silnika:" +
                pojemnoscSilnika + "\nNumer rejestracyjny: " + numerRejestracyjny;
    }
}
