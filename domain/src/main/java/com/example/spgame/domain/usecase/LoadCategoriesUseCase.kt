package com.example.spgame.domain.usecase

import com.example.spgame.domain.model.Category
import com.example.spgame.domain.repository.CategoryRepository

class LoadCategoriesUseCase(private val categoryRepository: CategoryRepository)  {
     operator fun invoke() : MutableList<Category> {
        return categoryRepository.getCategories()
    }
}