import java.util.Scanner;

public class MatrixController {
    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix matrixC;
    private MatrixView matrixView;

    public MatrixController() {
        this.matrixView = new MatrixView();
    }

    public void inputMatrices() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbe wierszy macierzy A ");
        int rowsA = scanner.nextInt();
        System.out.println("Podaj liczbe kolumn macierzy A ");
        int colsA = scanner.nextInt();
        matrixA = new Matrix(rowsA, colsA);

        System.out.println("Podaj liczbe wierszy macierzy B ");
        int rowsB = scanner.nextInt();
        System.out.println("Podaj liczbe kolumn macierzy B ");
        int colsB = scanner.nextInt();
        matrixB = new Matrix(rowsB, colsB);

        Matrix matrix = new Matrix(rowsA, colsA);
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.println("Podaj elementy macierzy A [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrixA.setValue(i, j, scanner.nextInt());
            }
        }

        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.println("Podaj elementy macierzy B [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrixB.setValue(i, j, scanner.nextInt());
            }
        }
    }

    public void performOperations() {
        if (matrixA == null || matrixB == null) {
            System.err.println("Brak macierzy do wykonania operacji");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Transponuj macierze wejsciowe");
        System.out.println("2 - Pomnoz macierze wejsciowe");
        System.out.println("3 - Transponuj macierz wynikowa");
        System.out.println();
        System.out.println("Wybierz operacje:");

        int operationChoice = scanner.nextInt();

        switch (operationChoice) {
            case 1:
                Matrix transposedA = matrixA.transpose();
                Matrix transposedB = matrixB.transpose();
                matrixView.printMatrix("Transposed Matrix A", transposedA);
                matrixView.printMatrix("Transposed Matrix B", transposedB);
                break;

            case 2:
                matrixC = matrixA.multiply(matrixB);
                matrixA.isResultMatrixCalculated(true);

                if (matrixC != null) {
                    matrixView.printMatrix("Result Matrix C", matrixC);
                } else {
                    System.err.println("Nie mozna pomnozyc macierzu A i B ");
                }
                break;

            case 3:
                if (matrixC == null) {
                    System.err.println("Brak macierzy do wyswietlenia");
                } else {
                    Matrix transposedC = matrixC.transpose();
                    matrixView.printMatrix("Transposed Result Matrix C", transposedC);
                }
                break;

            default:
                System.err.println("Niepoprawny wybor operacji");
                break;
        }
    }

    public void displayMatrices() {
        boolean resultMatrixCalculated = matrixA.isResultMatrixCalculated(true);

        if (matrixA != null) {
            matrixView.printMatrix("Matrix A", matrixA);
        } else {
            System.err.println("Brak macierzy A");
        }

        if (matrixB != null) {
            matrixView.printMatrix("Matrix B", matrixB);
        } else {
            System.err.println("Brak macierzy B");
        }

        if (resultMatrixCalculated && matrixC != null) {
            matrixView.printMatrix("Result Matrix C", matrixC);
        } else if (resultMatrixCalculated){
            System.err.println("Brak macierzy wynikowej C");
        }
    }

    public void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcsz zakończyć program?  (y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("y")) {
            System.out.println("Program zakończony.");
            System.exit(0);
        } else {
            System.out.println("Program kontynuowany.");
        }
    }
}