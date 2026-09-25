// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
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
 * Generated implementation of {@link DoubleRigid} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleRigidImpl implements DoubleRigid {

    public double tX;
    public double tY;
    public double tZ;
    public double rX;
    public double rY;
    public double rZ;
    public double rW;
    static final DoubleRigidSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRigidSegOpsUnsafe()
                    : new DoubleRigidSegOpsMS();
    static final DoubleRigidBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRigidBbOpsUnsafe()
                    : new DoubleRigidBbOpsApi();
    static final DoubleRigidRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRigidRawOpsUnsafe()
                    : new DoubleRigidRawOpsApi();

    public DoubleRigidImpl() {
        rW = 1;
    }

    public DoubleRigidImpl(double tX, double tY, double tZ, double rX, double rY, double rZ, double rW) {
        this.tX = tX;
        this.tY = tY;
        this.tZ = tZ;
        this.rX = rX;
        this.rY = rY;
        this.rZ = rZ;
        this.rW = rW;
    }

    public DoubleRigidImpl(DoubleRigidR src) {
        this.tX = src.tX();
        this.tY = src.tY();
        this.tZ = src.tZ();
        this.rX = src.rX();
        this.rY = src.rY();
        this.rZ = src.rZ();
        this.rW = src.rW();
    }


    /**
     * Set this rigid transform to the rotation of {@code angle} radians about the axis
     * {@code axis}, combined with a translation by {@code translation}.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param angle the angle in radians
     * @param translation the translation
     * @return this
     */
    public @Mutated DoubleRigid makeFromAxisAngle(Double3R axis, double angle, Double3R translation) {
        return makeFromAxisAngle(axis.x(), axis.y(), axis.z(), angle, translation.x(), translation.y(), translation.z());
    }


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
    @Mutated public DoubleRigid makeFromAxisAngle(double axisX, double axisY, double axisZ, double angle, double translationX, double translationY, double translationZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this rigid transform to a rigid transformation that first rotates by {@code rotation} and
     * then translates by {@code translation} ({@code T * R}).
     *
     * @param translation the translation
     * @param rotation the rotation
     * @return this
     */
    public @Mutated DoubleRigid makeTranslationRotation(Double3R translation, DoubleQuatR rotation) {
        return makeTranslationRotation(translation.x(), translation.y(), translation.z(), rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


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
    @Mutated public DoubleRigid makeTranslationRotation(double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW) {
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        return this;
    }


    /**
     * Set this rigid transform to the given values.
     *
     * @param v the rigid transform to copy
     * @return this
     */
    public @Mutated DoubleRigid set(DoubleRigidR v) {
        return set(v.tX(), v.tY(), v.tZ(), v.rX(), v.rY(), v.rZ(), v.rW());
    }


    /**
     * Set this rigid transform to the given values.
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
     * @return this
     */
    @Mutated public DoubleRigid set(double vTX, double vTY, double vTZ, double vRX, double vRY, double vRZ, double vRW) {
        this.tX = vTX;
        this.tY = vTY;
        this.tZ = vTZ;
        this.rX = vRX;
        this.rY = vRY;
        this.rZ = vRZ;
        this.rW = vRW;
        return this;
    }


    /**
     * Set the rotation of this rigid transform to {@code r} and store the result in {@code dest}.
     *
     * @param r the new rotation
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid setRotation(DoubleQuatR r, @Mutated DoubleRigid dest) {
        return setRotation(r.x(), r.y(), r.z(), r.w(), dest);
    }


    /**
     * Set the rotation of this rigid transform to ({@code rX}, {@code rY}, {@code rZ}, {@code rW})
     * and store the result in {@code dest}.
     *
     * @param rX the {@code x} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rY the {@code y} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rZ the {@code z} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param rW the {@code w} component of the quaternion {@code (rX, rY, rZ, rW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid setRotation(double rX, double rY, double rZ, double rW, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = rX;
        d.rY = rY;
        d.rZ = rZ;
        d.rW = rW;
        return d;
    }


    /**
     * Set the translation of this rigid transform to {@code t} and store the result in
     * {@code dest}.
     *
     * @param t the translation vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid setTranslation(Double3R t, @Mutated DoubleRigid dest) {
        return setTranslation(t.x(), t.y(), t.z(), dest);
    }


    /**
     * Set the translation of this rigid transform to ({@code tX}, {@code tY}, {@code tZ}) and store
     * the result in {@code dest}.
     *
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid setTranslation(double tX, double tY, double tZ, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        d.tX = tX;
        d.tY = tY;
        d.tZ = tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        return d;
    }


    /**
     * Set this rigid transform to the rigid motion of the unit dual quaternion {@code dq} (an exact
     * conversion - both represent rotation plus translation).
     *
     * @param dq the dual quaternion to convert
     * @return this
     */
    public @Mutated DoubleRigid makeFromDualQuat(DoubleDualQuatR dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Set this rigid transform to the rigid motion of the unit dual quaternion ({@code dqRX},
     * {@code dqRY}, {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ},
     * {@code dqDW}) (an exact conversion - both represent rotation plus translation).
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
    @Mutated public DoubleRigid makeFromDualQuat(double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        this.tX = 2.0 * (dqRY * dqDZ - dqRZ * dqDY + (dqRW * dqDX - dqRX * dqDW));
        this.tY = 2.0 * (dqRZ * dqDX - dqRX * dqDZ + (dqRW * dqDY - dqRY * dqDW));
        this.tZ = 2.0 * (dqRX * dqDY - dqRY * dqDX + (dqRW * dqDZ - dqRZ * dqDW));
        this.rX = dqRX;
        this.rY = dqRY;
        this.rZ = dqRZ;
        this.rW = dqRW;
        return this;
    }


    /**
     * Set this rigid transform to the rotation extracted from the given matrix, with zero
     * translation (scale is removed by normalizing the columns, but shear is not removed: a sheared
     * block yields a rotation quaternion that is not unit length).
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public DoubleRigid makeFromMatrix(Double3x3R m) {
        double _t15 = (1.0 / Math.sqrt(m.m01() * m.m01() + m.m11() * m.m11() + m.m21() * m.m21()));
        double _t16 = (1.0 / Math.sqrt(m.m02() * m.m02() + m.m12() * m.m12() + m.m22() * m.m22()));
        double _t17 = (1.0 / Math.sqrt(m.m00() * m.m00() + m.m10() * m.m10() + m.m20() * m.m20()));
        double _t18 = m.m11() * _t15;
        double _t19 = m.m22() * _t16;
        double _t20 = m.m10() * _t17;
        double _t21 = m.m21() * _t15;
        double _t22 = m.m20() * _t17;
        double _t23 = m.m02() * _t16;
        double _t24 = m.m12() * _t16;
        double _t25 = m.m00() * _t17;
        double _t26 = m.m01() * _t15;
        double _t36 = _t21 - _t24;
        double _t37 = Math.max(_t18, _t19);
        double _t38 = _t24 + _t21;
        double _t46 = (_t20 * _t21 - _t18 * _t22) * _t23 + (_t18 * _t19 - _t24 * _t21) * _t25 - (_t20 * _t19 - _t24 * _t22) * _t26;
        double _t47, _t48, _t49;
        if (_t46 < 0.0) {
            _t47 = -_t25;
            _t48 = -_t20;
            _t49 = -_t22;
        } else {
            _t47 = _t25;
            _t48 = _t20;
            _t49 = _t22;
        }
        double _t50 = 1.0 + _t47;
        double _t51 = 1.0 - _t47;
        double _t53 = _t26 + _t48;
        double _t54 = _t23 + _t49;
        double _t55 = _t23 - _t49;
        double _t56 = _t48 - _t26;
        double _t61 = _t18 + (_t19 + _t47);
        double _t62 = _t18 + (_t19 + _t50);
        double _t63 = _t50 - _t19 - _t18;
        double _t64 = _t18 + (_t51 - _t19);
        double _t65 = _t19 + (_t51 - _t18);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t62));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t64));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t65));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t63));
        if (_t61 > 0.0) {
            this.rX = _sp0 * _t36;
            this.rY = _sp0 * _t55;
            this.rZ = _sp0 * _t56;
            this.rW = 0.5 * Math.sqrt(_t62);
        } else {
            if (_t47 > _t37) {
                this.rX = 0.5 * Math.sqrt(_t63);
                this.rY = _sp3 * _t53;
                this.rZ = _sp3 * _t54;
                this.rW = _sp3 * _t36;
            } else {
                if (_t18 > _t19) {
                    this.rX = _sp1 * _t53;
                    this.rY = 0.5 * Math.sqrt(_t64);
                    this.rZ = _sp1 * _t38;
                    this.rW = _sp1 * _t55;
                } else {
                    this.rX = _sp2 * _t54;
                    this.rY = _sp2 * _t38;
                    this.rZ = 0.5 * Math.sqrt(_t65);
                    this.rW = _sp2 * _t56;
                }
            }
        }
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        return this;
    }


    /**
     * Set this rigid transform to the rigid decomposition of the given affine matrix: translation
     * from the last column, rotation from the column-normalized upper-left 3x3 block (scale is
     * removed by normalizing the columns, but shear is not removed: a sheared block yields a
     * rotation quaternion that is not unit length).
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public DoubleRigid makeFromMatrix(Double3x4R m) {
        double _t15 = (1.0 / Math.sqrt(m.m01() * m.m01() + m.m11() * m.m11() + m.m21() * m.m21()));
        double _t16 = (1.0 / Math.sqrt(m.m02() * m.m02() + m.m12() * m.m12() + m.m22() * m.m22()));
        double _t17 = (1.0 / Math.sqrt(m.m00() * m.m00() + m.m10() * m.m10() + m.m20() * m.m20()));
        double _t18 = m.m11() * _t15;
        double _t19 = m.m22() * _t16;
        double _t20 = m.m10() * _t17;
        double _t21 = m.m21() * _t15;
        double _t22 = m.m20() * _t17;
        double _t23 = m.m02() * _t16;
        double _t24 = m.m12() * _t16;
        double _t25 = m.m00() * _t17;
        double _t26 = m.m01() * _t15;
        double _t36 = _t21 - _t24;
        double _t37 = Math.max(_t18, _t19);
        double _t38 = _t24 + _t21;
        double _t46 = (_t20 * _t21 - _t18 * _t22) * _t23 + (_t18 * _t19 - _t24 * _t21) * _t25 - (_t20 * _t19 - _t24 * _t22) * _t26;
        double _t47, _t48, _t49;
        if (_t46 < 0.0) {
            _t47 = -_t25;
            _t48 = -_t20;
            _t49 = -_t22;
        } else {
            _t47 = _t25;
            _t48 = _t20;
            _t49 = _t22;
        }
        double _t50 = 1.0 + _t47;
        double _t51 = 1.0 - _t47;
        double _t53 = _t26 + _t48;
        double _t54 = _t23 + _t49;
        double _t55 = _t23 - _t49;
        double _t56 = _t48 - _t26;
        double _t61 = _t18 + (_t19 + _t47);
        double _t62 = _t18 + (_t19 + _t50);
        double _t63 = _t50 - _t19 - _t18;
        double _t64 = _t18 + (_t51 - _t19);
        double _t65 = _t19 + (_t51 - _t18);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t62));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t64));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t65));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t63));
        if (_t61 > 0.0) {
            this.rX = _sp0 * _t36;
            this.rY = _sp0 * _t55;
            this.rZ = _sp0 * _t56;
            this.rW = 0.5 * Math.sqrt(_t62);
        } else {
            if (_t47 > _t37) {
                this.rX = 0.5 * Math.sqrt(_t63);
                this.rY = _sp3 * _t53;
                this.rZ = _sp3 * _t54;
                this.rW = _sp3 * _t36;
            } else {
                if (_t18 > _t19) {
                    this.rX = _sp1 * _t53;
                    this.rY = 0.5 * Math.sqrt(_t64);
                    this.rZ = _sp1 * _t38;
                    this.rW = _sp1 * _t55;
                } else {
                    this.rX = _sp2 * _t54;
                    this.rY = _sp2 * _t38;
                    this.rZ = 0.5 * Math.sqrt(_t65);
                    this.rW = _sp2 * _t56;
                }
            }
        }
        this.tX = m.m03();
        this.tY = m.m13();
        this.tZ = m.m23();
        return this;
    }


    /**
     * Set this rigid transform to the rigid decomposition of the given affine matrix: translation
     * from the last column, rotation from the column-normalized upper-left 3x3 block (scale is
     * removed by normalizing the columns, but shear is not removed: a sheared block yields a
     * rotation quaternion that is not unit length).
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public DoubleRigid makeFromMatrix(Double4x4R m) {
        double _t15 = (1.0 / Math.sqrt(m.m01() * m.m01() + m.m11() * m.m11() + m.m21() * m.m21()));
        double _t16 = (1.0 / Math.sqrt(m.m02() * m.m02() + m.m12() * m.m12() + m.m22() * m.m22()));
        double _t17 = (1.0 / Math.sqrt(m.m00() * m.m00() + m.m10() * m.m10() + m.m20() * m.m20()));
        double _t18 = m.m11() * _t15;
        double _t19 = m.m22() * _t16;
        double _t20 = m.m10() * _t17;
        double _t21 = m.m21() * _t15;
        double _t22 = m.m20() * _t17;
        double _t23 = m.m02() * _t16;
        double _t24 = m.m12() * _t16;
        double _t25 = m.m00() * _t17;
        double _t26 = m.m01() * _t15;
        double _t36 = _t21 - _t24;
        double _t37 = Math.max(_t18, _t19);
        double _t38 = _t24 + _t21;
        double _t46 = (_t20 * _t21 - _t18 * _t22) * _t23 + (_t18 * _t19 - _t24 * _t21) * _t25 - (_t20 * _t19 - _t24 * _t22) * _t26;
        double _t47, _t48, _t49;
        if (_t46 < 0.0) {
            _t47 = -_t25;
            _t48 = -_t20;
            _t49 = -_t22;
        } else {
            _t47 = _t25;
            _t48 = _t20;
            _t49 = _t22;
        }
        double _t50 = 1.0 + _t47;
        double _t51 = 1.0 - _t47;
        double _t53 = _t26 + _t48;
        double _t54 = _t23 + _t49;
        double _t55 = _t23 - _t49;
        double _t56 = _t48 - _t26;
        double _t61 = _t18 + (_t19 + _t47);
        double _t62 = _t18 + (_t19 + _t50);
        double _t63 = _t50 - _t19 - _t18;
        double _t64 = _t18 + (_t51 - _t19);
        double _t65 = _t19 + (_t51 - _t18);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t62));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t64));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t65));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t63));
        if (_t61 > 0.0) {
            this.rX = _sp0 * _t36;
            this.rY = _sp0 * _t55;
            this.rZ = _sp0 * _t56;
            this.rW = 0.5 * Math.sqrt(_t62);
        } else {
            if (_t47 > _t37) {
                this.rX = 0.5 * Math.sqrt(_t63);
                this.rY = _sp3 * _t53;
                this.rZ = _sp3 * _t54;
                this.rW = _sp3 * _t36;
            } else {
                if (_t18 > _t19) {
                    this.rX = _sp1 * _t53;
                    this.rY = 0.5 * Math.sqrt(_t64);
                    this.rZ = _sp1 * _t38;
                    this.rW = _sp1 * _t55;
                } else {
                    this.rX = _sp2 * _t54;
                    this.rY = _sp2 * _t38;
                    this.rZ = 0.5 * Math.sqrt(_t65);
                    this.rW = _sp2 * _t56;
                }
            }
        }
        this.tX = m.m03();
        this.tY = m.m13();
        this.tZ = m.m23();
        return this;
    }


    /**
     * Set this rigid transform to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (a rigid transform cannot represent it).
     *
     * @param t the transform to convert
     * @return this
     */
    public @Mutated DoubleRigid makeFromTransform(DoubleTransformR t) {
        return makeFromTransform(t.tX(), t.tY(), t.tZ(), t.rX(), t.rY(), t.rZ(), t.rW(), t.sX(), t.sY(), t.sZ());
    }


    /**
     * Set this rigid transform to the rigid motion (rotation and translation) of the given
     * transform; the scale is dropped (a rigid transform cannot represent it).
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
     * @return this
     */
    @Mutated public DoubleRigid makeFromTransform(double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        this.tX = tTX;
        this.tY = tTY;
        this.tZ = tTZ;
        this.rX = tRX;
        this.rY = tRY;
        this.rZ = tRZ;
        this.rW = tRW;
        return this;
    }


    /**
     * Convert this rigid transform to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatRigid toFloat(@Mutated FloatRigid dest) {
        FloatRigidImpl d = (FloatRigidImpl) dest;
        d.tX = (float) (this.tX);
        d.tY = (float) (this.tY);
        d.tZ = (float) (this.tZ);
        d.rX = (float) (this.rX);
        d.rY = (float) (this.rY);
        d.rZ = (float) (this.rZ);
        d.rW = (float) (this.rW);
        return d;
    }


    /**
     * Convert this rigid transform to a unit dual quaternion encoding the same rigid motion (an
     * exact conversion) and store the result in {@code dest}.
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
     * Compute the matrix representation of this rigid transform (whose rotation must be a unit
     * quaternion) and store the result in {@code dest}.
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
        double _buf0 = 1.0 - 2.0 * (_t0 + _t1);
        d.m10 = 2.0 * (_t2 + _t3);
        d.m20 = 2.0 * (_t4 - _t5);
        d.m30 = 0.0;
        double _buf1 = 2.0 * (_t2 - _t3);
        d.m11 = 1.0 - 2.0 * (_t6 + _t1);
        d.m21 = 2.0 * (_t8 + _t7);
        d.m31 = 0.0;
        double _buf2 = 2.0 * (_t4 + _t5);
        d.m12 = 2.0 * (_t7 - _t8);
        d.m22 = 1.0 - 2.0 * (_t6 + _t0);
        d.m32 = 0.0;
        d.m03 = this.tX;
        d.m13 = this.tY;
        d.m23 = this.tZ;
        d.m33 = 1.0;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Compute the 3x3 matrix representation of the rotation of this rigid transform (whose rotation
     * must be a unit quaternion; the translation is dropped) and store the result in {@code dest}.
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
        d.m00 = 1.0 - 2.0 * (_t0 + _t1);
        d.m10 = 2.0 * (_t2 + _t3);
        d.m20 = 2.0 * (_t4 - _t5);
        d.m01 = 2.0 * (_t2 - _t3);
        d.m11 = 1.0 - 2.0 * (_t6 + _t1);
        d.m21 = 2.0 * (_t8 + _t7);
        d.m02 = 2.0 * (_t4 + _t5);
        d.m12 = 2.0 * (_t7 - _t8);
        d.m22 = 1.0 - 2.0 * (_t6 + _t0);
        d.properties = 0;
        return d;
    }


    /**
     * Compute the 3x4 matrix representation of this rigid transform (whose rotation must be a unit
     * quaternion; the omitted last row is implicitly {@code 0, 0, 0, 1}) and store the result in
     * {@code dest}.
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
        double _buf0 = 1.0 - 2.0 * (_t0 + _t1);
        double _buf1 = 2.0 * (_t2 - _t3);
        double _buf2 = 2.0 * (_t4 + _t5);
        d.m03 = this.tX;
        d.m10 = 2.0 * (_t2 + _t3);
        d.m11 = 1.0 - 2.0 * (_t6 + _t1);
        d.m12 = 2.0 * (_t7 - _t8);
        d.m13 = this.tY;
        d.m20 = 2.0 * (_t4 - _t5);
        d.m21 = 2.0 * (_t8 + _t7);
        d.m22 = 1.0 - 2.0 * (_t6 + _t0);
        d.m23 = this.tZ;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Widen this rigid transform to a TRS transform (same translation and rotation, scale = 1) and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTransform toTransform(@Mutated DoubleTransform dest) {
        DoubleTransformImpl d = (DoubleTransformImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        d.sX = 1.0;
        d.sY = 1.0;
        d.sZ = 1.0;
        return d;
    }


    /**
     * Set this rigid transform to the identity.
     *
     * @return this
     */
    @Mutated public DoubleRigid makeIdentity() {
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        return this;
    }


    /**
     * Set this rigid transform to a pure rotation by {@code rotation} (zero translation).
     *
     * @param rotation the rotation
     * @return this
     */
    public @Mutated DoubleRigid set(DoubleQuatR rotation) {
        return set(rotation.x(), rotation.y(), rotation.z(), rotation.w());
    }


    /**
     * Set this rigid transform to a pure rotation by ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) (zero translation).
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
    @Mutated public DoubleRigid set(double rotationX, double rotationY, double rotationZ, double rotationW) {
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = rotationX;
        this.rY = rotationY;
        this.rZ = rotationZ;
        this.rW = rotationW;
        return this;
    }


    /**
     * Set this rigid transform to a pure translation by {@code translation} (identity rotation).
     *
     * @param translation the translation
     * @return this
     */
    public @Mutated DoubleRigid set(Double3R translation) {
        return set(translation.x(), translation.y(), translation.z());
    }


    /**
     * Set this rigid transform to a pure translation by ({@code translationX},
     * {@code translationY}, {@code translationZ}) (identity rotation).
     *
     * @param translationX the {@code x} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationY the {@code y} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @param translationZ the {@code z} component of the vector
     *        {@code (translationX, translationY, translationZ)}
     * @return this
     */
    @Mutated public DoubleRigid set(double translationX, double translationY, double translationZ) {
        this.tX = translationX;
        this.tY = translationY;
        this.tZ = translationZ;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = 1.0;
        return this;
    }


    /**
     * Interpolate between this rigid transform and {@code other} using the interpolation factor
     * {@code t}, interpolating the translation linearly and the rotation via shortest-arc slerp and
     * store the result in {@code dest}.
     * <p>
     * The interpolation starts at this rigid transform (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the rigid transform to interpolate towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid lerp(DoubleRigidR other, double t, @Mutated DoubleRigid dest) {
        return lerp(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), t, dest);
    }

    /** Private store group 0 of {@code lerp}: computes and stores it; reached only through it. */
    private void lerp_s3b4e3a15_c0(DoubleRigidImpl _dst, double t, double otherTX, double _r4, double otherTY, double _r5, double otherTZ, double _r6, double _t63, double _t64, double _t53) {
        _dst.tX = t * (otherTX - _r4) + _r4;
        _dst.tY = t * (otherTY - _r5) + _r5;
        _dst.tZ = t * (otherTZ - _r6) + _r6;
        _dst.rX = _t63 != 0.0 ? _t64 * _t53 : 0.0;
    }

    /** Private store group 1 of {@code lerp}: computes and stores it; reached only through it. */
    private void lerp_s3b4e3a15_c1(DoubleRigidImpl _dst, double _t63, double _t64, double _t54, double _t55, double _t56) {
        _dst.rY = _t63 != 0.0 ? _t64 * _t54 : 0.0;
        _dst.rZ = _t63 != 0.0 ? _t64 * _t55 : 0.0;
        _dst.rW = _t63 != 0.0 ? _t64 * _t56 : 0.0;
    }

    /** Private tail of {@code lerp}; reached only through it. */
    private void lerp_s3b4e3a15_tail(DoubleRigidImpl _dst, double _t0, double _t19, double _t20, double _r0, double _t22, double _t24, double _t20_inv, double t, double _r1, double _t25, double _r2, double _t26, double _r3, double _t27, double otherTX, double _r4, double otherTY, double _r5, double otherTZ, double _r6) {
        double _t28 = Math.sin(_t0 * _t19);
        double _t53, _t54, _t55, _t56;
        if (_t20 > 0.0) {
            _t53 = (_r0 * _t28 + _t22 * _t24) * _t20_inv;
            _t54 = (_r1 * _t28 + _t22 * _t25) * _t20_inv;
            _t55 = (_r2 * _t28 + _t22 * _t26) * _t20_inv;
            _t56 = (_r3 * _t28 + _t22 * _t27) * _t20_inv;
        } else {
            _t53 = t * _t24 + _r0 * _t0;
            _t54 = t * _t25 + _r1 * _t0;
            _t55 = t * _t26 + _r2 * _t0;
            _t56 = t * _t27 + _r3 * _t0;
        }
        double _t63 = _t53 * _t53 + _t54 * _t54 + _t55 * _t55 + _t56 * _t56;
        double _t64 = (1.0 / Math.sqrt(_t63));
        lerp_s3b4e3a15_c0(_dst, t, otherTX, _r4, otherTY, _r5, otherTZ, _r6, _t63, _t64, _t53);
        lerp_s3b4e3a15_c1(_dst, _t63, _t64, _t54, _t55, _t56);
    }


    /**
     * Interpolate between this rigid transform and ({@code otherTX}, {@code otherTY},
     * {@code otherTZ}, {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}) using
     * the interpolation factor {@code t}, interpolating the translation linearly and the rotation
     * via shortest-arc slerp and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this rigid transform (interpolation factor {@code 0}) and ends at
     * ({@code otherTX}, {@code otherTY}, {@code otherTZ}, {@code otherRX}, {@code otherRY},
     * {@code otherRZ}, {@code otherRW}) (interpolation factor {@code 1}).
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid lerp(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, double t, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.rX;
        double _r1 = this.rY;
        double _r2 = this.rZ;
        double _r3 = this.rW;
        double _r4 = this.tX;
        double _r5 = this.tY;
        double _r6 = this.tZ;
        double _t0 = 1.0 - t;
        double _t15 = otherRX * _r0 + otherRY * _r1 + otherRZ * _r2 + otherRW * _r3;
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
        lerp_s3b4e3a15_tail(d, _t0, _t19, _t20, _r0, _t22, _t24, _t20_inv, t, _r1, _t25, _r2, _t26, _r3, _t27, otherTX, _r4, otherTY, _r5, otherTZ, _r6);
        return d;
    }


    /**
     * Multiply this rigid transform by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code M * R}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code M * R * v}, the transformation of the operand will be applied
     * first.
     *
     * @param other the right operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid mul(DoubleRigidR other, @Mutated DoubleRigid dest) {
        return mul(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), dest);
    }

    /** Private store group 0 of {@code mul}: computes and stores it; reached only through it. */
    private void mul_s1abfb90e_c0(DoubleRigidImpl _dst, double _r1, double _t9, double _r3, double _t10, double _r4, double otherTX, double _r2, double _t11, double _r5, double otherTY, double _r0, double _r6, double otherTZ, double otherRX, double otherRW, double otherRZ, double otherRY) {
        _dst.tX = _r1 * _t9 + (_r3 * _t10 + (_r4 + otherTX) - _r2 * _t11);
        _dst.tY = _r2 * _t10 + (_r3 * _t11 + (_r5 + otherTY) - _r0 * _t9);
        _dst.tZ = _r0 * _t11 + (_r3 * _t9 + (_r6 + otherTZ) - _r1 * _t10);
        _dst.rX = otherRX * _r3 + otherRW * _r0 + (otherRZ * _r1 - otherRY * _r2);
    }

    /** Private store group 1 of {@code mul}: computes and stores it; reached only through it. */
    private void mul_s1abfb90e_c1(DoubleRigidImpl _dst, double otherRX, double _r2, double otherRW, double _r1, double otherRY, double _r3, double otherRZ, double _r0) {
        _dst.rY = otherRX * _r2 + otherRW * _r1 + (otherRY * _r3 - otherRZ * _r0);
        _dst.rZ = otherRY * _r0 + otherRZ * _r3 + (otherRW * _r2 - otherRX * _r1);
        _dst.rW = otherRW * _r3 - otherRX * _r0 - (otherRY * _r1 + otherRZ * _r2);
    }


    /**
     * Multiply this rigid transform by ({@code otherTX}, {@code otherTY}, {@code otherTZ},
     * {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}) and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid mul(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.rX;
        double _r1 = this.rY;
        double _r2 = this.rZ;
        double _r3 = this.rW;
        double _r4 = this.tX;
        double _r5 = this.tY;
        double _r6 = this.tZ;
        double _t9 = 2.0 * (otherTY * _r0 - otherTX * _r1);
        double _t10 = 2.0 * (otherTZ * _r1 - otherTY * _r2);
        double _t11 = 2.0 * (otherTX * _r2 - otherTZ * _r0);
        mul_s1abfb90e_c0(d, _r1, _t9, _r3, _t10, _r4, otherTX, _r2, _t11, _r5, otherTY, _r0, _r6, otherTZ, otherRX, otherRW, otherRZ, otherRY);
        mul_s1abfb90e_c1(d, otherRX, _r2, otherRW, _r1, otherRY, _r3, otherRZ, _r0);
        return d;
    }


    /**
     * Pre-multiply {@code other} onto this rigid transform and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the operand, then the new rigid
     * transform will be {@code R * M}. So when transforming a vector {@code v} with the new rigid
     * transform by using {@code R * M * v}, the transformation of the operand will be applied last.
     *
     * @param other the left operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid preMul(DoubleRigidR other, @Mutated DoubleRigid dest) {
        return preMul(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), dest);
    }

    /** Private store group 0 of {@code preMul}: computes and stores it; reached only through it. */
    private void preMul_s1abfb90e_c0(DoubleRigidImpl _dst, double otherRY, double _t9, double otherRW, double _t10, double otherTX, double _r1, double otherRZ, double _t11, double otherTY, double _r0, double otherRX, double otherTZ, double _r2, double _r3, double _r4, double _r5, double _r6) {
        _dst.tX = otherRY * _t9 + (otherRW * _t10 + (otherTX + _r1) - otherRZ * _t11);
        _dst.tY = otherRZ * _t10 + (otherRW * _t11 + (otherTY + _r0) - otherRX * _t9);
        _dst.tZ = otherRX * _t11 + (otherRW * _t9 + (otherTZ + _r2) - otherRY * _t10);
        _dst.rX = otherRX * _r3 + otherRW * _r4 + (otherRY * _r5 - otherRZ * _r6);
    }

    /** Private store group 1 of {@code preMul}: computes and stores it; reached only through it. */
    private void preMul_s1abfb90e_c1(DoubleRigidImpl _dst, double otherRY, double _r3, double otherRZ, double _r4, double otherRW, double _r6, double otherRX, double _r5) {
        _dst.rY = otherRY * _r3 + otherRZ * _r4 + (otherRW * _r6 - otherRX * _r5);
        _dst.rZ = otherRX * _r6 + otherRW * _r5 + (otherRZ * _r3 - otherRY * _r4);
        _dst.rW = otherRW * _r3 - otherRX * _r4 - (otherRY * _r6 + otherRZ * _r5);
    }


    /**
     * Pre-multiply ({@code otherTX}, {@code otherTY}, {@code otherTZ}, {@code otherRX},
     * {@code otherRY}, {@code otherRZ}, {@code otherRW}) onto this rigid transform and store the
     * result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid preMul(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tY;
        double _r1 = this.tX;
        double _r2 = this.tZ;
        double _r3 = this.rW;
        double _r4 = this.rX;
        double _r5 = this.rZ;
        double _r6 = this.rY;
        double _t9 = 2.0 * (otherRX * _r0 - otherRY * _r1);
        double _t10 = 2.0 * (otherRY * _r2 - otherRZ * _r0);
        double _t11 = 2.0 * (otherRZ * _r1 - otherRX * _r2);
        preMul_s1abfb90e_c0(d, otherRY, _t9, otherRW, _t10, otherTX, _r1, otherRZ, _t11, otherTY, _r0, otherRX, otherTZ, _r2, _r3, _r4, _r5, _r6);
        preMul_s1abfb90e_c1(d, otherRY, _r3, otherRZ, _r4, otherRW, _r6, otherRX, _r5);
        return d;
    }


    /**
     * Compute the difference between this rigid transform and {@code other}, i.e. the rigid
     * transformation {@code D} with {@code this * D = other}, that is {@code D = this^-1 * other}
     * and store the result in {@code dest}.
     *
     * @param other the target rigid transform, reached by composing this rigid transform with the
     *        result
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid difference(DoubleRigidR other, @Mutated DoubleRigid dest) {
        return difference(other.tX(), other.tY(), other.tZ(), other.rX(), other.rY(), other.rZ(), other.rW(), dest);
    }

    /** Private store group 0 of {@code difference}: computes and stores it; reached only through it. */
    private void difference_s1abfb90e_c0(DoubleRigidImpl _dst, double otherTX, double _r1, double _t18, double _r6, double _t19, double _r2, double _t20, double _t21, double _t22, double _t23, double _r3, double otherTY, double _r0, double _r5, double otherTZ, double _r4, double otherRX, double otherRW, double otherRY, double otherRZ) {
        _dst.tX = otherTX + _r1 * _t18 + (_r6 * _t19 - _r2 * _t20) + (_r1 * _t21 - _r2 * _t22 + (_r6 * _t23 - _r3));
        _dst.tY = otherTY + _r0 * _t20 + (_r6 * _t18 - _r1 * _t19) + (_r0 * _t22 - _r1 * _t23 + (_r6 * _t21 - _r5));
        _dst.tZ = otherTZ + _r2 * _t19 + (_r6 * _t20 - _r0 * _t18) + (_r2 * _t23 - _r0 * _t21 + (_r6 * _t22 - _r4));
        _dst.rX = otherRX * _r6 - otherRW * _r0 + (otherRY * _r1 - otherRZ * _r2);
    }

    /** Private store group 1 of {@code difference}: computes and stores it; reached only through it. */
    private void difference_s1abfb90e_c1(DoubleRigidImpl _dst, double otherRY, double _r6, double otherRZ, double _r0, double otherRW, double _r2, double otherRX, double _r1) {
        _dst.rY = otherRY * _r6 + otherRZ * _r0 + (-(otherRW * _r2) - otherRX * _r1);
        _dst.rZ = otherRX * _r2 - otherRW * _r1 + (otherRZ * _r6 - otherRY * _r0);
        _dst.rW = otherRX * _r0 + otherRW * _r6 - (-(otherRY * _r2) - otherRZ * _r1);
    }


    /**
     * Compute the difference between this rigid transform and ({@code otherTX}, {@code otherTY},
     * {@code otherTZ}, {@code otherRX}, {@code otherRY}, {@code otherRZ}, {@code otherRW}), i.e.
     * the rigid transformation {@code D} with
     * {@code this * D = (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)}, that is
     * {@code D = this^-1 * (otherTX, otherTY, otherTZ, otherRX, otherRY, otherRZ, otherRW)} and
     * store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid difference(double otherTX, double otherTY, double otherTZ, double otherRX, double otherRY, double otherRZ, double otherRW, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.rX;
        double _r1 = this.rZ;
        double _r2 = this.rY;
        double _r3 = this.tX;
        double _r4 = this.tZ;
        double _r5 = this.tY;
        double _r6 = this.rW;
        double _t18 = 2.0 * (otherTZ * _r0 - otherTX * _r1);
        double _t19 = 2.0 * (otherTY * _r1 - otherTZ * _r2);
        double _t20 = 2.0 * (otherTX * _r2 - otherTY * _r0);
        double _t21 = 2.0 * (_r3 * _r1 - _r4 * _r0);
        double _t22 = 2.0 * (_r5 * _r0 - _r3 * _r2);
        double _t23 = 2.0 * (_r4 * _r2 - _r5 * _r1);
        difference_s1abfb90e_c0(d, otherTX, _r1, _t18, _r6, _t19, _r2, _t20, _t21, _t22, _t23, _r3, otherTY, _r0, _r5, otherTZ, _r4, otherRX, otherRW, otherRY, otherRZ);
        difference_s1abfb90e_c1(d, otherRY, _r6, otherRZ, _r0, otherRW, _r2, otherRX, _r1);
        return d;
    }


    /**
     * Invert this rigid transform; exact for any rigid motion (no scale divisions) and store the
     * result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid invert(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t9 = 2.0 * (this.tX * this.rZ - this.tZ * this.rX);
        double _t10 = 2.0 * (this.tZ * this.rY - this.tY * this.rZ);
        double _t11 = 2.0 * (this.tY * this.rX - this.tX * this.rY);
        d.tX = this.rZ * _t9 + (this.rW * _t10 - this.tX - this.rY * _t11);
        d.tY = this.rX * _t11 + (this.rW * _t9 - this.tY - this.rZ * _t10);
        d.tZ = this.rY * _t10 + (this.rW * _t11 - this.tZ - this.rX * _t9);
        d.rX = -this.rX;
        d.rY = -this.rY;
        d.rZ = -this.rZ;
        d.rW = this.rW;
        return d;
    }


    /**
     * Normalize this rigid transform so that its rotation part has unit length, leaving its
     * translation unchanged (a zero-length rotation yields the zero quaternion) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the rotation quaternion must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid normalize(@Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t6 = this.rX * this.rX + this.rY * this.rY + this.rZ * this.rZ + this.rW * this.rW;
        double _t7 = (1.0 / Math.sqrt(_t6));
        if (_t6 != 0.0) {
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
        return d;
    }


    /**
     * Get the Euler angles in radians of this rigid transform, to be applied about the X, Y and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationXYZ(e.x(), e.y(), e.z())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Get the Euler angles in radians of this rigid transform, to be applied about the X, Z and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationXZY(e.x(), e.z(), e.y())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Get the Euler angles in radians of this rigid transform, to be applied about the Y, X and Z
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationYXZ(e.y(), e.x(), e.z())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Get the Euler angles in radians of this rigid transform, to be applied about the Y, Z and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationYZX(e.y(), e.z(), e.x())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Get the Euler angles in radians of this rigid transform, to be applied about the Z, X and Y
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationZXY(e.z(), e.x(), e.y())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Get the Euler angles in radians of this rigid transform, to be applied about the Z, Y and X
     * axes, in that order and store the result in {@code dest}.
     * <p>
     * The result holds each angle at the component of its axis, not at its position in the order:
     * the angle about X in {@code x}, about Y in {@code y} and about Z in {@code z}. So, with
     * {@code e} the result, {@code makeRotationZYX(e.z(), e.y(), e.x())}, which takes the angles in
     * application order, rebuilds the rotation.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code double} resolution over its whole range, down to 0.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Get the rotation of this rigid transform and store the result in {@code dest}.
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
     * Get the translation of this rigid transform and store the result in {@code dest}.
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
     * Set this rigid transform to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated DoubleRigid makeRotationAxis(double angle, Double3R axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the axis
     * ({@code axisX}, {@code axisY}, {@code axisZ}).
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
    @Mutated public DoubleRigid makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return makeRotationX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return makeRotationY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return makeRotationZ(axisZ * angle);
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = axisX * _t1;
        this.rY = axisY * _t1;
        this.rZ = axisZ * _t1;
        this.rW = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleRigid makeRotationX(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t1;
        this.rY = 0.0;
        this.rZ = 0.0;
        this.rW = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so
     * a vector is rotated about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleRigid makeRotationXYZ(double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t4, _t1);
        double _t7 = Math.cosFromSin(_t5, _t2);
        double _t8 = Math.cosFromSin(_t3, _t0);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t6;
        double _t11 = _t4 * _t8;
        double _t12 = _t8 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t10 * _t7 + _t11 * _t5;
        this.rY = _t11 * _t7 - _t10 * _t5;
        this.rZ = _t9 * _t7 + _t12 * _t5;
        this.rW = _t12 * _t7 - _t9 * _t5;
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so
     * a vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @return this
     */
    @Mutated public DoubleRigid makeRotationXZY(double angleX, double angleZ, double angleY) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t4, _t1);
        double _t7 = Math.cosFromSin(_t5, _t2);
        double _t8 = Math.cosFromSin(_t3, _t0);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t6;
        double _t11 = _t4 * _t8;
        double _t12 = _t8 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t10 * _t7 - _t11 * _t5;
        this.rY = _t12 * _t5 - _t9 * _t7;
        this.rZ = _t10 * _t5 + _t11 * _t7;
        this.rW = _t9 * _t5 + _t12 * _t7;
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleRigid makeRotationY(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = _t1;
        this.rZ = 0.0;
        this.rW = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so
     * a vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleRigid makeRotationYXZ(double angleY, double angleX, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t4, _t1);
        double _t7 = Math.cosFromSin(_t5, _t2);
        double _t8 = Math.cosFromSin(_t3, _t0);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t6;
        double _t11 = _t4 * _t8;
        double _t12 = _t8 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t10 * _t7 + _t11 * _t5;
        this.rY = _t11 * _t7 - _t10 * _t5;
        this.rZ = _t12 * _t5 - _t9 * _t7;
        this.rW = _t9 * _t5 + _t12 * _t7;
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so
     * a vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @return this
     */
    @Mutated public DoubleRigid makeRotationYZX(double angleY, double angleZ, double angleX) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t5, _t2);
        double _t7 = Math.cosFromSin(_t3, _t0);
        double _t8 = Math.cosFromSin(_t4, _t1);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t8;
        double _t11 = _t4 * _t7;
        double _t12 = _t7 * _t8;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t9 * _t6 + _t12 * _t5;
        this.rY = _t10 * _t6 + _t11 * _t5;
        this.rZ = _t11 * _t6 - _t10 * _t5;
        this.rW = _t12 * _t6 - _t9 * _t5;
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleRigid makeRotationZ(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = 0.0;
        this.rY = 0.0;
        this.rZ = _t1;
        this.rW = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so
     * a vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @return this
     */
    @Mutated public DoubleRigid makeRotationZXY(double angleZ, double angleX, double angleY) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t4, _t1);
        double _t7 = Math.cosFromSin(_t5, _t2);
        double _t8 = Math.cosFromSin(_t3, _t0);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t6;
        double _t11 = _t4 * _t8;
        double _t12 = _t8 * _t6;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t10 * _t7 - _t11 * _t5;
        this.rY = _t9 * _t7 + _t12 * _t5;
        this.rZ = _t10 * _t5 + _t11 * _t7;
        this.rW = _t12 * _t7 - _t9 * _t5;
        return this;
    }


    /**
     * Set this rigid transform to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so
     * a vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @return this
     */
    @Mutated public DoubleRigid makeRotationZYX(double angleZ, double angleY, double angleX) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t7;
        double _t11 = _t4 * _t6;
        double _t12 = _t6 * _t7;
        this.tX = 0.0;
        this.tY = 0.0;
        this.tZ = 0.0;
        this.rX = _t12 * _t5 - _t9 * _t8;
        this.rY = _t10 * _t8 + _t11 * _t5;
        this.rZ = _t11 * _t8 - _t10 * _t5;
        this.rW = _t9 * _t5 + _t12 * _t8;
        return this;
    }


    /**
     * Apply the rotation represented by the quaternion {@code rotation} to this rigid transform and
     * store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param rotation the rotation to apply (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotate(DoubleQuatR rotation, @Mutated DoubleRigid dest) {
        return rotate(rotation.x(), rotation.y(), rotation.z(), rotation.w(), dest);
    }


    /**
     * Apply the rotation represented by the quaternion ({@code rotationX}, {@code rotationY},
     * {@code rotationZ}, {@code rotationW}) to this rigid transform and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotate(double rotationX, double rotationY, double rotationZ, double rotationW, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = rotationX * this.rW + rotationW * this.rX + (rotationZ * this.rY - rotationY * this.rZ);
        double _buf1 = rotationX * this.rZ + rotationW * this.rY + (rotationY * this.rW - rotationZ * this.rX);
        double _buf2 = rotationY * this.rX + rotationZ * this.rW + (rotationW * this.rZ - rotationX * this.rY);
        d.rW = rotationW * this.rW - rotationX * this.rX - (rotationY * this.rY + rotationZ * this.rZ);
        d.rX = _buf0;
        d.rY = _buf1;
        d.rZ = _buf2;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this rigid transform
     * and store the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateAxis(double angle, Double3R axis, @Mutated DoubleRigid dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }

    /** Private store group 0 of {@code rotateAxis}: computes and stores it; reached only through it. */
    private void rotateAxis_s5fbf191b_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t5, double _r4, double _t2, double _r5, double _t3, double _r6, double _t4) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t5 + _r4 * _t2 + (_r5 * _t3 - _r6 * _t4);
    }

    /** Private store group 1 of {@code rotateAxis}: computes and stores it; reached only through it. */
    private void rotateAxis_s5fbf191b_c1(DoubleRigidImpl _dst, double _r5, double _t5, double _r6, double _t2, double _r4, double _t4, double _r3, double _t3) {
        _dst.rY = _r5 * _t5 + _r6 * _t2 + (_r4 * _t4 - _r3 * _t3);
        _dst.rZ = _r3 * _t4 + _r4 * _t3 + (_r6 * _t5 - _r5 * _t2);
        _dst.rW = _r4 * _t5 - _r3 * _t2 - (_r5 * _t4 + _r6 * _t3);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this rigid transform and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated DoubleRigid dest) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle, dest);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle, dest);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle, dest);
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = axisX * _t1;
        double _t3 = axisZ * _t1;
        double _t4 = axisY * _t1;
        double _t5 = Math.cosFromSin(_t1, _t0);
        rotateAxis_s5fbf191b_c0(d, _r0, _r1, _r2, _r3, _t5, _r4, _t2, _r5, _t3, _r6, _t4);
        rotateAxis_s5fbf191b_c1(d, _r5, _t5, _r6, _t2, _r4, _t4, _r3, _t3);
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the X axis to this rigid transform and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateX(double angle, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t2 + this.rW * _t1;
        double _buf1 = this.rY * _t2 + this.rZ * _t1;
        d.rZ = this.rZ * _t2 - this.rY * _t1;
        d.rW = this.rW * _t2 - this.rX * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        return d;
    }

    /** Private store group 0 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s6c64e0a1_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6, double _t24) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t21 + _r4 * _t22 + (_r5 * _t23 - _r6 * _t24);
    }

    /** Private store group 1 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s6c64e0a1_c1(DoubleRigidImpl _dst, double _r5, double _t21, double _r6, double _t22, double _r4, double _t24, double _r3, double _t23) {
        _dst.rY = _r5 * _t21 + _r6 * _t22 + (_r4 * _t24 - _r3 * _t23);
        _dst.rZ = _r3 * _t24 + _r4 * _t23 + (_r6 * _t21 - _r5 * _t22);
        _dst.rW = _r4 * _t21 - _r3 * _t22 - (_r5 * _t24 + _r6 * _t23);
    }

    /** Private tail of {@code rotateXYZ}; reached only through it. */
    private void rotateXYZ_s6c64e0a1_tail(DoubleRigidImpl _dst, double _t11, double _t8, double _t10, double _t5, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6) {
        double _t24 = _t11 * _t8 - _t10 * _t5;
        rotateXYZ_s6c64e0a1_c0(_dst, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6, _t24);
        rotateXYZ_s6c64e0a1_c1(_dst, _r5, _t21, _r6, _t22, _r4, _t24, _r3, _t23);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateXYZ(double angleX, double angleY, double angleZ, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t7;
        double _t11 = _t4 * _t6;
        double _t13 = _t6 * _t7;
        double _t21 = _t13 * _t8 - _t9 * _t5;
        double _t22 = _t10 * _t8 + _t11 * _t5;
        double _t23 = _t9 * _t8 + _t13 * _t5;
        rotateXYZ_s6c64e0a1_tail(d, _t11, _t8, _t10, _t5, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6);
        return d;
    }

    /** Private store group 0 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s60d54803_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6, double _t24) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t21 + _r4 * _t22 + (_r5 * _t23 - _r6 * _t24);
    }

    /** Private store group 1 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s60d54803_c1(DoubleRigidImpl _dst, double _r5, double _t21, double _r6, double _t22, double _r4, double _t24, double _r3, double _t23) {
        _dst.rY = _r5 * _t21 + _r6 * _t22 + (_r4 * _t24 - _r3 * _t23);
        _dst.rZ = _r3 * _t24 + _r4 * _t23 + (_r6 * _t21 - _r5 * _t22);
        _dst.rW = _r4 * _t21 - _r3 * _t22 - (_r5 * _t24 + _r6 * _t23);
    }

    /** Private tail of {@code rotateXZY}; reached only through it. */
    private void rotateXZY_s60d54803_tail(DoubleRigidImpl _dst, double _t13, double _t5, double _t9, double _t8, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6) {
        double _t24 = _t13 * _t5 - _t9 * _t8;
        rotateXZY_s60d54803_c0(_dst, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6, _t24);
        rotateXZY_s60d54803_c1(_dst, _r5, _t21, _r6, _t22, _r4, _t24, _r3, _t23);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateXZY(double angleX, double angleZ, double angleY, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t7;
        double _t11 = _t4 * _t6;
        double _t13 = _t6 * _t7;
        double _t21 = _t9 * _t5 + _t13 * _t8;
        double _t22 = _t10 * _t8 - _t11 * _t5;
        double _t23 = _t10 * _t5 + _t11 * _t8;
        rotateXZY_s60d54803_tail(d, _t13, _t5, _t9, _t8, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6);
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Y axis to this rigid transform and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateY(double angle, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t2 - this.rZ * _t1;
        double _buf1 = this.rY * _t2 + this.rW * _t1;
        d.rZ = this.rX * _t1 + this.rZ * _t2;
        d.rW = this.rW * _t2 - this.rY * _t1;
        d.rX = _buf0;
        d.rY = _buf1;
        return d;
    }

    /** Private store group 0 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s141088ff_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6, double _t24) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t21 + _r4 * _t22 + (_r5 * _t23 - _r6 * _t24);
    }

    /** Private store group 1 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s141088ff_c1(DoubleRigidImpl _dst, double _r5, double _t21, double _r6, double _t22, double _r4, double _t24, double _r3, double _t23) {
        _dst.rY = _r5 * _t21 + _r6 * _t22 + (_r4 * _t24 - _r3 * _t23);
        _dst.rZ = _r3 * _t24 + _r4 * _t23 + (_r6 * _t21 - _r5 * _t22);
        _dst.rW = _r4 * _t21 - _r3 * _t22 - (_r5 * _t24 + _r6 * _t23);
    }

    /** Private tail of {@code rotateYXZ}; reached only through it. */
    private void rotateYXZ_s141088ff_tail(DoubleRigidImpl _dst, double _t11, double _t8, double _t10, double _t5, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6) {
        double _t24 = _t11 * _t8 - _t10 * _t5;
        rotateYXZ_s141088ff_c0(_dst, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6, _t24);
        rotateYXZ_s141088ff_c1(_dst, _r5, _t21, _r6, _t22, _r4, _t24, _r3, _t23);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateYXZ(double angleY, double angleX, double angleZ, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t7;
        double _t11 = _t4 * _t6;
        double _t13 = _t6 * _t7;
        double _t21 = _t9 * _t5 + _t13 * _t8;
        double _t22 = _t10 * _t8 + _t11 * _t5;
        double _t23 = _t13 * _t5 - _t9 * _t8;
        rotateYXZ_s141088ff_tail(d, _t11, _t8, _t10, _t5, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6);
        return d;
    }

    /** Private store group 0 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s7cf157c3_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6, double _t24) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t21 + _r4 * _t22 + (_r5 * _t23 - _r6 * _t24);
    }

    /** Private store group 1 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s7cf157c3_c1(DoubleRigidImpl _dst, double _r5, double _t21, double _r6, double _t22, double _r4, double _t24, double _r3, double _t23) {
        _dst.rY = _r5 * _t21 + _r6 * _t22 + (_r4 * _t24 - _r3 * _t23);
        _dst.rZ = _r3 * _t24 + _r4 * _t23 + (_r6 * _t21 - _r5 * _t22);
        _dst.rW = _r4 * _t21 - _r3 * _t22 - (_r5 * _t24 + _r6 * _t23);
    }

    /** Private tail of {@code rotateYZX}; reached only through it. */
    private void rotateYZX_s7cf157c3_tail(DoubleRigidImpl _dst, double _t11, double _t8, double _t10, double _t5, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6) {
        double _t24 = _t11 * _t8 + _t10 * _t5;
        rotateYZX_s7cf157c3_c0(_dst, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6, _t24);
        rotateYZX_s7cf157c3_c1(_dst, _r5, _t21, _r6, _t22, _r4, _t24, _r3, _t23);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateYZX(double angleY, double angleZ, double angleX, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t4 * _t6;
        double _t11 = _t3 * _t7;
        double _t13 = _t6 * _t7;
        double _t21 = _t13 * _t8 - _t9 * _t5;
        double _t22 = _t9 * _t8 + _t13 * _t5;
        double _t23 = _t10 * _t8 - _t11 * _t5;
        rotateYZX_s7cf157c3_tail(d, _t11, _t8, _t10, _t5, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6);
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the Z axis to this rigid transform and store
     * the result in {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateZ(double angle, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        d.tX = this.tX;
        d.tY = this.tY;
        d.tZ = this.tZ;
        double _buf0 = this.rX * _t2 + this.rY * _t1;
        d.rY = this.rY * _t2 - this.rX * _t1;
        double _buf1 = this.rZ * _t2 + this.rW * _t1;
        d.rW = this.rW * _t2 - this.rZ * _t1;
        d.rX = _buf0;
        d.rZ = _buf1;
        return d;
    }

    /** Private store group 0 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_s302c98bf_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6, double _t24) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t21 + _r4 * _t22 + (_r5 * _t23 - _r6 * _t24);
    }

    /** Private store group 1 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_s302c98bf_c1(DoubleRigidImpl _dst, double _r5, double _t21, double _r6, double _t22, double _r4, double _t24, double _r3, double _t23) {
        _dst.rY = _r5 * _t21 + _r6 * _t22 + (_r4 * _t24 - _r3 * _t23);
        _dst.rZ = _r3 * _t24 + _r4 * _t23 + (_r6 * _t21 - _r5 * _t22);
        _dst.rW = _r4 * _t21 - _r3 * _t22 - (_r5 * _t24 + _r6 * _t23);
    }

    /** Private tail of {@code rotateZXY}; reached only through it. */
    private void rotateZXY_s302c98bf_tail(DoubleRigidImpl _dst, double _t9, double _t8, double _t13, double _t5, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6) {
        double _t24 = _t9 * _t8 + _t13 * _t5;
        rotateZXY_s302c98bf_c0(_dst, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6, _t24);
        rotateZXY_s302c98bf_c1(_dst, _r5, _t21, _r6, _t22, _r4, _t24, _r3, _t23);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateZXY(double angleZ, double angleX, double angleY, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t3 * _t7;
        double _t11 = _t4 * _t6;
        double _t13 = _t6 * _t7;
        double _t21 = _t13 * _t8 - _t9 * _t5;
        double _t22 = _t10 * _t8 - _t11 * _t5;
        double _t23 = _t10 * _t5 + _t11 * _t8;
        rotateZXY_s302c98bf_tail(d, _t9, _t8, _t13, _t5, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6);
        return d;
    }

    /** Private store group 0 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s249d0021_c0(DoubleRigidImpl _dst, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6, double _t24) {
        _dst.tX = _r0;
        _dst.tY = _r1;
        _dst.tZ = _r2;
        _dst.rX = _r3 * _t21 + _r4 * _t22 + (_r5 * _t23 - _r6 * _t24);
    }

    /** Private store group 1 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s249d0021_c1(DoubleRigidImpl _dst, double _r5, double _t21, double _r6, double _t22, double _r4, double _t24, double _r3, double _t23) {
        _dst.rY = _r5 * _t21 + _r6 * _t22 + (_r4 * _t24 - _r3 * _t23);
        _dst.rZ = _r3 * _t24 + _r4 * _t23 + (_r6 * _t21 - _r5 * _t22);
        _dst.rW = _r4 * _t21 - _r3 * _t22 - (_r5 * _t24 + _r6 * _t23);
    }

    /** Private tail of {@code rotateZYX}; reached only through it. */
    private void rotateZYX_s249d0021_tail(DoubleRigidImpl _dst, double _t11, double _t8, double _t10, double _t5, double _r0, double _r1, double _r2, double _r3, double _t21, double _r4, double _t22, double _r5, double _t23, double _r6) {
        double _t24 = _t11 * _t8 + _t10 * _t5;
        rotateZYX_s249d0021_c0(_dst, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6, _t24);
        rotateZYX_s249d0021_c1(_dst, _r5, _t21, _r6, _t22, _r4, _t24, _r3, _t23);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code R} the rotation rigid transform, then
     * the new rigid transform will be {@code M * R}. So when transforming a vector {@code v} with
     * the new rigid transform by using {@code M * R * v}, the rotation will be applied first.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid rotateZYX(double angleZ, double angleY, double angleX, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _r0 = this.tX;
        double _r1 = this.tY;
        double _r2 = this.tZ;
        double _r3 = this.rX;
        double _r4 = this.rW;
        double _r5 = this.rY;
        double _r6 = this.rZ;
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cosFromSin(_t3, _t0);
        double _t7 = Math.cosFromSin(_t4, _t1);
        double _t8 = Math.cosFromSin(_t5, _t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t4 * _t6;
        double _t11 = _t3 * _t7;
        double _t13 = _t6 * _t7;
        double _t21 = _t9 * _t5 + _t13 * _t8;
        double _t22 = _t13 * _t5 - _t9 * _t8;
        double _t23 = _t10 * _t8 - _t11 * _t5;
        rotateZYX_s249d0021_tail(d, _t11, _t8, _t10, _t5, _r0, _r1, _r2, _r3, _t21, _r4, _t22, _r5, _t23, _r6);
        return d;
    }


    /**
     * Apply a translation by {@code translation} to this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * If {@code M} is {@code this} rigid transform and {@code T} the translation rigid transform,
     * then the new rigid transform will be {@code M * T}. So when transforming a vector {@code v}
     * with the new rigid transform by using {@code M * T * v}, the translation will be applied
     * first.
     *
     * @param translation the translation offsets
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid translate(Double3R translation, @Mutated DoubleRigid dest) {
        return translate(translation.x(), translation.y(), translation.z(), dest);
    }


    /**
     * Apply a translation by ({@code translationX}, {@code translationY}, {@code translationZ}) to
     * this rigid transform and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRigid translate(double translationX, double translationY, double translationZ, @Mutated DoubleRigid dest) {
        DoubleRigidImpl d = (DoubleRigidImpl) dest;
        double _t9 = 2.0 * (this.rX * translationY - this.rY * translationX);
        double _t10 = 2.0 * (this.rY * translationZ - this.rZ * translationY);
        double _t11 = 2.0 * (this.rZ * translationX - this.rX * translationZ);
        d.tX = this.rY * _t9 + (this.rW * _t10 + (this.tX + translationX) - this.rZ * _t11);
        d.tY = this.rZ * _t10 + (this.rW * _t11 + (this.tY + translationY) - this.rX * _t9);
        d.tZ = this.rX * _t11 + (this.rW * _t9 + (this.tZ + translationZ) - this.rY * _t10);
        d.rX = this.rX;
        d.rY = this.rY;
        d.rZ = this.rZ;
        d.rW = this.rW;
        return d;
    }


    /**
     * Transform {@code v} by this rigid transform and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param v the vector to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Double3R v, @Mutated Double3 dest) {
        return transform(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this rigid transform and store the result
     * in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (this.rX * vY - this.rY * vX);
        double _t10 = 2.0 * (this.rY * vZ - this.rZ * vY);
        double _t11 = 2.0 * (this.rZ * vX - this.rX * vZ);
        d.x = this.rY * _t9 + (this.rW * _t10 + (this.tX + vX) - this.rZ * _t11);
        d.y = this.rZ * _t10 + (this.rW * _t11 + (this.tY + vY) - this.rX * _t9);
        d.z = this.rX * _t11 + (this.rW * _t9 + (this.tZ + vZ) - this.rY * _t10);
        return d;
    }


    /**
     * Transform the given direction by the rotation part of this rigid transform, ignoring the
     * translation and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param v the direction to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirection(Double3R v, @Mutated Double3 dest) {
        return transformDirection(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the rotation part of this rigid transform, ignoring the
     * translation and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Transform the given direction by the inverse of this rigid transform's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param v the direction to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformDirectionInverse(Double3R v, @Mutated Double3 dest) {
        return transformDirectionInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform the given direction by the inverse of this rigid transform's rotation (world to
     * local), ignoring the translation, without materializing {@code invert()} and store the result
     * in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Transform {@code p} by the inverse of this rigid transform and store the result in
     * {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(Double3R p, @Mutated Double3 dest) {
        return transformInverse(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Transform ({@code pX}, {@code pY}, {@code pZ}) by the inverse of this rigid transform and
     * store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
        d.x = this.rZ * _t12 + (this.rW * _t13 + _t1 - this.rY * _t14);
        d.y = this.rX * _t14 + (this.rW * _t12 + _t2 - this.rZ * _t13);
        d.z = this.rY * _t13 + (this.rW * _t14 + _t0 - this.rX * _t12);
        return d;
    }


    /**
     * Transform the given position by this rigid transform, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param v the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPosition(Double3R v, @Mutated Double3 dest) {
        return transform(v, dest);
    }


    /**
     * Transform the given position by this rigid transform, treating it as a point with an implicit
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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
     * Transform the given position by the inverse of this rigid transform (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
     *
     * @param p the position to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformPositionInverse(Double3R p, @Mutated Double3 dest) {
        return transformInverse(p, dest);
    }


    /**
     * Transform the given position by the inverse of this rigid transform (world to local), without
     * materializing {@code invert()} and store the result in {@code dest}.
     * <p>
     * The rotation quaternion of this rigid transform must have unit length.
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

    public double tX() { return this.tX; }
    public double tY() { return this.tY; }
    public double tZ() { return this.tZ; }
    public double rX() { return this.rX; }
    public double rY() { return this.rY; }
    public double rZ() { return this.rZ; }
    public double rW() { return this.rW; }

    @Override public String toString() {
        return "DoubleRigid(" + tX() + ", " + tY() + ", " + tZ() + ", " + rX() + ", " + rY() + ", " + rZ() + ", " + rW() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleRigidImpl)) return false;
        DoubleRigidImpl o = (DoubleRigidImpl) obj;
        return Double.doubleToLongBits(tX) == Double.doubleToLongBits(o.tX)
            && Double.doubleToLongBits(tY) == Double.doubleToLongBits(o.tY)
            && Double.doubleToLongBits(tZ) == Double.doubleToLongBits(o.tZ)
            && Double.doubleToLongBits(rX) == Double.doubleToLongBits(o.rX)
            && Double.doubleToLongBits(rY) == Double.doubleToLongBits(o.rY)
            && Double.doubleToLongBits(rZ) == Double.doubleToLongBits(o.rZ)
            && Double.doubleToLongBits(rW) == Double.doubleToLongBits(o.rW);
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
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(tX)
            && Double.isFinite(tY)
            && Double.isFinite(tZ)
            && Double.isFinite(rX)
            && Double.isFinite(rY)
            && Double.isFinite(rZ)
            && Double.isFinite(rW);
    }

    @Override public boolean equalsEpsilon(DoubleRigidR other, double epsilon) {
        return Math.abs(tX - other.tX()) <= epsilon
            && Math.abs(tY - other.tY()) <= epsilon
            && Math.abs(tZ - other.tZ()) <= epsilon
            && Math.abs(rX - other.rX()) <= epsilon
            && Math.abs(rY - other.rY()) <= epsilon
            && Math.abs(rZ - other.rZ()) <= epsilon
            && Math.abs(rW - other.rW()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.tX;
        dest[offset + 1] = this.tY;
        dest[offset + 2] = this.tZ;
        dest[offset + 3] = this.rX;
        dest[offset + 4] = this.rY;
        dest[offset + 5] = this.rZ;
        dest[offset + 6] = this.rW;
        return dest;
    }
    public @Mutated DoubleRigid load(double[] src, int offset) {
        this.tX = src[offset + 0];
        this.tY = src[offset + 1];
        this.tZ = src[offset + 2];
        this.rX = src[offset + 3];
        this.rY = src[offset + 4];
        this.rZ = src[offset + 5];
        this.rW = src[offset + 6];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleRigid loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleRigid loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleRigid storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleRigid loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleRigid load(long offset, MemorySegment src) {
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
        return dest;
    }
    public @Mutated DoubleRigid load(float[] src, int offset) {
        this.tX = src[offset + 0];
        this.tY = src[offset + 1];
        this.tZ = src[offset + 2];
        this.rX = src[offset + 3];
        this.rY = src[offset + 4];
        this.rZ = src[offset + 5];
        this.rW = src[offset + 6];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleRigid loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleRigid loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleRigid storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleRigid loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleRigid loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
