package com.revstar.mvc.model;


import android.os.Handler;
import android.util.Log;
import android.widget.EditText;

/**
 * Create on 2018/10/13 15:29
 * author revstar
 * Email 1967919189@qq.com
 */
public class UserLoginModelImpl implements UserLoginMode {

    @Override
    public void login(final String account, final String passWord, final UserLoginListener userLoginListener) {

        Log.d("正在登录","......");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (account.equals("revstar")&&passWord.equals("123")){
                    userLoginListener.success();
                }else {
                    userLoginListener.failed();
                }
            }
        },3000);
    }

    @Override
    public void clear(EditText account, EditText password) {
        account.getText().clear();
        password.getText().clear();
    }


}
