package com.example.projetoapollo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class ExplorarFragment extends Fragment {

    Button btnCaixaPesquisa, btnPesquisar, btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    ImageView imgLupa;


    public ExplorarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.explorar_layout, container, false);

        btnCaixaPesquisa = view.findViewById(R.id.btnCaixaPesquisa);
        btnPesquisar = view.findViewById(R.id.btnPesquisar);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        btn5 = view.findViewById(R.id.btn5);
        btn6 = view.findViewById(R.id.btn6);
        btn7 = view.findViewById(R.id.btn7);
        imgLupa = view.findViewById(R.id.imgLupa);

        return view;
    }
}