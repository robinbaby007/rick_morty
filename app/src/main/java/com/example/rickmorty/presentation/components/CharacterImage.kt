package com.example.rickmorty.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.rickmorty.presentation.components.common.LoadingState

@Composable
fun CharacterImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = "Image Item",
        contentScale = ContentScale.Crop,
        loading = {
            LoadingState()
        },
        modifier = modifier.clip(RoundedCornerShape(12.dp))
    )
}