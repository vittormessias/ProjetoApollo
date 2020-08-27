package com.example.projetoapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CadPerfilPublico_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_perfil_publico_layout);
    }

    public void voltarJanelaPublico(View view) {
        Intent voltarJanelaPublico = new Intent(getApplicationContext(), TelaInscricaoPublico_Activity.class);
        startActivity(voltarJanelaPublico);
    }

    public void abrirJanela(View view) {
        Intent abrirJanela = new Intent(getApplicationContext(), SplashPublico_Activity.class);
        startActivity(abrirJanela);
    }
}