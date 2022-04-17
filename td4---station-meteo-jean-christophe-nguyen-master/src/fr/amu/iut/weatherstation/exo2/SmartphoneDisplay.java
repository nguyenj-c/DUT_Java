package fr.amu.iut.weatherstation.exo2;

import fr.amu.iut.weatherstation.exo1.WeatherStation;

public class SmartphoneDisplay extends Display{
    public void AfficheStation(WeatherStation WS){
        System.out.println("Affichage smartphone :" +
                '\n' +
                "Température :" + WS.getTemperature() +  '\n' +
                "Humidité : " + WS.getHumidity() +  '\n' +
                "Poor weather today");
    }
}
