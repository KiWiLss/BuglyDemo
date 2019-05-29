/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BaseFragment
 * Author:   kiwilss
 * Date:     2019/3/13 13:41
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.mvpktx.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kingja.loadsir.core.LoadSir

/**
 *@FileName: BaseFragment
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/13
 * @desc   : {DESCRIPTION}
 */
abstract class BaseFragment<T: BasePresenter>: Fragment(){

     val mPresenter: T? by lazy {
        initPresenter()
    }

    /**
     * 视图是否加载完毕
     */
    var isViewPrepare = false

    abstract fun initPresenter(): T?

    var mRootView: View? = null

    val mLoadSir by lazy {
        LoadSir.getDefault().register(mRootView){ view ->
            //onReload
            initDataAgain()
        }
    }

    open fun initDataAgain() {//首次加载失败，再次加载数据时
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (mRootView == null){
            mRootView = inflater.inflate(getLayoutId(),container,false)
        }

        mPresenter?.attech(context)

        return mRootView
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initInterface(view,savedInstanceState)
        initData()

    }

    override fun onDestroyView() {
        mPresenter?.detach()
        super.onDestroyView()
    }


    abstract fun initData()

    abstract fun initInterface(view: View, savedInstanceState: Bundle?)
}