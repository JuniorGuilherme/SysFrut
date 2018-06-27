package com.example.pc_gamer.sysfrut;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PC-Gamer on 26/06/2018.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final String nome_banco = "sysfrut.db";
    public static final String tabela = "clientes";
    public static final String id = "_id";
    public static final String nome = "nome";
    private static final int version = 3;

    public DataBase(Context context) {
        super(context, nome_banco, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+tabela+" (\n" +
                id+" integer primary key,\n" +
                nome+" text\n" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tabela);
        onCreate(db);
    }
}
