package com.example.user.boozetracker;

/**
 * Created by user on 16/12/2016.
 */
public class Booze {
    private int id;
    private String drinkName;
    private String date;
    private String time;

    public Booze() {
    }

    public Booze(int id, String drinkName, String date, String time) {
        this.id = id;
        this.drinkName = drinkName;
        this.date = date;
        this.time = time;
    }

    public Booze(String drinkName, String date, String time) {
        this.drinkName = drinkName;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Booze: " + drinkName + ". Date: " + date + ". Time " + time;
    }
}
