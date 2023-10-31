public class SamochodTerenowy extends Pojazd {
    private int iloscDrzwi;
    private int iloscKol;
    private boolean czySUV;

    SamochodTerenowy(String nazwa, String model, double objetosc,
                     String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, int iloscDrzwi,
                     int iloscKol, boolean czySUV){
        super(nazwa, model, objetosc, typSilnika, pojemnoscSilnika, numerRejestracyjny);
        this.iloscDrzwi=iloscDrzwi;
        this.iloscKol=iloscKol;
        this.czySUV=czySUV;
    }

    SamochodTerenowy(String nazwa, String model, double szerokosc, double wysokosc, double dlugosc,
                    String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, int iloscDrzwi,
                    int iloscKol, boolean czySUV){
        super(nazwa, model, typSilnika, pojemnoscSilnika, numerRejestracyjny, szerokosc, wysokosc, dlugosc);
        this.czySUV=czySUV;
        this.iloscKol=iloscKol;
        this.iloscDrzwi=iloscDrzwi;
        this.objetosc= szerokosc* wysokosc* dlugosc;

    }

    public int getIloscKol() {
        return iloscKol;
    }

    public void setIloscKol(int iloscKol) {
        this.iloscKol = iloscKol;
    }

    public int getIloscDrzwi() {
        return iloscDrzwi;
    }

    public void setIloscDrzwi(int iloscDrzwi) {
        this.iloscDrzwi = iloscDrzwi;
    }

    public boolean getCzySUV() {
        return czySUV;
    }

    public void setCzySUV(boolean czySUV) {
        this.czySUV = czySUV;
    }

    public String toString(){
            return "Typ: Samochod Terenowy "+ "\nNazwa:" + getNazwa() + "\nModel: "+ getModel() + "\nObjetosc:" + objetosc +
                    "\nTyp silnika: "+ getTypSilnika() + "\nPojemnosc silnika:" +
                    getPojemnoscSilnika() + "\nNumer rejestracyjny" + getNumerRejestracyjny() +
                    "\nIlosc drzwi: "+ iloscDrzwi + "\nIlosc kol: " + iloscKol +
                    "\nCzy SUV: "+ czySUV;
    }
}
