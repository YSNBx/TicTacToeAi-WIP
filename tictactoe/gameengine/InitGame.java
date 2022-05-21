package tictactoe.gameengine;

import java.util.Scanner;

import tictactoe.components.Ai;
import tictactoe.components.GameGrid;
import tictactoe.components.InterfaceController;

public class InitGame {
    private String choice;
    private InterfaceController interfaceController;
    private final Scanner scanner;

    public InitGame(Scanner scanner) {
        this.scanner = scanner;
        this.choice = null;
        this.interfaceController = new InterfaceController();
    }

    public void init() {
        while (true) {
            System.out.println("Input command: ");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }

            this.evaluateCommand(command);
        }
    }

    public void evaluateCommand(String command) {
        if (command.equals("start user easy")) {
            this.executePlayerFirst();
        } else if (command.equals("start easy user")) {
            this.executeAiFirst();
        } else if (command.equals("start easy easy")) {
            this.executeAiVsAi();
        } else {
            System.out.println("Bad parameters!");
            this.init();
        }
    }

    public void executePlayerFirst() {
        Ai ai = new Ai();
        GameGrid grid = new GameGrid();

        this.interfaceController.setInterface(new PlayerVersusAi(grid, ai, this.scanner));
        this.interfaceController.execute();
    }

    public void executeAiFirst() {
        Ai ai = new Ai();
        GameGrid grid = new GameGrid();

        this.interfaceController.setInterface(new AiVersusPlayer(grid, ai, this.scanner));
        this.interfaceController.execute();
    }

    public void executeAiVsAi() {

    }
}
