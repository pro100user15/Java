package TaskOne;

import java.util.Date;
import java.util.Scanner;

public class OperationDate {
    int day;
    int month;
    int years;

    public OperationDate() {
        day = 0;
        month = 0;
        years = 0;
    }
    public OperationDate(int day, int month, int years) {
        this.day = day;
        this.month = month;
        this.years = years;
    }

    public void enterDate() {
        Scanner scanner = new Scanner(System.in);
        Date nowdate = new Date();
        System.out.println("Введіть дату :");
        System.out.print("Введіть день :");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 31) {
            System.err.println("Не вірно введений день!");
            this.enterDate();
            return;
        }
        day = Integer.parseInt(line);

        System.out.print("Введіть місяць :");
        line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) < 0 || Integer.parseInt(line) > 12) {
            System.err.println("Не вірно введений місяць!");
            this.enterDate();
            return;
        }
        month = Integer.parseInt(line);

        System.out.print("Введіть рік :");
        line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) > (nowdate.getYear() + 1900)) {
            System.err.println("Не вірно введений рік!");
            this.enterDate();
            return;
        }
        years = Integer.parseInt(line);

        if ((years == (nowdate.getYear() + 1900))
                && ((month > nowdate.getMonth() + 1)
                || ((month == nowdate.getMonth() + 1) && (day > nowdate.getDate())))) {
            System.err.println("Не вірно введений рік!");
            this.enterDate();
            return;
        }

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

    public boolean better(OperationDate date){
        if(this.years > date.years ||
                (this.years == date.years && this.month > date.month) ||
                (this.years == date.years && this.month == date.month && this.day > date.day))
            return true;
        return false;
    }

    public boolean equally(OperationDate date){
        if(this.years == date.years && this.month == date.month && this.day == date.day)
            return true;
        return false;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
