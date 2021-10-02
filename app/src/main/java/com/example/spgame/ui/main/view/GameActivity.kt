package com.example.spgame.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.spgame.ui.main.adapter.GamePlayersAdapter
import com.example.spgame.R
import com.example.spgame.model.Player
import com.example.spgame.model.User
import com.google.android.flexbox.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val layoutPlayers = FlexboxLayoutManager(this@GameActivity).apply {
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }

        val rvPlayers :RecyclerView = findViewById<RecyclerView>(R.id.rvPlayers).apply {
            adapter = GamePlayersAdapter(players = initPlayersList())
            layoutManager = layoutPlayers
            isNestedScrollingEnabled = false
        }

    }

    override fun onResume() {
        super.onResume()
        //Щоб прибрати statusBar зверху
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }


    private fun initPlayersList (): MutableList<Player> = mutableListOf(
        Player(User(1,"Name1", "https://www.personality-insights.com/wp-content/uploads/2017/12/default-profile-pic-e1513291410505.jpg"),0),
        Player(User(2,"Name2", "https://forum.fairphone.com/uploads/default/original/2X/3/315153974e87223a48b8472f593e9e297e6a7889.jpg"),0),
        Player(User(3,"Name3", "https://it-tehnik.ru/wp-content/uploads/default-user.jpg"),0),
        Player(User(4,"Name4", "https://abiturients.info/ru/system/files/styles/user_avatar/private/avatars/picture-default.webp?original-extension=jpg&itok=yFAg2f8N"),0)
    )

}