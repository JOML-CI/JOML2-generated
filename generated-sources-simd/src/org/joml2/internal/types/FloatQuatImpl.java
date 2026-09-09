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
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatQuat} backed by a {@code float[]} array, with Vector API
 * SIMD kernels where profitable.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatQuatImpl implements FloatQuat {

    public float[] data;
    static final FloatQuatSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatQuatSegOpsUnsafe()
                    : new FloatQuatSegOpsMS();
    static final FloatQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatQuatBbOpsUnsafe()
                    : new FloatQuatBbOpsApi();
    static final FloatQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatQuatRawOpsUnsafe()
                    : new FloatQuatRawOpsApi();

    public FloatQuatImpl() {
        data = new float[4];
        data[3] = 1;
    }


    /**
     * Invert this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat invert(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t3_inv = 1.0f / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = _sv0.mul(FloatVector.broadcast(COL_SPECIES, _t3_inv)).blend(_sv0.mul(FloatVector.broadcast(COL_SPECIES, -_t3_inv)), MASK_0);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Invert this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invert(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t3 = Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        float _t3_inv = 1.0f / _t3;
        dd[0] = -(sd[0] * _t3_inv);
        dd[1] = -(sd[1] * _t3_inv);
        dd[2] = -(sd[2] * _t3_inv);
        dd[3] = sd[3] * _t3_inv;
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
    public FloatQuat invertProduct(FloatQuatR other, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t21 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[2], sd[1], -(otherData[1] * sd[2]));
        float _t22 = Math.fma(otherData[1], sd[0], otherData[2] * sd[3]) + Math.fma(otherData[3], sd[2], -(otherData[0] * sd[1]));
        float _t23 = Math.fma(otherData[0], sd[2], otherData[3] * sd[1]) + Math.fma(otherData[1], sd[3], -(otherData[2] * sd[0]));
        float _t24 = Math.fma(-otherData[2], sd[2], Math.fma(-otherData[1], sd[1], Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0]))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        dd[0] = -(_t21 * _t28_inv);
        dd[1] = -(_t23 * _t28_inv);
        dd[2] = -(_t22 * _t28_inv);
        dd[3] = _t24 * _t28_inv;
        return dest;
    }


    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat invertProduct(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat invertProduct(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t21 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        float _t22 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
        float _t23 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        float _t24 = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        dd[0] = -(_t21 * _t28_inv);
        dd[1] = -(_t23 * _t28_inv);
        dd[2] = -(_t22 * _t28_inv);
        dd[3] = _t24 * _t28_inv;
        return dest;
    }


    /**
     * Compute the inverse of the product of this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat invertProduct(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t21 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        float _t22 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
        float _t23 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        float _t24 = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
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
    public FloatQuat add(FloatQuatR other, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, otherData, 0).add(FloatVector.fromArray(COL_SPECIES, sd, 0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat add(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat add(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        dd[0] = otherX + sd[0];
        dd[1] = otherY + sd[1];
        dd[2] = otherZ + sd[2];
        dd[3] = otherW + sd[3];
        return dest;
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) to this quaternion and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat add(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
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
    public FloatQuat negate(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).neg();
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Negate this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat negate(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = -sd[3];
        return dest;
    }


    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat sub(FloatQuatR other, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).sub(FloatVector.fromArray(COL_SPECIES, otherData, 0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Subtract {@code other} from this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat sub(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat sub(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        dd[0] = sd[0] - otherX;
        dd[1] = sd[1] - otherY;
        dd[2] = sd[2] - otherZ;
        dd[3] = sd[3] - otherW;
        return dest;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) from this
     * quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat sub(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
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
    @Mutated public FloatQuat set(FloatQuatR v) {
        float[] dd = this.data;
        float[] vData = ((FloatQuatImpl) v).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, vData, 0);
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
    @Mutated public FloatQuat set(float vX, float vY, float vZ, float vW) {
        float[] dd = this.data;
        dd[0] = vX;
        dd[1] = vY;
        dd[2] = vZ;
        dd[3] = vW;
        return this;
    }


    /**
     * Convert this quaternion to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat toDouble(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        return dest;
    }


    /**
     * Set this quaternion to the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion
     * @return this
     */
    @Mutated public FloatQuat makeFromDualQuat(FloatDualQuatR dq) {
        float[] dd = this.data;
        float[] dqData = ((FloatDualQuatImpl) dq).data;
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
    @Mutated public FloatQuat makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        float[] dd = this.data;
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
    @Mutated public FloatQuat makeFromMatrix(Float3x3R m) {
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private FloatQuat makeFromMatrix_fma(Float3x3R m) {
        float[] dd = this.data;
        float[] mData = ((Float3x3Impl) m).data;
        float _t0 = mData[0] + mData[4];
        float _t1 = mData[5] - mData[7];
        float _t4 = mData[3] + mData[1];
        float _t6 = mData[6] + mData[2];
        float _t7 = mData[6] - mData[2];
        float _t8 = mData[7] + mData[5];
        float _t9 = mData[1] - mData[3];
        float _t10 = mData[8] + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (mData[0] - (mData[4] + mData[8]));
        float _t16 = 1.0f + (mData[4] - (mData[0] + mData[8]));
        float _t17 = 1.0f + (mData[8] - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (_t10 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t14)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[4], mData[8]) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[4] > mData[8] ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeFromMatrix_mulAdd(Float3x3R m) {
        float[] dd = this.data;
        float[] mData = ((Float3x3Impl) m).data;
        float _t0 = mData[0] + mData[4];
        float _t1 = mData[5] - mData[7];
        float _t4 = mData[3] + mData[1];
        float _t6 = mData[6] + mData[2];
        float _t7 = mData[6] - mData[2];
        float _t8 = mData[7] + mData[5];
        float _t9 = mData[1] - mData[3];
        float _t10 = mData[8] + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (mData[0] - (mData[4] + mData[8]));
        float _t16 = 1.0f + (mData[4] - (mData[0] + mData[8]));
        float _t17 = 1.0f + (mData[8] - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (_t10 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t14)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[4], mData[8]) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[4] > mData[8] ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public FloatQuat makeFromMatrix(Float3x4R m) {
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private FloatQuat makeFromMatrix_fma(Float3x4R m) {
        float[] dd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float _t0 = mData[0] + mData[5];
        float _t1 = mData[9] - mData[6];
        float _t4 = mData[1] + mData[4];
        float _t6 = mData[2] + mData[8];
        float _t7 = mData[2] - mData[8];
        float _t8 = mData[6] + mData[9];
        float _t9 = mData[4] - mData[1];
        float _t10 = mData[10] + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (mData[0] - (mData[5] + mData[10]));
        float _t16 = 1.0f + (mData[5] - (mData[0] + mData[10]));
        float _t17 = 1.0f + (mData[10] - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (_t10 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t14)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeFromMatrix_mulAdd(Float3x4R m) {
        float[] dd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float _t0 = mData[0] + mData[5];
        float _t1 = mData[9] - mData[6];
        float _t4 = mData[1] + mData[4];
        float _t6 = mData[2] + mData[8];
        float _t7 = mData[2] - mData[8];
        float _t8 = mData[6] + mData[9];
        float _t9 = mData[4] - mData[1];
        float _t10 = mData[10] + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (mData[0] - (mData[5] + mData[10]));
        float _t16 = 1.0f + (mData[5] - (mData[0] + mData[10]));
        float _t17 = 1.0f + (mData[10] - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (_t10 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t14)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public FloatQuat makeFromMatrix(Float4x4R m) {
        if (SimdMath.USE_FMA) return makeFromMatrix_fma(m);
        return makeFromMatrix_mulAdd(m);
    }

    private FloatQuat makeFromMatrix_fma(Float4x4R m) {
        float[] dd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float _t0 = mData[0] + mData[5];
        float _t1 = mData[6] - mData[9];
        float _t4 = mData[4] + mData[1];
        float _t6 = mData[8] + mData[2];
        float _t7 = mData[8] - mData[2];
        float _t8 = mData[9] + mData[6];
        float _t9 = mData[1] - mData[4];
        float _t10 = mData[10] + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (mData[0] - (mData[5] + mData[10]));
        float _t16 = 1.0f + (mData[5] - (mData[0] + mData[10]));
        float _t17 = 1.0f + (mData[10] - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (_t10 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t14)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeFromMatrix_mulAdd(Float4x4R m) {
        float[] dd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float _t0 = mData[0] + mData[5];
        float _t1 = mData[6] - mData[9];
        float _t4 = mData[4] + mData[1];
        float _t6 = mData[8] + mData[2];
        float _t7 = mData[8] - mData[2];
        float _t8 = mData[9] + mData[6];
        float _t9 = mData[1] - mData[4];
        float _t10 = mData[10] + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (mData[0] - (mData[5] + mData[10]));
        float _t16 = 1.0f + (mData[5] - (mData[0] + mData[10]));
        float _t17 = 1.0f + (mData[10] - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (_t10 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t14)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (mData[0] > Math.max(mData[5], mData[10]) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (mData[5] > mData[10] ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
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
    public FloatDualQuat toDualQuat(@Mutated FloatDualQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatDualQuatImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        return dest;
    }


    /**
     * Convert this quaternion to a pure-rotation dual quaternion (zero dual part) and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleDualQuat toDualQuat(@Mutated DoubleDualQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleDualQuatImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = 0.0f;
        dd[5] = 0.0f;
        dd[6] = 0.0f;
        dd[7] = 0.0f;
        return dest;
    }


    /**
     * Compute the matrix representation of this quaternion (which must have unit length) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x4 toMatrix(@Mutated Float4x4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4x4Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[2] * sd[3];
        float _t2 = sd[1] * sd[3];
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        dd[1] = 2.0f * Math.fma(sd[0], sd[1], _t1);
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], -_t2);
        dd[3] = 0.0f;
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], -_t1);
        dd[5] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        dd[6] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[7] = 0.0f;
        float _buf2 = 2.0f * Math.fma(sd[0], sd[2], _t2);
        dd[9] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[10] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[11] = 0.0f;
        dd[12] = 0.0f;
        dd[13] = 0.0f;
        dd[14] = 0.0f;
        dd[15] = 1.0f;
        dd[0] = _buf0;
        dd[4] = _buf1;
        dd[8] = _buf2;
        ((Float4x4Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Compute the matrix representation of this quaternion (which must have unit length) and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 toMatrix(@Mutated Double4x4 dest) {
        float[] sd = this.data;
        double[] dd = ((Double4x4Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[2] * sd[3];
        float _t2 = sd[1] * sd[3];
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        dd[1] = 2.0f * Math.fma(sd[0], sd[1], _t1);
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], -_t2);
        dd[3] = 0.0f;
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], -_t1);
        dd[5] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        dd[6] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[7] = 0.0f;
        float _buf2 = 2.0f * Math.fma(sd[0], sd[2], _t2);
        dd[9] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[10] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[11] = 0.0f;
        dd[12] = 0.0f;
        dd[13] = 0.0f;
        dd[14] = 0.0f;
        dd[15] = 1.0f;
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
    public Float3x3 toMatrix3x3(@Mutated Float3x3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[2] * sd[3];
        float _t2 = sd[1] * sd[3];
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], _t1);
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], -_t2);
        float _buf2 = 2.0f * Math.fma(sd[0], sd[1], -_t1);
        dd[4] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        dd[5] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _buf3 = 2.0f * Math.fma(sd[0], sd[2], _t2);
        dd[7] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[8] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[6] = _buf3;
        ((Float3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Compute the 3x3 rotation matrix representation of this quaternion (which must have unit
     * length) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 toMatrix3x3(@Mutated Double3x3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[2] * sd[3];
        float _t2 = sd[1] * sd[3];
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], _t1);
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], -_t2);
        float _buf2 = 2.0f * Math.fma(sd[0], sd[1], -_t1);
        dd[4] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        dd[5] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _buf3 = 2.0f * Math.fma(sd[0], sd[2], _t2);
        dd[7] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[8] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
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
    public Float3x4 toMatrix3x4(@Mutated Float3x4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3x4Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[2] * sd[3];
        float _t2 = sd[1] * sd[3];
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], -_t1);
        float _buf2 = 2.0f * Math.fma(sd[0], sd[2], _t2);
        float _buf3 = 0.0f;
        dd[4] = 2.0f * Math.fma(sd[0], sd[1], _t1);
        dd[5] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        dd[6] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[7] = 0.0f;
        dd[8] = 2.0f * Math.fma(sd[0], sd[2], -_t2);
        dd[9] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[10] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[11] = 0.0f;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        dd[3] = _buf3;
        ((Float3x4Impl) dest).properties = Joml.BIT_ORTHOGONAL;
        return dest;
    }


    /**
     * Compute the 3x4 matrix representation of this quaternion (which must have unit length; the
     * omitted last row is implicitly {@code 0, 0, 0, 1}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3x4 toMatrix3x4(@Mutated Double3x4 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3x4Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[2] * sd[3];
        float _t2 = sd[1] * sd[3];
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], -_t1);
        float _buf2 = 2.0f * Math.fma(sd[0], sd[2], _t2);
        float _buf3 = 0.0f;
        dd[4] = 2.0f * Math.fma(sd[0], sd[1], _t1);
        dd[5] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        dd[6] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[7] = 0.0f;
        dd[8] = 2.0f * Math.fma(sd[0], sd[2], -_t2);
        dd[9] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[10] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[11] = 0.0f;
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
    public FloatQuat decomposeSwingTwist(Float3R axis, @Mutated FloatQuat swing, @Mutated FloatQuat twist) {
        return decomposeSwingTwist(axis.x(), axis.y(), axis.z(), swing, twist);
    }


    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axis} followed
     * by a twist about {@code axis}, storing them in {@code swing} and {@code twist} respectively,
     * such that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param swing will hold the swing
     * @param twist will hold the twist
     * @return this
     */
    public FloatQuat decomposeSwingTwist(Float3R axis, @Mutated DoubleQuat swing, @Mutated DoubleQuat twist) {
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
    public FloatQuat decomposeSwingTwist(float axisX, float axisY, float axisZ, @Mutated FloatQuat swing, @Mutated FloatQuat twist) {
        float[] sd = this.data;
        float[] swingData = ((FloatQuatImpl) swing).data;
        float[] twistData = ((FloatQuatImpl) twist).data;
        float _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = sd[3] * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _d0buf0 = Math.fma(sd[0], _t11, -(sd[3] * _t12)) + Math.fma(sd[2], _t13, -(sd[1] * _t14));
        float _d0buf1 = Math.fma(sd[0], _t14, -(sd[3] * _t13)) + Math.fma(sd[1], _t11, -(sd[2] * _t12));
        float _d0buf2 = Math.fma(sd[1], _t12, sd[2] * _t11) + Math.fma(-sd[0], _t13, -(sd[3] * _t14));
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
     * Decompose this quaternion into a swing about an axis perpendicular to ({@code axisX},
     * {@code axisY}, {@code axisZ}) followed by a twist about ({@code axisX}, {@code axisY},
     * {@code axisZ}), storing them in {@code swing} and {@code twist} respectively, such that
     * {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public FloatQuat decomposeSwingTwist(float axisX, float axisY, float axisZ, @Mutated DoubleQuat swing, @Mutated DoubleQuat twist) {
        float[] sd = this.data;
        double[] swingData = ((DoubleQuatImpl) swing).data;
        double[] twistData = ((DoubleQuatImpl) twist).data;
        float _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = sd[3] * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _d0buf0 = Math.fma(sd[0], _t11, -(sd[3] * _t12)) + Math.fma(sd[2], _t13, -(sd[1] * _t14));
        float _d0buf1 = Math.fma(sd[0], _t14, -(sd[3] * _t13)) + Math.fma(sd[1], _t11, -(sd[2] * _t12));
        float _d0buf2 = Math.fma(sd[1], _t12, sd[2] * _t11) + Math.fma(-sd[0], _t13, -(sd[3] * _t14));
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
    public FloatQuat getSwing(Float3R axis, @Mutated FloatQuat dest) {
        return getSwing(axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to {@code axis} in
     * the swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getSwing(Float3R axis, @Mutated DoubleQuat dest) {
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
    public FloatQuat getSwing(float axisX, float axisY, float axisZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = sd[3] * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _buf0 = Math.fma(sd[0], _t11, -(sd[3] * _t12)) + Math.fma(sd[2], _t13, -(sd[1] * _t14));
        float _buf1 = Math.fma(sd[0], _t14, -(sd[3] * _t13)) + Math.fma(sd[1], _t11, -(sd[2] * _t12));
        float _buf2 = Math.fma(sd[1], _t12, sd[2] * _t11) + Math.fma(-sd[0], _t13, -(sd[3] * _t14));
        dd[3] = Math.fma(sd[2], _t14, Math.fma(sd[1], _t13, Math.fma(sd[0], _t12, sd[3] * _t11)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to ({@code axisX},
     * {@code axisY}, {@code axisZ}) in the swing-twist decomposition and store the result in
     * {@code dest}.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat getSwing(float axisX, float axisY, float axisZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = sd[3] * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _buf0 = Math.fma(sd[0], _t11, -(sd[3] * _t12)) + Math.fma(sd[2], _t13, -(sd[1] * _t14));
        float _buf1 = Math.fma(sd[0], _t14, -(sd[3] * _t13)) + Math.fma(sd[1], _t11, -(sd[2] * _t12));
        float _buf2 = Math.fma(sd[1], _t12, sd[2] * _t11) + Math.fma(-sd[0], _t13, -(sd[3] * _t14));
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
    public FloatQuat getTwist(Float3R axis, @Mutated FloatQuat dest) {
        return getTwist(axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Extract the twist component of this quaternion: the rotation about {@code axis} in the
     * swing-twist decomposition and store the result in {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat getTwist(Float3R axis, @Mutated DoubleQuat dest) {
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
    public FloatQuat getTwist(float axisX, float axisY, float axisZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            dd[0] = axisX * _t6;
            dd[1] = axisY * _t6;
            dd[2] = axisZ * _t6;
            dd[3] = sd[3] * _t5;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 1.0f;
        }
        return dest;
    }


    /**
     * Extract the twist component of this quaternion: the rotation about ({@code axisX},
     * {@code axisY}, {@code axisZ}) in the swing-twist decomposition and store the result in
     * {@code dest}.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat getTwist(float axisX, float axisY, float axisZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t2 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _t4 = Math.fma(sd[3], sd[3], _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            dd[0] = axisX * _t6;
            dd[1] = axisY * _t6;
            dd[2] = axisZ * _t6;
            dd[3] = sd[3] * _t5;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 1.0f;
        }
        return dest;
    }


    /**
     * Set this quaternion to the identity.
     *
     * @return this
     */
    @Mutated public FloatQuat makeIdentity() {
        float[] dd = this.data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = 1.0f;
        return this;
    }


    /**
     * Set all components of this quaternion to zero.
     *
     * @return this
     */
    @Mutated public FloatQuat makeZero() {
        float[] dd = this.data;
        var _col0 = FloatVector.broadcast(COL_SPECIES, 0.0f);
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
    public FloatQuat lerp(FloatQuatR other, float t, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return lerp_fma(other, t, dest);
        return lerp_mulAdd(other, t, dest);
    }

    private FloatQuat lerp_fma(FloatQuatR other, float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = FloatVector.broadcast(COL_SPECIES, t).fma(FloatVector.fromArray(COL_SPECIES, otherData, 0).sub(_sv0), _sv0);
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat lerp_mulAdd(FloatQuatR other, float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = FloatVector.broadcast(COL_SPECIES, t).mul(FloatVector.fromArray(COL_SPECIES, otherData, 0).sub(_sv0)).add(_sv0);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lerp(FloatQuatR other, float t, @Mutated DoubleQuat dest) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t, dest);
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
    public FloatQuat lerp(float otherX, float otherY, float otherZ, float otherW, float t, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return lerp_fma(otherX, otherY, otherZ, otherW, t, dest);
        return lerp_mulAdd(otherX, otherY, otherZ, otherW, t, dest);
    }

    private FloatQuat lerp_fma(float otherX, float otherY, float otherZ, float otherW, float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = FloatVector.broadcast(COL_SPECIES, t).fma(FloatVector.zero(COL_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0), _sv0);
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat lerp_mulAdd(float otherX, float otherY, float otherZ, float otherW, float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = FloatVector.broadcast(COL_SPECIES, t).mul(FloatVector.zero(COL_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0)).add(_sv0);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Linearly interpolate between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}) using the interpolation factor {@code t} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat lerp(float otherX, float otherY, float otherZ, float otherW, float t, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = Math.fma(t, otherX - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherY - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherZ - sd[2], sd[2]);
        dd[3] = Math.fma(t, otherW - sd[3], sd[3]);
        return dest;
    }


    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat nlerp(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return nlerp_fma(target, alpha, dest);
        return nlerp_mulAdd(target, alpha, dest);
    }

    private FloatQuat nlerp_fma(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.broadcast(COL_SPECIES, alpha).fma(FloatVector.fromArray(COL_SPECIES, targetData, 0).sub(_sv0), _sv0);
        float _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t11 > 0.0f ? _sv1.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t11)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat nlerp_mulAdd(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.broadcast(COL_SPECIES, alpha).mul(FloatVector.fromArray(COL_SPECIES, targetData, 0).sub(_sv0)).add(_sv0);
        float _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t11 > 0.0f ? _sv1.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t11)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat nlerp(FloatQuatR target, float alpha, @Mutated DoubleQuat dest) {
        return nlerp(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }


    /**
     * Interpolate between this quaternion and ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}) using the interpolation factor {@code alpha} and normalize the result and
     * store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
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
    public FloatQuat nlerp(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t4 = Math.fma(alpha, targetW - sd[3], sd[3]);
        float _t5 = Math.fma(alpha, targetZ - sd[2], sd[2]);
        float _t6 = Math.fma(alpha, targetX - sd[0], sd[0]);
        float _t7 = Math.fma(alpha, targetY - sd[1], sd[1]);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            dd[0] = _t6 * _t12;
            dd[1] = _t7 * _t12;
            dd[2] = _t5 * _t12;
            dd[3] = _t4 * _t12;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
        }
        return dest;
    }


    /**
     * Interpolate between this quaternion and ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}) using the interpolation factor {@code alpha} and normalize the result and
     * store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat nlerp(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t4 = Math.fma(alpha, targetW - sd[3], sd[3]);
        float _t5 = Math.fma(alpha, targetZ - sd[2], sd[2]);
        float _t6 = Math.fma(alpha, targetX - sd[0], sd[0]);
        float _t7 = Math.fma(alpha, targetY - sd[1], sd[1]);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            dd[0] = _t6 * _t12;
            dd[1] = _t7 * _t12;
            dd[2] = _t5 * _t12;
            dd[3] = _t4 * _t12;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
        }
        return dest;
    }


    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat nlerpShortest(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return nlerpShortest_fma(target, alpha, dest);
        return nlerpShortest_mulAdd(target, alpha, dest);
    }

    private FloatQuat nlerpShortest_fma(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv2 = FloatVector.broadcast(COL_SPECIES, alpha).fma((-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? _sv0.neg() : _sv0).sub(_sv1), _sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t24 > 0.0f ? _sv2.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat nlerpShortest_mulAdd(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv2 = FloatVector.broadcast(COL_SPECIES, alpha).mul((-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? _sv0.neg() : _sv0).sub(_sv1)).add(_sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t24 > 0.0f ? _sv2.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result and store the result in
     * {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat nlerpShortest(FloatQuatR target, float alpha, @Mutated DoubleQuat dest) {
        return nlerpShortest(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }


    /**
     * Interpolate along the shortest path between this quaternion and ({@code targetX},
     * {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
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
    public FloatQuat nlerpShortest(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t8 = -Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        float _t17, _t18, _t19, _t20;
        if (_t8 > 0.0f) {
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
        float _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            dd[0] = _t19 * _t25;
            dd[1] = _t20 * _t25;
            dd[2] = _t18 * _t25;
            dd[3] = _t17 * _t25;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
        }
        return dest;
    }


    /**
     * Interpolate along the shortest path between this quaternion and ({@code targetX},
     * {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat nlerpShortest(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t8 = -Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        float _t17, _t18, _t19, _t20;
        if (_t8 > 0.0f) {
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
        float _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            dd[0] = _t19 * _t25;
            dd[1] = _t20 * _t25;
            dd[2] = _t18 * _t25;
            dd[3] = _t17 * _t25;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
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
    public FloatQuat slerp(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return slerp_fma(target, alpha, dest);
        return slerp_mulAdd(target, alpha, dest);
    }

    private FloatQuat slerp_fma(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _col0 = (Math.abs(_t8) > 1.0E-6f ? _sv0.fma(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(COL_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(COL_SPECIES, _t0))));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat slerp_mulAdd(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _col0 = (Math.abs(_t8) > 1.0E-6f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(COL_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(COL_SPECIES, _t0))));
        _col0.intoArray(dd, 0);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat slerp(FloatQuatR target, float alpha, @Mutated DoubleQuat dest) {
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
    public FloatQuat slerp(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return slerp_fma(targetX, targetY, targetZ, targetW, alpha, dest);
        return slerp_mulAdd(targetX, targetY, targetZ, targetW, alpha, dest);
    }

    private FloatQuat slerp_fma(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.zero(COL_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _col0 = (Math.abs(_t8) > 1.0E-6f ? _sv0.fma(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(COL_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(COL_SPECIES, _t0))));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat slerp_mulAdd(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.zero(COL_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _col0 = (Math.abs(_t8) > 1.0E-6f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(COL_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(COL_SPECIES, _t0))));
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat slerp(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6f) {
            dd[0] = Math.fma(sd[0], _t13, targetX * _t11) * _t8_inv;
            dd[1] = Math.fma(sd[1], _t13, targetY * _t11) * _t8_inv;
            dd[2] = Math.fma(sd[2], _t13, targetZ * _t11) * _t8_inv;
            dd[3] = Math.fma(sd[3], _t13, targetW * _t11) * _t8_inv;
        } else {
            dd[0] = Math.fma(alpha, targetX, sd[0] * _t0);
            dd[1] = Math.fma(alpha, targetY, sd[1] * _t0);
            dd[2] = Math.fma(alpha, targetZ, sd[2] * _t0);
            dd[3] = Math.fma(alpha, targetW, sd[3] * _t0);
        }
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
    public FloatQuat slerpShortest(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return slerpShortest_fma(target, alpha, dest);
        return slerpShortest_mulAdd(target, alpha, dest);
    }

    private FloatQuat slerpShortest_fma(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0f ? _sv0.fma(FloatVector.broadcast(COL_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))), FloatVector.broadcast(COL_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))).mul(_sv2)).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : FloatVector.broadcast(COL_SPECIES, alpha).fma(_sv2, _sv0.mul(FloatVector.broadcast(COL_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t49 > 0.0f ? _sv3.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat slerpShortest_mulAdd(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))).add(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))).mul(_sv2)).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : FloatVector.broadcast(COL_SPECIES, alpha).mul(_sv2).add(_sv0.mul(FloatVector.broadcast(COL_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t49 > 0.0f ? _sv3.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat slerpShortest(FloatQuatR target, float alpha, @Mutated DoubleQuat dest) {
        return slerpShortest(target.x(), target.y(), target.z(), target.w(), alpha, dest);
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
    public FloatQuat slerpShortest(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t12 = Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        float _t14 = -_t12;
        float _t16 = (float) Math.acos(Math.min(1.0f, Math.abs(_t12)));
        float _t17 = (float) Math.sin(_t16);
        float _t17_inv = 1.0f / _t17;
        float _t19 = (float) Math.sin(alpha * _t16);
        float _t21, _t22, _t23, _t24;
        if (_t14 > 0.0f) {
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
        float _t25 = (float) Math.sin(_t0 * _t16);
        float _t42, _t43, _t44, _t45;
        if (_t17 > 0.0f) {
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
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        if (_t49 > 0.0f) {
            dd[0] = _t50 * _t44;
            dd[1] = _t50 * _t45;
            dd[2] = _t50 * _t43;
            dd[3] = _t50 * _t42;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
        }
        return dest;
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) using the
     * interpolation factor {@code alpha} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat slerpShortest(float targetX, float targetY, float targetZ, float targetW, float alpha, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 1.0f - alpha;
        float _t12 = Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        float _t14 = -_t12;
        float _t16 = (float) Math.acos(Math.min(1.0f, Math.abs(_t12)));
        float _t17 = (float) Math.sin(_t16);
        float _t17_inv = 1.0f / _t17;
        float _t19 = (float) Math.sin(alpha * _t16);
        float _t21, _t22, _t23, _t24;
        if (_t14 > 0.0f) {
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
        float _t25 = (float) Math.sin(_t0 * _t16);
        float _t42, _t43, _t44, _t45;
        if (_t17 > 0.0f) {
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
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        if (_t49 > 0.0f) {
            dd[0] = _t50 * _t44;
            dd[1] = _t50 * _t45;
            dd[2] = _t50 * _t43;
            dd[3] = _t50 * _t42;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
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
    public FloatQuat squad(FloatQuatR control0, FloatQuatR control1, FloatQuatR target, float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] control0Data = ((FloatQuatImpl) control0).data;
        float[] control1Data = ((FloatQuatImpl) control1).data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(control0Data[3], control1Data[3], Math.fma(control0Data[2], control1Data[2], Math.fma(control0Data[0], control1Data[0], control0Data[1] * control1Data[1]))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))));
        float _t35 = (float) Math.sin(_t33);
        float _t35_inv = 1.0f / _t35;
        float _t36 = (float) Math.sin(_t34);
        float _t36_inv = 1.0f / _t36;
        float _t37 = Math.abs(_t35);
        float _t39 = Math.abs(_t36);
        float _t41 = (float) Math.sin(t * _t33);
        float _t42 = (float) Math.sin(t * _t34);
        float _t45 = (float) Math.sin(_t0 * _t33);
        float _t46 = (float) Math.sin(_t0 * _t34);
        float _t71, _t73, _t75, _t77;
        if (_t37 > 1.0E-6f) {
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
        float _t72, _t74, _t76, _t78;
        if (_t39 > 1.0E-6f) {
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
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param control0 the inner control quaternion associated with the start rotation
     * @param control1 the inner control quaternion associated with the end rotation
     * @param target the target rotation
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat squad(FloatQuatR control0, FloatQuatR control1, FloatQuatR target, float t, @Mutated DoubleQuat dest) {
        return squad(control0.x(), control0.y(), control0.z(), control0.w(), control1.x(), control1.y(), control1.z(), control1.w(), target.x(), target.y(), target.z(), target.w(), t, dest);
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
    public FloatQuat squad(float control0X, float control0Y, float control0Z, float control0W, float control1X, float control1Y, float control1Z, float control1W, float targetX, float targetY, float targetZ, float targetW, float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        float _t35 = (float) Math.sin(_t33);
        float _t35_inv = 1.0f / _t35;
        float _t36 = (float) Math.sin(_t34);
        float _t36_inv = 1.0f / _t36;
        float _t37 = Math.abs(_t35);
        float _t39 = Math.abs(_t36);
        float _t41 = (float) Math.sin(t * _t33);
        float _t42 = (float) Math.sin(t * _t34);
        float _t45 = (float) Math.sin(_t0 * _t33);
        float _t46 = (float) Math.sin(_t0 * _t34);
        float _t71, _t73, _t75, _t77;
        if (_t37 > 1.0E-6f) {
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
        float _t72, _t74, _t76, _t78;
        if (_t39 > 1.0E-6f) {
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
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat squad(float control0X, float control0Y, float control0Z, float control0W, float control1X, float control1Y, float control1Z, float control1W, float targetX, float targetY, float targetZ, float targetW, float t, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY))))));
        float _t35 = (float) Math.sin(_t33);
        float _t35_inv = 1.0f / _t35;
        float _t36 = (float) Math.sin(_t34);
        float _t36_inv = 1.0f / _t36;
        float _t37 = Math.abs(_t35);
        float _t39 = Math.abs(_t36);
        float _t41 = (float) Math.sin(t * _t33);
        float _t42 = (float) Math.sin(t * _t34);
        float _t45 = (float) Math.sin(_t0 * _t33);
        float _t46 = (float) Math.sin(_t0 * _t34);
        float _t71, _t73, _t75, _t77;
        if (_t37 > 1.0E-6f) {
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
        float _t72, _t74, _t76, _t78;
        if (_t39 > 1.0E-6f) {
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
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
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
    public FloatQuat mul(FloatQuatR other, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _buf0 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[2], sd[1], -(otherData[1] * sd[2]));
        float _buf1 = Math.fma(otherData[0], sd[2], otherData[3] * sd[1]) + Math.fma(otherData[1], sd[3], -(otherData[2] * sd[0]));
        float _buf2 = Math.fma(otherData[1], sd[0], otherData[2] * sd[3]) + Math.fma(otherData[3], sd[2], -(otherData[0] * sd[1]));
        dd[3] = Math.fma(-otherData[2], sd[2], Math.fma(-otherData[1], sd[1], Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0]))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Multiply this quaternion by {@code other} and store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat mul(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat mul(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _buf0 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        float _buf1 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        float _buf2 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
        dd[3] = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat mul(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _buf0 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        float _buf1 = Math.fma(otherX, sd[2], otherW * sd[1]) + Math.fma(otherY, sd[3], -(otherZ * sd[0]));
        float _buf2 = Math.fma(otherY, sd[0], otherZ * sd[3]) + Math.fma(otherW, sd[2], -(otherX * sd[1]));
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
    public FloatQuat preMul(FloatQuatR other, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _buf0 = Math.fma(otherData[0], sd[3], otherData[3] * sd[0]) + Math.fma(otherData[1], sd[2], -(otherData[2] * sd[1]));
        float _buf1 = Math.fma(otherData[1], sd[3], otherData[2] * sd[0]) + Math.fma(otherData[3], sd[1], -(otherData[0] * sd[2]));
        float _buf2 = Math.fma(otherData[0], sd[1], otherData[3] * sd[2]) + Math.fma(otherData[2], sd[3], -(otherData[1] * sd[0]));
        dd[3] = Math.fma(-otherData[2], sd[2], Math.fma(-otherData[1], sd[1], Math.fma(otherData[3], sd[3], -(otherData[0] * sd[0]))));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preMul(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat preMul(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _buf0 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherY, sd[2], -(otherZ * sd[1]));
        float _buf1 = Math.fma(otherY, sd[3], otherZ * sd[0]) + Math.fma(otherW, sd[1], -(otherX * sd[2]));
        float _buf2 = Math.fma(otherX, sd[1], otherW * sd[2]) + Math.fma(otherZ, sd[3], -(otherY * sd[0]));
        dd[3] = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat preMul(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _buf0 = Math.fma(otherX, sd[3], otherW * sd[0]) + Math.fma(otherY, sd[2], -(otherZ * sd[1]));
        float _buf1 = Math.fma(otherY, sd[3], otherZ * sd[0]) + Math.fma(otherW, sd[1], -(otherX * sd[2]));
        float _buf2 = Math.fma(otherX, sd[1], otherW * sd[2]) + Math.fma(otherZ, sd[3], -(otherY * sd[0]));
        dd[3] = Math.fma(-otherZ, sd[2], Math.fma(-otherY, sd[1], Math.fma(otherW, sd[3], -(otherX * sd[0]))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    public float angle() {
        float[] sd = this.data;
        return 2.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]))), sd[3]);
    }


    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other quaternion
     * @return the angle in radians between this quaternion and {@code other}
     */
    public float angleTo(FloatQuatR other) {
        return angleTo(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the angle in radians between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
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
    public float angleTo(float otherX, float otherY, float otherZ, float otherW) {
        float[] sd = this.data;
        float _t8 = -Math.fma(otherW, sd[3], Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1])));
        float _t9, _t10, _t11, _t12;
        if (_t8 > 0.0f) {
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
        float _t13 = sd[3] - _t9;
        float _t14 = sd[2] - _t10;
        float _t15 = sd[0] - _t11;
        float _t16 = sd[1] - _t12;
        float _t17 = sd[3] + _t9;
        float _t18 = sd[2] + _t10;
        float _t19 = sd[0] + _t11;
        float _t20 = sd[1] + _t12;
        return 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(_t13, _t13, Math.fma(_t14, _t14, Math.fma(_t15, _t15, _t16 * _t16)))), (float) Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))));
    }


    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero)
     * and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 axis(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t3;
            dd[1] = sd[1] * _t3;
            dd[2] = sd[2] * _t3;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 axis(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t3;
            dd[1] = sd[1] * _t3;
            dd[2] = sd[2] * _t3;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
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
    public FloatQuat calculateW(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).withLane(3, (float) Math.sqrt(Math.max(0.0f, Math.fma(-sd[0], sd[0], Math.fma(-sd[1], sd[1], Math.fma(-sd[2], sd[2], 1.0f))))));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Recompute the {@code w} component of this quaternion from {@code x}, {@code y} and {@code z},
     * assuming unit length (the positive square root is chosen) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat calculateW(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _buf0 = sd[0];
        float _buf1 = sd[1];
        float _buf2 = sd[2];
        dd[3] = (float) Math.sqrt(Math.max(0.0f, Math.fma(-sd[0], sd[0], Math.fma(-sd[1], sd[1], Math.fma(-sd[2], sd[2], 1.0f)))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Conjugate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat conjugate(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _col0 = _sv0.lanewise(VectorOperators.NEG, MASK_0);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Conjugate this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugate(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        dd[3] = sd[3];
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
    public FloatQuat conjugateBy(FloatQuatR q, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] qData = ((FloatQuatImpl) q).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t1 = -qData[1];
        float _t21 = Math.fma(qData[0], sd[1], qData[3] * sd[2]) + Math.fma(qData[2], sd[3], -(qData[1] * sd[0]));
        float _t22 = Math.fma(qData[1], sd[3], qData[2] * sd[0]) + Math.fma(qData[3], sd[1], -(qData[0] * sd[2]));
        float _t23 = Math.fma(qData[0], sd[3], qData[3] * sd[0]) + Math.fma(qData[1], sd[2], -(qData[2] * sd[1]));
        float _t24 = Math.fma(-qData[2], sd[2], Math.fma(_t1, sd[1], Math.fma(qData[3], sd[3], -(qData[0] * sd[0]))));
        float _buf0 = Math.fma(qData[1], _t21, -(qData[2] * _t22)) + Math.fma(qData[3], _t23, -(qData[0] * _t24));
        float _buf1 = Math.fma(qData[2], _t23, -(qData[1] * _t24)) + Math.fma(qData[3], _t22, -(qData[0] * _t21));
        float _buf2 = Math.fma(qData[0], _t22, qData[3] * _t21) + Math.fma(_t1, _t23, -(qData[2] * _t24));
        dd[3] = Math.fma(qData[2], _t21, Math.fma(qData[1], _t22, Math.fma(qData[0], _t23, qData[3] * _t24)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length)
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param q the quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugateBy(FloatQuatR q, @Mutated DoubleQuat dest) {
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
    public FloatQuat conjugateBy(float qX, float qY, float qZ, float qW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t1 = -qY;
        float _t21 = Math.fma(qX, sd[1], qW * sd[2]) + Math.fma(qZ, sd[3], -(qY * sd[0]));
        float _t22 = Math.fma(qY, sd[3], qZ * sd[0]) + Math.fma(qW, sd[1], -(qX * sd[2]));
        float _t23 = Math.fma(qX, sd[3], qW * sd[0]) + Math.fma(qY, sd[2], -(qZ * sd[1]));
        float _t24 = Math.fma(-qZ, sd[2], Math.fma(_t1, sd[1], Math.fma(qW, sd[3], -(qX * sd[0]))));
        dd[0] = Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24));
        dd[1] = Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21));
        dd[2] = Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24));
        dd[3] = Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24)));
        return dest;
    }


    /**
     * Conjugate this quaternion by ({@code qX}, {@code qY}, {@code qZ}, {@code qW}), i.e. compute
     * {@code q * this * conj(q)} where {@code q} is the given quaternion (equal to
     * {@code q * this * q^-1} when it has unit length) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat conjugateBy(float qX, float qY, float qZ, float qW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t1 = -qY;
        float _t21 = Math.fma(qX, sd[1], qW * sd[2]) + Math.fma(qZ, sd[3], -(qY * sd[0]));
        float _t22 = Math.fma(qY, sd[3], qZ * sd[0]) + Math.fma(qW, sd[1], -(qX * sd[2]));
        float _t23 = Math.fma(qX, sd[3], qW * sd[0]) + Math.fma(qY, sd[2], -(qZ * sd[1]));
        float _t24 = Math.fma(-qZ, sd[2], Math.fma(_t1, sd[1], Math.fma(qW, sd[3], -(qX * sd[0]))));
        dd[0] = Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24));
        dd[1] = Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21));
        dd[2] = Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24));
        dd[3] = Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24)));
        return dest;
    }


    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation {@code D}
     * with {@code this * D = other}, that is {@code D = this^-1 * other} and store the result in
     * {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat difference(FloatQuatR other, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] otherData = ((FloatQuatImpl) other).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t3_inv = 1.0f / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        var _col0 = FloatVector.broadcast(COL_SPECIES, Math.fma(otherData[0], sd[3], -(otherData[3] * sd[0]))).withLane(2, Math.fma(otherData[0], sd[1], -(otherData[3] * sd[2]))).add(FloatVector.broadcast(COL_SPECIES, Math.fma(otherData[1], sd[2], -(otherData[2] * sd[1]))).withLane(2, Math.fma(otherData[2], sd[3], -(otherData[1] * sd[0])))).withLane(3, Math.fma(otherData[2], sd[2], Math.fma(otherData[1], sd[1], Math.fma(otherData[0], sd[0], otherData[3] * sd[3])))).mul(FloatVector.broadcast(COL_SPECIES, _t3_inv)).withLane(1, -(otherData[3] * sd[1] * _t3_inv) - otherData[0] * sd[2] * _t3_inv + Math.fma(otherData[1], sd[3], otherData[2] * sd[0]) * _t3_inv);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation {@code D}
     * with {@code this * D = other}, that is {@code D = this^-1 * other} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat difference(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat difference(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t3_inv = 1.0f / Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        var _col0 = FloatVector.broadcast(COL_SPECIES, Math.fma(otherX, sd[3], -(otherW * sd[0]))).withLane(2, Math.fma(otherX, sd[1], -(otherW * sd[2]))).add(FloatVector.broadcast(COL_SPECIES, Math.fma(otherY, sd[2], -(otherZ * sd[1]))).withLane(2, Math.fma(otherZ, sd[3], -(otherY * sd[0])))).withLane(3, Math.fma(otherZ, sd[2], Math.fma(otherY, sd[1], Math.fma(otherX, sd[0], otherW * sd[3])))).mul(FloatVector.broadcast(COL_SPECIES, _t3_inv)).withLane(1, -(otherW * sd[1] * _t3_inv) - otherX * sd[2] * _t3_inv + Math.fma(otherY, sd[3], otherZ * sd[0]) * _t3_inv);
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Compute the difference between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}), i.e. the rotation {@code D} with
     * {@code this * D = (otherX, otherY, otherZ, otherW)}, that is
     * {@code D = this^-1 * (otherX, otherY, otherZ, otherW)} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat difference(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t3 = Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        float _t3_inv = 1.0f / _t3;
        float _buf0 = (Math.fma(otherX, sd[3], -(otherW * sd[0])) + Math.fma(otherY, sd[2], -(otherZ * sd[1]))) * _t3_inv;
        float _buf1 = -(otherW * sd[1] * _t3_inv) - otherX * sd[2] * _t3_inv + Math.fma(otherY, sd[3], otherZ * sd[0]) * _t3_inv;
        float _buf2 = (Math.fma(otherX, sd[1], -(otherW * sd[2])) + Math.fma(otherZ, sd[3], -(otherY * sd[0]))) * _t3_inv;
        dd[3] = Math.fma(otherZ, sd[2], Math.fma(otherY, sd[1], Math.fma(otherX, sd[0], otherW * sd[3]))) * _t3_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the dot product of this quaternion and {@code other}
     */
    public float dot(FloatQuatR other) {
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
    public float dot(float otherX, float otherY, float otherZ, float otherW) {
        float[] sd = this.data;
        return Math.fma(otherW, sd[3], Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1])));
    }


    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat exp(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = (float) Math.exp(sd[3]);
        float _t3 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t4 = (float) Math.sqrt(_t3);
        var _col0 = (_t3 > 0.0f ? FloatVector.fromArray(COL_SPECIES, sd, 0).withLane(3, (float) Math.cos(_t4)).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3))).withLane(3, _t0)) : FloatVector.broadcast(COL_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t4) * _t0));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat exp(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = (float) Math.exp(sd[3]);
        float _t3 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t4 = (float) Math.sqrt(_t3);
        float _t8 = (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            dd[0] = sd[0] * _t8;
            dd[1] = sd[1] * _t8;
            dd[2] = sd[2] * _t8;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        dd[3] = (float) Math.cos(_t4) * _t0;
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesXYZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t1 = sd[1] * sd[2];
        float _t3 = sd[2] * sd[2];
        float _t8 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], _t1), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t3), 1.0f));
            dd[2] = 0.0f;
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t9, _t10);
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t3), 1.0f));
            dd[0] = _buf0;
        }
        dd[1] = (float) Math.atan2(_t8, (float) Math.sqrt(_t12));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t1 = sd[1] * sd[2];
        float _t3 = sd[2] * sd[2];
        float _t8 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], _t1), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t3), 1.0f));
            dd[2] = 0.0f;
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t9, _t10);
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t3), 1.0f));
            dd[0] = _buf0;
        }
        dd[1] = (float) Math.atan2(_t8, (float) Math.sqrt(_t12));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesXZY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[1] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[3], _t1);
        float _t8 = 2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], -_t1), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[1] = 0.0f;
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t7, _t9);
            dd[1] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f));
            dd[0] = _buf0;
        }
        dd[2] = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t1 = sd[1] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[3], _t1);
        float _t8 = 2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], -_t1), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[1] = 0.0f;
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t7, _t9);
            dd[1] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f));
            dd[0] = _buf0;
        }
        dd[2] = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesYXZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t3 = sd[2] * sd[2];
        float _t8 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], -(sd[1] * sd[2]));
        float _t10 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t3), 1.0f));
            dd[2] = 0.0f;
            dd[1] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t8, _t10);
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t3), 1.0f));
            dd[1] = _buf0;
        }
        dd[0] = (float) Math.atan2(_t9, (float) Math.sqrt(_t12));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t3 = sd[2] * sd[2];
        float _t8 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], -(sd[1] * sd[2]));
        float _t10 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t3), 1.0f));
            dd[2] = 0.0f;
            dd[1] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t8, _t10);
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t3), 1.0f));
            dd[1] = _buf0;
        }
        dd[0] = (float) Math.atan2(_t9, (float) Math.sqrt(_t12));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesYZX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t8 = 2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            dd[1] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], -(sd[1] * sd[2])), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f));
            dd[1] = (float) Math.atan2(_t8, _t9);
            dd[0] = _buf0;
        }
        dd[2] = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t8 = 2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            dd[1] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], -(sd[1] * sd[2])), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f));
            dd[1] = (float) Math.atan2(_t8, _t9);
            dd[0] = _buf0;
        }
        dd[2] = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesZXY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t1 = sd[2] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t8 = 2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t1), 1.0f));
            dd[1] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[2] = (float) Math.atan2(_t8, _t9);
            dd[1] = _buf0;
        }
        dd[0] = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t1 = sd[2] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t8 = 2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]), Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t1), 1.0f));
            dd[1] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2])), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[2] = (float) Math.atan2(_t8, _t9);
            dd[1] = _buf0;
        }
        dd[0] = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getEulerAnglesZYX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t8 = 2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f));
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[2] = (float) Math.atan2(_t7, _t9);
            dd[0] = _buf0;
        }
        dd[1] = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
        return dest;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The middle angle is recovered with {@code atan2} rather than {@code asin}, so it keeps full
     * {@code float} resolution over its whole range, down to 0.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = sd[2] * sd[2];
        float _t7 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t8 = 2.0f * Math.fma(sd[1], sd[3], -(sd[0] * sd[2]));
        float _t9 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            dd[2] = (float) Math.atan2(2.0f * Math.fma(sd[2], sd[3], -(sd[0] * sd[1])), Math.fma(-2.0f, Math.fma(sd[0], sd[0], _t0), 1.0f));
            dd[0] = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]), Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f));
            dd[2] = (float) Math.atan2(_t7, _t9);
            dd[0] = _buf0;
        }
        dd[1] = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
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
    public FloatQuat integrate(Float3R angularVel, float dt, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] angularVelData = ((Float3Impl) angularVel).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * dt;
        float _t1 = angularVelData[2] * _t0;
        float _t2 = angularVelData[0] * _t0;
        float _t3 = angularVelData[1] * _t0;
        float _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        float _t7 = (float) Math.sqrt(_t6);
        float _t9 = (float) Math.cos(_t7);
        float _t11 = (float) Math.sin(_t7) * (1.0f / (float) Math.sqrt(_t6));
        float _t15, _t16, _t17;
        if (_t6 > 0.0f) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _buf0 = Math.fma(sd[0], _t9, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        float _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t9, -(sd[2] * _t15));
        float _buf2 = Math.fma(sd[1], _t15, sd[2] * _t9) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(-sd[2], _t17, Math.fma(-sd[1], _t16, Math.fma(sd[3], _t9, -(sd[0] * _t15))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angularVel the angular velocity, in radians per second, applied in the reference frame
     * @param dt the time step
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat integrate(Float3R angularVel, float dt, @Mutated DoubleQuat dest) {
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
    public FloatQuat integrate(float angularVelX, float angularVelY, float angularVelZ, float dt, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * dt;
        float _t1 = angularVelZ * _t0;
        float _t2 = angularVelX * _t0;
        float _t3 = angularVelY * _t0;
        float _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        float _t7 = (float) Math.sqrt(_t6);
        float _t9 = (float) Math.cos(_t7);
        float _t11 = (float) Math.sin(_t7) * (1.0f / (float) Math.sqrt(_t6));
        float _t15, _t16, _t17;
        if (_t6 > 0.0f) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _buf0 = Math.fma(sd[0], _t9, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        float _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t9, -(sd[2] * _t15));
        float _buf2 = Math.fma(sd[1], _t15, sd[2] * _t9) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(-sd[2], _t17, Math.fma(-sd[1], _t16, Math.fma(sd[3], _t9, -(sd[0] * _t15))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat integrate(float angularVelX, float angularVelY, float angularVelZ, float dt, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * dt;
        float _t1 = angularVelZ * _t0;
        float _t2 = angularVelX * _t0;
        float _t3 = angularVelY * _t0;
        float _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        float _t7 = (float) Math.sqrt(_t6);
        float _t9 = (float) Math.cos(_t7);
        float _t11 = (float) Math.sin(_t7) * (1.0f / (float) Math.sqrt(_t6));
        float _t15, _t16, _t17;
        if (_t6 > 0.0f) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _buf0 = Math.fma(sd[0], _t9, sd[3] * _t15) + Math.fma(sd[2], _t16, -(sd[1] * _t17));
        float _buf1 = Math.fma(sd[0], _t17, sd[3] * _t16) + Math.fma(sd[1], _t9, -(sd[2] * _t15));
        float _buf2 = Math.fma(sd[1], _t15, sd[2] * _t9) + Math.fma(sd[3], _t17, -(sd[0] * _t16));
        dd[3] = Math.fma(-sd[2], _t17, Math.fma(-sd[1], _t16, Math.fma(sd[3], _t9, -(sd[0] * _t15))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invNegativeX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t12 * _t16);
            dd[1] = -(_t10 * _t16);
            dd[2] = -(_t9 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t12 * _t16);
            dd[1] = -(_t10 * _t16);
            dd[2] = -(_t9 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invNegativeY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t9 * _t16);
            dd[1] = -(_t12 * _t16);
            dd[2] = -(_t10 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t9 * _t16);
            dd[1] = -(_t12 * _t16);
            dd[2] = -(_t10 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invNegativeZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t10 * _t16);
            dd[1] = -(_t9 * _t16);
            dd[2] = -(_t12 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t10 * _t16);
            dd[1] = -(_t9 * _t16);
            dd[2] = -(_t12 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
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
    public Float3 invNormalizedNegativeX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), -1.0f);
        float _buf1 = -(2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3])));
        dd[2] = -(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), -1.0f);
        float _buf1 = -(2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3])));
        dd[2] = -(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]));
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
    public Float3 invNormalizedNegativeY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]));
        float _buf1 = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), -1.0f);
        dd[2] = -(2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3])));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]));
        float _buf1 = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), -1.0f);
        dd[2] = -(2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3])));
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
    public Float3 invNormalizedNegativeZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3])));
        float _buf1 = -(2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]));
        dd[2] = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), -1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3])));
        float _buf1 = -(2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]));
        dd[2] = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), -1.0f);
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
    public Float3 invNormalizedPositiveX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
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
    public Float3 invNormalizedPositiveY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _buf1 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0f);
        dd[2] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _buf1 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0f);
        dd[2] = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
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
    public Float3 invNormalizedPositiveZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _buf1 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[2] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _buf1 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        dd[2] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invPositiveX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t12 * _t16;
            dd[1] = _t10 * _t16;
            dd[2] = _t9 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t12 * _t16;
            dd[1] = _t10 * _t16;
            dd[2] = _t9 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invPositiveY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t9 * _t16;
            dd[1] = _t12 * _t16;
            dd[2] = _t10 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t9 * _t16;
            dd[1] = _t12 * _t16;
            dd[2] = _t10 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invPositiveZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t10 * _t16;
            dd[1] = _t9 * _t16;
            dd[2] = _t12 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected row of this quaternion's
     * rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}. Rescale inputs
     * outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t10 * _t16;
            dd[1] = _t9 * _t16;
            dd[2] = _t12 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Compute the length of this quaternion.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the length of this quaternion
     */
    public float length() {
        float[] sd = this.data;
        return (float) Math.sqrt(Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]))));
    }


    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    public float lengthSquared() {
        float[] sd = this.data;
        return Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
    }


    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat log(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        var _col0 = (_t2 > 0.0f ? FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.atan2((float) Math.sqrt(_t2), sd[3]) * (1.0f / (float) Math.sqrt(_t2)))).withLane(3, (float) Math.log((float) Math.sqrt(Math.fma(sd[3], sd[3], _t2)))) : FloatVector.broadcast(COL_SPECIES, 0.0f).withLane(3, (float) Math.log((float) Math.sqrt(Math.fma(sd[3], sd[3], _t2)))));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat log(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t6 = (float) Math.atan2((float) Math.sqrt(_t2), sd[3]) * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t6;
            dd[1] = sd[1] * _t6;
            dd[2] = sd[2] * _t6;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        dd[3] = (float) Math.log((float) Math.sqrt(Math.fma(sd[3], sd[3], _t2)));
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negativeX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t12 * _t16);
            dd[1] = -(_t9 * _t16);
            dd[2] = -(_t10 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t12 * _t16);
            dd[1] = -(_t9 * _t16);
            dd[2] = -(_t10 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negativeY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t10 * _t16);
            dd[1] = -(_t12 * _t16);
            dd[2] = -(_t9 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t10 * _t16);
            dd[1] = -(_t12 * _t16);
            dd[2] = -(_t9 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negativeZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t9 * _t16);
            dd[1] = -(_t10 * _t16);
            dd[2] = -(_t12 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = -(_t9 * _t16);
            dd[1] = -(_t10 * _t16);
            dd[2] = -(_t12 * _t16);
        } else {
            dd[0] = -0.0f;
            dd[1] = -0.0f;
            dd[2] = -0.0f;
        }
        return dest;
    }


    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat normalize(@Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        float _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t3 > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t3)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this quaternion must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat normalize(@Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t3 = Math.fma(sd[3], sd[3], Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            dd[0] = sd[0] * _t4;
            dd[1] = sd[1] * _t4;
            dd[2] = sd[2] * _t4;
            dd[3] = sd[3] * _t4;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
        }
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
    public Float3 normalizedNegativeX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), -1.0f);
        float _buf1 = -(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]));
        dd[2] = -(2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * This method assumes this quaternion to be normalized, and skips the normalization the plain
     * variant performs.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), -1.0f);
        float _buf1 = -(2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]));
        dd[2] = -(2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3])));
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
    public Float3 normalizedNegativeY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3])));
        float _buf1 = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), -1.0f);
        dd[2] = -(2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3])));
        float _buf1 = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), -1.0f);
        dd[2] = -(2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]));
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
    public Float3 normalizedNegativeZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]));
        float _buf1 = -(2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3])));
        dd[2] = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), -1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = -(2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]));
        float _buf1 = -(2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3])));
        dd[2] = Math.fma(2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), -1.0f);
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
    public Float3 normalizedPositiveX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(-2.0f, Math.fma(sd[1], sd[1], sd[2] * sd[2]), 1.0f);
        float _buf1 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        dd[2] = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
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
    public Float3 normalizedPositiveY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _buf1 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0f);
        dd[2] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _buf1 = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[2] * sd[2]), 1.0f);
        dd[2] = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
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
    public Float3 normalizedPositiveZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _buf1 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[2] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _buf1 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        dd[2] = Math.fma(-2.0f, Math.fma(sd[0], sd[0], sd[1] * sd[1]), 1.0f);
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 positiveX(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t12 * _t16;
            dd[1] = _t9 * _t16;
            dd[2] = _t10 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveX(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[1], sd[2] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[2], -(sd[1] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[0], sd[0], sd[3] * sd[3])));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t12 * _t16;
            dd[1] = _t9 * _t16;
            dd[2] = _t10 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 positiveY(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t10 * _t16;
            dd[1] = _t12 * _t16;
            dd[2] = _t9 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveY(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[3], sd[1] * sd[2]);
        float _t10 = 2.0f * Math.fma(sd[0], sd[1], -(sd[2] * sd[3]));
        float _t12 = Math.fma(-sd[2], sd[2], Math.fma(sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t10 * _t16;
            dd[1] = _t12 * _t16;
            dd[2] = _t9 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 positiveZ(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t9 * _t16;
            dd[1] = _t10 * _t16;
            dd[2] = _t12 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the selected column of this
     * quaternion's rotation matrix must lie roughly between {@code 1e-19} and {@code 1.8e19}.
     * Rescale inputs outside that band first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveZ(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], sd[2], sd[1] * sd[3]);
        float _t10 = 2.0f * Math.fma(sd[1], sd[2], -(sd[0] * sd[3]));
        float _t12 = Math.fma(sd[2], sd[2], Math.fma(-sd[1], sd[1], Math.fma(sd[3], sd[3], -(sd[0] * sd[0]))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            dd[0] = _t9 * _t16;
            dd[1] = _t10 * _t16;
            dd[2] = _t12 * _t16;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))} and
     * store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat pow(float t, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t10 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(Math.fma(sd[3], sd[3], _t2))));
        float _t11 = (float) Math.atan2((float) Math.sqrt(_t2), sd[3]) * (1.0f / (float) Math.sqrt(_t2));
        float _t18 = t * (_t2 > 0.0f ? sd[2] * _t11 : 0.0f);
        float _t19 = t * (_t2 > 0.0f ? sd[0] * _t11 : 0.0f);
        float _t20 = t * (_t2 > 0.0f ? sd[1] * _t11 : 0.0f);
        float _t23 = Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20));
        float _t24 = (float) Math.sqrt(_t23);
        var _col0 = (_t23 > 0.0f ? FloatVector.zero(COL_SPECIES).withLane(0, _t19).withLane(1, _t20).withLane(2, _t18).withLane(3, (float) Math.cos(_t24)).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t24) * _t10 * (1.0f / (float) Math.sqrt(_t23))).withLane(3, _t10)) : FloatVector.broadcast(COL_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t24) * _t10));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))} and
     * store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat pow(float t, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t10 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(Math.fma(sd[3], sd[3], _t2))));
        float _t11 = (float) Math.atan2((float) Math.sqrt(_t2), sd[3]) * (1.0f / (float) Math.sqrt(_t2));
        float _t18, _t19, _t20;
        if (_t2 > 0.0f) {
            _t18 = t * sd[2] * _t11;
            _t19 = t * sd[0] * _t11;
            _t20 = t * sd[1] * _t11;
        } else {
            _t18 = t * 0.0f;
            _t19 = t * 0.0f;
            _t20 = t * 0.0f;
        }
        float _t23 = Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20));
        float _t24 = (float) Math.sqrt(_t23);
        float _t28 = (float) Math.sin(_t24) * _t10 * (1.0f / (float) Math.sqrt(_t23));
        if (_t23 > 0.0f) {
            dd[0] = _t19 * _t28;
            dd[1] = _t20 * _t28;
            dd[2] = _t18 * _t28;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        dd[3] = (float) Math.cos(_t24) * _t10;
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
    public FloatQuat premul(FloatQuatR other, @Mutated FloatQuat dest) {
        return preMul(other, dest);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat premul(FloatQuatR other, @Mutated DoubleQuat dest) {
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
    public FloatQuat premul(float otherX, float otherY, float otherZ, float otherW, @Mutated FloatQuat dest) {
        return preMul(otherX, otherY, otherZ, otherW, dest);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat premul(float otherX, float otherY, float otherZ, float otherW, @Mutated DoubleQuat dest) {
        return preMul(otherX, otherY, otherZ, otherW, dest);
    }


    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle and store
     * the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     *
     * @param target the target rotation
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateTowards(FloatQuatR target, float step, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return rotateTowards_fma(target, step, dest);
        return rotateTowards_mulAdd(target, step, dest);
    }

    private FloatQuat rotateTowards_fma(FloatQuatR target, float step, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0f ? _sv0.fma(FloatVector.broadcast(COL_SPECIES, (float) Math.sin((1.0f - (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))))), FloatVector.broadcast(COL_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) * (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : _sv0.fma(FloatVector.broadcast(COL_SPECIES, 1.0f - (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f)), _sv2.mul(FloatVector.broadcast(COL_SPECIES, 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f))));
        float _t72 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t72 > 0.0f ? _sv3.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t72)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat rotateTowards_mulAdd(FloatQuatR target, float step, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] targetData = ((FloatQuatImpl) target).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        var _sv0 = FloatVector.fromArray(COL_SPECIES, sd, 0);
        var _sv1 = FloatVector.fromArray(COL_SPECIES, targetData, 0);
        var _sv2 = (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))) > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin((1.0f - (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))).add(FloatVector.broadcast(COL_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1])))))) * (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(COL_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))))))))) : _sv0.mul(FloatVector.broadcast(COL_SPECIES, 1.0f - (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f))).add(_sv2.mul(FloatVector.broadcast(COL_SPECIES, 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))) > 0.0f ? Math.min(1.0f, step / (4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] - (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])))))), (float) Math.sqrt(Math.fma(sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), sd[3] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[3] : targetData[3]), Math.fma(sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), sd[2] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[2] : targetData[2]), Math.fma(sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), sd[0] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[0] : targetData[0]), (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1])) * (sd[1] + (-Math.fma(sd[3], targetData[3], Math.fma(sd[2], targetData[2], Math.fma(sd[0], targetData[0], sd[1] * targetData[1]))) > 0.0f ? -targetData[1] : targetData[1]))))))))) : 0.0f))));
        float _t72 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _col0 = (_t72 > 0.0f ? _sv3.mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t72)))) : FloatVector.broadcast(COL_SPECIES, 0.0f));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle and store
     * the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param target the target rotation
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTowards(FloatQuatR target, float step, @Mutated DoubleQuat dest) {
        return rotateTowards(target.x(), target.y(), target.z(), target.w(), step, dest);
    }


    /**
     * Rotate this quaternion towards ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}), by at most the given maximum angle and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
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
    public FloatQuat rotateTowards(float targetX, float targetY, float targetZ, float targetW, float step, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t7 = Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        float _t9 = -_t7;
        float _t11 = (float) Math.acos(Math.min(1.0f, Math.abs(_t7)));
        float _t12 = (float) Math.sin(_t11);
        float _t12_inv = 1.0f / _t12;
        float _t13, _t14, _t15, _t16;
        if (_t9 > 0.0f) {
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
        float _t17 = sd[3] - _t13;
        float _t18 = sd[2] - _t14;
        float _t19 = sd[0] - _t15;
        float _t20 = sd[1] - _t16;
        float _t21 = sd[3] + _t13;
        float _t22 = sd[2] + _t14;
        float _t23 = sd[0] + _t15;
        float _t24 = sd[1] + _t16;
        float _t36 = 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))), (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24)))));
        float _t39 = _t36 > 0.0f ? Math.min(1.0f, step / _t36) : 0.0f;
        float _t40 = 1.0f - _t39;
        float _t42 = (float) Math.sin(_t11 * _t39);
        float _t44 = (float) Math.sin(_t40 * _t11);
        float _t65, _t66, _t67, _t68;
        if (_t12 > 0.0f) {
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
        float _t72 = Math.fma(_t65, _t65, Math.fma(_t66, _t66, Math.fma(_t67, _t67, _t68 * _t68)));
        float _t73 = (1.0f / (float) Math.sqrt(_t72));
        if (_t72 > 0.0f) {
            dd[0] = _t73 * _t67;
            dd[1] = _t73 * _t68;
            dd[2] = _t73 * _t66;
            dd[3] = _t73 * _t65;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
        }
        return dest;
    }


    /**
     * Rotate this quaternion towards ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}), by at most the given maximum angle and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code float} resolution
     * down to 0 - small rotations are not truncated.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat rotateTowards(float targetX, float targetY, float targetZ, float targetW, float step, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t7 = Math.fma(sd[3], targetW, Math.fma(sd[2], targetZ, Math.fma(sd[0], targetX, sd[1] * targetY)));
        float _t9 = -_t7;
        float _t11 = (float) Math.acos(Math.min(1.0f, Math.abs(_t7)));
        float _t12 = (float) Math.sin(_t11);
        float _t12_inv = 1.0f / _t12;
        float _t13, _t14, _t15, _t16;
        if (_t9 > 0.0f) {
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
        float _t17 = sd[3] - _t13;
        float _t18 = sd[2] - _t14;
        float _t19 = sd[0] - _t15;
        float _t20 = sd[1] - _t16;
        float _t21 = sd[3] + _t13;
        float _t22 = sd[2] + _t14;
        float _t23 = sd[0] + _t15;
        float _t24 = sd[1] + _t16;
        float _t36 = 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))), (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24)))));
        float _t39 = _t36 > 0.0f ? Math.min(1.0f, step / _t36) : 0.0f;
        float _t40 = 1.0f - _t39;
        float _t42 = (float) Math.sin(_t11 * _t39);
        float _t44 = (float) Math.sin(_t40 * _t11);
        float _t65, _t66, _t67, _t68;
        if (_t12 > 0.0f) {
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
        float _t72 = Math.fma(_t65, _t65, Math.fma(_t66, _t66, Math.fma(_t67, _t67, _t68 * _t68)));
        float _t73 = (1.0f / (float) Math.sqrt(_t72));
        if (_t72 > 0.0f) {
            dd[0] = _t73 * _t67;
            dd[1] = _t73 * _t68;
            dd[2] = _t73 * _t66;
            dd[3] = _t73 * _t65;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
            dd[3] = 0.0f;
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
    public FloatQuat lookAlong(Float3R dir, Float3R up, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dirData = ((Float3Impl) dir).data;
        float[] upData = ((Float3Impl) up).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirData[2] * _t3;
            _t8 = dirData[1] * _t3;
            _t9 = dirData[0] * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upData[0], _t8, -(upData[1] * _t9));
        float _t22 = Math.fma(upData[1], _t7, -(upData[2] * _t8));
        float _t23 = Math.fma(upData[2], _t9, -(upData[0] * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 - _t32;
        float _t38 = _t9 + _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.max(_t49, _t7);
        float _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t65 = (1.0f / (float) Math.sqrt(_t61));
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t63));
        float _t68 = (1.0f / (float) Math.sqrt(_t60));
        float _t108, _t109, _t110, _t111;
        if (_t59 > 0.0f) {
            _t108 = 0.5f * _t57 * _t68;
            _t109 = 0.5f * _t37 * _t68;
            _t110 = 0.5f * (float) Math.sqrt(_t60);
            _t111 = 0.5f * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5f * _t38 * _t65;
                _t109 = 0.5f * _t58 * _t65;
                _t110 = 0.5f * _t56 * _t65;
                _t111 = 0.5f * (float) Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5f * _t54 * _t66;
                    _t109 = 0.5f * (float) Math.sqrt(_t62);
                    _t110 = 0.5f * _t37 * _t66;
                    _t111 = 0.5f * _t58 * _t66;
                } else {
                    _t108 = 0.5f * (float) Math.sqrt(_t63);
                    _t109 = 0.5f * _t54 * _t67;
                    _t110 = 0.5f * _t57 * _t67;
                    _t111 = 0.5f * _t38 * _t67;
                }
            }
        }
        float _buf0 = Math.fma(sd[0], _t110, sd[3] * _t111) + Math.fma(sd[1], _t108, -(sd[2] * _t109));
        float _buf1 = Math.fma(sd[1], _t110, sd[2] * _t111) + Math.fma(sd[3], _t109, -(sd[0] * _t108));
        float _buf2 = Math.fma(sd[0], _t109, sd[3] * _t108) + Math.fma(sd[2], _t110, -(sd[1] * _t111));
        dd[3] = Math.fma(-sd[2], _t108, Math.fma(-sd[1], _t109, Math.fma(sd[3], _t110, -(sd[0] * _t111))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat lookAlong(Float3R dir, Float3R up, @Mutated DoubleQuat dest) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
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
    public FloatQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 - _t32;
        float _t38 = _t9 + _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.max(_t49, _t7);
        float _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t65 = (1.0f / (float) Math.sqrt(_t61));
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t63));
        float _t68 = (1.0f / (float) Math.sqrt(_t60));
        float _t108, _t109, _t110, _t111;
        if (_t59 > 0.0f) {
            _t108 = 0.5f * _t57 * _t68;
            _t109 = 0.5f * _t37 * _t68;
            _t110 = 0.5f * (float) Math.sqrt(_t60);
            _t111 = 0.5f * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5f * _t38 * _t65;
                _t109 = 0.5f * _t58 * _t65;
                _t110 = 0.5f * _t56 * _t65;
                _t111 = 0.5f * (float) Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5f * _t54 * _t66;
                    _t109 = 0.5f * (float) Math.sqrt(_t62);
                    _t110 = 0.5f * _t37 * _t66;
                    _t111 = 0.5f * _t58 * _t66;
                } else {
                    _t108 = 0.5f * (float) Math.sqrt(_t63);
                    _t109 = 0.5f * _t54 * _t67;
                    _t110 = 0.5f * _t57 * _t67;
                    _t111 = 0.5f * _t38 * _t67;
                }
            }
        }
        float _buf0 = Math.fma(sd[0], _t110, sd[3] * _t111) + Math.fma(sd[1], _t108, -(sd[2] * _t109));
        float _buf1 = Math.fma(sd[1], _t110, sd[2] * _t111) + Math.fma(sd[3], _t109, -(sd[0] * _t108));
        float _buf2 = Math.fma(sd[0], _t109, sd[3] * _t108) + Math.fma(sd[2], _t110, -(sd[1] * _t111));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 - _t32;
        float _t38 = _t9 + _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.max(_t49, _t7);
        float _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t65 = (1.0f / (float) Math.sqrt(_t61));
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t63));
        float _t68 = (1.0f / (float) Math.sqrt(_t60));
        float _t108, _t109, _t110, _t111;
        if (_t59 > 0.0f) {
            _t108 = 0.5f * _t57 * _t68;
            _t109 = 0.5f * _t37 * _t68;
            _t110 = 0.5f * (float) Math.sqrt(_t60);
            _t111 = 0.5f * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5f * _t38 * _t65;
                _t109 = 0.5f * _t58 * _t65;
                _t110 = 0.5f * _t56 * _t65;
                _t111 = 0.5f * (float) Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5f * _t54 * _t66;
                    _t109 = 0.5f * (float) Math.sqrt(_t62);
                    _t110 = 0.5f * _t37 * _t66;
                    _t111 = 0.5f * _t58 * _t66;
                } else {
                    _t108 = 0.5f * (float) Math.sqrt(_t63);
                    _t109 = 0.5f * _t54 * _t67;
                    _t110 = 0.5f * _t57 * _t67;
                    _t111 = 0.5f * _t38 * _t67;
                }
            }
        }
        float _buf0 = Math.fma(sd[0], _t110, sd[3] * _t111) + Math.fma(sd[1], _t108, -(sd[2] * _t109));
        float _buf1 = Math.fma(sd[1], _t110, sd[2] * _t111) + Math.fma(sd[3], _t109, -(sd[0] * _t108));
        float _buf2 = Math.fma(sd[0], _t109, sd[3] * _t108) + Math.fma(sd[2], _t110, -(sd[1] * _t111));
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
    @Mutated public FloatQuat makeRotationAxis(float angle, Float3R axis) {
        if (SimdMath.USE_FMA) return makeRotationAxis_fma(angle, axis);
        return makeRotationAxis_mulAdd(angle, axis);
    }

    private FloatQuat makeRotationAxis_fma(float angle, Float3R axis) {
        float[] dd = this.data;
        float[] axisData = ((Float3Impl) axis).data;
        float _t0 = 0.5f * angle;
        var _col0 = FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, axisData[0]).withLane(1, axisData[1]).withLane(2, axisData[2]).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationAxis_mulAdd(float angle, Float3R axis) {
        float[] dd = this.data;
        float[] axisData = ((Float3Impl) axis).data;
        float _t0 = 0.5f * angle;
        var _col0 = FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, axisData[0]).withLane(1, axisData[1]).withLane(2, axisData[2]).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0))));
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
    @Mutated public FloatQuat makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        if (SimdMath.USE_FMA) return makeRotationAxis_fma(angle, axisX, axisY, axisZ);
        return makeRotationAxis_mulAdd(angle, axisX, axisY, axisZ);
    }

    private FloatQuat makeRotationAxis_fma(float angle, float axisX, float axisY, float axisZ) {
        float[] dd = this.data;
        float _t0 = 0.5f * angle;
        var _col0 = FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationAxis_mulAdd(float angle, float axisX, float axisY, float axisZ) {
        float[] dd = this.data;
        float _t0 = 0.5f * angle;
        var _col0 = FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sin(_t0))));
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
    @Mutated public FloatQuat makeRotationLookAlong(Float3R dir, Float3R up) {
        if (SimdMath.USE_FMA) return makeRotationLookAlong_fma(dir, up);
        return makeRotationLookAlong_mulAdd(dir, up);
    }

    private FloatQuat makeRotationLookAlong_fma(Float3R dir, Float3R up) {
        float[] dd = this.data;
        float[] dirData = ((Float3Impl) dir).data;
        float[] upData = ((Float3Impl) up).data;
        float _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirData[2] * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirData[1] * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirData[0] * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upData[0], _t8, -(upData[1] * _t9));
        float _t22 = Math.fma(upData[1], _t7, -(upData[2] * _t8));
        float _t23 = Math.fma(upData[2], _t9, -(upData[0] * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t60)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationLookAlong_mulAdd(Float3R dir, Float3R up) {
        float[] dd = this.data;
        float[] dirData = ((Float3Impl) dir).data;
        float[] upData = ((Float3Impl) up).data;
        float _t2 = Math.fma(dirData[2], dirData[2], Math.fma(dirData[0], dirData[0], dirData[1] * dirData[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirData[2] * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirData[1] * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirData[0] * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upData[0], _t8, -(upData[1] * _t9));
        float _t22 = Math.fma(upData[1], _t7, -(upData[2] * _t8));
        float _t23 = Math.fma(upData[2], _t9, -(upData[0] * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t60)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
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
    @Mutated public FloatQuat makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        if (SimdMath.USE_FMA) return makeRotationLookAlong_fma(dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_mulAdd(dirX, dirY, dirZ, upX, upY, upZ);
    }

    private FloatQuat makeRotationLookAlong_fma(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float[] dd = this.data;
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t60)).fma(VEC_1, FloatVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationLookAlong_mulAdd(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float[] dd = this.data;
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.5f);
        var _col0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7)) > 0.0f ? _sv0.mul(FloatVector.broadcast(COL_SPECIES, (float) Math.sqrt(_t60)).mul(VEC_1).add(FloatVector.zero(COL_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31 > Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49 > _t7 ? _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(COL_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation that rotates {@code fromDir} onto {@code toDir} (both
     * must be unit vectors; for opposite vectors an arbitrary perpendicular rotation axis is
     * chosen).
     * <p>
     * The half-vector form is exact for nearly antiparallel inputs all the way down to the
     * 180-degree fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than
     * {@code 1e-6} (about 0.08 degrees from opposite); only there is the perpendicular axis chosen
     * arbitrarily.
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @return this
     */
    @Mutated public FloatQuat makeRotationTo(Float3R fromDir, Float3R toDir) {
        if (SimdMath.USE_FMA) return makeRotationTo_fma(fromDir, toDir);
        return makeRotationTo_mulAdd(fromDir, toDir);
    }

    private FloatQuat makeRotationTo_fma(Float3R fromDir, Float3R toDir) {
        float[] dd = this.data;
        float[] fromDirData = ((Float3Impl) fromDir).data;
        float[] toDirData = ((Float3Impl) toDir).data;
        float _t3 = fromDirData[2] + toDirData[2];
        float _t4 = fromDirData[0] + toDirData[0];
        float _t5 = fromDirData[1] + toDirData[1];
        float _t13 = Math.fma(fromDirData[0], fromDirData[0], fromDirData[1] * fromDirData[1]);
        float _t15 = Math.fma(fromDirData[1], toDirData[2], -(fromDirData[2] * toDirData[1]));
        float _t16 = Math.fma(fromDirData[2], toDirData[0], -(fromDirData[0] * toDirData[2]));
        float _t17 = Math.fma(fromDirData[0], toDirData[1], -(fromDirData[1] * toDirData[0]));
        float _t18 = _t13 > 0.0f ? fromDirData[1] : 0.0f;
        float _t19 = _t13 > 0.0f ? 0.0f : -fromDirData[1];
        float _t20 = _t13 > 0.0f ? -fromDirData[0] : fromDirData[2];
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t33 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.0f);
        var _col0 = (0.5f * _t22 > 1.0E-6f ? FloatVector.zero(COL_SPECIES).withLane(0, _t15).withLane(1, _t16).withLane(2, _t17).withLane(3, 0.5f).mul(FloatVector.broadcast(COL_SPECIES, _t33).withLane(3, _t22 * _t33)) : (_t29 > 0.0f ? _sv0.fma(VEC_1, FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t29))).mul(FloatVector.zero(COL_SPECIES).withLane(0, _t18).withLane(1, _t20).withLane(2, _t19))) : _sv0));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationTo_mulAdd(Float3R fromDir, Float3R toDir) {
        float[] dd = this.data;
        float[] fromDirData = ((Float3Impl) fromDir).data;
        float[] toDirData = ((Float3Impl) toDir).data;
        float _t3 = fromDirData[2] + toDirData[2];
        float _t4 = fromDirData[0] + toDirData[0];
        float _t5 = fromDirData[1] + toDirData[1];
        float _t13 = Math.fma(fromDirData[0], fromDirData[0], fromDirData[1] * fromDirData[1]);
        float _t15 = Math.fma(fromDirData[1], toDirData[2], -(fromDirData[2] * toDirData[1]));
        float _t16 = Math.fma(fromDirData[2], toDirData[0], -(fromDirData[0] * toDirData[2]));
        float _t17 = Math.fma(fromDirData[0], toDirData[1], -(fromDirData[1] * toDirData[0]));
        float _t18 = _t13 > 0.0f ? fromDirData[1] : 0.0f;
        float _t19 = _t13 > 0.0f ? 0.0f : -fromDirData[1];
        float _t20 = _t13 > 0.0f ? -fromDirData[0] : fromDirData[2];
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t33 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.0f);
        var _col0 = (0.5f * _t22 > 1.0E-6f ? FloatVector.zero(COL_SPECIES).withLane(0, _t15).withLane(1, _t16).withLane(2, _t17).withLane(3, 0.5f).mul(FloatVector.broadcast(COL_SPECIES, _t33).withLane(3, _t22 * _t33)) : (_t29 > 0.0f ? _sv0.mul(VEC_1).add(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t29))).mul(FloatVector.zero(COL_SPECIES).withLane(0, _t18).withLane(1, _t20).withLane(2, _t19))) : _sv0));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to the rotation that rotates ({@code fromDirX}, {@code fromDirY},
     * {@code fromDirZ}) onto ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen).
     * <p>
     * The half-vector form is exact for nearly antiparallel inputs all the way down to the
     * 180-degree fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than
     * {@code 1e-6} (about 0.08 degrees from opposite); only there is the perpendicular axis chosen
     * arbitrarily.
     *
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @return this
     */
    @Mutated public FloatQuat makeRotationTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        if (SimdMath.USE_FMA) return makeRotationTo_fma(fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return makeRotationTo_mulAdd(fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
    }

    private FloatQuat makeRotationTo_fma(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float[] dd = this.data;
        float _t3 = fromDirZ + toDirZ;
        float _t4 = fromDirX + toDirX;
        float _t5 = fromDirY + toDirY;
        float _t13 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t15 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        float _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        float _t17 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        float _t18 = _t13 > 0.0f ? fromDirY : 0.0f;
        float _t19 = _t13 > 0.0f ? 0.0f : -fromDirY;
        float _t20 = _t13 > 0.0f ? -fromDirX : fromDirZ;
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t33 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.0f);
        var _col0 = (0.5f * _t22 > 1.0E-6f ? FloatVector.zero(COL_SPECIES).withLane(0, _t15).withLane(1, _t16).withLane(2, _t17).withLane(3, 0.5f).mul(FloatVector.broadcast(COL_SPECIES, _t33).withLane(3, _t22 * _t33)) : (_t29 > 0.0f ? _sv0.fma(VEC_1, FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t29))).mul(FloatVector.zero(COL_SPECIES).withLane(0, _t18).withLane(1, _t20).withLane(2, _t19))) : _sv0));
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationTo_mulAdd(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float[] dd = this.data;
        float _t3 = fromDirZ + toDirZ;
        float _t4 = fromDirX + toDirX;
        float _t5 = fromDirY + toDirY;
        float _t13 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t15 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        float _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        float _t17 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        float _t18 = _t13 > 0.0f ? fromDirY : 0.0f;
        float _t19 = _t13 > 0.0f ? 0.0f : -fromDirY;
        float _t20 = _t13 > 0.0f ? -fromDirX : fromDirZ;
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t33 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        var _sv0 = FloatVector.broadcast(COL_SPECIES, 0.0f);
        var _col0 = (0.5f * _t22 > 1.0E-6f ? FloatVector.zero(COL_SPECIES).withLane(0, _t15).withLane(1, _t16).withLane(2, _t17).withLane(3, 0.5f).mul(FloatVector.broadcast(COL_SPECIES, _t33).withLane(3, _t22 * _t33)) : (_t29 > 0.0f ? _sv0.mul(VEC_1).add(FloatVector.broadcast(COL_SPECIES, (1.0f / (float) Math.sqrt(_t29))).mul(FloatVector.zero(COL_SPECIES).withLane(0, _t18).withLane(1, _t20).withLane(2, _t19))) : _sv0));
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public FloatQuat makeRotationX(float angle) {
        float[] dd = this.data;
        float _t0 = 0.5f * angle;
        dd[0] = (float) Math.sin(_t0);
        dd[1] = 0.0f;
        dd[2] = 0.0f;
        dd[3] = (float) Math.cos(_t0);
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
    @Mutated public FloatQuat makeRotationXYZ(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t5, _t10 * _t8);
        dd[1] = Math.fma(_t10, _t5, -(_t9 * _t8));
        dd[2] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleX}, {@code angleZ} and {@code angleY}
     * radians about the X, Z and Y axes, in that order (the matrix product {@code Rx * Rz * Ry}, so
     * a vector is rotated about the Y axis first, then Z, then X).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatQuat makeRotationXZY(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
    @Mutated public FloatQuat makeRotationY(float angle) {
        float[] dd = this.data;
        float _t0 = 0.5f * angle;
        dd[0] = 0.0f;
        dd[1] = (float) Math.sin(_t0);
        dd[2] = 0.0f;
        dd[3] = (float) Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleX} and {@code angleZ}
     * radians about the Y, X and Z axes, in that order (the matrix product {@code Ry * Rx * Rz}, so
     * a vector is rotated about the Z axis first, then X, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatQuat makeRotationYXZ(float angleX, float angleY, float angleZ) {
        if (SimdMath.USE_FMA) return makeRotationYXZ_fma(angleX, angleY, angleZ);
        return makeRotationYXZ_mulAdd(angleX, angleY, angleZ);
    }

    private FloatQuat makeRotationYXZ_fma(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
        var _col0 = FloatVector.zero(COL_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).fma(FloatVector.broadcast(COL_SPECIES, _t5), FloatVector.broadcast(COL_SPECIES, _t10).withLane(3, _t12).mul(FloatVector.broadcast(COL_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _col0.intoArray(dd, 0);
        return this;
    }

    private FloatQuat makeRotationYXZ_mulAdd(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
        var _col0 = FloatVector.zero(COL_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).mul(FloatVector.broadcast(COL_SPECIES, _t5)).add(FloatVector.broadcast(COL_SPECIES, _t10).withLane(3, _t12).mul(FloatVector.broadcast(COL_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _col0.intoArray(dd, 0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleY}, {@code angleZ} and {@code angleX}
     * radians about the Y, Z and X axes, in that order (the matrix product {@code Ry * Rz * Rx}, so
     * a vector is rotated about the X axis first, then Z, then Y).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatQuat makeRotationYZX(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
    @Mutated public FloatQuat makeRotationZ(float angle) {
        float[] dd = this.data;
        float _t0 = 0.5f * angle;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = (float) Math.sin(_t0);
        dd[3] = (float) Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleX} and {@code angleY}
     * radians about the Z, X and Y axes, in that order (the matrix product {@code Rz * Rx * Ry}, so
     * a vector is rotated about the Y axis first, then X, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatQuat makeRotationZXY(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
        dd[0] = Math.fma(_t9, _t5, -(_t10 * _t8));
        dd[1] = Math.fma(_t11, _t5, _t12 * _t8);
        dd[2] = Math.fma(_t9, _t8, _t10 * _t5);
        dd[3] = Math.fma(_t12, _t5, -(_t11 * _t8));
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angleZ}, {@code angleY} and {@code angleX}
     * radians about the Z, Y and X axes, in that order (the matrix product {@code Rz * Ry * Rx}, so
     * a vector is rotated about the X axis first, then Y, then Z).
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return this
     */
    @Mutated public FloatQuat makeRotationZYX(float angleX, float angleY, float angleZ) {
        float[] dd = this.data;
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
    public FloatQuat preRotateX(float angle, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return preRotateX_fma(angle, dest);
        return preRotateX_mulAdd(angle, dest);
    }

    private FloatQuat preRotateX_fma(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).fma(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)), FloatVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(2, sd[1]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(1, sd[2]).withLane(3, sd[0]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat preRotateX_mulAdd(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0))).add(FloatVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(2, sd[1]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(1, sd[2]).withLane(3, sd[0]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateX(float angle, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(sd[0], _t1, sd[3] * _t2);
        float _buf1 = Math.fma(sd[1], _t1, -(sd[2] * _t2));
        dd[2] = Math.fma(sd[1], _t2, sd[2] * _t1);
        dd[3] = Math.fma(sd[3], _t1, -(sd[0] * _t2));
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
    public FloatQuat preRotateY(float angle, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return preRotateY_fma(angle, dest);
        return preRotateY_mulAdd(angle, dest);
    }

    private FloatQuat preRotateY_fma(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).fma(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)), FloatVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(1, sd[3]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(2, sd[0]).withLane(3, sd[1]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat preRotateY_mulAdd(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0))).add(FloatVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(1, sd[3]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(2, sd[0]).withLane(3, sd[1]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateY(float angle, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(sd[0], _t1, sd[2] * _t2);
        float _buf1 = Math.fma(sd[1], _t1, sd[3] * _t2);
        dd[2] = Math.fma(sd[2], _t1, -(sd[0] * _t2));
        dd[3] = Math.fma(sd[3], _t1, -(sd[1] * _t2));
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
    public FloatQuat preRotateZ(float angle, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return preRotateZ_fma(angle, dest);
        return preRotateZ_mulAdd(angle, dest);
    }

    private FloatQuat preRotateZ_fma(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).fma(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)), FloatVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(2, sd[3]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(3, sd[2]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat preRotateZ_mulAdd(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0))).add(FloatVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(2, sd[3]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(3, sd[2]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateZ(float angle, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(sd[0], _t1, -(sd[1] * _t2));
        dd[1] = Math.fma(sd[0], _t2, sd[1] * _t1);
        float _buf1 = Math.fma(sd[2], _t1, sd[3] * _t2);
        dd[3] = Math.fma(sd[3], _t1, -(sd[2] * _t2));
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
    public FloatQuat rotateAxis(float angle, Float3R axis, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] axisData = ((Float3Impl) axis).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisData[0] * _t2;
        float _t4 = axisData[2] * _t2;
        float _t5 = axisData[1] * _t2;
        float _buf0 = Math.fma(sd[0], _t1, sd[3] * _t3) + Math.fma(sd[1], _t4, -(sd[2] * _t5));
        float _buf1 = Math.fma(sd[1], _t1, sd[2] * _t3) + Math.fma(sd[3], _t5, -(sd[0] * _t4));
        float _buf2 = Math.fma(sd[0], _t5, sd[3] * _t4) + Math.fma(sd[2], _t1, -(sd[1] * _t3));
        dd[3] = Math.fma(-sd[2], _t4, Math.fma(-sd[1], _t5, Math.fma(sd[3], _t1, -(sd[0] * _t3))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this quaternion and
     * store the result in {@code dest}.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateAxis(float angle, Float3R axis, @Mutated DoubleQuat dest) {
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
    public FloatQuat rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        float _buf0 = Math.fma(sd[0], _t1, sd[3] * _t3) + Math.fma(sd[1], _t4, -(sd[2] * _t5));
        float _buf1 = Math.fma(sd[1], _t1, sd[2] * _t3) + Math.fma(sd[3], _t5, -(sd[0] * _t4));
        float _buf2 = Math.fma(sd[0], _t5, sd[3] * _t4) + Math.fma(sd[2], _t1, -(sd[1] * _t3));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        float _buf0 = Math.fma(sd[0], _t1, sd[3] * _t3) + Math.fma(sd[1], _t4, -(sd[2] * _t5));
        float _buf1 = Math.fma(sd[1], _t1, sd[2] * _t3) + Math.fma(sd[3], _t5, -(sd[0] * _t4));
        float _buf2 = Math.fma(sd[0], _t5, sd[3] * _t4) + Math.fma(sd[2], _t1, -(sd[1] * _t3));
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
     * <p>
     * The half-vector form is exact for nearly antiparallel inputs all the way down to the
     * 180-degree fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than
     * {@code 1e-6} (about 0.08 degrees from opposite); only there is the perpendicular axis chosen
     * arbitrarily.
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateTo(Float3R fromDir, Float3R toDir, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] fromDirData = ((Float3Impl) fromDir).data;
        float[] toDirData = ((Float3Impl) toDir).data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t3 = fromDirData[2] + toDirData[2];
        float _t4 = fromDirData[0] + toDirData[0];
        float _t5 = fromDirData[1] + toDirData[1];
        float _t13 = Math.fma(fromDirData[0], fromDirData[0], fromDirData[1] * fromDirData[1]);
        float _t15 = Math.fma(fromDirData[1], toDirData[2], -(fromDirData[2] * toDirData[1]));
        float _t16 = Math.fma(fromDirData[2], toDirData[0], -(fromDirData[0] * toDirData[2]));
        float _t17 = Math.fma(fromDirData[0], toDirData[1], -(fromDirData[1] * toDirData[0]));
        float _t18, _t19, _t20;
        if (_t13 > 0.0f) {
            _t18 = fromDirData[1];
            _t19 = 0.0f;
            _t20 = -fromDirData[0];
        } else {
            _t18 = 0.0f;
            _t19 = -fromDirData[1];
            _t20 = fromDirData[2];
        }
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t23 = 0.5f * _t22;
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t36 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        float _t42, _t46, _t47, _t48;
        if (_t23 > 1.0E-6f) {
            _t42 = 0.5f * _t22 * _t36;
            _t46 = _t15 * _t36;
            _t47 = _t17 * _t36;
            _t48 = _t16 * _t36;
        } else {
            if (_t29 > 0.0f) {
                _t42 = 0.0f;
                _t46 = _t30 * _t18;
                _t47 = _t30 * _t19;
                _t48 = _t30 * _t20;
            } else {
                _t42 = 0.0f;
                _t46 = 0.0f;
                _t47 = 0.0f;
                _t48 = 0.0f;
            }
        }
        float _buf0 = Math.fma(sd[0], _t42, sd[3] * _t46) + Math.fma(sd[1], _t47, -(sd[2] * _t48));
        float _buf1 = Math.fma(sd[1], _t42, sd[2] * _t46) + Math.fma(sd[3], _t48, -(sd[0] * _t47));
        float _buf2 = Math.fma(sd[0], _t48, sd[3] * _t47) + Math.fma(sd[2], _t42, -(sd[1] * _t46));
        dd[3] = Math.fma(-sd[2], _t47, Math.fma(-sd[1], _t48, Math.fma(sd[3], _t42, -(sd[0] * _t46))));
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
     * The half-vector form is exact for nearly antiparallel inputs all the way down to the
     * 180-degree fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than
     * {@code 1e-6} (about 0.08 degrees from opposite); only there is the perpendicular axis chosen
     * arbitrarily.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTo(Float3R fromDir, Float3R toDir, @Mutated DoubleQuat dest) {
        return rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z(), dest);
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
     * The half-vector form is exact for nearly antiparallel inputs all the way down to the
     * 180-degree fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than
     * {@code 1e-6} (about 0.08 degrees from opposite); only there is the perpendicular axis chosen
     * arbitrarily.
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
    public FloatQuat rotateTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t3 = fromDirZ + toDirZ;
        float _t4 = fromDirX + toDirX;
        float _t5 = fromDirY + toDirY;
        float _t13 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t15 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        float _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        float _t17 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        float _t18, _t19, _t20;
        if (_t13 > 0.0f) {
            _t18 = fromDirY;
            _t19 = 0.0f;
            _t20 = -fromDirX;
        } else {
            _t18 = 0.0f;
            _t19 = -fromDirY;
            _t20 = fromDirZ;
        }
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t23 = 0.5f * _t22;
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t36 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        float _t42, _t46, _t47, _t48;
        if (_t23 > 1.0E-6f) {
            _t42 = 0.5f * _t22 * _t36;
            _t46 = _t15 * _t36;
            _t47 = _t17 * _t36;
            _t48 = _t16 * _t36;
        } else {
            if (_t29 > 0.0f) {
                _t42 = 0.0f;
                _t46 = _t30 * _t18;
                _t47 = _t30 * _t19;
                _t48 = _t30 * _t20;
            } else {
                _t42 = 0.0f;
                _t46 = 0.0f;
                _t47 = 0.0f;
                _t48 = 0.0f;
            }
        }
        float _buf0 = Math.fma(sd[0], _t42, sd[3] * _t46) + Math.fma(sd[1], _t47, -(sd[2] * _t48));
        float _buf1 = Math.fma(sd[1], _t42, sd[2] * _t46) + Math.fma(sd[3], _t48, -(sd[0] * _t47));
        float _buf2 = Math.fma(sd[0], _t48, sd[3] * _t47) + Math.fma(sd[2], _t42, -(sd[1] * _t46));
        dd[3] = Math.fma(-sd[2], _t47, Math.fma(-sd[1], _t48, Math.fma(sd[3], _t42, -(sd[0] * _t46))));
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
     * The half-vector form is exact for nearly antiparallel inputs all the way down to the
     * 180-degree fallback, which is taken when {@code 1 + dot(fromDir, toDir)} is no larger than
     * {@code 1e-6} (about 0.08 degrees from opposite); only there is the perpendicular axis chosen
     * arbitrarily.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleQuat rotateTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t3 = fromDirZ + toDirZ;
        float _t4 = fromDirX + toDirX;
        float _t5 = fromDirY + toDirY;
        float _t13 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t15 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY));
        float _t16 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ));
        float _t17 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX));
        float _t18, _t19, _t20;
        if (_t13 > 0.0f) {
            _t18 = fromDirY;
            _t19 = 0.0f;
            _t20 = -fromDirX;
        } else {
            _t18 = 0.0f;
            _t19 = -fromDirY;
            _t20 = fromDirZ;
        }
        float _t22 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t23 = 0.5f * _t22;
        float _t29 = Math.fma(_t19, _t19, Math.fma(_t18, _t18, _t20 * _t20));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t36 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        float _t42, _t46, _t47, _t48;
        if (_t23 > 1.0E-6f) {
            _t42 = 0.5f * _t22 * _t36;
            _t46 = _t15 * _t36;
            _t47 = _t17 * _t36;
            _t48 = _t16 * _t36;
        } else {
            if (_t29 > 0.0f) {
                _t42 = 0.0f;
                _t46 = _t30 * _t18;
                _t47 = _t30 * _t19;
                _t48 = _t30 * _t20;
            } else {
                _t42 = 0.0f;
                _t46 = 0.0f;
                _t47 = 0.0f;
                _t48 = 0.0f;
            }
        }
        float _buf0 = Math.fma(sd[0], _t42, sd[3] * _t46) + Math.fma(sd[1], _t47, -(sd[2] * _t48));
        float _buf1 = Math.fma(sd[1], _t42, sd[2] * _t46) + Math.fma(sd[3], _t48, -(sd[0] * _t47));
        float _buf2 = Math.fma(sd[0], _t48, sd[3] * _t47) + Math.fma(sd[2], _t42, -(sd[1] * _t46));
        dd[3] = Math.fma(-sd[2], _t47, Math.fma(-sd[1], _t48, Math.fma(sd[3], _t42, -(sd[0] * _t46))));
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
    public FloatQuat rotateX(float angle, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return rotateX_fma(angle, dest);
        return rotateX_mulAdd(angle, dest);
    }

    private FloatQuat rotateX_fma(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).fma(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)), FloatVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(1, sd[2]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(2, sd[1]).withLane(3, sd[0]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat rotateX_mulAdd(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0))).add(FloatVector.zero(COL_SPECIES).withLane(0, sd[3]).withLane(1, sd[2]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(2, sd[1]).withLane(3, sd[0]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_3));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local X axis and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateX(float angle, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(sd[0], _t1, sd[3] * _t2);
        float _buf1 = Math.fma(sd[1], _t1, sd[2] * _t2);
        dd[2] = Math.fma(sd[2], _t1, -(sd[1] * _t2));
        dd[3] = Math.fma(sd[3], _t1, -(sd[0] * _t2));
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
    public FloatQuat rotateXYZ(float angleX, float angleY, float angleZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        float _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        float _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        float _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateXYZ(float angleX, float angleY, float angleZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        float _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        float _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        float _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
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
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateXZY(float angleX, float angleY, float angleZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        float _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        float _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        float _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(-sd[2], _t20, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t21))));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateXZY(float angleX, float angleY, float angleZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        float _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t20, -(sd[2] * _t22));
        float _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t22, -(sd[0] * _t20));
        float _buf2 = Math.fma(sd[0], _t22, sd[3] * _t20) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
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
    public FloatQuat rotateY(float angle, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return rotateY_fma(angle, dest);
        return rotateY_mulAdd(angle, dest);
    }

    private FloatQuat rotateY_fma(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).fma(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)), FloatVector.zero(COL_SPECIES).withLane(1, sd[3]).withLane(2, sd[0]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(3, sd[1]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat rotateY_mulAdd(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0))).add(FloatVector.zero(COL_SPECIES).withLane(1, sd[3]).withLane(2, sd[0]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(0, sd[2]).withLane(3, sd[1]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_4));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Y axis and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateY(float angle, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(sd[0], _t1, -(sd[2] * _t2));
        float _buf1 = Math.fma(sd[1], _t1, sd[3] * _t2);
        dd[2] = Math.fma(sd[0], _t2, sd[2] * _t1);
        dd[3] = Math.fma(sd[3], _t1, -(sd[1] * _t2));
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
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateYXZ(float angleX, float angleY, float angleZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        float _buf0 = Math.fma(sd[0], _t19, sd[3] * _t20) + Math.fma(sd[1], _t21, -(sd[2] * _t22));
        float _buf1 = Math.fma(sd[1], _t19, sd[2] * _t20) + Math.fma(sd[3], _t22, -(sd[0] * _t21));
        float _buf2 = Math.fma(sd[0], _t22, sd[3] * _t21) + Math.fma(sd[2], _t19, -(sd[1] * _t20));
        dd[3] = Math.fma(-sd[2], _t21, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t20))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateYXZ(float angleX, float angleY, float angleZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        float _buf0 = Math.fma(sd[0], _t19, sd[3] * _t20) + Math.fma(sd[1], _t21, -(sd[2] * _t22));
        float _buf1 = Math.fma(sd[1], _t19, sd[2] * _t20) + Math.fma(sd[3], _t22, -(sd[0] * _t21));
        float _buf2 = Math.fma(sd[0], _t22, sd[3] * _t21) + Math.fma(sd[2], _t19, -(sd[1] * _t20));
        dd[3] = Math.fma(-sd[2], _t21, Math.fma(-sd[1], _t22, Math.fma(sd[3], _t19, -(sd[0] * _t20))));
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
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateYZX(float angleX, float angleY, float angleZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        float _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        float _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        float _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
        dd[3] = Math.fma(-sd[2], _t22, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t19))));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateYZX(float angleX, float angleY, float angleZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        float _buf0 = Math.fma(sd[0], _t21, sd[3] * _t19) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        float _buf1 = Math.fma(sd[1], _t21, sd[2] * _t19) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        float _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t21, -(sd[1] * _t19));
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
    public FloatQuat rotateZ(float angle, @Mutated FloatQuat dest) {
        if (SimdMath.USE_FMA) return rotateZ_fma(angle, dest);
        return rotateZ_mulAdd(angle, dest);
    }

    private FloatQuat rotateZ_fma(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).fma(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0)), FloatVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(2, sd[3]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(3, sd[2]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }

    private FloatQuat rotateZ_mulAdd(float angle, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t2 = (float) Math.sin(_t0);
        var _col0 = FloatVector.fromArray(COL_SPECIES, sd, 0).mul(FloatVector.broadcast(COL_SPECIES, (float) Math.cos(_t0))).add(FloatVector.zero(COL_SPECIES).withLane(0, sd[1]).withLane(2, sd[3]).mul(FloatVector.broadcast(COL_SPECIES, _t2)).blend(FloatVector.zero(COL_SPECIES).withLane(1, sd[0]).withLane(3, sd[2]).mul(FloatVector.broadcast(COL_SPECIES, -_t2)), MASK_2));
        _col0.intoArray(dd, 0);
        return dest;
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Z axis and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateZ(float angle, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(sd[0], _t1, sd[1] * _t2);
        dd[1] = Math.fma(sd[1], _t1, -(sd[0] * _t2));
        float _buf1 = Math.fma(sd[2], _t1, sd[3] * _t2);
        dd[3] = Math.fma(sd[3], _t1, -(sd[2] * _t2));
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
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateZXY(float angleX, float angleY, float angleZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        float _buf0 = Math.fma(sd[0], _t21, sd[3] * _t22) + Math.fma(sd[1], _t19, -(sd[2] * _t20));
        float _buf1 = Math.fma(sd[1], _t21, sd[2] * _t22) + Math.fma(sd[3], _t20, -(sd[0] * _t19));
        float _buf2 = Math.fma(sd[0], _t20, sd[3] * _t19) + Math.fma(sd[2], _t21, -(sd[1] * _t22));
        dd[3] = Math.fma(-sd[2], _t19, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t22))));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateZXY(float angleX, float angleY, float angleZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        float _buf0 = Math.fma(sd[0], _t21, sd[3] * _t22) + Math.fma(sd[1], _t19, -(sd[2] * _t20));
        float _buf1 = Math.fma(sd[1], _t21, sd[2] * _t22) + Math.fma(sd[3], _t20, -(sd[0] * _t19));
        float _buf2 = Math.fma(sd[0], _t20, sd[3] * _t19) + Math.fma(sd[2], _t21, -(sd[1] * _t22));
        dd[3] = Math.fma(-sd[2], _t19, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t21, -(sd[0] * _t22))));
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
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat rotateZYX(float angleX, float angleY, float angleZ, @Mutated FloatQuat dest) {
        float[] sd = this.data;
        float[] dd = ((FloatQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        float _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        float _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        float _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
        dd[3] = Math.fma(-sd[2], _t22, Math.fma(-sd[1], _t20, Math.fma(sd[3], _t19, -(sd[0] * _t21))));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateZYX(float angleX, float angleY, float angleZ, @Mutated DoubleQuat dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleQuatImpl) dest).data;
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
        float _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        float _buf0 = Math.fma(sd[0], _t19, sd[3] * _t21) + Math.fma(sd[1], _t22, -(sd[2] * _t20));
        float _buf1 = Math.fma(sd[1], _t19, sd[2] * _t21) + Math.fma(sd[3], _t20, -(sd[0] * _t22));
        float _buf2 = Math.fma(sd[0], _t20, sd[3] * _t22) + Math.fma(sd[2], _t19, -(sd[1] * _t21));
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
    public Float3 transform(Float3R v, @Mutated Float3 dest) {
        return transform(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform {@code v} by this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(Float3R v, @Mutated Double3 dest) {
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
    public Float3 transform(float vX, float vY, float vZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], vY, -(sd[1] * vX));
        float _t10 = 2.0f * Math.fma(sd[2], vX, -(sd[0] * vZ));
        float _t11 = 2.0f * Math.fma(sd[1], vZ, -(sd[2] * vY));
        float _buf0 = Math.fma(sd[1], _t9, Math.fma(-sd[2], _t10, Math.fma(sd[3], _t11, vX)));
        float _buf1 = Math.fma(sd[2], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vY)));
        dd[2] = Math.fma(sd[0], _t10, Math.fma(-sd[1], _t11, Math.fma(sd[3], _t9, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this quaternion and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transform(float vX, float vY, float vZ, @Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], vY, -(sd[1] * vX));
        float _t10 = 2.0f * Math.fma(sd[2], vX, -(sd[0] * vZ));
        float _t11 = 2.0f * Math.fma(sd[1], vZ, -(sd[2] * vY));
        float _buf0 = Math.fma(sd[1], _t9, Math.fma(-sd[2], _t10, Math.fma(sd[3], _t11, vX)));
        float _buf1 = Math.fma(sd[2], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vY)));
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
    public Float3 transformInverse(Float3R v, @Mutated Float3 dest) {
        return transformInverse(v.x(), v.y(), v.z(), dest);
    }


    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion) and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param v the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(Float3R v, @Mutated Double3 dest) {
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
    public Float3 transformInverse(float vX, float vY, float vZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], vZ, -(sd[2] * vX));
        float _t10 = 2.0f * Math.fma(sd[1], vX, -(sd[0] * vY));
        float _t11 = 2.0f * Math.fma(sd[2], vY, -(sd[1] * vZ));
        float _buf0 = Math.fma(sd[2], _t9, Math.fma(-sd[1], _t10, Math.fma(sd[3], _t11, vX)));
        float _buf1 = Math.fma(sd[0], _t10, Math.fma(-sd[2], _t11, Math.fma(sd[3], _t9, vY)));
        dd[2] = Math.fma(sd[1], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by the inverse of this quaternion (assumes a
     * unit quaternion) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 transformInverse(float vX, float vY, float vZ, @Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(sd[0], vZ, -(sd[2] * vX));
        float _t10 = 2.0f * Math.fma(sd[1], vX, -(sd[0] * vY));
        float _t11 = 2.0f * Math.fma(sd[2], vY, -(sd[1] * vZ));
        float _buf0 = Math.fma(sd[2], _t9, Math.fma(-sd[1], _t10, Math.fma(sd[3], _t11, vX)));
        float _buf1 = Math.fma(sd[0], _t10, Math.fma(-sd[2], _t11, Math.fma(sd[3], _t9, vY)));
        dd[2] = Math.fma(sd[1], _t11, Math.fma(-sd[0], _t9, Math.fma(sd[3], _t10, vZ)));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }

    public float x() { return data[0]; }
    public float y() { return data[1]; }
    public float z() { return data[2]; }
    public float w() { return data[3]; }

    @Override public String toString() {
        return "FloatQuat(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatQuatImpl)) return false;
        FloatQuatImpl o = (FloatQuatImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Float.isFinite(data[0])
            && Float.isFinite(data[1])
            && Float.isFinite(data[2])
            && Float.isFinite(data[3]);
    }

    @Override public boolean equalsEpsilon(FloatQuatR other, float epsilon) {
        return Math.abs(data[0] - other.x()) <= epsilon
            && Math.abs(data[1] - other.y()) <= epsilon
            && Math.abs(data[2] - other.z()) <= epsilon
            && Math.abs(data[3] - other.w()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        float[] d = this.data;
        FloatVector.fromArray(COL_SPECIES, d, 0).intoArray(dest, offset);
        return dest;
    }
    public @Mutated FloatQuat load(float[] src, int offset) {
        float[] d = this.data;
        FloatVector.fromArray(COL_SPECIES, src, offset).intoArray(d, 0);
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        float[] d = this.data;
        if (buf.hasArray()) {
            float[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            FloatVector.fromArray(COL_SPECIES, d, 0).intoArray(arr, off);
        } else if (buf.order() != ByteOrder.nativeOrder()) {
            return BB_OPS.storeAbsolute(this, index, buf);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 4;
            FloatVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, baseOff, ByteOrder.nativeOrder());
        }
        return buf;
    }
    @Mutated public FloatQuat loadAbsolute(int index, FloatBuffer buf) {
        float[] d = this.data;
        if (buf.hasArray()) {
            float[] arr = buf.array();
            int off = buf.arrayOffset() + index;
            FloatVector.fromArray(COL_SPECIES, arr, off).intoArray(d, 0);
        } else if (buf.order() != ByteOrder.nativeOrder()) {
            return BB_OPS.loadAbsolute(this, index, buf);
        } else {
            MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
            long baseOff = (long) index * 4;
            FloatVector.fromMemorySegment(COL_SPECIES, seg, baseOff, ByteOrder.nativeOrder()).intoArray(d, 0);
        }
        return this;
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        if (buf.order() != ByteOrder.nativeOrder()) return BB_OPS.storeAbsolute(this, index, buf);
        float[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        FloatVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, index, ByteOrder.nativeOrder());
        return buf;
    }
    public FloatQuat loadAbsolute(int index, ByteBuffer buf) {
        if (buf.order() != ByteOrder.nativeOrder()) return BB_OPS.loadAbsolute(this, index, buf);
        float[] d = this.data;
        MemorySegment seg = MemorySegment.ofBuffer(buf.duplicate().position(0));
        FloatVector.fromMemorySegment(COL_SPECIES, seg, index, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }
    public FloatQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        float[] d = this.data;
        MemorySegment seg = dest;
        FloatVector.fromArray(COL_SPECIES, d, 0).intoMemorySegment(seg, offset, ByteOrder.nativeOrder());
        return dest;
    }
    public FloatQuat load(long offset, MemorySegment src) {
        float[] d = this.data;
        MemorySegment seg = src;
        FloatVector.fromMemorySegment(COL_SPECIES, seg, offset, ByteOrder.nativeOrder()).intoArray(d, 0);
        return this;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        return dest;
    }
    public @Mutated FloatQuat load(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatQuat loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatQuat storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatQuat loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatQuat loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

    private static final VectorSpecies<Float> COL_SPECIES = FloatVector.SPECIES_128;
    private static final VectorMask<Float> MASK_0 = VectorMask.fromValues(COL_SPECIES, true, true, true, false);
    private static final VectorMask<Float> MASK_2 = VectorMask.fromValues(COL_SPECIES, false, true, false, true);
    private static final VectorMask<Float> MASK_3 = VectorMask.fromValues(COL_SPECIES, false, false, true, true);
    private static final VectorMask<Float> MASK_4 = VectorMask.fromValues(COL_SPECIES, true, false, false, true);
    private static final FloatVector VEC_1 = FloatVector.fromArray(COL_SPECIES, new float[]{0.0f, 0.0f, 0.0f, 1.0f}, 0);

}
