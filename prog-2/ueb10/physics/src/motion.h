#ifndef MOTION_H
#define MOTION_H

#include "types.h"

Distance calcLinearDist(Speed v, Time t, Time t0);
Distance calcLinearAccelDist(Speed v, Speed v0, Acceleration a);
Speed calcLinearAccelSpeed(Acceleration a, Time t, Time t0, Speed v0);

#endif // MOTION_H