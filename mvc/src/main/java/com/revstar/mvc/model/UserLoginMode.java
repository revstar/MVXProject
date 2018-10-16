package com.revstar.mvc.model;

import android.widget.EditText;

/**
 * Create on 2018/10/13 15:26
 * author revstar
 * Email 1967919189@qq.com
 */
public interface UserLoginMode {
    void login(String account, String passWord, UserLoginListener userLoginListener);
    void clear(EditText account,EditText password);
}
