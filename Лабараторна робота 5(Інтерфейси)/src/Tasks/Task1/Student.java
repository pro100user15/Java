package Tasks.Task1;

import java.util.Scanner;

enum Subject{
    Math, Language, History, dotNET, Java;
    byte rating;

    Subject() {
        rating = 0;
    }
    Subject(byte rating) {
        this.rating = rating;
    }

    void input() {
        System.out.print("Введіть оцінку з " + this.name() + " : ");
        inputRating();
    }
    void output() {
        System.out.print("Оцінка з " + this.name() + " - " + rating);
    }

    private void inputRating() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 100) {
            System.err.println("Не вірно введена оцінка!");
            this.inputRating();
            return;
        }
        rating = Byte.parseByte(line);
    }

    public byte getRating() {return rating;}

    public void setRating(byte rating) {this.rating = rating;}

    @Override
    public String toString() {
        return "Subject " + this.name() +
                "\trating=" + rating +
                '}';
    }
}

public class Student {
    String lastname;        //прізвище
    String name;            //ім'я
    int nomer;
    Subject []subjects;

    public Student() {
        lastname = "";
        name = "";
        nomer = 0;
        subjects = new Subject[5];
    }

    public Student(String lastname, String name, int nomer, Subject[] subjects) {
        this.lastname = lastname;
        this.name = name;
        this.nomer = nomer;
        this.subjects = subjects;
    }
}
