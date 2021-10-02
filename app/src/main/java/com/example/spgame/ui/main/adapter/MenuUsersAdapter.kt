package com.example.spgame.ui.main.adapter

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spgame.R
import com.example.spgame.model.User
import com.example.spgame.databinding.UserBinding
import com.example.spgame.presentation.viewmodel.UserViewModel
import com.example.spgame.utils.UserActionListener


class MenuUsersAdapter(private val onClickUser: UserActionListener)
    :RecyclerView.Adapter<MenuUsersAdapter.UserViewHolder>(), View.OnClickListener {

    var usersList : List<User> = emptyList()
    set(newValue) { // Сеттер для того щоб повідомляти ресайклер про необхідність себе оновити при кожній зміні значення ліста
        field = newValue
        notifyDataSetChanged()
    }

    override fun onClick(v: View) {
        val user = v.tag as User
       // onClickUser.onUserRemove(user)
        showPopupMenu(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = DataBindingUtil
            .inflate<UserBinding>(LayoutInflater.from(parent.context), R.layout.user,parent, false).apply {
                root.layoutParams.apply {
                    height = (parent.height * 0.6).toInt()
                    width = (parent.width * 0.2).toInt()
                }
            }

        binding.root.setOnClickListener(this)
        //binding.imgUser.setOnClickListener(this)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = usersList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = usersList.size

    private fun showPopupMenu(view:View){
        val context = view.context
        val popupMenu = PopupMenu(context,view)
        val user = view.tag as User

        popupMenu.menu.add(0,ID_DELETE,Menu.NONE,context.getString(R.string.popup_remove_user))

        popupMenu.setOnMenuItemClickListener {
            when(it.itemId){
                ID_DELETE->onClickUser.onUserRemove(user)
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }

    companion object{
        private const val ID_DELETE = 1
    }

    inner class UserViewHolder(private val binding: UserBinding)
        :RecyclerView.ViewHolder(binding.root){
            init {
                binding.viewModel = UserViewModel()
            }
            fun bind(user: User){
                itemView.tag = user
                //binding.imgUser.tag = user //?
                binding.apply {
                   // itemView.minimumWidth = 100
                    viewModel?.user = user
                 executePendingBindings()// Так як RV оновлює дані дуже швидко
                }
            }
        }
}