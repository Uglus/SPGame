package com.example.spgame.data.api

import com.example.spgame.data.model.Category
import com.example.spgame.data.model.User
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
        val faker = Faker.instance()
        CATEGORIES.shuffle()
        val generatedCategories : List<Category> = (1..6).map { Category(
            id = it,
            name = faker.name().username(),
            image = CATEGORIES[it-1]
        ) }


        return generatedCategories
    }

    companion object{
        private val IMAGES = mutableListOf(
            "https://www.tenforums.com/geek/gars/images/2/types/thumb_15951118880user.png",
            "https://www.personality-insights.com/wp-content/uploads/2017/12/default-profile-pic-e1513291410505.jpg",
            "https://forum.fairphone.com/uploads/default/original/2X/3/315153974e87223a48b8472f593e9e297e6a7889.jpg",
            "https://it-tehnik.ru/wp-content/uploads/default-user.jpg",
            "https://abiturients.info/ru/system/files/styles/user_avatar/private/avatars/picture-default.webp?original-extension=jpg&itok=yFAg2f8N"
        )

        private val CATEGORIES = mutableListOf(
            "https://www.tenforums.com/geek/gars/images/2/types/thumb_15951118880user.png",
            "https://www.personality-insights.com/wp-content/uploads/2017/12/default-profile-pic-e1513291410505.jpg",
            "https://forum.fairphone.com/uploads/default/original/2X/3/315153974e87223a48b8472f593e9e297e6a7889.jpg",
            "https://it-tehnik.ru/wp-content/uploads/default-user.jpg",
            "https://abiturients.info/ru/system/files/styles/user_avatar/private/avatars/picture-default.webp?original-extension=jpg&itok=yFAg2f8N",
            "https://abiturients.info/ru/system/files/styles/user_avatar/private/avatars/picture-default.webp?original-extension=jpg&itok=yFAg2f8N"
        )
    }

}