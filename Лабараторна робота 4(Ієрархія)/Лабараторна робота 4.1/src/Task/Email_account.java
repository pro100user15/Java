package Task;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_account {
    String email;       //E-mail
    String fullname;    //ПІБ власника

    //конструктор без параметрів
    public Email_account() {
        email = "";
        fullname = "";
    }

    //конструктор з параметрами
    public Email_account(String email, String fullname) {
        this.email = email;
        this.fullname = fullname;
    }

    //метод для вводу даних
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
    }

    //метод для виводу даних
    public void output() {
        System.out.println("E-mail - " + email);
        System.out.println("ПІБ - " + fullname);
    }

    //перевизначення методу toString()
    @Override
    public String toString() {
        return "Email_account{" +
                "email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    //гетери
    public String getEmail() {return email;}
    public String getFullname() {return fullname;}

    //сетери
    public void setEmail(String email) {this.email = email;}
    public void setFullname(String fullname) {this.fullname = fullname;}
}
