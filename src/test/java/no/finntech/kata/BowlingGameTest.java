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
       scoreSeries(game, 3, 5);
        assertThat(game.score()).isEqualTo(8);
    }

    @Test
    public void shouldNotScoreSpareUntilNextFrame() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 4, 6);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void shouldScoreSpareCorrectlyAfterNextRoll() {
        BowlingGame game = new BowlingGame();

        scoreSeries(game, 4, 6, 3);
        assertThat(game.score()).isEqualTo(6 + 4 + (2 * 3));
    }

    @Test
    public void shouldScoreSpareInFrameTwoCorrectlyAfterNextRoll() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 1, 5, 4, 6, 3);
        assertThat(game.score()).isEqualTo(1 + 5 + 6 + 4 + (2 * 3));
    }

    @Test
    public void shouldScoreTwoSpares() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2, 4, 4, 6, 7, 3, 1);
        assertThat(game.score()).isEqualTo(2 + 4 + 10 + 7 + 10 + 1 + 1);
    }

    @Test
    public void shoulScoreOneStrikeInVeryFirstRoll() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 10);
        assertThat(game.score()).isEqualTo(0);
    }

    /*
    @Test
    public void shoulScoreOneStrike() {
        BowlingGame game = new BowlingGame();
        scoreSeries(game, 2, 4, 10, 3, 2);
        assertThat(game.score()).isEqualTo(6 + 15 + 3 + 2);
    }*/

    private void scoreSeries(BowlingGame game, int ... rolls) {
        for (int roll : rolls) {
            game.roll(roll);
        }
    }
}
