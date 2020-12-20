package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WhetherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whether);
        getSupportActionBar().hide();
    }
}