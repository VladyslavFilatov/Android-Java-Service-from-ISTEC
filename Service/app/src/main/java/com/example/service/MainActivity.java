package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Servico1 servico1;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent itsrv1 = new Intent(MainActivity.this,Servico1.class);
        //---------------------------------------
        bt1 = findViewById(R.id.bt_btstart1_main);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Serviso1", Toast.LENGTH_SHORT).show();
                startService(itsrv1);
            }
        });

        //---------------------------------------
        bt2 = findViewById(R.id.bt_btstop1_main);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
                stopService(itsrv1);
            }
        });
    }
}