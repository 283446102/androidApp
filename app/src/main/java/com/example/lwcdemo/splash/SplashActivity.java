package com.example.lwcdemo.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lwcdemo.R;
import com.example.lwcdemo.login.LoginActivity;
import com.example.lwcdemo.main.MainActivity;

import base.BaseMvpActivity;
import base.BasePresenter;
import butterknife.BindView;

/**
 * @author LiWeiChi
 * @Date 2019-07-16 17:39
 * 功能:欢迎界面
 */
public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements SplashView {

    /*
    * 相当于findViewById
    * */
    @BindView(R.id.iv_logo)
    ImageView mIvLogo;
    @BindView(R.id.tv_name)
    TextView mTvName;

    /*
    * 引用相应的P层
    * */
    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter(this);
    }

    /*
    * 相当于onCreate的功能，在这里初始化一些控件
    * */
    @Override
    public void onBindView() {
        toMainActivity();
    }

    /*
    * 跳转到主界面
    * */
    private void toMainActivity() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }


    /*
    * 加载对应的xml布局
    * */
    @Override
    public int getLayout() {
        return R.layout.splash_layout;
    }

    /*
    * 懒加载，需要网络加载的操作最好写在这里
    * */
    @Override
    public void lazyLoad() {
        super.lazyLoad();
        mPresenter.loadAppName();//调用P层的方法，前面的是已经封装好的对象，通过里氏代换原则，声明父类对象，在需要的时候注入子类对象，从而达到使用子类对象的目的
    }

    @Override
    public void showAppName(String name) {
        mTvName.setText(name);
    }
}
