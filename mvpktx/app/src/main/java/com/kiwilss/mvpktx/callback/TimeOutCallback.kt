/**
 * Copyright (C), 2017-2018, XXX有限公司
 * FileName: TimeOutCallback
 * Author:   kiwilss
 * Date:     2018/11/14 11:39
 * Description: time out
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.wanandroid.callback

import com.kingja.loadsir.callback.Callback
import com.kiwilss.mvpktx.R

/**
 *@FileName: TimeOutCallback
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2018/11/14
 * @desc   : time out
 */
class TimeOutCallback: Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_timeout
    }
}