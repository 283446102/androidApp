package com.example.lwcdemo.main_fragment.mine;

import java.util.List;

import base.BaseView;
import bean.TaskBean;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 9:43
 * 功能：
 */
public interface MineView extends BaseView {
    public void showTask(List<TaskBean> data);
}
