package com.arvind.foodizone.data

import com.arvind.foodizone.model.Menu
import com.arvind.foodizone.model.MenuItem

object MenuRepository {

    fun getMenuData(): Menu {
        return Menu(
            categories = CategoriesRepository.getCategoriesData(),
            menuItems = listOf(
                MenuItem(
                    id = 1001,
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_big_mac.png",
                    name = "Big Mac",
                    price = getRandomPrice()

                ),
                MenuItem(
                    id = 1002,
                    name = "Quarter Pounder with Cheese",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_quarter_pounder_with_cheese.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1003,
                    name = "Double Quarter Pounder with Cheese",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_double_quarter_pounder_with_cheese.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1004,
                    name = "Quarter Pounder with Cheese Deluxe",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_quarter_pounder_with_cheese_deluxe.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1005,
                    name = "McDouble",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_mcdouble.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1006,
                    name = "Quarter Pounder with Cheese Bacon",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_quarter_pounder_with_cheese_bacon.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1007,
                    name = "Cheeseburger",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_cheeseburger.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1008,
                    name = "Double Cheeseburger",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_double_cheeseburger.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1009,
                    name = "Hamburger",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_hamburger.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1010,
                    name = "McChicken",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_mcchicken.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 1011,
                    name = "Filet-O-Fish",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_filet_o_fish.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 2001,
                    name = "Small French Fries",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_small_french_fries.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 2002,
                    name = "Medium French Fries",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_medium_french_fries.png",
                    price = getRandomPrice()
                ),
                MenuItem(
                    id = 2003,
                    name = "Large French Fries",
                    ordersImageId = "https://raw.githubusercontent.com/hitanshu-dhawan/McCompose/main/app/src/main/res/drawable-nodpi/" + "menu_item_large_french_fries.png",
                    price = getRandomPrice()
                )
            ),
        )
    }

    fun getRandomPrice(): Double = (1..9).random() + 0.99
}