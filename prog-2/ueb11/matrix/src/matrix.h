#ifndef MATRIX_H
#define MATRIX_H

#include <stdio.h>

void printMatrix(int* matrix, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        printf("| ");
        for (int j = 0; j < cols; j++) {
            printf("%d ", matrix[i * cols + j]);
        }
        printf(" |\n");
    }
}

int findMaxInCol(int* matrix, int rows, int cols, int col) {
    int max = matrix[col];
    for (int i = 1; i < rows; i++) {
        if (matrix[i * cols + col] > max) {
            max = matrix[i * cols + col];
        }
    }
    return max;
}

int findMinInRow(int* matrix, int rows, int cols, int row) {
    int min = matrix[row * cols];
    for (int j = 1; j < cols; j++) {
        if (matrix[row * cols + j] < min) {
            min = matrix[row * cols + j];
        }
    }
    return min;
}

void swapRows(int* matrix, int rows, int cols, int row1, int row2) {
    for (int j = 0; j < cols; j++) {
        int temp = matrix[row1 * cols + j];
        matrix[row1 * cols + j] = matrix[row2 * cols + j];
        matrix[row2 * cols + j] = temp;
    }
}

void transposeMatrix(int* matrix, int rows, int cols) {
    if (rows != cols) {
        printf("Transponieren funktioniert nur bei quadratischen Matrizen.\n");
        return;
    }

    for (int i = 0; i < rows; i++) {
        for (int j = i + 1; j < cols; j++) {
            int temp = matrix[i * cols + j];
            matrix[i * cols + j] = matrix[j * cols + i];
            matrix[j * cols + i] = temp;
        }
    }
}

void multiplyScalar(int* matrix, int rows, int cols, int scalar) {
    for (int i = 0; i < rows * cols; i++) {
        matrix[i] *= scalar;
    }
}

void sum(int* matrix1, int* matrix2, int* result, int rows, int cols) {
    for (int i = 0; i < rows * cols; i++) {
        result[i] = matrix1[i] + matrix2[i];
    }
}

void mult(int* matrix1, int* matrix2, int* result, int rows1, int cols1, int rows2, int cols2) {
    
    if (cols1 != rows2) {
        printf("Matrixmultiplikation nicht moeglich: Spalten von Matrix 1 (%d) sind nicht gleich Zeilen von Matrix 2 (%d).\n", cols1, rows2);
        return;
    }
    
    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            result[i * cols2 + j] = 0;
            for (int k = 0; k < cols1; k++) {
                result[i * cols2 + j] += matrix1[i * cols1 + k] * matrix2[k * cols2 + j];
            }
        }
    }

}

#endif // MATRIX_H