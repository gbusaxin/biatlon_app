package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemNewsBinding
import com.example.trainingsystem.domain.pojo.NewsInfo
import com.squareup.picasso.Picasso

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = ItemNewsBinding.bind(itemView)
        val image = binding.imageView
        val head = binding.textViewHead
        val date = binding.textViewDate
        val body = binding.textViewBody
    }

    var newsList = listOf<NewsInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]
        with(holder){
            Picasso.get().load(item.image).into(image)
            head.text = item.head
            date.text = item.date
            body.text = item.body
        }
    }

    override fun getItemCount() = newsList.size

}