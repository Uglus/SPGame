package com.example.spgame.ui.main.view

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import com.example.spgame.R

class MenuSettingsFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
             val builder = AlertDialog.Builder(it, R.style.SettingsDialogAnimationTheme)
             val view = layoutInflater.inflate(R.layout.dialog_menu_settings,null)
             view.background = R.color.purple_700.toDrawable()
             val changeLocalisationView = view.findViewById<Button>(R.id.btnLocalisation)

            changeLocalisationView.setOnClickListener {
                 Toast.makeText(view.context, "btnLocalise",Toast.LENGTH_SHORT).show()
                     //ДОРОБИТИ ЛОКАЛІЗАЦЮ
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