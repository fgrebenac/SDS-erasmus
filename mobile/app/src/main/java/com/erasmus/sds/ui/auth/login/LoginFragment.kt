package com.erasmus.sds.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentLoginBinding
import com.erasmus.sds.ui.views.IconEditText
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {
        usernameEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError()
            }
        })
        passwordEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError()
            }
        })
        loginButton.onClickDebounced {
            // TODO viewModel.signIn
        }
    }

    private fun setUsernameError() {
        binding.usernameEditText.setError()
        binding.errorDescription.text = getString(R.string.login_error)
        binding.usernameErrorView.visibility = View.VISIBLE
    }

    private fun removeError() {
        binding.usernameEditText.removeError()
        binding.usernameErrorView.visibility = View.GONE
    }
}
