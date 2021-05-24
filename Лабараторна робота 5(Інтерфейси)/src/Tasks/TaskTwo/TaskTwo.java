package Tasks.TaskTwo;

import Tasks.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskTwo implements Task {
    ArrayList<Speech> speeches;

    public TaskTwo() {
        speeches = new ArrayList<Speech>();
        download();
    }

    public void add() throws IOException {
        Speech speech = new Speech();
        System.out.println("\n======Введіть інформацію :======");
        speech.input();
        speeches.add(speech);

        save();
    }

    public void edit() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > speeches.size()) {
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\n======Відредагуйте :======");
        speeches.get(nomer).input();

        save();
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\n======Інформація про студентів :======");
        for (var p :
                speeches) {
            System.out.println("\n====Виступ №" + (i + 1) + " :=====");
            p.output();
            i++;
        }
        System.out.println("\n====================================");
    }

    public void printlist() throws IOException {
        count_note();

        System.out.println("\n======Інформація про виступи :======\n");
        for (var p :
                speeches) {
            System.out.println(p.toString());
        }
        System.out.println("\n====================================");
    }

    public void search() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть прізвище поета, яке ви шукаєте : ");
        String lastname = scanner.nextLine();

        boolean flag = false;
        int i = 0;
        for (var p :
                speeches) {
            if (p.getLastname().equals(lastname)) {
                if (flag == false) {
                    System.out.println("\n======Результат :======\n");
                    flag = true;
                }
                System.out.println("Виступ №" + (i + 1) + " :");
                p.output();
                System.out.println("\n=====================");
            }
            i++;
        }

        if (flag == false) {
            System.out.println("Пошук не вдалий!");
        }
    }

    public void sort() throws IOException {
        count_note();

        ArrayList<Speech> sortSpeeches = new ArrayList<Speech>(speeches);
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            System.out.print("\nВведіть параметр по якому відбудеться сортування : ");
            String command = scanner.nextLine();
            switch (command) {
                case "lastname up" -> sortSpeeches.sort(Comparator.comparing(Speech::getLastname));
                case "lastname down" -> sortSpeeches.sort(Comparator.comparing(Speech::getLastname).reversed());
                case "language up"  -> sortSpeeches.sort(Comparator.comparing(Speech::getLanguage));
                case "language down" -> sortSpeeches.sort(Comparator.comparing(Speech::getLanguage).reversed());
                case "collections up" -> sortSpeeches.sort(Comparator.comparing(Speech::getCount_collections));
                case "collections down" -> sortSpeeches.sort(Comparator.comparing(Speech::getCount_collections).reversed());
                case "date up" -> {
                    for (int i=1; i<sortSpeeches.size(); i++)
                        for (int j = sortSpeeches.size()-1; j>=i; j--)
                            if (Speech.compareTo(sortSpeeches.get(i), sortSpeeches.get(j-1))) {
                                Speech tmp = sortSpeeches.get(j-1);
                                sortSpeeches.set(j-1, sortSpeeches.get(i));
                                sortSpeeches.set(i, tmp);
                            }
                }
                case "date down" -> {
                    for (int i=1; i<sortSpeeches.size(); i++)
                        for (int j = sortSpeeches.size()-1; j>=i; j--)
                            if (!Speech.compareTo(sortSpeeches.get(i), sortSpeeches.get(j-1))) {
                                Speech tmp = sortSpeeches.get(j-1);
                                sortSpeeches.set(j-1, sortSpeeches.get(i));
                                sortSpeeches.set(i, tmp);
                            }
                }
                case "place up" -> sortSpeeches.sort(Comparator.comparing(Speech::getPlace));
                case "place down" -> sortSpeeches.sort(Comparator.comparing(Speech::getPlace).reversed());
                case "listeners up" -> sortSpeeches.sort(Comparator.comparing(Speech::getCount_listeners));
                case "listeners down" -> sortSpeeches.sort(Comparator.comparing(Speech::getCount_listeners).reversed());
                case "help"-> {
                    System.out.println("\n" + "[field] up/down" + "\n" +
                            "[field] = lastname / language / collections / date / place / listeners");
                    continue;
                }
                default-> {
                    System.out.println("Не вірно введений параметр сортування(help-допомога). Введіть ще раз :");
                    continue;
                }
            }
            break;
        }

        System.out.println("\n======Відсортований список :======\n");
        for (var p :
                sortSpeeches) {
            System.out.println(p.toString());
        }
        System.out.println("\n==============================");
    }

    public void delete() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер, який ви хочете видалити : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > speeches.size()) {
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        speeches.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        save();
    }

    public void task() throws IOException {
        count_note();

        System.out.println("\n===========Завдання :===========\n");
        int suma = 0, index = 0, max = speeches.get(index).count_listeners;
        int i = 0;
        System.out.println("Довжина прізвища :");
        for (var p :
                speeches) {
            System.out.print(p.getLastname().length() + " ");
            if(p.getCount_listeners() > max){
                max = p.getCount_listeners();
                index = i;
            }
            suma += p.getCount_listeners();
            i++;
        }
        System.out.println();

        System.out.println("Сумарна кількість слухачів = " + suma);
        System.out.println("День з найбільшою кількістю слухачів = " + speeches.get(index).getDate().toString());
        System.out.println("\n====================================");
    }

    private void count_note() throws IOException {
        if (speeches.size() == 0)
            throw new IOException("Записів нема!");
    }


    private static void isFile(String filepath) throws IOException {
        //перевірка чи файл існує
        File file = new File(filepath);
        if (!file.isFile())
            file.createNewFile();
    }

    private void save() {
        try {
            isFile("speeches.dat");
            FileOutputStream fos = new FileOutputStream("speeches.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(speeches);
            oos.close();
            fos.close();
        }
        catch(Exception ex) {
            System.err.println("Виникла якась помилка!");
        }
    }

    private void download() {
        try {
            isFile("speeches.dat");
            FileInputStream fis = new FileInputStream("speeches.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            speeches = (ArrayList<Speech>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
