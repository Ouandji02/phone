package com.example.telephone.ui.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.telephone.ui.presentation.Model.NavigationScreen

@Composable
fun ContactScreen(navController: NavController, navControllerGlobal: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Contacts",
            style = MaterialTheme.typography.h2.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 0.dp, start = 15.dp)
        )
        LazyColumn {
            items(1) {
                Surface(modifier = Modifier.clickable {
                    navControllerGlobal.navigate(
                        NavigationScreen.Details.route
                    )
                }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                modifier = Modifier
                                    .padding(end = 30.dp)
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clip(
                                        CircleShape
                                    ),
                                color = Color.Yellow,
                                elevation = 3.dp

                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PersonAdd,
                                        contentDescription = "add number"
                                    )
                                }
                            }
                            Text(text = "Mon profil")
                        }
                    }
                }

            }
            items(10) {
                Surface(modifier = Modifier.clickable {
                    navControllerGlobal.navigate(
                        NavigationScreen.Details.route
                    )
                }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Surface(
                                modifier = Modifier
                                    .padding(end = 30.dp)
                                    .height(40.dp)
                                    .width(40.dp)
                                    .clip(
                                        CircleShape
                                    ),
                                color = Color.Yellow,
                                elevation = 3.dp

                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "M",
                                        style = MaterialTheme.typography.h2.copy(fontSize = 20.sp)
                                    )
                                }
                            }
                            Text(text = "848484884")
                        }
                    }
                }
            }
        }
    }
}