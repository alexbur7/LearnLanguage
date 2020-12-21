package com.example.learnlanguage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFragment extends Fragment {

    private int position;
    private List<Words> words;
    private TextView transWord;
    private Button buttonAnswer1;
    private Button buttonAnswer2;
    private Button buttonAnswer3;
    private Button buttonAnswer4;
    private Next next;
    private int topic;

    public TestFragment(int position, int topic, List<Words> words){
        this.position = position;
        this.topic = topic;
        this.words =words;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        next = (Next) context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_body_test,container,false);
        createView(view);
        initView();
        trueTranslation();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        next = null;
    }

    private void createView(View view) {
        transWord = view.findViewById(R.id.word_tranc);
        buttonAnswer1= view.findViewById(R.id.btnAnsw1);
        buttonAnswer2= view.findViewById(R.id.btnAnsw2);
        buttonAnswer3= view.findViewById(R.id.btnAnsw3);
        buttonAnswer4= view.findViewById(R.id.btnAnsw4);
    }

    private void initView() {
        transWord.setText(words.get(position).TransWord);
        List<String> translateWords = randomWords();
        buttonAnswer1.setText(translateWords.get(0));
        buttonAnswer2.setText(translateWords.get(1));
        buttonAnswer3.setText(translateWords.get(2));
        buttonAnswer4.setText(translateWords.get(3));
    }

    private List<String> randomWords() {
        List<String> translateWords = new ArrayList<>();
        translateWords.add(words.get(position).TrueWord);
        translateWords.add(words.get(position).FalseWord1);
        translateWords.add(words.get(position).FalseWord2);
        translateWords.add(words.get(position).FalseWord3);
        Collections.shuffle(translateWords);
        return translateWords;
    }

    private void trueTranslation(){
            buttonAnswer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonAnswer1.getText().equals(words.get(position).TrueWord)) {
                        next.nextQuestion();
                        Toast.makeText(getActivity(), R.string.true_answer, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        next.exitTest();
                    }
                }
            });
            buttonAnswer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonAnswer2.getText().equals(words.get(position).TrueWord)) {
                        next.nextQuestion();
                        Toast.makeText(getActivity(), R.string.true_answer, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        next.exitTest();
                    }
                }
            });
            buttonAnswer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonAnswer3.getText().equals(words.get(position).TrueWord)) {
                        next.nextQuestion();
                        Toast.makeText(getActivity(), R.string.true_answer, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        next.exitTest();
                    }
                }
            });
            buttonAnswer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonAnswer4.getText().equals(words.get(position).TrueWord)) {
                        next.nextQuestion();
                        Toast.makeText(getActivity(), R.string.true_answer, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        next.exitTest();
                    }
                }
            });
    }

    public interface Next {
        void nextQuestion();
        void exitTest();
    }
}