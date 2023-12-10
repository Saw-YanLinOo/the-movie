package com.yanyan.themovie.viewpods

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanyan.themovie.adapters.ActorAdapter
import com.yanyan.themovie.databinding.ViewHolderActorBinding
import com.yanyan.themovie.databinding.ViewPodActorListBinding
import com.yanyan.themovie.delegates.ActorViewHolderDelegate

class ActorListViewPod @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    RelativeLayout(context, attrs) {

    private lateinit var mActorAdaptor: ActorAdapter
    private lateinit var mDelegate: ActorViewHolderDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setUpActorListViewPod(
        backgroundColor: Int,
        title: String,
        moreTitle: String,
        binding: ViewPodActorListBinding,
        delegate: ActorViewHolderDelegate
    ) {
        setUpDelegate(delegate)
        setUpRecyclerView(binding)
        setBackgroundColor(ContextCompat.getColor(context, backgroundColor))
        binding.tvBestActors.text = title
        binding.tvMoreActors.text = moreTitle
        binding.tvMoreActors.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    }

    private fun setUpDelegate(delegate: ActorViewHolderDelegate) {
        mDelegate = delegate
    }

    private fun setUpRecyclerView(binding: ViewPodActorListBinding) {
        mActorAdaptor = ActorAdapter(mDelegate)
        binding.rvActor.adapter = mActorAdaptor
        binding.rvActor.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}