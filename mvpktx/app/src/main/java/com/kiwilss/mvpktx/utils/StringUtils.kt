/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: StringUtils
 * Author:   kiwilss
 * Date:     2019/3/4 17:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.utils

import com.kiwilss.mvpktx.config.URL_BASEURL


/**
 *@FileName: StringUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */




object StringUtils{

    const val isLog = true

    const val HINT_PHONE = "请输入手机号"
    const val HINT_PHONE_RIGHT = "请输入合法的手机号"
    const val HINT_PASSWORD = "请输入密码"



}

/**
 * 拼接网址
 * @receiver String
 * @param map Map<String,Any>
 * @return String
 */

fun String.splicingUrl(map: Map<String,Any>): String{
    val stringBuffer = StringBuffer(URL_BASEURL)
    stringBuffer.append("$this?")
    map.forEach {
        stringBuffer.append(it.key + "=" + it.value + "&")
    }
    return stringBuffer.deleteCharAt(stringBuffer.lastIndex).toString()
}

fun String.splicingUrl(vararg params: Pair<String, Any>): String{
    val stringBuffer = StringBuffer(URL_BASEURL)
    stringBuffer.append("$this?")
    params.forEach {
        stringBuffer.append("${it.first}=${it.second}&")
    }
    return stringBuffer.deleteCharAt(stringBuffer.lastIndex).toString()
}


/**
 * 简单判空提示
 * @receiver String?
 * @param type String
 * @return Any?
 */
fun String?.hint(type: String): Any?{
    return if (this.isNullOrEmpty()){
        ToastUtils.toast(type)
        null
    }else{
        ""
    }
}

fun String?.hint2(type: String): Boolean{
    if (this.isNullOrEmpty()){
        ToastUtils.toast(type)
        return false
    }
    return true
}



