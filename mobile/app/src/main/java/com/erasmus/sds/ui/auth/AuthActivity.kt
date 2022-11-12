package com.erasmus.sds.ui.auth

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import com.erasmus.sds.databinding.ActivityAuthBinding
import com.erasmus.sds.utils.viewBinding

class AuthActivity : FragmentActivity() {

    private val binding by viewBinding(ActivityAuthBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        })
    }
}