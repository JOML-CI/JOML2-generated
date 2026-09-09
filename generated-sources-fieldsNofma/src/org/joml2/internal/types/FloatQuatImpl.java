package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
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
        float _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        float _t6_inv = 1.0f / _t6;
        d.x = -(this.x * _t6_inv);
        d.y = -(this.y * _t6_inv);
        d.z = -(this.z * _t6_inv);
        d.w = this.w * _t6_inv;
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
        float _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        float _t6_inv = 1.0f / _t6;
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
        float _t24 = otherX * this.w + otherW * this.x + (otherZ * this.y - otherY * this.z);
        float _t25 = otherX * this.z + otherW * this.y + (otherY * this.w - otherZ * this.x);
        float _t26 = otherY * this.x + otherZ * this.w + (otherW * this.z - otherX * this.y);
        float _t27 = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
        float _t34 = _t25 * _t25 + _t24 * _t24 + _t26 * _t26 + _t27 * _t27;
        float _t34_inv = 1.0f / _t34;
        d.x = -(_t24 * _t34_inv);
        d.y = -(_t25 * _t34_inv);
        d.z = -(_t26 * _t34_inv);
        d.w = _t27 * _t34_inv;
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
        float _t24 = otherX * this.w + otherW * this.x + (otherZ * this.y - otherY * this.z);
        float _t25 = otherX * this.z + otherW * this.y + (otherY * this.w - otherZ * this.x);
        float _t26 = otherY * this.x + otherZ * this.w + (otherW * this.z - otherX * this.y);
        float _t27 = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
        float _t34 = _t25 * _t25 + _t24 * _t24 + _t26 * _t26 + _t27 * _t27;
        float _t34_inv = 1.0f / _t34;
        d.x = -(_t24 * _t34_inv);
        d.y = -(_t25 * _t34_inv);
        d.z = -(_t26 * _t34_inv);
        d.w = _t27 * _t34_inv;
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
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.x * this.x;
        float _t7 = this.y * this.z;
        float _t8 = this.x * this.w;
        d.m00 = 1.0f - 2.0f * (_t0 + _t1);
        d.m10 = 2.0f * (_t2 + _t3);
        d.m20 = 2.0f * (_t4 - _t5);
        d.m30 = 0.0f;
        d.m01 = 2.0f * (_t2 - _t3);
        d.m11 = 1.0f - 2.0f * (_t6 + _t1);
        d.m21 = 2.0f * (_t8 + _t7);
        d.m31 = 0.0f;
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = 2.0f * (_t7 - _t8);
        d.m22 = 1.0f - 2.0f * (_t6 + _t0);
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
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
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.x * this.x;
        float _t7 = this.y * this.z;
        float _t8 = this.x * this.w;
        d.m00 = 1.0f - 2.0f * (_t0 + _t1);
        d.m10 = 2.0f * (_t2 + _t3);
        d.m20 = 2.0f * (_t4 - _t5);
        d.m30 = 0.0f;
        d.m01 = 2.0f * (_t2 - _t3);
        d.m11 = 1.0f - 2.0f * (_t6 + _t1);
        d.m21 = 2.0f * (_t8 + _t7);
        d.m31 = 0.0f;
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = 2.0f * (_t7 - _t8);
        d.m22 = 1.0f - 2.0f * (_t6 + _t0);
        d.m32 = 0.0f;
        d.m03 = 0.0f;
        d.m13 = 0.0f;
        d.m23 = 0.0f;
        d.m33 = 1.0f;
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
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.x * this.x;
        float _t7 = this.y * this.z;
        float _t8 = this.x * this.w;
        d.m00 = 1.0f - 2.0f * (_t0 + _t1);
        d.m10 = 2.0f * (_t2 + _t3);
        d.m20 = 2.0f * (_t4 - _t5);
        d.m01 = 2.0f * (_t2 - _t3);
        d.m11 = 1.0f - 2.0f * (_t6 + _t1);
        d.m21 = 2.0f * (_t8 + _t7);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = 2.0f * (_t7 - _t8);
        d.m22 = 1.0f - 2.0f * (_t6 + _t0);
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
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.x * this.x;
        float _t7 = this.y * this.z;
        float _t8 = this.x * this.w;
        d.m00 = 1.0f - 2.0f * (_t0 + _t1);
        d.m10 = 2.0f * (_t2 + _t3);
        d.m20 = 2.0f * (_t4 - _t5);
        d.m01 = 2.0f * (_t2 - _t3);
        d.m11 = 1.0f - 2.0f * (_t6 + _t1);
        d.m21 = 2.0f * (_t8 + _t7);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m12 = 2.0f * (_t7 - _t8);
        d.m22 = 1.0f - 2.0f * (_t6 + _t0);
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
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.x * this.x;
        float _t7 = this.y * this.z;
        float _t8 = this.x * this.w;
        d.m00 = 1.0f - 2.0f * (_t0 + _t1);
        d.m01 = 2.0f * (_t2 - _t3);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m03 = 0.0f;
        d.m10 = 2.0f * (_t2 + _t3);
        d.m11 = 1.0f - 2.0f * (_t6 + _t1);
        d.m12 = 2.0f * (_t7 - _t8);
        d.m13 = 0.0f;
        d.m20 = 2.0f * (_t4 - _t5);
        d.m21 = 2.0f * (_t8 + _t7);
        d.m22 = 1.0f - 2.0f * (_t6 + _t0);
        d.m23 = 0.0f;
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
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.x * this.x;
        float _t7 = this.y * this.z;
        float _t8 = this.x * this.w;
        d.m00 = 1.0f - 2.0f * (_t0 + _t1);
        d.m01 = 2.0f * (_t2 - _t3);
        d.m02 = 2.0f * (_t4 + _t5);
        d.m03 = 0.0f;
        d.m10 = 2.0f * (_t2 + _t3);
        d.m11 = 1.0f - 2.0f * (_t6 + _t1);
        d.m12 = 2.0f * (_t7 - _t8);
        d.m13 = 0.0f;
        d.m20 = 2.0f * (_t4 - _t5);
        d.m21 = 2.0f * (_t8 + _t7);
        d.m22 = 1.0f - 2.0f * (_t6 + _t0);
        d.m23 = 0.0f;
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
        float _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _t7 = this.w * this.w + _t5 * _t5;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t10 = _t5 * _t8;
        float _t14, _t15, _t16, _t17;
        if (_t7 > 1.0E-14f) {
            _t14 = this.w * _t8;
            _t15 = axisX * _t10;
            _t16 = axisY * _t10;
            _t17 = axisZ * _t10;
        } else {
            _t14 = 1.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _d0buf0 = this.x * _t14 - this.w * _t15 + (this.z * _t16 - this.y * _t17);
        float _d0buf1 = this.x * _t17 - this.w * _t16 + (this.y * _t14 - this.z * _t15);
        float _d0buf2 = this.y * _t15 + this.z * _t14 + (-(this.w * _t17) - this.x * _t16);
        d0.w = this.x * _t15 + this.w * _t14 + this.y * _t16 + this.z * _t17;
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
        float _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _t7 = this.w * this.w + _t5 * _t5;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t10 = _t5 * _t8;
        float _t14, _t15, _t16, _t17;
        if (_t7 > 1.0E-14f) {
            _t14 = this.w * _t8;
            _t15 = axisX * _t10;
            _t16 = axisY * _t10;
            _t17 = axisZ * _t10;
        } else {
            _t14 = 1.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _d0buf0 = this.x * _t14 - this.w * _t15 + (this.z * _t16 - this.y * _t17);
        float _d0buf1 = this.x * _t17 - this.w * _t16 + (this.y * _t14 - this.z * _t15);
        float _d0buf2 = this.y * _t15 + this.z * _t14 + (-(this.w * _t17) - this.x * _t16);
        d0.w = this.x * _t15 + this.w * _t14 + this.y * _t16 + this.z * _t17;
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
        float _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _t7 = this.w * this.w + _t5 * _t5;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t10 = _t5 * _t8;
        float _t14, _t15, _t16, _t17;
        if (_t7 > 1.0E-14f) {
            _t14 = this.w * _t8;
            _t15 = axisX * _t10;
            _t16 = axisY * _t10;
            _t17 = axisZ * _t10;
        } else {
            _t14 = 1.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _buf0 = this.x * _t14 - this.w * _t15 + (this.z * _t16 - this.y * _t17);
        float _buf1 = this.x * _t17 - this.w * _t16 + (this.y * _t14 - this.z * _t15);
        float _buf2 = this.y * _t15 + this.z * _t14 + (-(this.w * _t17) - this.x * _t16);
        d.w = this.x * _t15 + this.w * _t14 + this.y * _t16 + this.z * _t17;
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
        float _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _t7 = this.w * this.w + _t5 * _t5;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t10 = _t5 * _t8;
        float _t14, _t15, _t16, _t17;
        if (_t7 > 1.0E-14f) {
            _t14 = this.w * _t8;
            _t15 = axisX * _t10;
            _t16 = axisY * _t10;
            _t17 = axisZ * _t10;
        } else {
            _t14 = 1.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        float _buf0 = this.x * _t14 - this.w * _t15 + (this.z * _t16 - this.y * _t17);
        float _buf1 = this.x * _t17 - this.w * _t16 + (this.y * _t14 - this.z * _t15);
        float _buf2 = this.y * _t15 + this.z * _t14 + (-(this.w * _t17) - this.x * _t16);
        d.w = this.x * _t15 + this.w * _t14 + this.y * _t16 + this.z * _t17;
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
        float _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _t7 = this.w * this.w + _t5 * _t5;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t9 = _t5 * _t8;
        if (_t7 > 1.0E-14f) {
            d.x = axisX * _t9;
            d.y = axisY * _t9;
            d.z = axisZ * _t9;
            d.w = this.w * _t8;
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
        float _t5 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _t7 = this.w * this.w + _t5 * _t5;
        float _t8 = (1.0f / (float) Math.sqrt(_t7));
        float _t9 = _t5 * _t8;
        if (_t7 > 1.0E-14f) {
            d.x = axisX * _t9;
            d.y = axisY * _t9;
            d.z = axisZ * _t9;
            d.w = this.w * _t8;
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
        d.x = t * (otherX - this.x) + this.x;
        d.y = t * (otherY - this.y) + this.y;
        d.z = t * (otherZ - this.z) + this.z;
        d.w = t * (otherW - this.w) + this.w;
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
        d.x = t * (otherX - this.x) + this.x;
        d.y = t * (otherY - this.y) + this.y;
        d.z = t * (otherZ - this.z) + this.z;
        d.w = t * (otherW - this.w) + this.w;
        return d;
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
    public FloatQuat nlerp(FloatQuatR target, float alpha, @Mutated FloatQuat dest) {
        return nlerp(target.x(), target.y(), target.z(), target.w(), alpha, dest);
    }


    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result and store the result in {@code dest}.
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
        float _t8 = alpha * (targetX - this.x) + this.x;
        float _t9 = alpha * (targetY - this.y) + this.y;
        float _t10 = alpha * (targetZ - this.z) + this.z;
        float _t11 = alpha * (targetW - this.w) + this.w;
        float _t18 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10 + _t11 * _t11;
        float _t19 = (1.0f / (float) Math.sqrt(_t18));
        if (_t18 > 0.0f) {
            d.x = _t8 * _t19;
            d.y = _t9 * _t19;
            d.z = _t10 * _t19;
            d.w = _t11 * _t19;
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
        float _t8 = alpha * (targetX - this.x) + this.x;
        float _t9 = alpha * (targetY - this.y) + this.y;
        float _t10 = alpha * (targetZ - this.z) + this.z;
        float _t11 = alpha * (targetW - this.w) + this.w;
        float _t18 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10 + _t11 * _t11;
        float _t19 = (1.0f / (float) Math.sqrt(_t18));
        if (_t18 > 0.0f) {
            d.x = _t8 * _t19;
            d.y = _t9 * _t19;
            d.z = _t10 * _t19;
            d.w = _t11 * _t19;
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
        float _t11 = -(this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW);
        float _t24, _t25, _t26, _t27;
        if (_t11 > 0.0f) {
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
        float _t34 = _t24 * _t24 + _t25 * _t25 + _t26 * _t26 + _t27 * _t27;
        float _t35 = (1.0f / (float) Math.sqrt(_t34));
        if (_t34 > 0.0f) {
            d.x = _t24 * _t35;
            d.y = _t25 * _t35;
            d.z = _t26 * _t35;
            d.w = _t27 * _t35;
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
        float _t11 = -(this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW);
        float _t24, _t25, _t26, _t27;
        if (_t11 > 0.0f) {
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
        float _t34 = _t24 * _t24 + _t25 * _t25 + _t26 * _t26 + _t27 * _t27;
        float _t35 = (1.0f / (float) Math.sqrt(_t34));
        if (_t34 > 0.0f) {
            d.x = _t24 * _t35;
            d.y = _t25 * _t35;
            d.z = _t26 * _t35;
            d.w = _t27 * _t35;
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
        float _t10 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW)));
        float _t11 = (float) Math.sin(_t10);
        float _t11_inv = 1.0f / _t11;
        float _t12 = Math.abs(_t11);
        float _t14 = (float) Math.sin(alpha * _t10);
        float _t16 = (float) Math.sin(_t0 * _t10);
        if (_t12 > 1.0E-6f) {
            d.x = (this.x * _t16 + targetX * _t14) * _t11_inv;
            d.y = (this.y * _t16 + targetY * _t14) * _t11_inv;
            d.z = (this.z * _t16 + targetZ * _t14) * _t11_inv;
            d.w = (this.w * _t16 + targetW * _t14) * _t11_inv;
        } else {
            d.x = alpha * targetX + this.x * _t0;
            d.y = alpha * targetY + this.y * _t0;
            d.z = alpha * targetZ + this.z * _t0;
            d.w = alpha * targetW + this.w * _t0;
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
        float _t10 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW)));
        float _t11 = (float) Math.sin(_t10);
        float _t11_inv = 1.0f / _t11;
        float _t12 = Math.abs(_t11);
        float _t14 = (float) Math.sin(alpha * _t10);
        float _t16 = (float) Math.sin(_t0 * _t10);
        if (_t12 > 1.0E-6f) {
            d.x = (this.x * _t16 + targetX * _t14) * _t11_inv;
            d.y = (this.y * _t16 + targetY * _t14) * _t11_inv;
            d.z = (this.z * _t16 + targetZ * _t14) * _t11_inv;
            d.w = (this.w * _t16 + targetW * _t14) * _t11_inv;
        } else {
            d.x = alpha * targetX + this.x * _t0;
            d.y = alpha * targetY + this.y * _t0;
            d.z = alpha * targetZ + this.z * _t0;
            d.w = alpha * targetW + this.w * _t0;
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
        float _t15 = this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW;
        float _t17 = -_t15;
        float _t19 = (float) Math.acos(Math.min(1.0f, Math.abs(_t15)));
        float _t20 = (float) Math.sin(_t19);
        float _t20_inv = 1.0f / _t20;
        float _t22 = (float) Math.sin(alpha * _t19);
        float _t24, _t25, _t26, _t27;
        if (_t17 > 0.0f) {
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
        float _t28 = (float) Math.sin(_t0 * _t19);
        float _t53, _t54, _t55, _t56;
        if (_t20 > 0.0f) {
            _t53 = (this.x * _t28 + _t22 * _t24) * _t20_inv;
            _t54 = (this.y * _t28 + _t22 * _t25) * _t20_inv;
            _t55 = (this.z * _t28 + _t22 * _t26) * _t20_inv;
            _t56 = (this.w * _t28 + _t22 * _t27) * _t20_inv;
        } else {
            _t53 = alpha * _t24 + this.x * _t0;
            _t54 = alpha * _t25 + this.y * _t0;
            _t55 = alpha * _t26 + this.z * _t0;
            _t56 = alpha * _t27 + this.w * _t0;
        }
        float _t63 = _t53 * _t53 + _t54 * _t54 + _t55 * _t55 + _t56 * _t56;
        float _t64 = (1.0f / (float) Math.sqrt(_t63));
        if (_t63 > 0.0f) {
            d.x = _t64 * _t53;
            d.y = _t64 * _t54;
            d.z = _t64 * _t55;
            d.w = _t64 * _t56;
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
        float _t15 = this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW;
        float _t17 = -_t15;
        float _t19 = (float) Math.acos(Math.min(1.0f, Math.abs(_t15)));
        float _t20 = (float) Math.sin(_t19);
        float _t20_inv = 1.0f / _t20;
        float _t22 = (float) Math.sin(alpha * _t19);
        float _t24, _t25, _t26, _t27;
        if (_t17 > 0.0f) {
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
        float _t28 = (float) Math.sin(_t0 * _t19);
        float _t53, _t54, _t55, _t56;
        if (_t20 > 0.0f) {
            _t53 = (this.x * _t28 + _t22 * _t24) * _t20_inv;
            _t54 = (this.y * _t28 + _t22 * _t25) * _t20_inv;
            _t55 = (this.z * _t28 + _t22 * _t26) * _t20_inv;
            _t56 = (this.w * _t28 + _t22 * _t27) * _t20_inv;
        } else {
            _t53 = alpha * _t24 + this.x * _t0;
            _t54 = alpha * _t25 + this.y * _t0;
            _t55 = alpha * _t26 + this.z * _t0;
            _t56 = alpha * _t27 + this.w * _t0;
        }
        float _t63 = _t53 * _t53 + _t54 * _t54 + _t55 * _t55 + _t56 * _t56;
        float _t64 = (1.0f / (float) Math.sqrt(_t63));
        if (_t63 > 0.0f) {
            d.x = _t64 * _t53;
            d.y = _t64 * _t54;
            d.z = _t64 * _t55;
            d.w = _t64 * _t56;
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
        float _t26 = _t0 * 2.0f * t;
        float _t27 = 1.0f - _t26;
        float _t46 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, control0X * control1X + control0Y * control1Y + control0Z * control1Z + control0W * control1W)));
        float _t47 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW)));
        float _t48 = (float) Math.sin(_t46);
        float _t48_inv = 1.0f / _t48;
        float _t49 = (float) Math.sin(_t47);
        float _t49_inv = 1.0f / _t49;
        float _t50 = Math.abs(_t48);
        float _t52 = Math.abs(_t49);
        float _t54 = (float) Math.sin(t * _t46);
        float _t55 = (float) Math.sin(t * _t47);
        float _t58 = (float) Math.sin(_t0 * _t46);
        float _t59 = (float) Math.sin(_t0 * _t47);
        float _t92, _t94, _t96, _t98;
        if (_t50 > 1.0E-6f) {
            _t92 = (control0X * _t58 + control1X * _t54) * _t48_inv;
            _t94 = (control0Y * _t58 + control1Y * _t54) * _t48_inv;
            _t96 = (control0Z * _t58 + control1Z * _t54) * _t48_inv;
            _t98 = (control0W * _t58 + control1W * _t54) * _t48_inv;
        } else {
            _t92 = t * control1X + control0X * _t0;
            _t94 = t * control1Y + control0Y * _t0;
            _t96 = t * control1Z + control0Z * _t0;
            _t98 = t * control1W + control0W * _t0;
        }
        float _t93, _t95, _t97, _t99;
        if (_t52 > 1.0E-6f) {
            _t93 = (this.x * _t59 + targetX * _t55) * _t49_inv;
            _t95 = (this.y * _t59 + targetY * _t55) * _t49_inv;
            _t97 = (this.z * _t59 + targetZ * _t55) * _t49_inv;
            _t99 = (this.w * _t59 + targetW * _t55) * _t49_inv;
        } else {
            _t93 = t * targetX + this.x * _t0;
            _t95 = t * targetY + this.y * _t0;
            _t97 = t * targetZ + this.z * _t0;
            _t99 = t * targetW + this.w * _t0;
        }
        float _t109 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, _t92 * _t93 + _t94 * _t95 + _t96 * _t97 + _t98 * _t99)));
        float _t110 = (float) Math.sin(_t109);
        float _t110_inv = 1.0f / _t110;
        float _t111 = Math.abs(_t110);
        float _t113 = (float) Math.sin(_t26 * _t109);
        float _t115 = (float) Math.sin(_t27 * _t109);
        if (_t111 > 1.0E-6f) {
            d.x = (_t115 * _t93 + _t113 * _t92) * _t110_inv;
            d.y = (_t115 * _t95 + _t113 * _t94) * _t110_inv;
            d.z = (_t115 * _t97 + _t113 * _t96) * _t110_inv;
            d.w = (_t115 * _t99 + _t113 * _t98) * _t110_inv;
        } else {
            d.x = _t27 * _t93 + _t26 * _t92;
            d.y = _t27 * _t95 + _t26 * _t94;
            d.z = _t27 * _t97 + _t26 * _t96;
            d.w = _t27 * _t99 + _t26 * _t98;
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
        float _t26 = _t0 * 2.0f * t;
        float _t27 = 1.0f - _t26;
        float _t46 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, control0X * control1X + control0Y * control1Y + control0Z * control1Z + control0W * control1W)));
        float _t47 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW)));
        float _t48 = (float) Math.sin(_t46);
        float _t48_inv = 1.0f / _t48;
        float _t49 = (float) Math.sin(_t47);
        float _t49_inv = 1.0f / _t49;
        float _t50 = Math.abs(_t48);
        float _t52 = Math.abs(_t49);
        float _t54 = (float) Math.sin(t * _t46);
        float _t55 = (float) Math.sin(t * _t47);
        float _t58 = (float) Math.sin(_t0 * _t46);
        float _t59 = (float) Math.sin(_t0 * _t47);
        float _t92, _t94, _t96, _t98;
        if (_t50 > 1.0E-6f) {
            _t92 = (control0X * _t58 + control1X * _t54) * _t48_inv;
            _t94 = (control0Y * _t58 + control1Y * _t54) * _t48_inv;
            _t96 = (control0Z * _t58 + control1Z * _t54) * _t48_inv;
            _t98 = (control0W * _t58 + control1W * _t54) * _t48_inv;
        } else {
            _t92 = t * control1X + control0X * _t0;
            _t94 = t * control1Y + control0Y * _t0;
            _t96 = t * control1Z + control0Z * _t0;
            _t98 = t * control1W + control0W * _t0;
        }
        float _t93, _t95, _t97, _t99;
        if (_t52 > 1.0E-6f) {
            _t93 = (this.x * _t59 + targetX * _t55) * _t49_inv;
            _t95 = (this.y * _t59 + targetY * _t55) * _t49_inv;
            _t97 = (this.z * _t59 + targetZ * _t55) * _t49_inv;
            _t99 = (this.w * _t59 + targetW * _t55) * _t49_inv;
        } else {
            _t93 = t * targetX + this.x * _t0;
            _t95 = t * targetY + this.y * _t0;
            _t97 = t * targetZ + this.z * _t0;
            _t99 = t * targetW + this.w * _t0;
        }
        float _t109 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, _t92 * _t93 + _t94 * _t95 + _t96 * _t97 + _t98 * _t99)));
        float _t110 = (float) Math.sin(_t109);
        float _t110_inv = 1.0f / _t110;
        float _t111 = Math.abs(_t110);
        float _t113 = (float) Math.sin(_t26 * _t109);
        float _t115 = (float) Math.sin(_t27 * _t109);
        if (_t111 > 1.0E-6f) {
            d.x = (_t115 * _t93 + _t113 * _t92) * _t110_inv;
            d.y = (_t115 * _t95 + _t113 * _t94) * _t110_inv;
            d.z = (_t115 * _t97 + _t113 * _t96) * _t110_inv;
            d.w = (_t115 * _t99 + _t113 * _t98) * _t110_inv;
        } else {
            d.x = _t27 * _t93 + _t26 * _t92;
            d.y = _t27 * _t95 + _t26 * _t94;
            d.z = _t27 * _t97 + _t26 * _t96;
            d.w = _t27 * _t99 + _t26 * _t98;
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
        float _buf0 = otherX * this.w + otherW * this.x + (otherZ * this.y - otherY * this.z);
        float _buf1 = otherX * this.z + otherW * this.y + (otherY * this.w - otherZ * this.x);
        float _buf2 = otherY * this.x + otherZ * this.w + (otherW * this.z - otherX * this.y);
        d.w = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
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
        float _buf0 = otherX * this.w + otherW * this.x + (otherZ * this.y - otherY * this.z);
        float _buf1 = otherX * this.z + otherW * this.y + (otherY * this.w - otherZ * this.x);
        float _buf2 = otherY * this.x + otherZ * this.w + (otherW * this.z - otherX * this.y);
        d.w = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
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
        float _buf0 = otherX * this.w + otherW * this.x + (otherY * this.z - otherZ * this.y);
        float _buf1 = otherY * this.w + otherZ * this.x + (otherW * this.y - otherX * this.z);
        float _buf2 = otherX * this.y + otherW * this.z + (otherZ * this.w - otherY * this.x);
        d.w = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
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
        float _buf0 = otherX * this.w + otherW * this.x + (otherY * this.z - otherZ * this.y);
        float _buf1 = otherY * this.w + otherZ * this.x + (otherW * this.y - otherX * this.z);
        float _buf2 = otherX * this.y + otherW * this.z + (otherZ * this.w - otherY * this.x);
        d.w = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     *
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    public float angle() {
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, this.w)));
    }


    /**
     * Compute the angle in radians between this quaternion and {@code other}.
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
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(otherX * this.x + otherY * this.y + otherZ * this.z + otherW * this.w)));
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
        float _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        if (_t4 > 0.0f) {
            d.x = this.x * _t5;
            d.y = this.y * _t5;
            d.z = this.z * _t5;
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
        float _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        if (_t4 > 0.0f) {
            d.x = this.x * _t5;
            d.y = this.y * _t5;
            d.z = this.z * _t5;
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
        d.w = (float) Math.sqrt(Math.max(0.0f, 1.0f - this.z * this.z - this.y * this.y - this.x * this.x));
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
        d.w = (float) Math.sqrt(Math.max(0.0f, 1.0f - this.z * this.z - this.y * this.y - this.x * this.x));
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
        float _t24 = qX * this.y + qW * this.z + (qZ * this.w - qY * this.x);
        float _t25 = qY * this.w + qZ * this.x + (qW * this.y - qX * this.z);
        float _t26 = qX * this.w + qW * this.x + (qY * this.z - qZ * this.y);
        float _t27 = qW * this.w - qX * this.x - qY * this.y - qZ * this.z;
        d.x = qY * _t24 - qZ * _t25 + (qW * _t26 - qX * _t27);
        d.y = qZ * _t26 - qY * _t27 + (qW * _t25 - qX * _t24);
        d.z = qX * _t25 + qW * _t24 + (-(qZ * _t27) - qY * _t26);
        d.w = qX * _t26 + qW * _t27 + qY * _t25 + qZ * _t24;
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
        float _t24 = qX * this.y + qW * this.z + (qZ * this.w - qY * this.x);
        float _t25 = qY * this.w + qZ * this.x + (qW * this.y - qX * this.z);
        float _t26 = qX * this.w + qW * this.x + (qY * this.z - qZ * this.y);
        float _t27 = qW * this.w - qX * this.x - qY * this.y - qZ * this.z;
        d.x = qY * _t24 - qZ * _t25 + (qW * _t26 - qX * _t27);
        d.y = qZ * _t26 - qY * _t27 + (qW * _t25 - qX * _t24);
        d.z = qX * _t25 + qW * _t24 + (-(qZ * _t27) - qY * _t26);
        d.w = qX * _t26 + qW * _t27 + qY * _t25 + qZ * _t24;
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
        float _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        float _t6_inv = 1.0f / _t6;
        float _buf0 = (otherX * this.w - otherW * this.x + (otherY * this.z - otherZ * this.y)) * _t6_inv;
        float _buf1 = -(otherW * this.y * _t6_inv) - otherX * this.z * _t6_inv + (otherY * this.w + otherZ * this.x) * _t6_inv;
        float _buf2 = (otherX * this.y - otherW * this.z + (otherZ * this.w - otherY * this.x)) * _t6_inv;
        d.w = (otherX * this.x + otherW * this.w + otherY * this.y + otherZ * this.z) * _t6_inv;
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
        float _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        float _t6_inv = 1.0f / _t6;
        float _buf0 = (otherX * this.w - otherW * this.x + (otherY * this.z - otherZ * this.y)) * _t6_inv;
        float _buf1 = -(otherW * this.y * _t6_inv) - otherX * this.z * _t6_inv + (otherY * this.w + otherZ * this.x) * _t6_inv;
        float _buf2 = (otherX * this.y - otherW * this.z + (otherZ * this.w - otherY * this.x)) * _t6_inv;
        d.w = (otherX * this.x + otherW * this.w + otherY * this.y + otherZ * this.z) * _t6_inv;
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
        return otherX * this.x + otherY * this.y + otherZ * this.z + otherW * this.w;
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
        float _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t6 = (float) Math.sqrt(_t5);
        float _t10 = (float) Math.sin(_t6) * _t0 * (1.0f / (float) Math.sqrt(_t5));
        if (_t5 > 0.0f) {
            d.x = this.x * _t10;
            d.y = this.y * _t10;
            d.z = this.z * _t10;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t6) * _t0;
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
        float _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t6 = (float) Math.sqrt(_t5);
        float _t10 = (float) Math.sin(_t6) * _t0 * (1.0f / (float) Math.sqrt(_t5));
        if (_t5 > 0.0f) {
            d.x = this.x * _t10;
            d.y = this.y * _t10;
            d.z = this.z * _t10;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t6) * _t0;
        return d;
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
    public Float3 getEulerAnglesXYZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.x * this.x;
        float _t1 = this.y * this.y;
        float _t2 = this.x * this.w;
        float _t3 = this.y * this.z;
        float _t6 = this.z * this.z;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 + _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.z = (float) Math.atan2(2.0f * (this.z * this.w - this.x * this.y), 1.0f - 2.0f * (_t1 + _t6));
            d.x = _buf0;
        }
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXYZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.x * this.x;
        float _t1 = this.y * this.y;
        float _t2 = this.x * this.w;
        float _t3 = this.y * this.z;
        float _t6 = this.z * this.z;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 + _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.z = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.z = (float) Math.atan2(2.0f * (this.z * this.w - this.x * this.y), 1.0f - 2.0f * (_t1 + _t6));
            d.x = _buf0;
        }
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
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
    public Float3 getEulerAnglesXZY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.x * this.x;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.w;
        float _t3 = this.y * this.z;
        float _t6 = this.y * this.y;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.z * this.w - this.x * this.y);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 - _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.y = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.y = (float) Math.atan2(2.0f * (this.x * this.z + this.y * this.w), 1.0f - 2.0f * (_t6 + _t1));
            d.x = _buf0;
        }
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesXZY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.x * this.x;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.w;
        float _t3 = this.y * this.z;
        float _t6 = this.y * this.y;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.z * this.w - this.x * this.y);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t2 - _t3), 1.0f - 2.0f * (_t0 + _t6));
            d.y = 0.0f;
            d.x = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t11, _t13);
            d.y = (float) Math.atan2(2.0f * (this.x * this.z + this.y * this.w), 1.0f - 2.0f * (_t6 + _t1));
            d.x = _buf0;
        }
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
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
    public Float3 getEulerAnglesYXZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = this.x * this.x;
        float _t3 = this.y * this.y;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.z * this.z;
        float _t10 = 2.0f * (this.x * this.w - this.y * this.z);
        float _t12 = 2.0f * (_t4 + _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t5 - _t4), 1.0f - 2.0f * (_t3 + _t6));
            d.z = 0.0f;
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t12, _t13);
            d.z = (float) Math.atan2(2.0f * (this.x * this.y + this.z * this.w), 1.0f - 2.0f * (_t2 + _t6));
            d.y = _buf0;
        }
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYXZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = this.x * this.x;
        float _t3 = this.y * this.y;
        float _t4 = this.x * this.z;
        float _t5 = this.y * this.w;
        float _t6 = this.z * this.z;
        float _t10 = 2.0f * (this.x * this.w - this.y * this.z);
        float _t12 = 2.0f * (_t4 + _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            float _buf0 = (float) Math.atan2(2.0f * (_t5 - _t4), 1.0f - 2.0f * (_t3 + _t6));
            d.z = 0.0f;
            d.y = _buf0;
        } else {
            float _buf0 = (float) Math.atan2(_t12, _t13);
            d.z = (float) Math.atan2(2.0f * (this.x * this.y + this.z * this.w), 1.0f - 2.0f * (_t2 + _t6));
            d.y = _buf0;
        }
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
        return d;
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
    public Float3 getEulerAnglesYZX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.y * this.w;
        float _t3 = this.x * this.z;
        float _t6 = this.x * this.x;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.y = (float) Math.atan2(2.0f * (_t3 + _t2), 1.0f - 2.0f * (_t6 + _t0));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.x * this.w - this.y * this.z), 1.0f - 2.0f * (_t6 + _t1));
            d.y = (float) Math.atan2(_t11, _t13);
        }
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesYZX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.y * this.w;
        float _t3 = this.x * this.z;
        float _t6 = this.x * this.x;
        float _t11 = 2.0f * (_t2 - _t3);
        float _t12 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.y = (float) Math.atan2(2.0f * (_t3 + _t2), 1.0f - 2.0f * (_t6 + _t0));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.x * this.w - this.y * this.z), 1.0f - 2.0f * (_t6 + _t1));
            d.y = (float) Math.atan2(_t11, _t13);
        }
        d.z = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
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
    public Float3 getEulerAnglesZXY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = this.x * this.x;
        float _t3 = this.z * this.z;
        float _t4 = this.z * this.w;
        float _t5 = this.x * this.y;
        float _t6 = this.y * this.y;
        float _t10 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t12 = 2.0f * (_t4 - _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            d.y = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t5 + _t4), 1.0f - 2.0f * (_t6 + _t3));
        } else {
            d.y = (float) Math.atan2(2.0f * (this.y * this.w - this.x * this.z), 1.0f - 2.0f * (_t2 + _t6));
            d.z = (float) Math.atan2(_t12, _t13);
        }
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZXY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = this.x * this.x;
        float _t3 = this.z * this.z;
        float _t4 = this.z * this.w;
        float _t5 = this.x * this.y;
        float _t6 = this.y * this.y;
        float _t10 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t12 = 2.0f * (_t4 - _t5);
        float _t13 = 1.0f - 2.0f * (_t2 + _t3);
        float _t17 = _t13 * _t13 + _t12 * _t12;
        float _t19 = (_t17 + _t10 * _t10) * 1.0E-7f;
        if (_t17 < _t19) {
            d.y = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t5 + _t4), 1.0f - 2.0f * (_t6 + _t3));
        } else {
            d.y = (float) Math.atan2(2.0f * (this.y * this.w - this.x * this.z), 1.0f - 2.0f * (_t2 + _t6));
            d.z = (float) Math.atan2(_t12, _t13);
        }
        d.x = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t10)));
        return d;
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
    public Float3 getEulerAnglesZYX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t6 = this.x * this.x;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.y * this.w - this.x * this.z);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t3 - _t2), 1.0f - 2.0f * (_t6 + _t1));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.x * this.w + this.y * this.z), 1.0f - 2.0f * (_t6 + _t0));
            d.z = (float) Math.atan2(_t11, _t13);
        }
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
        return d;
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order and store the result in {@code dest}.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getEulerAnglesZYX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.y * this.y;
        float _t1 = this.z * this.z;
        float _t2 = this.x * this.y;
        float _t3 = this.z * this.w;
        float _t6 = this.x * this.x;
        float _t11 = 2.0f * (_t2 + _t3);
        float _t12 = 2.0f * (this.y * this.w - this.x * this.z);
        float _t13 = 1.0f - 2.0f * (_t0 + _t1);
        float _t17 = _t13 * _t13 + _t11 * _t11;
        float _t19 = (_t17 + _t12 * _t12) * 1.0E-7f;
        if (_t17 < _t19) {
            d.x = 0.0f;
            d.z = (float) Math.atan2(2.0f * (_t3 - _t2), 1.0f - 2.0f * (_t6 + _t1));
        } else {
            d.x = (float) Math.atan2(2.0f * (this.x * this.w + this.y * this.z), 1.0f - 2.0f * (_t6 + _t0));
            d.z = (float) Math.atan2(_t11, _t13);
        }
        d.y = (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t12)));
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
        float _t1 = angularVelX * _t0;
        float _t2 = angularVelY * _t0;
        float _t3 = angularVelZ * _t0;
        float _t8 = _t1 * _t1 + _t2 * _t2 + _t3 * _t3;
        float _t9 = (float) Math.sqrt(_t8);
        float _t11 = (float) Math.cos(_t9);
        float _t13 = (float) Math.sin(_t9) * (1.0f / (float) Math.sqrt(_t8));
        float _t17, _t18, _t19;
        if (_t8 > 0.0f) {
            _t17 = _t1 * _t13;
            _t18 = _t2 * _t13;
            _t19 = _t3 * _t13;
        } else {
            _t17 = 0.0f;
            _t18 = 0.0f;
            _t19 = 0.0f;
        }
        float _buf0 = this.x * _t11 + this.w * _t17 + (this.z * _t18 - this.y * _t19);
        float _buf1 = this.x * _t19 + this.w * _t18 + (this.y * _t11 - this.z * _t17);
        float _buf2 = this.y * _t17 + this.z * _t11 + (this.w * _t19 - this.x * _t18);
        d.w = this.w * _t11 - this.x * _t17 - this.y * _t18 - this.z * _t19;
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
        float _t1 = angularVelX * _t0;
        float _t2 = angularVelY * _t0;
        float _t3 = angularVelZ * _t0;
        float _t8 = _t1 * _t1 + _t2 * _t2 + _t3 * _t3;
        float _t9 = (float) Math.sqrt(_t8);
        float _t11 = (float) Math.cos(_t9);
        float _t13 = (float) Math.sin(_t9) * (1.0f / (float) Math.sqrt(_t8));
        float _t17, _t18, _t19;
        if (_t8 > 0.0f) {
            _t17 = _t1 * _t13;
            _t18 = _t2 * _t13;
            _t19 = _t3 * _t13;
        } else {
            _t17 = 0.0f;
            _t18 = 0.0f;
            _t19 = 0.0f;
        }
        float _buf0 = this.x * _t11 + this.w * _t17 + (this.z * _t18 - this.y * _t19);
        float _buf1 = this.x * _t19 + this.w * _t18 + (this.y * _t11 - this.z * _t17);
        float _buf2 = this.y * _t17 + this.z * _t11 + (this.w * _t19 - this.x * _t18);
        d.w = this.w * _t11 - this.x * _t17 - this.y * _t18 - this.z * _t19;
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invNegativeX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t14 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t12 * _t20);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t14 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t12 * _t20);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invNegativeY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t11 * _t20);
            d.y = -(_t14 * _t20);
            d.z = -(_t12 * _t20);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t11 * _t20);
            d.y = -(_t14 * _t20);
            d.z = -(_t12 * _t20);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invNegativeZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t12 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t14 * _t20);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invNegativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t12 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t14 * _t20);
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
        float _buf0 = 2.0f * (this.y * this.y + this.z * this.z) - 1.0f;
        float _buf1 = -(2.0f * (this.x * this.y - this.z * this.w));
        d.z = -(2.0f * (this.x * this.z + this.y * this.w));
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
        float _buf0 = 2.0f * (this.y * this.y + this.z * this.z) - 1.0f;
        float _buf1 = -(2.0f * (this.x * this.y - this.z * this.w));
        d.z = -(2.0f * (this.x * this.z + this.y * this.w));
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
        float _buf0 = -(2.0f * (this.x * this.y + this.z * this.w));
        float _buf1 = 2.0f * (this.x * this.x + this.z * this.z) - 1.0f;
        d.z = -(2.0f * (this.y * this.z - this.x * this.w));
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
        float _buf0 = -(2.0f * (this.x * this.y + this.z * this.w));
        float _buf1 = 2.0f * (this.x * this.x + this.z * this.z) - 1.0f;
        d.z = -(2.0f * (this.y * this.z - this.x * this.w));
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
        float _buf0 = -(2.0f * (this.x * this.z - this.y * this.w));
        float _buf1 = -(2.0f * (this.x * this.w + this.y * this.z));
        d.z = 2.0f * (this.x * this.x + this.y * this.y) - 1.0f;
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
        float _buf0 = -(2.0f * (this.x * this.z - this.y * this.w));
        float _buf1 = -(2.0f * (this.x * this.w + this.y * this.z));
        d.z = 2.0f * (this.x * this.x + this.y * this.y) - 1.0f;
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
        float _buf0 = 1.0f - 2.0f * (this.y * this.y + this.z * this.z);
        float _buf1 = 2.0f * (this.x * this.y - this.z * this.w);
        d.z = 2.0f * (this.x * this.z + this.y * this.w);
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
        float _buf0 = 1.0f - 2.0f * (this.y * this.y + this.z * this.z);
        float _buf1 = 2.0f * (this.x * this.y - this.z * this.w);
        d.z = 2.0f * (this.x * this.z + this.y * this.w);
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
        float _buf0 = 2.0f * (this.x * this.y + this.z * this.w);
        float _buf1 = 1.0f - 2.0f * (this.x * this.x + this.z * this.z);
        d.z = 2.0f * (this.y * this.z - this.x * this.w);
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
        float _buf0 = 2.0f * (this.x * this.y + this.z * this.w);
        float _buf1 = 1.0f - 2.0f * (this.x * this.x + this.z * this.z);
        d.z = 2.0f * (this.y * this.z - this.x * this.w);
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
        float _buf0 = 2.0f * (this.x * this.z - this.y * this.w);
        float _buf1 = 2.0f * (this.x * this.w + this.y * this.z);
        d.z = 1.0f - 2.0f * (this.x * this.x + this.y * this.y);
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
        float _buf0 = 2.0f * (this.x * this.z - this.y * this.w);
        float _buf1 = 2.0f * (this.x * this.w + this.y * this.z);
        d.z = 1.0f - 2.0f * (this.x * this.x + this.y * this.y);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invPositiveX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t14 * _t20;
            d.y = _t11 * _t20;
            d.z = _t12 * _t20;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t14 * _t20;
            d.y = _t11 * _t20;
            d.z = _t12 * _t20;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invPositiveY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t11 * _t20;
            d.y = _t14 * _t20;
            d.z = _t12 * _t20;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t11 * _t20;
            d.y = _t14 * _t20;
            d.z = _t12 * _t20;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 invPositiveZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t12 * _t20;
            d.y = _t11 * _t20;
            d.z = _t14 * _t20;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 invPositiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t12 * _t20;
            d.y = _t11 * _t20;
            d.z = _t14 * _t20;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
    }


    /**
     * Compute the length of this quaternion.
     *
     * @return the length of this quaternion
     */
    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }


    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }


    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat log(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t7 = _t5 + this.w * this.w;
        float _t11 = (float) Math.acos(this.w * (1.0f / (float) Math.sqrt(_t7))) * (1.0f / (float) Math.sqrt(_t5));
        if (_t5 > 0.0f) {
            d.x = this.x * _t11;
            d.y = this.y * _t11;
            d.z = this.z * _t11;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.log((float) Math.sqrt(_t7));
        return d;
    }


    /**
     * Compute the natural logarithm of this quaternion and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat log(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t7 = _t5 + this.w * this.w;
        float _t11 = (float) Math.acos(this.w * (1.0f / (float) Math.sqrt(_t7))) * (1.0f / (float) Math.sqrt(_t5));
        if (_t5 > 0.0f) {
            d.x = this.x * _t11;
            d.y = this.y * _t11;
            d.z = this.z * _t11;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.log((float) Math.sqrt(_t7));
        return d;
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negativeX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t14 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t12 * _t20);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t14 * _t20);
            d.y = -(_t11 * _t20);
            d.z = -(_t12 * _t20);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negativeY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t11 * _t20);
            d.y = -(_t14 * _t20);
            d.z = -(_t12 * _t20);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t11 * _t20);
            d.y = -(_t14 * _t20);
            d.z = -(_t12 * _t20);
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negativeZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t11 * _t20);
            d.y = -(_t12 * _t20);
            d.z = -(_t14 * _t20);
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negativeZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = -(_t11 * _t20);
            d.y = -(_t12 * _t20);
            d.z = -(_t14 * _t20);
        } else {
            d.x = -0.0f;
            d.y = -0.0f;
            d.z = -0.0f;
        }
        return d;
    }


    /**
     * Normalize this quaternion to unit length and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat normalize(@Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        float _t7 = (1.0f / (float) Math.sqrt(_t6));
        if (_t6 > 0.0f) {
            d.x = this.x * _t7;
            d.y = this.y * _t7;
            d.z = this.z * _t7;
            d.w = this.w * _t7;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat normalize(@Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        float _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        float _t7 = (1.0f / (float) Math.sqrt(_t6));
        if (_t6 > 0.0f) {
            d.x = this.x * _t7;
            d.y = this.y * _t7;
            d.z = this.z * _t7;
            d.w = this.w * _t7;
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
        float _buf0 = 2.0f * (this.y * this.y + this.z * this.z) - 1.0f;
        float _buf1 = -(2.0f * (this.x * this.y + this.z * this.w));
        d.z = -(2.0f * (this.x * this.z - this.y * this.w));
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
        float _buf0 = 2.0f * (this.y * this.y + this.z * this.z) - 1.0f;
        float _buf1 = -(2.0f * (this.x * this.y + this.z * this.w));
        d.z = -(2.0f * (this.x * this.z - this.y * this.w));
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
        float _buf0 = -(2.0f * (this.x * this.y - this.z * this.w));
        float _buf1 = 2.0f * (this.x * this.x + this.z * this.z) - 1.0f;
        d.z = -(2.0f * (this.x * this.w + this.y * this.z));
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
        float _buf0 = -(2.0f * (this.x * this.y - this.z * this.w));
        float _buf1 = 2.0f * (this.x * this.x + this.z * this.z) - 1.0f;
        d.z = -(2.0f * (this.x * this.w + this.y * this.z));
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
        float _buf0 = -(2.0f * (this.x * this.z + this.y * this.w));
        float _buf1 = -(2.0f * (this.y * this.z - this.x * this.w));
        d.z = 2.0f * (this.x * this.x + this.y * this.y) - 1.0f;
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
        float _buf0 = -(2.0f * (this.x * this.z + this.y * this.w));
        float _buf1 = -(2.0f * (this.y * this.z - this.x * this.w));
        d.z = 2.0f * (this.x * this.x + this.y * this.y) - 1.0f;
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
        float _buf0 = 1.0f - 2.0f * (this.y * this.y + this.z * this.z);
        float _buf1 = 2.0f * (this.x * this.y + this.z * this.w);
        d.z = 2.0f * (this.x * this.z - this.y * this.w);
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
        float _buf0 = 1.0f - 2.0f * (this.y * this.y + this.z * this.z);
        float _buf1 = 2.0f * (this.x * this.y + this.z * this.w);
        d.z = 2.0f * (this.x * this.z - this.y * this.w);
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
        float _buf0 = 2.0f * (this.x * this.y - this.z * this.w);
        float _buf1 = 1.0f - 2.0f * (this.x * this.x + this.z * this.z);
        d.z = 2.0f * (this.x * this.w + this.y * this.z);
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
        float _buf0 = 2.0f * (this.x * this.y - this.z * this.w);
        float _buf1 = 1.0f - 2.0f * (this.x * this.x + this.z * this.z);
        d.z = 2.0f * (this.x * this.w + this.y * this.z);
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
        float _buf0 = 2.0f * (this.x * this.z + this.y * this.w);
        float _buf1 = 2.0f * (this.y * this.z - this.x * this.w);
        d.z = 1.0f - 2.0f * (this.x * this.x + this.y * this.y);
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
        float _buf0 = 2.0f * (this.x * this.z + this.y * this.w);
        float _buf1 = 2.0f * (this.y * this.z - this.x * this.w);
        d.z = 1.0f - 2.0f * (this.x * this.x + this.y * this.y);
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 positiveX(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t14 * _t20;
            d.y = _t11 * _t20;
            d.z = _t12 * _t20;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveX(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y + this.z * this.w);
        float _t12 = 2.0f * (this.x * this.z - this.y * this.w);
        float _t14 = this.x * this.x + this.w * this.w - this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t14 * _t20;
            d.y = _t11 * _t20;
            d.z = _t12 * _t20;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 positiveY(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t11 * _t20;
            d.y = _t14 * _t20;
            d.z = _t12 * _t20;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveY(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.y - this.z * this.w);
        float _t12 = 2.0f * (this.x * this.w + this.y * this.z);
        float _t14 = this.w * this.w - this.x * this.x + this.y * this.y - this.z * this.z;
        float _t19 = _t14 * _t14 + _t11 * _t11 + _t12 * _t12;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t11 * _t20;
            d.y = _t14 * _t20;
            d.z = _t12 * _t20;
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
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 positiveZ(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t11 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t11 * _t20;
            d.y = _t12 * _t20;
            d.z = _t14 * _t20;
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
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 positiveZ(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t11 = 2.0f * (this.x * this.z + this.y * this.w);
        float _t12 = 2.0f * (this.y * this.z - this.x * this.w);
        float _t14 = this.w * this.w - this.x * this.x - this.y * this.y + this.z * this.z;
        float _t19 = _t11 * _t11 + _t12 * _t12 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t11 * _t20;
            d.y = _t12 * _t20;
            d.z = _t14 * _t20;
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
     *
     * @param t the exponent
     * @param dest will hold the result
     * @return dest
     */
    public FloatQuat pow(float t, @Mutated FloatQuat dest) {
        FloatQuatImpl d = (FloatQuatImpl) dest;
        float _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t7 = _t5 + this.w * this.w;
        float _t14 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t7)));
        float _t15 = (float) Math.acos(this.w * (1.0f / (float) Math.sqrt(_t7))) * (1.0f / (float) Math.sqrt(_t5));
        float _t22, _t23, _t24;
        if (_t5 > 0.0f) {
            _t22 = t * this.x * _t15;
            _t23 = t * this.y * _t15;
            _t24 = t * this.z * _t15;
        } else {
            _t22 = t * 0.0f;
            _t23 = t * 0.0f;
            _t24 = t * 0.0f;
        }
        float _t29 = _t22 * _t22 + _t23 * _t23 + _t24 * _t24;
        float _t30 = (float) Math.sqrt(_t29);
        float _t34 = (float) Math.sin(_t30) * _t14 * (1.0f / (float) Math.sqrt(_t29));
        if (_t29 > 0.0f) {
            d.x = _t22 * _t34;
            d.y = _t23 * _t34;
            d.z = _t24 * _t34;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t30) * _t14;
        return d;
    }


    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))} and
     * store the result in {@code dest}.
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
        float _t5 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t7 = _t5 + this.w * this.w;
        float _t14 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t7)));
        float _t15 = (float) Math.acos(this.w * (1.0f / (float) Math.sqrt(_t7))) * (1.0f / (float) Math.sqrt(_t5));
        float _t22, _t23, _t24;
        if (_t5 > 0.0f) {
            _t22 = t * this.x * _t15;
            _t23 = t * this.y * _t15;
            _t24 = t * this.z * _t15;
        } else {
            _t22 = t * 0.0f;
            _t23 = t * 0.0f;
            _t24 = t * 0.0f;
        }
        float _t29 = _t22 * _t22 + _t23 * _t23 + _t24 * _t24;
        float _t30 = (float) Math.sqrt(_t29);
        float _t34 = (float) Math.sin(_t30) * _t14 * (1.0f / (float) Math.sqrt(_t29));
        if (_t29 > 0.0f) {
            d.x = _t22 * _t34;
            d.y = _t23 * _t34;
            d.z = _t24 * _t34;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        d.w = (float) Math.cos(_t30) * _t14;
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
        float _t10 = this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW;
        float _t12 = -_t10;
        float _t14 = (float) Math.acos(Math.min(1.0f, Math.abs(_t10)));
        float _t15 = (float) Math.sin(_t14);
        float _t15_inv = 1.0f / _t15;
        float _t16 = 2.0f * _t14;
        float _t18, _t19, _t20, _t21;
        if (_t12 > 0.0f) {
            _t18 = -targetX;
            _t19 = -targetY;
            _t20 = -targetZ;
            _t21 = -targetW;
        } else {
            _t18 = targetX;
            _t19 = targetY;
            _t20 = targetZ;
            _t21 = targetW;
        }
        float _t23 = _t16 > 0.0f ? Math.min(1.0f, step / _t16) : 0.0f;
        float _t24 = 1.0f - _t23;
        float _t30 = (float) Math.sin(_t14 * _t23);
        float _t32 = (float) Math.sin(_t24 * _t14);
        float _t57, _t58, _t59, _t60;
        if (_t15 > 0.0f) {
            _t57 = (this.x * _t32 + _t30 * _t18) * _t15_inv;
            _t58 = (this.y * _t32 + _t30 * _t19) * _t15_inv;
            _t59 = (this.z * _t32 + _t30 * _t20) * _t15_inv;
            _t60 = (this.w * _t32 + _t30 * _t21) * _t15_inv;
        } else {
            _t57 = this.x * _t24 + _t18 * _t23;
            _t58 = this.y * _t24 + _t19 * _t23;
            _t59 = this.z * _t24 + _t20 * _t23;
            _t60 = this.w * _t24 + _t21 * _t23;
        }
        float _t67 = _t57 * _t57 + _t58 * _t58 + _t59 * _t59 + _t60 * _t60;
        float _t68 = (1.0f / (float) Math.sqrt(_t67));
        if (_t67 > 0.0f) {
            d.x = _t68 * _t57;
            d.y = _t68 * _t58;
            d.z = _t68 * _t59;
            d.w = _t68 * _t60;
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
        float _t10 = this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW;
        float _t12 = -_t10;
        float _t14 = (float) Math.acos(Math.min(1.0f, Math.abs(_t10)));
        float _t15 = (float) Math.sin(_t14);
        float _t15_inv = 1.0f / _t15;
        float _t16 = 2.0f * _t14;
        float _t18, _t19, _t20, _t21;
        if (_t12 > 0.0f) {
            _t18 = -targetX;
            _t19 = -targetY;
            _t20 = -targetZ;
            _t21 = -targetW;
        } else {
            _t18 = targetX;
            _t19 = targetY;
            _t20 = targetZ;
            _t21 = targetW;
        }
        float _t23 = _t16 > 0.0f ? Math.min(1.0f, step / _t16) : 0.0f;
        float _t24 = 1.0f - _t23;
        float _t30 = (float) Math.sin(_t14 * _t23);
        float _t32 = (float) Math.sin(_t24 * _t14);
        float _t57, _t58, _t59, _t60;
        if (_t15 > 0.0f) {
            _t57 = (this.x * _t32 + _t30 * _t18) * _t15_inv;
            _t58 = (this.y * _t32 + _t30 * _t19) * _t15_inv;
            _t59 = (this.z * _t32 + _t30 * _t20) * _t15_inv;
            _t60 = (this.w * _t32 + _t30 * _t21) * _t15_inv;
        } else {
            _t57 = this.x * _t24 + _t18 * _t23;
            _t58 = this.y * _t24 + _t19 * _t23;
            _t59 = this.z * _t24 + _t20 * _t23;
            _t60 = this.w * _t24 + _t21 * _t23;
        }
        float _t67 = _t57 * _t57 + _t58 * _t58 + _t59 * _t59 + _t60 * _t60;
        float _t68 = (1.0f / (float) Math.sqrt(_t67));
        if (_t67 > 0.0f) {
            d.x = _t68 * _t57;
            d.y = _t68 * _t58;
            d.z = _t68 * _t59;
            d.w = _t68 * _t60;
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
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11;
        if (_t4 > 0.0f) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 0.0f;
        }
        float _t21 = upY * _t9 - upZ * _t10;
        float _t22 = upZ * _t11 - upX * _t9;
        float _t23 = upX * _t10 - upY * _t11;
        float _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        float _t29 = (1.0f / (float) Math.sqrt(_t28));
        float _t33, _t34, _t35;
        if (_t28 > 0.0f) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0f;
            _t34 = 0.0f;
            _t35 = 0.0f;
        }
        float _t36 = 1.0f + _t33;
        float _t37 = _t9 * _t33;
        float _t39 = _t11 * _t34;
        float _t40 = _t11 * _t35;
        float _t41 = _t10 * _t33;
        float _t42 = _t11 - _t34;
        float _t43 = _t9 * _t35;
        float _t44 = _t10 * _t34;
        float _t45 = _t11 + _t34;
        float _t55 = _t37 - _t39;
        float _t60 = Math.max(_t55, _t9);
        float _t61 = _t40 + (_t10 - _t41);
        float _t62 = _t40 + (-_t10 - _t41);
        float _t63 = _t43 + _t35 - _t44;
        float _t64 = _t44 + (_t35 - _t43);
        float _t65 = _t37 + (_t33 + _t9 - _t39);
        float _t66 = _t37 + (_t36 + _t9 - _t39);
        float _t67 = _t39 + (_t36 - _t9) - _t37;
        float _t68 = _t37 + (1.0f - _t9 - _t33 - _t39);
        float _t69 = _t39 + (1.0f + _t9 - _t33) - _t37;
        float _t71 = (1.0f / (float) Math.sqrt(_t67));
        float _t72 = (1.0f / (float) Math.sqrt(_t68));
        float _t73 = (1.0f / (float) Math.sqrt(_t69));
        float _t74 = (1.0f / (float) Math.sqrt(_t66));
        float _t114, _t115, _t116, _t117;
        if (_t65 > 0.0f) {
            _t114 = 0.5f * _t63 * _t74;
            _t115 = 0.5f * _t42 * _t74;
            _t116 = 0.5f * (float) Math.sqrt(_t66);
            _t117 = 0.5f * _t62 * _t74;
        } else {
            if (_t33 > _t60) {
                _t114 = 0.5f * _t45 * _t71;
                _t115 = 0.5f * _t64 * _t71;
                _t116 = 0.5f * _t62 * _t71;
                _t117 = 0.5f * (float) Math.sqrt(_t67);
            } else {
                if (_t55 > _t9) {
                    _t114 = 0.5f * _t61 * _t72;
                    _t115 = 0.5f * (float) Math.sqrt(_t68);
                    _t116 = 0.5f * _t42 * _t72;
                    _t117 = 0.5f * _t64 * _t72;
                } else {
                    _t114 = 0.5f * (float) Math.sqrt(_t69);
                    _t115 = 0.5f * _t61 * _t73;
                    _t116 = 0.5f * _t63 * _t73;
                    _t117 = 0.5f * _t45 * _t73;
                }
            }
        }
        float _buf0 = this.x * _t116 + this.w * _t117 + (this.y * _t114 - this.z * _t115);
        float _buf1 = this.y * _t116 + this.z * _t117 + (this.w * _t115 - this.x * _t114);
        float _buf2 = this.x * _t115 + this.w * _t114 + (this.z * _t116 - this.y * _t117);
        d.w = this.w * _t116 - this.x * _t117 - this.y * _t115 - this.z * _t114;
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
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11;
        if (_t4 > 0.0f) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 0.0f;
        }
        float _t21 = upY * _t9 - upZ * _t10;
        float _t22 = upZ * _t11 - upX * _t9;
        float _t23 = upX * _t10 - upY * _t11;
        float _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        float _t29 = (1.0f / (float) Math.sqrt(_t28));
        float _t33, _t34, _t35;
        if (_t28 > 0.0f) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0f;
            _t34 = 0.0f;
            _t35 = 0.0f;
        }
        float _t36 = 1.0f + _t33;
        float _t37 = _t9 * _t33;
        float _t39 = _t11 * _t34;
        float _t40 = _t11 * _t35;
        float _t41 = _t10 * _t33;
        float _t42 = _t11 - _t34;
        float _t43 = _t9 * _t35;
        float _t44 = _t10 * _t34;
        float _t45 = _t11 + _t34;
        float _t55 = _t37 - _t39;
        float _t60 = Math.max(_t55, _t9);
        float _t61 = _t40 + (_t10 - _t41);
        float _t62 = _t40 + (-_t10 - _t41);
        float _t63 = _t43 + _t35 - _t44;
        float _t64 = _t44 + (_t35 - _t43);
        float _t65 = _t37 + (_t33 + _t9 - _t39);
        float _t66 = _t37 + (_t36 + _t9 - _t39);
        float _t67 = _t39 + (_t36 - _t9) - _t37;
        float _t68 = _t37 + (1.0f - _t9 - _t33 - _t39);
        float _t69 = _t39 + (1.0f + _t9 - _t33) - _t37;
        float _t71 = (1.0f / (float) Math.sqrt(_t67));
        float _t72 = (1.0f / (float) Math.sqrt(_t68));
        float _t73 = (1.0f / (float) Math.sqrt(_t69));
        float _t74 = (1.0f / (float) Math.sqrt(_t66));
        float _t114, _t115, _t116, _t117;
        if (_t65 > 0.0f) {
            _t114 = 0.5f * _t63 * _t74;
            _t115 = 0.5f * _t42 * _t74;
            _t116 = 0.5f * (float) Math.sqrt(_t66);
            _t117 = 0.5f * _t62 * _t74;
        } else {
            if (_t33 > _t60) {
                _t114 = 0.5f * _t45 * _t71;
                _t115 = 0.5f * _t64 * _t71;
                _t116 = 0.5f * _t62 * _t71;
                _t117 = 0.5f * (float) Math.sqrt(_t67);
            } else {
                if (_t55 > _t9) {
                    _t114 = 0.5f * _t61 * _t72;
                    _t115 = 0.5f * (float) Math.sqrt(_t68);
                    _t116 = 0.5f * _t42 * _t72;
                    _t117 = 0.5f * _t64 * _t72;
                } else {
                    _t114 = 0.5f * (float) Math.sqrt(_t69);
                    _t115 = 0.5f * _t61 * _t73;
                    _t116 = 0.5f * _t63 * _t73;
                    _t117 = 0.5f * _t45 * _t73;
                }
            }
        }
        float _buf0 = this.x * _t116 + this.w * _t117 + (this.y * _t114 - this.z * _t115);
        float _buf1 = this.y * _t116 + this.z * _t117 + (this.w * _t115 - this.x * _t114);
        float _buf2 = this.x * _t115 + this.w * _t114 + (this.z * _t116 - this.y * _t117);
        d.w = this.w * _t116 - this.x * _t117 - this.y * _t115 - this.z * _t114;
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
        float _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t9, _t10, _t11;
        if (_t4 > 0.0f) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0f;
            _t10 = 0.0f;
            _t11 = 0.0f;
        }
        float _t21 = upY * _t9 - upZ * _t10;
        float _t22 = upZ * _t11 - upX * _t9;
        float _t23 = upX * _t10 - upY * _t11;
        float _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        float _t29 = (1.0f / (float) Math.sqrt(_t28));
        float _t33, _t34, _t35;
        if (_t28 > 0.0f) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0f;
            _t34 = 0.0f;
            _t35 = 0.0f;
        }
        float _t36 = 1.0f + _t33;
        float _t37 = _t9 * _t33;
        float _t39 = _t11 * _t34;
        float _t40 = _t11 * _t35;
        float _t41 = _t10 * _t33;
        float _t42 = _t10 * _t34;
        float _t43 = _t9 * _t35;
        float _t44 = _t11 + _t34;
        float _t45 = _t11 - _t34;
        float _t55 = _t37 - _t39;
        float _t60 = Math.max(_t55, _t9);
        float _t61 = _t40 + (_t10 - _t41);
        float _t62 = _t40 + (-_t10 - _t41);
        float _t63 = _t42 + (_t35 - _t43);
        float _t64 = _t43 + _t35 - _t42;
        float _t65 = _t37 + (_t33 + _t9 - _t39);
        float _t66 = _t37 + (_t36 + _t9 - _t39);
        float _t67 = _t39 + (_t36 - _t9) - _t37;
        float _t68 = _t37 + (1.0f - _t9 - _t33 - _t39);
        float _t69 = _t39 + (1.0f + _t9 - _t33) - _t37;
        float _t70 = (1.0f / (float) Math.sqrt(_t66));
        float _t71 = (1.0f / (float) Math.sqrt(_t68));
        float _t72 = (1.0f / (float) Math.sqrt(_t69));
        float _t73 = (1.0f / (float) Math.sqrt(_t67));
        if (_t65 > 0.0f) {
            this.x = 0.5f * _t62 * _t70;
            this.y = 0.5f * _t45 * _t70;
            this.z = 0.5f * _t64 * _t70;
            this.w = 0.5f * (float) Math.sqrt(_t66);
        } else {
            if (_t33 > _t60) {
                this.x = 0.5f * (float) Math.sqrt(_t67);
                this.y = 0.5f * _t63 * _t73;
                this.z = 0.5f * _t44 * _t73;
                this.w = 0.5f * _t62 * _t73;
            } else {
                if (_t55 > _t9) {
                    this.x = 0.5f * _t63 * _t71;
                    this.y = 0.5f * (float) Math.sqrt(_t68);
                    this.z = 0.5f * _t61 * _t71;
                    this.w = 0.5f * _t45 * _t71;
                } else {
                    this.x = 0.5f * _t44 * _t72;
                    this.y = 0.5f * _t61 * _t72;
                    this.z = 0.5f * (float) Math.sqrt(_t69);
                    this.w = 0.5f * _t64 * _t72;
                }
            }
        }
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
    public @Mutated FloatQuat makeRotationTo(Float3R fromDir, Float3R toDir) {
        return makeRotationTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
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
    @Mutated public FloatQuat makeRotationTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float _t8 = fromDirX * fromDirX + fromDirY * fromDirY;
        float _t10, _t11, _t12;
        if (_t8 > 0.0f) {
            _t10 = fromDirY;
            _t11 = 0.0f;
            _t12 = -fromDirX;
        } else {
            _t10 = 0.0f;
            _t11 = -fromDirY;
            _t12 = fromDirZ;
        }
        float _t13 = fromDirX * toDirX + (fromDirY * toDirY + (fromDirZ * toDirZ + 1.0f));
        float _t14 = 2.0f * _t13;
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        float _t20 = _t10 * _t10 + _t12 * _t12 + _t11 * _t11;
        float _t21 = (1.0f / (float) Math.sqrt(_t20));
        if (_t13 > 1.0E-6f) {
            this.x = (fromDirY * toDirZ - fromDirZ * toDirY) * _t15;
            this.y = (fromDirZ * toDirX - fromDirX * toDirZ) * _t15;
            this.z = (fromDirX * toDirY - fromDirY * toDirX) * _t15;
            this.w = 0.5f * (float) Math.sqrt(_t14);
        } else {
            if (_t20 > 0.0f) {
                this.x = _t21 * _t10;
                this.y = _t21 * _t12;
                this.z = _t21 * _t11;
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
        this.x = _t9 * _t5 + _t10 * _t8;
        this.y = _t10 * _t5 - _t9 * _t8;
        this.z = _t11 * _t5 + _t12 * _t8;
        this.w = _t12 * _t5 - _t11 * _t8;
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
        this.x = _t9 * _t5 - _t10 * _t8;
        this.y = _t11 * _t8 - _t12 * _t5;
        this.z = _t9 * _t8 + _t10 * _t5;
        this.w = _t12 * _t8 + _t11 * _t5;
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
        this.x = _t9 * _t5 + _t10 * _t8;
        this.y = _t10 * _t5 - _t9 * _t8;
        this.z = _t11 * _t8 - _t12 * _t5;
        this.w = _t12 * _t8 + _t11 * _t5;
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
        this.x = _t9 * _t5 + _t10 * _t8;
        this.y = _t11 * _t5 + _t12 * _t8;
        this.z = _t12 * _t5 - _t11 * _t8;
        this.w = _t10 * _t5 - _t9 * _t8;
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
        this.x = _t9 * _t5 - _t10 * _t8;
        this.y = _t11 * _t5 + _t12 * _t8;
        this.z = _t9 * _t8 + _t10 * _t5;
        this.w = _t12 * _t5 - _t11 * _t8;
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
        this.x = _t9 * _t5 - _t10 * _t8;
        this.y = _t11 * _t8 + _t12 * _t5;
        this.z = _t12 * _t8 - _t11 * _t5;
        this.w = _t10 * _t5 + _t9 * _t8;
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
        float _buf0 = this.x * _t1 + this.w * _t2;
        float _buf1 = this.y * _t1 - this.z * _t2;
        d.z = this.y * _t2 + this.z * _t1;
        d.w = this.w * _t1 - this.x * _t2;
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
        float _buf0 = this.x * _t1 + this.w * _t2;
        float _buf1 = this.y * _t1 - this.z * _t2;
        d.z = this.y * _t2 + this.z * _t1;
        d.w = this.w * _t1 - this.x * _t2;
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
        float _buf0 = this.x * _t1 + this.z * _t2;
        float _buf1 = this.y * _t1 + this.w * _t2;
        d.z = this.z * _t1 - this.x * _t2;
        d.w = this.w * _t1 - this.y * _t2;
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
        float _buf0 = this.x * _t1 + this.z * _t2;
        float _buf1 = this.y * _t1 + this.w * _t2;
        d.z = this.z * _t1 - this.x * _t2;
        d.w = this.w * _t1 - this.y * _t2;
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
        float _buf0 = this.x * _t1 - this.y * _t2;
        d.y = this.x * _t2 + this.y * _t1;
        float _buf1 = this.z * _t1 + this.w * _t2;
        d.w = this.w * _t1 - this.z * _t2;
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
        float _buf0 = this.x * _t1 - this.y * _t2;
        d.y = this.x * _t2 + this.y * _t1;
        float _buf1 = this.z * _t1 + this.w * _t2;
        d.w = this.w * _t1 - this.z * _t2;
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
        float _buf0 = this.x * _t1 + this.w * _t3 + (this.y * _t4 - this.z * _t5);
        float _buf1 = this.y * _t1 + this.z * _t3 + (this.w * _t5 - this.x * _t4);
        float _buf2 = this.x * _t5 + this.w * _t4 + (this.z * _t1 - this.y * _t3);
        d.w = this.w * _t1 - this.x * _t3 - this.y * _t5 - this.z * _t4;
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
        float _buf0 = this.x * _t1 + this.w * _t3 + (this.y * _t4 - this.z * _t5);
        float _buf1 = this.y * _t1 + this.z * _t3 + (this.w * _t5 - this.x * _t4);
        float _buf2 = this.x * _t5 + this.w * _t4 + (this.z * _t1 - this.y * _t3);
        d.w = this.w * _t1 - this.x * _t3 - this.y * _t5 - this.z * _t4;
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
        float _t15 = fromDirX * fromDirX + fromDirY * fromDirY;
        float _t19, _t20, _t21;
        if (_t15 > 0.0f) {
            _t19 = fromDirY;
            _t20 = 0.0f;
            _t21 = -fromDirX;
        } else {
            _t19 = 0.0f;
            _t20 = -fromDirY;
            _t21 = fromDirZ;
        }
        float _t22 = fromDirX * toDirX + (fromDirY * toDirY + (fromDirZ * toDirZ + 1.0f));
        float _t23 = 2.0f * _t22;
        float _t25 = (1.0f / (float) Math.sqrt(_t23));
        float _t33 = _t22 > 1.0E-6f ? 0.5f * (float) Math.sqrt(_t23) : 0.0f;
        float _t35 = _t19 * _t19 + _t21 * _t21 + _t20 * _t20;
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t43, _t44, _t45;
        if (_t22 > 1.0E-6f) {
            _t43 = (fromDirY * toDirZ - fromDirZ * toDirY) * _t25;
            _t44 = (fromDirX * toDirY - fromDirY * toDirX) * _t25;
            _t45 = (fromDirZ * toDirX - fromDirX * toDirZ) * _t25;
        } else {
            if (_t35 > 0.0f) {
                _t43 = _t36 * _t19;
                _t44 = _t36 * _t20;
                _t45 = _t36 * _t21;
            } else {
                _t43 = 0.0f;
                _t44 = 0.0f;
                _t45 = 0.0f;
            }
        }
        float _buf0 = this.x * _t33 + this.w * _t43 + (this.y * _t44 - this.z * _t45);
        float _buf1 = this.y * _t33 + this.z * _t43 + (this.w * _t45 - this.x * _t44);
        float _buf2 = this.x * _t45 + this.w * _t44 + (this.z * _t33 - this.y * _t43);
        d.w = this.w * _t33 - this.x * _t43 - this.y * _t45 - this.z * _t44;
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
        float _t15 = fromDirX * fromDirX + fromDirY * fromDirY;
        float _t19, _t20, _t21;
        if (_t15 > 0.0f) {
            _t19 = fromDirY;
            _t20 = 0.0f;
            _t21 = -fromDirX;
        } else {
            _t19 = 0.0f;
            _t20 = -fromDirY;
            _t21 = fromDirZ;
        }
        float _t22 = fromDirX * toDirX + (fromDirY * toDirY + (fromDirZ * toDirZ + 1.0f));
        float _t23 = 2.0f * _t22;
        float _t25 = (1.0f / (float) Math.sqrt(_t23));
        float _t33 = _t22 > 1.0E-6f ? 0.5f * (float) Math.sqrt(_t23) : 0.0f;
        float _t35 = _t19 * _t19 + _t21 * _t21 + _t20 * _t20;
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t43, _t44, _t45;
        if (_t22 > 1.0E-6f) {
            _t43 = (fromDirY * toDirZ - fromDirZ * toDirY) * _t25;
            _t44 = (fromDirX * toDirY - fromDirY * toDirX) * _t25;
            _t45 = (fromDirZ * toDirX - fromDirX * toDirZ) * _t25;
        } else {
            if (_t35 > 0.0f) {
                _t43 = _t36 * _t19;
                _t44 = _t36 * _t20;
                _t45 = _t36 * _t21;
            } else {
                _t43 = 0.0f;
                _t44 = 0.0f;
                _t45 = 0.0f;
            }
        }
        float _buf0 = this.x * _t33 + this.w * _t43 + (this.y * _t44 - this.z * _t45);
        float _buf1 = this.y * _t33 + this.z * _t43 + (this.w * _t45 - this.x * _t44);
        float _buf2 = this.x * _t45 + this.w * _t44 + (this.z * _t33 - this.y * _t43);
        d.w = this.w * _t33 - this.x * _t43 - this.y * _t45 - this.z * _t44;
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
        float _buf0 = this.x * _t1 + this.w * _t2;
        float _buf1 = this.y * _t1 + this.z * _t2;
        d.z = this.z * _t1 - this.y * _t2;
        d.w = this.w * _t1 - this.x * _t2;
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
        float _buf0 = this.x * _t1 + this.w * _t2;
        float _buf1 = this.y * _t1 + this.z * _t2;
        d.z = this.z * _t1 - this.y * _t2;
        d.w = this.w * _t1 - this.x * _t2;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 + _t12 * _t8;
        float _t23 = _t10 * _t5 + _t9 * _t8;
        float _t24 = _t12 * _t5 - _t11 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 + _t12 * _t8;
        float _t23 = _t10 * _t5 + _t9 * _t8;
        float _t24 = _t12 * _t5 - _t11 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 - _t12 * _t5;
        float _t23 = _t11 * _t5 + _t12 * _t8;
        float _t24 = _t10 * _t5 - _t9 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 - _t12 * _t5;
        float _t23 = _t11 * _t5 + _t12 * _t8;
        float _t24 = _t10 * _t5 - _t9 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _buf0 = this.x * _t1 - this.z * _t2;
        float _buf1 = this.y * _t1 + this.w * _t2;
        d.z = this.x * _t2 + this.z * _t1;
        d.w = this.w * _t1 - this.y * _t2;
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
        float _buf0 = this.x * _t1 - this.z * _t2;
        float _buf1 = this.y * _t1 + this.w * _t2;
        d.z = this.x * _t2 + this.z * _t1;
        d.w = this.w * _t1 - this.y * _t2;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 + _t12 * _t5;
        float _t23 = _t10 * _t5 - _t9 * _t8;
        float _t24 = _t12 * _t8 - _t11 * _t5;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t11 * _t8 + _t12 * _t5;
        float _t23 = _t10 * _t5 - _t9 * _t8;
        float _t24 = _t12 * _t8 - _t11 * _t5;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t10 * _t5 + _t9 * _t8;
        float _t23 = _t11 * _t5 - _t12 * _t8;
        float _t24 = _t12 * _t5 + _t11 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t10 * _t5 + _t9 * _t8;
        float _t23 = _t11 * _t5 - _t12 * _t8;
        float _t24 = _t12 * _t5 + _t11 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _buf0 = this.x * _t1 + this.y * _t2;
        d.y = this.y * _t1 - this.x * _t2;
        float _buf1 = this.z * _t1 + this.w * _t2;
        d.w = this.w * _t1 - this.z * _t2;
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
        float _buf0 = this.x * _t1 + this.y * _t2;
        d.y = this.y * _t1 - this.x * _t2;
        float _buf1 = this.z * _t1 + this.w * _t2;
        d.w = this.w * _t1 - this.z * _t2;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 - _t12 * _t8;
        float _t23 = _t11 * _t8 + _t12 * _t5;
        float _t24 = _t10 * _t5 + _t9 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 - _t10 * _t8;
        float _t22 = _t11 * _t5 - _t12 * _t8;
        float _t23 = _t11 * _t8 + _t12 * _t5;
        float _t24 = _t10 * _t5 + _t9 * _t8;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t10 * _t5 - _t9 * _t8;
        float _t23 = _t11 * _t8 - _t12 * _t5;
        float _t24 = _t12 * _t8 + _t11 * _t5;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t21 = _t9 * _t5 + _t10 * _t8;
        float _t22 = _t10 * _t5 - _t9 * _t8;
        float _t23 = _t11 * _t8 - _t12 * _t5;
        float _t24 = _t12 * _t8 + _t11 * _t5;
        float _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        float _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        float _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
        d.w = this.w * _t21 - this.x * _t22 - this.y * _t24 - this.z * _t23;
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
        float _t9 = 2.0f * (this.x * vY - this.y * vX);
        float _t10 = 2.0f * (this.y * vZ - this.z * vY);
        float _t11 = 2.0f * (this.z * vX - this.x * vZ);
        float _buf0 = this.y * _t9 + (this.w * _t10 + vX - this.z * _t11);
        float _buf1 = this.z * _t10 + (this.w * _t11 + vY - this.x * _t9);
        d.z = this.x * _t11 + (this.w * _t9 + vZ - this.y * _t10);
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
        float _t9 = 2.0f * (this.x * vY - this.y * vX);
        float _t10 = 2.0f * (this.y * vZ - this.z * vY);
        float _t11 = 2.0f * (this.z * vX - this.x * vZ);
        float _buf0 = this.y * _t9 + (this.w * _t10 + vX - this.z * _t11);
        float _buf1 = this.z * _t10 + (this.w * _t11 + vY - this.x * _t9);
        d.z = this.x * _t11 + (this.w * _t9 + vZ - this.y * _t10);
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
        float _t9 = 2.0f * (this.x * vZ - this.z * vX);
        float _t10 = 2.0f * (this.z * vY - this.y * vZ);
        float _t11 = 2.0f * (this.y * vX - this.x * vY);
        float _buf0 = this.z * _t9 + (this.w * _t10 + vX - this.y * _t11);
        float _buf1 = this.x * _t11 + (this.w * _t9 + vY - this.z * _t10);
        d.z = this.y * _t10 + (this.w * _t11 + vZ - this.x * _t9);
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
        float _t9 = 2.0f * (this.x * vZ - this.z * vX);
        float _t10 = 2.0f * (this.z * vY - this.y * vZ);
        float _t11 = 2.0f * (this.y * vX - this.x * vY);
        float _buf0 = this.z * _t9 + (this.w * _t10 + vX - this.y * _t11);
        float _buf1 = this.x * _t11 + (this.w * _t9 + vY - this.z * _t10);
        d.z = this.y * _t10 + (this.w * _t11 + vZ - this.x * _t9);
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
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public FloatQuat load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
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
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatQuat loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
