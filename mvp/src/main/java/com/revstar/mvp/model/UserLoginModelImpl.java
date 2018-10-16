package com.revstar.mvp.model;

import android.os.Handler;
import android.support.design.widget.Snackbar;

/**
 * Create on 2018/10/16 16:03
 * author revstar
 * Email 1967919189@qq.com
 */
public class UserLoginModelImpl implements  UserLoginModel {
    @Override
    public void login(final String account, final String password, final UserLoginListener userLoginListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (account.equals("revstar")&&password.equals("123")){
                    userLoginListener.loginSuccess();
                }else {
                    userLoginListener.loginFailed();
                }
            }
        },3000);


    }
}
