package com.example.spgame.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spgame.R
import com.example.spgame.model.Player
import com.example.spgame.ui.main.view.UserView
import com.squareup.picasso.Picasso

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

        fun bind(player: Player){
            score.text = player.score.toString()
            user.tvUserName.text = player.user.name
            //user.imgUser.setImageURI(user.imgUser)
            Picasso.get().load(player.user.img).into(user.imgUser)
        }

    }
}