package com.yanyan.themovie.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewHolderActorBinding
import com.yanyan.themovie.delegates.ActorViewHolderDelegate

class ActorViewHolder(
    private val binding: ViewHolderActorBinding,
    private val mDelegate: ActorViewHolderDelegate
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            mDelegate.onTapActor()
        }
    }
}