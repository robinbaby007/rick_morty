package com.example.rickmorty.repositories

import com.example.network.ApiOperation
import com.example.network.Character
import com.example.network.KtorClient
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {
    suspend fun getCharacter(id: Int): ApiOperation<Character> = ktorClient.getCharacter(id = id)
}