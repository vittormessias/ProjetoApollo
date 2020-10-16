package com.example.projetoapollo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PerfilPublicoFragment extends Fragment {

    ImageButton imgBtnSair;
    ImageView imgLogo, imgCoracao, imgInstagram, imgFacebook, imgSimboloTelefone, imgFotoPostPerfil, imgFotoPostPerfilDois, imgFotoPostPerfilTres, imgFotoPostPerfilQuatro;
    TextView txtNomeUsuario, txtDescricaoPerfil;

    BottomNavigationView bottomNavigationView;


    public PerfilPublicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_publico_layout, container, false);

        imgBtnSair = view.findViewById(R.id.imgBtnSair);
        imgLogo = view.findViewById(R.id.imgLogo);
        imgCoracao = view.findViewById(R.id.imgCoracao);
        imgInstagram = view.findViewById(R.id.imgInstagram);
        imgFacebook = view.findViewById(R.id.imgFacebook);
        imgSimboloTelefone = view.findViewById(R.id.imgSimboloTelefone);
        imgFotoPostPerfil = view.findViewById(R.id.imgFotoPostPerfil);
        imgFotoPostPerfilDois = view.findViewById(R.id.imgFotoPostPerfilDois);
        imgFotoPostPerfilTres = view.findViewById(R.id.imgFotoPostPerfilTres);
        imgFotoPostPerfilQuatro = view.findViewById(R.id.imgFotoPostPerfilQuatro);
        txtNomeUsuario = view.findViewById(R.id.txtNomeUsuario);
        txtDescricaoPerfil = view.findViewById(R.id.txtDescricaoPerfil);

        bottomNavigationView = view.findViewById(R.id.idBottomNavBar);

        //retira a elevação do appBar


        return view;
    }
}