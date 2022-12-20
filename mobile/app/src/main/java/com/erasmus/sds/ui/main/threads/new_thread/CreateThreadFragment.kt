package com.erasmus.sds.ui.main.threads.new_thread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentCreateThreadBinding
import com.erasmus.sds.models.ThreadBody
import com.erasmus.sds.ui.main.threads.ThreadsViewModel
import com.erasmus.sds.utils.PreferenceHelper
import com.erasmus.sds.utils.PreferenceHelper.get
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class CreateThreadFragment : BottomSheetDialogFragment() {

    private val binding by viewBinding(FragmentCreateThreadBinding::bind)
    private val viewModel by activityViewModel<ThreadsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dialog?.setOnShowListener { dialog ->
            val layout: FrameLayout? =
                (dialog as BottomSheetDialog).findViewById(com.google.android.material.R.id.design_bottom_sheet)
            layout?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.skipCollapsed = true
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return inflater.inflate(R.layout.fragment_create_thread, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    private fun initViews() = binding.apply {
        cancelButton.onClickDebounced { dismiss() }
        postButton.onClickDebounced {
            val threadBody =
                ThreadBody(
                    titleEditText.text.toString(),
                    contentEditText.text.toString(),
                    PreferenceHelper.defaultPrefs(requireContext())["id"]
                )
            viewModel.postThread(threadBody)
        }
    }

    private fun observeViewModel() {
        viewModel.addThread.observe(viewLifecycleOwner) {
            viewModel.getThreads()
            dismiss()
        }
        viewModel.addThreadError.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "Posting thread failed", Toast.LENGTH_SHORT).show()
        }
    }
}