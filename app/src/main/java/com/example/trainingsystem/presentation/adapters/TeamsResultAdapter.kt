package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemPlayerBinding
import com.example.trainingsystem.databinding.ItemResultBinding
import com.example.trainingsystem.databinding.ItemResultCountryBinding
import com.example.trainingsystem.domain.pojo.TeamsResultInfo

class TeamsResultAdapter : RecyclerView.Adapter<SealedResultViewHolder>() {

    var list = listOf<TeamsResultInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SealedResultViewHolder {
        return when (viewType) {
            R.layout.item_result_country -> SealedResultViewHolder.TeamInfoViewHolder(
                ItemResultCountryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.item_result -> SealedResultViewHolder.TeamResultViewHolder(
                ItemResultBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            R.layout.item_player -> SealedResultViewHolder.PlayersInfoViewHolder(
                ItemPlayerBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw Exception()
        }
    }

    override fun onBindViewHolder(holder: SealedResultViewHolder, position: Int) {
        when(holder){
            is SealedResultViewHolder.PlayersInfoViewHolder -> holder.bind(list[position].teams[position].players[position])
            is SealedResultViewHolder.TeamInfoViewHolder -> holder.bind(list[position].teams.get(position))
            is SealedResultViewHolder.TeamResultViewHolder -> holder.bind(list[position])
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return when (list[position].whatIs()) {
            1 -> R.layout.item_result
            2 -> R.layout.item_result_country
            3 -> R.layout.item_player
            else -> throw Exception()
        }
    }

}