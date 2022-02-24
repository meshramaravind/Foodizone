package com.arvind.foodizone.data

import com.arvind.foodizone.model.Categories

object CategoriesRepository {

    fun getCategoriesData(): List<Categories> {
        return listOf(
            Categories(
                id = 1,
                name = "Burgers",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_burgers.png"
            ),
            Categories(
                id = 2,
                name = "Pizza",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_fries.png"
            ),
            Categories(
                id = 3,
                name = "Healthy",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_beverages.png"
            ),
            Categories(
                id = 4,
                name = "Combo Meals",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_combo_meals.png"
            ),
            Categories(
                id = 5,
                name = "Happy Meals",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_happy_meals.png"
            ),
            Categories(
                id = 6,
                name = "Desserts",
                image = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "category_desserts.png"
            )
        )
    }
}