package Tasks;

import java.io.IOException;

public interface Task {

    public void add() throws IOException;

    public void edit() throws IOException;

    public void print() throws IOException;

    public void printlist() throws IOException;

    public void search() throws IOException;

    public void sort() throws IOException;

    public void delete() throws IOException;

}
