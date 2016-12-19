package com.example.user.boozetracker;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/12/2016.
 */
public class BoozeTest {

    Booze booze;

    @Before
    public void before() {
        booze = new Booze("Gin and Tonic", "16/12/16", "15:59", "Pub");
    }

    @Test
    public void getDrinkName() {
        assertEquals("Gin and Tonic", booze.getDrinkName());
    }

    @Test
    public void setDrinkName() {
        booze.setDrinkName("White Russian");
        assertEquals("White Russian", booze.getDrinkName());
    }

    @Test
    public void getDate() {
        assertEquals("16/12/16", booze.getDate());
    }

    @Test
    public void setDate() {
        booze.setDate("25/12/15");
        assertEquals("25/12/15", booze.getDate());
    }

    @Test
    public void getTime() {
        assertEquals("15:59", booze.getTime());
    }

    @Test
    public void setTime() {
        booze.setTime("16:20");
        assertEquals("16:20", booze.getTime());
    }

    @Test
    public void getLocation() {
        assertEquals("Pub", booze.getLocation());
    }

    @Test
    public void setLocation() {
        booze.setLocation("The Crown");
        assertEquals("The Crown", booze.getLocation());
    }

}
