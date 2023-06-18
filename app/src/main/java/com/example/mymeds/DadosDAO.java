package com.example.mymeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DadosDAO {
    private conexao conexao1;
    private SQLiteDatabase banco;

    public DadosDAO(Context context){
        conexao1 = new conexao(context);
        banco = conexao1.getWritableDatabase();
    }
    public long inserir(Dados dados){
        ContentValues values = new ContentValues();
        values.put("nome", dados.getNome());
        values.put("numero", dados.getNumero());
        return banco.insert("dados", null, values);
    }
}

