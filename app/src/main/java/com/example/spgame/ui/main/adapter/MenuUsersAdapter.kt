package com.example.spgame

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spgame.databinding.UserBinding
import com.example.spgame.ui.main.viewmodel.UserViewModel

class MenuUsersAdapter(var users: MutableList<User>)
    :RecyclerView.Adapter<MenuUsersAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = DataBindingUtil
            .inflate<UserBinding>(LayoutInflater.from(parent.context), R.layout.user,parent, false)
        binding.root.layoutParams.apply {
            height = (parent.height * 0.6).toInt()
            width = (parent.width * 0.2).toInt()
        }
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = users.size

    inner class UserViewHolder(private val binding: UserBinding)
        :RecyclerView.ViewHolder(binding.root){
            init {
                binding.userVM = UserViewModel()
            }
            fun bind(user:User){
                binding.apply {
                   // itemView.minimumWidth = 100
                    userVM?.user = user
                 executePendingBindings()// Так як RV оновлює дані дуже швидко
                }
            }
        }
}