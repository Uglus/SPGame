package com.example.spgame.ui.main.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.spgame.R
import com.google.android.material.imageview.ShapeableImageView

class UserView(context: Context, attrs: AttributeSet) : ConstraintLayout(context,attrs) {

    val imgUser : ShapeableImageView
    val tvUserName : TextView

    init{
        inflate(context, R.layout.user,this)

        imgUser = findViewById(R.id.imgUser)
        tvUserName = findViewById(R.id.tvUserName)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.UserView)
        imgUser.setImageDrawable(attributes.getDrawable(R.styleable.UserView_imgUser))
        tvUserName.text = attributes.getString(R.styleable.UserView_nameUser)
        attributes.recycle()
    }
}