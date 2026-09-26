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
 * Generated implementation of {@link DoubleQuat} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleQuatImpl implements DoubleQuat {

    public double x;
    public double y;
    public double z;
    public double w;
    static final DoubleQuatSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleQuatSegOpsUnsafe()
                    : new DoubleQuatSegOpsMS();
    static final DoubleQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleQuatBbOpsUnsafe()
                    : new DoubleQuatBbOpsApi();
    static final DoubleQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleQuatRawOpsUnsafe()
                    : new DoubleQuatRawOpsApi();

    public DoubleQuatImpl() {
        w = 1;
    }

    public DoubleQuatImpl(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public DoubleQuatImpl(DoubleQuatR src) {
        this.x = src.x();
        this.y = src.y();
        this.z = src.z();
        this.w = src.w();
    }


    /**
     * Invert this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invert(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        double _t6_inv = 1.0 / _t6;
        d.x = -(this.x * _t6_inv);
        d.y = -(this.y * _t6_inv);
        d.z = -(this.z * _t6_inv);
        d.w = this.w * _t6_inv;
        return d;
    }


    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     *
     * @param other the right factor of the product
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invertProduct(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return invertProduct(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Compute the inverse of the product of this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invertProduct(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t24 = otherX * this.w + otherW * this.x + (otherZ * this.y - otherY * this.z);
        double _t25 = otherX * this.z + otherW * this.y + (otherY * this.w - otherZ * this.x);
        double _t26 = otherY * this.x + otherZ * this.w + (otherW * this.z - otherX * this.y);
        double _t27 = otherW * this.w - otherX * this.x - (otherY * this.y + otherZ * this.z);
        double _t34 = _t25 * _t25 + _t24 * _t24 + _t26 * _t26 + _t27 * _t27;
        double _t34_inv = 1.0 / _t34;
        d.x = -(_t24 * _t34_inv);
        d.y = -(_t25 * _t34_inv);
        d.z = -(_t26 * _t34_inv);
        d.w = _t27 * _t34_inv;
        return d;
    }


    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param other the quaternion to add
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat add(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return add(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) to this quaternion and
     * store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat add(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        d.z = otherZ + this.z;
        d.w = otherW + this.w;
        return d;
    }


    /**
     * Multiply each component of this quaternion by {@code scalar} and store the result in
     * {@code dest}.
     *
     * @param scalar the factor to multiply each component by
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat mul(double scalar, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = scalar * this.x;
        d.y = scalar * this.y;
        d.z = scalar * this.z;
        d.w = scalar * this.w;
        return d;
    }


    /**
     * Negate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat negate(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        d.w = -this.w;
        return d;
    }


    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     *
     * @param other the quaternion to subtract
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat sub(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return sub(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) from this
     * quaternion and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat sub(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        d.z = this.z - otherZ;
        d.w = this.w - otherW;
        return d;
    }


    /**
     * Set this quaternion to the unit quaternion
     * {@code (sqrt(1 - u1) sin(2 PI u2), sqrt(1 - u1) cos(2 PI u2), sqrt(u1) sin(2 PI u3), sqrt(u1) cos(2 PI u3))},
     * Shoemake's construction: samples uniformly distributed in {@code [0, 1)} give a rotation
     * uniformly distributed over all rotations ({@code makeRandomRotation} draws them from a
     * {@link java.util.Random}).
     *
     * @param u1 the sample that splits the unit length between {@code (x, y)} and {@code (z, w)},
     *        uniformly distributed in {@code [0, 1)} for a uniformly distributed rotation
     * @param u2 the fraction of a full turn of {@code (x, y)}, uniformly distributed in
     *        {@code [0, 1)} for a uniformly distributed rotation
     * @param u3 the fraction of a full turn of {@code (z, w)}, uniformly distributed in
     *        {@code [0, 1)} for a uniformly distributed rotation
     * @return this
     */
    @Mutated public DoubleQuat makeUniformRotation(double u1, double u2, double u3) {
        double _t0 = Math.sqrt(u1);
        double _t1 = u2 * 6.283185307179586;
        double _t3 = u3 * 6.283185307179586;
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sqrt(1.0 - u1);
        double _t6 = Math.sin(_t3);
        this.x = _t4 * _t5;
        this.y = Math.cosFromSin(_t4, _t1) * _t5;
        this.z = _t6 * _t0;
        this.w = Math.cosFromSin(_t6, _t3) * _t0;
        return this;
    }


    /**
     * Set this quaternion to the given values.
     *
     * @param v the quaternion to copy
     * @return this
     */
    public @Mutated DoubleQuat set(DoubleQuatR v) {
        return set(v.x(), v.y(), v.z(), v.w());
    }


    /**
     * Set this quaternion to the given values.
     *
     * @param vX the {@code x} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @return this
     */
    @Mutated public DoubleQuat set(double vX, double vY, double vZ, double vW) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.w = vW;
        return this;
    }


    /**
     * Convert this quaternion to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat toFloat(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = (float) (this.x);
        d.y = (float) (this.y);
        d.z = (float) (this.z);
        d.w = (float) (this.w);
        return d;
    }


    /**
     * Set this quaternion to the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion to convert
     * @return this
     */
    public @Mutated DoubleQuat makeFromDualQuat(DoubleDualQuatR dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Set this quaternion to the rotation (real) part of the unit dual quaternion ({@code dqRX},
     * {@code dqRY}, {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ},
     * {@code dqDW}).
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
    @Mutated public DoubleQuat makeFromDualQuat(double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        this.x = dqRX;
        this.y = dqRY;
        this.z = dqRZ;
        this.w = dqRW;
        return this;
    }

    /** Private store group 0 of {@code makeFromMatrix}: computes and stores it; reached only through it. */
    private void makeFromMatrix_s11ab8262_c0(DoubleQuatImpl _dst, double _t10, double _sp0, double _t1, double _r0, double _t2, double _t15, double _r1, double _r4, double _sp1, double _t4, double _sp2, double _t6, double _t7, double _sp3, double _t16, double _t8, double _t9, double _t17, double _t14) {
        _dst.x = _t10 > 0.0 ? _sp0 * _t1 : _r0 > _t2 ? 0.5 * Math.sqrt(_t15) : _r1 > _r4 ? _sp1 * _t4 : _sp2 * _t6;
        _dst.y = _t10 > 0.0 ? _sp0 * _t7 : _r0 > _t2 ? _sp3 * _t4 : _r1 > _r4 ? 0.5 * Math.sqrt(_t16) : _sp2 * _t8;
        _dst.z = _t10 > 0.0 ? _sp0 * _t9 : _r0 > _t2 ? _sp3 * _t6 : _r1 > _r4 ? _sp1 * _t8 : 0.5 * Math.sqrt(_t17);
        _dst.w = _t10 > 0.0 ? 0.5 * Math.sqrt(_t14) : _r0 > _t2 ? _sp3 * _t1 : _r1 > _r4 ? _sp1 * _t7 : _sp2 * _t9;
    }

    /** Private tail of {@code makeFromMatrix}; reached only through it. */
    private void makeFromMatrix_s11ab8262_tail(DoubleQuatImpl _dst, double _t15, double _t10, double _sp0, double _t1, double _r0, double _t2, double _r1, double _r4, double _sp1, double _t4, double _sp2, double _t6, double _t7, double _t16, double _t8, double _t9, double _t17, double _t14) {
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s11ab8262_c0(_dst, _t10, _sp0, _t1, _r0, _t2, _t15, _r1, _r4, _sp1, _t4, _sp2, _t6, _t7, _sp3, _t16, _t8, _t9, _t17, _t14);
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix (which must be a
     * rotation: orthonormal, with determinant +1 - a scaled or sheared block gives a wrong
     * quaternion, not a longer one; {@code getNormalizedRotation} strips scale first).
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double3x3R m) {
        DoubleQuatImpl d = this;
        double _r0 = m.m00();
        double _r1 = m.m11();
        double _r2 = m.m21();
        double _r3 = m.m12();
        double _r4 = m.m22();
        double _r5 = m.m01();
        double _r6 = m.m10();
        double _r7 = m.m02();
        double _r8 = m.m20();
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t2 = Math.max(_r1, _r4);
        double _t4 = _r5 + _r6;
        double _t6 = _r7 + _r8;
        double _t7 = _r7 - _r8;
        double _t8 = _r3 + _r2;
        double _t9 = _r6 - _r5;
        double _t10 = _r4 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r4));
        double _t16 = 1.0 + (_r1 - (_r0 + _r4));
        double _t17 = 1.0 + (_r4 - _t0);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t14));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t16));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t17));
        makeFromMatrix_s11ab8262_tail(d, _t15, _t10, _sp0, _t1, _r0, _t2, _r1, _r4, _sp1, _t4, _sp2, _t6, _t7, _t16, _t8, _t9, _t17, _t14);
        return d;
    }

    /** Private store group 0 of {@code makeFromMatrix}: computes and stores it; reached only through it. */
    private void makeFromMatrix_s11abf6c1_c0(DoubleQuatImpl _dst, double _t10, double _sp0, double _t1, double _r0, double _t2, double _t15, double _r1, double _r4, double _sp1, double _t4, double _sp2, double _t6, double _t7, double _sp3, double _t16, double _t8, double _t9, double _t17, double _t14) {
        _dst.x = _t10 > 0.0 ? _sp0 * _t1 : _r0 > _t2 ? 0.5 * Math.sqrt(_t15) : _r1 > _r4 ? _sp1 * _t4 : _sp2 * _t6;
        _dst.y = _t10 > 0.0 ? _sp0 * _t7 : _r0 > _t2 ? _sp3 * _t4 : _r1 > _r4 ? 0.5 * Math.sqrt(_t16) : _sp2 * _t8;
        _dst.z = _t10 > 0.0 ? _sp0 * _t9 : _r0 > _t2 ? _sp3 * _t6 : _r1 > _r4 ? _sp1 * _t8 : 0.5 * Math.sqrt(_t17);
        _dst.w = _t10 > 0.0 ? 0.5 * Math.sqrt(_t14) : _r0 > _t2 ? _sp3 * _t1 : _r1 > _r4 ? _sp1 * _t7 : _sp2 * _t9;
    }

    /** Private tail of {@code makeFromMatrix}; reached only through it. */
    private void makeFromMatrix_s11abf6c1_tail(DoubleQuatImpl _dst, double _t15, double _t10, double _sp0, double _t1, double _r0, double _t2, double _r1, double _r4, double _sp1, double _t4, double _sp2, double _t6, double _t7, double _t16, double _t8, double _t9, double _t17, double _t14) {
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s11abf6c1_c0(_dst, _t10, _sp0, _t1, _r0, _t2, _t15, _r1, _r4, _sp1, _t4, _sp2, _t6, _t7, _sp3, _t16, _t8, _t9, _t17, _t14);
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix (which must be a
     * rotation: orthonormal, with determinant +1 - a scaled or sheared block gives a wrong
     * quaternion, not a longer one; {@code getNormalizedRotation} strips scale first).
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double3x4R m) {
        DoubleQuatImpl d = this;
        double _r0 = m.m00();
        double _r1 = m.m11();
        double _r2 = m.m21();
        double _r3 = m.m12();
        double _r4 = m.m22();
        double _r5 = m.m01();
        double _r6 = m.m10();
        double _r7 = m.m02();
        double _r8 = m.m20();
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t2 = Math.max(_r1, _r4);
        double _t4 = _r5 + _r6;
        double _t6 = _r7 + _r8;
        double _t7 = _r7 - _r8;
        double _t8 = _r3 + _r2;
        double _t9 = _r6 - _r5;
        double _t10 = _r4 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r4));
        double _t16 = 1.0 + (_r1 - (_r0 + _r4));
        double _t17 = 1.0 + (_r4 - _t0);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t14));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t16));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t17));
        makeFromMatrix_s11abf6c1_tail(d, _t15, _t10, _sp0, _t1, _r0, _t2, _r1, _r4, _sp1, _t4, _sp2, _t6, _t7, _t16, _t8, _t9, _t17, _t14);
        return d;
    }

    /** Private store group 0 of {@code makeFromMatrix}: computes and stores it; reached only through it. */
    private void makeFromMatrix_s1360cf60_c0(DoubleQuatImpl _dst, double _t10, double _sp0, double _t1, double _r0, double _t2, double _t15, double _r1, double _r4, double _sp1, double _t4, double _sp2, double _t6, double _t7, double _sp3, double _t16, double _t8, double _t9, double _t17, double _t14) {
        _dst.x = _t10 > 0.0 ? _sp0 * _t1 : _r0 > _t2 ? 0.5 * Math.sqrt(_t15) : _r1 > _r4 ? _sp1 * _t4 : _sp2 * _t6;
        _dst.y = _t10 > 0.0 ? _sp0 * _t7 : _r0 > _t2 ? _sp3 * _t4 : _r1 > _r4 ? 0.5 * Math.sqrt(_t16) : _sp2 * _t8;
        _dst.z = _t10 > 0.0 ? _sp0 * _t9 : _r0 > _t2 ? _sp3 * _t6 : _r1 > _r4 ? _sp1 * _t8 : 0.5 * Math.sqrt(_t17);
        _dst.w = _t10 > 0.0 ? 0.5 * Math.sqrt(_t14) : _r0 > _t2 ? _sp3 * _t1 : _r1 > _r4 ? _sp1 * _t7 : _sp2 * _t9;
    }

    /** Private tail of {@code makeFromMatrix}; reached only through it. */
    private void makeFromMatrix_s1360cf60_tail(DoubleQuatImpl _dst, double _t15, double _t10, double _sp0, double _t1, double _r0, double _t2, double _r1, double _r4, double _sp1, double _t4, double _sp2, double _t6, double _t7, double _t16, double _t8, double _t9, double _t17, double _t14) {
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s1360cf60_c0(_dst, _t10, _sp0, _t1, _r0, _t2, _t15, _r1, _r4, _sp1, _t4, _sp2, _t6, _t7, _sp3, _t16, _t8, _t9, _t17, _t14);
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix (which must be a
     * rotation: orthonormal, with determinant +1 - a scaled or sheared block gives a wrong
     * quaternion, not a longer one; {@code getNormalizedRotation} strips scale first).
     *
     * @param m the matrix to convert
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double4x4R m) {
        DoubleQuatImpl d = this;
        double _r0 = m.m00();
        double _r1 = m.m11();
        double _r2 = m.m21();
        double _r3 = m.m12();
        double _r4 = m.m22();
        double _r5 = m.m01();
        double _r6 = m.m10();
        double _r7 = m.m02();
        double _r8 = m.m20();
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t2 = Math.max(_r1, _r4);
        double _t4 = _r5 + _r6;
        double _t6 = _r7 + _r8;
        double _t7 = _r7 - _r8;
        double _t8 = _r3 + _r2;
        double _t9 = _r6 - _r5;
        double _t10 = _r4 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r4));
        double _t16 = 1.0 + (_r1 - (_r0 + _r4));
        double _t17 = 1.0 + (_r4 - _t0);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t14));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t16));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t17));
        makeFromMatrix_s1360cf60_tail(d, _t15, _t10, _sp0, _t1, _r0, _t2, _r1, _r4, _sp1, _t4, _sp2, _t6, _t7, _t16, _t8, _t9, _t17, _t14);
        return d;
    }


    /**
     * Convert this quaternion to a pure-rotation dual quaternion (zero dual part) and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = this.x;
        d.rY = this.y;
        d.rZ = this.z;
        d.rW = this.w;
        d.dX = 0.0;
        d.dY = 0.0;
        d.dZ = 0.0;
        d.dW = 0.0;
        return d;
    }


    /**
     * Compute the matrix representation of this quaternion (which must have unit length) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _t0 = this.y * this.y;
        double _t1 = this.z * this.z;
        double _t2 = this.x * this.y;
        double _t3 = this.z * this.w;
        double _t4 = this.x * this.z;
        double _t5 = this.y * this.w;
        double _t6 = this.x * this.x;
        double _t7 = this.y * this.z;
        double _t8 = this.x * this.w;
        d.m00 = 1.0 - 2.0 * (_t0 + _t1);
        d.m10 = 2.0 * (_t2 + _t3);
        d.m20 = 2.0 * (_t4 - _t5);
        d.m30 = 0.0;
        d.m01 = 2.0 * (_t2 - _t3);
        d.m11 = 1.0 - 2.0 * (_t6 + _t1);
        d.m21 = 2.0 * (_t8 + _t7);
        d.m31 = 0.0;
        d.m02 = 2.0 * (_t4 + _t5);
        d.m12 = 2.0 * (_t7 - _t8);
        d.m22 = 1.0 - 2.0 * (_t6 + _t0);
        d.m32 = 0.0;
        d.m03 = 0.0;
        d.m13 = 0.0;
        d.m23 = 0.0;
        d.m33 = 1.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Compute the 3x3 rotation matrix representation of this quaternion (which must have unit
     * length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        double _t0 = this.y * this.y;
        double _t1 = this.z * this.z;
        double _t2 = this.x * this.y;
        double _t3 = this.z * this.w;
        double _t4 = this.x * this.z;
        double _t5 = this.y * this.w;
        double _t6 = this.x * this.x;
        double _t7 = this.y * this.z;
        double _t8 = this.x * this.w;
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
     * Compute the 3x4 matrix representation of this quaternion (which must have unit length; the
     * omitted last row is implicitly {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        Double3x4Impl d = (Double3x4Impl) dest;
        double _t0 = this.y * this.y;
        double _t1 = this.z * this.z;
        double _t2 = this.x * this.y;
        double _t3 = this.z * this.w;
        double _t4 = this.x * this.z;
        double _t5 = this.y * this.w;
        double _t6 = this.x * this.x;
        double _t7 = this.y * this.z;
        double _t8 = this.x * this.w;
        d.m00 = 1.0 - 2.0 * (_t0 + _t1);
        d.m01 = 2.0 * (_t2 - _t3);
        d.m02 = 2.0 * (_t4 + _t5);
        d.m03 = 0.0;
        d.m10 = 2.0 * (_t2 + _t3);
        d.m11 = 1.0 - 2.0 * (_t6 + _t1);
        d.m12 = 2.0 * (_t7 - _t8);
        d.m13 = 0.0;
        d.m20 = 2.0 * (_t4 - _t5);
        d.m21 = 2.0 * (_t8 + _t7);
        d.m22 = 1.0 - 2.0 * (_t6 + _t0);
        d.m23 = 0.0;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
    }


    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axis} followed
     * by a twist about {@code axis}, storing them in {@code swing} and {@code twist} respectively,
     * such that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param swing will hold the swing
     * @param twist will hold the twist
     * @return this
     */
    public DoubleQuat decomposeSwingTwist(Double3R axis, @Mutated DoubleQuat swing, @Mutated DoubleQuat twist) {
        return decomposeSwingTwist(axis.x(), axis.y(), axis.z(), swing, twist);
    }


    /**
     * Decompose this quaternion into a swing about an axis perpendicular to ({@code axisX},
     * {@code axisY}, {@code axisZ}) followed by a twist about ({@code axisX}, {@code axisY},
     * {@code axisZ}), storing them in {@code swing} and {@code twist} respectively, such that
     * {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param swing will hold the swing
     * @param twist will hold the twist
     * @return this
     */
    public DoubleQuat decomposeSwingTwist(double axisX, double axisY, double axisZ, @Mutated DoubleQuat swing, @Mutated DoubleQuat twist) {
        DoubleQuatImpl d0 = (DoubleQuatImpl) swing;
        DoubleQuatImpl d1 = (DoubleQuatImpl) twist;
        double _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        double _t7 = this.w * this.w + _t5 * _t5;
        double _t8 = (1.0 / Math.sqrt(_t7));
        double _t10 = _t5 * _t8;
        double _t14, _t15, _t16, _t17;
        if (_t7 > 1.0E-30) {
            _t14 = this.w * _t8;
            _t15 = axisX * _t10;
            _t16 = axisY * _t10;
            _t17 = axisZ * _t10;
        } else {
            _t14 = 1.0;
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        double _d0buf0 = this.x * _t14 - this.w * _t15 + (this.z * _t16 - this.y * _t17);
        double _d0buf1 = this.x * _t17 - this.w * _t16 + (this.y * _t14 - this.z * _t15);
        double _d0buf2 = this.y * _t15 + this.z * _t14 + (-(this.w * _t17) - this.x * _t16);
        d0.w = this.x * _t15 + this.w * _t14 - (-(this.y * _t16) - this.z * _t17);
        d0.x = _d0buf0;
        d0.y = _d0buf1;
        d0.z = _d0buf2;
        d1.x = _t15;
        d1.y = _t16;
        d1.z = _t17;
        d1.w = _t14;
        return this;
    }


    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to {@code axis} in
     * the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getSwing(Double3R axis, @Mutated DoubleQuat dest) {
        return getSwing(axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to ({@code axisX},
     * {@code axisY}, {@code axisZ}) in the swing-twist decomposition and store the result in
     * {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     *
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getSwing(double axisX, double axisY, double axisZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        double _t7 = this.w * this.w + _t5 * _t5;
        double _t8 = (1.0 / Math.sqrt(_t7));
        double _t10 = _t5 * _t8;
        double _t14, _t15, _t16, _t17;
        if (_t7 > 1.0E-30) {
            _t14 = this.w * _t8;
            _t15 = axisX * _t10;
            _t16 = axisY * _t10;
            _t17 = axisZ * _t10;
        } else {
            _t14 = 1.0;
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        double _buf0 = this.x * _t14 - this.w * _t15 + (this.z * _t16 - this.y * _t17);
        double _buf1 = this.x * _t17 - this.w * _t16 + (this.y * _t14 - this.z * _t15);
        double _buf2 = this.y * _t15 + this.z * _t14 + (-(this.w * _t17) - this.x * _t16);
        d.w = this.x * _t15 + this.w * _t14 - (-(this.y * _t16) - this.z * _t17);
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Extract the twist component of this quaternion: the rotation about {@code axis} in the
     * swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getTwist(Double3R axis, @Mutated DoubleQuat dest) {
        return getTwist(axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Extract the twist component of this quaternion: the rotation about ({@code axisX},
     * {@code axisY}, {@code axisZ}) in the swing-twist decomposition and store the result in
     * {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     *
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getTwist(double axisX, double axisY, double axisZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        double _t7 = this.w * this.w + _t5 * _t5;
        double _t8 = (1.0 / Math.sqrt(_t7));
        double _t9 = _t5 * _t8;
        if (_t7 > 1.0E-30) {
            d.x = axisX * _t9;
            d.y = axisY * _t9;
            d.z = axisZ * _t9;
            d.w = this.w * _t8;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 1.0;
        }
        return d;
    }


    /**
     * Set this quaternion to the identity.
     *
     * @return this
     */
    @Mutated public DoubleQuat makeIdentity() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 1.0;
        return this;
    }


    /**
     * Set all components of this quaternion to zero.
     *
     * @return this
     */
    @Mutated public DoubleQuat makeZero() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 0.0;
        return this;
    }


    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the quaternion to interpolate towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lerp(DoubleQuatR other, double t, @Mutated DoubleQuat dest) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t, dest);
    }


    /**
     * Linearly interpolate between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}) using the interpolation factor {@code t} and store the result
     * in {@code dest}.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) (interpolation factor
     * {@code 1}).
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lerp(double otherX, double otherY, double otherZ, double otherW, double t, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = t * (otherX - this.x) + this.x;
        d.y = t * (otherY - this.y) + this.y;
        d.z = t * (otherZ - this.z) + this.z;
        d.w = t * (otherW - this.w) + this.w;
        return d;
    }


    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this quaternion must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * {@code target} (interpolation factor {@code 1}).
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat nlerp(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        return nlerp(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }


    /**
     * Interpolate between this quaternion and ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}) using the interpolation factor {@code alpha} and normalize the result and
     * store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this quaternion must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) (interpolation factor
     * {@code 1}).
     *
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat nlerp(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t8 = alpha * (targetX - this.x) + this.x;
        double _t9 = alpha * (targetY - this.y) + this.y;
        double _t10 = alpha * (targetZ - this.z) + this.z;
        double _t11 = alpha * (targetW - this.w) + this.w;
        double _t18 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10 + _t11 * _t11;
        double _t19 = (1.0 / Math.sqrt(_t18));
        if (_t18 != 0.0) {
            d.x = _t8 * _t19;
            d.y = _t9 * _t19;
            d.z = _t10 * _t19;
            d.w = _t11 * _t19;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
        }
        return d;
    }


    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this quaternion must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * {@code target} (interpolation factor {@code 1}).
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat nlerpShortest(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        return nlerpShortest(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }


    /**
     * Interpolate along the shortest path between this quaternion and ({@code targetX},
     * {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this quaternion must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) (interpolation factor
     * {@code 1}).
     *
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat nlerpShortest(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t11 = -(this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW);
        double _t24, _t25, _t26, _t27;
        if (_t11 > 0.0) {
            _t24 = alpha * (-targetX - this.x) + this.x;
            _t25 = alpha * (-targetY - this.y) + this.y;
            _t26 = alpha * (-targetZ - this.z) + this.z;
            _t27 = alpha * (-targetW - this.w) + this.w;
        } else {
            _t24 = alpha * (targetX - this.x) + this.x;
            _t25 = alpha * (targetY - this.y) + this.y;
            _t26 = alpha * (targetZ - this.z) + this.z;
            _t27 = alpha * (targetW - this.w) + this.w;
        }
        double _t34 = _t24 * _t24 + _t25 * _t25 + _t26 * _t26 + _t27 * _t27;
        double _t35 = (1.0 / Math.sqrt(_t34));
        if (_t34 != 0.0) {
            d.x = _t24 * _t35;
            d.y = _t25 * _t35;
            d.z = _t26 * _t35;
            d.w = _t27 * _t35;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
        }
        return d;
    }


    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * {@code target} using the interpolation factor {@code alpha} and store the result in
     * {@code dest}.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * {@code target} (interpolation factor {@code 1}).
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat slerp(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        return slerp(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }


    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation
     * factor {@code alpha} and store the result in {@code dest}.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) (interpolation factor
     * {@code 1}).
     *
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat slerp(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 1.0 - alpha;
        double _t1 = this.x + targetX;
        double _t2 = this.y + targetY;
        double _t3 = this.z + targetZ;
        double _t4 = this.w + targetW;
        double _t5 = alpha < 0.5 ? 1.0 : 0.0;
        double _t14 = Math.min(4.0, _t1 * _t1 + _t2 * _t2 + _t3 * _t3 + _t4 * _t4);
        double _t15 = quatArcAngle(_t14);
        double _t16 = 4.0 - _t14;
        double _t21 = _t16 * _t14;
        double _t22 = Math.sqrt(_t21);
        double _t24 = 2.0 / _t22;
        double _t29, _t30;
        if (_t22 > 2.0E-14) {
            _t29 = _t24 * Math.sin(alpha * _t15);
            _t30 = _t24 * Math.sin(_t0 * _t15);
        } else {
            if (_t14 > _t16) {
                _t29 = alpha;
                _t30 = _t0;
            } else {
                _t29 = 1.0 - _t5;
                _t30 = _t5;
            }
        }
        d.x = this.x * _t30 + targetX * _t29;
        d.y = this.y * _t30 + targetY * _t29;
        d.z = this.z * _t30 + targetZ * _t29;
        d.w = this.w * _t30 + targetW * _t29;
        return d;
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha} and store the result
     * in {@code dest}.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * {@code target} (interpolation factor {@code 1}).
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat slerpShortest(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        return slerpShortest(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }

    /** Private store group 0 of {@code slerpShortest}: computes and stores it; reached only through it. */
    private void slerpShortest_s323d976d_c0(DoubleQuatImpl _dst, double _t63, double _t64, double _t53, double _t54, double _t55, double _t56) {
        _dst.x = _t63 != 0.0 ? _t64 * _t53 : 0.0;
        _dst.y = _t63 != 0.0 ? _t64 * _t54 : 0.0;
        _dst.z = _t63 != 0.0 ? _t64 * _t55 : 0.0;
        _dst.w = _t63 != 0.0 ? _t64 * _t56 : 0.0;
    }

    /** Private tail of {@code slerpShortest}; reached only through it. */
    private void slerpShortest_s323d976d_tail(DoubleQuatImpl _dst, double _t20, double _r0, double _t28, double _t22, double _t24, double _t20_inv, double alpha, double _t0, double _r1, double _t25, double _r2, double _t26, double _r3, double _t27) {
        double _t53, _t54, _t55, _t56;
        if (_t20 > 0.0) {
            _t53 = (_r0 * _t28 + _t22 * _t24) * _t20_inv;
            _t54 = (_r1 * _t28 + _t22 * _t25) * _t20_inv;
            _t55 = (_r2 * _t28 + _t22 * _t26) * _t20_inv;
            _t56 = (_r3 * _t28 + _t22 * _t27) * _t20_inv;
        } else {
            _t53 = alpha * _t24 + _r0 * _t0;
            _t54 = alpha * _t25 + _r1 * _t0;
            _t55 = alpha * _t26 + _r2 * _t0;
            _t56 = alpha * _t27 + _r3 * _t0;
        }
        double _t63 = _t53 * _t53 + _t54 * _t54 + _t55 * _t55 + _t56 * _t56;
        double _t64 = (1.0 / Math.sqrt(_t63));
        slerpShortest_s323d976d_c0(_dst, _t63, _t64, _t53, _t54, _t55, _t56);
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) using the
     * interpolation factor {@code alpha} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this quaternion (interpolation factor {@code 0}) and ends at
     * ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) (interpolation factor
     * {@code 1}).
     *
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)} (the quaternion must have unit length)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat slerpShortest(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.y;
        double _r2 = this.z;
        double _r3 = this.w;
        double _t0 = 1.0 - alpha;
        double _t15 = _r0 * targetX + _r1 * targetY + _r2 * targetZ + _r3 * targetW;
        double _t17 = -_t15;
        double _t19 = Math.acos(Math.min(1.0, Math.abs(_t15)));
        double _t20 = Math.sin(_t19);
        double _t20_inv = 1.0 / _t20;
        double _t22 = Math.sin(alpha * _t19);
        double _t24, _t25, _t26, _t27;
        if (_t17 > 0.0) {
            _t24 = -targetX;
            _t25 = -targetY;
            _t26 = -targetZ;
            _t27 = -targetW;
        } else {
            _t24 = targetX;
            _t25 = targetY;
            _t26 = targetZ;
            _t27 = targetW;
        }
        double _t28 = Math.sin(_t0 * _t19);
        slerpShortest_s323d976d_tail(d, _t20, _r0, _t28, _t22, _t24, _t20_inv, alpha, _t0, _r1, _t25, _r2, _t26, _r3, _t27);
        return d;
    }


    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions and store the
     * result in {@code dest}.
     *
     * @param control0 the inner control quaternion associated with the start rotation
     * @param control1 the inner control quaternion associated with the end rotation
     * @param target the target rotation
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat squad(DoubleQuatR control0, DoubleQuatR control1, DoubleQuatR target, double t, @Mutated DoubleQuat dest) {
        return squad(control0.x(), control0.y(), control0.z(), control0.w(), control1.x(), control1.y(), control1.z(), control1.w(), target.x(), target.y(), target.z(), target.w(), t, dest);
    }

    /** Private store group 0 of {@code squad}: computes and stores it; reached only through it. */
    private void squad_s41d92dd3_c0(DoubleQuatImpl _dst, double _t80, double _t114, double _t81, double _t115, double _t82, double _t83, double _t84, double _t85, double _t86, double _t87) {
        _dst.x = _t80 * _t114 + _t81 * _t115;
        _dst.y = _t82 * _t114 + _t83 * _t115;
        _dst.z = _t84 * _t114 + _t85 * _t115;
        _dst.w = _t86 * _t114 + _t87 * _t115;
    }

    /** Private tail of {@code squad}; reached only through it. */
    private void squad_s41d92dd3_tail(DoubleQuatImpl _dst, double _t7, double _t8, double _t9, double _t10, double _t30, double t, double _t11, double _t0, double _t6, double control0X, double control1X, double _r0, double targetX, double control0Y, double control1Y, double _r1, double targetY, double control0Z, double control1Z, double _r2, double targetZ, double control0W, double control1W, double _r3, double targetW, double _t12, double _t22, double _t13) {
        double _t31 = Math.min(4.0, _t7 * _t7 + _t8 * _t8 + _t9 * _t9 + _t10 * _t10);
        double _t32 = quatArcAngle(_t30);
        double _t33 = quatArcAngle(_t31);
        double _t34 = 4.0 - _t30;
        double _t35 = 4.0 - _t31;
        double _t44 = _t34 * _t30;
        double _t45 = _t35 * _t31;
        double _t46 = Math.sqrt(_t44);
        double _t48 = Math.sqrt(_t45);
        double _t50 = 2.0 / _t46;
        double _t51 = 2.0 / _t48;
        double _t60 = _t46 > 2.0E-14 ? _t50 * Math.sin(t * _t32) : _t30 > _t34 ? t : _t11;
        double _t61 = _t48 > 2.0E-14 ? _t51 * Math.sin(t * _t33) : _t31 > _t35 ? t : _t11;
        squad_s41d92dd3_tail2(_dst, _t46, _t50, _t0, _t32, _t30, _t34, _t6, _t48, _t51, _t33, _t31, _t35, control0X, control1X, _t60, _r0, targetX, _t61, control0Y, control1Y, _r1, targetY, control0Z, control1Z, _r2, targetZ, control0W, control1W, _r3, targetW, _t12, _t22, _t13);
    }

    /** Private tail of {@code squad}; reached only through it. */
    private void squad_s41d92dd3_tail2(DoubleQuatImpl _dst, double _t46, double _t50, double _t0, double _t32, double _t30, double _t34, double _t6, double _t48, double _t51, double _t33, double _t31, double _t35, double control0X, double control1X, double _t60, double _r0, double targetX, double _t61, double control0Y, double control1Y, double _r1, double targetY, double control0Z, double control1Z, double _r2, double targetZ, double control0W, double control1W, double _r3, double targetW, double _t12, double _t22, double _t13) {
        double _t62 = _t46 > 2.0E-14 ? _t50 * Math.sin(_t0 * _t32) : _t30 > _t34 ? _t0 : _t6;
        double _t63 = _t48 > 2.0E-14 ? _t51 * Math.sin(_t0 * _t33) : _t31 > _t35 ? _t0 : _t6;
        double _t80 = control0X * _t62 + control1X * _t60;
        double _t81 = _r0 * _t63 + targetX * _t61;
        double _t82 = control0Y * _t62 + control1Y * _t60;
        double _t83 = _r1 * _t63 + targetY * _t61;
        double _t84 = control0Z * _t62 + control1Z * _t60;
        double _t85 = _r2 * _t63 + targetZ * _t61;
        double _t86 = control0W * _t62 + control1W * _t60;
        double _t87 = _r3 * _t63 + targetW * _t61;
        double _t88 = _t80 + _t81;
        double _t89 = _t82 + _t83;
        double _t90 = _t84 + _t85;
        double _t91 = _t86 + _t87;
        squad_s41d92dd3_tail3(_dst, _t88, _t89, _t90, _t91, _t12, _t22, _t13, _t80, _t81, _t82, _t83, _t84, _t85, _t86, _t87);
    }

    /** Private tail of {@code squad}; reached only through it. */
    private void squad_s41d92dd3_tail3(DoubleQuatImpl _dst, double _t88, double _t89, double _t90, double _t91, double _t12, double _t22, double _t13, double _t80, double _t81, double _t82, double _t83, double _t84, double _t85, double _t86, double _t87) {
        double _t99 = Math.min(4.0, _t88 * _t88 + _t89 * _t89 + _t90 * _t90 + _t91 * _t91);
        double _t100 = quatArcAngle(_t99);
        double _t101 = 4.0 - _t99;
        double _t106 = _t101 * _t99;
        double _t107 = Math.sqrt(_t106);
        double _t109 = 2.0 / _t107;
        double _t114, _t115;
        if (_t107 > 2.0E-14) {
            _t114 = _t109 * Math.sin(_t12 * _t100);
            _t115 = _t109 * Math.sin(_t13 * _t100);
        } else {
            if (_t99 > _t101) {
                _t114 = _t12;
                _t115 = _t13;
            } else {
                _t114 = 1.0 - _t22;
                _t115 = _t22;
            }
        }
        squad_s41d92dd3_c0(_dst, _t80, _t114, _t81, _t115, _t82, _t83, _t84, _t85, _t86, _t87);
    }


    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions and store the
     * result in {@code dest}.
     *
     * @param control0X the {@code x} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control0Y the {@code y} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control0Z the {@code z} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control0W the {@code w} component of the quaternion
     *        {@code (control0X, control0Y, control0Z, control0W)}
     * @param control1X the {@code x} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param control1Y the {@code y} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param control1Z the {@code z} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param control1W the {@code w} component of the quaternion
     *        {@code (control1X, control1Y, control1Z, control1W)}
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat squad(double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.y;
        double _r2 = this.z;
        double _r3 = this.w;
        double _t0 = 1.0 - t;
        double _t2 = control0X + control1X;
        double _t3 = control0Y + control1Y;
        double _t4 = control0Z + control1Z;
        double _t5 = control0W + control1W;
        double _t6 = t < 0.5 ? 1.0 : 0.0;
        double _t7 = _r0 + targetX;
        double _t8 = _r1 + targetY;
        double _t9 = _r2 + targetZ;
        double _t10 = _r3 + targetW;
        double _t11 = 1.0 - _t6;
        double _t12 = _t0 * (t + t);
        double _t13 = 1.0 - _t12;
        double _t22 = _t12 < 0.5 ? 1.0 : 0.0;
        double _t30 = Math.min(4.0, _t2 * _t2 + _t3 * _t3 + _t4 * _t4 + _t5 * _t5);
        squad_s41d92dd3_tail(d, _t7, _t8, _t9, _t10, _t30, t, _t11, _t0, _t6, control0X, control1X, _r0, targetX, control0Y, control1Y, _r1, targetY, control0Z, control1Z, _r2, targetZ, control0W, control1W, _r3, targetW, _t12, _t22, _t13);
        return d;
    }


    /**
     * Multiply this quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param other the right operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat mul(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return mul(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Multiply this quaternion by ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW})
     * and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat mul(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _buf0 = otherX * this.w + otherW * this.x + (otherZ * this.y - otherY * this.z);
        double _buf1 = otherX * this.z + otherW * this.y + (otherY * this.w - otherZ * this.x);
        double _buf2 = otherY * this.x + otherZ * this.w + (otherW * this.z - otherX * this.y);
        d.w = otherW * this.w - otherX * this.x - (otherY * this.y + otherZ * this.z);
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Pre-multiply the transformation {@code other} onto this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param other the left operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preMul(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return preMul(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Pre-multiply the transformation ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) onto this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preMul(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _buf0 = otherX * this.w + otherW * this.x + (otherY * this.z - otherZ * this.y);
        double _buf1 = otherY * this.w + otherZ * this.x + (otherW * this.y - otherX * this.z);
        double _buf2 = otherX * this.y + otherW * this.z + (otherZ * this.w - otherY * this.x);
        d.w = otherW * this.w - otherX * this.x - (otherY * this.y + otherZ * this.z);
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Add {@code other} scaled by {@code weight} to this quaternion and store the result in
     * {@code dest}.
     *
     * @param other the quaternion to scale and add
     * @param weight the factor to scale {@code other} by before adding
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat addScaled(DoubleQuatR other, double weight, @Mutated DoubleQuat dest) {
        return addScaled(other.x(), other.y(), other.z(), other.w(), weight, dest);
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) scaled by {@code weight}
     * to this quaternion and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param weight the factor to scale ({@code otherX}, {@code otherY}, {@code otherZ},
     *        {@code otherW}) by before adding
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat addScaled(double otherX, double otherY, double otherZ, double otherW, double weight, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = weight * otherX + this.x;
        d.y = weight * otherY + this.y;
        d.z = weight * otherZ + this.z;
        d.w = weight * otherW + this.w;
        return d;
    }


    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    public double angle() {
        return 2.0 * Math.atan2(Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z), this.w);
    }


    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     * <p>
     * This quaternion must have unit length.
     *
     * @param other the quaternion to measure the angle to
     * @return the angle in radians between this quaternion and {@code other}
     */
    public double angleTo(DoubleQuatR other) {
        return angleTo(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the angle in radians between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     * <p>
     * This quaternion must have unit length.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the angle in radians between this quaternion and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public double angleTo(double otherX, double otherY, double otherZ, double otherW) {
        double _t11 = -(otherX * this.x + otherY * this.y + otherZ * this.z + otherW * this.w);
        double _t12, _t13, _t14, _t15;
        if (_t11 > 0.0) {
            _t12 = -otherX;
            _t13 = -otherY;
            _t14 = -otherZ;
            _t15 = -otherW;
        } else {
            _t12 = otherX;
            _t13 = otherY;
            _t14 = otherZ;
            _t15 = otherW;
        }
        double _t16 = this.x - _t12;
        double _t17 = this.y - _t13;
        double _t18 = this.z - _t14;
        double _t19 = this.w - _t15;
        double _t20 = this.x + _t12;
        double _t21 = this.y + _t13;
        double _t22 = this.z + _t14;
        double _t23 = this.w + _t15;
        return 4.0 * Math.atan2(Math.sqrt(_t16 * _t16 + _t17 * _t17 + _t18 * _t18 + _t19 * _t19), Math.sqrt(_t20 * _t20 + _t21 * _t21 + _t22 * _t22 + _t23 * _t23));
    }


    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 axis(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t5 = (1.0 / Math.sqrt(_t4));
        if (_t4 > 0.0) {
            d.x = this.x * _t5;
            d.y = this.y * _t5;
            d.z = this.z * _t5;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Recompute the {@code w} component of this quaternion from {@code x}, {@code y} and {@code z},
     * assuming unit length (the positive square root is chosen) and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat calculateW(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _buf0 = this.x;
        double _buf1 = this.y;
        double _buf2 = this.z;
        d.w = Math.sqrt(Math.max(0.0, 1.0 - this.z * this.z - this.y * this.y - this.x * this.x));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Conjugate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugate(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        d.w = this.w;
        return d;
    }


    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length)
     * and store the result in {@code dest}.
     *
     * @param q the quaternion to conjugate by
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugateBy(DoubleQuatR q, @Mutated DoubleQuat dest) {
        return conjugateBy(q.x(), q.y(), q.z(), q.w(), dest);
    }


    /**
     * Conjugate this quaternion by ({@code qX}, {@code qY}, {@code qZ}, {@code qW}), i.e. compute
     * {@code q * this * conj(q)} where {@code q} is the given quaternion (equal to
     * {@code q * this * q^-1} when it has unit length) and store the result in {@code dest}.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugateBy(double qX, double qY, double qZ, double qW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t24 = qX * this.y + qW * this.z + (qZ * this.w - qY * this.x);
        double _t25 = qY * this.w + qZ * this.x + (qW * this.y - qX * this.z);
        double _t26 = qX * this.w + qW * this.x + (qY * this.z - qZ * this.y);
        double _t27 = qW * this.w - qX * this.x - (qY * this.y + qZ * this.z);
        d.x = qY * _t24 - qZ * _t25 + (qW * _t26 - qX * _t27);
        d.y = qZ * _t26 - qY * _t27 + (qW * _t25 - qX * _t24);
        d.z = qX * _t25 + qW * _t24 + (-(qZ * _t27) - qY * _t26);
        d.w = qX * _t26 + qW * _t27 - (-(qY * _t25) - qZ * _t24);
        return d;
    }


    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation {@code D}
     * with {@code this * D = other}, that is {@code D = this^-1 * other} and store the result in
     * {@code dest}.
     *
     * @param other the target quaternion, reached by composing this quaternion with the result
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat difference(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return difference(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Compute the difference between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}), i.e. the rotation {@code D} with
     * {@code this * D = (otherX, otherY, otherZ, otherW)}, that is
     * {@code D = this^-1 * (otherX, otherY, otherZ, otherW)} and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat difference(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t6_inv = 1.0 / (this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
        double _sp1 = this.z * _t6_inv;
        double _sp0 = this.y * _t6_inv;
        double _buf0 = (otherX * this.w - otherW * this.x + (otherY * this.z - otherZ * this.y)) * _t6_inv;
        double _buf1 = -(otherW * _sp0) - otherX * _sp1 + (otherY * this.w + otherZ * this.x) * _t6_inv;
        d.z = (otherX * this.y - otherW * this.z + (otherZ * this.w - otherY * this.x)) * _t6_inv;
        d.w = (otherX * this.x + otherW * this.w) * _t6_inv - (-(otherY * _sp0) - otherZ * _sp1);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param other the other operand of the dot product
     * @return the dot product of this quaternion and {@code other}
     */
    public double dot(DoubleQuatR other) {
        return dot(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the dot product of this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the dot product of this quaternion and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public double dot(double otherX, double otherY, double otherZ, double otherW) {
        return otherX * this.x + otherY * this.y + otherZ * this.z + otherW * this.w;
    }


    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat exp(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = Math.exp(this.w);
        double _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t6 = Math.sqrt(_t5);
        double _t8 = Math.sin(_t6);
        double _t10 = _t8 * _t0 / _t6;
        if (_t5 > 0.0) {
            d.x = this.x * _t10;
            d.y = this.y * _t10;
            d.z = this.z * _t10;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        d.w = Math.cosFromSin(_t8, _t6) * _t0;
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
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
     * This quaternion must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.x * this.x;
        double _t1 = this.y * this.y;
        double _t2 = this.x * this.w;
        double _t3 = this.y * this.z;
        double _t6 = this.z * this.z;
        double _t11 = 2.0 * (_t2 - _t3);
        double _t12 = 2.0 * (this.x * this.z + this.y * this.w);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            double _buf0 = Math.atan2(2.0 * (_t2 + _t3), 1.0 - 2.0 * (_t0 + _t6));
            d.z = 0.0;
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(_t11, _t13);
            d.z = Math.atan2(2.0 * (this.z * this.w - this.x * this.y), 1.0 - 2.0 * (_t1 + _t6));
            d.x = _buf0;
        }
        d.y = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
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
     * This quaternion must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.x * this.x;
        double _t1 = this.z * this.z;
        double _t2 = this.x * this.w;
        double _t3 = this.y * this.z;
        double _t6 = this.y * this.y;
        double _t11 = 2.0 * (_t2 + _t3);
        double _t12 = 2.0 * (this.z * this.w - this.x * this.y);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            double _buf0 = Math.atan2(2.0 * (_t2 - _t3), 1.0 - 2.0 * (_t0 + _t6));
            d.y = 0.0;
            d.x = _buf0;
        } else {
            double _buf0 = Math.atan2(_t11, _t13);
            d.y = Math.atan2(2.0 * (this.x * this.z + this.y * this.w), 1.0 - 2.0 * (_t6 + _t1));
            d.x = _buf0;
        }
        d.z = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
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
     * This quaternion must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = this.x * this.x;
        double _t3 = this.y * this.y;
        double _t4 = this.x * this.z;
        double _t5 = this.y * this.w;
        double _t6 = this.z * this.z;
        double _t10 = 2.0 * (this.x * this.w - this.y * this.z);
        double _t12 = 2.0 * (_t4 + _t5);
        double _t13 = 1.0 - 2.0 * (_t2 + _t3);
        double _t17 = _t13 * _t13 + _t12 * _t12;
        double _t19 = (_t17 + _t10 * _t10) * 1.0E-15;
        if (_t17 < _t19) {
            double _buf0 = Math.atan2(2.0 * (_t5 - _t4), 1.0 - 2.0 * (_t3 + _t6));
            d.z = 0.0;
            d.y = _buf0;
        } else {
            double _buf0 = Math.atan2(_t12, _t13);
            d.z = Math.atan2(2.0 * (this.x * this.y + this.z * this.w), 1.0 - 2.0 * (_t2 + _t6));
            d.y = _buf0;
        }
        d.x = Math.atan2(_t10, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
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
     * This quaternion must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.y * this.y;
        double _t1 = this.z * this.z;
        double _t2 = this.y * this.w;
        double _t3 = this.x * this.z;
        double _t6 = this.x * this.x;
        double _t11 = 2.0 * (_t2 - _t3);
        double _t12 = 2.0 * (this.x * this.y + this.z * this.w);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            d.x = 0.0;
            d.y = Math.atan2(2.0 * (_t3 + _t2), 1.0 - 2.0 * (_t6 + _t0));
        } else {
            d.x = Math.atan2(2.0 * (this.x * this.w - this.y * this.z), 1.0 - 2.0 * (_t6 + _t1));
            d.y = Math.atan2(_t11, _t13);
        }
        d.z = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
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
     * This quaternion must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = this.x * this.x;
        double _t3 = this.z * this.z;
        double _t4 = this.z * this.w;
        double _t5 = this.x * this.y;
        double _t6 = this.y * this.y;
        double _t10 = 2.0 * (this.x * this.w + this.y * this.z);
        double _t12 = 2.0 * (_t4 - _t5);
        double _t13 = 1.0 - 2.0 * (_t2 + _t3);
        double _t17 = _t13 * _t13 + _t12 * _t12;
        double _t19 = (_t17 + _t10 * _t10) * 1.0E-15;
        if (_t17 < _t19) {
            d.y = 0.0;
            d.z = Math.atan2(2.0 * (_t5 + _t4), 1.0 - 2.0 * (_t6 + _t3));
        } else {
            d.y = Math.atan2(2.0 * (this.y * this.w - this.x * this.z), 1.0 - 2.0 * (_t2 + _t6));
            d.z = Math.atan2(_t12, _t13);
        }
        d.x = Math.atan2(_t10, Math.sqrt(_t17));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
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
     * This quaternion must have unit length.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.y * this.y;
        double _t1 = this.z * this.z;
        double _t2 = this.x * this.y;
        double _t3 = this.z * this.w;
        double _t6 = this.x * this.x;
        double _t11 = 2.0 * (_t2 + _t3);
        double _t12 = 2.0 * (this.y * this.w - this.x * this.z);
        double _t13 = 1.0 - 2.0 * (_t0 + _t1);
        double _t17 = _t13 * _t13 + _t11 * _t11;
        double _t19 = (_t17 + _t12 * _t12) * 1.0E-15;
        if (_t17 < _t19) {
            d.x = 0.0;
            d.z = Math.atan2(2.0 * (_t3 - _t2), 1.0 - 2.0 * (_t6 + _t1));
        } else {
            d.x = Math.atan2(2.0 * (this.x * this.w + this.y * this.z), 1.0 - 2.0 * (_t6 + _t0));
            d.z = Math.atan2(_t11, _t13);
        }
        d.y = Math.atan2(_t12, Math.sqrt(_t17));
        return d;
    }


    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     *
     * @param angularVel the angular velocity, in radians per second, applied in the reference frame
     * @param dt the time step
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat integrate(Double3R angularVel, double dt, @Mutated DoubleQuat dest) {
        return integrate(angularVel.x(), angularVel.y(), angularVel.z(), dt, dest);
    }


    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     *
     * @param angularVelX the {@code x} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param angularVelY the {@code y} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param angularVelZ the {@code z} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param dt the time step
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat integrate(double angularVelX, double angularVelY, double angularVelZ, double dt, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * dt;
        double _t1 = angularVelX * _t0;
        double _t2 = angularVelY * _t0;
        double _t3 = angularVelZ * _t0;
        double _t8 = _t1 * _t1 + _t2 * _t2 + _t3 * _t3;
        double _t9 = Math.sqrt(_t8);
        double _t11 = Math.sin(_t9);
        double _t12 = Math.cosFromSin(_t11, _t9);
        double _t13 = _t11 / _t9;
        double _t17, _t18, _t19;
        if (_t8 > 0.0) {
            _t17 = _t1 * _t13;
            _t18 = _t2 * _t13;
            _t19 = _t3 * _t13;
        } else {
            _t17 = 0.0;
            _t18 = 0.0;
            _t19 = 0.0;
        }
        double _buf0 = this.x * _t12 + this.w * _t17 + (this.z * _t18 - this.y * _t19);
        double _buf1 = this.x * _t19 + this.w * _t18 + (this.y * _t12 - this.z * _t17);
        double _buf2 = this.y * _t17 + this.z * _t12 + (this.w * _t19 - this.x * _t18);
        d.w = this.w * _t12 - this.x * _t17 - (this.y * _t18 + this.z * _t19);
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected row of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y - this.z * this.w);
        double _t12 = 2.0 * (this.x * this.z + this.y * this.w);
        double _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = -(_t14 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t12 * _t20);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected row of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y + this.z * this.w);
        double _t12 = 2.0 * (this.y * this.z - this.x * this.w);
        double _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = -(_t11 * _t20);
            d.y = -(_t14 * _t20);
            d.z = -(_t12 * _t20);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected row of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.w + this.y * this.z);
        double _t12 = 2.0 * (this.x * this.z - this.y * this.w);
        double _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        double _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = -(_t12 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t14 * _t20);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (this.y * this.y + this.z * this.z) - 1.0;
        double _buf1 = -(2.0 * (this.x * this.y - this.z * this.w));
        d.z = -(2.0 * (this.x * this.z + this.y * this.w));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = -(2.0 * (this.x * this.y + this.z * this.w));
        double _buf1 = 2.0 * (this.x * this.x + this.z * this.z) - 1.0;
        d.z = -(2.0 * (this.y * this.z - this.x * this.w));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = -(2.0 * (this.x * this.z - this.y * this.w));
        double _buf1 = -(2.0 * (this.x * this.w + this.y * this.z));
        d.z = 2.0 * (this.x * this.x + this.y * this.y) - 1.0;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 1.0 - 2.0 * (this.y * this.y + this.z * this.z);
        double _buf1 = 2.0 * (this.x * this.y - this.z * this.w);
        d.z = 2.0 * (this.x * this.z + this.y * this.w);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (this.x * this.y + this.z * this.w);
        double _buf1 = 1.0 - 2.0 * (this.x * this.x + this.z * this.z);
        d.z = 2.0 * (this.y * this.z - this.x * this.w);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (this.x * this.z - this.y * this.w);
        double _buf1 = 2.0 * (this.x * this.w + this.y * this.z);
        d.z = 1.0 - 2.0 * (this.x * this.x + this.y * this.y);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected row of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y - this.z * this.w);
        double _t12 = 2.0 * (this.x * this.z + this.y * this.w);
        double _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = _t14 * _t20;
            d.y = _t11 * _t20;
            d.z = _t12 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected row of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y + this.z * this.w);
        double _t12 = 2.0 * (this.y * this.z - this.x * this.w);
        double _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = _t11 * _t20;
            d.y = _t14 * _t20;
            d.z = _t12 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected row of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.w + this.y * this.z);
        double _t12 = 2.0 * (this.x * this.z - this.y * this.w);
        double _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        double _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = _t12 * _t20;
            d.y = _t11 * _t20;
            d.z = _t14 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Compute the length of this quaternion.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this quaternion must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @return the length of this quaternion
     */
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }


    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    public double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }


    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code double}
     * resolution down to 0 - small rotations are not truncated.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat log(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t8 = Math.atan2(Math.sqrt(_t4), this.w) * (1.0 / Math.sqrt(_t4));
        if (_t4 > 0.0) {
            d.x = this.x * _t8;
            d.y = this.y * _t8;
            d.z = this.z * _t8;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        d.w = Math.log(Math.sqrt(_t4 + this.w * this.w));
        return d;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y + this.z * this.w);
        double _t12 = 2.0 * (this.x * this.z - this.y * this.w);
        double _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = -(_t14 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t12 * _t20);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y - this.z * this.w);
        double _t12 = 2.0 * (this.x * this.w + this.y * this.z);
        double _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = -(_t11 * _t20);
            d.y = -(_t14 * _t20);
            d.z = -(_t12 * _t20);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.z + this.y * this.w);
        double _t12 = 2.0 * (this.y * this.z - this.x * this.w);
        double _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        double _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = -(_t11 * _t20);
            d.y = -(_t12 * _t20);
            d.z = -(_t14 * _t20);
        } else {
            d.x = -0.0;
            d.y = -0.0;
            d.z = -0.0;
        }
        return d;
    }


    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this quaternion must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat normalize(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        double _t7 = (1.0 / Math.sqrt(_t6));
        if (_t6 != 0.0) {
            d.x = this.x * _t7;
            d.y = this.y * _t7;
            d.z = this.z * _t7;
            d.w = this.w * _t7;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (this.y * this.y + this.z * this.z) - 1.0;
        double _buf1 = -(2.0 * (this.x * this.y + this.z * this.w));
        d.z = -(2.0 * (this.x * this.z - this.y * this.w));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = -(2.0 * (this.x * this.y - this.z * this.w));
        double _buf1 = 2.0 * (this.x * this.x + this.z * this.z) - 1.0;
        d.z = -(2.0 * (this.x * this.w + this.y * this.z));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = -(2.0 * (this.x * this.z + this.y * this.w));
        double _buf1 = -(2.0 * (this.y * this.z - this.x * this.w));
        d.z = 2.0 * (this.x * this.x + this.y * this.y) - 1.0;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 1.0 - 2.0 * (this.y * this.y + this.z * this.z);
        double _buf1 = 2.0 * (this.x * this.y + this.z * this.w);
        d.z = 2.0 * (this.x * this.z - this.y * this.w);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (this.x * this.y - this.z * this.w);
        double _buf1 = 1.0 - 2.0 * (this.x * this.x + this.z * this.z);
        d.z = 2.0 * (this.x * this.w + this.y * this.z);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = 2.0 * (this.x * this.z + this.y * this.w);
        double _buf1 = 2.0 * (this.y * this.z - this.x * this.w);
        d.z = 1.0 - 2.0 * (this.x * this.x + this.y * this.y);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y + this.z * this.w);
        double _t12 = 2.0 * (this.x * this.z - this.y * this.w);
        double _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = _t14 * _t20;
            d.y = _t11 * _t20;
            d.z = _t12 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.y - this.z * this.w);
        double _t12 = 2.0 * (this.x * this.w + this.y * this.z);
        double _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        double _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = _t11 * _t20;
            d.y = _t14 * _t20;
            d.z = _t12 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1.5e-154} and {@code 1.3e154}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t11 = 2.0 * (this.x * this.z + this.y * this.w);
        double _t12 = 2.0 * (this.y * this.z - this.x * this.w);
        double _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        double _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 != 0.0) {
            d.x = _t11 * _t20;
            d.y = _t12 * _t20;
            d.z = _t14 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))} and
     * store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code double}
     * resolution down to 0 - small rotations are not truncated.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat pow(double t, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t13 = Math.exp(t * Math.log(Math.sqrt(_t5 + this.w * this.w)));
        double _t14 = Math.atan2(Math.sqrt(_t5), this.w) * (1.0 / Math.sqrt(_t5));
        double _t21, _t22, _t23;
        if (_t5 > 0.0) {
            _t21 = t * this.x * _t14;
            _t22 = t * this.y * _t14;
            _t23 = t * this.z * _t14;
        } else {
            _t21 = t * 0.0;
            _t22 = t * 0.0;
            _t23 = t * 0.0;
        }
        double _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        double _t29 = Math.sqrt(_t28);
        double _t31 = Math.sin(_t29);
        double _t33 = _t31 * _t13 / _t29;
        if (_t28 > 0.0) {
            d.x = _t21 * _t33;
            d.y = _t22 * _t33;
            d.z = _t23 * _t33;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        d.w = Math.cosFromSin(_t31, _t29) * _t13;
        return d;
    }


    /**
     * Pre-multiply {@code other} onto this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code R * Q}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code R * Q * v}, the transformation of the operand will be applied last.
     * <p>
     * Identical to {@link #preMul}; the lower-case spelling is kept for JOML 1 source
     * compatibility.
     *
     * @param other the left operand
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat premul(DoubleQuatR other, @Mutated DoubleQuat dest) {
        return preMul(other, dest);
    }


    /**
     * Pre-multiply ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) onto this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code R * Q}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code R * Q * v}, the transformation of the operand will be applied last.
     * <p>
     * Identical to {@link #preMul}; the lower-case spelling is kept for JOML 1 source
     * compatibility.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat premul(double otherX, double otherY, double otherZ, double otherW, @Mutated DoubleQuat dest) {
        return preMul(otherX, otherY, otherZ, otherW, dest);
    }


    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle and store
     * the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code double}
     * resolution down to 0 - small rotations are not truncated.
     * <p>
     * This quaternion must have unit length.
     *
     * @param target the target rotation
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTowards(DoubleQuatR target, double step, @Mutated DoubleQuat dest) {
        return rotateTowards(target.x(), target.y(), target.z(), target.w(), step, dest);
    }

    /** Private store group 0 of {@code rotateTowards}: computes and stores it; reached only through it. */
    private void rotateTowards_s2171c335_c0(DoubleQuatImpl _dst, double _t92, double _t93, double _t82, double _t83, double _t84, double _t85) {
        _dst.x = _t92 != 0.0 ? _t93 * _t82 : 0.0;
        _dst.y = _t92 != 0.0 ? _t93 * _t83 : 0.0;
        _dst.z = _t92 != 0.0 ? _t93 * _t84 : 0.0;
        _dst.w = _t92 != 0.0 ? _t93 * _t85 : 0.0;
    }

    /** Private tail of {@code rotateTowards}; reached only through it. */
    private void rotateTowards_s2171c335_tail(DoubleQuatImpl _dst, double _r3, double _t19, double _t20, double _t21, double _t22, double _t23, double _t24, double _t25, double _t26, double step, double _t14, double _t15, double _r0, double _t16, double _t15_inv, double _r1, double _t17, double _r2, double _t18) {
        double _t27 = _r3 + _t19;
        double _t45 = 4.0 * Math.atan2(Math.sqrt(_t20 * _t20 + _t21 * _t21 + _t22 * _t22 + _t23 * _t23), Math.sqrt(_t24 * _t24 + _t25 * _t25 + _t26 * _t26 + _t27 * _t27));
        double _t48 = _t45 > 0.0 ? Math.min(1.0, step / _t45) : 0.0;
        double _t49 = 1.0 - _t48;
        double _t55 = Math.sin(_t14 * _t48);
        double _t57 = Math.sin(_t49 * _t14);
        rotateTowards_s2171c335_tail2(_dst, _t15, _r0, _t57, _t55, _t16, _t15_inv, _t49, _t48, _r1, _t17, _r2, _t18, _r3, _t19);
    }

    /** Private tail of {@code rotateTowards}; reached only through it. */
    private void rotateTowards_s2171c335_tail2(DoubleQuatImpl _dst, double _t15, double _r0, double _t57, double _t55, double _t16, double _t15_inv, double _t49, double _t48, double _r1, double _t17, double _r2, double _t18, double _r3, double _t19) {
        double _t82, _t83, _t84, _t85;
        if (_t15 > 0.0) {
            _t82 = (_r0 * _t57 + _t55 * _t16) * _t15_inv;
            _t83 = (_r1 * _t57 + _t55 * _t17) * _t15_inv;
            _t84 = (_r2 * _t57 + _t55 * _t18) * _t15_inv;
            _t85 = (_r3 * _t57 + _t55 * _t19) * _t15_inv;
        } else {
            _t82 = _r0 * _t49 + _t16 * _t48;
            _t83 = _r1 * _t49 + _t17 * _t48;
            _t84 = _r2 * _t49 + _t18 * _t48;
            _t85 = _r3 * _t49 + _t19 * _t48;
        }
        double _t92 = _t82 * _t82 + _t83 * _t83 + _t84 * _t84 + _t85 * _t85;
        double _t93 = (1.0 / Math.sqrt(_t92));
        rotateTowards_s2171c335_c0(_dst, _t92, _t93, _t82, _t83, _t84, _t85);
    }


    /**
     * Rotate this quaternion towards ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}), by at most the given maximum angle and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code double}
     * resolution down to 0 - small rotations are not truncated.
     * <p>
     * This quaternion must have unit length.
     *
     * @param targetX the {@code x} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetY the {@code y} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetZ the {@code z} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param targetW the {@code w} component of the quaternion
     *        {@code (targetX, targetY, targetZ, targetW)}
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTowards(double targetX, double targetY, double targetZ, double targetW, double step, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.y;
        double _r2 = this.z;
        double _r3 = this.w;
        double _t10 = _r0 * targetX + _r1 * targetY + _r2 * targetZ + _r3 * targetW;
        double _t12 = -_t10;
        double _t14 = Math.acos(Math.min(1.0, Math.abs(_t10)));
        double _t15 = Math.sin(_t14);
        double _t15_inv = 1.0 / _t15;
        double _t16, _t17, _t18, _t19;
        if (_t12 > 0.0) {
            _t16 = -targetX;
            _t17 = -targetY;
            _t18 = -targetZ;
            _t19 = -targetW;
        } else {
            _t16 = targetX;
            _t17 = targetY;
            _t18 = targetZ;
            _t19 = targetW;
        }
        double _t20 = _r0 - _t16;
        double _t21 = _r1 - _t17;
        double _t22 = _r2 - _t18;
        double _t23 = _r3 - _t19;
        double _t24 = _r0 + _t16;
        double _t25 = _r1 + _t17;
        double _t26 = _r2 + _t18;
        rotateTowards_s2171c335_tail(d, _r3, _t19, _t20, _t21, _t22, _t23, _t24, _t25, _t26, step, _t14, _t15, _r0, _t16, _t15_inv, _r1, _t17, _r2, _t18);
        return d;
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dir the direction to look along, i.e. the direction the local {@code +z} axis is
     *        mapped to
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lookAlong(Double3R dir, Double3R up, @Mutated DoubleQuat dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }

    /** Private store group 0 of {@code lookAlong}: computes and stores it; reached only through it. */
    private void lookAlong_s384e4630_c0(DoubleQuatImpl _dst, double _r0, double _t105, double _r1, double _t106, double _r2, double _t107, double _r3, double _t108) {
        _dst.x = _r0 * _t105 + _r1 * _t106 + (_r2 * _t107 - _r3 * _t108);
        _dst.y = _r2 * _t105 + _r3 * _t106 + (_r1 * _t108 - _r0 * _t107);
        _dst.z = _r0 * _t108 + _r1 * _t107 + (_r3 * _t105 - _r2 * _t106);
        _dst.w = _r1 * _t105 - _r0 * _t106 - (_r2 * _t108 + _r3 * _t107);
    }

    /** Private tail of {@code lookAlong}; reached only through it. */
    private void lookAlong_s384e4630_tail(DoubleQuatImpl _dst, double _t7, double _t28, double _t6, double _t29, double _t43, double _t44, double _t27, double _t31, double _t32, double _t30, double _t35, double _t38, double _r0, double _r1, double _r2, double _r3) {
        double _t45 = _t7 * _t28 - _t6 * _t29;
        double _t48 = Math.max(_t43, _t6);
        double _t49 = _t44 - _t7;
        double _t50 = _t44 + _t7;
        double _t53 = _t29 - _t45;
        double _t54 = _t45 + _t29;
        double _t56 = _t43 + _t27 + _t6;
        double _t57 = _t31 + (_t27 + (_t6 + 1.0) - _t32);
        double _t58 = _t27 + (_t32 + (1.0 - _t6) - _t31);
        double _t59 = _t31 + (_t30 - _t6 - _t32);
        double _t60 = _t6 + (_t32 + _t30 - _t31);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t58));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t59));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t60));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t57));
        lookAlong_s384e4630_tail2(_dst, _t56, _t57, _t27, _t48, _sp0, _t49, _t43, _t6, _sp1, _t35, _sp2, _t53, _sp3, _t58, _t54, _t38, _t50, _t60, _t59, _r0, _r1, _r2, _r3);
    }

    /** Private tail of {@code lookAlong}; reached only through it. */
    private void lookAlong_s384e4630_tail2(DoubleQuatImpl _dst, double _t56, double _t57, double _t27, double _t48, double _sp0, double _t49, double _t43, double _t6, double _sp1, double _t35, double _sp2, double _t53, double _sp3, double _t58, double _t54, double _t38, double _t50, double _t60, double _t59, double _r0, double _r1, double _r2, double _r3) {
        double _t105, _t106, _t107, _t108;
        if (_t56 > 0.0) {
            _t105 = 0.5 * Math.sqrt(_t57);
            _t106 = _sp3 * _t49;
            _t107 = _sp3 * _t53;
            _t108 = _sp3 * _t35;
        } else {
            if (_t27 > _t48) {
                _t105 = _sp0 * _t49;
                _t106 = 0.5 * Math.sqrt(_t58);
                _t107 = _sp0 * _t38;
                _t108 = _sp0 * _t54;
            } else {
                if (_t43 > _t6) {
                    _t105 = _sp1 * _t35;
                    _t106 = _sp1 * _t54;
                    _t107 = _sp1 * _t50;
                    _t108 = 0.5 * Math.sqrt(_t59);
                } else {
                    _t105 = _sp2 * _t53;
                    _t106 = _sp2 * _t38;
                    _t107 = 0.5 * Math.sqrt(_t60);
                    _t108 = _sp2 * _t50;
                }
            }
        }
        lookAlong_s384e4630_c0(_dst, _r0, _t105, _r1, _t106, _r2, _t107, _r3, _t108);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t5 = (1.0 / Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ));
        double _t6 = dirZ * _t5;
        double _t7 = dirY * _t5;
        double _t8 = dirX * _t5;
        double _t17 = upY * _t6 - upZ * _t7;
        double _t18 = upZ * _t8 - upX * _t6;
        double _t19 = upX * _t7 - upY * _t8;
        double _ct0 = _t17 * _t17 + _t18 * _t18 + _t19 * _t19;
        if (!(_ct0 > 0.0)) return lookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ, dest);
        double _t26 = (1.0 / Math.sqrt(_ct0));
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
        double _t27 = _t17 * _t26;
        double _t28 = _t19 * _t26;
        double _t29 = _t18 * _t26;
        double _t30 = 1.0 - _t27;
        double _t31 = _t6 * _t27;
        double _t32 = _t8 * _t28;
        double _t35 = _t8 - _t28;
        double _t38 = _t8 + _t28;
        double _t43 = _t31 - _t32;
        double _t44 = _t8 * _t29 - _t7 * _t27;
        lookAlong_s384e4630_tail(d, _t7, _t28, _t6, _t29, _t43, _t44, _t27, _t31, _t32, _t30, _t35, _t38, _r0, _r1, _r2, _r3);
        return d;
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private DoubleQuat lookAlong_degenerate(Double3R dir, Double3R up, @Mutated DoubleQuat dest) {
        return lookAlong_degenerate(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
    }

    /** Private store group 0 of {@code lookAlong_degenerate}: computes and stores it; reached only through it. */
    private void lookAlong_degenerate_s384e4630_c0(DoubleQuatImpl _dst, double _r0, double _t129, double _r1, double _t130, double _r2, double _t127, double _r3, double _t128) {
        _dst.x = _r0 * _t129 + _r1 * _t130 + (_r2 * _t127 - _r3 * _t128);
        _dst.y = _r2 * _t129 + _r3 * _t130 + (_r1 * _t128 - _r0 * _t127);
        _dst.z = _r0 * _t128 + _r1 * _t127 + (_r3 * _t129 - _r2 * _t130);
        _dst.w = _r1 * _t129 - _r0 * _t130 - (_r2 * _t128 + _r3 * _t127);
    }

    /** Private tail of {@code lookAlong_degenerate}; reached only through it. */
    private void lookAlong_degenerate_s384e4630_tail(DoubleQuatImpl _dst, double _t15, double _t16, double _t14, double _t17, double _t9, double _t12, double _t10, double _t13, double _t11, double _t19, double _t20, double _r0, double _r1, double _r2, double _r3) {
        double _t27, _t28, _t32;
        if (_t15 > _t16) {
            _t27 = 0.0;
            _t28 = _t17;
            _t32 = _t12;
        } else {
            _t27 = _t14;
            _t28 = 0.0;
            _t32 = -_t13;
        }
        double _t29 = _t9 * _t12 - _t10 * _t13;
        double _t30 = _t11 * _t13 - _t9 * _t14;
        double _t31 = _t10 * _t14 - _t12 * _t11;
        double _t41 = _t29 * _t29 + _t30 * _t30 + _t31 * _t31;
        double _t47, _t48, _t49, _t50;
        if (_t41 == 0.0) {
            _t47 = (1.0 / Math.sqrt(_t28 * _t28 + _t32 * _t32 + _t27 * _t27));
            _t48 = _t47 * _t27;
            _t49 = _t47 * _t28;
            _t50 = _t47 * _t32;
        } else {
            _t47 = (1.0 / Math.sqrt(_t41));
            _t48 = _t47 * _t31;
            _t49 = _t47 * _t30;
            _t50 = _t47 * _t29;
        }
        double _t51 = _t48 * _t12;
        lookAlong_degenerate_s384e4630_tail2(_dst, _t12, _t48, _t49, _t13, _t14, _t50, _t51, _t17, _t19, _t20, _r0, _r1, _r2, _r3);
    }

    /** Private tail of {@code lookAlong_degenerate}; reached only through it. */
    private void lookAlong_degenerate_s384e4630_tail2(DoubleQuatImpl _dst, double _t12, double _t48, double _t49, double _t13, double _t14, double _t50, double _t51, double _t17, double _t19, double _t20, double _r0, double _r1, double _r2, double _r3) {
        double _t52 = _t12 - _t48;
        double _t54 = _t48 + _t12;
        double _t55 = _t49 * _t13;
        double _t57 = _t49 * _t14;
        double _t61 = _t50 * _t12;
        double _t67 = _t55 - _t51;
        double _t71 = _t48 * _t14 - _t50 * _t13;
        double _t72 = Math.max(_t67, _t13);
        double _t74 = _t61 + (_t14 - _t57);
        double _t75 = _t61 + (_t17 - _t57);
        double _t76 = _t55 + (_t49 + _t13 - _t51);
        double _t77 = _t55 + (_t49 + _t19 - _t51);
        double _t78 = _t49 + (_t51 + _t20 - _t55);
        double _t79 = _t55 + (_t20 - _t49 - _t51);
        double _t80 = _t51 + (_t19 - _t49) - _t55;
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t78));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t79));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t80));
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t77));
        double _t93 = _t50 - _t71;
        double _t94 = _t71 + _t50;
        lookAlong_degenerate_s384e4630_tail3(_dst, _t76, _sp0, _t93, _t49, _t72, _sp1, _t54, _t67, _t13, _sp2, _t74, _t80, _t52, _t94, _t79, _sp3, _t77, _t75, _t78, _r0, _r1, _r2, _r3);
    }

    /** Private tail of {@code lookAlong_degenerate}; reached only through it. */
    private void lookAlong_degenerate_s384e4630_tail3(DoubleQuatImpl _dst, double _t76, double _sp0, double _t93, double _t49, double _t72, double _sp1, double _t54, double _t67, double _t13, double _sp2, double _t74, double _t80, double _t52, double _t94, double _t79, double _sp3, double _t77, double _t75, double _t78, double _r0, double _r1, double _r2, double _r3) {
        double _t127, _t128, _t129, _t130;
        if (_t76 > 0.0) {
            _t127 = _sp0 * _t93;
            _t128 = _sp0 * _t52;
            _t129 = 0.5 * Math.sqrt(_t77);
            _t130 = _sp0 * _t75;
        } else {
            if (_t49 > _t72) {
                _t127 = _sp1 * _t54;
                _t128 = _sp1 * _t94;
                _t129 = _sp1 * _t75;
                _t130 = 0.5 * Math.sqrt(_t78);
            } else {
                if (_t67 > _t13) {
                    _t127 = _sp2 * _t74;
                    _t128 = 0.5 * Math.sqrt(_t79);
                    _t129 = _sp2 * _t52;
                    _t130 = _sp2 * _t94;
                } else {
                    _t127 = 0.5 * Math.sqrt(_t80);
                    _t128 = _sp3 * _t74;
                    _t129 = _sp3 * _t93;
                    _t130 = _sp3 * _t54;
                }
            }
        }
        lookAlong_degenerate_s384e4630_c0(_dst, _r0, _t129, _r1, _t130, _r2, _t127, _r3, _t128);
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private DoubleQuat lookAlong_degenerate(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
        double _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t9, _t10, _t11, _t12, _t13, _t14;
        if (_t4 == 0.0) {
            _t9 = 0.0;
            _t10 = 0.0;
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 1.0;
            _t14 = 0.0;
        } else {
            _t9 = upZ;
            _t10 = upX;
            _t11 = upY;
            _t12 = dirX * _t5;
            _t13 = dirZ * _t5;
            _t14 = dirY * _t5;
        }
        double _t15 = Math.abs(_t12);
        double _t16 = Math.abs(_t13);
        double _t17 = -_t14;
        double _t19 = 1.0 + _t13;
        double _t20 = 1.0 - _t13;
        lookAlong_degenerate_s384e4630_tail(d, _t15, _t16, _t14, _t17, _t9, _t12, _t10, _t13, _t11, _t19, _t20, _r0, _r1, _r2, _r3);
        return d;
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    @Mutated private DoubleQuat lookAlong_degenerate(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        return lookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ, Joml.RETURN_NEW ? Joml.doubleQuat() : this);
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated DoubleQuat makeRotationAxis(double angle, Double3R axis) {
        return makeRotationAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the axis ({@code axisX},
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
    @Mutated public DoubleQuat makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return makeRotationX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return makeRotationY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return makeRotationZ(axisZ * angle);
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.x = axisX * _t1;
        this.y = axisY * _t1;
        this.z = axisZ * _t1;
        this.w = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation that makes {@code +z} point along {@code dir}.
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dir the direction to look along, i.e. the direction the local {@code +z} axis is
     *        mapped to
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated DoubleQuat makeRotationLookAlong(Double3R dir, Double3R up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }

    /** Private store group 0 of {@code makeRotationLookAlong}: computes and stores it; reached only through it. */
    private void makeRotationLookAlong_s6a304d84_c0(DoubleQuatImpl _dst, double _t56, double _sp0, double _t48, double _t27, double _t49, double _t58, double _t43, double _t6, double _sp1, double _t53, double _sp2, double _t37, double _t38, double _sp3, double _t59, double _t50, double _t54, double _t60, double _t57) {
        _dst.x = _t56 > 0.0 ? _sp0 * _t48 : _t27 > _t49 ? 0.5 * Math.sqrt(_t58) : _t43 > _t6 ? _sp1 * _t53 : _sp2 * _t37;
        _dst.y = _t56 > 0.0 ? _sp0 * _t38 : _t27 > _t49 ? _sp3 * _t53 : _t43 > _t6 ? 0.5 * Math.sqrt(_t59) : _sp2 * _t50;
        _dst.z = _t56 > 0.0 ? _sp0 * _t54 : _t27 > _t49 ? _sp3 * _t37 : _t43 > _t6 ? _sp1 * _t50 : 0.5 * Math.sqrt(_t60);
        _dst.w = _t56 > 0.0 ? 0.5 * Math.sqrt(_t57) : _t27 > _t49 ? _sp3 * _t48 : _t43 > _t6 ? _sp1 * _t38 : _sp2 * _t54;
    }

    /** Private tail of {@code makeRotationLookAlong}; reached only through it. */
    private void makeRotationLookAlong_s6a304d84_tail(DoubleQuatImpl _dst, double _t43, double _t27, double _t6, double _t31, double _t32, double _t30, double _t48, double _t49, double _t53, double _t37, double _t38, double _t50, double _t54) {
        double _t56 = _t43 + _t27 + _t6;
        double _t57 = _t31 + (_t27 + (_t6 + 1.0) - _t32);
        double _t58 = _t27 + (_t32 + (1.0 - _t6) - _t31);
        double _t59 = _t31 + (_t30 - _t6 - _t32);
        double _t60 = _t6 + (_t32 + _t30 - _t31);
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t57));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t59));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t60));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t58));
        makeRotationLookAlong_s6a304d84_c0(_dst, _t56, _sp0, _t48, _t27, _t49, _t58, _t43, _t6, _sp1, _t53, _sp2, _t37, _t38, _sp3, _t59, _t50, _t54, _t60, _t57);
    }


    /**
     * Set this quaternion to a rotation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}).
     * <p>
     * Degenerate input still gives a proper rotation: an up vector parallel to the view direction
     * (or zero) is replaced by one perpendicular to it, and a zero view direction (coinciding
     * points) gives the identity orientation; NaN input gives NaN. (The raw-storage {@code *Ops}
     * kernels write zero rows for degenerate input instead.)
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return this
     */
    @Mutated public DoubleQuat makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        DoubleQuatImpl d = this;
        double _t5 = (1.0 / Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ));
        double _t6 = dirZ * _t5;
        double _t7 = dirY * _t5;
        double _t8 = dirX * _t5;
        double _t17 = upY * _t6 - upZ * _t7;
        double _t18 = upZ * _t8 - upX * _t6;
        double _t19 = upX * _t7 - upY * _t8;
        double _ct0 = _t17 * _t17 + _t18 * _t18 + _t19 * _t19;
        if (!(_ct0 > 0.0)) return makeRotationLookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ);
        double _t26 = (1.0 / Math.sqrt(_ct0));
        double _t27 = _t17 * _t26;
        double _t28 = _t19 * _t26;
        double _t29 = _t18 * _t26;
        double _t30 = 1.0 - _t27;
        double _t31 = _t6 * _t27;
        double _t32 = _t8 * _t28;
        double _t37 = _t8 + _t28;
        double _t38 = _t8 - _t28;
        double _t43 = _t31 - _t32;
        double _t44 = _t8 * _t29 - _t7 * _t27;
        double _t45 = _t7 * _t28 - _t6 * _t29;
        double _t48 = _t44 - _t7;
        double _t49 = Math.max(_t43, _t6);
        double _t50 = _t44 + _t7;
        double _t53 = _t45 + _t29;
        double _t54 = _t29 - _t45;
        makeRotationLookAlong_s6a304d84_tail(d, _t43, _t27, _t6, _t31, _t32, _t30, _t48, _t49, _t53, _t37, _t38, _t50, _t54);
        return d;
    }


    /**
     * Degenerate-input path of {@code makeRotationLookAlong}: its methods leave here when their
     * input spans no proper basis (a zero direction, an up vector parallel to it or zero, NaN);
     * reached only through them.
     */
    private @Mutated DoubleQuat makeRotationLookAlong_degenerate(Double3R dir, Double3R up) {
        return makeRotationLookAlong_degenerate(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }

    /** Private store group 0 of {@code makeRotationLookAlong_degenerate}: computes and stores it; reached only through it. */
    private void makeRotationLookAlong_degenerate_s6a304d84_c0(DoubleQuatImpl _dst, double _t76, double _sp0, double _t75, double _t49, double _t72, double _t78, double _t67, double _t13, double _sp1, double _t85, double _sp2, double _t53, double _t54, double _sp3, double _t79, double _t74, double _t86, double _t80, double _t77) {
        _dst.x = _t76 > 0.0 ? _sp0 * _t75 : _t49 > _t72 ? 0.5 * Math.sqrt(_t78) : _t67 > _t13 ? _sp1 * _t85 : _sp2 * _t53;
        _dst.y = _t76 > 0.0 ? _sp0 * _t54 : _t49 > _t72 ? _sp3 * _t85 : _t67 > _t13 ? 0.5 * Math.sqrt(_t79) : _sp2 * _t74;
        _dst.z = _t76 > 0.0 ? _sp0 * _t86 : _t49 > _t72 ? _sp3 * _t53 : _t67 > _t13 ? _sp1 * _t74 : 0.5 * Math.sqrt(_t80);
        _dst.w = _t76 > 0.0 ? 0.5 * Math.sqrt(_t77) : _t49 > _t72 ? _sp3 * _t75 : _t67 > _t13 ? _sp1 * _t54 : _sp2 * _t86;
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate}; reached only through it. */
    private void makeRotationLookAlong_degenerate_s6a304d84_tail(DoubleQuatImpl _dst, double _t10, double _t14, double _t12, double _t11, double _t15, double _t16, double _t13, double _t29, double _t30, double _t28, double _t27, double _t17, double _t19, double _t20) {
        double _t31 = _t10 * _t14 - _t12 * _t11;
        double _t32 = _t15 > _t16 ? _t12 : -_t13;
        double _t41 = _t29 * _t29 + _t30 * _t30 + _t31 * _t31;
        double _t47, _t48, _t49, _t50;
        if (_t41 == 0.0) {
            _t47 = (1.0 / Math.sqrt(_t28 * _t28 + _t32 * _t32 + _t27 * _t27));
            _t48 = _t47 * _t27;
            _t49 = _t47 * _t28;
            _t50 = _t47 * _t32;
        } else {
            _t47 = (1.0 / Math.sqrt(_t41));
            _t48 = _t47 * _t31;
            _t49 = _t47 * _t30;
            _t50 = _t47 * _t29;
        }
        double _t51 = _t48 * _t12;
        double _t53 = _t48 + _t12;
        double _t54 = _t12 - _t48;
        double _t55 = _t49 * _t13;
        double _t57 = _t49 * _t14;
        double _t61 = _t50 * _t12;
        double _t67 = _t55 - _t51;
        double _t71 = _t48 * _t14 - _t50 * _t13;
        double _t72 = Math.max(_t67, _t13);
        makeRotationLookAlong_degenerate_s6a304d84_tail2(_dst, _t61, _t14, _t57, _t17, _t55, _t49, _t13, _t51, _t19, _t20, _t71, _t50, _t72, _t67, _t53, _t54);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate}; reached only through it. */
    private void makeRotationLookAlong_degenerate_s6a304d84_tail2(DoubleQuatImpl _dst, double _t61, double _t14, double _t57, double _t17, double _t55, double _t49, double _t13, double _t51, double _t19, double _t20, double _t71, double _t50, double _t72, double _t67, double _t53, double _t54) {
        double _t74 = _t61 + (_t14 - _t57);
        double _t75 = _t61 + (_t17 - _t57);
        double _t76 = _t55 + (_t49 + _t13 - _t51);
        double _t77 = _t55 + (_t49 + _t19 - _t51);
        double _t78 = _t49 + (_t51 + _t20 - _t55);
        double _t79 = _t55 + (_t20 - _t49 - _t51);
        double _t80 = _t51 + (_t19 - _t49) - _t55;
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t77));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t79));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t80));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t78));
        double _t85 = _t71 + _t50;
        double _t86 = _t50 - _t71;
        makeRotationLookAlong_degenerate_s6a304d84_c0(_dst, _t76, _sp0, _t75, _t49, _t72, _t78, _t67, _t13, _sp1, _t85, _sp2, _t53, _t54, _sp3, _t79, _t74, _t86, _t80, _t77);
    }


    /**
     * Degenerate-input path of {@code makeRotationLookAlong}: its methods leave here when their
     * input spans no proper basis (a zero direction, an up vector parallel to it or zero, NaN);
     * reached only through them.
     */
    @Mutated private DoubleQuat makeRotationLookAlong_degenerate(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        DoubleQuatImpl d = this;
        double _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t9, _t10, _t11, _t12, _t13, _t14;
        if (_t4 == 0.0) {
            _t9 = 0.0;
            _t10 = 0.0;
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 1.0;
            _t14 = 0.0;
        } else {
            _t9 = upZ;
            _t10 = upX;
            _t11 = upY;
            _t12 = dirX * _t5;
            _t13 = dirZ * _t5;
            _t14 = dirY * _t5;
        }
        double _t15 = Math.abs(_t12);
        double _t16 = Math.abs(_t13);
        double _t17 = -_t14;
        double _t19 = 1.0 + _t13;
        double _t20 = 1.0 - _t13;
        double _t27, _t28;
        if (_t15 > _t16) {
            _t27 = 0.0;
            _t28 = _t17;
        } else {
            _t27 = _t14;
            _t28 = 0.0;
        }
        double _t29 = _t9 * _t12 - _t10 * _t13;
        double _t30 = _t11 * _t13 - _t9 * _t14;
        makeRotationLookAlong_degenerate_s6a304d84_tail(d, _t10, _t14, _t12, _t11, _t15, _t16, _t13, _t29, _t30, _t28, _t27, _t17, _t19, _t20);
        return d;
    }


    /**
     * Set this quaternion to the rotation that rotates {@code fromDir} onto {@code toDir} (both
     * must be unit vectors; for opposite vectors an arbitrary perpendicular rotation axis is
     * chosen).
     * <p>
     * The half-vector form stays accurate for nearly antiparallel inputs down to the 180-degree
     * fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than {@code 1e-13}
     * (about 4.5e-7 radians from opposite); only there is the perpendicular axis chosen
     * arbitrarily, and the result is then off by at most that angle. The threshold also covers
     * directions normalized only to {@code float} precision.
     *
     * @param fromDir the direction to rotate from (must be a unit vector)
     * @param toDir the direction to rotate onto (must be a unit vector)
     * @return this
     */
    public @Mutated DoubleQuat makeRotationTo(Double3R fromDir, Double3R toDir) {
        return makeRotationTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
    }

    /** Private store group 0 of {@code makeRotationTo}: computes and stores it; reached only through it. */
    private void makeRotationTo_s6ca4b61d_c0(DoubleQuatImpl _dst, double _t30, double _t16, double _t40, double _t37, double _t38, double _t20, double _t17, double _t22, double _t18, double _t21) {
        _dst.x = _t30 > 1.0E-13 ? _t16 * _t40 : _t37 != 0.0 ? _t38 * _t20 : 0.0;
        _dst.y = _t30 > 1.0E-13 ? _t17 * _t40 : _t37 != 0.0 ? _t38 * _t22 : 0.0;
        _dst.z = _t30 > 1.0E-13 ? _t18 * _t40 : _t37 != 0.0 ? _t38 * _t21 : 0.0;
        _dst.w = _t30 > 1.0E-13 ? _t30 * _t40 : 0.0;
    }


    /**
     * Set this quaternion to the rotation that rotates ({@code fromDirX}, {@code fromDirY},
     * {@code fromDirZ}) onto ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen).
     * <p>
     * The half-vector form stays accurate for nearly antiparallel inputs down to the 180-degree
     * fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than {@code 1e-13}
     * (about 4.5e-7 radians from opposite); only there is the perpendicular axis chosen
     * arbitrarily, and the result is then off by at most that angle. The threshold also covers
     * directions normalized only to {@code float} precision.
     *
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @return this
     */
    @Mutated public DoubleQuat makeRotationTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        DoubleQuatImpl d = this;
        double _t2 = fromDirX + toDirX;
        double _t3 = fromDirY + toDirY;
        double _t4 = fromDirZ + toDirZ;
        double _t16 = fromDirY * toDirZ - fromDirZ * toDirY;
        double _t17 = fromDirZ * toDirX - fromDirX * toDirZ;
        double _t18 = fromDirX * toDirY - fromDirY * toDirX;
        double _t19 = fromDirX * fromDirX + fromDirY * fromDirY;
        double _t20, _t21, _t22;
        if (_t19 > 0.0) {
            _t20 = fromDirY;
            _t21 = 0.0;
            _t22 = -fromDirX;
        } else {
            _t20 = 0.0;
            _t21 = -fromDirY;
            _t22 = fromDirZ;
        }
        double _t28 = _t2 * _t2 + _t3 * _t3 + _t4 * _t4;
        double _t30 = 0.5 * _t28;
        double _t37 = _t20 * _t20 + _t22 * _t22 + _t21 * _t21;
        double _t38 = (1.0 / Math.sqrt(_t37));
        double _t40 = (1.0 / Math.sqrt(_t16 * _t16 + _t17 * _t17 + _t18 * _t18 + 0.25 * _t28 * _t28));
        makeRotationTo_s6ca4b61d_c0(d, _t30, _t16, _t40, _t37, _t38, _t20, _t17, _t22, _t18, _t21);
        return d;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleQuat makeRotationX(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.x = _t1;
        this.y = 0.0;
        this.z = 0.0;
        this.w = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so
     * a vector is rotated about the Z axis first, then Y, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationXYZ(double angleX, double angleY, double angleZ) {
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
        this.x = _t10 * _t7 + _t11 * _t5;
        this.y = _t11 * _t7 - _t10 * _t5;
        this.z = _t9 * _t7 + _t12 * _t5;
        this.w = _t12 * _t7 - _t9 * _t5;
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so
     * a vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationXZY(double angleX, double angleZ, double angleY) {
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
        this.x = _t10 * _t7 - _t11 * _t5;
        this.y = _t12 * _t5 - _t9 * _t7;
        this.z = _t10 * _t5 + _t11 * _t7;
        this.w = _t9 * _t5 + _t12 * _t7;
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleQuat makeRotationY(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.x = 0.0;
        this.y = _t1;
        this.z = 0.0;
        this.w = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so
     * a vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationYXZ(double angleY, double angleX, double angleZ) {
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
        this.x = _t10 * _t7 + _t11 * _t5;
        this.y = _t11 * _t7 - _t10 * _t5;
        this.z = _t12 * _t5 - _t9 * _t7;
        this.w = _t9 * _t5 + _t12 * _t7;
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so
     * a vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationYZX(double angleY, double angleZ, double angleX) {
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
        this.x = _t9 * _t6 + _t12 * _t5;
        this.y = _t10 * _t6 + _t11 * _t5;
        this.z = _t11 * _t6 - _t10 * _t5;
        this.w = _t12 * _t6 - _t9 * _t5;
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleQuat makeRotationZ(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.x = 0.0;
        this.y = 0.0;
        this.z = _t1;
        this.w = Math.cosFromSin(_t1, _t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so
     * a vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationZXY(double angleZ, double angleX, double angleY) {
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
        this.x = _t10 * _t7 - _t11 * _t5;
        this.y = _t9 * _t7 + _t12 * _t5;
        this.z = _t10 * _t5 + _t11 * _t7;
        this.w = _t12 * _t7 - _t9 * _t5;
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so
     * a vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationZYX(double angleZ, double angleY, double angleX) {
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
        this.x = _t12 * _t5 - _t9 * _t8;
        this.y = _t10 * _t8 + _t11 * _t5;
        this.z = _t11 * _t8 - _t10 * _t5;
        this.w = _t9 * _t5 + _t12 * _t8;
        return this;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateX(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t2 + this.w * _t1;
        double _buf1 = this.y * _t2 - this.z * _t1;
        d.z = this.y * _t1 + this.z * _t2;
        d.w = this.w * _t2 - this.x * _t1;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateY(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t2 + this.z * _t1;
        double _buf1 = this.y * _t2 + this.w * _t1;
        d.z = this.z * _t2 - this.x * _t1;
        d.w = this.w * _t2 - this.y * _t1;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateZ(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t2 - this.y * _t1;
        d.y = this.x * _t1 + this.y * _t2;
        double _buf1 = this.z * _t2 + this.w * _t1;
        d.w = this.w * _t2 - this.z * _t1;
        d.x = _buf0;
        d.z = _buf1;
        return d;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateAxis(double angle, Double3R axis, @Mutated DoubleQuat dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
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
    public DoubleQuat rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated DoubleQuat dest) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle, dest);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle, dest);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle, dest);
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = axisX * _t1;
        double _t3 = axisZ * _t1;
        double _t4 = axisY * _t1;
        double _t5 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t5 + this.w * _t2 + (this.y * _t3 - this.z * _t4);
        double _buf1 = this.y * _t5 + this.z * _t2 + (this.w * _t4 - this.x * _t3);
        double _buf2 = this.x * _t4 + this.w * _t3 + (this.z * _t5 - this.y * _t2);
        d.w = this.w * _t5 - this.x * _t2 - (this.y * _t4 + this.z * _t3);
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Apply the rotation that rotates {@code fromDir} onto {@code toDir} (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen) to this
     * quaternion and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The half-vector form stays accurate for nearly antiparallel inputs down to the 180-degree
     * fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than {@code 1e-13}
     * (about 4.5e-7 radians from opposite); only there is the perpendicular axis chosen
     * arbitrarily, and the result is then off by at most that angle. The threshold also covers
     * directions normalized only to {@code float} precision.
     *
     * @param fromDir the direction to rotate from (must be a unit vector)
     * @param toDir the direction to rotate onto (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTo(Double3R fromDir, Double3R toDir, @Mutated DoubleQuat dest) {
        return rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z(), dest);
    }

    /** Private store group 0 of {@code rotateTo}: computes and stores it; reached only through it. */
    private void rotateTo_s203b189_c0(DoubleQuatImpl _dst, double _r0, double _t49, double _r1, double _t53, double _r2, double _t54, double _r3, double _t55) {
        _dst.x = _r0 * _t49 + _r1 * _t53 + (_r2 * _t54 - _r3 * _t55);
        _dst.y = _r2 * _t49 + _r3 * _t53 + (_r1 * _t55 - _r0 * _t54);
        _dst.z = _r0 * _t55 + _r1 * _t54 + (_r3 * _t49 - _r2 * _t53);
        _dst.w = _r1 * _t49 - _r0 * _t53 - (_r2 * _t55 + _r3 * _t54);
    }

    /** Private tail of {@code rotateTo}; reached only through it. */
    private void rotateTo_s203b189_tail(DoubleQuatImpl _dst, double _t16, double _t17, double _t18, double _t28, double _t30, double _t37, double _t38, double _t20, double _t21, double _t22, double _r0, double _r1, double _r2, double _r3) {
        double _t43 = (1.0 / Math.sqrt(_t16 * _t16 + _t17 * _t17 + _t18 * _t18 + 0.25 * _t28 * _t28));
        double _t49, _t53, _t54, _t55;
        if (_t30 > 1.0E-13) {
            _t49 = _t30 * _t43;
            _t53 = _t16 * _t43;
            _t54 = _t18 * _t43;
            _t55 = _t17 * _t43;
        } else {
            if (_t37 != 0.0) {
                _t49 = 0.0;
                _t53 = _t38 * _t20;
                _t54 = _t38 * _t21;
                _t55 = _t38 * _t22;
            } else {
                _t49 = 0.0;
                _t53 = 0.0;
                _t54 = 0.0;
                _t55 = 0.0;
            }
        }
        rotateTo_s203b189_c0(_dst, _r0, _t49, _r1, _t53, _r2, _t54, _r3, _t55);
    }


    /**
     * Apply the rotation that rotates ({@code fromDirX}, {@code fromDirY}, {@code fromDirZ}) onto
     * ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit vectors; for opposite
     * vectors an arbitrary perpendicular rotation axis is chosen) to this quaternion and store the
     * result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The half-vector form stays accurate for nearly antiparallel inputs down to the 180-degree
     * fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than {@code 1e-13}
     * (about 4.5e-7 radians from opposite); only there is the perpendicular axis chosen
     * arbitrarily, and the result is then off by at most that angle. The threshold also covers
     * directions normalized only to {@code float} precision.
     *
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
        double _t2 = fromDirX + toDirX;
        double _t3 = fromDirY + toDirY;
        double _t4 = fromDirZ + toDirZ;
        double _t16 = fromDirY * toDirZ - fromDirZ * toDirY;
        double _t17 = fromDirZ * toDirX - fromDirX * toDirZ;
        double _t18 = fromDirX * toDirY - fromDirY * toDirX;
        double _t19 = fromDirX * fromDirX + fromDirY * fromDirY;
        double _t20, _t21, _t22;
        if (_t19 > 0.0) {
            _t20 = fromDirY;
            _t21 = 0.0;
            _t22 = -fromDirX;
        } else {
            _t20 = 0.0;
            _t21 = -fromDirY;
            _t22 = fromDirZ;
        }
        double _t28 = _t2 * _t2 + _t3 * _t3 + _t4 * _t4;
        double _t30 = 0.5 * _t28;
        double _t37 = _t20 * _t20 + _t22 * _t22 + _t21 * _t21;
        double _t38 = (1.0 / Math.sqrt(_t37));
        rotateTo_s203b189_tail(d, _t16, _t17, _t18, _t28, _t30, _t37, _t38, _t20, _t21, _t22, _r0, _r1, _r2, _r3);
        return d;
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local X axis and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateX(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t2 + this.w * _t1;
        double _buf1 = this.y * _t2 + this.z * _t1;
        d.z = this.z * _t2 - this.y * _t1;
        d.w = this.w * _t2 - this.x * _t1;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }

    /** Private store group 0 of {@code rotateXYZ}: computes and stores it; reached only through it. */
    private void rotateXYZ_s2a22d61_c0(DoubleQuatImpl _dst, double _r0, double _t21, double _r1, double _t22, double _r2, double _t23, double _r3, double _t24) {
        _dst.x = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.y = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.z = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.w = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order (the matrix product {@code Rx * Ry * Rz}, so a vector is rotated
     * about the Z axis first, then Y, then X), to this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateXYZ(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
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
        double _t24 = _t11 * _t8 - _t10 * _t5;
        rotateXYZ_s2a22d61_c0(d, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        return d;
    }

    /** Private store group 0 of {@code rotateXZY}: computes and stores it; reached only through it. */
    private void rotateXZY_s50b651bf_c0(DoubleQuatImpl _dst, double _r0, double _t21, double _r1, double _t22, double _r2, double _t23, double _r3, double _t24) {
        _dst.x = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.y = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.z = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.w = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so a vector is rotated
     * about the Y axis first, then Z, then X), to this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateXZY(double angleX, double angleZ, double angleY, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
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
        double _t24 = _t13 * _t5 - _t9 * _t8;
        rotateXZY_s50b651bf_c0(d, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        return d;
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Y axis and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateY(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t2 - this.z * _t1;
        double _buf1 = this.y * _t2 + this.w * _t1;
        d.z = this.x * _t1 + this.z * _t2;
        d.w = this.w * _t2 - this.y * _t1;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }

    /** Private store group 0 of {@code rotateYXZ}: computes and stores it; reached only through it. */
    private void rotateYXZ_s20d10143_c0(DoubleQuatImpl _dst, double _r0, double _t21, double _r1, double _t22, double _r2, double _t23, double _r3, double _t24) {
        _dst.x = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.y = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.z = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.w = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so a vector is rotated
     * about the Z axis first, then X, then Y), to this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateYXZ(double angleY, double angleX, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
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
        double _t24 = _t11 * _t8 - _t10 * _t5;
        rotateYXZ_s20d10143_c0(d, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        return d;
    }

    /** Private store group 0 of {@code rotateYZX}: computes and stores it; reached only through it. */
    private void rotateYZX_s3cf949ff_c0(DoubleQuatImpl _dst, double _r0, double _t21, double _r1, double _t22, double _r2, double _t23, double _r3, double _t24) {
        _dst.x = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.y = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.z = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.w = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so a vector is rotated
     * about the X axis first, then Z, then Y), to this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateYZX(double angleY, double angleZ, double angleX, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
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
        double _t24 = _t11 * _t8 + _t10 * _t5;
        rotateYZX_s3cf949ff_c0(d, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        return d;
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Z axis and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateZ(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = this.x * _t2 + this.y * _t1;
        d.y = this.y * _t2 - this.x * _t1;
        double _buf1 = this.z * _t2 + this.w * _t1;
        d.w = this.w * _t2 - this.z * _t1;
        d.x = _buf0;
        d.z = _buf1;
        return d;
    }

    /** Private store group 0 of {@code rotateZXY}: computes and stores it; reached only through it. */
    private void rotateZXY_sd13f983_c0(DoubleQuatImpl _dst, double _r0, double _t21, double _r1, double _t22, double _r2, double _t23, double _r3, double _t24) {
        _dst.x = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.y = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.z = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.w = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so a vector is rotated
     * about the Y axis first, then X, then Z), to this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateZXY(double angleZ, double angleX, double angleY, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
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
        double _t24 = _t9 * _t8 + _t13 * _t5;
        rotateZXY_sd13f983_c0(d, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        return d;
    }

    /** Private store group 0 of {@code rotateZYX}: computes and stores it; reached only through it. */
    private void rotateZYX_s5b281de1_c0(DoubleQuatImpl _dst, double _r0, double _t21, double _r1, double _t22, double _r2, double _t23, double _r3, double _t24) {
        _dst.x = _r0 * _t21 + _r1 * _t22 + (_r2 * _t23 - _r3 * _t24);
        _dst.y = _r2 * _t21 + _r3 * _t22 + (_r1 * _t24 - _r0 * _t23);
        _dst.z = _r0 * _t24 + _r1 * _t23 + (_r3 * _t21 - _r2 * _t22);
        _dst.w = _r1 * _t21 - _r0 * _t22 - (_r2 * _t24 + _r3 * _t23);
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so a vector is rotated
     * about the X axis first, then Y, then Z), to this quaternion and store the result in
     * {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleX the angle in radians to rotate about the X axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateZYX(double angleZ, double angleY, double angleX, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _r0 = this.x;
        double _r1 = this.w;
        double _r2 = this.y;
        double _r3 = this.z;
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
        double _t24 = _t11 * _t8 + _t10 * _t5;
        rotateZYX_s5b281de1_c0(d, _r0, _t21, _r1, _t22, _r2, _t23, _r3, _t24);
        return d;
    }


    /**
     * Transform {@code v} by this quaternion and store the result in {@code dest}.
     * <p>
     * This quaternion must have unit length.
     *
     * @param v the vector to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Double3R v, @Mutated Double3 dest) {
        return transform(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this quaternion and store the result in
     * {@code dest}.
     * <p>
     * This quaternion must have unit length.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (this.x * vY - this.y * vX);
        double _t10 = 2.0 * (this.y * vZ - this.z * vY);
        double _t11 = 2.0 * (this.z * vX - this.x * vZ);
        double _buf0 = this.y * _t9 + (this.w * _t10 + vX - this.z * _t11);
        double _buf1 = this.z * _t10 + (this.w * _t11 + vY - this.x * _t9);
        d.z = this.x * _t11 + (this.w * _t9 + vZ - this.y * _t10);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion) and store
     * the result in {@code dest}.
     *
     * @param v the vector to transform
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(Double3R v, @Mutated Double3 dest) {
        return transformInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by the inverse of this quaternion (assumes a
     * unit quaternion) and store the result in {@code dest}.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(double vX, double vY, double vZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (this.x * vZ - this.z * vX);
        double _t10 = 2.0 * (this.z * vY - this.y * vZ);
        double _t11 = 2.0 * (this.y * vX - this.x * vY);
        double _buf0 = this.z * _t9 + (this.w * _t10 + vX - this.y * _t11);
        double _buf1 = this.x * _t11 + (this.w * _t9 + vY - this.z * _t10);
        d.z = this.y * _t10 + (this.w * _t11 + vZ - this.x * _t9);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }

    public double x() { return this.x; }
    public double y() { return this.y; }
    public double z() { return this.z; }
    public double w() { return this.w; }

    @Override public String toString() {
        return "DoubleQuat(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleQuatImpl)) return false;
        DoubleQuatImpl o = (DoubleQuatImpl) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(o.x)
            && Double.doubleToLongBits(y) == Double.doubleToLongBits(o.y)
            && Double.doubleToLongBits(z) == Double.doubleToLongBits(o.z)
            && Double.doubleToLongBits(w) == Double.doubleToLongBits(o.w);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(w) ^ (Double.doubleToLongBits(w) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(x)
            && Double.isFinite(y)
            && Double.isFinite(z)
            && Double.isFinite(w);
    }

    @Override public boolean equalsEpsilon(DoubleQuatR other, double epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(w - other.w()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.w;
        return dest;
    }
    public @Mutated DoubleQuat load(double[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.w = src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleQuat load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.x;
        dest[offset + 1] = (float) this.y;
        dest[offset + 2] = (float) this.z;
        dest[offset + 3] = (float) this.w;
        return dest;
    }
    public @Mutated DoubleQuat load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.w = src[offset + 3];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleQuat loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleQuat storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleQuat loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleQuat loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

    /**
     * The angle between two unit quaternions a and b from s = |a+b|^2, clamped to [0, 4]:
     * 2 asin(|a-b|/2) up to pi/2 and pi - 2 asin(|a+b|/2) beyond, so asin always sees an
     * argument of at most sqrt(2)/2 and the angle stays accurate at both ends.
     */
    private static float quatArcAngle(float s) {
        float d = 4.0f - s;
        return s > d ? 2.0f * (float) Math.asin(0.5f * (float) Math.sqrt(d))
                : (float) Math.PI - 2.0f * (float) Math.asin(0.5f * (float) Math.sqrt(s));
    }

    /** Double-precision twin of {@link #quatArcAngle(float)}. */
    private static double quatArcAngle(double s) {
        double d = 4.0 - s;
        return s > d ? 2.0 * Math.asin(0.5 * Math.sqrt(d)) : Math.PI - 2.0 * Math.asin(0.5 * Math.sqrt(s));
    }
}
