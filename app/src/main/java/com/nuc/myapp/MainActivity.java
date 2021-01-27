package com.nuc.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nuc.myapp.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLongin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLongin = findViewById(R.id.login_btn);
        btnLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(in);

            }
        });

    }
}
