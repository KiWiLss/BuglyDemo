/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyApp
 * Author:   kiwilss
 * Date:     2019/3/12 14:37
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.coder.zzq.smartshow.core.SmartShow
import com.kingja.loadsir.core.LoadSir
import com.kiwilss.wanandroid.callback.*
import com.lxj.androidktx.AndroidKtxConfig
import com.mob.MobSDK
import com.squareup.leakcanary.LeakCanary

/**
 *@FileName: MyApp
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/12
 * @desc   : {DESCRIPTION}
 */
class MyApp: Application(){

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context


    }

    override fun onCreate() {
        super.onCreate()
        mContext = this.applicationContext

        initAll()
    }



    private fun initAll() {
        //工具类初始化
        Utils.init(this)
        LogUtils.getConfig().setLogSwitch(true).globalTag = "MMM"
        //ktx初始化
        AndroidKtxConfig.init(this,defaultLogTag = "MMM")
        //toast,topbar,snackbar初始化
        SmartShow.init(this)
        //mob
        MobSDK.init(this)

        MultiDex.install(this)

        //全局loading设置
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(TimeOutCallback())
            .addCallback(CustomCallback())
            //.setDefaultCallback(LoadingCallback.class)//设置了默认每个界面初始都会出现
            .commit()

        //初始化内存检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)

    }
}