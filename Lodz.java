public class Lodz extends Pojazd{
    private boolean czyZagle;

    Lodz(String nazwa, String model, double objetosc,
         String typSilnika, double pojemnoscSilnika, String numerRejestracyjny,boolean czyZagle){
        super(nazwa, model, objetosc, typSilnika, pojemnoscSilnika, numerRejestracyjny);
        this.czyZagle=czyZagle;
    }
    Lodz(String nazwa, String model, double dlugosc, double szerokosc,
           double wysokosc, boolean czyZagle,
           String  typSilnika,double pojemnoscSilnika, String numerRejestracyjny){
        super(nazwa, model, typSilnika, pojemnoscSilnika, numerRejestracyjny, szerokosc, wysokosc, dlugosc);
        this.czyZagle=czyZagle;
    }


    public boolean getCzyZagle()
    { return czyZagle;
    }

    public void setCzyZagle(boolean czyZagle)
    {this.czyZagle = czyZagle;
    }

    public String toString(){
        return "Typ: Lodz"+ "\nNazwa:" + getNazwa() + "\nModel: "+ getModel() + "\nObjetosc:" + objetosc +
                "\nTyp silnika: "+ getTypSilnika() + "\nPojemnosc silnika:" +
                getPojemnoscSilnika() + "\nNumer rejestracyjny: " + getNumerRejestracyjny() +
                "\nCzy zagle?: "+ czyZagle;
    }
}
