package com.example.rickmorty.presentation.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HeadingValue(
    item: DataPoint
) {
    Column {
        Text(
            text = item.heading,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            fontSize = 20.sp
        )
        Text(
            text = item.content,
            fontSize = 18.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    HeadingValue(
        DataPoint(
            "Rick",
            "Morty"
        )
    )
}

data class DataPoint(
    val heading: String,
    val content: String,
)