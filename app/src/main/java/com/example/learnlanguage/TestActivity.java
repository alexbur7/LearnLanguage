package com.example.learnlanguage;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class TestActivity extends SingleFragmentActivity implements TestFragment.Next {
    //private ViewPager viewPager;
    private List<Words> words;
    private int code;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        code = getIntent().getIntExtra(BodyActivity.BODY_CODE, -1);
        words = MainActivity.newDatabase().getWordsDao().getWordsTopic(code);
    }

    @Override
    public Fragment createFragment(int position) {
        return new TestFragment(position, code);
    }

    @Override
    public void nextQuestion() {
        if (position<words.size()-1) {
            position++;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TestFragment(position,code)).commit();
        }
        else position=0;
    }

    @Override
    public void exitTest() {
        Intent intent;
        if (code==0) {
            intent = new Intent(this, BodyActivity.class);
        }
        else if (code==1){
            intent = new Intent(this,FoodActivity.class);
        }
        else if (code==2){
            intent = new Intent(this,WhetherActivity.class);
        }
        else {
            intent = new Intent(this,RegActivity.class);
        }
        startActivity(intent);
    }

   /* @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_pager);
        words = MainActivity.newDatabase().getWordsDao().getWords();
        viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return new TestFragment(position);
            }

            @Override
            public int getCount() {
                return words.size();
            }
        });
    }*/

}
