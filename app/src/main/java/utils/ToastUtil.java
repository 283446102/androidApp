package utils;


import android.content.Context;
import android.widget.Toast;

/**
 * @author LiWeiChi
 * @Date 2019-07-18 09:44
 * 功能:
 */
public class ToastUtil {

    /**
     * 封装显示的信息
     * @param message
     */
    public static void show(Context mContext, String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }

}
