package com.example.spgame.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.spgame.data.api.ApiHelper
import com.example.spgame.data.repository.CategoryRepositoryImpl
import com.example.spgame.data.repository.UserRepositoryImpl

import com.example.spgame.presentation.viewmodel.MainActivityViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass){
            MainActivityViewModel::class.java->{
                MainActivityViewModel(UserRepositoryImpl(apiHelper), CategoryRepositoryImpl(apiHelper))
            }
            /*CategoryViewModel::class.java->{
                CategoryViewModel(CategoryRepository(apiHelper))
            }*/
            else ->{throw IllegalArgumentException("Unknown view model class name")}
        }
        return viewModel as T

    }
}