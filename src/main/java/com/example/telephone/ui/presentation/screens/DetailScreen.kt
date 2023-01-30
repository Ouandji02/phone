package com.example.telephone.ui.presentation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.RecordVoiceOver
import androidx.compose.material.icons.outlined.VideoCameraBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.telephone.Domain.Model.Contact
import com.example.telephone.Domain.Model.Response
import com.example.telephone.ui.presentation.ContactViewModel
import com.example.telephone.ui.presentation.Model.BottomBarScreen
import com.example.telephone.ui.presentation.Model.NavigationScreen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    phone: String,
    contactViewModel: ContactViewModel = getViewModel(),
    context: Context = LocalContext.current
) {
    var contact1 by remember{ mutableStateOf(Contact("","","","")) }
    val coroutine = rememberCoroutineScope()
    LaunchedEffect(key1 = phone) {
        coroutine.launch {
            contactViewModel.getOneContact(phone)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary.copy(.4f),
                elevation = 0.dp,
                title = {
                    Text("Details", style = MaterialTheme.typography.h1)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "icons",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                actions = {
                    Row() {
                        IconButton(onClick = {
                            contactViewModel.deleteContact(contact1)
                            when (contactViewModel.deleteContactResponse) {
                                is Response.Success -> navController.navigate(NavigationScreen.Home.route)
                                is Response.Error -> {
                                    Toast.makeText(
                                        context,
                                        "impossible de supprimer pour le moment",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                                else -> {}
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "icons",
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier
                                    .size(30.dp)
                            )
                        }
                        /*IconButton(onClick = { *//*TODO*//* }) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "icons",
                                tint = MaterialTheme.colors.primary,
                                modifier = Modifier.size(30.dp)
                            )
                        }*/
                    }


                }
            )
        }
    ) {
        when (val response = contactViewModel.getContactResponse) {
            is Response.Success -> {
                contact1 = response.data
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(color = MaterialTheme.colors.primary.copy(.4f)) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Surface(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clip(CircleShape),
                                color = Color.White
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "icons",
                                    tint = MaterialTheme.colors.primary,
                                    modifier = Modifier.size(80.dp)
                                )
                            }
                            Text(
                                text = (response.data.name + " " + response.data.surname).toUpperCase(),
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(vertical = 20.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp, horizontal = 20.dp)
                    ) {
                        Row(modifier = Modifier.padding(bottom = 20.dp)) {
                            Icon(
                                imageVector = Icons.Outlined.Phone,
                                contentDescription = "icons",
                                modifier = Modifier.padding(end = 30.dp),
                                tint = MaterialTheme.colors.primary
                            )
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = response.data.phone,
                                    style = TextStyle(fontWeight = FontWeight.Bold)
                                )
                                Text("Telephone", style = TextStyle(color = Color.LightGray))
                            }
                        }
                        Row(modifier = Modifier.padding(bottom = 20.dp)) {
                            Icon(
                                imageVector = Icons.Outlined.VideoCameraBack,
                                contentDescription = "icons",
                                modifier = Modifier.padding(end = 30.dp),
                                tint = MaterialTheme.colors.primary
                            )
                            Text(
                                text = response.data.phone,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                        Row(modifier = Modifier.padding(bottom = 20.dp)) {
                            Icon(
                                imageVector = Icons.Outlined.Email,
                                contentDescription = "icons",
                                modifier = Modifier.padding(end = 30.dp),
                                tint = MaterialTheme.colors.primary
                            )
                            Text(
                                text = response.data.email,
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                        Row(modifier = Modifier.padding(bottom = 20.dp)) {
                            Icon(
                                imageVector = Icons.Outlined.RecordVoiceOver,
                                contentDescription = "icons",
                                modifier = Modifier.padding(end = 30.dp),
                                tint = MaterialTheme.colors.primary
                            )
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = "Enregistreur d'appel",
                                    style = TextStyle(fontWeight = FontWeight.Bold)
                                )
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