package base;

import android.app.Activity;
import android.content.Intent;

/**
 * @author LiWeiChi
 * @Date 2019-07-16 15:54
 * 功能:
 */
public interface BaseView {
    /*
    * 显示消息
    * */
    void showPromptMessage(String message);


    void setResultFinish(int resultCode);

    void setResultFinish(Intent intent,int resultCode);

}
