package com.example.lwcdemo.main_fragment.mine;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lwcdemo.R;

import java.util.List;

import bean.TaskBean;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 14:35
 * 功能：
 */
public class MineAdapter extends BaseQuickAdapter<TaskBean, BaseViewHolder> {

    public MineAdapter(@Nullable List<TaskBean> data) {
        super(R.layout.item_layout_mine, data);//这里我直接定死了布局，就不在fragment内部传入布局了
    }

    /*
    * 这个方法是做适配器里面的操作的，也基本只需要写这个方法
    * item是实体类的数据，每次都是一个实体类，而传过来的是一个list，list里面是很多的实体类
    * helper就相当于你想要操作的控件的集合，它自动管理了
    * */
    @Override
    protected void convert(@NonNull BaseViewHolder helper, TaskBean item) {
        /*
        * 也可以这么写
        * TextView tvName=helper.getView(R.id.iv_mine);
        * tvName.setText(item.getName());
        * */
        helper.setText(R.id.tv_name,item.getName());
        ImageView imageView = helper.getView(R.id.iv_mine);
        imageView.setImageResource(item.getIcon());
    }
}
