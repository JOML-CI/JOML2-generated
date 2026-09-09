package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatQuat} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatQuatImpl implements FloatQuat {

    public float x;
    public float y;
    public float z;
    public float w;
    static final FloatQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatQuatBbOpsUnsafe()
                    : new FloatQuatBbOpsApi();
    static final FloatQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatQuatRawOpsUnsafe()
                    : new FloatQuatRawOpsApi();

    public FloatQuatImpl() {
        w = 1;
    }


    /**
     * Invert this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat invert(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t3_inv = 1.0f / _t3;
        d.x = -(this.x * _t3_inv);
        d.y = -(this.y * _t3_inv);
        d.z = -(this.z * _t3_inv);
        d.w = this.w * _t3_inv;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t3_inv = 1.0f / _t3;
        d.x = -(this.x * _t3_inv);
        d.y = -(this.y * _t3_inv);
        d.z = -(this.z * _t3_inv);
        d.w = this.w * _t3_inv;
        return d;
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
        return invertProduct(other.x(), other.y(), other.z(), other.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t21 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z));
        float _t22 = Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y));
        float _t23 = Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x));
        float _t24 = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        d.x = -(_t21 * _t28_inv);
        d.y = -(_t23 * _t28_inv);
        d.z = -(_t22 * _t28_inv);
        d.w = _t24 * _t28_inv;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t21 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z));
        float _t22 = Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y));
        float _t23 = Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x));
        float _t24 = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        d.x = -(_t21 * _t28_inv);
        d.y = -(_t23 * _t28_inv);
        d.z = -(_t22 * _t28_inv);
        d.w = _t24 * _t28_inv;
        return d;
    }


    /**
     * Add {@code other} to this quaternion and store the result in {@code dest}.
     *
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat add(FloatQuatR other, @Mutated FloatQuat dest) {
        return add(other.x(), other.y(), other.z(), other.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        d.z = otherZ + this.z;
        d.w = otherW + this.w;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        d.z = otherZ + this.z;
        d.w = otherW + this.w;
        return d;
    }


    /**
     * Negate this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat negate(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        d.w = -this.w;
        return d;
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
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat sub(FloatQuatR other, @Mutated FloatQuat dest) {
        return sub(other.x(), other.y(), other.z(), other.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        d.z = this.z - otherZ;
        d.w = this.w - otherW;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        d.z = this.z - otherZ;
        d.w = this.w - otherW;
        return d;
    }


    /**
     * Set this quaternion to the given values.
     *
     * @param v the quaternion
     * @return this
     */
    public @Mutated FloatQuat set(FloatQuatR v) {
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
    @Mutated public FloatQuat set(float vX, float vY, float vZ, float vW) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.w = vW;
        return this;
    }


    /**
     * Convert this quaternion to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat toDouble(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = this.w;
        return d;
    }


    /**
     * Set this quaternion to the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion
     * @return this
     */
    public @Mutated FloatQuat makeFromDualQuat(FloatDualQuatR dq) {
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
    @Mutated public FloatQuat makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        this.x = dqRX;
        this.y = dqRY;
        this.z = dqRZ;
        this.w = dqRW;
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public FloatQuat makeFromMatrix(Float3x3R m) {
        float _t0 = m.m00() + m.m11();
        float _t1 = m.m21() - m.m12();
        float _t2 = Math.max(m.m11(), m.m22());
        float _t4 = m.m01() + m.m10();
        float _t6 = m.m02() + m.m20();
        float _t7 = m.m02() - m.m20();
        float _t8 = m.m12() + m.m21();
        float _t9 = m.m10() - m.m01();
        float _t10 = m.m22() + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (m.m00() - (m.m11() + m.m22()));
        float _t16 = 1.0f + (m.m11() - (m.m00() + m.m22()));
        float _t17 = 1.0f + (m.m22() - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            this.x = 0.5f * _t1 * _t18;
            this.y = 0.5f * _t7 * _t18;
            this.z = 0.5f * _t9 * _t18;
            this.w = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t2) {
                this.x = 0.5f * (float) Math.sqrt(_t15);
                this.y = 0.5f * _t4 * _t21;
                this.z = 0.5f * _t6 * _t21;
                this.w = 0.5f * _t1 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.x = 0.5f * _t4 * _t19;
                    this.y = 0.5f * (float) Math.sqrt(_t16);
                    this.z = 0.5f * _t8 * _t19;
                    this.w = 0.5f * _t7 * _t19;
                } else {
                    this.x = 0.5f * _t6 * _t20;
                    this.y = 0.5f * _t8 * _t20;
                    this.z = 0.5f * (float) Math.sqrt(_t17);
                    this.w = 0.5f * _t9 * _t20;
                }
            }
        }
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public FloatQuat makeFromMatrix(Float3x4R m) {
        float _t0 = m.m00() + m.m11();
        float _t1 = m.m21() - m.m12();
        float _t2 = Math.max(m.m11(), m.m22());
        float _t4 = m.m01() + m.m10();
        float _t6 = m.m02() + m.m20();
        float _t7 = m.m02() - m.m20();
        float _t8 = m.m12() + m.m21();
        float _t9 = m.m10() - m.m01();
        float _t10 = m.m22() + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (m.m00() - (m.m11() + m.m22()));
        float _t16 = 1.0f + (m.m11() - (m.m00() + m.m22()));
        float _t17 = 1.0f + (m.m22() - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            this.x = 0.5f * _t1 * _t18;
            this.y = 0.5f * _t7 * _t18;
            this.z = 0.5f * _t9 * _t18;
            this.w = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t2) {
                this.x = 0.5f * (float) Math.sqrt(_t15);
                this.y = 0.5f * _t4 * _t21;
                this.z = 0.5f * _t6 * _t21;
                this.w = 0.5f * _t1 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.x = 0.5f * _t4 * _t19;
                    this.y = 0.5f * (float) Math.sqrt(_t16);
                    this.z = 0.5f * _t8 * _t19;
                    this.w = 0.5f * _t7 * _t19;
                } else {
                    this.x = 0.5f * _t6 * _t20;
                    this.y = 0.5f * _t8 * _t20;
                    this.z = 0.5f * (float) Math.sqrt(_t17);
                    this.w = 0.5f * _t9 * _t20;
                }
            }
        }
        return this;
    }


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public FloatQuat makeFromMatrix(Float4x4R m) {
        float _t0 = m.m00() + m.m11();
        float _t1 = m.m21() - m.m12();
        float _t2 = Math.max(m.m11(), m.m22());
        float _t4 = m.m01() + m.m10();
        float _t6 = m.m02() + m.m20();
        float _t7 = m.m02() - m.m20();
        float _t8 = m.m12() + m.m21();
        float _t9 = m.m10() - m.m01();
        float _t10 = m.m22() + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (m.m00() - (m.m11() + m.m22()));
        float _t16 = 1.0f + (m.m11() - (m.m00() + m.m22()));
        float _t17 = 1.0f + (m.m22() - _t0);
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            this.x = 0.5f * _t1 * _t18;
            this.y = 0.5f * _t7 * _t18;
            this.z = 0.5f * _t9 * _t18;
            this.w = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (m.m00() > _t2) {
                this.x = 0.5f * (float) Math.sqrt(_t15);
                this.y = 0.5f * _t4 * _t21;
                this.z = 0.5f * _t6 * _t21;
                this.w = 0.5f * _t1 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.x = 0.5f * _t4 * _t19;
                    this.y = 0.5f * (float) Math.sqrt(_t16);
                    this.z = 0.5f * _t8 * _t19;
                    this.w = 0.5f * _t7 * _t19;
                } else {
                    this.x = 0.5f * _t6 * _t20;
                    this.y = 0.5f * _t8 * _t20;
                    this.z = 0.5f * (float) Math.sqrt(_t17);
                    this.w = 0.5f * _t9 * _t20;
                }
            }
        }
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
        FloatDualQuatImpl d = (FloatDualQuatImpl) dest;
        d.rX = this.x;
        d.rY = this.y;
        d.rZ = this.z;
        d.rW = this.w;
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
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
        DoubleDualQuatImpl d = (DoubleDualQuatImpl) dest;
        d.rX = this.x;
        d.rY = this.y;
        d.rZ = this.z;
        d.rW = this.w;
        d.dX = 0.0f;
        d.dY = 0.0f;
        d.dZ = 0.0f;
        d.dW = 0.0f;
        return d;
    }


    /**
     * Compute the matrix representation of this quaternion (which must have unit length) and store
     * the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4x4 toMatrix(@Mutated Float4x4 dest) {
        Float4x4Impl d = (Float4x4Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        d.m10 = 2.0f * Math.fma(this.x, this.y, _t1);
        d.m20 = 2.0f * Math.fma(this.x, this.z, -_t2);
        d.m30 = 0.0f;
        float _buf1 = 2.0f * Math.fma(this.x, this.y, -_t1);
        d.m11 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        d.m21 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        d.m31 = 0.0f;
        float _buf2 = 2.0f * Math.fma(this.x, this.z, _t2);
        d.m12 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.m22 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
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
        Double4x4Impl d = (Double4x4Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        d.m10 = 2.0f * Math.fma(this.x, this.y, _t1);
        d.m20 = 2.0f * Math.fma(this.x, this.z, -_t2);
        d.m30 = 0.0f;
        float _buf1 = 2.0f * Math.fma(this.x, this.y, -_t1);
        d.m11 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        d.m21 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        d.m31 = 0.0f;
        float _buf2 = 2.0f * Math.fma(this.x, this.z, _t2);
        d.m12 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.m22 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
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
    public Float3x3 toMatrix3x3(@Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, _t1);
        d.m20 = 2.0f * Math.fma(this.x, this.z, -_t2);
        float _buf2 = 2.0f * Math.fma(this.x, this.y, -_t1);
        d.m11 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        d.m21 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _buf3 = 2.0f * Math.fma(this.x, this.z, _t2);
        d.m12 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.m22 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m02 = _buf3;
        d.properties = 0;
        return d;
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
        Double3x3Impl d = (Double3x3Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, _t1);
        d.m20 = 2.0f * Math.fma(this.x, this.z, -_t2);
        float _buf2 = 2.0f * Math.fma(this.x, this.y, -_t1);
        d.m11 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        d.m21 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _buf3 = 2.0f * Math.fma(this.x, this.z, _t2);
        d.m12 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.m22 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.m00 = _buf0;
        d.m10 = _buf1;
        d.m01 = _buf2;
        d.m02 = _buf3;
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
    public Float3x4 toMatrix3x4(@Mutated Float3x4 dest) {
        Float3x4Impl d = (Float3x4Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, -_t1);
        float _buf2 = 2.0f * Math.fma(this.x, this.z, _t2);
        float _buf3 = 0.0f;
        d.m10 = 2.0f * Math.fma(this.x, this.y, _t1);
        d.m11 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        d.m12 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.m13 = 0.0f;
        d.m20 = 2.0f * Math.fma(this.x, this.z, -_t2);
        d.m21 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        d.m22 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.m23 = 0.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = Joml.BIT_ORTHOGONAL;
        return d;
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
        Double3x4Impl d = (Double3x4Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, -_t1);
        float _buf2 = 2.0f * Math.fma(this.x, this.z, _t2);
        float _buf3 = 0.0f;
        d.m10 = 2.0f * Math.fma(this.x, this.y, _t1);
        d.m11 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        d.m12 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.m13 = 0.0f;
        d.m20 = 2.0f * Math.fma(this.x, this.z, -_t2);
        d.m21 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        d.m22 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.m23 = 0.0f;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
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
        FloatQuatImpl d0 = (FloatQuatImpl) swing;
        FloatQuatImpl d1 = (FloatQuatImpl) twist;
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = this.w * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _d0buf0 = Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14));
        float _d0buf1 = Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12));
        float _d0buf2 = Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14));
        d0.w = Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11)));
        d0.x = _d0buf0;
        d0.y = _d0buf1;
        d0.z = _d0buf2;
        d1.x = _t12;
        d1.y = _t13;
        d1.z = _t14;
        d1.w = _t11;
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
        DoubleQuatImpl d0 = (DoubleQuatImpl) swing;
        DoubleQuatImpl d1 = (DoubleQuatImpl) twist;
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = this.w * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _d0buf0 = Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14));
        float _d0buf1 = Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12));
        float _d0buf2 = Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14));
        d0.w = Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11)));
        d0.x = _d0buf0;
        d0.y = _d0buf1;
        d0.z = _d0buf2;
        d1.x = _t12;
        d1.y = _t13;
        d1.z = _t14;
        d1.w = _t11;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = this.w * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _buf0 = Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14));
        float _buf1 = Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12));
        float _buf2 = Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14));
        d.w = Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11)));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = this.w * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        float _buf0 = Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14));
        float _buf1 = Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12));
        float _buf2 = Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14));
        d.w = Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11)));
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            d.x = axisX * _t6;
            d.y = axisY * _t6;
            d.z = axisZ * _t6;
            d.w = this.w * _t5;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 1.0f;
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            d.x = axisX * _t6;
            d.y = axisY * _t6;
            d.z = axisZ * _t6;
            d.w = this.w * _t5;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 1.0f;
        }
        return d;
    }


    /**
     * Set this quaternion to the identity.
     *
     * @return this
     */
    @Mutated public FloatQuat makeIdentity() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 1.0f;
        return this;
    }


    /**
     * Set all components of this quaternion to zero.
     *
     * @return this
     */
    @Mutated public FloatQuat makeZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 0.0f;
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
        return lerp(other.x(), other.y(), other.z(), other.w(), t, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = Math.fma(t, otherX - this.x, this.x);
        d.y = Math.fma(t, otherY - this.y, this.y);
        d.z = Math.fma(t, otherZ - this.z, this.z);
        d.w = Math.fma(t, otherW - this.w, this.w);
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        d.x = Math.fma(t, otherX - this.x, this.x);
        d.y = Math.fma(t, otherY - this.y, this.y);
        d.z = Math.fma(t, otherZ - this.z, this.z);
        d.w = Math.fma(t, otherW - this.w, this.w);
        return d;
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
        return nlerp(target.x(), target.y(), target.z(), target.w(), alpha, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t4 = Math.fma(alpha, targetW - this.w, this.w);
        float _t5 = Math.fma(alpha, targetZ - this.z, this.z);
        float _t6 = Math.fma(alpha, targetX - this.x, this.x);
        float _t7 = Math.fma(alpha, targetY - this.y, this.y);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            d.x = _t6 * _t12;
            d.y = _t7 * _t12;
            d.z = _t5 * _t12;
            d.w = _t4 * _t12;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t4 = Math.fma(alpha, targetW - this.w, this.w);
        float _t5 = Math.fma(alpha, targetZ - this.z, this.z);
        float _t6 = Math.fma(alpha, targetX - this.x, this.x);
        float _t7 = Math.fma(alpha, targetY - this.y, this.y);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            d.x = _t6 * _t12;
            d.y = _t7 * _t12;
            d.z = _t5 * _t12;
            d.w = _t4 * _t12;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        return nlerpShortest(target.x(), target.y(), target.z(), target.w(), alpha, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t8 = -Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
        float _t17, _t18, _t19, _t20;
        if (_t8 > 0.0f) {
            _t17 = Math.fma(alpha, -targetW - this.w, this.w);
            _t18 = Math.fma(alpha, -targetZ - this.z, this.z);
            _t19 = Math.fma(alpha, -targetX - this.x, this.x);
            _t20 = Math.fma(alpha, -targetY - this.y, this.y);
        } else {
            _t17 = Math.fma(alpha, targetW - this.w, this.w);
            _t18 = Math.fma(alpha, targetZ - this.z, this.z);
            _t19 = Math.fma(alpha, targetX - this.x, this.x);
            _t20 = Math.fma(alpha, targetY - this.y, this.y);
        }
        float _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            d.x = _t19 * _t25;
            d.y = _t20 * _t25;
            d.z = _t18 * _t25;
            d.w = _t17 * _t25;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t8 = -Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
        float _t17, _t18, _t19, _t20;
        if (_t8 > 0.0f) {
            _t17 = Math.fma(alpha, -targetW - this.w, this.w);
            _t18 = Math.fma(alpha, -targetZ - this.z, this.z);
            _t19 = Math.fma(alpha, -targetX - this.x, this.x);
            _t20 = Math.fma(alpha, -targetY - this.y, this.y);
        } else {
            _t17 = Math.fma(alpha, targetW - this.w, this.w);
            _t18 = Math.fma(alpha, targetZ - this.z, this.z);
            _t19 = Math.fma(alpha, targetX - this.x, this.x);
            _t20 = Math.fma(alpha, targetY - this.y, this.y);
        }
        float _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            d.x = _t19 * _t25;
            d.y = _t20 * _t25;
            d.z = _t18 * _t25;
            d.w = _t17 * _t25;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
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
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat slerp(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        return slerp(target.x(), target.y(), target.z(), target.w(), alpha, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6f) {
            d.x = Math.fma(this.x, _t13, targetX * _t11) * _t8_inv;
            d.y = Math.fma(this.y, _t13, targetY * _t11) * _t8_inv;
            d.z = Math.fma(this.z, _t13, targetZ * _t11) * _t8_inv;
            d.w = Math.fma(this.w, _t13, targetW * _t11) * _t8_inv;
        } else {
            d.x = Math.fma(alpha, targetX, this.x * _t0);
            d.y = Math.fma(alpha, targetY, this.y * _t0);
            d.z = Math.fma(alpha, targetZ, this.z * _t0);
            d.w = Math.fma(alpha, targetW, this.w * _t0);
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6f) {
            d.x = Math.fma(this.x, _t13, targetX * _t11) * _t8_inv;
            d.y = Math.fma(this.y, _t13, targetY * _t11) * _t8_inv;
            d.z = Math.fma(this.z, _t13, targetZ * _t11) * _t8_inv;
            d.w = Math.fma(this.w, _t13, targetW * _t11) * _t8_inv;
        } else {
            d.x = Math.fma(alpha, targetX, this.x * _t0);
            d.y = Math.fma(alpha, targetY, this.y * _t0);
            d.z = Math.fma(alpha, targetZ, this.z * _t0);
            d.w = Math.fma(alpha, targetW, this.w * _t0);
        }
        return d;
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
        return slerpShortest(target.x(), target.y(), target.z(), target.w(), alpha, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 1.0f - alpha;
        float _t12 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
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
            _t42 = Math.fma(this.w, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(this.z, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(this.x, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(this.y, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, this.w * _t0);
            _t43 = Math.fma(alpha, _t22, this.z * _t0);
            _t44 = Math.fma(alpha, _t23, this.x * _t0);
            _t45 = Math.fma(alpha, _t24, this.y * _t0);
        }
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        if (_t49 > 0.0f) {
            d.x = _t50 * _t44;
            d.y = _t50 * _t45;
            d.z = _t50 * _t43;
            d.w = _t50 * _t42;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 1.0f - alpha;
        float _t12 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
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
            _t42 = Math.fma(this.w, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(this.z, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(this.x, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(this.y, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, this.w * _t0);
            _t43 = Math.fma(alpha, _t22, this.z * _t0);
            _t44 = Math.fma(alpha, _t23, this.x * _t0);
            _t45 = Math.fma(alpha, _t24, this.y * _t0);
        }
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        if (_t49 > 0.0f) {
            d.x = _t50 * _t44;
            d.y = _t50 * _t45;
            d.z = _t50 * _t43;
            d.w = _t50 * _t42;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
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
    public FloatQuat squad(FloatQuatR control0, FloatQuatR control1, FloatQuatR target, float t, @Mutated FloatQuat dest) {
        return squad(control0.x(), control0.y(), control0.z(), control0.w(), control1.x(), control1.y(), control1.z(), control1.w(), target.x(), target.y(), target.z(), target.w(), t, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
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
            _t72 = Math.fma(this.w, _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(this.z, _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(this.x, _t46, targetX * _t42) * _t36_inv;
            _t78 = Math.fma(this.y, _t46, targetY * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, this.w * _t0);
            _t74 = Math.fma(t, targetZ, this.z * _t0);
            _t76 = Math.fma(t, targetX, this.x * _t0);
            _t78 = Math.fma(t, targetY, this.y * _t0);
        }
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
            d.x = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            d.y = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            d.z = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            d.w = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            d.x = Math.fma(_t14, _t76, _t13 * _t75);
            d.y = Math.fma(_t14, _t78, _t13 * _t77);
            d.z = Math.fma(_t14, _t74, _t13 * _t73);
            d.w = Math.fma(_t14, _t72, _t13 * _t71);
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
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
            _t72 = Math.fma(this.w, _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(this.z, _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(this.x, _t46, targetX * _t42) * _t36_inv;
            _t78 = Math.fma(this.y, _t46, targetY * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, this.w * _t0);
            _t74 = Math.fma(t, targetZ, this.z * _t0);
            _t76 = Math.fma(t, targetX, this.x * _t0);
            _t78 = Math.fma(t, targetY, this.y * _t0);
        }
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
            d.x = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            d.y = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            d.z = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            d.w = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            d.x = Math.fma(_t14, _t76, _t13 * _t75);
            d.y = Math.fma(_t14, _t78, _t13 * _t77);
            d.z = Math.fma(_t14, _t74, _t13 * _t73);
            d.w = Math.fma(_t14, _t72, _t13 * _t71);
        }
        return d;
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
        return mul(other.x(), other.y(), other.z(), other.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _buf0 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z));
        float _buf1 = Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x));
        float _buf2 = Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y));
        d.w = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _buf0 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z));
        float _buf1 = Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x));
        float _buf2 = Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y));
        d.w = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
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
     * @param other the other quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat preMul(FloatQuatR other, @Mutated FloatQuat dest) {
        return preMul(other.x(), other.y(), other.z(), other.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _buf0 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherY, this.z, -(otherZ * this.y));
        float _buf1 = Math.fma(otherY, this.w, otherZ * this.x) + Math.fma(otherW, this.y, -(otherX * this.z));
        float _buf2 = Math.fma(otherX, this.y, otherW * this.z) + Math.fma(otherZ, this.w, -(otherY * this.x));
        d.w = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _buf0 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherY, this.z, -(otherZ * this.y));
        float _buf1 = Math.fma(otherY, this.w, otherZ * this.x) + Math.fma(otherW, this.y, -(otherX * this.z));
        float _buf2 = Math.fma(otherX, this.y, otherW * this.z) + Math.fma(otherZ, this.w, -(otherY * this.x));
        d.w = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        return 2.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y))), this.w);
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
        float _t8 = -Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
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
        float _t13 = this.w - _t9;
        float _t14 = this.z - _t10;
        float _t15 = this.x - _t11;
        float _t16 = this.y - _t12;
        float _t17 = this.w + _t9;
        float _t18 = this.z + _t10;
        float _t19 = this.x + _t11;
        float _t20 = this.y + _t12;
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
        Float3Impl d = (Float3Impl) dest;
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            d.x = this.x * _t3;
            d.y = this.y * _t3;
            d.z = this.z * _t3;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            d.x = this.x * _t3;
            d.y = this.y * _t3;
            d.z = this.z * _t3;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
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
    public FloatQuat calculateW(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _buf0 = this.x;
        float _buf1 = this.y;
        float _buf2 = this.z;
        d.w = (float) Math.sqrt(Math.max(0.0f, Math.fma(-this.x, this.x, Math.fma(-this.y, this.y, Math.fma(-this.z, this.z, 1.0f)))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _buf0 = this.x;
        float _buf1 = this.y;
        float _buf2 = this.z;
        d.w = (float) Math.sqrt(Math.max(0.0f, Math.fma(-this.x, this.x, Math.fma(-this.y, this.y, Math.fma(-this.z, this.z, 1.0f)))));
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
    public FloatQuat conjugate(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        d.w = this.w;
        return d;
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
     * @param q the quaternion
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat conjugateBy(FloatQuatR q, @Mutated FloatQuat dest) {
        return conjugateBy(q.x(), q.y(), q.z(), q.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t1 = -qY;
        float _t21 = Math.fma(qX, this.y, qW * this.z) + Math.fma(qZ, this.w, -(qY * this.x));
        float _t22 = Math.fma(qY, this.w, qZ * this.x) + Math.fma(qW, this.y, -(qX * this.z));
        float _t23 = Math.fma(qX, this.w, qW * this.x) + Math.fma(qY, this.z, -(qZ * this.y));
        float _t24 = Math.fma(-qZ, this.z, Math.fma(_t1, this.y, Math.fma(qW, this.w, -(qX * this.x))));
        d.x = Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24));
        d.y = Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21));
        d.z = Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24));
        d.w = Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24)));
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t1 = -qY;
        float _t21 = Math.fma(qX, this.y, qW * this.z) + Math.fma(qZ, this.w, -(qY * this.x));
        float _t22 = Math.fma(qY, this.w, qZ * this.x) + Math.fma(qW, this.y, -(qX * this.z));
        float _t23 = Math.fma(qX, this.w, qW * this.x) + Math.fma(qY, this.z, -(qZ * this.y));
        float _t24 = Math.fma(-qZ, this.z, Math.fma(_t1, this.y, Math.fma(qW, this.w, -(qX * this.x))));
        d.x = Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24));
        d.y = Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21));
        d.z = Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24));
        d.w = Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24)));
        return d;
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
        return difference(other.x(), other.y(), other.z(), other.w(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t3_inv = 1.0f / _t3;
        float _buf0 = (Math.fma(otherX, this.w, -(otherW * this.x)) + Math.fma(otherY, this.z, -(otherZ * this.y))) * _t3_inv;
        float _buf1 = -(otherW * this.y * _t3_inv) - otherX * this.z * _t3_inv + Math.fma(otherY, this.w, otherZ * this.x) * _t3_inv;
        float _buf2 = (Math.fma(otherX, this.y, -(otherW * this.z)) + Math.fma(otherZ, this.w, -(otherY * this.x))) * _t3_inv;
        d.w = Math.fma(otherZ, this.z, Math.fma(otherY, this.y, Math.fma(otherX, this.x, otherW * this.w))) * _t3_inv;
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t3_inv = 1.0f / _t3;
        float _buf0 = (Math.fma(otherX, this.w, -(otherW * this.x)) + Math.fma(otherY, this.z, -(otherZ * this.y))) * _t3_inv;
        float _buf1 = -(otherW * this.y * _t3_inv) - otherX * this.z * _t3_inv + Math.fma(otherY, this.w, otherZ * this.x) * _t3_inv;
        float _buf2 = (Math.fma(otherX, this.y, -(otherW * this.z)) + Math.fma(otherZ, this.w, -(otherY * this.x))) * _t3_inv;
        d.w = Math.fma(otherZ, this.z, Math.fma(otherY, this.y, Math.fma(otherX, this.x, otherW * this.w))) * _t3_inv;
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        return Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
    }


    /**
     * Compute the exponential of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat exp(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = (float) Math.exp(this.w);
        float _t3 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t4 = (float) Math.sqrt(_t3);
        float _t8 = (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            d.x = this.x * _t8;
            d.y = this.y * _t8;
            d.z = this.z * _t8;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t4) * _t0;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = (float) Math.exp(this.w);
        float _t3 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t4 = (float) Math.sqrt(_t3);
        float _t8 = (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            d.x = this.x * _t8;
            d.y = this.y * _t8;
            d.z = this.z * _t8;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t4) * _t0;
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t1 = this.y * this.z;
        float _t3 = this.z * this.z;
        float _t8 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t9 = 2.0f * Math.fma(this.x, this.w, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, _t1), Math.fma(-2.0f, Math.fma(this.x, this.x, _t3), 1.0f));
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t9, _t10);
            d.z = (float) Math.atan2(2.0f * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0f, Math.fma(this.y, this.y, _t3), 1.0f));
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(_t8, (float) Math.sqrt(_t12));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t1 = this.y * this.z;
        float _t3 = this.z * this.z;
        float _t8 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t9 = 2.0f * Math.fma(this.x, this.w, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, _t1), Math.fma(-2.0f, Math.fma(this.x, this.x, _t3), 1.0f));
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t9, _t10);
            d.z = (float) Math.atan2(2.0f * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0f, Math.fma(this.y, this.y, _t3), 1.0f));
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(_t8, (float) Math.sqrt(_t12));
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.y * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.w, _t1);
        float _t8 = 2.0f * Math.fma(this.z, this.w, -(this.x * this.y));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, -_t1), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.y = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t7, _t9);
            d.y = (float) Math.atan2(2.0f * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f));
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.z * this.z;
        float _t1 = this.y * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.w, _t1);
        float _t8 = 2.0f * Math.fma(this.z, this.w, -(this.x * this.y));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, -_t1), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.y = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t7, _t9);
            d.y = (float) Math.atan2(2.0f * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f));
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t3 = this.z * this.z;
        float _t8 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t9 = 2.0f * Math.fma(this.x, this.w, -(this.y * this.z));
        float _t10 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0f, Math.fma(this.y, this.y, _t3), 1.0f));
            d.z = 0.0f;
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t8, _t10);
            d.z = (float) Math.atan2(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, _t3), 1.0f));
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(_t9, (float) Math.sqrt(_t12));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t3 = this.z * this.z;
        float _t8 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t9 = 2.0f * Math.fma(this.x, this.w, -(this.y * this.z));
        float _t10 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0f, Math.fma(this.y, this.y, _t3), 1.0f));
            d.z = 0.0f;
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t8, _t10);
            d.z = (float) Math.atan2(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, _t3), 1.0f));
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(_t9, (float) Math.sqrt(_t12));
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.w, -(this.x * this.z));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            d.y = (float) Math.atan2(2.0f * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, -(this.y * this.z)), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f));
            d.y = (float) Math.atan2(_t8, _t9);
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.w, -(this.x * this.z));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            d.y = (float) Math.atan2(2.0f * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, -(this.y * this.z)), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f));
            d.y = (float) Math.atan2(_t8, _t9);
            d.x = _buf0;
        }
        d.z = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t1 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.z, this.w, -(this.x * this.y));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.y, this.y, _t1), 1.0f));
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.z = (float) Math.atan2(_t8, _t9);
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t1 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.z, this.w, -(this.x * this.y));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.y, this.y, _t1), 1.0f));
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.z = (float) Math.atan2(_t8, _t9);
            d.y = _buf0;
        }
        d.x = (float) Math.atan2(_t7, (float) Math.sqrt(_t11));
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.w, -(this.x * this.z));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(2.0f * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f));
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.z = (float) Math.atan2(_t7, _t9);
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.w, -(this.x * this.z));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            float _buf0 = 0.0f;
            d.z = (float) Math.atan2(2.0f * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f));
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
            d.z = (float) Math.atan2(_t7, _t9);
            d.x = _buf0;
        }
        d.y = (float) Math.atan2(_t8, (float) Math.sqrt(_t11));
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
    public FloatQuat integrate(Float3R angularVel, float dt, @Mutated FloatQuat dest) {
        return integrate(angularVel.x(), angularVel.y(), angularVel.z(), dt, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t9, this.w * _t15) + Math.fma(this.z, _t16, -(this.y * _t17));
        float _buf1 = Math.fma(this.x, _t17, this.w * _t16) + Math.fma(this.y, _t9, -(this.z * _t15));
        float _buf2 = Math.fma(this.y, _t15, this.z * _t9) + Math.fma(this.w, _t17, -(this.x * _t16));
        d.w = Math.fma(-this.z, _t17, Math.fma(-this.y, _t16, Math.fma(this.w, _t9, -(this.x * _t15))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t9, this.w * _t15) + Math.fma(this.z, _t16, -(this.y * _t17));
        float _buf1 = Math.fma(this.x, _t17, this.w * _t16) + Math.fma(this.y, _t9, -(this.z * _t15));
        float _buf2 = Math.fma(this.y, _t15, this.z * _t9) + Math.fma(this.w, _t17, -(this.x * _t16));
        d.w = Math.fma(-this.z, _t17, Math.fma(-this.y, _t16, Math.fma(this.w, _t9, -(this.x * _t15))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t12 * _t16);
            d.y = -(_t10 * _t16);
            d.z = -(_t9 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t12 * _t16);
            d.y = -(_t10 * _t16);
            d.z = -(_t9 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t9 * _t16);
            d.y = -(_t12 * _t16);
            d.z = -(_t10 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t9 * _t16);
            d.y = -(_t12 * _t16);
            d.z = -(_t10 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t10 * _t16);
            d.y = -(_t9 * _t16);
            d.z = -(_t12 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t10 * _t16);
            d.y = -(_t9 * _t16);
            d.z = -(_t12 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
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
    public Float3 invNormalizedNegativeX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = Math.fma(2.0f, Math.fma(this.y, this.y, this.z * this.z), -1.0f);
        float _buf1 = -(2.0f * Math.fma(this.x, this.y, -(this.z * this.w)));
        d.z = -(2.0f * Math.fma(this.x, this.z, this.y * this.w));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = Math.fma(2.0f, Math.fma(this.y, this.y, this.z * this.z), -1.0f);
        float _buf1 = -(2.0f * Math.fma(this.x, this.y, -(this.z * this.w)));
        d.z = -(2.0f * Math.fma(this.x, this.z, this.y * this.w));
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
    public Float3 invNormalizedNegativeY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.y, this.z * this.w));
        float _buf1 = Math.fma(2.0f, Math.fma(this.x, this.x, this.z * this.z), -1.0f);
        d.z = -(2.0f * Math.fma(this.y, this.z, -(this.x * this.w)));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.y, this.z * this.w));
        float _buf1 = Math.fma(2.0f, Math.fma(this.x, this.x, this.z * this.z), -1.0f);
        d.z = -(2.0f * Math.fma(this.y, this.z, -(this.x * this.w)));
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
    public Float3 invNormalizedNegativeZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.z, -(this.y * this.w)));
        float _buf1 = -(2.0f * Math.fma(this.x, this.w, this.y * this.z));
        d.z = Math.fma(2.0f, Math.fma(this.x, this.x, this.y * this.y), -1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedNegativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.z, -(this.y * this.w)));
        float _buf1 = -(2.0f * Math.fma(this.x, this.w, this.y * this.z));
        d.z = Math.fma(2.0f, Math.fma(this.x, this.x, this.y * this.y), -1.0f);
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
    public Float3 invNormalizedPositiveX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        d.z = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        d.z = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
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
    public Float3 invNormalizedPositiveY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _buf1 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        d.z = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _buf1 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        d.z = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
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
    public Float3 invNormalizedPositiveZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _buf1 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        d.z = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNormalizedPositiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _buf1 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        d.z = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t12 * _t16;
            d.y = _t10 * _t16;
            d.z = _t9 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t12 * _t16;
            d.y = _t10 * _t16;
            d.z = _t9 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t9 * _t16;
            d.y = _t12 * _t16;
            d.z = _t10 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t9 * _t16;
            d.y = _t12 * _t16;
            d.z = _t10 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t10 * _t16;
            d.y = _t9 * _t16;
            d.z = _t12 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t10 * _t16;
            d.y = _t9 * _t16;
            d.z = _t12 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        return (float) Math.sqrt(Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y))));
    }


    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    public float lengthSquared() {
        return Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t6 = (float) Math.atan2((float) Math.sqrt(_t2), this.w) * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            d.x = this.x * _t6;
            d.y = this.y * _t6;
            d.z = this.z * _t6;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.log((float) Math.sqrt(Math.fma(this.w, this.w, _t2)));
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t6 = (float) Math.atan2((float) Math.sqrt(_t2), this.w) * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            d.x = this.x * _t6;
            d.y = this.y * _t6;
            d.z = this.z * _t6;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.log((float) Math.sqrt(Math.fma(this.w, this.w, _t2)));
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t12 * _t16);
            d.y = -(_t9 * _t16);
            d.z = -(_t10 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t12 * _t16);
            d.y = -(_t9 * _t16);
            d.z = -(_t10 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t10 * _t16);
            d.y = -(_t12 * _t16);
            d.z = -(_t9 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t10 * _t16);
            d.y = -(_t12 * _t16);
            d.z = -(_t9 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t9 * _t16);
            d.y = -(_t10 * _t16);
            d.z = -(_t12 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = -(_t9 * _t16);
            d.y = -(_t10 * _t16);
            d.z = -(_t12 * _t16);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            d.x = this.x * _t4;
            d.y = this.y * _t4;
            d.z = this.z * _t4;
            d.w = this.w * _t4;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            d.x = this.x * _t4;
            d.y = this.y * _t4;
            d.z = this.z * _t4;
            d.w = this.w * _t4;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
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
    public Float3 normalizedNegativeX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = Math.fma(2.0f, Math.fma(this.y, this.y, this.z * this.z), -1.0f);
        float _buf1 = -(2.0f * Math.fma(this.x, this.y, this.z * this.w));
        d.z = -(2.0f * Math.fma(this.x, this.z, -(this.y * this.w)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = Math.fma(2.0f, Math.fma(this.y, this.y, this.z * this.z), -1.0f);
        float _buf1 = -(2.0f * Math.fma(this.x, this.y, this.z * this.w));
        d.z = -(2.0f * Math.fma(this.x, this.z, -(this.y * this.w)));
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
    public Float3 normalizedNegativeY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.y, -(this.z * this.w)));
        float _buf1 = Math.fma(2.0f, Math.fma(this.x, this.x, this.z * this.z), -1.0f);
        d.z = -(2.0f * Math.fma(this.x, this.w, this.y * this.z));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.y, -(this.z * this.w)));
        float _buf1 = Math.fma(2.0f, Math.fma(this.x, this.x, this.z * this.z), -1.0f);
        d.z = -(2.0f * Math.fma(this.x, this.w, this.y * this.z));
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
    public Float3 normalizedNegativeZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.z, this.y * this.w));
        float _buf1 = -(2.0f * Math.fma(this.y, this.z, -(this.x * this.w)));
        d.z = Math.fma(2.0f, Math.fma(this.x, this.x, this.y * this.y), -1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedNegativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = -(2.0f * Math.fma(this.x, this.z, this.y * this.w));
        float _buf1 = -(2.0f * Math.fma(this.y, this.z, -(this.x * this.w)));
        d.z = Math.fma(2.0f, Math.fma(this.x, this.x, this.y * this.y), -1.0f);
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
    public Float3 normalizedPositiveX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        d.z = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _buf1 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        d.z = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
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
    public Float3 normalizedPositiveY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _buf1 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        d.z = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _buf1 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        d.z = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
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
    public Float3 normalizedPositiveZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _buf1 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.z = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizedPositiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _buf1 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        d.z = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t12 * _t16;
            d.y = _t9 * _t16;
            d.z = _t10 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t10 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t12 * _t16;
            d.y = _t9 * _t16;
            d.z = _t10 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t10 * _t16;
            d.y = _t12 * _t16;
            d.z = _t9 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t10 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t10 * _t16;
            d.y = _t12 * _t16;
            d.z = _t9 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t9 * _t16;
            d.y = _t10 * _t16;
            d.z = _t12 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t10 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            d.x = _t9 * _t16;
            d.y = _t10 * _t16;
            d.z = _t12 * _t16;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t10 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(Math.fma(this.w, this.w, _t2))));
        float _t11 = (float) Math.atan2((float) Math.sqrt(_t2), this.w) * (1.0f / (float) Math.sqrt(_t2));
        float _t18, _t19, _t20;
        if (_t2 > 0.0f) {
            _t18 = t * this.z * _t11;
            _t19 = t * this.x * _t11;
            _t20 = t * this.y * _t11;
        } else {
            _t18 = t * 0.0f;
            _t19 = t * 0.0f;
            _t20 = t * 0.0f;
        }
        float _t23 = Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20));
        float _t24 = (float) Math.sqrt(_t23);
        float _t28 = (float) Math.sin(_t24) * _t10 * (1.0f / (float) Math.sqrt(_t23));
        if (_t23 > 0.0f) {
            d.x = _t19 * _t28;
            d.y = _t20 * _t28;
            d.z = _t18 * _t28;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t24) * _t10;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t10 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(Math.fma(this.w, this.w, _t2))));
        float _t11 = (float) Math.atan2((float) Math.sqrt(_t2), this.w) * (1.0f / (float) Math.sqrt(_t2));
        float _t18, _t19, _t20;
        if (_t2 > 0.0f) {
            _t18 = t * this.z * _t11;
            _t19 = t * this.x * _t11;
            _t20 = t * this.y * _t11;
        } else {
            _t18 = t * 0.0f;
            _t19 = t * 0.0f;
            _t20 = t * 0.0f;
        }
        float _t23 = Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20));
        float _t24 = (float) Math.sqrt(_t23);
        float _t28 = (float) Math.sin(_t24) * _t10 * (1.0f / (float) Math.sqrt(_t23));
        if (_t23 > 0.0f) {
            d.x = _t19 * _t28;
            d.y = _t20 * _t28;
            d.z = _t18 * _t28;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t24) * _t10;
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
        return rotateTowards(target.x(), target.y(), target.z(), target.w(), step, dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t7 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
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
        float _t17 = this.w - _t13;
        float _t18 = this.z - _t14;
        float _t19 = this.x - _t15;
        float _t20 = this.y - _t16;
        float _t21 = this.w + _t13;
        float _t22 = this.z + _t14;
        float _t23 = this.x + _t15;
        float _t24 = this.y + _t16;
        float _t36 = 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))), (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24)))));
        float _t39 = _t36 > 0.0f ? Math.min(1.0f, step / _t36) : 0.0f;
        float _t40 = 1.0f - _t39;
        float _t42 = (float) Math.sin(_t11 * _t39);
        float _t44 = (float) Math.sin(_t40 * _t11);
        float _t65, _t66, _t67, _t68;
        if (_t12 > 0.0f) {
            _t65 = Math.fma(this.w, _t44, _t42 * _t13) * _t12_inv;
            _t66 = Math.fma(this.z, _t44, _t42 * _t14) * _t12_inv;
            _t67 = Math.fma(this.x, _t44, _t42 * _t15) * _t12_inv;
            _t68 = Math.fma(this.y, _t44, _t42 * _t16) * _t12_inv;
        } else {
            _t65 = Math.fma(this.w, _t40, _t13 * _t39);
            _t66 = Math.fma(this.z, _t40, _t14 * _t39);
            _t67 = Math.fma(this.x, _t40, _t15 * _t39);
            _t68 = Math.fma(this.y, _t40, _t16 * _t39);
        }
        float _t72 = Math.fma(_t65, _t65, Math.fma(_t66, _t66, Math.fma(_t67, _t67, _t68 * _t68)));
        float _t73 = (1.0f / (float) Math.sqrt(_t72));
        if (_t72 > 0.0f) {
            d.x = _t73 * _t67;
            d.y = _t73 * _t68;
            d.z = _t73 * _t66;
            d.w = _t73 * _t65;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t7 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
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
        float _t17 = this.w - _t13;
        float _t18 = this.z - _t14;
        float _t19 = this.x - _t15;
        float _t20 = this.y - _t16;
        float _t21 = this.w + _t13;
        float _t22 = this.z + _t14;
        float _t23 = this.x + _t15;
        float _t24 = this.y + _t16;
        float _t36 = 4.0f * (float) Math.atan2((float) Math.sqrt(Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)))), (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t24 * _t24)))));
        float _t39 = _t36 > 0.0f ? Math.min(1.0f, step / _t36) : 0.0f;
        float _t40 = 1.0f - _t39;
        float _t42 = (float) Math.sin(_t11 * _t39);
        float _t44 = (float) Math.sin(_t40 * _t11);
        float _t65, _t66, _t67, _t68;
        if (_t12 > 0.0f) {
            _t65 = Math.fma(this.w, _t44, _t42 * _t13) * _t12_inv;
            _t66 = Math.fma(this.z, _t44, _t42 * _t14) * _t12_inv;
            _t67 = Math.fma(this.x, _t44, _t42 * _t15) * _t12_inv;
            _t68 = Math.fma(this.y, _t44, _t42 * _t16) * _t12_inv;
        } else {
            _t65 = Math.fma(this.w, _t40, _t13 * _t39);
            _t66 = Math.fma(this.z, _t40, _t14 * _t39);
            _t67 = Math.fma(this.x, _t40, _t15 * _t39);
            _t68 = Math.fma(this.y, _t40, _t16 * _t39);
        }
        float _t72 = Math.fma(_t65, _t65, Math.fma(_t66, _t66, Math.fma(_t67, _t67, _t68 * _t68)));
        float _t73 = (1.0f / (float) Math.sqrt(_t72));
        if (_t72 > 0.0f) {
            d.x = _t73 * _t67;
            d.y = _t73 * _t68;
            d.z = _t73 * _t66;
            d.w = _t73 * _t65;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
            d.w = 0.0f;
        }
        return d;
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
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t110, this.w * _t111) + Math.fma(this.y, _t108, -(this.z * _t109));
        float _buf1 = Math.fma(this.y, _t110, this.z * _t111) + Math.fma(this.w, _t109, -(this.x * _t108));
        float _buf2 = Math.fma(this.x, _t109, this.w * _t108) + Math.fma(this.z, _t110, -(this.y * _t111));
        d.w = Math.fma(-this.z, _t108, Math.fma(-this.y, _t109, Math.fma(this.w, _t110, -(this.x * _t111))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t110, this.w * _t111) + Math.fma(this.y, _t108, -(this.z * _t109));
        float _buf1 = Math.fma(this.y, _t110, this.z * _t111) + Math.fma(this.w, _t109, -(this.x * _t108));
        float _buf2 = Math.fma(this.x, _t109, this.w * _t108) + Math.fma(this.z, _t110, -(this.y * _t111));
        d.w = Math.fma(-this.z, _t108, Math.fma(-this.y, _t109, Math.fma(this.w, _t110, -(this.x * _t111))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return this
     */
    public @Mutated FloatQuat makeRotationAxis(float angle, Float3R axis) {
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
    @Mutated public FloatQuat makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        this.x = axisX * _t1;
        this.y = axisY * _t1;
        this.z = axisZ * _t1;
        this.w = (float) Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated FloatQuat makeRotationLookAlong(Float3R dir, Float3R up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
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
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t56 = Math.max(_t49, _t7);
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t64 = (1.0f / (float) Math.sqrt(_t60));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        if (_t59 > 0.0f) {
            this.x = 0.5f * _t55 * _t64;
            this.y = 0.5f * _t38 * _t64;
            this.z = 0.5f * _t58 * _t64;
            this.w = 0.5f * (float) Math.sqrt(_t60);
        } else {
            if (_t31 > _t56) {
                this.x = 0.5f * (float) Math.sqrt(_t61);
                this.y = 0.5f * _t57 * _t67;
                this.z = 0.5f * _t37 * _t67;
                this.w = 0.5f * _t55 * _t67;
            } else {
                if (_t49 > _t7) {
                    this.x = 0.5f * _t57 * _t65;
                    this.y = 0.5f * (float) Math.sqrt(_t62);
                    this.z = 0.5f * _t54 * _t65;
                    this.w = 0.5f * _t38 * _t65;
                } else {
                    this.x = 0.5f * _t37 * _t66;
                    this.y = 0.5f * _t54 * _t66;
                    this.z = 0.5f * (float) Math.sqrt(_t63);
                    this.w = 0.5f * _t58 * _t66;
                }
            }
        }
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
    public @Mutated FloatQuat makeRotationTo(Float3R fromDir, Float3R toDir) {
        return makeRotationTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
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
        float _t33 = (1.0f / (float) Math.sqrt(Math.fma(_t15, _t15, Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t22 * _t22 / (2.0f * 2.0f))))));
        if (_t23 > 1.0E-6f) {
            this.x = _t15 * _t33;
            this.y = _t16 * _t33;
            this.z = _t17 * _t33;
            this.w = 0.5f * _t22 * _t33;
        } else {
            if (_t29 > 0.0f) {
                this.x = _t30 * _t18;
                this.y = _t30 * _t20;
                this.z = _t30 * _t19;
                this.w = 0.0f;
            } else {
                this.x = 0.0f;
                this.y = 0.0f;
                this.z = 0.0f;
                this.w = 0.0f;
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
    @Mutated public FloatQuat makeRotationX(float angle) {
        float _t0 = 0.5f * angle;
        this.x = (float) Math.sin(_t0);
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = (float) Math.cos(_t0);
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
        this.x = Math.fma(_t9, _t5, _t10 * _t8);
        this.y = Math.fma(_t10, _t5, -(_t9 * _t8));
        this.z = Math.fma(_t11, _t5, _t12 * _t8);
        this.w = Math.fma(_t12, _t5, -(_t11 * _t8));
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
        this.x = Math.fma(_t9, _t5, -(_t10 * _t8));
        this.y = Math.fma(_t11, _t8, -(_t12 * _t5));
        this.z = Math.fma(_t9, _t8, _t10 * _t5);
        this.w = Math.fma(_t12, _t8, _t11 * _t5);
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public FloatQuat makeRotationY(float angle) {
        float _t0 = 0.5f * angle;
        this.x = 0.0f;
        this.y = (float) Math.sin(_t0);
        this.z = 0.0f;
        this.w = (float) Math.cos(_t0);
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
        this.x = Math.fma(_t9, _t5, _t10 * _t8);
        this.y = Math.fma(_t10, _t5, -(_t9 * _t8));
        this.z = Math.fma(_t11, _t8, -(_t12 * _t5));
        this.w = Math.fma(_t12, _t8, _t11 * _t5);
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
        this.x = Math.fma(_t9, _t5, _t10 * _t8);
        this.y = Math.fma(_t11, _t5, _t12 * _t8);
        this.z = Math.fma(_t12, _t5, -(_t11 * _t8));
        this.w = Math.fma(_t10, _t5, -(_t9 * _t8));
        return this;
    }


    /**
     * Set this quaternion to a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return this
     */
    @Mutated public FloatQuat makeRotationZ(float angle) {
        float _t0 = 0.5f * angle;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = (float) Math.sin(_t0);
        this.w = (float) Math.cos(_t0);
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
        this.x = Math.fma(_t9, _t5, -(_t10 * _t8));
        this.y = Math.fma(_t11, _t5, _t12 * _t8);
        this.z = Math.fma(_t9, _t8, _t10 * _t5);
        this.w = Math.fma(_t12, _t5, -(_t11 * _t8));
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
        this.x = Math.fma(_t9, _t5, -(_t10 * _t8));
        this.y = Math.fma(_t11, _t8, _t12 * _t5);
        this.z = Math.fma(_t12, _t8, -(_t11 * _t5));
        this.w = Math.fma(_t10, _t5, _t9 * _t8);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.w * _t2);
        float _buf1 = Math.fma(this.y, _t1, -(this.z * _t2));
        d.z = Math.fma(this.y, _t2, this.z * _t1);
        d.w = Math.fma(this.w, _t1, -(this.x * _t2));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.w * _t2);
        float _buf1 = Math.fma(this.y, _t1, -(this.z * _t2));
        d.z = Math.fma(this.y, _t2, this.z * _t1);
        d.w = Math.fma(this.w, _t1, -(this.x * _t2));
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
    public FloatQuat preRotateY(float angle, @Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.z * _t2);
        float _buf1 = Math.fma(this.y, _t1, this.w * _t2);
        d.z = Math.fma(this.z, _t1, -(this.x * _t2));
        d.w = Math.fma(this.w, _t1, -(this.y * _t2));
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat preRotateY(float angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.z * _t2);
        float _buf1 = Math.fma(this.y, _t1, this.w * _t2);
        d.z = Math.fma(this.z, _t1, -(this.x * _t2));
        d.w = Math.fma(this.w, _t1, -(this.y * _t2));
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
    public FloatQuat preRotateZ(float angle, @Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, -(this.y * _t2));
        d.y = Math.fma(this.x, _t2, this.y * _t1);
        float _buf1 = Math.fma(this.z, _t1, this.w * _t2);
        d.w = Math.fma(this.w, _t1, -(this.z * _t2));
        d.x = _buf0;
        d.z = _buf1;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, -(this.y * _t2));
        d.y = Math.fma(this.x, _t2, this.y * _t1);
        float _buf1 = Math.fma(this.z, _t1, this.w * _t2);
        d.w = Math.fma(this.w, _t1, -(this.z * _t2));
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
    public FloatQuat rotateAxis(float angle, Float3R axis, @Mutated FloatQuat dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        float _buf0 = Math.fma(this.x, _t1, this.w * _t3) + Math.fma(this.y, _t4, -(this.z * _t5));
        float _buf1 = Math.fma(this.y, _t1, this.z * _t3) + Math.fma(this.w, _t5, -(this.x * _t4));
        float _buf2 = Math.fma(this.x, _t5, this.w * _t4) + Math.fma(this.z, _t1, -(this.y * _t3));
        d.w = Math.fma(-this.z, _t4, Math.fma(-this.y, _t5, Math.fma(this.w, _t1, -(this.x * _t3))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        float _buf0 = Math.fma(this.x, _t1, this.w * _t3) + Math.fma(this.y, _t4, -(this.z * _t5));
        float _buf1 = Math.fma(this.y, _t1, this.z * _t3) + Math.fma(this.w, _t5, -(this.x * _t4));
        float _buf2 = Math.fma(this.x, _t5, this.w * _t4) + Math.fma(this.z, _t1, -(this.y * _t3));
        d.w = Math.fma(-this.z, _t4, Math.fma(-this.y, _t5, Math.fma(this.w, _t1, -(this.x * _t3))));
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
        return rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z(), dest);
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t42, this.w * _t46) + Math.fma(this.y, _t47, -(this.z * _t48));
        float _buf1 = Math.fma(this.y, _t42, this.z * _t46) + Math.fma(this.w, _t48, -(this.x * _t47));
        float _buf2 = Math.fma(this.x, _t48, this.w * _t47) + Math.fma(this.z, _t42, -(this.y * _t46));
        d.w = Math.fma(-this.z, _t47, Math.fma(-this.y, _t48, Math.fma(this.w, _t42, -(this.x * _t46))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t42, this.w * _t46) + Math.fma(this.y, _t47, -(this.z * _t48));
        float _buf1 = Math.fma(this.y, _t42, this.z * _t46) + Math.fma(this.w, _t48, -(this.x * _t47));
        float _buf2 = Math.fma(this.x, _t48, this.w * _t47) + Math.fma(this.z, _t42, -(this.y * _t46));
        d.w = Math.fma(-this.z, _t47, Math.fma(-this.y, _t48, Math.fma(this.w, _t42, -(this.x * _t46))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
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
    public FloatQuat rotateX(float angle, @Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.w * _t2);
        float _buf1 = Math.fma(this.y, _t1, this.z * _t2);
        d.z = Math.fma(this.z, _t1, -(this.y * _t2));
        d.w = Math.fma(this.w, _t1, -(this.x * _t2));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.w * _t2);
        float _buf1 = Math.fma(this.y, _t1, this.z * _t2);
        d.z = Math.fma(this.z, _t1, -(this.y * _t2));
        d.w = Math.fma(this.w, _t1, -(this.x * _t2));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t20, -(this.z * _t22));
        float _buf1 = Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t22, -(this.x * _t20));
        float _buf2 = Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t21, -(this.y * _t19));
        d.w = Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t21, -(this.x * _t19))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t20, -(this.z * _t22));
        float _buf1 = Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t22, -(this.x * _t20));
        float _buf2 = Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t21, -(this.y * _t19));
        d.w = Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t21, -(this.x * _t19))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t20, -(this.z * _t22));
        float _buf1 = Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t22, -(this.x * _t20));
        float _buf2 = Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t19, -(this.y * _t21));
        d.w = Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t21))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t20, -(this.z * _t22));
        float _buf1 = Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t22, -(this.x * _t20));
        float _buf2 = Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t19, -(this.y * _t21));
        d.w = Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t21))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
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
    public FloatQuat rotateY(float angle, @Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, -(this.z * _t2));
        float _buf1 = Math.fma(this.y, _t1, this.w * _t2);
        d.z = Math.fma(this.x, _t2, this.z * _t1);
        d.w = Math.fma(this.w, _t1, -(this.y * _t2));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, -(this.z * _t2));
        float _buf1 = Math.fma(this.y, _t1, this.w * _t2);
        d.z = Math.fma(this.x, _t2, this.z * _t1);
        d.w = Math.fma(this.w, _t1, -(this.y * _t2));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t19, this.w * _t20) + Math.fma(this.y, _t21, -(this.z * _t22));
        float _buf1 = Math.fma(this.y, _t19, this.z * _t20) + Math.fma(this.w, _t22, -(this.x * _t21));
        float _buf2 = Math.fma(this.x, _t22, this.w * _t21) + Math.fma(this.z, _t19, -(this.y * _t20));
        d.w = Math.fma(-this.z, _t21, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t20))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t19, this.w * _t20) + Math.fma(this.y, _t21, -(this.z * _t22));
        float _buf1 = Math.fma(this.y, _t19, this.z * _t20) + Math.fma(this.w, _t22, -(this.x * _t21));
        float _buf2 = Math.fma(this.x, _t22, this.w * _t21) + Math.fma(this.z, _t19, -(this.y * _t20));
        d.w = Math.fma(-this.z, _t21, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t20))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t22, -(this.z * _t20));
        float _buf1 = Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t20, -(this.x * _t22));
        float _buf2 = Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t21, -(this.y * _t19));
        d.w = Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t19))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t22, -(this.z * _t20));
        float _buf1 = Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t20, -(this.x * _t22));
        float _buf2 = Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t21, -(this.y * _t19));
        d.w = Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t19))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
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
    public FloatQuat rotateZ(float angle, @Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.y * _t2);
        d.y = Math.fma(this.y, _t1, -(this.x * _t2));
        float _buf1 = Math.fma(this.z, _t1, this.w * _t2);
        d.w = Math.fma(this.w, _t1, -(this.z * _t2));
        d.x = _buf0;
        d.z = _buf1;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _buf0 = Math.fma(this.x, _t1, this.y * _t2);
        d.y = Math.fma(this.y, _t1, -(this.x * _t2));
        float _buf1 = Math.fma(this.z, _t1, this.w * _t2);
        d.w = Math.fma(this.w, _t1, -(this.z * _t2));
        d.x = _buf0;
        d.z = _buf1;
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t21, this.w * _t22) + Math.fma(this.y, _t19, -(this.z * _t20));
        float _buf1 = Math.fma(this.y, _t21, this.z * _t22) + Math.fma(this.w, _t20, -(this.x * _t19));
        float _buf2 = Math.fma(this.x, _t20, this.w * _t19) + Math.fma(this.z, _t21, -(this.y * _t22));
        d.w = Math.fma(-this.z, _t19, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t22))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t21, this.w * _t22) + Math.fma(this.y, _t19, -(this.z * _t20));
        float _buf1 = Math.fma(this.y, _t21, this.z * _t22) + Math.fma(this.w, _t20, -(this.x * _t19));
        float _buf2 = Math.fma(this.x, _t20, this.w * _t19) + Math.fma(this.z, _t21, -(this.y * _t22));
        d.w = Math.fma(-this.z, _t19, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t22))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        FloatQuatImpl d = (FloatQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t22, -(this.z * _t20));
        float _buf1 = Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t20, -(this.x * _t22));
        float _buf2 = Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t19, -(this.y * _t21));
        d.w = Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t19, -(this.x * _t21))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        float _buf0 = Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t22, -(this.z * _t20));
        float _buf1 = Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t20, -(this.x * _t22));
        float _buf2 = Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t19, -(this.y * _t21));
        d.w = Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t19, -(this.x * _t21))));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, vY, -(this.y * vX));
        float _t10 = 2.0f * Math.fma(this.z, vX, -(this.x * vZ));
        float _t11 = 2.0f * Math.fma(this.y, vZ, -(this.z * vY));
        float _buf0 = Math.fma(this.y, _t9, Math.fma(-this.z, _t10, Math.fma(this.w, _t11, vX)));
        float _buf1 = Math.fma(this.z, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vY)));
        d.z = Math.fma(this.x, _t10, Math.fma(-this.y, _t11, Math.fma(this.w, _t9, vZ)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, vY, -(this.y * vX));
        float _t10 = 2.0f * Math.fma(this.z, vX, -(this.x * vZ));
        float _t11 = 2.0f * Math.fma(this.y, vZ, -(this.z * vY));
        float _buf0 = Math.fma(this.y, _t9, Math.fma(-this.z, _t10, Math.fma(this.w, _t11, vX)));
        float _buf1 = Math.fma(this.z, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vY)));
        d.z = Math.fma(this.x, _t10, Math.fma(-this.y, _t11, Math.fma(this.w, _t9, vZ)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, vZ, -(this.z * vX));
        float _t10 = 2.0f * Math.fma(this.y, vX, -(this.x * vY));
        float _t11 = 2.0f * Math.fma(this.z, vY, -(this.y * vZ));
        float _buf0 = Math.fma(this.z, _t9, Math.fma(-this.y, _t10, Math.fma(this.w, _t11, vX)));
        float _buf1 = Math.fma(this.x, _t10, Math.fma(-this.z, _t11, Math.fma(this.w, _t9, vY)));
        d.z = Math.fma(this.y, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vZ)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * Math.fma(this.x, vZ, -(this.z * vX));
        float _t10 = 2.0f * Math.fma(this.y, vX, -(this.x * vY));
        float _t11 = 2.0f * Math.fma(this.z, vY, -(this.y * vZ));
        float _buf0 = Math.fma(this.z, _t9, Math.fma(-this.y, _t10, Math.fma(this.w, _t11, vX)));
        float _buf1 = Math.fma(this.x, _t10, Math.fma(-this.z, _t11, Math.fma(this.w, _t9, vY)));
        d.z = Math.fma(this.y, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vZ)));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }

    public float x() { return this.x; }
    public float y() { return this.y; }
    public float z() { return this.z; }
    public float w() { return this.w; }

    @Override public String toString() {
        return "FloatQuat(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatQuatImpl)) return false;
        FloatQuatImpl o = (FloatQuatImpl) obj;
        return Float.floatToIntBits(x) == Float.floatToIntBits(o.x)
            && Float.floatToIntBits(y) == Float.floatToIntBits(o.y)
            && Float.floatToIntBits(z) == Float.floatToIntBits(o.z)
            && Float.floatToIntBits(w) == Float.floatToIntBits(o.w);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(x);
        h = 31 * h + Float.floatToIntBits(y);
        h = 31 * h + Float.floatToIntBits(z);
        h = 31 * h + Float.floatToIntBits(w);
        return h;
    }

    @Override public boolean isFinite() {
        return Float.isFinite(x)
            && Float.isFinite(y)
            && Float.isFinite(z)
            && Float.isFinite(w);
    }

    @Override public boolean equalsEpsilon(FloatQuatR other, float epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(w - other.w()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.w;
        return dest;
    }
    public @Mutated FloatQuat load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.w = src[offset + 3];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.w;
        return dest;
    }
    public @Mutated FloatQuat load(double[] src, int offset) {
        this.x = (float) src[offset + 0];
        this.y = (float) src[offset + 1];
        this.z = (float) src[offset + 2];
        this.w = (float) src[offset + 3];
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

}
