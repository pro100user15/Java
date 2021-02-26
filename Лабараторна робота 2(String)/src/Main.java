import java.io.*;

//@author pro100user

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Завданння 1 :");
        task1();

        try {
            System.out.println("\n\nЗавданння 2 :");
              task2("D:\\Project\\Java\\Лабараторна робота 2(String)\\file.txt");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nЗавданння 3 :");
            task3("D:\\Project\\Java\\Лабараторна робота 2(String)\\input.txt", "D:\\Project\\Java\\Лабараторна робота 2(String)\\output.txt");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    /*
    * 23. а) міняє місцями першу і останню літери кожного слова;
    * б) видаляє всі слова, що починаються з малої літери.
    * */
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок : ");
        String str = scanner.nextLine();

        String[] words = str.split("[\\s]+");
        String[] words1 = new String[words.length];

        int i = 0, size = 0;
        for (String p:words) {
            char[] word = p.toCharArray();
            if(word.length > 1) {
                char temp = word[0];
                word[0] = word[word.length - 1];
                word[word.length - 1] = temp;
                //перевірка чи перша буква слова є нижнього регістру
                if(Character.isLowerCase(word[0])) {size++; continue;}
                p = new String(word);
            }
            words1[i] = p;
            i++;
        }

        System.out.println("\nОтриманий рядок після завдання : ");
        for (int i1=0; i1 < words1.length - size; i1++) {
            System.out.print(words1[i1] + " ");
        }
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

        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");

        //записуємо в файл
        FileWriter input = new FileWriter(filepath);
        BufferedWriter output = new BufferedWriter(input);
        output.write(Double.toString(average));
        output.flush();
        output.close();
    }


    /*
    * Розв’язати задачу з індивідуального завдання 1(б) при умові, що текстовий рядок імпортується
    * з деякого наперед створеного файла input.txt, а результати роботи програми потрібно записати
    * у новостворений під час виконання проекту файл output.txt.
    * 3. а) підраховує кількість слів у тексті, які закінчуються на голосну літеру; б) виводить на екран
    * */
    public static void task3(String inputPath, String outputPath) throws IOException {
        //перевірка чи файл існує
        File file = new File(inputPath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");

        FileReader readerFile = new FileReader(inputPath);
        BufferedReader reader = new BufferedReader(readerFile);
        String text;
        StringBuilder lines = new StringBuilder();
        //зчитуємо текст з файлу
        while ((text = reader.readLine()) != null) {
            lines.append(text);
        }
        reader.close();
        text = lines.toString();

        String[] words = text.split("[\\s]+");

        char[] vowels={'e', 'y', 'u', 'i', 'o', 'a'};

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

        System.out.println("К-ть слів які закінчуються з голосною буквою = " + count);
        System.out.println("Текст - " + text);

        //перевірка чи файл існує
        file = new File(outputPath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");

        //записуємо результат в файл
        FileWriter input = new FileWriter(outputPath);
        BufferedWriter output = new BufferedWriter(input);
        output.write("К-ть слів які закінчуються з голосною буквою = " + count);
        output.write("\nТекст - " + text);
        output.flush();
        output.close();
    }
}
