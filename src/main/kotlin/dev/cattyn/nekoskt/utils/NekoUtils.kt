package dev.cattyn.nekoskt.utils

import com.github.kevinsawicki.http.HttpRequest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

const val API_URL = "https://nekos.life/api/"
const val API_VERSION = "v2"

val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    coerceInputValues = true
    prettyPrint = true
}

fun get(suffix: String, userAgent: String = ""): HttpRequest {
    return HttpRequest.get(API_URL + API_VERSION + suffix).userAgent(userAgent);
}

inline fun <reified T> deserialize(res: HttpRequest): T {
    return json.decodeFromString(res.body() ?: "")
}
