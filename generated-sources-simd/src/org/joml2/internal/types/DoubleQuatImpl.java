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
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invertProduct(DoubleQuatR other, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t21 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[2], sd[1], -(otherData[1] * sd[2]));
        double _t22 = Math.fma(otherData[1], sd[0], otherData[2] * sd[3]) + Math.fma(otherData[3], sd[2], -(otherData[0] * sd[1]));
        double _t23 = Math.fma(otherData[0], sd[2], otherData[3] * sd[1]) + Math.fma(otherData[1], sd[3], -(otherData[2] * sd[0]));
        double _t24 = Math.fma(-otherData[2], sd[2], Math.fma(-otherData[1], sd[1], Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0]))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        dd[0] = -(_t21 * _t28_inv);
        dd[1] = -(_t23 * _t28_inv);
        dd[2] = -(_t22 * _t28_inv);
        dd[3] = _t24 * _t28_inv;
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
        double _t21 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        double _t22 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
        double _t23 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        double _t24 = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        dd[0] = -(_t21 * _t28_inv);
        dd[1] = -(_t23 * _t28_inv);
        dd[2] = -(_t22 * _t28_inv);
        dd[3] = _t24 * _t28_inv;
        return dest;
    }


    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param other the other quaternion
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
     * @param other the other quaternion
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
     * @param v the quaternion
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
     * @param dq the dual quaternion
     * @return this
     */
    @Mutated public DoubleQuat makeFromDualQuat(DoubleDualQuatR dq) {
        double[] dd = this.data;
        double[] dqData = ((DoubleDualQuatImpl) dq).data;
        dd[0] = dqData[0];
        dd[1] = dqData[1];
        dd[2] = dqData[2];
        dd[3] = dqData[3];
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
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double3x3R m) {
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private DoubleQuat makeFromMatrix_fma(Double3x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x3Impl) m).data;
        double _t0 = mData[0] + mData[4];
        double _t1 = mData[5] - mData[7];
        double _t4 = mData[3] + mData[1];
        double _t6 = mData[6] + mData[2];
        double _t7 = mData[6] - mData[2];
        double _t8 = mData[7] + mData[5];
        double _t9 = mData[1] - mData[3];
        double _t10 = mData[8] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (mData[0] - (mData[4] + mData[8]));
        double _t16 = 1.0 + (mData[4] - (mData[0] + mData[8]));
        double _t17 = 1.0 + (mData[8] - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t14)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[4], mData[8]) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[4] > mData[8] ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeFromMatrix_mulAdd(Double3x3R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x3Impl) m).data;
        double _t0 = mData[0] + mData[4];
        double _t1 = mData[5] - mData[7];
        double _t4 = mData[3] + mData[1];
        double _t6 = mData[6] + mData[2];
        double _t7 = mData[6] - mData[2];
        double _t8 = mData[7] + mData[5];
        double _t9 = mData[1] - mData[3];
        double _t10 = mData[8] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (mData[0] - (mData[4] + mData[8]));
        double _t16 = 1.0 + (mData[4] - (mData[0] + mData[8]));
        double _t17 = 1.0 + (mData[8] - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t14)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[4], mData[8]) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[4] > mData[8] ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double3x4R m) {
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private DoubleQuat makeFromMatrix_fma(Double3x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        double _t0 = mData[0] + mData[5];
        double _t1 = mData[9] - mData[6];
        double _t4 = mData[1] + mData[4];
        double _t6 = mData[2] + mData[8];
        double _t7 = mData[2] - mData[8];
        double _t8 = mData[6] + mData[9];
        double _t9 = mData[4] - mData[1];
        double _t10 = mData[10] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (mData[0] - (mData[5] + mData[10]));
        double _t16 = 1.0 + (mData[5] - (mData[0] + mData[10]));
        double _t17 = 1.0 + (mData[10] - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t14)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeFromMatrix_mulAdd(Double3x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double3x4Impl) m).data;
        double _t0 = mData[0] + mData[5];
        double _t1 = mData[9] - mData[6];
        double _t4 = mData[1] + mData[4];
        double _t6 = mData[2] + mData[8];
        double _t7 = mData[2] - mData[8];
        double _t8 = mData[6] + mData[9];
        double _t9 = mData[4] - mData[1];
        double _t10 = mData[10] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (mData[0] - (mData[5] + mData[10]));
        double _t16 = 1.0 + (mData[5] - (mData[0] + mData[10]));
        double _t17 = 1.0 + (mData[10] - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t14)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double4x4R m) {
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private DoubleQuat makeFromMatrix_fma(Double4x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double _t0 = mData[0] + mData[5];
        double _t1 = mData[6] - mData[9];
        double _t4 = mData[4] + mData[1];
        double _t6 = mData[8] + mData[2];
        double _t7 = mData[8] - mData[2];
        double _t8 = mData[9] + mData[6];
        double _t9 = mData[1] - mData[4];
        double _t10 = mData[10] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (mData[0] - (mData[5] + mData[10]));
        double _t16 = 1.0 + (mData[5] - (mData[0] + mData[10]));
        double _t17 = 1.0 + (mData[10] - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t14)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeFromMatrix_mulAdd(Double4x4R m) {
        double[] dd = this.data;
        double[] mData = ((Double4x4Impl) m).data;
        double _t0 = mData[0] + mData[5];
        double _t1 = mData[6] - mData[9];
        double _t4 = mData[4] + mData[1];
        double _t6 = mData[8] + mData[2];
        double _t7 = mData[8] - mData[2];
        double _t8 = mData[9] + mData[6];
        double _t9 = mData[1] - mData[4];
        double _t10 = mData[10] + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (mData[0] - (mData[5] + mData[10]));
        double _t16 = 1.0 + (mData[5] - (mData[0] + mData[10]));
        double _t17 = 1.0 + (mData[10] - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (_t10 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t14)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
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
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 0.0;
        dd[5] = 0.0;
        dd[6] = 0.0;
        dd[7] = 0.0;
        return dest;
    }


    /**
     * Compute the matrix representation of this quaternion and store the result in {@code dest}.
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
        dd[11] = 0.0;
        dd[12] = 0.0;
        dd[13] = 0.0;
        dd[14] = 0.0;
        dd[15] = 1.0;
        dd[0] = _buf0;
        dd[4] = _buf1;
        dd[8] = _buf2;
        ((Double4x4Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the 3x3 rotation matrix representation of this quaternion and store the result in
     * {@code dest}.
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
     * Compute the 3x4 matrix representation of this quaternion (the omitted last row is implicitly
     * {@code 0, 0, 0, 1}) and store the result in {@code dest}.
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
        ((Double3x4Impl) dest).properties = 0;
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
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axisX} followed
     * by a twist about {@code axisX}, storing them in {@code swing} and {@code twist} respectively,
     * such that {@code swing * twist} is this rotation.
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
        swingData[3] = Math.fma(sd[2], _t14, Math.fma(sd[1], _t13, Math.fma(sd[0], _t12, sd[3] * _t11)));
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
        dd[3] = Math.fma(sd[2], _t14, Math.fma(sd[1], _t13, Math.fma(sd[0], _t12, sd[3] * _t11)));
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
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = 1.0;
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
     *
     * @param other the other quaternion
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
        var _col0 = (_t11 > 0.0 ? _sv1.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t11)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
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
        var _col0 = (_t11 > 0.0 ? _sv1.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t11)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Interpolate between this quaternion and ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}) using the interpolation factor {@code alpha} and normalize the result and
     * store the result in {@code dest}.
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
        if (_t11 > 0.0) {
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
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv2 = DoubleVector.broadcast(COL_SPECIES, alpha).fma((-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? _sv0.neg() : _sv0).sub(_sv1), _sv1);
        double _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t24 > 0.0 ? _sv2.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t24)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat nlerpShortest_mulAdd(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv2 = DoubleVector.broadcast(COL_SPECIES, alpha).mul((-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0 ? _sv0.neg() : _sv0).sub(_sv1)).add(_sv1);
        double _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t24 > 0.0 ? _sv2.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t24)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Interpolate along the shortest path between this quaternion and ({@code targetX},
     * {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
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
        if (_t24 > 0.0) {
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
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _col0 = (Math.abs(_t8) > 0.0 ? _sv0.fma(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0 * _t7)), _sv1.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(COL_SPECIES, alpha).fma(_sv1, _sv0.mul(DoubleVector.broadcast(COL_SPECIES, _t0))));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat slerp_mulAdd(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] targetData = ((DoubleQuatImpl) target).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.fromArray(COL_SPECIES, targetData, 0);
        var _col0 = (Math.abs(_t8) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0 * _t7))).add(_sv1.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(COL_SPECIES, alpha).mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(COL_SPECIES, _t0))));
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
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.zero(COL_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _col0 = (Math.abs(_t8) > 0.0 ? _sv0.fma(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0 * _t7)), _sv1.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(COL_SPECIES, alpha).fma(_sv1, _sv0.mul(DoubleVector.broadcast(COL_SPECIES, _t0))));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat slerp_mulAdd(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = DoubleVector.zero(COL_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _col0 = (Math.abs(_t8) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0 * _t7))).add(_sv1.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(COL_SPECIES, alpha).mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(COL_SPECIES, _t0))));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha} and store the result
     * in {@code dest}.
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
        var _col0 = (_t49 > 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t49)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
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
        var _col0 = (_t49 > 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t49)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) using the
     * interpolation factor {@code alpha} and store the result in {@code dest}.
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
        if (_t49 > 0.0) {
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
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(control0Data[3], control1Data[3], Math.fma(control0Data[2], control1Data[2], Math.fma(control0Data[0], control1Data[0], control0Data[1] * control1Data[1]))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))));
        double _t35 = Math.sin(_t33);
        double _t35_inv = 1.0 / _t35;
        double _t36 = Math.sin(_t34);
        double _t36_inv = 1.0 / _t36;
        double _t37 = Math.abs(_t35);
        double _t39 = Math.abs(_t36);
        double _t41 = Math.sin(t * _t33);
        double _t42 = Math.sin(t * _t34);
        double _t45 = Math.sin(_t0 * _t33);
        double _t46 = Math.sin(_t0 * _t34);
        double _t71, _t73, _t75, _t77;
        if (_t37 > 0.0) {
            _t71 = Math.fma(control0Data[3], _t45, control1Data[3] * _t41) * _t35_inv;
            _t73 = Math.fma(control0Data[2], _t45, control1Data[2] * _t41) * _t35_inv;
            _t75 = Math.fma(control0Data[0], _t45, control1Data[0] * _t41) * _t35_inv;
            _t77 = Math.fma(control0Data[1], _t45, control1Data[1] * _t41) * _t35_inv;
        } else {
            _t71 = Math.fma(t, control1Data[3], control0Data[3] * _t0);
            _t73 = Math.fma(t, control1Data[2], control0Data[2] * _t0);
            _t75 = Math.fma(t, control1Data[0], control0Data[0] * _t0);
            _t77 = Math.fma(t, control1Data[1], control0Data[1] * _t0);
        }
        double _t72, _t74, _t76, _t78;
        if (_t39 > 0.0) {
            _t72 = Math.fma(sd[3], _t46, targetData[3] * _t42) * _t36_inv;
            _t74 = Math.fma(sd[2], _t46, targetData[2] * _t42) * _t36_inv;
            _t76 = Math.fma(sd[0], _t46, targetData[0] * _t42) * _t36_inv;
            _t78 = Math.fma(sd[1], _t46, targetData[1] * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetData[3], sd[3] * _t0);
            _t74 = Math.fma(t, targetData[2], sd[2] * _t0);
            _t76 = Math.fma(t, targetData[0], sd[0] * _t0);
            _t78 = Math.fma(t, targetData[1], sd[1] * _t0);
        }
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        if (_t87 > 0.0) {
            dd[0] = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            dd[1] = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            dd[2] = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            dd[3] = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            dd[0] = Math.fma(_t14, _t76, _t13 * _t75);
            dd[1] = Math.fma(_t14, _t78, _t13 * _t77);
            dd[2] = Math.fma(_t14, _t74, _t13 * _t73);
            dd[3] = Math.fma(_t14, _t72, _t13 * _t71);
        }
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
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        double _t35 = Math.sin(_t33);
        double _t35_inv = 1.0 / _t35;
        double _t36 = Math.sin(_t34);
        double _t36_inv = 1.0 / _t36;
        double _t37 = Math.abs(_t35);
        double _t39 = Math.abs(_t36);
        double _t41 = Math.sin(t * _t33);
        double _t42 = Math.sin(t * _t34);
        double _t45 = Math.sin(_t0 * _t33);
        double _t46 = Math.sin(_t0 * _t34);
        double _t71, _t73, _t75, _t77;
        if (_t37 > 0.0) {
            _t71 = Math.fma(control0W, _t45, control1W * _t41) * _t35_inv;
            _t73 = Math.fma(control0Z, _t45, control1Z * _t41) * _t35_inv;
            _t75 = Math.fma(control0X, _t45, control1X * _t41) * _t35_inv;
            _t77 = Math.fma(control0Y, _t45, control1Y * _t41) * _t35_inv;
        } else {
            _t71 = Math.fma(t, control1W, control0W * _t0);
            _t73 = Math.fma(t, control1Z, control0Z * _t0);
            _t75 = Math.fma(t, control1X, control0X * _t0);
            _t77 = Math.fma(t, control1Y, control0Y * _t0);
        }
        double _t72, _t74, _t76, _t78;
        if (_t39 > 0.0) {
            _t72 = Math.fma(sd[3], _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(sd[2], _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(sd[0], _t46, targetX * _t42) * _t36_inv;
            _t78 = Math.fma(sd[1], _t46, targetY * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, sd[3] * _t0);
            _t74 = Math.fma(t, targetZ, sd[2] * _t0);
            _t76 = Math.fma(t, targetX, sd[0] * _t0);
            _t78 = Math.fma(t, targetY, sd[1] * _t0);
        }
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        if (_t87 > 0.0) {
            dd[0] = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            dd[1] = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            dd[2] = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            dd[3] = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            dd[0] = Math.fma(_t14, _t76, _t13 * _t75);
            dd[1] = Math.fma(_t14, _t78, _t13 * _t77);
            dd[2] = Math.fma(_t14, _t74, _t13 * _t73);
            dd[3] = Math.fma(_t14, _t72, _t13 * _t71);
        }
        return dest;
    }


    /**
     * Multiply this quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param other the other quaternion
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
        dd[3] = Math.fma(-otherData[2], sd[2], Math.fma(-otherData[1], sd[1], Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0]))));
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
        dd[3] = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
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
     * @param other the other quaternion
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
        dd[3] = Math.fma(-otherData[2], sd[2], Math.fma(-otherData[1], sd[1], Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0]))));
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
        dd[3] = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     *
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    public double angle() {
        double[] sd = this.data;
        return 2.0 * Math.acos(Math.min(1.0, Math.max(-1.0, sd[3])));
    }


    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the angle in radians between this quaternion and {@code other}
     */
    public double angleTo(DoubleQuatR other) {
        return angleTo(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the angle in radians between this quaternion and ({@code otherX}, {@code otherY},
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
     * @return the angle in radians between this quaternion and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public double angleTo(double otherX, double otherY, double otherZ, double otherW) {
        double[] sd = this.data;
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(otherW, sd[3], Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1]))))));
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
     * @param q the quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugateBy(DoubleQuatR q, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] qData = ((DoubleQuatImpl) q).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t1 = -qData[1];
        double _t21 = Math.fma(qData[0], sd[1], qData[3] * sd[2]) + Math.fma(qData[2], sd[3], -(qData[1] * sd[0]));
        double _t22 = Math.fma(qData[1], sd[3], qData[2] * sd[0]) + Math.fma(qData[3], sd[1], -(qData[0] * sd[2]));
        double _t23 = Math.fma(qData[0], sd[3], qData[3] * sd[0]) + Math.fma(qData[1], sd[2], -(qData[2] * sd[1]));
        double _t24 = Math.fma(-qData[2], sd[2], Math.fma(_t1, sd[1], Math.fma(qData[3], sd[3], -(qData[0] * sd[0]))));
        double _buf0 = Math.fma(qData[1], _t21, -(qData[2] * _t22)) + Math.fma(qData[3], _t23, -(qData[0] * _t24));
        double _buf1 = Math.fma(qData[2], _t23, -(qData[1] * _t24)) + Math.fma(qData[3], _t22, -(qData[0] * _t21));
        double _buf2 = Math.fma(qData[0], _t22, qData[3] * _t21) + Math.fma(_t1, _t23, -(qData[2] * _t24));
        dd[3] = Math.fma(qData[2], _t21, Math.fma(qData[1], _t22, Math.fma(qData[0], _t23, qData[3] * _t24)));
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
        double _t1 = -qY;
        double _t21 = Math.fma(qX, sd[1], qW * sd[2]) + Math.fma(qZ, sd[3], -(qY * sd[0]));
        double _t22 = Math.fma(qY, sd[3], qZ * sd[0]) + Math.fma(qW, sd[1], -(qX * sd[2]));
        double _t23 = Math.fma(qX, sd[3], qW * sd[0]) + Math.fma(qY, sd[2], -(qZ * sd[1]));
        double _t24 = Math.fma(-qZ, sd[2], Math.fma(_t1, sd[1], Math.fma(qW, sd[3], -(qX * sd[0]))));
        dd[0] = Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24));
        dd[1] = Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21));
        dd[2] = Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24));
        dd[3] = Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24)));
        return dest;
    }


    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation that,
     * applied after {@code this}, results in {@code other} and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat difference(DoubleQuatR other, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] otherData = ((DoubleQuatImpl) other).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t3_inv = 1.0 / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        var _col0 = DoubleVector.broadcast(COL_SPECIES, Math.fma(otherData[0], sd[3], -(otherData[3] * sd[0]))).withLane(2, Math.fma(otherData[0], sd[1], -(otherData[3] * sd[2]))).add(DoubleVector.broadcast(COL_SPECIES, Math.fma(otherData[1], sd[2], -(otherData[2] * sd[1]))).withLane(2, Math.fma(otherData[2], sd[3], -(otherData[1] * sd[0])))).withLane(3, Math.fma(otherData[2], sd[2], Math.fma(otherData[1], sd[1], Math.fma(otherData[0], sd[0], otherData[3] * sd[3])))).mul(DoubleVector.broadcast(COL_SPECIES, _t3_inv)).withLane(1, -(otherData[3] * sd[1] * _t3_inv) - otherData[0] * sd[2] * _t3_inv + Math.fma(otherData[1], sd[3], otherData[2] * sd[0]) * _t3_inv);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Compute the difference between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}), i.e. the rotation that, applied after {@code this}, results
     * in ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) and store the result in
     * {@code dest}.
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
        var _col0 = DoubleVector.broadcast(COL_SPECIES, Math.fma(otherX, sd[3], -(otherW * sd[0]))).withLane(2, Math.fma(otherX, sd[1], -(otherW * sd[2]))).add(DoubleVector.broadcast(COL_SPECIES, Math.fma(otherY, sd[2], -(otherZ * sd[1]))).withLane(2, Math.fma(otherZ, sd[3], -(otherY * sd[0])))).withLane(3, Math.fma(otherZ, sd[2], Math.fma(otherY, sd[1], Math.fma(otherX, sd[0], otherW * sd[3])))).mul(DoubleVector.broadcast(COL_SPECIES, _t3_inv)).withLane(1, -(otherW * sd[1] * _t3_inv) - otherX * sd[2] * _t3_inv + Math.fma(otherY, sd[3], otherZ * sd[0]) * _t3_inv);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param other the other quaternion
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
        var _col0 = (_t3 > 0.0 ? DoubleVector.fromArray(COL_SPECIES, sd, 0).withLane(3, Math.cos(_t4)).mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3))).withLane(3, _t0)) : DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cos(_t4) * _t0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        dd[2] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, _t9)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        dd[2] = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        dd[0] = Math.asin(Math.min(1.0, Math.max(-1.0, _t7)));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
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
        dd[1] = Math.asin(Math.min(1.0, Math.max(-1.0, _t8)));
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
        double _t9 = Math.cos(_t7);
        double _t11 = Math.sin(_t7) * (1.0 / Math.sqrt(_t6));
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
        double _buf0 = Math.fma(sd[0], _t9, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        double _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t9, -(sd[2] * _t15));
        double _buf2 = Math.fma(sd[1], _t15, sd[2] * _t9) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(-sd[2], _t17, Math.fma(-sd[1], _t16, Math.fma(sd[3], _t9, -(sd[0] * _t15))));
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
        double _t9 = Math.cos(_t7);
        double _t11 = Math.sin(_t7) * (1.0 / Math.sqrt(_t6));
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
        double _buf0 = Math.fma(sd[0], _t9, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        double _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t9, -(sd[2] * _t15));
        double _buf2 = Math.fma(sd[1], _t15, sd[2] * _t9) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(-sd[2], _t17, Math.fma(-sd[1], _t16, Math.fma(sd[3], _t9, -(sd[0] * _t15))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeX(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = -(_t9 * _t13);
            dd[1] = -(_t8 * _t13);
            dd[2] = -(_t7 * _t13);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeY(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = -(_t7 * _t13);
            dd[1] = -(_t9 * _t13);
            dd[2] = -(_t8 * _t13);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeZ(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = -(_t8 * _t13);
            dd[1] = -(_t7 * _t13);
            dd[2] = -(_t9 * _t13);
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveX(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = _t9 * _t13;
            dd[1] = _t8 * _t13;
            dd[2] = _t7 * _t13;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveY(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = _t7 * _t13;
            dd[1] = _t9 * _t13;
            dd[2] = _t8 * _t13;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveZ(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = _t8 * _t13;
            dd[1] = _t7 * _t13;
            dd[2] = _t9 * _t13;
        } else {
            dd[0] = 0.0;
            dd[1] = 0.0;
            dd[2] = 0.0;
        }
        return dest;
    }


    /**
     * Compute the length of this quaternion.
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat log(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t4 = Math.fma(sd[3], sd[3], _t2);
        var _col0 = (_t2 > 0.0 ? DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.acos(sd[3] * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2)))).withLane(3, Math.log(Math.sqrt(_t4))) : DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.log(Math.sqrt(_t4))));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeX(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = -(_t9 * _t13);
            dd[1] = -(_t7 * _t13);
            dd[2] = -(_t8 * _t13);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeY(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = -(_t8 * _t13);
            dd[1] = -(_t9 * _t13);
            dd[2] = -(_t7 * _t13);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeZ(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = -(_t7 * _t13);
            dd[1] = -(_t8 * _t13);
            dd[2] = -(_t9 * _t13);
        } else {
            dd[0] = -0.0;
            dd[1] = -0.0;
            dd[2] = -0.0;
        }
        return dest;
    }


    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat normalize(@Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        var _sv0 = DoubleVector.fromArray(COL_SPECIES, sd, 0);
        double _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t3 > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t3)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveX(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = _t9 * _t13;
            dd[1] = _t7 * _t13;
            dd[2] = _t8 * _t13;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveY(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        double _t8 = 2.0 * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = _t8 * _t13;
            dd[1] = _t9 * _t13;
            dd[2] = _t7 * _t13;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveZ(@Mutated Double3 dest) {
        double[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        double _t7 = 2.0 * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        double _t8 = 2.0 * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        double _t9 = Math.fma(-2.0, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dd[0] = _t7 * _t13;
            dd[1] = _t8 * _t13;
            dd[2] = _t9 * _t13;
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
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat pow(double t, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        double _t4 = Math.fma(sd[3], sd[3], _t2);
        double _t11 = Math.exp(t * Math.log(Math.sqrt(_t4)));
        double _t12 = Math.acos(sd[3] * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        double _t19 = t * (_t2 > 0.0 ? sd[2] * _t12 : 0.0);
        double _t20 = t * (_t2 > 0.0 ? sd[0] * _t12 : 0.0);
        double _t21 = t * (_t2 > 0.0 ? sd[1] * _t12 : 0.0);
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = Math.sqrt(_t24);
        var _col0 = (_t24 > 0.0 ? DoubleVector.zero(COL_SPECIES).withLane(0, _t20).withLane(1, _t21).withLane(2, _t19).withLane(3, Math.cos(_t25)).mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t25) * _t11 * (1.0 / Math.sqrt(_t24))).withLane(3, _t11)) : DoubleVector.broadcast(COL_SPECIES, 0.0).withLane(3, Math.cos(_t25) * _t11));
        _col0.intoArray(dd, 0);
        return dest;
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
     * @param other the other quaternion
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
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0 ? _sv0.fma(DoubleVector.broadcast(COL_SPECIES, Math.sin((1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0)) * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))), DoubleVector.broadcast(COL_SPECIES, Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) * (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0))).mul(_sv2)).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : _sv0.fma(DoubleVector.broadcast(COL_SPECIES, 1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0)), _sv2.mul(DoubleVector.broadcast(COL_SPECIES, 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0))));
        double _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t53 > 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t53)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
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
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sin((1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0)) * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))).add(DoubleVector.broadcast(COL_SPECIES, Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) * (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0))).mul(_sv2)).mul(DoubleVector.broadcast(COL_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : _sv0.mul(DoubleVector.broadcast(COL_SPECIES, 1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0))).add(_sv2.mul(DoubleVector.broadcast(COL_SPECIES, 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))) : 0.0))));
        double _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t53 > 0.0 ? _sv3.mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t53)))) : DoubleVector.broadcast(COL_SPECIES, 0.0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Rotate this quaternion towards ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}), by at most the given maximum angle and store the result in {@code dest}.
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
        double _t13 = 2.0 * _t11;
        double _t15, _t16, _t17, _t18;
        if (_t9 > 0.0) {
            _t15 = -targetW;
            _t16 = -targetZ;
            _t17 = -targetX;
            _t18 = -targetY;
        } else {
            _t15 = targetW;
            _t16 = targetZ;
            _t17 = targetX;
            _t18 = targetY;
        }
        double _t20 = _t13 > 0.0 ? Math.min(1.0, step / _t13) : 0.0;
        double _t21 = 1.0 - _t20;
        double _t23 = Math.sin(_t11 * _t20);
        double _t25 = Math.sin(_t21 * _t11);
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
            _t46 = Math.fma(sd[3], _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(sd[2], _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(sd[0], _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(sd[1], _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(sd[3], _t21, _t15 * _t20);
            _t47 = Math.fma(sd[2], _t21, _t16 * _t20);
            _t48 = Math.fma(sd[0], _t21, _t17 * _t20);
            _t49 = Math.fma(sd[1], _t21, _t18 * _t20);
        }
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            dd[0] = _t54 * _t48;
            dd[1] = _t54 * _t49;
            dd[2] = _t54 * _t47;
            dd[3] = _t54 * _t46;
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
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lookAlong(Double3R dir, Double3R up, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirData[2] * _t3;
            _t8 = dirData[1] * _t3;
            _t9 = dirData[0] * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upData[0], _t8, -(upData[1] * _t9));
        double _t22 = Math.fma(upData[1], _t7, -(upData[2] * _t8));
        double _t23 = Math.fma(upData[2], _t9, -(upData[0] * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t110, sd[3] * _t111) + Math.fma(sd[1], _t108, -(sd[2] * _t109));
        double _buf1 = Math.fma(sd[1], _t110, sd[2] * _t111) + Math.fma(sd[3], _t109, -(sd[0] * _t108));
        double _buf2 = Math.fma(sd[0], _t109, sd[3] * _t108) + Math.fma(sd[2], _t110, -(sd[1] * _t111));
        dd[3] = Math.fma(-sd[2], _t108, Math.fma(-sd[1], _t109, Math.fma(sd[3], _t110, -(sd[0] * _t111))));
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
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        double _buf0 = Math.fma(sd[0], _t110, sd[3] * _t111) + Math.fma(sd[1], _t108, -(sd[2] * _t109));
        double _buf1 = Math.fma(sd[1], _t110, sd[2] * _t111) + Math.fma(sd[3], _t109, -(sd[0] * _t108));
        double _buf2 = Math.fma(sd[0], _t109, sd[3] * _t108) + Math.fma(sd[2], _t110, -(sd[1] * _t111));
        dd[3] = Math.fma(-sd[2], _t108, Math.fma(-sd[1], _t109, Math.fma(sd[3], _t110, -(sd[0] * _t111))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    @Mutated public DoubleQuat makeRotationAxis(double angle, Double3R axis) {
        if (SimdMath.USE_FMA) return makeRotationAxis_fma(angle, axis);
        return makeRotationAxis_mulAdd(angle, axis);
    }

    private DoubleQuat makeRotationAxis_fma(double angle, Double3R axis) {
        double[] dd = this.data;
        double[] axisData = ((Double3Impl) axis).data;
        double _t0 = 0.5 * angle;
        var _col0 = DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, axisData[0]).withLane(1, axisData[1]).withLane(2, axisData[2]).mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationAxis_mulAdd(double angle, Double3R axis) {
        double[] dd = this.data;
        double[] axisData = ((Double3Impl) axis).data;
        double _t0 = 0.5 * angle;
        var _col0 = DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, axisData[0]).withLane(1, axisData[1]).withLane(2, axisData[2]).mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0))));
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
        if (SimdMath.USE_FMA) return makeRotationAxis_fma(angle, axisX, axisY, axisZ);
        return makeRotationAxis_mulAdd(angle, axisX, axisY, axisZ);
    }

    private DoubleQuat makeRotationAxis_fma(double angle, double axisX, double axisY, double axisZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        var _col0 = DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationAxis_mulAdd(double angle, double axisX, double axisY, double axisZ) {
        double[] dd = this.data;
        double _t0 = 0.5 * angle;
        var _col0 = DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(DoubleVector.broadcast(COL_SPECIES, Math.sin(_t0))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
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
        double _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? dirData[2] * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? dirData[1] * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? dirData[0] * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upData[0], _t8, -(upData[1] * _t9));
        double _t22 = Math.fma(upData[1], _t7, -(upData[2] * _t8));
        double _t23 = Math.fma(upData[2], _t9, -(upData[0] * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t60)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationLookAlong_mulAdd(Double3R dir, Double3R up) {
        double[] dd = this.data;
        double[] dirData = ((Double3Impl) dir).data;
        double[] upData = ((Double3Impl) up).data;
        double _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? dirData[2] * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? dirData[1] * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? dirData[0] * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upData[0], _t8, -(upData[1] * _t9));
        double _t22 = Math.fma(upData[1], _t7, -(upData[2] * _t8));
        double _t23 = Math.fma(upData[2], _t9, -(upData[0] * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t60)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to a rotation that makes {@code +z} point along ({@code dirX},
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
    @Mutated public DoubleQuat makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (SimdMath.USE_FMA) return makeRotationLookAlong_fma(dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_mulAdd(dirX, dirY, dirZ, upX, upY, upZ);
    }

    private DoubleQuat makeRotationLookAlong_fma(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? dirZ * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? dirY * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? dirX * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t60)).fma(VEC_1, DoubleVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationLookAlong_mulAdd(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double[] dd = this.data;
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? dirZ * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? dirY * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? dirX * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(COL_SPECIES, 0.5);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0 ? _sv0.mul(DoubleVector.broadcast(COL_SPECIES, Math.sqrt(_t60)).mul(VEC_1).add(DoubleVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(COL_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation that rotates {@code fromDir} onto {@code toDir} (both
     * must be unit vectors; for opposite vectors an arbitrary perpendicular rotation axis is
     * chosen).
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @return this
     */
    @Mutated public DoubleQuat makeRotationTo(Double3R fromDir, Double3R toDir) {
        double[] dd = this.data;
        double[] fromDirData = ((Double3Impl) fromDir).data;
        double[] toDirData = ((Double3Impl) toDir).data;
        double _t4 = Math.fma(fromDirData[0], fromDirData[0], fromDirData[1] * fromDirData[1]);
        double _t6, _t8, _t9;
        if (_t4 > 0.0) {
            _t6 = fromDirData[1];
            _t8 = 0.0;
            _t9 = -fromDirData[0];
        } else {
            _t6 = 0.0;
            _t8 = -fromDirData[1];
            _t9 = fromDirData[2];
        }
        double _t7 = Math.fma(fromDirData[0], toDirData[0], Math.fma(fromDirData[1], toDirData[1], Math.fma(fromDirData[2], toDirData[2], 1.0)));
        double _t10 = 2.0 * _t7;
        double _t11 = (1.0 / Math.sqrt(_t10));
        double _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        double _t15 = (1.0 / Math.sqrt(_t14));
        if (_t7 > 1.0E-6) {
            dd[0] = Math.fma(fromDirData[1], toDirData[2], -(fromDirData[2] * toDirData[1])) * _t11;
            dd[1] = Math.fma(fromDirData[2], toDirData[0], -(fromDirData[0] * toDirData[2])) * _t11;
            dd[2] = Math.fma(fromDirData[0], toDirData[1], -(fromDirData[1] * toDirData[0])) * _t11;
            dd[3] = 0.5 * Math.sqrt(_t10);
        } else {
            if (_t14 > 0.0) {
                dd[0] = _t15 * _t6;
                dd[1] = _t15 * _t9;
                dd[2] = _t15 * _t8;
                dd[3] = 0.0;
            } else {
                dd[0] = 0.0;
                dd[1] = 0.0;
                dd[2] = 0.0;
                dd[3] = 0.0;
            }
        }
        return this;
    }


    /**
     * Set this quaternion to the rotation that rotates ({@code fromDirX}, {@code fromDirY},
     * {@code fromDirZ}) onto ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen).
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
        double[] dd = this.data;
        double _t4 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t6, _t8, _t9;
        if (_t4 > 0.0) {
            _t6 = fromDirY;
            _t8 = 0.0;
            _t9 = -fromDirX;
        } else {
            _t6 = 0.0;
            _t8 = -fromDirY;
            _t9 = fromDirZ;
        }
        double _t7 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0)));
        double _t10 = 2.0 * _t7;
        double _t11 = (1.0 / Math.sqrt(_t10));
        double _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        double _t15 = (1.0 / Math.sqrt(_t14));
        if (_t7 > 1.0E-6) {
            dd[0] = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11;
            dd[1] = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11;
            dd[2] = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11;
            dd[3] = 0.5 * Math.sqrt(_t10);
        } else {
            if (_t14 > 0.0) {
                dd[0] = _t15 * _t6;
                dd[1] = _t15 * _t9;
                dd[2] = _t15 * _t8;
                dd[3] = 0.0;
            } else {
                dd[0] = 0.0;
                dd[1] = 0.0;
                dd[2] = 0.0;
                dd[3] = 0.0;
            }
        }
        return this;
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
        dd[0] = Math.sin(_t0);
        dd[1] = 0.0;
        dd[2] = 0.0;
        dd[3] = Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleY} and {@code angleZ}
     * radians about the X, Y and Z axes, in that order.
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
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        dd[0] = Math.fma(_t9, _t5, _t10 * _t8);
        dd[1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dd[2] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationXZY(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t8, -(_t12 * _t5));
        dd[2] = Math.fma(_t9, _t8, _t10 * _t5);
        dd[3] = Math.fma(_t12, _t8, _t11 * _t5);
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
        dd[0] = 0.0;
        dd[1] = Math.sin(_t0);
        dd[2] = 0.0;
        dd[3] = Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationYXZ(double angleX, double angleY, double angleZ) {
        if (SimdMath.USE_FMA) return makeRotationYXZ_fma(angleX, angleY, angleZ);
        return makeRotationYXZ_mulAdd(angleX, angleY, angleZ);
    }

    private DoubleQuat makeRotationYXZ_fma(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
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
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).fma(DoubleVector.broadcast(COL_SPECIES, _t5), DoubleVector.broadcast(COL_SPECIES, _t10).withLane(3, _t12).mul(DoubleVector.broadcast(COL_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _col0.intoArray(dd, 0);
        return this;
    }

    private DoubleQuat makeRotationYXZ_mulAdd(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
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
        var _col0 = DoubleVector.zero(COL_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).mul(DoubleVector.broadcast(COL_SPECIES, _t5)).add(DoubleVector.broadcast(COL_SPECIES, _t10).withLane(3, _t12).mul(DoubleVector.broadcast(COL_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationYZX(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t5, _t10 * _t8);
        dd[1] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[2] = Math.fma(_t12, _t5, -(_t11 * _t8));
        dd[3] = Math.fma(_t10, _t5, -(_t9 * _t8));
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
        dd[0] = 0.0;
        dd[1] = 0.0;
        dd[2] = Math.sin(_t0);
        dd[3] = Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationZXY(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[2] = Math.fma(_t9, _t8, _t10 * _t5);
        dd[3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public DoubleQuat makeRotationZYX(double angleX, double angleY, double angleZ) {
        double[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t8, _t12 * _t5);
        dd[2] = Math.fma(_t12, _t8, -(_t11 * _t5));
        dd[3] = Math.fma(_t10, _t5, _t9 * _t8);
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
        if (SimdMath.USE_FMA) return preRotateX_fma(angle, dest);
        return preRotateX_mulAdd(angle, dest);
    }

    private DoubleQuat preRotateX_fma(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)), DoubleVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(2, sd[1]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(1, sd[2]).withLane(3, sd[0]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat preRotateX_mulAdd(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0))).add(DoubleVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(2, sd[1]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(1, sd[2]).withLane(3, sd[0]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return preRotateY_fma(angle, dest);
        return preRotateY_mulAdd(angle, dest);
    }

    private DoubleQuat preRotateY_fma(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)), DoubleVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(1, sd[3]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(2, sd[0]).withLane(3, sd[1]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat preRotateY_mulAdd(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0))).add(DoubleVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(1, sd[3]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(2, sd[0]).withLane(3, sd[1]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
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
        if (SimdMath.USE_FMA) return preRotateZ_fma(angle, dest);
        return preRotateZ_mulAdd(angle, dest);
    }

    private DoubleQuat preRotateZ_fma(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)), DoubleVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(2, sd[3]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(3, sd[2]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat preRotateZ_mulAdd(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0))).add(DoubleVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(2, sd[3]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(3, sd[2]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
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
        double[] sd = this.data;
        double[] axisData = ((Double3Impl) axis).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisData[0] * _t2;
        double _t4 = axisData[2] * _t2;
        double _t5 = axisData[1] * _t2;
        double _buf0 = Math.fma(sd[0], _t1, sd[3] * _t3) + Math.fma(sd[1], _t4, -(sd[2] * _t5));
        double _buf1 = Math.fma(sd[1], _t1, sd[2] * _t3) + Math.fma(sd[3], _t5, -(sd[0] * _t4));
        double _buf2 = Math.fma(sd[0], _t5, sd[3] * _t4) + Math.fma(sd[2], _t1, -(sd[1] * _t3));
        dd[3] = Math.fma(-sd[2], _t4, Math.fma(-sd[1], _t5, Math.fma(sd[3], _t1, -(sd[0] * _t3))));
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
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        double _buf0 = Math.fma(sd[0], _t1, sd[3] * _t3) + Math.fma(sd[1], _t4, -(sd[2] * _t5));
        double _buf1 = Math.fma(sd[1], _t1, sd[2] * _t3) + Math.fma(sd[3], _t5, -(sd[0] * _t4));
        double _buf2 = Math.fma(sd[0], _t5, sd[3] * _t4) + Math.fma(sd[2], _t1, -(sd[1] * _t3));
        dd[3] = Math.fma(-sd[2], _t4, Math.fma(-sd[1], _t5, Math.fma(sd[3], _t1, -(sd[0] * _t3))));
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
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTo(Double3R fromDir, Double3R toDir, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] fromDirData = ((Double3Impl) fromDir).data;
        double[] toDirData = ((Double3Impl) toDir).data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t10 = Math.fma(fromDirData[0], fromDirData[0], fromDirData[1] * fromDirData[1]);
        double _t15, _t17, _t18;
        if (_t10 > 0.0) {
            _t15 = fromDirData[1];
            _t17 = 0.0;
            _t18 = -fromDirData[0];
        } else {
            _t15 = 0.0;
            _t17 = -fromDirData[1];
            _t18 = fromDirData[2];
        }
        double _t16 = Math.fma(fromDirData[0], toDirData[0], Math.fma(fromDirData[1], toDirData[1], Math.fma(fromDirData[2], toDirData[2], 1.0)));
        double _t19 = 2.0 * _t16;
        double _t21 = (1.0 / Math.sqrt(_t19));
        double _t27 = _t16 > 1.0E-6 ? 0.5 * Math.sqrt(_t19) : 0.0;
        double _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t37, _t38, _t39;
        if (_t16 > 1.0E-6) {
            _t37 = Math.fma(fromDirData[1], toDirData[2], -(fromDirData[2] * toDirData[1])) * _t21;
            _t38 = Math.fma(fromDirData[0], toDirData[1], -(fromDirData[1] * toDirData[0])) * _t21;
            _t39 = Math.fma(fromDirData[2], toDirData[0], -(fromDirData[0] * toDirData[2])) * _t21;
        } else {
            if (_t29 > 0.0) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0;
                _t38 = 0.0;
                _t39 = 0.0;
            }
        }
        double _buf0 = Math.fma(sd[0], _t27, sd[3] * _t37) + Math.fma(sd[1], _t38, -(sd[2] * _t39));
        double _buf1 = Math.fma(sd[1], _t27, sd[2] * _t37) + Math.fma(sd[3], _t39, -(sd[0] * _t38));
        double _buf2 = Math.fma(sd[0], _t39, sd[3] * _t38) + Math.fma(sd[2], _t27, -(sd[1] * _t37));
        dd[3] = Math.fma(-sd[2], _t38, Math.fma(-sd[1], _t39, Math.fma(sd[3], _t27, -(sd[0] * _t37))));
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
        double _t10 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t15, _t17, _t18;
        if (_t10 > 0.0) {
            _t15 = fromDirY;
            _t17 = 0.0;
            _t18 = -fromDirX;
        } else {
            _t15 = 0.0;
            _t17 = -fromDirY;
            _t18 = fromDirZ;
        }
        double _t16 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0)));
        double _t19 = 2.0 * _t16;
        double _t21 = (1.0 / Math.sqrt(_t19));
        double _t27 = _t16 > 1.0E-6 ? 0.5 * Math.sqrt(_t19) : 0.0;
        double _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t37, _t38, _t39;
        if (_t16 > 1.0E-6) {
            _t37 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t21;
            _t38 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t21;
            _t39 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t21;
        } else {
            if (_t29 > 0.0) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0;
                _t38 = 0.0;
                _t39 = 0.0;
            }
        }
        double _buf0 = Math.fma(sd[0], _t27, sd[3] * _t37) + Math.fma(sd[1], _t38, -(sd[2] * _t39));
        double _buf1 = Math.fma(sd[1], _t27, sd[2] * _t37) + Math.fma(sd[3], _t39, -(sd[0] * _t38));
        double _buf2 = Math.fma(sd[0], _t39, sd[3] * _t38) + Math.fma(sd[2], _t27, -(sd[1] * _t37));
        dd[3] = Math.fma(-sd[2], _t38, Math.fma(-sd[1], _t39, Math.fma(sd[3], _t27, -(sd[0] * _t37))));
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
        if (SimdMath.USE_FMA) return rotateX_fma(angle, dest);
        return rotateX_mulAdd(angle, dest);
    }

    private DoubleQuat rotateX_fma(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)), DoubleVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(1, sd[2]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(2, sd[1]).withLane(3, sd[0]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat rotateX_mulAdd(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0))).add(DoubleVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(1, sd[2]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(2, sd[1]).withLane(3, sd[0]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this quaternion and store the result in {@code dest}.
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
        double _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this quaternion and store the result in {@code dest}.
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
    public DoubleQuat rotateXZY(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        double _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t21))));
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
        if (SimdMath.USE_FMA) return rotateY_fma(angle, dest);
        return rotateY_mulAdd(angle, dest);
    }

    private DoubleQuat rotateY_fma(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)), DoubleVector.zero(COL_SPECIES).withLane(1, sd[3]).withLane(2, sd[0]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(3, sd[1]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat rotateY_mulAdd(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0))).add(DoubleVector.zero(COL_SPECIES).withLane(1, sd[3]).withLane(2, sd[0]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(3, sd[1]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this quaternion and store the result in {@code dest}.
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
    public DoubleQuat rotateYXZ(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t20) + Math.fma(sd[1], _t21, -(sd[2] * _t22));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t20) + Math.fma(sd[3], _t22, -(sd[0] * _t21));
        double _buf2 = Math.fma(sd[0], _t22, sd[3] * _t21) + Math.fma(sd[2], _t19, -(sd[1] * _t20));
        dd[3] = Math.fma(-sd[2], _t21, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t20))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this quaternion and store the result in {@code dest}.
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
    public DoubleQuat rotateYZX(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t22, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
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
        if (SimdMath.USE_FMA) return rotateZ_fma(angle, dest);
        return rotateZ_mulAdd(angle, dest);
    }

    private DoubleQuat rotateZ_fma(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).fma(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0)), DoubleVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(2, sd[3]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(3, sd[2]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private DoubleQuat rotateZ_mulAdd(double angle, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        double _t0 = 0.5 * angle;
        double _t2 = Math.sin(_t0);
        var _col0 = DoubleVector.fromArray(COL_SPECIES, sd, 0).mul(DoubleVector.broadcast(COL_SPECIES, Math.cos(_t0))).add(DoubleVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(2, sd[3]).mul(DoubleVector.broadcast(COL_SPECIES, _t2)).blend(DoubleVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(3, sd[2]).mul(DoubleVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this quaternion and store the result in {@code dest}.
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
    public DoubleQuat rotateZXY(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        double _buf0 = Math.fma(sd[0], _t21, sd[3] * _t22) + Math.fma(sd[1], _t19, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t21, sd[2] * _t22) + Math.fma(sd[3], _t20, -(sd[0] * _t19));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t19) + Math.fma(sd[2], _t21, -(sd[1] * _t22));
        dd[3] = Math.fma(-sd[2], _t19, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t22))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this quaternion and store the result in {@code dest}.
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
    public DoubleQuat rotateZYX(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        double[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        double _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        double _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        double _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(-sd[2], _t22, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t19, -(sd[0] * _t21))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Transform {@code v} by this quaternion and store the result in {@code dest}.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Double3R v, @Mutated Double3 dest) {
        return transform(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this quaternion and store the result in
     * {@code dest}.
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
     * @param v the vector
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
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 8;
            DoubleVector.fromMemorySegment(COL_SPECIES, seg, baseOff, ByteOrder.nativeOrder()).intoArray(d, 0);
        }
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        double[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        DoubleVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, index, ByteOrder.nativeOrder());
        return buf;
    }
    public DoubleQuat loadAbsolute(int index, ByteBuffer buf) {
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
    private static final VectorMask<Double> MASK_2 = VectorMask.fromValues(COL_SPECIES, false, true, false, true);
    private static final VectorMask<Double> MASK_3 = VectorMask.fromValues(COL_SPECIES, false, false, true, true);
    private static final VectorMask<Double> MASK_4 = VectorMask.fromValues(COL_SPECIES, true, false, false, true);
    private static final DoubleVector VEC_1 = DoubleVector.fromArray(COL_SPECIES, new double[]{0.0, 0.0, 0.0, 1.0}, 0);

}
