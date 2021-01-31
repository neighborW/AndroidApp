package com.nuc.myapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nuc.myapp.util.StringUtil;

public class BaseActivity extends AppCompatActivity {

    private Context mComtext;

    @Override
    protected void onCreate(@Nullable Bundle sa){
        super.onCreate(sa);
        mComtext = this;
    }

    public void showToast(String str){

        Toast.makeText(mComtext,"str",Toast.LENGTH_SHORT).show();

    }

    public void navigateTo(Class activity){
        Intent intent = new Intent(mComtext,activity);
        startActivity(intent);
    }
}
