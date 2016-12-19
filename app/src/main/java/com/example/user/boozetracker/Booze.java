package com.example.user.boozetracker;

/**
 * Created by user on 16/12/2016.
 */
public class Booze {
    private int id;
    private String drinkName;
    private String date;
    private String time;
    private String location;

    public Booze() {
    }

    public Booze(int id, String drinkName, String date, String time, String location) {
        this.id = id;
        this.drinkName = drinkName;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Booze(String drinkName, String date, String time, String location) {
        this.drinkName = drinkName;
        this.date = date;
        this.time = time;
        this.location = location;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Booze: " + drinkName + ". Date: " + date + ". Time: " + time + ". Location: " + location;
    }
}
