package com.example.movies_app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_app.Domain.Film
import com.example.movies_app.databinding.ViewholderFilmBinding

class FavoriteAdapter(var mContext: Context, private val films: List<Film>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>()
{

    inner class ViewHolder(val binding: ViewholderFilmBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val film = films[position]
        val imgResId = mContext.resources.getIdentifier(film.img, "drawable", mContext.packageName)
        holder.binding.apply {
            titleTxt.text = film.title
            scoreTxt.text = film.score
            picture.setImageResource(imgResId)
        }
    }

}