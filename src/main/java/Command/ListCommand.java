package Command;


import Ping.TaskList;
import Ping.UI;

/**
 * This class is used to list the tasks
 */
public class ListCommand extends Command {
    @Override
    public TaskList perform(TaskList tasks, UI ui) {
        ui.showList(tasks.allTasks());
        return tasks;
    }
}
