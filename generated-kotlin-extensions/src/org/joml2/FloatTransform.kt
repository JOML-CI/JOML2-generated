@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatTransform.
package org.joml2

/** [FloatTransform.mul] as the `*` operator. */
inline operator fun FloatTransform.times(other: FloatTransform): FloatTransform = mul(other)
/** [FloatTransform.transform] as the `*` operator. */
inline operator fun FloatTransform.times(v: Float3): Float3 = transform(v)
