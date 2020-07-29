package moe.him188.jcekt

import kotlinx.io.core.Input
import kotlinx.io.core.Output
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialFormat
import kotlinx.serialization.SerializationStrategy

/**
 * Unstable
 */
public interface IOFormat : SerialFormat {

    public fun <T> dumpTo(serializer: SerializationStrategy<T>, ojb: T, output: Output)

    public fun <T> load(deserializer: DeserializationStrategy<T>, input: Input): T
}
