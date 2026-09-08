package org.joml2;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteBuffer;

/**
 * A rigid transform of double-precision {@code double} components.
 * <p>
 * Extends the read-only view {@link DoubleRigidR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface DoubleRigid extends DoubleRigidR {

    /**
     * Set this rigid transform to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return this
     */
    @Mutated DoubleRigid makeFromAxisAngle(Double3R axis, double angle, Double3R translation);

    /**
     * Set this rigid transform to the rotation of {@code angle} radians about the axis
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
    @Mutated DoubleRigid makeFromAxisAngle(double axisX, double axisY, double axisZ, double angle, double translationX, double translationY, double translationZ);

    /**
     * Set this rigid transform to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return this
     */
    @Mutated DoubleRigid makeTranslationRotation(Double3R translation, DoubleQuatR rotation);

    /**
     * Set this rigid transform to a rigid transformation that first rotates by ({@code rotationX},
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
    @Mutated DoubleRigid makeTranslationRotation(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW);

    /**
     * Set this rigid transform to the given values.
     *
     * @param v the rigid transform
     * @return this
     */
    @Mutated DoubleRigid set(DoubleRigidR v);

    /**
     * Set this rigid transform to the given values.
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
    @Mutated DoubleRigid set(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW);

    /**
     * Set the rotation of this rigid transform to {@code r}.
     *
     * @param r the quaternion
     * @return this
     */
    @Mutated default DoubleRigid setRotation(DoubleQuatR r) { return setRotation(r, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Set the rotation of this rigid transform to ({@code x}, {@code y}, {@code z}, {@code w}).
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated default DoubleRigid setRotation(double x, double y, double z, double w) { return setRotation(x, y, z, w, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Set the translation of this rigid transform to {@code t}.
     *
     * @param t the translation vector
     * @return this
     */
    @Mutated default DoubleRigid setTranslation(Double3R t) { return setTranslation(t, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Set the translation of this rigid transform to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleRigid setTranslation(double x, double y, double z) { return setTranslation(x, y, z, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Set this rigid transform to the rigid motion of the unit dual quaternion {@code dq} (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param dq the dual quaternion
     * @return this
     */
    @Mutated DoubleRigid makeFromDualQuat(DoubleDualQuatR dq);

    /**
     * Set this rigid transform to the rigid motion of the unit dual quaternion ({@code rX},
     * {@code rY}, {@code rZ}, {@code rW}, {@code dX}, {@code dY}, {@code dZ}, {@code dW}) (an exact
     * conversion - both represent rotation plus translation).
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
    @Mutated DoubleRigid makeFromDualQuat(double rX, double rY, double rZ, double rW, double dX, double dY, double dZ, double dW);

    /**
     * Set this rigid transform to the rotation extracted from the given matrix, with zero
     * translation (any scale or shear projects onto the nearest rotation).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated DoubleRigid makeFromMatrix(Double3x3R m);

    /**
     * Set this rigid transform to the rigid decomposition of the given affine matrix: translation
     * from the last column, rotation from the orthonormalized upper-left 3x3 block (any scale or
     * shear is discarded).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated DoubleRigid makeFromMatrix(Double3x4R m);

    /**
     * Set this rigid transform to the rigid decomposition of the given affine matrix: translation
     * from the last column, rotation from the orthonormalized upper-left 3x3 block (any scale or
     * shear is discarded).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated DoubleRigid makeFromMatrix(Double4x4R m);

    /**
     * Set this rigid transform to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (a rigid transform cannot represent it).
     *
     * @param t the transform
     * @return this
     */
    @Mutated DoubleRigid makeFromTransform(DoubleTransformR t);

    /**
     * Set this rigid transform to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (a rigid transform cannot represent it).
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
    @Mutated DoubleRigid makeFromTransform(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW, double sX, double sY, double sZ);

    /**
     * Convert this rigid transform to {@code float} precision, returning the result as a new
     * instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatRigid} holding the result
     */
    default FloatRigid toFloat() { return toFloat(Joml.floatRigid()); }

    /**
     * Set this rigid transform to the identity.
     *
     * @return this
     */
    @Mutated DoubleRigid makeIdentity();

    /**
     * Set this rigid transform to the given values.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated DoubleRigid set(DoubleQuatR rotation);

    /**
     * Set this rigid transform to the given values.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated DoubleRigid set(double x, double y, double z, double w);

    /**
     * Set this rigid transform to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated default DoubleRigid makeRotation(DoubleQuatR rotation) { return set(rotation); }

    /**
     * Set this rigid transform to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated default DoubleRigid makeRotation(double x, double y, double z, double w) { return set(x, y, z, w); }

    /**
     * Set this rigid transform to the given values.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated DoubleRigid set(Double3R translation);

    /**
     * Set this rigid transform to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated DoubleRigid set(double x, double y, double z);

    /**
     * Set this rigid transform to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default DoubleRigid makeTranslation(Double3R translation) { return set(translation); }

    /**
     * Set this rigid transform to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleRigid makeTranslation(double x, double y, double z) { return set(x, y, z); }

    /**
     * Interpolate between this rigid transform and {@code other} using the interpolation factor
     * {@code t}, interpolating the translation linearly and the rotation via shortest-arc slerp.
     *
     * @param other the other rigid transform
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleRigid lerp(DoubleRigidR other, double t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Interpolate between this rigid transform and ({@code tX}, {@code tY}, {@code tZ}, {@code rX},
     * {@code rY}, {@code rZ}, {@code rW}) using the interpolation factor {@code t}, interpolating
     * the translation linearly and the rotation via shortest-arc slerp.
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
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default DoubleRigid lerp(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW, double t) { return lerp(tX, tY, tZ, rX, rY, rZ, rW, t, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Multiply this rigid transform by {@code other}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code M * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param other the other rigid transform
     * @return this
     */
    @Mutated default DoubleRigid mul(DoubleRigidR other) { return mul(other, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Multiply this rigid transform by ({@code tX}, {@code tY}, {@code tZ}, {@code rX}, {@code rY},
     * {@code rZ}, {@code rW}).
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code M * R * v}, the transformation of the operand will be applied
     * first.
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
    @Mutated default DoubleRigid mul(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW) { return mul(tX, tY, tZ, rX, rY, rZ, rW, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Pre-multiply {@code other} onto this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code R * M}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code R * M * v}, the transformation of the operand will be applied last.
     *
     * @param other the other rigid transform
     * @return this
     */
    @Mutated default DoubleRigid preMul(DoubleRigidR other) { return preMul(other, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Pre-multiply ({@code tX}, {@code tY}, {@code tZ}, {@code rX}, {@code rY}, {@code rZ},
     * {@code rW}) onto this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code R * M}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code R * M * v}, the transformation of the operand will be applied last.
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
    @Mutated default DoubleRigid preMul(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW) { return preMul(tX, tY, tZ, rX, rY, rZ, rW, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Compute the difference between this rigid transform and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other}.
     *
     * @param other the other rigid transform
     * @return this
     */
    @Mutated default DoubleRigid difference(DoubleRigidR other) { return difference(other, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Compute the difference between this rigid transform and ({@code tX}, {@code tY}, {@code tZ},
     * {@code rX}, {@code rY}, {@code rZ}, {@code rW}), i.e. the rigid transformation that, applied
     * after {@code this}, results in ({@code tX}, {@code tY}, {@code tZ}, {@code rX}, {@code rY},
     * {@code rZ}, {@code rW}).
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
    @Mutated default DoubleRigid difference(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW) { return difference(tX, tY, tZ, rX, rY, rZ, rW, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Invert this rigid transform; exact for any rigid motion (no scale divisions).
     *
     * @return this
     */
    @Mutated default DoubleRigid invert() { return invert(Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Normalize this rigid transform so that its rotation part has unit length, leaving its
     * translation unchanged (a zero-length rotation yields the zero quaternion).
     *
     * @return this
     */
    @Mutated default DoubleRigid normalize() { return normalize(Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated DoubleRigid makeRotationAxis(double angle, Double3R axis);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the axis ({@code x},
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
    @Mutated DoubleRigid makeRotationAxis(double angle, double x, double y, double z);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated DoubleRigid makeRotationX(double angle);

    /**
     * Set this rigid transform to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleRigid makeRotationXYZ(double angleX, double angleY, double angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleRigid makeRotationXZY(double angleX, double angleY, double angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated DoubleRigid makeRotationY(double angle);

    /**
     * Set this rigid transform to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleRigid makeRotationYXZ(double angleX, double angleY, double angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleRigid makeRotationYZX(double angleX, double angleY, double angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated DoubleRigid makeRotationZ(double angle);

    /**
     * Set this rigid transform to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleRigid makeRotationZXY(double angleX, double angleY, double angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated DoubleRigid makeRotationZYX(double angleX, double angleY, double angleZ);

    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param rotation the quaternion (must be a unit quaternion)
     * @return this
     */
    @Mutated default DoubleRigid rotate(DoubleQuatR rotation) { return rotate(rotation, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply the rotation represented by the quaternion ({@code x}, {@code y}, {@code z}, {@code w})
     * to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
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
    @Mutated default DoubleRigid rotate(double x, double y, double z, double w) { return rotate(x, y, z, w, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this rigid
     * transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated default DoubleRigid rotateAxis(double angle, Double3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code x}, {@code y}, {@code z}) to
     * this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
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
    @Mutated default DoubleRigid rotateAxis(double angle, double x, double y, double z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the X axis to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default DoubleRigid rotateX(double angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default DoubleRigid rotateXYZ(double angleX, double angleY, double angleZ) { return rotateXYZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default DoubleRigid rotateXZY(double angleX, double angleY, double angleZ) { return rotateXZY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default DoubleRigid rotateY(double angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default DoubleRigid rotateYXZ(double angleX, double angleY, double angleZ) { return rotateYXZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default DoubleRigid rotateYZX(double angleX, double angleY, double angleZ) { return rotateYZX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated default DoubleRigid rotateZ(double angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default DoubleRigid rotateZXY(double angleX, double angleY, double angleZ) { return rotateZXY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated default DoubleRigid rotateZYX(double angleX, double angleY, double angleZ) { return rotateZYX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a translation by {@code translation} to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code T} the translation rigid transform,
     * then the new rigid transform will be {@code M * T}. So when transforming a vector {@code v}
     * with the new rigid transform by using {@code M * T * v}, the translation will be applied
     * first.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default DoubleRigid translate(Double3R translation) { return translate(translation, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Apply a translation by ({@code x}, {@code y}, {@code z}) to this rigid transform.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code T} the translation rigid transform,
     * then the new rigid transform will be {@code M * T}. So when transforming a vector {@code v}
     * with the new rigid transform by using {@code M * T * v}, the translation will be applied
     * first.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default DoubleRigid translate(double x, double y, double z) { return translate(x, y, z, Joml.RETURN_NEW ? Joml.doubleRigid() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleRigid load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleRigid load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRigid load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRigid loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleRigid loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRigid loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 7);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRigid load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRigid loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleRigid loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRigid loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 56);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleRigid loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default DoubleRigid load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated DoubleRigid load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRigid load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRigid loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated DoubleRigid loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default DoubleRigid loadRelative(FloatBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 7);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRigid loadFloat(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRigid loadFloatAbsolute(ByteBuffer src) { return loadFloatAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated DoubleRigid loadFloatAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default DoubleRigid loadFloatRelative(ByteBuffer src) {
        int pos = src.position();
        loadFloatAbsolute(pos, src);
        src.position(pos + 28);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated DoubleRigid loadFloatUnsafe(long address);
}
