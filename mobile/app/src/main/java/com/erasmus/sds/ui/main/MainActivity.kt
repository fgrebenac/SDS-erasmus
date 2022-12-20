package com.erasmus.sds.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.ActivityMainBinding
import com.erasmus.sds.utils.PreferenceHelper
import com.erasmus.sds.utils.viewBinding

class MainActivity : FragmentActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNavigation.setupWithNavController(navHostFragment.navController)
        binding.userText.text =
            getString(
                R.string.hi_user_format,
                PreferenceHelper.defaultPrefs(this).getString("firstName", "")
            )
    }

}