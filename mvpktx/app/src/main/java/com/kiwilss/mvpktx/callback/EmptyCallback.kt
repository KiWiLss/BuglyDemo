/**
 * Copyright (C), 2017-2018, XXX有限公司
 * FileName: EmptyCallback
 * Author:   kiwilss
 * Date:     2018/11/14 10:33
 * Description: 数据为空的状态
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.wanandroid.callback

import com.kingja.loadsir.callback.Callback
import com.kiwilss.mvpktx.R


/**
 * FileName: EmptyCallback
 *@author : Lss kiwilss
 *     e-mail : kiwilss@163.com
 *     time   : 2018/11/14
 *     desc   : 数据为空的状态
 *Description: 数据为空的状态
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int = R.layout.layout_empty

}