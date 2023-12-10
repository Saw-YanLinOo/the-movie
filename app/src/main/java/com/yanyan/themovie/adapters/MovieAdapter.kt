package com.yanyan.themovie.adapters

import com.yanyan.themovie.viewholders.MovieViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewHolderMovieBinding
import com.yanyan.themovie.delegates.MovieViewHolderDelegate

class MovieAdapter(private val mDelegate:MovieViewHolderDelegate):RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val binding = ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MovieViewHolder(binding,mDelegate)
    }

    override fun getItemCount(): Int = 8

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

    }
}