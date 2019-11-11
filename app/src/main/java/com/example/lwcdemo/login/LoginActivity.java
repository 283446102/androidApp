package com.example.lwcdemo.login;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lwcdemo.R;

import base.BaseMvpActivity;
import butterknife.BindView;
import utils.ToastUtil;

/**
 * @author LiWeiChi
 * @Date 2019-09-09 17:05
 * 功能：登陆界面
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView, View.OnClickListener {

    private boolean flag=true;

    @BindView(R.id.edt_phone)
    EditText mEditPhone;
    @BindView(R.id.edt_password)
    EditText mEditPassword;
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.tv_forget)
    TextView mTvForget;
    @BindView(R.id.bt_login)
    TextView mBtLogin;
    @BindView(R.id.iv_is_visible)
    ImageView mIvIsVisible;

    @Override
    public void onBindView() {
        mTvRegister.setOnClickListener(this);
        mTvForget.setOnClickListener(this);
        mBtLogin.setOnClickListener(this);
        mIvIsVisible.setOnClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_register:
                break;
            case R.id.tv_forget:
                break;
            case R.id.bt_login:
                mPresenter.loadLogin(mEditPhone.getText().toString(),mEditPassword.getText().toString());
                break;
            case R.id.iv_is_visible:
                if (flag){
                    mEditPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mIvIsVisible.setImageDrawable(getResources().getDrawable(R.drawable.ic_visible));
                    flag=false;
                }else {
                    flag=true;
                    mIvIsVisible.setImageDrawable(getResources().getDrawable(R.drawable.ic_invisible));
                    mEditPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        ToastUtil.show(this,message);
    }
}
