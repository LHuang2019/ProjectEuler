package projectEuler;

import java.math.BigInteger;

/**
 * The class which contain methods that solve problem 25 to 50, except few
 * @author Li Huang
 * @version 12.21.2015
 */
public class LevelTwentySixToFifty {

    /**
     * Method which solves problem 48 using BigInteger and loops
     * @param maxNum the maximum number and its exponent
     * @param digit the amount digit of the sum that wants to output
     * @return the last giving input digit of the sum
     */
    public static String selfPowers(int maxNum, long digit)
    {
        BigInteger current = new BigInteger("0");
        BigInteger mod = BigInteger.valueOf(digit);
        BigInteger sum = new BigInteger("0");
        
        for (int i = 1; i < maxNum; i++)
        {
            current = BigInteger.valueOf(i);
            sum = sum.add(current.modPow(current, mod));
            sum = new BigInteger(sum.mod(mod).toString());
        }
        
        String output = sum.toString();
        
        return output;
    }
    
    /**
     * Method which solves problem 28 using loops
     * @param n the n spiral
     * @return the sum of numbers on the diagonals in a n by n spiral
     */
    public static int numberSpiralDiagonals (int n)
    {   
        int sum = 1;
        int current = 3;
        for (int i = 1; i <= (n - 1) / 2; i++)
        {
            sum += 4 * (current * current) - 12 * i;
            current += 2;
        }
        
        return sum;
    }
}