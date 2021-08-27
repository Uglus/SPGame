package com.example.spgame

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import java.util.*
import java.util.zip.Inflater


public class CategoryAdapter(var data: MutableList<Category>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.slide_categories_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class CategoryViewHolder(view: View)
        : RecyclerView.ViewHolder(view){
        private val nameTextView : TextView = itemView.findViewById(R.id.slideCategoryName)
        private val imageImageView : ImageView = itemView.findViewById(R.id.slideCategoryImage)
        private val btnStart : Button = itemView.findViewById(R.id.slideCategoryStartBtn)

        init {
            btnStart.setOnClickListener {
                Log.d("CategoryAdapter","btnStart clicked")
                val dialog : DialogFragment = MenuStartFragment()
                val activity: AppCompatActivity = itemView.context as AppCompatActivity
                dialog.show(activity.supportFragmentManager,null)

            }
        }

        fun bind(category : Category){
            nameTextView.text = itemView.resources.getText(category.name)
            imageImageView.setImageResource(category.image)
        }
    }
}





