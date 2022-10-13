package dev.cattyn.nekoskt

import com.sun.xml.internal.ws.encoding.soap.SerializationException
import dev.cattyn.nekoskt.exceptions.InvalidImageType
import dev.cattyn.nekoskt.utils.Images
import dev.cattyn.nekoskt.utils.deserialize
import dev.cattyn.nekoskt.utils.get
import dev.cattyn.nekoskt.utils.types.*

class NekosApi(private val userAgent: String) {

    fun eightBall(): EightBall {
        return deserialize(get("/8ball", userAgent))
    }

    fun cat(): Cat {
        return deserialize(get("/cat", userAgent))
    }

    fun chat(): Fact {
        return deserialize(get("/fact", userAgent))
    }

    @Throws(InvalidImageType::class)
    fun image(image: Images): Image {
        return image(image.ref)
    }

    @Throws(InvalidImageType::class)
    fun image(image: String): Image {
        try {
            return deserialize(get("/img/${image}", userAgent))
        } catch (ex: SerializationException) {
            throw InvalidImageType(image)
        }
    }

    fun name(): Name {
        return deserialize(get("/name", userAgent))
    }

    fun why(): Why {
        return deserialize(get("/why", userAgent))
    }

    fun owoify(text: String?): Owoify {
        return deserialize(get("/owoify?text=${text ?: ""}", userAgent))
    }

    fun spoiler(text: String?): Spoiler {
        return deserialize(get("/spoiler?text=${text ?: ""}", userAgent))
    }

}