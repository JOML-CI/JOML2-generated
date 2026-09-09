@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatRect.
package org.joml2.kotlin

import org.joml2.*

/** [FloatRect.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun FloatRect.contains(p: Float2): Boolean = containsPoint(p)
/** [FloatRect.containsRect] as the `in` operator, so `o in shape` reads as containment. */
inline operator fun FloatRect.contains(o: FloatRect): Boolean = containsRect(o)
/** [FloatRect.intersectsRect] as the `overlaps` infix function. */
inline infix fun FloatRect.overlaps(o: FloatRect): Boolean = intersectsRect(o)
