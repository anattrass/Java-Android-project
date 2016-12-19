package com.example.user.boozetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by user on 19/12/2016.
 */
public class Home extends AppCompatActivity {

    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }


    public void enterBoozeTracker(View view) {
        Intent intent = new Intent(this, BoozeTracker.class);
        startActivity(intent);
    }

}
