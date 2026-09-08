@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleOBB.
package org.joml2

/** [DoubleOBB.transform] as the `*` operator. */
inline operator fun DoubleOBB.times(m: Double3x4): DoubleOBB = transform(m)
/** [DoubleOBB.transform] as the `*` operator. */
inline operator fun DoubleOBB.times(m: Double4x4): DoubleOBB = transform(m)
/** [DoubleOBB.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun DoubleOBB.contains(p: Double3): Boolean = containsPoint(p)
/** [DoubleOBB.intersectsOBB] as the `overlaps` infix function. */
inline infix fun DoubleOBB.overlaps(o: DoubleOBB): Boolean = intersectsOBB(o)
