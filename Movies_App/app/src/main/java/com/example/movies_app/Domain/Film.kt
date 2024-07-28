package com.example.movies_app.Domain

data class Film(val id: Int,
                val title: String,
                val img: String ,
                val score: String,
                val time: String,
                val calendar: String,
                val summery: String,
                val actors: String,
                val actorsImg: List<DetailDomain>)
