#include "mechanical.h"
#include "motion.h"

#include <stdio.h>

int main() {

    int choice;
    do {
        printf("What to calculate?\n");
        printf("1. Speed\n");
        printf("2. Acceleration\n");
        printf("3. Impulse\n");
        printf("4. Linear Distance\n");
        printf("5. Linear Acceleration Distance\n");
        printf("6. Linear Acceleration Speed\n");
        printf("0. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1: {
            Distance delta_s;
            Time delta_t;
            printf("Enter distance (m): ");
            scanf("%lf", &delta_s);
            printf("Enter time (s): ");
            scanf("%lf", &delta_t);

            if (delta_t == 0) {
                printf("Error: Time cannot be zero.\n");
                break;
            }

            Speed speed = calculateSpeed(delta_s, delta_t);
            printf("Speed: %.2f m/s\n", speed);
            break;
        }
        case 2: {
            Speed delta_v;
            Time delta_t;
            printf("Enter change in speed (m/s): ");
            scanf("%lf", &delta_v);
            printf("Enter time (s): ");
            scanf("%lf", &delta_t);

            if (delta_t == 0) {
                printf("Error: Time cannot be zero.\n");
                break;
            }

            Acceleration acceleration = calculateAcceleration(delta_v, delta_t);
            printf("Acceleration: %.2f m/s^2\n", acceleration);
            break;
        }
        case 3: {
            Mass m;
            Speed v;
            printf("Enter mass (kg): ");
            scanf("%lf", &m);
            printf("Enter speed (m/s): ");
            scanf("%lf", &v);
            Impulse impulse = calculateImpulse(m, v);
            printf("Impulse: %.2f kg*m/s\n", impulse);
            break;
        }
        case 4: {
            Speed v;
            Time t, t0;
            printf("Enter speed (m/s): ");
            scanf("%lf", &v);
            printf("Enter time (s): ");
            scanf("%lf", &t);
            printf("Enter initial time (s): ");
            scanf("%lf", &t0);
            Distance distance = calcLinearDist(v, t, t0);
            printf("Linear Distance: %.2f m\n", distance);
            break;
        }
        case 5: {
            Speed v, v0;
            Acceleration a;
            printf("Enter final speed (m/s): ");
            scanf("%lf", &v);
            printf("Enter initial speed (m/s): ");
            scanf("%lf", &v0);
            printf("Enter acceleration (m/s^2): ");
            scanf("%lf", &a);

            if (a == 0) {
                printf("Error: Acceleration cannot be zero.\n");
                break;
            }

            Distance distance = calcLinearAccelDist(v, v0, a);
            printf("Linear Acceleration Distance: %.2f m\n", distance);
            break;
        }
        case 6: {
            Acceleration a;
            Time t, t0;
            Speed v0;
            printf("Enter acceleration (m/s^2): ");
            scanf("%lf", &a);
            printf("Enter time (s): ");
            scanf("%lf", &t);
            printf("Enter initial time (s): ");
            scanf("%lf", &t0);
            printf("Enter initial speed (m/s): ");
            scanf("%lf", &v0);
            Speed speed = calcLinearAccelSpeed(a, t, t0, v0);
            printf("Linear Acceleration Speed: %.2f m/s\n", speed);
            break;
        }
        default:
            break;
        }
    } while (choice != 0);

    printf("Exiting program.\n");
    return 0;
}