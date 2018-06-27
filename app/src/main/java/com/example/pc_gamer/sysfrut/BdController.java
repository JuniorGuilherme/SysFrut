package com.example.pc_gamer.sysfrut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by PC-Gamer on 26/06/2018.
 */

public class BdController {
    private SQLiteDatabase db;
    private DataBase banco;

    public BdController(Context context){
        banco = new DataBase(context);
    }

    public String inserir(Integer id, String nome){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DataBase.nome, nome);
        valores.put(DataBase.id, id);

        resultado = db.insert(DataBase.tabela, null, valores);
        db.close();

        if(resultado == -1){
            return "Erro ao inserir registro.";
        }
        else{
            return "Registro inserido com sucesso.";
        }
    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.id, banco.nome};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.tabela, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.id,banco.nome};
        String where = DataBase.id + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(DataBase.tabela,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String nome){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = DataBase.id + "=" + id;

        valores = new ContentValues();
        valores.put(DataBase.id, id);
        valores.put(DataBase.nome, nome);

        db.update(DataBase.tabela,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = DataBase.id + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(DataBase.tabela,where,null);
        db.close();
    }
}
