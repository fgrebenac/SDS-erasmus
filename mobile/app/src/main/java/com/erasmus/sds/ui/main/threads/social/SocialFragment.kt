package com.erasmus.sds.ui.main.threads.social

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentThreadsBinding
import com.erasmus.sds.ui.main.threads.ThreadsRecyclerAdapter
import com.erasmus.sds.ui.main.threads.ThreadsViewModel
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class SocialFragment : Fragment(R.layout.fragment_threads) {

    private val binding by viewBinding(FragmentThreadsBinding::bind)
    private val viewModel by activityViewModel<ThreadsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
        viewModel.getThreads()
    }

    private fun initViews() = binding.apply {
        addThreadButton.onClickDebounced { findNavController().navigate(SocialFragmentDirections.openCreateThread()) }
    }

    private fun observeViewModel() {
        viewModel.threads.observe(viewLifecycleOwner) {
            val adapter = ThreadsRecyclerAdapter(it) {
                // TODO open thread
            }
            binding.recyclerView.adapter = adapter
        }
        viewModel.threadsError.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Getting threads failed", Toast.LENGTH_SHORT).show()
        }
    }
}