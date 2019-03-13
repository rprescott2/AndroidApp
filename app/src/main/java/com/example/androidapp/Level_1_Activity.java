package com.example.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Level_1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1_);
        ButtonLevel1Activity();
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
                    if(i[0] == xx[0] & words.get(i[0]).equalsIgnoreCase(text)){
                        Toast.makeText(Level_1_Activity.this, "Вы прошли уровень 1", Toast.LENGTH_SHORT).show();
                    }
                     else if (words.get(i[0]).equalsIgnoreCase(text)) {
                        Toast.makeText(Level_1_Activity.this, "Вы угадали", Toast.LENGTH_SHORT).show();
                        i[0]++;
                    } else {
                        Toast.makeText(Level_1_Activity.this, "Вы не угадали", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
