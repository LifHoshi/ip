// Some of the code modified from the JavaFX tutorial
package Ping;

import Command.Command;



/**
 * This class is used to run the program
 */
public class Ping {
    private UI ui;

    private TaskList tasks;
    /**
     * This is the constructor of the Ping class
     */
    public Ping() throws PingException {
        try {
            this.ui = new UI();
            this.tasks = new TaskList(Storage.loadFiles());
        } catch (PingException e) {
            throw new PingException("An error occurred while loading the file");
        }
    }

    public String getResponse(String input) throws PingException {
        try {
            Command com = Parser.parseCommand(tasks, input);
            Storage.saveFiles(tasks.allTasks());
            return com.perform(tasks, ui);
        } catch (NullPointerException | PingException e) {
            return e.getMessage();
        }
    }
    /**
     * This method is used to run the program
     */
    public void run() throws PingException {
        ui.welcome();
        boolean isRun = true;
        while (isRun) {
            try {
                String lines = ui.readLines();
                Command cmd = Parser.parseCommand(tasks, lines);
                cmd.perform(tasks, ui);
                isRun = cmd.isRunning();
            } catch (PingException e) {
                ui.showError(e.getMessage());
            }
            Storage.saveFiles(tasks.allTasks());
        }


    }

    public static void main(String[] args) throws PingException {
        try {
            new Ping().run();
        } catch (PingException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
