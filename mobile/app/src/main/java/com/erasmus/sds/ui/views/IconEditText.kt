package com.erasmus.sds.ui.views

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import coil.load
import com.erasmus.sds.R
import com.erasmus.sds.databinding.ViewIconEditTextBinding
import com.erasmus.sds.utils.onClickDebounced

class IconEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    interface OnTextListener {
        fun onTextChanged()
    }

    private var binding: ViewIconEditTextBinding
    private var passwordVisible = false
    private var listener: OnTextListener? = null

    init {
        binding = ViewIconEditTextBinding.inflate(LayoutInflater.from(context), this, true)
        context.theme.obtainStyledAttributes(attrs, R.styleable.IconEditText, 0, 0).apply {
            try {
                binding.icon.load(getDrawable(R.styleable.IconEditText_editTextIcon))
                binding.editText.hint = getString(R.styleable.IconEditText_hint)
                binding.editText.doOnTextChanged { _, _, _, _ ->
                    listener?.onTextChanged()
                }
                binding.visibilityToggle.apply {
                    if (getBoolean(R.styleable.IconEditText_isPassword, false)) {
                        visibility = View.VISIBLE
                        load(R.drawable.ic_invisible)
                        binding.editText.transformationMethod =
                            PasswordTransformationMethod.getInstance()
                        onClickDebounced {
                            passwordVisible = !passwordVisible
                            if (passwordVisible) {
                                binding.editText.transformationMethod =
                                    HideReturnsTransformationMethod.getInstance()
                                load(R.drawable.ic_visible) {
                                    crossfade(500)
                                }
                            } else {
                                binding.editText.transformationMethod =
                                    PasswordTransformationMethod.getInstance()
                                load(R.drawable.ic_invisible) {
                                    crossfade(500)
                                }
                            }

                        }
                    } else {
                        visibility = View.GONE
                    }
                }
            } finally {
                recycle()
            }
        }
    }

    fun setListener(listener: OnTextListener) {
        this.listener = listener
    }

    fun setError() {
        binding.root.setBackgroundResource(R.drawable.background_round_edit_text_error)
    }

    fun removeError() {
        binding.root.setBackgroundResource(R.drawable.background_round_edit_text)
    }

    fun getText(): String {
        return binding.editText.text.toString()
    }

}