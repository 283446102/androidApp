package com.example.lwcdemo.concern;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lwcdemo.R;

import base.fragment.BaseMvpFragment;

/**
 * @author LiWeiChi
 * @Date 2019-07-18 10:03
 * 功能:
 */
public class ConcernFragment extends BaseMvpFragment<ConcernPresenter> implements ConcernView {

    public static ConcernFragment newInstance() {
        ConcernFragment fragment = new ConcernFragment();
        return fragment;
    }

    @Override
    protected ConcernPresenter createPresenter() {
        return new ConcernPresenter(getContext());
    }

    @Override
    public Object setLayout() {
        return null;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
