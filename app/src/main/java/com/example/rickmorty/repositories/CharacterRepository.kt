package com.example.rickmorty.repositories

import com.example.network.ApiOperation
import com.example.network.models.remote.RemoteCharacter
import com.example.network.KtorClient
import com.example.network.models.domain.DomainCharacter
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val ktorClient: KtorClient) {
    suspend fun getCharacter(id: Int): ApiOperation<DomainCharacter> = ktorClient.getCharacter(id = id)
}