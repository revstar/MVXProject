package com.revstar.mvp.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.revstar.mvp.LoginView;
import com.revstar.mvp.model.UserLoginListener;
import com.revstar.mvp.model.UserLoginModelImpl;

/**
 * Create on 2018/10/16 17:16
 * author revstar
 * Email 1967919189@qq.com
 */
public class LoginPresenter {

    private LoginView mLoginView;
    private UserLoginModelImpl mUserLoginModel;
    private Context mContext;

    public LoginPresenter(Context context, LoginView loginView) {

        this.mLoginView=loginView;
        mUserLoginModel = new UserLoginModelImpl();
        this.mContext = context;
    }

    public void login(String account, String passWord) {
        mLoginView.showLoading();
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(passWord)) {
            mLoginView.hideLoading();
            Toast.makeText(mContext,"用户名或者密码不能为空",Toast.LENGTH_SHORT).show();

        }else {
            mUserLoginModel.login(account, passWord, new UserLoginListener() {
                @Override
                public void loginSuccess() {
                    mLoginView.success();
                    mLoginView.hideLoading();
                }

                @Override
                public void loginFailed() {
                    mLoginView.failed();
                    mLoginView.hideLoading();
                }
            });
        }

    }

    public void clear(){
        mLoginView.clear();
    }
}
