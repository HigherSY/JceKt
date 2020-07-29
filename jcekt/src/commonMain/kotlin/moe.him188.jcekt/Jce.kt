/*
 * Copyright 2020 Him188.
 *
 * Use of this source code is governed by the Apache 2.0 license that can be found through the following link.
 *
 * https://github.com/him188/jcekt/blob/master/LICENSE
 */

@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package moe.him188.jcekt

import kotlinx.io.charsets.Charset
import kotlinx.io.charsets.Charsets
import kotlinx.io.core.*
import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialFormat
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import moe.him188.jcekt.internal.JceDecoder
import moe.him188.jcekt.internal.JceInput
import moe.him188.jcekt.internal.JceOld
import kotlin.jvm.JvmStatic


/**
 * The main entry point to work with JCE serialization.
 */
public class Jce(
    public override val serializersModule: SerializersModule = EmptySerializersModule,
    public val charset: Charset = Charsets.UTF_8
) : SerialFormat, IOFormat, BinaryFormat {
    private val old = JceOld(charset)

    public override fun <T> dumpTo(serializer: SerializationStrategy<T>, ojb: T, output: Output) {
        output.writePacket(old.dumpAsPacket(serializer, ojb))
    }

    public override fun <T> load(deserializer: DeserializationStrategy<T>, input: Input): T {
        return JceDecoder(
            JceInput(
                input,
                charset
            ), serializersModule
        ).decodeSerializableValue(deserializer)
    }

    public override fun <T> encodeToByteArray(serializer: SerializationStrategy<T>, value: T): ByteArray {
        return buildPacket { dumpTo(serializer, value, this) }.readBytes()
    }

    public override fun <T> decodeFromByteArray(deserializer: DeserializationStrategy<T>, bytes: ByteArray): T {
        return load(deserializer, ByteReadPacket(bytes))
    }

    public companion object {
        @JvmStatic
        public val UTF_8: Jce = Jce()

        internal const val BYTE: Byte = 0
        internal const val DOUBLE: Byte = 5
        internal const val FLOAT: Byte = 4
        internal const val INT: Byte = 2
        internal const val JCE_MAX_STRING_LENGTH = 104857600
        internal const val LIST: Byte = 9
        internal const val LONG: Byte = 3
        internal const val MAP: Byte = 8
        internal const val SHORT: Byte = 1
        internal const val SIMPLE_LIST: Byte = 13
        internal const val STRING1: Byte = 6
        internal const val STRING4: Byte = 7
        internal const val STRUCT_BEGIN: Byte = 10
        internal const val STRUCT_END: Byte = 11
        internal const val ZERO_TYPE: Byte = 12
    }
}
