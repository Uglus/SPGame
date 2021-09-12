package com.example.spgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spgame.ui.main.view.UserView

class GamePlayersAdapter(var players: MutableList<Player>)
    :RecyclerView.Adapter<GamePlayersAdapter.PlayerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.game_player,parent,false)
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player)
    }

    override fun getItemCount(): Int = players.size

    inner class PlayerViewHolder(view: View)
        :RecyclerView.ViewHolder(view){
        private val score : TextView = view.findViewById(R.id.tvPlayerScore)
        private val user : UserView = view.findViewById(R.id.viewUser)

        fun bind(player:Player){
            score.text = player.score.toString()
            user.tvUserName.text = player.user.name
            user.imgUser.setImageResource(player.user.img)
        }


    }
}