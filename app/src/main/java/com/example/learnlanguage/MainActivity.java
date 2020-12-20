package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.app.ProgressDialog;
import androidx.room.Room;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnlanguage.UserDao;
import com.example.learnlanguage.UserDatabase;
import com.example.learnlanguage.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button INSTbtn;
    private Button TGbtn;
    private Button Logbtn;
    private Button Regbtn;
    private Button VKbtn;
    private EditText edtEmail;
    private EditText edtPassword;
    private UserDatabase database;

    private User user;
    private UserDao userDao;
    private ProgressDialog progressDialog;
    private static WordsDatabase wordsDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Проверка пользователя...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);


        database = Room.databaseBuilder(this, UserDatabase.class, "LL.db")
                .allowMainThreadQueries()
                .build();
        wordsDatabase = Room.databaseBuilder(getApplicationContext() , WordsDatabase.class , "Words.db").allowMainThreadQueries().build();

        userDao = database.getUserDao();

        Logbtn = findViewById(R.id.LogBtn);
        Regbtn = findViewById(R.id.RegBtn);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LogBtn:
                if (!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(edtEmail.getText().toString(), edtPassword.getText().toString());
                            if(user!=null){
                                Intent i = new Intent(MainActivity.this, Activity2.class);
                                i.putExtra("User", user);
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(MainActivity.this, "Незарегистрированный пользователь или неверный логин/пароль",
                                        Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);

                }else{
                    Toast.makeText(MainActivity.this, "Пустые поля", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.RegBtn:
                Intent intent2 = new Intent(this, RegActivity.class);
                startActivity(intent2);

                break;

            case R.id.VKbtn:
                Intent vk = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/public201203730"));
                startActivity(vk);

                break;

            case R.id.INSTbtn:
                Intent inst = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/learnlanguage0718?r=nametag"));
                startActivity(inst);

                break;

            case R.id.TGbtn:
                Intent tg = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/joinchat/AAAAAFP_qIGlOfRrAImDVQ"));
                startActivity(tg);

                break;

            default:
                break;
        }

    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }

    public static WordsDatabase newDatabase(){
        return wordsDatabase;
    }



}