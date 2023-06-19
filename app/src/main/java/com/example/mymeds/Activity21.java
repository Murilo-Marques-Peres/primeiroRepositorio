package com.example.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity21 extends AppCompatActivity {
    private EditText dose1;
    private EditText dose2;
    private EditText atual1;
    private EditText atual2;
    private DadosDAO dao;
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
    public void Salvar(View view){

        Dados dados1 = new Dados();
        String atual1String = atual1.getText().toString();

        if(!atual1String.equals("")){
            Integer atual1Convertido = Integer.valueOf(atual1String);
            dados1.setNumero(atual1Convertido);
        }
        String dose1String = dose1.getText().toString();
        if(dose1String.equals("")){
            Integer dose1Convertido = Integer.valueOf(dose1String);
            dados1.setDose(dose1Convertido);
        }
        //dao.inserir(dados1);

        Dados dados2 = new Dados();

        String atual2String = atual2.getText().toString();
        if(!atual2String.equals("")){
            Integer atual2Convertido = Integer.valueOf(atual2String);
            dados2.setNumero(atual2Convertido);
        }
        String dose2String = dose2.getText().toString();
        if(dose2String.equals("")){
            Integer dose2Convertido = Integer.valueOf(dose2String);
            dados2.setDose(dose2Convertido);
        }
        dao.inserir(dados1);
        dao.inserir(dados2);
        dao.atualizar1(dados1);
        dao.atualizar2(dados2);
    }
}