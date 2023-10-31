import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Blok {
    String numer;
    private Mieszkanie[] mieszkania;
    private MiejsceParkingowe[] miejscaParkingowe;
    int liczbaWynajetychMieszkan = 0;

    public Blok(String numer, int liczbaMieszkań, int liczbaMiejscParkingowych) {
        this.numer = numer;
        mieszkania = new Mieszkanie[liczbaMieszkań];
        miejscaParkingowe = new MiejsceParkingowe[liczbaMiejscParkingowych];
    }


    public String getNumer() {
        return numer;
    }

    public void dodajMieszkanie(Mieszkanie mieszkanie, int numerMieszkania)
            throws IllegalArgumentException {
        if (numerMieszkania < 0 && numerMieszkania > mieszkania.length) {
            throw new IllegalArgumentException("Brak takiego mieszkania");
        }
        mieszkania[numerMieszkania] = mieszkanie;
    }

    public void dodajMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe, int numerMiejscaParkingowego)
            throws IllegalArgumentException {
        if (numerMiejscaParkingowego < 0 || numerMiejscaParkingowego >= miejscaParkingowe.length) {
            throw new IllegalArgumentException("Nieprawidłowy numer miejsca parkingowego.");
        }

        miejscaParkingowe[numerMiejscaParkingowego] = miejsceParkingowe;
    }

    public MiejsceParkingowe[] getMiejscaParkingowe() {
        return miejscaParkingowe;
    }


    public Mieszkanie[] getMieszkania() {
        return mieszkania;
    }


    public String toString() {
        String mieszkaniaString = "";
        for (Mieszkanie mieszkanie : mieszkania) {
            mieszkaniaString += mieszkanie.toString() + "\n";
        }

        String miejscaParkingoweString = "";
        for (MiejsceParkingowe miejsceParkingowe : miejscaParkingowe) {
            miejscaParkingoweString += miejsceParkingowe.toString() + "\n";
        }

        return "Numer bloku: " + numer + "\n" +
                "Mieszkania:\n" + mieszkaniaString +
                "Miejsca parkingowe:\n" + miejscaParkingoweString;
    }

}
