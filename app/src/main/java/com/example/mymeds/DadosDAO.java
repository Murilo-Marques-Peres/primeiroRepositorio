package com.example.mymeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DadosDAO {
    private conexao conexao1;
    private SQLiteDatabase banco;


    public DadosDAO(Context context){
        conexao1 = new conexao(context);
        banco = conexao1.getWritableDatabase();


    }
    public void inserir(Dados dados){
        int x = 0;
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose"}, null, null, null, null, null);
        if(!cursor.moveToNext()){
            ContentValues values = new ContentValues();
            values.put("numero", dados.getNumero());
            values.put("dose", dados.getDose());
            banco.insert("dados", null, values);
            x++;
        }
    }
    public void atualizar1(Dados dados){
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        if(cursor.moveToNext()){
            ContentValues values = new ContentValues();
            values.put("numero", dados.getNumero());
            values.put("dose", dados.getDose());
            values.put("numeroDez", dados.getNumeroDezem());

            String index = "1";
            banco.update("dados", values,"id = ?", new String[]{index});

            ContentValues values2 = new ContentValues();
            values2.put("numero", dados.getNumero());
            values2.put("dose", dados.getDose());
            banco.insert("dados", null, values2);

        }
    }
    public void atualizar2(Dados dados){
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        if(cursor.moveToNext()){
            ContentValues values = new ContentValues();
            values.put("numero", dados.getNumero());
            values.put("dose", dados.getDose());
            values.put("numeroDez", dados.getNumeroDezem());

            String index = "2";
            banco.update("dados", values,"id = ?", new String[]{index});
        }

    }
    public int funcao1(){
        int x = 0;
        int numeroPesquisado1 = 0;
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            if(x==0){
                Dados dados3 = new Dados();
                dados3.setId(cursor.getInt(0));
                dados3.setNumero(cursor.getInt(2));
                dados3.setDose(cursor.getInt(3));
                numeroPesquisado1 = cursor.getInt(2);
                x++;
            }

        }

        return numeroPesquisado1;
    }
    public int funcao2(){
        int x = 0;
        int numeroPesquisado2 = 0;
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            if(x==1){
                Dados dados3 = new Dados();
                dados3.setId(cursor.getInt(0));
                dados3.setNumero(cursor.getInt(2));
                dados3.setDose(cursor.getInt(3));
                numeroPesquisado2 = cursor.getInt(2);
            }
            x++;
        }
        return numeroPesquisado2;
    }
    public void definirDezembro1(Dados dados){
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        if(cursor.moveToNext()){
            ContentValues values = new ContentValues();
            values.put("numeroDez", dados.getNumeroDezem());

            String index = "1";
            banco.update("dados", values, "id=?", new String[]{index});

        }
    }
    public void definirDezembro2(Dados dados){
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        if(cursor.moveToNext()){
            ContentValues values = new ContentValues();
            values.put("numeroDez", dados.getNumeroDezem());

            String index = "2";
            banco.update("dados", values, "id=?", new String[]{index});

        }

    }
    public int devolverDez1(){
        int x = 0;
        int numeroPesquisado1 = 0;
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            if(x==0){
                Dados dados3 = new Dados();
                dados3.setId(cursor.getInt(0));
                dados3.setNumero(cursor.getInt(2));
                dados3.setDose(cursor.getInt(3));
                dados3.setNumeroDezem(cursor.getInt(4));
                numeroPesquisado1 = cursor.getInt(4);

            }
            x++;

        }

        return numeroPesquisado1;
    }
    public int devolverDez2(){
        int x = 0;
        int numeroPesquisado1 = 0;
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            if(x==1){
                Dados dados3 = new Dados();
                dados3.setId(cursor.getInt(0));
                dados3.setNumero(cursor.getInt(2));
                dados3.setDose(cursor.getInt(3));
                dados3.setNumeroDezem(cursor.getInt(4));
                numeroPesquisado1 = cursor.getInt(4);
            }
            x++;

        }

        return numeroPesquisado1;
    }
    public int devolverNum1(){
        int x = 0;
        int numeroRequerido = 0;
        Cursor cursor = banco.query("dados", new String[]{"id", "nome", "numero", "dose", "numeroDez"}, null, null, null, null, null);
        while(cursor.moveToNext()){
            if(x==0){
                numeroRequerido = cursor.getInt(2);
            }
            x++;

        }
        return numeroRequerido;
    }
}

