package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemResultBinding
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import com.squareup.picasso.Picasso

class TeamsResultAdapter : RecyclerView.Adapter<TeamsResultAdapter.TeamResultInfoViewHolder>() {
    inner class TeamResultInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemResultBinding.bind(itemView)
        val type = binding.textViewResultType
        val date = binding.textViewResultDate
        val condition = binding.textViewResultCondition
        val stage = binding.textViewResultStage
        val image = binding.imageViewTeamsResult
        val name = binding.textViewResultName
        val scores = binding.textViewResultScores
        val lag = binding.textViewResultLag
        val result = binding.textViewResultResult
        val comment = binding.textViewResultComment
    }

    var list = listOf<TeamsResultInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamResultInfoViewHolder {
        return TeamResultInfoViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_result,parent,false))
    }

    override fun onBindViewHolder(holder: TeamResultInfoViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            type.text = item.type
            date.text = item.date
            condition.text = item.condition
            stage.text = item.stage
            val team = item.teams[position]
            Picasso.get().load(team.image).into(image)
            name.text = team.name
            scores.text = team.scores.toString()
            lag.text = team.lag
            result.text = team.result
            comment.text = team.comments
        }
    }

    override fun getItemCount() = list.size


}