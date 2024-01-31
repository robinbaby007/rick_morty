package com.example.rickmorty.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.example.network.KtorClient
import com.example.rickmorty.repositories.CharacterRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val characterRepository: CharacterRepository): ViewModel(){

}