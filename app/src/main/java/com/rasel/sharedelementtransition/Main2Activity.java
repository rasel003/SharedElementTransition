package com.rasel.sharedelementtransition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().setEnterTransition(null);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Second Plus");
    }
}
