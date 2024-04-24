package model;

public class MyDate {

    private int day;
    private int month;
    private int year;

    /**
     * Method is Constructor of the class
     * @param day, int
     * @param month, int
     * @param year, int
     */

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Method gets day
     * @return day, int
     */

    public int getDay() {
        return day;
    }

    
    /**
     * Method gets month
     * @return month, int
     */

    public int getMonth() {
        return month;
    }

    
    /**
     * Method gets year
     * @return year, int
     */

    public int getYear() {
        return year;
    }

    
    /**
     * Method shows MyDate attributes as string
     * @return str, String
     */

    public String toString() {
        return "\nDay: " + day + "\n Month: " + month + "\n Year: " + year + "\n";
    }
}