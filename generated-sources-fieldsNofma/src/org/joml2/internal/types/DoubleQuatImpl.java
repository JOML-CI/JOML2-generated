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
     * @param other the other quaternion
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
        double _t27 = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
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
     * @param other the other quaternion
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
     * @param other the other quaternion
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
     * Set this quaternion to the given values.
     *
     * @param v the quaternion
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
     * @param dq the dual quaternion
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


    /**
     * Set this quaternion to the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return this
     */
    @Mutated public DoubleQuat makeFromMatrix(Double3x3R m) {
        double _t0 = m.m00() + m.m11();
        double _t1 = m.m21() - m.m12();
        double _t2 = Math.max(m.m11(), m.m22());
        double _t4 = m.m01() + m.m10();
        double _t6 = m.m02() + m.m20();
        double _t7 = m.m02() - m.m20();
        double _t8 = m.m12() + m.m21();
        double _t9 = m.m10() - m.m01();
        double _t10 = m.m22() + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (m.m00() - (m.m11() + m.m22()));
        double _t16 = 1.0 + (m.m11() - (m.m00() + m.m22()));
        double _t17 = 1.0 + (m.m22() - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            this.x = 0.5 * _t1 * _t18;
            this.y = 0.5 * _t7 * _t18;
            this.z = 0.5 * _t9 * _t18;
            this.w = 0.5 * Math.sqrt(_t14);
        } else {
            if (m.m00() > _t2) {
                this.x = 0.5 * Math.sqrt(_t15);
                this.y = 0.5 * _t4 * _t21;
                this.z = 0.5 * _t6 * _t21;
                this.w = 0.5 * _t1 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.x = 0.5 * _t4 * _t19;
                    this.y = 0.5 * Math.sqrt(_t16);
                    this.z = 0.5 * _t8 * _t19;
                    this.w = 0.5 * _t7 * _t19;
                } else {
                    this.x = 0.5 * _t6 * _t20;
                    this.y = 0.5 * _t8 * _t20;
                    this.z = 0.5 * Math.sqrt(_t17);
                    this.w = 0.5 * _t9 * _t20;
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
    @Mutated public DoubleQuat makeFromMatrix(Double3x4R m) {
        double _t0 = m.m00() + m.m11();
        double _t1 = m.m21() - m.m12();
        double _t2 = Math.max(m.m11(), m.m22());
        double _t4 = m.m01() + m.m10();
        double _t6 = m.m02() + m.m20();
        double _t7 = m.m02() - m.m20();
        double _t8 = m.m12() + m.m21();
        double _t9 = m.m10() - m.m01();
        double _t10 = m.m22() + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (m.m00() - (m.m11() + m.m22()));
        double _t16 = 1.0 + (m.m11() - (m.m00() + m.m22()));
        double _t17 = 1.0 + (m.m22() - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            this.x = 0.5 * _t1 * _t18;
            this.y = 0.5 * _t7 * _t18;
            this.z = 0.5 * _t9 * _t18;
            this.w = 0.5 * Math.sqrt(_t14);
        } else {
            if (m.m00() > _t2) {
                this.x = 0.5 * Math.sqrt(_t15);
                this.y = 0.5 * _t4 * _t21;
                this.z = 0.5 * _t6 * _t21;
                this.w = 0.5 * _t1 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.x = 0.5 * _t4 * _t19;
                    this.y = 0.5 * Math.sqrt(_t16);
                    this.z = 0.5 * _t8 * _t19;
                    this.w = 0.5 * _t7 * _t19;
                } else {
                    this.x = 0.5 * _t6 * _t20;
                    this.y = 0.5 * _t8 * _t20;
                    this.z = 0.5 * Math.sqrt(_t17);
                    this.w = 0.5 * _t9 * _t20;
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
    @Mutated public DoubleQuat makeFromMatrix(Double4x4R m) {
        double _t0 = m.m00() + m.m11();
        double _t1 = m.m21() - m.m12();
        double _t2 = Math.max(m.m11(), m.m22());
        double _t4 = m.m01() + m.m10();
        double _t6 = m.m02() + m.m20();
        double _t7 = m.m02() - m.m20();
        double _t8 = m.m12() + m.m21();
        double _t9 = m.m10() - m.m01();
        double _t10 = m.m22() + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (m.m00() - (m.m11() + m.m22()));
        double _t16 = 1.0 + (m.m11() - (m.m00() + m.m22()));
        double _t17 = 1.0 + (m.m22() - _t0);
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            this.x = 0.5 * _t1 * _t18;
            this.y = 0.5 * _t7 * _t18;
            this.z = 0.5 * _t9 * _t18;
            this.w = 0.5 * Math.sqrt(_t14);
        } else {
            if (m.m00() > _t2) {
                this.x = 0.5 * Math.sqrt(_t15);
                this.y = 0.5 * _t4 * _t21;
                this.z = 0.5 * _t6 * _t21;
                this.w = 0.5 * _t1 * _t21;
            } else {
                if (m.m11() > m.m22()) {
                    this.x = 0.5 * _t4 * _t19;
                    this.y = 0.5 * Math.sqrt(_t16);
                    this.z = 0.5 * _t8 * _t19;
                    this.w = 0.5 * _t7 * _t19;
                } else {
                    this.x = 0.5 * _t6 * _t20;
                    this.y = 0.5 * _t8 * _t20;
                    this.z = 0.5 * Math.sqrt(_t17);
                    this.w = 0.5 * _t9 * _t20;
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
     *
     * @param other the other quaternion
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
        if (_t18 > 0.0) {
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
        if (_t34 > 0.0) {
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
        double _t10 = Math.acos(Math.min(1.0, Math.max(-1.0, this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW)));
        double _t11 = Math.sin(_t10);
        double _t11_inv = 1.0 / _t11;
        double _t12 = Math.abs(_t11);
        double _t14 = Math.sin(alpha * _t10);
        double _t16 = Math.sin(_t0 * _t10);
        if (_t12 > 1.0E-6) {
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
    public DoubleQuat slerpShortest(DoubleQuatR target, double alpha, @Mutated DoubleQuat dest) {
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
    public DoubleQuat slerpShortest(double targetX, double targetY, double targetZ, double targetW, double alpha, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 1.0 - alpha;
        double _t15 = this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW;
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
        double _t53, _t54, _t55, _t56;
        if (_t20 > 0.0) {
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
        double _t63 = _t53 * _t53 + _t54 * _t54 + _t55 * _t55 + _t56 * _t56;
        double _t64 = (1.0 / Math.sqrt(_t63));
        if (_t63 > 0.0) {
            d.x = _t64 * _t53;
            d.y = _t64 * _t54;
            d.z = _t64 * _t55;
            d.w = _t64 * _t56;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
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
    public DoubleQuat squad(DoubleQuatR control0, DoubleQuatR control1, DoubleQuatR target, double t, @Mutated DoubleQuat dest) {
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
    public DoubleQuat squad(double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 1.0 - t;
        double _t26 = _t0 * 2.0 * t;
        double _t27 = 1.0 - _t26;
        double _t46 = Math.acos(Math.min(1.0, Math.max(-1.0, control0X * control1X + control0Y * control1Y + control0Z * control1Z + control0W * control1W)));
        double _t47 = Math.acos(Math.min(1.0, Math.max(-1.0, this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW)));
        double _t48 = Math.sin(_t46);
        double _t48_inv = 1.0 / _t48;
        double _t49 = Math.sin(_t47);
        double _t49_inv = 1.0 / _t49;
        double _t50 = Math.abs(_t48);
        double _t52 = Math.abs(_t49);
        double _t54 = Math.sin(t * _t46);
        double _t55 = Math.sin(t * _t47);
        double _t58 = Math.sin(_t0 * _t46);
        double _t59 = Math.sin(_t0 * _t47);
        double _t92, _t94, _t96, _t98;
        if (_t50 > 1.0E-6) {
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
        double _t93, _t95, _t97, _t99;
        if (_t52 > 1.0E-6) {
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
        double _t109 = Math.acos(Math.min(1.0, Math.max(-1.0, _t92 * _t93 + _t94 * _t95 + _t96 * _t97 + _t98 * _t99)));
        double _t110 = Math.sin(_t109);
        double _t110_inv = 1.0 / _t110;
        double _t111 = Math.abs(_t110);
        double _t113 = Math.sin(_t26 * _t109);
        double _t115 = Math.sin(_t27 * _t109);
        if (_t111 > 1.0E-6) {
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
        d.w = otherW * this.w - otherX * this.x - otherY * this.y - otherZ * this.z;
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
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
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
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
     * @param q the quaternion
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
        double _t27 = qW * this.w - qX * this.x - qY * this.y - qZ * this.z;
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
        double _t6 = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        double _t6_inv = 1.0 / _t6;
        double _buf0 = (otherX * this.w - otherW * this.x + (otherY * this.z - otherZ * this.y)) * _t6_inv;
        double _buf1 = -(otherW * this.y * _t6_inv) - otherX * this.z * _t6_inv + (otherY * this.w + otherZ * this.x) * _t6_inv;
        double _buf2 = (otherX * this.y - otherW * this.z + (otherZ * this.w - otherY * this.x)) * _t6_inv;
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
        double _t10 = Math.sin(_t6) * _t0 * (1.0 / Math.sqrt(_t5));
        if (_t5 > 0.0) {
            d.x = this.x * _t10;
            d.y = this.y * _t10;
            d.z = this.z * _t10;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        d.w = Math.cos(_t6) * _t0;
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
     * {@code double} resolution over its whole range, down to 0.
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
        double _t11 = Math.cos(_t9);
        double _t13 = Math.sin(_t9) * (1.0 / Math.sqrt(_t8));
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
        double _buf0 = this.x * _t11 + this.w * _t17 + (this.z * _t18 - this.y * _t19);
        double _buf1 = this.x * _t19 + this.w * _t18 + (this.y * _t11 - this.z * _t17);
        double _buf2 = this.y * _t17 + this.z * _t11 + (this.w * _t19 - this.x * _t18);
        d.w = this.w * _t11 - this.x * _t17 - this.y * _t18 - this.z * _t19;
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t6 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        if (_t19 > 0.0) {
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
        double _t33 = Math.sin(_t29) * _t13 * (1.0 / Math.sqrt(_t28));
        if (_t28 > 0.0) {
            d.x = _t21 * _t33;
            d.y = _t22 * _t33;
            d.z = _t23 * _t33;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        d.w = Math.cos(_t29) * _t13;
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
     *
     * @param target the target rotation
     * @param step the maximum rotation angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public DoubleQuat rotateTowards(DoubleQuatR target, double step, @Mutated DoubleQuat dest) {
        return rotateTowards(target.x(), target.y(), target.z(), target.w(), step, dest);
    }


    /**
     * Rotate this quaternion towards ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}), by at most the given maximum angle and store the result in {@code dest}.
     * <p>
     * The rotation angle is recovered with {@code atan2}, so it keeps full {@code double}
     * resolution down to 0 - small rotations are not truncated.
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
        double _t10 = this.x * targetX + this.y * targetY + this.z * targetZ + this.w * targetW;
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
        double _t20 = this.x - _t16;
        double _t21 = this.y - _t17;
        double _t22 = this.z - _t18;
        double _t23 = this.w - _t19;
        double _t24 = this.x + _t16;
        double _t25 = this.y + _t17;
        double _t26 = this.z + _t18;
        double _t27 = this.w + _t19;
        double _t45 = 4.0 * Math.atan2(Math.sqrt(_t20 * _t20 + _t21 * _t21 + _t22 * _t22 + _t23 * _t23), Math.sqrt(_t24 * _t24 + _t25 * _t25 + _t26 * _t26 + _t27 * _t27));
        double _t48 = _t45 > 0.0 ? Math.min(1.0, step / _t45) : 0.0;
        double _t49 = 1.0 - _t48;
        double _t55 = Math.sin(_t14 * _t48);
        double _t57 = Math.sin(_t49 * _t14);
        double _t82, _t83, _t84, _t85;
        if (_t15 > 0.0) {
            _t82 = (this.x * _t57 + _t55 * _t16) * _t15_inv;
            _t83 = (this.y * _t57 + _t55 * _t17) * _t15_inv;
            _t84 = (this.z * _t57 + _t55 * _t18) * _t15_inv;
            _t85 = (this.w * _t57 + _t55 * _t19) * _t15_inv;
        } else {
            _t82 = this.x * _t49 + _t16 * _t48;
            _t83 = this.y * _t49 + _t17 * _t48;
            _t84 = this.z * _t49 + _t18 * _t48;
            _t85 = this.w * _t49 + _t19 * _t48;
        }
        double _t92 = _t82 * _t82 + _t83 * _t83 + _t84 * _t84 + _t85 * _t85;
        double _t93 = (1.0 / Math.sqrt(_t92));
        if (_t92 > 0.0) {
            d.x = _t93 * _t82;
            d.y = _t93 * _t83;
            d.z = _t93 * _t84;
            d.w = _t93 * _t85;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
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
    public DoubleQuat lookAlong(Double3R dir, Double3R up, @Mutated DoubleQuat dest) {
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
    public DoubleQuat lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t9, _t10, _t11;
        if (_t4 > 0.0) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0;
            _t10 = 0.0;
            _t11 = 0.0;
        }
        double _t21 = upY * _t9 - upZ * _t10;
        double _t22 = upZ * _t11 - upX * _t9;
        double _t23 = upX * _t10 - upY * _t11;
        double _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        double _t29 = (1.0 / Math.sqrt(_t28));
        double _t33, _t34, _t35;
        if (_t28 > 0.0) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0;
            _t34 = 0.0;
            _t35 = 0.0;
        }
        double _t36 = 1.0 + _t33;
        double _t37 = _t9 * _t33;
        double _t39 = _t11 * _t34;
        double _t40 = _t11 * _t35;
        double _t41 = _t10 * _t33;
        double _t42 = _t11 - _t34;
        double _t43 = _t9 * _t35;
        double _t44 = _t10 * _t34;
        double _t45 = _t11 + _t34;
        double _t55 = _t37 - _t39;
        double _t60 = Math.max(_t55, _t9);
        double _t61 = _t40 + (_t10 - _t41);
        double _t62 = _t40 + (-_t10 - _t41);
        double _t63 = _t43 + _t35 - _t44;
        double _t64 = _t44 + (_t35 - _t43);
        double _t65 = _t37 + (_t33 + _t9 - _t39);
        double _t66 = _t37 + (_t36 + _t9 - _t39);
        double _t67 = _t39 + (_t36 - _t9) - _t37;
        double _t68 = _t37 + (1.0 - _t9 - _t33 - _t39);
        double _t69 = _t39 + (1.0 + _t9 - _t33) - _t37;
        double _t71 = (1.0 / Math.sqrt(_t67));
        double _t72 = (1.0 / Math.sqrt(_t68));
        double _t73 = (1.0 / Math.sqrt(_t69));
        double _t74 = (1.0 / Math.sqrt(_t66));
        double _t114, _t115, _t116, _t117;
        if (_t65 > 0.0) {
            _t114 = 0.5 * _t63 * _t74;
            _t115 = 0.5 * _t42 * _t74;
            _t116 = 0.5 * Math.sqrt(_t66);
            _t117 = 0.5 * _t62 * _t74;
        } else {
            if (_t33 > _t60) {
                _t114 = 0.5 * _t45 * _t71;
                _t115 = 0.5 * _t64 * _t71;
                _t116 = 0.5 * _t62 * _t71;
                _t117 = 0.5 * Math.sqrt(_t67);
            } else {
                if (_t55 > _t9) {
                    _t114 = 0.5 * _t61 * _t72;
                    _t115 = 0.5 * Math.sqrt(_t68);
                    _t116 = 0.5 * _t42 * _t72;
                    _t117 = 0.5 * _t64 * _t72;
                } else {
                    _t114 = 0.5 * Math.sqrt(_t69);
                    _t115 = 0.5 * _t61 * _t73;
                    _t116 = 0.5 * _t63 * _t73;
                    _t117 = 0.5 * _t45 * _t73;
                }
            }
        }
        double _buf0 = this.x * _t116 + this.w * _t117 + (this.y * _t114 - this.z * _t115);
        double _buf1 = this.y * _t116 + this.z * _t117 + (this.w * _t115 - this.x * _t114);
        double _buf2 = this.x * _t115 + this.w * _t114 + (this.z * _t116 - this.y * _t117);
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
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        this.x = axisX * _t1;
        this.y = axisY * _t1;
        this.z = axisZ * _t1;
        this.w = Math.cos(_t0);
        return this;
    }


    /**
     * Set this quaternion to a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return this
     */
    public @Mutated DoubleQuat makeRotationLookAlong(Double3R dir, Double3R up) {
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
    @Mutated public DoubleQuat makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t4 = dirX * dirX + dirY * dirY + dirZ * dirZ;
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t9, _t10, _t11;
        if (_t4 > 0.0) {
            _t9 = dirZ * _t5;
            _t10 = dirY * _t5;
            _t11 = dirX * _t5;
        } else {
            _t9 = 0.0;
            _t10 = 0.0;
            _t11 = 0.0;
        }
        double _t21 = upY * _t9 - upZ * _t10;
        double _t22 = upZ * _t11 - upX * _t9;
        double _t23 = upX * _t10 - upY * _t11;
        double _t28 = _t21 * _t21 + _t22 * _t22 + _t23 * _t23;
        double _t29 = (1.0 / Math.sqrt(_t28));
        double _t33, _t34, _t35;
        if (_t28 > 0.0) {
            _t33 = _t21 * _t29;
            _t34 = _t23 * _t29;
            _t35 = _t22 * _t29;
        } else {
            _t33 = 0.0;
            _t34 = 0.0;
            _t35 = 0.0;
        }
        double _t36 = 1.0 + _t33;
        double _t37 = _t9 * _t33;
        double _t39 = _t11 * _t34;
        double _t40 = _t11 * _t35;
        double _t41 = _t10 * _t33;
        double _t42 = _t10 * _t34;
        double _t43 = _t9 * _t35;
        double _t44 = _t11 + _t34;
        double _t45 = _t11 - _t34;
        double _t55 = _t37 - _t39;
        double _t60 = Math.max(_t55, _t9);
        double _t61 = _t40 + (_t10 - _t41);
        double _t62 = _t40 + (-_t10 - _t41);
        double _t63 = _t42 + (_t35 - _t43);
        double _t64 = _t43 + _t35 - _t42;
        double _t65 = _t37 + (_t33 + _t9 - _t39);
        double _t66 = _t37 + (_t36 + _t9 - _t39);
        double _t67 = _t39 + (_t36 - _t9) - _t37;
        double _t68 = _t37 + (1.0 - _t9 - _t33 - _t39);
        double _t69 = _t39 + (1.0 + _t9 - _t33) - _t37;
        double _t70 = (1.0 / Math.sqrt(_t66));
        double _t71 = (1.0 / Math.sqrt(_t68));
        double _t72 = (1.0 / Math.sqrt(_t69));
        double _t73 = (1.0 / Math.sqrt(_t67));
        if (_t65 > 0.0) {
            this.x = 0.5 * _t62 * _t70;
            this.y = 0.5 * _t45 * _t70;
            this.z = 0.5 * _t64 * _t70;
            this.w = 0.5 * Math.sqrt(_t66);
        } else {
            if (_t33 > _t60) {
                this.x = 0.5 * Math.sqrt(_t67);
                this.y = 0.5 * _t63 * _t73;
                this.z = 0.5 * _t44 * _t73;
                this.w = 0.5 * _t62 * _t73;
            } else {
                if (_t55 > _t9) {
                    this.x = 0.5 * _t63 * _t71;
                    this.y = 0.5 * Math.sqrt(_t68);
                    this.z = 0.5 * _t61 * _t71;
                    this.w = 0.5 * _t45 * _t71;
                } else {
                    this.x = 0.5 * _t44 * _t72;
                    this.y = 0.5 * _t61 * _t72;
                    this.z = 0.5 * Math.sqrt(_t69);
                    this.w = 0.5 * _t64 * _t72;
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
    public @Mutated DoubleQuat makeRotationTo(Double3R fromDir, Double3R toDir) {
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
    @Mutated public DoubleQuat makeRotationTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double _t3 = fromDirX + toDirX;
        double _t4 = fromDirY + toDirY;
        double _t5 = fromDirZ + toDirZ;
        double _t17 = fromDirY * toDirZ - fromDirZ * toDirY;
        double _t18 = fromDirZ * toDirX - fromDirX * toDirZ;
        double _t19 = fromDirX * toDirY - fromDirY * toDirX;
        double _t20 = fromDirX * fromDirX + fromDirY * fromDirY;
        double _t21, _t22, _t23;
        if (_t20 > 0.0) {
            _t21 = fromDirY;
            _t22 = 0.0;
            _t23 = -fromDirX;
        } else {
            _t21 = 0.0;
            _t22 = -fromDirY;
            _t23 = fromDirZ;
        }
        double _t29 = _t3 * _t3 + _t4 * _t4 + _t5 * _t5;
        double _t31 = 0.5 * _t29;
        double _t37 = _t21 * _t21 + _t23 * _t23 + _t22 * _t22;
        double _t38 = (1.0 / Math.sqrt(_t37));
        double _t41 = (1.0 / Math.sqrt(_t17 * _t17 + (_t18 * _t18 + (_t19 * _t19 + _t29 * _t29 / (2.0 * 2.0)))));
        if (_t31 > 1.0E-6) {
            this.x = _t17 * _t41;
            this.y = _t18 * _t41;
            this.z = _t19 * _t41;
            this.w = 0.5 * _t29 * _t41;
        } else {
            if (_t37 > 0.0) {
                this.x = _t38 * _t21;
                this.y = _t38 * _t23;
                this.z = _t38 * _t22;
                this.w = 0.0;
            } else {
                this.x = 0.0;
                this.y = 0.0;
                this.z = 0.0;
                this.w = 0.0;
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
        double _t0 = 0.5 * angle;
        this.x = Math.sin(_t0);
        this.y = 0.0;
        this.z = 0.0;
        this.w = Math.cos(_t0);
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
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
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
    @Mutated public DoubleQuat makeRotationXZY(double angleX, double angleY, double angleZ) {
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
    @Mutated public DoubleQuat makeRotationY(double angle) {
        double _t0 = 0.5 * angle;
        this.x = 0.0;
        this.y = Math.sin(_t0);
        this.z = 0.0;
        this.w = Math.cos(_t0);
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
    @Mutated public DoubleQuat makeRotationYXZ(double angleX, double angleY, double angleZ) {
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
    @Mutated public DoubleQuat makeRotationYZX(double angleX, double angleY, double angleZ) {
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
    @Mutated public DoubleQuat makeRotationZ(double angle) {
        double _t0 = 0.5 * angle;
        this.x = 0.0;
        this.y = 0.0;
        this.z = Math.sin(_t0);
        this.w = Math.cos(_t0);
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
    @Mutated public DoubleQuat makeRotationZXY(double angleX, double angleY, double angleZ) {
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
    @Mutated public DoubleQuat makeRotationZYX(double angleX, double angleY, double angleZ) {
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
    public DoubleQuat preRotateX(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = this.x * _t1 + this.w * _t2;
        double _buf1 = this.y * _t1 - this.z * _t2;
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
    public DoubleQuat preRotateY(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = this.x * _t1 + this.z * _t2;
        double _buf1 = this.y * _t1 + this.w * _t2;
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
    public DoubleQuat preRotateZ(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = this.x * _t1 - this.y * _t2;
        d.y = this.x * _t2 + this.y * _t1;
        double _buf1 = this.z * _t1 + this.w * _t2;
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
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        double _buf0 = this.x * _t1 + this.w * _t3 + (this.y * _t4 - this.z * _t5);
        double _buf1 = this.y * _t1 + this.z * _t3 + (this.w * _t5 - this.x * _t4);
        double _buf2 = this.x * _t5 + this.w * _t4 + (this.z * _t1 - this.y * _t3);
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
    public DoubleQuat rotateTo(Double3R fromDir, Double3R toDir, @Mutated DoubleQuat dest) {
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
    public DoubleQuat rotateTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t3 = fromDirX + toDirX;
        double _t4 = fromDirY + toDirY;
        double _t5 = fromDirZ + toDirZ;
        double _t17 = fromDirY * toDirZ - fromDirZ * toDirY;
        double _t18 = fromDirZ * toDirX - fromDirX * toDirZ;
        double _t19 = fromDirX * toDirY - fromDirY * toDirX;
        double _t20 = fromDirX * fromDirX + fromDirY * fromDirY;
        double _t21, _t22, _t23;
        if (_t20 > 0.0) {
            _t21 = fromDirY;
            _t22 = 0.0;
            _t23 = -fromDirX;
        } else {
            _t21 = 0.0;
            _t22 = -fromDirY;
            _t23 = fromDirZ;
        }
        double _t29 = _t3 * _t3 + _t4 * _t4 + _t5 * _t5;
        double _t31 = 0.5 * _t29;
        double _t37 = _t21 * _t21 + _t23 * _t23 + _t22 * _t22;
        double _t38 = (1.0 / Math.sqrt(_t37));
        double _t44 = (1.0 / Math.sqrt(_t17 * _t17 + (_t18 * _t18 + (_t19 * _t19 + _t29 * _t29 / (2.0 * 2.0)))));
        double _t50, _t54, _t55, _t56;
        if (_t31 > 1.0E-6) {
            _t50 = 0.5 * _t29 * _t44;
            _t54 = _t17 * _t44;
            _t55 = _t19 * _t44;
            _t56 = _t18 * _t44;
        } else {
            if (_t37 > 0.0) {
                _t50 = 0.0;
                _t54 = _t38 * _t21;
                _t55 = _t38 * _t22;
                _t56 = _t38 * _t23;
            } else {
                _t50 = 0.0;
                _t54 = 0.0;
                _t55 = 0.0;
                _t56 = 0.0;
            }
        }
        double _buf0 = this.x * _t50 + this.w * _t54 + (this.y * _t55 - this.z * _t56);
        double _buf1 = this.y * _t50 + this.z * _t54 + (this.w * _t56 - this.x * _t55);
        double _buf2 = this.x * _t56 + this.w * _t55 + (this.z * _t50 - this.y * _t54);
        d.w = this.w * _t50 - this.x * _t54 - this.y * _t56 - this.z * _t55;
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
    public DoubleQuat rotateX(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = this.x * _t1 + this.w * _t2;
        double _buf1 = this.y * _t1 + this.z * _t2;
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
    public DoubleQuat rotateXYZ(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        double _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        double _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        double _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
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
    public DoubleQuat rotateXZY(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        double _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        double _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        double _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
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
    public DoubleQuat rotateY(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = this.x * _t1 - this.z * _t2;
        double _buf1 = this.y * _t1 + this.w * _t2;
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
    public DoubleQuat rotateYXZ(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        double _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        double _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        double _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
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
    public DoubleQuat rotateYZX(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        double _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        double _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        double _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
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
    public DoubleQuat rotateZ(double angle, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _buf0 = this.x * _t1 + this.y * _t2;
        d.y = this.y * _t1 - this.x * _t2;
        double _buf1 = this.z * _t1 + this.w * _t2;
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
    public DoubleQuat rotateZXY(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        double _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        double _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        double _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
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
    public DoubleQuat rotateZYX(double angleX, double angleY, double angleZ, @Mutated DoubleQuat dest) {
        DoubleQuatImpl d = (DoubleQuatImpl) dest;
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
        double _buf0 = this.x * _t21 + this.w * _t22 + (this.y * _t23 - this.z * _t24);
        double _buf1 = this.y * _t21 + this.z * _t22 + (this.w * _t24 - this.x * _t23);
        double _buf2 = this.x * _t24 + this.w * _t23 + (this.z * _t21 - this.y * _t22);
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

}
