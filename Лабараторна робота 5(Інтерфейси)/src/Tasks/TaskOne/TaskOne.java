package Tasks.TaskOne;

import Tasks.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaskOne implements Task {
    ArrayList<Student> students;

    public TaskOne() {
        students = new ArrayList<Student>();
        download();
    }

    public void add() throws IOException {
        Student new_student = new Student();
        System.out.println("\n======Введіть інформацію :======");
        new_student.input();
        students.add(new_student);

        save();
    }

    public void edit() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер студента, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > students.size()) {
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\n======Відредагуйте :======");
        students.get(nomer).input();

        save();
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\n======Інформація про студентів :======");
        for (var p :
                students) {
            System.out.println("\n====Студент №" + (i + 1) + " :=====");
            p.output();
            i++;
        }
        System.out.println("\n====================================");
    }

    public void printlist() throws IOException {
        count_note();

        System.out.println("\n======Інформація про студентів :======\n");
        for (var p :
                students) {
            System.out.println(p.toString());
        }
        System.out.println("\n====================================");
    }

    public void search() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть прізвище студента, яке ви шукаєте : ");
        String lastname = scanner.nextLine();

        boolean flag = false;
        int i = 0;
        for (var p :
                students) {
            if (p.getLastname().equals(lastname)) {
                if (flag == false) {
                    System.out.println("\n======Результат :======\n");
                    flag = true;
                }
                System.out.println("Студент №" + (i + 1) + " :");
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

        ArrayList<Student> sortstudents = new ArrayList<Student>(students);
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            System.out.print("\nВведіть параметр по якому відбудеться сортування : ");
            String commnd = scanner.nextLine();
            switch (commnd) {
                case "lastname up" -> sortstudents.sort(Comparator.comparing(Student::getLastname));
                case "lastname down" -> sortstudents.sort(Comparator.comparing(Student::getLastname).reversed());
                case "name up" -> sortstudents.sort(Comparator.comparing(Student::getName));
                case "name down" -> sortstudents.sort(Comparator.comparing(Student::getName).reversed());
                case "nomer up" -> sortstudents.sort(Comparator.comparing(Student::getNomer));
                case "nomer down" -> sortstudents.sort(Comparator.comparing(Student::getNomer).reversed());
                case "subjects up" ->sortstudents.sort(Comparator.comparing(Student::getAverage));
                case "subjects down" ->sortstudents.sort(Comparator.comparing(Student::getAverage).reversed());
                case "help"-> {
                    System.out.println("\n" + "[field] up/down" + "\n" +
                            "[field] = lastname / name / nomer / subjects");
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
                sortstudents) {
            System.out.println(p.toString());
        }
        System.out.println("\n==============================");
    }

    public void delete() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер студента, який ви хочете видалити : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > students.size()) {
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        students.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        save();
    }

    public void task() throws IOException {
        count_note();

        System.out.println("\n======Cтуденти, які мають незадовільні оцінки :======\n");
        int count = 0;
        for (var p :
                students) {
            if (p.isUnsatisfactory()) {
                System.out.println(p.toString());
                count++;
            }
        }
        System.out.println("Відсоток студентів, що мають незадовільні оцінки = " + 100*count/students.size() + "%");
        System.out.println("\n====================================");
    }

    private void count_note() throws IOException {
        if (students.size() == 0)
            throw new IOException("Записів нема!");
    }


    private static void isFile(String filepath) throws IOException {
        //перевірка чи файл існує
        File file = new File(filepath);
        if (!file.isFile()) throw new IOException("Файл не знайдено!");
        //file.createNewFile();
    }

    private void save() {
        try {
            isFile("student.dat");
            FileOutputStream fos = new FileOutputStream("student.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }
        catch(Exception ex) {
            System.err.println("Виникла якась помилка!");
        }
    }

    private void download() {
        try {
            isFile("student.dat");
            FileInputStream fis = new FileInputStream("student.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
