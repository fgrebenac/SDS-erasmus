package com.erasmus.sds.ui.auth.registration

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentRegistrationBinding
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val binding by viewBinding(FragmentRegistrationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.registerButton.onClickDebounced {
            findNavController().navigate(RegistrationFragmentDirections.navigateToLogin())
        }
    }
}