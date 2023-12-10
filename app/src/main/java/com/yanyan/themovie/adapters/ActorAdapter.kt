package com.yanyan.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewHolderActorBinding
import com.yanyan.themovie.delegates.ActorViewHolderDelegate
import com.yanyan.themovie.viewholders.ActorViewHolder

class ActorAdapter(private val mDelegate: ActorViewHolderDelegate) :
    RecyclerView.Adapter<ActorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {

        val binding =
            ViewHolderActorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorViewHolder(binding, mDelegate)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
    }
}