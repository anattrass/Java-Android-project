package com.example.user.boozetracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 19/12/2016.
 */
public class ViewDrink extends AppCompatActivity {

    TextView drinkNameText;
    TextView dateText;
    TextView timeText;
    TextView locationText;
    Button deleteButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final DBHandler db = ((MainApplication) getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_drink);

        drinkNameText = (TextView)findViewById(R.id.drink_name);
        dateText = (TextView)findViewById(R.id.drink_date);
        timeText = (TextView)findViewById(R.id.drink_time);
        locationText = (TextView)findViewById(R.id.location_of_drink);
        deleteButton = (Button)findViewById(R.id.button_delete);
        backButton = (Button)findViewById(R.id.button_back);
    }

}
