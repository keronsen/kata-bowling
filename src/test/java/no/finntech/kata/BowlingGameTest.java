package no.finntech.kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public final class BowlingGameTest {

    @Test
    public void scoreShouldMatchPinsAfterFirstRoll() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        assertThat(game.score()).isEqualTo(5);
    }

    @Test
    public void scoreShouldMatchPinsAfterSecondRoll() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 3,5);
        assertThat(game.score()).isEqualTo(8);
    }

    @Test
    public void shouldScoreSpareAsTen() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 4,6);
        assertThat(game.score()).isEqualTo(10);
    }

    @Test
    public void shouldScoreSpareCorrectlyAfterNextRoll() {
        BowlingGame game = new BowlingGame();

        scoreSeries(game, 4,6, 3);
        assertThat(game.score()).isEqualTo(13 + 3);
    }

    @Test
    public void shouldScoreSpareInFrameTwoCorrectlyAfterNextRoll() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 1,5, 4,6, 3);
        assertThat(game.score()).isEqualTo(6 + 13 + 3);
    }

    @Test
    public void shouldScoreTwoSpares() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 4,6, 7,3, 1);
        assertThat(game.score()).isEqualTo(6 + 17 + 11 + 1);
    }

    @Test
    public void shouldScoreOneStrikeInVeryFirstRoll() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 10);
        assertThat(game.score()).isEqualTo(10);
    }


    @Test
    public void shouldScoreOneStrike() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 10, 3,2);
        assertThat(game.score()).isEqualTo(6 + 15 + 5);
    }

    @Test
    public void shouldScoreTwoStrike() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 10, 10, 3,2);
        assertThat(game.score()).isEqualTo(6 + 23 + 15 + 5);
    }

    @Test
    public void shouldScoreSpareBetweenStrikes() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 10, 1,9, 10, 2,3);
        assertThat(game.score()).isEqualTo(6 + 20 + 20 + 15 + 5);
    }

    @Test
    public void shouldScoreFourStrikes() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 10, 10, 10, 10, 2,3);
        assertThat(game.score()).isEqualTo(6 + 30 + 30 + 22 + 15 + 5);
    }

    @Test
    public void shouldScoreSpareEndGame() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 2,3, 2,2, 3,4, 5,1, 2,4, 2,2, 3,1, 2,2, 1,9,3);
        assertThat(game.score()).isEqualTo(6 + 5 + 4 + 7 + 6 + 6 + 4 + 4 + 4 + 13);
    }

    @Test
    public void shouldScoreStrikeEndGame() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2,4, 2,3, 2,2, 3,4, 5,1, 2,4, 2,2, 3,1, 2,2, 10,10,10);
        assertThat(game.score()).isEqualTo(6 + 5 + 4 + 7 + 6 + 6 + 4 + 4 + 4 + 30);
    }

    @Test
    public void shouldScorePerfectGame() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10,10);
        assertThat(game.score()).isEqualTo(300);
    }


    private void scoreSeries(BowlingGame game, int ... rolls) {
        for (int roll : rolls) {
            game.roll(roll);
        }
    }
}
