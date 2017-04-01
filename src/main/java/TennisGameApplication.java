import model.Player;
import model.Score;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import utiility.ScoreCalculationUtility;

import java.util.Scanner;

/**
 * Created by vaishnavithangapalam on 4/1/17.
 */
public class TennisGameApplication {


    public static void main(String[] args) throws Exception {


        System.out.println("Enter a sequence of player ids' who win each point ");
        //Example for  player1 player2 player1  player1
        //Enter the sequence 1 2 1 1
        //Note: Input of player id can be either 1 or 2 only
        String str;
        Scanner readIn = new Scanner(System.in);
        str = readIn.nextLine();
        String[] numSequence = str.trim().split("\\s+");
        int[] scoreArray = new int[numSequence.length];
        for(int i = 0; i < numSequence.length; i++) {

            scoreArray[i] = Integer.parseInt(numSequence[i]);
            if(scoreArray[i] != 1 &&  scoreArray[i] != 2 ) {
               throw  new Exception("Invalid player id !"+scoreArray[i] +" only 1 or 2 allowed" );
            }

        }

        //intialize players
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        Score[] finalScores = ScoreCalculationUtility.getPlayersScores(scoreArray);
        if(finalScores[0].equals(Score.game)) {
            System.out.println("********Winner : Player 1");
        } else if (finalScores[1].equals(Score.game)) {
            System.out.println("********Winner : Player 2");
        }
        else {
            System.out.println("Game still in progress!");
        }


    }




}
