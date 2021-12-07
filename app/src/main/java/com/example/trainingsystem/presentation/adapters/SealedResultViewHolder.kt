package com.example.trainingsystem.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.trainingsystem.databinding.ItemPlayerBinding
import com.example.trainingsystem.databinding.ItemResultBinding
import com.example.trainingsystem.databinding.ItemResultCountryBinding
import com.example.trainingsystem.domain.pojo.PlayerInfo
import com.example.trainingsystem.domain.pojo.TeamInfo
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import com.squareup.picasso.Picasso

sealed class SealedResultViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TeamResultViewHolder(private val binding: ItemResultBinding) :
        SealedResultViewHolder(binding) {
        fun bind(title: TeamsResultInfo) {
            binding.textViewResultCondition.text = title.condition
            binding.textViewResultDate.text = title.date
            binding.textViewResultStage.text = title.stage
            binding.textViewResultType.text = title.type
        }
    }

    class TeamInfoViewHolder(private val binding: ItemResultCountryBinding) :
        SealedResultViewHolder(binding) {
        fun bind(country: TeamInfo) {
            Picasso.get().load(country.image).into(binding.imageViewTeamsResult)
            binding.textViewResultName.text = country.name
            binding.textViewResultLag.text = country.lag
            binding.textViewResultResult.text = country.result
            binding.textViewResultComment.text = country.comments
            binding.textViewResultScores.text = country.scores.toString()
        }
    }

    class PlayersInfoViewHolder(private val binding: ItemPlayerBinding) :
        SealedResultViewHolder(binding) {
            fun bind(player:PlayerInfo){
                binding.textViewResultPlayer.text = "${player.player} ${player.comment}"
            }
    }
}
