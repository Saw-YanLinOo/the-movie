package com.yanyan.themovie.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewHolderMovieBinding
import com.yanyan.themovie.delegates.MovieViewHolderDelegate

class MovieViewHolder(private val binding: ViewHolderMovieBinding, private val mDelegate: MovieViewHolderDelegate): RecyclerView.ViewHolder(binding.root){
    init {
        binding.root.setOnClickListener{
            mDelegate.onTapMovieItem()
        }
    }
}