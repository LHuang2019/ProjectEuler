package projectEuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * The class which contain methods that solve problem 25 to 50, except few
 * @author Li Huang
 * @version 12.21.2015
 */
public class LevelTwentySixToFifty extends ProjectHelper{

    /**
     * Method which solves problem 26 by comparing the remainders, uses helper method sieveOfErathosthenes
     * @param max value in which we going to find unit fractions on
     * @return the value which has largest reciprocal that is lower than max
     */
    public static int reciprocalCycles (int max)
    {
        ArrayList<Integer> remainderList = new ArrayList<Integer>();
        remainderList.add(Integer.MAX_VALUE);
        int currentRemainder = 1;
        int current = 0;
        int currentD = 0;
        int currentMax = 0;
        boolean condition = false;
        boolean[] primeList = ProjectHelper.sieveOfErathosthenes(max);

        // if max is even then we need to make it odd to speed up the process
        if (max != 2 && max % 2 == 0)
            max -= 1;

        // starts at max, only check the prime numbers because only prime generates
        // reciprocal that is large enough
        for (int i = max; i > 0; i -= 2)
        {
            if (primeList[i])
                condition = true;

            while(!condition)
            {
                while (currentRemainder < i)
                    currentRemainder *= 10;

                currentRemainder %= i;

                if (currentRemainder != 0)
                {
                    for (int j = 0; j < remainderList.size(); j++)
                    {
                        if (remainderList.get(j) == currentRemainder)
                        {
                            j = remainderList.size();
                            condition = true;
                        }
                    }
                    if (condition)
                    {
                        if (current > currentMax)
                        {
                            currentD = i;
                            currentMax = current;
                        }
                        currentRemainder = 1;
                        current = 0;
                        remainderList.clear();
                        remainderList.add(Integer.MAX_VALUE);
                    }
                    else
                    {
                        remainderList.add(currentRemainder);
                        current++;
                    }
                }
                else
                {
                    currentRemainder = 1;
                    condition = true;
                }
            }            
            condition = false;
        }

        return currentD;
    }

    /**
     * Method which solves problem 27 using helper method isPrime and sieveOfErathosthenes
     * @param aMax max value a in n^2 + an + b
     * @param bMax max value b in n^2 + an + b
     * @return the product of a and b that generates largest number of primes with consecutive n 
     */
    public static int quadraticPrimes (int aMax, int bMax)
    {
        int a = 0, b = 0, n = 0, numOfPrime = -1, maxNumPrime = -1, currentPrime = 0;
        boolean[] primeList = ProjectHelper.sieveOfErathosthenes(aMax);

        // make aMax and bMax to be odd, so for loops can increment by 2 to increase speed
        if (aMax != 2 && aMax % 2 == 0)
            aMax--;
        if (bMax != 2 && bMax % 2 == 0)
            bMax--;

        // a and b can only be prime for n^ + an + b to generate primes with consecutive n
        for (int i = -aMax; i <= aMax; i += 2)
        {
            if (!primeList[Math.abs(i)])
            {
                for (int j = -bMax; j <= bMax; j += 2)
                {
                    if (!primeList[Math.abs(j)])
                    {
                        do
                        {
                            currentPrime = n * n + i * n + j;
                            numOfPrime++;
                            n++;
                        } while (ProjectHelper.isPrime(currentPrime));

                        if (numOfPrime > maxNumPrime)
                        {
                            maxNumPrime = numOfPrime;
                            a = i;
                            b = j;
                        }
                        numOfPrime = -1;
                        n = 0;
                        currentPrime = 0;
                    }
                }
            }
        }

        return a * b;
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

    /**
     * Method which solves problem 29 using brute force
     *      will be updated
     * @param max a and b
     * @return the distinct terms in the sequence generated by a and b
     */
    public static int distinctPowers(int max)
    {
        boolean condition = true;
        BigInteger current = new BigInteger("0");
        ArrayList<BigInteger> list = new ArrayList<BigInteger>();
        for (int a = 2; a <= max; a++)
        {
            for (int b = 2; b <= max; b++)
            {
                current = new BigInteger(Integer.toString(a));
                current = current.pow(b);

                for (int i = 2; i < list.size(); i++)
                {
                    if (current.equals(list.get(i)))
                    {
                        i = list.size();
                        condition = false;
                    }
                }
                if (condition)
                {
                    list.add(0, current);
                }
                condition = true;
            }
        }
        return list.size();
    }

    /**
     * Method which solves problem 30 using loops
     * @param pow the power 
     * @return sum of all numbers that can be written 
     *         as the sum given powers of their digits
     */
    public static int digitFifthPowers (double pow)
    {
        long max = (long) (pow * Math.pow(9, pow));
        int strLength = Long.toString(max).length();
        max = (long) (strLength * Math.pow(9, pow));

        int sum = 0;

        for (int i = 2; i <= max; i++)
        {
            int sumOfPowers = 0;
            int current = i;

            while (current > 0) {
                int currentDigit = current % 10;

                currentDigit = (int) Math.pow(currentDigit, pow);
                sumOfPowers += currentDigit;
                current /= 10;
            }

            if (sumOfPowers == i) {
                sum += i;
            }
        }

        return sum;
    }

    /**
     * method which solves problem 31 using for loops and brute force
     * @param currency the given amount of money
     * @return the way we can use all the coins to add up to the amount of given money
     */
    public static int coinSum(int currency)
    {
        int generation = 0;

        for (int a = 0; a <= currency; a += 200)
            for (int i = a; i <= currency; i += 100)
                for (int j = i; j <= currency; j += 50)
                    for (int k = j; k <= currency; k += 20)
                        for (int m = k; m <= currency; m += 10)
                            for (int n = m; n <= currency; n += 5)
                                for (int x = n; x <= currency; x += 2)
                                    generation++;

        return generation;
    }

    /**
     * Method which solves problem 34 using similar approach as problem 30 
     * @return sum of all numbers all numbers 
     *          which are equal to the sum of the factorial of their digits
     */
    public static int digitFactorials ()
    {
        long max = 7 * factorialCalculator(9); //the upper bound
        int currentFactorial = 0;
        int sum = 0;

        for (int i = 3; i <= max; i++)
        {
            int current = i;
            int numSum = 0;

            while (current > 0) {
                int currentDigit = current % 10;

                currentFactorial = (int)factorialCalculator(currentDigit);
                numSum += currentFactorial;
                current /= 10;
            }

            if (numSum == i) {
                sum += i;
            }
        }

        return sum;
    }

    /**
     * Method which solves problem 35 using loops and helper method sieveOfErathosthenes()
     *      *** extremely inefficient ***
     * @param max the max number 
     * @return number of  circular primes are there below max
     */
    public static int circularPrimes (int max)
    {
        boolean[] primeArray = sieveOfErathosthenes(max);
        boolean[] circularPrimes = new boolean[primeArray.length];
        String currentPrime = "";
        boolean currentCondition = true;
        int count = 0;
        int currentLength = 0;
        int sum = 1;

        for (int i = 3; i < primeArray.length; i += 2) //start at 3 to make the loop more efficient
        {
            if (!primeArray[i])
            {
                currentPrime = Integer.toString(i);
                currentLength = currentPrime.length();
                count = 0;
                currentCondition = true;

                while (currentCondition && count < currentLength)
                {
                    if (!primeArray[Integer.parseInt(currentPrime)])
                    {
                        currentPrime = currentPrime.substring(1) + currentPrime.substring(0, 1);
                        count++;
                    }
                    else
                    {
                        currentCondition = false;
                    }
                }

                currentPrime = Integer.toString(i);
                count = 0;

                while (currentCondition && count < currentLength)
                {
                    circularPrimes[Integer.parseInt(currentPrime)] = true;
                    primeArray[Integer.parseInt(currentPrime)] = true;
                    currentPrime = currentPrime.substring(1) + currentPrime.substring(0, 1);
                    count++;
                }
            }
        }

        for (int j = 3; j < circularPrimes.length; j += 2) //start at 3 to make the loop more efficient
        {
            if(circularPrimes[j])
            {
                sum++;
            }
        }

        return sum; //count 2 as prime number
    }

    /**
     * Method which solves problem 36 using brute force
     * @param max the max number
     * @return the sum of all number that is palindrome in base 2 and 10
     */
    public static int doubleBasePalindromes(int max)
    {
        String binary = "";
        int sum = 0;

        for (int i = 1; i <= max; i += 2)
        {
            if (palindromeIntChecker(i))
            {
                binary = Integer.toBinaryString(i);
                if (palindromeStringChecker(binary))
                {
                    sum += i;
                }
            }
        }

        return sum;
    }
    
    public static int champernownesConstant (int maxDigit)
    {        
        return 0;
    }

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