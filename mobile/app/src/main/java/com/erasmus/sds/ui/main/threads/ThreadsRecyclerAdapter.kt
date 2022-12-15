package com.erasmus.sds.ui.main.threads

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.erasmus.sds.databinding.ViewHolderThreadBinding
import com.erasmus.sds.models.AppThread
import com.erasmus.sds.utils.onClickDebounced

class ThreadsRecyclerAdapter(
    private val threads: List<AppThread>,
    private val onThreadClicked: (AppThread) -> Unit
) :
    RecyclerView.Adapter<ThreadsRecyclerAdapter.ThreadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ThreadViewHolder(
            ViewHolderThreadBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ThreadViewHolder, position: Int) {
        holder.bind(threads[position])
    }

    override fun getItemCount() = threads.size

    inner class ThreadViewHolder(private val binding: ViewHolderThreadBinding) :
        ViewHolder(binding.root) {
        fun bind(thread: AppThread) = binding.apply {
            title.text = thread.title
            content.text = thread.content
            root.onClickDebounced { onThreadClicked.invoke(thread) }
        }
    }
}