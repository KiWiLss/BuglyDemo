package com.kiwilss.mvpktx.model

data class BaseBean<T>(val code: String?, val failures: Any?,
                       val message: String?, val status: Int, val result: T?)