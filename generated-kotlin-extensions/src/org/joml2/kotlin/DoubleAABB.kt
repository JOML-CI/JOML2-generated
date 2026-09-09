@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleAABB.
package org.joml2.kotlin

import org.joml2.*

/** [DoubleAABB.transform] as the `*` operator. */
inline operator fun DoubleAABB.times(m: Double3x4): DoubleAABB = transform(m)
/** [DoubleAABB.transform] as the `*` operator. */
inline operator fun DoubleAABB.times(m: Double4x4): DoubleAABB = transform(m)
/** [DoubleAABB.containsPoint] as the `in` operator, so `p in shape` reads as containment. */
inline operator fun DoubleAABB.contains(p: Double3): Boolean = containsPoint(p)
/** [DoubleAABB.containsAABB] as the `in` operator, so `o in shape` reads as containment. */
inline operator fun DoubleAABB.contains(o: DoubleAABB): Boolean = containsAABB(o)
/** [DoubleAABB.intersectsAABB] as the `overlaps` infix function. */
inline infix fun DoubleAABB.overlaps(o: DoubleAABB): Boolean = intersectsAABB(o)
/** [DoubleAABB.intersectsSphere] as the `overlaps` infix function. */
inline infix fun DoubleAABB.overlaps(sph: DoubleSphere): Boolean = intersectsSphere(sph)
/** [DoubleAABB.intersectsPlane] as the `overlaps` infix function. */
inline infix fun DoubleAABB.overlaps(plane: DoublePlane): Boolean = intersectsPlane(plane)
/** [DoubleAABB.intersectsRay] as the `overlaps` infix function. */
inline infix fun DoubleAABB.overlaps(ray: DoubleRay): Boolean = intersectsRay(ray)
