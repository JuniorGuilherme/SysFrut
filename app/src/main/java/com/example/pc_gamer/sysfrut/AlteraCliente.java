package com.example.pc_gamer.sysfrut;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlteraCliente extends AppCompatActivity {
    EditText etNome;
    EditText etId;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BdController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_cliente);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BdController(getBaseContext());

        etNome = findViewById(R.id.editText4);
        etId = findViewById(R.id.editText5);

        alterar = findViewById(R.id.button2);
        deletar = findViewById(R.id.button3);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        etNome.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataBase.nome)));
        etId.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataBase.id)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.alteraRegistro(Integer.parseInt(etId.getText().toString()),
                        etNome.getText().toString());
                Intent intent = new Intent(AlteraCliente.this, ClienteActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlteraCliente.this,ClienteActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
