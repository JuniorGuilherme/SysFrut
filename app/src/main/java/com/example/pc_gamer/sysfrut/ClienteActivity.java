package com.example.pc_gamer.sysfrut;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ClienteActivity extends AppCompatActivity {
    Button btnAddCliente;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        btnAddCliente = findViewById(R.id.btnAddCliente);
        btnAddCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(ClienteActivity.this, AdicionaCliente.class);
                ClienteActivity.this.startActivity(intencao);
            }
        });

        BdController crud = new BdController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {DataBase.id, DataBase.nome};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.item_cliente,cursor,nomeCampos,idViews, 0);
        list = findViewById(R.id.listCliente);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String codigo;
                cursor.moveToPosition(i);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(DataBase.id));
                Intent intent = new Intent(ClienteActivity.this, AlteraCliente.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
