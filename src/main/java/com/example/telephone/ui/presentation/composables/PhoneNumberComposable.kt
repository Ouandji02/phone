package com.example.telephone.ui.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PhoneNumberComposable() {
    Column(modifier = Modifier.padding(horizontal = 30.dp)) {
        RowNumberPhone(
            digit1 = "1",
            digit2 = "2",
            digit3 = "3",
            letter1 = "&",
            letter2 = "ABC",
            letter3 = "DEF"
        )
        RowNumberPhone(
            digit1 = "4",
            digit2 = "5",
            digit3 = "6",
            letter1 = "GHI",
            letter2 = "JKL",
            letter3 = "MNO"
        )
        RowNumberPhone(
            digit1 = "7",
            digit2 = "8",
            digit3 = "9",
            letter1 = "PQRS",
            letter2 = "TUV",
            letter3 = "WXYZ"
        )
        RowNumberPhone(
            digit1 = "*",
            digit2 = "0",
            digit3 = "#",
            letter1 = "",
            letter2 = "+",
            letter3 = ""
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
                    ButtonCall(sim = "1")
                    ButtonCall(sim = "2")
                }
                IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(end = 10.dp)) {
                    Icon(imageVector = Icons.Default.Dashboard, contentDescription = "icons")
                }
            }
        }
    }


}

@Composable
fun ButtonCall(sim: String) {
    Box(modifier = Modifier.padding(horizontal = 5.dp)) {
        Surface(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(
                    CircleShape
                ),
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
fun ColumnDigit(digit: String, letter: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(all = 10.dp)
            .clickable { }
            .clip(CircleShape)
            .height(60.dp)
            .width(60.dp)
    ) {
        Text(
            text = digit,
            style = MaterialTheme.typography.h1.copy(
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
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
    letter3: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ColumnDigit(digit = digit1, letter = letter1)
        ColumnDigit(digit = digit2, letter = letter2)
        ColumnDigit(digit = digit3, letter = letter3)
    }
}