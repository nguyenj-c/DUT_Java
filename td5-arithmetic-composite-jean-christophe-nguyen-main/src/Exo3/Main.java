package Exo3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String arg[]){
        Circuit circ = new Circuit(new ArrayList<Composant>());
        circ.addComposant(new Diode());
        circ.addComposant(new Condensateur());
        circ.addComposant(new Resistance());


        Circuit circ2 = new Circuit(new ArrayList<Composant>());
        circ2.addComposant(circ);
        circ2.addComposant(new Condensateur());
        circ2.addComposant(new Resistance());

        Circuit circ3 = new Circuit(new ArrayList<Composant>());
        circ3.addComposant(circ2);
        circ3.addComposant(new Diode());
        circ3.addComposant(new Diode());

        circ3.execute();
    }


}
