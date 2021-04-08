package Task;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Scanner;

public class Spam extends Email_account {
    DateSpam date;
    int amount;
    int all_amount_spam;

    public Spam() {
        date = new DateSpam();
        amount = 0;
        all_amount_spam = 0;
    }

    public Spam(int d, int m, int y, int amount, int all_amount_spam) {
        this.date = new DateSpam(d,m,y);
        this.amount = amount;
        this.all_amount_spam = all_amount_spam;
    }

    public Spam(String email, String fullname, int d, int m, int y, int amount, int all_amount_spam) {
        super(email, fullname);
        this.date = new DateSpam(d,m,y);
        this.amount = amount;
        this.all_amount_spam = all_amount_spam;
    }

    //метод для вводу даних
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("E-mail : ");
        email = scanner.nextLine();
        System.out.print("ПІБ : ");
        fullname = scanner.nextLine();
    }

    //метод для виводу даних
    @Override
    public void output() {
        System.out.print("E-mail - " + email);
        System.out.print("ПІБ - " + fullname);
    }

    @Override
    public String toString() {
        return "Spam{" +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                "date=" + date +
                ", amount=" + amount +
                ", all_amount_spam=" + all_amount_spam +
                '}';
    }

    public String to_string() {
        return email + '\n' +
                fullname + '\n' +
                date.to_string() + '\n' +
                amount + '\n' +
                all_amount_spam + '\n'
                ;
    }

    //гетери
    public DateSpam getDate() {
        return date;
    }
    public int getAmount() {
        return amount;
    }
    public int getAll_amount_spam() {
        return all_amount_spam;
    }

    //сетери
    public void setDate(DateSpam date) {
        this.date = date;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setAll_amount_spam(int all_amount_spam) {
        this.all_amount_spam = all_amount_spam;
    }
}