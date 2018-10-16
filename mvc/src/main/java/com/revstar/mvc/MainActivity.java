package com.revstar.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.revstar.mvc.model.UserLoginListener;
import com.revstar.mvc.model.UserLoginModelImpl;


public class MainActivity extends AppCompatActivity {

    AppCompatButton btn_login, btn_clear;
    EditText edit_account, edit_password;
    UserLoginModelImpl login = new UserLoginModelImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = this.findViewById(R.id.btn_login);
        btn_clear = this.findViewById(R.id.btn_clear);
        edit_account = this.findViewById(R.id.edit_account);
        edit_password = this.findViewById(R.id.edit_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.login(edit_account.getText().toString(), edit_password.getText().toString(), new UserLoginListener() {
                    @Override
                    public void success() {
                        Log.d("登录成功", "!");
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failed() {
                        Log.d("登录失败", "!");
                        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        //清除密码
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.clear(edit_account, edit_password);
            }
        });

    }
}
