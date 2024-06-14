package com.czp.mywanandroid.util

import android.util.Log

class LazyLog {

    companion object {
        // 标识符常量，开发过程中可能存在过多的Log信息，统一在这里使用标识符管理
        // 全局DEBUG标识符
        const val DEBUG = false
        //------------------------------------------------
        //----------------------TAG-----------------------
        const val TAG = "MVVM"

        fun e(msg:String) {
            Log.e(TAG, msg)
        }
    }

}