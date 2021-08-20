package com.example.spgame

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import java.util.*


public class CategoryAdapter(var data: MutableList<Category>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.slide_categories_container, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int)
    = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    inner class CategoryViewHolder(view: View)
        : RecyclerView.ViewHolder(view){
        private val nameTextView : TextView = itemView.findViewById(R.id.slideCategoryName)
        private val imageImageView : ImageView = itemView.findViewById(R.id.slideCategoryImage)

        fun bind(category : Category){
            nameTextView.text = itemView.resources.getText(category.name)
            imageImageView.setImageResource(category.image)
        }

    }
}





