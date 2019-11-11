package base;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author LiWeiChi
 * @Date 2019-07-16 16:09
 * 功能:最基础的Activity，封装页面加载创建
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder = null;//添加对butterknife的绑定
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//初始化窗口为无标题栏的
        if (getLayout() != 0) {
            setContentView(getLayout());
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mUnbinder = ButterKnife.bind(this);
        onBindView();
        /*
         * 懒加载数据，在页面生成后加载数据，但是如果是fragment的数据不建议在此处加载
         * */
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                lazyLoad();
            }
        });
    }

    /*
     * 初始化view相关的内容，随着页面直接加载出来，需要加载的数据不建议在这里直接加载出来
     * */
    public abstract void onBindView();


    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayout();

    /*
     * 数据延迟加载
     * */
    public void lazyLoad() {
    }

    /**做一个替换fragment的简单封装
     * @param containerViewId：替换的位置的id，在xml布局里面写好
     * @param fragment:需要替换的fragment
     * @param addToBackTask:是否需要物理按键返回，类似activity出栈
     */
    protected void replaceContainer(@IdRes int containerViewId, Fragment fragment, boolean addToBackTask) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerViewId, fragment);
        if (addToBackTask) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        super.onDestroy();
    }
}
