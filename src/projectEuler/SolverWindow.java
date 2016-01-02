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
public class SolverWindow {

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
        
        while (scan.hasNextLine())
        {
            index++;
            list2D.add(new ArrayList<Integer>());
            line = scan.nextLine();
            for (String s : line.split(" "))
            {
                list2D.get(index).add(Integer.parseInt(s));
            }
        }
        
        int[][] array2D = new int[list2D.size()][list2D.get(0).size()];
        
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
     * Method which reads in the file and convert it into a arraylist of string
     * @param fileName the file that will be reading in
     * @return the arraylist of string
     * @throws FileNotFoundException exception in which the file is not at the location
     */
    @SuppressWarnings("resource")
    public static ArrayList<String> stringArrayReader(String fileName) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(fileName));
        ArrayList<String> output = new ArrayList<String>();
        
        while (scan.hasNextLine())
        {
            output.add(scan.nextLine());
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
        System.out.println(LevelOneToTwentyFive.highlyDivisibleTriNum(6));
    }
}