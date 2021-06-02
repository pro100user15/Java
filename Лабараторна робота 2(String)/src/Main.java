import java.io.*;

//@author pro100user

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1.Завданння 1" +
                "\n2.Завданння 2" +
                "\n3.Завдання 3" +
                "\n4.Вихід" +
                "\nВведіть число : ");
        int num = scanner.nextInt();

        while(num != 4){
            switch (num){
                case 1:
                    try {
                        System.out.println("\n\nЗавданння 1 :");
                        Tasks.task1();
                        System.out.println();
                    }
                    catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("\n\nЗавданння 2 :");
                        Tasks.task2("D:\\Project\\Java\\Лабараторна робота 2(String))\\file.txt");
                    }
                    catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("\nЗавданння 3 :");
                        Tasks.task3("D:\\Project\\Java\\Лабараторна робота 2(String))\\input.txt", "D:\\Project\\Java\\Лабараторна робота 2(String))\\output.txt");
                    }
                    catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Не вірно введене число!Введіть ще раз :");
                    break;
            }
            System.out.print("\n\n1.Завданння 1" +
                    "\n2.Завданння 2" +
                    "\n3.Завдання 3" +
                    "\n4.Вихід" +
                    "\nВведіть число : ");
            num = scanner.nextInt();
        }
    }
}
