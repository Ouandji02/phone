package com.example.telephone.ui.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Recents",
            style = MaterialTheme.typography.h2.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 0.dp, start = 15.dp)
        )
        LazyColumn {
            items(10) {
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
                                color = Color.Blue,
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
                            Column() {
                                Text(text = "848484884")
                                Row(verticalAlignment = Alignment.Bottom) {
                                    Icon(
                                        imageVector = Icons.Default.Call,
                                        contentDescription = "icons",
                                        tint = Color.LightGray
                                    )
                                    Text(text = "Mobile", style = MaterialTheme.typography.subtitle2)
                                }

                            }
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "il y a 1h",
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier.padding(end = 15.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "info",
                                tint = Color.LightGray
                            )
                        }
                    }

            }
        }
    }
}