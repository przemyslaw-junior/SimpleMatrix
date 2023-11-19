import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrixController matrixController = new MatrixController();

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1 - Wprowadz macierze");
            System.out.println("2 - Operacje na macierzach");
            System.out.println("3 - Wyswietl macierze");
            System.out.println("4 - EXIT");
            System.out.println();
            System.out.println("Wybierz opcje:");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    matrixController.inputMatrices();
                    break;

                case 2:
                    matrixController.performOperations();
                    break;

                case 3:
                    matrixController.displayMatrices();
                    break;
                case 4:
                    matrixController.exit();
                    break;
                default:
                    System.err.println("Niepoprawny wybor opcji");
                    break;
            }
        }
    }
}
