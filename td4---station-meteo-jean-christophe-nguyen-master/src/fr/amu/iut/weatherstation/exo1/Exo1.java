package fr.amu.iut.weatherstation.exo1;

public class Exo1 {

    public static void main(String[] args) {
        // Initialize sensors
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();

        // Initialize our weather station by linking it to the sensors
        WeatherStation weatherStation = new WeatherStation(temperatureSensor, humiditySensor, pressureSensor);


        try {
            //noinspection InfiniteLoopStatement
            while (true){
                System.out.println();
                System.out.println("Weather station: polling sensors");
                // Take a measurement from the sensors
                weatherStation.pollSensors();
                System.out.println("Console display: ");
                System.out.println("Temperature: " + weatherStation.getTemperature());
                System.out.println("Humidity: " + weatherStation.getHumidity());
                System.out.println("Pressure: " + weatherStation.getPressure());
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
