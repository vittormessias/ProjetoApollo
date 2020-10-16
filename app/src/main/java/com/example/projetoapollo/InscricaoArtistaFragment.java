package com.example.projetoapollo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InscricaoArtistaFragment extends Fragment {

    Button btnPesquisar;
    TextView txtInscricoes, txtVitor, txtRobert, txtGustavo, txtYasmin, txtLouise;
    ImageView imgVitor, imgRobert, imgGustavo, imgYasmin, imgLouise;


    public InscricaoArtistaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.inscricao_artista_layout, container, false);

        btnPesquisar = view.findViewById(R.id.btnPesquisar);
        txtInscricoes = view.findViewById(R.id.txtInscricoes);
        txtVitor = view.findViewById(R.id.txtVitor);
        txtRobert = view.findViewById(R.id.txtRobert);
        txtGustavo = view.findViewById(R.id.txtGustavo);
        txtYasmin = view.findViewById(R.id.txtYasmin);
        txtLouise = view.findViewById(R.id.txtLouise);
        imgVitor = view.findViewById(R.id.imgVitor);
        imgRobert = view.findViewById(R.id.imgRobert);
        imgGustavo = view.findViewById(R.id.imgGustavo);
        imgYasmin = view.findViewById(R.id.imgYasmin);
        imgLouise = view.findViewById(R.id.imgLouise);


        return view;
    }
}