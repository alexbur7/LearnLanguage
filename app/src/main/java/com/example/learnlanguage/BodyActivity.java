package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.List;

public class BodyActivity extends AppCompatActivity {
    private RecyclerView rvBodyW;
    private Button testButton;
    private Button backButton;
    private int code;
    public static final String BODY_CODE = "body_code";


    List<Words> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        getSupportActionBar().hide();
        code = getIntent().getIntExtra(BODY_CODE, -1);
        words = Room.databaseBuilder(this , WordsDatabase.class , "Words.db").allowMainThreadQueries().build().getWordsDao().getWordsTopic(code);

        rvBodyW = findViewById(R.id.rvWords);
        rvBodyW.setLayoutManager(new LinearLayoutManager(this));
        rvBodyW.setAdapter(new MyAdapter(this,words));

        testButton = findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BodyActivity.this, TestActivity.class);
                intent.putExtra(BODY_CODE,code);
                startActivity(intent);
            }
        });

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BodyActivity.this,Activity2.class);
                startActivity(intent);
            }
        });

    }


}