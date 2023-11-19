// MatrixView.java
public class MatrixView {

    public void printMatrix(String label, Matrix matrix) {
        if (matrix == null) {
            System.err.println("Macierz jest pusta");
            return;
        }

        System.out.println(label + ":");
        int rows = matrix.getRows();
        int cols = matrix.getCols();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix.getValue(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

