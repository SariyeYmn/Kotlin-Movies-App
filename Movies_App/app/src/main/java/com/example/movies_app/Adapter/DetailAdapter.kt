package com.example.movies_app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies_app.Domain.DetailDomain
import com.example.movies_app.databinding.ViewholderDetailImagesBinding

class DetailAdapter(var mContext: Context,var actorsListImg: List<DetailDomain>) : RecyclerView.Adapter<DetailAdapter.ViewHolder>(){


    inner class ViewHolder(var binding: ViewholderDetailImagesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAdapter.ViewHolder {
        val binding = ViewholderDetailImagesBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailAdapter.ViewHolder, position: Int) {
        val actor = actorsListImg[position]
        holder.binding.itemImages.setImageResource(actor.imageResourceId)
    }

    override fun getItemCount(): Int {
        return actorsListImg.size
    }

}