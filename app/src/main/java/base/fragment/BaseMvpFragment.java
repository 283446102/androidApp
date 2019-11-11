package base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import base.BasePresenter;
import base.BaseView;

/**
 * @author LiWeiChi
 * @Date 2019-07-17 15:53
 * 功能:
 */
public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements BaseView {
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter=createPresenter();
        bindPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract P createPresenter();

    private void bindPresenter(){
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    @Override
    public void showPromptMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setResultFinish(int resultCode) {
        setResultFinish(null,resultCode);
    }

    @Override
    public void setResultFinish(Intent intent, int resultCode) {
        if (intent!=null){
            mActivity.setResult(resultCode,intent);
        }else {
            mActivity.setResult(resultCode);
        }
        mActivity.finish();
    }

}
