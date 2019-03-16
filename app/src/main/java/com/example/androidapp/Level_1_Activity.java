package com.example.androidapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.util.IslamicCalendar;
import android.os.Build;
import android.provider.CalendarContract;
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
            String str = getIntent().getExtras().getString("stat");
            if(str.contains("true")) {
                fos.write("false1 false2  false3 false4 false5 false6".getBytes());
            }
            fos.flush();
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                String text = new String(bytes);
                String[] text2 = text.split(" ");
                for(int i = 0; i < text2.length; i++){
                    if(text2[i].contains("false1")){
                        text2[i] = "true1";
                    }
                }

                text = "";
            EditText ed = (EditText)findViewById(R.id.Text_Level_1);
            for(int i = 0; i < text2.length; i++){
                text = text +" " + text2[i];
            }
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.flush();
            fos.close();
            fis.close();
            Intent intent = new Intent(Level_1_Activity.this, MainActivity.class);
            intent.putExtra("STATUS", "true1");
            startActivity(intent);
            } catch(FileNotFoundException e){
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
                        Toast.makeText(Level_1_Activity.this, "Вы прошли уровень 1", Toast.LENGTH_SHORT).show();
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