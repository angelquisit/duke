import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import duke.tasks.TaskList;
import duke.ui.UI;
import duke.commands.FindCommand;
import duke.exceptions.DukeException;

public class FindCommandTest {
    @Test
    public void executeTest() throws DukeException{
        // Test set up
        TaskList t = new TaskList();
        UI ui = new UI();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        t.addToDo("duke week 10 increment");
        t.addDeadline("duke submission", LocalDate.parse("2023-10-19"));
        
        FindCommand f = new FindCommand("find project");
        f.execute(t, ui, null);

        assertEquals("You have no tasks with this keyword: project",outputStream.toString().trim());
    }   
}
