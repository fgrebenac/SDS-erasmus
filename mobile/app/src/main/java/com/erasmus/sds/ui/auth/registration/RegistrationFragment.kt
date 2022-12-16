package com.erasmus.sds.ui.auth.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentRegistrationBinding
import com.erasmus.sds.models.AppUser
import com.erasmus.sds.ui.main.MainActivity
import com.erasmus.sds.ui.views.IconEditText
import com.erasmus.sds.utils.PreferenceHelper
import com.erasmus.sds.utils.PreferenceHelper.set
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val binding by viewBinding(FragmentRegistrationBinding::bind)
    private val viewModel: RegistrationViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.registerResult.observe(viewLifecycleOwner) {
            saveUserData(it)
            startMainActivity()
        }
        viewModel.registerError.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                "Registration failed. Please try again.",
                Toast.LENGTH_SHORT
            ).show()
        }
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
        binding.registerButton.onClickDebounced {
            viewModel.registerUser(
                firstNameEditText.getText(),
                lastNameEditText.getText(),
                emailEditText.getText(),
                passwordEditText.getText()
            )
        }
        binding.goToLoginButton.onClickDebounced {
            findNavController().navigate(RegistrationFragmentDirections.navigateToLogin())
        }
    }

    private fun removeError(view: IconEditText, errorView: LinearLayout) {
        view.removeError()
        errorView.isVisible = false
    }

    private fun saveUserData(appUser: AppUser) {
        PreferenceHelper.defaultPrefs(requireContext())["firstName"] = appUser.firstName
        PreferenceHelper.defaultPrefs(requireContext())["lastName"] = appUser.lastName
        PreferenceHelper.defaultPrefs(requireContext())["email"] = appUser.email
        PreferenceHelper.defaultPrefs(requireContext())["id"] = appUser.id
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
}