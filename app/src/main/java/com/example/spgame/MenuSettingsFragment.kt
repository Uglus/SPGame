package com.example.spgame

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.withStyledAttributes
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment

class MenuSettingsFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
             val builder = AlertDialog.Builder(it,R.style.SettingsDialogAnimationTheme)
             val view = layoutInflater.inflate(R.layout.dialog_menu_settings,null)
             view.background = R.color.purple_700.toDrawable()
             val changeLocalisationView = view.findViewById<Button>(R.id.btnLocalisation)

            changeLocalisationView.setOnClickListener {
                 Toast.makeText(view.context, "btnLocalise",Toast.LENGTH_SHORT).show()
             }
             builder.setView(view)
             builder.show()
         } ?: throw IllegalStateException("Activity cannot be null")
    }


    override fun onResume() {
        super.onResume()
        var width : Int = resources.displayMetrics.widthPixels
        width -= (width * 0.25).toInt()
        var height : Int = resources.displayMetrics.heightPixels
        height -= (height * 0.3).toInt()
        dialog?.window?.apply {
            setLayout(width,height)
            setGravity(Gravity.TOP)
        }
    }
}