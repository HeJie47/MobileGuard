package cn.edu.gdmec.android.mobileguard.m5virusscan;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m5virusscan.adapter.ScanVirusAdapter;
import cn.edu.gdmec.android.mobileguard.m5virusscan.entity.ScanAppInfo;

/**
 * Created by admin on 2017/11/18.
 */

public class VirusScanSpeedActivity extends AppCompatActivity implements View.OnClickListener{
    protected static final int SCAN_BENGIN = 100;
    protected static final int SCANNIMG = 101;
    protected static final int SCAN_FINISH = 102;
    private int total;
    private int process;
    private TextView mProcessTV;
    private PackageManager pm;
    private boolean flag;
    private boolean isStop;
    private TextView mScanAppTV;
    private Button mCancleBtn;
    private ImageView mScanningIcon;
    private RotateAnimation rani;
    private ListView mScanListView;
    private ScanVirusAdapter adapter;
    private List<ScanAppInfo> mScanAppInfos = new ArrayList<ScanAppInfo>();
    private SharedPreferences mSP;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg){
            switch (msg.what){

                case SCAN_BENGIN:
                    mScanAppTV.setText("初始化杀毒引擎中...");
                    break;

                case SCANNIMG:
                    ScanAppInfo info = (ScanAppInfo) msg.obj;
                    mScanAppTV.setText("正在扫描：" + info.appName);
                    int speed = msg.arg1;
                    mProcessTV.setText((speed * 100 / total) + "%");
                    mScanAppInfos.add(info);
                    adapter.notifyDataSetChanged();
                    mScanListView.setSelection(mScanAppInfos.size());
                    break;

                case SCAN_FINISH:
                    mScanAppTV.setText("扫描完成! ");
                    mScanningIcon.clearColorFilter();
                    mCancleBtn.setBackgroundResource(R.drawable.scan_complete);
                    savaScanTime();
                    break;
            }
        }
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    }

    @Override
    public void onClick(View v) {

    }
}
