import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task {
    /*
    22. Визначити 1) добуток елементів масиву з парними номерами;
    2) суму елементів масиву, розташованих до максимального за модулем елемента.
    */
    public void task1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву : ");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть розмірність масиву : ");
                size = scanner.nextInt();
            } else break;
        }

        int[] mas = new int[size];
        System.out.println("1.Ввести масив з клавіатури.");
        System.out.println("2.Згенерувати масив.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести масив з клавіатури.");
                System.out.println("2.Згенерувати масив.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < mas.length; i++) {
                System.out.print("A [" + i + "] = ");
                mas[i] = scanner.nextInt();
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < mas.length; i++) {
                mas[i] = random.nextInt(200) - 100;
            }
        }
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\nЗавдання 2 :");
        task1_a(mas);
        task1_b(mas);
    }

    //1) добуток елементів масиву з парними номерами;
    private void task1_a(int []mas) {
        int dobutok = 1;
        for(int number : mas) {
            if (number % 2 == 0)
                dobutok *= number;
        }

        System.out.println("Добуток парник чисел = " + dobutok);
    }

    //2) суму елементів масиву, розташованих до максимального за модулем елемента.
    private void task1_b(int []mas) throws IOException{
        if(mas.length == 1)
            throw new IOException("Замала кількіть елементів в масиві!");
        int maxIndex = 0, max = mas[maxIndex], suma = 0;
        for(int i=0;i<mas.length;i++) {
            if(Math.abs(mas[i]) > max){
                max = Math.abs(mas[i]);
                maxIndex = i;
            }
        }

        for(int i=0;i<maxIndex;i++) {
            suma += mas[i];
        }

        System.out.println("Сума елементів, розташованих до максимального за модулем елемента(А[" + maxIndex + "]=" + mas[maxIndex] + ") = " + suma);
    }

    /*
    * 22. Написати підпрограму, яка шукає індекси найбільшого та найменшого елементів одновимірного масиву із n елементів цілого типу.
    * */
    public void task_2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву : ");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть розмірність масиву : ");
                size = scanner.nextInt();
            } else break;
        }

        int[] mas = new int[size];
        System.out.println("1.Ввести масив з клавіатури.");
        System.out.println("2.Згенерувати масив.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести масив з клавіатури.");
                System.out.println("2.Згенерувати масив.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < mas.length; i++) {
                System.out.print("A [" + i + "] = ");
                mas[i] = scanner.nextInt();
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < mas.length; i++) {
                mas[i] = random.nextInt(200) - 100;
            }
        }
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();

        int maxIndex = 0, max = mas[0];
        int minIndex = 0, min = mas[0];
        for(int i=0;i<mas.length;i++)
            if (mas[i] > max) {
                max = mas[i];
                maxIndex = i;
            } else if (mas[i] < min) {
                min = mas[i];
                minIndex = i;
            }

        System.out.println("\nЗавдання 2 :");
        System.out.println("Індекс найбільшого елементу(" + mas[maxIndex] + ") = " + maxIndex);
        System.out.println("Індекс найменшого елементу(" + mas[maxIndex] + ") = " + maxIndex);
    }
}
