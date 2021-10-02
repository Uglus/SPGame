package com.example.spgame.ui.main.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.spgame.data.api.ApiHelper
import com.example.spgame.data.api.ApiServiceImpl
import com.example.spgame.ui.main.adapter.CategoryAdapter
import com.example.spgame.databinding.ActivityMainBinding
import com.example.spgame.model.User
import com.example.spgame.utils.pagetransformer.CardAlphaPageTransformer
import com.example.spgame.utils.pagetransformer.CardDropPageTransformer
import com.example.spgame.utils.pagetransformer.CardMarginPageTransformer
import com.example.spgame.ui.base.ViewModelFactory
import com.example.spgame.ui.main.adapter.MenuUsersAdapter
import com.example.spgame.presentation.viewmodel.MainActivityViewModel
import com.example.spgame.utils.UserActionListener
import com.google.android.flexbox.*



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: MenuUsersAdapter
    private lateinit var categoryAdapter : CategoryAdapter

    private val viewModel : MainActivityViewModel by viewModels{ViewModelFactory(ApiHelper(ApiServiceImpl()))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout  = FlexboxLayoutManager(this@MainActivity).apply{
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP

        }
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = MenuUsersAdapter(object: UserActionListener{
            override fun onUserRemove(user: User) {
                viewModel.deleteUser(user)
            }
        })

        categoryAdapter = CategoryAdapter()

        binding.rvUsers.apply {
            adapter = userAdapter
            layoutManager = layout
            isNestedScrollingEnabled = false
        }

        //viewModel.users.observe(viewLifecycleOwner,) для фрагментів
        viewModel.apply {
            users.observe(this@MainActivity) {
                userAdapter.usersList = it
            }
            categories.observe(this@MainActivity) {
                categoryAdapter.categoriesList = it
            }
        }


        //val binding : ActivityMainBinding =
        //    DataBindingUtil.setContentView(this, R.layout.activity_main)

        //val categoriesList : MutableList<Category> = initCategoryList()
        //initViewPager2(binding.vpCategoryQuizSlider)
        initViewPager2()

        binding.imgUser.setOnClickListener {
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

    private fun initViewPager2 (){
        with(binding.vpCategoryQuizSlider/*viewPager2*/) {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING) {
                        if (currentItem == 1)
                            setCurrentItem(categoryAdapter.itemCount - 3, false)
                        else if (currentItem == categoryAdapter.itemCount - 2)
                            setCurrentItem(2, false)
                    }
                }
            })

            adapter = categoryAdapter
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
    }

    /*private fun initViewPager2 (viewPager2: ViewPager2): ViewPager2{
        with(viewPager2) {
            *//*registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING) {
                        if (currentItem == 1)
                            setCurrentItem(data.size - 3, false)
                        else if (currentItem == data.size - 2)
                            setCurrentItem(2, false)
                    }
                }
            })*//*
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == ViewPager2.SCROLL_STATE_IDLE || state == ViewPager2.SCROLL_STATE_DRAGGING) {
                        if (currentItem == 1)
                            setCurrentItem(categoryAdapter.itemCount - 3, false)
                        else if (currentItem == categoryAdapter.itemCount - 2)
                            setCurrentItem(2, false)
                    }
                }
            })

            adapter = categoryAdapter
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
    }*/

}