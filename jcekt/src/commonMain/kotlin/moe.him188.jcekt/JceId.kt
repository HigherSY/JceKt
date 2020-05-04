package moe.him188.jcekt

import kotlinx.serialization.SerialInfo

/**
 * The serial id used in Jce serialization
 */
@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class JceId(val id: Int)

