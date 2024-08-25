package com.meuplantao.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meuplantao.screen.detail.DetailScreen
import com.meuplantao.screen.home.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navigateToDetails = {
                    navController.navigate(Screen.Detail.route)
                }
            )
        }
        composable(route = Screen.Detail.route) {
            DetailScreen(
                navigateToHome = {
                    navController.popBackStack()
                }
            )
        }
    }
}