package com.yanyan.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewHolderShowcaseMovieBinding
import com.yanyan.themovie.delegates.ShowCaseMovieViewHolderDelegate
import com.yanyan.themovie.viewholders.ShowCaseMovieViewHolder

class ShowCaseMovieAdapter(private val mDelegate: ShowCaseMovieViewHolderDelegate) :
    RecyclerView.Adapter<ShowCaseMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseMovieViewHolder {
        val binding = ViewHolderShowcaseMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShowCaseMovieViewHolder(binding, mDelegate)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: ShowCaseMovieViewHolder, position: Int) {
        
    }
}