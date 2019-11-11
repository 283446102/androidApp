package com.example.lwcdemo.main_fragment.home;

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
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeView {

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(getContext());
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_home_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
