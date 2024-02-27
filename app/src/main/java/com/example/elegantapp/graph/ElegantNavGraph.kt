package com.example.elegantapp.graph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.elegantapp.ui.screens.ContactUsScreen
import com.example.elegantapp.ui.screens.HomePageScreen
import com.example.elegantapp.ui.screens.ROOM_KEY
import com.example.elegantapp.ui.screens.Screen
import com.example.elegantapp.ui.screens.ShopPageScreen

@Composable
fun ElegantNavGraph(
    navController: NavHostController,
    onCloseDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomePage.route,
        modifier = modifier
    ) {
        composable(route = Screen.HomePage.route) {
            onCloseDrawer()
            HomePageScreen(navController = navController)
        }
        composable(
            route = Screen.ShopPage.route,
            arguments = listOf(navArgument(ROOM_KEY) {
                type = NavType.StringType
            })
        ) {
            onCloseDrawer()
            ShopPageScreen(navController = navController, room = it.arguments?.getString(ROOM_KEY).toString())
        }
        composable(route = Screen.ContactUsPage.route) {
            onCloseDrawer()
            ContactUsScreen(navController = navController)
        }
    }
}