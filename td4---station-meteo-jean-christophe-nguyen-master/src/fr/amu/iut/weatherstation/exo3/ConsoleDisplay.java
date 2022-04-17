package fr.amu.iut.weatherstation.exo3;

import fr.amu.iut.weatherstation.exo3.WeatherStation;
import fr.amu.iut.weatherstation.exo3.Display;

public class ConsoleDisplay extends Display {
    public void AfficheStation(WeatherStation WS){
        System.out.println("Affichage console: " +
                '\n' + '\n' +
                "Humidité : " + WS.getHumidity() +  '\n' +
                "Température :" + WS.getTemperature() +  '\n' +
                "Pression atmosphérique: "+ WS.getPressure() +  '\n' +'\n');
    }
}