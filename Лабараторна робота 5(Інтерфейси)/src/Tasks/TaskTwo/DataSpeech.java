package Tasks.TaskTwo;

import java.io.Serializable;
import java.util.Scanner;

public class DataSpeech implements Serializable {
    int day;
    int month;
    int years;

    public DataSpeech() {
        day = 0;
        month = 0;
        years = 0;
    }

    public DataSpeech(int day, int month, int years) {
        this.day = day;
        this.month = month;
        this.years = years;
    }

    public void enterDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("День : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 31) {
            System.err.println("Не вірно введений день!");
            this.enterDate();
            return;
        }
        day = Integer.parseInt(line);

        System.out.print("Місяць : ");
        line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 12) {
            System.err.println("Не вірно введений місяць!");
            this.enterDate();
            return;
        }
        month = Integer.parseInt(line);

        System.out.print("Рік : ");
        line = scanner.nextLine();
        if (!line.matches("\\d+")) {
            System.err.println("Не вірно введений рік!");
            this.enterDate();
            return;
        }
        years = Integer.parseInt(line);

        switch (month) {
            case 2:
                if (day > 28) {
                    System.err.println("В Лютому тільки 28 днів!");
                    this.enterDate();
                    return;
                }
            case 4:
                if (day > 30) {
                    System.err.println("В Квітні тільки 30 днів!");
                    this.enterDate();
                    return;
                }
            case 6:
                if (day > 30) {
                    System.err.println("В Червні тільки 30 днів!");
                    this.enterDate();
                    return;
                }
            case 9:
                if (day > 30) {
                    System.err.println("В Вересні тільки 30 днів!");
                    this.enterDate();
                    return;
                }
            case 11:
                if (day > 30) {
                    System.err.println("В Листопаді тільки 30 днів!");
                    this.enterDate();
                }
        }
    }

    @Override
    public String toString() {
        return day + "." + month + "." + years;
    }

    public boolean better(DataSpeech date) {
        if (this.years > date.years ||
                (this.years == date.years && this.month > date.month) ||
                (this.years == date.years && this.month == date.month && this.day > date.day))
            return true;
        return false;
    }

    public boolean equally(DataSpeech date) {
        if (this.years == date.years && this.month == date.month && this.day == date.day)
            return true;
        return false;
    }

    //гетери
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYears() {
        return years;
    }

    //сетери
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYears(int years) {
        this.years = years;
    }
}
