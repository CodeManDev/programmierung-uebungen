#include <stdio.h>

int main() {
    int n;
    printf("Enter the number of lines for the star pattern: ");
    scanf("%d", &n);
    getchar();

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (j == i || j == n - i - 1) {
                printf("*");
            } else {
                printf("-");
            }
        }
        printf("\n");
    }

    printf("Press Enter to exit...");
    getchar();

    return 0;
}