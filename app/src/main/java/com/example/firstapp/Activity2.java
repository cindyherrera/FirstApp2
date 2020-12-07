package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String[] resultFinal = {"ENDGAME, YOU LOSE", "YOU SURVIVED THE BIG SNAP"};

        int randomNumber = (int) (Math.random() * 2);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        textView2.setText(text);
        textView1.setText(resultFinal[randomNumber]);
        ImageView youWin = (ImageView) findViewById(R.id.imgYouWin);
        youWin.setVisibility(View.VISIBLE);

        if (randomNumber != 1) {

            ImageView youLose = (ImageView) findViewById(R.id.youLose);
            youLose.setVisibility(View.VISIBLE);
            youWin.setVisibility(View.INVISIBLE);
            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            boolean hasVibratingMode = vibrator.hasVibrator();
            if (hasVibratingMode) {

                Toast.makeText(this, "vibrate on", Toast.LENGTH_SHORT).show();

                vibrator.vibrate(2000);

            } else
                Toast.makeText(this, "no vibrate capabilities", Toast.LENGTH_SHORT).show();

        }
    }
}