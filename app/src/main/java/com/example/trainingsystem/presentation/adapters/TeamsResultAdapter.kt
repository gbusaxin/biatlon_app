package com.example.trainingsystem.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.ItemResultBinding
import com.example.trainingsystem.domain.pojo.TeamsResultInfo
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class TeamsResultAdapter : RecyclerView.Adapter<TeamsResultAdapter.TeamsResultViewHolder>() {

    inner class TeamsResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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
        val players = binding.textViewResultPlayer
    }

    var list = listOf<TeamsResultInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsResultViewHolder {
        return TeamsResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamsResultViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            type.text = item.type
            date.text = item.date
            condition.text = item.condition
            stage.text = item.stage
            Picasso.get().load(item.teams[position].image).into(image)
            name.text = item.teams[position].name
            scores.text = item.teams[position].scores.toString()
            lag.text = item.teams[position].lag
            result.text = item.teams[position].result
            comment.text = item.teams[position].comments
            val builder = StringBuilder()
            val playersItem = item.teams[position].players
            for( player in playersItem){
                builder.append("${player.player} ${player.comment}")
            }
            players.text = builder.toString()
        }
    }

    override fun getItemCount() = list.size
}