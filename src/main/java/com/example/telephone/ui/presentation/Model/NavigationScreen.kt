package com.example.telephone.ui.presentation.Model

sealed class NavigationScreen(val route : String){
    object Home : NavigationScreen(route = "home")
    object Create : NavigationScreen(route = "create")
    object  Details : NavigationScreen(route = "details")
}