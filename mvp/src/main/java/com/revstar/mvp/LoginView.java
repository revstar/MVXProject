package com.revstar.mvp;

/**
 * Create on 2018/10/16 17:13
 * author revstar
 * Email 1967919189@qq.com
 */
public interface LoginView {
    void showLoading();
    void hideLoading();
    void success();
    void failed();
    void clear();
}
