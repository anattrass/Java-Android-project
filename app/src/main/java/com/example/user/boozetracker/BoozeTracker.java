package com.example.user.boozetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */

public class BoozeTracker extends AppCompatActivity {

        ListView ListView;
        Button NewDrinkButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ListView = (ListView) findViewById(R.id.booze_list);
            NewDrinkButton = (Button)findViewById(R.id.button_new);

            final DBHandler db = ((MainApplication)getApplication()).db;

//            db.deleteAllBoozeEntries();
            Log.d("Insert: ", "Inserting..");
            db.addBooze(new Booze("Pint of Joker I.P.A", "08/12/16", "17:59"));
            db.addBooze(new Booze("Vodka Coke", "09/12/16", "18:30"));
            db.addBooze(new Booze("Mulled Wine", "10/12/16", "19:00"));


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, getAllBooze(db));
            ListView.setAdapter(adapter);

            NewDrinkButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("BoozeTracker: ", "new drink button clicked");
                    Intent intent = new Intent(BoozeTracker.this, NewDrink.class);
                    startActivity(intent);
                }
            });
        }

    private ArrayList<String> getAllBooze(DBHandler db) {
        ArrayList<String> drinks = new ArrayList<String>();

        ArrayList<Booze> booze = db.getAllBooze();
        for (Booze drink : booze) {
            drinks.add(drink.getDrinkName());
            drinks.add(drink.getDate());
            drinks.add(drink.getTime());
        }
        return drinks;
    }

}
