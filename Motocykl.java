public class Motocykl extends Pojazd {
    private String rodzajZaplonu;
    private int iloscKol;

    Motocykl(String nazwa, String model, double objetosc,
             String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, String rodzajZaplonu,
             int iloscKol){
        super(nazwa, model, objetosc, typSilnika, pojemnoscSilnika, numerRejestracyjny);
        this.rodzajZaplonu=rodzajZaplonu;
        this.iloscKol=iloscKol;
    }
    Motocykl(String nazwa, String model, double szerokosc, double wysokosc, double dlugosc,
                    String typSilnika, double pojemnoscSilnika, String numerRejestracyjny,
                    int iloscKol, String rodzajZaplonu){
        super(nazwa, model, typSilnika, pojemnoscSilnika, numerRejestracyjny, szerokosc, wysokosc, dlugosc);
        this.rodzajZaplonu=rodzajZaplonu;
        this.iloscKol=iloscKol;
        this.objetosc= szerokosc* wysokosc* dlugosc;

    }

    public int getIloscKol() {
        return iloscKol;
    }

    public void setIloscKol(int iloscKol) {
        this.iloscKol = iloscKol;
    }

    public String getRodzajZaplonu() {
        return rodzajZaplonu;
    }


    public void setRodzajZaplonu(String rodzajZaplonu) {
        this.rodzajZaplonu = rodzajZaplonu;
    }

    public String toString(){
        return "Typ: Motocykl"+ "\nNazwa:" + getNazwa() + "\nModel: "+ getModel() + "\nObjetosc:" + objetosc +
                "\nTyp silnika: "+ getTypSilnika() + "\nPojemnosc silnika:" +
                getPojemnoscSilnika() + "\nNumer rejestracyjny: " + getNumerRejestracyjny() + "\nRodzaj Zaplonu: "
                + rodzajZaplonu + "\nIlosc kol: "+ iloscKol;
    }

}
