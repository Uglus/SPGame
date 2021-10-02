package com.example.spgame.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.spgame.model.Category
import com.example.spgame.ui.main.view.MenuStartFragment

class CategoryViewModel  {
    var category: Category? = null
    set(category){
        field = category
    }

    val nameRes : String?
    get() = category?.name

    val imgRes : String?
    get() = category?.image

    fun showDialog(context: Context){
        Log.d("CategoryAdapter","btnStart clicked")
        val dialog : DialogFragment = MenuStartFragment()
        val activity: AppCompatActivity = context as AppCompatActivity
        dialog.show(activity.supportFragmentManager,null)
    }

}