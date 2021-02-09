package com.nuc.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nuc.myapp.R;
import com.nuc.myapp.api.Api;
import com.nuc.myapp.api.AppConfig;
import com.nuc.myapp.api.TtitCallback;
import com.nuc.myapp.util.StringUtil;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void register(String account , String pwd){

        if (StringUtil.isEmpty(account)){
            showToast("请输入账号");
            return;
        }
        if (StringUtil.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }

        HashMap<String,Object> params = new HashMap<>();
        params.put("mobile",account);
        params.put("password",pwd);

        Api.config(AppConfig.BASE_URI,params).postRequsr(new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(res);
                    }
                });
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
