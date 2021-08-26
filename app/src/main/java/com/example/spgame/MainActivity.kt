package com.example.spgame


import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.spgame.pagetransformer.CardAlphaPageTransformer
import com.example.spgame.pagetransformer.CardDropPageTransformer
import com.example.spgame.pagetransformer.CardMarginPageTransformer


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoriesList : MutableList<Category> = initCategoryList()
        var viewPager2 = initViewPager2(findViewById(R.id.vpCategoryQuizSlider),categoriesList)

        val settingsBtn = findViewById<ImageView>(R.id.imgUser)
        settingsBtn.setOnClickListener {
            val dialog = MenuSettingsFragment()
            val manager = supportFragmentManager
            dialog.show(manager,"TAG_SETTINGS")

        }

    }

    override fun onResume() {
        super.onResume()
        //Щоб прибрати statusBar зверху
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }


    private fun initCategoryList() : MutableList<Category> {
        return mutableListOf(
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
    }

    private fun initViewPager2 (viewPager2: ViewPager2, data:MutableList<Category>): ViewPager2{
        with(viewPager2) {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING) {
                        if (currentItem == 1)
                            setCurrentItem(data.size - 3, false)
                        else if (currentItem == data.size - 2)
                            setCurrentItem(2, false)
                    }
                }
            })
            adapter = CategoryAdapter(data = data)
            setCurrentItem(1, false)

            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3

            val transformer = CompositePageTransformer()
            transformer.apply {
                addTransformer(CardAlphaPageTransformer())
                addTransformer(CardDropPageTransformer())
                addTransformer(CardMarginPageTransformer())
            }

            setPageTransformer(transformer)
        }
        return viewPager2
    }


}