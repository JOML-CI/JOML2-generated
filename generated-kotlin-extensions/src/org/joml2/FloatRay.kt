@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatRay.
package org.joml2

/** [FloatRay.transform] as the `*` operator. */
inline operator fun FloatRay.times(m: Float3x4): FloatRay = transform(m)
/** [FloatRay.transform] as the `*` operator. */
inline operator fun FloatRay.times(m: Float4x4): FloatRay = transform(m)
/** [FloatRay.at] as the indexing operator: `ray[t]` is the point at parameter `t` along the ray. */
inline operator fun FloatRay.get(t: Float): Float3 = at(t)
