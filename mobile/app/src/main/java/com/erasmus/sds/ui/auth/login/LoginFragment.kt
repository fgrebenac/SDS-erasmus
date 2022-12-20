package com.erasmus.sds.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentLoginBinding
import com.erasmus.sds.models.AppUser
import com.erasmus.sds.ui.main.MainActivity
import com.erasmus.sds.ui.views.IconEditText
import com.erasmus.sds.utils.PreferenceHelper
import com.erasmus.sds.utils.PreferenceHelper.set
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(viewLifecycleOwner) {
            saveUserData(it)
            startMainActivity()
        }
        viewModel.loginError.observe(viewLifecycleOwner) {
            setEmailError()
        }
    }

    private fun initViews() = binding.apply {
        emailEditText.setListener(object : IconEditText.OnTextListener {
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
            viewModel.loginUser(binding.emailEditText.getText(), binding.passwordEditText.getText())
            startMainActivity()
        }
        goToRegistrationButton.onClickDebounced {
            findNavController().popBackStack()
        }
    }

    private fun setEmailError() {
        binding.emailEditText.setError()
        binding.errorDescription.text = getString(R.string.login_error)
        binding.usernameErrorView.visibility = View.VISIBLE
    }

    private fun removeError() {
        binding.emailEditText.removeError()
        binding.usernameErrorView.visibility = View.GONE
    }

    private fun startMainActivity() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        requireActivity().startActivity(intent)
        requireActivity().overridePendingTransition(
            R.anim.enter_from_right_anim,
            R.anim.exit_to_left_anim
        )
        requireActivity().finish()
    }

    private fun saveUserData(appUser: AppUser) {
        PreferenceHelper.defaultPrefs(requireContext())["firstName"] = appUser.firstName
        PreferenceHelper.defaultPrefs(requireContext())["lastName"] = appUser.lastName
        PreferenceHelper.defaultPrefs(requireContext())["email"] = appUser.email
        PreferenceHelper.defaultPrefs(requireContext())["id"] = appUser.id
    }
}
