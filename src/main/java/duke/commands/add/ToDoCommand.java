package duke.commands.add;

import duke.commands.Command;
import duke.constants.ErrorMessages;
import duke.constants.RegExp;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.UI;

public class ToDoCommand extends Command {
    String description;

    public ToDoCommand(String line) throws DukeException {
        if (line.split(RegExp.SPACE_DELIMITER).length < 2){
            throw new DukeException(ErrorMessages.MISSING_TODO_DESCRIPTION);
        }

        this.description = line.split(RegExp.SPACE_DELIMITER, 2)[1].trim();
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        Task t = tasks.addToDo(description);
        ui.showTaskAdded(t);
    }
}
