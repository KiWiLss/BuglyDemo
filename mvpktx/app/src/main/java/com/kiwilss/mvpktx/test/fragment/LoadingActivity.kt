/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: LoadingActivity
 * Author:   kiwilss
 * Date:     2019/3/26 21:30
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.fragment

import android.os.Bundle
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity

/**
 *@FileName: LoadingActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class LoadingActivity: BaseActivity<LoadingPresenter>() {
    override fun initPresenter(): LoadingPresenter? = LoadingPresenter()

    override fun initData() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {

        //初始化fg
        val fg = LoadingFg()

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_loading_container,fg,"one").commit()



    }

    override fun getLayoutId(): Int = R.layout.activity_loading
}