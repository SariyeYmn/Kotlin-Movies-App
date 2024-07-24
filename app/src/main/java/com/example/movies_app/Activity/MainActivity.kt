package com.example.movies_app.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.RequestQueue
import com.example.movies_app.Adapter.FilmAdapter
import com.example.movies_app.Domain.Film
import com.example.movies_app.R
import com.example.movies_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val filmList = ArrayList<Film>()

        val filmListUpcoming = ArrayList<Film>()

        val f1 = Film(1,"Avatar","avatar3","12000","teeessssssssssttttttt","denemeeeeeeeeeeeee")
        val f2 = Film(2,"Supernatural","supernatural3","2000","teeessssssssssttttttt","denemeeeeeeeeeeeee")
        val f3 = Film(3,"Seven","seven","1000","teeessssssssssttttttt","denemeeeeeeeeeeeee")
        val f4 = Film(4,"Sihirbazlar Çetesi","eye","1500","teeessssssssssttttttt","denemeeeeeeeeeeeee")

        val f5 = Film(5,"Avatar","avatar","12000","teeessssssssssttttttt","denemeeeeeeeeeeeee")
        val f6 = Film(6,"Supernatural","supernatural","2000","teeessssssssssttttttt","denemeeeeeeeeeeeee")
        val f7 = Film(7,"Seven","seven","1000","teeessssssssssttttttt","denemeeeeeeeeeeeee")
        val f8 = Film(8,"Avatar","avatar","1500","teeessssssssssttttttt","denemeeeeeeeeeeeee")

        val items = listOf(f1,f2,f3,f4)
        val items1 = listOf(f5,f6,f7,f8)

        for (i in items){
            filmList.add(i)
        }

        for (i in items1){
            filmListUpcoming.add(i)
        }

        val newFilmAdapter = FilmAdapter(this,filmList)
        val upcomingFilmAdapter = FilmAdapter(this,filmListUpcoming)

        binding.apply{
            recyclerView1.adapter = newFilmAdapter
            recyclerView1.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

            recyclerView2.adapter = upcomingFilmAdapter
            recyclerView2.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        }

    }

}