package com.beginner.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameMulti extends AppCompatActivity {
    String mWord;
    int mFailCounter = 0;
    int mGuessedLetters = 0;
    int mPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_multi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String wordSent=getIntent().getStringExtra("WORD_IDENTIFIER");
        mWord=wordSent;
        createTextViews(mWord);

            }


    public void checkLetter(String letter) {
        char IntroducedLetter = letter.charAt(0);
        boolean guessed = false;
        for (int i = 0; i < mWord.length(); i++) {
            char FromTheWord = mWord.charAt(i);
            if (FromTheWord == (IntroducedLetter)) {
                guessed = true;
                showLettersAtIndex(i, IntroducedLetter);
                mGuessedLetters++;
            }


        }

        if (guessed == false) {
            letterFail(Character.toString(IntroducedLetter));

        }

        if (mGuessedLetters == mWord.length()) {
            mPoints++;
            clearScreen();
        }
    }

    public void clearScreen() {

        TextView fail = (TextView) findViewById(R.id.triedLetter);
        fail.setText("");
        mFailCounter = 0;
        mGuessedLetters = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutAddLetters);

        for (int i = 0; i < layoutLetters.getChildCount(); i++) {
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }


        ImageView imageView = (ImageView) findViewById(R.id.image_game);
        imageView.setImageResource(R.drawable.hangdroid_0);

        Intent myIntent = new Intent(this,activity_multiplayer.class);
        startActivity(myIntent);
    }


    public void showLettersAtIndex(int position, char letterGuessed) {
        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutAddLetters);
        TextView textView = (TextView) layoutLetters.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));

    }

    public void letterFail(String fail) {

        TextView failView = (TextView) findViewById(R.id.triedLetter);

        String previousFail = failView.getText().toString();
        failView.setText(previousFail + fail);

        mFailCounter++;
        ImageView imageFail = (ImageView) findViewById(R.id.image_game);

        if (mFailCounter == 1) {
            imageFail.setImageResource(R.drawable.hangdroid_1);
        } else if (mFailCounter == 2) {
            imageFail.setImageResource(R.drawable.hangdroid_2);
        } else if (mFailCounter == 3) {
            imageFail.setImageResource(R.drawable.hangdroid_3);
        } else if (mFailCounter == 4) {
            imageFail.setImageResource(R.drawable.hangdroid_4);
        } else if (mFailCounter == 5) {
            imageFail.setImageResource(R.drawable.hangdroid_5);
        } else if (mFailCounter == 6) {
            imageFail.setImageResource(R.drawable.hangdroid_go);
            clearScreen();

            Intent gameOverIntent = new Intent(this, gameOverActivity.class);
            gameOverIntent.putExtra("POINTS_IDENTIFIER", mPoints);
            startActivity(gameOverIntent);
        }
    }

    public void createTextViews(String word){
      LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutAddLetters);

        for(int i=0;i<word.length();i++)
        {
            TextView newTextView = (TextView) getLayoutInflater().inflate(R.layout.textview,null);
            layoutLetters.addView(newTextView);
        }
    }

    public void introduceLetterM(View v) {
        EditText inputLetter = (EditText) findViewById(R.id.letterEnter);
        String letter = inputLetter.getText().toString();
        inputLetter.setText("");
        if (letter.length() > 0) {
            checkLetter(letter.toUpperCase());
        } else {
            Toast.makeText(this, "Please Enter Letter", Toast.LENGTH_SHORT).show();
        }
    }

}
