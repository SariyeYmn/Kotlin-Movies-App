package com.example.movies_app.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movies_app.Adapter.FavoriteAdapter
import com.example.movies_app.Domain.Film
import com.example.movies_app.R
import com.example.movies_app.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private val favoriteFilms = mutableListOf<Film>()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val favoriteAdapter = FavoriteAdapter(this, favoriteFilms)

        binding.apply {
            recyclerViewFavorite.adapter = favoriteAdapter
            recyclerViewFavorite.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
            image1.setOnClickListener {
                val intent = Intent(this@FavoriteActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        loadFavoriteFilms()
    }

    private fun loadFavoriteFilms() {
        val sharedPreferences = getSharedPreferences("Favorites", Context.MODE_PRIVATE)
        val allPrefs = sharedPreferences.all

        for ((key, value) in allPrefs) {
            if (key.endsWith("_favorite") && value as Boolean) {
                val filmName = key.replace("_favorite", "")
                val filmImageResId = getFilmImageResId(filmName).toString()
                favoriteFilms.add(Film(1,filmName, filmImageResId,"","","", "", "", emptyList()))
            }
        }
    }

    private fun getFilmImageResId(filmName: String): Int {
        return when (filmName) {
            "Avatar" -> R.drawable.avatar
            "Supernatural" -> R.drawable.supernatural
            "Seven" -> R.drawable.seven
            "Sihirbazlar Çetesi" -> R.drawable.eye

            else -> R.drawable.dean// Varsayılan bir resim
        }
    }

}
