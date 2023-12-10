package com.yanyan.themovie.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewItemBannerBinding
import com.yanyan.themovie.delegates.BannerViewHolderDelegate

class BannerViewHolder(private val binding: ViewItemBannerBinding, private val mDelegate: BannerViewHolderDelegate):RecyclerView.ViewHolder(binding.root) {

   init {
       binding.root.setOnClickListener{
           mDelegate.onTapMovieBanner()
       }
   }
}