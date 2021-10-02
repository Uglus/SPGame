package com.example.spgame.utils

import android.content.ContentResolver
import android.net.Uri
import android.webkit.MimeTypeMap
import java.io.File
import java.util.*


class ImageUtil {
    companion object{
        fun isImageFile(path : String) : String{
            return getMimeType(path)
        }

        private fun getMimeType(fallback: String = "image/*"): String {
            return MimeTypeMap.getFileExtensionFromUrl(toString())
                ?.run { MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowercase(Locale.getDefault())) }
                ?: fallback // You might set it to */*
        }
    }


}