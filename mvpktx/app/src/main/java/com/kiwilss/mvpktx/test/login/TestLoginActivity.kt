/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestLoginActivity
 * Author:   kiwilss
 * Date:     2019/3/12 15:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.test.login

import android.Manifest
import android.arch.lifecycle.Observer
import android.os.Bundle
import com.kiwilss.mvpktx.R
import com.kiwilss.mvpktx.base.BaseActivity
import com.kiwilss.mvpktx.utils.StringUtils
import com.kiwilss.mvpktx.utils.hint2
import com.lxj.androidktx.bus.LiveDataBus
import com.lxj.androidktx.core.click
import com.lxj.androidktx.core.isPhone
import com.lxj.androidktx.core.toast
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_test_login.*

/**
 *@FileName: TestLoginActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/12
 * @desc   : {DESCRIPTION}
 */
class TestLoginActivity: BaseActivity<TestPresenter>() {
    override fun initPresenter(): TestPresenter? =
        TestPresenter()

    override fun initData() {
//        showLoadingDiloag()
//        window.decorView.postDelayed({dismissLoadingDiloag()},2500)




    }

    override fun initInterface(savedInstanceState: Bundle?) {
        //登录点击
        loginClick()
        //接收消息
        initReceiver()
        //注册点击
        registerClick()
    }

    private fun registerClick() {
        stv_login_register.click {
            showLoadingDiloag("注册")
        }
    }

    private fun initReceiver() {
        //接收登录成功的结果
        LiveDataBus.with<LoginIn>("login").observe(this,observer = Observer {
            dismissLoadingDiloag()
            //mLoadSir.showSuccess()
            toast("登录成功")
        })

    }

    private fun loginClick() {
        stv_login_login.click {
            //申请权限
            val rxPermissions = RxPermissions(this)
            rxPermissions.requestEach(Manifest.permission.READ_PHONE_STATE)
                .subscribe {
                    if (it.granted){
                        val phone = et_login_phone.text.toString()
                        val pwd = et_login_pwd.text.toString()
                        if (phone.hint2(StringUtils.HINT_PHONE)) {
                            if (phone.isPhone()) {
                                //验证密码
                                if (pwd.hint2(StringUtils.HINT_PASSWORD)) {
                                    showLoadingDiloag("加载中...")
                                    //mLoadSir.showCallback(LoadingCallback::class.java)
                                    mPresenter?.login(phone,pwd)
                                }
                            }else{
                                toast(StringUtils.HINT_PHONE_RIGHT)
                            }
                        }
                    }else{
                        toast("请授予权限")
                    }
                }
        }

    }

    override fun getLayoutId(): Int = R.layout.activity_test_login
}