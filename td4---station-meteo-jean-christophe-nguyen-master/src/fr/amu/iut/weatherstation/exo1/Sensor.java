package fr.amu.iut.weatherstation.exo1;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Sensor {

    private double refreshProbability = 0.2; // 20%
    protected float measurement = 0;

    /**
     * Refresh sensor internal measurement
     */
    public abstract void refresh();

    /**
     * Take a measurement with the sensor.
     * The internal measurement is not refreshed every time to simulate in a very simple way a real sensor
     * @return The measurement
     */
    public float takeMeasurement() {
        double randomValue = ThreadLocalRandom.current().nextDouble();  //Random number between [0.0 ; 1.0[
        if (randomValue <= refreshProbability) {
            this.refresh();
        }
        return measurement;
    }

    public Sensor(){
        // Take a first measurement at initialization
        this.refresh();
    }
}
