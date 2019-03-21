/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: DialogFragment
 * Author:   kiwilss
 * Date:     2019/3/15 11:18
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.im.fg.dialog

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseFragment
import com.mob.imsdk.MobIM
import com.mob.imsdk.MobIMCallback
import com.mob.imsdk.MobIMMessageReceiver
import com.mob.imsdk.model.IMConversation
import com.mob.imsdk.model.IMMessage

/**
 *@FileName: DialogFragment
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/15
 * @desc   : {DESCRIPTION}
 */
class DialogFragment: BaseFragment<DialogPresenter>() {
    override fun initPresenter(): DialogPresenter? = DialogPresenter()

    override fun getLayoutId(): Int = R.layout.im_fg_dialog

    override fun initData() {
        //获取通话列表
        MobIM.getChatManager().getAllLocalConversations(object : MobIMCallback<List<IMConversation>> {
            override fun onSuccess(imConversations: List<IMConversation>) {
                LogUtils.e(imConversations)
                //设置上去

            }

            override fun onError(i: Int, s: String) {
                LogUtils.e(i)
            }
        })
    }

    override fun initInterface(view: View, savedInstanceState: Bundle?) {

        //在需要监听消息回调的地方，调用如下api，设置消息监听
        MobIM.addMessageReceiver(object : MobIMMessageReceiver{
            override fun onMessageReceived(p0: MutableList<IMMessage>?) {
                LogUtils.e(p0)
            }

            override fun onMsgWithDraw(p0: String?, p1: String?) {
                LogUtils.e("$p0-----$p1")
            }

        })

    }
}