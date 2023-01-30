package com.example.telephone.ui.presentation.composables

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telecom.TelecomManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import com.example.telephone.ui.presentation.screens.CallViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PhoneNumberComposable(modalSheetState: ModalBottomSheetState) {
   val context = LocalContext.current
    var value by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val coroutineScope = rememberCoroutineScope()
    val telecomManager = context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
    val call = telecomManager.createManageBlockedNumbersIntent()

    if (value.text.isNotEmpty()) FormNumber(onChange = { newValue ->
        value = TextFieldValue(newValue)
    }, name = value.text, remove = {
        value = TextFieldValue(value.text.removeRange(value.text.length - 1, value.text.length))
    })
    Column(modifier = Modifier.padding(bottom = 40.dp, end = 30.dp, start = 30.dp, top = 10.dp)) {
        RowNumberPhone(
            digit1 = "1",
            digit2 = "2",
            digit3 = "3",
            letter1 = "&",
            letter2 = "ABC",
            letter3 = "DEF",
            add1 = { value = TextFieldValue(value.text + "1") },
            add2 = { value = TextFieldValue(value.text + "2") },
            add3 = { value = TextFieldValue(value.text + "3") }
        )
        RowNumberPhone(
            digit1 = "4",
            digit2 = "5",
            digit3 = "6",
            letter1 = "GHI",
            letter2 = "JKL",
            letter3 = "MNO",
            add1 = { value = TextFieldValue(value.text + "4") },
            add2 = { value = TextFieldValue(value.text + "5") },
            add3 = { value = TextFieldValue(value.text + "6") }
        )
        RowNumberPhone(
            digit1 = "7",
            digit2 = "8",
            digit3 = "9",
            letter1 = "PQRS",
            letter2 = "TUV",
            letter3 = "WXYZ",
            add1 = { value = TextFieldValue(value.text + "7") },
            add2 = { value = TextFieldValue(value.text + "8") },
            add3 = { value = TextFieldValue(value.text + "9") }
        )
        RowNumberPhone(
            digit1 = "*",
            digit2 = "0",
            digit3 = "#",
            letter1 = "",
            letter2 = "+",
            letter3 = "",
            add1 = { value = TextFieldValue(value.text + "*") },
            add2 = { value = TextFieldValue(value.text + "0") },
            add3 = { value = TextFieldValue(value.text + "#") }
        )
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "")
                Row() {
                    ButtonCall(sim = "", onClick = {
                       context.startActivity(
                           Intent(Intent.ACTION_CALL, Uri.parse("tel:${value.text}"))
                           )
                    })
                }
                IconButton(
                    onClick = {
                        coroutineScope.launch { modalSheetState.hide() }
                    }, modifier = Modifier
                        .padding(end = 10.dp)
                        .height(60.dp)
                        .width(60.dp)
                ) {
                    Icon(imageVector = Icons.Default.Dashboard, contentDescription = "icons")
                }
            }
        }
    }
}

@Composable
fun FormNumber(
    name: String = "",
    onChange: (String) -> Unit,
    label: String = "",
    remove: () -> Unit
) {
    TextField(
        value = name,
        textStyle = MaterialTheme.typography.h1.copy(
            fontSize = 25.sp,
            fontWeight = FontWeight.W400
        ),
        onValueChange = onChange,
        label = {
            Text(label, color = Color.LightGray)
        },
        trailingIcon = {
            IconButton(onClick = remove) {
                Icon(imageVector = Icons.Default.Backspace, contentDescription = "icons")
            }
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colors.primary
        ),
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ButtonCall(sim: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(horizontal = 5.dp)) {
        Surface(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(
                    CircleShape
                )
                .clickable {
                    onClick()
                },
            color = MaterialTheme.colors.primary
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "icons",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text(text = sim, color = Color.White, modifier = Modifier.padding(end = 5.dp))
            }
        }
    }

}

@Composable
fun ColumnDigit(digit: String, letter: String, add: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                add()
            }
            .clip(CircleShape)
            .height(60.dp)
            .width(60.dp)
    ) {
        Text(
            text = digit,
            style = MaterialTheme.typography.h1.copy(
                fontSize = 25.sp,
                fontWeight = FontWeight.W400
            )
        )
        Text(text = letter, style = MaterialTheme.typography.subtitle2)
    }
}

@Composable
fun RowNumberPhone(
    digit1: String,
    digit2: String,
    digit3: String,
    letter1: String,
    letter2: String,
    letter3: String,
    add1: () -> Unit,
    add2: () -> Unit,
    add3: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        ColumnDigit(digit = digit1, letter = letter1, add = add1)
        ColumnDigit(digit = digit2, letter = letter2, add = add2)
        ColumnDigit(digit = digit3, letter = letter3, add = add3)
    }
}