package com.example.android.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    char[] lettersAndNumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button helpButton;
    Button replayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
    }



    public void initializeButtons() {
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        helpButton = (Button) findViewById(R.id.helpButton);
        replayButton = (Button) findViewById(R.id.replayButton);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        replayButton.setOnClickListener(this);
/*
        ArrayList usedChars = new ArrayList();
        Random r = new Random();
        int firstInt = r.nextInt();
        usedChars.add(firstInt);
        for(int i = 0; i<3; i++) {
            int randInt = r.nextInt();
            if(usedChars.contains(randInt)) {
                i--;
            } else {
                usedChars.add(randInt);
            }
        }
        char correctChar = lettersAndNumbers[firstInt];
        char inChar1 = lettersAndNumbers[(int)usedChars.get(0)];
        char inChar2 = lettersAndNumbers[(int)usedChars.get(1)];
        char inChar3 = lettersAndNumbers[(int)usedChars.get(2)];*/
//Need to figure out how to initiate random letters on text
    }

    @Override
    public void onClick(View v) {
        Random r =new Random();
    }
}
