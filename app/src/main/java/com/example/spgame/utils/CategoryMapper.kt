package com.example.spgame.utils

import com.example.spgame.domain.model.Category

class CategoryMapper {

    companion object{
        fun mapDomainCategoryToAppCategory(category:Category) : com.example.spgame.model.Category{
            return com.example.spgame.model.Category(
                id = category.id,
                name = category.name,
                image = category.image
            )
        }

        fun mapDomainCategoriesToAppCategories(categories : List<Category>):List<com.example.spgame.model.Category>{
            val appCategories = mutableListOf<com.example.spgame.model.Category>()
            categories.forEach {
                appCategories.add(mapDomainCategoryToAppCategory(it))
            }
            return appCategories
        }

    }

}