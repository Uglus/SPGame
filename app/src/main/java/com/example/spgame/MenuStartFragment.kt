package com.example.spgame

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class MenuStartFragment : DialogFragment() {
    inline fun <reified T> T.TAG(): String = T::class.java.simpleName

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(TAG(), "onCreateDialog(MenuStartFragment)")
        return activity?.let {
            val view = layoutInflater.inflate(R.layout.dialog_menu_start,null).apply {
                background = R.color.purple_700.toDrawable()
            }
            val btnCreate : Button = view.findViewById(R.id.btnCreateGame)
            btnCreate.setOnClickListener {
                Log.d(TAG(), "btnCreate clicked")
                val intent : Intent = Intent(context,GameActivity::class.java)
                context?.startActivity(intent)
            }

            val builder = AlertDialog.Builder(it,R.style.MenuStartDialogAnimationTheme).apply {
                setView(view)
            }

            builder.show()
        } ?: throw IllegalStateException("Activity cannot be null")
        //return super.onCreateDialog(savedInstanceState)
    }
}