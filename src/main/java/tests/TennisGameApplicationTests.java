package tests;

import model.Score;
import org.junit.Assert;
import org.junit.Test;

import utiility.ScoreCalculationUtility;

/**
 * Created by vaishnavithangapalam on 4/1/17.
 */
public class TennisGameApplicationTests {

    @Test
    public void test_getNextScore() {
        //testing the score calculation - current player(first in argument) gets point , intial score love, love
        Score testScore1 = ScoreCalculationUtility.getNextScore(Score.love, Score.love);
        Assert.assertTrue(testScore1.equals(Score.fifteen));


        //testing the score calculation - current player(first in argument) gets point, intial score forty, forty
        Score testScore2 = ScoreCalculationUtility.getNextScore(Score.forty, Score.forty);
        Assert.assertTrue(testScore2.equals(Score.advantage));


        //testing the score calculation - current player (first in argument)gets point, intial score thirty, forty
        Score testScore3 = ScoreCalculationUtility.getNextScore(Score.thirty, Score.forty);
        Assert.assertTrue(testScore3.equals(Score.deuce));


        //testing the score calculation - current player(first in argument) gets point intial score thirty, forty
        Score testScore4 = ScoreCalculationUtility.getNextScore(Score.forty, Score.thirty);
        Assert.assertTrue(testScore4.equals(Score.game));

    }


    @Test
    public void test_getPlayersScores() {
        int[] scoreSequence1 = {1,1,1,2};
        //test scores
        Score scores1[] = ScoreCalculationUtility.getPlayersScores(scoreSequence1);
        Assert.assertTrue(scores1[0].equals(Score.forty) && scores1[1].equals(Score.fifteen));

        //test game
        int[] scoreSequence2 = {1,1,2,1,1};
        Score scores2[] = ScoreCalculationUtility.getPlayersScores(scoreSequence2);
        Assert.assertTrue(scores2[0].equals(Score.game) && scores2[1].equals(Score.fifteen));


        //test deuce
        int[] scoreSequence3 = {1,1,1,2,2,2};
        Score scores3[] = ScoreCalculationUtility.getPlayersScores(scoreSequence3);
        Assert.assertTrue(scores3[0].equals(Score.deuce) && scores3[1].equals(Score.deuce));


        //test advantage
        int[] scoreSequence4 = {1,1,1,2,2,2,1};
        Score scores4[] = ScoreCalculationUtility.getPlayersScores(scoreSequence4);
        Assert.assertTrue(scores4[0].equals(Score.advantage) && scores4[1].equals(Score.forty));





    }
}
