@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for IntRect.
package org.joml2

/** [IntRect.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun IntRect.contains(p: Int2): Boolean = containsPoint(p)
/** [IntRect.containsRect] as the `in` operator, so `o in shape` reads as containment. */
inline operator fun IntRect.contains(o: IntRect): Boolean = containsRect(o)
/** [IntRect.intersectsRect] as the `overlaps` infix function. */
inline infix fun IntRect.overlaps(o: IntRect): Boolean = intersectsRect(o)
