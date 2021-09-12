package com.example.spgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
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
        Player(User("Name1",R.drawable.default_user),0),
        Player(User("Name2",R.drawable.default_user),0),
        Player(User("Name3",R.drawable.default_user),0),
        Player(User("Name4",R.drawable.default_user),0)
    )
}