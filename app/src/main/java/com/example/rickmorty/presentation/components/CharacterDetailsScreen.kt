package com.example.rickmorty.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rickmorty.presentation.components.common.HeadingValue

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
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {


                items(state.dataPoints) { dataPoint ->
                    HeadingValue(item = dataPoint)
                }

                item { Spacer(modifier = Modifier.height(8.dp)) }

                item {
                    CharacterImage(state.character.image)
                }
                item { Spacer(modifier = Modifier.height(8.dp)) }
                item {
                    Text(
                        text = "View All Episodes",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .border(
                                shape = RoundedCornerShape(10.dp),
                                color = Color.Yellow,
                                width = 1.dp
                            )
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }

        is CharacterState.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.message)
            }
        }
    }


}