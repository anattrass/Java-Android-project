package com.example.user.boozetracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "booze_tracker";
    private static final String TABLE_BOOZE = "drinks_drunk";
    private static final String KEY_ID = "id";
    private static final String KEY_DRINK_NAME = "drink";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_LOCATION = "location";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_BOOZE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DRINK_NAME + " TEXT,"
                + KEY_DATE + " TEXT, " + KEY_TIME + " TEXT," + KEY_LOCATION + " TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOZE);
        onCreate(db);
    }

    private void runSQL(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void addBooze (Booze booze) {
        String drinkName = booze.getDrinkName();
        String date = booze.getDate();
        String time = booze.getTime();
        String location = booze.getLocation();

        String sql = "INSERT INTO " + TABLE_BOOZE +
                "(" + KEY_DRINK_NAME + "," + KEY_DATE + "," + KEY_TIME + "," + KEY_LOCATION + ") " + "VALUES ('"
                + drinkName + "','" + date + "','" + time + "','" + location + "')";
        runSQL(sql);
    }

    public Booze getBooze(int id) {
        String sql = "SELECT * FROM " + TABLE_BOOZE + " WHERE " + KEY_ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Booze booze = getBoozeFromDBCursor(cursor);
            return booze;
        }
        return null;
    }

    public Booze getBooze(String drinkName) {
        String sql = "SELECT * FROM " + TABLE_BOOZE + " WHERE " + KEY_DRINK_NAME + " = '" + drinkName + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();

            Booze booze = getBoozeFromDBCursor(cursor);
            return booze;
        }
        return null;
    }

    public ArrayList<Booze> getAllBooze() {
        ArrayList<Booze> boozeList = new ArrayList<Booze>();

        String sql = "SELECT * FROM " + TABLE_BOOZE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Booze booze = getBoozeFromDBCursor(cursor);
                boozeList.add(booze);
            } while (cursor.moveToNext());
        }

        return boozeList;
    }

    public void deleteDrink(Booze booze) {
        int id = booze.getId();

        String sql = "DELETE FROM " + TABLE_BOOZE + " WHERE " + KEY_ID + " = " + id;
        runSQL(sql);
    }

    public void deleteDrink(int id) {
        String sql = "DELETE FROM " + TABLE_BOOZE + " WHERE " + KEY_ID + " = " + id;
        runSQL(sql);
    }

    public void deleteAllBoozeEntries() {
        String sql = "DELETE FROM " + TABLE_BOOZE;
        runSQL(sql);
    }

    private Booze getBoozeFromDBCursor(Cursor cursor) {

        int idColumnNum = cursor.getColumnIndex(KEY_ID);
        int drinkNameColumnNum = cursor.getColumnIndex(KEY_DRINK_NAME);
        int dateColumnNum = cursor.getColumnIndex(KEY_DATE);
        int timeColumnNum = cursor.getColumnIndex(KEY_TIME);
        int locationColumnNum = cursor.getColumnIndex(KEY_LOCATION);

        int id = Integer.parseInt(cursor.getString(idColumnNum));
        String drinkName = cursor.getString(drinkNameColumnNum);
        String date = cursor.getString(dateColumnNum);
        String time = cursor.getString(timeColumnNum);
        String location = cursor.getString(locationColumnNum);

        Booze booze = new Booze(id, drinkName, date, time, location);

        return booze;
    }

}