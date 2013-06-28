package no.finntech.kata;


public class BowlingGame {

    int frameScore = 0;
    int score = 0;
    int previousRoll = 0;
    boolean firstRoll = true;

    private boolean spare = false;


    public void roll(int pins) {
        frameScore += pins;
        score += pins;

        if(firstRoll && spare) {
            score = score + 10 + pins;
            spare = false;
        }

        if(!firstRoll && frameScore == 10) {
            spare = true;
            score -= 10;
        }

        if (firstRoll && frameScore == 10) {
            score -= 10;
        }

        if(firstRoll) {
            firstRoll = false;
        } else {
            frameScore = 0;
            firstRoll = true;
        }

        previousRoll = pins;
    }

    public int score() {
        return score;
    }
}
