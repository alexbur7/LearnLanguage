package com.example.learnlanguage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment(int position);
    protected static int position=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment==null){
            fragment = createFragment(position);
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
