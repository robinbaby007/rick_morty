package com.example.rickmorty.presentation.components.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingState(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier
            .fillMaxSize()
            .padding(180.dp)
    )
}