@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleRigid.
package org.joml2

/** [DoubleRigid.mul] as the `*` operator. */
inline operator fun DoubleRigid.times(other: DoubleRigid): DoubleRigid = mul(other)
/** [DoubleRigid.transform] as the `*` operator. */
inline operator fun DoubleRigid.times(v: Double3): Double3 = transform(v)
