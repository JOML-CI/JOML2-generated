package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleTransform} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleTransformImpl implements DoubleTransform {

    public double tX;
    public double tY;
    public double tZ;
    public double rX;
    public double rY;
    public double rZ;
    public double rW;
    public double sX;
    public double sY;
    public double sZ;
    static final DoubleTransformSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleTransformSegOpsUnsafe()
                    : new DoubleTransformSegOpsMS();
    static final DoubleTransformBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleTransformBbOpsUnsafe()
                    : new DoubleTransformBbOpsApi();
    static final DoubleTransformRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleTransformRawOpsUnsafe()
                    : new DoubleTransformRawOpsApi();

    public DoubleTransformImpl() {
        rW = 1;
        sX = 1;
        sY = 1;
        sZ = 1;
    }


    /**
     * Set this transform to the rotation of {@code angle} radians about the axis {@code axis},
     * combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the vector
     * @return this
     */
    public @Mutated DoubleTransform makeFromAxisAngle(Double3R axis, double angle, Double3R translation) {
        return makeFromAxisAngle(axis.x(), axis.y(), axis.z(), angle, translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this transform to the rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}), combined with a translation by ({@code translationX},
     * {@code translationY}, {@code translationZ}).
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
    @Mutated public DoubleTransform makeFromAxisAngle(double axisX, double axisY, double axisZ, double angle, double translationX, double translationY, double translationZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = Math.cos(_t0);
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rigid transformation that first rotates by {@code rotation} and then
     * translates by {@code translation} ({@code T * R}).
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @return this
     */
    public @Mutated DoubleTransform makeTranslationRotation(Double3R translation, DoubleQuatR rotation) {
        return makeTranslationRotation(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set this transform to a rigid transformation that first rotates by ({@code rotationX},
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
    @Mutated public DoubleTransform makeTranslationRotation(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW) {
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a transformation composed of the given translation, rotation and scale,
     * applied in scale-rotation-translation order.
     *
     * @param translation the vector
     * @param rotation the quaternion
     * @param scale the scale factor
     * @return this
     */
    public @Mutated DoubleTransform makeTranslationRotationScale(Double3R translation, DoubleQuatR rotation, Double3R scale) {
        return makeTranslationRotationScale(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w(), scale.x(), scale.y(), scale.z());
    }


    /**
     * Set this transform to a transformation composed of the given translation, rotation and scale,
     * applied in scale-rotation-translation order.
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
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @return this
     */
    @Mutated public DoubleTransform makeTranslationRotationScale(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.sX = scaleX;
        this.sY = scaleY;
        this.sZ = scaleZ;
        return this;
    }


    /**
     * Set this transform to the given values.
     *
     * @param v the transform
     * @return this
     */
    public @Mutated DoubleTransform set(DoubleTransformR v) {
        return set(v.tX(), v.tY(), v.tZ(), v.rX(), v.rY(), v.rZ(), v.rW(), v.sX(), v.sY(), v.sZ());
    }


    /**
     * Set this transform to the given values.
     *
     * @param vTX the {@code tX} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vTY the {@code tY} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vTZ the {@code tZ} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vRX the {@code rX} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vRY the {@code rY} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vRZ the {@code rZ} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vRW the {@code rW} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vSX the {@code sX} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vSY the {@code sY} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @param vSZ the {@code sZ} component of the transform
     *        {@code (vTX, vTY, vTZ, vRX, vRY, vRZ, vRW, vSX, vSY, vSZ)}
     * @return this
     */
    @Mutated public DoubleTransform set(double vTX, double vTY, double vTZ, double vRX, double vRY, double vRZ, double vRW, double vSX, double vSY, double vSZ) {
        this.tX = vTX;
        this.tY = vTY;
        this.tZ = vTZ;
        this.rX = vRX;
        this.rY = vRY;
        this.rZ = vRZ;
        this.rW = vRW;
        this.sX = vSX;
        this.sY = vSY;
        this.sZ = vSZ;
        return this;
    }


    /**
     * Set the rotation of this transform to {@code r} and store the result in {@code dest}.
     *
     * @param r the quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setRotation(DoubleQuatR r, @Mutated DoubleTransform dest) {
        return setRotation(r.x(), r.y(), r.z(), r.w(), dest);
    }


    /**
     * Set the rotation of this transform to ({@code rX}, {@code rY}, {@code rZ}, {@code rW}) and
     * store the result in {@code dest}.
     *
     * @param rX the {@code x} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rY the {@code y} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rZ the {@code z} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rW the {@code w} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setRotation(double rX, double rY, double rZ, double rW, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = rX;
        d.rY = rY;
        d.rZ = rZ;
        d.rW = rW;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        return d;
    }


    /**
     * Set the scale of this transform to {@code s} and store the result in {@code dest}.
     *
     * @param s the scale factors
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setScale(Double3R s, @Mutated DoubleTransform dest) {
        return setScale(s.x(), s.y(), s.z(), dest);
    }


    /**
     * Set the scale of this transform to ({@code sX}, {@code sY}, {@code sZ}) and store the result
     * in {@code dest}.
     *
     * @param sX the {@code x} component of the vector {@code (sX, sY, sZ)}
     * @param sY the {@code y} component of the vector {@code (sX, sY, sZ)}
     * @param sZ the {@code z} component of the vector {@code (sX, sY, sZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setScale(double sX, double sY, double sZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = sX;
        d.sY = sY;
        d.sZ = sZ;
        return d;
    }


    /**
     * Set the scale of this transform to {@code uniform} and store the result in {@code dest}.
     *
     * @param uniform the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setScale(double uniform, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = uniform;
        d.sY = uniform;
        d.sZ = uniform;
        return d;
    }


    /**
     * Set the translation of this transform to {@code t} and store the result in {@code dest}.
     *
     * @param t the translation vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setTranslation(Double3R t, @Mutated DoubleTransform dest) {
        return setTranslation(t.x(), t.y(), t.z(), dest);
    }


    /**
     * Set the translation of this transform to ({@code tX}, {@code tY}, {@code tZ}) and store the
     * result in {@code dest}.
     *
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform setTranslation(double tX, double tY, double tZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = tX;
        d.tY = tY;
        d.tZ = tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        return d;
    }


    /**
     * Set this transform to the rigid motion of the unit dual quaternion {@code dq} (translation
     * and rotation from {@code dq}, scale = 1).
     *
     * @param dq the dual quaternion
     * @return this
     */
    public @Mutated DoubleTransform makeFromDualQuat(DoubleDualQuatR dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Set this transform to the rigid motion of the unit dual quaternion ({@code dqRX},
     * {@code dqRY}, {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ},
     * {@code dqDW}) (translation and rotation from {@code dq}, scale = 1).
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
     * @return this
     */
    @Mutated public DoubleTransform makeFromDualQuat(double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        this.tX = 2.0 * (dqRY * dqDZ - dqRZ * dqDY + (dqRW * dqDX - dqRX * dqDW));
        this.tY = 2.0 * (dqRZ * dqDX - dqRX * dqDZ + (dqRW * dqDY - dqRY * dqDW));
        this.tZ = 2.0 * (dqRX * dqDY - dqRY * dqDX + (dqRW * dqDZ - dqRZ * dqDW));
        this.rX = dqRX;
        this.rY = dqRY;
        this.rZ = dqRZ;
        this.rW = dqRW;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to the decomposition of the given matrix's linear {@code R * S} block,
     * with zero translation (scale is removed by normalizing the columns, but shear is not removed:
     * a sheared block yields a rotation quaternion that is not unit length).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleTransform makeFromMatrix(Double3x3R m) {
        double _t12 = m.m01() * m.m01() + m.m11() * m.m11() + m.m21() * m.m21();
        double _t13 = m.m02() * m.m02() + m.m12() * m.m12() + m.m22() * m.m22();
        double _t14 = m.m00() * m.m00() + m.m10() * m.m10() + m.m20() * m.m20();
        double _t15 = (1.0 / Math.sqrt(_t12));
        double _t16 = (1.0 / Math.sqrt(_t13));
        double _t17 = (1.0 / Math.sqrt(_t14));
        double _t18 = Math.sqrt(_t14);
        double _t19 = m.m11() * _t15;
        double _t20 = m.m22() * _t16;
        double _t21 = m.m10() * _t17;
        double _t22 = m.m21() * _t15;
        double _t23 = m.m20() * _t17;
        double _t24 = m.m02() * _t16;
        double _t25 = m.m12() * _t16;
        double _t26 = m.m00() * _t17;
        double _t27 = m.m01() * _t15;
        double _t37 = _t22 - _t25;
        double _t38 = Math.max(_t19, _t20);
        double _t39 = _t25 + _t22;
        double _t47 = (_t21 * _t22 - _t19 * _t23) * _t24 + (_t19 * _t20 - _t25 * _t22) * _t26 - (_t21 * _t20 - _t25 * _t23) * _t27;
        double _t48, _t49, _t50;
        if (_t47 < 0.0) {
            _t48 = -_t26;
            _t49 = -_t21;
            _t50 = -_t23;
        } else {
            _t48 = _t26;
            _t49 = _t21;
            _t50 = _t23;
        }
        double _t51 = 1.0 + _t48;
        double _t52 = 1.0 - _t48;
        double _t54 = _t27 + _t49;
        double _t55 = _t24 + _t50;
        double _t56 = _t24 - _t50;
        double _t57 = _t49 - _t27;
        double _t62 = _t19 + (_t20 + _t48);
        double _t63 = _t19 + (_t20 + _t51);
        double _t64 = _t51 - _t20 - _t19;
        double _t65 = _t19 + (_t52 - _t20);
        double _t66 = _t20 + (_t52 - _t19);
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t65));
        double _t69 = (1.0 / Math.sqrt(_t66));
        double _t70 = (1.0 / Math.sqrt(_t64));
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t62 > 0.0 ? 0.5 * _t37 * _t67 : _t48 > _t38 ? 0.5 * Math.sqrt(_t64) : _t19 > _t20 ? 0.5 * _t54 * _t68 : 0.5 * _t55 * _t69;
        this.rY = _t62 > 0.0 ? 0.5 * _t56 * _t67 : _t48 > _t38 ? 0.5 * _t54 * _t70 : _t19 > _t20 ? 0.5 * Math.sqrt(_t65) : 0.5 * _t39 * _t69;
        this.rZ = _t62 > 0.0 ? 0.5 * _t57 * _t67 : _t48 > _t38 ? 0.5 * _t55 * _t70 : _t19 > _t20 ? 0.5 * _t39 * _t68 : 0.5 * Math.sqrt(_t66);
        this.rW = _t62 > 0.0 ? 0.5 * Math.sqrt(_t63) : _t48 > _t38 ? 0.5 * _t37 * _t70 : _t19 > _t20 ? 0.5 * _t56 * _t68 : 0.5 * _t57 * _t69;
        this.sX = _t47 < 0.0 ? -_t18 : _t18;
        this.sY = Math.sqrt(_t12);
        this.sZ = Math.sqrt(_t13);
        return this;
    }


    /**
     * Set this transform to the TRS decomposition of the given affine matrix: translation from the
     * last column, scale from the column lengths of the upper-left 3x3 block, rotation from the
     * column-normalized block (scale is removed by normalizing the columns, but shear is not
     * removed: a sheared block yields a rotation quaternion that is not unit length).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleTransform makeFromMatrix(Double3x4R m) {
        double _t12 = m.m01() * m.m01() + m.m11() * m.m11() + m.m21() * m.m21();
        double _t13 = m.m02() * m.m02() + m.m12() * m.m12() + m.m22() * m.m22();
        double _t14 = m.m00() * m.m00() + m.m10() * m.m10() + m.m20() * m.m20();
        double _t15 = (1.0 / Math.sqrt(_t12));
        double _t16 = (1.0 / Math.sqrt(_t13));
        double _t17 = (1.0 / Math.sqrt(_t14));
        double _t18 = Math.sqrt(_t14);
        double _t19 = m.m11() * _t15;
        double _t20 = m.m22() * _t16;
        double _t21 = m.m10() * _t17;
        double _t22 = m.m21() * _t15;
        double _t23 = m.m20() * _t17;
        double _t24 = m.m02() * _t16;
        double _t25 = m.m12() * _t16;
        double _t26 = m.m00() * _t17;
        double _t27 = m.m01() * _t15;
        double _t37 = _t22 - _t25;
        double _t38 = Math.max(_t19, _t20);
        double _t39 = _t25 + _t22;
        double _t47 = (_t21 * _t22 - _t19 * _t23) * _t24 + (_t19 * _t20 - _t25 * _t22) * _t26 - (_t21 * _t20 - _t25 * _t23) * _t27;
        double _t48, _t49, _t50;
        if (_t47 < 0.0) {
            _t48 = -_t26;
            _t49 = -_t21;
            _t50 = -_t23;
        } else {
            _t48 = _t26;
            _t49 = _t21;
            _t50 = _t23;
        }
        double _t51 = 1.0 + _t48;
        double _t52 = 1.0 - _t48;
        double _t54 = _t27 + _t49;
        double _t55 = _t24 + _t50;
        double _t56 = _t24 - _t50;
        double _t57 = _t49 - _t27;
        double _t62 = _t19 + (_t20 + _t48);
        double _t63 = _t19 + (_t20 + _t51);
        double _t64 = _t51 - _t20 - _t19;
        double _t65 = _t19 + (_t52 - _t20);
        double _t66 = _t20 + (_t52 - _t19);
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t65));
        double _t69 = (1.0 / Math.sqrt(_t66));
        double _t70 = (1.0 / Math.sqrt(_t64));
        this.tX = m.m03();
        this.tY = m.m13();
        this.tZ = m.m23();
        this.rX = _t62 > 0.0 ? 0.5 * _t37 * _t67 : _t48 > _t38 ? 0.5 * Math.sqrt(_t64) : _t19 > _t20 ? 0.5 * _t54 * _t68 : 0.5 * _t55 * _t69;
        this.rY = _t62 > 0.0 ? 0.5 * _t56 * _t67 : _t48 > _t38 ? 0.5 * _t54 * _t70 : _t19 > _t20 ? 0.5 * Math.sqrt(_t65) : 0.5 * _t39 * _t69;
        this.rZ = _t62 > 0.0 ? 0.5 * _t57 * _t67 : _t48 > _t38 ? 0.5 * _t55 * _t70 : _t19 > _t20 ? 0.5 * _t39 * _t68 : 0.5 * Math.sqrt(_t66);
        this.rW = _t62 > 0.0 ? 0.5 * Math.sqrt(_t63) : _t48 > _t38 ? 0.5 * _t37 * _t70 : _t19 > _t20 ? 0.5 * _t56 * _t68 : 0.5 * _t57 * _t69;
        this.sX = _t47 < 0.0 ? -_t18 : _t18;
        this.sY = Math.sqrt(_t12);
        this.sZ = Math.sqrt(_t13);
        return this;
    }


    /**
     * Set this transform to the TRS decomposition of the given affine matrix: translation from the
     * last column, scale from the column lengths of the upper-left 3x3 block, rotation from the
     * column-normalized block (scale is removed by normalizing the columns, but shear is not
     * removed: a sheared block yields a rotation quaternion that is not unit length).
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleTransform makeFromMatrix(Double4x4R m) {
        double _t12 = m.m01() * m.m01() + m.m11() * m.m11() + m.m21() * m.m21();
        double _t13 = m.m02() * m.m02() + m.m12() * m.m12() + m.m22() * m.m22();
        double _t14 = m.m00() * m.m00() + m.m10() * m.m10() + m.m20() * m.m20();
        double _t15 = (1.0 / Math.sqrt(_t12));
        double _t16 = (1.0 / Math.sqrt(_t13));
        double _t17 = (1.0 / Math.sqrt(_t14));
        double _t18 = Math.sqrt(_t14);
        double _t19 = m.m11() * _t15;
        double _t20 = m.m22() * _t16;
        double _t21 = m.m10() * _t17;
        double _t22 = m.m21() * _t15;
        double _t23 = m.m20() * _t17;
        double _t24 = m.m02() * _t16;
        double _t25 = m.m12() * _t16;
        double _t26 = m.m00() * _t17;
        double _t27 = m.m01() * _t15;
        double _t37 = _t22 - _t25;
        double _t38 = Math.max(_t19, _t20);
        double _t39 = _t25 + _t22;
        double _t47 = (_t21 * _t22 - _t19 * _t23) * _t24 + (_t19 * _t20 - _t25 * _t22) * _t26 - (_t21 * _t20 - _t25 * _t23) * _t27;
        double _t48, _t49, _t50;
        if (_t47 < 0.0) {
            _t48 = -_t26;
            _t49 = -_t21;
            _t50 = -_t23;
        } else {
            _t48 = _t26;
            _t49 = _t21;
            _t50 = _t23;
        }
        double _t51 = 1.0 + _t48;
        double _t52 = 1.0 - _t48;
        double _t54 = _t27 + _t49;
        double _t55 = _t24 + _t50;
        double _t56 = _t24 - _t50;
        double _t57 = _t49 - _t27;
        double _t62 = _t19 + (_t20 + _t48);
        double _t63 = _t19 + (_t20 + _t51);
        double _t64 = _t51 - _t20 - _t19;
        double _t65 = _t19 + (_t52 - _t20);
        double _t66 = _t20 + (_t52 - _t19);
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t65));
        double _t69 = (1.0 / Math.sqrt(_t66));
        double _t70 = (1.0 / Math.sqrt(_t64));
        this.tX = m.m03();
        this.tY = m.m13();
        this.tZ = m.m23();
        this.rX = _t62 > 0.0 ? 0.5 * _t37 * _t67 : _t48 > _t38 ? 0.5 * Math.sqrt(_t64) : _t19 > _t20 ? 0.5 * _t54 * _t68 : 0.5 * _t55 * _t69;
        this.rY = _t62 > 0.0 ? 0.5 * _t56 * _t67 : _t48 > _t38 ? 0.5 * _t54 * _t70 : _t19 > _t20 ? 0.5 * Math.sqrt(_t65) : 0.5 * _t39 * _t69;
        this.rZ = _t62 > 0.0 ? 0.5 * _t57 * _t67 : _t48 > _t38 ? 0.5 * _t55 * _t70 : _t19 > _t20 ? 0.5 * _t39 * _t68 : 0.5 * Math.sqrt(_t66);
        this.rW = _t62 > 0.0 ? 0.5 * Math.sqrt(_t63) : _t48 > _t38 ? 0.5 * _t37 * _t70 : _t19 > _t20 ? 0.5 * _t56 * _t68 : 0.5 * _t57 * _t69;
        this.sX = _t47 < 0.0 ? -_t18 : _t18;
        this.sY = Math.sqrt(_t12);
        this.sZ = Math.sqrt(_t13);
        return this;
    }


    /**
     * Set this transform to the given rigid transform's motion (translation and rotation), with
     * scale = 1.
     *
     * @param r the rigid transform
     * @return this
     */
    public @Mutated DoubleTransform makeFromRigid(DoubleRigidR r) {
        return makeFromRigid(r.tX(), r.tY(), r.tZ(), r.rX(), r.rY(), r.rZ(), r.rW());
    }


    /**
     * Set this transform to the given rigid transform's motion (translation and rotation), with
     * scale = 1.
     *
     * @param rTX the {@code tX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTY the {@code tY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rTZ the {@code tZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRX the {@code rX} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRY the {@code rY} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRZ the {@code rZ} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @param rRW the {@code rW} component of the rigid transform
     *        {@code (rTX, rTY, rTZ, rRX, rRY, rRZ, rRW)}
     * @return this
     */
    @Mutated public DoubleTransform makeFromRigid(double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        this.tX = rTX;
        this.tY = rTY;
        this.tZ = rTZ;
        this.rX = rRX;
        this.rY = rRY;
        this.rZ = rRZ;
        this.rW = rRW;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Convert this transform's rigid motion (rotation and translation) to a unit dual quaternion;
     * the scale is dropped (dual quaternions cannot represent it) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        double _buf0 = this.rX;
        double _buf1 = this.rY;
        double _buf2 = this.rZ;
        double _buf3 = this.rW;
        double _buf4 = 0.5 * (this.tX * this.rW + this.tY * this.rZ - this.tZ * this.rY);
        double _buf5 = 0.5 * (this.tY * this.rW - this.tX * this.rZ + this.tZ * this.rX);
        d.dZ = 0.5 * (this.tX * this.rY - this.tY * this.rX + this.tZ * this.rW);
        d.dW = 0.5 * (-(this.tX * this.rX) - this.tY * this.rY - this.tZ * this.rZ);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        d.rW = _buf3;
        d.dX = _buf4;
        d.dY = _buf5;
        return d;
    }


    /**
     * Compute the matrix representation of this transform and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t1 = this.rZ * this.rZ;
        double _t2 = this.rX * this.rY;
        double _t3 = this.rZ * this.rW;
        double _t4 = this.rX * this.rZ;
        double _t5 = this.rY * this.rW;
        double _t6 = this.rX * this.rX;
        double _t7 = this.rY * this.rZ;
        double _t8 = this.rX * this.rW;
        double _buf0 = this.sX * (1.0 - 2.0 * (_t0 + _t1));
        d.m10 = this.sX * 2.0 * (_t2 + _t3);
        double _buf1 = this.sX * 2.0 * (_t4 - _t5);
        d.m30 = 0.0;
        double _buf2 = this.sY * 2.0 * (_t2 - _t3);
        d.m11 = this.sY * (1.0 - 2.0 * (_t6 + _t1));
        double _buf3 = this.sY * 2.0 * (_t8 + _t7);
        d.m31 = 0.0;
        double _buf4 = this.sZ * 2.0 * (_t4 + _t5);
        d.m12 = this.sZ * 2.0 * (_t7 - _t8);
        d.m22 = this.sZ * (1.0 - 2.0 * (_t6 + _t0));
        d.m32 = 0.0;
        d.m03 = this.tX;
        d.m13 = this.tY;
        d.m23 = this.tZ;
        d.m33 = 1.0;
        d.m00 = _buf0;
        d.m20 = _buf1;
        d.m01 = _buf2;
        d.m21 = _buf3;
        d.m02 = _buf4;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Compute the 3x3 linear block ({@code R * S}) of this transform (the translation is dropped)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t1 = this.rZ * this.rZ;
        double _t2 = this.rX * this.rY;
        double _t3 = this.rZ * this.rW;
        double _t4 = this.rX * this.rZ;
        double _t5 = this.rY * this.rW;
        double _t6 = this.rX * this.rX;
        double _t7 = this.rY * this.rZ;
        double _t8 = this.rX * this.rW;
        d.m00 = this.sX * (1.0 - 2.0 * (_t0 + _t1));
        d.m10 = this.sX * 2.0 * (_t2 + _t3);
        d.m20 = this.sX * 2.0 * (_t4 - _t5);
        d.m01 = this.sY * 2.0 * (_t2 - _t3);
        d.m11 = this.sY * (1.0 - 2.0 * (_t6 + _t1));
        d.m21 = this.sY * 2.0 * (_t8 + _t7);
        d.m02 = this.sZ * 2.0 * (_t4 + _t5);
        d.m12 = this.sZ * 2.0 * (_t7 - _t8);
        d.m22 = this.sZ * (1.0 - 2.0 * (_t6 + _t0));
        d.properties = 0;
        return d;
    }


    /**
     * Compute the 3x4 matrix representation of this transform (the omitted last row is implicitly
     * {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t1 = this.rZ * this.rZ;
        double _t2 = this.rX * this.rY;
        double _t3 = this.rZ * this.rW;
        double _t4 = this.rX * this.rZ;
        double _t5 = this.rY * this.rW;
        double _t6 = this.rX * this.rX;
        double _t7 = this.rY * this.rZ;
        double _t8 = this.rX * this.rW;
        double _buf0 = this.sX * (1.0 - 2.0 * (_t0 + _t1));
        double _buf1 = this.sY * 2.0 * (_t2 - _t3);
        double _buf2 = this.sZ * 2.0 * (_t4 + _t5);
        d.m03 = this.tX;
        d.m10 = this.sX * 2.0 * (_t2 + _t3);
        d.m11 = this.sY * (1.0 - 2.0 * (_t6 + _t1));
        d.m12 = this.sZ * 2.0 * (_t7 - _t8);
        double _buf3 = this.tY;
        double _buf4 = this.sX * 2.0 * (_t4 - _t5);
        double _buf5 = this.sY * 2.0 * (_t8 + _t7);
        d.m22 = this.sZ * (1.0 - 2.0 * (_t6 + _t0));
        d.m23 = this.tZ;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m13 = _buf3;
        d.m20 = _buf4;
        d.m21 = _buf5;
        d.properties = Joml.BIT_AFFINE;
        return d;
    }


    /**
     * Narrow this transform to a rigid transform (translation and rotation; the scale is dropped)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid toRigid(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        return d;
    }


    /**
     * Convert this transform to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatTransform toFloat(@Mutated FloatTransform dest) {
        FloatTransformImpl d = (FloatTransformImpl) dest;
        d.tX = (float) (this.tX);
        d.tY = (float) (this.tY);
        d.tZ = (float) (this.tZ);
        d.rX = (float) (this.rX);
        d.rY = (float) (this.rY);
        d.rZ = (float) (this.rZ);
        d.rW = (float) (this.rW);
        d.sX = (float) (this.sX);
        d.sY = (float) (this.sY);
        d.sZ = (float) (this.sZ);
        return d;
    }


    /**
     * Set this transform to the identity.
     *
     * @return this
     */
    @Mutated public DoubleTransform makeIdentity() {
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a pure rotation by {@code rotation} (zero translation, unit scale).
     *
     * @param rotation the quaternion
     * @return this
     */
    public @Mutated DoubleTransform set(DoubleQuatR rotation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set this transform to a pure rotation by ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) (zero translation, unit scale).
     *
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
    @Mutated public DoubleTransform set(double rotationX, double rotationY, double rotationZ, double rotationW) {
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a pure translation by {@code translation} (identity rotation, unit
     * scale).
     *
     * @param translation the vector
     * @return this
     */
    public @Mutated DoubleTransform set(Double3R translation) {
        return set(translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this transform to a pure translation by ({@code translationX}, {@code translationY},
     * {@code translationZ}) (identity rotation, unit scale).
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated public DoubleTransform set(double translationX, double translationY, double translationZ) {
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Interpolate between this transform and {@code other} using the interpolation factor
     * {@code t}, interpolating translation and scale linearly and the rotation via shortest-arc
     * slerp and store the result in {@code dest}.
     *
     * @param other the other transform
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform lerp(DoubleTransformR other, double t, @Mutated DoubleTransform dest) {
        return lerp(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), other.sX(), other.sY(), other.sZ(), t, dest);
    }


    /**
     * Interpolate between this transform and ({@code otherTX}, {@code otherTY}, {@code otherTZ},
     * {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherSX},
     * {@code otherSY}, {@code otherSZ}) using the interpolation factor {@code t}, interpolating
     * translation and scale linearly and the rotation via shortest-arc slerp and store the result
     * in {@code dest}.
     *
     * @param otherTX the {@code tX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTY the {@code tY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTZ the {@code tZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRX the {@code rX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRY the {@code rY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRZ the {@code rZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRW the {@code rW} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSX the {@code sX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSY the {@code sY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSZ the {@code sZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform lerp(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, double otherSX, double otherSY, double otherSZ, double t, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 1.0 - t;
        double _t15 = otherRX * this.rX + otherRY * this.rY + otherRZ * this.rZ + otherRW * this.rW;
        double _t17 = -_t15;
        double _t19 = Math.acos(Math.min(1.0, Math.abs(_t15)));
        double _t20 = Math.sin(_t19);
        double _t20_inv = 1.0 / _t20;
        double _t22 = Math.sin(t * _t19);
        double _t24, _t25, _t26, _t27;
        if (_t17 > 0.0) {
            _t24 = -otherRX;
            _t25 = -otherRY;
            _t26 = -otherRZ;
            _t27 = -otherRW;
        } else {
            _t24 = otherRX;
            _t25 = otherRY;
            _t26 = otherRZ;
            _t27 = otherRW;
        }
        double _t28 = Math.sin(_t0 * _t19);
        double _t53, _t54, _t55, _t56;
        if (_t20 > 0.0) {
            _t53 = (this.rX * _t28 + _t22 * _t24) * _t20_inv;
            _t54 = (this.rY * _t28 + _t22 * _t25) * _t20_inv;
            _t55 = (this.rZ * _t28 + _t22 * _t26) * _t20_inv;
            _t56 = (this.rW * _t28 + _t22 * _t27) * _t20_inv;
        } else {
            _t53 = t * _t24 + this.rX * _t0;
            _t54 = t * _t25 + this.rY * _t0;
            _t55 = t * _t26 + this.rZ * _t0;
            _t56 = t * _t27 + this.rW * _t0;
        }
        double _t63 = _t53 * _t53 + _t54 * _t54 + _t55 * _t55 + _t56 * _t56;
        double _t64 = (1.0 / Math.sqrt(_t63));
        if (_t63 > 0.0) {
            d.rX = _t64 * _t53;
            d.rY = _t64 * _t54;
            d.rZ = _t64 * _t55;
            d.rW = _t64 * _t56;
        } else {
            d.rX = 0.0;
            d.rY = 0.0;
            d.rZ = 0.0;
            d.rW = 0.0;
        }
        d.tX = t * (otherTX - this.tX) + this.tX;
        d.tY = t * (otherTY - this.tY) + this.tY;
        d.tZ = t * (otherTZ - this.tZ) + this.tZ;
        d.sX = t * (otherSX - this.sX) + this.sX;
        d.sY = t * (otherSY - this.sY) + this.sY;
        d.sZ = t * (otherSZ - this.sZ) + this.sZ;
        return d;
    }


    /**
     * Multiply this transform by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the operand, then the new transform will
     * be {@code M * R}. So when transforming a vector {@code v} with the new transform by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param other the other transform
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform mul(DoubleTransformR other, @Mutated DoubleTransform dest) {
        return mul(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), other.sX(), other.sY(), other.sZ(), dest);
    }


    /**
     * Multiply this transform by ({@code otherTX}, {@code otherTY}, {@code otherTZ},
     * {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherSX},
     * {@code otherSY}, {@code otherSZ}) and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the operand, then the new transform will
     * be {@code M * R}. So when transforming a vector {@code v} with the new transform by using
     * {@code M * R * v}, the transformation of the operand will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param otherTX the {@code tX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTY the {@code tY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTZ the {@code tZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRX the {@code rX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRY the {@code rY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRZ the {@code rZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRW the {@code rW} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSX the {@code sX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSY the {@code sY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSZ the {@code sZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform mul(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, double otherSX, double otherSY, double otherSZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = otherTY * this.sY;
        double _t1 = otherTX * this.sX;
        double _t2 = otherTZ * this.sZ;
        double _t12 = 2.0 * (this.rX * _t0 - this.rY * _t1);
        double _t13 = 2.0 * (this.rY * _t2 - this.rZ * _t0);
        double _t14 = 2.0 * (this.rZ * _t1 - this.rX * _t2);
        d.tX = this.rY * _t12 + (this.rW * _t13 + (_t1 + this.tX) - this.rZ * _t14);
        d.tY = this.rZ * _t13 + (this.rW * _t14 + (_t0 + this.tY) - this.rX * _t12);
        d.tZ = this.rX * _t14 + (this.rW * _t12 + (_t2 + this.tZ) - this.rY * _t13);
        double _buf0 = otherRX * this.rW + otherRW * this.rX + (otherRZ * this.rY - otherRY * this.rZ);
        double _buf1 = otherRY * this.rW + otherRW * this.rY + (otherRX * this.rZ - otherRZ * this.rX);
        double _buf2 = otherRZ * this.rW + otherRW * this.rZ + (otherRY * this.rX - otherRX * this.rY);
        d.rW = otherRW * this.rW - otherRX * this.rX - otherRY * this.rY - otherRZ * this.rZ;
        d.sX = otherSX * this.sX;
        d.sY = otherSY * this.sY;
        d.sZ = otherSZ * this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Pre-multiply {@code other} onto this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the operand, then the new transform will
     * be {@code R * M}. So when transforming a vector {@code v} with the new transform by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param other the other transform
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform preMul(DoubleTransformR other, @Mutated DoubleTransform dest) {
        return preMul(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), other.sX(), other.sY(), other.sZ(), dest);
    }


    /**
     * Pre-multiply ({@code otherTX}, {@code otherTY}, {@code otherTZ}, {@code otherRX},
     * {@code otherRY}, {@code otherRZ}, {@code otherRW}, {@code otherSX}, {@code otherSY},
     * {@code otherSZ}) onto this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the operand, then the new transform will
     * be {@code R * M}. So when transforming a vector {@code v} with the new transform by using
     * {@code R * M * v}, the transformation of the operand will be applied last.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param otherTX the {@code tX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTY the {@code tY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTZ the {@code tZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRX the {@code rX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRY the {@code rY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRZ the {@code rZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRW the {@code rW} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSX the {@code sX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSY the {@code sY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSZ the {@code sZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform preMul(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, double otherSX, double otherSY, double otherSZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = otherSY * this.tY;
        double _t1 = otherSX * this.tX;
        double _t2 = otherSZ * this.tZ;
        double _t12 = 2.0 * (otherRX * _t0 - otherRY * _t1);
        double _t13 = 2.0 * (otherRY * _t2 - otherRZ * _t0);
        double _t14 = 2.0 * (otherRZ * _t1 - otherRX * _t2);
        d.tX = otherRY * _t12 + (otherRW * _t13 + (_t1 + otherTX) - otherRZ * _t14);
        d.tY = otherRZ * _t13 + (otherRW * _t14 + (_t0 + otherTY) - otherRX * _t12);
        d.tZ = otherRX * _t14 + (otherRW * _t12 + (_t2 + otherTZ) - otherRY * _t13);
        double _buf0 = otherRX * this.rW + otherRW * this.rX + (otherRY * this.rZ - otherRZ * this.rY);
        double _buf1 = otherRY * this.rW + otherRW * this.rY + (otherRZ * this.rX - otherRX * this.rZ);
        double _buf2 = otherRZ * this.rW + otherRW * this.rZ + (otherRX * this.rY - otherRY * this.rX);
        d.rW = otherRW * this.rW - otherRX * this.rX - otherRY * this.rY - otherRZ * this.rZ;
        d.sX = otherSX * this.sX;
        d.sY = otherSY * this.sY;
        d.sZ = otherSZ * this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Compute the difference between this transform and {@code other}, i.e. the
     * translation-rotation-scale transformation {@code D} with {@code this * D = other}, that is
     * {@code D = this^-1 * other} and store the result in {@code dest}.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param other the other transform
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform difference(DoubleTransformR other, @Mutated DoubleTransform dest) {
        return difference(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), other.sX(), other.sY(), other.sZ(), dest);
    }


    /**
     * Compute the difference between this transform and ({@code otherTX}, {@code otherTY},
     * {@code otherTZ}, {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW},
     * {@code otherSX}, {@code otherSY}, {@code otherSZ}), i.e. the translation-rotation-scale
     * transformation {@code D} with
     * {@code this * D = (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)},
     * that is
     * {@code D = this^-1 * (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * and store the result in {@code dest}.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param otherTX the {@code tX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTY the {@code tY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherTZ the {@code tZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRX the {@code rX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRY the {@code rY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRZ the {@code rZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherRW the {@code rW} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSX the {@code sX} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSY the {@code sY} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param otherSZ the {@code sZ} component of the transform
     *        {@code (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW, otherSX, otherSY, otherSZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform difference(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, double otherSX, double otherSY, double otherSZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _rcp0 = 1.0 / this.sZ;
        double _rcp1 = 1.0 / this.sX;
        double _rcp2 = 1.0 / this.sY;
        double _t30 = 2.0 * (otherTZ * this.rX * _rcp0 - otherTX * this.rZ * _rcp1);
        double _t31 = 2.0 * (otherTX * this.rY * _rcp1 - otherTY * this.rX * _rcp2);
        double _t32 = 2.0 * (otherTY * this.rZ * _rcp2 - otherTZ * this.rY * _rcp0);
        double _t33 = 2.0 * (this.tX * this.rZ * _rcp1 - this.tZ * this.rX * _rcp0);
        double _t34 = 2.0 * (this.tY * this.rX * _rcp2 - this.tX * this.rY * _rcp1);
        double _t35 = 2.0 * (this.tZ * this.rY * _rcp0 - this.tY * this.rZ * _rcp2);
        d.tX = this.rZ * _t30 - this.rY * _t31 + (this.rW * _t32 + otherTX * _rcp1) + (this.rZ * _t33 - this.rY * _t34 + (this.rW * _t35 - this.tX * _rcp1));
        d.tY = this.rX * _t31 - this.rZ * _t32 + (this.rW * _t30 + otherTY * _rcp2) + (this.rX * _t34 - this.rZ * _t35 + (this.rW * _t33 - this.tY * _rcp2));
        d.tZ = this.rY * _t32 - this.rX * _t30 + (this.rW * _t31 + otherTZ * _rcp0) + (this.rY * _t35 - this.rX * _t33 + (this.rW * _t34 - this.tZ * _rcp0));
        double _buf0 = otherRX * this.rW - otherRW * this.rX + (otherRY * this.rZ - otherRZ * this.rY);
        double _buf1 = otherRY * this.rW - otherRW * this.rY + (otherRZ * this.rX - otherRX * this.rZ);
        double _buf2 = otherRX * this.rY - otherRY * this.rX + (otherRZ * this.rW - otherRW * this.rZ);
        d.rW = otherRX * this.rX + otherRW * this.rW + otherRY * this.rY + otherRZ * this.rZ;
        d.sX = otherSX * _rcp1;
        d.sY = otherSY * _rcp2;
        d.sZ = otherSZ * _rcp0;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Invert this transform (translation-rotation-scale, without shear); a zero scale axis yields
     * positive infinity in the corresponding inverse scale and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform invert(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _rcp0 = 1.0 / this.sX;
        double _rcp1 = 1.0 / this.sZ;
        double _rcp2 = 1.0 / this.sY;
        double _t15 = 2.0 * (this.tX * this.rZ * _rcp0 - this.tZ * this.rX * _rcp1);
        double _t16 = 2.0 * (this.tZ * this.rY * _rcp1 - this.tY * this.rZ * _rcp2);
        double _t17 = 2.0 * (this.tY * this.rX * _rcp2 - this.tX * this.rY * _rcp0);
        d.tX = this.rZ * _t15 + (this.rW * _t16 - this.tX * _rcp0 - this.rY * _t17);
        d.tY = this.rX * _t17 + (this.rW * _t15 - this.tY * _rcp2 - this.rZ * _t16);
        d.tZ = this.rY * _t16 + (this.rW * _t17 - this.tZ * _rcp1 - this.rX * _t15);
        d.rX = -this.rX;
        d.rY = -this.rY;
        d.rZ = -this.rZ;
        d.rW = this.rW;
        d.sX = 1.0 * _rcp0;
        d.sY = 1.0 * _rcp2;
        d.sZ = 1.0 * _rcp1;
        return d;
    }


    /**
     * Normalize this transform so that its rotation part has unit length, leaving its translation
     * and scale unchanged (a zero-length rotation yields the zero quaternion) and store the result
     * in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the rotation quaternion must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform normalize(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t6 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ + this.rW * this.rW;
        double _t7 = (1.0 / Math.sqrt(_t6));
        if (_t6 > 0.0) {
            d.rX = this.rX * _t7;
            d.rY = this.rY * _t7;
            d.rZ = this.rZ * _t7;
            d.rW = this.rW * _t7;
        } else {
            d.rX = 0.0;
            d.rY = 0.0;
            d.rZ = 0.0;
            d.rW = 0.0;
        }
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        return d;
    }


    /**
     * Get the Euler angles in radians of this transform, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rX * this.rX;
        double _t1 = this.rY * this.rY;
        double _t2 = this.rX * this.rW;
        double _t3 = this.rY * this.rZ;
        double _t6 = this.rZ * this.rZ;
        double _t11 = 2.0 * (_t2 - _t3);
        double _t12 = 2.0 * (this.rX * this.rZ + this.rY * this.rW);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            d.x = Math.atan2(2.0 * (_t2 + _t3), 1.0 - 2.0 * (_t0 + _t6));
            d.z = 0.0;
        } else {
            d.x = Math.atan2(_t11, _t13);
            d.z = Math.atan2(2.0 * (this.rZ * this.rW - this.rX * this.rY), 1.0 - 2.0 * (_t1 + _t6));
        }
        d.y = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this transform, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rX * this.rX;
        double _t1 = this.rZ * this.rZ;
        double _t2 = this.rX * this.rW;
        double _t3 = this.rY * this.rZ;
        double _t6 = this.rY * this.rY;
        double _t11 = 2.0 * (_t2 + _t3);
        double _t12 = 2.0 * (this.rZ * this.rW - this.rX * this.rY);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            d.x = Math.atan2(2.0 * (_t2 - _t3), 1.0 - 2.0 * (_t0 + _t6));
            d.y = 0.0;
        } else {
            d.x = Math.atan2(_t11, _t13);
            d.y = Math.atan2(2.0 * (this.rX * this.rZ + this.rY * this.rW), 1.0 - 2.0 * (_t6 + _t1));
        }
        d.z = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this transform, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = this.rX * this.rX;
        double _t3 = this.rY * this.rY;
        double _t4 = this.rX * this.rZ;
        double _t5 = this.rY * this.rW;
        double _t6 = this.rZ * this.rZ;
        double _t10 = 2.0 * (this.rX * this.rW - this.rY * this.rZ);
        double _t12 = 2.0 * (_t4 + _t5);
        double _t13 = 1.0 - 2.0 * (_t2 + _t3);
        double _t17 = _t13 * _t13 + _t12 * _t12;
        double _t19 = (_t17 + _t10 * _t10) * 1.0E-15;
        if (_t17 < _t19) {
            d.y = Math.atan2(2.0 * (_t5 - _t4), 1.0 - 2.0 * (_t3 + _t6));
            d.z = 0.0;
        } else {
            d.y = Math.atan2(_t12, _t13);
            d.z = Math.atan2(2.0 * (this.rX * this.rY + this.rZ * this.rW), 1.0 - 2.0 * (_t2 + _t6));
        }
        d.x = Math.atan2(_t10, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this transform, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t1 = this.rZ * this.rZ;
        double _t2 = this.rY * this.rW;
        double _t3 = this.rX * this.rZ;
        double _t6 = this.rX * this.rX;
        double _t11 = 2.0 * (_t2 - _t3);
        double _t12 = 2.0 * (this.rX * this.rY + this.rZ * this.rW);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            d.x = 0.0;
            d.y = Math.atan2(2.0 * (_t3 + _t2), 1.0 - 2.0 * (_t6 + _t0));
        } else {
            d.x = Math.atan2(2.0 * (this.rX * this.rW - this.rY * this.rZ), 1.0 - 2.0 * (_t6 + _t1));
            d.y = Math.atan2(_t11, _t13);
        }
        d.z = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this transform, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = this.rX * this.rX;
        double _t3 = this.rZ * this.rZ;
        double _t4 = this.rZ * this.rW;
        double _t5 = this.rX * this.rY;
        double _t6 = this.rY * this.rY;
        double _t10 = 2.0 * (this.rX * this.rW + this.rY * this.rZ);
        double _t12 = 2.0 * (_t4 - _t5);
        double _t13 = 1.0 - 2.0 * (_t2 + _t3);
        double _t17 = _t13 * _t13 + _t12 * _t12;
        double _t19 = (_t17 + _t10 * _t10) * 1.0E-15;
        if (_t17 < _t19) {
            d.y = 0.0;
            d.z = Math.atan2(2.0 * (_t5 + _t4), 1.0 - 2.0 * (_t6 + _t3));
        } else {
            d.y = Math.atan2(2.0 * (this.rY * this.rW - this.rX * this.rZ), 1.0 - 2.0 * (_t2 + _t6));
            d.z = Math.atan2(_t12, _t13);
        }
        d.x = Math.atan2(_t10, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this transform, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.rY * this.rY;
        double _t1 = this.rZ * this.rZ;
        double _t2 = this.rX * this.rY;
        double _t3 = this.rZ * this.rW;
        double _t6 = this.rX * this.rX;
        double _t11 = 2.0 * (_t2 + _t3);
        double _t12 = 2.0 * (this.rY * this.rW - this.rX * this.rZ);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            d.x = 0.0;
            d.z = Math.atan2(2.0 * (_t3 - _t2), 1.0 - 2.0 * (_t6 + _t1));
        } else {
            d.x = Math.atan2(2.0 * (this.rX * this.rW + this.rY * this.rZ), 1.0 - 2.0 * (_t6 + _t0));
            d.z = Math.atan2(_t11, _t13);
        }
        d.y = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the rotation of this transform and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getRotation(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = this.rX;
        d.y = this.rY;
        d.z = this.rZ;
        d.w = this.rW;
        return d;
    }


    /**
     * Get the scaling factors of this transform and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getScale(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.sX;
        d.y = this.sY;
        d.z = this.sZ;
        return d;
    }


    /**
     * Get the translation of this transform and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getTranslation(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.tX;
        d.y = this.tY;
        d.z = this.tZ;
        return d;
    }


    /**
     * Set this transform to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated DoubleTransform makeRotationAxis(double angle, Double3R axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Set this transform to a rotation of {@code angle} radians about the axis ({@code axisX},
     * {@code axisY}, {@code axisZ}).
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return this
     */
    @Mutated public DoubleTransform makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = Math.cos(_t0);
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleTransform makeRotationX(double angle) {
        double _t0 = 0.5 * angle;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = Math.sin(_t0);
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = Math.cos(_t0);
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians
     * about the X, Y and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a
     * vector is rotated about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleTransform makeRotationXYZ(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t5 + _t10 * _t8;
        this.rY = _t10 * _t5 - _t9 * _t8;
        this.rZ = _t11 * _t5 + _t12 * _t8;
        this.rW = _t12 * _t5 - _t11 * _t8;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians
     * about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a
     * vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleTransform makeRotationXZY(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t5 - _t10 * _t8;
        this.rY = _t11 * _t8 - _t12 * _t5;
        this.rZ = _t9 * _t8 + _t10 * _t5;
        this.rW = _t12 * _t8 + _t11 * _t5;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleTransform makeRotationY(double angle) {
        double _t0 = 0.5 * angle;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = Math.sin(_t0);
        this.rZ = 0.0;
        this.rW = Math.cos(_t0);
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians
     * about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a
     * vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleTransform makeRotationYXZ(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t5 + _t10 * _t8;
        this.rY = _t10 * _t5 - _t9 * _t8;
        this.rZ = _t11 * _t8 - _t12 * _t5;
        this.rW = _t12 * _t8 + _t11 * _t5;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians
     * about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a
     * vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleTransform makeRotationYZX(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t5 + _t10 * _t8;
        this.rY = _t11 * _t5 + _t12 * _t8;
        this.rZ = _t12 * _t5 - _t11 * _t8;
        this.rW = _t10 * _t5 - _t9 * _t8;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleTransform makeRotationZ(double angle) {
        double _t0 = 0.5 * angle;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = Math.sin(_t0);
        this.rW = Math.cos(_t0);
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians
     * about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a
     * vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleTransform makeRotationZXY(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t5 - _t10 * _t8;
        this.rY = _t11 * _t5 + _t12 * _t8;
        this.rZ = _t9 * _t8 + _t10 * _t5;
        this.rW = _t12 * _t5 - _t11 * _t8;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians
     * about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a
     * vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleTransform makeRotationZYX(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t5 - _t10 * _t8;
        this.rY = _t11 * _t8 + _t12 * _t5;
        this.rZ = _t12 * _t8 - _t11 * _t5;
        this.rW = _t10 * _t5 + _t9 * _t8;
        this.sX = 1.0;
        this.sY = 1.0;
        this.sZ = 1.0;
        return this;
    }


    /**
     * Set this transform to a scaling transformation that scales by {@code scale}.
     *
     * @param scale the scale factor
     * @return this
     */
    public @Mutated DoubleTransform makeScaling(Double3R scale) {
        return makeScaling(scale.x(), scale.y(), scale.z());
    }


    /**
     * Set this transform to a scaling transformation that scales by ({@code scaleX},
     * {@code scaleY}, {@code scaleZ}).
     *
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @return this
     */
    @Mutated public DoubleTransform makeScaling(double scaleX, double scaleY, double scaleZ) {
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        this.sX = scaleX;
        this.sY = scaleY;
        this.sZ = scaleZ;
        return this;
    }


    /**
     * Set this transform to a scaling transformation that scales by {@code scale}.
     *
     * @param scale the scale factor
     * @return this
     */
    @Mutated public DoubleTransform makeScaling(double scale) {
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        this.sX = scale;
        this.sY = scale;
        this.sZ = scale;
        return this;
    }


    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this transform and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param rotation the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotate(DoubleQuatR rotation, @Mutated DoubleTransform dest) {
        return rotate(rotation.x(), rotation.y(), rotation.z(), rotation.w(), dest);
    }


    /**
     * Apply the rotation represented by the quaternion ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) to this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotate(double rotationX, double rotationY, double rotationZ, double rotationW, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = rotationX * this.rW + rotationW * this.rX + (rotationZ * this.rY - rotationY * this.rZ);
        double _buf1 = rotationY * this.rW + rotationW * this.rY + (rotationX * this.rZ - rotationZ * this.rX);
        double _buf2 = rotationZ * this.rW + rotationW * this.rZ + (rotationY * this.rX - rotationX * this.rY);
        d.rW = rotationW * this.rW - rotationX * this.rX - rotationY * this.rY - rotationZ * this.rZ;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this transform and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateAxis(double angle, Double3R axis, @Mutated DoubleTransform dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t1 + this.rW * _t3 + (this.rY * _t4 - this.rZ * _t5);
        double _buf1 = this.rY * _t1 + this.rW * _t5 + (this.rZ * _t3 - this.rX * _t4);
        double _buf2 = this.rZ * _t1 + this.rW * _t4 + (this.rX * _t5 - this.rY * _t3);
        d.rW = this.rW * _t1 - this.rX * _t3 - this.rY * _t5 - this.rZ * _t4;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this transform and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateX(double angle, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t1 + this.rW * _t2;
        double _buf1 = this.rY * _t1 + this.rZ * _t2;
        d.rZ = this.rZ * _t1 - this.rY * _t2;
        d.rW = this.rW * _t1 - this.rX * _t2;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        return d;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateXYZ(double angleX, double angleY, double angleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t21 = _t9 * _t5 - _t10 * _t8;
        double _t22 = _t11 * _t5 + _t12 * _t8;
        double _t23 = _t10 * _t5 + _t9 * _t8;
        double _t24 = _t12 * _t5 - _t11 * _t8;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        double _buf1 = this.rY * _t21 + this.rW * _t24 + (this.rZ * _t22 - this.rX * _t23);
        double _buf2 = this.rZ * _t21 + this.rW * _t23 + (this.rX * _t24 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateXZY(double angleX, double angleY, double angleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t21 = _t9 * _t5 + _t10 * _t8;
        double _t22 = _t11 * _t8 - _t12 * _t5;
        double _t23 = _t11 * _t5 + _t12 * _t8;
        double _t24 = _t10 * _t5 - _t9 * _t8;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        double _buf1 = this.rY * _t21 + this.rW * _t24 + (this.rZ * _t22 - this.rX * _t23);
        double _buf2 = this.rZ * _t21 + this.rW * _t23 + (this.rX * _t24 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this transform and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateY(double angle, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t1 - this.rZ * _t2;
        double _buf1 = this.rY * _t1 + this.rW * _t2;
        d.rZ = this.rX * _t2 + this.rZ * _t1;
        d.rW = this.rW * _t1 - this.rY * _t2;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        return d;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateYXZ(double angleX, double angleY, double angleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t21 = _t9 * _t5 + _t10 * _t8;
        double _t22 = _t11 * _t8 + _t12 * _t5;
        double _t23 = _t10 * _t5 - _t9 * _t8;
        double _t24 = _t12 * _t8 - _t11 * _t5;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        double _buf1 = this.rY * _t21 + this.rW * _t24 + (this.rZ * _t22 - this.rX * _t23);
        double _buf2 = this.rZ * _t21 + this.rW * _t23 + (this.rX * _t24 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateYZX(double angleX, double angleY, double angleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t3;
        double _t12 = _t6 * _t4;
        double _t21 = _t9 * _t5 - _t10 * _t8;
        double _t22 = _t10 * _t5 + _t9 * _t8;
        double _t23 = _t11 * _t5 - _t12 * _t8;
        double _t24 = _t12 * _t5 + _t11 * _t8;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        double _buf1 = this.rY * _t21 + this.rW * _t24 + (this.rZ * _t22 - this.rX * _t23);
        double _buf2 = this.rZ * _t21 + this.rW * _t23 + (this.rX * _t24 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this transform and store the
     * result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateZ(double angle, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t1 + this.rY * _t2;
        d.rY = this.rY * _t1 - this.rX * _t2;
        double _buf1 = this.rZ * _t1 + this.rW * _t2;
        d.rW = this.rW * _t1 - this.rZ * _t2;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rZ = _buf1;
        return d;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateZXY(double angleX, double angleY, double angleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t21 = _t9 * _t5 - _t10 * _t8;
        double _t22 = _t11 * _t5 - _t12 * _t8;
        double _t23 = _t11 * _t8 + _t12 * _t5;
        double _t24 = _t10 * _t5 + _t9 * _t8;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        double _buf1 = this.rY * _t21 + this.rW * _t24 + (this.rZ * _t22 - this.rX * _t23);
        double _buf2 = this.rZ * _t21 + this.rW * _t23 + (this.rX * _t24 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code R} the rotation transform, then the new
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * R * v}, the rotation will be applied first.
     * <p>
     * A transform carries no shear, so this composition is exact only for a uniform scale: under a
     * non-uniform scale the shear the product would have is dropped, and applying the result to a
     * point is then not the same as applying the operands one after the other (likewise
     * {@code invert()} composes with {@code this} to the identity but is not the pointwise inverse;
     * {@code transformPositionInverse} is).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform rotateZYX(double angleX, double angleY, double angleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t4 * _t6;
        double _t12 = _t3 * _t7;
        double _t21 = _t9 * _t5 + _t10 * _t8;
        double _t22 = _t10 * _t5 - _t9 * _t8;
        double _t23 = _t11 * _t8 - _t12 * _t5;
        double _t24 = _t12 * _t8 + _t11 * _t5;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t21 + this.rW * _t22 + (this.rY * _t23 - this.rZ * _t24);
        double _buf1 = this.rY * _t21 + this.rW * _t24 + (this.rZ * _t22 - this.rX * _t23);
        double _buf2 = this.rZ * _t21 + this.rW * _t23 + (this.rX * _t24 - this.rY * _t22);
        d.rW = this.rW * _t21 - this.rX * _t22 - this.rY * _t24 - this.rZ * _t23;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a scaling by {@code scale} to this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code S} the scaling transform, then the new
     * transform will be {@code M * S}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * S * v}, the scaling will be applied first.
     *
     * @param scale the scale factor
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform scale(Double3R scale, @Mutated DoubleTransform dest) {
        return scale(scale.x(), scale.y(), scale.z(), dest);
    }


    /**
     * Apply a scaling by ({@code scaleX}, {@code scaleY}, {@code scaleZ}) to this transform and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code S} the scaling transform, then the new
     * transform will be {@code M * S}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * S * v}, the scaling will be applied first.
     *
     * @param scaleX the {@code x} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleY the {@code y} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param scaleZ the {@code z} component of the vector {@code (scaleX, scaleY, scaleZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform scale(double scaleX, double scaleY, double scaleZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = scaleX * this.sX;
        d.sY = scaleY * this.sY;
        d.sZ = scaleZ * this.sZ;
        return d;
    }


    /**
     * Apply a scaling by {@code scale} to this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code S} the scaling transform, then the new
     * transform will be {@code M * S}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * S * v}, the scaling will be applied first.
     *
     * @param scale the scale factor
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform scale(double scale, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = scale * this.sX;
        d.sY = scale * this.sY;
        d.sZ = scale * this.sZ;
        return d;
    }


    /**
     * Apply a translation by {@code translation} to this transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code T} the translation transform, then the new
     * transform will be {@code M * T}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * T * v}, the translation will be applied first.
     *
     * @param translation the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform translate(Double3R translation, @Mutated DoubleTransform dest) {
        return translate(translation.x(), translation.y(), translation.z(), dest);
    }


    /**
     * Apply a translation by ({@code translationX}, {@code translationY}, {@code translationZ}) to
     * this transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} transform and {@code T} the translation transform, then the new
     * transform will be {@code M * T}. So when transforming a vector {@code v} with the new
     * transform by using {@code M * T * v}, the translation will be applied first.
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform translate(double translationX, double translationY, double translationZ, @Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        double _t0 = this.sY * translationY;
        double _t1 = this.sX * translationX;
        double _t2 = this.sZ * translationZ;
        double _t12 = 2.0 * (this.rX * _t0 - this.rY * _t1);
        double _t13 = 2.0 * (this.rY * _t2 - this.rZ * _t0);
        double _t14 = 2.0 * (this.rZ * _t1 - this.rX * _t2);
        d.tX = this.rY * _t12 + (this.rW * _t13 + (_t1 + this.tX) - this.rZ * _t14);
        d.tY = this.rZ * _t13 + (this.rW * _t14 + (_t0 + this.tY) - this.rX * _t12);
        d.tZ = this.rX * _t14 + (this.rW * _t12 + (_t2 + this.tZ) - this.rY * _t13);
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = this.sX;
        d.sY = this.sY;
        d.sZ = this.sZ;
        return d;
    }


    /**
     * Transform {@code v} by this transform and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Double3R v, @Mutated Double3 dest) {
        return transform(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this transform and store the result in
     * {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.sY * vY;
        double _t1 = this.sX * vX;
        double _t2 = this.sZ * vZ;
        double _t12 = 2.0 * (this.rX * _t0 - this.rY * _t1);
        double _t13 = 2.0 * (this.rY * _t2 - this.rZ * _t0);
        double _t14 = 2.0 * (this.rZ * _t1 - this.rX * _t2);
        d.x = this.rY * _t12 + (this.rW * _t13 + (_t1 + this.tX) - this.rZ * _t14);
        d.y = this.rZ * _t13 + (this.rW * _t14 + (_t0 + this.tY) - this.rX * _t12);
        d.z = this.rX * _t14 + (this.rW * _t12 + (_t2 + this.tZ) - this.rY * _t13);
        return d;
    }


    /**
     * Transform the given direction by the rotation part of this transform, ignoring translation
     * and scale and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(Double3R v, @Mutated Double3 dest) {
        return transformDirection(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the rotation part of this transform, ignoring translation
     * and scale and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (this.rX * vY - this.rY * vX);
        double _t10 = 2.0 * (this.rY * vZ - this.rZ * vY);
        double _t11 = 2.0 * (this.rZ * vX - this.rX * vZ);
        d.x = this.rY * _t9 + (this.rW * _t10 + vX - this.rZ * _t11);
        d.y = this.rZ * _t10 + (this.rW * _t11 + vY - this.rX * _t9);
        d.z = this.rX * _t11 + (this.rW * _t9 + vZ - this.rY * _t10);
        return d;
    }


    /**
     * Transform the given direction by the inverse of this transform's rotation (world to local),
     * ignoring translation and scale, without materializing {@code invert()} and store the result
     * in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(Double3R v, @Mutated Double3 dest) {
        return transformDirectionInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the inverse of this transform's rotation (world to local),
     * ignoring translation and scale, without materializing {@code invert()} and store the result
     * in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (this.rX * vZ - this.rZ * vX);
        double _t10 = 2.0 * (this.rZ * vY - this.rY * vZ);
        double _t11 = 2.0 * (this.rY * vX - this.rX * vY);
        d.x = this.rZ * _t9 + (this.rW * _t10 + vX - this.rY * _t11);
        d.y = this.rX * _t11 + (this.rW * _t9 + vY - this.rZ * _t10);
        d.z = this.rY * _t10 + (this.rW * _t11 + vZ - this.rX * _t9);
        return d;
    }


    /**
     * Transform {@code p} by the inverse of this transform and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(Double3R p, @Mutated Double3 dest) {
        return transformInverse(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by the inverse of this transform and store the
     * result in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(double pX, double pY, double pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = pZ - this.tZ;
        double _t1 = pX - this.tX;
        double _t2 = pY - this.tY;
        double _t12 = 2.0 * (this.rX * _t0 - this.rZ * _t1);
        double _t13 = 2.0 * (this.rZ * _t2 - this.rY * _t0);
        double _t14 = 2.0 * (this.rY * _t1 - this.rX * _t2);
        d.x = (this.rZ * _t12 + (this.rW * _t13 + _t1 - this.rY * _t14)) / this.sX;
        d.y = (this.rX * _t14 + (this.rW * _t12 + _t2 - this.rZ * _t13)) / this.sY;
        d.z = (this.rY * _t13 + (this.rW * _t14 + _t0 - this.rX * _t12)) / this.sZ;
        return d;
    }


    /**
     * Transform the given position by this transform, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(Double3R v, @Mutated Double3 dest) {
        return transform(v, dest);
    }


    /**
     * Transform the given position by this transform, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(double vX, double vY, double vZ, @Mutated Double3 dest) {
        return transform(vX, vY, vZ, dest);
    }


    /**
     * Transform the given position by the inverse of this transform (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(Double3R p, @Mutated Double3 dest) {
        return transformInverse(p, dest);
    }


    /**
     * Transform the given position by the inverse of this transform (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(double pX, double pY, double pZ, @Mutated Double3 dest) {
        return transformInverse(pX, pY, pZ, dest);
    }


    /**
     * Transform the given vector by the linear part of this transform, i.e. apply its scale and
     * rotation but not its translation and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(Double3R v, @Mutated Double3 dest) {
        return transformVector(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given vector by the linear part of this transform, i.e. apply its scale and
     * rotation but not its translation and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVector(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.sY * vY;
        double _t1 = this.sX * vX;
        double _t2 = this.sZ * vZ;
        double _t12 = 2.0 * (this.rX * _t0 - this.rY * _t1);
        double _t13 = 2.0 * (this.rZ * _t1 - this.rX * _t2);
        double _t14 = 2.0 * (this.rY * _t2 - this.rZ * _t0);
        d.x = this.rY * _t12 - this.rZ * _t13 + this.rW * _t14 + _t1;
        d.y = this.rZ * _t14 - this.rX * _t12 + this.rW * _t13 + _t0;
        d.z = this.rX * _t13 - this.rY * _t14 + this.rW * _t12 + _t2;
        return d;
    }


    /**
     * Transform the given vector by the inverse of this transform's linear part (world to local),
     * i.e. undo its rotation and scale but not its translation, without materializing
     * {@code invert()} and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVectorInverse(Double3R v, @Mutated Double3 dest) {
        return transformVectorInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given vector by the inverse of this transform's linear part (world to local),
     * i.e. undo its rotation and scale but not its translation, without materializing
     * {@code invert()} and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformVectorInverse(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (this.rX * vZ - this.rZ * vX);
        double _t10 = 2.0 * (this.rZ * vY - this.rY * vZ);
        double _t11 = 2.0 * (this.rY * vX - this.rX * vY);
        d.x = (this.rZ * _t9 + (this.rW * _t10 + vX - this.rY * _t11)) / this.sX;
        d.y = (this.rX * _t11 + (this.rW * _t9 + vY - this.rZ * _t10)) / this.sY;
        d.z = (this.rY * _t10 + (this.rW * _t11 + vZ - this.rX * _t9)) / this.sZ;
        return d;
    }

    public double tX() { return this.tX; }
    public double tY() { return this.tY; }
    public double tZ() { return this.tZ; }
    public double rX() { return this.rX; }
    public double rY() { return this.rY; }
    public double rZ() { return this.rZ; }
    public double rW() { return this.rW; }
    public double sX() { return this.sX; }
    public double sY() { return this.sY; }
    public double sZ() { return this.sZ; }

    @Override public String toString() {
        return "DoubleTransform(" + tX() + ", " + tY() + ", " + tZ() + ", " + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ", " + sX() + ", " + sY() + ", " + sZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleTransformImpl)) return false;
        DoubleTransformImpl o = (DoubleTransformImpl) obj;
        return Double.doubleToLongBits(tX) == Double.doubleToLongBits(o.tX)
            && Double.doubleToLongBits(tY) == Double.doubleToLongBits(o.tY)
            && Double.doubleToLongBits(tZ) == Double.doubleToLongBits(o.tZ)
            && Double.doubleToLongBits(rX) == Double.doubleToLongBits(o.rX)
            && Double.doubleToLongBits(rY) == Double.doubleToLongBits(o.rY)
            && Double.doubleToLongBits(rZ) == Double.doubleToLongBits(o.rZ)
            && Double.doubleToLongBits(rW) == Double.doubleToLongBits(o.rW)
            && Double.doubleToLongBits(sX) == Double.doubleToLongBits(o.sX)
            && Double.doubleToLongBits(sY) == Double.doubleToLongBits(o.sY)
            && Double.doubleToLongBits(sZ) == Double.doubleToLongBits(o.sZ);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(tX) ^ (Double.doubleToLongBits(tX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(tY) ^ (Double.doubleToLongBits(tY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(tZ) ^ (Double.doubleToLongBits(tZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rX) ^ (Double.doubleToLongBits(rX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rY) ^ (Double.doubleToLongBits(rY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rZ) ^ (Double.doubleToLongBits(rZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(rW) ^ (Double.doubleToLongBits(rW) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(sX) ^ (Double.doubleToLongBits(sX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(sY) ^ (Double.doubleToLongBits(sY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(sZ) ^ (Double.doubleToLongBits(sZ) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(tX)
            && Double.isFinite(tY)
            && Double.isFinite(tZ)
            && Double.isFinite(rX)
            && Double.isFinite(rY)
            && Double.isFinite(rZ)
            && Double.isFinite(rW)
            && Double.isFinite(sX)
            && Double.isFinite(sY)
            && Double.isFinite(sZ);
    }

    @Override public boolean equalsEpsilon(DoubleTransformR other, double epsilon) {
        return Math.abs(tX - other.tX()) <= epsilon
            && Math.abs(tY - other.tY()) <= epsilon
            && Math.abs(tZ - other.tZ()) <= epsilon
            && Math.abs(rX - other.rX()) <= epsilon
            && Math.abs(rY - other.rY()) <= epsilon
            && Math.abs(rZ - other.rZ()) <= epsilon
            && Math.abs(rW - other.rW()) <= epsilon
            && Math.abs(sX - other.sX()) <= epsilon
            && Math.abs(sY - other.sY()) <= epsilon
            && Math.abs(sZ - other.sZ()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.tX;
        dest[offset + 1] = this.tY;
        dest[offset + 2] = this.tZ;
        dest[offset + 3] = this.rX;
        dest[offset + 4] = this.rY;
        dest[offset + 5] = this.rZ;
        dest[offset + 6] = this.rW;
        dest[offset + 7] = this.sX;
        dest[offset + 8] = this.sY;
        dest[offset + 9] = this.sZ;
        return dest;
    }
    public @Mutated DoubleTransform load(double[] src, int offset) {
        this.tX = src[offset + 0];
        this.tY = src[offset + 1];
        this.tZ = src[offset + 2];
        this.rX = src[offset + 3];
        this.rY = src[offset + 4];
        this.rZ = src[offset + 5];
        this.rW = src[offset + 6];
        this.sX = src[offset + 7];
        this.sY = src[offset + 8];
        this.sZ = src[offset + 9];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleTransform loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleTransform loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleTransform storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleTransform loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleTransform load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.tX;
        dest[offset + 1] = (float) this.tY;
        dest[offset + 2] = (float) this.tZ;
        dest[offset + 3] = (float) this.rX;
        dest[offset + 4] = (float) this.rY;
        dest[offset + 5] = (float) this.rZ;
        dest[offset + 6] = (float) this.rW;
        dest[offset + 7] = (float) this.sX;
        dest[offset + 8] = (float) this.sY;
        dest[offset + 9] = (float) this.sZ;
        return dest;
    }
    public @Mutated DoubleTransform load(float[] src, int offset) {
        this.tX = src[offset + 0];
        this.tY = src[offset + 1];
        this.tZ = src[offset + 2];
        this.rX = src[offset + 3];
        this.rY = src[offset + 4];
        this.rZ = src[offset + 5];
        this.rW = src[offset + 6];
        this.sX = src[offset + 7];
        this.sY = src[offset + 8];
        this.sZ = src[offset + 9];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleTransform loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleTransform loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleTransform storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleTransform loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleTransform loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
