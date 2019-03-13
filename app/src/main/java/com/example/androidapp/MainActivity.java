package com.example.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ButtonActivity();
    }
    public void ButtonActivity(){
        Button level1 = (Button)findViewById(R.id.Level1);
        Button level2 = (Button)findViewById(R.id.Level2);
        Button level3 = (Button)findViewById(R.id.Level3);
        Button level4 = (Button)findViewById(R.id.Level4);
        Button level5 = (Button)findViewById(R.id.Level5);
        Button level6 = (Button)findViewById(R.id.Level6);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shift = new Intent(".Level_1_Activity");
                startActivity(shift);
            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shift = new Intent(".Level_2_Activity");
                startActivity(shift);
            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shift = new Intent(".Level_3_Activity");
                startActivity(shift);
            }
        });
        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shift = new Intent(".Level_4_Activity");
                startActivity(shift);
            }
        });
        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shift = new Intent(".Level_5_Activity");
                startActivity(shift);
            }
        });
        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shift = new Intent(".Level_6_Activity");
                startActivity(shift);
            }
        });
    }
}
