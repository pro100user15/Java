package Tasks.TaskTwo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

final public class Speech extends Poet implements Serializable {
    DataSpeech date;        //дата виступу
    String place;           //місце виступу
    int count_listeners;    //кількість слухачів

    public Speech() {
        date = new DataSpeech(0, 0 , 0);
        place = "";
        count_listeners = 0;
    }

    public Speech(DataSpeech date, String place, int count_listeners) {
        this.date = date;
        this.place = place;
        this.count_listeners = count_listeners;
    }

    public Speech(String lastname, String language, int count_collections, DataSpeech date, String place, int count_listeners) {
        super(lastname, language, count_collections);
        this.date = date;
        this.place = place;
        this.count_listeners = count_listeners;
    }


    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Прізвище : ");
        lastname = scanner.nextLine();
        System.out.print("Мова : ");
        language = scanner.nextLine();
        System.out.print("Кількість збірок : ");
        count_collections = scanner.nextInt();
        System.out.println("Дата :");
        date.enterDate();
        System.out.print("Місце виступу : ");
        scanner.nextLine();
        place = scanner.nextLine();
        System.out.print("Кількість слухачів : ");
        count_listeners = scanner.nextInt();
    }

    @Override
    public void output() {
        System.out.println("Прізвище - " + lastname);
        System.out.println("Мова - " + language);
        System.out.println("Кількість збірок - " + count_collections);
        System.out.println("Дата - " + date.toString());
        System.out.println("Місце виступу - " + place);
        System.out.println("Кількість слухачів - " + count_listeners);
    }


    @Override
    public String toString() {
        return date.toString() + '\t' +
                lastname + '\t' +
                language + '\t' +
                count_collections + '\t' +
                place + '\t' +
                count_listeners;
    }

    //гетери
    public DataSpeech getDate() { return date; }
    public String getPlace() { return place; }
    public int getCount_listeners() { return count_listeners; }

    //сетери
    public void setDate(DataSpeech date) { this.date = date; }
    public void setPlace(String place) { this.place = place; }
    public void setCount_listeners(int count_listeners) { this.count_listeners = count_listeners; }

    public static boolean compareTo(Speech a, Speech b) {
        if (a.getDate().years > b.getDate().years ||
                (a.getDate().years == b.getDate().years && a.getDate().month > b.getDate().month) ||
                (a.getDate().years == b.getDate().years && a.getDate().month == b.getDate().month && a.getDate().day > b.getDate().day))
            return true;
        return false;
    }
}
