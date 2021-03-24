import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*23. Описати клас для бази зданих з інформацією про клієнтів банку з полями:
дата проведення операції прізвище та ім’я, № рахунку, сума безготівкового
отримання/переведення, отримано/видано готівкою, залишок вкладу.
Вивести на екран у формі таблиці дані про клієнтів банку,
які на протязі заданого періоду часу виконали безготівкове переведення на загальну суму,
яка перевищує задане користувачем граничне значення.*/

public class Operation {
    OperationDate date;
    String name;
    String surname;
    int nomer;
    double suma;
    double score;

    Date nowdate = new Date();

    public Operation() {
        date = new OperationDate();
        name = "";
        surname = "";
        nomer = 0;
        suma = 0;
        score = 0;
    }

    public Operation(int day, int month, int years, String name, String surname, int nomer, double suma, double score) {
        this.date = new OperationDate(day, month, years);
        this.name = name;
        this.surname = surname;
        this.nomer = nomer;
        this.suma = suma;
        this.score = score;
    }

    public void input() throws IOException{
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть дату :");
        System.out.print("День : ");
        String day = scanner.nextLine();
        if(!day.matches("\\d+") || Integer.parseInt(day) > 31)
            throw new IOException("Не вірно введений день!");

        System.out.print("Місяць : ");
        String month = scanner.nextLine();
        if(!month.matches("\\d+") || Integer.parseInt(month) > 12)
            throw new IOException("Не вірно введений місяць!");
        System.out.print("Рік : ");
        String years = scanner.nextLine();

        if(!years.matches("\\d+") || Integer.parseInt(years) > (nowdate.getYear() + 1900))
            throw new IOException("Уведений не вірний рік!");

        if((Integer.parseInt(years) == (nowdate.getYear() + 1900))
                && (Integer.parseInt(month) > nowdate.getMonth() + 1)
                || ((Integer.parseInt(month) == nowdate.getMonth() + 1) && (Integer.parseInt(day) > nowdate.getDate())))
            throw new IOException("Не вірно введена дата!");

        date = new OperationDate(Integer.parseInt(years), Integer.parseInt(month), Integer.parseInt(day));

        System.out.print("Ім'я : ");
        name = scanner.nextLine();
        System.out.print("Прізвище : ");
        surname = scan.nextLine();
        System.out.print("Номер : ");
        nomer = scanner.nextInt();
        System.out.print("Зняття з рахунку : ");
        suma = scanner.nextDouble();
        System.out.print("Залишок вкладу : ");
        score = scanner.nextDouble();
    }

    public void output(){

    }

    @Override
    public String toString() {
        return date.toString() +
                "\t" + name +
                "\t" + surname +
                "\t" + nomer +
                "\t" + suma +
                "\t" + score
                ;
    }

    public OperationDate getDate() {
        return date;
    }

    public void setDate(OperationDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}