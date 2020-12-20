package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Activity2 extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().hide();


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BodyBtn:
                Intent intent3 = new Intent(this, BodyActivity.class);
                startActivity(intent3);
                break;
            case R.id.WhetherBtn:
                Intent intent4 = new Intent(this, WhetherActivity.class);
                startActivity(intent4);
                break;
            case R.id.BugBtn:
                Intent intent5 = new Intent(this, BugActivity.class);
                startActivity(intent5);
                break;
            case R.id.FoodBtn:
                Intent intent7 = new Intent(this, FoodActivity.class);
                startActivity(intent7);
                break;
            case R.id.Grammar:
                Intent Gram = new Intent(this, AddDB.class);
                startActivity(Gram);
                break;
            default:
                break;
        }

    }

}