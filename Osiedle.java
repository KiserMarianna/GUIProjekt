import java.util.ArrayList;
import java.util.List;

public class Osiedle {
    private String nazwa;
    private List<Blok> bloki= new ArrayList<>();

    private Blok blok;

    public Osiedle(String nazwa){
        this.nazwa=nazwa;
    }

    public void setNazwa(String nazwa){
        this.nazwa=nazwa;
    }
    public String getNazwa(){
        return nazwa;
    }

    public void dodajBlok(Blok blok){
        bloki.add(blok);
    }

    public List<Blok> getBloki(){
        return bloki;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nazwa osiedla: ").append(nazwa).append("\n");
        sb.append("Lista bloków:\n");

        for (Blok blok : bloki) {
            sb.append("Blok ").append(blok.getNumer()).append("\n");
        }

        return sb.toString();
    }

    public void wynajmijMieszkanie(Person najemca, Mieszkanie mieszkanie, String dataRozpoczeciaNajmu,
                                   String dataZakoczeniaNajmu) {

        if (najemca.getLiczbaWynajetychPomieszczen() >= 5) {
            throw new IllegalArgumentException("Najemca osiągnął limit wynajmowanych pomieszczeń.");
        }

        if (mieszkanie.getMieszkancy().size() > 0) {
            throw new IllegalArgumentException("Mieszkanie jest już wynajmowane.");
        }

        mieszkanie.dodajMieszkanca(najemca);
        najemca.dodajWynajeteMieszkanie(mieszkanie);
        mieszkanie.dataRozpoczeciaNajmu=dataRozpoczeciaNajmu;
        mieszkanie.dataZakonczeniaNajmu=dataZakoczeniaNajmu;
        mieszkanie.sprawdzDateZakonczeniaNajmu();
    }

    public void wynajmijMiejsceParkingowe(Person najemca, MiejsceParkingowe miejsceParkingowe, Mieszkanie mieszkanie,
                                          String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu)
    throws ProblematicTenantException{
        if(najemca.czyNajemcaMaProblematyczneZadluzenia(najemca)){
            throw new ProblematicTenantException(najemca);
        }
        if (najemca.getLiczbaWynajetychPomieszczen() >= 5) {
            throw new IllegalArgumentException("Najemca osiągnął limit wynajmowanych pomieszczeń.");
        }

        if (miejsceParkingowe.getNajemca() != null || !mieszkanie.getMieszkancy().contains(najemca)) {
            throw new IllegalArgumentException("Miejsce parkingowe nie jest dostępne.");
        }

        miejsceParkingowe.setNajemca(najemca);
        najemca.dodajWynajeteMiejsceParkingowe(miejsceParkingowe);
        miejsceParkingowe.dataRozpoczeciaNajmu= dataRozpoczeciaNajmu;
        miejsceParkingowe.dataZakonczeniaNajmu=dataZakonczeniaNajmu;
        miejsceParkingowe.sprawdzDateZakonczeniaNajmu();

    }

//    public void wynajmijMiejsceParkingowe(Person najemca, MiejsceParkingowe miejsceParkingowe, Mieszkanie mieszkanie,
//                                          String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) {
//        if (najemca.getLiczbaWynajetychPomieszczen() >= 5) {
//            throw new IllegalArgumentException("Najemca osiągnął limit wynajmowanych pomieszczeń.");
//        }
//
//        if (miejsceParkingowe.getNajemca() != null || !mieszkanie.getMieszkancy().contains(najemca)) {
//            throw new IllegalArgumentException("Miejsce parkingowe nie jest dostępne.");
//        }
//
//        miejsceParkingowe.setNajemca(najemca);
//        najemca.dodajWynajeteMiejsceParkingowe(miejsceParkingowe);
//        miejsceParkingowe.dataRozpoczeciaNajmu= dataRozpoczeciaNajmu;
//        miejsceParkingowe.dataZakonczeniaNajmu=dataZakonczeniaNajmu;
//        miejsceParkingowe.sprawdzDateZakonczeniaNajmu();
//
//    }

//    public void pokazMieszkaniaIMiejscaParkingoweWynajetePrzezOsobe(String imie, String nazwisko) {
//        for (Blok blok : bloki) {
//            for (Mieszkanie mieszkanie : blok.getMieszkania()) {
//                for (Person mieszkaniec : mieszkanie.getMieszkancy()) {
//                    if (mieszkaniec.getImie().equals(imie) && mieszkaniec.getNazwisko().equals(nazwisko)) {
//                        System.out.println("Osoba " + imie + " " + nazwisko + " wynajmuje mieszkanie " + mieszkanie.getId() + " w bloku " + blok.getNumer());
//                    }
//                }
//            }
//            for (MiejsceParkingowe miejsceParkingowe : blok.getMiejscaParkingowe()) {
//                Person najemca = miejsceParkingowe.getNajemca();
//                if (najemca != null && najemca.getImie().equals(imie) && najemca.getNazwisko().equals(nazwisko)) {
//                    System.out.println("Osoba " + imie + " " + nazwisko + " wynajmuje miejsce parkingowe " + miejsceParkingowe.getId() + " w bloku " + blok.getNumer());
//                }
//            }
//        }
//    }







}







