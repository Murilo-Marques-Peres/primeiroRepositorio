package com.example.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Activity21 extends AppCompatActivity {
    private EditText dose1;
    private EditText dose2;
    private EditText atual1;
    private EditText atual2;
    private DadosDAO dao;
    public int CalcularAtual(int atual1Novo, int dose12){
        Calendar cal = Calendar.getInstance();
        Date data = (Date) cal.getTime();
        String a1 = String.valueOf(data);
        String mes_atual = a1.substring(4,7);
        int soma_meses_completos = 0;
        int soma_dias_atuais = 0;
        int mJan = 31;
        int mFeb = 28;
        int mMar = 31;
        int mApril = 30;
        int mMay = 31;
        int mJune = 30;
        int mJuly = 31;
        int mAug = 31;
        int mSept = 30;
        int mOct = 31;
        int mNov = 30;
        int mDec = 31;
        ArrayList<Integer> lista_meses = new ArrayList<Integer>();

        lista_meses.add(mJan);
        lista_meses.add(mFeb);
        lista_meses.add(mMar);
        lista_meses.add(mApril);
        lista_meses.add(mMay);
        lista_meses.add(mJune);
        lista_meses.add(mJuly);
        lista_meses.add(mAug);
        lista_meses.add(mSept);
        lista_meses.add(mOct);
        lista_meses.add(mNov);
        lista_meses.add(mDec);
        ArrayList<String> lista_string_meses = new ArrayList<String>();
        lista_string_meses.add("Jan");
        lista_string_meses.add("Feb");
        lista_string_meses.add("Mar");
        lista_string_meses.add("Apri");
        lista_string_meses.add("May");
        lista_string_meses.add("Jun");
        lista_string_meses.add("Jul");
        lista_string_meses.add("Aug");
        lista_string_meses.add("Sep");
        lista_string_meses.add("Oct");
        lista_string_meses.add("Nov");
        lista_string_meses.add("Dec");

        int index_mes_atual = 0;
        String dia_atual_string = a1.substring(8,10);
        int dia_atual_integer = Integer.parseInt(dia_atual_string);
        for(int x=0; x<12; x++) {
            if((mes_atual).equals(lista_string_meses.get(x))){
                index_mes_atual = x;
            }
        }
        for(int x2=0;x2<index_mes_atual;x2++){
            soma_meses_completos = soma_meses_completos + lista_meses.get(x2);
        }
        soma_dias_atuais = soma_meses_completos + dia_atual_integer;
        int remedioDez = atual1Novo + (soma_dias_atuais * dose12);
        while(remedioDez>30){
            remedioDez-=30;
        }
        return remedioDez;
    }

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
        int atual1Convertido = 1;
        int atual2Convertido = 1;
        int numeroDez1 = 1;
        int dose1Convertido = 1;
        int dose2Convertido = 1;

        if(!atual1String.equals("")){
            atual1Convertido = Integer.valueOf(atual1String);
            dados1.setNumero(atual1Convertido);
        }



        String dose1String = dose1.getText().toString();
        if(!dose1String.equals("")){
            dose1Convertido = Integer.valueOf(dose1String);
            dados1.setDose(dose1Convertido);
        }

        dados1.setNumeroDezem(CalcularAtual(atual1Convertido, dose1Convertido));
        Dados dados2 = new Dados();

        String atual2String = atual2.getText().toString();
        if(!atual2String.equals("")){
            atual2Convertido = Integer.valueOf(atual2String);
            dados2.setNumero(atual2Convertido);
        }
        String dose2String = dose2.getText().toString();
        if(dose2String.equals("")){
            dose2Convertido = Integer.valueOf(dose2String);
            dados2.setDose(dose2Convertido);
        }
        dados2.setNumeroDezem(CalcularAtual(atual2Convertido, dose2Convertido));



        dao.inserir(dados1);
        dao.inserir(dados2);
        dao.atualizar1(dados1);
        dao.atualizar2(dados2);
        dao.definirDezembro1(dados1);
        dao.definirDezembro2(dados2);


    }
}