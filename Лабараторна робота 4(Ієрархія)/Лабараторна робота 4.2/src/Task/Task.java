package Task;

import java.io.*;
import java.util.*;

public class Task {
    ArrayList<Spam> spam;

    public Task() throws IOException {
        spam = read_from_file();
    }

    public void add() throws IOException {
        Spam new_spam = new Spam();
        System.out.println("\nВведіть інформацію :");
        new_spam.input();
        spam.add(new_spam);

        System.out.println("\nЗапись додана!");

        this.write_to_file();
    }

    public void edit() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер фільму, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > spam.size()) {
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\nВідредагуйте :");
        spam.get(nomer).input();
        System.out.println("\nРедагування пройшло успішно!");

        this.write_to_file();
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\nІнформація про фільми :");
        for (var p :
                spam) {
            System.out.println("\nФільм №" + (i + 1) + " :");
            p.output();
            i++;
        }
    }

    public void search() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        Date nowdate = new Date();
        System.out.println("\nВведіть рік випуску, який ви шукаєте : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) > (nowdate.getYear() + 1900)) {
            System.err.println("Не вірно введений день!");
            this.search();
            return;
        }
        int amount = Integer.parseInt(line);

        boolean flag = false;
        int i = 0;
        for (var p :
                spam) {
            if (p.getAmount() == amount) {
                if (flag == false) {
                    System.out.println("\nРезультат : ");
                    flag = true;
                }
                System.out.println("Фільм №" + (i + 1) + " :");
                p.output();
                System.out.println();
                i++;
            }
        }

        if (flag == false) {
            System.out.println("Пошук не вдалий!");
        }
    }

    public void sort() throws IOException {
        count_note();

        ArrayList<Spam> sortmovies = new ArrayList<Spam>(spam);
        sortmovies.sort(Comparator.comparing(Spam::getAmount));

        int i = 0;
        System.out.println("\nВідсортований список :");
        for (var p :
                sortmovies) {
            System.out.println("\nФільм №" + (i + 1) + " :");
            p.output();
            i++;
        }
    }

    public void delete() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер фільму, який ви хочете видалити : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > spam.size()) {
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        spam.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        this.write_to_file();
    }

    public void task() throws IOException {
        count_note();

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n1.Завдання 1" + "\n" +
                    "2.Завдання 2" + "\n" +
                    "3.Завдання 3" + "\n" +
                    "4.Вернутись назад" + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            if (nomer < 1 || nomer > 4) {
                System.out.println("Не вірно введене число!! Введіть ще раз :");
                continue;
            }

            switch (nomer) {
                case 1:
                    task_1();
                    break;
                case 2:
                    task_2();
                    break;
                case 3:
                    task_3();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void task_1() {
        try {
            DateSpam beg_date = new DateSpam();
            DateSpam end_date = new DateSpam();
            System.out.println("\nВведіть першу дату :");
            beg_date.inputDate();
            System.out.println("\nВведіть другу дату :");
            end_date.inputDate();

            if (beg_date.better(end_date))
                throw new IOException("Перша дата не може бути бульшою за другу!");
            int count_spam = 0;
            int count_day = 0;
            for (Spam spam : spam) {
                if (!beg_date.better(spam.date) || beg_date.equally(spam.date))
                    if (end_date.better(spam.date) || end_date.equally(spam.date)) {
                        count_spam += spam.amount;
                        count_day++;
                    }
            }

            if (count_day == 0)
                throw new IOException("В заданий період не було найдено записів!");

            double result = (double) count_spam / count_day;

            System.out.println("Середня кількість спаму в день за період(" + beg_date.toString() + " - " + end_date.toString() + ") = " + result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void task_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення спам повідомлень : ");
        int amount_spam = scanner.nextInt();

        int count_day = 0;
        for (Spam spam : spam) {
            if (spam.amount < amount_spam)
                count_day++;
        }

        System.out.println("Кількість днів, коли відсоток спам повідомлень був менший за(" + amount_spam + ") = " + count_day);
    }

    private void task_3() {
        Spam[] arr = new Spam[spam.size()];
        arr = spam.toArray(arr);
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].getDate().better(arr[j + 1].getDate())) {
                    Spam temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        for (Spam p : arr) {
            System.out.println(p.toString());
        }

        for (int i = 1; i < arr.length; i++)
            if (arr[i].amount > arr[i - 1].amount) {
                System.out.println(arr[i].getDate().toString());
            }
    }

    private void count_note() throws IOException {
        if (spam.size() == 0)
            throw new IOException("Записів нема!");
    }


    /* Цей метод перевіряє чи файл існує
     * вказаному за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     */
    private static void isFile(String filepath) throws IOException {
        //перевірка чи файл існує
        File file = new File(filepath);
        if (!file.isFile()) throw new IOException("Файл не знайдено!");
        //file.createNewFile();
    }

    /*Цей метод записує у файл за шляхом {@param filepath}
     * текст {@param text}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     */
    public void write_to_file() throws IOException {
        isFile("Spam.txt");

        BufferedWriter output = new BufferedWriter(new FileWriter("Spam.txt"));
        for (var p :
                spam) {
            output.write(p.to_string());
        }
        output.flush();
        output.close();
        output.close();
    }

    /*Цей метод зчитує з файлу за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     * @return ArrayList<Spam>
     */
    private static ArrayList<Spam> read_from_file() throws IOException {
        isFile("Spam.txt");

        BufferedReader reader = new BufferedReader(new FileReader("Spam.txt"));
        String text;
        ArrayList<Spam> arrayList = new ArrayList<>();
        while ((text = reader.readLine()) != null) {
            arrayList.add(new Spam(text, reader.readLine(), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())));
        }
        reader.close();
        return arrayList;
    }
}
