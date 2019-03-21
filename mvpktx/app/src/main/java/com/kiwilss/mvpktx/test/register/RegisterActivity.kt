/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: RegisterActivity
 * Author:   kiwilss
 * Date:     2019/3/13 13:46
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.register

import android.os.Bundle
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity

/**
 *@FileName: RegisterActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/13
 * @desc   : {DESCRIPTION}
 */
class RegisterActivity: BaseActivity<RegisterPresenter>() {
    override fun initPresenter(): RegisterPresenter? = RegisterPresenter()

    override fun initData() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {



    }

    override fun getLayoutId(): Int = R.layout.activity_register
}