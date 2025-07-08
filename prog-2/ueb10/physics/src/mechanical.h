#ifndef MECHANICAL_H
#define MECHANICAL_H

#include "types.h"

Speed calculateSpeed(Distance delta_s, Time delta_t);
Acceleration calculateAcceleration(Speed delta_v, Time delta_t);
Impulse calculateImpulse(Mass m, Speed v);

#endif // MECHANICAL_H