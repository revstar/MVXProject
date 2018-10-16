package com.revstar.mvp.model;

/**
 * Create on 2018/10/16 16:02
 * author revstar
 * Email 1967919189@qq.com
 */
public interface UserLoginModel {

    void login(String account,String password ,UserLoginListener userLoginListener);
}
