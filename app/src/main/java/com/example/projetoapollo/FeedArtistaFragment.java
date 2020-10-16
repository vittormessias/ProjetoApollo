package com.example.projetoapollo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FeedArtistaFragment extends Fragment {

    ImageView imgFotoPerfilPequena, imgFotoPontos, imgFotoPostPerfil, imgFotoPerfilPequena2, imgFotoPontos2, imgFotoPostPerfil2, imgFotoPerfilPequena3, imgFotoPontos3, imgFotoPostPerfil3;
    TextView txtNomeUsuario, txtSP, txtNomeUsuario2, txtSP2, txtNomeUsuario3, txtSP3;


    public FeedArtistaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.feed_artista_layout, container, false);

        imgFotoPerfilPequena = view.findViewById(R.id.imgFotoPerfilPequena);
        imgFotoPontos = view.findViewById(R.id.imgFotoPontos);
        imgFotoPostPerfil = view.findViewById(R.id.imgFotoPostPerfil);
        imgFotoPerfilPequena2 = view.findViewById(R.id.imgFotoPerfilPequena2);
        imgFotoPontos2 = view.findViewById(R.id.imgFotoPontos2);
        imgFotoPostPerfil2 = view.findViewById(R.id.imgFotoPostPerfil2);
        imgFotoPerfilPequena3 = view.findViewById(R.id.imgFotoPerfilPequena3);
        imgFotoPontos3 = view.findViewById(R.id.imgFotoPontos3);
        imgFotoPostPerfil3 = view.findViewById(R.id.imgFotoPostPerfil3);
        txtNomeUsuario = view.findViewById(R.id.txtNomeUsuario);
        txtSP = view.findViewById(R.id.txtSP);
        txtNomeUsuario2 = view.findViewById(R.id.txtNomeUsuario2);
        txtSP2 = view.findViewById(R.id.txtSP2);
        txtNomeUsuario3 = view.findViewById(R.id.txtNomeUsuario3);
        txtSP3 = view.findViewById(R.id.txtSP3);

        return view;
    }
}