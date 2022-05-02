package org.ross;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    ArrayList<String> board = new ArrayList<>(Arrays.asList("","","","","","","","",""));
    ArrayList<String> displayBoard = new ArrayList<>(Arrays.asList(	"☐","☐","☐","☐","☐","☐","☐","☐","☐"));
    boolean isPositionEmpty;

    public String getTokenAtPos(int position) {
        String token = board.get(position - 1);
        return token;
    }

    public void setTokenAtPos(int position, String token) {
        board.set(position - 1,token);
        displayBoard.set(position - 1, token);
    }

    public ArrayList<String> getTokensAtAllPos() {
        return board;
    }

    public void startingBoard() {
        System.out.println("\nThe choices you have available:");
        System.out.printf("%s|%s|%s\n", 1, 2, 3);
        System.out.printf("%s|%s|%s\n", 4, 5, 6);
        System.out.printf("%s|%s|%s\n", 7, 8, 9);
    }

    public void displayBoard() {
        System.out.println("\nThe current state of play:");
        System.out.printf("%s|%s|%s\n", displayBoard.get(0), displayBoard.get(1), displayBoard.get(2));
        System.out.printf("%s|%s|%s\n", displayBoard.get(3), displayBoard.get(4), displayBoard.get(5));
        System.out.printf("%s|%s|%s\n", displayBoard.get(6), displayBoard.get(7), displayBoard.get(8));
    }

    public boolean isPosEmpty(int position) {
        isPositionEmpty = true;
        if(!board.get(position - 1).equals("")) {
            isPositionEmpty = false;
        }
        return isPositionEmpty;
    }
}