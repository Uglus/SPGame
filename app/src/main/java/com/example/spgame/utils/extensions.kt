package com.example.spgame.utils

import android.app.Activity
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.spgame.data.api.ApiHelper
import com.example.spgame.data.api.ApiServiceImpl
import com.example.spgame.ui.base.ViewModelFactory
import java.io.File

fun File.getMimeType(fallback: String = "image/*"): String {
    return MimeTypeMap.getFileExtensionFromUrl(toString())
        ?.run { MimeTypeMap.getSingleton().getMimeTypeFromExtension(toLowerCase()) }
        ?: fallback // You might set it to */*
}

fun Activity.showToast(text:Any) = Toast.makeText(this,text.toString(), Toast.LENGTH_SHORT).show()

fun ViewModel.factory() = ViewModelFactory(ApiHelper(ApiServiceImpl()))