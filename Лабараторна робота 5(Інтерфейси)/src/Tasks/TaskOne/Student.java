package Tasks.TaskOne;

import java.io.Serializable;
import java.util.Arrays;
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

    //гетер
    public byte getRating() {return rating;}

    //сетер
    public void setRating(byte rating) {this.rating = rating;}

    @Override
    public String toString() {
        return "Subject " + this.name() +
                "\trating=" + rating +
                '}';
    }
}

public class Student implements Serializable {
    String lastname;        //прізвище
    String name;            //ім'я
    int nomer;              //№ залікової книжки
    Subject []subjects;     //предмети

    public Student() {
        lastname = "";
        name = "";
        nomer = 0;
        subjects = new Subject[]{Subject.Math, Subject.Language, Subject.History, Subject.dotNET, Subject.Java};
    }

    public Student(String lastname, String name, int nomer, Subject[] subjects) {
        this.lastname = lastname;
        this.name = name;
        this.nomer = nomer;
        this.subjects = subjects;
    }


    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Прізвище : ");
        lastname = scanner.nextLine();
        System.out.print("Ім'я : ");
        name = scanner.nextLine();
        System.out.print("№ залікової книжки : ");
        nomer = scanner.nextInt();
        for(Subject subject : subjects){
            subject.input();
        }
    }

    void output() {
        System.out.print("Прізвище - " + lastname);
        System.out.print("Ім'я - " + name);
        System.out.print("№ залікової книжки - " + nomer);
        for(Subject subject : subjects){
            subject.output();
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", nomer=" + nomer +
                ", subjects=" + Arrays.toString(subjects) +
                '}';
    }

    //гетери
    public String getLastname() {return lastname;}
    public String getName() {return name;}
    public int getNomer() {return nomer;}
    public Subject[] getSubjects() {return subjects;}

    //сетери
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setName(String name) {this.name = name;}
    public void setNomer(int nomer) {this.nomer = nomer;}
    public void setSubjects(Subject[] subjects) {this.subjects = subjects;}
}
