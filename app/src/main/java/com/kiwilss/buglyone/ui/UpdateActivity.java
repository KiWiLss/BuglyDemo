package com.kiwilss.buglyone.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kiwilss.buglyone.R;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;

/**
 * @author : Lss kiwilss
 * @FileName: UpdateActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/1/17
 * @desc : {DESCRIPTION}
 */
public class UpdateActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private android.widget.TextView tvupdateinfo;

    private TextView start;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        this.start = (TextView) findViewById(R.id.tv_update_start);
        this.tvupdateinfo = (TextView) findViewById(R.id.tv_update_info);

        /*获取下载任务，初始化界面信息*/
        updateBtn(Beta.getStrategyTask());
        tvupdateinfo.setText(tvupdateinfo.getText().toString() + Beta.getStrategyTask().getSavedLength() + "");

        Log.e(TAG, "onCreate: "+Beta.getUpgradeInfo().title);





        /*注册下载监听，监听下载事件*/
        Beta.registerDownloadListener(new DownloadListener() {
            @Override
            public void onReceive(DownloadTask task) {
                updateBtn(task);
                tvupdateinfo.setText(task.getSavedLength() + "");
            }

            @Override
            public void onCompleted(DownloadTask task) {
                updateBtn(task);
                tvupdateinfo.setText(task.getSavedLength() + "");
            }

            @Override
            public void onFailed(DownloadTask task, int code, String extMsg) {
                updateBtn(task);
                tvupdateinfo.setText("failed");

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*注销下载监听*/
        Beta.unregisterDownloadListener();
    }

    public void updateBtn(DownloadTask task) {
        /*根据下载任务状态设置按钮*/
        switch (task.getStatus()) {
            case DownloadTask.INIT:
            case DownloadTask.DELETED:
            case DownloadTask.FAILED: {
                //start.setText("开始下载");
            }
            break;
            case DownloadTask.COMPLETE: {
                start.setText("安装");
            }
            break;
            case DownloadTask.DOWNLOADING: {
                start.setText("暂停");
            }
            break;
            case DownloadTask.PAUSED: {
                start.setText("继续下载");
            }
            break;
            default:
        }
    }

    public void dowloadClick(View view) {
        DownloadTask task = Beta.startDownload();
        updateBtn(task);
        if (task.getStatus() == DownloadTask.DOWNLOADING) {
            //finish();
        }
    }



    public void cancelClick(View view) {
        Beta.cancelDownload();
        //finish();
    }
}
