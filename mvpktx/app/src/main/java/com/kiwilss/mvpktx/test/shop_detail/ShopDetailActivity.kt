/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ShopDetailActivity
 * Author:   kiwilss
 * Date:     2019/3/12 16:57
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.shop_detail

import android.os.Bundle
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity

/**
 *@FileName: ShopDetailActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/12
 * @desc   : {DESCRIPTION}
 */
 class ShopDetailActivity: BaseActivity<ShopDetailPresenter>() {
    override fun initPresenter(): ShopDetailPresenter? = ShopDetailPresenter()

    override fun initData() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId(): Int = R.layout.activity_shop_detail
}