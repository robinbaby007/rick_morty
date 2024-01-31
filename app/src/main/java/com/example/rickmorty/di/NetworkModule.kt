package com.example.rickmorty.di

import com.example.network.KtorClient
import com.example.rickmorty.repositories.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideKtorClient(): KtorClient = KtorClient()

    @Provides
    @Singleton
    fun provideCharacterRepository(ktorClient: KtorClient): CharacterRepository =
        CharacterRepository(ktorClient = ktorClient)
}