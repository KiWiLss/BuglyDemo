package com.kiwilss.xupdatetest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.CustomVersionDialogListener;
import com.allenliu.versionchecklib.v2.callback.ForceUpdateListener;

public class MainActivity extends AppCompatActivity {

    String mDownLoadUrl = "http://download.alicdn.com/wireless/dingtalk/latest/rimet_10034481.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void defaultFun(View view) {//只使用下载模式,默认界面进度条下载
        AllenVersionChecker
                .getInstance()
                .downloadOnly(
                        UIData.create().setTitle("应用有更新")
                        .setContent("更新内容")
                        .setDownloadUrl(mDownLoadUrl)
                        //UIData.create().setDownloadUrl(mDownLoadUrl)
                ).executeMission(this);
    }

    public void defaultFunForce(View view) {//只使用下载模式,默认界面进度条下载,强制更新
        DownloadBuilder downloadBuilder = AllenVersionChecker.getInstance().downloadOnly(
                UIData.create().setTitle("应用有更新")
                        .setContent("更新内容")
                        .setDownloadUrl(mDownLoadUrl)
        );

        //设置强制更新
        downloadBuilder.setForceUpdateListener(new ForceUpdateListener() {
            @Override
            public void onShouldForceUpdate() {//下载完成时会调用
                Toast.makeText(MainActivity.this, "强制更新", Toast.LENGTH_SHORT).show();
            }
        });
        //设置是否显示通知栏,默认显示,可自定义通知栏
        //downloadBuilder.setShowNotification(false);
        //设置是否显示下载对话框
        downloadBuilder.setShowDownloadingDialog(false);

        downloadBuilder.executeMission(this);
    }

    public void customDialog(View view) {
        DownloadBuilder downloadBuilder = AllenVersionChecker.getInstance().downloadOnly(
                UIData.create().setTitle("应用有更新")
                        .setContent("更新内容")
                        .setDownloadUrl(mDownLoadUrl)
        );
        //设置自定义升级界面
        downloadBuilder.setCustomVersionDialogListener(new CustomVersionDialogListener() {
            @Override
            public Dialog getCustomVersionDialog(Context context, UIData versionBundle) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_custom_sure);
                //BaseDialog baseDialog = new BaseDialog(context, R.style.BaseDialog, R.layout.custom_dialog_one_layout);
                //versionBundle 就是UIData，之前开发者传入的，在这里可以拿出UI数据并展示
//                TextView textView = baseDialog.findViewById(R.id.tv_msg);
//                textView.setText(versionBundle.getContent());
                return dialog;
            }
        });
        //设置自定义下载对话框
//        downloadBuilder.setCustomDownloadingDialogListener(new CustomDownloadingDialogListener() {
//            @Override
//            public Dialog getCustomDownloadingDialog(Context context, int progress, UIData versionBundle) {
//                return null;
//            }
//
//            @Override
//            public void updateUI(Dialog dialog, int progress, UIData versionBundle) {
//
//            }
//        });
        //设置是否显示通知栏,默认显示,可自定义通知栏
        //downloadBuilder.setShowNotification(false);
        //设置是否显示下载对话框
        //downloadBuilder.setShowDownloadingDialog(false);

        downloadBuilder.executeMission(this);
    }
}
