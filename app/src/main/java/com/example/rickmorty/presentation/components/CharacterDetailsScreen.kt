package com.example.rickmorty.presentation.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickmorty.presentation.viewModels.MainViewModel

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    viewModel: MainViewModel = hiltViewModel()
) {
}