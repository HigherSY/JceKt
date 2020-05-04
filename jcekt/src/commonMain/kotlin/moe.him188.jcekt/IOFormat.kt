package moe.him188.jcekt

import kotlinx.io.core.Input
import kotlinx.io.core.Output
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialFormat
import kotlinx.serialization.SerializationStrategy

interface IOFormat : SerialFormat {

    fun <T> dumpTo(serializer: SerializationStrategy<T>, ojb: T, output: Output)

    fun <T> load(deserializer: DeserializationStrategy<T>, input: Input): T
}
