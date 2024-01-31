package com.example.rickmorty.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.Character
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
            val characterDetails = characterRepository
                .getCharacter(id = characterId)
            _characterDetailsState
                .update {
                    CharacterState.Success(character = characterDetails)
                }
        }
    }
}

sealed interface CharacterState {
    data object Loading : CharacterState
    data class Success(val character: Character) : CharacterState
    data class Error(val message: String) : CharacterState
}