package fr.amu.iut.weatherstation.exo1;

public class PressureSensor extends Sensor {

    @Override
    public void refresh() {
        // Generate a random value in hPa to act as a dummy pressure sensor
        float minValue = 990;
        float maxValue = 1020;
        this.measurement = (float) (minValue + (Math.random() * (maxValue - minValue)));
    }
}
