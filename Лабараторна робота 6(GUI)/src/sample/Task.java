package sample;

public class Task {
    /*
    * 22. Дано трьохзначне число х. В ньому закреслили його останню цифру. Після
    цього цифри, які залишилися поміняли місцями і зліва до них дописали закреслену цифру
    числа х. Отримали число 654. Знайти число х.
    Вхідні дані: d = 654 .
    Вихідні дані: х = 456.
    * */
    public static String task1(String line) throws IllegalArgumentException {
        if (!line.matches("\\d+"))
            throw new IllegalArgumentException("Введіть число!");

        if(line.length() != 3)
            throw new IllegalArgumentException("Число 'x' має бути трьохзначним!");

        return replace(line);
    }


    /*
    * 22. Написати програму, яка в залежності від порядкового номера дня тижня (1,2,...7) виводить на екран його назву (понеділок,...)
    * */
    public static String task2(String line) throws IllegalArgumentException {
        if (!line.matches("\\d+"))
            throw new IllegalArgumentException("Введіть число!");

        int nomer = Integer.parseInt(line);
        if(nomer < 1 || nomer > 7)
            throw new IllegalArgumentException("Введено не вірне число!");

        switch (nomer){
            case 1 -> {
                return "Понеділок";
            }
            case 2 -> {
                return "Вівторок";
            }
            case 3 -> {
                return "Середа";
            }
            case 4 -> {
                return "Четверг";
            }
            case 5 -> {
                return "П'ятниця";
            }
            case 6 -> {
                return "Субота";
            }
            case 7 -> {
                return "Неділя";
            }
        }
        return null;
    }

    private static String replace(String string){
        return string.charAt(string.length() - 1) +
                string.substring(1, 2) +
                string.charAt(0);
    }
}
