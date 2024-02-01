package com.example.rickmorty.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickmorty.presentation.viewModels.CharacterState
import com.example.rickmorty.presentation.viewModels.CharacterViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    characterViewModel: CharacterViewModel = hiltViewModel()
) {
    val characterDetailsState = characterViewModel.characterDetailsState.collectAsState()
    LaunchedEffect(key1 = Unit,
        block = {
            characterViewModel.getCharacterDetails(characterId = characterId)
        })

    when (val state = characterDetailsState.value) {
        is CharacterState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is CharacterState.Success -> {
            LazyColumn {
                item {
                    CharacterImage(state.character.image)
                }
                item { Spacer(modifier = Modifier.height(8.dp)) }
                item {
                    Text(text = state.character.name)
                }
            }
        }

        is CharacterState.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text =state.message)
            }
        }
    }


}