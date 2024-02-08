package Command;

import Ping.TaskList;
import Ping.UI;


/**
 * This class is used to find the tasks
 */
public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String ... keyword) {
        this.keyword = String.join(" ", keyword);
    }

    @Override
    public String perform(TaskList tasks, UI ui) {
        return ui.findTaskMessage(tasks.findTasks(keyword));
    }
    
}
