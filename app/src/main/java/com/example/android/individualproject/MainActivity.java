package com.example.android.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //http://www.morseresource.com/morse/makemorse.php
    char[] lettersAndNumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button helpButton;
    Button replayButton;
    char[] usedChars = new char[4];
    int[] morseMP3s = new int[36];
    char correctChar;
    int correctIndex;

    private SoundPool soundPool;
    private int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,one,two,three,four,five,six,seven,eight,nine,zero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeButtons();
        setButtons();
        initializeSoundPool();
        //seems that you have to set up soundIDs in the onCreate method
        intitializeSounds();

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.helpButton:
                Intent intent = new Intent(getBaseContext(), LearningActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonA:
                char aButton = usedChars[0];
                if(usedChars[0] == correctChar)
                setButtons();
                break;
            case R.id.buttonB:
                char bButton = usedChars[1];
                if(usedChars[1] == correctChar)
                setButtons();
                break;
            case R.id.buttonC:
                char cButton = usedChars[2];
                if(usedChars[2] == correctChar)
                setButtons();
                break;
            case R.id.buttonD:
                char dButton = usedChars[3];
                if(usedChars[3] == correctChar)
                setButtons();
                break;
            case R.id.playButton:

                playChar();
                break;
        }
    }


    public boolean isCorrect(char inputChar) {
        return inputChar == correctChar;
    }

    public void intitializeSounds() {
        a = soundPool.load(this, R.raw.a,1);
        morseMP3s[0] = a;
        b = soundPool.load(this, R.raw.b,1);
        morseMP3s[1] = b;
        c = soundPool.load(this, R.raw.c,1);
        morseMP3s[2] = c;
        d = soundPool.load(this, R.raw.d,1);
        morseMP3s[3] = d;
        e = soundPool.load(this, R.raw.e,1);
        morseMP3s[4] = e;
        f = soundPool.load(this, R.raw.f,1);
        morseMP3s[5] = f;
        g = soundPool.load(this, R.raw.g,1);
        morseMP3s[6] = g;
        h = soundPool.load(this, R.raw.h,1);
        morseMP3s[7] = h;
        i = soundPool.load(this, R.raw.i,1);
        morseMP3s[8] = i;
        j = soundPool.load(this, R.raw.j,1);
        morseMP3s[9] = j;
        k = soundPool.load(this, R.raw.k,1);
        morseMP3s[10] = k;
        l = soundPool.load(this, R.raw.l,1);
        morseMP3s[11] = l;
        m = soundPool.load(this, R.raw.m,1);
        morseMP3s[12] = m;
        n = soundPool.load(this, R.raw.n,1);
        morseMP3s[13] = n;
        o = soundPool.load(this, R.raw.o,1);
        morseMP3s[14] = o;
        p = soundPool.load(this, R.raw.p,1);
        morseMP3s[15] = p;
        q = soundPool.load(this, R.raw.q,1);
        morseMP3s[16] = q;
        r = soundPool.load(this, R.raw.r,1);
        morseMP3s[17] = r;
        s = soundPool.load(this, R.raw.s,1);
        morseMP3s[18] = s;
        t = soundPool.load(this, R.raw.t,1);
        morseMP3s[19] = t;
        u = soundPool.load(this, R.raw.u,1);
        morseMP3s[20] = u;
        v = soundPool.load(this, R.raw.v,1);
        morseMP3s[21] = v;
        w = soundPool.load(this, R.raw.w,1);
        morseMP3s[22] = w;
        x = soundPool.load(this, R.raw.x,1);
        morseMP3s[23] = x;
        y = soundPool.load(this, R.raw.y,1);
        morseMP3s[24] = y;
        z = soundPool.load(this, R.raw.z,1);
        morseMP3s[25] = z;
        zero = soundPool.load(this, R.raw.zero,1);
        morseMP3s[26] = zero;
        one = soundPool.load(this, R.raw.one,1);
        morseMP3s[27] = one;
        two = soundPool.load(this, R.raw.two,1);
        morseMP3s[28] = two;
        three = soundPool.load(this, R.raw.three,1);
        morseMP3s[29] = three;
        four = soundPool.load(this, R.raw.four,1);
        morseMP3s[30] = four;
        five = soundPool.load(this, R.raw.five,1);
        morseMP3s[31] = five;
        six = soundPool.load(this, R.raw.six,1);
        morseMP3s[32] = six;
        seven = soundPool.load(this, R.raw.seven,1);
        morseMP3s[33] = seven;
        eight = soundPool.load(this, R.raw.eight, 1);
        morseMP3s[34] = eight;
        nine = soundPool.load(this, R.raw.nine,1);
        morseMP3s[35] = nine;
    }

    public void playChar() {
        int sound = morseMP3s[correctIndex];
        soundPool.play(sound,1,1,0,0,1);
    }

    public void initializeButtons() {
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        helpButton = findViewById(R.id.helpButton);
        replayButton = findViewById(R.id.playButton);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        replayButton.setOnClickListener(this);

    }

    public void setButtons() {
        int[] usedNums = new int[4];

        Random r = new Random();
        int num = r.nextInt(36);
        char curChar = lettersAndNumbers[num];
        usedNums[0] = num;
        usedChars[0] = curChar;

        //This for loop checks to make sure there are no repeated characters
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

        int randInt = r.nextInt(4);
        correctChar = usedChars[randInt];
        correctIndex = usedNums[randInt];
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

    public void initializeSoundPool(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
