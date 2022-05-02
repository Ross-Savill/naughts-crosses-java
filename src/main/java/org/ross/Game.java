package org.ross;

public class Game {

    Board activeBoard = new Board();
    Player playerX = new Player("X", activeBoard);
    Player playerO = new Player("O", activeBoard);
    Player activePlayer = playerX;

    public void playNewGame() {
        activeBoard.startingBoard();
        while(true) {
            int chosenMove = activePlayer.chooseMove(activePlayer.token);
            boolean isTurnSuccessful = activePlayer.playToken(activeBoard, chosenMove);
            activeBoard.displayBoard();
            if(activePlayer.winCheck()) { break; }
            if(drawCheck()) { break; }
            if(isTurnSuccessful) { newTurn(); }
        }
    }

    public boolean drawCheck() {
        Player opponent = activePlayer.equals(playerO) ? playerX : playerO;
        if (!opponent.playerCanOnlyDraw && activePlayer.getPositions().size() > 0) {
            opponent.canPlayerOnlyDraw(activePlayer.getPositions(), activePlayer.getPositions().size() - 1);
        }
        if (playerX.playerCanOnlyDraw && playerO.playerCanOnlyDraw) {
            System.out.println("No Winner Possible! It's a Draw.");
            return true;
        }
        return false;
    }

    public void newTurn() {
        activePlayer = activePlayer.equals(playerO) ? playerX : playerO;
    }
}

