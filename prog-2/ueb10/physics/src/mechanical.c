#include "mechanical.h"

Speed calculateSpeed(Distance delta_s, Time delta_t) {
    return delta_s / delta_t;
}

Acceleration calculateAcceleration(Speed delta_v, Time delta_t) {
    return delta_v / delta_t;
}

Impulse calculateImpulse(Mass m, Speed v) {
    return m * v;
}
