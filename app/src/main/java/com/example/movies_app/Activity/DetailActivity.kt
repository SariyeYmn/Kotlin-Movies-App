package com.example.movies_app.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movies_app.R
import com.example.movies_app.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Intent'ten verileri alın
        val filmId = intent.getIntExtra("FILM_ID", -1)
        val filmTitle = intent.getStringExtra("FILM_TITLE")
        val filmScore = intent.getStringExtra("FILM_SCORE")
        val filmImgResId = intent.getIntExtra("FILM_IMG_RES_ID", -1)
        val filmSummery = intent.getStringExtra("FILM_SUMMERY")
        val filmActors = intent.getStringExtra("FILM_ACTORS")

        binding.apply {
            posterBigImg.setImageResource(filmImgResId)
            posterNormalImg.setImageResource(filmImgResId)
            movieNameTxt.text = filmTitle
            movieRateTxt.text = filmScore
            movieSummeryInfo.text = filmSummery
            movieInfoActor.text = filmActors
        }
    }
}