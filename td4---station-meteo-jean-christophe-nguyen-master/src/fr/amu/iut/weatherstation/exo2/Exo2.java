package fr.amu.iut.weatherstation.exo2;

import fr.amu.iut.weatherstation.exo1.HumiditySensor;
import fr.amu.iut.weatherstation.exo1.PressureSensor;
import fr.amu.iut.weatherstation.exo1.TemperatureSensor;
import fr.amu.iut.weatherstation.exo1.WeatherStation;

public class Exo2 {
    public static void main(String[] args) {
        // Initialize sensors
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        HumiditySensor humiditySensor = new HumiditySensor();
        PressureSensor pressureSensor = new PressureSensor();

        // Initialize our weather station by linking it to the sensors
        WeatherStation weatherStation = new WeatherStation(temperatureSensor, humiditySensor, pressureSensor);

        //Initialize our screens
        KitchenDisplay kitchen = new KitchenDisplay();
        SmartphoneDisplay phone = new SmartphoneDisplay();
        ConsoleDisplay console = new ConsoleDisplay();

        try {
            //noinspection InfiniteLoopStatement
            while (true){
                weatherStation.pollSensors();
                kitchen.AfficheStation(weatherStation);
                phone.AfficheStation(weatherStation);
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}