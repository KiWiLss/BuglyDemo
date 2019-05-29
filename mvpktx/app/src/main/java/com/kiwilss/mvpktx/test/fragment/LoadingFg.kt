/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: LoadingFg
 * Author:   kiwilss
 * Date:     2019/3/26 21:39
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.fragment

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseFragment
import com.kiwilss.mvpktx.callback.PostUtil
import com.kiwilss.wanandroid.callback.ErrorCallback
import com.kiwilss.wanandroid.callback.LoadingCallback
import com.lxj.androidktx.core.toast

/**
 *@FileName: LoadingFg
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class LoadingFg: BaseFragment<LoadingFgPresenter>() {
    override fun initPresenter(): LoadingFgPresenter? = LoadingFgPresenter()

    override fun getLayoutId(): Int = R.layout.fg_loading

    override fun initData() {
        Thread(Runnable {
            SystemClock.sleep(2000)
            //progressDialog.dismiss();
            //成功的情况
            //loadService.showSuccess();
            //加载为空时
            //PostUtil.postCallbackDelayed(loadService, EmptyCallback.class);
            //加载失败时
            PostUtil.postCallbackDelayed(mLoadSir, ErrorCallback::class.java)
        }).start()
    }

    override fun initDataAgain() {
        super.initDataAgain()
        toast("no data")
    }

    override fun initInterface(view: View, savedInstanceState: Bundle?) {

        mLoadSir.showCallback(LoadingCallback::class.java)
    }
}