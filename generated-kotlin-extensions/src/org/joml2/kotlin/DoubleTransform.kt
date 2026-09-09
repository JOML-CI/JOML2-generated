@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleTransform.
package org.joml2.kotlin

import org.joml2.*

/** [DoubleTransform.mul] as the `*` operator. */
inline operator fun DoubleTransform.times(other: DoubleTransform): DoubleTransform = mul(other)
/** [DoubleTransform.transform] as the `*` operator. */
inline operator fun DoubleTransform.times(v: Double3): Double3 = transform(v)
