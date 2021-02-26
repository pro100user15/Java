import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//@author pro100user

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Перше завдання.");
        System.out.println("2. Друге завдання.");
        System.out.println("3. Третє завдання.");
        System.out.println("4. Четверте завдання.");
        System.out.println("5. Вихід.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while(num != 5){
            switch (num) {
                case 1:
                    task1();
                    break;
                case 2:
                    try {
                        task2();
                    }
                    catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                default:
                    System.out.println("Не вірно введене число!!! Повторіть спробу :");
                    break;
            }
            System.out.println("1. Перше завдання.");
            System.out.println("2. Друге завдання.");
            System.out.println("3. Третє завдання.");
            System.out.println("4. Четверте завдання.");
            System.out.println("5. Вихід.");
            System.out.print("Введіть число : ");
            num = scanner.nextInt();
        }
    }


    /*
    * 23. Написати програму, яка в залежності від порядкового номера місяця (1,2,...12)
    * виводить на екран його назву (січень,...грудень).
    * */
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер місяця : ");
        int month = scanner.nextInt();
        do {
            if (month >= 1 && month <= 12) {
                switch (month) {
                    case 1:
                        System.out.println("Січень");
                        break;
                    case 2:
                        System.out.println("Лютий");
                        break;
                    case 3:
                        System.out.println("Березень");
                        break;
                    case 4:
                        System.out.println("Квітень");
                        break;
                    case 5:
                        System.out.println("Травень");
                        break;
                    case 6:
                        System.out.println("Червень");
                        break;
                    case 7:
                        System.out.println("Липень");
                        break;
                    case 8:
                        System.out.println("Серпень");
                        break;
                    case 9:
                        System.out.println("Вересень");
                        break;
                    case 10:
                        System.out.println("Жовтень");
                        break;
                    case 11:
                        System.out.println("Листопад");
                        break;
                    case 12:
                        System.out.println("Грудень");
                        break;
                }
                break;
            } else {
                System.out.print("Введіть місяць народження : ");
                month = scanner.nextInt();
            }
        } while (true);
    }


    /*
    * 23. Протабулювати функцію y=f(x), з параметром x, який змінюється від 'a' до 'b' з кроком h
    * */
    public static void task2() throws IOException {
        int a = -1, b = 25;
        double dx = 1.25d;
//        for (double x = a; x <= b; x += dx) {
//            if((3*x-12) == 0) throw new IOException("На нуль ділити не можна");
//            double y = Math.exp(x)/(3*x-12);
//            System.out.print(x + "\t" + y + "\n");
//        }

        double x = a;
        do {
            if ((3 * x - 12) == 0) throw new IOException("На нуль ділити не можна");
            double y = Math.exp(x) / (3 * x - 12);
            System.out.println("x = " + String.format("%.2f", x) + "\ty = "+ String.format("%.2f", y));
            x += dx;
        }while(x <= b);
    }


    /*
    * 23. Визначити : 1) суму від’ємних елементів масиву;
    * 2) добуток елементів масиву, розташованих між максимальним і мінімальним елементами.
    * */
    public static void task3() {
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

        int suma = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 0) {
                suma += mas[i];
            }
        }
        System.out.println("Сума відємних елементів = " + suma);

        int min = mas[0], max = mas[0], mini = 0, maxi = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] >= max) {
                max = mas[i];
                maxi = i;
            }
            if(mas[i] <= min) {
                min = mas[i];
                mini = i;
            }
        }

        if(mini == maxi || (mini-maxi == -1) || (mini - maxi == 1)){
            System.out.println("Визначити добуток між мінімальним(" + mini +") і максимальним(" + maxi +") елементом не можливо!");
        }
        else {
            if(maxi<mini){
                int temp = mini;
                mini = maxi;
                maxi = temp;
            }
            int dobutok = 1;
            for(int i = mini + 1; i<maxi;i++){
                dobutok *= mas[i];
            }
            System.out.println("Добуток між мінімальним - " + min +", і максимальним - " + max +" елементом = " + dobutok);
        }
    }


    /*
    * 23. Дано цілочислову матрицю А розмірності nxm. Вивести одновимірний масив b, в якому кожен елемент
    * є добутком елементів стовпців, в яких знаходяться максимальний та мінімальний елементи відповідного рядка.
    * */
    public static void task4(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть висоту матриці : ");
        int n = scanner.nextInt();
        System.out.print("Введіть ширину матриці : ");
        int m = scanner.nextInt();
        for (; ;) {
            if (n < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть висоту матриці : ");
                n = scanner.nextInt();
            }
            if (m < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть ширину матриці : ");
                m = scanner.nextInt();
            }
            if(n > 0 && m > 0) break;
        }
        int[][] mas = new int[n][m];
        System.out.println("1.Ввести матрицю з клавіатури.");
        System.out.println("2.Згенерувати матрицю.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести матрицю з клавіатури.");
                System.out.println("2.Згенерувати матрицю.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("A [" + i + "][" + j + "] = ");
                    mas[i][j] = scanner.nextInt();
                }
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mas[i][j] = random.nextInt(200) - 100;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        int []onemas = new int[n];
        for (int i = 0; i < n; i++) {
            int min=mas[i][0], max=mas[i][0];
            int mini=0,maxi=0;
            int dobutok = 1;
            for (int j = 0; j < m; j++) {
                if (mas[i][j] >= max) {
                    max = mas[i][j];
                    maxi = j;
                }
                if(mas[i][j] <= min) {
                    min = mas[i][j];
                    mini = j;
                }
            }
            for (int i1 = 0; i1 < n; i1++) {
                dobutok *= mas[i1][mini]*mas[i1][maxi];
            }
            onemas[i] = dobutok;
        }

        System.out.println("Результат :");
        for (int i : onemas) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}