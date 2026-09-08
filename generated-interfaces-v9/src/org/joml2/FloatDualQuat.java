package org.joml2;

import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;
import java.nio.ByteBuffer;

/**
 * A dual quaternion of single-precision {@code float} components.
 * <p>
 * Extends the read-only view {@link FloatDualQuatR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface FloatDualQuat extends FloatDualQuatR {

    /**
     * Add {@code other} to this dual quaternion.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default FloatDualQuat add(FloatDualQuatR other) { return add(other, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Add ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ},
     * {@code dW}) to this dual quaternion.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated default FloatDualQuat add(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) { return add(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Multiply each component of this dual quaternion by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default FloatDualQuat mul(float scalar) { return mul(scalar, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Negate this dual quaternion.
     *
     * @return this
     */
    @Mutated default FloatDualQuat negate() { return negate(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Subtract {@code other} from this dual quaternion.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default FloatDualQuat sub(FloatDualQuatR other) { return sub(other, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Subtract ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ},
     * {@code dW}) from this dual quaternion.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated default FloatDualQuat sub(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) { return sub(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set this dual quaternion to the given values.
     *
     * @param v the dual quaternion
     * @return this
     */
    @Mutated FloatDualQuat set(FloatDualQuatR v);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated FloatDualQuat set(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW);

    /**
     * Convert this dual quaternion to {@code double} precision, returning the result as a new
     * instance.
     *
     * @return a new {@code DoubleDualQuat} holding the result
     */
    default DoubleDualQuat toDouble() { return toDouble(Joml.doubleDualQuat()); }

    /**
     * Set this dual quaternion to the rigid motion of the given rigid transform (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param r the rigid transform
     * @return this
     */
    @Mutated FloatDualQuat makeFromRigid(FloatRigidR r);

    /**
     * Set this dual quaternion to the rigid motion of the given rigid transform (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param tX the {@code tX} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param tY the {@code tY} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param tZ the {@code tZ} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param rX the {@code rX} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param rY the {@code rY} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param rZ the {@code rZ} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @param rW the {@code rW} component of the rigid transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW)}
     * @return this
     */
    @Mutated FloatDualQuat makeFromRigid(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW);

    /**
     * Set this dual quaternion to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (dual quaternions cannot represent it).
     *
     * @param t the transform
     * @return this
     */
    @Mutated FloatDualQuat makeFromTransform(FloatTransformR t);

    /**
     * Set this dual quaternion to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (dual quaternions cannot represent it).
     *
     * @param tX the {@code tX} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param tY the {@code tY} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param tZ the {@code tZ} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rX the {@code rX} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rY the {@code rY} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rZ the {@code rZ} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param rW the {@code rW} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param sX the {@code sX} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param sY the {@code sY} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @param sZ the {@code sZ} component of the transform
     *        {@code (tX, tY, tZ, rX, rY, rZ, rW, sX, sY, sZ)}
     * @return this
     */
    @Mutated FloatDualQuat makeFromTransform(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW, float sX, float sY, float sZ);

    /**
     * Set this dual quaternion to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return this
     */
    @Mutated FloatDualQuat makeFromAxisAngle(Float3R axis, float angle, Float3R translation);

    /**
     * Set this dual quaternion to the rotation of {@code angle} radians about the axis
     * ({@code axisX}, {@code axisY}, {@code axisZ}), combined with a translation by
     * ({@code translationX}, {@code translationY}, {@code translationZ}).
     *
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param angle the angle in radians
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated FloatDualQuat makeFromAxisAngle(float axisX, float axisY, float axisZ, float angle, float translationX, float translationY, float translationZ);

    /**
     * Set this dual quaternion to the identity.
     *
     * @return this
     */
    @Mutated FloatDualQuat makeIdentity();

    /**
     * Set this dual quaternion to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return this
     */
    @Mutated FloatDualQuat makeTranslationRotation(Float3R translation, FloatQuatR rotation);

    /**
     * Set this dual quaternion to a rigid transformation that first rotates by ({@code rotationX},
     * {@code rotationY}, {@code rotationZ}, {@code rotationW}) and then translates by
     * ({@code translationX}, {@code translationY}, {@code translationZ}) ({@code T * R}).
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return this
     */
    @Mutated FloatDualQuat makeTranslationRotation(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW);

    /**
     * Set all components of this dual quaternion to zero.
     *
     * @return this
     */
    @Mutated FloatDualQuat makeZero();

    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated FloatDualQuat set(FloatQuatR rotation);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated FloatDualQuat set(float x, float y, float z, float w);

    /**
     * Set this dual quaternion to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated default FloatDualQuat makeRotation(FloatQuatR rotation) { return set(rotation); }

    /**
     * Set this dual quaternion to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated default FloatDualQuat makeRotation(float x, float y, float z, float w) { return set(x, y, z, w); }

    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @param translation the vector
     * @return this
     */
    @Mutated FloatDualQuat set(FloatQuatR rotation, Float3R translation);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated FloatDualQuat set(float rotationX, float rotationY, float rotationZ, float rotationW, float translationX, float translationY, float translationZ);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated FloatDualQuat set(Float3R translation);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated FloatDualQuat set(float x, float y, float z);

    /**
     * Set this dual quaternion to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default FloatDualQuat makeTranslation(Float3R translation) { return set(translation); }

    /**
     * Set this dual quaternion to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default FloatDualQuat makeTranslation(float x, float y, float z) { return set(x, y, z); }

    /**
     * Blend this dual quaternion with {@code other} using dual-quaternion linear blending with the
     * weight {@code t}.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatDualQuat dlb(FloatDualQuatR other, float t) { return dlb(other, t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Blend this dual quaternion with ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX},
     * {@code dY}, {@code dZ}, {@code dW}) using dual-quaternion linear blending with the weight
     * {@code t}.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatDualQuat dlb(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW, float t) { return dlb(rX, rY, rZ, rW, dX, dY, dZ, dW, t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Linearly interpolate between this dual quaternion and {@code other} using the interpolation
     * factor {@code t}.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatDualQuat lerp(FloatDualQuatR other, float t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Linearly interpolate between this dual quaternion and ({@code rX}, {@code rY}, {@code rZ},
     * {@code rW}, {@code dX}, {@code dY}, {@code dZ}, {@code dW}) using the interpolation factor
     * {@code t}.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatDualQuat lerp(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW, float t) { return lerp(rX, rY, rZ, rW, dX, dY, dZ, dW, t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * {@code other} using the interpolation factor {@code t}.
     *
     * @param other the other dual quaternion (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatDualQuat sclerp(FloatDualQuatR other, float t) { return sclerp(other, t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ},
     * {@code dW}) using the interpolation factor {@code t}.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)} (the dual quaternion must have unit length)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatDualQuat sclerp(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW, float t) { return sclerp(rX, rY, rZ, rW, dX, dY, dZ, dW, t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Multiply this dual quaternion by {@code other}.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code Q * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default FloatDualQuat mul(FloatDualQuatR other) { return mul(other, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Multiply this dual quaternion by ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX},
     * {@code dY}, {@code dZ}, {@code dW}).
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code Q * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated default FloatDualQuat mul(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) { return mul(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Pre-multiply {@code other} onto this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code R * Q * v}, the transformation of the operand will be applied
     * last.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default FloatDualQuat preMul(FloatDualQuatR other) { return preMul(other, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Pre-multiply ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY},
     * {@code dZ}, {@code dW}) onto this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the operand, then the new dual
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new dual
     * quaternion by using {@code R * Q * v}, the transformation of the operand will be applied
     * last.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated default FloatDualQuat preMul(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) { return preMul(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Add {@code other} scaled by {@code weight} to this dual quaternion.
     *
     * @param other the other dual quaternion
     * @param weight the factor to scale {@code other} by before adding
     * @return this
     */
    @Mutated default FloatDualQuat addScaled(FloatDualQuatR other, float weight) { return addScaled(other, weight, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Add ({@code rX}, {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ},
     * {@code dW}) scaled by {@code weight} to this dual quaternion.
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param weight the factor to scale ({@code rX}, {@code rY}, {@code rZ}, {@code rW},
     *        {@code dX}, {@code dY}, {@code dZ}, {@code dW}) by before adding
     * @return this
     */
    @Mutated default FloatDualQuat addScaled(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW, float weight) { return addScaled(rX, rY, rZ, rW, dX, dY, dZ, dW, weight, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the quaternion conjugate of this dual quaternion, conjugating both the real and the
     * dual part (for a unit dual quaternion this is its inverse).
     *
     * @return this
     */
    @Mutated default FloatDualQuat conjugate() { return conjugate(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the difference between this dual quaternion and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other}.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default FloatDualQuat difference(FloatDualQuatR other) { return difference(other, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the difference between this dual quaternion and ({@code rX}, {@code rY}, {@code rZ},
     * {@code rW}, {@code dX}, {@code dY}, {@code dZ}, {@code dW}), i.e. the rigid transformation
     * that, applied after {@code this}, results in ({@code rX}, {@code rY}, {@code rZ}, {@code rW},
     * {@code dX}, {@code dY}, {@code dZ}, {@code dW}).
     *
     * @param rX the {@code rX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rY the {@code rY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rZ the {@code rZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param rW the {@code rW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dX the {@code dX} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dY the {@code dY} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dZ the {@code dZ} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @param dW the {@code dW} component of the dual quaternion
     *        {@code (rX, rY, rZ, rW, dX, dY, dZ, dW)}
     * @return this
     */
    @Mutated default FloatDualQuat difference(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW) { return difference(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the dual-number conjugate of this dual quaternion.
     *
     * @return this
     */
    @Mutated default FloatDualQuat dualConjugate() { return dualConjugate(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the exponential of this dual quaternion.
     *
     * @return this
     */
    @Mutated default FloatDualQuat exp() { return exp(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the inverse of this dual quaternion, which is assumed to have unit length.
     *
     * @return this
     */
    @Mutated default FloatDualQuat inverseUnit() { return inverseUnit(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Invert this dual quaternion.
     *
     * @return this
     */
    @Mutated default FloatDualQuat invert() { return invert(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Compute the natural logarithm of this dual quaternion.
     *
     * @return this
     */
    @Mutated default FloatDualQuat log() { return log(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated FloatDualQuat makeFromMatrix(Float4x4R m);

    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated FloatDualQuat makeFromMatrix(Float3x4R m);

    /**
     * Set this dual quaternion to the rotation represented by the given matrix, with zero
     * translation.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated FloatDualQuat makeFromMatrix(Float3x3R m);

    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length.
     *
     * @return this
     */
    @Mutated default FloatDualQuat normalize() { return normalize(Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Raise this dual quaternion to the power of {@code t} (screw-motion power: {@code t = 0}
     * yields the identity, {@code t = 1} yields {@code this}).
     *
     * @param t the exponent
     * @return this
     */
    @Mutated default FloatDualQuat pow(float t) { return pow(t, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set the rotation of this dual quaternion to {@code rotation}.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated default FloatDualQuat setRotation(FloatQuatR rotation) { return setRotation(rotation, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set the rotation of this dual quaternion to ({@code x}, {@code y}, {@code z}, {@code w}).
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated default FloatDualQuat setRotation(float x, float y, float z, float w) { return setRotation(x, y, z, w, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set the translation of this dual quaternion to {@code translation}.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default FloatDualQuat setTranslation(Float3R translation) { return setTranslation(translation, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set the translation of this dual quaternion to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default FloatDualQuat setTranslation(float x, float y, float z) { return setTranslation(x, y, z, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this dual
     * quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    @Mutated default FloatDualQuat lookAlong(Float3R dir, Float3R up) { return lookAlong(dir, up, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code L} the "look along" dual quaternion,
     * then the new dual quaternion will be {@code Q * L}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * L * v}, the "look along" will be applied
     * first.
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated default FloatDualQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) { return lookAlong(dirX, dirY, dirZ, upX, upY, upZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated FloatDualQuat makeRotationAxis(float angle, Float3R axis);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the axis ({@code x},
     * {@code y}, {@code z}).
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated FloatDualQuat makeRotationAxis(float angle, float x, float y, float z);

    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    @Mutated FloatDualQuat makeRotationLookAlong(Float3R dir, Float3R up);

    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated FloatDualQuat makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated FloatDualQuat makeRotationX(float angle);

    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatDualQuat makeRotationXYZ(float angleX, float angleY, float angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatDualQuat makeRotationXZY(float angleX, float angleY, float angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated FloatDualQuat makeRotationY(float angle);

    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatDualQuat makeRotationYXZ(float angleX, float angleY, float angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatDualQuat makeRotationYZX(float angleX, float angleY, float angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated FloatDualQuat makeRotationZ(float angle);

    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatDualQuat makeRotationZXY(float angleX, float angleY, float angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatDualQuat makeRotationZYX(float angleX, float angleY, float angleZ);

    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param rotation the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated default FloatDualQuat rotate(FloatQuatR rotation) { return rotate(rotation, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z}, {@code w})
     * to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)} (the quaternion must
     *        have unit length)
     * @return this
     */
    @Mutated default FloatDualQuat rotate(float x, float y, float z, float w) { return rotate(x, y, z, w, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this dual
     * quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated default FloatDualQuat rotateAxis(float angle, Float3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}) to
     * this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param x the {@code x} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param y the {@code y} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @param z the {@code z} component of the vector {@code (x, y, z)} (the vector must have unit
     *        length)
     * @return this
     */
    @Mutated default FloatDualQuat rotateAxis(float angle, float x, float y, float z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the X axis to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default FloatDualQuat rotateX(float angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default FloatDualQuat rotateXYZ(float angleX, float angleY, float angleZ) { return rotateXYZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default FloatDualQuat rotateXZY(float angleX, float angleY, float angleZ) { return rotateXZY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default FloatDualQuat rotateY(float angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default FloatDualQuat rotateYXZ(float angleX, float angleY, float angleZ) { return rotateYXZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default FloatDualQuat rotateYZX(float angleX, float angleY, float angleZ) { return rotateYZX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default FloatDualQuat rotateZ(float angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default FloatDualQuat rotateZXY(float angleX, float angleY, float angleZ) { return rotateZXY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code R} the rotation dual quaternion, then
     * the new dual quaternion will be {@code Q * R}. So when transforming a vector {@code v} with
     * the new dual quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default FloatDualQuat rotateZYX(float angleX, float angleY, float angleZ) { return rotateZYX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a translation by {@code translation} to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default FloatDualQuat translate(Float3R translation) { return translate(translation, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Apply a translation by ({@code x}, {@code y}, {@code z}) to this dual quaternion.
     * <p>
     * If {@code Q} is {@code this} dual quaternion and {@code T} the translation dual quaternion,
     * then the new dual quaternion will be {@code Q * T}. So when transforming a vector {@code v}
     * with the new dual quaternion by using {@code Q * T * v}, the translation will be applied
     * first.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default FloatDualQuat translate(float x, float y, float z) { return translate(x, y, z, Joml.RETURN_NEW ? Joml.floatDualQuat() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default FloatDualQuat load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated FloatDualQuat load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatDualQuat load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated FloatDualQuat loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 8);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatDualQuat load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated FloatDualQuat loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 32);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated FloatDualQuat loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default FloatDualQuat load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated FloatDualQuat load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatDualQuat load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated FloatDualQuat loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 8);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadDouble(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadDoubleAbsolute(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated FloatDualQuat loadDoubleAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatDualQuat loadDoubleRelative(ByteBuffer src) {
        int pos = src.position();
        loadDoubleAbsolute(pos, src);
        src.position(pos + 64);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated FloatDualQuat loadDoubleUnsafe(long address);
}
