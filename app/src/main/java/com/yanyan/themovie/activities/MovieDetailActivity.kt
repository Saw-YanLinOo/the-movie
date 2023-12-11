package com.yanyan.themovie.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yanyan.themovie.databinding.ActivityMovieDetailBinding
import com.yanyan.themovie.viewpods.ActorListViewPod
import com.yanyan.themovie.R
import com.yanyan.themovie.delegates.ActorViewHolderDelegate

class MovieDetailActivity : AppCompatActivity(), ActorViewHolderDelegate {

    private lateinit var _binding: ActivityMovieDetailBinding

    private lateinit var _actorListViewPod: ActorListViewPod
    private lateinit var _creatorListViewPod: ActorListViewPod

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MovieDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        setUpViewPodInstance()

        setUpListener()
    }

    private fun setUpListener() {
        _binding.btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun setUpViewPodInstance() {
        _actorListViewPod = _binding.vpActorList.root
        _actorListViewPod.setUpActorListViewPod(
            backgroundColor = R.color.colorPrimary,
            title = "ACTORS",
            moreTitle = "",
            binding = _binding.vpActorList,
            delegate = this
        )

        _creatorListViewPod = _binding.vpCreatorList.root
        _creatorListViewPod.setUpActorListViewPod(
            backgroundColor = R.color.colorPrimary,
            title = "CREATORS",
            moreTitle = "MORE CREATORS",
            binding = _binding.vpCreatorList,
            delegate = this
        )
    }

    override fun onTapActor() {

    }
}