package com.revstar.mvp;

import android.app.ProgressDialog;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.revstar.mvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,LoginView {

    private EditText editAccount;
    private EditText editPassword;
    private AppCompatButton btnLogin;
    private AppCompatButton btnClear;
    private LoginPresenter mLoginPresenter;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }


    private void initView() {
        mLoginPresenter=new LoginPresenter(this,this);

        mProgressDialog=new ProgressDialog(this);
        mProgressDialog.setMessage("登录...");
        mProgressDialog.setCancelable(false);

        editAccount=this.findViewById(R.id.edit_account);
        editPassword=this.findViewById(R.id.edit_password);
        btnLogin=this.findViewById(R.id.btn_login);
        btnClear=this.findViewById(R.id.btn_clear);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                mLoginPresenter.login(editAccount.getText().toString(),editPassword.getText().toString());
                break;
            case R.id.btn_clear:
                mLoginPresenter.clear();
                break;

        }
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {

        mProgressDialog.cancel();
    }

    @Override
    public void success() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
        editAccount.getText().clear();
        editPassword.getText().clear();
    }
}
