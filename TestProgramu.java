public class TestProgramu {
    public static void main(String []args) throws TooManyThingsException, ProblematicTenantException {

        Osiedle osiedle1 = new Osiedle("Słoneczne");
        Blok blok1 = new Blok("59F", 3, 3);
        Blok blok2 = new Blok("34I", 10, 10);
        osiedle1.dodajBlok(blok1);
        osiedle1.dodajBlok(blok2);

        Mieszkanie mieszkanie1 = new Mieszkanie(50);
        Mieszkanie mieszkanie2 = new Mieszkanie(60);
        Mieszkanie mieszkanie3 = new Mieszkanie(45);
        MiejsceParkingowe miejsceParkingowe1 = new MiejsceParkingowe(20);
        MiejsceParkingowe miejsceParkingowe2 = new MiejsceParkingowe(15);
        MiejsceParkingowe miejsceParkingowe3 = new MiejsceParkingowe(10);

        blok1.dodajMieszkanie(mieszkanie1, 0);
        blok1.dodajMieszkanie(mieszkanie2, 1);
        blok1.dodajMieszkanie(mieszkanie3, 2);
        blok1.dodajMiejsceParkingowe(miejsceParkingowe1, 0);
        blok1.dodajMiejsceParkingowe(miejsceParkingowe2, 1);
        blok1.dodajMiejsceParkingowe(miejsceParkingowe3, 2);

        System.out.println(osiedle1.toString());

        System.out.println(blok1.toString());
        Person person1 = new Person("Marianna", "Kiser", "07-12-1998",
                "762649203", "Kolejowa2");
        Person person2 = new Person("Kirill", "Galagan", "24-06-1995",
                "39472380204", "Kwiatowa2");

        osiedle1.wynajmijMieszkanie(person1,mieszkanie1, "2021-07-21",
                "2024-07-21");
        osiedle1.wynajmijMiejsceParkingowe(person1, miejsceParkingowe1,mieszkanie1,
                "2021-07-21", "2024-07-21");
        osiedle1.wynajmijMiejsceParkingowe(person1,miejsceParkingowe2,mieszkanie1,"2021-07-21",
                "2024-07-21");

        Przedmiot szafa= new Przedmiot("Szafa", 3);
        Przedmiot biurko= new Przedmiot("Biurko", 3);
        Lodz lodz= new Lodz("Lodz", "model", 10, "silnik", 20, "864293", true  );

        miejsceParkingowe1.dodajRzecz(szafa);
        miejsceParkingowe1.dodajRzecz(biurko);
        miejsceParkingowe1.dodajRzecz(lodz);
        person1.wyswietlWynajetePomieszczeniaPosortowaneWedlugRozmiaru();
        person1.wyswietlZawartoscMiejscParkingowych(person1);


    }


}
