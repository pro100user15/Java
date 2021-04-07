package TaskTwo;

/*
Варіант 23
Клас : Колекція фільмів
Поля : Назва, прізвище режисера, рік випуску, кіностудія, тривалість фільму
Параметр сортування : Назва
Параметр пошуку : Рік випуску
* */

import java.util.Scanner;

public class Movies {
    String title;
    String directors_name;
    int year;
    String film_studio;
    double movie_duration;

    public Movies() {
        title = "";
        directors_name = "";
        year = 0;
        film_studio = "";
        movie_duration = 0;
    }

    public Movies(String title, String directors_name, int year, String film_studio, double movie_duration) {
        this.title = title;
        this.directors_name = directors_name;
        this.year = year;
        this.film_studio = film_studio;
        this.movie_duration = movie_duration;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Назва : ");
        title = scanner.nextLine();
        System.out.print("Прізвище режисера : ");
        directors_name = scanner.nextLine();
        System.out.print("Рік випуску : ");
        year = scanner.nextInt();
        System.out.print("Кіностудія : ");
        scanner.nextLine();
        film_studio = scanner.nextLine();
        System.out.print("Тривалість фільму : ");
        movie_duration = scanner.nextDouble();
    }

    public void print() {
        System.out.println("Назва : " + title);
        System.out.println("Прізвище режисера - " + directors_name);
        System.out.println("Рік випуску - " + year);
        System.out.println("Кіностудія - " + film_studio);
        System.out.println("Тривалість фільму - " + movie_duration);
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", directors_name='" + directors_name + '\'' +
                ", year=" + year +
                ", film_studio='" + film_studio + '\'' +
                ", movie_duration=" + movie_duration +
                '}';
    }

    public String to_string() {
        return title + '\n' +
                directors_name + '\n' +
                year + '\n' +
                film_studio + '\n' +
                movie_duration + '\n'
                ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectors_name() {
        return directors_name;
    }

    public void setDirectors_name(String directors_name) {
        this.directors_name = directors_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFilm_studio() {
        return film_studio;
    }

    public void setFilm_studio(String film_studio) {
        this.film_studio = film_studio;
    }

    public double getMovie_duration() {
        return movie_duration;
    }

    public void setMovie_duration(double movie_duration) {
        this.movie_duration = movie_duration;
    }
}
