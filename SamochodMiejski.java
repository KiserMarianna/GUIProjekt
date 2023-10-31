public class SamochodMiejski extends Pojazd {
    private int iloscDrzwi;
    private int iloscKol;
    private boolean czyElektryczny;

    SamochodMiejski(String nazwa, String model, double objetosc,
                     String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, int iloscDrzwi,
                     int iloscKol, boolean czyElektryczny){
        super(nazwa, model, objetosc, typSilnika, pojemnoscSilnika, numerRejestracyjny);
        this.iloscDrzwi=iloscDrzwi;
        this.iloscKol=iloscKol;
        this.czyElektryczny=czyElektryczny;
    }

    SamochodMiejski(String nazwa, String model, double szerokosc, double wysokosc, double dlugosc,
                    String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, int iloscDrzwi,
                    int iloscKol, boolean czyElektryczny){
        super(nazwa, model, typSilnika, pojemnoscSilnika, numerRejestracyjny, szerokosc, wysokosc, dlugosc);
        this.czyElektryczny=czyElektryczny;
        this.iloscKol=iloscKol;
        this.iloscDrzwi=iloscDrzwi;
        this.objetosc= szerokosc* wysokosc* dlugosc;

    }

    public boolean getCzyElektryczny() {
        return czyElektryczny;
    }

    public void setCzyElektryczny(boolean czyElektryczny) {
        this.czyElektryczny = czyElektryczny;
    }

    public int getIloscDrzwi() {
        return iloscDrzwi;
    }

    public void setIloscDrzwi(int iloscDrzwi) {
        this.iloscDrzwi = iloscDrzwi;
    }

    public int getIloscKol() {
        return iloscKol;
    }

    public void setIloscKol(int iloscKol) {
        this.iloscKol = iloscKol;
    }

    public String toString(){
        return "Typ: Samochod Miejski"+ "\nNazwa:" + getNazwa() + "\nModel: "+ getModel() + "\nObjetosc:" + objetosc +
                "\nTyp silnika: "+ getTypSilnika()+ "\nPojemnosc silnika:" +
                getPojemnoscSilnika() + "\nNumer rejestracyjny: " +
                getNumerRejestracyjny() + iloscDrzwi + "\nIlosc kol: " + iloscKol +
                "\nCzy elektryczny: " + czyElektryczny ;
    }
}
