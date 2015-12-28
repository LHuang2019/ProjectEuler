package projectEuler;
;
/**
 * Class which consists of the main methods that use to show the answer
 * @author Li Huang
 * @version 12.21.2015
 */
public class SolverWindow {
    
    /**
     * The main method that gives the answer by calling other methods
     * @param arg the input argument
     */
    public static void main (String[]   arg)
    {
        System.out.println(LevelOneToTwentyFive.largestProductInSeries(
                "731671765313306249192251196744265747423553491949349698"
                + "3520312774506326239578318016984801869478851843858615"
                + "6078911294949545950173795833195285320880551112540698"
                + "7471585238630507156932909632952274430435576689664895"
                + "0445244523161731856403098711121722383113622298934233"
                + "8030813533627661428280644448664523874930358907296290"
                + "4915604407723907138105158593079608667017242712188399"
                + "8797908792274921901699720888093776657273330010533678"
                + "8122023542180975125454059475224352584907711670556013"
                + "6048395864467063244157221553975369781797784617406495"
                + "5149290862569321978468622482839722413756570560574902"
                + "6140797296865241453510047482166370484403199890008895"
                + "2434506585412275886668811642717147992444292823086346"
                + "5674813919123162824586178664583591245665294765456828"
                + "4891288314260769004224219022671055626321111109370544"
                + "2175069416589604080719840385096245544436298123098787"
                + "9927244284909188845801561660979191338754992005240636"
                + "8991256071760605886116467109405077541002256983155200"
                + "05593572972571636269561882670428252483600823257530420752963450", 13));
    }
}