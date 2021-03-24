import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Operation p = new Operation(2, 11, 2003, "Богдан", "Ткачук", 1, 500, 1000);
            System.out.println(p.toString());
            p.input();
            System.out.println(p.toString());
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

