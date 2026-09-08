@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")
@file:JvmSynthetic

// Kotlin operator/infix/destructuring/indexing extensions for Float4x4.
package org.joml2

/** [Float4x4.add] as the `+` operator. */
inline operator fun Float4x4.plus(other: Float4x4): Float4x4 = add(other)
/** [Float4x4.negate] as the unary `-` operator. */
inline operator fun Float4x4.unaryMinus(): Float4x4 = negate()
/** [Float4x4.sub] as the `-` operator. */
inline operator fun Float4x4.minus(other: Float4x4): Float4x4 = sub(other)
/** [Float4x4.mul] as the `*` operator. */
inline operator fun Float4x4.times(right: Float4x4): Float4x4 = mul(right)
/** [Float4x4.mul] as the `*` operator. */
inline operator fun Float4x4.times(right: Float2x2): Float4x4 = mul(right)
/** [Float4x4.mul] as the `*` operator. */
inline operator fun Float4x4.times(right: Float2x3): Float4x4 = mul(right)
/** [Float4x4.mul] as the `*` operator. */
inline operator fun Float4x4.times(right: Float3x3): Float4x4 = mul(right)
/** [Float4x4.mul] as the `*` operator. */
inline operator fun Float4x4.times(right: Float3x4): Float4x4 = mul(right)
/** [Float4x4.arcball] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.arcball(radius: Float, center: Float3, angleX: Angle, angleY: Angle): Float4x4 = arcball(radius, center, angleX.radians.toFloat(), angleY.radians.toFloat())
/** [Float4x4.obliqueCabinet] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.obliqueCabinet(angle: Angle): Float4x4 = obliqueCabinet(angle.radians.toFloat())
/** [Float4x4.obliqueCavalier] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.obliqueCavalier(angle: Angle): Float4x4 = obliqueCavalier(angle.radians.toFloat())
/** [Float4x4.obliqueMilitary] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.obliqueMilitary(angle: Angle): Float4x4 = obliqueMilitary(angle.radians.toFloat())
/** [Float4x4.perspective] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspective(fovy: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness, depthRange: DepthRange): Float4x4 = perspective(fovy.radians.toFloat(), aspect, near, far, handedness, depthRange)
/** [Float4x4.perspective] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspective(fovy: Angle, aspect: Float, near: Float, far: Float, depthRange: DepthRange): Float4x4 = perspective(fovy.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, depthRange)
/** [Float4x4.perspective] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspective(fovy: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness): Float4x4 = perspective(fovy.radians.toFloat(), aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE)
/** [Float4x4.perspective] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspective(fovy: Angle, aspect: Float, near: Float, far: Float): Float4x4 = perspective(fovy.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE)
/** [Float4x4.perspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness, depthRange: DepthRange): Float4x4 = perspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, handedness, depthRange)
/** [Float4x4.perspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float, depthRange: DepthRange): Float4x4 = perspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, depthRange)
/** [Float4x4.perspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness): Float4x4 = perspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE)
/** [Float4x4.perspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float): Float4x4 = perspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE)
/** [Float4x4.perspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float, handedness: Handedness, depthRange: DepthRange): Float4x4 = perspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, handedness, depthRange)
/** [Float4x4.perspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float, depthRange: DepthRange): Float4x4 = perspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, Handedness.RIGHT_HANDED, depthRange)
/** [Float4x4.perspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float, handedness: Handedness): Float4x4 = perspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE)
/** [Float4x4.perspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.perspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float): Float4x4 = perspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE)
/** [Float4x4.preRotateAxis] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.preRotateAxis(angle: Angle, axis: Float3): Float4x4 = preRotateAxis(angle.radians.toFloat(), axis)
/** [Float4x4.preRotateX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.preRotateX(angle: Angle): Float4x4 = preRotateX(angle.radians.toFloat())
/** [Float4x4.preRotateY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.preRotateY(angle: Angle): Float4x4 = preRotateY(angle.radians.toFloat())
/** [Float4x4.preRotateZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.preRotateZ(angle: Angle): Float4x4 = preRotateZ(angle.radians.toFloat())
/** [Float4x4.rotateAxis] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateAxis(angle: Angle, axis: Float3): Float4x4 = rotateAxis(angle.radians.toFloat(), axis)
/** [Float4x4.rotateX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateX(angle: Angle): Float4x4 = rotateX(angle.radians.toFloat())
/** [Float4x4.rotateXYZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateXYZ(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = rotateXYZ(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
/** [Float4x4.rotateXZY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateXZY(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = rotateXZY(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
/** [Float4x4.rotateY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateY(angle: Angle): Float4x4 = rotateY(angle.radians.toFloat())
/** [Float4x4.rotateYXZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateYXZ(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = rotateYXZ(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
/** [Float4x4.rotateYZX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateYZX(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = rotateYZX(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
/** [Float4x4.rotateZ] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateZ(angle: Angle): Float4x4 = rotateZ(angle.radians.toFloat())
/** [Float4x4.rotateZXY] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateZXY(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = rotateZXY(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
/** [Float4x4.rotateZYX] taking a type-safe [Angle] in place of the angle in radians. */
inline fun Float4x4.rotateZYX(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = rotateZYX(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
/** [Float4x4.mul] as the `*` operator. */
inline operator fun Float4x4.times(v: Float4): Float4 = mul(v)
/** The element of this Float4x4 in the given row and column, throwing `IndexOutOfBoundsException` when either index is out of range. */
inline operator fun Float4x4.get(row: Int, column: Int): Float {
    if (row < 0 || row >= 4 || column < 0 || column >= 4)
        throw IndexOutOfBoundsException("Float4x4 indices: $row, $column")
    return when (row * 4 + column) {
        0 -> m00()
        1 -> m01()
        2 -> m02()
        3 -> m03()
        4 -> m10()
        5 -> m11()
        6 -> m12()
        7 -> m13()
        8 -> m20()
        9 -> m21()
        10 -> m22()
        11 -> m23()
        12 -> m30()
        13 -> m31()
        14 -> m32()
        15 -> m33()
        else -> throw IndexOutOfBoundsException("Float4x4 indices: $row, $column")
    }
}

// Static make*(… : Angle …) factories. Object-scoped because Kotlin can't
// extend a Java class's static scope, and bare top-level funs would collide by
// return type across the shapes/precisions sharing a name.
object Float4x4Factory {
    /** [Float4x4.makeArcball] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeArcball(radius: Float, center: Float3, angleX: Angle, angleY: Angle): Float4x4 = Float4x4.makeArcball(radius, center, angleX.radians.toFloat(), angleY.radians.toFloat())
    /** [Float4x4.makeObliqueCabinet] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeObliqueCabinet(angle: Angle): Float4x4 = Float4x4.makeObliqueCabinet(angle.radians.toFloat())
    /** [Float4x4.makeObliqueCavalier] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeObliqueCavalier(angle: Angle): Float4x4 = Float4x4.makeObliqueCavalier(angle.radians.toFloat())
    /** [Float4x4.makeObliqueMilitary] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeObliqueMilitary(angle: Angle): Float4x4 = Float4x4.makeObliqueMilitary(angle.radians.toFloat())
    /** [Float4x4.makePerspective] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspective(fovy: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness, depthRange: DepthRange): Float4x4 = Float4x4.makePerspective(fovy.radians.toFloat(), aspect, near, far, handedness, depthRange)
    /** [Float4x4.makePerspective] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspective(fovy: Angle, aspect: Float, near: Float, far: Float, depthRange: DepthRange): Float4x4 = Float4x4.makePerspective(fovy.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, depthRange)
    /** [Float4x4.makePerspective] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspective(fovy: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness): Float4x4 = Float4x4.makePerspective(fovy.radians.toFloat(), aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE)
    /** [Float4x4.makePerspective] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspective(fovy: Angle, aspect: Float, near: Float, far: Float): Float4x4 = Float4x4.makePerspective(fovy.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE)
    /** [Float4x4.makePerspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness, depthRange: DepthRange): Float4x4 = Float4x4.makePerspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, handedness, depthRange)
    /** [Float4x4.makePerspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float, depthRange: DepthRange): Float4x4 = Float4x4.makePerspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, depthRange)
    /** [Float4x4.makePerspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float, handedness: Handedness): Float4x4 = Float4x4.makePerspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE)
    /** [Float4x4.makePerspectiveFovRange] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveFovRange(angleMin: Angle, angleMax: Angle, aspect: Float, near: Float, far: Float): Float4x4 = Float4x4.makePerspectiveFovRange(angleMin.radians.toFloat(), angleMax.radians.toFloat(), aspect, near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE)
    /** [Float4x4.makePerspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float, handedness: Handedness, depthRange: DepthRange): Float4x4 = Float4x4.makePerspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, handedness, depthRange)
    /** [Float4x4.makePerspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float, depthRange: DepthRange): Float4x4 = Float4x4.makePerspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, Handedness.RIGHT_HANDED, depthRange)
    /** [Float4x4.makePerspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float, handedness: Handedness): Float4x4 = Float4x4.makePerspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, handedness, DepthRange.NEGATIVE_ONE_TO_ONE)
    /** [Float4x4.makePerspectiveOffCenterFov] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makePerspectiveOffCenterFov(angleLeft: Angle, angleRight: Angle, angleDown: Angle, angleUp: Angle, near: Float, far: Float): Float4x4 = Float4x4.makePerspectiveOffCenterFov(angleLeft.radians.toFloat(), angleRight.radians.toFloat(), angleDown.radians.toFloat(), angleUp.radians.toFloat(), near, far, Handedness.RIGHT_HANDED, DepthRange.NEGATIVE_ONE_TO_ONE)
    /** [Float4x4.makeRotationAxis] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationAxis(angle: Angle, axis: Float3): Float4x4 = Float4x4.makeRotationAxis(angle.radians.toFloat(), axis)
    /** [Float4x4.makeRotationX] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationX(angle: Angle): Float4x4 = Float4x4.makeRotationX(angle.radians.toFloat())
    /** [Float4x4.makeRotationXYZ] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationXYZ(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = Float4x4.makeRotationXYZ(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
    /** [Float4x4.makeRotationXZY] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationXZY(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = Float4x4.makeRotationXZY(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
    /** [Float4x4.makeRotationY] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationY(angle: Angle): Float4x4 = Float4x4.makeRotationY(angle.radians.toFloat())
    /** [Float4x4.makeRotationYXZ] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationYXZ(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = Float4x4.makeRotationYXZ(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
    /** [Float4x4.makeRotationYZX] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationYZX(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = Float4x4.makeRotationYZX(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
    /** [Float4x4.makeRotationZ] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationZ(angle: Angle): Float4x4 = Float4x4.makeRotationZ(angle.radians.toFloat())
    /** [Float4x4.makeRotationZXY] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationZXY(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = Float4x4.makeRotationZXY(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
    /** [Float4x4.makeRotationZYX] taking a type-safe [Angle] in place of the angle in radians. */
    inline fun makeRotationZYX(angleX: Angle, angleY: Angle, angleZ: Angle): Float4x4 = Float4x4.makeRotationZYX(angleX.radians.toFloat(), angleY.radians.toFloat(), angleZ.radians.toFloat())
}
