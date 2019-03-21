package com.kiwilss.buglyone;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

/**
 * @author : Lss kiwilss
 * @FileName: MyApp
 * @e-mail : kiwilss@163.com
 * @time : 2019/1/14
 * @desc : {DESCRIPTION}
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

//        //设置自定义升级提示对话框
        Beta.upgradeDialogLayoutId = R.layout.update_custom_dialog;
//
        Beta.largeIconId = R.mipmap.wm_big;
//
//        //Beta.canShowUpgradeActs.add(UpdateActivity.class);
//
///**
// * 设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
// */
        Beta.initDelay = 3000;
//
        Bugly.init(getApplicationContext(), "18ea610bd7", false);
//
        Beta.strUpgradeDialogCancelBtn = "残忍拒绝";
        Beta.strUpgradeDialogContinueBtn = "立即更新";
    }
}
