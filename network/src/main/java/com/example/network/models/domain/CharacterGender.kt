package com.example.network.models.domain

sealed class CharacterGender(val genderName: String) {
    data object Male : CharacterGender("Male")
    data object Female : CharacterGender("Female")
    data object GenderLess : CharacterGender("GenderLess")
    data object Unknown : CharacterGender("Unknown")

}