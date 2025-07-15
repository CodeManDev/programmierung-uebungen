#include <stdio.h>
#include <string.h>

#define MAX_NAME_LENGTH 50
#define MAX_ABTEILUNG_LENGTH 50
#define MAX_MITARBEITER 50

typedef struct {
    char name[MAX_NAME_LENGTH];
    int alter;
    char abteilung[MAX_ABTEILUNG_LENGTH];
    float gehalt;
} Mitarbeiter;

Mitarbeiter mitarbeiter[MAX_MITARBEITER];
int anzahl_mitarbeiter = 0;

int getMitarbeiterIndex(char* name) {
    for (int i = 0; i < anzahl_mitarbeiter; i++) {
        if (strcmp(mitarbeiter[i].name, name) == 0) {
            return i;
        }
    }
    return -1; // Mitarbeiter nicht gefunden
}

void addMitarbeiter() {
    if (anzahl_mitarbeiter >= MAX_MITARBEITER) {
        printf("Maximale Anzahl an Mitarbeitern erreicht.\n");
        return;
    }
    Mitarbeiter newMitarbeiter;

    printf("Geben Sie den Namen des Mitarbeiters ein: ");
    getchar();
    fgets(newMitarbeiter.name, MAX_NAME_LENGTH, stdin);
    newMitarbeiter.name[strcspn(newMitarbeiter.name, "\n")] = 0;
    printf("Geben Sie das Alter des Mitarbeiters ein: ");
    int alter;
    scanf("%d", &alter);
    newMitarbeiter.alter = alter;
    printf("Geben Sie die Abteilung des Mitarbeiters ein: ");
    getchar();
    fgets(newMitarbeiter.abteilung, MAX_ABTEILUNG_LENGTH, stdin);
    newMitarbeiter.abteilung[strcspn(newMitarbeiter.abteilung, "\n")] = 0;
    printf("Geben Sie das Gehalt des Mitarbeiters ein: ");
    float gehalt;
    scanf("%f", &gehalt);
    newMitarbeiter.gehalt = gehalt;

    mitarbeiter[anzahl_mitarbeiter] = newMitarbeiter;
    anzahl_mitarbeiter++;
    printf("Mitarbeiter %s wurde hinzugefuegt.\n", newMitarbeiter.name);
}

void deleteMitarbeiter(char* name) {
    int found = getMitarbeiterIndex(name);
    if (found == -1) {
        printf("Mitarbeiter %s nicht gefunden.\n", name);
        return;
    }

    for (int i = found; i < anzahl_mitarbeiter - 1; i++) {
        mitarbeiter[i] = mitarbeiter[i + 1];
    }
    anzahl_mitarbeiter--;
    printf("Mitarbeiter %s wurde geloescht.\n", name);
}

void editMitarbeiter(char* name) {
    int found = getMitarbeiterIndex(name);
    if (found == -1) {
        printf("Mitarbeiter %s nicht gefunden.\n", name);
        return;
    }

    printf("Name: %s\n", mitarbeiter[found].name);
    printf("Alter: %d\n", mitarbeiter[found].alter);
    printf("Abteilung: %s\n", mitarbeiter[found].abteilung);
    printf("Gehalt: %.2f\n", mitarbeiter[found].gehalt);
    printf("Was moechten Sie aendern?\n");
    printf("1. Name\n");
    printf("2. Alter\n");
    printf("3. Abteilung\n");
    printf("4. Gehalt\n");
    printf("0. Abbrechen\n");
    int choice;
    scanf("%d", &choice);
    switch (choice) {
        case 1: {
            printf("Geben Sie den neuen Namen ein: ");
            getchar();
            fgets(mitarbeiter[found].name, MAX_NAME_LENGTH, stdin);
            mitarbeiter[found].name[strcspn(mitarbeiter[found].name, "\n")] = 0;
            break;
        }
        case 2: {
            printf("Geben Sie das neue Alter ein: ");
            int newAlter;
            scanf("%d", &newAlter);
            mitarbeiter[found].alter = newAlter;
            break;
        }
        case 3: {
            printf("Geben Sie die neue Abteilung ein: ");
            getchar();
            fgets(mitarbeiter[found].abteilung, MAX_ABTEILUNG_LENGTH, stdin);
            mitarbeiter[found].abteilung[strcspn(mitarbeiter[found].abteilung, "\n")] = 0;
            break;
        }
        case 4: {
            printf("Geben Sie das neue Gehalt ein: ");
            float newGehalt;
            scanf("%f", &newGehalt);
            mitarbeiter[found].gehalt = newGehalt;
            break;
        }
        case 0:
            return;
        default:
            printf("Ungueltige Auswahl.\n");
    }

    printf("Mitarbeiter %s wurde aktualisiert.\n", mitarbeiter[found].name);
}

void queryMitarbeiter(char* name) {
    int found = getMitarbeiterIndex(name);

    if (found == -1) {
        printf("Mitarbeiter %s nicht gefunden.\n", name);
        return;
    }

    printf("Name: %s\n", mitarbeiter[found].name);
    printf("Alter: %d\n", mitarbeiter[found].alter);
    printf("Abteilung: %s\n", mitarbeiter[found].abteilung);
    printf("Gehalt: %.2f\n", mitarbeiter[found].gehalt);
}

void printAllMitarbeiter() {
    if (anzahl_mitarbeiter == 0) {
        printf("Keine Mitarbeiter vorhanden.\n");
        return;
    }

    for (int i = 0; i < anzahl_mitarbeiter; i++) {
        printf("Name: %s, Alter: %d, Abteilung: %s, Gehalt: %.2f\n",
               mitarbeiter[i].name, mitarbeiter[i].alter,
               mitarbeiter[i].abteilung, mitarbeiter[i].gehalt);
    }
}

int main() {

    int choice;
    do {

        printf("\nMitarbeiterverwaltung:\n");
        printf("1. Mitarbeiter hinzufuegen\n");
        printf("2. Mitarbeiter loeschen\n");
        printf("3. Mitarbeiter bearbeiten\n");
        printf("4. Mitarbeiter abfragen\n");
        printf("5. Alle Mitarbeiter anzeigen\n");
        printf("0. Beenden\n");
        printf("Bitte waehlen Sie eine Option: ");
        scanf("%d", &choice);
        
        switch (choice) {
        case 1:
            addMitarbeiter();
            break;
        case 2: {
            printf("Geben Sie den Namen des zu loeschenden Mitarbeiters ein: ");
            char name[MAX_NAME_LENGTH];
            getchar();
            fgets(name, MAX_NAME_LENGTH, stdin);
            name[strcspn(name, "\n")] = 0;
            deleteMitarbeiter(name);
            break;
        }
        case 3: {
            printf("Geben Sie den Namen des zu bearbeitenden Mitarbeiters ein: ");
            char name[MAX_NAME_LENGTH];
            getchar();
            fgets(name, MAX_NAME_LENGTH, stdin);
            name[strcspn(name, "\n")] = 0;
            editMitarbeiter(name);
            break;
        }
        case 4: {
            printf("Geben Sie den Namen des abzufragenden Mitarbeiters ein: ");
            char name[MAX_NAME_LENGTH];
            getchar();
            fgets(name, MAX_NAME_LENGTH, stdin);
            name[strcspn(name, "\n")] = 0;
            queryMitarbeiter(name);
            break;
        }
        case 5:
            printAllMitarbeiter();
            break;
        case 0:
            break;
        default:
            printf("Ungueltige Auswahl. Bitte versuchen Sie es erneut.\n");
            break;
        }

    } while (choice != 0);

    printf("Programm beendet.\n");

    return 0;
}