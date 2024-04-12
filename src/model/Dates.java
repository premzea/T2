package model;

public class Dates{

    private int day;
    private int month;
    private int year;

    public Dates(int day, int month,  int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString(){
        return "\nDay: " + day + "\n Month: " + month + "\n Year: " + year + "\n";
    }
}