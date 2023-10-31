public class Przedmiot {

    private String nazwa;
    private double objetosc;

    Przedmiot(String nazwa, double objetosc ){
        this.nazwa=nazwa;
        this.objetosc=objetosc;
    }

    Przedmiot(String nazwa, double szerokosc, double wysokosc, double dlugosc){
        this.nazwa=nazwa;
        this.objetosc= szerokosc*wysokosc*dlugosc;
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

    public String toString(){
        return "Przedmiot: " + nazwa + "\nObjetosc: "+ objetosc;
    }
}
