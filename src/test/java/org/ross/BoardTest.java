package org.ross;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    Board board = new Board();

    @Test
    public void canGetTokenAtPos() {
        board.getTokenAtPos(1);
        assertEquals("", board.getTokenAtPos(1));
    }

    @Test
    public void canSetTokenAtPos() {
        board.setTokenAtPos(1, "X");
        assertEquals("X", board.getTokenAtPos(1));
    }

    @Test
    public void boardIsUpdatedCorrectly() {
        ArrayList<String> expectedBoard = new ArrayList<>(Arrays.asList("X","O","X","O","","","","",""));
        board.setTokenAtPos(1, "X");
        board.setTokenAtPos(2, "O");
        board.setTokenAtPos(3, "X");
        board.setTokenAtPos(4, "O");
        assertEquals(expectedBoard, board.getTokensAtAllPos());
    }

    @Test
    public void canSeeIfPosEmpty() {
        assertTrue(board.isPosEmpty(1));
    }
}
