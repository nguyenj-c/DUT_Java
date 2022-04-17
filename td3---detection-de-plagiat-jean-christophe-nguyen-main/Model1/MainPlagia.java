
import java.util.*;

/**
 * 
 */
public class MainPlagia {

    /**
     * Default constructor
     */
    public MainPlagia() {
    }


    /**
     * @param text1 
     * @param text2 
     * @param methode 
     * @return
     */

    public static boolean checkPlagiarism(String text1, String text2, Methode methode) {
        boolean result = methode.compare(text1, text2);
        return result;
    }
    public static void main(String[] args){
        String text1 = "Gateau";
        String text2 = "Bateau";
        System.out.println(checkPlagiarism(text1,text2, new Distance_Hamming(4)));

    }
}