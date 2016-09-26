package projectEuler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which consists of the main methods that use to show the answer
 * @author Li Huang
 * @version 12.21.2015
 */
public class SolverWindow extends ProjectHelper{

    /**
     * Method which reads in the file and convert it into 2d array of integer
     * @param fileName the file that will be reading in
     * @return the 2d array
     * @throws FileNotFoundException exception in which the file is not at the location
     */
    @SuppressWarnings("resource")
    public static int[][] gridReader(String fileName)
            throws FileNotFoundException
    {
        ArrayList<ArrayList<Integer>> list2D = new ArrayList<ArrayList<Integer>>();

        Scanner scan = new Scanner(new File(fileName));
        int index = -1;
        String line = "";

        int rowLength = 0;
        int maxLength = 0;

        while (scan.hasNextLine())
        {
            index++;
            list2D.add(new ArrayList<Integer>());
            line = scan.nextLine();
            for (String s : line.split(" "))
            {
                list2D.get(index).add(Integer.parseInt(s));
                rowLength++;
            }
            if (maxLength < rowLength)
            {
                maxLength = rowLength;
            }

            rowLength = 0;
        }

        int[][] array2D = new int[list2D.size()][maxLength];

        for (int i = 0; i < list2D.size(); i++)
        {
            ArrayList<Integer> row = list2D.get(i);
            for (int j = 0; j < row.size(); j++)
            {
                if (row.get(j) != null)
                {
                    array2D[i][j] = row.get(j).intValue();
                }
            }
        }

        return array2D;
    }

    /**
     * Method which reads in the file and convert it into a array list of string
     * @param fileName the file that will be reading in
     * @return the array list of string
     * @throws FileNotFoundException exception in which the file is not at the location
     */
    @SuppressWarnings("resource")
    public static ArrayList<String> stringArrayReader(String fileName) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<String> output = new ArrayList<String>();

        String current = "";

        while (scan.hasNextLine())
        {
            current = scan.nextLine();
            for (String s : current.split(","))
            {
                output.add(s);
            }
        }

        return output;  
    }

    /**
     * The main method that gives the answer by calling other methods
     * @param arg the input argument
     * @throws FileNotFoundException 
     */
    public static void main (String[]   arg) throws FileNotFoundException
    {   
        //System.out.println(LevelTwentySixToFifty.distinctPowers(100));
        //System.out.println(Arrays.deepToString(array));

        /**
        ArrayList<Integer> list = properFactorFinder(12);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
         **/

        //System.out.println(Integer.toBinaryString(117));
        System.out.println(LevelTwentySixToFifty.reciprocalCycles(1000));

    }
}