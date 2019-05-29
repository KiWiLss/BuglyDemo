/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: HomeActivity
 * Author:   kiwilss
 * Date:     2019/3/26 14:56
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.home

import android.os.Bundle
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity
import com.kiwilss.wanandroid.callback.LoadingCallback

/**
 *@FileName: HomeActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class HomeActivity: BaseActivity<HomePresenter>(){
    override fun initPresenter(): HomePresenter? = HomePresenter()

    override fun initData() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {

        mLoadSir.showCallback(LoadingCallback::class.java)





    }

    override fun getLayoutId(): Int = R.layout.activity_home

}