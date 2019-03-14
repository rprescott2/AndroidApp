package com.example.androidapp;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Level_1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1_);
        ButtonLevel1Activity();
    }
    private final static String FILE_NAME = "content.txt";
    FileOutputStream fos;
    FileInputStream fis;
    public void WriteComplete() {
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fis = openFileInput(FILE_NAME);
            fos.write("false1 false2  false3 false4 false5 false6".getBytes());
            fos.flush();
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                String text = new String(bytes);
                text.replace("false1", "true1");
            Button level1 = (Button) findViewById(R.id.Level1);
            Button level2 = (Button) findViewById(R.id.Level2);
            Button level3 = (Button) findViewById(R.id.Level3);
            Button level4 = (Button) findViewById(R.id.Level4);
            Button level5 = (Button) findViewById(R.id.Level5);
            Button level6 = (Button) findViewById(R.id.Level6);
            EditText ed = (EditText)findViewById(R.id.Text_Level_1);
            ed.setText(text);
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
                fos.write(text.getBytes());
                fos.flush();
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }

    }
    ArrayList<String> words = new ArrayList<>();
    public void ButtonLevel1Activity(){
        final int[] i = {0};
        words.add("корова");
        words.add("снег");
        Button checkLevel = (Button)findViewById(R.id.Check_Level_1);
        final EditText textLevel = (EditText)findViewById(R.id.Text_Level_1);
        final int[] numberSucces = {(words.size())};
        final int[] xx = {0};
        for(int x = 0; x < words.size()-1; x++){
            xx[0]++;
        }
        checkLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String text = textLevel.getText().toString();
                    if (i[0] == xx[0] & words.get(i[0]).equalsIgnoreCase(text)) {

                        WriteComplete();

                    } else if (words.get(i[0]).equalsIgnoreCase(text)) {
                        Toast.makeText(Level_1_Activity.this, "Вы угадали", Toast.LENGTH_SHORT).show();
                        i[0]++;
                    } else {
                        Toast.makeText(Level_1_Activity.this, "Вы не угадали", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }
}