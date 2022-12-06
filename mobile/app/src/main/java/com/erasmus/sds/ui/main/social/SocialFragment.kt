package com.erasmus.sds.ui.main.social

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentThreadsBinding
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding

class SocialFragment : Fragment(R.layout.fragment_threads) {

    private val binding by viewBinding(FragmentThreadsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = binding.apply {
        addThreadButton.onClickDebounced { findNavController().navigate(SocialFragmentDirections.openCreateThread()) }
    }

}