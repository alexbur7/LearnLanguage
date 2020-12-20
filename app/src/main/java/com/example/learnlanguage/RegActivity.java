package com.example.learnlanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnlanguage.UserDao;
import com.example.learnlanguage.UserDatabase;
import com.example.learnlanguage.User;

public class RegActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtSurname;
    private EditText edtEmail;
    private EditText edtPassword;

    private Button RegBtn2;
    private Button CancelBtn;

    private UserDao userDao;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Регистрация...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);


        edtName = findViewById(R.id.edtName);
        edtSurname = findViewById(R.id.edtSurname);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        CancelBtn = findViewById(R.id.CancelBtn);
        RegBtn2 = findViewById(R.id.RegBtn2);

        userDao = Room.databaseBuilder(this, UserDatabase.class, "LL.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RegBtn2:
                if (!isEmpty()) {

                    progressDialog.show();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(edtName.getText().toString(), edtSurname.getText().toString(),
                                    edtEmail.getText().toString(), edtPassword.getText().toString());
                            userDao.insert(user);
                            progressDialog.dismiss();
                            startActivity(new Intent(RegActivity.this, MainActivity.class));
                        }
                    }, 1000);

                } else {
                    Toast.makeText(RegActivity.this, "Пустые поля", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.CancelBtn:
                Intent intent10 = new Intent(this, MainActivity.class);
                startActivity(intent10);
                break;
            default:
                break;
        }

    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) ||
                TextUtils.isEmpty(edtPassword.getText().toString()) ||
                TextUtils.isEmpty(edtName.getText().toString()) ||
                TextUtils.isEmpty(edtSurname.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }

}