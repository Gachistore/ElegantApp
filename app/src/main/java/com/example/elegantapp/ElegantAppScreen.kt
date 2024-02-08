package com.example.elegantapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.elegantapp.ui.components.ElegantTopAppBar
import com.example.elegantapp.ui.screens.HomePageScreen

enum class ElegantAppScreen() {
    HomePage,
    ProductPage,
    ShopPage,
    Cart,
    BlogPage,
    ContactUsPage
}

@Composable
fun ElegantApp() {

    val viewModel: ElegantViewModel = viewModel()
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ElegantAppScreen.valueOf(
        backStackEntry?.destination?.route ?: ElegantAppScreen.HomePage.name
    )
    Scaffold(
        topBar = {
            ElegantTopAppBar()
        },
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = ElegantAppScreen.HomePage.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = ElegantAppScreen.HomePage.name) {
                HomePageScreen()
            }
        }

    }
}