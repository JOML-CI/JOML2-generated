package org.joml2;

import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;
import java.nio.ByteBuffer;

/**
 * A rigid transform of single-precision {@code float} components.
 * <p>
 * Extends the read-only view {@link FloatRigidR} with the mutating surface: in-place self-forms,
 * setters and load methods. A self-form operation writes its result to {@code this} and returns it
 * - unless the {@code joml.returnNew} mode is enabled, in which case it leaves {@code this}
 * unchanged and returns a freshly allocated instance.
 * <p>
 * Instances are created through the {@link Joml} factory methods.
 */
public interface FloatRigid extends FloatRigidR {

    /**
     * Set this rigid transform to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return this
     */
    @Mutated FloatRigid makeFromAxisAngle(Float3R axis, float angle, Float3R translation);

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
    @Mutated FloatRigid makeFromAxisAngle(float axisX, float axisY, float axisZ, float angle, float translationX, float translationY, float translationZ);

    /**
     * Set this rigid transform to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return this
     */
    @Mutated FloatRigid makeTranslationRotation(Float3R translation, FloatQuatR rotation);

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
    @Mutated FloatRigid makeTranslationRotation(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW);

    /**
     * Set this rigid transform to the given values.
     *
     * @param v the rigid transform
     * @return this
     */
    @Mutated FloatRigid set(FloatRigidR v);

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
    @Mutated FloatRigid set(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW);

    /**
     * Set the rotation of this rigid transform to {@code r}.
     *
     * @param r the quaternion
     * @return this
     */
    @Mutated default FloatRigid setRotation(FloatQuatR r) { return setRotation(r, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Set the rotation of this rigid transform to ({@code x}, {@code y}, {@code z}, {@code w}).
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated default FloatRigid setRotation(float x, float y, float z, float w) { return setRotation(x, y, z, w, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Set the translation of this rigid transform to {@code t}.
     *
     * @param t the translation vector
     * @return this
     */
    @Mutated default FloatRigid setTranslation(Float3R t) { return setTranslation(t, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Set the translation of this rigid transform to ({@code x}, {@code y}, {@code z}).
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated default FloatRigid setTranslation(float x, float y, float z) { return setTranslation(x, y, z, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Set this rigid transform to the rigid motion of the unit dual quaternion {@code dq} (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param dq the dual quaternion
     * @return this
     */
    @Mutated FloatRigid makeFromDualQuat(FloatDualQuatR dq);

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
    @Mutated FloatRigid makeFromDualQuat(float rX, float rY, float rZ, float rW, float dX, float dY, float dZ, float dW);

    /**
     * Set this rigid transform to the rotation extracted from the given matrix, with zero
     * translation (any scale or shear projects onto the nearest rotation).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated FloatRigid makeFromMatrix(Float3x3R m);

    /**
     * Set this rigid transform to the rigid decomposition of the given affine matrix: translation
     * from the last column, rotation from the orthonormalized upper-left 3x3 block (any scale or
     * shear is discarded).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated FloatRigid makeFromMatrix(Float3x4R m);

    /**
     * Set this rigid transform to the rigid decomposition of the given affine matrix: translation
     * from the last column, rotation from the orthonormalized upper-left 3x3 block (any scale or
     * shear is discarded).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated FloatRigid makeFromMatrix(Float4x4R m);

    /**
     * Set this rigid transform to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (a rigid transform cannot represent it).
     *
     * @param t the transform
     * @return this
     */
    @Mutated FloatRigid makeFromTransform(FloatTransformR t);

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
    @Mutated FloatRigid makeFromTransform(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW, float sX, float sY, float sZ);

    /**
     * Convert this rigid transform to {@code double} precision, returning the result as a new
     * instance.
     *
     * @return a new {@code DoubleRigid} holding the result
     */
    default DoubleRigid toDouble() { return toDouble(Joml.doubleRigid()); }

    /**
     * Set this rigid transform to the identity.
     *
     * @return this
     */
    @Mutated FloatRigid makeIdentity();

    /**
     * Set this rigid transform to the given values.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated FloatRigid set(FloatQuatR rotation);

    /**
     * Set this rigid transform to the given values.
     *
     * @param x the {@code x} component of the quaternion {@code (x, y, z, w)}
     * @param y the {@code y} component of the quaternion {@code (x, y, z, w)}
     * @param z the {@code z} component of the quaternion {@code (x, y, z, w)}
     * @param w the {@code w} component of the quaternion {@code (x, y, z, w)}
     * @return this
     */
    @Mutated FloatRigid set(float x, float y, float z, float w);

    /**
     * Set this rigid transform to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param rotation the quaternion
     * @return this
     */
    @Mutated default FloatRigid makeRotation(FloatQuatR rotation) { return set(rotation); }

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
    @Mutated default FloatRigid makeRotation(float x, float y, float z, float w) { return set(x, y, z, w); }

    /**
     * Set this rigid transform to the given values.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated FloatRigid set(Float3R translation);

    /**
     * Set this rigid transform to the given values.
     *
     * @param x the {@code x} component of the vector {@code (x, y, z)}
     * @param y the {@code y} component of the vector {@code (x, y, z)}
     * @param z the {@code z} component of the vector {@code (x, y, z)}
     * @return this
     */
    @Mutated FloatRigid set(float x, float y, float z);

    /**
     * Set this rigid transform to the given values.
     * <p>
     * Alias for {@code set}.
     *
     * @param translation the vector
     * @return this
     */
    @Mutated default FloatRigid makeTranslation(Float3R translation) { return set(translation); }

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
    @Mutated default FloatRigid makeTranslation(float x, float y, float z) { return set(x, y, z); }

    /**
     * Interpolate between this rigid transform and {@code other} using the interpolation factor
     * {@code t}, interpolating the translation linearly and the rotation via shortest-arc slerp.
     *
     * @param other the other rigid transform
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return this
     */
    @Mutated default FloatRigid lerp(FloatRigidR other, float t) { return lerp(other, t, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid lerp(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW, float t) { return lerp(tX, tY, tZ, rX, rY, rZ, rW, t, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid mul(FloatRigidR other) { return mul(other, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid mul(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW) { return mul(tX, tY, tZ, rX, rY, rZ, rW, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid preMul(FloatRigidR other) { return preMul(other, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid preMul(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW) { return preMul(tX, tY, tZ, rX, rY, rZ, rW, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Compute the difference between this rigid transform and {@code other}, i.e. the rigid
     * transformation that, applied after {@code this}, results in {@code other}.
     *
     * @param other the other rigid transform
     * @return this
     */
    @Mutated default FloatRigid difference(FloatRigidR other) { return difference(other, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid difference(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW) { return difference(tX, tY, tZ, rX, rY, rZ, rW, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Invert this rigid transform; exact for any rigid motion (no scale divisions).
     *
     * @return this
     */
    @Mutated default FloatRigid invert() { return invert(Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Normalize this rigid transform so that its rotation part has unit length, leaving its
     * translation unchanged (a zero-length rotation yields the zero quaternion).
     *
     * @return this
     */
    @Mutated default FloatRigid normalize() { return normalize(Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated FloatRigid makeRotationAxis(float angle, Float3R axis);

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
    @Mutated FloatRigid makeRotationAxis(float angle, float x, float y, float z);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated FloatRigid makeRotationX(float angle);

    /**
     * Set this rigid transform to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatRigid makeRotationXYZ(float angleX, float angleY, float angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatRigid makeRotationXZY(float angleX, float angleY, float angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated FloatRigid makeRotationY(float angle);

    /**
     * Set this rigid transform to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatRigid makeRotationYXZ(float angleX, float angleY, float angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatRigid makeRotationYZX(float angleX, float angleY, float angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated FloatRigid makeRotationZ(float angle);

    /**
     * Set this rigid transform to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatRigid makeRotationZXY(float angleX, float angleY, float angleZ);

    /**
     * Set this rigid transform to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated FloatRigid makeRotationZYX(float angleX, float angleY, float angleZ);

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
    @Mutated default FloatRigid rotate(FloatQuatR rotation) { return rotate(rotation, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotate(float x, float y, float z, float w) { return rotate(x, y, z, w, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateAxis(float angle, Float3R axis) { return rotateAxis(angle, axis, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateAxis(float angle, float x, float y, float z) { return rotateAxis(angle, x, y, z, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateX(float angle) { return rotateX(angle, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateXYZ(float angleX, float angleY, float angleZ) { return rotateXYZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateXZY(float angleX, float angleY, float angleZ) { return rotateXZY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateY(float angle) { return rotateY(angle, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateYXZ(float angleX, float angleY, float angleZ) { return rotateYXZ(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateYZX(float angleX, float angleY, float angleZ) { return rotateYZX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateZ(float angle) { return rotateZ(angle, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateZXY(float angleX, float angleY, float angleZ) { return rotateZXY(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid rotateZYX(float angleX, float angleY, float angleZ) { return rotateZYX(angleX, angleY, angleZ, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid translate(Float3R translation) { return translate(translation, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

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
    @Mutated default FloatRigid translate(float x, float y, float z) { return translate(x, y, z, Joml.RETURN_NEW ? Joml.floatRigid() : this); }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default FloatRigid load(float[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated FloatRigid load(float[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatRigid load(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatRigid loadAbsolute(FloatBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated FloatRigid loadAbsolute(int index, FloatBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatRigid loadRelative(FloatBuffer src) {
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
    @Mutated default FloatRigid load(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatRigid loadAbsolute(ByteBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated FloatRigid loadAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatRigid loadRelative(ByteBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 28);
        return this;
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated FloatRigid loadUnsafe(long address);

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return this
     */
    @Mutated default FloatRigid load(double[] src) { return load(src, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return this
     */
    @Mutated FloatRigid load(double[] src, int offset);

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatRigid load(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatRigid loadAbsolute(DoubleBuffer src) { return loadAbsolute(src.position(), src); }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param src the source buffer
     * @return this
     */
    @Mutated FloatRigid loadAbsolute(int index, DoubleBuffer src);

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param src the source buffer
     * @return this
     */
    @Mutated default FloatRigid loadRelative(DoubleBuffer src) {
        int pos = src.position();
        loadAbsolute(pos, src);
        src.position(pos + 7);
        return this;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatRigid loadDouble(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatRigid loadDoubleAbsolute(ByteBuffer src) { return loadDoubleAbsolute(src.position(), src); }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param src the source byte buffer
     * @return this
     */
    @Mutated FloatRigid loadDoubleAbsolute(int index, ByteBuffer src);

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param src the source byte buffer
     * @return this
     */
    @Mutated default FloatRigid loadDoubleRelative(ByteBuffer src) {
        int pos = src.position();
        loadDoubleAbsolute(pos, src);
        src.position(pos + 56);
        return this;
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    @Mutated FloatRigid loadDoubleUnsafe(long address);
}
