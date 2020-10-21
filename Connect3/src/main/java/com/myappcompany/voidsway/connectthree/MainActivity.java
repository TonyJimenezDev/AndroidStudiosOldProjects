package com.myappcompany.voidsway.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Active = yellow 0 | Inactive = red 1 | Empty = 2
    Boolean playingGame = true;
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningSpots = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}};

    public void DropIn(View view) {

        ImageView smiley = (ImageView) view;

        int tappedSmiley = Integer.parseInt(smiley.getTag().toString());

        if (gameState[tappedSmiley] == 2 && playingGame) {

            gameState[tappedSmiley] = activePlayer;

            smiley.setTranslationY(-1200);

            if (activePlayer == 0) {
                smiley.setImageResource(R.drawable.yellowsmileface);
                activePlayer = 1;
            } else {
                smiley.setImageResource(R.drawable.redsmileface);
                activePlayer = 0;
            }

            smiley.animate().translationYBy(1200).rotationBy(600).setDuration(600);

            for (int[] winningSpot : winningSpots) {
                if (gameState[winningSpot[0]] == gameState[winningSpot[1]] &&
                        gameState[winningSpot[1]] == gameState[winningSpot[2]] &&
                        gameState[winningSpot[0]] != 2) {

                    String winner;
                    ImageView yellow = findViewById(R.id.imageView9);
                    ImageView red = findViewById(R.id.imageView10);

                    //Active player becomes 1 after clicking
                    if (activePlayer == 1) {
                        winner = "Yellow SmileyFace Wins!!!";
                        yellow.animate().translationXBy(650).setDuration(300);
                        red.animate().translationYBy(1500).rotation(1600).setDuration(3600);


                    } else {
                        winner = "Red SmileyFace Wins!!!";
                        red.animate().translationXBy(-650).setDuration(300);
                        yellow.animate().translationYBy(1500).rotation(1600).setDuration(3600);
                    }

                    playingGame = false;
                    TextView fightText = findViewById(R.id.textView2);
                    Button Restart = findViewById(R.id.restartButton);
                    TextView winnerTextView = findViewById(R.id.textView);
                    winnerTextView.setText(winner);
                    fightText.setVisibility(View.INVISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                    Restart.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void PlayAgain(View view) {
        Button Restart = findViewById(R.id.restartButton);
        TextView winnerTextView = findViewById(R.id.textView);
        ImageView yellow = findViewById(R.id.imageView9);
        ImageView red = findViewById(R.id.imageView10);
        TextView fightText = findViewById(R.id.textView2);

        winnerTextView.setVisibility(View.INVISIBLE);
        Restart.setVisibility(View.INVISIBLE);
        fightText.setVisibility(View.VISIBLE);

        android.support.v7.widget.GridLayout gridLayout = findViewById(R.id.board);

        yellow.animate().translationX(0).translationY(0).rotation(0).setDuration(1);
        red.animate().translationY(0).translationX(0).rotation(0).setDuration(1);

        for(int i = 0; i<gridLayout.getChildCount(); i++) {
            ImageView smileyFaces = (ImageView) gridLayout.getChildAt(i);

            smileyFaces.setImageDrawable(null);
        }
        for(int x = 0; x < gameState.length; x++){
            gameState[x] = 2;
        }
        activePlayer = 0;
        playingGame = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
