package com.example.androidapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import static android.graphics.Color.*;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String status = "FIRST_TIME_LAUNCHED";
        try {
            status = getIntent().getExtras().getString("STATUS");
            Button level1 = (Button) findViewById(R.id.Level1);
            Button level2 = (Button) findViewById(R.id.Level2);
            Button level3 = (Button) findViewById(R.id.Level3);
            Button level4 = (Button) findViewById(R.id.Level4);
            Button level5 = (Button) findViewById(R.id.Level5);
            Button level6 = (Button) findViewById(R.id.Level6);
            if (status.contains("true1")) {
                level1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                level1.setClickable(false);
            } else if (status.contains("true2")) {
                level2.setClickable(false);
                level2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            } else if (status.contains("true3")) {
                level3.setClickable(false);
                level3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            } else if (status.contains("true4")) {
                level4.setClickable(false);
                level4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            } else if (status.contains("true5")) {
                level5.setClickable(false);
                level5.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            } else if (status.contains("true6")) {
                level6.setClickable(false);
                level6.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            }
        }catch (Exception e){
        }
        check();
        ButtonActivity();
    }
    private final static String FILE_NAME = "content.txt";

    FileInputStream fis;

    public void check(){
        Button level1 = (Button)findViewById(R.id.Level1);
        Button level2 = (Button)findViewById(R.id.Level2);
        Button level3 = (Button)findViewById(R.id.Level3);
        Button level4 = (Button)findViewById(R.id.Level4);
        Button level5 = (Button)findViewById(R.id.Level5);
        Button level6 = (Button)findViewById(R.id.Level6);
        try {
            fis = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            String[] text2 = text.split(" ");
            for(int i = 0; i < text2.length; i++){
                if(text2[i].contains("true1")){
                    level1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    level1.setClickable(false);
                } else if(text2[i].contains("true2")){
                    level2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    level2.setClickable(false);
                }else if(text2[i].contains("true3")){
                    level3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    level3.setClickable(false);
                }else if(text2[i].contains("true4")){
                    level4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    level4.setClickable(false);
                }else if(text2[i].contains("true5")){
                    level5.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    level5.setClickable(false);
                }else if(text2[i].contains("true6")){
                    level6.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    level6.setClickable(false);
                }
            }
            fis.close();
        }catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                Intent shift = new Intent(MainActivity.this, Level_1_Activity.class);
                try {
                    fis = openFileInput(FILE_NAME);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    String text = new String(bytes);
                    String[] text2 = text.split(" ");
                    if(text.contains("")) {
                        shift.putExtra("stat", "true");
                    }else{
                        shift.putExtra("stat", "false");
                    }
                    startActivity(shift);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
