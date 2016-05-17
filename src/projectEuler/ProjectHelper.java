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
     * @param input the number that needs to be check
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
     * helper method which checks to see if a string is palindrome
     * @param input input the string that needs to be check
     * @return true if the string is palindrome
     */
    public static boolean palindromeStringChecker(String input)
    {
        return input.equals(new StringBuilder(input).reverse().toString());
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
     *      less than that number, using the algorithm of sieve half efficiently
     *      *** the given array should start with index at 2, since 1 is not a prime number ***
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

    /**
     * Method which finds the name of the weekday of January 1st
     *      for any year after 1900
     * @param year the weekday of the year you want to find
     * @return the startDay where 0 is Monday and 6 is Sunday
     */
    public static int startDayFinder (int year)
    {
        int difference = year - 1900;
        int startDay = ((difference / 4) + difference) % 7;

        if (difference > 99)
        {
            startDay -= difference / 100;
        }

        if (year % 100 != 0 && year % 4 == 0)
        {
            startDay -= 1;

            if (startDay < 0)
            {
                startDay += 7;
            }
        }

        return startDay;
    }

    /**
     * Method which returns all the factors of the number except itself
     *      in an ArrayList
     * @param num the number
     * @return an ArrayList of all the factors of the number except itself
     */
    public static ArrayList<Integer> properFactorFinder(int num)
    {

        int divisor = 0;
        int increment = 1;
        int start = 2;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);

        int sqrtNum = (int)Math.sqrt(num);

        if (num % 2 != 0)
        {
            increment = 2;
            start = 3;
        }

        for(int i = start; i <= sqrtNum; i += increment)
        {
            if(num % i == 0)
            {
                list.add(i);
                divisor = num / i;

                if(divisor != i)
                {
                    list.add(divisor);
                }
            }
        }

        return list;
    }

    /**
     * Method which returns the next Lexicographic permutations of an integer array
     * @param array the integer array
     * @return the array with next Lexicographic permutations; original array
     *          if there is no next Lexicographic permutations
     */
    public static int[] nextLexicographicOrder (int[] array)
    {
        int key = 0;
        int keyPosition = Integer.MIN_VALUE;
        int keyNext = Integer.MAX_VALUE;
        int keyNextPosition = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] < array[i + 1] && i > keyPosition)
            {
                key = array[i];
                keyPosition = i;
            }
        }

        if (keyPosition == Integer.MIN_VALUE)
        {
            return array;
        }

        for (int j = keyPosition + 1; j < array.length; j++)
        {
            if (array[j] < keyNext && array[j] > key)
            {
                keyNext = array[j];
                keyNextPosition = j;
            }
        }

        array[keyPosition] = keyNext;
        array[keyNextPosition] = key;

        array = arrayIntSort(array, keyPosition + 1);

        return array;
    }

    /**
     * A simple method that uses insertion sort to sort an integer array
     *      from the start index to the end
     * @param array the given array
     * @param start the start index
     * @return the sorted array
     */
    public static int[] arrayIntSort(int[] array, int start)
    {
        int key = 0;

        for (int i = start; i < array.length; i++)
        {
            key = array[i];
            int previous = i - 1;
            while (previous > start - 1 && (array[previous] > key))
            {
                array[previous + 1] = array[previous];
                previous--;
            }
            array[previous + 1] = key;
        }

        return array;
    }

    /**
     * Helper method which calculates the factorial of the given number
     * @param num the given number
     * @return the factorial of the given number; num!
     */
    public static long factorialCalculator (int num)
    {
        long answer = 1;

        for (int i = 1; i <= num; i++)
        {
            answer *= i;
        }

        return answer;
    }
}
