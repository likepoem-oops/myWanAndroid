package com.czp.mywanandroid.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.constraintlayout.widget.ConstraintLayout
import com.czp.mywanandroid.R
import com.czp.mywanandroid.logic.dao.AppConfig
import com.drake.net.utils.scopeNetLife
import com.drake.serialize.intent.openActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val layoutSplash: ConstraintLayout by lazy { findViewById(R.id.layout_splash) }
    // 闪屏页面动画对象
    private val alphaAnimation: AlphaAnimation by lazy { AlphaAnimation(0.3F, 1.0F) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        alphaAnimation.run {
            duration = 1000
            setAnimationListener(object: Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                    if (AppConfig.UserName.isNotEmpty()) {
                        scopeNetLife {
                            // 做登录操作
                        }
                    }
                }

                override fun onAnimationEnd(p0: Animation?) {
                    jumpToMain()
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
        }
        layoutSplash.startAnimation(alphaAnimation)
    }

    private fun jumpToMain() {
        openActivity<MainActivity>()
        finish()
        // 转场动画
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}