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
    public static int problemOne(int x, int y, int stop)
    {
        stop = stop - 1;
        
        int nOne = stop / x;
        int nTwo = stop / y;
        int nThree = stop / (x * y);
        
        int sumOne = (nOne * (nOne + 1)) / 2 * x;
        int sumTwo = (nTwo * (nTwo + 1)) / 2 * y;
        int sumThree = (nThree * (nThree + 1)) / 2 * (x * y);
        
        int outPut = sumOne + sumTwo - sumThree;
        
        return outPut;
    }
    
}
