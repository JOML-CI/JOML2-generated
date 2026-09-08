@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatTriangle.
package org.joml2

/** [FloatTriangle.transform] as the `*` operator. */
inline operator fun FloatTriangle.times(m: Float3x4): FloatTriangle = transform(m)
/** [FloatTriangle.transform] as the `*` operator. */
inline operator fun FloatTriangle.times(m: Float4x4): FloatTriangle = transform(m)
/** [FloatTriangle.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun FloatTriangle.contains(p: Float3): Boolean = containsPoint(p)
