package Task;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Task {
    Email_account account;
    ArrayList<Spam> spam;

    public Task() throws IOException {
        account = new Email_account();
        spam = read_from_file("Spam.txt");
    }

    public void add() throws IOException {
        Spam new_spam = new Spam();
        System.out.println("\nВведіть інформацію :");
        new_spam.input();
        spam.add(new_spam);

        System.out.println("\nЗапись додана!");

        this.write_to_file("Movies.txt");
    }

    public void edit() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер фільму, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > spam.size()){
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\nВідредагуйте :");
        spam.get(nomer).input();
        System.out.println("\nРедагування пройшло успішно!");

        this.write_to_file("Movies.txt");
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\nІнформація про фільми :");
        for (var p:
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
        if(!line.matches("\\d+") || Integer.parseInt(line) > (nowdate.getYear() + 1900)){
            System.err.println("Не вірно введений день!");
            this.search();
            return;
        }
        int amount = Integer.parseInt(line);

        boolean flag = false;
        int i = 0;
        for (var p:
                spam) {
            if(p.getAmount() == amount) {
                if(flag == false){
                    System.out.println("\nРезультат : ");
                    flag = true;
                }
                System.out.println("Фільм №" + (i + 1) + " :");
                p.output();
                System.out.println();
                i++;
            }
        }

        if(flag == false){
            System.out.println("Пошук не вдалий!");
        }
    }

    public void sort() throws IOException {
        count_note();

        ArrayList<Spam> sortmovies = new ArrayList<Spam>(spam);
        sortmovies.sort(Comparator.comparing(Spam::getAmount));

        int i = 0;
        System.out.println("\nВідсортований список :");
        for (var p:
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
        if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > spam.size()){
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        spam.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        this.write_to_file("Movies.txt");
    }

    public void count_note() throws IOException {
        if(spam.size() == 0)
            throw new IOException("Записів нема!");
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
    public void write_to_file(String filepath) throws IOException{
        isFile(filepath);

        BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
        for (var p:
                spam) {
            output.write(p.to_string());
        }
        output.flush();
        output.close();
        output.close();
    }

    /* Цей метод зчитує з файлу за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     * @return ArrayList<Spam>
     * */
    private static ArrayList<Spam> read_from_file(String filepath) throws IOException {
        isFile(filepath);

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String text;
        ArrayList<Spam> arrayList = new ArrayList<>();
        while ((text = reader.readLine()) != null) {
            arrayList.add(new Spam(text, reader.readLine(), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine())));
        }
        reader.close();
        return arrayList;
    }
}
