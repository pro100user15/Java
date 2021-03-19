import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Tasks {

    /*
     * 23. а) міняє місцями першу і останню літери кожного слова;
     * б) видаляє всі слова, що починаються з малої літери.
     * */
    public static void task1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок : ");
        String str = scanner.nextLine();

        String[] words = str.split("[\\s]+");

        if(str.length() == 0 || words.length == 0){
            throw new IOException("Не був введений рядок!");
        }

        task1_a(words.clone());
        task1_b(words.clone());
    }

    //а) міняє місцями першу і останню літери кожного слова;
    public static void task1_a(String[] words){
        int i = 0;
        for (String p:words) {
            char[] word = p.toCharArray();
            if(word.length > 1) {
                char temp = word[0];
                word[0] = word[word.length - 1];
                word[word.length - 1] = temp;
                p = new String(word);
            }
            words[i++] = p;
        }

        System.out.println("\nРезультат виконання завдання 'a' :");
        for (String p:words) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    //б) видаляє всі слова, що починаються з малої літери.
    public static void task1_b(String[] words){
        String str = "";
        for (String p:words) {
            char[] word = p.toCharArray();
            if(!Character.isLowerCase(word[0]))
                str += p + " ";
        }

        System.out.println("\nОтриманий рядок після завдання 'б' :\n" + str);
    }



    /*
     * 23. Створіть файл, який містить середній бал успішності студентів вашої групи
     * (кількість студентів групи та їхні середні бали вводяться з клавіатури).
     * Підрахуйте загальний середній бал групи.
     * */
    public static void task2(String filepath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть к-ть студентів : ");
        int kilkist = scanner.nextInt();

        double[] mas = new double[kilkist];
        double suma = 0;
        //вводимо середні бали студентів
        for (int i = 0; i < kilkist; i++) {
            System.out.print("Введіть середній бал " + (i + 1) + "-шого студента : ");
            mas[i] = scanner.nextDouble();
            suma += mas[i];
        }

        double average = suma/kilkist;

        outputFile(filepath, Double.toString(average));

        System.out.println("Середній бал групи = " + average);
    }



    /*
     * Розв’язати задачу з індивідуального завдання 1(б) при умові, що текстовий рядок імпортується
     * з деякого наперед створеного файла input.txt, а результати роботи програми потрібно записати
     * у новостворений під час виконання проекту файл output.txt.
     * 3. а) підраховує кількість слів у тексті, які закінчуються на голосну літеру; б) виводить на екран
     * */
    public static void task3(String inputPath, String outputPath) throws IOException {
        String text = inputFile(inputPath);

        String[] words = text.split("[\\s]+");

        char[] vowels={'e', 'y', 'u', 'i', 'o', 'a', 'у', 'е', 'ї', 'і', 'а', 'о', 'є', 'я', 'и', 'ю'};

        int count  = 0;
        for (String p:words) {
            char[] word = p.toCharArray();
            for (char ch:vowels) {
                //перевірка на голосну букву
                if (word[word.length - 1] == ch) {
                    count++;
                    break;
                }
            }
        }

        String result = "К-ть слів які закінчуються з голосною буквою = " + count;
        result += "Текст - " + text;
        outputFile(outputPath, result);
    }


    public static void isFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");
    }

    public static void outputFile(String filepath, String text) throws IOException{
        isFile(filepath);

        //записуємо в файл
        FileWriter input = new FileWriter(filepath);
        BufferedWriter output = new BufferedWriter(input);
        output.write(text);
        output.flush();
        output.close();
    }
    private static String inputFile(String filepath) throws IOException {

        isFile(filepath);

        FileReader readerFile = new FileReader(filepath);
        BufferedReader reader = new BufferedReader(readerFile);
        String text;
        StringBuilder lines = new StringBuilder();
        //зчитуємо текст з файлу
        while ((text = reader.readLine()) != null) {
            lines.append(text);
        }
        reader.close();
        return lines.toString();
    }
}
