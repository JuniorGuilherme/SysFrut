package com.example.pc_gamer.sysfrut;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class AtribuirEmbalagem extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atribuir_embalagem);

        BdController crud = new BdController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {DataBase.id, DataBase.nome};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_cliente,cursor,nomeCampos,idViews, 0);
        list = findViewById(R.id.listCliente);
        list.setAdapter(adapter);
    }
}
