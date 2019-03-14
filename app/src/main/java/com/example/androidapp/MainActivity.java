package com.example.androidapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonActivity();
    }
    private final static String FILE_NAME = "content.txt";
    FileOutputStream fos;
    FileInputStream fis;
    public void ButtonActivity(){
        Button level1 = (Button)findViewById(R.id.Level1);
        Button level2 = (Button)findViewById(R.id.Level2);
        Button level3 = (Button)findViewById(R.id.Level3);
        Button level4 = (Button)findViewById(R.id.Level4);
        Button level5 = (Button)findViewById(R.id.Level5);
        Button level6 = (Button)findViewById(R.id.Level6);
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fis = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            for(int i = 0; i < 6; i++){
                if(text.contains("true1")){
                    level1.setBackgroundColor(Color.GREEN);
                } else if(text.contains("true2")){
                    level2.setBackgroundColor(Color.GREEN);
                }else if(text.contains("true3")){
                    level3.setBackgroundColor(Color.GREEN);
                }else if(text.contains("true4")){
                    level4.setBackgroundColor(Color.GREEN);
                }else if(text.contains("true5")){
                    level5.setBackgroundColor(Color.GREEN);
                }else if(text.contains("true6")){
                    level6.setBackgroundColor(Color.GREEN);
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
