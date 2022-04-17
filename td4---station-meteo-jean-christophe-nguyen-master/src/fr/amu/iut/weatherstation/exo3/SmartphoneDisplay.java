package fr.amu.iut.weatherstation.exo3;

import fr.amu.iut.weatherstation.exo3.WeatherStation;
import fr.amu.iut.weatherstation.exo3.Display;

public class SmartphoneDisplay extends Display {
    public void AfficheStation(WeatherStation WS){
        System.out.println("Affichage smartphone :" +
                '\n' +
                "Température :" + WS.getTemperature() +  '\n' +
                "Humidité : " + WS.getHumidity() +  '\n' +
                "Poor weather today");
    }
}
