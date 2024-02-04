package duke;

import java.util.Scanner;


/**
 * Duke is a task management application that allows users to manage their tasks.
 * It provides a command-line interface for users to interact with their task list.
 */
public class Duke {
    private static final String FILE_PATH = "./data/duke.txt";

    private Ui ui;
    private Storage storage;


    /**
     * Enumeration representing possible commands in Duke.
     */





    private TaskList tasks;


    /**
     * Constructs a Duke instance with the specified file path.
     *
     * @param filePath The file path for loading and saving tasks.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(FILE_PATH);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Runs the Duke application, allowing users to interact with their task list.
     */
    public void run() {
        ui.showWelcomeMessage();

        Scanner sc = new Scanner(System.in);
        boolean isExit = false;

        while (!isExit) {
            try {

                Ui.Command userInput = ui.getUserInput();
                if (userInput.equals("Bye")) {
                    isExit = true;
                }
                Parser.parseAndExecute(userInput, tasks, ui, storage);
                storage.saveTasks(tasks.getTasks());
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }

        ui.showGoodbyeMessage();
    }

    /**
     * The main entry point for the Duke application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        new Duke("data/duke.txt").run();
    }
}
