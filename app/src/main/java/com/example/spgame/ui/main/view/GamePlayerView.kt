package com.example.spgame

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.spgame.ui.main.view.UserView
import com.google.android.material.imageview.ShapeableImageView

class GamePlayerView(context: Context, attrs: AttributeSet) : ConstraintLayout(context,attrs) {
    init{
        inflate(context,R.layout.game_player,this)

        val userView : UserView = findViewById(R.id.viewUser)
        val imgPlayer : ShapeableImageView = userView.findViewById(R.id.imgUser)
        val tvPlayerName : TextView = userView.findViewById(R.id.tvUserName)

        val tvPlayerScore : TextView = findViewById(R.id.tvPlayerScore)

        val attributes = context.obtainStyledAttributes(attrs,R.styleable.GamePlayerView)
        imgPlayer.setImageDrawable(attributes.getDrawable(R.styleable.GamePlayerView_image))
        tvPlayerName.text = attributes.getString(R.styleable.GamePlayerView_name)
        tvPlayerScore.text = attributes.getString(R.styleable.GamePlayerView_score)
        attributes.recycle()
    }
}