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

    /**
     * Helper method which given a number, gives you all the prime numbers
     *      under that number, using the algorithm of sieve half efficiently
     * @param max the max value
     * @return list an array which gives you prime numbers with boolean false
     */
    public static boolean[] sieveOfErathosthenes(int max)
    {
        boolean[] list = new boolean[max + 1];

        for (int i = 2; i * i < max + 1; i++)
        {
            for (int j = i * i; j < max + 1; j++)
            {
                if (j % i == 0)
                {
                    list[j] = true;
                }
            }
        }

        return list;
    }

    /**
     * Method which returns the gcd of x and y
     * @param x the x value
     * @param y the y value
     * @return gcd the gcd of x and y
     */
    public static int greatestCommonDivider(int x, int y)
    {
        int i;
        while (y != 0)
        {
            i = y;
            y = x % y;
            x = i;
        }
        return x;
    }

    /**
     * Method which returns the largest of number of x, y, and z
     * @param x the first number
     * @param y the second number
     * @param z the third number
     * @return the largest number
     */
    public static int largestOfThree(int x, int y, int z)
    {
        if ( x > y && x > z )
            return x;
        else if ( y > x && y > z )
            return y;
        else if ( z > x && z > y )
            return z;
        else   
            return x;
    }
}
