package com.example.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonConfig = findViewById(R.id.button2);
        Button buttonVer = findViewById(R.id.button3);
        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });
        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openActivity3();}
        });
    }
    public void openActivity3(){
        Intent intent2 = new Intent(this,Activity21.class);
        startActivity(intent2);
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }


}