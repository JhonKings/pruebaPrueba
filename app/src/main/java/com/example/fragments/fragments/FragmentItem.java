package com.example.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.R;

public class FragmentItem extends Fragment {

    int cont = 1;

    public FragmentItem() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_item, container, false);



        //aqui se puede manipular los views del xml
        view.setOnClickListener(v -> {
            cont++;

            FragmentDetail frgDtl = (FragmentDetail) getParentFragmentManager().
                                    findFragmentById(R.id.fragment_detail);

            if(frgDtl != null){
                frgDtl.updateMessagge("Mensaje desde fragmento ITEM n# " + cont);
            }

        });


        return view;
        //return inflater.inflate(R.layout.fragment_item, container, false);
    }
}