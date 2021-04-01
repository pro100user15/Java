import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Tasks {
    /*
     * 23. а) міняє місцями першу і останню літери кожного слова;
     * б) видаляє всі слова, що починаються з малої літери.
     *
     * @throws IOException якщо текст не був введений
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

    /*Ця функція міняє місцями першу і останню літери кожного слова
    * з масива {@param worlds}
    *
    * @param worlds набір слів
    * */
    private static void task1_a(String[] words){
        /*int i = 0;
        for (String p:words) {
            char[] word = p.toCharArray();
            if(word.length > 1) {
                char temp = word[0];
                word[0] = word[word.length - 1];
                word[word.length - 1] = temp;
                p = new String(word);
            }
            words[i++] = p;
        }*/
        /*for(int i=0;i < words.length; i++){
            if(words[i].length() > 1){
                char temp = words[i].charAt(0);
                words[i] = words[i].replace(words[i].charAt(0), words[i].charAt(words[i].length() - 1));
                words[i] = words[i].replace(words[i].charAt(words[i].length() - 1), temp);
            }
        }*/

        int i = 0;
        for (String p : words) {
            words[i++] = replace(p);
        }

        System.out.println("\nРезультат виконання завдання 'a' :");
        for (String p:words) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    /* Ця функція видаляє всі слова, що починаються з малої літери
     * з масива {@param worlds}
     *
     * @param worlds набір слів
     * */
    private static void task1_b(String[] words){
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
     *
     * @param filepath вказує путь до файлу для виконання завдання
     * @throws IOException якщо користувач введе не вірні дані
     * або якщо файлу по шляху {@param filepath} не існує
     * */
    public static void task2(String filepath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть к-ть студентів : ");
        int kilkist = scanner.nextInt();
        if(kilkist < 0) throw  new IOException("Кількість студентів не може бути відємною!");


        double[] mas = new double[kilkist];
        double suma = 0;
        //вводимо середні бали студентів
        for (int i = 0; i < kilkist; i++) {
            System.out.print("Введіть середній бал " + (i + 1) + "-шого студента : ");
            mas[i] = scanner.nextDouble();
            if(mas[i] < 0) throw  new IOException("Середній бал не може бути меншим 0!");
            suma += mas[i];
        }

        double average;
        if(kilkist != 0) average = suma/kilkist;
        else average = 0;

        outputFile(filepath, Double.toString(average));

        System.out.println("Середній бал групи = " + average);
    }



    /*
     * Розв’язати задачу з індивідуального завдання 1(б) при умові, що текстовий рядок імпортується
     * з деякого наперед створеного файла input.txt, а результати роботи програми потрібно записати
     * у новостворений під час виконання проекту файл output.txt.
     * 3. а) підраховує кількість слів у тексті, які закінчуються на голосну літеру; б) виводить на екран
     *
     * @param inputPath путь до файлу з якого считуватимуться дані
     * @param outputPath путь до файлу в який будуть записуватись дані
     * @throws IOException якщо один з файлів {@param inputPath, outputPath} не існує або вказана не вірна путь
     * або якщо у файлі {@param inputPath} не буде даних
     * */
    public static void task3(String inputPath, String outputPath) throws IOException {
        String text = inputFile(inputPath);

        String[] words = text.split("[\\s]+");

        if(words.length <= 0) throw new IOException("Файл пустий.");

        //масив char голосних букв
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
        result += "\nТекст - " + text;
        outputFile(outputPath, result);

        System.out.println(result);
    }





    /* Цей метод перевіряє чи файл існує
     * вказаному за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     * */
    private static void isFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");
            //file.createNewFile();
    }

    /* Цей метод записує у файл за шляхом {@param filepath}
     * текст {@param text}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     * */
    private static void outputFile(String filepath, String text) throws IOException{
        isFile(filepath);

        //записуємо в файл
        BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
        output.write(text);
        output.flush();
        output.close();
        output.close();
    }

    /* Цей метод зчитує з файлу за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     * @return текст з файлу
     * */
    private static String inputFile(String filepath) throws IOException {
        isFile(filepath);

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String text;
        StringBuilder lines = new StringBuilder();
        //зчитуємо текст з файлу
        while ((text = reader.readLine()) != null) {
            lines.append(text);
        }
        reader.close();
        return lines.toString();
    }

    /* Цей метод вертає текст міняючи мершу і останню букву в тексті {@param string}
     *
     * @param string шлях до файлу
     * @return текст
     * */
    private static String replace(String string){
        return string.charAt(string.length() - 1) +
                string.substring(1, string.length() - 2) +
                string.charAt(0);
    }
}
