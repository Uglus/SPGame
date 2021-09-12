package com.example.spgame.ui.main.viewmodel

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.example.spgame.data.model.Category
import com.example.spgame.ui.main.view.MenuStartFragment

class CategoryViewModel  {
    var category: Category? = null
    set(category){
        field = category
    }

    val nameRes : Int?
    get() = category?.name

    val imgRes : Int?
    get() = category?.image

    fun showDialog(context: Context){
        Log.d("CategoryAdapter","btnStart clicked")
        val dialog : DialogFragment = MenuStartFragment()
        val activity: AppCompatActivity = context as AppCompatActivity
        dialog.show(activity.supportFragmentManager,null)
    }

}