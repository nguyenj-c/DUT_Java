import java.lang.Math;
import java.util.*;

/**
 * 
 */
public class Distance_Hamming implements Methode {

    private int mySeuil=0;
    /**
     * Default constructor
     */
    public Distance_Hamming(int seuil) {
        mySeuil=seuil;
    }

    /**
     * @param text1 
     * @param text2
     * @return
     */
    public boolean compare(String text1, String text2) {
        int i = 0, count = 0;
        while ( i< Math.min(text1.length(),text2.length()))
        {
            if (text1.charAt(i) != text2.charAt(i))
                count++;
            i++;
        }
        if(count < mySeuil)
            return true;
        return false;
    }

}