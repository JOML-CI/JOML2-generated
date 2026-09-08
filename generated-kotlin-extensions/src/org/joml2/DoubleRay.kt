@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleRay.
package org.joml2

/** [DoubleRay.transform] as the `*` operator. */
inline operator fun DoubleRay.times(m: Double3x4): DoubleRay = transform(m)
/** [DoubleRay.transform] as the `*` operator. */
inline operator fun DoubleRay.times(m: Double4x4): DoubleRay = transform(m)
/** [DoubleRay.at] as the indexing operator: `ray[t]` is the point at parameter `t` along the ray. */
inline operator fun DoubleRay.get(t: Double): Double3 = at(t)
