package com.example.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    String ip = null;
    Socket clientSocket = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            clientSocket = new Socket(ip, 9999);
            ip = new GetIpAdress().run2().replaceFirst("/", "");
            ButtonActivity();
        }catch (IOException e){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ButtonActivity(){
        final int entrychecked = 0;
        Button entryButton = (Button)findViewById(R.id.EntryButton);
        final EditText PoleLogin = (EditText)findViewById(R.id.Login);
        final EditText PolePassword = (EditText)findViewById(R.id.Password);
        final CheckBox CheckPolePassword = (CheckBox)findViewById(R.id.PasswordCheck);
        CheckPolePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckPolePassword.isChecked() == true){
                    PolePassword.setInputType(9);
                } else {
                    PolePassword.setInputType(129);
                }
            }
        });
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String indexEntery = null;
                try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                   BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write( PoleLogin.getText().toString() +  "\n");
                out.flush();
                    out.write( PolePassword.getText().toString() +  "\n");
                    out.flush();
                    indexEntery = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(indexEntery.contains("true") == true) {
                    Toast.makeText(MainActivity.this, "Вы вошли под учетной записью " + PoleLogin.getText().toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "False", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }
