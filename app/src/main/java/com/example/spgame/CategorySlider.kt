package com.example.spgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class CategorySlider {

    private inner class CategoryAdapter(var categories: List<Category>, var viewPager2: ViewPager2)
        : RecyclerView.Adapter<CategoryViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            return CategoryViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.slide_categories_container, parent, false)
            )
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            val category = categories[position]
            holder.bind(category)
        }

        override fun getItemCount(): Int = categories.size

    }


    private inner class CategoryViewHolder(view: View)
        : RecyclerView.ViewHolder(view){
        private val nameTextView : TextView = itemView.findViewById(R.id.slideCategoryName)
        private val imageImageView : ImageView = itemView.findViewById(R.id.slideCategoryImage)

        fun bind(category : Category){
            nameTextView.text = category.name.toString()
            imageImageView.setImageResource(category.image)
        }
    }
}