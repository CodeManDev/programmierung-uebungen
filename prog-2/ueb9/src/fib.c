#include <stdio.h>
#include <time.h>

int fibrec(int n) {
    if (n <= 1) {
        return n;
    }
    return fibrec(n - 1) + fibrec(n - 2);
}

int fibiter(int n) {
    if (n <= 1) {
        return n;
    }
    int a = 0, b = 1, c;
    for (int i = 2; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}

int main() {

    clock_t start, end;
    
    int result;

    int n = 0;

    printf("n = ");
    scanf("%d", &n);

    start = clock();
    result = fibrec(n);
    end = clock();
    double time_taken_rec = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Fibonacci (rekursiv) von %d: %d, Zeit: %.6f Sekunden\n", n, result, time_taken_rec);

    start = clock();
    result = fibiter(n);
    end = clock();
    double time_taken_iter = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("Fibonacci (iterativ) von %d: %d, Zeit: %.6f Sekunden\n", n, result, time_taken_iter);

    return 0;
}