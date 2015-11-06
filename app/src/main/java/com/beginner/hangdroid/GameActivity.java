package com.beginner.hangdroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    String mWord = "WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void introduceLetter(View v) {
        EditText inputLetter = (EditText) findViewById(R.id.letterEnter);
        String letter = inputLetter.getText().toString();
        if (letter.length() == 1) {
            checkLetter(letter);
        } else {
            Toast.makeText(this, "Please Enter Letter", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLetter(String letter) {
        char IntroducedLetter = letter.charAt(0);
        for (int i = 0; i < mWord.length(); i++) {
            char FromTheWord = mWord.charAt(i);
            if (FromTheWord == (IntroducedLetter)) {
                showLettersAtIndex(i, IntroducedLetter);
            }
        }
    }

    public void showLettersAtIndex(int position, char letterGuessed) {
        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutAddLetters);
        TextView textView = (TextView) layoutLetters.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));
    }
}


