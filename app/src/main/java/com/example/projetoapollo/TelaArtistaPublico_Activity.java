package com.example.projetoapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaArtistaPublico_Activity extends AppCompatActivity {

    TextView txtPergunta;
    ImageView imgLogo;
    Button btnArtista, btnPublico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tela_artista_publico_layout);
        //apresentar os componentes do xml para o java
        txtPergunta = findViewById(R.id.txtPergunta);
        imgLogo = findViewById(R.id.imgLogo);
        btnArtista = findViewById(R.id.btnArtista);
        btnPublico = findViewById(R.id.btnPublico);
    }

    public void abrirJanelaArtista(View view) {
        Intent abrirJanelaArtista = new Intent(getApplicationContext(), CadPerfilArtista_Activity.class);
        startActivity(abrirJanelaArtista);

    }

    public void abrirJanelaPublico(View view) {
        Intent abrirJanelaPublico = new Intent(getApplicationContext(), CadPerfilPublico_Activity.class);
        startActivity(abrirJanelaPublico);

    }
}