package com.example.spgame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                        if (currentItem == 0)
                            setCurrentItem(data.size - 2, false)
                        else if (currentItem == data.size -1)
                            setCurrentItem(1, false)
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