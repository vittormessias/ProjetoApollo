package com.example.projetoapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class EstiloInstrumento_Activity extends AppCompatActivity {
    ImageView imgSeta;
    CheckBox instrumentoViolao, instrumentoGuitarra, instrumentoTeclado, instrumentoVocal, instrumentoBateria, instrumentoBaixo, instrumentoUkulele, instrumentoViolino, instrumentoSaxofone, instrumentoSanfona, instrumentoSampler, instrumentoCavaquinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estilo_instrumento_layout);

        imgSeta = findViewById(R.id.imgSeta);
        instrumentoViolao = findViewById(R.id.instrumentoViolao);
        instrumentoGuitarra = findViewById(R.id.instrumentoGuitarra);
        instrumentoTeclado = findViewById(R.id.instrumentoTeclado);
        instrumentoVocal = findViewById(R.id.instrumentoVocal);
        instrumentoBateria = findViewById(R.id.instrumentoBateria);
        instrumentoBaixo = findViewById(R.id.instrumentoBaixo);
        instrumentoUkulele = findViewById(R.id.instrumentoUkulele);
        instrumentoViolino = findViewById(R.id.instrumentoViolino);
        instrumentoSaxofone = findViewById(R.id.instrumentoSaxofone);
        instrumentoSanfona = findViewById(R.id.instrumentoSanfona);
        instrumentoSampler = findViewById(R.id.instrumentoSampler);
        instrumentoCavaquinho = findViewById(R.id.instrumentoCavaquinho);
    }

    public void voltarJanelaArtista(View view) {
        Intent voltarJanelaArtista = new Intent(getApplicationContext(), CadPerfilArtista_Activity.class);
        startActivity(voltarJanelaArtista);
    }
}