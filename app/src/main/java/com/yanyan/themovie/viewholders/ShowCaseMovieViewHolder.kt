package com.yanyan.themovie.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewHolderShowcaseMovieBinding
import com.yanyan.themovie.delegates.ShowCaseMovieViewHolderDelegate

class ShowCaseMovieViewHolder(private val binding:ViewHolderShowcaseMovieBinding, private val mDelegate:ShowCaseMovieViewHolderDelegate):RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener{
            mDelegate.onTapShowCaseMovie()
        }
    }
}