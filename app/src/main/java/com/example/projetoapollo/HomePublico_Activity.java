package com.example.projetoapollo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePublico_Activity extends AppCompatActivity {

    ImageButton imgBtnSair;
    ImageView imgLogo, imgCoracao, imgInstagram, imgFacebook, imgSimboloTelefone, imgFotoPostPerfil, imgFotoPostPerfilDois, imgFotoPostPerfilTres, imgFotoPostPerfilQuatro;
    TextView txtNomeUsuario, txtDescricaoPerfil;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home_publico_layout);

        imgBtnSair = findViewById(R.id.imgBtnSair);
        imgLogo = findViewById(R.id.imgLogo);
        imgCoracao = findViewById(R.id.imgCoracao);
        imgInstagram = findViewById(R.id.imgInstagram);
        imgFacebook = findViewById(R.id.imgFacebook);
        imgSimboloTelefone = findViewById(R.id.imgSimboloTelefone);
        imgFotoPostPerfil = findViewById(R.id.imgFotoPostPerfil);
        imgFotoPostPerfilDois = findViewById(R.id.imgFotoPostPerfilDois);
        imgFotoPostPerfilTres = findViewById(R.id.imgFotoPostPerfilTres);
        imgFotoPostPerfilQuatro = findViewById(R.id.imgFotoPostPerfilQuatro);
        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
        txtDescricaoPerfil = findViewById(R.id.txtDescricaoPerfil);


        bottomNavigationView = findViewById(R.id.idBottomNavBar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout, new PerfilPublicoFragment()).commit();
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //instanciando a classe Fragment
                Fragment fragment = null;
                Activity activity = null;

                switch (menuItem.getItemId()) {
                    case R.id.mExplorar:
                        fragment = new ExplorarFragment();
                        break;
                    case R.id.mFavoritos:
                        fragment = new FavoritosFragment();
                        break;
                    case R.id.mFeed:
                        fragment = new FeedPublicoFragment();
                        break;
                    case R.id.mNotificacoes:
                        fragment = new NotificacoesPublicoFragment();
                        break;
                    case R.id.mPerfil:
                        fragment = new PerfilPublicoFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout, fragment).commit();

                return true;
            }
        });
    }

    public void voltarJanelaSair(View view) {
        Intent voltarJanelaSair = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(voltarJanelaSair);
    }
}