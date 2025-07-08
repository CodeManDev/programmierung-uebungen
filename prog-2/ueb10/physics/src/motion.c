#include "motion.h"

Distance calcLinearDist(Speed v, Time t, Time t0) {
    return v * (t - t0);
}

Distance calcLinearAccelDist(Speed v, Speed v0, Acceleration a) {
    return (v * v - v0 * v0) / (2 * a);
}

Speed calcLinearAccelSpeed(Acceleration a, Time t, Time t0, Speed v0) {
    return a * (t - t0) + v0;
}