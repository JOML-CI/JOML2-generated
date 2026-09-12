package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable rigid transform of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Float.floatToIntBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
 * NaN. {@code hashCode} is consistent with it (derived from the same bit patterns).
 * <p>
 * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
 * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and a
 * NaN component never compares equal to anything.
 *
 * @param tX the {@code tX} component
 * @param tY the {@code tY} component
 * @param tZ the {@code tZ} component
 * @param rX the {@code rX} component
 * @param rY the {@code rY} component
 * @param rZ the {@code rZ} component
 * @param rW the {@code rW} component
 */
public record FloatRigid(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 28;

    /** Canonical constructor. */
    public FloatRigid(float tX, float tY, float tZ, float rX, float rY, float rZ, float rW) {
        this.tX = tX;
        this.tY = tY;
        this.tZ = tZ;
        this.rX = rX;
        this.rY = rY;
        this.rZ = rZ;
        this.rW = rW;
    }

    /**
     * Create a new instance initialized to the identity transform.
     */
    public FloatRigid() {
        this(0, 0, 0, 0, 0, 0, 1);
    }

    /** {@return the {@code tX} component} */
    public float tX() { return tX; }
    /** {@return the {@code tY} component} */
    public float tY() { return tY; }
    /** {@return the {@code tZ} component} */
    public float tZ() { return tZ; }
    /** {@return the {@code rX} component} */
    public float rX() { return rX; }
    /** {@return the {@code rY} component} */
    public float rY() { return rY; }
    /** {@return the {@code rZ} component} */
    public float rZ() { return rZ; }
    /** {@return the {@code rW} component} */
    public float rW() { return rW; }


    /**
     * Create the rotation of {@code angle} radians about the axis {@code axis}, combined with a
     * translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromAxisAngle(Float3 axis, float angle, Float3 translation) {
        return makeFromAxisAngle(axis.x(), axis.y(), axis.z(), angle, translation.x(), translation.y(), translation.z());
    }


    /**
     * Create the rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}), combined with a translation by ({@code translationX}, {@code translationY},
     * {@code translationZ}).
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
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromAxisAngle(float axisX, float axisY, float axisZ, float angle, float translationX, float translationY, float translationZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        return new FloatRigid(translationX, translationY, translationZ, axisX * _t1, axisY * _t1, axisZ * _t1, (float) Math.cos(_t0));
    }


    /**
     * Create a rigid transformation that first rotates by {@code rotation} and then translates by
     * {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return the resulting rigid transform
     */
    public static FloatRigid makeTranslationRotation(Float3 translation, FloatQuat rotation) {
        return makeTranslationRotation(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Create a rigid transformation that first rotates by ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) and then translates by ({@code translationX},
     * {@code translationY}, {@code translationZ}) ({@code T * R}).
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
     * @return the resulting rigid transform
     */
    public static FloatRigid makeTranslationRotation(float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW) {
        return new FloatRigid(translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW);
    }


    /**
     * Create a new rigid transform from the given values.
     *
     * @param v the rigid transform
     * @return the resulting rigid transform
     */
    public FloatRigid set(FloatRigid v) {
        return set(v.tX(), v.tY(), v.tZ(), v.rX(), v.rY(), v.rZ(), v.rW());
    }


    /**
     * Create a new rigid transform from the given values.
     *
     * @param vTX the {@code tX} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @param vTY the {@code tY} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @param vTZ the {@code tZ} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @param vRX the {@code rX} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @param vRY the {@code rY} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @param vRZ the {@code rZ} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @param vRW the {@code rW} component of the rigid transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW)}
     * @return the resulting rigid transform
     */
    public FloatRigid set(float vTX, float vTY, float vTZ, float vRX, float vRY, float vRZ, float vRW) {
        return new FloatRigid(vTX, vTY, vTZ, vRX, vRY, vRZ, vRW);
    }


    /**
     * Set the rotation of this rigid transform to {@code r}, returning the result as a value.
     *
     * @param r the quaternion
     * @return the resulting rigid transform
     */
    public FloatRigid setRotation(FloatQuat r) {
        return setRotation(r.x(), r.y(), r.z(), r.w());
    }


    /**
     * Set the rotation of this rigid transform to ({@code rX}, {@code rY}, {@code rZ}, {@code rW}),
     * returning the result as a value.
     *
     * @param rX the {@code x} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rY the {@code y} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rZ the {@code z} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rW the {@code w} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @return the resulting rigid transform
     */
    public FloatRigid setRotation(float rX, float rY, float rZ, float rW) {
        return new FloatRigid(this.tX, this.tY, this.tZ, rX, rY, rZ, rW);
    }


    /**
     * Set the translation of this rigid transform to {@code t}, returning the result as a value.
     *
     * @param t the translation vector
     * @return the resulting rigid transform
     */
    public FloatRigid setTranslation(Float3 t) {
        return setTranslation(t.x(), t.y(), t.z());
    }


    /**
     * Set the translation of this rigid transform to ({@code tX}, {@code tY}, {@code tZ}),
     * returning the result as a value.
     *
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @return the resulting rigid transform
     */
    public FloatRigid setTranslation(float tX, float tY, float tZ) {
        return new FloatRigid(tX, tY, tZ, this.rX, this.rY, this.rZ, this.rW);
    }


    /**
     * Create the rigid motion of the unit dual quaternion {@code dq} (an exact conversion - both
     * represent rotation plus translation).
     *
     * @param dq the dual quaternion
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromDualQuat(FloatDualQuat dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Create the rigid motion of the unit dual quaternion ({@code dqRX}, {@code dqRY},
     * {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ}, {@code dqDW}) (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param dqRX the {@code rX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqRY the {@code rY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqRZ the {@code rZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqRW the {@code rW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDX the {@code dX} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDY the {@code dY} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDZ the {@code dZ} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @param dqDW the {@code dW} component of the dual quaternion
     *        {@code (dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW)}
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        return new FloatRigid(2.0f * (Math.fma(dqRY, dqDZ, -(dqRZ * dqDY)) + Math.fma(dqRW, dqDX, -(dqRX * dqDW))), 2.0f * (Math.fma(dqRZ, dqDX, -(dqRX * dqDZ)) + Math.fma(dqRW, dqDY, -(dqRY * dqDW))), 2.0f * (Math.fma(dqRX, dqDY, -(dqRY * dqDX)) + Math.fma(dqRW, dqDZ, -(dqRZ * dqDW))), dqRX, dqRY, dqRZ, dqRW);
    }


    /**
     * Create the rotation extracted from the given matrix, with zero translation (scale is removed
     * by normalizing the columns, but shear is not removed: a sheared block yields a rotation
     * quaternion that is not unit length).
     *
     * @param m the matrix
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromMatrix(Float3x3 m) {
        float _t0 = -m.m11();
        float _t1 = -m.m22();
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(m.m21(), m.m21(), Math.fma(m.m01(), m.m01(), m.m11() * m.m11()))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(m.m22(), m.m22(), Math.fma(m.m02(), m.m02(), m.m12() * m.m12()))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(m.m20(), m.m20(), Math.fma(m.m00(), m.m00(), m.m10() * m.m10()))));
        float _t15 = m.m10() * _t14;
        float _t16 = m.m22() * _t13;
        float _t17 = m.m12() * _t13;
        float _t18 = m.m20() * _t14;
        float _t20 = m.m21() * _t12;
        float _t21 = m.m11() * _t12;
        float _t23 = m.m00() * _t14;
        float _t28 = Math.fma(m.m12(), _t13, _t20);
        float _t32 = Math.fma(m.m21(), _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), m.m01() * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), m.m02() * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(m.m01(), _t12, _t45);
        float _t52 = Math.fma(m.m02(), _t13, _t46);
        float _t53 = Math.fma(m.m02(), _t13, -_t46);
        float _t54 = Math.fma(-m.m01(), _t12, _t45);
        float _t59 = Math.fma(m.m11(), _t12, Math.fma(m.m22(), _t13, _t44));
        float _t60 = Math.fma(m.m11(), _t12, Math.fma(m.m22(), _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(m.m11(), _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(m.m22(), _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t32 * _t61, 0.5f * _t53 * _t61, 0.5f * _t54 * _t61, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * (float) Math.sqrt(_t64), 0.5f * _t51 * _t67, 0.5f * _t52 * _t67, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t51 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t28 * _t65, 0.5f * _t53 * _t65);
                } else {
                    return new FloatRigid(0.0f, 0.0f, 0.0f, 0.5f * _t52 * _t66, 0.5f * _t28 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t54 * _t66);
                }
            }
        }
    }


    /**
     * Create the rigid decomposition of the given affine matrix: translation from the last column,
     * rotation from the column-normalized upper-left 3x3 block (scale is removed by normalizing the
     * columns, but shear is not removed: a sheared block yields a rotation quaternion that is not
     * unit length).
     *
     * @param m the matrix
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromMatrix(Float3x4 m) {
        float _t0 = -m.m11();
        float _t1 = -m.m22();
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(m.m21(), m.m21(), Math.fma(m.m01(), m.m01(), m.m11() * m.m11()))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(m.m22(), m.m22(), Math.fma(m.m02(), m.m02(), m.m12() * m.m12()))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(m.m20(), m.m20(), Math.fma(m.m00(), m.m00(), m.m10() * m.m10()))));
        float _t15 = m.m10() * _t14;
        float _t16 = m.m22() * _t13;
        float _t17 = m.m12() * _t13;
        float _t18 = m.m20() * _t14;
        float _t20 = m.m21() * _t12;
        float _t21 = m.m11() * _t12;
        float _t23 = m.m00() * _t14;
        float _t28 = Math.fma(m.m12(), _t13, _t20);
        float _t32 = Math.fma(m.m21(), _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), m.m01() * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), m.m02() * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(m.m01(), _t12, _t45);
        float _t52 = Math.fma(m.m02(), _t13, _t46);
        float _t53 = Math.fma(m.m02(), _t13, -_t46);
        float _t54 = Math.fma(-m.m01(), _t12, _t45);
        float _t59 = Math.fma(m.m11(), _t12, Math.fma(m.m22(), _t13, _t44));
        float _t60 = Math.fma(m.m11(), _t12, Math.fma(m.m22(), _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(m.m11(), _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(m.m22(), _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * _t32 * _t61, 0.5f * _t53 * _t61, 0.5f * _t54 * _t61, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * (float) Math.sqrt(_t64), 0.5f * _t51 * _t67, 0.5f * _t52 * _t67, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * _t51 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t28 * _t65, 0.5f * _t53 * _t65);
                } else {
                    return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * _t52 * _t66, 0.5f * _t28 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t54 * _t66);
                }
            }
        }
    }


    /**
     * Create the rigid decomposition of the given affine matrix: translation from the last column,
     * rotation from the column-normalized upper-left 3x3 block (scale is removed by normalizing the
     * columns, but shear is not removed: a sheared block yields a rotation quaternion that is not
     * unit length).
     *
     * @param m the matrix
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromMatrix(Float4x4 m) {
        float _t0 = -m.m11();
        float _t1 = -m.m22();
        float _t12 = (1.0f / (float) Math.sqrt(Math.fma(m.m21(), m.m21(), Math.fma(m.m01(), m.m01(), m.m11() * m.m11()))));
        float _t13 = (1.0f / (float) Math.sqrt(Math.fma(m.m22(), m.m22(), Math.fma(m.m02(), m.m02(), m.m12() * m.m12()))));
        float _t14 = (1.0f / (float) Math.sqrt(Math.fma(m.m20(), m.m20(), Math.fma(m.m00(), m.m00(), m.m10() * m.m10()))));
        float _t15 = m.m10() * _t14;
        float _t16 = m.m22() * _t13;
        float _t17 = m.m12() * _t13;
        float _t18 = m.m20() * _t14;
        float _t20 = m.m21() * _t12;
        float _t21 = m.m11() * _t12;
        float _t23 = m.m00() * _t14;
        float _t28 = Math.fma(m.m12(), _t13, _t20);
        float _t32 = Math.fma(m.m21(), _t12, -_t17);
        float _t33 = Math.max(_t21, _t16);
        float _t43 = Math.fma(-Math.fma(_t15, _t16, -(_t17 * _t18)), m.m01() * _t12, Math.fma(Math.fma(_t15, _t20, -(_t21 * _t18)), m.m02() * _t13, Math.fma(_t21, _t16, -(_t17 * _t20)) * _t23));
        float _t44, _t45, _t46;
        if (_t43 < 0.0f) {
            _t44 = -_t23;
            _t45 = -_t15;
            _t46 = -_t18;
        } else {
            _t44 = _t23;
            _t45 = _t15;
            _t46 = _t18;
        }
        float _t48 = 1.0f + _t44;
        float _t49 = 1.0f - _t44;
        float _t51 = Math.fma(m.m01(), _t12, _t45);
        float _t52 = Math.fma(m.m02(), _t13, _t46);
        float _t53 = Math.fma(m.m02(), _t13, -_t46);
        float _t54 = Math.fma(-m.m01(), _t12, _t45);
        float _t59 = Math.fma(m.m11(), _t12, Math.fma(m.m22(), _t13, _t44));
        float _t60 = Math.fma(m.m11(), _t12, Math.fma(m.m22(), _t13, _t48));
        float _t61 = (1.0f / (float) Math.sqrt(_t60));
        float _t62 = Math.fma(m.m11(), _t12, Math.fma(_t1, _t13, _t49));
        float _t63 = Math.fma(m.m22(), _t13, Math.fma(_t0, _t12, _t49));
        float _t64 = Math.fma(_t0, _t12, Math.fma(_t1, _t13, _t48));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t64));
        if (_t59 > 0.0f) {
            return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * _t32 * _t61, 0.5f * _t53 * _t61, 0.5f * _t54 * _t61, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t44 > _t33) {
                return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * (float) Math.sqrt(_t64), 0.5f * _t51 * _t67, 0.5f * _t52 * _t67, 0.5f * _t32 * _t67);
            } else {
                if (_t21 > _t16) {
                    return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * _t51 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t28 * _t65, 0.5f * _t53 * _t65);
                } else {
                    return new FloatRigid(m.m03(), m.m13(), m.m23(), 0.5f * _t52 * _t66, 0.5f * _t28 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t54 * _t66);
                }
            }
        }
    }


    /**
     * Create the rigid motion (rotation and translation) of the given transform; the scale is
     * dropped (a rigid transform cannot represent it).
     *
     * @param t the transform
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromTransform(FloatTransform t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Create the rigid motion (rotation and translation) of the given transform; the scale is
     * dropped (a rigid transform cannot represent it).
     *
     * @param tTX the {@code tX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tTY the {@code tY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tTZ the {@code tZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRX the {@code rX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRY the {@code rY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRZ the {@code rZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tRW the {@code rW} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSX the {@code sX} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSY the {@code sY} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @param tSZ the {@code sZ} component of the transform
     *        {@code (tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ)}
     * @return the resulting rigid transform
     */
    public static FloatRigid makeFromTransform(float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        return new FloatRigid(tTX, tTY, tTZ, tRX, tRY, tRZ, tRW);
    }


    /**
     * Convert this rigid transform to {@code double} precision, returning the result as a new
     * instance.
     *
     * @return a new {@code DoubleRigid} holding the result
     */
    public DoubleRigid toDouble() {
        return new DoubleRigid(this.tX, this.tY, this.tZ, this.rX, this.rY, this.rZ, this.rW);
    }


    /**
     * Convert this rigid transform to a unit dual quaternion encoding the same rigid motion (an
     * exact conversion), returning the result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat toDualQuat() {
        float _t0 = -this.tZ;
        return new FloatDualQuat(this.rX, this.rY, this.rZ, this.rW, 0.5f * Math.fma(_t0, this.rY, Math.fma(this.tX, this.rW, this.tY * this.rZ)), 0.5f * Math.fma(this.tZ, this.rX, Math.fma(this.tY, this.rW, -(this.tX * this.rZ))), 0.5f * Math.fma(this.tZ, this.rW, Math.fma(this.tX, this.rY, -(this.tY * this.rX))), 0.5f * Math.fma(_t0, this.rZ, Math.fma(-this.tY, this.rY, -(this.tX * this.rX))));
    }


    /**
     * Compute the matrix representation of this rigid transform (whose rotation must be a unit
     * quaternion), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float4x4 toMatrix() {
        float _t0 = this.rZ * this.rZ;
        float _t1 = this.rZ * this.rW;
        float _t2 = this.rY * this.rW;
        return new Float4x4(Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f), 2.0f * Math.fma(this.rX, this.rY, -_t1), 2.0f * Math.fma(this.rX, this.rZ, _t2), this.tX, 2.0f * Math.fma(this.rX, this.rY, _t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f), 2.0f * Math.fma(this.rY, this.rZ, -(this.rX * this.rW)), this.tY, 2.0f * Math.fma(this.rX, this.rZ, -_t2), 2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f), this.tZ, 0.0f, 0.0f, 0.0f, 1.0f, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Compute the 3x3 matrix representation of the rotation of this rigid transform (whose rotation
     * must be a unit quaternion; the translation is dropped), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x3 toMatrix3x3() {
        float _t0 = this.rZ * this.rZ;
        float _t1 = this.rZ * this.rW;
        float _t2 = this.rY * this.rW;
        return new Float3x3(Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f), 2.0f * Math.fma(this.rX, this.rY, -_t1), 2.0f * Math.fma(this.rX, this.rZ, _t2), 2.0f * Math.fma(this.rX, this.rY, _t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f), 2.0f * Math.fma(this.rY, this.rZ, -(this.rX * this.rW)), 2.0f * Math.fma(this.rX, this.rZ, -_t2), 2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f), 0);
    }


    /**
     * Compute the 3x4 matrix representation of this rigid transform (whose rotation must be a unit
     * quaternion; the omitted last row is implicitly {@code 0, 0, 0, 1}), returning the result as a
     * value.
     *
     * @return the resulting matrix
     */
    public Float3x4 toMatrix3x4() {
        float _t0 = this.rZ * this.rZ;
        float _t1 = this.rZ * this.rW;
        float _t2 = this.rY * this.rW;
        return new Float3x4(Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f), 2.0f * Math.fma(this.rX, this.rY, -_t1), 2.0f * Math.fma(this.rX, this.rZ, _t2), this.tX, 2.0f * Math.fma(this.rX, this.rY, _t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f), 2.0f * Math.fma(this.rY, this.rZ, -(this.rX * this.rW)), this.tY, 2.0f * Math.fma(this.rX, this.rZ, -_t2), 2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f), this.tZ, Joml.BIT_ORTHOGONAL);
    }


    /**
     * Widen this rigid transform to a TRS transform (same translation and rotation, scale = 1),
     * returning the result as a value.
     *
     * @return the resulting transform
     */
    public FloatTransform toTransform() {
        return new FloatTransform(this.tX, this.tY, this.tZ, this.rX, this.rY, this.rZ, this.rW, 1.0f, 1.0f, 1.0f);
    }


    /**
     * Create an identity rigid transform.
     *
     * @return the resulting rigid transform
     */
    public static FloatRigid makeIdentity() {
        return new FloatRigid(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f);
    }


    /**
     * Create a new rigid transform representing a pure rotation by {@code rotation} (zero
     * translation).
     *
     * @param rotation the quaternion
     * @return the resulting rigid transform
     */
    public FloatRigid set(FloatQuat rotation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Create a new rigid transform representing a pure rotation by ({@code rotationX},
     * {@code rotationY}, {@code rotationZ}, {@code rotationW}) (zero translation).
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return the resulting rigid transform
     */
    public FloatRigid set(float rotationX, float rotationY, float rotationZ, float rotationW) {
        return new FloatRigid(0.0f, 0.0f, 0.0f, rotationX, rotationY, rotationZ, rotationW);
    }


    /**
     * Create a new rigid transform representing a pure rotation by {@code rotation} (zero
     * translation).
     * <p>
     * Alias for {@code set}.
     *
     * @param rotation the quaternion
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotation(FloatQuat rotation) {
        return makeRotation(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Create a new rigid transform representing a pure rotation by ({@code rotationX},
     * {@code rotationY}, {@code rotationZ}, {@code rotationW}) (zero translation).
     * <p>
     * Alias for {@code set}.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)}
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotation(float rotationX, float rotationY, float rotationZ, float rotationW) {
        return new FloatRigid(0.0f, 0.0f, 0.0f, rotationX, rotationY, rotationZ, rotationW);
    }


    /**
     * Create a new rigid transform representing a pure translation by {@code translation} (identity
     * rotation).
     *
     * @param translation the vector
     * @return the resulting rigid transform
     */
    public FloatRigid set(Float3 translation) {
        return set(translation.x(), translation.y(), translation.z());
    }


    /**
     * Create a new rigid transform representing a pure translation by ({@code translationX},
     * {@code translationY}, {@code translationZ}) (identity rotation).
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return the resulting rigid transform
     */
    public FloatRigid set(float translationX, float translationY, float translationZ) {
        return new FloatRigid(translationX, translationY, translationZ, 0.0f, 0.0f, 0.0f, 1.0f);
    }


    /**
     * Create a new rigid transform representing a pure translation by {@code translation} (identity
     * rotation).
     * <p>
     * Alias for {@code set}.
     *
     * @param translation the vector
     * @return the resulting rigid transform
     */
    public static FloatRigid makeTranslation(Float3 translation) {
        return makeTranslation(translation.x(), translation.y(), translation.z());
    }


    /**
     * Create a new rigid transform representing a pure translation by ({@code translationX},
     * {@code translationY}, {@code translationZ}) (identity rotation).
     * <p>
     * Alias for {@code set}.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return the resulting rigid transform
     */
    public static FloatRigid makeTranslation(float translationX, float translationY, float translationZ) {
        return new FloatRigid(translationX, translationY, translationZ, 0.0f, 0.0f, 0.0f, 1.0f);
    }


    /**
     * Interpolate between this rigid transform and {@code other} using the interpolation factor
     * {@code t}, interpolating the translation linearly and the rotation via shortest-arc slerp,
     * returning the result as a value.
     *
     * @param other the other rigid transform
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting rigid transform
     */
    public FloatRigid lerp(FloatRigid other, float t) {
        return lerp(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), t);
    }

    /** Private tail of {@code lerp}; reached only through it. */
    private FloatRigid lerp_s49cf416d_tail(float _t17, float _t25, float _t19, float _t21, float _t17_inv, float t, float _t0, float _t22, float _t23, float _t24, float otherTX, float otherTY, float otherTZ) {
        float _t42, _t43, _t44, _t45;
        if (_t17 > 0.0f) {
            _t42 = Math.fma(this.rW, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(this.rZ, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(this.rX, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(this.rY, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(t, _t21, this.rW * _t0);
            _t43 = Math.fma(t, _t22, this.rZ * _t0);
            _t44 = Math.fma(t, _t23, this.rX * _t0);
            _t45 = Math.fma(t, _t24, this.rY * _t0);
        }
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _sfx0 = Math.fma(t, otherTX - this.tX, this.tX);
        float _sfx1 = Math.fma(t, otherTY - this.tY, this.tY);
        float _sfx2 = Math.fma(t, otherTZ - this.tZ, this.tZ);
        return lerp_s49cf416d_tail2(_t49, _t50, _t44, _t45, _t43, _t42, _sfx0, _sfx1, _sfx2);
    }

    /** Private tail of {@code lerp}; reached only through it. */
    private FloatRigid lerp_s49cf416d_tail2(float _t49, float _t50, float _t44, float _t45, float _t43, float _t42, float _sfx0, float _sfx1, float _sfx2) {
        float _sfx3, _sfx4, _sfx5, _sfx6;
        if (_t49 > 0.0f) {
            _sfx3 = _t50 * _t44;
            _sfx4 = _t50 * _t45;
            _sfx5 = _t50 * _t43;
            _sfx6 = _t50 * _t42;
        } else {
            _sfx3 = 0.0f;
            _sfx4 = 0.0f;
            _sfx5 = 0.0f;
            _sfx6 = 0.0f;
        }
        return new FloatRigid(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6);
    }


    /**
     * Interpolate between this rigid transform and ({@code otherTX}, {@code otherTY},
     * {@code otherTZ}, {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}) using
     * the interpolation factor {@code t}, interpolating the translation linearly and the rotation
     * via shortest-arc slerp, returning the result as a value.
     *
     * @param otherTX the {@code tX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTY the {@code tY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTZ the {@code tZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRX the {@code rX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRY the {@code rY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRZ the {@code rZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRW the {@code rW} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting rigid transform
     */
    public FloatRigid lerp(float otherTX, float otherTY, float otherTZ, float otherRX, float otherRY, float otherRZ, float otherRW, float t) {
        float _t0 = 1.0f - t;
        float _t12 = Math.fma(otherRW, this.rW, Math.fma(otherRZ, this.rZ, Math.fma(otherRX, this.rX, otherRY * this.rY)));
        float _t14 = -_t12;
        float _t16 = (float) Math.acos(Math.min(1.0f, Math.abs(_t12)));
        float _t17 = (float) Math.sin(_t16);
        float _t17_inv = 1.0f / _t17;
        float _t19 = (float) Math.sin(t * _t16);
        float _t21, _t22, _t23, _t24;
        if (_t14 > 0.0f) {
            _t21 = -otherRW;
            _t22 = -otherRZ;
            _t23 = -otherRX;
            _t24 = -otherRY;
        } else {
            _t21 = otherRW;
            _t22 = otherRZ;
            _t23 = otherRX;
            _t24 = otherRY;
        }
        float _t25 = (float) Math.sin(_t0 * _t16);
        return lerp_s49cf416d_tail(_t17, _t25, _t19, _t21, _t17_inv, t, _t0, _t22, _t23, _t24, otherTX, otherTY, otherTZ);
    }


    /**
     * Multiply this rigid transform by {@code other}, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code M * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param other the other rigid transform
     * @return the resulting rigid transform
     */
    public FloatRigid mul(FloatRigid other) {
        return mul(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW());
    }

    /** Private tail of {@code mul}; reached only through it. */
    private FloatRigid mul_s183b932f_tail(float otherTZ, float otherTY, float _t9, float _t10, float otherTX, float otherRX, float otherRW, float otherRZ, float otherRY) {
        float _t11 = 2.0f * Math.fma(otherTZ, this.rY, -(otherTY * this.rZ));
        return new FloatRigid(Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, this.tX + otherTX))), Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, this.tY + otherTY))), Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, this.tZ + otherTZ))), Math.fma(otherRX, this.rW, otherRW * this.rX) + Math.fma(otherRZ, this.rY, -(otherRY * this.rZ)), Math.fma(otherRX, this.rZ, otherRW * this.rY) + Math.fma(otherRY, this.rW, -(otherRZ * this.rX)), Math.fma(otherRY, this.rX, otherRZ * this.rW) + Math.fma(otherRW, this.rZ, -(otherRX * this.rY)), Math.fma(-otherRZ, this.rZ, Math.fma(-otherRY, this.rY, Math.fma(otherRW, this.rW, -(otherRX * this.rX)))));
    }


    /**
     * Multiply this rigid transform by ({@code otherTX}, {@code otherTY}, {@code otherTZ},
     * {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}), returning the result as
     * a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code M * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param otherTX the {@code tX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTY the {@code tY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTZ the {@code tZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRX the {@code rX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRY the {@code rY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRZ the {@code rZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRW the {@code rW} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @return the resulting rigid transform
     */
    public FloatRigid mul(float otherTX, float otherTY, float otherTZ, float otherRX, float otherRY, float otherRZ, float otherRW) {
        float _t9 = 2.0f * Math.fma(otherTY, this.rX, -(otherTX * this.rY));
        float _t10 = 2.0f * Math.fma(otherTX, this.rZ, -(otherTZ * this.rX));
        return mul_s183b932f_tail(otherTZ, otherTY, _t9, _t10, otherTX, otherRX, otherRW, otherRZ, otherRY);
    }


    /**
     * Pre-multiply {@code other} onto this rigid transform, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code R * M}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code R * M * v}, the transformation of the operand will be applied last.
     *
     * @param other the other rigid transform
     * @return the resulting rigid transform
     */
    public FloatRigid preMul(FloatRigid other) {
        return preMul(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW());
    }


    /**
     * Pre-multiply ({@code otherTX}, {@code otherTY}, {@code otherTZ}, {@code otherRX},
     * {@code otherRY}, {@code otherRZ}, {@code otherRW}) onto this rigid transform, returning the
     * result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code R * M}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code R * M * v}, the transformation of the operand will be applied last.
     *
     * @param otherTX the {@code tX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTY the {@code tY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTZ the {@code tZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRX the {@code rX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRY the {@code rY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRZ the {@code rZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRW the {@code rW} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @return the resulting rigid transform
     */
    public FloatRigid preMul(float otherTX, float otherTY, float otherTZ, float otherRX, float otherRY, float otherRZ, float otherRW) {
        float _t0 = -otherRZ;
        float _t1 = -otherRY;
        float _t11 = 2.0f * Math.fma(otherRX, this.tY, -(otherRY * this.tX));
        float _t12 = 2.0f * Math.fma(otherRZ, this.tX, -(otherRX * this.tZ));
        float _t13 = 2.0f * Math.fma(otherRY, this.tZ, -(otherRZ * this.tY));
        return new FloatRigid(Math.fma(otherRY, _t11, Math.fma(_t0, _t12, Math.fma(otherRW, _t13, otherTX + this.tX))), Math.fma(otherRZ, _t13, Math.fma(-otherRX, _t11, Math.fma(otherRW, _t12, otherTY + this.tY))), Math.fma(otherRX, _t12, Math.fma(_t1, _t13, Math.fma(otherRW, _t11, otherTZ + this.tZ))), Math.fma(otherRX, this.rW, otherRW * this.rX) + Math.fma(otherRY, this.rZ, -(otherRZ * this.rY)), Math.fma(otherRY, this.rW, otherRZ * this.rX) + Math.fma(otherRW, this.rY, -(otherRX * this.rZ)), Math.fma(otherRX, this.rY, otherRW * this.rZ) + Math.fma(otherRZ, this.rW, -(otherRY * this.rX)), Math.fma(_t0, this.rZ, Math.fma(_t1, this.rY, Math.fma(otherRW, this.rW, -(otherRX * this.rX)))));
    }


    /**
     * Compute the difference between this rigid transform and {@code other}, i.e. the rigid
     * transformation {@code D} with {@code this * D = other}, that is {@code D = this^-1 * other},
     * returning the result as a value.
     *
     * @param other the other rigid transform
     * @return the resulting rigid transform
     */
    public FloatRigid difference(FloatRigid other) {
        return difference(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW());
    }

    /** Private tail of {@code difference}; reached only through it. */
    private FloatRigid difference_s183b932f_tail(float _t20, float otherTY, float _t18, float _t19, float _t22, float _t23, float _t21, float otherTZ, float otherRX, float otherRW, float otherRY, float otherRZ, float _sfx0) {
        float _sfx1 = Math.fma(this.rX, _t20, otherTY) + Math.fma(this.rW, _t18, -(this.rZ * _t19)) + (Math.fma(this.rX, _t22, -(this.rZ * _t23)) + Math.fma(this.rW, _t21, -this.tY));
        float _sfx2 = Math.fma(this.rY, _t19, otherTZ) + Math.fma(this.rW, _t20, -(this.rX * _t18)) + (Math.fma(this.rY, _t23, -(this.rX * _t21)) + Math.fma(this.rW, _t22, -this.tZ));
        float _sfx3 = Math.fma(otherRX, this.rW, -(otherRW * this.rX)) + Math.fma(otherRY, this.rZ, -(otherRZ * this.rY));
        float _sfx4 = Math.fma(otherRY, this.rW, otherRZ * this.rX) + Math.fma(-otherRX, this.rZ, -(otherRW * this.rY));
        float _sfx5 = Math.fma(otherRX, this.rY, -(otherRW * this.rZ)) + Math.fma(otherRZ, this.rW, -(otherRY * this.rX));
        float _sfx6 = Math.fma(otherRZ, this.rZ, Math.fma(otherRY, this.rY, Math.fma(otherRX, this.rX, otherRW * this.rW)));
        return new FloatRigid(_sfx0, _sfx1, _sfx2, _sfx3, _sfx4, _sfx5, _sfx6);
    }


    /**
     * Compute the difference between this rigid transform and ({@code otherTX}, {@code otherTY},
     * {@code otherTZ}, {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}), i.e.
     * the rigid transformation {@code D} with
     * {@code this * D = (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}, that is
     * {@code D = this^-1 * (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)},
     * returning the result as a value.
     *
     * @param otherTX the {@code tX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTY the {@code tY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherTZ the {@code tZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRX the {@code rX} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRY the {@code rY} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRZ the {@code rZ} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @param otherRW the {@code rW} component of the rigid transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}
     * @return the resulting rigid transform
     */
    public FloatRigid difference(float otherTX, float otherTY, float otherTZ, float otherRX, float otherRY, float otherRZ, float otherRW) {
        float _t18 = 2.0f * Math.fma(otherTZ, this.rX, -(otherTX * this.rZ));
        float _t19 = 2.0f * Math.fma(otherTY, this.rZ, -(otherTZ * this.rY));
        float _t20 = 2.0f * Math.fma(otherTX, this.rY, -(otherTY * this.rX));
        float _t21 = 2.0f * Math.fma(this.tX, this.rZ, -(this.tZ * this.rX));
        float _t22 = 2.0f * Math.fma(this.tY, this.rX, -(this.tX * this.rY));
        float _t23 = 2.0f * Math.fma(this.tZ, this.rY, -(this.tY * this.rZ));
        float _sfx0 = Math.fma(this.rZ, _t18, otherTX) + Math.fma(this.rW, _t19, -(this.rY * _t20)) + (Math.fma(this.rZ, _t21, -(this.rY * _t22)) + Math.fma(this.rW, _t23, -this.tX));
        return difference_s183b932f_tail(_t20, otherTY, _t18, _t19, _t22, _t23, _t21, otherTZ, otherRX, otherRW, otherRY, otherRZ, _sfx0);
    }


    /**
     * Invert this rigid transform; exact for any rigid motion (no scale divisions), returning the
     * result as a value.
     *
     * @return the resulting rigid transform
     */
    public FloatRigid invert() {
        float _t0 = -this.rY;
        float _t1 = -this.rZ;
        float _t2 = -this.rX;
        float _t12 = 2.0f * Math.fma(this.tX, this.rZ, -(this.tZ * this.rX));
        float _t13 = 2.0f * Math.fma(this.tY, this.rX, -(this.tX * this.rY));
        float _t14 = 2.0f * Math.fma(this.tZ, this.rY, -(this.tY * this.rZ));
        return new FloatRigid(Math.fma(this.rZ, _t12, Math.fma(_t0, _t13, Math.fma(this.rW, _t14, -this.tX))), Math.fma(this.rX, _t13, Math.fma(_t1, _t14, Math.fma(this.rW, _t12, -this.tY))), Math.fma(this.rY, _t14, Math.fma(_t2, _t12, Math.fma(this.rW, _t13, -this.tZ))), _t2, _t0, _t1, this.rW);
    }


    /**
     * Normalize this rigid transform so that its rotation part has unit length, leaving its
     * translation unchanged (a zero-length rotation yields the zero quaternion), returning the
     * result as a value.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the rotation quaternion must lie
     * roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the resulting rigid transform
     */
    public FloatRigid normalize() {
        float _t3 = Math.fma(this.rW, this.rW, Math.fma(this.rZ, this.rZ, Math.fma(this.rX, this.rX, this.rY * this.rY)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            return new FloatRigid(this.tX, this.tY, this.tZ, this.rX * _t4, this.rY * _t4, this.rZ * _t4, this.rW * _t4);
        } else {
            return new FloatRigid(this.tX, this.tY, this.tZ, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the X, Y and Z
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXYZ() {
        float _t1 = this.rY * this.rZ;
        float _t3 = this.rZ * this.rZ;
        float _t8 = 2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW);
        float _t9 = 2.0f * Math.fma(this.rX, this.rW, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, _t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t3), 1.0f)), (float) Math.atan2(_t8, (float) Math.sqrt(_t12)), 0.0f);
        } else {
            return new Float3((float) Math.atan2(_t9, _t10), (float) Math.atan2(_t8, (float) Math.sqrt(_t12)), (float) Math.atan2(2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY)), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t3), 1.0f)));
        }
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the X, Z and Y
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXZY() {
        float _t0 = this.rZ * this.rZ;
        float _t1 = this.rY * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rW, _t1);
        float _t8 = 2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, -_t1), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), 0.0f, (float) Math.atan2(_t8, (float) Math.sqrt(_t11)));
        } else {
            return new Float3((float) Math.atan2(_t7, _t9), (float) Math.atan2(2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f)), (float) Math.atan2(_t8, (float) Math.sqrt(_t11)));
        }
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the Y, X and Z
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYXZ() {
        float _t3 = this.rZ * this.rZ;
        float _t8 = 2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW);
        float _t9 = 2.0f * Math.fma(this.rX, this.rW, -(this.rY * this.rZ));
        float _t10 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            return new Float3((float) Math.atan2(_t9, (float) Math.sqrt(_t12)), (float) Math.atan2(2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ)), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t3), 1.0f)), 0.0f);
        } else {
            return new Float3((float) Math.atan2(_t9, (float) Math.sqrt(_t12)), (float) Math.atan2(_t8, _t10), (float) Math.atan2(2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t3), 1.0f)));
        }
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the Y, Z and X
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYZX() {
        float _t0 = this.rZ * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW);
        float _t8 = 2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3(0.0f, (float) Math.atan2(2.0f * Math.fma(this.rX, this.rZ, this.rY * this.rW), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), (float) Math.atan2(_t7, (float) Math.sqrt(_t11)));
        } else {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, -(this.rY * this.rZ)), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f)), (float) Math.atan2(_t8, _t9), (float) Math.atan2(_t7, (float) Math.sqrt(_t11)));
        }
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the Z, X and Y
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZXY() {
        float _t1 = this.rZ * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ);
        float _t8 = 2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3((float) Math.atan2(_t7, (float) Math.sqrt(_t11)), 0.0f, (float) Math.atan2(2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW), Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t1), 1.0f)));
        } else {
            return new Float3((float) Math.atan2(_t7, (float) Math.sqrt(_t11)), (float) Math.atan2(2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ)), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), (float) Math.atan2(_t8, _t9));
        }
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the Z, Y and X
     * axes, in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZYX() {
        float _t0 = this.rZ * this.rZ;
        float _t7 = 2.0f * Math.fma(this.rX, this.rY, this.rZ * this.rW);
        float _t8 = 2.0f * Math.fma(this.rY, this.rW, -(this.rX * this.rZ));
        float _t9 = Math.fma(-2.0f, Math.fma(this.rY, this.rY, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3(0.0f, (float) Math.atan2(_t8, (float) Math.sqrt(_t11)), (float) Math.atan2(2.0f * Math.fma(this.rZ, this.rW, -(this.rX * this.rY)), Math.fma(-2.0f, Math.fma(this.rX, this.rX, _t0), 1.0f)));
        } else {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.rX, this.rW, this.rY * this.rZ), Math.fma(-2.0f, Math.fma(this.rX, this.rX, this.rY * this.rY), 1.0f)), (float) Math.atan2(_t8, (float) Math.sqrt(_t11)), (float) Math.atan2(_t7, _t9));
        }
    }


    /**
     * Get the rotation of this rigid transform, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat getRotation() {
        return new FloatQuat(this.rX, this.rY, this.rZ, this.rW);
    }


    /**
     * Get the translation of this rigid transform, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getTranslation() {
        return new Float3(this.tX, this.tY, this.tZ);
    }


    /**
     * Create a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationAxis(float angle, Float3 axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Create a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}).
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return makeRotationX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return makeRotationY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return makeRotationZ(axisZ * angle);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        return new FloatRigid(0.0f, 0.0f, 0.0f, axisX * _t1, axisY * _t1, axisZ * _t1, (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationX(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatRigid(0.0f, 0.0f, 0.0f, (float) Math.sin(_t0), 0.0f, 0.0f, (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t6;
        float _t12 = _t7 * _t4;
        return new FloatRigid(0.0f, 0.0f, 0.0f, Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)));
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationXZY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        return new FloatRigid(0.0f, 0.0f, 0.0f, Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t8, _t11 * _t5));
    }


    /**
     * Create a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationY(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatRigid(0.0f, 0.0f, 0.0f, 0.0f, (float) Math.sin(_t0), 0.0f, (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        return new FloatRigid(0.0f, 0.0f, 0.0f, Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t12, _t8, _t11 * _t5));
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationYZX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        return new FloatRigid(0.0f, 0.0f, 0.0f, Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)), Math.fma(_t10, _t5, -(_t9 * _t8)));
    }


    /**
     * Create a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationZ(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatRigid(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, (float) Math.sin(_t0), (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationZXY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t6;
        float _t12 = _t7 * _t4;
        return new FloatRigid(0.0f, 0.0f, 0.0f, Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t5, -(_t11 * _t8)));
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public static FloatRigid makeRotationZYX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        return new FloatRigid(0.0f, 0.0f, 0.0f, Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, _t12 * _t5), Math.fma(_t12, _t8, -(_t11 * _t5)), Math.fma(_t10, _t5, _t9 * _t8));
    }


    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this rigid transform,
     * returning the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param rotation the quaternion (must be a unit quaternion)
     * @return the resulting rigid transform
     */
    public FloatRigid rotate(FloatQuat rotation) {
        return rotate(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Apply the rotation represented by the quaternion ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param rotationX the {@code x} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationY the {@code y} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationZ the {@code z} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @param rotationW the {@code w} component of the quaternion
     *        {@code (rotationX, rotationY, rotationZ, rotationW)} (the quaternion must have unit
     *        length)
     * @return the resulting rigid transform
     */
    public FloatRigid rotate(float rotationX, float rotationY, float rotationZ, float rotationW) {
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(rotationX, this.rW, rotationW * this.rX) + Math.fma(rotationZ, this.rY, -(rotationY * this.rZ)), Math.fma(rotationX, this.rZ, rotationW * this.rY) + Math.fma(rotationY, this.rW, -(rotationZ * this.rX)), Math.fma(rotationY, this.rX, rotationZ * this.rW) + Math.fma(rotationW, this.rZ, -(rotationX * this.rY)), Math.fma(-rotationZ, this.rZ, Math.fma(-rotationY, this.rY, Math.fma(rotationW, this.rW, -(rotationX * this.rX)))));
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this rigid
     * transform, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting rigid transform
     */
    public FloatRigid rotateAxis(float angle, Float3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this rigid transform, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return the resulting rigid transform
     */
    public FloatRigid rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t1, this.rW * _t3) + Math.fma(this.rY, _t4, -(this.rZ * _t5)), Math.fma(this.rY, _t1, this.rZ * _t3) + Math.fma(this.rW, _t5, -(this.rX * _t4)), Math.fma(this.rX, _t5, this.rW * _t4) + Math.fma(this.rZ, _t1, -(this.rY * _t3)), Math.fma(-this.rZ, _t4, Math.fma(-this.rY, _t5, Math.fma(this.rW, _t1, -(this.rX * _t3)))));
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this rigid transform, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting rigid transform
     */
    public FloatRigid rotateX(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t1, this.rW * _t2), Math.fma(this.rY, _t1, this.rZ * _t2), Math.fma(this.rZ, _t1, -(this.rY * _t2)), Math.fma(this.rW, _t1, -(this.rX * _t2)));
    }

    /** Private tail of {@code rotateXYZ}; reached only through it. */
    private FloatRigid rotateXYZ_s6e793366_tail(float _t12, float _t5, float _t11, float _t8, float _t21, float _t19, float _t20) {
        float _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t21, this.rW * _t19) + Math.fma(this.rY, _t20, -(this.rZ * _t22)), Math.fma(this.rY, _t21, this.rZ * _t19) + Math.fma(this.rW, _t22, -(this.rX * _t20)), Math.fma(this.rX, _t22, this.rW * _t20) + Math.fma(this.rZ, _t21, -(this.rY * _t19)), Math.fma(-this.rZ, _t20, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t21, -(this.rX * _t19)))));
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public FloatRigid rotateXYZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        float _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        float _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        return rotateXYZ_s6e793366_tail(_t12, _t5, _t11, _t8, _t21, _t19, _t20);
    }

    /** Private tail of {@code rotateXZY}; reached only through it. */
    private FloatRigid rotateXZY_s6e793366_tail(float _t10, float _t5, float _t9, float _t8, float _t19, float _t21, float _t20) {
        float _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t19, this.rW * _t21) + Math.fma(this.rY, _t20, -(this.rZ * _t22)), Math.fma(this.rY, _t19, this.rZ * _t21) + Math.fma(this.rW, _t22, -(this.rX * _t20)), Math.fma(this.rX, _t22, this.rW * _t20) + Math.fma(this.rZ, _t19, -(this.rY * _t21)), Math.fma(-this.rZ, _t20, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t19, -(this.rX * _t21)))));
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public FloatRigid rotateXZY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        float _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        return rotateXZY_s6e793366_tail(_t10, _t5, _t9, _t8, _t19, _t21, _t20);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this rigid transform, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting rigid transform
     */
    public FloatRigid rotateY(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t1, -(this.rZ * _t2)), Math.fma(this.rY, _t1, this.rW * _t2), Math.fma(this.rX, _t2, this.rZ * _t1), Math.fma(this.rW, _t1, -(this.rY * _t2)));
    }

    /** Private tail of {@code rotateYXZ}; reached only through it. */
    private FloatRigid rotateYXZ_s6e793366_tail(float _t12, float _t8, float _t11, float _t5, float _t19, float _t20, float _t21) {
        float _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t19, this.rW * _t20) + Math.fma(this.rY, _t21, -(this.rZ * _t22)), Math.fma(this.rY, _t19, this.rZ * _t20) + Math.fma(this.rW, _t22, -(this.rX * _t21)), Math.fma(this.rX, _t22, this.rW * _t21) + Math.fma(this.rZ, _t19, -(this.rY * _t20)), Math.fma(-this.rZ, _t21, Math.fma(-this.rY, _t22, Math.fma(this.rW, _t19, -(this.rX * _t20)))));
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public FloatRigid rotateYXZ(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        float _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        return rotateYXZ_s6e793366_tail(_t12, _t8, _t11, _t5, _t19, _t20, _t21);
    }

    /** Private tail of {@code rotateYZX}; reached only through it. */
    private FloatRigid rotateYZX_s6e793366_tail(float _t11, float _t5, float _t12, float _t8, float _t21, float _t19, float _t20) {
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t21, this.rW * _t19) + Math.fma(this.rY, _t22, -(this.rZ * _t20)), Math.fma(this.rY, _t21, this.rZ * _t19) + Math.fma(this.rW, _t20, -(this.rX * _t22)), Math.fma(this.rX, _t20, this.rW * _t22) + Math.fma(this.rZ, _t21, -(this.rY * _t19)), Math.fma(-this.rZ, _t22, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t21, -(this.rX * _t19)))));
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public FloatRigid rotateYZX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t3;
        float _t12 = _t6 * _t4;
        float _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        return rotateYZX_s6e793366_tail(_t11, _t5, _t12, _t8, _t21, _t19, _t20);
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this rigid transform, returning
     * the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @return the resulting rigid transform
     */
    public FloatRigid rotateZ(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t1, this.rY * _t2), Math.fma(this.rY, _t1, -(this.rX * _t2)), Math.fma(this.rZ, _t1, this.rW * _t2), Math.fma(this.rW, _t1, -(this.rZ * _t2)));
    }

    /** Private tail of {@code rotateZXY}; reached only through it. */
    private FloatRigid rotateZXY_s6e793366_tail(float _t11, float _t5, float _t12, float _t8, float _t21, float _t19, float _t20) {
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t21, this.rW * _t22) + Math.fma(this.rY, _t19, -(this.rZ * _t20)), Math.fma(this.rY, _t21, this.rZ * _t22) + Math.fma(this.rW, _t20, -(this.rX * _t19)), Math.fma(this.rX, _t20, this.rW * _t19) + Math.fma(this.rZ, _t21, -(this.rY * _t22)), Math.fma(-this.rZ, _t19, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t21, -(this.rX * _t22)))));
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public FloatRigid rotateZXY(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        float _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        float _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        return rotateZXY_s6e793366_tail(_t11, _t5, _t12, _t8, _t21, _t19, _t20);
    }

    /** Private tail of {@code rotateZYX}; reached only through it. */
    private FloatRigid rotateZYX_s6e793366_tail(float _t11, float _t8, float _t12, float _t5, float _t19, float _t21, float _t20) {
        float _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        return new FloatRigid(this.tX, this.tY, this.tZ, Math.fma(this.rX, _t19, this.rW * _t21) + Math.fma(this.rY, _t22, -(this.rZ * _t20)), Math.fma(this.rY, _t19, this.rZ * _t21) + Math.fma(this.rW, _t20, -(this.rX * _t22)), Math.fma(this.rX, _t20, this.rW * _t22) + Math.fma(this.rZ, _t19, -(this.rY * _t21)), Math.fma(-this.rZ, _t22, Math.fma(-this.rY, _t20, Math.fma(this.rW, _t19, -(this.rX * _t21)))));
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting rigid transform
     */
    public FloatRigid rotateZYX(float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t4 * _t6;
        float _t12 = _t3 * _t7;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        float _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        return rotateZYX_s6e793366_tail(_t11, _t8, _t12, _t5, _t19, _t21, _t20);
    }


    /**
     * Apply a translation by {@code translation} to this rigid transform, returning the result as a
     * value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code T} the translation rigid transform,
     * then the new rigid transform will be {@code M * T}. So when transforming a vector {@code v}
     * with the new rigid transform by using {@code M * T * v}, the translation will be applied
     * first.
     *
     * @param translation the vector
     * @return the resulting rigid transform
     */
    public FloatRigid translate(Float3 translation) {
        return translate(translation.x(), translation.y(), translation.z());
    }


    /**
     * Apply a translation by ({@code translationX}, {@code translationY}, {@code translationZ}) to
     * this rigid transform, returning the result as a value.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code T} the translation rigid transform,
     * then the new rigid transform will be {@code M * T}. So when transforming a vector {@code v}
     * with the new rigid transform by using {@code M * T * v}, the translation will be applied
     * first.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return the resulting rigid transform
     */
    public FloatRigid translate(float translationX, float translationY, float translationZ) {
        float _t9 = 2.0f * Math.fma(this.rX, translationY, -(this.rY * translationX));
        float _t10 = 2.0f * Math.fma(this.rZ, translationX, -(this.rX * translationZ));
        float _t11 = 2.0f * Math.fma(this.rY, translationZ, -(this.rZ * translationY));
        return new FloatRigid(Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, this.tX + translationX))), Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, this.tY + translationY))), Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, this.tZ + translationZ))), this.rX, this.rY, this.rZ, this.rW);
    }


    /**
     * Transform {@code v} by this rigid transform, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transform(Float3 v) {
        return transform(v.x(), v.y(), v.z());
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this rigid transform, returning the result
     * as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transform(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.rX, vY, -(this.rY * vX));
        float _t10 = 2.0f * Math.fma(this.rZ, vX, -(this.rX * vZ));
        float _t11 = 2.0f * Math.fma(this.rY, vZ, -(this.rZ * vY));
        return new Float3(Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, this.tX + vX))), Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, this.tY + vY))), Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, this.tZ + vZ))));
    }


    /**
     * Transform the given direction by the rotation part of this rigid transform, ignoring the
     * translation, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformDirection(Float3 v) {
        return transformDirection(v.x(), v.y(), v.z());
    }


    /**
     * Transform the given direction by the rotation part of this rigid transform, ignoring the
     * translation, returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformDirection(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.rX, vY, -(this.rY * vX));
        float _t10 = 2.0f * Math.fma(this.rZ, vX, -(this.rX * vZ));
        float _t11 = 2.0f * Math.fma(this.rY, vZ, -(this.rZ * vY));
        return new Float3(Math.fma(this.rY, _t9, Math.fma(-this.rZ, _t10, Math.fma(this.rW, _t11, vX))), Math.fma(this.rZ, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, vY))), Math.fma(this.rX, _t10, Math.fma(-this.rY, _t11, Math.fma(this.rW, _t9, vZ))));
    }


    /**
     * Transform the given direction by the inverse of this rigid transform's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()}, returning the
     * result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformDirectionInverse(Float3 v) {
        return transformDirectionInverse(v.x(), v.y(), v.z());
    }


    /**
     * Transform the given direction by the inverse of this rigid transform's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()}, returning the
     * result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformDirectionInverse(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.rX, vZ, -(this.rZ * vX));
        float _t10 = 2.0f * Math.fma(this.rY, vX, -(this.rX * vY));
        float _t11 = 2.0f * Math.fma(this.rZ, vY, -(this.rY * vZ));
        return new Float3(Math.fma(this.rZ, _t9, Math.fma(-this.rY, _t10, Math.fma(this.rW, _t11, vX))), Math.fma(this.rX, _t10, Math.fma(-this.rZ, _t11, Math.fma(this.rW, _t9, vY))), Math.fma(this.rY, _t11, Math.fma(-this.rX, _t9, Math.fma(this.rW, _t10, vZ))));
    }


    /**
     * Transform {@code p} by the inverse of this rigid transform, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 transformInverse(Float3 p) {
        return transformInverse(p.x(), p.y(), p.z());
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by the inverse of this rigid transform,
     * returning the result as a value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 transformInverse(float pX, float pY, float pZ) {
        float _t0 = pZ - this.tZ;
        float _t1 = pX - this.tX;
        float _t2 = pY - this.tY;
        float _t12 = 2.0f * Math.fma(this.rX, _t0, -(this.rZ * _t1));
        float _t13 = 2.0f * Math.fma(this.rY, _t1, -(this.rX * _t2));
        float _t14 = 2.0f * Math.fma(this.rZ, _t2, -(this.rY * _t0));
        return new Float3(Math.fma(this.rZ, _t12, Math.fma(-this.rY, _t13, Math.fma(this.rW, _t14, _t1))), Math.fma(this.rX, _t13, Math.fma(-this.rZ, _t14, Math.fma(this.rW, _t12, _t2))), Math.fma(this.rY, _t14, Math.fma(-this.rX, _t12, Math.fma(this.rW, _t13, _t0))));
    }


    /**
     * Transform the given position by this rigid transform, treating it as a point with an implicit
     * {@code w = 1}, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformPosition(Float3 v) {
        return transform(v);
    }


    /**
     * Transform the given position by this rigid transform, treating it as a point with an implicit
     * {@code w = 1}, returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformPosition(float vX, float vY, float vZ) {
        return transform(vX, vY, vZ);
    }


    /**
     * Transform the given position by the inverse of this rigid transform (world to local), without
     * materializing {@code invert()}, returning the result as a value.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 transformPositionInverse(Float3 p) {
        return transformInverse(p);
    }


    /**
     * Transform the given position by the inverse of this rigid transform (world to local), without
     * materializing {@code invert()}, returning the result as a value.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 transformPositionInverse(float pX, float pY, float pZ) {
        return transformInverse(pX, pY, pZ);
    }

    /** {@return a copy with the {@code tX} component replaced by {@code v}} */
    public FloatRigid withTX(float v) {
        return new FloatRigid(v, tY, tZ, rX, rY, rZ, rW);
    }

    /** {@return a copy with the {@code tY} component replaced by {@code v}} */
    public FloatRigid withTY(float v) {
        return new FloatRigid(tX, v, tZ, rX, rY, rZ, rW);
    }

    /** {@return a copy with the {@code tZ} component replaced by {@code v}} */
    public FloatRigid withTZ(float v) {
        return new FloatRigid(tX, tY, v, rX, rY, rZ, rW);
    }

    /** {@return a copy with the {@code rX} component replaced by {@code v}} */
    public FloatRigid withRX(float v) {
        return new FloatRigid(tX, tY, tZ, v, rY, rZ, rW);
    }

    /** {@return a copy with the {@code rY} component replaced by {@code v}} */
    public FloatRigid withRY(float v) {
        return new FloatRigid(tX, tY, tZ, rX, v, rZ, rW);
    }

    /** {@return a copy with the {@code rZ} component replaced by {@code v}} */
    public FloatRigid withRZ(float v) {
        return new FloatRigid(tX, tY, tZ, rX, rY, v, rW);
    }

    /** {@return a copy with the {@code rW} component replaced by {@code v}} */
    public FloatRigid withRW(float v) {
        return new FloatRigid(tX, tY, tZ, rX, rY, rZ, v);
    }

    @Override public String toString() {
        return "FloatRigid(" + tX() + ", " + tY() + ", " + tZ() + ", " + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatRigid)) return false;
        FloatRigid o = (FloatRigid) obj;
        return Float.floatToIntBits(tX) == Float.floatToIntBits(o.tX)
            && Float.floatToIntBits(tY) == Float.floatToIntBits(o.tY)
            && Float.floatToIntBits(tZ) == Float.floatToIntBits(o.tZ)
            && Float.floatToIntBits(rX) == Float.floatToIntBits(o.rX)
            && Float.floatToIntBits(rY) == Float.floatToIntBits(o.rY)
            && Float.floatToIntBits(rZ) == Float.floatToIntBits(o.rZ)
            && Float.floatToIntBits(rW) == Float.floatToIntBits(o.rW);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(tX);
        h = 31 * h + Float.floatToIntBits(tY);
        h = 31 * h + Float.floatToIntBits(tZ);
        h = 31 * h + Float.floatToIntBits(rX);
        h = 31 * h + Float.floatToIntBits(rY);
        h = 31 * h + Float.floatToIntBits(rZ);
        h = 31 * h + Float.floatToIntBits(rW);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(tX)
            && Float.isFinite(tY)
            && Float.isFinite(tZ)
            && Float.isFinite(rX)
            && Float.isFinite(rY)
            && Float.isFinite(rZ)
            && Float.isFinite(rW);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     * <p>
     * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
     * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and
     * a NaN component never compares equal to anything.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatRigid other, float epsilon) {
        return Math.abs(tX - other.tX()) <= epsilon
            && Math.abs(tY - other.tY()) <= epsilon
            && Math.abs(tZ - other.tZ()) <= epsilon
            && Math.abs(rX - other.rX()) <= epsilon
            && Math.abs(rY - other.rY()) <= epsilon
            && Math.abs(rZ - other.rZ()) <= epsilon
            && Math.abs(rW - other.rW()) <= epsilon;
    }

    static final FloatRigidSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRigidSegOpsUnsafe()
                    : new FloatRigidSegOpsMS();
    static final FloatRigidBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRigidBbOpsUnsafe()
                    : new FloatRigidBbOpsApi();
    static final FloatRigidRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRigidRawOpsUnsafe()
                    : new FloatRigidRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = this.tX;
        dest[offset + 1] = this.tY;
        dest[offset + 2] = this.tZ;
        dest[offset + 3] = this.rX;
        dest[offset + 4] = this.rY;
        dest[offset + 5] = this.rZ;
        dest[offset + 6] = this.rW;
        return dest;
    }

    /**
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] store(float[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        float _c4 = src[offset + 4];
        float _c5 = src[offset + 5];
        float _c6 = src[offset + 6];
        return new FloatRigid(_c0, _c1, _c2, _c3, _c4, _c5, _c6);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer store(FloatBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 7);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatRigid r = loadAbsolute(pos, buf);
        buf.position(pos + 7);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer store(ByteBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 28);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatRigid r = loadAbsolute(pos, buf);
        buf.position(pos + 28);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatRigid storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(long offset, MemorySegment src) {
        return SEG_OPS.load(offset, src);
    }


    /**
     * Store the elements into the given array, converting each element to {@code double}, starting
     * at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public double[] store(double[] dest, int offset) {
        dest[offset + 0] = this.tX;
        dest[offset + 1] = this.tY;
        dest[offset + 2] = this.tZ;
        dest[offset + 3] = this.rX;
        dest[offset + 4] = this.rY;
        dest[offset + 5] = this.rZ;
        dest[offset + 6] = this.rW;
        return dest;
    }

    /**
     * Store the elements into the given array, converting each element to {@code double}.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] store(double[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, converting each element from {@code double}, starting
     * at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        float _c4 = (float) src[offset + 4];
        float _c5 = (float) src[offset + 5];
        float _c6 = (float) src[offset + 6];
        return new FloatRigid(_c0, _c1, _c2, _c3, _c4, _c5, _c6);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer store(DoubleBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 7);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatRigid r = loadAbsolute(pos, buf);
        buf.position(pos + 7);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDouble(ByteBuffer buf) {
        return storeDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeDoubleAbsolute(pos, buf);
        buf.position(pos + 56);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatRigid r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 56);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatRigid storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(MemorySegment dest) { return storeDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double},
     * starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatRigid} holding the loaded elements
     */
    public static FloatRigid loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(offset, src);
    }

}
