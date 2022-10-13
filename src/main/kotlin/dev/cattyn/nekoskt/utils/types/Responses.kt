package dev.cattyn.nekoskt.utils.types

import kotlinx.serialization.Serializable

@Serializable
data class EightBall(
    val response: String,
    val url: String
)

@Serializable
data class Cat(
    val cat: String
)

@Serializable
data class Fact(
    val fact: String
)

@Serializable
data class Image(
    val url: String
)

@Serializable
data class Name(
    val name: String
)

@Serializable
data class Why(
    val why: String
)

@Serializable
data class Owoify(
    val owo: String
)

@Serializable
data class Spoiler(
    val owo: String
)