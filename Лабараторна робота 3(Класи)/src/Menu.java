import TaskOne.Operation;
import TaskOne.OperationDate;
import TaskTwo.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1.Перше завдання." + "\n" +
                    "2.Друге завдання." + "\n" +
                    "3.Вихід." + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            switch (nomer) {
                case 1:
                    TaskOne();
                    break;
                case 2:
                    TaskTwo();
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Не вірно введене число! Введіть ще раз :");
                    break;
            }
        }
    }

    public static void TaskOne(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Operation> list = new ArrayList<Operation>();
        list.add(new Operation(5, 3, 2021, "Богдан", "Ткачук", 1, 500, 1000));
        list.add(new Operation(25, 6, 2017, "Євген", "Парацій", 2, 500, 1000));
        list.add(new Operation(12, 11, 2020, "Андрій", "Татарчук", 3, 500, 1000));
        list.add(new Operation(21, 10, 2020, "Міша", "Сушинський", 4, 500, 1000));
        list.add(new Operation(8, 1, 2021, "Микола", "Бужняк", 5, 500, 1000));
        list.add(new Operation(17, 6, 2019, "Віталій", "Ясенівський", 6, 500, 1000));
        list.add(new Operation(19, 3, 2018, "Діма", "Васенковик", 7, 500, 1000));
        list.add(new Operation(21, 2, 2021, "Петро", "Клим", 8, 500, 1000));
        list.add(new Operation(24, 12, 2020, "Макс", "Нищук", 9, 500, 1000));
        list.add(new Operation(28, 3, 2021, "Олександр", "Чорнієвич", 10, 500, 1000));

        System.out.println("\nСписок проведених операцій клієнтами банку :");
        for (Operation operation : list) {
            System.out.println(operation.toString());
        }

        OperationDate beg_date = new OperationDate();
        OperationDate end_date = new OperationDate();
        System.out.println("\nВведіть першу дату :");
        beg_date.enterDate();
        System.out.println("\nВведіть другу дату :");
        end_date.enterDate();
        System.out.print("\nВведіть суму : ");
        double suma = scanner.nextDouble();
        for (Operation operation : list) {
            operation.Task(beg_date, end_date, suma);
        }
    }

    public static void TaskTwo(){
        try {
            Scanner scanner = new Scanner(System.in);
            Task task = new Task();
            for(;;){
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();

                switch (command){
                    case "add":
                        task.add();
                        break;
                    case "edit":
                        task.edit();
                        break;
                    case "print":
                        task.print();
                        break;
                    case "search":
                        task.search();
                        break;
                    case "sort":
                        task.sort();
                        break;
                    case "delete":
                        task.delete();
                        break;
                    case "exit":
                        return;
                    case "help":
                        System.out.println("\nadd - додати фільм" + "\n" +
                                "edit - редагувати фільм" + "\n" +
                                "print - висести список фільмів" + "\n" +
                                "search - пошук фільма" + "\n" +
                                "sort - сортування фільмів" + "\n" +
                                "delete - видалити фільм" + "\n" +
                                "exit - вихід");
                        break;
                    default:
                        System.err.print("Не вірно введена команда(help - допомога)! Введіть ще раз :");
                        break;
                }
            }
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
