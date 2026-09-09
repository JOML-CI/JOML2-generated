@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatOBB.
package org.joml2.kotlin

import org.joml2.*

/** [FloatOBB.transform] as the `*` operator. */
inline operator fun FloatOBB.times(m: Float3x4): FloatOBB = transform(m)
/** [FloatOBB.transform] as the `*` operator. */
inline operator fun FloatOBB.times(m: Float4x4): FloatOBB = transform(m)
/** [FloatOBB.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun FloatOBB.contains(p: Float3): Boolean = containsPoint(p)
/** [FloatOBB.intersectsOBB] as the `overlaps` infix function. */
inline infix fun FloatOBB.overlaps(o: FloatOBB): Boolean = intersectsOBB(o)
