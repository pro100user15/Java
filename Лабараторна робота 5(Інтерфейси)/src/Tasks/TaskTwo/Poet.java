package Tasks.TaskTwo;

import java.io.Serializable;

public abstract class Poet implements Serializable {
    String lastname;            //прізвище
    String language;            //мова
    int count_collections;      //кількість збірок

    public Poet() {
        lastname = "";
        language = "";
        count_collections = 0;
    }
    public Poet(String lastname, String language, int count_collections) {
        this.lastname = lastname;
        this.language = language;
        this.count_collections = count_collections;
    }


    public abstract void input();

    public abstract void output();


    @Override
    public String toString() {
        return "Poet{" +
                "lastname='" + lastname + '\'' +
                ", language='" + language + '\'' +
                ", count_collections=" + count_collections +
                '}';
    }

    //гетери
    public String getLastname() { return lastname; }
    public String getLanguage() { return language; }
    public int getCount_collections() { return count_collections; }

    //сетери
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setLanguage(String language) { this.language = language; }
    public void setCount_collections(int count_collections) { this.count_collections = count_collections; }
}
