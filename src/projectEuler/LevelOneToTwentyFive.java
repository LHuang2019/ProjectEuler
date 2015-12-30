package projectEuler;

import java.util.ArrayList;

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
     * Method which solves problem three using the helper method
     *      ProjectHelper -> primeFactor()
     * @param input the number that will be solve
     * @return the largest prime factor of the input
     */
    public static long largestPrimeFactor(long input)
    {
        ArrayList<Long> list = ProjectHelper.primeFactor(input);
        long output = list.get(list.size() - 1);

        return output;
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
                if (ProjectHelper.palindromeIntChecker(i * j) && i * j > output)
                {
                    output = i * j;
                }
            }
        }
        return output;
    }

    /**
     * Method which solves problem 6
     *      sum_n = (n*(n+1))/2
     *      sum_n^2 = (n*(n+1)*(2n+1))/6
     * @param max the n value
     * @return the difference of sum of square and square of sum
     */
    public static double sumSquareDifference(double max)
    {
        double sumOfSquare = (max * (max + 1) * (2 * max + 1)) / 6;
        double squareOfSum = Math.pow((max * (max + 1)) / 2, 2);

        double output = squareOfSum - sumOfSquare;

        return output;
    }

    /**
     * Method which solves problem 7 using helper method
     *      ProjectHelper -> sieveOfErathosthenes
     * @param max the nth term prime number
     * @return index - 1 the value of nth term prime number
     */
    public static int problemSeven(int max)
    {
        boolean[] list = ProjectHelper.sieveOfErathosthenes(109999);

        int count = 0;
        int index = 2;

        while (count < max && index < list.length - 1)
        {
            if (list[index] == false)
            {
                count++;
            }
            index++;
        }

        return index - 1;
    }

    /**
     * Method which solves problem 8 using two loops that goes through the series
     * @param series the series given by the problem
     * @param num the number of consecutive numbers that will be multiply together
     * @return the largest product of the consecutive numbers
     */
    public static long largestProductInSeries(String series, int num)
    {

        int[] list = new int[series.length()];

        for (int i = 0; i < series.length(); i++)
        {
            list[i] = Integer.parseInt(series.substring(i, i + 1));
        }

        long checker = 1;
        long output = 0;

        for (int i = 0; i + num < list.length; i++)
        {
            for (int j = i; j < i + num; j++)
            {
                if (list[j] != 0)
                {
                    checker = checker * list[j];
                }
                else
                {
                    j = i + num;
                }
            }

            if (checker > output)
            {
                output = checker;
            }
            checker = 1;
        }

        return output;
    }

    /**
     * Method which solves problem 9 using Euclid's formula:
     *      a^2 + b^2 = c^2 where
     *      a = m^2-n^2, b = 2mn, and c = m^2+n^2
     * @param sum sum of a + b + c
     * @return product of a * b * c;
     */
    public static int SpecialPythagoreanTriplet(int sum)
    {
        int answer = 0;
        for (int m = 1; m < Math.sqrt(sum); m++)
        {
            for (int n = 1; n < m; n++)
            {
                if ((m - n) % 2 == 1)
                {
                    answer = 2 * (m * m) + 2 * m * n;
                    if (answer == sum)
                    {
                        return 2 * m * n * (m * m - n * n) * (m * m + n * n);
                    }
                }
            }
        }
        return 0;
    }
    
    /**
     * Method which solves problem 10 using helper method sieveOfErathosthenes
     * @param max the maxmum number that can be
     * @return the sum of all prime numbers below max
     */
    public static long summationOfPrimes(int max)
    {
        boolean[] list = ProjectHelper.sieveOfErathosthenes(max);
        long sum = 0;
        
        for (int i = 2; i < list.length; i++)
        {
            if (!list[i])
            {
                sum += i;
            }
        }
        
        return sum;
    }
}
