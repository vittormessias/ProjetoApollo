package com.example.projetoapollo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FavoritosFragment extends Fragment {

    Button btn1, btnImgRobert1, btnVermelho1, btn2, btnImgRobert2, btnVermelho2;


    public FavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.favoritos_fragment_layout, container, false);

        btn1 = view.findViewById(R.id.btn1);
        btnImgRobert1 = view.findViewById(R.id.btnImgRobert1);
        btnVermelho1 = view.findViewById(R.id.btnVermelho1);
        btn2 = view.findViewById(R.id.btn2);
        btnImgRobert2 = view.findViewById(R.id.btnImgRobert2);
        btnVermelho2 = view.findViewById(R.id.btnVermelho2);

        return view;
    }
}