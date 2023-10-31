import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mieszkanie implements Pomieszczenia {
    private static int KOLEJNYNUMER=1;
    String id;
    double powierzchniaUzytkowaM3;
    String dataRozpoczeciaNajmu;
    String dataZakonczeniaNajmu= null;
    private List<Person> mieszkancy= new ArrayList<>();
    private Person osobaOdpowiedzialna;
    private List<TenantLetter> tenantLetters= new ArrayList<>();

//    Mieszkanie(double powierzchniaUzytkowaM3, String dataRozpoczeciaNajmu,
//               String dataZakonczeniaNajmu){
//        this.powierzchniaUzytkowaM3=powierzchniaUzytkowaM3;
//        this.dataRozpoczeciaNajmu= dataRozpoczeciaNajmu;
//        this.dataZakonczeniaNajmu= dataZakonczeniaNajmu;
//        this.id= "M" + KOLEJNYNUMER;
//        KOLEJNYNUMER++;
//    }

    Mieszkanie(double powierzchniaUzytkowaM3){
        this.powierzchniaUzytkowaM3=powierzchniaUzytkowaM3;
        this.id= "M" + KOLEJNYNUMER;
        KOLEJNYNUMER++;
    }

       Mieszkanie(double dlugosc, double szerokosc, double wysokosc){
       this.powierzchniaUzytkowaM3= dlugosc* szerokosc* wysokosc;
        this.id= "M" + KOLEJNYNUMER;
        KOLEJNYNUMER++;
    }

    public void dodajMieszkanca(Person person){
        mieszkancy.add(person);
        if(osobaOdpowiedzialna== null){
            osobaOdpowiedzialna= person;
        }
    }
    public void usunMieszkanca(Person person) {
        if (mieszkancy.contains(person)) {
            mieszkancy.remove(person);
        }
    }

    public List<Person> getMieszkancy() {
        return mieszkancy;
    }

    public void setMieszkancy(List<Person> mieszkancy) {
        this.mieszkancy = mieszkancy;
    }

    public void setOsobaOdpowiedzialna(Person person){
        this.osobaOdpowiedzialna= person;
    }

    public Person getOsobaOdpowiedzialna(){
        return osobaOdpowiedzialna;
    }

    @Override
    public double getPowierzchniUzytkowaM3(){
        return powierzchniaUzytkowaM3;
    }

    public String getId(){
        return id;
    }

    public String toString() {
        return "Mieszkanie: " + id;
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
                osobaOdpowiedzialna.dodajPismo(pismo);
            }
        }
    }

    public List<TenantLetter> getZadluzenia() {
        List<TenantLetter> zadluzenia = new ArrayList<>();
        for (TenantLetter letter : tenantLetters) {
            if (letter.getCzyZadluzenie()) {
                zadluzenia.add(letter);
            }
        }
        return zadluzenia;
    }

}
