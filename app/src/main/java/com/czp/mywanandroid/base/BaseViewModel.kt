package com.czp.mywanandroid.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.trello.rxlifecycle3.LifecycleProvider
import java.lang.ref.WeakReference

class BaseViewModel(application: Application): AndroidViewModel(application), IBaseViewModel {

    private var mLifecycle: WeakReference<LifecycleProvider<*>>? = null


    companion object {
        class UIChangeLiveData: SingleLiveEvent<Any?>() {

        }

        object ParameterField {
            const val CLASS = "CLASS"
            const val CANONICAL_NAME = "CANONICAL_NAME"
            const val BUNDLE = "BUNDLE"
            const val REQUEST = "REQUEST"
            const val REQUEST_DEFAULT = 1
        }

    }
}