package com.example.telephone.ui.Routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.telephone.ui.presentation.Model.NavigationScreen
import com.example.telephone.ui.presentation.RecentCallComposable
import com.example.telephone.ui.presentation.screens.CreateContact
import com.example.telephone.ui.presentation.screens.DetailScreen

@Composable
fun GlobalNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.Home.route) {
        composable(NavigationScreen.Home.route) {
            RecentCallComposable(navController)
        }
        composable(NavigationScreen.Create.route) {
            CreateContact(navController)
        }
        composable(NavigationScreen.Details.route) {
            DetailScreen(navController)
        }
    }
}