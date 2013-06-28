package no.finntech.kata;


public class BowlingGame {


    int[][] frames = new int[12][2];
    boolean firstRoll = true;
    int frameIndex = 0;

    public void roll(int pins) {
        frames[frameIndex][firstRoll ? 0 : 1] = pins;
        if(firstRoll && pins != 10) {
            firstRoll = false;
        } else {
            firstRoll = true;
            frameIndex++;
        }
    }

    public int score() {
        int score = 0;
        for(int i = 0; i < 10; i++) {
            if(strike(i)) {
                if (strike(i + 1)) {
                    score += 10 + 10 + frames[i+2][0];
                } else {
                    score += 10 + frames[i+1][0] + frames[i+1][1];
                }
            } else if(spare(i)) {
                score += 10 + frames[i+1][0];
            } else {
                score += frames[i][0] + frames[i][1];
            }
        }
        return score;
    }

    private boolean spare(int i) {
        return frames[i][0] + frames[i][1] == 10;
    }

    private boolean strike(int i) {
        return frames[i][0] == 10;
    }
}
