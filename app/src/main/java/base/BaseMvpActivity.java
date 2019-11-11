package base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @author LiWeiChi
 * @Date 2019-07-16 16:06
 * 功能:
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements BaseView {
    public P mPresenter;

    protected abstract P createPresenter();

    private void bindPresenter() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        bindPresenter();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void showPromptMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setResultFinish(int resultCode) {
        setResultFinish(null,resultCode);
    }

    @Override
    public void setResultFinish(Intent intent, int resultCode) {
        if (intent!=null){
            setResult(resultCode,intent);
        }else {
            setResult(resultCode);
        }
        finish();
    }

    //清除对view的引用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
