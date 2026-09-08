@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatPlane.
package org.joml2

/** [FloatPlane.intersectsSphere] as the `overlaps` infix function. */
inline infix fun FloatPlane.overlaps(sph: FloatSphere): Boolean = intersectsSphere(sph)
/** [FloatPlane.intersectsAABB] as the `overlaps` infix function. */
inline infix fun FloatPlane.overlaps(box: FloatAABB): Boolean = intersectsAABB(box)
