@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatAABB.
package org.joml2.kotlin

import org.joml2.*

/** [FloatAABB.transform] as the `*` operator. */
inline operator fun FloatAABB.times(m: Float3x4): FloatAABB = transform(m)
/** [FloatAABB.transform] as the `*` operator. */
inline operator fun FloatAABB.times(m: Float4x4): FloatAABB = transform(m)
/** [FloatAABB.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun FloatAABB.contains(p: Float3): Boolean = containsPoint(p)
/** [FloatAABB.containsAABB] as the `in` operator, so `o in shape` reads as containment. */
inline operator fun FloatAABB.contains(o: FloatAABB): Boolean = containsAABB(o)
/** [FloatAABB.intersectsAABB] as the `overlaps` infix function. */
inline infix fun FloatAABB.overlaps(o: FloatAABB): Boolean = intersectsAABB(o)
/** [FloatAABB.intersectsSphere] as the `overlaps` infix function. */
inline infix fun FloatAABB.overlaps(sph: FloatSphere): Boolean = intersectsSphere(sph)
/** [FloatAABB.intersectsPlane] as the `overlaps` infix function. */
inline infix fun FloatAABB.overlaps(plane: FloatPlane): Boolean = intersectsPlane(plane)
/** [FloatAABB.intersectsRay] as the `overlaps` infix function. */
inline infix fun FloatAABB.overlaps(ray: FloatRay): Boolean = intersectsRay(ray)
