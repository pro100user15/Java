package TaskTwo;

import java.io.*;
import java.util.*;

/*
* Розробити консольний застосунок для роботи з базою даних, що зберігається у текстовому файлі
* (початковий масив не менше 10 записів). Структура бази даних описується класом згідно вашого варіанта.
* Передбачити роботу з довільною кількістю записів. Для ідентифікації спроби введення з клавіатури
* некоректних даних описати виключення. Всі поля класу зробити закритими, а доступ до них реалізувати
* через get i set. Реалізувати конструктори з параметрами та без параметрів, а ініціалізацію полів
* виконати через властивості.
*
* Реалізувати методи для:
– додавання записів;
– редагування записів;
– знищення записів;
– виведення інформації з файла на екран;
– пошук потрібної інформації за конкретною ознакою (поле Параметр пошуку);
– сортування за різними полями (поле Параметр сортування).
Меню програми реалізувати по натисненню на певні клавіші:
наприклад, Enter – вихід, п - пошук, р – редагування тощо.
* */

public class Task {
     ArrayList<Movies> movies;

     public Task() throws IOException {
          movies = read_from_file("Movies.txt");
     }

     public void add() throws IOException{
          Movies new_movies = new Movies();
          System.out.println("\nВведіть інформацію :");
          new_movies.input();
          movies.add(new_movies);

          System.out.println("\nЗапись додана!");

          this.write_to_file("Movies.txt");
     }

     public void edit() throws IOException {
          count_note();

          Scanner scanner = new Scanner(System.in);
          System.out.print("\nВведіть порядковий номер фільму, який ви хочете редагувати : ");
          String line = scanner.nextLine();
          if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > movies.size()){
               System.err.println("Не вірно введений номер!");
               this.edit();
               return;
          }
          int nomer = Integer.parseInt(line);
          nomer--;

          System.out.println("\nВідредагуйте :");
          movies.get(nomer).input();
          System.out.println("\nРедагування пройшло успішно!");

          this.write_to_file("Movies.txt");
     }

     public void print() throws IOException {
          count_note();

          int i = 0;
          System.out.println("\nІнформація про фільми :");
          for (var p:
               movies) {
               System.out.println("\nФільм №" + (i + 1) + " :");
               p.print();
               i++;
          }
     }

     public void search() throws IOException {
          count_note();

          Scanner scanner = new Scanner(System.in);
          Date nowdate = new Date();
          System.out.println("\nВведіть рік випуску, який ви шукаєте : ");
          String line = scanner.nextLine();
          if(!line.matches("\\d+") || Integer.parseInt(line) > (nowdate.getYear() + 1900)){
               System.err.println("Не вірно введений день!");
               this.search();
               return;
          }
          int year = Integer.parseInt(line);

          boolean flag = false;
          int i = 0;
          for (var p:
               movies) {
               if(p.getYear() == year) {
                    if(flag == false){
                         System.out.println("\nРезультат : ");
                         flag = true;
                    }
                    System.out.println("Фільм №" + (i + 1) + " :");
                    p.print();
                    System.out.println();
                    i++;
               }
          }

          if(flag == false){
               System.out.println("Пошук не вдалий!");
          }
     }

     public void sort() throws IOException {
          count_note();

          ArrayList<Movies> sortmovies = new ArrayList<Movies>(movies);
          sortmovies.sort(Comparator.comparing(Movies::getYear));

          int i = 0;
          System.out.println("\nВідсортований список :");
          for (var p:
                  sortmovies) {
               System.out.println("\nФільм №" + (i + 1) + " :");
               p.print();
               i++;
          }
     }

     public void delete() throws IOException {
          count_note();

          Scanner scanner = new Scanner(System.in);
          System.out.print("\nВведіть порядковий номер фільму, який ви хочете видалити : ");
          String line = scanner.nextLine();
          if(!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > movies.size()){
               System.err.println("Не вірно введений номер!");
               this.delete();
               return;
          }
          int nomer = Integer.parseInt(line);
          nomer--;

          movies.remove(nomer);
          System.out.println("\nВидалення пройшло успішно!");

          this.write_to_file("Movies.txt");
     }

     public void count_note() throws IOException {
          if(movies.size() == 0)
               throw new IOException("Записів нема!");
     }

     /* Цей метод перевіряє чи файл існує
      * вказаному за шляхом {@param filepath}
      *
      * @param filepath шлях до файлу
      * @throws IOException якщо файлу по шляху {@code filepath} не існує
      * */
     private static void isFile(String filepath) throws IOException{
          //перевірка чи файл існує
          File file = new File(filepath);
          if(!file.isFile()) throw new IOException("Файл не знайдено!");
          //file.createNewFile();
     }

     /* Цей метод записує у файл за шляхом {@param filepath}
      * текст {@param text}
      *
      * @param filepath шлях до файлу
      * @throws IOException якщо файлу по шляху {@code filepath} не існує
      * */
     public void write_to_file(String filepath) throws IOException{
          isFile(filepath);

          BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
          for (var p:
                  movies) {
               output.write(p.to_string());
          }
          output.flush();
          output.close();
          output.close();
     }

     /* Цей метод зчитує з файлу за шляхом {@param filepath}
      *
      * @param filepath шлях до файлу
      * @throws IOException якщо файлу по шляху {@code filepath} не існує
      * @return ArrayList<Movies>
      * */
     private static ArrayList<Movies> read_from_file(String filepath) throws IOException {
          isFile(filepath);

          BufferedReader reader = new BufferedReader(new FileReader(filepath));
          String text;
          ArrayList<Movies> arrayList = new ArrayList<>();
          Movies movies;
          while ((text = reader.readLine()) != null) {
               arrayList.add(new Movies(text, reader.readLine(), Integer.parseInt(reader.readLine()), reader.readLine(), Double.parseDouble(reader.readLine())));
          }
          reader.close();
          return arrayList;
     }
}
