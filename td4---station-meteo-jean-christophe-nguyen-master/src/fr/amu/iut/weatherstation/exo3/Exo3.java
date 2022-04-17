package fr.amu.iut.weatherstation.exo3;

import fr.amu.iut.weatherstation.exo1.HumiditySensor;
import fr.amu.iut.weatherstation.exo1.PressureSensor;
import fr.amu.iut.weatherstation.exo1.TemperatureSensor;
import fr.amu.iut.weatherstation.exo3.WeatherStation;
import fr.amu.iut.weatherstation.exo3.ConsoleDisplay;
import fr.amu.iut.weatherstation.exo3.SmartphoneDisplay;

public class Exo3 {
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

        weatherStation.addEcran(kitchen);
        weatherStation.addEcran(phone);
        weatherStation.addEcran(console);

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