import java.util.Date;

/*23. Описати клас для бази зданих з інформацією про клієнтів банку з полями:
дата проведення операції прізвище та ім’я, № рахунку, сума безготівкового
отримання/переведення, отримано/видано готівкою, залишок вкладу.
Вивести на екран у формі таблиці дані про клієнтів банку,
які на протязі заданого періоду часу виконали безготівкове переведення на загальну суму,
яка перевищує задане користувачем граничне значення.*/

public class Movies {
    Date date;
    String name;
    String surname;
    int nomer;
    double suma;
    double score;

    public Movies() {
        date = new Date(0,0,0);
        name = "";
        surname = "";
        nomer = 0;
        suma = 0;
        score = 0;
    }

    public Movies(Date date, String name, String surname, int nomer, double suma, double score) {
        this.date = date;
        this.name = name;
        this.surname = surname;
        this.nomer = nomer;
        this.suma = suma;
        this.score = score;
    }

    public void input(){

    }

    public void output(){

    }

    @Override
    public String toString() {
        return "Movies{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nomer=" + nomer +
                ", suma=" + suma +
                ", score=" + score +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
