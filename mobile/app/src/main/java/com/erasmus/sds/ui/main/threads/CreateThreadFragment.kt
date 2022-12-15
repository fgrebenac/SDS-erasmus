package com.erasmus.sds.ui.main.threads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.erasmus.sds.R
import com.erasmus.sds.databinding.FragmentCreateThreadBinding
import com.erasmus.sds.utils.onClickDebounced
import com.erasmus.sds.utils.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateThreadFragment : BottomSheetDialogFragment() {

    private val binding by viewBinding(FragmentCreateThreadBinding::bind)

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
    }

    private fun initViews() = binding.apply {
        cancelButton.onClickDebounced { dismiss() }
    }
}