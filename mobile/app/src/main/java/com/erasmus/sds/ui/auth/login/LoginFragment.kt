package com.erasmus.sds.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentLoginBinding
import com.erasmus.sds.utils.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}