package com.example.user.boozetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by user on 18/12/2016.
 */
public class NewDrink extends AppCompatActivity {
    EditText drinkNameEditText;
    EditText dateEditText;
    EditText timeEditText;
    EditText locationEditText;
    ImageButton saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication) getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_drink);

        drinkNameEditText = (EditText) findViewById(R.id.new_drink_name);
        dateEditText = (EditText) findViewById(R.id.date_of_drink);
        timeEditText = (EditText) findViewById(R.id.time_of_drink);
        locationEditText = (EditText) findViewById(R.id.drink_location);
        saveButton = (ImageButton) findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(NewDrink.this, R.string.new_drink_toast, Toast.LENGTH_LONG).show();
                String drinkName = drinkNameEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String time = timeEditText.getText().toString();
                String location = locationEditText.getText().toString();

                Booze newBooze = new Booze(drinkName, date, time, location);
                db.addBooze(newBooze);
                backToBoozeTracker();
            }
        });

    }

    private void backToBoozeTracker() {
        Intent intent = new Intent(NewDrink.this, BoozeTracker.class);
        startActivity(intent);
    }
}
