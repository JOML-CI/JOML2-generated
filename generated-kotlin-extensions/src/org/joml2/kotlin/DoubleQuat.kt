@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for DoubleQuat.
package org.joml2.kotlin

import org.joml2.*

/** [DoubleQuat.add] as the `+` operator. */
inline operator fun DoubleQuat.plus(other: DoubleQuat): DoubleQuat = add(other)
/** [DoubleQuat.negate] as the unary `-` operator. */
inline operator fun DoubleQuat.unaryMinus(): DoubleQuat = negate()
/** [DoubleQuat.sub] as the `-` operator. */
inline operator fun DoubleQuat.minus(other: DoubleQuat): DoubleQuat = sub(other)
/** [DoubleQuat.mul] as the `*` operator. */
inline operator fun DoubleQuat.times(other: DoubleQuat): DoubleQuat = mul(other)
/** [DoubleQuat.dot] as an infix function, so `a dot b` parses. */
inline infix fun DoubleQuat.dot(other: DoubleQuat): Double = dot(other)
/** [DoubleQuat.preRotateX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.preRotateX(angle: Angle): DoubleQuat = preRotateX(angle.radians)
/** [DoubleQuat.preRotateY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.preRotateY(angle: Angle): DoubleQuat = preRotateY(angle.radians)
/** [DoubleQuat.preRotateZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.preRotateZ(angle: Angle): DoubleQuat = preRotateZ(angle.radians)
/** [DoubleQuat.rotateAxis] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateAxis(angle: Angle, axis: Double3): DoubleQuat = rotateAxis(angle.radians, axis)
/** [DoubleQuat.rotateX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateX(angle: Angle): DoubleQuat = rotateX(angle.radians)
/** [DoubleQuat.rotateXYZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateXYZ(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = rotateXYZ(angleX.radians, angleY.radians, angleZ.radians)
/** [DoubleQuat.rotateXZY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateXZY(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = rotateXZY(angleX.radians, angleY.radians, angleZ.radians)
/** [DoubleQuat.rotateY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateY(angle: Angle): DoubleQuat = rotateY(angle.radians)
/** [DoubleQuat.rotateYXZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateYXZ(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = rotateYXZ(angleX.radians, angleY.radians, angleZ.radians)
/** [DoubleQuat.rotateYZX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateYZX(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = rotateYZX(angleX.radians, angleY.radians, angleZ.radians)
/** [DoubleQuat.rotateZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateZ(angle: Angle): DoubleQuat = rotateZ(angle.radians)
/** [DoubleQuat.rotateZXY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateZXY(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = rotateZXY(angleX.radians, angleY.radians, angleZ.radians)
/** [DoubleQuat.rotateZYX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun DoubleQuat.rotateZYX(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = rotateZYX(angleX.radians, angleY.radians, angleZ.radians)
/** [DoubleQuat.transform] as the `*` operator. */
inline operator fun DoubleQuat.times(v: Double3): Double3 = transform(v)
/** Component 1 of this DoubleQuat (`x()`), for destructuring declarations. */
inline operator fun DoubleQuat.component1(): Double = x()
/** Component 2 of this DoubleQuat (`y()`), for destructuring declarations. */
inline operator fun DoubleQuat.component2(): Double = y()
/** Component 3 of this DoubleQuat (`z()`), for destructuring declarations. */
inline operator fun DoubleQuat.component3(): Double = z()
/** Component 4 of this DoubleQuat (`w()`), for destructuring declarations. */
inline operator fun DoubleQuat.component4(): Double = w()
/** A copy of this DoubleQuat with the named components replaced; every component left out keeps its current value. */
inline fun DoubleQuat.copy(x: Double = x(), y: Double = y(), z: Double = z(), w: Double = w()): DoubleQuat = DoubleQuat(x, y, z, w)
/** The components of this DoubleQuat in a new `DoubleArray`, in storage order. */
inline fun DoubleQuat.toDoubleArray(): DoubleArray = store(DoubleArray(4))
/** A DoubleQuat read from this array in storage order, starting at index 0. */
inline fun DoubleArray.toDoubleQuat(): DoubleQuat = DoubleQuat.load(this)
/** The component of this DoubleQuat at `index` in storage order, throwing `IndexOutOfBoundsException` when `index` is out of range. Read-only: an indexed ASSIGNMENT with 3 indices (`v[a, b, ...] = x`) resolves to the Java 4-argument value factory `DoubleQuat.set(...)`, whose result is discarded - it compiles but is a silent no-op on this immutable record; use `copy(...)` or the `with*` methods instead. */
inline operator fun DoubleQuat.get(index: Int): Double = when (index) {
    0 -> x()
    1 -> y()
    2 -> z()
    3 -> w()
    else -> throw IndexOutOfBoundsException("DoubleQuat index: $index")
}

// Static make*(… : Angle …) factories. Object-scoped because Kotlin can't
// extend a Java class's static scope, and bare top-level funs would collide by
// return type across the shapes/precisions sharing a name.
object DoubleQuatFactory {
    /** [DoubleQuat.makeRotationAxis] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationAxis(angle: Angle, axis: Double3): DoubleQuat = DoubleQuat.makeRotationAxis(angle.radians, axis)
    /** [DoubleQuat.makeRotationX] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationX(angle: Angle): DoubleQuat = DoubleQuat.makeRotationX(angle.radians)
    /** [DoubleQuat.makeRotationXYZ] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationXYZ(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = DoubleQuat.makeRotationXYZ(angleX.radians, angleY.radians, angleZ.radians)
    /** [DoubleQuat.makeRotationXZY] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationXZY(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = DoubleQuat.makeRotationXZY(angleX.radians, angleY.radians, angleZ.radians)
    /** [DoubleQuat.makeRotationY] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationY(angle: Angle): DoubleQuat = DoubleQuat.makeRotationY(angle.radians)
    /** [DoubleQuat.makeRotationYXZ] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationYXZ(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = DoubleQuat.makeRotationYXZ(angleX.radians, angleY.radians, angleZ.radians)
    /** [DoubleQuat.makeRotationYZX] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationYZX(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = DoubleQuat.makeRotationYZX(angleX.radians, angleY.radians, angleZ.radians)
    /** [DoubleQuat.makeRotationZ] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationZ(angle: Angle): DoubleQuat = DoubleQuat.makeRotationZ(angle.radians)
    /** [DoubleQuat.makeRotationZXY] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationZXY(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = DoubleQuat.makeRotationZXY(angleX.radians, angleY.radians, angleZ.radians)
    /** [DoubleQuat.makeRotationZYX] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationZYX(angleX: Angle, angleY: Angle, angleZ: Angle): DoubleQuat = DoubleQuat.makeRotationZYX(angleX.radians, angleY.radians, angleZ.radians)
}
