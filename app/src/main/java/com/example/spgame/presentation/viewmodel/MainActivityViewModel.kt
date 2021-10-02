package com.example.spgame.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spgame.data.repository.CategoryRepositoryImpl
import com.example.spgame.data.repository.UserRepositoryImpl
import com.example.spgame.domain.usecase.LoadCategoriesUseCase
import com.example.spgame.domain.usecase.LoadUsersUseCase
import com.example.spgame.model.Category
import com.example.spgame.model.User
import com.example.spgame.utils.CategoryMapper
import com.example.spgame.utils.UserMapper

class MainActivityViewModel(
    private val userRepositoryImpl: UserRepositoryImpl,
    private val categoryRepositoryImpl: CategoryRepositoryImpl
) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users : LiveData<List<User>> = _users

    private val _categories = MutableLiveData<List<Category>>()
    val categories : LiveData<List<Category>> = _categories

/*    private val userListener : UsersListener = {
        _users.value = it
    }
    private val categoryListener: CategoryListener = {
        _categories.value = it
    }*/

    init {
        loadUsers()
        loadCategories()
    }

    override fun onCleared() {
        super.onCleared()
        //userRepositoryImpl.removeListener(userListener)
        //categoryRepositoryImpl.removeListener(categoryListener)

    }

    private fun loadCategories(){
       // categoryRepositoryImpl.addListener(categoryListener)
        val categories = CategoryMapper.mapDomainCategoriesToAppCategories(
            categories = LoadCategoriesUseCase(categoryRepositoryImpl).invoke()
        ) as MutableList<Category>

        categories.add(0,categories[categories.size-2])
        categories.add(1,categories[categories.size-1])

        categories.add(categories[2])
        categories.add(categories[3])

        Log.d("MainActivityViewModel", "loadCategories: $categories")

        _categories.value = categories


    }

    private fun loadUsers(){
       // userRepositoryImpl.addListener(userListener)


         /*_users.value = UserMapper.mapDomainUsersToAppUsers(
             users = LoadUsersUseCase(userRepositoryImpl).invoke()
         )*/


        // LoadUsersUseCase(userRepositoryImpl)
    }

    fun deleteUser(user: User){
       // userRepositoryImpl.deleteUser(user)
    }



}