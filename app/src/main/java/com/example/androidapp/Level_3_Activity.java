package com.example.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Level_3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_3_);
        ButtonLevel1Activity();
    }
    private final static String FILE_NAME = "content.txt";
    FileOutputStream fos;
    FileInputStream fis;
    int index;
    public void WriteComplete() {
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fis = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            text.replace("false3", "true3");
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
        Button checkLevel = (Button)findViewById(R.id.Check_Level_3);
        final EditText textLevel = (EditText)findViewById(R.id.Text_Level_3);
        final int[] numberSucces = {(words.size())};
        final int[] xx = {0};
        for(int x = 0; x < words.size()-1; x++){
            xx[0]++;
        }
        checkLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textLevel.getText().toString();
                if(i[0] == xx[0] & words.get(i[0]).equalsIgnoreCase(text)){
                    Toast.makeText(Level_3_Activity.this, "Вы прошли уровень 3", Toast.LENGTH_SHORT).show();
                }
                else if (words.get(i[0]).equalsIgnoreCase(text)) {
                    Toast.makeText(Level_3_Activity.this, "Вы угадали", Toast.LENGTH_SHORT).show();
                    i[0]++;
                } else {
                    Toast.makeText(Level_3_Activity.this, "Вы не угадали", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
