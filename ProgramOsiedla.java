import java.util.Scanner;

public class ProgramOsiedla {
    public static void main(String []args){
        Scanner scanner= new Scanner(System.in);
        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dostęp do danych osiedla");
            System.out.println("2. Dostęp do danych bloku");
            System.out.println("3. Dostęp do pomieszczeń wynajmowanych przez osobę");
            System.out.println("4. Dostęp do przedmiotów/pojazdów w miejscu parkingowym danej osoby");
            System.out.println("5. Wyjście z programu");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    // Dostęp do danych osiedla
                    // Zaimplementuj odpowiednią funkcjonalność
                    break;

                case 2:
                    // Dostęp do danych bloku
                    // Zaimplementuj odpowiednią funkcjonalność
                    break;

                case 3:
                    // Dostęp do pomieszczeń wynajmowanych przez osobę
                    // Zaimplementuj odpowiednią funkcjonalność
                    break;

                case 4:
                    // Dostęp do przedmiotów/pojazdów w miejscu parkingowym danej osoby
                    // Zaimplementuj odpowiednią funkcjonalność
                    break;

                case 5:
                    System.out.println("Program został zakończony.");
                    return;

                default:
                    System.out.println("Niepoprawny wybór. Wybierz ponownie.");
                    break;
            }
        }
    }
}
