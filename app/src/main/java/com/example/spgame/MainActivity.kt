package com.example.spgame

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2:ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val categoriesList : MutableList<Category> = mutableListOf(
            Category(name = R.string.sliderCategory5, image = R.drawable.image5),
            Category(name = R.string.sliderCategory6, image = R.drawable.image6),

            Category(name = R.string.sliderCategory1, image = R.drawable.image1),
            Category(name = R.string.sliderCategory2, image = R.drawable.image2),
            Category(name = R.string.sliderCategory3, image = R.drawable.image3),
            Category(name = R.string.sliderCategory4, image = R.drawable.image4),
            Category(name = R.string.sliderCategory5, image = R.drawable.image5),
            Category(name = R.string.sliderCategory6, image = R.drawable.image6),

            Category(name = R.string.sliderCategory1, image = R.drawable.image1),
            Category(name = R.string.sliderCategory2, image = R.drawable.image2)
        )

        /*
        viewPager2 = findViewById(R.id.viewPagerCategoryQuizSlider)

        viewPager2.apply {
            adapter = CategoryAdapter(categories = categoriesList,viewPager2 = this)
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val transformer : CompositePageTransformer = CompositePageTransformer()
            transformer.apply {
                addTransformer(MarginPageTransformer(40))
                addTransformer { page: View, position: Float ->
                    val r: Float = 1 - abs(position)
                    page.scaleY = 0.85f + r * 0.15f
                }
            }
            setPageTransformer(transformer)
        }
        */
        viewPager2 = findViewById(R.id.viewPagerCategoryQuizSlider)
        with(viewPager2) {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING) {
                        if (currentItem == 0)
                            setCurrentItem(categoriesList.size - 2, false)
                        else if (currentItem == categoriesList.size -1)
                            setCurrentItem(1, false)
                    }
                }
            })
            adapter = CategoryAdapter(categoriesList)
            setCurrentItem(1, false)

            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3

            val transformer : CompositePageTransformer = CompositePageTransformer()
            transformer.apply {
                addTransformer(MarginPageTransformer(40))
                addTransformer { page: View, position: Float ->
                    val r: Float = 1 - abs(position)
                    page.scaleY = 0.85f + r * 0.15f
                    page.alpha = 1-abs(0.5f*position) // треба зробити якось розмиття вюшок ззаді
                }
            }
            setPageTransformer(transformer)
        }
    }

    override fun onResume() {
        super.onResume()
        //Щоб прибрати statusBar зверху
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
}