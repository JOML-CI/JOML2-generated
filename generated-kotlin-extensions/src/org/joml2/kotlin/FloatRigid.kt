@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for FloatRigid.
package org.joml2.kotlin

import org.joml2.*

/** [FloatRigid.mul] as the `*` operator. */
inline operator fun FloatRigid.times(other: FloatRigid): FloatRigid = mul(other)
/** [FloatRigid.transform] as the `*` operator. */
inline operator fun FloatRigid.times(v: Float3): Float3 = transform(v)
