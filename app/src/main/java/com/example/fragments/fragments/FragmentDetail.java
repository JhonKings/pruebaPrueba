package com.example.fragments.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragments.MainActivity;
import com.example.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDetail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDetail extends Fragment {

        TextView mensaje;

    public FragmentDetail() {
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
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        mensaje = view.findViewById(R.id.txt_fragment2);

        if(mensaje != null){
            pressTextMessageListener();
        }

        return view;

    }

    private void pressTextMessageListener(){

        mensaje.setOnClickListener(v -> {

            MainActivity ma = (MainActivity) getActivity();
            if(ma != null || !ma.fragmentThreeVisible){
                ma.cargarFragmentExtern();
            }

        });

    }

    public void updateMessagge(String message) {

        if (mensaje != null) {
            mensaje.setText(message);

        }

    }
}