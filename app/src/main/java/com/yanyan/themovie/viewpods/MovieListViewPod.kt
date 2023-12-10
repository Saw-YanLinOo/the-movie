package com.yanyan.themovie.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanyan.themovie.adapters.MovieAdapter
import com.yanyan.themovie.databinding.ViewPodMovieListBinding
import com.yanyan.themovie.delegates.MovieViewHolderDelegate

class MovieListViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?=null
):FrameLayout(context,attrs) {

    private  lateinit var mMovieAdapter: MovieAdapter
    private lateinit var mDelegate: MovieViewHolderDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setUpMovieListViewPod(delegate: MovieViewHolderDelegate,binding:ViewPodMovieListBinding){
        setUpDelegate(delegate)
        setUpMovieListRecyclerView(binding)
    }

    private  fun setUpDelegate(delegate:MovieViewHolderDelegate){
        mDelegate=delegate
    }
    private fun setUpMovieListRecyclerView(binding:ViewPodMovieListBinding){
        mMovieAdapter = MovieAdapter(mDelegate)
        binding.rvMovieList.adapter = mMovieAdapter
        binding.rvMovieList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }

}

