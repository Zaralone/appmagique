package com.example.administrateur.mystackappmagique.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrateur.mystackappmagique.R;


public class FocusQuestionFragment extends Fragment {
    Button imageButton;

    public FocusQuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        addListenerOnButton(inflater.inflate(R.layout.fragment_focus_question, container, false));

        return inflater.inflate(R.layout.fragment_focus_question, container, false);
    }

    public void addListenerOnButton (@NonNull View view) {

        imageButton = (Button) view.findViewById(R.id.favorikiki);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getActivity(), "Ajouté aux Favoris", Toast.LENGTH_SHORT).show();

            }

        });

    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        



    }
}
