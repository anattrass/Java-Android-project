package com.example.user.boozetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/12/2016.
 */

public class BoozeTracker extends AppCompatActivity {

        ListView listView;
        ImageButton newDrinkButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            listView = (ListView) findViewById(R.id.booze_list);
            newDrinkButton = (ImageButton)findViewById(R.id.button_new);

            final DBHandler db = ((MainApplication)getApplication()).db;

           // db.deleteAllBoozeEntries();
            Log.d("Insert: ", "Inserting..");
           // db.addBooze(new Booze("Pint of Joker I.P.A", "08/12/16", "17:59", "Footlights"));
          //  db.addBooze(new Booze("Vodka Coke", "09/12/16", "18:30", "Moriarty"));


            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, getAllBooze(db));
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selected = (String)listView.getItemAtPosition(position);
                    Log.d("ListView:", selected + " selected");

                    Booze selectedDrink = db.getBooze(position+1);
                    Log.d("Selected Drink: ", "Selected Drink: " + selectedDrink);

                    Intent intent = new Intent(BoozeTracker.this, ViewDrink.class);
                    Log.d("SelectedDrinkInfo", "Selected Drink: drink_info: " + selectedDrink.getDrinkName() +
                            ", "  + selectedDrink.getDate() + ", " + selectedDrink.getTime() + ", " +
                            selectedDrink.getLocation());

                    intent.putExtra("Selected Drink Name", selectedDrink.getDrinkName());
                    intent.putExtra("Selected Drink Date", selectedDrink.getDate());
                    intent.putExtra("Selected Drink Time", selectedDrink.getTime());
                    intent.putExtra("Selected Drink Location", selectedDrink.getLocation());
                    intent.putExtra("Selected Drink ID", selectedDrink.getId());

                    startActivity(intent);
                }
            });


            newDrinkButton.setOnClickListener(new View.OnClickListener() {
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
        }
        return drinks;
    }

}
