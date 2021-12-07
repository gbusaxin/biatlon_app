package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemPlayerBinding
import com.example.trainingsystem.databinding.ItemResultBinding
import com.example.trainingsystem.databinding.ItemResultCountryBinding
import com.example.trainingsystem.domain.pojo.SealedResultsInfo
import com.example.trainingsystem.domain.pojo.TeamsResultInfo

class TeamsResultAdapter : RecyclerView.Adapter<SealedResultViewHolder>() {

    var list = listOf<SealedResultsInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var items = listOf<TeamsResultInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SealedResultViewHolder {
        return when(viewType){
            R.layout.item_result_country ->  SealedResultViewHolder.TeamInfoViewHolder(
                ItemResultCountryBinding.inflate(
                    LayoutInflater.from(parent.context), parent,false)
            )
            R.layout.item_result ->  SealedResultViewHolder.TeamResultViewHolder(
                ItemResultBinding.inflate(
                    LayoutInflater.from(parent.context), parent,false)
            )
            R.layout.item_player ->  SealedResultViewHolder.PlayersInfoViewHolder(
                ItemPlayerBinding.inflate(
                    LayoutInflater.from(parent.context), parent,false)
            )
            else -> throw Exception()
        }
    }

    override fun onBindViewHolder(holder: SealedResultViewHolder, position: Int) {

    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return when(list[position]){
            is SealedResultsInfo.Coutry -> R.layout.item_result_country
            is SealedResultsInfo.Result -> R.layout.item_result
            is SealedResultsInfo.Team -> R.layout.item_player
        }
    }

}