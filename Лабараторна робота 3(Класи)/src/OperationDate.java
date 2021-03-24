public class OperationDate {
    int day;
    int month;
    int years;

    public OperationDate() {
        day = 0;
        month = 0;
        years = 0;
    }
    public OperationDate(int day, int month, int years) {
        this.day = day;
        this.month = month;
        this.years = years;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + years;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
