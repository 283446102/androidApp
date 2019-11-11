package base;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

/**
 * @author LiWeiChi
 * @Date 2019-07-16 16:01
 * 功能:
 */
public abstract class BasePresenter<M extends BaseModel, V extends BaseView> implements IPresenter<V> {
    protected M mModel;
    protected V mView;
    protected Context mContext;

    public BasePresenter(Context context) {
        this.mContext = context;
        mModel = bindModel();
    }

    public abstract M bindModel();

    @Override
    public void attachView(@NonNull V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
