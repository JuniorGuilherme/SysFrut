package com.example.pc_gamer.sysfrut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionaCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_cliente);

        Button botao = findViewById(R.id.button);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BdController crud = new BdController(getBaseContext());
                EditText etId = findViewById(R.id.editText2);
                EditText etNome = findViewById((R.id.editText));

                Integer id = Integer.parseInt(etId.getText().toString());
                String nome = etNome.getText().toString();
                String resultado;

                resultado = crud.inserir(id, nome);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
