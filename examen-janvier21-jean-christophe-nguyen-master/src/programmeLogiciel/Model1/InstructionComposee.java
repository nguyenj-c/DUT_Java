
import java.util.*;

/**
 * 
 */
public class InstructionComposee extends Instruction {

    /**
     * Default constructor
     */
    public InstructionComposee() {
    }

    /**
     * @return String
     */
    public String IF(String s,void AppelAfficher()) {
        if(s="toto"){
            return System.out.println("bravo");
        }
    }

    /**
     * @return
     */
    public String Condition() {
        // TODO implement here
        return "";
    }
    /**
     * @return
     */
    public String AppelAfficher() {
        // TODO implement here
        return "";
    }

}