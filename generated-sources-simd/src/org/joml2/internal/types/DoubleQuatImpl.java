// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import jdk.incubator.vector.*;
import org.joml2.internal.simd.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link DoubleQuat} backed by a {@code double[]} array, with Vector
 * API SIMD kernels where profitable.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleQuatImpl implements DoubleQuat {

    public double[] data;
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
        data = new double[4];
        data[3] = 1;
    }

    public DoubleQuatImpl(double x, double y, double z, double w) {
        double[] dd = this.data = new double[4];
        dd[0] = x;
        dd[1] = y;
        dd[2] = z;
        dd[3] = w;
    }

    public DoubleQuatImpl(DoubleQuatR src) {
        double[] dd = this.data = new double[4];
        dd[0] = src.x();
        dd[1] = src.y();
        dd[2] = src.z();
        dd[3] = src.w();
    }


    /**
     * Invert this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invert(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t3_inv = 1.0 / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = _sv0.mul(DoubleVector.broadcast(COL_SPECIES, _t3_inv)).blend(_sv0.mul(DoubleVector.broadcast(COL_SPECIES, -_t3_inv)), MASK_0);
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t20 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[2], sd[1], -(otherData[1] * sd[2]));
        double _t21 = Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0])) - Math.fma(otherData[1], sd[1], otherData[2] * sd[2]);
        double _t22 = Math.fma(otherData[1], sd[0], otherData[2] * sd[3]) + Math.fma(otherData[3], sd[2], -(otherData[0] * sd[1]));
        double _t23 = Math.fma(otherData[0], sd[2], otherData[3] * sd[1]) + Math.fma(otherData[1], sd[3], -(otherData[2] * sd[0]));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t20 * _t20)));
        double _t27_inv = 1.0 / _t27;
        dd[0] = -(_t20 * _t27_inv);
        dd[1] = -(_t23 * _t27_inv);
        dd[2] = -(_t22 * _t27_inv);
        dd[3] = _t21 * _t27_inv;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t20 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        double _t21 = Math.fma(otherW, sd[3], -(otherX * sd[0])) - Math.fma(otherY, sd[1], otherZ * sd[2]);
        double _t22 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
        double _t23 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t20 * _t20)));
        double _t27_inv = 1.0 / _t27;
        dd[0] = -(_t20 * _t27_inv);
        dd[1] = -(_t23 * _t27_inv);
        dd[2] = -(_t22 * _t27_inv);
        dd[3] = _t21 * _t27_inv;
        return dest;
    }


    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param other the quaternion to add
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat add(DoubleQuatR other, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _col0 = DoubleVector.fromArray(COL_SPECIES, otherData, 0).add(DoubleVector.fromArray(COL_SPECIES, sd, 0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = otherX + sd[0];
        dd[1] = otherY + sd[1];
        dd[2] = otherZ + sd[2];
        dd[3] = otherW + sd[3];
        return dest;
    }


    /**
     * Negate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat negate(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).neg();
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     *
     * @param other the quaternion to subtract
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat sub(DoubleQuatR other, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).sub(DoubleVector.fromArray(COL_SPECIES, otherData, 0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = sd[0] - otherX;
        dd[1] = sd[1] - otherY;
        dd[2] = sd[2] - otherZ;
        dd[3] = sd[3] - otherW;
        return dest;
    }


    /**
     * Set this quaternion to the given values.
     *
     * @param v the quaternion to copy
     * @return this
     */
    @Mutated public DoubleQuat set(DoubleQuatR v) {
        double[] dd = this.data;
        double[] vData = ((DoubleQuatImpl) v).data;
        var _col0 = DoubleVector.fromArray(COL_SPECIES, vData, 0);
        _col0.intoArray(dd, 0);
        return this;
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
        double[] dd = this.data;
        dd[0] = vX;
        dd[1] = vY;
        dd[2] = vZ;
        dd[3] = vW;
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
        double[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        dd[0] = (float) (sd[0]);
        dd[1] = (float) (sd[1]);
        dd[2] = (float) (sd[2]);
        dd[3] = (float) (sd[3]);
        return dest;
    }


    /**
     * Set this quaternion to the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion to convert
     * @return this
     */
    @Mutated public DoubleQuat makeFromDualQuat(DoubleDualQuatR dq) {
        double[] dd = this.data;
        double[] dqData = ((DoubleDualQuatImpl) dq).data;
        DoubleVector.fromArray(COL_SPECIES, dqData, 0).intoArray(dd, 0);
        return this;
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
        double[] dd = this.data;
        dd[0] = dqRX;
        dd[1] = dqRY;
        dd[2] = dqRZ;
        dd[3] = dqRW;
        return this;
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
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private DoubleQuat makeFromMatrix_fma(Double3x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x3Impl) m).data;
        double _r0 = mData[0];
        double _r1 = mData[4];
        double _r2 = mData[5];
        double _r3 = mData[7];
        double _r4 = mData[3];
        double _r5 = mData[1];
        double _r6 = mData[6];
        double _r7 = mData[2];
        double _r8 = mData[8];
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t4 = _r4 + _r5;
        double _t6 = _r6 + _r7;
        double _t7 = _r6 - _r7;
        double _t8 = _r3 + _r2;
        double _t9 = _r5 - _r4;
        double _t10 = _r8 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r8));
        double _t16 = 1.0 + (_r1 - (_r0 + _r8));
        double _t17 = 1.0 + (_r8 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s7190f6d9_tail(dd, _r0, _r1, _r8, _t1, _t4, _t6, _t7, _t8, _t9, _t10, _t14, _t15, _t16, _t17, _t21);
        return this;
    }

    private DoubleQuat makeFromMatrix_mulAdd(Double3x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x3Impl) m).data;
        double _r0 = mData[0];
        double _r1 = mData[4];
        double _r2 = mData[5];
        double _r3 = mData[7];
        double _r4 = mData[3];
        double _r5 = mData[1];
        double _r6 = mData[6];
        double _r7 = mData[2];
        double _r8 = mData[8];
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t4 = _r4 + _r5;
        double _t6 = _r6 + _r7;
        double _t7 = _r6 - _r7;
        double _t8 = _r3 + _r2;
        double _t9 = _r5 - _r4;
        double _t10 = _r8 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r8));
        double _t16 = 1.0 + (_r1 - (_r0 + _r8));
        double _t17 = 1.0 + (_r8 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s610e977e_tail(dd, _r0, _r1, _r8, _t1, _t4, _t6, _t7, _t8, _t9, _t10, _t14, _t15, _t16, _t17, _t21);
        return this;
    }

    /** Private vector tail of {@code makeFromMatrix_s7190f6d9}: loads, computes and stores every column; reached only through it. */
    private static void makeFromMatrix_s7190f6d9_tail(double[] dd, double _r0, double _r1, double _r8, double _t1, double _t4, double _t6, double _t7, double _t8, double _t9, double _t10, double _t14, double _t15, double _t16, double _t17, double _t21) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t14)))) : (_r0 > Math.max(_r1, _r8) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_r1 > _r8 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code makeFromMatrix_s610e977e}: loads, computes and stores every column; reached only through it. */
    private static void makeFromMatrix_s610e977e_tail(double[] dd, double _r0, double _r1, double _r8, double _t1, double _t4, double _t6, double _t7, double _t8, double _t9, double _t10, double _t14, double _t15, double _t16, double _t17, double _t21) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t14)))) : (_r0 > Math.max(_r1, _r8) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_r1 > _r8 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private DoubleQuat makeFromMatrix_fma(Double3x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        double _r0 = mData[0];
        double _r1 = mData[5];
        double _r2 = mData[9];
        double _r3 = mData[6];
        double _r4 = mData[1];
        double _r5 = mData[4];
        double _r6 = mData[2];
        double _r7 = mData[8];
        double _r8 = mData[10];
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t4 = _r4 + _r5;
        double _t6 = _r6 + _r7;
        double _t7 = _r6 - _r7;
        double _t8 = _r3 + _r2;
        double _t9 = _r5 - _r4;
        double _t10 = _r8 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r8));
        double _t16 = 1.0 + (_r1 - (_r0 + _r8));
        double _t17 = 1.0 + (_r8 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s597223b8_tail(dd, _r0, _r1, _r8, _t1, _t4, _t6, _t7, _t8, _t9, _t10, _t14, _t15, _t16, _t17, _t21);
        return this;
    }

    private DoubleQuat makeFromMatrix_mulAdd(Double3x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        double _r0 = mData[0];
        double _r1 = mData[5];
        double _r2 = mData[9];
        double _r3 = mData[6];
        double _r4 = mData[1];
        double _r5 = mData[4];
        double _r6 = mData[2];
        double _r7 = mData[8];
        double _r8 = mData[10];
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t4 = _r4 + _r5;
        double _t6 = _r6 + _r7;
        double _t7 = _r6 - _r7;
        double _t8 = _r3 + _r2;
        double _t9 = _r5 - _r4;
        double _t10 = _r8 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r8));
        double _t16 = 1.0 + (_r1 - (_r0 + _r8));
        double _t17 = 1.0 + (_r8 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s75f34a3f_tail(dd, _r0, _r1, _r8, _t1, _t4, _t6, _t7, _t8, _t9, _t10, _t14, _t15, _t16, _t17, _t21);
        return this;
    }

    /** Private vector tail of {@code makeFromMatrix_s597223b8}: loads, computes and stores every column; reached only through it. */
    private static void makeFromMatrix_s597223b8_tail(double[] dd, double _r0, double _r1, double _r8, double _t1, double _t4, double _t6, double _t7, double _t8, double _t9, double _t10, double _t14, double _t15, double _t16, double _t17, double _t21) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t14)))) : (_r0 > Math.max(_r1, _r8) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_r1 > _r8 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code makeFromMatrix_s75f34a3f}: loads, computes and stores every column; reached only through it. */
    private static void makeFromMatrix_s75f34a3f_tail(double[] dd, double _r0, double _r1, double _r8, double _t1, double _t4, double _t6, double _t7, double _t8, double _t9, double _t10, double _t14, double _t15, double _t16, double _t17, double _t21) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t14)))) : (_r0 > Math.max(_r1, _r8) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_r1 > _r8 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private DoubleQuat makeFromMatrix_fma(Double4x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double _r0 = mData[0];
        double _r1 = mData[5];
        double _r2 = mData[6];
        double _r3 = mData[9];
        double _r4 = mData[4];
        double _r5 = mData[1];
        double _r6 = mData[8];
        double _r7 = mData[2];
        double _r8 = mData[10];
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t4 = _r4 + _r5;
        double _t6 = _r6 + _r7;
        double _t7 = _r6 - _r7;
        double _t8 = _r3 + _r2;
        double _t9 = _r5 - _r4;
        double _t10 = _r8 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r8));
        double _t16 = 1.0 + (_r1 - (_r0 + _r8));
        double _t17 = 1.0 + (_r8 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s4dbb94d7_tail(dd, _r0, _r1, _r8, _t1, _t4, _t6, _t7, _t8, _t9, _t10, _t14, _t15, _t16, _t17, _t21);
        return this;
    }

    private DoubleQuat makeFromMatrix_mulAdd(Double4x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double _r0 = mData[0];
        double _r1 = mData[5];
        double _r2 = mData[6];
        double _r3 = mData[9];
        double _r4 = mData[4];
        double _r5 = mData[1];
        double _r6 = mData[8];
        double _r7 = mData[2];
        double _r8 = mData[10];
        double _t0 = _r0 + _r1;
        double _t1 = _r2 - _r3;
        double _t4 = _r4 + _r5;
        double _t6 = _r6 + _r7;
        double _t7 = _r6 - _r7;
        double _t8 = _r3 + _r2;
        double _t9 = _r5 - _r4;
        double _t10 = _r8 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_r0 - (_r1 + _r8));
        double _t16 = 1.0 + (_r1 - (_r0 + _r8));
        double _t17 = 1.0 + (_r8 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        makeFromMatrix_s647650c0_tail(dd, _r0, _r1, _r8, _t1, _t4, _t6, _t7, _t8, _t9, _t10, _t14, _t15, _t16, _t17, _t21);
        return this;
    }

    /** Private vector tail of {@code makeFromMatrix_s4dbb94d7}: loads, computes and stores every column; reached only through it. */
    private static void makeFromMatrix_s4dbb94d7_tail(double[] dd, double _r0, double _r1, double _r8, double _t1, double _t4, double _t6, double _t7, double _t8, double _t9, double _t10, double _t14, double _t15, double _t16, double _t17, double _t21) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t14)))) : (_r0 > Math.max(_r1, _r8) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_r1 > _r8 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code makeFromMatrix_s647650c0}: loads, computes and stores every column; reached only through it. */
    private static void makeFromMatrix_s647650c0_tail(double[] dd, double _r0, double _r1, double _r8, double _t1, double _t4, double _t6, double _t7, double _t8, double _t9, double _t10, double _t14, double _t15, double _t16, double _t17, double _t21) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t14)))) : (_r0 > Math.max(_r1, _r8) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_r1 > _r8 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
    }


    /**
     * Convert this quaternion to a pure-rotation dual quaternion (zero dual part) and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        DoubleVector.fromArray(COL_SPECIES, sd, 0).intoArray(dd, 0);
        VEC_1.intoArray(dd, 4);
        return dest;
    }


    /**
     * Compute the matrix representation of this quaternion (which must have unit length) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t1 = sd[2] * sd[3];
        double _t2 = sd[1] * sd[3];
        double _buf0 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        dd[1] = 2.0 * Math.fma(sd[0], sd[1], _t1);
        dd[2] = 2.0 * Math.fma(sd[0], sd[2], -_t2);
        dd[3] = 0.0;
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], -_t1);
        dd[5] = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0);
        dd[6] = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[7] = 0.0;
        double _buf2 = 2.0 * Math.fma(sd[0], sd[2], _t2);
        dd[9] = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[10] = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        VEC_1.intoArray(dd, 11);
        dd[15] = 1.0;
        dd[0] = _buf0;
        dd[4] = _buf1;
        dd[8] = _buf2;
        ((Double4x4Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Compute the 3x3 rotation matrix representation of this quaternion (which must have unit
     * length) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t1 = sd[2] * sd[3];
        double _t2 = sd[1] * sd[3];
        double _buf0 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], _t1);
        dd[2] = 2.0 * Math.fma(sd[0], sd[2], -_t2);
        double _buf2 = 2.0 * Math.fma(sd[0], sd[1], -_t1);
        dd[4] = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0);
        dd[5] = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _buf3 = 2.0 * Math.fma(sd[0], sd[2], _t2);
        dd[7] = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[8] = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[6] = _buf3;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the 3x4 matrix representation of this quaternion (which must have unit length; the
     * omitted last row is implicitly {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t1 = sd[2] * sd[3];
        double _t2 = sd[1] * sd[3];
        double _buf0 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], -_t1);
        double _buf2 = 2.0 * Math.fma(sd[0], sd[2], _t2);
        double _buf3 = 0.0;
        dd[4] = 2.0 * Math.fma(sd[0], sd[1], _t1);
        dd[5] = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0);
        dd[6] = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[7] = 0.0;
        dd[8] = 2.0 * Math.fma(sd[0], sd[2], -_t2);
        dd[9] = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[10] = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        dd[11] = 0.0;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Double3x4Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
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
        double[] sd = this.data;
        double[] swingData = ((DoubleQuatImpl) swing).data;
        double[] twistData = ((DoubleQuatImpl) twist).data;
        double _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        double _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = sd[3] * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        double _d0buf0 = Math.fma(sd[0], _t11, -(sd[3] * _t12)) + Math.fma(sd[2], _t13, -(sd[1] * _t14));
        double _d0buf1 = Math.fma(sd[0], _t14, -(sd[3] * _t13)) + Math.fma(sd[1], _t11, -(sd[2] * _t12));
        double _d0buf2 = Math.fma(sd[1], _t12, sd[2] * _t11) + Math.fma(-sd[0], _t13, -(sd[3] * _t14));
        swingData[3] = Math.fma(sd[0], _t12, sd[3] * _t11) - Math.fma(-sd[2], _t14, -(sd[1] * _t13));
        swingData[0] = _d0buf0;
        swingData[1] = _d0buf1;
        swingData[2] = _d0buf2;
        twistData[0] = _t12;
        twistData[1] = _t13;
        twistData[2] = _t14;
        twistData[3] = _t11;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        double _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = sd[3] * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        double _buf0 = Math.fma(sd[0], _t11, -(sd[3] * _t12)) + Math.fma(sd[2], _t13, -(sd[1] * _t14));
        double _buf1 = Math.fma(sd[0], _t14, -(sd[3] * _t13)) + Math.fma(sd[1], _t11, -(sd[2] * _t12));
        double _buf2 = Math.fma(sd[1], _t12, sd[2] * _t11) + Math.fma(-sd[0], _t13, -(sd[3] * _t14));
        dd[3] = Math.fma(sd[0], _t12, sd[3] * _t11) - Math.fma(-sd[2], _t14, -(sd[1] * _t13));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        double _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            dd[0] = axisX * _t6;
            dd[1] = axisY * _t6;
            dd[2] = axisZ * _t6;
            dd[3] = sd[3] * _t5;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
            dd[3] = 1.0;
        }
        return dest;
    }


    /**
     * Set this quaternion to the identity.
     *
     * @return this
     */
    @Mutated public DoubleQuat makeIdentity() {
        double[] dd = this.data;
        VEC_2.intoArray(dd, 0);
        return this;
    }


    /**
     * Set all components of this quaternion to zero.
     *
     * @return this
     */
    @Mutated public DoubleQuat makeZero() {
        double[] dd = this.data;
        var _col0 = DoubleVector.broadcast(COL_SPECIES, 0.0);
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return lerp_fma(other, t, dest);
        return lerp_mulAdd(other, t, dest);
    }

    private DoubleQuat lerp_fma(DoubleQuatR other, double t, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = DoubleVector.broadcast(COL_SPECIES, t).fma(DoubleVector.fromArray(COL_SPECIES, otherData, 0).sub(_sv0), _sv0);
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat lerp_mulAdd(DoubleQuatR other, double t, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = DoubleVector.broadcast(COL_SPECIES, t).mul(DoubleVector.fromArray(COL_SPECIES, otherData, 0).sub(_sv0)).add(_sv0);
        _col0.intoArray(dd, 0);
        return dest;
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
        if (SimdMath.USE_FMA) return lerp_fma(otherX, otherY, otherZ, otherW, t, dest);
        return lerp_mulAdd(otherX, otherY, otherZ, otherW, t, dest);
    }

    private DoubleQuat lerp_fma(double otherX, double otherY, double otherZ, double otherW, double t, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = DoubleVector.broadcast(COL_SPECIES, t).fma(DoubleVector.zero(COL_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0), _sv0);
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat lerp_mulAdd(double otherX, double otherY, double otherZ, double otherW, double t, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = DoubleVector.broadcast(COL_SPECIES, t).mul(DoubleVector.zero(COL_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0)).add(_sv0);
        _col0.intoArray(dd, 0);
        return dest;
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
        if (SimdMath.USE_FMA) return nlerp_fma(target, alpha, dest);
        return nlerp_mulAdd(target, alpha, dest);
    }

    private DoubleQuat nlerp_fma(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.broadcast(COL_SPECIES, alpha).fma(DoubleVector.fromArray(COL_SPECIES, targetData, 0).sub(_sv0), _sv0);
        double _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t11 != 0.0 ? _sv1.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t11)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat nlerp_mulAdd(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.broadcast(COL_SPECIES, alpha).mul(DoubleVector.fromArray(COL_SPECIES, targetData, 0).sub(_sv0)).add(_sv0);
        double _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t11 != 0.0 ? _sv1.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t11)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t4 = Math.fma(alpha, targetW - sd[3], sd[3]);
        double _t5 = Math.fma(alpha, targetZ - sd[2], sd[2]);
        double _t6 = Math.fma(alpha, targetX - sd[0], sd[0]);
        double _t7 = Math.fma(alpha, targetY - sd[1], sd[1]);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 != 0.0) {
            dd[0] = _t6 * _t12;
            dd[1] = _t7 * _t12;
            dd[2] = _t5 * _t12;
            dd[3] = _t4 * _t12;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
            dd[3] = 0.0;
        }
        return dest;
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
        if (SimdMath.USE_FMA) return nlerpShortest_fma(target, alpha, dest);
        return nlerpShortest_mulAdd(target, alpha, dest);
    }

    private DoubleQuat nlerpShortest_fma(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _r0 = sd[3];
        double _r1 = targetData[3];
        double _r2 = sd[2];
        double _r3 = targetData[2];
        double _r4 = sd[0];
        double _r5 = targetData[0];
        double _r6 = sd[1];
        double _r7 = targetData[1];
        nlerpShortest_s2dc9352d_tail(dd, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, alpha, sd, targetData);
        return dest;
    }

    private DoubleQuat nlerpShortest_mulAdd(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _r0 = sd[3];
        double _r1 = targetData[3];
        double _r2 = sd[2];
        double _r3 = targetData[2];
        double _r4 = sd[0];
        double _r5 = targetData[0];
        double _r6 = sd[1];
        double _r7 = targetData[1];
        nlerpShortest_s362bc8aa_tail(dd, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, alpha, sd, targetData);
        return dest;
    }

    /** Private vector tail of {@code nlerpShortest_s2dc9352d}: loads, computes and stores every column; reached only through it. */
    private static void nlerpShortest_s2dc9352d_tail(double[] dd, double _r0, double _r1, double _r2, double _r3, double _r4, double _r5, double _r6, double _r7, double alpha, double[] sd, double[] targetData) {
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv2 = _sv0.neg();
        var _sv3 = DoubleVector.broadcast(COL_SPECIES, alpha).fma((-Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6 * _r7))) > 0.0 ? _sv2 : _sv0).sub(_sv1), _sv1);
        double _t24 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t24 != 0.0 ? DoubleVector.broadcast(COL_SPECIES, alpha).fma((-Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6 * _r7))) > 0.0 ? _sv2 : _sv0).sub(_sv1), _sv1).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t24)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code nlerpShortest_s362bc8aa}: loads, computes and stores every column; reached only through it. */
    private static void nlerpShortest_s362bc8aa_tail(double[] dd, double _r0, double _r1, double _r2, double _r3, double _r4, double _r5, double _r6, double _r7, double alpha, double[] sd, double[] targetData) {
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv2 = _sv0.neg();
        var _sv3 = DoubleVector.broadcast(COL_SPECIES, alpha).mul((-Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6 * _r7))) > 0.0 ? _sv2 : _sv0).sub(_sv1)).add(_sv1);
        double _t24 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t24 != 0.0 ? DoubleVector.broadcast(COL_SPECIES, alpha).mul((-Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6 * _r7))) > 0.0 ? _sv2 : _sv0).sub(_sv1)).add(_sv1).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t24)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t8 = -Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
            _t17 = Math.fma(alpha, -targetW - sd[3], sd[3]);
            _t18 = Math.fma(alpha, -targetZ - sd[2], sd[2]);
            _t19 = Math.fma(alpha, -targetX - sd[0], sd[0]);
            _t20 = Math.fma(alpha, -targetY - sd[1], sd[1]);
        } else {
            _t17 = Math.fma(alpha, targetW - sd[3], sd[3]);
            _t18 = Math.fma(alpha, targetZ - sd[2], sd[2]);
            _t19 = Math.fma(alpha, targetX - sd[0], sd[0]);
            _t20 = Math.fma(alpha, targetY - sd[1], sd[1]);
        }
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 != 0.0) {
            dd[0] = _t19 * _t25;
            dd[1] = _t20 * _t25;
            dd[2] = _t18 * _t25;
            dd[3] = _t17 * _t25;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
            dd[3] = 0.0;
        }
        return dest;
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
        if (SimdMath.USE_FMA) return slerp_fma(target, alpha, dest);
        return slerp_mulAdd(target, alpha, dest);
    }

    private DoubleQuat slerp_fma(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - alpha;
        double _t1 = sd[3] + targetData[3];
        double _t2 = sd[2] + targetData[2];
        double _t3 = sd[0] + targetData[0];
        double _t4 = sd[1] + targetData[1];
        double _t5 = alpha < 0.5 ? 1.0 : 0.0;
        double _t11 = Math.min(4.0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4))));
        double _t12 = quatArcAngle(_t11);
        double _t13 = 4.0 - _t11;
        double _t18 = _t13 * _t11;
        double _t19 = Math.sqrt(_t18);
        double _t21 = 2.0 * (1.0 / Math.sqrt(_t18));
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(_t0 * _t12) : _t11 > _t13 ? _t0 : _t5), DoubleVector.fromArray(COL_SPECIES, targetData, 0).mul(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(alpha * _t12) : _t11 > _t13 ? alpha : 1.0 - _t5)));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat slerp_mulAdd(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - alpha;
        double _t1 = sd[3] + targetData[3];
        double _t2 = sd[2] + targetData[2];
        double _t3 = sd[0] + targetData[0];
        double _t4 = sd[1] + targetData[1];
        double _t5 = alpha < 0.5 ? 1.0 : 0.0;
        double _t11 = Math.min(4.0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4))));
        double _t12 = quatArcAngle(_t11);
        double _t13 = 4.0 - _t11;
        double _t18 = _t13 * _t11;
        double _t19 = Math.sqrt(_t18);
        double _t21 = 2.0 * (1.0 / Math.sqrt(_t18));
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(_t0 * _t12) : _t11 > _t13 ? _t0 : _t5)).add(DoubleVector.fromArray(COL_SPECIES, targetData, 0).mul(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(alpha * _t12) : _t11 > _t13 ? alpha : 1.0 - _t5)));
        _col0.intoArray(dd, 0);
        return dest;
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
        if (SimdMath.USE_FMA) return slerp_fma(targetX, targetY, targetZ, targetW, alpha, dest);
        return slerp_mulAdd(targetX, targetY, targetZ, targetW, alpha, dest);
    }

    private DoubleQuat slerp_fma(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _r0 = sd[3];
        double _r1 = sd[2];
        double _r2 = sd[0];
        double _r3 = sd[1];
        double _t0 = 1.0 - alpha;
        double _t1 = _r0 + targetW;
        double _t2 = _r1 + targetZ;
        double _t3 = _r2 + targetX;
        double _t4 = _r3 + targetY;
        double _t5 = alpha < 0.5 ? 1.0 : 0.0;
        double _t11 = Math.min(4.0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4))));
        double _t12 = quatArcAngle(_t11);
        double _t13 = 4.0 - _t11;
        double _t18 = _t13 * _t11;
        double _t19 = Math.sqrt(_t18);
        double _t21 = 2.0 * (1.0 / Math.sqrt(_t18));
        slerp_s21ab8e64_tail(dd, _t0, _t5, _t11, _t12, _t13, _t19, _t21, targetX, targetY, targetZ, targetW, alpha, sd);
        return dest;
    }

    private DoubleQuat slerp_mulAdd(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _r0 = sd[3];
        double _r1 = sd[2];
        double _r2 = sd[0];
        double _r3 = sd[1];
        double _t0 = 1.0 - alpha;
        double _t1 = _r0 + targetW;
        double _t2 = _r1 + targetZ;
        double _t3 = _r2 + targetX;
        double _t4 = _r3 + targetY;
        double _t5 = alpha < 0.5 ? 1.0 : 0.0;
        double _t11 = Math.min(4.0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4))));
        double _t12 = quatArcAngle(_t11);
        double _t13 = 4.0 - _t11;
        double _t18 = _t13 * _t11;
        double _t19 = Math.sqrt(_t18);
        double _t21 = 2.0 * (1.0 / Math.sqrt(_t18));
        slerp_s4797d013_tail(dd, _t0, _t5, _t11, _t12, _t13, _t19, _t21, targetX, targetY, targetZ, targetW, alpha, sd);
        return dest;
    }

    /** Private vector tail of {@code slerp_s21ab8e64}: loads, computes and stores every column; reached only through it. */
    private static void slerp_s21ab8e64_tail(double[] dd, double _t0, double _t5, double _t11, double _t12, double _t13, double _t19, double _t21, double targetX, double targetY, double targetZ, double targetW, double alpha, double[] sd) {
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = _sv0.fma(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(_t0 * _t12) : _t11 > _t13 ? _t0 : _t5), DoubleVector.zero(COL_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW).mul(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(alpha * _t12) : _t11 > _t13 ? alpha : 1.0 - _t5)));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code slerp_s4797d013}: loads, computes and stores every column; reached only through it. */
    private static void slerp_s4797d013_tail(double[] dd, double _t0, double _t5, double _t11, double _t12, double _t13, double _t19, double _t21, double targetX, double targetY, double targetZ, double targetW, double alpha, double[] sd) {
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = _sv0.mul(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(_t0 * _t12) : _t11 > _t13 ? _t0 : _t5)).add(DoubleVector.zero(COL_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW).mul(DoubleVector.broadcast(COL_SPECIES, _t19 > 2.0E-14 ? _t21 * Math.sin(alpha * _t12) : _t11 > _t13 ? alpha : 1.0 - _t5)));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return slerpShortest_fma(target, alpha, dest);
        return slerpShortest_mulAdd(target, alpha, dest);
    }

    private DoubleQuat slerpShortest_fma(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0 ? _sv0.fma(DoubleVector.broadcast(COL_SPECIES, Math.sin((1.0 - alpha) * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))), DoubleVector.broadcast(COL_SPECIES, Math.sin(alpha * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))).mul(_sv2)).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : DoubleVector.broadcast(COL_SPECIES, alpha).fma(_sv2, _sv0.mul(DoubleVector.broadcast(COL_SPECIES, 1.0 - alpha))));
        double _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t49 != 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t49)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat slerpShortest_mulAdd(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin((1.0 - alpha) * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))).add(DoubleVector.broadcast(COL_SPECIES, Math.sin(alpha * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))).mul(_sv2)).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : DoubleVector.broadcast(COL_SPECIES, alpha).mul(_sv2).add(_sv0.mul(DoubleVector.broadcast(COL_SPECIES, 1.0 - alpha))));
        double _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t49 != 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t49)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        double _t14 = -_t12;
        double _t16 = Math.acos(Math.min(1.0, Math.abs(_t12)));
        double _t17 = Math.sin(_t16);
        double _t17_inv = 1.0 / _t17;
        double _t19 = Math.sin(alpha * _t16);
        double _t21, _t22, _t23, _t24;
        if (_t14 > 0.0) {
            _t21 = -targetW;
            _t22 = -targetZ;
            _t23 = -targetX;
            _t24 = -targetY;
        } else {
            _t21 = targetW;
            _t22 = targetZ;
            _t23 = targetX;
            _t24 = targetY;
        }
        double _t25 = Math.sin(_t0 * _t16);
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
            _t42 = Math.fma(sd[3], _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(sd[2], _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(sd[0], _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(sd[1], _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, sd[3] * _t0);
            _t43 = Math.fma(alpha, _t22, sd[2] * _t0);
            _t44 = Math.fma(alpha, _t23, sd[0] * _t0);
            _t45 = Math.fma(alpha, _t24, sd[1] * _t0);
        }
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 != 0.0) {
            dd[0] = _t50 * _t44;
            dd[1] = _t50 * _t45;
            dd[2] = _t50 * _t43;
            dd[3] = _t50 * _t42;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
            dd[3] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] control0Data = ((DoubleQuatImpl) control0).data;
        double[] control1Data = ((DoubleQuatImpl) control1).data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - t;
        double _t1 = t + t;
        double _t3 = control0Data[3] + control1Data[3];
        double _t4 = control0Data[2] + control1Data[2];
        double _t5 = control0Data[0] + control1Data[0];
        double _t6 = control0Data[1] + control1Data[1];
        double _t7 = t < 0.5 ? 1.0 : 0.0;
        double _t8 = sd[3] + targetData[3];
        double _t9 = sd[2] + targetData[2];
        double _t10 = sd[0] + targetData[0];
        double _t11 = sd[1] + targetData[1];
        double _t12 = 1.0 - _t7;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t17 = _t13 < 0.5 ? 1.0 : 0.0;
        double _t25 = Math.min(4.0, Math.fma(_t3, _t3, Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6))));
        double _t26 = Math.min(4.0, Math.fma(_t8, _t8, Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11))));
        double _t27 = quatArcAngle(_t25);
        double _t28 = quatArcAngle(_t26);
        double _t29 = 4.0 - _t25;
        double _t30 = 4.0 - _t26;
        double _t39 = _t29 * _t25;
        double _t40 = _t30 * _t26;
        double _t41 = Math.sqrt(_t39);
        double _t43 = Math.sqrt(_t40);
        double _t45 = 2.0 / _t41;
        double _t46 = 2.0 / _t43;
        double _t55, _t57;
        if (_t41 > 2.0E-14) {
            _t55 = _t45 * Math.sin(t * _t27);
            _t57 = _t45 * Math.sin(_t0 * _t27);
        } else {
            if (_t25 > _t29) {
                _t55 = t;
                _t57 = _t0;
            } else {
                _t55 = _t12;
                _t57 = _t7;
            }
        }
        double _t56, _t58;
        if (_t43 > 2.0E-14) {
            _t56 = _t46 * Math.sin(t * _t28);
            _t58 = _t46 * Math.sin(_t0 * _t28);
        } else {
            if (_t26 > _t30) {
                _t56 = t;
                _t58 = _t0;
            } else {
                _t56 = _t12;
                _t58 = _t7;
            }
        }
        double _t67 = Math.fma(control0Data[0], _t57, control1Data[0] * _t55);
        double _t68 = Math.fma(control0Data[3], _t57, control1Data[3] * _t55);
        double _t69 = Math.fma(sd[3], _t58, targetData[3] * _t56);
        double _t70 = Math.fma(control0Data[2], _t57, control1Data[2] * _t55);
        double _t71 = Math.fma(sd[2], _t58, targetData[2] * _t56);
        double _t72 = Math.fma(sd[0], _t58, targetData[0] * _t56);
        double _t73 = Math.fma(control0Data[1], _t57, control1Data[1] * _t55);
        double _t74 = Math.fma(sd[1], _t58, targetData[1] * _t56);
        double _t75 = _t68 + _t69;
        double _t76 = _t70 + _t71;
        double _t77 = _t67 + _t72;
        double _t78 = _t73 + _t74;
        double _t83 = Math.min(4.0, Math.fma(_t75, _t75, Math.fma(_t76, _t76, Math.fma(_t77, _t77, _t78 * _t78))));
        double _t84 = quatArcAngle(_t83);
        double _t85 = 4.0 - _t83;
        double _t90 = _t85 * _t83;
        double _t91 = Math.sqrt(_t90);
        double _t93 = 2.0 / _t91;
        double _t98, _t99;
        if (_t91 > 2.0E-14) {
            _t98 = _t93 * Math.sin(_t13 * _t84);
            _t99 = _t93 * Math.sin(_t14 * _t84);
        } else {
            if (_t83 > _t85) {
                _t98 = _t13;
                _t99 = _t14;
            } else {
                _t98 = 1.0 - _t17;
                _t99 = _t17;
            }
        }
        dd[0] = Math.fma(_t67, _t98, _t72 * _t99);
        dd[1] = Math.fma(_t73, _t98, _t74 * _t99);
        dd[2] = Math.fma(_t70, _t98, _t71 * _t99);
        dd[3] = Math.fma(_t68, _t98, _t69 * _t99);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - t;
        double _t1 = t + t;
        double _t3 = control0W + control1W;
        double _t4 = control0Z + control1Z;
        double _t5 = control0X + control1X;
        double _t6 = control0Y + control1Y;
        double _t7 = t < 0.5 ? 1.0 : 0.0;
        double _t8 = sd[3] + targetW;
        double _t9 = sd[2] + targetZ;
        double _t10 = sd[0] + targetX;
        double _t11 = sd[1] + targetY;
        double _t12 = 1.0 - _t7;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t17 = _t13 < 0.5 ? 1.0 : 0.0;
        double _t25 = Math.min(4.0, Math.fma(_t3, _t3, Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6))));
        double _t26 = Math.min(4.0, Math.fma(_t8, _t8, Math.fma(_t9, _t9, Math.fma(_t10, _t10, _t11 * _t11))));
        double _t27 = quatArcAngle(_t25);
        double _t28 = quatArcAngle(_t26);
        double _t29 = 4.0 - _t25;
        double _t30 = 4.0 - _t26;
        double _t39 = _t29 * _t25;
        double _t40 = _t30 * _t26;
        double _t41 = Math.sqrt(_t39);
        double _t43 = Math.sqrt(_t40);
        double _t45 = 2.0 / _t41;
        double _t46 = 2.0 / _t43;
        double _t55, _t57;
        if (_t41 > 2.0E-14) {
            _t55 = _t45 * Math.sin(t * _t27);
            _t57 = _t45 * Math.sin(_t0 * _t27);
        } else {
            if (_t25 > _t29) {
                _t55 = t;
                _t57 = _t0;
            } else {
                _t55 = _t12;
                _t57 = _t7;
            }
        }
        double _t56, _t58;
        if (_t43 > 2.0E-14) {
            _t56 = _t46 * Math.sin(t * _t28);
            _t58 = _t46 * Math.sin(_t0 * _t28);
        } else {
            if (_t26 > _t30) {
                _t56 = t;
                _t58 = _t0;
            } else {
                _t56 = _t12;
                _t58 = _t7;
            }
        }
        double _t67 = Math.fma(control0X, _t57, control1X * _t55);
        double _t68 = Math.fma(control0W, _t57, control1W * _t55);
        double _t69 = Math.fma(sd[3], _t58, targetW * _t56);
        double _t70 = Math.fma(control0Z, _t57, control1Z * _t55);
        double _t71 = Math.fma(sd[2], _t58, targetZ * _t56);
        double _t72 = Math.fma(sd[0], _t58, targetX * _t56);
        double _t73 = Math.fma(control0Y, _t57, control1Y * _t55);
        double _t74 = Math.fma(sd[1], _t58, targetY * _t56);
        double _t75 = _t68 + _t69;
        double _t76 = _t70 + _t71;
        double _t77 = _t67 + _t72;
        double _t78 = _t73 + _t74;
        double _t83 = Math.min(4.0, Math.fma(_t75, _t75, Math.fma(_t76, _t76, Math.fma(_t77, _t77, _t78 * _t78))));
        double _t84 = quatArcAngle(_t83);
        double _t85 = 4.0 - _t83;
        double _t90 = _t85 * _t83;
        double _t91 = Math.sqrt(_t90);
        double _t93 = 2.0 / _t91;
        double _t98, _t99;
        if (_t91 > 2.0E-14) {
            _t98 = _t93 * Math.sin(_t13 * _t84);
            _t99 = _t93 * Math.sin(_t14 * _t84);
        } else {
            if (_t83 > _t85) {
                _t98 = _t13;
                _t99 = _t14;
            } else {
                _t98 = 1.0 - _t17;
                _t99 = _t17;
            }
        }
        dd[0] = Math.fma(_t67, _t98, _t72 * _t99);
        dd[1] = Math.fma(_t73, _t98, _t74 * _t99);
        dd[2] = Math.fma(_t70, _t98, _t71 * _t99);
        dd[3] = Math.fma(_t68, _t98, _t69 * _t99);
        return dest;
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
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[2], sd[1], -(otherData[1] * sd[2]));
        double _buf1 = Math.fma(otherData[0], sd[2], otherData[3] * sd[1]) + Math.fma(otherData[1], sd[3], -(otherData[2] * sd[0]));
        double _buf2 = Math.fma(otherData[1], sd[0], otherData[2] * sd[3]) + Math.fma(otherData[3], sd[2], -(otherData[0] * sd[1]));
        dd[3] = Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0])) - Math.fma(otherData[1], sd[1], otherData[2] * sd[2]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _buf0 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        double _buf1 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        double _buf2 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
        dd[3] = Math.fma(otherW, sd[3], -(otherX * sd[0])) - Math.fma(otherY, sd[1], otherZ * sd[2]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _buf0 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[1], sd[2], -(otherData[2] * sd[1]));
        double _buf1 = Math.fma(otherData[1], sd[3], otherData[2] * sd[0]) + Math.fma(otherData[3], sd[1], -(otherData[0] * sd[2]));
        double _buf2 = Math.fma(otherData[0], sd[1], otherData[3] * sd[2]) + Math.fma(otherData[2], sd[3], -(otherData[1] * sd[0]));
        dd[3] = Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0])) - Math.fma(otherData[1], sd[1], otherData[2] * sd[2]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _buf0 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherY, sd[2], -(otherZ * sd[1]));
        double _buf1 = Math.fma(otherY, sd[3], otherZ * sd[0]) + Math.fma(otherW, sd[1], -(otherX * sd[2]));
        double _buf2 = Math.fma(otherX, sd[1], otherW * sd[2]) + Math.fma(otherZ, sd[3], -(otherY * sd[0]));
        dd[3] = Math.fma(otherW, sd[3], -(otherX * sd[0])) - Math.fma(otherY, sd[1], otherZ * sd[2]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        return 2.0 * Math.atan2(Math.sqrt(Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]))), sd[3]);
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
        double[] sd = this.data;
        double _t8 = -Math.fma(otherW, sd[3], Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1])));
        double _t9, _t10, _t11, _t12;
        if (_t8 > 0.0) {
            _t9 = -otherW;
            _t10 = -otherZ;
            _t11 = -otherX;
            _t12 = -otherY;
        } else {
            _t9 = otherW;
            _t10 = otherZ;
            _t11 = otherX;
            _t12 = otherY;
        }
        double _t13 = sd[3] - _t9;
        double _t14 = sd[2] - _t10;
        double _t15 = sd[0] - _t11;
        double _t16 = sd[1] - _t12;
        double _t17 = sd[3] + _t9;
        double _t18 = sd[2] + _t10;
        double _t19 = sd[0] + _t11;
        double _t20 = sd[1] + _t12;
        return 4.0 * Math.atan2(Math.sqrt(Math.fma(_t13, _t13, Math.fma(_t14, _t14, Math.fma(_t15, _t15, _t16 * _t16)))), Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))));
    }


    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 axis(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dd[0] = sd[0] * _t3;
            dd[1] = sd[1] * _t3;
            dd[2] = sd[2] * _t3;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).withLane(3, Math.sqrt(Math.max(0.0, Math.fma(-sd[0], sd[0], Math.fma(-sd[1], sd[1], Math.fma(-sd[2], sd[2], 1.0))))));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Conjugate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugate(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = _sv0.lanewise(VectorOperators.NEG, MASK_0);
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] qData = ((DoubleQuatImpl) q).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t20 = Math.fma(qData[0], sd[1], qData[3] * sd[2]) + Math.fma(qData[2], sd[3], -(qData[1] * sd[0]));
        double _t21 = Math.fma(qData[1], sd[3], qData[2] * sd[0]) + Math.fma(qData[3], sd[1], -(qData[0] * sd[2]));
        double _t22 = Math.fma(qData[0], sd[3], qData[3] * sd[0]) + Math.fma(qData[1], sd[2], -(qData[2] * sd[1]));
        double _t23 = Math.fma(qData[3], sd[3], -(qData[0] * sd[0])) - Math.fma(qData[1], sd[1], qData[2] * sd[2]);
        double _buf0 = Math.fma(qData[1], _t20, -(qData[2] * _t21)) + Math.fma(qData[3], _t22, -(qData[0] * _t23));
        double _buf1 = Math.fma(qData[2], _t22, -(qData[1] * _t23)) + Math.fma(qData[3], _t21, -(qData[0] * _t20));
        double _buf2 = Math.fma(qData[0], _t21, qData[3] * _t20) + Math.fma(-qData[1], _t22, -(qData[2] * _t23));
        dd[3] = Math.fma(qData[0], _t22, qData[3] * _t23) - Math.fma(-qData[2], _t20, -(qData[1] * _t21));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t20 = Math.fma(qX, sd[1], qW * sd[2]) + Math.fma(qZ, sd[3], -(qY * sd[0]));
        double _t21 = Math.fma(qY, sd[3], qZ * sd[0]) + Math.fma(qW, sd[1], -(qX * sd[2]));
        double _t22 = Math.fma(qX, sd[3], qW * sd[0]) + Math.fma(qY, sd[2], -(qZ * sd[1]));
        double _t23 = Math.fma(qW, sd[3], -(qX * sd[0])) - Math.fma(qY, sd[1], qZ * sd[2]);
        dd[0] = Math.fma(qY, _t20, -(qZ * _t21)) + Math.fma(qW, _t22, -(qX * _t23));
        dd[1] = Math.fma(qZ, _t22, -(qY * _t23)) + Math.fma(qW, _t21, -(qX * _t20));
        dd[2] = Math.fma(qX, _t21, qW * _t20) + Math.fma(-qY, _t22, -(qZ * _t23));
        dd[3] = Math.fma(qX, _t22, qW * _t23) - Math.fma(-qZ, _t20, -(qY * _t21));
        return dest;
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
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t3_inv = 1.0 / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        double _sp1 = _t3_inv * sd[2];
        double _sp0 = sd[1] * _t3_inv;
        double _buf0 = (Math.fma(otherData[0], sd[3], -(otherData[3] * sd[0])) + Math.fma(otherData[1], sd[2], -(otherData[2] * sd[1]))) * _t3_inv;
        double _buf1 = -(otherData[3] * _sp0) - otherData[0] * _sp1 + Math.fma(otherData[1], sd[3], otherData[2] * sd[0]) * _t3_inv;
        double _buf2 = (Math.fma(otherData[0], sd[1], -(otherData[3] * sd[2])) + Math.fma(otherData[2], sd[3], -(otherData[1] * sd[0]))) * _t3_inv;
        dd[3] = Math.fma(otherData[0], sd[0], otherData[3] * sd[3]) * _t3_inv - (-(otherData[1] * _sp0) - otherData[2] * _sp1);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t3_inv = 1.0 / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        double _sp1 = _t3_inv * sd[2];
        double _sp0 = sd[1] * _t3_inv;
        double _buf0 = (Math.fma(otherX, sd[3], -(otherW * sd[0])) + Math.fma(otherY, sd[2], -(otherZ * sd[1]))) * _t3_inv;
        double _buf1 = -(otherW * _sp0) - otherX * _sp1 + Math.fma(otherY, sd[3], otherZ * sd[0]) * _t3_inv;
        dd[2] = (Math.fma(otherX, sd[1], -(otherW * sd[2])) + Math.fma(otherZ, sd[3], -(otherY * sd[0]))) * _t3_inv;
        dd[3] = Math.fma(otherX, sd[0], otherW * sd[3]) * _t3_inv - (-(otherY * _sp0) - otherZ * _sp1);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        return Math.fma(otherW, sd[3], Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1])));
    }


    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat exp(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = Math.exp(sd[3]);
        double _t3 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t4 = Math.sqrt(_t3);
        double _t6 = Math.sin(_t4);
        var _col0 = (_t3 > 0.0 ? DoubleVector.fromArray(COL_SPECIES, sd, 0).withLane(3, Math.cosFromSin(_t6, _t4)).mul(DoubleVector.broadcast(COL_SPECIES, _t6 * _t0 * (1.0 / Math.sqrt(_t3))).withLane(3, _t0)) : DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cosFromSin(_t6, _t4) * _t0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = sd[1] * sd[2];
        double _t3 = sd[2] * sd[2];
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], _t1), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t3), 1.0));
            dd[2] = 0.0;
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(_t9, _t10);
            dd[2] = Math.atan2(2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t3), 1.0));
            dd[0] = _buf0;
        }
        dd[1] = Math.atan2(_t8, Math.sqrt(_t12));
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t1 = sd[1] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], _t1);
        double _t8 = 2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], -_t1), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[1] = 0.0;
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(_t7, _t9);
            dd[1] = Math.atan2(2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0));
            dd[0] = _buf0;
        }
        dd[2] = Math.atan2(_t8, Math.sqrt(_t11));
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t3 = sd[2] * sd[2];
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], -(sd[1] * sd[2]));
        double _t10 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t3), 1.0));
            dd[2] = 0.0;
            dd[1] = _buf0;
        } else {
            double _buf0 = Math.atan2(_t8, _t10);
            dd[2] = Math.atan2(2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t3), 1.0));
            dd[1] = _buf0;
        }
        dd[0] = Math.atan2(_t9, Math.sqrt(_t12));
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            dd[1] = Math.atan2(2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], -(sd[1] * sd[2])), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0));
            dd[1] = Math.atan2(_t8, _t9);
            dd[0] = _buf0;
        }
        dd[2] = Math.atan2(_t7, Math.sqrt(_t11));
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t1 = sd[2] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t8 = 2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            dd[2] = Math.atan2(2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0, Math.fma(sd[1], sd[1], _t1), 1.0));
            dd[1] = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[2] = Math.atan2(_t8, _t9);
            dd[1] = _buf0;
        }
        dd[0] = Math.atan2(_t7, Math.sqrt(_t11));
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t0 = sd[2] * sd[2];
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            double _buf0 = 0.0;
            dd[2] = Math.atan2(2.0 * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0, Math.fma(sd[0], sd[0], _t0), 1.0));
            dd[0] = _buf0;
        } else {
            double _buf0 = Math.atan2(2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]), Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0));
            dd[2] = Math.atan2(_t7, _t9);
            dd[0] = _buf0;
        }
        dd[1] = Math.atan2(_t8, Math.sqrt(_t11));
        return dest;
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
        double[] sd = this.data;
        double[] angularVelData = ((Double3Impl) angularVel).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * dt;
        double _t1 = angularVelData[2] * _t0;
        double _t2 = angularVelData[0] * _t0;
        double _t3 = angularVelData[1] * _t0;
        double _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        double _t7 = Math.sqrt(_t6);
        double _t9 = Math.sin(_t7);
        double _t10 = Math.cosFromSin(_t9, _t7);
        double _t11 = _t9 / _t7;
        double _t15, _t16, _t17;
        if (_t6 > 0.0) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        double _buf0 = Math.fma(sd[0], _t10, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        double _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t10, -(sd[2] * _t15));
        double _buf2 = Math.fma(sd[1], _t15, sd[2] * _t10) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(sd[3], _t10, -(sd[0] * _t15)) - Math.fma(sd[1], _t16, sd[2] * _t17);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * dt;
        double _t1 = angularVelZ * _t0;
        double _t2 = angularVelX * _t0;
        double _t3 = angularVelY * _t0;
        double _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        double _t7 = Math.sqrt(_t6);
        double _t9 = Math.sin(_t7);
        double _t10 = Math.cosFromSin(_t9, _t7);
        double _t11 = _t9 / _t7;
        double _t15, _t16, _t17;
        if (_t6 > 0.0) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        double _buf0 = Math.fma(sd[0], _t10, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        double _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t10, -(sd[2] * _t15));
        double _buf2 = Math.fma(sd[1], _t15, sd[2] * _t10) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(sd[3], _t10, -(sd[0] * _t15)) - Math.fma(sd[1], _t16, sd[2] * _t17);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = -(_t12 * _t16);
            dd[1] = -(_t10 * _t16);
            dd[2] = -(_t9 * _t16);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = -(_t9 * _t16);
            dd[1] = -(_t12 * _t16);
            dd[2] = -(_t10 * _t16);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = -(_t10 * _t16);
            dd[1] = -(_t9 * _t16);
            dd[2] = -(_t12 * _t16);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = Math.fma(2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), -1.0);
        double _buf1 = -(2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3])));
        dd[2] = -(2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = -(2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]));
        double _buf1 = Math.fma(2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), -1.0);
        dd[2] = -(2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = -(2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3])));
        double _buf1 = -(2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]));
        dd[2] = Math.fma(2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), -1.0);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = Math.fma(-2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0);
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        dd[2] = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _buf1 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0);
        dd[2] = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _buf1 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[2] = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = _t12 * _t16;
            dd[1] = _t10 * _t16;
            dd[2] = _t9 * _t16;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = _t9 * _t16;
            dd[1] = _t12 * _t16;
            dd[2] = _t10 * _t16;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = _t10 * _t16;
            dd[1] = _t9 * _t16;
            dd[2] = _t12 * _t16;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        return Math.sqrt(Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]))));
    }


    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    public double lengthSquared() {
        double[] sd = this.data;
        return Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        var _col0 = (_t2 > 0.0 ? DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.atan2(Math.sqrt(_t2), sd[3]) * (1.0 / Math.sqrt(_t2)))).withLane(3, Math.log(Math.sqrt(Math.fma(sd[3], sd[3], _t2)))) : DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.log(Math.sqrt(Math.fma(sd[3], sd[3], _t2)))));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = -(_t12 * _t16);
            dd[1] = -(_t9 * _t16);
            dd[2] = -(_t10 * _t16);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = -(_t10 * _t16);
            dd[1] = -(_t12 * _t16);
            dd[2] = -(_t9 * _t16);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = -(_t9 * _t16);
            dd[1] = -(_t10 * _t16);
            dd[2] = -(_t12 * _t16);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        double _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t3 != 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t3)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = Math.fma(2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), -1.0);
        double _buf1 = -(2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]));
        dd[2] = -(2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = -(2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3])));
        double _buf1 = Math.fma(2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), -1.0);
        dd[2] = -(2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = -(2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]));
        double _buf1 = -(2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3])));
        dd[2] = Math.fma(2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), -1.0);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = Math.fma(-2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0);
        double _buf1 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        dd[2] = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _buf1 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0);
        dd[2] = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _buf0 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _buf1 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[2] = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = _t12 * _t16;
            dd[1] = _t9 * _t16;
            dd[2] = _t10 * _t16;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t10 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = _t10 * _t16;
            dd[1] = _t12 * _t16;
            dd[2] = _t9 * _t16;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t10 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 != 0.0) {
            dd[0] = _t9 * _t16;
            dd[1] = _t10 * _t16;
            dd[2] = _t12 * _t16;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _r0 = sd[2];
        double _r1 = sd[0];
        double _r2 = sd[1];
        double _r3 = sd[3];
        double _t2 = Math.fma(_r0, _r0, Math.fma(_r1, _r1, _r2 * _r2));
        double _t10 = Math.exp(t * Math.log(Math.sqrt(Math.fma(_r3, _r3, _t2))));
        double _t11 = Math.atan2(Math.sqrt(_t2), _r3) * (1.0 / Math.sqrt(_t2));
        double _t18 = t * (_t2 > 0.0 ? _r0 * _t11 : 0.0);
        double _t19 = t * (_t2 > 0.0 ? _r1 * _t11 : 0.0);
        double _t20 = t * (_t2 > 0.0 ? _r2 * _t11 : 0.0);
        double _t23 = Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20));
        double _t24 = Math.sqrt(_t23);
        double _t26 = Math.sin(_t24);
        pow_s74ed0648_tail(dd, _t10, _t18, _t19, _t20, _t23, _t24, _t26);
        return dest;
    }

    /** Private vector tail of {@code pow_s74ed0648}: loads, computes and stores every column; reached only through it. */
    private static void pow_s74ed0648_tail(double[] dd, double _t10, double _t18, double _t19, double _t20, double _t23, double _t24, double _t26) {
        var _col0 = (_t23 > 0.0 ? DoubleVector.zero(COL_SPECIES).withLane(0, _t19).withLane(1, _t20).withLane(2, _t18).withLane(3, Math.cosFromSin(_t26, _t24)).mul(DoubleVector.broadcast(COL_SPECIES, _t26 * _t10 * (1.0 / Math.sqrt(_t23))).withLane(3, _t10)) : DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cosFromSin(_t26, _t24) * _t10));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return rotateTowards_fma(target, step, dest);
        return rotateTowards_mulAdd(target, step, dest);
    }

    private DoubleQuat rotateTowards_fma(DoubleQuatR target, double step, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0 ? _sv0.fma(DoubleVector.broadcast(COL_SPECIES, Math.sin((1.0 - (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0)) * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))), DoubleVector.broadcast(COL_SPECIES, Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) * (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0))).mul(_sv2)).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : _sv0.fma(DoubleVector.broadcast(COL_SPECIES, 1.0 - (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0)), _sv2.mul(DoubleVector.broadcast(COL_SPECIES, 4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0))));
        double _t72 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t72 != 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t72)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat rotateTowards_mulAdd(DoubleQuatR target, double step, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin((1.0 - (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0)) * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))).add(DoubleVector.broadcast(COL_SPECIES, Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) * (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0))).mul(_sv2)).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : _sv0.mul(DoubleVector.broadcast(COL_SPECIES, 1.0 - (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0))).add(_sv2.mul(DoubleVector.broadcast(COL_SPECIES, 4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))) > 0.0 ? Math.min(1.0, step / (4.0 * Math.atan2(Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])))))), Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? -targetData[1] : targetData[1]))))))))) : 0.0))));
        double _t72 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t72 != 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t72)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t7 = Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        double _t9 = -_t7;
        double _t11 = Math.acos(Math.min(1.0, Math.abs(_t7)));
        double _t12 = Math.sin(_t11);
        double _t12_inv = 1.0 / _t12;
        double _t13, _t14, _t15, _t16;
        if (_t9 > 0.0) {
            _t13 = -targetW;
            _t14 = -targetZ;
            _t15 = -targetX;
            _t16 = -targetY;
        } else {
            _t13 = targetW;
            _t14 = targetZ;
            _t15 = targetX;
            _t16 = targetY;
        }
        double _t17 = sd[3] - _t13;
        double _t18 = sd[2] - _t14;
        double _t19 = sd[0] - _t15;
        double _t20 = sd[1] - _t16;
        double _t21 = sd[3] + _t13;
        double _t22 = sd[2] + _t14;
        double _t23 = sd[0] + _t15;
        double _t24 = sd[1] + _t16;
        double _t36 = 4.0 * Math.atan2(Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))), Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24)))));
        double _t39 = _t36 > 0.0 ? Math.min(1.0, step / _t36) : 0.0;
        double _t40 = 1.0 - _t39;
        double _t42 = Math.sin(_t11 * _t39);
        double _t44 = Math.sin(_t40 * _t11);
        double _t65, _t66, _t67, _t68;
        if (_t12 > 0.0) {
            _t65 = Math.fma(sd[3], _t44, _t42 * _t13) * _t12_inv;
            _t66 = Math.fma(sd[2], _t44, _t42 * _t14) * _t12_inv;
            _t67 = Math.fma(sd[0], _t44, _t42 * _t15) * _t12_inv;
            _t68 = Math.fma(sd[1], _t44, _t42 * _t16) * _t12_inv;
        } else {
            _t65 = Math.fma(sd[3], _t40, _t13 * _t39);
            _t66 = Math.fma(sd[2], _t40, _t14 * _t39);
            _t67 = Math.fma(sd[0], _t40, _t15 * _t39);
            _t68 = Math.fma(sd[1], _t40, _t16 * _t39);
        }
        double _t72 = Math.fma(_t65, _t65, Math.fma(_t66, _t66, Math.fma(_t67, _t67, _t68 * _t68)));
        double _t73 = (1.0 / Math.sqrt(_t72));
        if (_t72 != 0.0) {
            dd[0] = _t73 * _t67;
            dd[1] = _t73 * _t68;
            dd[2] = _t73 * _t66;
            dd[3] = _t73 * _t65;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
            dd[3] = 0.0;
        }
        return dest;
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
        double[] sd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t1 = -dirData[2];
        double _t5 = (1.0 / Math.sqrt(Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]))));
        double _t6 = dirData[2] * _t5;
        double _t7 = dirData[1] * _t5;
        double _t8 = dirData[0] * _t5;
        double _t9 = -_t8;
        double _t11 = -_t6;
        double _t19 = Math.fma(upData[1], _t6, -(upData[2] * _t7));
        double _t20 = Math.fma(upData[0], _t7, -(upData[1] * _t8));
        double _t21 = Math.fma(upData[2], _t8, -(upData[0] * _t6));
        double _ct0 = Math.fma(_t20, _t20, Math.fma(_t19, _t19, _t21 * _t21));
        if (!(_ct0 > 0.0)) return lookAlong_degenerate(dir, up, dest);
        double _t27 = (1.0 / Math.sqrt(_ct0));
        double _t28 = _t19 * _t27;
        double _t29 = _t20 * _t27;
        double _t30 = _t21 * _t27;
        double _t32 = Math.fma(-_t19, _t27, 1.0);
        double _t33 = Math.fma(dirData[0], _t5, _t29);
        double _t37 = Math.fma(dirData[0], _t5, -_t29);
        double _t45 = Math.fma(_t6, _t28, -(_t8 * _t29));
        double _t47 = Math.fma(_t8, _t30, -(_t7 * _t28));
        double _t48 = Math.fma(_t7, _t29, -(_t6 * _t30));
        double _t51 = Math.fma(dirData[1], _t5, _t47);
        double _t52 = Math.max(_t45, _t6);
        double _t53 = Math.fma(-dirData[1], _t5, _t47);
        double _t56 = Math.fma(_t21, _t27, _t48);
        double _t57 = Math.fma(_t21, _t27, -_t48);
        double _t59 = Math.fma(dirData[2], _t5, Math.fma(_t19, _t27, _t45));
        double _t60 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t19, _t27, Math.fma(dirData[2], _t5, 1.0))));
        double _t62 = Math.fma(_t19, _t27, Math.fma(_t11, _t28, Math.fma(_t8, _t29, Math.fma(_t1, _t5, 1.0))));
        double _t63 = Math.fma(dirData[2], _t5, Math.fma(_t11, _t28, Math.fma(_t8, _t29, _t32)));
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t60));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t62));
        double _t66 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t1, _t5, _t32)));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t63));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t66));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = _sp0 * _t53;
            _t109 = _sp0 * _t57;
            _t110 = _sp0 * _t37;
            _t111 = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t28 > _t52) {
                _t108 = 0.5 * Math.sqrt(_t62);
                _t109 = _sp3 * _t33;
                _t110 = _sp3 * _t56;
                _t111 = _sp3 * _t53;
            } else {
                if (_t45 > _t6) {
                    _t108 = _sp1 * _t56;
                    _t109 = _sp1 * _t51;
                    _t110 = 0.5 * Math.sqrt(_t66);
                    _t111 = _sp1 * _t37;
                } else {
                    _t108 = _sp2 * _t33;
                    _t109 = 0.5 * Math.sqrt(_t63);
                    _t110 = _sp2 * _t51;
                    _t111 = _sp2 * _t57;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t111, sd[3] * _t108) + Math.fma(sd[1], _t109, -(sd[2] * _t110));
        double _buf1 = Math.fma(sd[1], _t111, sd[2] * _t108) + Math.fma(sd[3], _t110, -(sd[0] * _t109));
        double _buf2 = Math.fma(sd[0], _t110, sd[3] * _t109) + Math.fma(sd[2], _t111, -(sd[1] * _t108));
        dd[3] = Math.fma(sd[3], _t111, -(sd[0] * _t108)) - Math.fma(sd[1], _t110, sd[2] * _t109);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t1 = -dirZ;
        double _t5 = (1.0 / Math.sqrt(Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY))));
        double _t6 = dirZ * _t5;
        double _t7 = dirY * _t5;
        double _t8 = dirX * _t5;
        double _t9 = -_t8;
        double _t11 = -_t6;
        double _t19 = Math.fma(upY, _t6, -(upZ * _t7));
        double _t20 = Math.fma(upX, _t7, -(upY * _t8));
        double _t21 = Math.fma(upZ, _t8, -(upX * _t6));
        double _ct0 = Math.fma(_t20, _t20, Math.fma(_t19, _t19, _t21 * _t21));
        if (!(_ct0 > 0.0)) return lookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ, dest);
        double _t27 = (1.0 / Math.sqrt(_ct0));
        double _t28 = _t19 * _t27;
        double _t29 = _t20 * _t27;
        double _t30 = _t21 * _t27;
        double _t32 = Math.fma(-_t19, _t27, 1.0);
        double _t33 = Math.fma(dirX, _t5, _t29);
        double _t37 = Math.fma(dirX, _t5, -_t29);
        double _t45 = Math.fma(_t6, _t28, -(_t8 * _t29));
        double _t47 = Math.fma(_t8, _t30, -(_t7 * _t28));
        double _t48 = Math.fma(_t7, _t29, -(_t6 * _t30));
        double _t51 = Math.fma(dirY, _t5, _t47);
        double _t52 = Math.max(_t45, _t6);
        double _t53 = Math.fma(-dirY, _t5, _t47);
        double _t56 = Math.fma(_t21, _t27, _t48);
        double _t57 = Math.fma(_t21, _t27, -_t48);
        double _t59 = Math.fma(dirZ, _t5, Math.fma(_t19, _t27, _t45));
        double _t60 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t19, _t27, Math.fma(dirZ, _t5, 1.0))));
        double _t62 = Math.fma(_t19, _t27, Math.fma(_t11, _t28, Math.fma(_t8, _t29, Math.fma(_t1, _t5, 1.0))));
        double _t63 = Math.fma(dirZ, _t5, Math.fma(_t11, _t28, Math.fma(_t8, _t29, _t32)));
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t60));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t62));
        double _t66 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t1, _t5, _t32)));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t63));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t66));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = _sp0 * _t53;
            _t109 = _sp0 * _t57;
            _t110 = _sp0 * _t37;
            _t111 = 0.5 * Math.sqrt(_t60);
        } else {
            if (_t28 > _t52) {
                _t108 = 0.5 * Math.sqrt(_t62);
                _t109 = _sp3 * _t33;
                _t110 = _sp3 * _t56;
                _t111 = _sp3 * _t53;
            } else {
                if (_t45 > _t6) {
                    _t108 = _sp1 * _t56;
                    _t109 = _sp1 * _t51;
                    _t110 = 0.5 * Math.sqrt(_t66);
                    _t111 = _sp1 * _t37;
                } else {
                    _t108 = _sp2 * _t33;
                    _t109 = 0.5 * Math.sqrt(_t63);
                    _t110 = _sp2 * _t51;
                    _t111 = _sp2 * _t57;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t111, sd[3] * _t108) + Math.fma(sd[1], _t109, -(sd[2] * _t110));
        double _buf1 = Math.fma(sd[1], _t111, sd[2] * _t108) + Math.fma(sd[3], _t110, -(sd[0] * _t109));
        double _buf2 = Math.fma(sd[0], _t110, sd[3] * _t109) + Math.fma(sd[2], _t111, -(sd[1] * _t108));
        dd[3] = Math.fma(sd[3], _t111, -(sd[0] * _t108)) - Math.fma(sd[1], _t110, sd[2] * _t109);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private DoubleQuat lookAlong_degenerate(Double3R dir, Double3R up, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9, _t10, _t11, _t12;
        if (_t2 == 0.0) {
            _t7 = 0.0;
            _t8 = 1.0;
            _t9 = 0.0;
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 1.0;
        } else {
            _t7 = upData[0];
            _t8 = upData[1];
            _t9 = upData[2];
            _t10 = dirData[1] * _t3;
            _t11 = dirData[0] * _t3;
            _t12 = dirData[2] * _t3;
        }
        double _t13 = Math.abs(_t11);
        double _t14 = Math.abs(_t12);
        double _t15 = -_t10;
        double _t17 = 1.0 + _t12;
        double _t18 = 1.0 - _t12;
        double _t25, _t26, _t30;
        if (_t13 > _t14) {
            _t25 = 0.0;
            _t26 = _t15;
            _t30 = _t11;
        } else {
            _t25 = _t10;
            _t26 = 0.0;
            _t30 = -_t12;
        }
        double _t27 = Math.fma(_t7, _t10, -(_t11 * _t8));
        double _t28 = Math.fma(_t9, _t11, -(_t7 * _t12));
        double _t29 = Math.fma(_t8, _t12, -(_t9 * _t10));
        double _t35 = Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29));
        double _t37, _t38, _t39, _t41;
        if (_t35 == 0.0) {
            _t37 = _t25;
            _t38 = _t26;
            _t39 = _t30;
            _t41 = (1.0 / Math.sqrt(Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t30 * _t30))));
        } else {
            _t37 = _t27;
            _t38 = _t29;
            _t39 = _t28;
            _t41 = (1.0 / Math.sqrt(_t35));
        }
        double _t42 = -_t41;
        double _t43 = _t41 * _t37;
        double _t44 = _t41 * _t38;
        double _t45 = -_t43;
        double _t46 = -_t44;
        double _t47 = _t41 * _t39;
        double _t48 = Math.fma(_t41, _t37, _t11);
        double _t51 = Math.fma(_t42, _t37, _t11);
        double _t62 = Math.fma(_t44, _t12, -(_t43 * _t11));
        double _t66 = Math.fma(_t43, _t10, -(_t47 * _t12));
        double _t68 = Math.max(_t62, _t12);
        double _t70 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t10));
        double _t71 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t15));
        double _t72 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t12)));
        double _t73 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t17)));
        double _t74 = Math.fma(_t41, _t38, Math.fma(_t46, _t12, Math.fma(_t43, _t11, _t18)));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t74));
        double _t77 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t42, _t38, _t18)));
        double _t78 = Math.fma(_t46, _t12, Math.fma(_t43, _t11, Math.fma(_t42, _t38, _t17)));
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t73));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t77));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t78));
        double _t89 = Math.fma(_t41, _t39, _t66);
        double _t90 = Math.fma(_t41, _t39, -_t66);
        double _t123, _t124, _t125, _t126;
        if (_t72 > 0.0) {
            _t123 = _sp0 * _t71;
            _t124 = _sp0 * _t90;
            _t125 = _sp0 * _t51;
            _t126 = 0.5 * Math.sqrt(_t73);
        } else {
            if (_t44 > _t68) {
                _t123 = 0.5 * Math.sqrt(_t74);
                _t124 = _sp3 * _t48;
                _t125 = _sp3 * _t89;
                _t126 = _sp3 * _t71;
            } else {
                if (_t62 > _t12) {
                    _t123 = _sp1 * _t89;
                    _t124 = _sp1 * _t70;
                    _t125 = 0.5 * Math.sqrt(_t77);
                    _t126 = _sp1 * _t51;
                } else {
                    _t123 = _sp2 * _t48;
                    _t124 = 0.5 * Math.sqrt(_t78);
                    _t125 = _sp2 * _t70;
                    _t126 = _sp2 * _t90;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t126, sd[3] * _t123) + Math.fma(sd[1], _t124, -(sd[2] * _t125));
        double _buf1 = Math.fma(sd[1], _t126, sd[2] * _t123) + Math.fma(sd[3], _t125, -(sd[0] * _t124));
        double _buf2 = Math.fma(sd[0], _t125, sd[3] * _t124) + Math.fma(sd[2], _t126, -(sd[1] * _t123));
        dd[3] = Math.fma(sd[3], _t126, -(sd[0] * _t123)) - Math.fma(sd[1], _t125, sd[2] * _t124);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    @Mutated private DoubleQuat lookAlong_degenerate(Double3R dir, Double3R up) {
        return lookAlong_degenerate(dir, up, Joml.RETURN_NEW ? Joml.doubleQuat() : this);
    }


    /**
     * Degenerate-input path of {@code lookAlong}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private DoubleQuat lookAlong_degenerate(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9, _t10, _t11, _t12;
        if (_t2 == 0.0) {
            _t7 = 0.0;
            _t8 = 1.0;
            _t9 = 0.0;
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 1.0;
        } else {
            _t7 = upX;
            _t8 = upY;
            _t9 = upZ;
            _t10 = dirY * _t3;
            _t11 = dirX * _t3;
            _t12 = dirZ * _t3;
        }
        double _t13 = Math.abs(_t11);
        double _t14 = Math.abs(_t12);
        double _t15 = -_t10;
        double _t17 = 1.0 + _t12;
        double _t18 = 1.0 - _t12;
        double _t25, _t26, _t30;
        if (_t13 > _t14) {
            _t25 = 0.0;
            _t26 = _t15;
            _t30 = _t11;
        } else {
            _t25 = _t10;
            _t26 = 0.0;
            _t30 = -_t12;
        }
        double _t27 = Math.fma(_t7, _t10, -(_t11 * _t8));
        double _t28 = Math.fma(_t9, _t11, -(_t7 * _t12));
        double _t29 = Math.fma(_t8, _t12, -(_t9 * _t10));
        double _t35 = Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29));
        double _t37, _t38, _t39, _t41;
        if (_t35 == 0.0) {
            _t37 = _t25;
            _t38 = _t26;
            _t39 = _t30;
            _t41 = (1.0 / Math.sqrt(Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t30 * _t30))));
        } else {
            _t37 = _t27;
            _t38 = _t29;
            _t39 = _t28;
            _t41 = (1.0 / Math.sqrt(_t35));
        }
        double _t42 = -_t41;
        double _t43 = _t41 * _t37;
        double _t44 = _t41 * _t38;
        double _t45 = -_t43;
        double _t46 = -_t44;
        double _t47 = _t41 * _t39;
        double _t48 = Math.fma(_t41, _t37, _t11);
        double _t51 = Math.fma(_t42, _t37, _t11);
        double _t62 = Math.fma(_t44, _t12, -(_t43 * _t11));
        double _t66 = Math.fma(_t43, _t10, -(_t47 * _t12));
        double _t68 = Math.max(_t62, _t12);
        double _t70 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t10));
        double _t71 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t15));
        double _t72 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t12)));
        double _t73 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t17)));
        double _t74 = Math.fma(_t41, _t38, Math.fma(_t46, _t12, Math.fma(_t43, _t11, _t18)));
        double _sp3 = 0.5 * (1.0 / Math.sqrt(_t74));
        double _t77 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t42, _t38, _t18)));
        double _t78 = Math.fma(_t46, _t12, Math.fma(_t43, _t11, Math.fma(_t42, _t38, _t17)));
        double _sp0 = 0.5 * (1.0 / Math.sqrt(_t73));
        double _sp1 = 0.5 * (1.0 / Math.sqrt(_t77));
        double _sp2 = 0.5 * (1.0 / Math.sqrt(_t78));
        double _t89 = Math.fma(_t41, _t39, _t66);
        double _t90 = Math.fma(_t41, _t39, -_t66);
        double _t123, _t124, _t125, _t126;
        if (_t72 > 0.0) {
            _t123 = _sp0 * _t71;
            _t124 = _sp0 * _t90;
            _t125 = _sp0 * _t51;
            _t126 = 0.5 * Math.sqrt(_t73);
        } else {
            if (_t44 > _t68) {
                _t123 = 0.5 * Math.sqrt(_t74);
                _t124 = _sp3 * _t48;
                _t125 = _sp3 * _t89;
                _t126 = _sp3 * _t71;
            } else {
                if (_t62 > _t12) {
                    _t123 = _sp1 * _t89;
                    _t124 = _sp1 * _t70;
                    _t125 = 0.5 * Math.sqrt(_t77);
                    _t126 = _sp1 * _t51;
                } else {
                    _t123 = _sp2 * _t48;
                    _t124 = 0.5 * Math.sqrt(_t78);
                    _t125 = _sp2 * _t70;
                    _t126 = _sp2 * _t90;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t126, sd[3] * _t123) + Math.fma(sd[1], _t124, -(sd[2] * _t125));
        double _buf1 = Math.fma(sd[1], _t126, sd[2] * _t123) + Math.fma(sd[3], _t125, -(sd[0] * _t124));
        double _buf2 = Math.fma(sd[0], _t125, sd[3] * _t124) + Math.fma(sd[2], _t126, -(sd[1] * _t123));
        dd[3] = Math.fma(sd[3], _t126, -(sd[0] * _t123)) - Math.fma(sd[1], _t125, sd[2] * _t124);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
    @Mutated public DoubleQuat makeRotationAxis(double angle, Double3R axis) {
        if (axis.y() == 0 && axis.z() == 0 && Math.abs(axis.x()) == 1) return makeRotationX(axis.x() * angle);
        if (axis.x() == 0 && axis.z() == 0 && Math.abs(axis.y()) == 1) return makeRotationY(axis.y() * angle);
        if (axis.x() == 0 && axis.y() == 0 && Math.abs(axis.z()) == 1) return makeRotationZ(axis.z() * angle);
        if (SimdMath.USE_FMA) return makeRotationAxis_fma(angle, axis);
        return makeRotationAxis_mulAdd(angle, axis);
    }

    private DoubleQuat makeRotationAxis_fma(double angle, Double3R axis) {
        double[] dd = this.data;
        double[] axisData = ((Double3Impl) axis).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, axisData[0]).withLane(1, axisData[1]).withLane(2, axisData[2]).fma(DoubleVector.broadcast(COL_SPECIES, _t1), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cosFromSin(_t1, _t0)));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationAxis_mulAdd(double angle, Double3R axis) {
        double[] dd = this.data;
        double[] axisData = ((Double3Impl) axis).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, axisData[0]).withLane(1, axisData[1]).withLane(2, axisData[2]).mul(DoubleVector.broadcast(COL_SPECIES, _t1)).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cosFromSin(_t1, _t0)));
        _col0.intoArray(dd, 0);
        return this;
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
        if (SimdMath.USE_FMA) return makeRotationAxis_fma(angle, axisX, axisY, axisZ);
        return makeRotationAxis_mulAdd(angle, axisX, axisY, axisZ);
    }

    private DoubleQuat makeRotationAxis_fma(double angle, double axisX, double axisY, double axisZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).fma(DoubleVector.broadcast(COL_SPECIES, _t1), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cosFromSin(_t1, _t0)));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationAxis_mulAdd(double angle, double axisX, double axisY, double axisZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(DoubleVector.broadcast(COL_SPECIES, _t1)).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cosFromSin(_t1, _t0)));
        _col0.intoArray(dd, 0);
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
    @Mutated public DoubleQuat makeRotationLookAlong(Double3R dir, Double3R up) {
        if (SimdMath.USE_FMA) return makeRotationLookAlong_fma(dir, up);
        return makeRotationLookAlong_mulAdd(dir, up);
    }

    private DoubleQuat makeRotationLookAlong_fma(Double3R dir, Double3R up) {
        double[] dd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double _r0 = dirData[2];
        double _r1 = dirData[0];
        double _r2 = dirData[1];
        double _r3 = upData[1];
        double _r4 = upData[2];
        double _r5 = upData[0];
        double _t5 = (1.0 / Math.sqrt(Math.fma(_r0, _r0, Math.fma(_r1, _r1, _r2 * _r2))));
        double _t6 = _r0 * _t5;
        double _t7 = _r2 * _t5;
        double _t8 = _r1 * _t5;
        double _t19 = Math.fma(_r3, _t6, -(_r4 * _t7));
        double _t20 = Math.fma(_r5, _t7, -(_r3 * _t8));
        double _t21 = Math.fma(_r4, _t8, -(_r5 * _t6));
        double _ct0 = Math.fma(_t20, _t20, Math.fma(_t19, _t19, _t21 * _t21));
        if (!(_ct0 > 0.0)) return makeRotationLookAlong_degenerate(dir, up);
        double _t27 = (1.0 / Math.sqrt(_ct0));
        double _t1 = -_r0;
        double _t9 = -_t8;
        double _t11 = -_t6;
        double _t28 = _t19 * _t27;
        double _t29 = _t20 * _t27;
        double _t30 = _t21 * _t27;
        double _t32 = Math.fma(-_t19, _t27, 1.0);
        double _t33 = Math.fma(_r1, _t5, _t29);
        makeRotationLookAlong_s9a33d91_tail(dd, _r0, _r1, _r2, _t5, _t6, _t7, _t8, _t19, _t21, _t27, _t1, _t9, _t11, _t28, _t29, _t30, _t32, _t33);
        return this;
    }

    private DoubleQuat makeRotationLookAlong_mulAdd(Double3R dir, Double3R up) {
        double[] dd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double _r0 = dirData[2];
        double _r1 = dirData[0];
        double _r2 = dirData[1];
        double _r3 = upData[1];
        double _r4 = upData[2];
        double _r5 = upData[0];
        double _t5 = (1.0 / Math.sqrt(Math.fma(_r0, _r0, Math.fma(_r1, _r1, _r2 * _r2))));
        double _t6 = _r0 * _t5;
        double _t7 = _r2 * _t5;
        double _t8 = _r1 * _t5;
        double _t19 = Math.fma(_r3, _t6, -(_r4 * _t7));
        double _t20 = Math.fma(_r5, _t7, -(_r3 * _t8));
        double _t21 = Math.fma(_r4, _t8, -(_r5 * _t6));
        double _ct1 = Math.fma(_t20, _t20, Math.fma(_t19, _t19, _t21 * _t21));
        if (!(_ct1 > 0.0)) return makeRotationLookAlong_degenerate(dir, up);
        double _t27 = (1.0 / Math.sqrt(_ct1));
        double _t1 = -_r0;
        double _t9 = -_t8;
        double _t11 = -_t6;
        double _t28 = _t19 * _t27;
        double _t29 = _t20 * _t27;
        double _t30 = _t21 * _t27;
        double _t32 = Math.fma(-_t19, _t27, 1.0);
        double _t33 = Math.fma(_r1, _t5, _t29);
        makeRotationLookAlong_s17e235c6_tail(dd, _r0, _r1, _r2, _t5, _t6, _t7, _t8, _t19, _t21, _t27, _t1, _t9, _t11, _t28, _t29, _t30, _t32, _t33);
        return this;
    }

    /** Private vector tail of {@code makeRotationLookAlong_s9a33d91}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_s9a33d91_tail2(double[] dd, double _r0, double _t5, double _t6, double _t19, double _t27, double _t28, double _t33, double _t38, double _t45, double _t51, double _t52, double _t56, double _t57, double _t60, double _t62, double _t63, double _t64, double _t66) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_r0, _t5, Math.fma(_t19, _t27, _t45)) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t52).withLane(1, _t38).withLane(2, _t57).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t60)))) : (_t28 > Math.max(_t45, _t6) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t62)).withLane(1, _t56 * _t66).withLane(2, _t33 * _t66).withLane(3, _t52 * _t66)) : (_t45 > _t6 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t56).withLane(2, _t51).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t64)))).withLane(1, Math.sqrt(_t64))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t33).withLane(1, _t51).withLane(3, _t57).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_s9a33d91}; reached only through it. */
    private static void makeRotationLookAlong_s9a33d91_tail(double[] dd, double _r0, double _r1, double _r2, double _t5, double _t6, double _t7, double _t8, double _t19, double _t21, double _t27, double _t1, double _t9, double _t11, double _t28, double _t29, double _t30, double _t32, double _t33) {
        double _t38 = Math.fma(_r1, _t5, -_t29);
        double _t45 = Math.fma(_t6, _t28, -(_t8 * _t29));
        double _t46 = Math.fma(_t8, _t30, -(_t7 * _t28));
        double _t48 = Math.fma(_t7, _t29, -(_t6 * _t30));
        double _t51 = Math.fma(_r2, _t5, _t46);
        double _t52 = Math.fma(-_r2, _t5, _t46);
        double _t56 = Math.fma(_t21, _t27, _t48);
        double _t57 = Math.fma(_t21, _t27, -_t48);
        double _t60 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t19, _t27, Math.fma(_r0, _t5, 1.0))));
        double _t62 = Math.fma(_t19, _t27, Math.fma(_t11, _t28, Math.fma(_t8, _t29, Math.fma(_t1, _t5, 1.0))));
        double _t63 = Math.fma(_r0, _t5, Math.fma(_t11, _t28, Math.fma(_t8, _t29, _t32)));
        double _t64 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t1, _t5, _t32)));
        double _t66 = (1.0 / Math.sqrt(_t62));
        makeRotationLookAlong_s9a33d91_tail2(dd, _r0, _t5, _t6, _t19, _t27, _t28, _t33, _t38, _t45, _t51, _t52, _t56, _t57, _t60, _t62, _t63, _t64, _t66);
    }

    /** Private vector tail of {@code makeRotationLookAlong_s17e235c6}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_s17e235c6_tail2(double[] dd, double _r0, double _t5, double _t6, double _t19, double _t27, double _t28, double _t33, double _t38, double _t45, double _t51, double _t52, double _t56, double _t57, double _t60, double _t62, double _t63, double _t64, double _t66) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_r0, _t5, Math.fma(_t19, _t27, _t45)) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t52).withLane(1, _t38).withLane(2, _t57).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t60)))) : (_t28 > Math.max(_t45, _t6) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t62)).withLane(1, _t56 * _t66).withLane(2, _t33 * _t66).withLane(3, _t52 * _t66)) : (_t45 > _t6 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t56).withLane(2, _t51).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t64)))).withLane(1, Math.sqrt(_t64))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t33).withLane(1, _t51).withLane(3, _t57).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_s17e235c6}; reached only through it. */
    private static void makeRotationLookAlong_s17e235c6_tail(double[] dd, double _r0, double _r1, double _r2, double _t5, double _t6, double _t7, double _t8, double _t19, double _t21, double _t27, double _t1, double _t9, double _t11, double _t28, double _t29, double _t30, double _t32, double _t33) {
        double _t38 = Math.fma(_r1, _t5, -_t29);
        double _t45 = Math.fma(_t6, _t28, -(_t8 * _t29));
        double _t46 = Math.fma(_t8, _t30, -(_t7 * _t28));
        double _t48 = Math.fma(_t7, _t29, -(_t6 * _t30));
        double _t51 = Math.fma(_r2, _t5, _t46);
        double _t52 = Math.fma(-_r2, _t5, _t46);
        double _t56 = Math.fma(_t21, _t27, _t48);
        double _t57 = Math.fma(_t21, _t27, -_t48);
        double _t60 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t19, _t27, Math.fma(_r0, _t5, 1.0))));
        double _t62 = Math.fma(_t19, _t27, Math.fma(_t11, _t28, Math.fma(_t8, _t29, Math.fma(_t1, _t5, 1.0))));
        double _t63 = Math.fma(_r0, _t5, Math.fma(_t11, _t28, Math.fma(_t8, _t29, _t32)));
        double _t64 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t1, _t5, _t32)));
        double _t66 = (1.0 / Math.sqrt(_t62));
        makeRotationLookAlong_s17e235c6_tail2(dd, _r0, _t5, _t6, _t19, _t27, _t28, _t33, _t38, _t45, _t51, _t52, _t56, _t57, _t60, _t62, _t63, _t64, _t66);
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
        if (SimdMath.USE_FMA) return makeRotationLookAlong_fma(dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_mulAdd(dirX, dirY, dirZ, upX, upY, upZ);
    }

    private DoubleQuat makeRotationLookAlong_fma(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t5 = (1.0 / Math.sqrt(Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY))));
        double _t6 = dirZ * _t5;
        double _t7 = dirY * _t5;
        double _t8 = dirX * _t5;
        double _t19 = Math.fma(upY, _t6, -(upZ * _t7));
        double _t20 = Math.fma(upX, _t7, -(upY * _t8));
        double _t21 = Math.fma(upZ, _t8, -(upX * _t6));
        double _ct0 = Math.fma(_t20, _t20, Math.fma(_t19, _t19, _t21 * _t21));
        if (!(_ct0 > 0.0)) return makeRotationLookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ);
        double _t27 = (1.0 / Math.sqrt(_ct0));
        double _t1 = -dirZ;
        double _t9 = -_t8;
        double _t11 = -_t6;
        double _t28 = _t19 * _t27;
        double _t29 = _t20 * _t27;
        double _t30 = _t21 * _t27;
        double _t32 = Math.fma(-_t19, _t27, 1.0);
        double _t33 = Math.fma(dirX, _t5, _t29);
        double _t38 = Math.fma(dirX, _t5, -_t29);
        double _t45 = Math.fma(_t6, _t28, -(_t8 * _t29));
        double _t46 = Math.fma(_t8, _t30, -(_t7 * _t28));
        makeRotationLookAlong_s169760fb_tail(dd, _t5, _t6, _t7, _t8, _t19, _t21, _t27, _t1, _t9, _t11, _t28, _t29, _t30, _t32, _t33, _t38, _t45, _t46, dirY, dirZ);
        return this;
    }

    private DoubleQuat makeRotationLookAlong_mulAdd(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t5 = (1.0 / Math.sqrt(Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY))));
        double _t6 = dirZ * _t5;
        double _t7 = dirY * _t5;
        double _t8 = dirX * _t5;
        double _t19 = Math.fma(upY, _t6, -(upZ * _t7));
        double _t20 = Math.fma(upX, _t7, -(upY * _t8));
        double _t21 = Math.fma(upZ, _t8, -(upX * _t6));
        double _ct1 = Math.fma(_t20, _t20, Math.fma(_t19, _t19, _t21 * _t21));
        if (!(_ct1 > 0.0)) return makeRotationLookAlong_degenerate(dirX, dirY, dirZ, upX, upY, upZ);
        double _t27 = (1.0 / Math.sqrt(_ct1));
        double _t1 = -dirZ;
        double _t9 = -_t8;
        double _t11 = -_t6;
        double _t28 = _t19 * _t27;
        double _t29 = _t20 * _t27;
        double _t30 = _t21 * _t27;
        double _t32 = Math.fma(-_t19, _t27, 1.0);
        double _t33 = Math.fma(dirX, _t5, _t29);
        double _t38 = Math.fma(dirX, _t5, -_t29);
        double _t45 = Math.fma(_t6, _t28, -(_t8 * _t29));
        double _t46 = Math.fma(_t8, _t30, -(_t7 * _t28));
        makeRotationLookAlong_s687621c_tail(dd, _t5, _t6, _t7, _t8, _t19, _t21, _t27, _t1, _t9, _t11, _t28, _t29, _t30, _t32, _t33, _t38, _t45, _t46, dirY, dirZ);
        return this;
    }

    /** Private vector tail of {@code makeRotationLookAlong_s169760fb}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_s169760fb_tail2(double[] dd, double _t5, double _t6, double _t19, double _t27, double _t28, double _t33, double _t38, double _t45, double _t51, double _t52, double _t56, double _t57, double _t60, double _t62, double _t63, double _t64, double _t66, double dirZ) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(dirZ, _t5, Math.fma(_t19, _t27, _t45)) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t52).withLane(1, _t38).withLane(2, _t57).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t60)))) : (_t28 > Math.max(_t45, _t6) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t62)).withLane(1, _t56 * _t66).withLane(2, _t33 * _t66).withLane(3, _t52 * _t66)) : (_t45 > _t6 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t56).withLane(2, _t51).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t64)))).withLane(1, Math.sqrt(_t64))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t33).withLane(1, _t51).withLane(3, _t57).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_s169760fb}; reached only through it. */
    private static void makeRotationLookAlong_s169760fb_tail(double[] dd, double _t5, double _t6, double _t7, double _t8, double _t19, double _t21, double _t27, double _t1, double _t9, double _t11, double _t28, double _t29, double _t30, double _t32, double _t33, double _t38, double _t45, double _t46, double dirY, double dirZ) {
        double _t48 = Math.fma(_t7, _t29, -(_t6 * _t30));
        double _t51 = Math.fma(dirY, _t5, _t46);
        double _t52 = Math.fma(-dirY, _t5, _t46);
        double _t56 = Math.fma(_t21, _t27, _t48);
        double _t57 = Math.fma(_t21, _t27, -_t48);
        double _t60 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t19, _t27, Math.fma(dirZ, _t5, 1.0))));
        double _t62 = Math.fma(_t19, _t27, Math.fma(_t11, _t28, Math.fma(_t8, _t29, Math.fma(_t1, _t5, 1.0))));
        double _t63 = Math.fma(dirZ, _t5, Math.fma(_t11, _t28, Math.fma(_t8, _t29, _t32)));
        double _t64 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t1, _t5, _t32)));
        double _t66 = (1.0 / Math.sqrt(_t62));
        makeRotationLookAlong_s169760fb_tail2(dd, _t5, _t6, _t19, _t27, _t28, _t33, _t38, _t45, _t51, _t52, _t56, _t57, _t60, _t62, _t63, _t64, _t66, dirZ);
    }

    /** Private vector tail of {@code makeRotationLookAlong_s687621c}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_s687621c_tail2(double[] dd, double _t5, double _t6, double _t19, double _t27, double _t28, double _t33, double _t38, double _t45, double _t51, double _t52, double _t56, double _t57, double _t60, double _t62, double _t63, double _t64, double _t66, double dirZ) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(dirZ, _t5, Math.fma(_t19, _t27, _t45)) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t52).withLane(1, _t38).withLane(2, _t57).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t60)))) : (_t28 > Math.max(_t45, _t6) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t62)).withLane(1, _t56 * _t66).withLane(2, _t33 * _t66).withLane(3, _t52 * _t66)) : (_t45 > _t6 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t56).withLane(2, _t51).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t64)))).withLane(1, Math.sqrt(_t64))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t33).withLane(1, _t51).withLane(3, _t57).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_s687621c}; reached only through it. */
    private static void makeRotationLookAlong_s687621c_tail(double[] dd, double _t5, double _t6, double _t7, double _t8, double _t19, double _t21, double _t27, double _t1, double _t9, double _t11, double _t28, double _t29, double _t30, double _t32, double _t33, double _t38, double _t45, double _t46, double dirY, double dirZ) {
        double _t48 = Math.fma(_t7, _t29, -(_t6 * _t30));
        double _t51 = Math.fma(dirY, _t5, _t46);
        double _t52 = Math.fma(-dirY, _t5, _t46);
        double _t56 = Math.fma(_t21, _t27, _t48);
        double _t57 = Math.fma(_t21, _t27, -_t48);
        double _t60 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t19, _t27, Math.fma(dirZ, _t5, 1.0))));
        double _t62 = Math.fma(_t19, _t27, Math.fma(_t11, _t28, Math.fma(_t8, _t29, Math.fma(_t1, _t5, 1.0))));
        double _t63 = Math.fma(dirZ, _t5, Math.fma(_t11, _t28, Math.fma(_t8, _t29, _t32)));
        double _t64 = Math.fma(_t6, _t28, Math.fma(_t9, _t29, Math.fma(_t1, _t5, _t32)));
        double _t66 = (1.0 / Math.sqrt(_t62));
        makeRotationLookAlong_s687621c_tail2(dd, _t5, _t6, _t19, _t27, _t28, _t33, _t38, _t45, _t51, _t52, _t56, _t57, _t60, _t62, _t63, _t64, _t66, dirZ);
    }


    /**
     * Degenerate-input path of {@code makeRotationLookAlong}: its methods leave here when their
     * input spans no proper basis (a zero direction, an up vector parallel to it or zero, NaN);
     * reached only through them.
     */
    @Mutated private DoubleQuat makeRotationLookAlong_degenerate(Double3R dir, Double3R up) {
        if (SimdMath.USE_FMA) return makeRotationLookAlong_degenerate_fma(dir, up);
        return makeRotationLookAlong_degenerate_mulAdd(dir, up);
    }

    private DoubleQuat makeRotationLookAlong_degenerate_fma(Double3R dir, Double3R up) {
        double[] dd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double _r0 = dirData[2];
        double _r1 = dirData[0];
        double _r2 = dirData[1];
        double _r3 = upData[0];
        double _r4 = upData[1];
        double _r5 = upData[2];
        double _t2 = Math.fma(_r0, _r0, Math.fma(_r1, _r1, _r2 * _r2));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 == 0.0 ? 0.0 : _r3;
        double _t8 = _t2 == 0.0 ? 1.0 : _r4;
        double _t9 = _t2 == 0.0 ? 0.0 : _r5;
        double _t10 = _t2 == 0.0 ? 0.0 : _r2 * _t3;
        double _t11 = _t2 == 0.0 ? 0.0 : _r1 * _t3;
        double _t12 = _t2 == 0.0 ? 1.0 : _r0 * _t3;
        double _t13 = Math.abs(_t11);
        double _t14 = Math.abs(_t12);
        double _t15 = -_t10;
        double _t17 = 1.0 + _t12;
        double _t18 = 1.0 - _t12;
        makeRotationLookAlong_degenerate_s9a33d91_tail(dd, _t7, _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15, _t17, _t18);
        return this;
    }

    private DoubleQuat makeRotationLookAlong_degenerate_mulAdd(Double3R dir, Double3R up) {
        double[] dd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double _r0 = dirData[2];
        double _r1 = dirData[0];
        double _r2 = dirData[1];
        double _r3 = upData[0];
        double _r4 = upData[1];
        double _r5 = upData[2];
        double _t2 = Math.fma(_r0, _r0, Math.fma(_r1, _r1, _r2 * _r2));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 == 0.0 ? 0.0 : _r3;
        double _t8 = _t2 == 0.0 ? 1.0 : _r4;
        double _t9 = _t2 == 0.0 ? 0.0 : _r5;
        double _t10 = _t2 == 0.0 ? 0.0 : _r2 * _t3;
        double _t11 = _t2 == 0.0 ? 0.0 : _r1 * _t3;
        double _t12 = _t2 == 0.0 ? 1.0 : _r0 * _t3;
        double _t13 = Math.abs(_t11);
        double _t14 = Math.abs(_t12);
        double _t15 = -_t10;
        double _t17 = 1.0 + _t12;
        double _t18 = 1.0 - _t12;
        makeRotationLookAlong_degenerate_s17e235c6_tail(dd, _t7, _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15, _t17, _t18);
        return this;
    }

    /** Private vector tail of {@code makeRotationLookAlong_degenerate_s9a33d91}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s9a33d91_tail3(double[] dd, double _t11, double _t12, double _t38, double _t41, double _t44, double _t45, double _t48, double _t51, double _t62, double _t70, double _t71, double _t73, double _t74, double _t76, double _t77, double _t78, double _t81, double _t82) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t12))) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t71).withLane(1, _t51).withLane(2, _t82).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t73))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t73)))) : (_t44 > Math.max(_t62, _t12) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t74)).withLane(1, _t81 * _t78).withLane(2, _t48 * _t78).withLane(3, _t71 * _t78)) : (_t62 > _t12 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t81).withLane(2, _t70).withLane(3, _t51).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t76)))).withLane(1, Math.sqrt(_t76))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t48).withLane(1, _t70).withLane(3, _t82).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t77)))).withLane(2, Math.sqrt(_t77))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s9a33d91}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s9a33d91_tail(double[] dd, double _t7, double _t8, double _t9, double _t10, double _t11, double _t12, double _t13, double _t14, double _t15, double _t17, double _t18) {
        double _t25 = _t13 > _t14 ? 0.0 : _t10;
        double _t26 = _t13 > _t14 ? _t15 : 0.0;
        double _t27 = Math.fma(_t7, _t10, -(_t11 * _t8));
        double _t28 = Math.fma(_t9, _t11, -(_t7 * _t12));
        double _t29 = Math.fma(_t8, _t12, -(_t9 * _t10));
        double _t30 = _t13 > _t14 ? _t11 : -_t12;
        double _t35 = Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29));
        double _t37 = _t35 == 0.0 ? _t25 : _t27;
        double _t38 = _t35 == 0.0 ? _t26 : _t29;
        double _t39 = _t35 == 0.0 ? _t30 : _t28;
        double _t41 = (1.0 / Math.sqrt(_t35 == 0.0 ? Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t30 * _t30)) : _t35));
        double _t42 = -_t41;
        double _t43 = _t41 * _t37;
        double _t44 = _t41 * _t38;
        makeRotationLookAlong_degenerate_s9a33d91_tail2(dd, _t10, _t11, _t12, _t15, _t17, _t18, _t37, _t38, _t39, _t41, _t42, _t43, _t44);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s9a33d91}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s9a33d91_tail2(double[] dd, double _t10, double _t11, double _t12, double _t15, double _t17, double _t18, double _t37, double _t38, double _t39, double _t41, double _t42, double _t43, double _t44) {
        double _t45 = -_t43;
        double _t46 = -_t44;
        double _t47 = _t41 * _t39;
        double _t48 = Math.fma(_t41, _t37, _t11);
        double _t51 = Math.fma(_t42, _t37, _t11);
        double _t62 = Math.fma(_t44, _t12, -(_t43 * _t11));
        double _t66 = Math.fma(_t43, _t10, -(_t47 * _t12));
        double _t70 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t10));
        double _t71 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t15));
        double _t73 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t17)));
        double _t74 = Math.fma(_t41, _t38, Math.fma(_t46, _t12, Math.fma(_t43, _t11, _t18)));
        double _t76 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t42, _t38, _t18)));
        double _t77 = Math.fma(_t46, _t12, Math.fma(_t43, _t11, Math.fma(_t42, _t38, _t17)));
        double _t78 = (1.0 / Math.sqrt(_t74));
        double _t81 = Math.fma(_t41, _t39, _t66);
        double _t82 = Math.fma(_t41, _t39, -_t66);
        makeRotationLookAlong_degenerate_s9a33d91_tail3(dd, _t11, _t12, _t38, _t41, _t44, _t45, _t48, _t51, _t62, _t70, _t71, _t73, _t74, _t76, _t77, _t78, _t81, _t82);
    }

    /** Private vector tail of {@code makeRotationLookAlong_degenerate_s17e235c6}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s17e235c6_tail3(double[] dd, double _t11, double _t12, double _t38, double _t41, double _t44, double _t45, double _t48, double _t51, double _t62, double _t70, double _t71, double _t73, double _t74, double _t76, double _t77, double _t78, double _t81, double _t82) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t12))) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t71).withLane(1, _t51).withLane(2, _t82).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t73)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t73)))) : (_t44 > Math.max(_t62, _t12) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t74)).withLane(1, _t81 * _t78).withLane(2, _t48 * _t78).withLane(3, _t71 * _t78)) : (_t62 > _t12 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t81).withLane(2, _t70).withLane(3, _t51).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t76)))).withLane(1, Math.sqrt(_t76))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t48).withLane(1, _t70).withLane(3, _t82).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t77)))).withLane(2, Math.sqrt(_t77))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s17e235c6}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s17e235c6_tail(double[] dd, double _t7, double _t8, double _t9, double _t10, double _t11, double _t12, double _t13, double _t14, double _t15, double _t17, double _t18) {
        double _t25 = _t13 > _t14 ? 0.0 : _t10;
        double _t26 = _t13 > _t14 ? _t15 : 0.0;
        double _t27 = Math.fma(_t7, _t10, -(_t11 * _t8));
        double _t28 = Math.fma(_t9, _t11, -(_t7 * _t12));
        double _t29 = Math.fma(_t8, _t12, -(_t9 * _t10));
        double _t30 = _t13 > _t14 ? _t11 : -_t12;
        double _t35 = Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29));
        double _t37 = _t35 == 0.0 ? _t25 : _t27;
        double _t38 = _t35 == 0.0 ? _t26 : _t29;
        double _t39 = _t35 == 0.0 ? _t30 : _t28;
        double _t41 = (1.0 / Math.sqrt(_t35 == 0.0 ? Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t30 * _t30)) : _t35));
        double _t42 = -_t41;
        double _t43 = _t41 * _t37;
        double _t44 = _t41 * _t38;
        makeRotationLookAlong_degenerate_s17e235c6_tail2(dd, _t10, _t11, _t12, _t15, _t17, _t18, _t37, _t38, _t39, _t41, _t42, _t43, _t44);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s17e235c6}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s17e235c6_tail2(double[] dd, double _t10, double _t11, double _t12, double _t15, double _t17, double _t18, double _t37, double _t38, double _t39, double _t41, double _t42, double _t43, double _t44) {
        double _t45 = -_t43;
        double _t46 = -_t44;
        double _t47 = _t41 * _t39;
        double _t48 = Math.fma(_t41, _t37, _t11);
        double _t51 = Math.fma(_t42, _t37, _t11);
        double _t62 = Math.fma(_t44, _t12, -(_t43 * _t11));
        double _t66 = Math.fma(_t43, _t10, -(_t47 * _t12));
        double _t70 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t10));
        double _t71 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t15));
        double _t73 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t17)));
        double _t74 = Math.fma(_t41, _t38, Math.fma(_t46, _t12, Math.fma(_t43, _t11, _t18)));
        double _t76 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t42, _t38, _t18)));
        double _t77 = Math.fma(_t46, _t12, Math.fma(_t43, _t11, Math.fma(_t42, _t38, _t17)));
        double _t78 = (1.0 / Math.sqrt(_t74));
        double _t81 = Math.fma(_t41, _t39, _t66);
        double _t82 = Math.fma(_t41, _t39, -_t66);
        makeRotationLookAlong_degenerate_s17e235c6_tail3(dd, _t11, _t12, _t38, _t41, _t44, _t45, _t48, _t51, _t62, _t70, _t71, _t73, _t74, _t76, _t77, _t78, _t81, _t82);
    }


    /**
     * Degenerate-input path of {@code makeRotationLookAlong}: its methods leave here when their
     * input spans no proper basis (a zero direction, an up vector parallel to it or zero, NaN);
     * reached only through them.
     */
    @Mutated private DoubleQuat makeRotationLookAlong_degenerate(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (SimdMath.USE_FMA) return makeRotationLookAlong_degenerate_fma(dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_degenerate_mulAdd(dirX, dirY, dirZ, upX, upY, upZ);
    }

    private DoubleQuat makeRotationLookAlong_degenerate_fma(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 == 0.0 ? 0.0 : upX;
        double _t8 = _t2 == 0.0 ? 1.0 : upY;
        double _t9 = _t2 == 0.0 ? 0.0 : upZ;
        double _t10 = _t2 == 0.0 ? 0.0 : dirY * _t3;
        double _t11 = _t2 == 0.0 ? 0.0 : dirX * _t3;
        double _t12 = _t2 == 0.0 ? 1.0 : dirZ * _t3;
        double _t13 = Math.abs(_t11);
        double _t14 = Math.abs(_t12);
        double _t15 = -_t10;
        double _t17 = 1.0 + _t12;
        double _t18 = 1.0 - _t12;
        double _t25 = _t13 > _t14 ? 0.0 : _t10;
        double _t26 = _t13 > _t14 ? _t15 : 0.0;
        double _t27 = Math.fma(_t7, _t10, -(_t11 * _t8));
        makeRotationLookAlong_degenerate_s169760fb_tail(dd, _t7, _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15, _t17, _t18, _t25, _t26, _t27);
        return this;
    }

    private DoubleQuat makeRotationLookAlong_degenerate_mulAdd(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 == 0.0 ? 0.0 : upX;
        double _t8 = _t2 == 0.0 ? 1.0 : upY;
        double _t9 = _t2 == 0.0 ? 0.0 : upZ;
        double _t10 = _t2 == 0.0 ? 0.0 : dirY * _t3;
        double _t11 = _t2 == 0.0 ? 0.0 : dirX * _t3;
        double _t12 = _t2 == 0.0 ? 1.0 : dirZ * _t3;
        double _t13 = Math.abs(_t11);
        double _t14 = Math.abs(_t12);
        double _t15 = -_t10;
        double _t17 = 1.0 + _t12;
        double _t18 = 1.0 - _t12;
        double _t25 = _t13 > _t14 ? 0.0 : _t10;
        double _t26 = _t13 > _t14 ? _t15 : 0.0;
        double _t27 = Math.fma(_t7, _t10, -(_t11 * _t8));
        makeRotationLookAlong_degenerate_s687621c_tail(dd, _t7, _t8, _t9, _t10, _t11, _t12, _t13, _t14, _t15, _t17, _t18, _t25, _t26, _t27);
        return this;
    }

    /** Private vector tail of {@code makeRotationLookAlong_degenerate_s169760fb}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s169760fb_tail3(double[] dd, double _t11, double _t12, double _t38, double _t41, double _t44, double _t45, double _t48, double _t51, double _t62, double _t70, double _t71, double _t73, double _t74, double _t76, double _t77, double _t78, double _t81, double _t82) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t12))) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t71).withLane(1, _t51).withLane(2, _t82).fma(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t73))), DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t73)))) : (_t44 > Math.max(_t62, _t12) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t74)).withLane(1, _t81 * _t78).withLane(2, _t48 * _t78).withLane(3, _t71 * _t78)) : (_t62 > _t12 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t81).withLane(2, _t70).withLane(3, _t51).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t76)))).withLane(1, Math.sqrt(_t76))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t48).withLane(1, _t70).withLane(3, _t82).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t77)))).withLane(2, Math.sqrt(_t77))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s169760fb}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s169760fb_tail(double[] dd, double _t7, double _t8, double _t9, double _t10, double _t11, double _t12, double _t13, double _t14, double _t15, double _t17, double _t18, double _t25, double _t26, double _t27) {
        double _t28 = Math.fma(_t9, _t11, -(_t7 * _t12));
        double _t29 = Math.fma(_t8, _t12, -(_t9 * _t10));
        double _t30 = _t13 > _t14 ? _t11 : -_t12;
        double _t35 = Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29));
        double _t37 = _t35 == 0.0 ? _t25 : _t27;
        double _t38 = _t35 == 0.0 ? _t26 : _t29;
        double _t39 = _t35 == 0.0 ? _t30 : _t28;
        double _t41 = (1.0 / Math.sqrt(_t35 == 0.0 ? Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t30 * _t30)) : _t35));
        double _t42 = -_t41;
        double _t43 = _t41 * _t37;
        double _t44 = _t41 * _t38;
        double _t45 = -_t43;
        double _t46 = -_t44;
        double _t47 = _t41 * _t39;
        double _t48 = Math.fma(_t41, _t37, _t11);
        double _t51 = Math.fma(_t42, _t37, _t11);
        makeRotationLookAlong_degenerate_s169760fb_tail2(dd, _t10, _t11, _t12, _t15, _t17, _t18, _t38, _t39, _t41, _t42, _t43, _t44, _t45, _t46, _t47, _t48, _t51);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s169760fb}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s169760fb_tail2(double[] dd, double _t10, double _t11, double _t12, double _t15, double _t17, double _t18, double _t38, double _t39, double _t41, double _t42, double _t43, double _t44, double _t45, double _t46, double _t47, double _t48, double _t51) {
        double _t62 = Math.fma(_t44, _t12, -(_t43 * _t11));
        double _t66 = Math.fma(_t43, _t10, -(_t47 * _t12));
        double _t70 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t10));
        double _t71 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t15));
        double _t73 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t17)));
        double _t74 = Math.fma(_t41, _t38, Math.fma(_t46, _t12, Math.fma(_t43, _t11, _t18)));
        double _t76 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t42, _t38, _t18)));
        double _t77 = Math.fma(_t46, _t12, Math.fma(_t43, _t11, Math.fma(_t42, _t38, _t17)));
        double _t78 = (1.0 / Math.sqrt(_t74));
        double _t81 = Math.fma(_t41, _t39, _t66);
        double _t82 = Math.fma(_t41, _t39, -_t66);
        makeRotationLookAlong_degenerate_s169760fb_tail3(dd, _t11, _t12, _t38, _t41, _t44, _t45, _t48, _t51, _t62, _t70, _t71, _t73, _t74, _t76, _t77, _t78, _t81, _t82);
    }

    /** Private vector tail of {@code makeRotationLookAlong_degenerate_s687621c}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s687621c_tail3(double[] dd, double _t11, double _t12, double _t38, double _t41, double _t44, double _t45, double _t48, double _t51, double _t62, double _t70, double _t71, double _t73, double _t74, double _t76, double _t77, double _t78, double _t81, double _t82) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t12))) > 0.0 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t71).withLane(1, _t51).withLane(2, _t82).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t73)))).add(DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.sqrt(_t73)))) : (_t44 > Math.max(_t62, _t12) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t74)).withLane(1, _t81 * _t78).withLane(2, _t48 * _t78).withLane(3, _t71 * _t78)) : (_t62 > _t12 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t81).withLane(2, _t70).withLane(3, _t51).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t76)))).withLane(1, Math.sqrt(_t76))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t48).withLane(1, _t70).withLane(3, _t82).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t77)))).withLane(2, Math.sqrt(_t77))))));
        _col0.intoArray(dd, 0);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s687621c}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s687621c_tail(double[] dd, double _t7, double _t8, double _t9, double _t10, double _t11, double _t12, double _t13, double _t14, double _t15, double _t17, double _t18, double _t25, double _t26, double _t27) {
        double _t28 = Math.fma(_t9, _t11, -(_t7 * _t12));
        double _t29 = Math.fma(_t8, _t12, -(_t9 * _t10));
        double _t30 = _t13 > _t14 ? _t11 : -_t12;
        double _t35 = Math.fma(_t27, _t27, Math.fma(_t28, _t28, _t29 * _t29));
        double _t37 = _t35 == 0.0 ? _t25 : _t27;
        double _t38 = _t35 == 0.0 ? _t26 : _t29;
        double _t39 = _t35 == 0.0 ? _t30 : _t28;
        double _t41 = (1.0 / Math.sqrt(_t35 == 0.0 ? Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t30 * _t30)) : _t35));
        double _t42 = -_t41;
        double _t43 = _t41 * _t37;
        double _t44 = _t41 * _t38;
        double _t45 = -_t43;
        double _t46 = -_t44;
        double _t47 = _t41 * _t39;
        double _t48 = Math.fma(_t41, _t37, _t11);
        double _t51 = Math.fma(_t42, _t37, _t11);
        makeRotationLookAlong_degenerate_s687621c_tail2(dd, _t10, _t11, _t12, _t15, _t17, _t18, _t38, _t39, _t41, _t42, _t43, _t44, _t45, _t46, _t47, _t48, _t51);
    }

    /** Private tail of {@code makeRotationLookAlong_degenerate_s687621c}; reached only through it. */
    private static void makeRotationLookAlong_degenerate_s687621c_tail2(double[] dd, double _t10, double _t11, double _t12, double _t15, double _t17, double _t18, double _t38, double _t39, double _t41, double _t42, double _t43, double _t44, double _t45, double _t46, double _t47, double _t48, double _t51) {
        double _t62 = Math.fma(_t44, _t12, -(_t43 * _t11));
        double _t66 = Math.fma(_t43, _t10, -(_t47 * _t12));
        double _t70 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t10));
        double _t71 = Math.fma(_t47, _t11, Math.fma(_t46, _t10, _t15));
        double _t73 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t41, _t38, _t17)));
        double _t74 = Math.fma(_t41, _t38, Math.fma(_t46, _t12, Math.fma(_t43, _t11, _t18)));
        double _t76 = Math.fma(_t44, _t12, Math.fma(_t45, _t11, Math.fma(_t42, _t38, _t18)));
        double _t77 = Math.fma(_t46, _t12, Math.fma(_t43, _t11, Math.fma(_t42, _t38, _t17)));
        double _t78 = (1.0 / Math.sqrt(_t74));
        double _t81 = Math.fma(_t41, _t39, _t66);
        double _t82 = Math.fma(_t41, _t39, -_t66);
        makeRotationLookAlong_degenerate_s687621c_tail3(dd, _t11, _t12, _t38, _t41, _t44, _t45, _t48, _t51, _t62, _t70, _t71, _t73, _t74, _t76, _t77, _t78, _t81, _t82);
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
    @Mutated public DoubleQuat makeRotationTo(Double3R fromDir, Double3R toDir) {
        if (SimdMath.USE_FMA) return makeRotationTo_fma(fromDir, toDir);
        return makeRotationTo_mulAdd(fromDir, toDir);
    }

    private DoubleQuat makeRotationTo_fma(Double3R fromDir, Double3R toDir) {
        double[] dd = this.data;
        double[] fromDirData = ((Double3Impl) fromDir).data;
        double[] toDirData = ((Double3Impl) toDir).data;
        double _r0 = fromDirData[2];
        double _r1 = toDirData[2];
        double _r2 = fromDirData[0];
        double _r3 = toDirData[0];
        double _r4 = fromDirData[1];
        double _r5 = toDirData[1];
        double _t2 = _r0 + _r1;
        double _t3 = _r2 + _r3;
        double _t4 = _r4 + _r5;
        double _t12 = Math.fma(_r2, _r2, _r4 * _r4);
        double _t14 = Math.fma(_r4, _r1, -(_r0 * _r5));
        double _t15 = Math.fma(_r2, _r5, -(_r4 * _r3));
        double _t16 = Math.fma(_r0, _r3, -(_r2 * _r1));
        double _t17 = _t12 > 0.0 ? _r4 : 0.0;
        double _t18 = _t12 > 0.0 ? 0.0 : -_r4;
        double _t19 = _t12 > 0.0 ? -_r2 : _r0;
        double _t22 = Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4));
        double _t29 = Math.fma(_t18, _t18, Math.fma(_t17, _t17, _t19 * _t19));
        double _t32 = (1.0 / Math.sqrt(Math.fma(0.25, _t22 * _t22, Math.fma(_t15, _t15, Math.fma(_t14, _t14, _t16 * _t16)))));
        makeRotationTo_s5f982a20_tail(dd, _t14, _t15, _t16, _t17, _t18, _t19, _t22, _t29, _t32);
        return this;
    }

    private DoubleQuat makeRotationTo_mulAdd(Double3R fromDir, Double3R toDir) {
        double[] dd = this.data;
        double[] fromDirData = ((Double3Impl) fromDir).data;
        double[] toDirData = ((Double3Impl) toDir).data;
        double _r0 = fromDirData[2];
        double _r1 = toDirData[2];
        double _r2 = fromDirData[0];
        double _r3 = toDirData[0];
        double _r4 = fromDirData[1];
        double _r5 = toDirData[1];
        double _t2 = _r0 + _r1;
        double _t3 = _r2 + _r3;
        double _t4 = _r4 + _r5;
        double _t12 = Math.fma(_r2, _r2, _r4 * _r4);
        double _t14 = Math.fma(_r4, _r1, -(_r0 * _r5));
        double _t15 = Math.fma(_r2, _r5, -(_r4 * _r3));
        double _t16 = Math.fma(_r0, _r3, -(_r2 * _r1));
        double _t17 = _t12 > 0.0 ? _r4 : 0.0;
        double _t18 = _t12 > 0.0 ? 0.0 : -_r4;
        double _t19 = _t12 > 0.0 ? -_r2 : _r0;
        double _t22 = Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4));
        double _t29 = Math.fma(_t18, _t18, Math.fma(_t17, _t17, _t19 * _t19));
        double _t32 = (1.0 / Math.sqrt(Math.fma(0.25, _t22 * _t22, Math.fma(_t15, _t15, Math.fma(_t14, _t14, _t16 * _t16)))));
        makeRotationTo_s78f6cad7_tail(dd, _t14, _t15, _t16, _t17, _t18, _t19, _t22, _t29, _t32);
        return this;
    }

    /** Private vector tail of {@code makeRotationTo_s5f982a20}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationTo_s5f982a20_tail(double[] dd, double _t14, double _t15, double _t16, double _t17, double _t18, double _t19, double _t22, double _t29, double _t32) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.0);
        var _col0 = (0.5 * _t22 > 1.0E-13 ? DoubleVector.zero(COL_SPECIES).withLane(0, _t14).withLane(1, _t16).withLane(2, _t15).withLane(3, 0.5).mul(DoubleVector.broadcast(COL_SPECIES, _t32).withLane(3, _t22 * _t32)) : (_t29 != 0.0 ? DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t29))).fma(DoubleVector.zero(COL_SPECIES).withLane(0, _t17).withLane(1, _t19).withLane(2, _t18), _sv0.withLane(3, 0.0)) : _sv0));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code makeRotationTo_s78f6cad7}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationTo_s78f6cad7_tail(double[] dd, double _t14, double _t15, double _t16, double _t17, double _t18, double _t19, double _t22, double _t29, double _t32) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.0);
        var _col0 = (0.5 * _t22 > 1.0E-13 ? DoubleVector.zero(COL_SPECIES).withLane(0, _t14).withLane(1, _t16).withLane(2, _t15).withLane(3, 0.5).mul(DoubleVector.broadcast(COL_SPECIES, _t32).withLane(3, _t22 * _t32)) : (_t29 != 0.0 ? DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t29))).mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t17).withLane(1, _t19).withLane(2, _t18)).add(_sv0.withLane(3, 0.0)) : _sv0));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return makeRotationTo_fma(fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return makeRotationTo_mulAdd(fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    private DoubleQuat makeRotationTo_fma(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double[] dd = this.data;
        double _t2 = fromDirZ + toDirZ;
        double _t3 = fromDirX + toDirX;
        double _t4 = fromDirY + toDirY;
        double _t12 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t14 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        double _t15 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        double _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        double _t17 = _t12 > 0.0 ? fromDirY : 0.0;
        double _t18 = _t12 > 0.0 ? 0.0 : -fromDirY;
        double _t19 = _t12 > 0.0 ? -fromDirX : fromDirZ;
        double _t22 = Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4));
        double _t29 = Math.fma(_t18, _t18, Math.fma(_t17, _t17, _t19 * _t19));
        double _t32 = (1.0 / Math.sqrt(Math.fma(0.25, _t22 * _t22, Math.fma(_t15, _t15, Math.fma(_t14, _t14, _t16 * _t16)))));
        makeRotationTo_s103d514_tail(dd, _t14, _t15, _t16, _t17, _t18, _t19, _t22, _t29, _t32);
        return this;
    }

    private DoubleQuat makeRotationTo_mulAdd(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double[] dd = this.data;
        double _t2 = fromDirZ + toDirZ;
        double _t3 = fromDirX + toDirX;
        double _t4 = fromDirY + toDirY;
        double _t12 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t14 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        double _t15 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        double _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        double _t17 = _t12 > 0.0 ? fromDirY : 0.0;
        double _t18 = _t12 > 0.0 ? 0.0 : -fromDirY;
        double _t19 = _t12 > 0.0 ? -fromDirX : fromDirZ;
        double _t22 = Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4));
        double _t29 = Math.fma(_t18, _t18, Math.fma(_t17, _t17, _t19 * _t19));
        double _t32 = (1.0 / Math.sqrt(Math.fma(0.25, _t22 * _t22, Math.fma(_t15, _t15, Math.fma(_t14, _t14, _t16 * _t16)))));
        makeRotationTo_s2961cb63_tail(dd, _t14, _t15, _t16, _t17, _t18, _t19, _t22, _t29, _t32);
        return this;
    }

    /** Private vector tail of {@code makeRotationTo_s103d514}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationTo_s103d514_tail(double[] dd, double _t14, double _t15, double _t16, double _t17, double _t18, double _t19, double _t22, double _t29, double _t32) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.0);
        var _col0 = (0.5 * _t22 > 1.0E-13 ? DoubleVector.zero(COL_SPECIES).withLane(0, _t14).withLane(1, _t16).withLane(2, _t15).withLane(3, 0.5).mul(DoubleVector.broadcast(COL_SPECIES, _t32).withLane(3, _t22 * _t32)) : (_t29 != 0.0 ? DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t29))).fma(DoubleVector.zero(COL_SPECIES).withLane(0, _t17).withLane(1, _t19).withLane(2, _t18), _sv0.withLane(3, 0.0)) : _sv0));
        _col0.intoArray(dd, 0);
    }

    /** Private vector tail of {@code makeRotationTo_s2961cb63}: loads, computes and stores every column; reached only through it. */
    private static void makeRotationTo_s2961cb63_tail(double[] dd, double _t14, double _t15, double _t16, double _t17, double _t18, double _t19, double _t22, double _t29, double _t32) {
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.0);
        var _col0 = (0.5 * _t22 > 1.0E-13 ? DoubleVector.zero(COL_SPECIES).withLane(0, _t14).withLane(1, _t16).withLane(2, _t15).withLane(3, 0.5).mul(DoubleVector.broadcast(COL_SPECIES, _t32).withLane(3, _t22 * _t32)) : (_t29 != 0.0 ? DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t29))).mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t17).withLane(1, _t19).withLane(2, _t18)).add(_sv0.withLane(3, 0.0)) : _sv0));
        _col0.intoArray(dd, 0);
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleQuat makeRotationX(double angle) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dd[0] = _t1;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = Math.cosFromSin(_t1, _t0);
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
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t10, _t7, _t11 * _t5);
        dd[1] = Math.fma(_t11, _t7, -(_t10 * _t5));
        dd[2] = Math.fma(_t9, _t7, _t12 * _t5);
        dd[3] = Math.fma(_t12, _t7, -(_t9 * _t5));
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
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t10, _t7, -(_t11 * _t5));
        dd[1] = Math.fma(_t12, _t5, -(_t9 * _t7));
        dd[2] = Math.fma(_t10, _t5, _t11 * _t7);
        dd[3] = Math.fma(_t9, _t5, _t12 * _t7);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleQuat makeRotationY(double angle) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dd[0] = 0.0;
        dd[1] = _t1;
        dd[2] = 0.0;
        dd[3] = Math.cosFromSin(_t1, _t0);
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
        if (SimdMath.USE_FMA) return makeRotationYXZ_fma(angleY, angleX, angleZ);
        return makeRotationYXZ_mulAdd(angleY, angleX, angleZ);
    }

    private DoubleQuat makeRotationYXZ_fma(double angleY, double angleX, double angleZ) {
        double[] dd = this.data;
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
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, _t11).withLane(2, _t12).withLane(3, _t9).fma(DoubleVector.broadcast(COL_SPECIES, _t5), DoubleVector.broadcast(COL_SPECIES, _t10).withLane(3, _t12).mul(DoubleVector.broadcast(COL_SPECIES, _t7)).withLane(2, -(_t9 * _t7))).withLane(1, _t11 * _t7 - _t10 * _t5);
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationYXZ_mulAdd(double angleY, double angleX, double angleZ) {
        double[] dd = this.data;
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
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, _t11).withLane(2, _t12).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, _t5)).add(DoubleVector.broadcast(COL_SPECIES, _t10).withLane(3, _t12).mul(DoubleVector.broadcast(COL_SPECIES, _t7)).withLane(2, -(_t9 * _t7))).withLane(1, _t11 * _t7 - _t10 * _t5);
        _col0.intoArray(dd, 0);
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
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t6, _t12 * _t5);
        dd[1] = Math.fma(_t10, _t6, _t11 * _t5);
        dd[2] = Math.fma(_t11, _t6, -(_t10 * _t5));
        dd[3] = Math.fma(_t12, _t6, -(_t9 * _t5));
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public DoubleQuat makeRotationZ(double angle) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = _t1;
        dd[3] = Math.cosFromSin(_t1, _t0);
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
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t10, _t7, -(_t11 * _t5));
        dd[1] = Math.fma(_t9, _t7, _t12 * _t5);
        dd[2] = Math.fma(_t10, _t5, _t11 * _t7);
        dd[3] = Math.fma(_t12, _t7, -(_t9 * _t5));
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
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t12, _t5, -(_t9 * _t8));
        dd[1] = Math.fma(_t10, _t8, _t11 * _t5);
        dd[2] = Math.fma(_t11, _t8, -(_t10 * _t5));
        dd[3] = Math.fma(_t9, _t5, _t12 * _t8);
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t2, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t2, -(sd[2] * _t1));
        dd[2] = Math.fma(sd[1], _t1, sd[2] * _t2);
        dd[3] = Math.fma(sd[3], _t2, -(sd[0] * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t2, sd[2] * _t1);
        double _buf1 = Math.fma(sd[1], _t2, sd[3] * _t1);
        dd[2] = Math.fma(sd[2], _t2, -(sd[0] * _t1));
        dd[3] = Math.fma(sd[3], _t2, -(sd[1] * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t2, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t2);
        double _buf1 = Math.fma(sd[2], _t2, sd[3] * _t1);
        dd[3] = Math.fma(sd[3], _t2, -(sd[2] * _t1));
        dd[0] = _buf0;
        dd[2] = _buf1;
        return dest;
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
        if (axis.y() == 0 && axis.z() == 0 && Math.abs(axis.x()) == 1) return rotateX(axis.x() * angle, dest);
        if (axis.x() == 0 && axis.z() == 0 && Math.abs(axis.y()) == 1) return rotateY(axis.y() * angle, dest);
        if (axis.x() == 0 && axis.y() == 0 && Math.abs(axis.z()) == 1) return rotateZ(axis.z() * angle, dest);
        double[] sd = this.data;
        double[] axisData = ((Double3Impl) axis).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = axisData[0] * _t1;
        double _t3 = axisData[2] * _t1;
        double _t4 = axisData[1] * _t1;
        double _t5 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t5, sd[3] * _t2) + Math.fma(sd[1], _t3, -(sd[2] * _t4));
        double _buf1 = Math.fma(sd[1], _t5, sd[2] * _t2) + Math.fma(sd[3], _t4, -(sd[0] * _t3));
        double _buf2 = Math.fma(sd[0], _t4, sd[3] * _t3) + Math.fma(sd[2], _t5, -(sd[1] * _t2));
        dd[3] = Math.fma(sd[3], _t5, -(sd[0] * _t2)) - Math.fma(sd[1], _t4, sd[2] * _t3);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = axisX * _t1;
        double _t3 = axisZ * _t1;
        double _t4 = axisY * _t1;
        double _t5 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t5, sd[3] * _t2) + Math.fma(sd[1], _t3, -(sd[2] * _t4));
        double _buf1 = Math.fma(sd[1], _t5, sd[2] * _t2) + Math.fma(sd[3], _t4, -(sd[0] * _t3));
        double _buf2 = Math.fma(sd[0], _t4, sd[3] * _t3) + Math.fma(sd[2], _t5, -(sd[1] * _t2));
        dd[3] = Math.fma(sd[3], _t5, -(sd[0] * _t2)) - Math.fma(sd[1], _t4, sd[2] * _t3);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] fromDirData = ((Double3Impl) fromDir).data;
        double[] toDirData = ((Double3Impl) toDir).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = fromDirData[2] + toDirData[2];
        double _t3 = fromDirData[0] + toDirData[0];
        double _t4 = fromDirData[1] + toDirData[1];
        double _t12 = Math.fma(fromDirData[0], fromDirData[0], fromDirData[1] * fromDirData[1]);
        double _t14 = Math.fma(fromDirData[0], toDirData[1], -(fromDirData[1] * toDirData[0]));
        double _t15 = Math.fma(fromDirData[1], toDirData[2], -(fromDirData[2] * toDirData[1]));
        double _t16 = Math.fma(fromDirData[2], toDirData[0], -(fromDirData[0] * toDirData[2]));
        double _t17, _t18, _t19;
        if (_t12 > 0.0) {
            _t17 = fromDirData[1];
            _t18 = 0.0;
            _t19 = -fromDirData[0];
        } else {
            _t17 = 0.0;
            _t18 = -fromDirData[1];
            _t19 = fromDirData[2];
        }
        double _t22 = Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4));
        double _t23 = 0.5 * _t22;
        double _t29 = Math.fma(_t18, _t18, Math.fma(_t17, _t17, _t19 * _t19));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t35 = (1.0 / Math.sqrt(Math.fma(0.25, _t22 * _t22, Math.fma(_t14, _t14, Math.fma(_t15, _t15, _t16 * _t16)))));
        double _t41, _t45, _t46, _t47;
        if (_t23 > 1.0E-13) {
            _t41 = _t23 * _t35;
            _t45 = _t15 * _t35;
            _t46 = _t14 * _t35;
            _t47 = _t16 * _t35;
        } else {
            if (_t29 != 0.0) {
                _t41 = 0.0;
                _t45 = _t30 * _t17;
                _t46 = _t30 * _t18;
                _t47 = _t30 * _t19;
            } else {
                _t41 = 0.0;
                _t45 = 0.0;
                _t46 = 0.0;
                _t47 = 0.0;
            }
        }
        double _buf0 = Math.fma(sd[0], _t41, sd[3] * _t45) + Math.fma(sd[1], _t46, -(sd[2] * _t47));
        double _buf1 = Math.fma(sd[1], _t41, sd[2] * _t45) + Math.fma(sd[3], _t47, -(sd[0] * _t46));
        double _buf2 = Math.fma(sd[0], _t47, sd[3] * _t46) + Math.fma(sd[2], _t41, -(sd[1] * _t45));
        dd[3] = Math.fma(sd[3], _t41, -(sd[0] * _t45)) - Math.fma(sd[1], _t47, sd[2] * _t46);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = fromDirZ + toDirZ;
        double _t3 = fromDirX + toDirX;
        double _t4 = fromDirY + toDirY;
        double _t12 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t14 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        double _t15 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        double _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        double _t17, _t18, _t19;
        if (_t12 > 0.0) {
            _t17 = fromDirY;
            _t18 = 0.0;
            _t19 = -fromDirX;
        } else {
            _t17 = 0.0;
            _t18 = -fromDirY;
            _t19 = fromDirZ;
        }
        double _t22 = Math.fma(_t2, _t2, Math.fma(_t3, _t3, _t4 * _t4));
        double _t23 = 0.5 * _t22;
        double _t29 = Math.fma(_t18, _t18, Math.fma(_t17, _t17, _t19 * _t19));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t35 = (1.0 / Math.sqrt(Math.fma(0.25, _t22 * _t22, Math.fma(_t14, _t14, Math.fma(_t15, _t15, _t16 * _t16)))));
        double _t41, _t45, _t46, _t47;
        if (_t23 > 1.0E-13) {
            _t41 = _t23 * _t35;
            _t45 = _t15 * _t35;
            _t46 = _t14 * _t35;
            _t47 = _t16 * _t35;
        } else {
            if (_t29 != 0.0) {
                _t41 = 0.0;
                _t45 = _t30 * _t17;
                _t46 = _t30 * _t18;
                _t47 = _t30 * _t19;
            } else {
                _t41 = 0.0;
                _t45 = 0.0;
                _t46 = 0.0;
                _t47 = 0.0;
            }
        }
        double _buf0 = Math.fma(sd[0], _t41, sd[3] * _t45) + Math.fma(sd[1], _t46, -(sd[2] * _t47));
        double _buf1 = Math.fma(sd[1], _t41, sd[2] * _t45) + Math.fma(sd[3], _t47, -(sd[0] * _t46));
        double _buf2 = Math.fma(sd[0], _t47, sd[3] * _t46) + Math.fma(sd[2], _t41, -(sd[1] * _t45));
        dd[3] = Math.fma(sd[3], _t41, -(sd[0] * _t45)) - Math.fma(sd[1], _t47, sd[2] * _t46);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t2, sd[3] * _t1);
        double _buf1 = Math.fma(sd[1], _t2, sd[2] * _t1);
        dd[2] = Math.fma(sd[2], _t2, -(sd[1] * _t1));
        dd[3] = Math.fma(sd[3], _t2, -(sd[0] * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t14 = _t6 * _t7;
        double _t19 = Math.fma(_t10, _t8, _t11 * _t5);
        double _t20 = Math.fma(_t9, _t8, _t14 * _t5);
        double _t21 = Math.fma(_t14, _t8, -(_t9 * _t5));
        double _t22 = Math.fma(_t11, _t8, -(_t10 * _t5));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(sd[3], _t21, -(sd[0] * _t19)) - Math.fma(sd[1], _t22, sd[2] * _t20);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t12 = _t6 * _t7;
        double _t19 = Math.fma(_t9, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t10, _t5, _t11 * _t8);
        double _t21 = Math.fma(_t10, _t8, -(_t11 * _t5));
        double _t22 = Math.fma(_t12, _t5, -(_t9 * _t8));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(sd[3], _t19, -(sd[0] * _t21)) - Math.fma(sd[1], _t22, sd[2] * _t20);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t2, -(sd[2] * _t1));
        double _buf1 = Math.fma(sd[1], _t2, sd[3] * _t1);
        dd[2] = Math.fma(sd[0], _t1, sd[2] * _t2);
        dd[3] = Math.fma(sd[3], _t2, -(sd[1] * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t12 = _t6 * _t7;
        double _t19 = Math.fma(_t9, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t10, _t8, _t11 * _t5);
        double _t21 = Math.fma(_t12, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t11, _t8, -(_t10 * _t5));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t20) + Math.fma(sd[1], _t21, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t20) + Math.fma(sd[3], _t22, -(sd[0] * _t21));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t21) + Math.fma(sd[2], _t19, -(sd[1] * _t20));
        dd[3] = Math.fma(sd[3], _t19, -(sd[0] * _t20)) - Math.fma(sd[1], _t22, sd[2] * _t21);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t14 = _t6 * _t7;
        double _t19 = Math.fma(_t9, _t8, _t14 * _t5);
        double _t20 = Math.fma(_t11, _t8, _t10 * _t5);
        double _t21 = Math.fma(_t14, _t8, -(_t9 * _t5));
        double _t22 = Math.fma(_t10, _t8, -(_t11 * _t5));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(sd[3], _t21, -(sd[0] * _t19)) - Math.fma(sd[1], _t20, sd[2] * _t22);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        double _t2 = Math.cosFromSin(_t1, _t0);
        double _buf0 = Math.fma(sd[0], _t2, sd[1] * _t1);
        dd[1] = Math.fma(sd[1], _t2, -(sd[0] * _t1));
        double _buf1 = Math.fma(sd[2], _t2, sd[3] * _t1);
        dd[3] = Math.fma(sd[3], _t2, -(sd[2] * _t1));
        dd[0] = _buf0;
        dd[2] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t14 = _t6 * _t7;
        double _t19 = Math.fma(_t10, _t5, _t11 * _t8);
        double _t20 = Math.fma(_t9, _t8, _t14 * _t5);
        double _t21 = Math.fma(_t14, _t8, -(_t9 * _t5));
        double _t22 = Math.fma(_t10, _t8, -(_t11 * _t5));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t22) + Math.fma(sd[1], _t19, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t22) + Math.fma(sd[3], _t20, -(sd[0] * _t19));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t19) + Math.fma(sd[2], _t21, -(sd[1] * _t22));
        dd[3] = Math.fma(sd[3], _t21, -(sd[0] * _t22)) - Math.fma(sd[1], _t20, sd[2] * _t19);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t12 = _t6 * _t7;
        double _t19 = Math.fma(_t9, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t11, _t8, _t10 * _t5);
        double _t21 = Math.fma(_t12, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t10, _t8, -(_t11 * _t5));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(sd[3], _t19, -(sd[0] * _t21)) - Math.fma(sd[1], _t20, sd[2] * _t22);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], vY, -(sd[1] * vX));
        double _t10 = 2.0 * Math.fma(sd[2], vX, -(sd[0] * vZ));
        double _t11 = 2.0 * Math.fma(sd[1], vZ, -(sd[2] * vY));
        double _buf0 = Math.fma(sd[1], _t9, Math.fma(-sd[2], _t10, Math.fma(sd[3], _t11, vX)));
        double _buf1 = Math.fma(sd[2], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vY)));
        dd[2] = Math.fma(sd[0], _t10, Math.fma(-sd[1], _t11, Math.fma(sd[3], _t9, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t9 = 2.0 * Math.fma(sd[0], vZ, -(sd[2] * vX));
        double _t10 = 2.0 * Math.fma(sd[1], vX, -(sd[0] * vY));
        double _t11 = 2.0 * Math.fma(sd[2], vY, -(sd[1] * vZ));
        double _buf0 = Math.fma(sd[2], _t9, Math.fma(-sd[1], _t10, Math.fma(sd[3], _t11, vX)));
        double _buf1 = Math.fma(sd[0], _t10, Math.fma(-sd[2], _t11, Math.fma(sd[3], _t9, vY)));
        dd[2] = Math.fma(sd[1], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }

    public double x() { return data[0]; }
    public double y() { return data[1]; }
    public double z() { return data[2]; }
    public double w() { return data[3]; }

    @Override public String toString() {
        return "DoubleQuat(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleQuatImpl)) return false;
        DoubleQuatImpl o = (DoubleQuatImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Double.isFinite(data[0])
            && Double.isFinite(data[1])
            && Double.isFinite(data[2])
            && Double.isFinite(data[3]);
    }

    @Override public boolean equalsEpsilon(DoubleQuatR other, double epsilon) {
        return Math.abs(data[0] - other.x()) <= epsilon
            && Math.abs(data[1] - other.y()) <= epsilon
            && Math.abs(data[2] - other.z()) <= epsilon
            && Math.abs(data[3] - other.w()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        double[] d = this.data;
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoArray(dest, offset);
        return dest;
    }
    public @Mutated DoubleQuat load(double[] src, int offset) {
        double[] d = this.data;
        DoubleVector.fromArray(COL_SPECIES, src, offset).intoArray(d, 0);
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        double[] d = this.data;
        if (buf.hasArray()) {
            double[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            DoubleVector.fromArray(COL_SPECIES, d, 0).intoArray(arr, off);
        } else if (buf.order() != ByteOrder.nativeOrder()) {
            return BB_OPS.storeAbsolute(this, index, buf);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 8;
            DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, baseOff, ByteOrder.nativeOrder());
        }
        return buf;
    }
    @Mutated public DoubleQuat loadAbsolute(int index, DoubleBuffer buf) {
        double[] d = this.data;
        if (buf.hasArray()) {
            double[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            DoubleVector.fromArray(COL_SPECIES, arr, off).intoArray(d, 0);
        } else if (buf.order() != ByteOrder.nativeOrder()) {
            return BB_OPS.loadAbsolute(this, index, buf);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 8;
            DoubleVector.fromMemorySegment(COL_SPECIES, seg, baseOff, ByteOrder.nativeOrder()).intoArray(d, 0);
        }
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        if (buf.order() != ByteOrder.nativeOrder()) return BB_OPS.storeAbsolute(this, index, buf);
        double[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, index, ByteOrder.nativeOrder());
        return buf;
    }
    public DoubleQuat loadAbsolute(int index, ByteBuffer buf) {
        if (buf.order() != ByteOrder.nativeOrder()) return BB_OPS.loadAbsolute(this, index, buf);
        double[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        DoubleVector.fromMemorySegment(COL_SPECIES, seg, index, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }
    public DoubleQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        double[] d = this.data;
        MemorySegment seg = dest;
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, offset, ByteOrder.nativeOrder());
        return dest;
    }
    public DoubleQuat load(long offset, MemorySegment src) {
        double[] d = this.data;
        MemorySegment seg = src;
        DoubleVector.fromMemorySegment(COL_SPECIES, seg, offset, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.data[0];
        dest[offset + 1] = (float) this.data[1];
        dest[offset + 2] = (float) this.data[2];
        dest[offset + 3] = (float) this.data[3];
        return dest;
    }
    public @Mutated DoubleQuat load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
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

    private static final VectorSpecies<Double> COL_SPECIES = DoubleVector.SPECIES_256;
    private static final VectorMask<Double> MASK_0 = VectorMask.fromValues(COL_SPECIES, true, true, true, false);
    private static final DoubleVector VEC_1 = DoubleVector.fromArray(COL_SPECIES, new double[]{0.0, 0.0, 0.0, 0.0}, 0);
    private static final DoubleVector VEC_2 = DoubleVector.fromArray(COL_SPECIES, new double[]{0.0, 0.0, 0.0, 1.0}, 0);

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
