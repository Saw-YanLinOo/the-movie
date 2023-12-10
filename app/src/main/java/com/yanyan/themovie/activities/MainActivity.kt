package com.yanyan.themovie.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.yanyan.themovie.R
import com.yanyan.themovie.adapters.BannerAdapter
import com.yanyan.themovie.adapters.MovieAdapter
import com.yanyan.themovie.databinding.ActivityMainBinding
import com.yanyan.themovie.delegates.BannerViewHolderDelegate
import com.yanyan.themovie.delegates.MovieViewHolderDelegate
import com.yanyan.themovie.viewpods.MovieListViewPod

class MainActivity : AppCompatActivity(),BannerViewHolderDelegate, MovieViewHolderDelegate {

    private lateinit var _binding : ActivityMainBinding

    private lateinit var mBannerAdapter: BannerAdapter
    private lateinit var mBestPopularMovieListViewPod: MovieListViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setUpToolBar()
        setUpBannerViewPager()
        setUpViewPodInstance()
    }

    private fun setUpViewPodInstance(){
        mBestPopularMovieListViewPod = _binding.vpBestPopularMovieList.root
        mBestPopularMovieListViewPod.setUpMovieListViewPod(this,_binding.vpBestPopularMovieList)
    }


    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        _binding.viewPagerBanner.adapter  = mBannerAdapter
        _binding.dotIndicatorBanner.attachTo(_binding.viewPagerBanner)
    }

    private fun setUpToolBar() {
        setSupportActionBar(_binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_discover,menu)
        return true
    }

    override fun onTapMovieBanner() {
        Snackbar.make(window.decorView,"Tapped Movie Banner",Snackbar.LENGTH_LONG).show()
    }

    override fun onTapMovieItem() {
        Snackbar.make(window.decorView,"Tapped Movie Item",Snackbar.LENGTH_LONG).show()

    }
}