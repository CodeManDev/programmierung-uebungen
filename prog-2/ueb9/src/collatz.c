#include <stdio.h>

int collatzSteps(int n) {
    int steps = 0;
    while (n != 1) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        printf("%d ", n);
        steps++;
    }
    return steps;
}

int main() {

    int n = 0;

    printf("Geben Sie eine Zahl ein: ");
    scanf("%d", &n);

    printf("Collatz-Folge: ");
    int steps = collatzSteps(n);

    printf("\nAnzahl der Schritte: %d\n", steps);

    return 0;
}