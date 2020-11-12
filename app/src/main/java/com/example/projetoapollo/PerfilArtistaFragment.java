package com.example.projetoapollo;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.Objects;

public class PerfilArtistaFragment extends Fragment {

    ImageButton imgBtnSair;
    TextView textNome, textBiografia, textLink, textNomeNumeroHomeArtista, textNomeNumeroDoisHomeArtista, txtNomeUsuario, txtSP;
    ImageView imagemPerfil, imgInstagram, imgFacebook, imgTelefone, imgFotoPerfilPequena, imgFotoPontos, imgFotoPostPerfil, imgSimboloFav, imgSimboloMusica, imgSimboloMensagem, imgSimboloLapis;

    SmartTabLayout smartTabLayout;
    ViewPager viewPager;


    public PerfilArtistaFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_artista_layout, container, false);

        imgBtnSair = view.findViewById(R.id.imgBtnSair);
        textNome = view.findViewById(R.id.textNome);
        textBiografia = view.findViewById(R.id.textBiografia);
        textLink = view.findViewById(R.id.textLink);
        textNomeNumeroHomeArtista = view.findViewById(R.id.textNomeNumeroHomeArtista);
        textNomeNumeroDoisHomeArtista = view.findViewById(R.id.textNomeNumeroDoisHomeArtista);
        txtNomeUsuario = view.findViewById(R.id.txtNomeUsuario);
        txtSP = view.findViewById(R.id.txtSP);
        imagemPerfil = view.findViewById(R.id.imagemPerfil);
        imgInstagram = view.findViewById(R.id.imgInstagram);
        imgFacebook = view.findViewById(R.id.imgFacebook);
        imgTelefone = view.findViewById(R.id.imgTelefone);
        imgFotoPerfilPequena = view.findViewById(R.id.imgFotoPerfilPequena);
        imgFotoPontos = view.findViewById(R.id.imgFotoPontos);
        imgFotoPostPerfil = view.findViewById(R.id.imgFotoPostPerfil);
        imgSimboloFav = view.findViewById(R.id.imgSimboloFav);
        imgSimboloMusica = view.findViewById(R.id.imgSimboloMusica);
        imgSimboloMensagem = view.findViewById(R.id.imgSimboloMensagem);
        imgSimboloLapis = view.findViewById(R.id.imgSimboloLapis);

        //retira a elevação do appBar


        return view;
    }
}