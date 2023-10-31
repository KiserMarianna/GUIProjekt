public class TenantLetter {
    String tresc;
    boolean czyZadluzenie;

    TenantLetter(String tresc){
        this.tresc= tresc;
        this.czyZadluzenie= true;
    }

    public boolean getCzyZadluzenie() {
        return czyZadluzenie;
    }


    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String toString(){
        return tresc;
    }

}
