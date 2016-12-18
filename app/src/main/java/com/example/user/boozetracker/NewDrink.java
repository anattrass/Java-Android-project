package com.example.user.boozetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user on 18/12/2016.
 */
public class NewDrink extends AppCompatActivity {
    EditText drinkNameEditText;
    EditText dateEditText;
    EditText timeEditText;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DBHandler db = ((MainApplication) getApplication()).db;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_drink);

        drinkNameEditText = (EditText) findViewById(R.id.new_drink_name);
        dateEditText = (EditText) findViewById(R.id.date_of_drink);
        timeEditText = (EditText) findViewById(R.id.time_of_drink);
        saveButton = (Button) findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String drinkName = drinkNameEditText.getText().toString();
                String date = dateEditText.getText().toString();
                String time = timeEditText.getText().toString();

                Booze newBooze = new Booze(drinkName, date, time);
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
