package com.example.telephone.ui.Routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.telephone.ui.presentation.Model.BottomBarScreen
import com.example.telephone.ui.presentation.screens.ContactScreen
import com.example.telephone.ui.presentation.screens.HomeScreen

@Composable
fun BottomGraph(navController: NavHostController, navControllerGlobal: NavController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController, navControllerGlobal)
        }
        composable(route = BottomBarScreen.Contact.route) {
            ContactScreen(navController, navControllerGlobal)
        }
    }
}