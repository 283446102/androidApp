package com.example.lwcdemo.main_fragment.task;

import android.content.Context;

import base.BasePresenter;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 9:42
 * 功能：
 */
public class TaskPresenter extends BasePresenter<TaskModel, TaskView> {
    public TaskPresenter(Context context) {
        super(context);
    }

    @Override
    public TaskModel bindModel() {
        return null;
    }
}
