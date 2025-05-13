public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValue(0, 0, 1);
        matrix1.setValue(0, 1, 2);
        matrix1.setValue(1, 0, 3);
        matrix1.setValue(1, 1, 4);
        System.out.println("Matrix 1:");
        matrix1.print();

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setValue(0, 0, 5);
        matrix2.setValue(0, 1, 6);
        matrix2.setValue(1, 0, 7);
        matrix2.setValue(1, 1, 8);
        System.out.println("Matrix 2:");
        matrix2.print();

        Matrix added = matrix1.add(matrix2);
        System.out.println("Matrix 1 addiert mit Matrix 2:");
        added.print();

        double scalar = 2.0;
        Matrix scaledMatrix = matrix1.multiplyScalar(scalar);
        System.out.println("Matrix 1 multipliziert mit " + scalar + ":");
        scaledMatrix.print();
    }

}