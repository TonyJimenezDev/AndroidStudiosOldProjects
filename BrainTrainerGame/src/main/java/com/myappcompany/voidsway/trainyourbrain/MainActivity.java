package com.myappcompany.voidsway.trainyourbrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView firstPageTextView;
    TextView secondPageTimer;
    TextView secondPageCounter;
    TextView secondPageQuestion;
    Button beginButton;
    Button leaderBoardButton;
    Button retryButton;
    ImageView firstPageImageView;
    android.support.v7.widget.GridLayout secondPageGrid;
    ArrayList<Integer> answers = new ArrayList<>();
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Random random = new Random();
    int correctAnswer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beginButton = findViewById(R.id.beginButton);
        firstPageTextView = findViewById(R.id.firstPageTextview);
        firstPageImageView = findViewById(R.id.firstPageImageView);
        secondPageTimer = findViewById(R.id.secondPageTimer);
        secondPageCounter = findViewById(R.id.secondPageCounter);
        secondPageQuestion = findViewById(R.id.secondPageQuestion);
        secondPageGrid = findViewById(R.id.secondPageGrid);
        leaderBoardButton = findViewById(R.id.LeaderBoardButton);
        retryButton = findViewById(R.id.RetryButton);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        final String firstPageString = "Add first page description here";
        firstPageTextView.setText(firstPageString);


        DisableSecondPage();
        EnableFirstPage();
        ChallengeStart();

    }

    public void BeginButton(View view) {
        DisableFirstPage();
    }

    public void RetryButton(View view) {
        Log.i("Retry button clicked", "yes");
    }

    public void SendLeaderBoard(View view) {
        Log.i("LeaderBoard sent", "Sent to leader board");
    }
    public void DisableFirstPage(){
        firstPageImageView.setVisibility(View.INVISIBLE);
        firstPageTextView.setVisibility(View.INVISIBLE);
        beginButton.setVisibility(View.INVISIBLE);
        EnableSecondPage();
    }

    public void EnableFirstPage() {
        firstPageImageView.setVisibility(View.VISIBLE);
        firstPageTextView.setVisibility(View.VISIBLE);
        beginButton.setVisibility(View.VISIBLE);
    }
    public void DisableSecondPage() {
        secondPageCounter.setVisibility(View.INVISIBLE);
        secondPageTimer.setVisibility(View.INVISIBLE);
        secondPageGrid.setVisibility(View.INVISIBLE);
        secondPageQuestion.setVisibility(View.INVISIBLE);
        retryButton.setVisibility(View.INVISIBLE);
        leaderBoardButton.setVisibility(View.INVISIBLE);
    }

    public void EnableSecondPage() {
        secondPageCounter.setVisibility(View.VISIBLE);
        secondPageTimer.setVisibility(View.VISIBLE);
        secondPageGrid.setVisibility(View.VISIBLE);
        secondPageQuestion.setVisibility(View.VISIBLE);

        //////////////////////////// Set visible when game ends //////////////////////////
        retryButton.setVisibility(View.VISIBLE);
        leaderBoardButton.setVisibility(View.VISIBLE);
    }

    public void ChallengeStart() {

        int a = random.nextInt(21);
        int b = random.nextInt(21);
        int sum = a * b;

        secondPageQuestion.setText(Integer.toString(a) + " * " + Integer.toString(b) + " = ?");
        correctAnswer = random.nextInt(4);



        for(int i = 0; i < 4; i++) {
            int incorrectAnswer = random.nextInt(sum) + random.nextInt(-10 + 50 + 1);
            if(correctAnswer == i) {
                answers.add(sum);
            } else {
                answers.add(incorrectAnswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void AnswerQuestion(View view) {

        // Uses string ref with Tag. Matches with correct answer
        if(Integer.toString(correctAnswer).equals(view.getTag().toString())) {
            answers.clear();
            ChallengeStart();
        } else {
            Toast.makeText(this, "Got, it wrong, try again", Toast.LENGTH_SHORT).show();
        }


        // I am able to get the tag name this way keep going
    }
}
