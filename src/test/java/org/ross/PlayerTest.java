package org.ross;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PlayerTest {
    Board board = new Board();
    Player playerX = new Player("X", board);
    Player playerO = new Player("O", board);
    Player spyPlayer = spy(playerX);

    @Test
    public void canPlayerChooseToken() {
        String token = "X";
        doReturn(5).when(spyPlayer).moveSelection("X", System.in);
        assertEquals(5, spyPlayer.chooseMove(token));
    }

//    @Test
//    public void canPositionSelectionBeMade() {
//        byte[] choice = new byte[]{5};
//        ByteArrayInputStream choiceStream = new ByteArrayInputStream(choice);
//        assertEquals(5, playerX.moveSelection("X", choiceStream));
//    }

//    @Test
//    public void playerCantChooseAboveNine() {
//        String token = "X";
//        System.setOut(new PrintStream(outputStreamCaptor));
//        doReturn(10).when(spyPlayer).moveSelection(token, System.in);
//        spyPlayer.chooseMove(token);
//        assertEquals("Number too BIG. Try again.", outputStreamCaptor.toString().trim());
//        System.setOut(standardOut);
//    }

    @Test
    public void canPlayerXPlayToken(){
        playerX.playToken(board, 1);
        assertEquals("X", board.getTokenAtPos(1));
    }

    @Test
    public void canPlayerOPlayToken(){
        playerX.playToken(board, 1);
        playerO.playToken(board, 1);
        assertEquals("X", board.getTokenAtPos(1));
    }

    @Test
    public void playerCanRetainMultiplePositions() {
        playerX.playToken(board,1);
        playerX.playToken(board,2);
        playerX.playToken(board,3);
        int[] expectedArray = new int[]{0,1,2};
        int[] actualArray = new int[3];
        for(int i = 0; i < 3; i++) {
            actualArray[i] = playerX.getPositions().get(i);
        }
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(actualArray));
    }

    @Test
    public void winnerIsFound() {
        playerX.playToken(board,1);
        playerX.playToken(board,5);
        playerX.playToken(board,9);
        assertTrue(playerX.winCheck());
    }
}
