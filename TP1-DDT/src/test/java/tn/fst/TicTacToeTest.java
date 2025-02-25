package tn.fst;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
    private TicTacToe game;

    @Before
    public void setup() {
        game = new TicTacToe();
    }

    @Test(expected = RuntimeException.class)
    public void testPlay_OutOfBoundsX() {
        game.play(3, 1);
    }

    @Test(expected = RuntimeException.class)
    public void testPlay_OutOfBoundsY() {
        game.play(1, 3);
    }

    @Test(expected = RuntimeException.class)
    public void testPlay_OccupiedCell() {
        game.play(1, 1);
        game.play(1, 1);
    }

    @Test
    public void testFirstPlayerIsX() {
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testPlayersAlternate() {
        game.play(0, 0);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    public void testWinningCondition_Row() {
        game.play(0, 0); // X
        game.play(1, 0); // O
        game.play(0, 1); // X
        game.play(1, 1); // O
        game.play(0, 2); // X wins
        assertEquals("Player X wins!", game.getGameState());
    }

    @Test
    public void testWinningCondition_Column() {
        game.play(0, 0); // X
        game.play(0, 1); // O
        game.play(1, 0); // X
        game.play(1, 1); // O
        game.play(2, 0); // X wins
        assertEquals("Player X wins!", game.getGameState());
    }

    @Test
    public void testWinningCondition_Diagonal1() {
        game.play(0, 0); // X
        game.play(0, 1); // O
        game.play(1, 1); // X
        game.play(0, 2); // O
        game.play(2, 2); // X wins
        assertEquals("Player X wins!", game.getGameState());
    }

    @Test
    public void testWinningCondition_Diagonal2() {
        game.play(0, 2); // X
        game.play(0, 1); // O
        game.play(1, 1); // X
        game.play(1, 0); // O
        game.play(2, 0); // X wins
        assertEquals("Player X wins!", game.getGameState());
    }

    @Test
    public void testGameDraw() {
        game.play(0, 0); // X
        game.play(0, 1); // O
        game.play(0, 2); // X
        game.play(1, 1); // O
        game.play(1, 0); // X
        game.play(1, 2); // O
        game.play(2, 1); // X
        game.play(2, 0); // O
        game.play(2, 2); // X
        assertEquals("Draw!", game.getGameState());
    }
}