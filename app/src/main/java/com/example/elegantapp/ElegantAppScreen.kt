package com.example.elegantapp

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.elegantapp.graph.ElegantNavGraph
import com.example.elegantapp.ui.components.ElegantTopAppBar
import com.example.elegantapp.ui.screens.ContactUsScreen
import com.example.elegantapp.ui.screens.FlyMenu
import com.example.elegantapp.ui.screens.HomePageScreen
import com.example.elegantapp.ui.screens.ShopPageScreen
import kotlinx.coroutines.launch

@Composable
fun ElegantApp() {

    val viewModel: ElegantViewModel = viewModel()
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val onCloseDrawer = {
        scope.launch {
            drawerState.apply {
                if (!isClosed) close()
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            FlyMenu(
                navController = navController,
                onClose = {
                    scope.launch {
                        drawerState.apply {
                            if (!isClosed) close()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .width(328.dp)
            )
        }
    ) {
        Scaffold(
            topBar = {
                ElegantTopAppBar(onDrawerClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open()
                        }
                    }
                })
            },

            ) { innerPadding ->
            val uiState by viewModel.uiState.collectAsState()

            ElegantNavGraph(
                navController = navController,
                onCloseDrawer = { onCloseDrawer() },
                modifier = Modifier.padding(innerPadding)
            )

        }
    }
}