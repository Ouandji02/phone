package com.example.telephone.ui.presentation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.telephone.Domain.Model.Response
import com.example.telephone.ui.presentation.ContactViewModel
import com.example.telephone.ui.presentation.Model.NavigationScreen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContactScreen(
    navController: NavController,
    navControllerGlobal: NavController,
    contactViewModel: ContactViewModel = getViewModel(),
    context: Context = LocalContext.current
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Contacts",
            style = MaterialTheme.typography.h2.copy(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 0.dp, start = 15.dp)
        )
        when (val response = contactViewModel.getAllContactResponse) {
            is Response.Loading -> Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
            is Response.Success -> {
                if (response.data.isEmpty()) Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Aucun contact")
                }
                else LazyColumn {
                    items(items = response.data) { contact ->
                        Box(

                        ) {
                            Surface(modifier = Modifier.clickable {
                                navControllerGlobal.navigate(
                                    NavigationScreen.Details.route + "/${contact.phone}"
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
                                                    text = contact.name[0].toString(),
                                                    style = MaterialTheme.typography.h2.copy(
                                                        fontSize = 20.sp
                                                    )
                                                )
                                            }
                                        }
                                        Text(text = contact.name.toString())
                                    }
                                }
                            }
                        }
                    }
                }
            }
            is Response.Error -> {
                Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
            }
        }

    }
}