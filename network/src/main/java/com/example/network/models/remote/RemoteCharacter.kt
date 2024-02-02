package com.example.network.models.remote


import com.example.network.models.domain.CharacterGender
import com.example.network.models.domain.CharacterStatus
import com.example.network.models.domain.DomainCharacter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacter(
    @SerialName("created")
    val created: String,
    @SerialName("episode")
    val episode: List<String>,
    @SerialName("gender")
    val gender: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("location")
    val location: Location,
    @SerialName("name")
    val name: String,
    @SerialName("origin")
    val origin: Origin,
    @SerialName("species")
    val species: String,
    @SerialName("status")
    val status: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
) {
    @Serializable
    data class Location(
        @SerialName("name")
        val name: String,
        @SerialName("url")
        val url: String
    )

    @Serializable
    data class Origin(
        @SerialName("name")
        val name: String,
        @SerialName("url")
        val url: String
    )
}

fun RemoteCharacter.toDomainCharacter(): DomainCharacter {
    val characterGender = when (gender.lowercase()) {
        "male" -> CharacterGender.Male
        "female" -> CharacterGender.Female
        "genderless" -> CharacterGender.GenderLess
        else -> CharacterGender.Unknown
    }
    val characterStatus = when (status.lowercase()) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }
    return DomainCharacter(
        created = created,
        gender = characterGender,
        id = id,
        status = characterStatus,
        image = image,
        name = name,
        location = DomainCharacter.Location(
            name = location.name,
            url = location.url
        ),
        origin = DomainCharacter.Origin(
            name = origin.name,
            url = origin.url
        ),
        species = species,
        type = type,
        episode = episode,
        url = url
    )
}