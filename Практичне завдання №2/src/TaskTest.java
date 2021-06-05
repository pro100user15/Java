import org.junit.Test;

import static org.junit.Assert.*;
import java.io.IOException;

class TaskTest {

    @org.junit.Test
    void task1() {
        try {
            Task task = new Task();
            task.task1();
        }
        catch (IOException ex) {
            System.err.println("");
        }
    }

    @org.junit.Test
    void task_2() {
    }
}