package com.example.projetoapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CadPerfilArtista_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_perfil_artista_layout);
    }

    public void voltarJanelaArtista(View view) {
        Intent voltarJanelaArtista = new Intent(getApplicationContext(), TelaInscricaoArtista_Activity.class);
        startActivity(voltarJanelaArtista);
    }

    public void abrirJanelaSplash(View view) {
        Intent abrirJanelaSplash = new Intent(getApplicationContext(), SplashArtista_Activity.class);
        startActivity(abrirJanelaSplash);
    }
}