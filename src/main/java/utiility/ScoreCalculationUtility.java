package utiility;

import model.Score;

/**
 * Created by vaishnavithangapalam on 4/1/17.
 */
public class ScoreCalculationUtility {

    /**
     * Returns the score point of a player given his current scorepoint and the opponents score
     * @param currentPoint
     * @param currentPointOther
     * @return
     */

        public static Score getNextScore(Score currentPoint,Score currentPointOther) {

            if(currentPoint.equals(Score.love)) {
                return Score.fifteen;

            }
            if(currentPoint.equals(Score.fifteen)) {
                return  Score.thirty;

            }

            if(currentPoint.equals(Score.thirty)) {
                 if(currentPointOther.equals(Score.forty)) {
                     return Score.deuce;
                 }
                 return Score.forty;


            }

            if(currentPoint.equals(Score.forty)) {
                if(currentPointOther.equals(Score.forty)) {
                    return Score.advantage;
                }
                if(currentPointOther.equals(Score.advantage)) {
                    return Score.deuce;
                }
                if(currentPointOther.equals(Score.love) || currentPointOther.equals(Score.fifteen) || currentPointOther.equals(Score.thirty)) {
                    return Score.game;
                }
            }


            if(currentPoint.equals(Score.deuce)) {
                return Score.advantage;
            }

            if(currentPoint.equals(Score.advantage)) {

                return Score.game;
            }

            return null;

        }

    /**
     * Returns the scores of the two players given a sequence of the player ids who win each point
     * @param scoreSequence
     * @return
     */

    public static Score[] getPlayersScores(int[] scoreSequence) {
        Score[] scores = new Score[2];
        //player1 score
        scores[0] = Score.love;
        //player2 score
        scores[1] = Score.love;

        for (int i =0; i < scoreSequence.length; i++) {
            //if player1 scored the current point in Sequence
            if(scoreSequence[i] == 1) {
                scores[0]= getNextScore(scores[0], scores[1]);
                if(scores[0].equals(Score.deuce)) {
                    scores[1]= Score.deuce;
                }
                else if(scores[0].equals(Score.advantage)) {
                    scores[1]= Score.forty;
                }
            }
            //if player 2 scored the current score
            else {
                scores[1]= getNextScore(scores[1], scores[0]);
                if(scores[1].equals(Score.deuce)) {
                    scores[0]= Score.deuce;
                }
                else if(scores[1].equals(Score.advantage)) {
                    scores[0]= Score.forty;
                }
            }
            //return if any one player has already won the game
            if(scores[0].equals(Score.game) || scores[1].equals(Score.game)) {
                return scores;
            }

        }

        System.out.println("End of the given point sequence the players' scores are :");
        System.out.println("Player 1 "+ scores[0]);
        System.out.println("Player 2  "+ scores[1]);
        return scores;
    }
}
