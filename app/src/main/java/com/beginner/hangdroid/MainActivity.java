package com.beginner.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

  public void startSinglePlayerGame(View view){

      Intent myIntent = new Intent(this,GameActivity.class);
      startActivity(myIntent);

  }

  public void startMultiPlayerGame(View v){
      Intent myIntent = new Intent(this,activity_multiplayer.class);
      startActivity(myIntent);
  }

    public void OpenScores(View v){

        Intent myIntent = new Intent(this,ScoresActivity.class);
        startActivity(myIntent);
    }
}
