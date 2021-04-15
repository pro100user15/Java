package Task;

public abstract class Email_account {
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
    public abstract void input();

    //метод для виводу даних
    public abstract void output();

    //гетери
    public String getEmail() {return email;}
    public String getFullname() {return fullname;}

    //сетери
    public void setEmail(String email) {this.email = email;}
    public void setFullname(String fullname) {this.fullname = fullname;}
}
