package cn.edu.gdmec.android.mobileguard.m9advancedtools.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by admin on 2017/12/23.
 */

public class UIUtils {
    public static void showToast(final Activity context, final String msg){
        if("main".equals(Thread.currentThread().getName())){
            Toast.makeText(context, msg, 1).show();
        }else{
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, msg, 1).show();
                }
            });
        }
    }
}
