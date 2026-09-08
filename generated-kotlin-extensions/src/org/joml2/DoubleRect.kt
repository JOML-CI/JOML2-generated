@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleRect.
package org.joml2

/** [DoubleRect.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun DoubleRect.contains(p: Double2): Boolean = containsPoint(p)
/** [DoubleRect.containsRect] as the `in` operator, so `o in shape` reads as containment. */
inline operator fun DoubleRect.contains(o: DoubleRect): Boolean = containsRect(o)
/** [DoubleRect.intersectsRect] as the `overlaps` infix function. */
inline infix fun DoubleRect.overlaps(o: DoubleRect): Boolean = intersectsRect(o)
