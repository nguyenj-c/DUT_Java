package fr.amu.iut.weatherstation.exo1;

public class TemperatureSensor extends Sensor {
    @Override
    public void refresh() {
        // Generate a random value in °C to act as a dummy pressure sensor
        float minValue = 15;
        float maxValue = 17;
        this.measurement = (float) (minValue + (Math.random() * (maxValue - minValue)));
    }
}
