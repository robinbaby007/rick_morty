package com.example.rickmorty.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickmorty.presentation.viewModels.CharacterState
import com.example.rickmorty.presentation.viewModels.CharacterViewModel

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val characterDetailsState = characterViewModel.characterDetailsState.collectAsState()
    LaunchedEffect(key1 = Unit, block = {
        characterViewModel.getCharacterDetails(characterId = characterId)
    })
    when (characterDetailsState.value) {
        is CharacterState.Loading -> {

        }

        is CharacterState.Success -> {

        }

        is CharacterState.Error -> {

        }
    }
}