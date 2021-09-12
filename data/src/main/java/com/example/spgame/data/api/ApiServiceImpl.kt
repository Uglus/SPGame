package com.example.data.api

import com.example.spgame.R
import com.example.data.model.Category
import com.example.data.model.User
import com.github.javafaker.Faker

class ApiServiceImpl : ApiService {

    override fun getUsers(): List<User> {
        //Псевдо витягування даних
        val faker = Faker.instance()
        IMAGES.shuffle()
        val generatedUsers : List<User> = (1..4).map { User(
            id = it,
            name = faker.name().username(),
            img = IMAGES[it]

        ) }
        return generatedUsers
    }

    override fun getCategories(): List<Category> {
        //Псевдо витягування даних
        return listOf(
            Category(name = R.string.sliderCategory1, image = R.drawable.image1),
            Category(name = R.string.sliderCategory2, image = R.drawable.image2),
            Category(name = R.string.sliderCategory3, image = R.drawable.image3),
            Category(name = R.string.sliderCategory4, image = R.drawable.image4),
            Category(name = R.string.sliderCategory5, image = R.drawable.image5),
            Category(name = R.string.sliderCategory6, image = R.drawable.image6)
            /*Category(name = R.string.sliderCategory5, image = R.drawable.image5),
        Category(name = R.string.sliderCategory6, image = R.drawable.image6),

        Category(name = R.string.sliderCategory1, image = R.drawable.image1),
        Category(name = R.string.sliderCategory2, image = R.drawable.image2),
        Category(name = R.string.sliderCategory3, image = R.drawable.image3),
        Category(name = R.string.sliderCategory4, image = R.drawable.image4),
        Category(name = R.string.sliderCategory5, image = R.drawable.image5),
        Category(name = R.string.sliderCategory6, image = R.drawable.image6),

        Category(name = R.string.sliderCategory1, image = R.drawable.image1),
        Category(name = R.string.sliderCategory2, image = R.drawable.image2)*/
        )
    }

    companion object{
        private val IMAGES = mutableListOf(
            "https://www.tenforums.com/geek/gars/images/2/types/thumb_15951118880user.png",
            "https://www.personality-insights.com/wp-content/uploads/2017/12/default-profile-pic-e1513291410505.jpg",
            "https://forum.fairphone.com/uploads/default/original/2X/3/315153974e87223a48b8472f593e9e297e6a7889.jpg",
            "https://it-tehnik.ru/wp-content/uploads/default-user.jpg",
            "https://abiturients.info/ru/system/files/styles/user_avatar/private/avatars/picture-default.webp?original-extension=jpg&itok=yFAg2f8N"
        )
    }

}