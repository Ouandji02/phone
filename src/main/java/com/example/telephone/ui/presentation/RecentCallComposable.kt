package com.example.telephone.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.telephone.ui.Routes.BottomGraph
import com.example.telephone.ui.presentation.Model.BottomBarScreen
import com.example.telephone.ui.presentation.composables.BottomNavigationComposable

@Composable
fun RecentCallComposable() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val backstack by navController.currentBackStackEntryAsState()
    println(backstack?.destination!!.route)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(elevation = 0.dp) {
                Surface {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = "research",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .padding(vertical = 15.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "research",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .padding(vertical = 15.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "research",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .padding(vertical = 15.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
            }

        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
            }
        },
        bottomBar = {
            BottomNavigationComposable(navController)
        }
    ) {
        BottomGraph(navController)
    }
}