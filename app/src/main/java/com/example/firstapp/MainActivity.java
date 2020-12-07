package com.example.firstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.firstapp.EXTRA_TEXT";

    Handler h;
    Runnable r;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.btn1);

        MediaPlayer snapSound = MediaPlayer.create(MainActivity.this, R.raw.julien_matthey_foley_movie_clapperboard);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r = new Runnable() {
                    @Override
                    public void run() {
                        snapSound.start();
                        openActivity2();
                    }
                };
                h = new Handler();
                h.postDelayed(r, 2000);
            }
        });
    }
    public void openActivity2() {
        EditText editText1 = (EditText) findViewById(R.id.editText1);

        String text = editText1.getText().toString();
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(EXTRA_TEXT, text);

        startActivity(intent);
    }

}