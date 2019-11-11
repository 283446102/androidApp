package com.example.lwcdemo.main_fragment.mine;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lwcdemo.R;

import java.util.List;

import base.fragment.BaseMvpFragment;
import bean.TaskBean;
import butterknife.BindView;
import utils.ToastUtil;

/**
 * @author LiWeiChi
 * @Date 2019-09-10 9:41
 * 功能：
 */
public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineView {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private MineAdapter mineAdapter = null;

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter(getContext());
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initView();
    }

    private void initView() {
        mineAdapter = new MineAdapter(null);//在创建适配器对象时，先不给其传值，防止在界面加载出来之前，数据比ui要更早加载出来
        initRecyclerView(mRecyclerView, mineAdapter);
    }

    private void initRecyclerView(RecyclerView recyclerView, BaseQuickAdapter adapter) {
        /*
         * 给RecyclerView设置布局样式，以及绑定适配器
         * */
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLazyInitData() {
        mPresenter.loadTask();
    }

    @Override
    public void showTask(List<TaskBean> data) {
        //给适配器加载数据
        if (mineAdapter != null) {
            mineAdapter.setNewData(data);
        }
    }
}
