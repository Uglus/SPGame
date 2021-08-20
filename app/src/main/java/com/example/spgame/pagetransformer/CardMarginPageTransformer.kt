package com.example.spgame.pagetransformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.spgame.R

class CardMarginPageTransformer : ViewPager2.PageTransformer {
    private var offset = 0f

    override fun transformPage(page: View, position: Float) {
        if (offset == 0f) {
            val cardWidth = page.findViewById<View>(R.id.slideCategoryImage).width
            offset = -page.width / 4f + (cardWidth * 0.33f)
        }

        page.translationX = offset * position
    }
}