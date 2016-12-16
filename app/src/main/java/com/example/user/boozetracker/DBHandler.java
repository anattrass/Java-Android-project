package com.example.user.boozetracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sandy on 05/09/2016.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "booze_tracker";
    private static final String TABLE_BOOZE = "drinks_drunk";
    private static final String KEY_ID = "id";
    private static final String KEY_DRINK_NAME = "drink name";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}