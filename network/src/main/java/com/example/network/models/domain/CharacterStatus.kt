package com.example.network.models.domain

import android.graphics.Color


sealed class CharacterStatus(status: String, color: Int) {
    data object Alive : CharacterStatus("Alive", Color.GREEN)
    data object Dead : CharacterStatus("Dead", Color.RED)
    data object Unknown : CharacterStatus("Unknown", Color.YELLOW)
}