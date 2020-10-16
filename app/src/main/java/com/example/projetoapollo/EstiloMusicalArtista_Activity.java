package com.example.projetoapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class EstiloMusicalArtista_Activity extends AppCompatActivity {

    ImageView imgSeta;
    CheckBox generoRock, generoSertanejo, generoHipHop, generoJazz, generoBlues, generoRap, generoEletronica, generoMetal, generoPop, generoFunk, generoReggae, generoAlternativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.estilo_musical_artista_layout);

        imgSeta = findViewById(R.id.imgSeta);
        generoRock = findViewById(R.id.generoRock);
        generoSertanejo = findViewById(R.id.generoSertanejo);
        generoHipHop = findViewById(R.id.generoHipHop);
        generoJazz = findViewById(R.id.generoJazz);
        generoBlues = findViewById(R.id.generoBlues);
        generoRap = findViewById(R.id.generoRap);
        generoEletronica = findViewById(R.id.generoEletronica);
        generoMetal = findViewById(R.id.generoMetal);
        generoPop = findViewById(R.id.generoPop);
        generoFunk = findViewById(R.id.generoFunk);
        generoReggae = findViewById(R.id.generoReggae);
        generoAlternativo = findViewById(R.id.generoAlternativo);
    }

    public void voltarJanela(View view) {
        Intent voltarJanela = new Intent(getApplicationContext(), CadPerfilArtista_Activity.class);
        startActivity(voltarJanela);
    }
}