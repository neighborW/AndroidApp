package com.nuc.myapp.activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.nuc.myapp.R;
import com.nuc.myapp.api.Api;
import com.nuc.myapp.api.TtitCallback;
import com.nuc.myapp.util.AppConfig;
import com.nuc.myapp.util.StringUtil;
import android.content.Intent;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginActivity extends BaseActivity {

    private Button btnLogin;

    private EditText etAccount;

    private EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login);
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                login(account, pwd);
            }
        });
    }

    public void login(String account, String pwd) {
        if (StringUtil.isEmpty(account)) {
            showToast("请输入账户");
            return;
        }
        if (StringUtil.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }

        HashMap<String,Object> params = new HashMap();

        params.put("mobile",account);
        params.put("password",pwd);

        Api.config("app/login",params).postRequsr(new TtitCallback() {
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
