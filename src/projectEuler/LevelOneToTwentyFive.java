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

        int outPut = sumOne + sumTwo - sumThree;

        return outPut;
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
        int outPut = 0;

        while (currentFib < max)
        {       
            int newFib = previousFib + currentFib;
            previousFib = currentFib;
            currentFib  = newFib;

            if (currentFib % 2 == 0)
            {
                outPut = outPut + currentFib;
            }
        }
        return outPut;
    }
}
