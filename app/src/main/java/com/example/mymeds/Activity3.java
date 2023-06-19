package com.example.mymeds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Activity3 extends AppCompatActivity {
    private TextView campo1;
    private TextView campo2;
    private DadosDAO dao;
    public int CalcularAtualNovo(){
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
        int remedioDez = dao.devolverNum1() + soma_dias_atuais;
        while(remedioDez>30){
            remedioDez-=30;
        }
        return soma_dias_atuais;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        campo1 = findViewById(R.id.textView4);
        campo2 = findViewById(R.id.textView6);
        dao = new DadosDAO(this);


        int valor1Integer = dao.devolverDez1();
        int valorHoje = valor1Integer - CalcularAtualNovo();
        while(valorHoje<=0){
            valorHoje += 30;
        }

        String valor1Convertido = String.valueOf(valorHoje);
        campo1.setText(valor1Convertido);

        int valor1Integer2 = dao.devolverDez2();
        String valor1Convertido2 = String.valueOf(valor1Integer2);
        campo2.setText(valor1Convertido2);

    }

}