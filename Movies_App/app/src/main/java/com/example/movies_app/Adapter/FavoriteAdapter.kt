package com.example.movies_app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_app.Domain.Film
import com.example.movies_app.databinding.ViewholderFavoriteBinding
import com.example.movies_app.databinding.ViewholderFilmBinding

class FavoriteAdapter(var mContext: Context, private val films: List<Film>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>()
{

    inner class ViewHolder(val binding: ViewholderFavoriteBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
            picture.setImageResource(imgResId)
            cardView.setOnClickListener {
                val builder = AlertDialog.Builder(mContext)
                builder.setTitle("Silme işlemi")
                builder.setMessage("Bu filmi farvorilerden kaldırmak istediğinize emin misiniz?")
                builder.setPositiveButton("Evet") { dialog, _ ->
                    // Tamam butonuna tıklanınca yapılacak işlemler
                    removeFilm(position)
                    dialog.dismiss()
                }
                builder.setNegativeButton("Hayır") { dialog, _ ->
                    // İptal butonuna tıklanınca yapılacak işlemler
                    dialog.dismiss()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }
    }

    fun removeFilm(position: Int) {
        val film = films[position]
        // Remove from SharedPreferences
        val sharedPreferences = mContext.getSharedPreferences("Favorites", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("${film.title}_favorite")
        editor.apply()

        // Remove from the list
        (films as MutableList).removeAt(position)
        notifyItemRemoved(position)
    }


}