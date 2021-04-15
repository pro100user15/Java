package Task;

import java.util.Date;
import java.util.Scanner;

public class DateSpam {
    int day;
    int month;
    int years;

    //конструктор без параметрів
    public DateSpam() {
        day = 0;
        month = 0;
        years = 0;
    }

    //конструктор з параметрами
    public DateSpam(int day, int month, int years) {
        this.day = day;
        this.month = month;
        this.years = years;
    }

    //метод для вводу дати
    public void inputDate() {
        Scanner scanner = new Scanner(System.in);
        Date nowdate = new Date();
        System.out.print("Введіть день : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 31) {
            System.err.println("Не вірно введений день!");
            this.inputDate();
            return;
        }
        day = Integer.parseInt(line);

        System.out.print("Введіть місяць : ");
        line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 12) {
            System.err.println("Не вірно введений місяць!");
            this.inputDate();
            return;
        }
        month = Integer.parseInt(line);

        System.out.print("Введіть рік : ");
        line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) > (nowdate.getYear() + 1900)) {
            System.err.println("Не вірно введений рік!");
            this.inputDate();
            return;
        }
        years = Integer.parseInt(line);

        if ((years == (nowdate.getYear() + 1900))
                && ((month > nowdate.getMonth() + 1)
                || ((month == nowdate.getMonth() + 1) && (day > nowdate.getDate())))) {
            System.err.println("Не вірно введений рік!");
            this.inputDate();
            return;
        }

        switch (month) {
            case 2:
                if (day > 28) {
                    System.err.println("В Лютому тільки 28 днів!");
                    this.inputDate();
                    return;
                }
            case 4:
                if (day > 30) {
                    System.err.println("В Квітні тільки 30 днів!");
                    this.inputDate();
                    return;
                }
            case 6:
                if (day > 30) {
                    System.err.println("В Червні тільки 30 днів!");
                    this.inputDate();
                    return;
                }
            case 9:
                if (day > 30) {
                    System.err.println("В Вересні тільки 30 днів!");
                    this.inputDate();
                    return;
                }
            case 11:
                if (day > 30) {
                    System.err.println("В Листопаді тільки 30 днів!");
                    this.inputDate();
                }
        }
    }


    public boolean better(DateSpam date) {
        if (this.years > date.years ||
                (this.years == date.years && this.month > date.month) ||
                (this.years == date.years && this.month == date.month && this.day > date.day))
            return true;
        return false;
    }

    public boolean equally(DateSpam date) {
        if (this.years == date.years && this.month == date.month && this.day == date.day)
            return true;
        return false;
    }

    //перевизначення методу toString()
    @Override
    public String toString() {
        return day + "." + month + "." + years;
    }

    public String to_string() {
        return day + "\n" +
                month + "\n" +
                years
                ;
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
