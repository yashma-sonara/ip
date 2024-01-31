package duke.task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class contains JUnit test cases to verify the functionality of the Todo class.
 */
public class TodoTest{
    @Test
    public void testInitialization() {
        Todo todo = new Todo("Buy groceries");
        assertEquals("[T][ ] Buy groceries", todo.toString());
    }


    @Test
    public void testToFileString() {
        Todo todo = new Todo("Complete assignment");
        assertEquals("T | 0 | Complete assignment", todo.toFileString());
    }
}
