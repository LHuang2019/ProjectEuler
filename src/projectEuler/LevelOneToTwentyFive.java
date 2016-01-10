package projectEuler;

import java.math.BigInteger;
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
     * @param max the maximum number that can be
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

    /**
     * Method which solves problem 11 using helper method largestOfThree
     * @param input the 2d array
     * @return the largest product of four adjacent numbers inside array
     */
    public static int largestProductInGrid (int[][] input)
    {
        int checkerRight = 0;
        int checkerDown = 0;
        int checkerDiagonal = 0;
        int checker = 0;
        int largest = 0;

        for (int i = 0; i < input.length - 3; i++)
        {
            for (int j = 0; j < input[i].length - 3; j++)
            {
                checkerRight = input[i][j] * input[i][j + 1] * input[i][j + 2] * input[i][j + 3];
                checkerDown = input[i][j] * input[i + 1][j] * input[i + 2][j] * input[i + 3][j];
                checkerDiagonal = input[i][j] * input[i + 1][j + 1] * input[i + 2][j + 2] * input[i + 3][j + 3];
                checker = ProjectHelper.largestOfThree(checkerRight, checkerDown, checkerDiagonal);
                if (checker > largest)
                {
                    largest = checker;
                }
            }
        }

        for (int k = input.length - 3; k < input.length; k++)
        {
            for (int l = 0; l < input[k].length - 3; l++)
            {
                checker = input[k][l] * input[k][l + 1] * input[k][l + 2] * input[k][l + 3];
                if (checker > largest)
                {
                    largest = checker;
                }
            }
        }

        for (int m = 0; m < input.length - 3; m++)
        {
            for (int n = 3; n < input[m].length; n++)
            {
                checkerDiagonal = input[m][n] * input[m + 1][n - 1] * input[m + 2][n - 2] * input[m + 3][n - 3];
                if (checkerDiagonal > largest)
                {
                    largest = checkerDiagonal;
                }
            }
        }

        return largest;
    }

    /**
     * Method which solves problem 12 using summation and for loop up to square root
     *      of the sum, and increment by two since factors come in pairs if divisible 
     * @param divisorNum the amount of divisors
     * @return the triangular number that contains the divisorNum amount of divisors
     */
    public static int highlyDivisibleTriNum(int divisorNum)
    {
        int count = 2;
        int n = 1;
        int current = 0;

        while (true)
        {
            current = (n * (n + 1)) / 2;
            for (int i = 2; i < Math.sqrt(current); i++)
            {
                if (current % i == 0)
                {
                    count += 2;
                }

                if (count >= divisorNum)
                {
                    return current;
                }
            }
            n++;
            count = 2;
        }
    }

    /**
     * Method which solves problem 13 using bigInteger
     * @param series the series of string in array list
     * @param digit the digit of the sum the question wants to show, which is 10
     * @return the first 10 digit of the sum of the series
     */
    public static String largestSumInSeries(ArrayList<String> series, int digit)
    {

        BigInteger sum = new BigInteger("0");

        for (int i = 0; i < series.size(); i++)
        {
            sum = sum.add(new BigInteger(series.get(i)));
        }

        String sumString = sum.toString();
        String output = sumString.substring(0, digit);

        return output;
    }

    /**
     * Method which solves problem 14 using loops
     * @param max the maximum number, which is million for the problem
     * @return the number that is under max and produces the longest chain
     */
    public static int longestCollatzSequence(int max)
    {
        long n = 0;
        int count = 0;
        int maxCount = 0;
        int maxNum = 0;

        for (int i = 1; i < max; i++)
        {
            count = 0;
            n = i;
            while (n > 1)
            {
                if (n % 2 == 0)
                {
                    n /= 2;
                    count++;
                }
                else
                {
                    n = 3 * n + 1;
                    count++;
                }
            }
            if (count > maxCount)
            {
                maxCount = count;
                maxNum = i;
            }
        }
        return maxNum;
    }

    /**
     * Method which solves problem 16 using BigInteger
     * @param exponent the exponent
     * @return the sum of the digit of the num
     */
    public static int powerDigitSum(int exponent)
    {
        BigInteger num = new BigInteger("2");
        num = num.pow(exponent);
        String sum = num.toString();
        int output = 0;

        for (int i = 0; i < sum.length(); i++)
        {
            output += Integer.parseInt(sum.substring(i, i + 1));
        }

        return output;
    }

    /**
     * Method which solves problem 17 using loops and control statements
     * @param max the max number, must be less than or equal to zero
     * @return the sum of number of letters from one to max
     */
    public static int numberLetterCounts (int max)
    {
        String[]ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        String[]tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                "Eighty", "Ninety"};

        String[]special = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String num = "";
        int sum = 0;

        for (int i = 1; i <= max; i++)
        {
            if (i > 999)
            {
                num = "oneThousand";
            }
            else if (i % 100 == 0)
            {
                num = ones[i / 100] + "hundred";
            }
            else if (i > 99)
            {
                if ((i % 100) < 10)
                {
                    num = ones[i / 100] + "HundredAnd" + ones[i % 100];
                }
                else if ((i % 100) < 20)
                {
                    num = ones[i / 100] + "HundredAnd" + special[i % 10];
                }
                else
                {
                    num = ones[i / 100] + "HundredAnd" + tens[(i % 100) / 10] + ones[i % 10];
                }
            }
            else
            {
                if (i < 10)
                {
                    num = ones[i];
                }
                else if (i < 20)
                {
                    num = special[i % 10];
                }
                else
                {
                    num = tens[i / 10] + ones[i % 10];
                }
            }

            sum += num.length();
        }

        return sum;
    }


    /**
     * Method which solves problem 18 and 67 by dividing the triangles into smaller ones
     *      and solve it more efficiently 
     * @param array the triangle that is saved as 2d array
     * @return array[0][0] which should be the sum of largest path
     */
    public static int maxPathSum(int[][] array)
    {
        int arrayHeight = array.length - 1;
        int arrayWidth = array[arrayHeight].length - 1;

        for (int i = arrayHeight; i > 0; i--)
        {
            for (int j = arrayWidth; j > 0; j--)
            {
                if (array[i][j] > array[i][j - 1])
                {
                    array[i - 1][j - 1] += array[i][j];
                }
                else
                {
                    array[i - 1][j - 1] += array[i][j - 1];
                }
            }
        }

        return array[0][0];
    }

    /**
     * Method which solves problem 19 using helper method and for loops
     * @param begin the starting year
     * @param end the ending year
     * @return sum of all Mondays that happens in the first month between the begin and the end year.
     */
    public static int countingSundays(int begin, int end)
    {
        int weekDay = 0;
        int sum = 0;

        for (int i = begin; i <= end; i++)
        {
            weekDay = ProjectHelper.startDayFinder(i);

            for (int month = 0; month < 12; month++)
            {
                if (weekDay == 6)
                {
                    sum++;
                }

                if (month == 1)
                {
                    if (i % 4 == 0)
                    {
                        weekDay = (weekDay + 29) % 7;
                    }
                    else
                    {
                        weekDay = (weekDay + 28) % 7;
                    }
                }

                else if (month == 3 || month == 5 || month == 8 || month == 10)
                {
                    weekDay = (weekDay + 30) % 7;
                }
                else
                {
                    weekDay = (weekDay + 31) % 7;
                }
            }
        }

        return sum;
    }

    /**
     * Method which solves problem 20 using BigInteger and loops
     * @param n the number that will do the factorial
     * @return the sum of digit of n!
     */
    public static int factorialDigitSum (int n)
    {

        BigInteger sum = BigInteger.valueOf(n);
        int output = 0;

        for (int i = n - 1; i > 1; i--)
        {
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        String result = sum.toString();

        for (int j = 0; j < result.length(); j++)
        {
            output += Integer.valueOf(result.substring(j, j + 1));
        }

        return output;
    }

    /**
     * Method which solves problem 21 using loops and factorFinder()
     * @param max the max
     * @return the sum of all amicable numbers below max
     */
    public static int amicableNumbers(int max)
    {
        ArrayList<Integer> current = new ArrayList<Integer>();
        int sum = 0;
        int amicable = 0;
        int amicableReverse = 0;
        boolean[] array = new boolean[max];

        for (int i = 1; i < array.length; i++)
        {
            if (!array[i]){
                current = ProjectHelper.factorFinder(i);
                for (int j = 0; j < current.size(); j++)
                {
                    amicable += current.get(j);
                }

                current = ProjectHelper.factorFinder(amicable);
                for (int k = 0; k < current.size(); k++)
                {
                    amicableReverse += current.get(k);
                }

                if (i != amicable && i == amicableReverse && amicable < max)
                {
                    sum = sum + i + amicable;
                    array[amicable] = true;
                }
                amicable = 0;
                amicableReverse = 0;
            }
        }

        return sum;
    }

    /**
     * Method which solves problem 22 using loops and insertion sort
     * @param list the list of strings
     * @return the sum of string scores
     */
    public static int nameScores(ArrayList<String> list)
    {
        String current = "";
        int score = 0;
        int sum = 0;

        for (int j = 0; j < list.size(); j++)
        {
            current = list.get(j);
            int previous = j - 1;

            while ((previous >- 1) && (list.get(previous).compareTo(current) > 0))
            {
                list.set(previous + 1, list.get(previous));
                previous--;
            }

            list.set(previous + 1, current);
        }
        
        for (int k = 0; k < list.size(); k++)
        {
            score = 0;
            current = list.get(k);
            
            for (char letter : current.toCharArray())
            {
                if (Character.isUpperCase(letter))
                {
                    score += letter - ('A' - 1);
                }
            }
            
            score *= (k + 1);
            sum += score;
        }

        return sum;
    }
}
