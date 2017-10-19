package cn.edu.gdmec.android.mobileguard;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 2017/10/19.
 */

public class App extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        corrtctSIM();
    }
    public void corrtctSIM(){
        SharedPreferences sp = getSharedPreferences("config", Context.MODE_PRIVATE);
    }
}
