package org.ross;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class GameTest {

    Game game = new Game();
    Board board = new Board();
    Player playerX = new Player("X", board);
    Player playerO = new Player("O", board);
    Game spyGame = game;
    Player spyPlayer = spy(game.activePlayer);

//    @Test
//    public void fullGameRunThrough() {
//        spyGame.playNewGame();
//        doReturn(1).when(spyGame.activePlayer.chooseMove("X"));
//        doReturn(4).when(spyGame.activePlayer.chooseMove("O"));
//        doReturn(2).when(spyGame.activePlayer.chooseMove("X"));
//        doReturn(5).when(spyGame.activePlayer.chooseMove("O"));
//        doReturn(3).when(spyGame.activePlayer.chooseMove("X"));
//        assertTrue(spyGame.activePlayer.winCheck());
//    }

    @Test
    public void canChangeTurn() {
        game.activePlayer = playerX;
        game.newTurn();
        Assert.assertEquals(playerO.token, game.activePlayer.token);
    }

    @Test
    public void playerThatCanOnlyDrawIdentified() {
        playerX.playToken(board,1);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,2);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,3);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,5);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,8);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        assertTrue(playerO.playerCanOnlyDraw);
    }

    @Test
    public void drawAnnouncedPermutationOne() {
        Player inGamePlayerX = game.playerX;
        Player inGamePlayerO = game.playerO;
        inGamePlayerX.playToken(board,1);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,3);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,5);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,9);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,6);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,4);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,8);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,2);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        assertTrue(game.drawCheck());
    }

    @Test
    public void drawAnnouncedPurmutationTwo() {
        Player inGamePlayerX = game.playerX;
        Player inGamePlayerO = game.playerO;
        inGamePlayerX.playToken(board,1);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,4);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,5);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,9);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,8);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,2);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,7);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board,3);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board,6);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        assertTrue(game.drawCheck());
    }

    @Test
    public void assertNoPlayerDrawYet() {
        playerX.playToken(board,1);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,2);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,3);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        playerX.playToken(board,5);
        playerO.canPlayerOnlyDraw(playerX.getPositions(), playerX.getPositions().size() - 1);
        assertFalse(playerO.playerCanOnlyDraw);
    }

    @Test
    public void drawNotFound() {
        Player inGamePlayerX = game.playerX;
        Player inGamePlayerO = game.playerO;
        inGamePlayerX.playToken(board, 1);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board, 3);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board, 5);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board, 9);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        inGamePlayerX.playToken(board, 6);
        inGamePlayerO.canPlayerOnlyDraw(inGamePlayerX.getPositions(), inGamePlayerX.getPositions().size() - 1);
        inGamePlayerO.playToken(board, 4);
        inGamePlayerX.canPlayerOnlyDraw(inGamePlayerO.getPositions(), inGamePlayerO.getPositions().size() - 1);
        assertFalse(game.drawCheck());
    }

    @Test
    public void winIsAnnounced() {

    }
}
