package com.example.elegantapp.ui.screens

const val ROOM_KEY = "room"

sealed class Screen(val route: String) {
    object HomePage: Screen(route = "home_page")
    object ProductPage: Screen(route = "product_page")
    object ShopPage: Screen(route = "shop_page/{$ROOM_KEY}") {
        fun passRoom(room: String): String {
            return this.route.replace(oldValue = "{$ROOM_KEY}", newValue = room)
        }
    }
    object Cart: Screen(route = "cart")
    object BlogPage: Screen(route = "blog_page")
    object ContactUsPage: Screen(route = "contact_us_page")
}