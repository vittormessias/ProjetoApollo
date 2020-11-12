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
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeArtista_Activity extends AppCompatActivity {

    Button btnCarregaDados;
    ImageButton imgBtnSair, imgSimboloLapis;
    TextView nome, sobre, site, textNomeNumeroHomeArtista, textNomeNumeroDoisHomeArtista, txtNomeUsuario, txtSP;
    ImageView imagemPerfil, imgInstagram, imgFacebook, imgTelefone, imgFotoPerfilPequena, imgFotoPontos, imgFotoPostPerfil, imgSimboloFav, imgSimboloMusica, imgSimboloMensagem;

    String server_url = "http://192.168.0.240/ProjetoApollo/logo.png";
    String url_json = "http://192.168.0.240/ProjetoApollo/apollo.php";

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_artista_layout);

        nome = findViewById(R.id.textNome);
        sobre = findViewById(R.id.textBiografia);
        site = findViewById(R.id.textLink);


        imgBtnSair = findViewById(R.id.imgBtnSair);
        textNomeNumeroHomeArtista = findViewById(R.id.textNomeNumeroHomeArtista);
        textNomeNumeroDoisHomeArtista = findViewById(R.id.textNomeNumeroDoisHomeArtista);
        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
        txtSP = findViewById(R.id.txtSP);
        imagemPerfil = findViewById(R.id.imagemPerfil);
        imgInstagram = findViewById(R.id.imgInstagram);
        imgFacebook = findViewById(R.id.imgFacebook);
        imgTelefone = findViewById(R.id.imgTelefone);
        imgFotoPerfilPequena = findViewById(R.id.imgFotoPerfilPequena);
        imgFotoPontos = findViewById(R.id.imgFotoPontos);
        imgFotoPostPerfil = findViewById(R.id.imgFotoPostPerfil);
        imgSimboloFav = findViewById(R.id.imgSimboloFav);
        imgSimboloMusica = findViewById(R.id.imgSimboloMusica);
        imgSimboloMensagem = findViewById(R.id.imgSimboloMensagem);
        imgSimboloLapis = findViewById(R.id.imgSimboloLapis);

        btnCarregaDados = findViewById(R.id.btnCarregaInformacoes);

        bottomNavigationView = findViewById(R.id.idBottomNavBar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout, new PerfilArtistaFragment()).commit();
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
                    case R.id.mInscricoes:
                        fragment = new InscricaoArtistaFragment();
                        break;
                    case R.id.mFeed:
                        fragment = new FeedArtistaFragment();
                        break;
                    case R.id.mNotificacoes:
                        fragment = new NotificacoesArtistaFragment();
                        break;
                    case R.id.mPerfil:
                        fragment = new PerfilArtistaFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.idframeLayout, fragment).commit();

                return true;
            }
        });

        //criando o carrega imagem
        imgSimboloLapis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImageRequest imageRequest = new ImageRequest(server_url,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                imgFotoPostPerfil.setImageBitmap(response);
                            }
                        }, 0, 0,
                        ImageView.ScaleType.CENTER_CROP, null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),
                                        "Erro ao visualizar a imagem",
                                        Toast.LENGTH_SHORT).show();
                                error.printStackTrace();
                            }
                        });
                MySingleton.getInstance(getApplicationContext()).addToRequestQue(imageRequest);
            }
        });

        btnCarregaDados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_json, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    //Os nomes recebidos pelo response.get deverá ter o mesmo nome dos campos da tabela php
                                    nome.setText(response.getString("Nome"));
                                    sobre.setText(response.getString("Sobre"));
                                    site.setText(response.getString("Site"));
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(),
                                            "Nenhum nome encontrado...",
                                            Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao carregar as informações",
                                Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                MySingleton.getInstance(HomeArtista_Activity.this).addToRequestque(jsonObjectRequest);
            }
        });

    }


    public void voltarJanelaSair(View view) {
        Intent voltarJanelaSair = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(voltarJanelaSair);
    }
}