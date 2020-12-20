package com.example.learnlanguage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.learnlanguage.Words;

import java.util.List;

@Dao
public interface WordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWords(Words words);

    @Update
    void update(Words Words);

    @Delete
    void delete(Words Words);

    @Query("SELECT * FROM Words")
    List<Words> getWords();

    @Query("SELECT * FROM Words WHERE Topic LIKE:a")
    List<Words> getWordsTopic(int a);

}

