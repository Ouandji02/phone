package com.example.telephone.ui.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.telephone.Domain.Model.Contact
import com.example.telephone.Domain.Model.Response
import com.example.telephone.ui.presentation.ContactViewModel
import com.example.telephone.ui.presentation.Model.NavigationScreen
import com.example.telephone.ui.presentation.composables.FieldComposable
import org.koin.androidx.compose.getViewModel

@Composable
fun CreateContact(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var surname by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    val contactViewModel = getViewModel<ContactViewModel>()
    val context = LocalContext.current
    var loading by remember {
         mutableStateOf(false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 0.dp,
                title = {
                    Text("Creer un nouveau contact", style = MaterialTheme.typography.h1)
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
                    IconButton(onClick = {
                       contactViewModel.addContact(
                            Contact(
                                name = name.text,
                                surname = surname.text,
                                phone = phone.text,
                                email = email.text,
                            )
                        )
                        println(contactViewModel.addContactResponse)
                        loading = true
                        if(loading) when(val response = contactViewModel.addContactResponse){
                            is Response.Error -> {
                                Toast.makeText(
                                    context,
                                    "une erreur s'est produite",
                                    Toast.LENGTH_LONG
                                ).show()
                                loading = false
                            }
                            is Response.Success -> {
                                Toast.makeText(context, "Contact enregistre", Toast.LENGTH_LONG)
                                    .show()
                                navController.navigate(NavigationScreen.Home.route)
                                loading = false
                            }
                            else -> {Toast.makeText(context,"Else", Toast.LENGTH_LONG).show()}
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "icons",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colors.primary.copy(.5f)
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoCamera,
                    contentDescription = "icons",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(80.dp)
                )
            }
            Column(modifier = Modifier.padding(vertical = 50.dp)) {
                Row() {
                    Icon(
                        imageVector = Icons.Default.PhoneAndroid,
                        contentDescription = "icons",
                        modifier = Modifier.padding(end = 20.dp)
                    )
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "Enregistrement sur le compte",
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )
                        Text("Telephone", style = TextStyle(color = Color.LightGray))
                    }
                }
                FieldComposable(
                    imageVector = Icons.Default.Person,
                    onFieldChange = { newValue -> name = TextFieldValue(newValue) },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    name = name.text,
                    label = "Nom"
                )
                FieldComposable(
                    imageVector = Icons.Default.Person,
                    onFieldChange = { newValue -> surname = TextFieldValue(newValue) },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    name = surname.text,
                    label = "Prenom"
                )
                FieldComposable(
                    imageVector = Icons.Default.Phone,
                    onFieldChange = { newValue -> phone = TextFieldValue(newValue) },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    name = phone.text,
                    label = "Telephone"
                )
                FieldComposable(
                    imageVector = Icons.Default.Email,
                    onFieldChange = { newValue -> email = TextFieldValue(newValue) },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    name = email.text,
                    label = "Email"
                )
            }
            }

    }

}