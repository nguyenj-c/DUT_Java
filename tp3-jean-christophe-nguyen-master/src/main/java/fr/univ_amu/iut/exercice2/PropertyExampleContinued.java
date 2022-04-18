package java.fr.univ_amu.iut.exercice2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyExampleContinued {

    private IntegerProperty anIntProperty;

    public static void main(String[] args) {
        PropertyExampleContinued propertyExample = new PropertyExampleContinued();
        propertyExample.setAnInt(1024);
        propertyExample.bindAndUnbindOnePropertyToAnother();
    }

    public int getAnInt() {
        return anIntProperty.get();
    }

    public void setAnInt(int anInt) {
        if (anIntProperty == null)
            anIntProperty = new SimpleIntegerProperty();
        this.anIntProperty.set(anInt);
    }

    public IntegerProperty anIntProperty() {
        return anIntProperty;
    }

    void bindAndUnbindOnePropertyToAnother() {
        IntegerProperty otherProperty = new SimpleIntegerProperty(0);
        System.out.println();
        System.out.println("otherProperty.get() = "+ otherProperty.get());
        otherProperty.bind(anIntProperty);
        System.out.println("Binding otherProperty to anIntProperty.");
        System.out.println("otherProperty.get() = "+ otherProperty.get());
        anIntProperty.set(7168);
        System.out.println("Calling anIntProperty.set(7168).");
        for(int i=0;i<3;++i) {
            System.out.println("otherProperty.get() = " + otherProperty.get());
        }
        otherProperty.unbind();
        System.out.println("Unbinding otherProperty from anIntProperty.");
        anIntProperty.set(8192);
        System.out.println("Calling anIntProperty.set(8192).");

    }
}
