package org.ross;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    String token;
    Board board;
    int playerTokenCount;
    boolean playerCanOnlyDraw = false;
    ArrayList<Integer> movesIndexes = new ArrayList<>();
    ArrayList<int[]> remainingWinnableFormations = new ArrayList<>(Arrays.asList(new int[]{0, 1, 2}, new int[]{0, 4, 8}, new int[]{0, 3, 6}, new int[]{1, 4, 7}, new int[]{2, 4, 6}, new int[]{2, 5, 8}, new int[]{3, 4, 5}, new int[]{6, 7, 8}));

    public Player(String token, Board board) {
        this.token = token;
        this.board = board;
    }

    public ArrayList<Integer>getPositions() {
        return movesIndexes;
     }

    public int chooseMove(String playersToken) {
        while(true) {
            int candidateNumber = moveSelection(playersToken, System.in);
            // How do I test these two paths?
            if(candidateNumber < 1) {
                System.out.println("Number too SMALL. Try again.");
                continue;
            }
            if(candidateNumber > 9) {
                System.out.println("Number too BIG. Try again.");
                continue;
            }
            return candidateNumber;
        }
    }

    public int moveSelection(String playersToken, InputStream inputStream) {
        String name = "Player " + playersToken;
        while(true) {
            System.out.printf("\n%s, take your turn >", name);
            Scanner sc = new Scanner(inputStream);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            System.out.println("NOT A NUMBER. Try again.");
        }
    }

    public boolean playToken(Board board, int position) {
        if (!board.isPosEmpty(position)) {
            System.out.println("Position Already Taken. Go again.");
            return false;
        }
        board.setTokenAtPos(position, token);
        movesIndexes.add(position - 1);
        playerTokenCount++;
        return true;
    }

    public boolean winCheck() {
        if(playerTokenCount < 3) return false;
        ArrayList<Integer> currentPositions = getPositions();
        for(int[] winnablePositions : remainingWinnableFormations) {
            if(hasWinningPositions(currentPositions, winnablePositions)) {
                System.out.println("WINNER: PLAYER " + token);
                return true;
            }
        }
        return false;
    }

    public boolean hasWinningPositions(ArrayList<Integer> currentPositions, int[] winnableConfiguration) {
        int winCountdown = 3;
        for(int currentPosition : currentPositions) {
            for (int position : winnableConfiguration) {
                if (position == currentPosition) {
                    winCountdown--;
                }
                if (winCountdown == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void canPlayerOnlyDraw(ArrayList<Integer> oppositionPositions, int lastMoveIndex) {
        System.out.println("Token::::" + token);
        int newPosition = oppositionPositions.get(lastMoveIndex);
        ArrayList<int[]> toRemove = new ArrayList<>();
        for(int[] winnableFormation : remainingWinnableFormations) {
            for(int formationPosition : winnableFormation) {
                if (isFormationImpossible(formationPosition, newPosition)) {
                    toRemove.add(winnableFormation);
                    break;
                }
            }
        }
        remainingWinnableFormations.removeAll(toRemove);
        if(remainingWinnableFormations.size() == 0) {
            playerCanOnlyDraw = true;
        }
    }

    public boolean isFormationImpossible(int formationPosition, int oppositionPositionToCheck) {
        if(oppositionPositionToCheck == formationPosition) {
            return true;
        }
        return false;
    }
}