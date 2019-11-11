package com.example.lwcdemo.main;


import android.view.View;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import com.example.lwcdemo.R;
import com.example.lwcdemo.main_fragment.home.HomeFragment;
import com.example.lwcdemo.main_fragment.mall.MallFragment;
import com.example.lwcdemo.main_fragment.mine.MineFragment;
import com.example.lwcdemo.main_fragment.task.TaskFragment;


import base.BaseMvpActivity;
import base.BasePresenter;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity{
    @BindView(R.id.rb_home)
    RadioButton mRbHome;
    @BindView(R.id.rb_task)
    RadioButton mRbTask;
    @BindView(R.id.rb_mall)
    RadioButton mRbMall;
    @BindView(R.id.rb_mine)
    RadioButton mRbMine;


    @Override
    public void onBindView() {
        mRbHome.setChecked(true);
        replaceContainer(R.id.fl_layout, HomeFragment.newInstance(), false);
        initView();
    }

    private void initView() {

    }




    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }



    /*
    * 点击事件，也可以使用原生android语句点击事件
    * */
    @OnClick({R.id.rb_home, R.id.rb_task, R.id.rb_mall, R.id.rb_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                toFragment(HomeFragment.newInstance());
                break;
            case R.id.rb_task:
                toFragment(TaskFragment.newInstance());
                break;
            case R.id.rb_mall:
                toFragment(MallFragment.newInstance());
                break;
            case R.id.rb_mine:
                toFragment(MineFragment.newInstance());
                break;
        }
    }

    private void toFragment(Fragment fragment){
        replaceContainer(R.id.fl_layout,fragment,false);
    }

    /*
    * 本activity暂时没有需要网络或者逻辑的处理，所以不需要P层
    * */
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
