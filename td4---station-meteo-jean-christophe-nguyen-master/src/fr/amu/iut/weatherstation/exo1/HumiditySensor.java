package fr.amu.iut.weatherstation.exo1;

public class HumiditySensor extends Sensor {

    @Override
    public void refresh() {
        // Generate a random value in % to act as a dummy pressure sensor
        float minValue = 55;
        float maxValue = 65;
        this.measurement = (float) (minValue + (Math.random() * (maxValue - minValue)));
    }
}
