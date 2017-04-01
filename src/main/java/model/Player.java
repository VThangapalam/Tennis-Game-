package model;

/**
 * Created by vaishnavithangapalam on 4/1/17.
 */
public class Player {

    private int playerId;
    private Score score;

    public Player(int playerId) {
        this.playerId = playerId;
        //by default set the point to love when a new player is created
        this.score = Score.love;
    }

    //private String playerName;

    //for future enhancement to implement sets
    //private int sets
    //private int games

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }


}
