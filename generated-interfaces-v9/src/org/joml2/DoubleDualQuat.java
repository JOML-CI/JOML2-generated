package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * A dual quaternion of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link DoubleDualQuatR} with the mutating surface: in-place
 * self-forms, setters and load methods. A self-form operation writes its result to {@code this} and
 * returns it - unless the {@code joml.returnNew} mode is enabled, in which case it leaves
 * {@code this} unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface DoubleDualQuat extends DoubleDualQuatR {

    /**
     * Add {@code other} to this dual quaternion.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default DoubleDualQuat add(DoubleDualQuatR other) { return add(other, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat add(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW) { return add(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Multiply each component of this dual quaternion by {@code scalar}.
     *
     * @param scalar the scalar value
     * @return this
     */
    @Mutated default DoubleDualQuat mul(double scalar) { return mul(scalar, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Negate this dual quaternion.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat negate() { return negate(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Subtract {@code other} from this dual quaternion.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default DoubleDualQuat sub(DoubleDualQuatR other) { return sub(other, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat sub(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW) { return sub(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set this dual quaternion to the given values.
     *
     * @param v the dual quaternion
     * @return this
     */
    @Mutated DoubleDualQuat set(DoubleDualQuatR v);

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
    @Mutated DoubleDualQuat set(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW);

    /**
     * Convert this dual quaternion to {@code float} precision, returning the result as a new
     * instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatDualQuat} holding the result
     */
    default FloatDualQuat toFloat() { return toFloat(Joml.floatDualQuat()); }

    /**
     * Set this dual quaternion to the rigid motion of the given rigid transform (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param r the rigid transform
     * @return this
     */
    @Mutated DoubleDualQuat makeFromRigid(DoubleRigidR r);

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
    @Mutated DoubleDualQuat makeFromRigid(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW);

    /**
     * Set this dual quaternion to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (dual quaternions cannot represent it).
     *
     * @param t the transform
     * @return this
     */
    @Mutated DoubleDualQuat makeFromTransform(DoubleTransformR t);

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
    @Mutated DoubleDualQuat makeFromTransform(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW, double sX, double sY, double sZ);

    /**
     * Set this dual quaternion to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return this
     */
    @Mutated DoubleDualQuat makeFromAxisAngle(Double3R axis, double angle, Double3R translation);

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
    @Mutated DoubleDualQuat makeFromAxisAngle(double axisX, double axisY, double axisZ, double angle, double translationX, double translationY, double translationZ);

    /**
     * Set this dual quaternion to the identity.
     *
     * @return this
     */
    @Mutated DoubleDualQuat makeIdentity();

    /**
     * Set this dual quaternion to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return this
     */
    @Mutated DoubleDualQuat makeTranslationRotation(Double3R translation, DoubleQuatR rotation);

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
    @Mutated DoubleDualQuat makeTranslationRotation(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW);

    /**
     * Set all components of this dual quaternion to zero.
     *
     * @return this
     */
    @Mutated DoubleDualQuat makeZero();

    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated DoubleDualQuat set(DoubleQuatR rotation);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated DoubleDualQuat set(double x, double y, double z, double w);

    /**
     * Set this dual quaternion to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated default DoubleDualQuat makeRotation(DoubleQuatR rotation) { return set(rotation); }

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
    @Mutated default DoubleDualQuat makeRotation(double x, double y, double z, double w) { return set(x, y, z, w); }

    /**
     * Set this dual quaternion to the given values.
     *
     * @param rotation the quaternion
     * @param translation the vector
     * @return this
     */
    @Mutated DoubleDualQuat set(DoubleQuatR rotation, Double3R translation);

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
    @Mutated DoubleDualQuat set(double rotationX, double rotationY, double rotationZ, double rotationW, double translationX, double translationY, double translationZ);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated DoubleDualQuat set(Double3R translation);

    /**
     * Set this dual quaternion to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated DoubleDualQuat set(double x, double y, double z);

    /**
     * Set this dual quaternion to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default DoubleDualQuat makeTranslation(Double3R translation) { return set(translation); }

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
    @Mutated default DoubleDualQuat makeTranslation(double x, double y, double z) { return set(x, y, z); }

    /**
     * Blend this dual quaternion with {@code other} using dual-quaternion linear blending with the
     * weight {@code t}.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleDualQuat dlb(DoubleDualQuatR other, double t) { return dlb(other, t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat dlb(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW, double t) { return dlb(rX, rY, rZ, rW, dX, dY, dZ, dW, t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Linearly interpolate between this dual quaternion and {@code other} using the interpolation
     * factor {@code t}.
     *
     * @param other the other dual quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleDualQuat lerp(DoubleDualQuatR other, double t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat lerp(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW, double t) { return lerp(rX, rY, rZ, rW, dX, dY, dZ, dW, t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Screw-linearly interpolate between this dual quaternion (which must have unit length) and
     * {@code other} using the interpolation factor {@code t}.
     *
     * @param other the other dual quaternion (must be a unit dual quaternion)
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleDualQuat sclerp(DoubleDualQuatR other, double t) { return sclerp(other, t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat sclerp(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW, double t) { return sclerp(rX, rY, rZ, rW, dX, dY, dZ, dW, t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat mul(DoubleDualQuatR other) { return mul(other, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat mul(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW) { return mul(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat preMul(DoubleDualQuatR other) { return preMul(other, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat preMul(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW) { return preMul(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Add {@code other} scaled by {@code weight} to this dual quaternion.
     *
     * @param other the other dual quaternion
     * @param weight the factor to scale {@code other} by before adding
     * @return this
     */
    @Mutated default DoubleDualQuat addScaled(DoubleDualQuatR other, double weight) { return addScaled(other, weight, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat addScaled(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW, double weight) { return addScaled(rX, rY, rZ, rW, dX, dY, dZ, dW, weight, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Compute the quaternion conjugate of this dual quaternion, conjugating both the real and the
     * dual part (for a unit dual quaternion this is its inverse).
     *
     * @return this
     */
    @Mutated default DoubleDualQuat conjugate() { return conjugate(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Compute the difference between this dual quaternion and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other}.
     *
     * @param other the other dual quaternion
     * @return this
     */
    @Mutated default DoubleDualQuat difference(DoubleDualQuatR other) { return difference(other, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat difference(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW) { return difference(rX, rY, rZ, rW, dX, dY, dZ, dW, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Compute the dual-number conjugate of this dual quaternion.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat dualConjugate() { return dualConjugate(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Compute the exponential of this dual quaternion.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat exp() { return exp(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Compute the inverse of this dual quaternion, which is assumed to have unit length.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat inverseUnit() { return inverseUnit(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Invert this dual quaternion.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat invert() { return invert(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Compute the natural logarithm of this dual quaternion.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat log() { return log(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated DoubleDualQuat makeFromMatrix(Double4x4R m);

    /**
     * Set this dual quaternion to the rigid motion of the given matrix: rotation from its
     * upper-left 3x3 block, which is assumed to be a rotation, and translation from its last
     * column.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated DoubleDualQuat makeFromMatrix(Double3x4R m);

    /**
     * Set this dual quaternion to the rotation represented by the given matrix, with zero
     * translation.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated DoubleDualQuat makeFromMatrix(Double3x3R m);

    /**
     * Normalize this dual quaternion so that its real (rotation) part has unit length.
     *
     * @return this
     */
    @Mutated default DoubleDualQuat normalize() { return normalize(Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Raise this dual quaternion to the power of {@code t} (screw-motion power: {@code t = 0}
     * yields the identity, {@code t = 1} yields {@code this}).
     *
     * @param t the exponent
     * @return this
     */
    @Mutated default DoubleDualQuat pow(double t) { return pow(t, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set the rotation of this dual quaternion to {@code rotation}.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated default DoubleDualQuat setRotation(DoubleQuatR rotation) { return setRotation(rotation, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set the rotation of this dual quaternion to ({@code x}, {@code y}, {@code z}, {@code w}).
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated default DoubleDualQuat setRotation(double x, double y, double z, double w) { return setRotation(x, y, z, w, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set the translation of this dual quaternion to {@code translation}.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default DoubleDualQuat setTranslation(Double3R translation) { return setTranslation(translation, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set the translation of this dual quaternion to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleDualQuat setTranslation(double x, double y, double z) { return setTranslation(x, y, z, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat lookAlong(Double3R dir, Double3R up) { return lookAlong(dir, up, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) { return lookAlong(dirX, dirY, dirZ, upX, upY, upZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationAxis(double angle, Double3R axis);

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
    @Mutated DoubleDualQuat makeRotationAxis(double angle, double x, double y, double z);

    /**
     * Set this dual quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationLookAlong(Double3R dir, Double3R up);

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
    @Mutated DoubleDualQuat makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationX(double angle);

    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationXYZ(double angleX, double angleY, double angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationXZY(double angleX, double angleY, double angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationY(double angle);

    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationYXZ(double angleX, double angleY, double angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationYZX(double angleX, double angleY, double angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationZ(double angle);

    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationZXY(double angleX, double angleY, double angleZ);

    /**
     * Set this dual quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleDualQuat makeRotationZYX(double angleX, double angleY, double angleZ);

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
    @Mutated default DoubleDualQuat rotate(DoubleQuatR rotation) { return rotate(rotation, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotate(double x, double y, double z, double w) { return rotate(x, y, z, w, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateAxis(double angle, Double3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateAxis(double angle, double x, double y, double z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateX(double angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateXYZ(double angleX, double angleY, double angleZ) { return rotateXYZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateXZY(double angleX, double angleY, double angleZ) { return rotateXZY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateY(double angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateYXZ(double angleX, double angleY, double angleZ) { return rotateYXZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateYZX(double angleX, double angleY, double angleZ) { return rotateYZX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateZ(double angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateZXY(double angleX, double angleY, double angleZ) { return rotateZXY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat rotateZYX(double angleX, double angleY, double angleZ) { return rotateZYX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat translate(Double3R translation) { return translate(translation, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

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
    @Mutated default DoubleDualQuat translate(double x, double y, double z) { return translate(x, y, z, Joml.RETURN_NEW ? Joml.doubleDualQuat() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleDualQuat load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleDualQuat load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleDualQuat load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleDualQuat loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadRelative(DoubleBuffer src) {
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
    @Mutated default DoubleDualQuat load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleDualQuat loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 64);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleDualQuat loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleDualQuat load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleDualQuat load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleDualQuat load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleDualQuat loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 8);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleDualQuat loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleDualQuat loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 32);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleDualQuat loadFloatUnsafe(long address);
}
