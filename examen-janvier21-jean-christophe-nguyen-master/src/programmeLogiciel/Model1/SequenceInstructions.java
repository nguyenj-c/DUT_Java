
import java.util.*;

/**
 * 
 */
public class SequenceInstructions extends Instruction {

    /**
     * Default constructor
     */
    public SequenceInstructions() {
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