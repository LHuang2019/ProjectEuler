package projectEuler;

/**
 * The class which contains the method that solves problem one through twenty five
 * @author Li Huang
 * @version 12.21.2015
 */
public class LevelOneToTwentyFive {

    /**
     * Method which solves problem one
     * The method takes input of x, y, and top, and returns the sum of
     *      all multiples of x or y that is below  top
     * @param x the first number
     * @param y the second number
     * @param top the greatest number that x or y can multiply to
     * @return the sum of multiple of x or y that is below top
     */
    public static int problemOne(int x, int y, int max)
    {
        max = max - 1;

        int nOne = max / x;
        int nTwo = max / y;
        int nThree = max / (x * y);

        int sumOne = (nOne * (nOne + 1)) / 2 * x;
        int sumTwo = (nTwo * (nTwo + 1)) / 2 * y;
        int sumThree = (nThree * (nThree + 1)) / 2 * (x * y);

        int output = sumOne + sumTwo - sumThree;

        return output;
    }
    
    /**
     * Method which solves problem two using brute force, uses Fibbonacci iteration
     * @param max the highest fibbonacci that can be
     * @return sum of all even fibbonacci number below the max
     */
    public static int problemTwo(int max)
    {
        if (max == 0)
        {
            return 0;
        }

        int previousFib = 0;
        int currentFib = 1;
        int output = 0;

        while (currentFib < max)
        {       
            int newFib = previousFib + currentFib;
            previousFib = currentFib;
            currentFib  = newFib;

            if (currentFib % 2 == 0)
            {
                output = output + currentFib;
            }
        }
        return output;
    }
    
    /**
     * Method which solves problem three using brute force
     * @param input the number that will be solve
     * @return the largest prime factor of the input
     */
    public static long largestPrimeFactor(long input)
    {
        long hold = input;
        long key = 0;
        
        for (long i = 2; i <= hold; i++)
        {
            if (hold % i == 0)
            {
                key = i;
                hold = hold / i;
                i = 2;
            }
        }
        
        return key;
    }
    
    /**
     * Method which solves problem 4 using brute force
     * @param max the largest number that the factor can become
     * @return output the product that is palindrome
     */
    public static int largestPalindromeProduct(int max)
    {
        int output = 0;
        int min = max / 10 + 1;
        
        for (int i = max; i > min; i--)
        {
            for (int j = i; j > min; j--)
            {
                if (palindromeIntChecker(i * j) && i * j > output)
                {
                    output = i * j;
                }
            }
        }
        return output;
    }
    
    /**
     * helper method which checks to see if a number is palindrome
     * @param input the number that be checked
     * @return true if the number is palindrome
     */
    private static boolean palindromeIntChecker(int input)
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
}
