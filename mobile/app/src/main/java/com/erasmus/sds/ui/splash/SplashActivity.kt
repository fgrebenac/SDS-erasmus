package com.erasmus.sds.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.erasmus.sds.R
import com.erasmus.sds.databinding.ActivitySplashBinding
import com.erasmus.sds.ui.auth.AuthActivity
import com.erasmus.sds.utils.viewBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivitySplashBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        animateLogo()
    }

    private fun animateLogo() {
        binding.logo.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(1000L).withEndAction {
                startAuth()
            }.start()
        }
    }

    private fun observeViewModel() {

    }

    private fun startAuth() {
        val intent = Intent(applicationContext, AuthActivity::class.java)
        startActivity(intent)
        overridePendingTransition(
            R.anim.enter_from_right_anim,
            R.anim.exit_to_left_anim
        )
        finish()
    }

}