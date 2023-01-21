package com.example.telephone.ui.presentation.Model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessAlarm
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route : String,
    val title : String,
    val icon : ImageVector
) {
    object Home : BottomBarScreen(
        route = "recent",
        title = "Recents",
        icon = Icons.Outlined.AccessAlarm
    )
    object Contact : BottomBarScreen(
        route = "contact",
        title = "Contacts",
        icon = Icons.Outlined.Person
    )
}