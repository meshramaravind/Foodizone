package com.arvind.foodizone.data

import com.arvind.foodizone.R
import com.arvind.foodizone.model.MyOrders

object MyOrdersDataDummy {
    val myOrders = MyOrders(
        1,
        R.drawable.burger,
        "Chicken Burger",
        4.25
    )

    val myOrdersList = listOf(
        myOrders,
        myOrders.copy(
            id = 2,
            ordersImageId = R.drawable.burger2,
            name = "Beef Burger",
            price = 3.45
        ),
        myOrders.copy(
            id = 3,
            ordersImageId = R.drawable.pizza,
            name = "Chicken Pizza",
            price = 6.25
        )
    )
}