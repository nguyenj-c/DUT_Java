package fr.amu.iut.weatherstation.exo1;

public class WeatherStation {
    private TemperatureSensor temperatureSensor;
    private HumiditySensor humiditySensor;
    private PressureSensor pressureSensor;
    private float temperature;
    private float humidity;
    private float pressure;


    public WeatherStation(TemperatureSensor temperatureSensor, HumiditySensor humiditySensor, PressureSensor pressureSensor){
        this.temperatureSensor = temperatureSensor;
        this.humiditySensor = humiditySensor;
        this.pressureSensor = pressureSensor;
    }

    public float getTemperature(){
        return this.temperature;
    }
    public float getHumidity(){
        return this.humidity;
    }
    public float getPressure(){
        return this.pressure;
    }

    public void pollSensors(){

        // Ask each sensor for its value and store it
        this.temperature = temperatureSensor.takeMeasurement();
        this.humidity = humiditySensor.takeMeasurement();
        this.pressure = pressureSensor.takeMeasurement();

    }
}
