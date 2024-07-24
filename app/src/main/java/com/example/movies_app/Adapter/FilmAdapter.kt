package com.example.movies_app.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_app.Activity.DetailActivity
import com.example.movies_app.Domain.Film
import com.example.movies_app.R
import com.example.movies_app.databinding.ViewholderFilmBinding

class FilmAdapter(var mContext: Context, var filmList: List<Film>)
    :RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(var binding: ViewholderFilmBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmAdapter.FilmViewHolder {
        val binding = ViewholderFilmBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmAdapter.FilmViewHolder, position: Int) {

        val film = filmList[position]
        val imgResId = mContext.resources.getIdentifier(film.img, "drawable", mContext.packageName)

        holder.binding.apply {
            titleTxt.text = film.title
            scoreTxt.text = film.score
            picture.setImageResource(mContext.resources.getIdentifier(film.img, "drawable", mContext.packageName))

            // Tıklama olayını burada işleyin
            holder.itemView.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("FILM_ID", film.id)
                    putExtra("FILM_TITLE", film.title)
                    putExtra("FILM_SCORE", film.score)
                    putExtra("FILM_SUMMERY", film.summery)
                    putExtra("FILM_ACTORS", film.actors) // Puanı ekleyin
                    putExtra("FILM_IMG_RES_ID", imgResId) // Görsel kaynağının ID'sini ekleyin
                }
                context.startActivity(intent)
            }


        }
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
}