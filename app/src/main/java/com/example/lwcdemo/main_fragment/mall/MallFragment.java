package com.example.lwcdemo.main_fragment.mall;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lwcdemo.R;

import base.fragment.BaseMvpFragment;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 9:41
 * 功能：
 */
public class MallFragment extends BaseMvpFragment<MallPresenter> implements MallView {

    public static MallFragment newInstance(){
        MallFragment fragment = new MallFragment();
        return fragment;
    }

    @Override
    protected MallPresenter createPresenter() {
        return new MallPresenter(getContext());
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_mall_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
