import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MiejsceParkingowe implements Pomieszczenia{
    private Person najemca;
    private static int KOLEJNYNUMER;
    List<Object> przechowywaneRzeczy = new ArrayList<>();
    String id;
    double powierzchniaUzytkowaM3;
    String dataRozpoczeciaNajmu;
    String dataZakonczeniaNajmu = null;
    private List<Pojazd> pojazdy = new ArrayList<>();
    private List<Przedmiot> przedmioty = new ArrayList<>();

    MiejsceParkingowe(double powierzchniUzytkowaM3) {
        this.powierzchniaUzytkowaM3 = powierzchniUzytkowaM3;
        this.id = "MP" + KOLEJNYNUMER;
        KOLEJNYNUMER++;
    }

    MiejsceParkingowe(double dlugosc, double szerokosc, double wysokosc) {
        this.powierzchniaUzytkowaM3 = dlugosc * szerokosc * wysokosc;

        this.id = "MP" + KOLEJNYNUMER;
        KOLEJNYNUMER++;

    }
    @Override
    public double getPowierzchniUzytkowaM3() {
        return powierzchniaUzytkowaM3;
    }

    public String getId() {
        return id;
    }



    public void ustawDateRozpoczeciaNajmu(String data) {
        this.dataRozpoczeciaNajmu = data;
    }

    public void ustawDateZakonczeniaNajmu(String data) {
        this.dataZakonczeniaNajmu = data;
    }

    public void sprawdzDateZakonczeniaNajmu(){
        if(dataZakonczeniaNajmu != null){
            LocalDate dataZakonczenia= LocalDate.parse(dataZakonczeniaNajmu);
            LocalDate dzisiaj= LocalDate.now();
            if(dzisiaj.isAfter(dataZakonczenia)){
                TenantLetter pismo= new TenantLetter("Mieszkanie: " + id+
                        " Prosze o zwolnienie mieszkania");
                najemca.dodajPismo(pismo);
            }
        }
    }


    public String toString() {
        return "Miejsce parkingowe: " + id;
    }

    public void wynajmij(Person najemca) {
        if (this.najemca != null) {
            throw new IllegalArgumentException("Miejsce parkingowe jest już wynajmowane.");
        }

        this.najemca = najemca;
    }

    public void zwolnij() {
        this.najemca = null;
    }

    public Person getNajemca() {
        return najemca;
    }

    public void setNajemca(Person najemca){
        this.najemca=najemca;
    }


    public void dodajRzecz(Object rzecz) throws TooManyThingsException {
        double rozmiarRzeczy = (rzecz instanceof Pojazd) ? ((Pojazd) rzecz).getObjetosc() : ((Przedmiot) rzecz).getObjetosc();
        if (sumaRozmiarow() + rozmiarRzeczy <= powierzchniaUzytkowaM3) {
            przechowywaneRzeczy.add(rzecz);
        } else {
            throw new TooManyThingsException("Usuń jakiś obiekt by włożyć nowy");
        }
    }

    private double sumaRozmiarow() {
        double suma = 0;
        for (Object rzecz : przechowywaneRzeczy) {
            suma += (rzecz instanceof Pojazd) ? ((Pojazd) rzecz).getObjetosc() : ((Przedmiot) rzecz).getObjetosc();
        }
        return suma;
    }

    public void usunObiekt(Object obiekt) {
        if (przechowywaneRzeczy.contains(obiekt)) {
            if (obiekt instanceof Pojazd) {
                Pojazd pojazd = (Pojazd) obiekt;
                przechowywaneRzeczy.remove(pojazd);
                powierzchniaUzytkowaM3 = powierzchniaUzytkowaM3 - pojazd.getObjetosc();
            } else if (obiekt instanceof Przedmiot) {
                Przedmiot przedmiot = (Przedmiot) obiekt;
                przechowywaneRzeczy.remove(przedmiot);
                powierzchniaUzytkowaM3 = powierzchniaUzytkowaM3 - przedmiot.getObjetosc();
            }


        }
    }

    public void pokazAktualnyStan() {
        double zajetaPowierzchnia = sumaRozmiarow();
        double dostepnaPowierzchnia = powierzchniaUzytkowaM3 - zajetaPowierzchnia;

        System.out.println("Aktualny stan powierzchni:");
        System.out.println("Zajęta powierzchnia: " + zajetaPowierzchnia + " m^3");
        System.out.println("Dostępna powierzchnia: " + dostepnaPowierzchnia + " m^3");
    }

    public List<Object> getPrzechowywaneRzeczy() {
        return przechowywaneRzeczy;
    }

    public void setPrzechowywaneRzeczy(List<Object> przechowywaneRzeczy) {
        this.przechowywaneRzeczy = przechowywaneRzeczy;
    }

}
