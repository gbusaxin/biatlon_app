package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemWorldCupBinding
import com.example.trainingsystem.domain.pojo.WorldCupInfo
import java.lang.StringBuilder

class WorldCupAdapter:RecyclerView.Adapter<WorldCupAdapter.WorldCupViewHolder>() {

    inner class WorldCupViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = ItemWorldCupBinding.bind(itemView)
        val body = binding.textViewWorldCupBody
        val stage = binding.textViewWorldCupStage
    }

    var list = listOf<WorldCupInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorldCupViewHolder {
        return WorldCupViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_world_cup,parent,false))
    }

    override fun onBindViewHolder(holder: WorldCupViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            stage.text = item.stage
            val builder = StringBuilder()
            for( item in item.racing){
                builder.append(item.body)
            }
            body.text = builder.toString()
        }
    }

    override fun getItemCount() = list.size
}