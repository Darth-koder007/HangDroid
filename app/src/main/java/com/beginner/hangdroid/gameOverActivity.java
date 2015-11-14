package com.beginner.hangdroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class gameOverActivity extends AppCompatActivity {

    int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int points = getIntent().getIntExtra("POINTS_IDENTIFIER",0);
        TextView textViewPoints = (TextView) findViewById(R.id.TextScore);
        textViewPoints.setText(String.valueOf(points)+" POINTS");
        mPoints=points;


    }

    public void saveScore(View v){

        SharedPreferences preferences = getSharedPreferences("HYPREFERENCES",Context.MODE_PRIVATE);
        EditText editText = (EditText) findViewById(R.id.editTextName);
        String name = editText.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        String previousScores = preferences.getString("SCORES","");
        editor.putString("SCORES", name + " " + mPoints + "Points \n" + previousScores);
        editor.commit();

        finish();
    }

}
