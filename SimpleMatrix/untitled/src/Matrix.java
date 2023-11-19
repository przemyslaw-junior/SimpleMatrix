// Matrix.java
public class Matrix {
    private int data[][];
    private int rows;
    private int cols;
    private boolean resultMatrixCalculated;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public void setValue(int row, int col, int value) {
        data[row][col] = value;
    }

    public int getValue(int row, int col) {
        return data[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isResultMatrixCalculated(boolean b) {
        return resultMatrixCalculated;
    }

    public void setResultMatrixCalculated(boolean resultMatrixCalculated) {
        this.resultMatrixCalculated = resultMatrixCalculated;
    }

    public void printMatrix(String label) {
        System.out.println(label + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(j, i, data[i][j]);
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (cols != other.getRows()) {
            return null;
        }
        Matrix result = new Matrix(rows, other.getCols());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                int sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k] * other.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        resultMatrixCalculated = true;
        return result;
    }
}
