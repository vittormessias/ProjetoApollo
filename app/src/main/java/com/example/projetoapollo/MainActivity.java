package com.example.projetoapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //criar variaveis que irão representar os componentes do xml
    Button btnEntrar, btnCadastro;
    TextView txtnomeApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //está chamada de metódo que faz referência ao layout
        setContentView(R.layout.activity_main);
        //apresentar os componentes do xml para o java
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastro = findViewById(R.id.btnCadastro);
        txtnomeApp = findViewById(R.id.txtnomeApp);
    }

    // metódo de abrir janela
    public void abrirJanela(View view) {
        Intent abrirJanela = new Intent(getApplicationContext(), LoginPublico_Activity.class);
        startActivity(abrirJanela);
    }

    public void abrirOutraJanela(View view) {
        Intent abrirOutraJanela = new Intent(getApplicationContext(), TelaInscricaoArtista_Activity.class);
        startActivity(abrirOutraJanela);
    }
}