package com.example.projetoapollo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NotificacoesArtistaFragment extends Fragment {

    Button btn1, btnImgRobert1, btnVermelho1, btn2, btnImgRobert, btnVermelho2, btn3, btnImgVitor1, btnVermelho3, btn4, btnImgYasmin1, btn5, btn6, btnImgVitor, btn7, btnImgGustavo, btn8, btnImgYasmin, btn9;

    public NotificacoesArtistaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.notificacoes_artista_layout, container, false);

        btn1 = view.findViewById(R.id.btn1);
        btnImgRobert1 = view.findViewById(R.id.btnImgRobert1);
        btnVermelho1 = view.findViewById(R.id.btnVermelho1);
        btn2 = view.findViewById(R.id.btn2);
        btnImgRobert = view.findViewById(R.id.btnImgRobert);
        btnVermelho2 = view.findViewById(R.id.btnVermelho2);
        btn3 = view.findViewById(R.id.btn3);
        btnImgVitor1 = view.findViewById(R.id.btnImgVitor1);
        btnVermelho3 = view.findViewById(R.id.btnVermelho3);
        btn4 = view.findViewById(R.id.btn4);
        btnImgYasmin1 = view.findViewById(R.id.btnImgYasmin1);
        btn5 = view.findViewById(R.id.btn5);
        btn6 = view.findViewById(R.id.btn6);
        btnImgVitor = view.findViewById(R.id.btnImgVitor);
        btn7 = view.findViewById(R.id.btn7);
        btnImgGustavo = view.findViewById(R.id.btnImgGustavo);
        btn8 = view.findViewById(R.id.btn8);
        btnImgYasmin = view.findViewById(R.id.btnImgYasmin);
        btn9 = view.findViewById(R.id.btn9);


        return view;
    }
}