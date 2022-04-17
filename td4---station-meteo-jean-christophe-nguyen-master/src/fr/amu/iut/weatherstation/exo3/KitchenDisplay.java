package fr.amu.iut.weatherstation.exo3;

import fr.amu.iut.weatherstation.exo3.WeatherStation;

public class KitchenDisplay extends Display {
    public void AfficheStation(WeatherStation WS){
        System.out.println("Affichage cuisine :" +
                '\n' +
                "                       Météo                    "+'\n'+
                "                 Humidité : " + WS.getHumidity() + " %"+'\n' +
                "                 Température :" + WS.getTemperature() + " °C" + '\n' +
                "                 Pression : "+ WS.getPressure() + '\n' +'\n');

    }
}
