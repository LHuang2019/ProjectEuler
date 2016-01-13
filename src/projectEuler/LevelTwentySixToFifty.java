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
}