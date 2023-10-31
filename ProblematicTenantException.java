import java.util.List;

public class ProblematicTenantException extends Exception{
        private Person osoba;

        public ProblematicTenantException(Person osoba) {
            super("Osoba: " + osoba.getImie()+ " ma już zadłużenie na 3 pomieszczenia");
            this.osoba = osoba;
        }

        public Person getOsoba() {
            return osoba;
        }

    }
