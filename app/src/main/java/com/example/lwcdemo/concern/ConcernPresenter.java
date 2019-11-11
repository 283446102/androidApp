package com.example.lwcdemo.concern;

import android.content.Context;

import base.BasePresenter;

/**
 * @author LiWeiChi
 * @Date 2019-07-18 10:04
 * 功能:
 */
public class ConcernPresenter extends BasePresenter<ConcernModel, ConcernView> {
    public ConcernPresenter(Context context) {
        super(context);
    }

    @Override
    public ConcernModel bindModel() {
        return null;
    }
}
