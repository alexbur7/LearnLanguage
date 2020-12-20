package com.example.learnlanguage;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import androidx.room.Entity;


@Entity
public class Words{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "TransWord")
    public String TransWord;

    @ColumnInfo(name = "TrueWord")
    public String TrueWord;

    @ColumnInfo(name = "FalseWord1")
    public String FalseWord1;

    @ColumnInfo(name = "FalseWord2")
    public String FalseWord2;

    @ColumnInfo(name = "FalseWord3")
    public String FalseWord3;

    @ColumnInfo(name = "Topic")
    public int Topic;

    public Words(@NonNull String TransWord, String TrueWord, String FalseWord1, String FalseWord2, String FalseWord3, int Topic) {
        this.TransWord = TransWord;
        this.TrueWord = TrueWord;
        this.FalseWord1 = FalseWord1;
        this.FalseWord2 = FalseWord2;
        this.FalseWord3 = FalseWord3;
        this.Topic = Topic;
    }
  /*  @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getTransWord() {
        return TransWord;
    }

    public void setTransWord(String transWord) {
        TransWord = transWord;
    }

    public String getTrueWord() {
        return TrueWord;
    }

    public void setTrueWord(String trueWord) {
        TrueWord = trueWord;
    }

    public String getFalseWord1() {
        return FalseWord1;
    }

    public void setFalseWord1(String falseWord1) {
        FalseWord1 = falseWord1;
    }

    public String getFalseWord2() {
        return FalseWord2;
    }

    public void setFalseWord2(String falseWord2) {
        FalseWord2 = falseWord2;
    }

    public String getFalseWord3() {
        return FalseWord3;
    }

    public void setFalseWord3(String falseWord3) {
        FalseWord3 = falseWord3;
    }

    public int getTopic() {
        return Topic;
    }

    public void setTopic(int topic) {
        Topic = topic;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", TransWord='" + TransWord  +
                ", TrueWord='" + TrueWord +
                ", FalseWord1='" + FalseWord1 +
                ", FalseWord2='" + FalseWord2  +
                ", FalseWord3='" + FalseWord3 +
                ", Topic=" + Topic +
                '}';
    }*/
}
