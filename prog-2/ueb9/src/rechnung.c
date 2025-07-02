#include <stdio.h>

int main() {

    float betrag = 0.0f;

    printf("Bitte geben Sie den Betrag ein: ");
    scanf("%f", &betrag);
    getchar();

    printf("Nettopreis:         Euro %.2f\n", betrag);

    float mwst = betrag * 0.20f;
    printf("+ 20%% MwSt:         Euro %.2f\n", mwst);

    printf("===============================\n");

    float bruttopreis = betrag + mwst;
    printf("Bruttopreis:        Euro %.2f\n", bruttopreis);

    float skonto = bruttopreis * 0.02f;
    printf("- 2%% Skonto:        Euro %.2f\n", skonto);

    printf("===============================\n");

    float rechungsbetrag = bruttopreis - skonto;
    printf("Rechungsbetrag:     Euro %.2f\n", rechungsbetrag);

    getchar();

    return 0;
}