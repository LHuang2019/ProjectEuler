package projectEuler;
import java.util.ArrayList;

/**
 * Class which contains helper methods to help solve future problems
 * @author Li Huang
 * @version 12.25.2015
 */
public class ProjectHelper {

    /**
     * helper method which checks to see if a number is palindrome
     * @param input the number that be checked
     * @return true if the number is palindrome
     */
    public static boolean palindromeIntChecker(int input)
    {
        int num = input;
        int placeHolder = 0;
        int rev = 0;

        while (num > 0)
        {
            placeHolder = num % 10;
            rev = rev * 10 + placeHolder;
            num = num / 10;
        }    
        return rev == input;
    }
    
    /**
     * Helper method which identifies all prime factors of the input
     * @param input the input
     * @return an array list of prime factors of the input
     */
    public static ArrayList<Long> primeFactor(long input)
    {
        
        ArrayList<Long> factor = new ArrayList<Long>();
        long checker = input;
        
        
        for (long i = 2; i <= checker / i; i++)
        {
            if (checker % i == 0)
            {
                factor.add(i);
                checker = checker / i;
            }
        }
        
        if (checker > 1)
        {
            factor.add(checker);
        }
        
        return factor;
    }

}
