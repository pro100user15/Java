package Tasks;

import Tasks.TaskOne.TaskOne;
import Tasks.TaskTwo.TaskTwo;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        for(;;) {
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

    public static void TaskOne() {
        Scanner scanner = new Scanner(System.in);
        TaskOne task = new TaskOne();
        for (; ; ) {
            try {
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();

                switch (command) {
                    case "add" -> task.add();
                    case "edit" -> task.edit();
                    case "print" -> task.print();
                    case "printlist" -> task.printlist();
                    case "search" -> task.search();
                    case "sort" -> task.sort();
                    case "delete" -> task.delete();
                    case "task" -> task.task();
                    case "exit" -> {
                        return;
                    }
                    case "help" -> {
                        System.out.println("\nadd - додати інформацію про студента" + "\n" +
                                "edit - редагувати інформацію про студента" + "\n" +
                                "print - висести інформацію про студента" + "\n" +
                                "printlist - висести інформацію про студента у вигляді таблиці" + "\n" +
                                "search - пошук інформації про студента" + "\n" +
                                "sort - сортування інформації про студента" + "\n" +
                                "delete - видалити інформацію про студента" + "\n" +
                                "task - відсоток студентів, що мають незадовільні оцінки" + "\n" +
                                "exit - вихід");
                    }
                    default -> System.err.print("Не вірно введена команда(help - допомога)! Введіть ще раз :");
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void TaskTwo() {
        Scanner scanner = new Scanner(System.in);
        TaskTwo task = new TaskTwo();
        for (; ; ) {
            try {
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();

                switch (command) {
                    case "add" -> task.add();
                    case "edit" -> task.edit();
                    case "print" -> task.print();
                    case "printlist" -> task.printlist();
                    case "search" -> task.search();
                    case "sort" -> task.sort();
                    case "delete" -> task.delete();
                    case "task" -> task.task();
                    case "exit" -> {
                        return;
                    }
                    case "help" -> {
                        System.out.println("\nadd - додати інформацію про виступ" + "\n" +
                                "edit - редагувати інформацію про виступ" + "\n" +
                                "print - висести інформацію про виступи" + "\n" +
                                "printlist - висести інформацію про виступи у вигляді таблиці" + "\n" +
                                "search - пошук інформації про виступ" + "\n" +
                                "sort - сортування інформації про виступ" + "\n" +
                                "delete - видалити інформацію про виступ" + "\n" +
                                "task - вивід 1)сумарної кількості слухачів,\t" +
                                "2)день з найбільшою кількістю слухачів,\t" +
                                "3)довжина прізвища" + "\n" +
                                "exit - вихід");
                    }
                    default -> System.err.print("Не вірно введена команда(help - допомога)! Введіть ще раз :");
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
