package cn.edu.gdmec.android.mobileguard.m9advancedtools;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by admin on 2017/12/19.
 */

public class AdvancedToolsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savadInstanceState){
        super.onCreate(savadInstanceState);
        setContentView(R.layout.activity_advanced_tools);
        initView();
    }
    @Override
    public void onClick(View v) {

    }
}
