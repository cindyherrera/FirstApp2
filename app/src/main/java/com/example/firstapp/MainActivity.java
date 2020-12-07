package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.firstapp.EXTRA_TEXT";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.btn1);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int randNum = (int)(Math.random()*2);

                openActivity2();

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