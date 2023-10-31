import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String pesel;
    private String adresZamieszkania;
    private List<TenantLetter> pisma = new ArrayList<>();
    private List<Mieszkanie> wynajeteMieszkania = new ArrayList<>();
    private List<MiejsceParkingowe> wynajeteMiejscaParkingowe = new ArrayList<>();
    List<Pomieszczenia> pomieszczenia = new ArrayList<>();
    int liczbaWynajetychPomieszczen = 0;

    Person(String imie, String nazwisko, String dataUrodzenia, String pesel,
           String adresZamieszkania) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.pesel = pesel;
        this.adresZamieszkania = adresZamieszkania;
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

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(String adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String toString() {
        return "Imie i nazwisko: " + imie + " " + nazwisko + ", data urodzenia: " + dataUrodzenia +
                ", pesel: " + pesel + ", adres zamieszkania: " + adresZamieszkania;
    }

    public int getLiczbaWynajetychPomieszczen() {
        return wynajeteMieszkania.size() + wynajeteMiejscaParkingowe.size();
    }

    public void dodajWynajeteMieszkanie(Mieszkanie mieszkanie) {
        wynajeteMieszkania.add(mieszkanie);
    }

    public void usunWynajeteMieszkanie(Mieszkanie mieszkanie) {
        wynajeteMieszkania.remove(mieszkanie);
    }

    public void dodajWynajeteMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe) {
        wynajeteMiejscaParkingowe.add(miejsceParkingowe);
    }

    public void usunWynajeteMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe) {
        wynajeteMiejscaParkingowe.remove(miejsceParkingowe);
    }

    public void dodajPismo(TenantLetter pismo) {
        pisma.add(pismo);
    }

    public String getIloscPism() {
        return "Ilość pism: " + pisma.size();
    }

    public List<MiejsceParkingowe> getWynajeteMiejscaParkingowe() {
        return wynajeteMiejscaParkingowe;
    }


    public boolean czyNajemcaMaProblematyczneZadluzenia(Person najemca) {
        if (pisma.size() >= 3) {
            return true;
        }
        return false;
    }

    public void wyswietlWynajetePomieszczenia() {
        System.out.println("Mieszkania i miejsca parkingowe wynajęte przez " + imie + " " + nazwisko + ":");

        for (Mieszkanie mieszkanie : wynajeteMieszkania) {
            System.out.println("Mieszkanie: " + mieszkanie.getId());
        }

        for (MiejsceParkingowe miejsceParkingowe : wynajeteMiejscaParkingowe) {
            System.out.println("Miejsce parkingowe: " + miejsceParkingowe.getId());
        }
    }

    public void usunZadluzenia() {
        pisma.removeIf(pismo -> pismo.getCzyZadluzenie());
    }

    public void wyswietlWynajetePomieszczeniaPosortowaneWedlugRozmiaru() {
        System.out.println("Mieszkania i miejsca parkingowe wynajęte przez " + imie + " " + nazwisko + ":");

        pomieszczenia.addAll(wynajeteMieszkania);
        pomieszczenia.addAll(wynajeteMiejscaParkingowe);

        // Sortuj pomieszczenia według rozmiaru
        pomieszczenia.sort(Comparator.comparingDouble(Pomieszczenia::getPowierzchniUzytkowaM3));

        for (Pomieszczenia pomieszczenie : pomieszczenia) {
            if (pomieszczenie instanceof Mieszkanie) {
                System.out.println("Mieszkanie: " + ((Mieszkanie) pomieszczenie).getId());
            } else if (pomieszczenie instanceof MiejsceParkingowe) {
                System.out.println("Miejsce parkingowe: " + ((MiejsceParkingowe) pomieszczenie).getId());
            }
        }
    }

    public void wyswietlZawartoscMiejscParkingowych(Person osoba) {
        System.out.println("Zawartość miejsc parkingowych wynajmowanych przez " + osoba.getImie() + " " + osoba.getNazwisko() + ":");

        List<Object> zawartosc = new ArrayList<>();

        for (MiejsceParkingowe miejsceParkingowe : osoba.getWynajeteMiejscaParkingowe()) {
            zawartosc.addAll(miejsceParkingowe.getPrzechowywaneRzeczy());
        }

        Collections.sort(zawartosc, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                double rozmiar1 = (o1 instanceof Pojazd) ? ((Pojazd) o1).getObjetosc() : ((Przedmiot) o1).getObjetosc();
                double rozmiar2 = (o2 instanceof Pojazd) ? ((Pojazd) o2).getObjetosc() : ((Przedmiot) o2).getObjetosc();

                if (rozmiar1 != rozmiar2) {
                    // Sortuj malejąco według rozmiaru
                    return Double.compare(rozmiar2, rozmiar1);
                } else {
                    // Jeśli objętości są takie same, sortuj alfabetycznie według nazwy
                    String nazwa1 = (o1 instanceof Pojazd) ? ((Pojazd) o1).getNazwa() : ((Przedmiot) o1).getNazwa();
                    String nazwa2 = (o2 instanceof Pojazd) ? ((Pojazd) o2).getNazwa() : ((Przedmiot) o2).getNazwa();
                    int result = nazwa1.compareTo(nazwa2);
                    if (result == 0) {
                        // Jeśli nazwy są takie same, porównaj po typie (Pojazd vs. Przedmiot)
                        if (o1 instanceof Pojazd && o2 instanceof Przedmiot) {
                            return -1;
                        } else if (o1 instanceof Przedmiot && o2 instanceof Pojazd) {
                            return 1;
                        }
                    }
                    return result;
                }
            }
        });
        for (Object rzecz : zawartosc) {
            if (rzecz instanceof Pojazd) {
                Pojazd pojazd = (Pojazd) rzecz;
                System.out.println("Pojazd: " + pojazd.getNazwa() + " (Objętość: " + pojazd.getObjetosc() + ")");
            } else if (rzecz instanceof Przedmiot) {
                Przedmiot przedmiot = (Przedmiot) rzecz;
                System.out.println("Przedmiot: " + przedmiot.getNazwa() + " (Objętość: " + przedmiot.getObjetosc() + ")");
            }
        }


    }
}
