#include <stdio.h>

int multiply(int* a, int* b) {
    return (*a) * (*b);
}

int main() {
    int x, y;
    printf("a = ");
    scanf("%d", &x);
    printf("b = ");
    scanf("%d", &y);

    int result = multiply(&x, &y);
    printf("Das Ergebnis von %d * %d = %d\n", x, y, result);

    getchar();
    printf("Druecken Sie eine Taste, um das Programm zu beenden...\n");
    getchar();

    return 0;
}