package com.example.lwcdemo.login;

import android.content.Context;

import base.BasePresenter;
import utils.ToastUtil;

/**
 * @author LiWeiChi
 * @Date 2019-11-10 21:07
 * 功能：
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {
    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    public LoginModel bindModel() {
        return null;
    }

    public void loadLogin(String phone, String password) {
        if (mView != null) {
            if (phone.length() == 0 || phone.equals("")) {
                mView.showMessage("请输入手机号码");
            } else if (phone.length() < 11) {
                mView.showMessage("手机号码格式错误");
            } else if (password.length() == 0 || password.equals("")) {
                mView.showMessage("请输入密码");
            } else {
                if (phone.equals("13278881883")) {
                    if (password.equals("123456")) {
                        mView.showMessage("登录成功");
                    } else {
                        mView.showMessage("密码错误");
                    }
                } else {
                    mView.showMessage("该手机号码未注册");
                }
            }
        }
    }
}
