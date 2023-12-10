package com.yanyan.themovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yanyan.themovie.databinding.ViewItemBannerBinding
import com.yanyan.themovie.delegates.BannerViewHolderDelegate
import com.yanyan.themovie.viewholders.BannerViewHolder

class BannerAdapter(private val mDelegate: BannerViewHolderDelegate):RecyclerView.Adapter<BannerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {

        val view = ViewItemBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BannerViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {

    }


}