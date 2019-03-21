package com.kiwilss.mvpktx

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.blankj.utilcode.util.LogUtils
import com.coder.zzq.smartshow.toast.SmartToast
import com.kiwilss.mvpktx.im.home.IMHomeActivity
import com.lxj.androidktx.core.click
import com.lxj.androidktx.core.mmkv
import com.lxj.androidktx.core.startActivity
import com.mob.MobSDK
import com.mob.pushsdk.MobPush
import com.mob.ums.OperationCallback
import com.mob.ums.User
import com.mob.ums.gui.UMSGUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MobPush.setAlias("test1")//设置别名
        //MobPush.addTags(String[] tags);//设置标签

        nextListener()


        tv_main_hello.click {
            //startActivity<TestLoginActivity>()
           //SmartToast.info("Welcome To IM")
            //UMSGUI.showRecommendationPage()
            //MobSDK.setUser("用户ID", "用户昵称","用户头像地址", null);
        }


    }

    private fun nextListener() {
        window.decorView.postDelayed({
            //登录过直接进入
            val isLogin = mmkv().getBoolean("isLogin", false)
            if (isLogin){
                startActivity<IMHomeActivity>()
                finish()
            }else{
                goToLogin()
            }
        },2500)
    }

    private fun goToLogin() {
        UMSGUI.showLogin(object : OperationCallback<User>(){
            override fun onSuccess(p0: User?) {
                super.onSuccess(p0)
                LogUtils.e(p0)
                val list = arrayListOf<User>(p0!!)
                val data = JSON.toJSONString(list)
                mmkv().putString("user",data)
                mmkv().putBoolean("isLogin",true)

                MobSDK.setUser(p0!!.id.toString(), p0.nickname.toString(),p0.address.toString(), null)
                //登录成功,进入首页
                startActivity<IMHomeActivity>(bundle = arrayOf("data" to data))
                finish()
                //UMSGUI.showProfilePage()
            }

            override fun onFailed(p0: Throwable?) {
                super.onFailed(p0)
                SmartToast.fail("登录失败, 请重试")
            }
        })
    }
}
