package com.example.pc_gamer.sysfrut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnClientes;
    Button btnEmbalagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClientes = findViewById(R.id.btnCliente);
        btnEmbalagem = findViewById(R.id.btnEmbalagem);

        btnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(MainActivity.this, ClienteActivity.class);
                MainActivity.this.startActivity(intencao);
            }
        });

        btnEmbalagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(MainActivity.this, AtribuirEmbalagem.class);
                MainActivity.this.startActivity(intencao);
            }
        });
    }
}
