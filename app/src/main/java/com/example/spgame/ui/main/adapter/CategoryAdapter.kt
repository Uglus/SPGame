package com.example.spgame.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spgame.R
import com.example.spgame.model.Category
import com.example.spgame.databinding.CategoryBinding
import com.example.spgame.presentation.viewmodel.CategoryViewModel


public class CategoryAdapter
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categoriesList : List<Category> = emptyList()
    set(newValue){
        field= newValue
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        /*return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.slide_categories_container, parent, false)*/
        val binding = DataBindingUtil
            .inflate<CategoryBinding>(LayoutInflater.from(parent.context), R.layout.slide_categories_container,parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) = holder.bind(categoriesList[position])

    override fun getItemCount(): Int = categoriesList.size


    inner class CategoryViewHolder(private val binding:CategoryBinding)
        : RecyclerView.ViewHolder(binding.root){
       /* private val nameTextView : TextView = itemView.findViewById(R.id.slideCategoryName)
        private val imageImageView : ImageView = itemView.findViewById(R.id.slideCategoryImage)
        private val btnStart : Button = itemView.findViewById(R.id.slideCategoryStartBtn)*/

        init {
            itemView.clipToOutline = true // Для закруглення кутів вюшки
            binding.viewModel = CategoryViewModel()

            /*btnStart.setOnClickListener {
*//*                Log.d("CategoryAdapter","btnStart clicked")
                val dialog : DialogFragment = MenuStartFragment()
                val activity: AppCompatActivity = itemView.context as AppCompatActivity
                dialog.show(activity.supportFragmentManager,null)*//*
            }*/
        }

        fun bind(category : Category){
            itemView.tag = category
            binding.apply {
                viewModel?.category = category
                executePendingBindings()
            }
            /*nameTextView.text = itemView.resources.getText(category.name)
            imageImageView.setImageResource(category.image)*/

        }
    }


}





