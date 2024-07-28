package com.example.movies_app.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movies_app.Adapter.DetailAdapter
import com.example.movies_app.Domain.DetailDomain
import com.example.movies_app.R
import com.example.movies_app.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var sharedPreferences: SharedPreferences
    var isFavorite = false
    val score = "0000"

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
        val filmTime = intent.getStringExtra("FILM_TIME")
        val filmCalendar = intent.getStringExtra("FILM_CALENDAR")
        val filmImgResId = intent.getIntExtra("FILM_IMG_RES_ID", -1)
        val filmSummery = intent.getStringExtra("FILM_SUMMERY")
        val filmActors = intent.getStringExtra("FILM_ACTORS")
        val actorsImg: ArrayList<DetailDomain>? = intent.getParcelableArrayListExtra("FILM_ACTORSIMG")

        val actorsAdapter = DetailAdapter(this,actorsImg!!)

        sharedPreferences = getSharedPreferences("Favorites", MODE_PRIVATE)
        // Favori durumu kontrol etme
        isFavorite = sharedPreferences.getBoolean("${filmTitle}_favorite", false)
        //filmin favori olup olmadığını belirlemek için kullanılır. Eğer bu anahtar yoksa varsayılan olarak false döndürür
        updateFavoriteIcon()

        binding.apply {
            posterBigImg.setImageResource(filmImgResId)
            posterNormalImg.setImageResource(filmImgResId)
            movieNameTxt.text = filmTitle
            movieRateTxt.text = filmScore
            movieSummeryInfo.text = filmSummery
            movieInfoActor.text = filmActors
            movieTimeTxt.text = filmTime
            movieDateTxt.text = filmCalendar
            imageRecyclerView.adapter = actorsAdapter
            imageRecyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
            back.setOnClickListener {
                val intent = Intent(this@DetailActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            favorite.setOnClickListener {
                isFavorite = !isFavorite
                val editor = sharedPreferences.edit()
                editor.putBoolean("${filmTitle}_favorite", isFavorite)
                editor.apply()
                updateFavoriteIcon()
            }
        }
    }

    private fun updateFavoriteIcon() {
        if (isFavorite) {
            binding.favorite.setImageResource(R.drawable.favorite_red)
        } else {
            binding.favorite.setImageResource(R.drawable.favorite)
        }
    }

}