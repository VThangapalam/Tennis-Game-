package model;

/**
 * Created by vaishnavithangapalam on 4/1/17.
 */
public enum Score {

    love("love"),
    fifteen("fifteen"),
    thirty("thirty"),
    forty("forty"),
    advantage("advantage"),
    deuce("deuce"),
    game("game");


    private String value;

    private Score(String value) {
        this.value = value;
    }


}
