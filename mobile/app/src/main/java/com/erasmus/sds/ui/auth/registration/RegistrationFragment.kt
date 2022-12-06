package com.erasmus.sds.ui.auth.registration

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentRegistrationBinding
import com.erasmus.sds.ui.views.IconEditText
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val binding by viewBinding(FragmentRegistrationBinding::bind)
    private val viewModel: RegistrationViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {
        emailEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError(emailEditText, emailErrorView)
            }
        })
        firstNameEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError(firstNameEditText, firstNameErrorView)
            }
        })
        lastNameEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError(lastNameEditText, lastNameErrorView)
            }
        })
        passwordEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError(passwordEditText, passwordErrorView)
            }
        })
        repeatPasswordEditText.setListener(object : IconEditText.OnTextListener {
            override fun onTextChanged() {
                removeError(repeatPasswordEditText, repeatPasswordErrorView)
            }
        })
        binding.registerButton.onClickDebounced {
            // TODO viewModel.register()
            findNavController().navigate(RegistrationFragmentDirections.navigateToLogin())
        }
    }

    private fun removeError(view: IconEditText, errorView: LinearLayout) {
        view.removeError()
        errorView.isVisible = false
    }
}