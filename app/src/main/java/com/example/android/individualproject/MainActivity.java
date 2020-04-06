package com.example.android.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
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
        setButtons();
        SoundPool soundPool;
    }



    public void initializeButtons() {
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        helpButton = findViewById(R.id.helpButton);
        replayButton = findViewById(R.id.replayButton);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        replayButton.setOnClickListener(this);




    }

    public void setButtons() {
        int[] usedNums = new int[4];
        char[] usedChars = new char[4];
        Random r = new Random();
        int num = r.nextInt(36);
        char curChar = lettersAndNumbers[num];
        usedNums[0] = num;
        usedChars[0] = curChar;

        for(int i = 0; i<3; i++) {
            num = r.nextInt(36);
            if(!checkNum(num, usedNums)){
                i--;
            } else {
                usedChars[i+1] = lettersAndNumbers[num];
                usedNums[i+1] = num;
            }
        }

        buttonA.setText(String.valueOf(usedChars[0]));
        buttonB.setText(String.valueOf(usedChars[1]));
        buttonC.setText(String.valueOf(usedChars[2]));
        buttonD.setText(String.valueOf(usedChars[3]));

    }

    public boolean checkNum(int num, int[] usedNums) {
        boolean isUnique = true;
        for(int i =0; i < usedNums.length;i++) {
            if(usedNums[i] == num) {
                isUnique = false;
            }
        }
        return isUnique;
    }


    @Override
    public void onClick(View v) {

    }
}
