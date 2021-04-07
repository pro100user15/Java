package Task;

import java.util.Scanner;

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
        System.out.print("ПІБ : ");
        fullname = scanner.nextLine();
    }

    //метод для виводу даних
    public void output() {
        System.out.print("E-mail - " + email);
        System.out.print("ПІБ - " + fullname);
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
