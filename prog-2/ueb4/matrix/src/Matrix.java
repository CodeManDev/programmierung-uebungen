public class Matrix {

    private final Number[][] matrix;
    private final int rows, cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new Number[rows][cols];
    }

    public void setValue(int row, int col, Number value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        this.matrix[row][col] = value;
    }

    public Number getValue(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.matrix[row][col];
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setValue(i, j, this.getValue(i, j).doubleValue() + other.getValue(i, j).doubleValue());
            }
        }
        return result;
    }

    public Matrix multiplyScalar(double scalar) {
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setValue(i, j, this.getValue(i, j).doubleValue() * scalar);
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }
}
