package Tasks.TaskOne;

import java.io.Serializable;
import java.util.Scanner;

class Subject implements Serializable {
    enum Subjects {
        Math, Language, History, dotNET, Java;
    }
    Subjects []subjects;
    byte []rating;

    Subject() {
        subjects = new Subjects[]{Subjects.Math, Subjects.Language, Subjects.History, Subjects.dotNET, Subjects.Java};
        rating = new byte[5];
    }
    public Subject(byte Math, byte Language, byte History, byte dotNET, byte Java) {
        subjects = new Subjects[]{Subjects.Math, Subjects.Language, Subjects.History, Subjects.dotNET, Subjects.Java};
        rating = new byte[]{Math, Language, History, dotNET, Java};
    }

    void input() {
        for(int i=0;i<subjects.length;i++) {
            System.out.print("Введіть оцінку з " + subjects[i].name() + " : ");
            rating[i] = inputRating();
        }
    }
    void output() {
        for(int i=0;i<subjects.length;i++)
            System.out.println("Оцінка з " + subjects[i].name() + " - " + rating[i]);
    }

    private byte inputRating() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 100) {
            System.err.println("Не вірно введена оцінка!");
            this.inputRating();
        }
        return Byte.parseByte(line);
    }

    //гетер
    public byte getRating(int index) {return rating[index];}

    //сетер
    public void setRating(int index, byte rating) {this.rating[index] = rating;}

    @Override
    public String toString() {
        String result = "";
        for(int i=0;i<subjects.length;i++)
            result += subjects[i].name() + " - " + rating[i] + "\t\t";
        return result;
    }
}

public class Student implements Serializable {
    String lastname;        //прізвище
    String name;            //ім'я
    int nomer;              //№ залікової книжки
    Subject subjects;     //предмети

    public Student() {
        lastname = "";
        name = "";
        nomer = 0;
        subjects = new Subject();
    }

    public Student(String lastname, String name, int nomer, byte Math, byte Language, byte History, byte dotNET, byte Java) {
        this.lastname = lastname;
        this.name = name;
        this.nomer = nomer;
        this.subjects = new Subject(Math, Language, History, dotNET, Java);
    }


    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Прізвище : ");
        lastname = scanner.nextLine();
        System.out.print("Ім'я : ");
        name = scanner.nextLine();
        System.out.print("№ залікової книжки : ");
        nomer = scanner.nextInt();
        subjects.input();
    }

    void output() {
        System.out.println("Прізвище - " + lastname);
        System.out.println("Ім'я - " + name);
        System.out.println("№ залікової книжки - " + nomer);
        subjects.output();
    }


    @Override
    public String toString() {
        return lastname + '\t' + '\t' +
                name + '\t' + '\t' +
                nomer + '\t' + '\t' +
                subjects.toString();
    }


    //гетери
    public String getLastname() {return lastname;}
    public String getName() {return name;}
    public int getNomer() {return nomer;}
    public Subject getSubject() {return subjects;}
    public double getAverage() {
        int average = 0;
        for(byte rating : subjects.rating) {
            average += rating;
        }
        return (double) average/subjects.rating.length;
    }

    //сетери
    public void setLastname(String lastname) {this.lastname = lastname;}
    public void setName(String name) {this.name = name;}
    public void setNomer(int nomer) {this.nomer = nomer;}
    public void setSubjects(Subject subjects) {this.subjects = subjects;}

    public boolean isUnsatisfactory() {
        for(int i=0;i<subjects.rating.length;i++)
            if(subjects.rating[i] <= 2)
                return true;
        return false;
    }
}
