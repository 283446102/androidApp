package com.example.lwcdemo.main_fragment.task;

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
public class TaskFragment extends BaseMvpFragment<TaskPresenter> implements TaskView {

    public static TaskFragment newInstance(){
        TaskFragment fragment = new TaskFragment();
        return fragment;
    }

    @Override
    protected TaskPresenter createPresenter() {
        return new TaskPresenter(getContext());
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_task_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
