package com.example.mymeds;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conexao extends SQLiteOpenHelper {
        private static final String name = "banco.db";
        private static final int version = 1;
        public conexao(Context context) {super(context, name, null, version);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table dados (id integer primary key autoincrement, " +
                "nome varchar(50), numero integer, dose integer)");
        db.execSQL("alter table dados add column int numeroDez");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
