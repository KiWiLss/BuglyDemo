/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: IMHomeActivity
 * Author:   kiwilss
 * Date:     2019/3/13 21:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.im.home

import android.content.Context
import android.os.Bundle
import com.alibaba.fastjson.JSON
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity
import com.lxj.androidktx.core.mmkv
import com.mob.pushsdk.MobPush
import com.mob.pushsdk.MobPushCustomMessage
import com.mob.pushsdk.MobPushNotifyMessage
import com.mob.pushsdk.MobPushReceiver
import com.mob.ums.User
import com.mob.ums.gui.UMSGUI


/**
 *@FileName: IMHomeActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/13
 * @desc   : {DESCRIPTION}
 */
class IMHomeActivity: BaseActivity<IMHomePresenter>() {
    override fun initPresenter(): IMHomePresenter? = IMHomePresenter()

    override fun initData() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {

        val stringExtra = mmkv().getString("user", "")
        //val stringExtra = intent.getStringExtra("data")
        val list = JSON.parseArray(stringExtra)
        LogUtils.e(list.size)
        val user: User = list[0] as User


        UMSGUI.showProfilePage()


        MobPush.addPushReceiver(object : MobPushReceiver{
            override fun onAliasCallback(p0: Context?, p1: String?, p2: Int, p3: Int) {
//接收alias的增改删查操作
                LogUtils.e("alias" + p1 + "=" + p2 + "--" + p3)
            }

            override fun onCustomMessageReceive(p0: Context?, p1: MobPushCustomMessage?) {
                //接收自定义消息
                LogUtils.e("custom--" + p1)
            }

            override fun onNotifyMessageReceive(p0: Context?, p1: MobPushNotifyMessage?) {
                //接收通知消息
                LogUtils.e("notify" + "---" + p1)
            }

            override fun onTagsCallback(p0: Context?, p1: Array<out String>?, p2: Int, p3: Int) {
                //接收tags的增改删查操作
                LogUtils.e("tagcall--" + p1)
            }

            override fun onNotifyMessageOpenedReceive(p0: Context?, p1: MobPushNotifyMessage?) {
                //接收通知消息被点击事件
                LogUtils.e("notify open--" + p1)
            }

        })

    }

    override fun onDestroy() {
        //MobPush.removePushReceiver(receiver);
        super.onDestroy()
    }

    override fun getLayoutId(): Int = R.layout.im_activity_home
}