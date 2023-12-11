package com.yanyan.themovie.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.yanyan.themovie.R
import com.yanyan.themovie.adapters.BannerAdapter
import com.yanyan.themovie.adapters.ShowCaseMovieAdapter
import com.yanyan.themovie.databinding.ActivityMainBinding
import com.yanyan.themovie.delegates.ActorViewHolderDelegate
import com.yanyan.themovie.delegates.BannerViewHolderDelegate
import com.yanyan.themovie.delegates.MovieViewHolderDelegate
import com.yanyan.themovie.delegates.ShowCaseMovieViewHolderDelegate
import com.yanyan.themovie.viewpods.ActorListViewPod
import com.yanyan.themovie.viewpods.MovieListViewPod

class MainActivity : AppCompatActivity(), BannerViewHolderDelegate, MovieViewHolderDelegate,
    ShowCaseMovieViewHolderDelegate, ActorViewHolderDelegate {

    private lateinit var _binding: ActivityMainBinding

    private lateinit var mBannerAdapter: BannerAdapter
    private lateinit var mBestPopularMovieListViewPod: MovieListViewPod
    private lateinit var mMovieListByGenerViewPod: MovieListViewPod

    private lateinit var mShowCaseMovieAdapter: ShowCaseMovieAdapter

    private lateinit var mActorListViewPod: ActorListViewPod


    private val genreList =
        listOf("ACTION", "ADVENTURE", "CRIMINAL", "DRAMA", "COMEDY", "ROMANCE", "ANIMATION")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setUpToolBar()
        setUpBannerViewPager()
        setUpViewPodInstance()
        setUpGenreTabLayout()
        setUpShowCaseAdapter()

        setUpListener()
    }

    fun setUpShowCaseAdapter() {
        mShowCaseMovieAdapter = ShowCaseMovieAdapter(this)
        _binding.rvShowCaseMovie.adapter = mShowCaseMovieAdapter
    }

    private fun setUpListener() {
        _binding.tlGenre.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Snackbar.make(
                    window.decorView,
                    "Tab Gener ${tab?.text ?: ""}",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setUpGenreTabLayout() {
        genreList.forEach { genre ->
            _binding.tlGenre.newTab().apply {
                text = genre
                _binding.tlGenre.addTab(this)
            }
        }
    }

    private fun setUpViewPodInstance() {
        mBestPopularMovieListViewPod = _binding.vpBestPopularMovieList.root
        mBestPopularMovieListViewPod.setUpMovieListViewPod(this, _binding.vpBestPopularMovieList)

        mMovieListByGenerViewPod = _binding.vpMovieByGenre.root
        mMovieListByGenerViewPod.setUpMovieListViewPod(this, _binding.vpMovieByGenre)

        mActorListViewPod = _binding.vpBestActorList.root
        mActorListViewPod.setUpActorListViewPod(
            backgroundColor = R.color.colorPrimaryDark,
            title = "BEST ACTORS",
            moreTitle = "MORE ACTORS",
            binding = _binding.vpBestActorList,
            this
        )
    }


    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        _binding.viewPagerBanner.adapter = mBannerAdapter
        _binding.dotIndicatorBanner.attachTo(_binding.viewPagerBanner)
    }

    private fun setUpToolBar() {
        setSupportActionBar(_binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_discover, menu)
        return true
    }

    override fun onTapMovieBanner() {
        Snackbar.make(window.decorView, "Tapped Movie Banner", Snackbar.LENGTH_LONG).show()
        startActivity(MovieDetailActivity.newIntent(this))
    }

    override fun onTapMovieItem() {
        Snackbar.make(window.decorView, "Tapped Movie Item", Snackbar.LENGTH_LONG).show()

    }

    override fun onTapShowCaseMovie() {
        Snackbar.make(window.decorView, "Tapped ShowCase Movie Item", Snackbar.LENGTH_LONG).show()

    }

    override fun onTapActor() {
        Snackbar.make(window.decorView, "Tapped Actor", Snackbar.LENGTH_LONG).show()

    }
}