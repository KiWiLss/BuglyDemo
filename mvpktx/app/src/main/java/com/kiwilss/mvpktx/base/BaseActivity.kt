/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BaseActivity
 * Author:   kiwilss
 * Date:     2019/3/12 14:46
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.base

import android.arch.lifecycle.Observer
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.AdaptScreenUtils
import com.coder.zzq.smartshow.dialog.SmartDialog
import com.coder.zzq.smartshow.dialog.creator.type.impl.DialogCreatorFactory
import com.gyf.barlibrary.ImmersionBar
import com.kingja.loadsir.core.LoadSir
import com.kiwilss.kotlinmvp.manager.ActivityCollector
import com.kiwilss.mvpktx.R
import com.lxj.androidktx.bus.LiveDataBus
import com.lxj.androidktx.core.toast
import kotlinx.android.synthetic.main.currency_top.*

/**
 *@FileName: BaseActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/12
 * @desc   : {DESCRIPTION}
 */
abstract class BaseActivity<T: BasePresenter>: AppCompatActivity(){

     val mPresenter: T? by lazy {
        initPresenter()
    }

    abstract fun initPresenter(): T?

     val mLoadSir by lazy {
        LoadSir.getDefault().register(this){ view ->
            //onReload
            initDataAgain()
        }
    }

     open fun initDataAgain() {//首次加载失败，再次加载数据时
         }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局前操作
        doBeforeSetContentView()
        //设置布局
        setContentView(getLayoutId())
        //设置状态栏
        setStatusBar()
        //当前活动加入活动管理器
        ActivityCollector.instance().addActivity(this)
        //关联presenter
        mPresenter?.attech(this)
        //初始化主界面
        initInterface(savedInstanceState)
        //初始化数据
        initData()
        //初始化标题
        initToolbarTitle()
        //设置返回监听
        setBackListener()
        //处理各种网络请求失败的结果
        handlerError()
    }

    open fun handlerError() {
        LiveDataBus.with<String>("error").observe(this,observer = Observer {
            it?.run {
                toast(it)
                dismissLoadingDiloag()
                //PostUtil.postCallbackDelayed(mLoadSir, ErrorCallback::class.java)
            }
        })
    }

    open fun setBackListener() {
        //设置返回点击
        iv_currency_top_back?.let { it ->
            it.setOnClickListener { onBackPressed() }
        }
    }

    open fun initToolbarTitle() {
        //设置标题
        tv_currency_top_title?.let {
            it.text = title
        }
    }

    override fun getResources(): Resources {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 375)
    }

//    private val mLoadingDialog by lazy {
//        SmartDialog.newInstance(
//            DialogCreatorFactory.loading().middle().message(mLoadingMessage))
//    }

     private var mLoadingDialog: SmartDialog? = null

    var mLoadingMessage = "加载中..."

    fun showLoadingDiloag(){
      showLoadingDiloag(mLoadingMessage)
    }

    fun showLoadingDiloag(message: String){
        mLoadingDialog = SmartDialog.newInstance(DialogCreatorFactory.loading().middle().message(message))
        mLoadingDialog?.show(this)
    }

    fun dismissLoadingDiloag(){
        mLoadingDialog?.run {
            if (this.isShowing){
                this.dismiss(this@BaseActivity)
            }
        }
    }

    override fun onDestroy() {
        mLoadingDialog?.run {
            if (this.isShowing){
                this.dismiss(this@BaseActivity)
            }
        }
        mPresenter?.detach()
        ImmersionBar.with(this).destroy()
        ActivityCollector.instance().removeActivity2(this)
        super.onDestroy()
    }

    abstract fun initData()

    abstract fun initInterface(savedInstanceState: Bundle?)

    open fun setStatusBar() {
        //设置默认样式
        ImmersionBar.with(this)
            //.transparentBar()
            .statusBarColor(R.color.white)
            .fitsSystemWindows(true)
            .statusBarDarkFont(true, 0f)
            //.navigationBarAlpha(1)
            .init()
    }

    abstract fun getLayoutId(): Int

    open fun doBeforeSetContentView() {
    }
}