public class Amfibia extends Pojazd{
    private boolean gasienice;
    private String rodzajNapedu;

    Amfibia(String nazwa, String model, double objetosc,
            String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, boolean gasienice,
            String rodzajNapedu){
        super(nazwa, model, objetosc, typSilnika, pojemnoscSilnika, numerRejestracyjny);
        this.gasienice=gasienice;
        this.rodzajNapedu=rodzajNapedu;
    }

    Amfibia(String nazwa, String model, double dlugosc, double szerokosc, double wysokosc,
            String typSilnika, double pojemnoscSilnika, String numerRejestracyjny, boolean gasienice,
            String rodzajNapedu){
        super(nazwa, model, typSilnika, pojemnoscSilnika, numerRejestracyjny, szerokosc, wysokosc, dlugosc);
        this.rodzajNapedu=rodzajNapedu;
        this.gasienice=gasienice;
        this.objetosc= szerokosc* wysokosc* dlugosc;
    }

    public String getRodzajNapedu() {
        return rodzajNapedu;
    }

    public void setRodzajNapedu(String rodzajNapedu) {
        this.rodzajNapedu = rodzajNapedu;
    }

    public boolean getGasienice() {
        return gasienice;
    }

    public void setGasienice(boolean gasienice) {
        this.gasienice = gasienice;
    }

    public String toString(){
        return "Typ: Amfibia" + "\nNazwa:" + getNazwa() + "\nModel: "+ getModel() + "\nObjetosc:" + objetosc +
                "\nTyp silnika: "+ getTypSilnika() + "\nPojemnosc silnika:" +
                getPojemnoscSilnika() + "\nNumer rejestracyjny: " + getNumerRejestracyjny() + "\nRodzaj napedu: " +
                rodzajNapedu + "\nCzy gasiennice?: " + gasienice;
    }

}
