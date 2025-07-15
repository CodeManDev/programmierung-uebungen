#include "matrix.h"

int main() {
    int m1[6] = {
        1, 2, 3,
        4, 5, 6
    };
    int m2[6] = {
        7, 8, 9,
        10, 11, 12
    };

    printf("Matrix 1:\n");
    printMatrix(m1, 2, 3);
    printf("Matrix 2:\n");
    printMatrix(m2, 2, 3);

    printf("Max in Spalte 1 von Matrix 1: %d\n", findMaxInCol(m1, 2, 3, 1));
    printf("Min in Zeile 0 von Matrix 2: %d\n", findMinInRow(m2, 2, 3, 0));

    printf("Zeilen 0 und 1 von Matrix 1 tauschen:\n");
    swapRows(m1, 2, 3, 0, 1);
    printMatrix(m1, 2, 3);

    int squareMatrix[9] = {
        1, 2, 3,
        4, 5, 6,
        7, 8, 9
    };

    printf("Quadratische Matrix vor Transponieren:\n");
    printMatrix(squareMatrix, 3, 3);
    transposeMatrix(squareMatrix, 3, 3);
    printf("Quadratische Matrix nach Transponieren:\n");
    printMatrix(squareMatrix, 3, 3);

    int scalar = 2;
    printf("Matrix 1 vor Skalierung mit %d:\n", scalar);
    printMatrix(m1, 2, 3);
    multiplyScalar(m1, 2, 3, scalar);
    printf("Matrix 1 nach Skalierung mit %d:\n", scalar);
    printMatrix(m1, 2, 3);

    printf("Matrix 2 vor Skalierung mit %d:\n", scalar);
    printMatrix(m2, 2, 3);
    multiplyScalar(m2, 2, 3, scalar);
    printf("Matrix 2 nach Skalierung mit %d:\n", scalar);
    printMatrix(m2, 2, 3);

    printf("Summe von Matrix 1 und Matrix 2:\n");
    int sumMatrix[6];
    sum(m1, m2, sumMatrix, 2, 3);

    printMatrix(sumMatrix, 2, 3);

    printf("Matrix Multiplikation:\n");
    
    int matrixA[6] = {
        1, 2, 3,
        4, 5, 6
    };

    int matrixB[6] = {
        7, 8,
        10, 11,
        13, 14
    };

    printf("Matrix A:\n");
    printMatrix(matrixA, 2, 3);
    printf("Matrix B:\n");
    printMatrix(matrixB, 3, 2);

    printf("Produkt der Matrizen A und B:\n");

    int productMatrix[4];
    mult(matrixA, matrixB, productMatrix, 2, 3, 3, 2);
    printMatrix(productMatrix, 2, 2);
    printf("Druecken Sie eine Taste, um das Programm zu beenden...\n");
    getchar();
    return 0;
}