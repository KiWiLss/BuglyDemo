/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestPresenter
 * Author:   kiwilss
 * Date:     2019/3/12 15:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.login

import android.annotation.SuppressLint
import com.kiwilss.mvpktx.base.BasePresenter
import com.kiwilss.mvpktx.config.URL_LOGIN
import com.kiwilss.mvpktx.model.BaseBean
import com.kiwilss.mvpktx.utils.ToastUtils
import com.kiwilss.mvpktx.utils.splicingUrl
import com.lxj.androidktx.okhttp.get
import com.lxj.androidktx.okhttp.http
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *@FileName: TestPresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/12
 * @desc   : {DESCRIPTION}
 */
class TestPresenter: BasePresenter(){

    @SuppressLint("MissingPermission")
    fun login(phone: String, pwd: String){
                    GlobalScope.launch {
                        //val  imei = PhoneUtils.getIMEI()
                        val result = URL_LOGIN.splicingUrl(
                            "deviceToken" to "99",
                            "phone" to phone,
                            "password" to pwd,
                            "deviceType" to "ANDROID")
                            .http().get<BaseBean<LoginIn>>().await()
                        ToastUtils.handlerResult(result,"login")
                    }

    }

}