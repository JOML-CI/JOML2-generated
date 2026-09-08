@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoublePlane.
package org.joml2

/** [DoublePlane.intersectsSphere] as the `overlaps` infix function. */
inline infix fun DoublePlane.overlaps(sph: DoubleSphere): Boolean = intersectsSphere(sph)
/** [DoublePlane.intersectsAABB] as the `overlaps` infix function. */
inline infix fun DoublePlane.overlaps(box: DoubleAABB): Boolean = intersectsAABB(box)
