package com.example.lwcdemo.splash;

import android.content.Context;

import base.BasePresenter;

/**
 * @author LiWeiChi
 * @Date 2019-07-17 14:29
 * 功能:P层的功能是将M层和V层连接起来，M层是数据加载，V层只做数据的显示，不做逻辑操作，逻辑操作尽量写在P层
 * 一般的流程是V层去调用P层的方法（逻辑操作），然后P层的方法里面再调用M层的方法（数据请求），然后再回调给V层
 * 它们相互引用的方法都写在相应的接口里面，只需要实现接口就可以了
 */
public class SplashPresenter extends BasePresenter<SplashModel,SplashView> {
    public SplashPresenter(Context context) {
        super(context);
    }

    @Override
    public SplashModel bindModel() {
        return new SplashModel();
    }

    //这个方法是V层调用的方法，通过这个方法进行逻辑操作，数据请求，然后回调给V层
    public void loadAppName(){
        String name="多闪";
        if (mView!=null){//此处是p层回调给V层
            mView.showAppName(name);
        }
    }
}
