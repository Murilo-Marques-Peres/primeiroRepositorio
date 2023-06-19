package com.example.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView campo1;
    private TextView campo2;
    private DadosDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        campo1 = findViewById(R.id.textView4);
        campo2 = findViewById(R.id.textView6);
        dao = new DadosDAO(this);


        int valor1Integer = dao.funcao1();
        String valor1Convertido = String.valueOf(valor1Integer);
        campo1.setText(valor1Convertido);

        int valor1Integer2 = dao.funcao2();
        String valor1Convertido2 = String.valueOf(valor1Integer2);
        campo2.setText(valor1Convertido2);

    }

}