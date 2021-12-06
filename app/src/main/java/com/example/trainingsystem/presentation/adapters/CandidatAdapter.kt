package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemCandidatBinding
import com.example.trainingsystem.domain.pojo.CandidatInfo

class CandidatAdapter:RecyclerView.Adapter<CandidatAdapter.CandidatViewHolder>() {
    inner class CandidatViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = ItemCandidatBinding.bind(itemView)
        val name = binding.textViewCandidatName
        val degree = binding.textViewCandidatDegree
        val birthday = binding.textViewCandidatBirthday
        val place = binding.textViewCandidatPlace
    }

    var list = listOf<CandidatInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CandidatViewHolder {
        return CandidatViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_candidat,parent,false))
    }

    override fun onBindViewHolder(holder: CandidatViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            name.text = item.name
            degree.text = item.degree
            birthday.text = item.birthday
            place.text = item.place
        }
    }

    override fun getItemCount() = list.size
}