/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: IMLoginActivity
 * Author:   kiwilss
 * Date:     2019/3/13 17:25
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.im.login

import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity
import com.lxj.androidktx.core.getList
import com.lxj.androidktx.core.mmkv

/**
 *@FileName: IMLoginActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/13
 * @desc   : {DESCRIPTION}
 */
class IMLoginActivity: BaseActivity<IMLoginPresenter>() {
    override fun initPresenter(): IMLoginPresenter? = IMLoginPresenter()

    override fun initData() {


    }

    override fun initInterface(savedInstanceState: Bundle?) {

        val list = mmkv().getList<String>("data")
        LogUtils.e(list.size)
        LogUtils.e(list[0])

    }

    override fun getLayoutId(): Int = R.layout.im_activity_login
}