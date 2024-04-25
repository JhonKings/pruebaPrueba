package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.window.OnBackInvokedDispatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fragments.fragments.FragmentDetail;
import com.example.fragments.fragments.FragmentExtern;
import com.example.fragments.fragments.FragmentItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    public boolean fragmentThreeVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cargarFragmentItem();

        cargarFragmentDetail();



    }

    private void cargarFragmentDetail() {

        fm.beginTransaction()
                .replace(R.id.fragment_detail, new FragmentDetail())
                .commit();
    }

    private void cargarFragmentItem() {

        fm.beginTransaction().replace(R.id.fragment_item, new FragmentItem()).commit();

    }

    public void cargarFragmentExtern() {

        fm.beginTransaction()
                .replace(R.id.fragment_extern, new FragmentExtern())
                .commit();

        findViewById(R.id.fragment_extern).setVisibility(View.VISIBLE);

        fragmentThreeVisible = true;
    }

    @Override
    public void onBackPressed(){
        if(fragmentThreeVisible){
            fm.beginTransaction()
                    .remove(Objects.requireNonNull(fm.findFragmentById(R.id.fragment_extern)))
                    .commit();

            findViewById(R.id.fragment_extern).setVisibility(View.GONE);

            fragmentThreeVisible = false;
        }else{
            super.onBackPressed();
        }
    }
}