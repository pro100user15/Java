package Task;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spam extends Email_account {
    DateSpam date;          //Дата
    int amount;             //Кількість спам повідомлень
    int all_amount_spam;    //Загальна кількість повідомлень

    //конструктор без параметрів
    public Spam() {
        date = new DateSpam();
        amount = 0;
        all_amount_spam = 0;
    }

    //конструктор з параметрами
    public Spam(int d, int m, int y, int amount, int all_amount_spam) {
        this.date = new DateSpam(d,m,y);
        this.amount = amount;
        this.all_amount_spam = all_amount_spam;
    }

    //конструктор з параметрами
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
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = p.matcher(email);
        if(!m.matches()) {
            System.err.println("Не вірно введений E-mail!");
            this.input();
            return;
        }
        System.out.print("ПІБ : ");
        fullname = scanner.nextLine();
        System.out.println("Дату : ");
        date.inputDate();
        System.out.print("Кількість спам повідомлень : ");
        amount = scanner.nextInt();
        System.out.print("Загальна кількість повідомлень : ");
        all_amount_spam = scanner.nextInt();
    }

    //метод для виводу даних
    @Override
    public void output() {
        System.out.println("E-mail - " + email);
        System.out.println("ПІБ - " + fullname);
        System.out.println("Дату - " + date.toString());
        System.out.println("Кількість спам повідомлень - " + amount);
        System.out.println("Загальна кількість повідомлень - " + all_amount_spam);
    }

    //перевизначення методу toString()
    @Override
    public String toString() {
        return email + '\t' +
                fullname + '\t' +
                date + '\t' +
                amount + '\t' +
                all_amount_spam;
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