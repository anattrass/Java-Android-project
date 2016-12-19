package com.example.user.boozetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        final int id = extras.getInt("id");
        final String drinkName = extras.getString("Selected Drink Name");
        final String date = extras.getString("Selected Drink Date");
        final String time = extras.getString("Selected Drink Time");
        final String location = extras.getString("Selected Drink Location");

        drinkNameText.setText(drinkName);
        dateText.setText(date);
        timeText.setText(time);
        locationText.setText(location);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ViewDrink: ", "deleting drink with id " + id);
                db.deleteDrink(id);
                backToBoozeTracker();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToBoozeTracker();
            }
        });
    }

    private void backToBoozeTracker() {
        Intent intent = new Intent(ViewDrink.this, BoozeTracker.class);
        startActivity(intent);
    }

}
