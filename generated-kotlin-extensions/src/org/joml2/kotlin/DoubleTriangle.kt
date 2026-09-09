@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleTriangle.
package org.joml2.kotlin

import org.joml2.*

/** [DoubleTriangle.transform] as the `*` operator. */
inline operator fun DoubleTriangle.times(m: Double3x4): DoubleTriangle = transform(m)
/** [DoubleTriangle.transform] as the `*` operator. */
inline operator fun DoubleTriangle.times(m: Double4x4): DoubleTriangle = transform(m)
/** [DoubleTriangle.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun DoubleTriangle.contains(p: Double3): Boolean = containsPoint(p)
