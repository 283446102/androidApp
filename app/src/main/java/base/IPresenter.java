package base;

import androidx.annotation.NonNull;

/**
 * @author LiWeiChi
 * @Date 2019-07-16 15:53
 * 功能:
 */
public interface IPresenter<V extends BaseView> {
    /*
    * 连接view
    * */
    void attachView(@NonNull V view);

    /*
    * 分离view
    * */
    void detachView();
}
