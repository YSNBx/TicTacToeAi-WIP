package tictactoe.gameengine;

import tictactoe.playerconstants.PlayerTurnEnums;
import tictactoe.ui.SuperInterface;
import tictactoe.components.Ai;
import tictactoe.components.GameGrid;

import java.util.Scanner;

public class AiVersusPlayer implements SuperInterface {
    private final Scanner scanner;
    private GameGrid gameGrid;
    private char playerTurn;
    private Ai artificialPlayer;

    public AiVersusPlayer(GameGrid gameGrid, Ai artificialPlayer, Scanner scanner) {
        this.scanner = scanner;
        this.gameGrid = gameGrid;
        gameGrid.initGrid();
        this.playerTurn = PlayerTurnEnums.PLAYER_X.getTurn();
        this.artificialPlayer = artificialPlayer;
    }

    @Override
    public void start() {
        while (true) {
            this.gameGrid.printGrid();
            
            if (this.isGameFinished()) {
                break;
            }

            if (this.playerTurn == PlayerTurnEnums.PLAYER_X.getTurn()) {
                this.turnForX();
                this.changePlayer(PlayerTurnEnums.PLAYER_O.getTurn());
            } else {
                this.turnForO();
                this.changePlayer(PlayerTurnEnums.PLAYER_X.getTurn());
            }
            this.gameGrid.increaseNumberOfFields();
        }
    }

    public void turnForO() {
        System.out.println("Enter the coordinates: ");

        int[] coordinates = this.checkInput();
        this.checkSpotAndMakeMove(coordinates);
    }

    public void turnForX() {
        System.out.println("Making move level \"easy\"");

        this.makeMoveIfPossible();
    }

    public int[] checkInput() {
        String[] input = scanner.nextLine().split("\\s");
        int[] coordinates = new int[2];

        try {
            coordinates[0] = Integer.parseInt(input[0]) - 1;
            coordinates[1] = Integer.parseInt(input[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            this.checkInput();
        }

        return coordinates;
    }

    public void makeMoveIfPossible() {
        int[] coordinates = this.artificialPlayer.generateCoordinates();
        int firstCoordinate = coordinates[0];
        int secondCoordinate = coordinates[1];

        if (this.gameGrid.getBoard()[firstCoordinate][secondCoordinate] == '_') {
            this.gameGrid.setBoard(firstCoordinate, secondCoordinate, this.playerTurn);
        } else {
            this.makeMoveIfPossible();
        }
    }

    public void checkSpotAndMakeMove(int[] coordinates) {
        if (this.gameGrid.getBoard()[coordinates[0]][coordinates[1]] != '_') {
            this.printErrorAndAskAgain();
        } else {
            this.gameGrid.setBoard(coordinates[0], coordinates[1], this.playerTurn);
        }
    }

    public void printErrorAndAskAgain() {
        System.out.println("This cell is occupied! Choose another one!");
        this.turnForX();
    }

    public void changePlayer(char turn) {
        this.playerTurn = turn;
    }

    //early version checkgamestate because i'm too lazy right now

    public boolean isGameFinished() {
        if (this.gameGrid.getBoard()[0][0] == 'X' && this.gameGrid.getBoard()[0][1] == 'X' && this.gameGrid.getBoard()[0][2] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[1][0] == 'X' && this.gameGrid.getBoard()[1][1] == 'X' && this.gameGrid.getBoard()[1][2] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[2][0] == 'X' && this.gameGrid.getBoard()[2][1] == 'X' && this.gameGrid.getBoard()[2][2] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][0] == 'O' && this.gameGrid.getBoard()[0][1] == 'O' && this.gameGrid.getBoard()[0][2] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[1][0] == 'O' && this.gameGrid.getBoard()[1][1] == 'O' && this.gameGrid.getBoard()[1][2] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[2][0] == 'O' && this.gameGrid.getBoard()[2][1] == 'O' && this.gameGrid.getBoard()[2][2] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][0] == 'X' && this.gameGrid.getBoard()[1][0] == 'X' && this.gameGrid.getBoard()[2][0] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][1] == 'X' && this.gameGrid.getBoard()[1][1] == 'X' && this.gameGrid.getBoard()[2][1] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][2] == 'X' && this.gameGrid.getBoard()[1][2] == 'X' && this.gameGrid.getBoard()[2][2] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][0] == 'O' && this.gameGrid.getBoard()[1][0] == 'O' && this.gameGrid.getBoard()[2][0] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][1] == 'O' && this.gameGrid.getBoard()[1][1] == 'O' && this.gameGrid.getBoard()[2][1] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][2] == 'O' && this.gameGrid.getBoard()[1][2] == 'O' && this.gameGrid.getBoard()[2][2] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][0] == 'X' && this.gameGrid.getBoard()[1][1] == 'X' && this.gameGrid.getBoard()[2][2] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][2] == 'X' && this.gameGrid.getBoard()[1][1] == 'X' && this.gameGrid.getBoard()[2][0] == 'X') {
            System.out.println("X wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][0] == 'O' && this.gameGrid.getBoard()[1][1] == 'O' && this.gameGrid.getBoard()[2][2] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getBoard()[0][2] == 'O' && this.gameGrid.getBoard()[1][1] == 'O' && this.gameGrid.getBoard()[2][0] == 'O') {
            System.out.println("O wins\n");
            return true;
        }

        if (this.gameGrid.getFilledFields() == 9) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}
