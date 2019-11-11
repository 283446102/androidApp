package com.example.lwcdemo.main_fragment.mine;

import android.content.Context;

import com.example.lwcdemo.R;

import java.util.ArrayList;
import java.util.List;

import base.BasePresenter;
import bean.TaskBean;
import utils.ToastUtil;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 9:42
 * 功能：
 */
public class MinePresenter extends BasePresenter<MineModel, MineView> {
    public MinePresenter(Context context) {
        super(context);
    }

    @Override
    public MineModel bindModel() {
        return null;
    }

    public void loadTask(){
        List<TaskBean> list = new ArrayList<>();
        TaskBean bean1 = new TaskBean("小画家", R.drawable.ic_concern_checked);
        TaskBean bean2 = new TaskBean("读书郎", R.drawable.ic_like_checked);
        TaskBean bean3 = new TaskBean("添加", R.drawable.ic_add);
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        if (mView!=null){
            mView.showTask(list);
        }
    }
}
