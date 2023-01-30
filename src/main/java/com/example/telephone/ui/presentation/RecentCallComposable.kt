package com.example.telephone.ui.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.telephone.ui.Routes.BottomGraph
import com.example.telephone.ui.presentation.Model.BottomBarScreen
import com.example.telephone.ui.presentation.Model.NavigationScreen
import com.example.telephone.ui.presentation.composables.BottomNavigationComposable
import com.example.telephone.ui.presentation.composables.PhoneNumberComposable
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecentCallComposable(navController: NavController) {
    val conf = LocalConfiguration.current
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
    )
    val scaffoldState = rememberScaffoldState()
    val navControllerBottom = rememberNavController()
    val backstack by navControllerBottom.currentBackStackEntryAsState()
    val verificationRoute = backstack?.destination?.route == BottomBarScreen.Home.route
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
           /* TopAppBar(elevation = 0.dp) {
                Surface {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (verificationRoute) Icon(
                            imageVector = Icons.Default.FilterAlt,
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
                            imageVector = Icons.Default.Settings,
                            contentDescription = "research",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .padding(vertical = 15.dp, horizontal = 10.dp)
                                .size(30.dp)
                        )
                    }
                }
            }*/
        },
        floatingActionButton = {
            if(!modalSheetState.isVisible) FloatingActionButton(onClick = {
                if (!verificationRoute) navController.navigate(NavigationScreen.Create.route)
                else {
                    coroutineScope.launch {
                        if (modalSheetState.isVisible)
                            modalSheetState.hide()
                        else
                            modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
                    }
                }
            }, backgroundColor = MaterialTheme.colors.primary) {
                if (verificationRoute) Icon(
                    imageVector = Icons.Default.Apps,
                    contentDescription = "icons",
                    tint = Color.White
                )
                else Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "icons",
                    tint = Color.White
                )
            }
        },
        bottomBar = {
            BottomNavigationComposable(navControllerBottom)
        }
    ) {
        ModalBottomSheetLayout(
            sheetState = modalSheetState,
            sheetContent = {
                Column(
                    //modifier =  Modifier.padding(bottom = 40.dp)
                ) {
                    //...
                    Column( modifier = Modifier.fillMaxWidth()) {
                        /*Button(
                            onClick = {
                                coroutineScope.launch { modalSheetState.hide() }
                            }
                        ) {
                            Text(text = "Hide Sheet")
                        }*/
                        PhoneNumberComposable(modalSheetState)
                    }

                }
            }
        ){
            BottomGraph(navControllerBottom, navController)
        }

    }
}