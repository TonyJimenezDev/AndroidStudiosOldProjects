package com.myappcompany.voidsway.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    int randomNumber;
    int aboveScope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GenerateRandomNum(1,20);
    }

    protected void GenerateRandomNum(int min, int max)
    {
        Random random = new Random();
        randomNumber = random.nextInt((max - min) + 1) + min;
        aboveScope = max;
    }

    public void onButtonClick(View view)
    {
        EditText userInput = findViewById(R.id.user_Input);
        int guess = Integer.parseInt(userInput.getText().toString());

        String popUp;

        if(guess > randomNumber && guess < aboveScope)
        {
            popUp = "Go lower!";
        }
        else if(guess < randomNumber)
        {
            popUp = "Go higher!";
        } else if(guess > aboveScope)
        {
            popUp = "Your guess is not within the scope i gave you";
        }
        else
        {
            popUp = "You got it right! Lets go again!";
            GenerateRandomNum(1,20);
        }
        Toast.makeText(this, popUp, Toast.LENGTH_SHORT).show();
    }
}
