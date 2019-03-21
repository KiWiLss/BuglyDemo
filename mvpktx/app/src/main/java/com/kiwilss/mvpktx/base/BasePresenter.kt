/**
 * Copyright (C), 2017-2018, XXX有限公司
 * FileName: BasePresenter
 * Author:   kiwilss
 * Date:     2018/12/12 09:09
 * Description: basepresenter
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.base

import android.content.Context


/**
 *@FileName: BasePresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2018/12/12
 * @desc   : basepresenter
 */
abstract class BasePresenter {

     private var mContext: Context? =null

    fun attech(context: Context?){
        mContext = context
    }

    fun detach() {
        mContext = null
    }


}