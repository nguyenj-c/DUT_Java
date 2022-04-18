package Exo3;

import java.util.List;

public class Circuit extends Composant{
    private List<Composant> mesComposants;
    public Circuit(List<Composant> composants) {
        mesComposants=composants;
    }
    public void addComposant(Composant monComposant){
        mesComposants.add(monComposant);
    }
    public void deleteComposant(Composant monComposant){
        mesComposants.remove(monComposant);
    }

    @Override
    public void execute() {
        for (Composant c: mesComposants)
            c.execute();
    }
}
