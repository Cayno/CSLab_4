public class Date {
    private int month;
    private int day ;
    private int year;


    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // set methods
    public void setMonth(int month) {
        if (month < 1 ||month > 12) {
            throw new IllegalArgumentException("Month must be 1-12");
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be 1-31");
        }
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // get methods
    public int getMonth() {return month;}
    public int getDay() {return day;}
    public int getYear() {return year;}
    public String toString() {
        return String.format("%s%s%s%s%s", 
        getMonth(), "/", getDay(), "/", getYear());
     } 
}




