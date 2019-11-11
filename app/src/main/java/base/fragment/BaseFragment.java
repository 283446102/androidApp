package base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * @author LiWeiChi
 * @Date 2019-07-17 15:26
 * 功能:
 */
public abstract class BaseFragment extends Fragment {
    private View mRootView;
    protected FragmentActivity mActivity;

    public abstract Object setLayout();

    protected View setLayout(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return null;
    }

    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    public void onLazyInitData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            if (setLayout() instanceof Integer) {
                mRootView = inflater.inflate((int) setLayout(), container, false);
            } else if (setLayout() instanceof View) {
                mRootView = (View) setLayout();
            } else if (setLayout(inflater, container) != null) {
                mRootView = setLayout(inflater, container);
            }else {
                throw new ClassCastException("type of setLayout() must be int or View!");
            }
            ButterKnife.bind(this,mRootView);
            onBindView(savedInstanceState,mRootView);
        }
        ViewGroup parent=(ViewGroup)mRootView.getParent();
        if (parent!=null){
            parent.removeView(mRootView);
        }
        mRootView.post(new Runnable() {
            @Override
            public void run() {
                onLazyInitData();
            }
        });
        return mRootView;
    }

}
