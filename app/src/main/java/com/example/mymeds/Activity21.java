package com.example.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Activity21 extends AppCompatActivity {
    private EditText dose1;
    private EditText dose2;
    private EditText atual1;
    private EditText atual2;
    private DadosDAO dao;
    private String novoTeste = "Teste";
    private String novoTeste2 = "teste2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21);
        dose1 = findViewById(R.id.editTextNumberDecimal);
        dose2 = findViewById(R.id.editTextNumberDecimal3);
        atual1 = findViewById(R.id.editTextNumberDecimal2);
        atual2 = findViewById(R.id.editTextNumberDecimal4);
        dao = new DadosDAO(this);
    }
}