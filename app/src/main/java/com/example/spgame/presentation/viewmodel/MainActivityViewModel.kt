package com.example.spgame.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spgame.data.model.Category
import com.example.spgame.data.model.User
import com.example.spgame.data.repository.CategoryListener
import com.example.spgame.data.repository.CategoryRepository
import com.example.spgame.data.repository.UserRepository
import com.example.spgame.data.repository.UsersListener

class MainActivityViewModel(
    private val userRepository: UserRepository,
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users : LiveData<List<User>> = _users

    private val _categories = MutableLiveData<List<Category>>()
    val categories : LiveData<List<Category>> = _categories

    private val userListener : UsersListener = {
        _users.value = it
    }
    private val categoryListener: CategoryListener = {
        _categories.value = it
    }

    init {
        loadUsers()
        loadCategories()
    }

    override fun onCleared() {
        super.onCleared()
        userRepository.removeListener(userListener)
        categoryRepository.removeListener(categoryListener)
    }

    private fun loadCategories(){
        categoryRepository.addListener(categoryListener)
    }

    private fun loadUsers(){
        userRepository.addListener(userListener)
    }

    fun deleteUser(user: User){
        userRepository.deleteUser(user)
    }
}