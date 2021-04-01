import TaskOne.Operation;
import TaskOne.OperationDate;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                //try {
                ArrayList<Operation> list = new ArrayList<Operation>();
                list.add(new Operation(2, 11, 2003, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2004, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2005, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2006, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2007, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2008, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2009, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2010, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2011, "Богдан", "Ткачук", 1, 500, 1000));
                list.add(new Operation(2, 11, 2012, "Богдан", "Ткачук", 1, 500, 1000));

                Operation p = new Operation();
                p.input();
                list.add(p);

                for (Operation operation : list) {
                        System.out.println(operation.toString());
                }

                /*OperationDate begdate = new OperationDate(2, 10, 2002);
                OperationDate enddate = new OperationDate(2, 10, 2004);
                for (Operation operation : list) {
                        System.out.println(operation.Task(begdate, enddate, 499));
                }*/
        /*}
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
        }

        public static int menu() {
                int menu = 0;
                return menu;
        }
}


