/**
 * Copyright (C), 2017-2018, XXX有限公司
 * FileName: CustomCallback
 * Author:   kiwilss
 * Date:     2018/11/19 09:55
 * Description: custom
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.wanandroid.callback

import com.kingja.loadsir.callback.Callback
import com.kiwilss.mvpktx.R

/**
 *@FileName: CustomCallback
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2018/11/19
 * @desc   : custom
 */
class CustomCallback: Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_custom
    }
}