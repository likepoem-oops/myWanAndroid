package com.czp.mywanandroid.base

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.czp.mywanandroid.util.LazyLog
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 事件包装类，防止liveData数据倒灌。
 * @author czp
 */
open class SingleLiveEvent<T>: MutableLiveData<T?>(){

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T?>) {
        if (hasActiveObservers()) {

        }

        super.observe(owner) {t ->
            if (mPending.compareAndSet(true, false)){
                observer.onChanged(t)
            }
        }
    }
}