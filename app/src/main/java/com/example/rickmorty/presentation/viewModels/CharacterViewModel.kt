package com.example.rickmorty.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.Character
import com.example.rickmorty.presentation.components.common.DataPoint
import com.example.rickmorty.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterRepository: CharacterRepository) :
    ViewModel() {
    private var _characterDetailsState = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val characterDetailsState = _characterDetailsState.asStateFlow()
    fun getCharacterDetails(characterId: Int) {
        viewModelScope.launch {
            characterRepository
                .getCharacter(id = characterId)
                .onSuccess { character ->

                    val dataPoints = buildList<DataPoint> {
                        add(DataPoint("Name", character.name))
                        add(DataPoint("Gender", character.gender))
                        add(DataPoint("Species", character.species))
                        add(DataPoint("Origin", character.origin.name))
                        character.type.takeIf { it.isNotEmpty() }?.let { type ->
                            add(DataPoint("Type", type))
                        }
                    }
                    _characterDetailsState
                        .update {
                            CharacterState.Success(
                                character = character,
                                dataPoints = dataPoints
                            )
                        }
                }
                .onFailure { exception ->
                    _characterDetailsState
                        .update {
                            CharacterState.Error(message = exception.message ?: "Unknown Error")
                        }
                }

        }
    }
}

sealed interface CharacterState {
    data object Loading : CharacterState
    data class Success(
        val character: Character,
        val dataPoints: List<DataPoint>
    ) : CharacterState

    data class Error(val message: String) : CharacterState
}