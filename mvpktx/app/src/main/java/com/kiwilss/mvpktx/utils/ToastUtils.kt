/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ToastUtils
 * Author:   kiwilss
 * Date:     2019/3/4 15:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.utils

import android.widget.Toast
import com.kiwilss.mvpktx.MyApp
import com.kiwilss.mvpktx.model.BaseBean
import com.lxj.androidktx.bus.LiveDataBus
import com.lxj.androidktx.util.NetworkUtils

/**
 *@FileName: ToastUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */
class ToastUtils {



    companion object {


        /**
         * 全局吐司
         * @param mes String?
         */
        fun toast(mes: String?) {
            if (!mes.isNullOrEmpty()) {
                Toast.makeText(MyApp.mContext, mes, Toast.LENGTH_SHORT).show()
            }
        }

        /**
         * 统一处理返回结果
         * @param data BaseBean<T>?
         * @param key String
         */
        fun <T> handlerResult(data: BaseBean<T>?, key: String) {//异步线程
            //判断异常出现的原因
            if (data == null){
                //检测是否断网
                if (!NetworkUtils.isConnected()) {//断网
                    //toast("请检查网络是否正常")
                    LiveDataBus.with<String>("error").postValue("请检查网络是否正常")
                }else{
                    //toast("未知错误, 请稍后再试")
                    LiveDataBus.with<String>("error").postValue("未知错误, 请稍后再试")
                }
            }else{
                val result = data.result
                val message = data.message
                if (result == null) {
                    if (message != null) {
                        LiveDataBus.with<String>("error").postValue(message)
                    }
                } else {
                    LiveDataBus.with<T>(key).postValue(result)
                    //LiveDataBus.with<T>(key).setValue(result)
                }
            }

        }






    }




}




