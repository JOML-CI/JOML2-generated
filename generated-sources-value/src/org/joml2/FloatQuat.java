package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable quaternion of single-precision {@code float} components, declared as a value record.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance; as a value class, instances have no identity and may be flattened by the JVM.
 *
 * @param x the {@code x} component
 * @param y the {@code y} component
 * @param z the {@code z} component
 * @param w the {@code w} component
 */
@jdk.internal.vm.annotation.LooselyConsistentValue
public value record FloatQuat(float x, float y, float z, float w) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** The zero quaternion (all components 0). */
    public static final FloatQuat ZERO = new FloatQuat(0, 0, 0, 0);

    /** The identity quaternion. */
    public static final FloatQuat IDENTITY = new FloatQuat();

    /** Canonical constructor. */
    public FloatQuat(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Create a new instance initialized to the identity.
     */
    public FloatQuat() {
        this(0, 0, 0, 1);
    }

    /** {@return the {@code x} component} */
    public float x() { return x; }
    /** {@return the {@code y} component} */
    public float y() { return y; }
    /** {@return the {@code z} component} */
    public float z() { return z; }
    /** {@return the {@code w} component} */
    public float w() { return w; }


    /**
     * Invert this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat invert() {
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t3_inv = 1.0f / _t3;
        return new FloatQuat(-(this.x * _t3_inv), -(this.y * _t3_inv), -(this.z * _t3_inv), this.w * _t3_inv);
    }


    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1}, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat invertProduct(FloatQuat other) {
        return invertProduct(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the inverse of the product of this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting quaternion
     */
    public FloatQuat invertProduct(float otherX, float otherY, float otherZ, float otherW) {
        float _t21 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z));
        float _t22 = Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y));
        float _t23 = Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x));
        float _t24 = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        return new FloatQuat(-(_t21 * _t28_inv), -(_t23 * _t28_inv), -(_t22 * _t28_inv), _t24 * _t28_inv);
    }


    /**
     * Add {@code other} to this quaternion, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat add(FloatQuat other) {
        return add(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) to this quaternion,
     * returning the result as a value.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting quaternion
     */
    public FloatQuat add(float otherX, float otherY, float otherZ, float otherW) {
        return new FloatQuat(otherX + this.x, otherY + this.y, otherZ + this.z, otherW + this.w);
    }


    /**
     * Negate this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat negate() {
        return new FloatQuat(-this.x, -this.y, -this.z, -this.w);
    }


    /**
     * Subtract {@code other} from this quaternion, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat sub(FloatQuat other) {
        return sub(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) from this
     * quaternion, returning the result as a value.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting quaternion
     */
    public FloatQuat sub(float otherX, float otherY, float otherZ, float otherW) {
        return new FloatQuat(this.x - otherX, this.y - otherY, this.z - otherZ, this.w - otherW);
    }


    /**
     * Create a new quaternion from the given values.
     *
     * @param v the quaternion
     * @return the resulting quaternion
     */
    public FloatQuat set(FloatQuat v) {
        return set(v.x(), v.y(), v.z(), v.w());
    }


    /**
     * Create a new quaternion from the given values.
     *
     * @param vX the {@code x} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the quaternion {@code (vX, vY, vZ, vW)}
     * @return the resulting quaternion
     */
    public FloatQuat set(float vX, float vY, float vZ, float vW) {
        return new FloatQuat(vX, vY, vZ, vW);
    }


    /**
     * Convert this quaternion to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code DoubleQuat} holding the result
     */
    public DoubleQuat toDouble() {
        return new DoubleQuat(this.x, this.y, this.z, this.w);
    }


    /**
     * Create the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion
     * @return the resulting quaternion
     */
    public static FloatQuat makeFromDualQuat(FloatDualQuat dq) {
        return makeFromDualQuat(dq.rX(), dq.rY(), dq.rZ(), dq.rW(), dq.dX(), dq.dY(), dq.dZ(), dq.dW());
    }


    /**
     * Create the rotation (real) part of the unit dual quaternion ({@code dqRX}, {@code dqRY},
     * {@code dqRZ}, {@code dqRW}, {@code dqDX}, {@code dqDY}, {@code dqDZ}, {@code dqDW}).
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
     * @return the resulting quaternion
     */
    public static FloatQuat makeFromDualQuat(float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        return new FloatQuat(dqRX, dqRY, dqRZ, dqRW);
    }


    /**
     * Create the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return the resulting quaternion
     */
    public static FloatQuat makeFromMatrix(Float3x3 m) {
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
            return new FloatQuat(0.5f * _t1 * _t18, 0.5f * _t7 * _t18, 0.5f * _t9 * _t18, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (m.m00() > _t2) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t15), 0.5f * _t4 * _t21, 0.5f * _t6 * _t21, 0.5f * _t1 * _t21);
            } else {
                if (m.m11() > m.m22()) {
                    return new FloatQuat(0.5f * _t4 * _t19, 0.5f * (float) Math.sqrt(_t16), 0.5f * _t8 * _t19, 0.5f * _t7 * _t19);
                } else {
                    return new FloatQuat(0.5f * _t6 * _t20, 0.5f * _t8 * _t20, 0.5f * (float) Math.sqrt(_t17), 0.5f * _t9 * _t20);
                }
            }
        }
    }


    /**
     * Create the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return the resulting quaternion
     */
    public static FloatQuat makeFromMatrix(Float3x4 m) {
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
            return new FloatQuat(0.5f * _t1 * _t18, 0.5f * _t7 * _t18, 0.5f * _t9 * _t18, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (m.m00() > _t2) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t15), 0.5f * _t4 * _t21, 0.5f * _t6 * _t21, 0.5f * _t1 * _t21);
            } else {
                if (m.m11() > m.m22()) {
                    return new FloatQuat(0.5f * _t4 * _t19, 0.5f * (float) Math.sqrt(_t16), 0.5f * _t8 * _t19, 0.5f * _t7 * _t19);
                } else {
                    return new FloatQuat(0.5f * _t6 * _t20, 0.5f * _t8 * _t20, 0.5f * (float) Math.sqrt(_t17), 0.5f * _t9 * _t20);
                }
            }
        }
    }


    /**
     * Create the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return the resulting quaternion
     */
    public static FloatQuat makeFromMatrix(Float4x4 m) {
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
            return new FloatQuat(0.5f * _t1 * _t18, 0.5f * _t7 * _t18, 0.5f * _t9 * _t18, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (m.m00() > _t2) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t15), 0.5f * _t4 * _t21, 0.5f * _t6 * _t21, 0.5f * _t1 * _t21);
            } else {
                if (m.m11() > m.m22()) {
                    return new FloatQuat(0.5f * _t4 * _t19, 0.5f * (float) Math.sqrt(_t16), 0.5f * _t8 * _t19, 0.5f * _t7 * _t19);
                } else {
                    return new FloatQuat(0.5f * _t6 * _t20, 0.5f * _t8 * _t20, 0.5f * (float) Math.sqrt(_t17), 0.5f * _t9 * _t20);
                }
            }
        }
    }


    /**
     * Convert this quaternion to a pure-rotation dual quaternion (zero dual part), returning the
     * result as a value.
     *
     * @return the resulting dual quaternion
     */
    public FloatDualQuat toDualQuat() {
        return new FloatDualQuat(this.x, this.y, this.z, this.w, 0.0f, 0.0f, 0.0f, 0.0f);
    }


    /**
     * Compute the matrix representation of this quaternion, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float4x4 toMatrix() {
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        return new Float4x4(Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f), 2.0f * Math.fma(this.x, this.y, -_t1), 2.0f * Math.fma(this.x, this.z, _t2), 0.0f, 2.0f * Math.fma(this.x, this.y, _t1), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f), 2.0f * Math.fma(this.y, this.z, -(this.x * this.w)), 0.0f, 2.0f * Math.fma(this.x, this.z, -_t2), 2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0);
    }


    /**
     * Compute the 3x3 rotation matrix representation of this quaternion, returning the result as a
     * value.
     *
     * @return the resulting matrix
     */
    public Float3x3 toMatrix3x3() {
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        return new Float3x3(Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f), 2.0f * Math.fma(this.x, this.y, -_t1), 2.0f * Math.fma(this.x, this.z, _t2), 2.0f * Math.fma(this.x, this.y, _t1), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f), 2.0f * Math.fma(this.y, this.z, -(this.x * this.w)), 2.0f * Math.fma(this.x, this.z, -_t2), 2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f), 0);
    }


    /**
     * Compute the 3x4 matrix representation of this quaternion (the omitted last row is implicitly
     * {@code 0, 0, 0, 1}), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Float3x4 toMatrix3x4() {
        float _t0 = this.z * this.z;
        float _t1 = this.z * this.w;
        float _t2 = this.y * this.w;
        return new Float3x4(Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f), 2.0f * Math.fma(this.x, this.y, -_t1), 2.0f * Math.fma(this.x, this.z, _t2), 0.0f, 2.0f * Math.fma(this.x, this.y, _t1), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f), 2.0f * Math.fma(this.y, this.z, -(this.x * this.w)), 0.0f, 2.0f * Math.fma(this.x, this.z, -_t2), 2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f), 0.0f, 0);
    }

    /** Result value of {@code decomposeSwingTwist}. */
    @jdk.internal.vm.annotation.LooselyConsistentValue
    public value record DecomposeSwingTwistResult(FloatQuat swing, FloatQuat twist) {
        /** Canonical constructor. */
        public DecomposeSwingTwistResult(FloatQuat swing, FloatQuat twist) {
            this.swing = swing;
            this.twist = twist;
        }
        /** {@return the {@code swing} component} */
        public FloatQuat swing() { return swing; }
        /** {@return the {@code twist} component} */
        public FloatQuat twist() { return twist; }
    }


    /**
     * Decompose this quaternion into a swing about an axis perpendicular to {@code axis} followed
     * by a twist about {@code axis}, such that {@code swing * twist} is this rotation.
     * <p>
     * Equivalent to calling {@code getSwing} and {@code getTwist} separately, but shares the work.
     * The twist is the identity when the rotation is a pure swing, including the 180-degree
     * perpendicular case where it is undefined.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @return a new result value holding the swing and the twist
     */
    public DecomposeSwingTwistResult decomposeSwingTwist(Float3 axis) {
        float _t2 = Math.fma(axis.z(), this.z, Math.fma(axis.x(), this.x, axis.y() * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = this.w * _t5;
            _t12 = axis.x() * _t7;
            _t13 = axis.y() * _t7;
            _t14 = axis.z() * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        return new DecomposeSwingTwistResult(new FloatQuat(Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14)), Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12)), Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14)), Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11)))), new FloatQuat(_t12, _t13, _t14, _t11));
    }


    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to {@code axis} in
     * the swing-twist decomposition, returning the result as a value.
     * <p>
     * The swing carries the rotation that tilts the axis itself; its own axis is perpendicular to
     * the given one.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting quaternion
     */
    public FloatQuat getSwing(Float3 axis) {
        return getSwing(axis.x(), axis.y(), axis.z());
    }


    /**
     * Extract the swing component of this quaternion: the rotation perpendicular to ({@code axisX},
     * {@code axisY}, {@code axisZ}) in the swing-twist decomposition, returning the result as a
     * value.
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
     * @return the resulting quaternion
     */
    public FloatQuat getSwing(float axisX, float axisY, float axisZ) {
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
        return new FloatQuat(Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14)), Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12)), Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14)), Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11))));
    }


    /**
     * Extract the twist component of this quaternion: the rotation about {@code axis} in the
     * swing-twist decomposition, returning the result as a value.
     * <p>
     * The twist is the rotation about the axis alone; it is the identity when the rotation is a
     * pure swing, including the 180-degree perpendicular case where the twist angle is undefined.
     *
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting quaternion
     */
    public FloatQuat getTwist(Float3 axis) {
        return getTwist(axis.x(), axis.y(), axis.z());
    }


    /**
     * Extract the twist component of this quaternion: the rotation about ({@code axisX},
     * {@code axisY}, {@code axisZ}) in the swing-twist decomposition, returning the result as a
     * value.
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
     * @return the resulting quaternion
     */
    public FloatQuat getTwist(float axisX, float axisY, float axisZ) {
        float _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            return new FloatQuat(axisX * _t6, axisY * _t6, axisZ * _t6, this.w * _t5);
        } else {
            return new FloatQuat(0.0f, 0.0f, 0.0f, 1.0f);
        }
    }


    /**
     * Create an identity quaternion.
     *
     * @return the resulting quaternion
     */
    public static FloatQuat makeIdentity() {
        return new FloatQuat(0.0f, 0.0f, 0.0f, 1.0f);
    }


    /**
     * Create an all-zero quaternion.
     *
     * @return the resulting quaternion
     */
    public static FloatQuat makeZero() {
        return FloatQuat.ZERO;
    }


    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public FloatQuat lerp(FloatQuat other, float t) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t);
    }


    /**
     * Linearly interpolate between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}) using the interpolation factor {@code t}, returning the
     * result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat lerp(float otherX, float otherY, float otherZ, float otherW, float t) {
        return new FloatQuat(Math.fma(t, otherX - this.x, this.x), Math.fma(t, otherY - this.y, this.y), Math.fma(t, otherZ - this.z, this.z), Math.fma(t, otherW - this.w, this.w));
    }


    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result, returning the result as a value.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public FloatQuat nlerp(FloatQuat target, float alpha) {
        return nlerp(target.x(), target.y(), target.z(), target.w(), alpha);
    }


    /**
     * Interpolate between this quaternion and ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}) using the interpolation factor {@code alpha} and normalize the result,
     * returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat nlerp(float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t4 = Math.fma(alpha, targetW - this.w, this.w);
        float _t5 = Math.fma(alpha, targetZ - this.z, this.z);
        float _t6 = Math.fma(alpha, targetX - this.x, this.x);
        float _t7 = Math.fma(alpha, targetY - this.y, this.y);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            return new FloatQuat(_t6 * _t12, _t7 * _t12, _t5 * _t12, _t4 * _t12);
        } else {
            return FloatQuat.ZERO;
        }
    }


    /**
     * Interpolate along the shortest path between this quaternion and {@code target} using the
     * interpolation factor {@code alpha} and normalize the result, returning the result as a value.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public FloatQuat nlerpShortest(FloatQuat target, float alpha) {
        return nlerpShortest(target.x(), target.y(), target.z(), target.w(), alpha);
    }


    /**
     * Interpolate along the shortest path between this quaternion and ({@code targetX},
     * {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation factor
     * {@code alpha} and normalize the result, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat nlerpShortest(float targetX, float targetY, float targetZ, float targetW, float alpha) {
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
            return new FloatQuat(_t19 * _t25, _t20 * _t25, _t18 * _t25, _t17 * _t25);
        } else {
            return FloatQuat.ZERO;
        }
    }


    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * {@code target} using the interpolation factor {@code alpha}, returning the result as a value.
     * <p>
     * This method interpolates along the arc as given: when the two quaternions' dot product is
     * negative, the longer path around the sphere is taken. Use {@link #slerpShortest} (or negate
     * one operand) to always interpolate along the shorter arc.
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public FloatQuat slerp(FloatQuat target, float alpha) {
        return slerp(target.x(), target.y(), target.z(), target.w(), alpha);
    }


    /**
     * Spherically interpolate between this quaternion (which must have unit length) and
     * ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) using the interpolation
     * factor {@code alpha}, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat slerp(float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 0.0f) {
            return new FloatQuat(Math.fma(this.x, _t13, targetX * _t11) * _t8_inv, Math.fma(this.y, _t13, targetY * _t11) * _t8_inv, Math.fma(this.z, _t13, targetZ * _t11) * _t8_inv, Math.fma(this.w, _t13, targetW * _t11) * _t8_inv);
        } else {
            return new FloatQuat(Math.fma(alpha, targetX, this.x * _t0), Math.fma(alpha, targetY, this.y * _t0), Math.fma(alpha, targetZ, this.z * _t0), Math.fma(alpha, targetW, this.w * _t0));
        }
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and {@code target} using the interpolation factor {@code alpha}, returning the result
     * as a value.
     *
     * @param target the target rotation (must be a unit quaternion)
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public FloatQuat slerpShortest(FloatQuat target, float alpha) {
        return slerpShortest(target.x(), target.y(), target.z(), target.w(), alpha);
    }

    /** Private tail of {@code slerpShortest}; reached only through it. */
    private FloatQuat slerpShortest_s9ffd1c_tail(float _t17, float _t25, float _t19, float _t21, float _t17_inv, float alpha, float _t0, float _t22, float _t23, float _t24) {
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
            return new FloatQuat(_t50 * _t44, _t50 * _t45, _t50 * _t43, _t50 * _t42);
        } else {
            return FloatQuat.ZERO;
        }
    }


    /**
     * Spherically interpolate along the shortest path between this quaternion (which must have unit
     * length) and ({@code targetX}, {@code targetY}, {@code targetZ}, {@code targetW}) using the
     * interpolation factor {@code alpha}, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat slerpShortest(float targetX, float targetY, float targetZ, float targetW, float alpha) {
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
        return slerpShortest_s9ffd1c_tail(_t17, _t25, _t19, _t21, _t17_inv, alpha, _t0, _t22, _t23, _t24);
    }


    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions, returning the
     * result as a value.
     *
     * @param control0 the inner control quaternion associated with the start rotation
     * @param control1 the inner control quaternion associated with the end rotation
     * @param target the target rotation
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public FloatQuat squad(FloatQuat control0, FloatQuat control1, FloatQuat target, float t) {
        return squad(control0.x(), control0.y(), control0.z(), control0.w(), control1.x(), control1.y(), control1.z(), control1.w(), target.x(), target.y(), target.z(), target.w(), t);
    }

    /** Private tail of {@code squad}; reached only through it. */
    private FloatQuat squad_s7f857976_tail(float _t39, float _t46, float targetW, float _t42, float _t36_inv, float t, float _t0, float _t37, float control0Z, float _t45, float control1Z, float _t41, float _t35_inv, float targetZ, float control0X, float control1X, float targetX, float control0Y, float control1Y, float targetY, float _t71, float _t13, float _t14) {
        float _t72, _t74, _t76;
        if (_t39 > 0.0f) {
            _t72 = Math.fma(this.w, _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(this.z, _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(this.x, _t46, targetX * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, this.w * _t0);
            _t74 = Math.fma(t, targetZ, this.z * _t0);
            _t76 = Math.fma(t, targetX, this.x * _t0);
        }
        float _t73, _t75, _t77;
        if (_t37 > 0.0f) {
            _t73 = Math.fma(control0Z, _t45, control1Z * _t41) * _t35_inv;
            _t75 = Math.fma(control0X, _t45, control1X * _t41) * _t35_inv;
            _t77 = Math.fma(control0Y, _t45, control1Y * _t41) * _t35_inv;
        } else {
            _t73 = Math.fma(t, control1Z, control0Z * _t0);
            _t75 = Math.fma(t, control1X, control0X * _t0);
            _t77 = Math.fma(t, control1Y, control0Y * _t0);
        }
        return squad_s7f857976_tail2(_t39, _t46, targetY, _t42, _t36_inv, t, _t0, _t71, _t72, _t73, _t74, _t75, _t76, _t77, _t13, _t14);
    }

    /** Private tail of {@code squad}; reached only through it. */
    private FloatQuat squad_s7f857976_tail2(float _t39, float _t46, float targetY, float _t42, float _t36_inv, float t, float _t0, float _t71, float _t72, float _t73, float _t74, float _t75, float _t76, float _t77, float _t13, float _t14) {
        float _t78 = _t39 > 0.0f ? Math.fma(this.y, _t46, targetY * _t42) * _t36_inv : Math.fma(t, targetY, this.y * _t0);
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        float _sfx0, _sfx1, _sfx2, _sfx3;
        if (_t87 > 0.0f) {
            _sfx0 = Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv;
            _sfx1 = Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv;
            _sfx2 = Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv;
            _sfx3 = Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv;
        } else {
            _sfx0 = Math.fma(_t14, _t76, _t13 * _t75);
            _sfx1 = Math.fma(_t14, _t78, _t13 * _t77);
            _sfx2 = Math.fma(_t14, _t74, _t13 * _t73);
            _sfx3 = Math.fma(_t14, _t72, _t13 * _t71);
        }
        return new FloatQuat(_sfx0, _sfx1, _sfx2, _sfx3);
    }


    /**
     * Perform spherical quadrangle interpolation (SQUAD) between this quaternion (the start
     * rotation) and the target rotation, shaped by the two inner control quaternions, returning the
     * result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat squad(float control0X, float control0Y, float control0Z, float control0W, float control1X, float control1Y, float control1Z, float control1W, float targetX, float targetY, float targetZ, float targetW, float t) {
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
        float _t71 = _t37 > 0.0f ? Math.fma(control0W, _t45, control1W * _t41) * _t35_inv : Math.fma(t, control1W, control0W * _t0);
        return squad_s7f857976_tail(_t39, _t46, targetW, _t42, _t36_inv, t, _t0, _t37, control0Z, _t45, control1Z, _t41, _t35_inv, targetZ, control0X, control1X, targetX, control0Y, control1Y, targetY, _t71, _t13, _t14);
    }


    /**
     * Multiply this quaternion by {@code other}, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code Q * R}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code Q * R * v}, the transformation of the operand will be applied first.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat mul(FloatQuat other) {
        return mul(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Multiply this quaternion by ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}),
     * returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat mul(float otherX, float otherY, float otherZ, float otherW) {
        return new FloatQuat(Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z)), Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x)), Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y)), Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x)))));
    }


    /**
     * Pre-multiply the transformation {@code other} onto this quaternion, returning the result as a
     * value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code T} the given transformation quaternion,
     * then the new quaternion will be {@code T * Q}. So when transforming a vector {@code v} with
     * the new quaternion by using {@code T * Q * v}, the given transformation will be applied last.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat preMul(FloatQuat other) {
        return preMul(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Pre-multiply the transformation ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) onto this quaternion, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat preMul(float otherX, float otherY, float otherZ, float otherW) {
        return new FloatQuat(Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherY, this.z, -(otherZ * this.y)), Math.fma(otherY, this.w, otherZ * this.x) + Math.fma(otherW, this.y, -(otherX * this.z)), Math.fma(otherX, this.y, otherW * this.z) + Math.fma(otherZ, this.w, -(otherY * this.x)), Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x)))));
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
    public float angleTo(FloatQuat other) {
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
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y))))));
    }


    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero),
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 axis() {
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(this.x * _t3, this.y * _t3, this.z * _t3);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Recompute the {@code w} component of this quaternion from {@code x}, {@code y} and {@code z},
     * assuming unit length (the positive square root is chosen), returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat calculateW() {
        return new FloatQuat(this.x, this.y, this.z, (float) Math.sqrt(Math.max(0.0f, Math.fma(-this.x, this.x, Math.fma(-this.y, this.y, Math.fma(-this.z, this.z, 1.0f))))));
    }


    /**
     * Conjugate this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat conjugate() {
        return new FloatQuat(-this.x, -this.y, -this.z, this.w);
    }


    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length),
     * returning the result as a value.
     *
     * @param q the quaternion
     * @return the resulting quaternion
     */
    public FloatQuat conjugateBy(FloatQuat q) {
        return conjugateBy(q.x(), q.y(), q.z(), q.w());
    }


    /**
     * Conjugate this quaternion by ({@code qX}, {@code qY}, {@code qZ}, {@code qW}), i.e. compute
     * {@code q * this * conj(q)} where {@code q} is the given quaternion (equal to
     * {@code q * this * q^-1} when it has unit length), returning the result as a value.
     *
     * @param qX the {@code x} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qY the {@code y} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qZ the {@code z} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @param qW the {@code w} component of the quaternion {@code (qX, qY, qZ, qW)}
     * @return the resulting quaternion
     */
    public FloatQuat conjugateBy(float qX, float qY, float qZ, float qW) {
        float _t1 = -qY;
        float _t21 = Math.fma(qX, this.y, qW * this.z) + Math.fma(qZ, this.w, -(qY * this.x));
        float _t22 = Math.fma(qY, this.w, qZ * this.x) + Math.fma(qW, this.y, -(qX * this.z));
        float _t23 = Math.fma(qX, this.w, qW * this.x) + Math.fma(qY, this.z, -(qZ * this.y));
        float _t24 = Math.fma(-qZ, this.z, Math.fma(_t1, this.y, Math.fma(qW, this.w, -(qX * this.x))));
        return new FloatQuat(Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24)), Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21)), Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24)), Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24))));
    }


    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation that,
     * applied after {@code this}, results in {@code other}, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat difference(FloatQuat other) {
        return difference(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the difference between this quaternion and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}), i.e. the rotation that, applied after {@code this}, results
     * in ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}), returning the result as
     * a value.
     *
     * @param otherX the {@code x} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the quaternion
     *        {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting quaternion
     */
    public FloatQuat difference(float otherX, float otherY, float otherZ, float otherW) {
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t3_inv = 1.0f / _t3;
        return new FloatQuat((Math.fma(otherX, this.w, -(otherW * this.x)) + Math.fma(otherY, this.z, -(otherZ * this.y))) * _t3_inv, -(otherW * this.y * _t3_inv) - otherX * this.z * _t3_inv + Math.fma(otherY, this.w, otherZ * this.x) * _t3_inv, (Math.fma(otherX, this.y, -(otherW * this.z)) + Math.fma(otherZ, this.w, -(otherY * this.x))) * _t3_inv, Math.fma(otherZ, this.z, Math.fma(otherY, this.y, Math.fma(otherX, this.x, otherW * this.w))) * _t3_inv);
    }


    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the dot product of this quaternion and {@code other}
     */
    public float dot(FloatQuat other) {
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
     * Compute the exponential of this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat exp() {
        float _t0 = (float) Math.exp(this.w);
        float _t3 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t4 = (float) Math.sqrt(_t3);
        float _t8 = (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            return new FloatQuat(this.x * _t8, this.y * _t8, this.z * _t8, (float) Math.cos(_t4) * _t0);
        } else {
            return new FloatQuat(0.0f, 0.0f, 0.0f, (float) Math.cos(_t4) * _t0);
        }
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Y and Z axes,
     * in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXYZ() {
        float _t1 = this.y * this.z;
        float _t3 = this.z * this.z;
        float _t8 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t9 = 2.0f * Math.fma(this.x, this.w, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.x, this.w, _t1), Math.fma(-2.0f, Math.fma(this.x, this.x, _t3), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), 0.0f);
        } else {
            return new Float3((float) Math.atan2(_t9, _t10), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), (float) Math.atan2(2.0f * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0f, Math.fma(this.y, this.y, _t3), 1.0f)));
        }
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the X, Z and Y axes,
     * in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesXZY() {
        float _t0 = this.z * this.z;
        float _t1 = this.y * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.w, _t1);
        float _t8 = 2.0f * Math.fma(this.z, this.w, -(this.x * this.y));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.x, this.w, -_t1), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f)), 0.0f, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        } else {
            return new Float3((float) Math.atan2(_t7, _t9), (float) Math.atan2(2.0f * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        }
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, X and Z axes,
     * in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYXZ() {
        float _t3 = this.z * this.z;
        float _t8 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t9 = 2.0f * Math.fma(this.x, this.w, -(this.y * this.z));
        float _t10 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t9))), (float) Math.atan2(2.0f * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0f, Math.fma(this.y, this.y, _t3), 1.0f)), 0.0f);
        } else {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t9))), (float) Math.atan2(_t8, _t10), (float) Math.atan2(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, _t3), 1.0f)));
        }
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Y, Z and X axes,
     * in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesYZX() {
        float _t0 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.w, -(this.x * this.z));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3(0.0f, (float) Math.atan2(2.0f * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        } else {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.x, this.w, -(this.y * this.z)), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f)), (float) Math.atan2(_t8, _t9), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        }
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, X and Y axes,
     * in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZXY() {
        float _t1 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.z, this.w, -(this.x * this.y));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))), 0.0f, (float) Math.atan2(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.y, this.y, _t1), 1.0f)));
        } else {
            return new Float3((float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))), (float) Math.atan2(2.0f * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f)), (float) Math.atan2(_t8, _t9));
        }
    }


    /**
     * Get the Euler angles in radians of this quaternion, to be applied about the Z, Y and X axes,
     * in that order, returning the result as a value.
     * <p>
     * At gimbal lock (a middle rotation of ±90 degrees) the decomposition is not unique; one valid
     * set of angles is returned.
     *
     * @return the resulting vector
     */
    public Float3 getEulerAnglesZYX() {
        float _t0 = this.z * this.z;
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.w, -(this.x * this.z));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            return new Float3(0.0f, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), (float) Math.atan2(2.0f * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0f, Math.fma(this.x, this.x, _t0), 1.0f)));
        } else {
            return new Float3((float) Math.atan2(2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f)), (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))), (float) Math.atan2(_t7, _t9));
        }
    }


    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion, returning the result as a value.
     *
     * @param angularVel the angular velocity, in radians per second, applied in the reference frame
     * @param dt the time step
     * @return the resulting quaternion
     */
    public FloatQuat integrate(Float3 angularVel, float dt) {
        return integrate(angularVel.x(), angularVel.y(), angularVel.z(), dt);
    }


    /**
     * Integrate the given angular velocity over the given time step and apply the resulting
     * rotation to this quaternion, returning the result as a value.
     *
     * @param angularVelX the {@code x} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param angularVelY the {@code y} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param angularVelZ the {@code z} component of the vector
     *        {@code (angularVelX, angularVelY, angularVelZ)}
     * @param dt the time step
     * @return the resulting quaternion
     */
    public FloatQuat integrate(float angularVelX, float angularVelY, float angularVelZ, float dt) {
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
        return new FloatQuat(Math.fma(this.x, _t9, this.w * _t15) + Math.fma(this.z, _t16, -(this.y * _t17)), Math.fma(this.x, _t17, this.w * _t16) + Math.fma(this.y, _t9, -(this.z * _t15)), Math.fma(this.y, _t15, this.z * _t9) + Math.fma(this.w, _t17, -(this.x * _t16)), Math.fma(-this.z, _t17, Math.fma(-this.y, _t16, Math.fma(this.w, _t9, -(this.x * _t15)))));
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 invNegativeX() {
        float _t7 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t8 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(-(_t9 * _t13), -(_t8 * _t13), -(_t7 * _t13));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 invNegativeY() {
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(-(_t7 * _t13), -(_t9 * _t13), -(_t8 * _t13));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 invNegativeZ() {
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(-(_t8 * _t13), -(_t7 * _t13), -(_t9 * _t13));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedNegativeX() {
        return new Float3(Math.fma(2.0f, Math.fma(this.y, this.y, this.z * this.z), -1.0f), -(2.0f * Math.fma(this.x, this.y, -(this.z * this.w))), -(2.0f * Math.fma(this.x, this.z, this.y * this.w)));
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedNegativeY() {
        return new Float3(-(2.0f * Math.fma(this.x, this.y, this.z * this.w)), Math.fma(2.0f, Math.fma(this.x, this.x, this.z * this.z), -1.0f), -(2.0f * Math.fma(this.y, this.z, -(this.x * this.w))));
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedNegativeZ() {
        return new Float3(-(2.0f * Math.fma(this.x, this.z, -(this.y * this.w))), -(2.0f * Math.fma(this.x, this.w, this.y * this.z)), Math.fma(2.0f, Math.fma(this.x, this.x, this.y * this.y), -1.0f));
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedPositiveX() {
        return new Float3(Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f), 2.0f * Math.fma(this.x, this.y, -(this.z * this.w)), 2.0f * Math.fma(this.x, this.z, this.y * this.w));
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedPositiveY() {
        return new Float3(2.0f * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f), 2.0f * Math.fma(this.y, this.z, -(this.x * this.w)));
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 invNormalizedPositiveZ() {
        return new Float3(2.0f * Math.fma(this.x, this.z, -(this.y * this.w)), 2.0f * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 invPositiveX() {
        float _t7 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t8 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(_t9 * _t13, _t8 * _t13, _t7 * _t13);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 invPositiveY() {
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(_t7 * _t13, _t9 * _t13, _t8 * _t13);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 invPositiveZ() {
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(_t8 * _t13, _t7 * _t13, _t9 * _t13);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Compute the length of this quaternion.
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
     * Compute the natural logarithm of this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat log() {
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2);
        float _t8 = (float) Math.acos(this.w * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new FloatQuat(this.x * _t8, this.y * _t8, this.z * _t8, (float) Math.log((float) Math.sqrt(_t4)));
        } else {
            return new FloatQuat(0.0f, 0.0f, 0.0f, (float) Math.log((float) Math.sqrt(_t4)));
        }
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 negativeX() {
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(-(_t9 * _t13), -(_t7 * _t13), -(_t8 * _t13));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 negativeY() {
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(-(_t8 * _t13), -(_t9 * _t13), -(_t7 * _t13));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 negativeZ() {
        float _t7 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(-(_t7 * _t13), -(_t8 * _t13), -(_t9 * _t13));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Normalize this quaternion to unit length, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public FloatQuat normalize() {
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            return new FloatQuat(this.x * _t4, this.y * _t4, this.z * _t4, this.w * _t4);
        } else {
            return FloatQuat.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedNegativeX() {
        return new Float3(Math.fma(2.0f, Math.fma(this.y, this.y, this.z * this.z), -1.0f), -(2.0f * Math.fma(this.x, this.y, this.z * this.w)), -(2.0f * Math.fma(this.x, this.z, -(this.y * this.w))));
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedNegativeY() {
        return new Float3(-(2.0f * Math.fma(this.x, this.y, -(this.z * this.w))), Math.fma(2.0f, Math.fma(this.x, this.x, this.z * this.z), -1.0f), -(2.0f * Math.fma(this.x, this.w, this.y * this.z)));
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedNegativeZ() {
        return new Float3(-(2.0f * Math.fma(this.x, this.z, this.y * this.w)), -(2.0f * Math.fma(this.y, this.z, -(this.x * this.w))), Math.fma(2.0f, Math.fma(this.x, this.x, this.y * this.y), -1.0f));
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedPositiveX() {
        return new Float3(Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f), 2.0f * Math.fma(this.x, this.y, this.z * this.w), 2.0f * Math.fma(this.x, this.z, -(this.y * this.w)));
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedPositiveY() {
        return new Float3(2.0f * Math.fma(this.x, this.y, -(this.z * this.w)), Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f), 2.0f * Math.fma(this.x, this.w, this.y * this.z));
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     * <p>
     * This method assumes the transformation to be orthogonal (i.e. free of scaling), and skips the
     * normalization the plain variant performs.
     *
     * @return the resulting vector
     */
    public Float3 normalizedPositiveZ() {
        return new Float3(2.0f * Math.fma(this.x, this.z, this.y * this.w), 2.0f * Math.fma(this.y, this.z, -(this.x * this.w)), Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f));
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 positiveX() {
        float _t7 = 2.0f * Math.fma(this.x, this.y, this.z * this.w);
        float _t8 = 2.0f * Math.fma(this.x, this.z, -(this.y * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.y, this.y, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(_t9 * _t13, _t7 * _t13, _t8 * _t13);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 positiveY() {
        float _t7 = 2.0f * Math.fma(this.x, this.w, this.y * this.z);
        float _t8 = 2.0f * Math.fma(this.x, this.y, -(this.z * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.z * this.z), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(_t8 * _t13, _t9 * _t13, _t7 * _t13);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 positiveZ() {
        float _t7 = 2.0f * Math.fma(this.x, this.z, this.y * this.w);
        float _t8 = 2.0f * Math.fma(this.y, this.z, -(this.x * this.w));
        float _t9 = Math.fma(-2.0f, Math.fma(this.x, this.x, this.y * this.y), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            return new Float3(_t7 * _t13, _t8 * _t13, _t9 * _t13);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))},
     * returning the result as a value.
     *
     * @param t the exponent
     * @return the resulting quaternion
     */
    public FloatQuat pow(float t) {
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t4 = Math.fma(this.w, this.w, _t2);
        float _t11 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t4)));
        float _t12 = (float) Math.acos(this.w * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        float _t19, _t20, _t21;
        if (_t2 > 0.0f) {
            _t19 = t * this.z * _t12;
            _t20 = t * this.x * _t12;
            _t21 = t * this.y * _t12;
        } else {
            _t19 = t * 0.0f;
            _t20 = t * 0.0f;
            _t21 = t * 0.0f;
        }
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (float) Math.sqrt(_t24);
        float _t29 = (float) Math.sin(_t25) * _t11 * (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            return new FloatQuat(_t20 * _t29, _t21 * _t29, _t19 * _t29, (float) Math.cos(_t25) * _t11);
        } else {
            return new FloatQuat(0.0f, 0.0f, 0.0f, (float) Math.cos(_t25) * _t11);
        }
    }


    /**
     * Pre-multiply {@code other} onto this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the operand, then the new quaternion
     * will be {@code R * Q}. So when transforming a vector {@code v} with the new quaternion by
     * using {@code R * Q * v}, the transformation of the operand will be applied last.
     * <p>
     * Identical to {@link #preMul}; the lower-case spelling is kept for JOML 1 source
     * compatibility.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public FloatQuat premul(FloatQuat other) {
        return preMul(other);
    }


    /**
     * Pre-multiply ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) onto this
     * quaternion, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat premul(float otherX, float otherY, float otherZ, float otherW) {
        return preMul(otherX, otherY, otherZ, otherW);
    }


    /**
     * Rotate this quaternion towards {@code target}, by at most the given maximum angle, returning
     * the result as a value.
     *
     * @param target the target rotation
     * @param step the maximum rotation angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat rotateTowards(FloatQuat target, float step) {
        return rotateTowards(target.x(), target.y(), target.z(), target.w(), step);
    }

    /** Private tail of {@code rotateTowards}; reached only through it. */
    private FloatQuat rotateTowards_s6b684b4e_tail(float _t12, float _t25, float _t23, float _t15, float _t12_inv, float _t21, float _t20, float _t16, float _t17, float _t18) {
        float _t46, _t47, _t48, _t49;
        if (_t12 > 0.0f) {
            _t46 = Math.fma(this.w, _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(this.z, _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(this.x, _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(this.y, _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(this.w, _t21, _t15 * _t20);
            _t47 = Math.fma(this.z, _t21, _t16 * _t20);
            _t48 = Math.fma(this.x, _t21, _t17 * _t20);
            _t49 = Math.fma(this.y, _t21, _t18 * _t20);
        }
        float _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        float _t54 = (1.0f / (float) Math.sqrt(_t53));
        if (_t53 > 0.0f) {
            return new FloatQuat(_t54 * _t48, _t54 * _t49, _t54 * _t47, _t54 * _t46);
        } else {
            return FloatQuat.ZERO;
        }
    }


    /**
     * Rotate this quaternion towards ({@code targetX}, {@code targetY}, {@code targetZ},
     * {@code targetW}), by at most the given maximum angle, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat rotateTowards(float targetX, float targetY, float targetZ, float targetW, float step) {
        float _t7 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
        float _t9 = -_t7;
        float _t11 = (float) Math.acos(Math.min(1.0f, Math.abs(_t7)));
        float _t12 = (float) Math.sin(_t11);
        float _t12_inv = 1.0f / _t12;
        float _t13 = 2.0f * _t11;
        float _t15, _t16, _t17, _t18;
        if (_t9 > 0.0f) {
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
        float _t20 = _t13 > 0.0f ? Math.min(1.0f, step / _t13) : 0.0f;
        float _t21 = 1.0f - _t20;
        float _t23 = (float) Math.sin(_t11 * _t20);
        float _t25 = (float) Math.sin(_t21 * _t11);
        return rotateTowards_s6b684b4e_tail(_t12, _t25, _t23, _t15, _t12_inv, _t21, _t20, _t16, _t17, _t18);
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along {@code dir} to this
     * quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code L} the "look along" quaternion, then the
     * new quaternion will be {@code Q * L}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * L * v}, the "look along" will be applied first.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting quaternion
     */
    public FloatQuat lookAlong(Float3 dir, Float3 up) {
        return lookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Apply a rotation transformation that makes {@code +z} point along ({@code dirX},
     * {@code dirY}, {@code dirZ}) to this quaternion, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat lookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
        return new FloatQuat(Math.fma(this.x, _t110, this.w * _t111) + Math.fma(this.y, _t108, -(this.z * _t109)), Math.fma(this.y, _t110, this.z * _t111) + Math.fma(this.w, _t109, -(this.x * _t108)), Math.fma(this.x, _t109, this.w * _t108) + Math.fma(this.z, _t110, -(this.y * _t111)), Math.fma(-this.z, _t108, Math.fma(-this.y, _t109, Math.fma(this.w, _t110, -(this.x * _t111)))));
    }


    /**
     * Create a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationAxis(float angle, Float3 axis) {
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
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        return new FloatQuat(axisX * _t1, axisY * _t1, axisZ * _t1, (float) Math.cos(_t0));
    }


    /**
     * Create a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationLookAlong(Float3 dir, Float3 up) {
        return makeRotationLookAlong(dir.x(), dir.y(), dir.z(), up.x(), up.y(), up.z());
    }


    /**
     * Create a rotation that makes {@code +z} point along ({@code dirX}, {@code dirY},
     * {@code dirZ}).
     *
     * @param dirX the {@code x} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirY the {@code y} component of the vector {@code (dirX, dirY, dirZ)}
     * @param dirZ the {@code z} component of the vector {@code (dirX, dirY, dirZ)}
     * @param upX the {@code x} component of the vector {@code (upX, upY, upZ)}
     * @param upY the {@code y} component of the vector {@code (upX, upY, upZ)}
     * @param upZ the {@code z} component of the vector {@code (upX, upY, upZ)}
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationLookAlong(float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
            return new FloatQuat(0.5f * _t55 * _t64, 0.5f * _t38 * _t64, 0.5f * _t58 * _t64, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                return new FloatQuat(0.5f * (float) Math.sqrt(_t61), 0.5f * _t57 * _t67, 0.5f * _t37 * _t67, 0.5f * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    return new FloatQuat(0.5f * _t57 * _t65, 0.5f * (float) Math.sqrt(_t62), 0.5f * _t54 * _t65, 0.5f * _t38 * _t65);
                } else {
                    return new FloatQuat(0.5f * _t37 * _t66, 0.5f * _t54 * _t66, 0.5f * (float) Math.sqrt(_t63), 0.5f * _t58 * _t66);
                }
            }
        }
    }


    /**
     * Create the rotation that rotates {@code fromDir} onto {@code toDir} (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen).
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationTo(Float3 fromDir, Float3 toDir) {
        return makeRotationTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
    }


    /**
     * Create the rotation that rotates ({@code fromDirX}, {@code fromDirY}, {@code fromDirZ}) onto
     * ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit vectors; for opposite
     * vectors an arbitrary perpendicular rotation axis is chosen).
     *
     * @param fromDirX the {@code x} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirY the {@code y} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param fromDirZ the {@code z} component of the vector {@code (fromDirX, fromDirY, fromDirZ)}
     * @param toDirX the {@code x} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirY the {@code y} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @param toDirZ the {@code z} component of the vector {@code (toDirX, toDirY, toDirZ)}
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float _t4 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t6, _t8, _t9;
        if (_t4 > 0.0f) {
            _t6 = fromDirY;
            _t8 = 0.0f;
            _t9 = -fromDirX;
        } else {
            _t6 = 0.0f;
            _t8 = -fromDirY;
            _t9 = fromDirZ;
        }
        float _t7 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0f)));
        float _t10 = 2.0f * _t7;
        float _t11 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        if (_t7 > 1.0E-6f) {
            return new FloatQuat(Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11, Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11, Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11, 0.5f * (float) Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0f) {
                return new FloatQuat(_t15 * _t6, _t15 * _t9, _t15 * _t8, 0.0f);
            } else {
                return FloatQuat.ZERO;
            }
        }
    }


    /**
     * Create a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationX(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatQuat((float) Math.sin(_t0), 0.0f, 0.0f, (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationXYZ(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)));
    }


    /**
     * Create a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationXZY(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t8, _t11 * _t5));
    }


    /**
     * Create a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationY(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatQuat(0.0f, (float) Math.sin(_t0), 0.0f, (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationYXZ(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t12, _t8, _t11 * _t5));
    }


    /**
     * Create a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationYZX(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)), Math.fma(_t10, _t5, -(_t9 * _t8)));
    }


    /**
     * Create a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationZ(float angle) {
        float _t0 = 0.5f * angle;
        return new FloatQuat(0.0f, 0.0f, (float) Math.sin(_t0), (float) Math.cos(_t0));
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationZXY(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t5, -(_t11 * _t8)));
    }


    /**
     * Create a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public static FloatQuat makeRotationZYX(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, _t12 * _t5), Math.fma(_t12, _t8, -(_t11 * _t5)), Math.fma(_t10, _t5, _t9 * _t8));
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the X axis onto this quaternion,
     * returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat preRotateX(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatQuat(Math.fma(this.x, _t1, this.w * _t2), Math.fma(this.y, _t1, -(this.z * _t2)), Math.fma(this.y, _t2, this.z * _t1), Math.fma(this.w, _t1, -(this.x * _t2)));
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Y axis onto this quaternion,
     * returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat preRotateY(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatQuat(Math.fma(this.x, _t1, this.z * _t2), Math.fma(this.y, _t1, this.w * _t2), Math.fma(this.z, _t1, -(this.x * _t2)), Math.fma(this.w, _t1, -(this.y * _t2)));
    }


    /**
     * Pre-multiply a rotation of {@code angle} radians about the Z axis onto this quaternion,
     * returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code R * Q}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code R * Q * v}, the rotation will be applied last.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat preRotateZ(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatQuat(Math.fma(this.x, _t1, -(this.y * _t2)), Math.fma(this.x, _t2, this.y * _t1), Math.fma(this.z, _t1, this.w * _t2), Math.fma(this.w, _t1, -(this.z * _t2)));
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis {@code axis} to this quaternion,
     * returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting quaternion
     */
    public FloatQuat rotateAxis(float angle, Float3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Apply a rotation of {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) to this quaternion, returning the result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        return new FloatQuat(Math.fma(this.x, _t1, this.w * _t3) + Math.fma(this.y, _t4, -(this.z * _t5)), Math.fma(this.y, _t1, this.z * _t3) + Math.fma(this.w, _t5, -(this.x * _t4)), Math.fma(this.x, _t5, this.w * _t4) + Math.fma(this.z, _t1, -(this.y * _t3)), Math.fma(-this.z, _t4, Math.fma(-this.y, _t5, Math.fma(this.w, _t1, -(this.x * _t3)))));
    }


    /**
     * Apply the rotation that rotates {@code fromDir} onto {@code toDir} (both must be unit
     * vectors; for opposite vectors an arbitrary perpendicular rotation axis is chosen) to this
     * quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param fromDir the vector
     * @param toDir the vector
     * @return the resulting quaternion
     */
    public FloatQuat rotateTo(Float3 fromDir, Float3 toDir) {
        return rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
    }

    /** Private tail of {@code rotateTo}; reached only through it. */
    private FloatQuat rotateTo_sb47fb53_tail(float _t16, float fromDirY, float toDirZ, float fromDirZ, float toDirY, float _t21, float _t29, float _t30, float _t15, float fromDirX, float toDirX, float _t17, float _t18, float _t27) {
        float _t37, _t38, _t39;
        if (_t16 > 1.0E-6f) {
            _t37 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t21;
            _t38 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t21;
            _t39 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t21;
        } else {
            if (_t29 > 0.0f) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0f;
                _t38 = 0.0f;
                _t39 = 0.0f;
            }
        }
        return new FloatQuat(Math.fma(this.x, _t27, this.w * _t37) + Math.fma(this.y, _t38, -(this.z * _t39)), Math.fma(this.y, _t27, this.z * _t37) + Math.fma(this.w, _t39, -(this.x * _t38)), Math.fma(this.x, _t39, this.w * _t38) + Math.fma(this.z, _t27, -(this.y * _t37)), Math.fma(-this.z, _t38, Math.fma(-this.y, _t39, Math.fma(this.w, _t27, -(this.x * _t37)))));
    }


    /**
     * Apply the rotation that rotates ({@code fromDirX}, {@code fromDirY}, {@code fromDirZ}) onto
     * ({@code toDirX}, {@code toDirY}, {@code toDirZ}) (both must be unit vectors; for opposite
     * vectors an arbitrary perpendicular rotation axis is chosen) to this quaternion, returning the
     * result as a value.
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
     * @return the resulting quaternion
     */
    public FloatQuat rotateTo(float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float _t10 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t15, _t17, _t18;
        if (_t10 > 0.0f) {
            _t15 = fromDirY;
            _t17 = 0.0f;
            _t18 = -fromDirX;
        } else {
            _t15 = 0.0f;
            _t17 = -fromDirY;
            _t18 = fromDirZ;
        }
        float _t16 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0f)));
        float _t19 = 2.0f * _t16;
        float _t21 = (1.0f / (float) Math.sqrt(_t19));
        float _t27 = _t16 > 1.0E-6f ? 0.5f * (float) Math.sqrt(_t19) : 0.0f;
        float _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        return rotateTo_sb47fb53_tail(_t16, fromDirY, toDirZ, fromDirZ, toDirY, _t21, _t29, _t30, _t15, fromDirX, toDirX, _t17, _t18, _t27);
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local X axis, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat rotateX(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatQuat(Math.fma(this.x, _t1, this.w * _t2), Math.fma(this.y, _t1, this.z * _t2), Math.fma(this.z, _t1, -(this.y * _t2)), Math.fma(this.w, _t1, -(this.x * _t2)));
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleY} and {@code angleZ} radians about the X, Y
     * and Z axes, in that order, to this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public FloatQuat rotateXYZ(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t20, -(this.z * _t22)), Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t22, -(this.x * _t20)), Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t21, -(this.y * _t19)), Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t21, -(this.x * _t19)))));
    }


    /**
     * Apply a rotation of {@code angleX}, {@code angleZ} and {@code angleY} radians about the X, Z
     * and Y axes, in that order, to this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public FloatQuat rotateXZY(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t20, -(this.z * _t22)), Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t22, -(this.x * _t20)), Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t19, -(this.y * _t21)), Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t21)))));
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Y axis, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat rotateY(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatQuat(Math.fma(this.x, _t1, -(this.z * _t2)), Math.fma(this.y, _t1, this.w * _t2), Math.fma(this.x, _t2, this.z * _t1), Math.fma(this.w, _t1, -(this.y * _t2)));
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleX} and {@code angleZ} radians about the Y, X
     * and Z axes, in that order, to this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public FloatQuat rotateYXZ(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(this.x, _t19, this.w * _t20) + Math.fma(this.y, _t21, -(this.z * _t22)), Math.fma(this.y, _t19, this.z * _t20) + Math.fma(this.w, _t22, -(this.x * _t21)), Math.fma(this.x, _t22, this.w * _t21) + Math.fma(this.z, _t19, -(this.y * _t20)), Math.fma(-this.z, _t21, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t20)))));
    }


    /**
     * Apply a rotation of {@code angleY}, {@code angleZ} and {@code angleX} radians about the Y, Z
     * and X axes, in that order, to this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public FloatQuat rotateYZX(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t22, -(this.z * _t20)), Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t20, -(this.x * _t22)), Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t21, -(this.y * _t19)), Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t19)))));
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Z axis, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public FloatQuat rotateZ(float angle) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        return new FloatQuat(Math.fma(this.x, _t1, this.y * _t2), Math.fma(this.y, _t1, -(this.x * _t2)), Math.fma(this.z, _t1, this.w * _t2), Math.fma(this.w, _t1, -(this.z * _t2)));
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleX} and {@code angleY} radians about the Z, X
     * and Y axes, in that order, to this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public FloatQuat rotateZXY(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(this.x, _t21, this.w * _t22) + Math.fma(this.y, _t19, -(this.z * _t20)), Math.fma(this.y, _t21, this.z * _t22) + Math.fma(this.w, _t20, -(this.x * _t19)), Math.fma(this.x, _t20, this.w * _t19) + Math.fma(this.z, _t21, -(this.y * _t22)), Math.fma(-this.z, _t19, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t22)))));
    }


    /**
     * Apply a rotation of {@code angleZ}, {@code angleY} and {@code angleX} radians about the Z, Y
     * and X axes, in that order, to this quaternion, returning the result as a value.
     * <p>
     * If {@code Q} is {@code this} quaternion and {@code R} the rotation quaternion, then the new
     * quaternion will be {@code Q * R}. So when transforming a vector {@code v} with the new
     * quaternion by using {@code Q * R * v}, the rotation will be applied first.
     *
     * @param angleX the angle in radians to rotate about the X axis
     * @param angleY the angle in radians to rotate about the Y axis
     * @param angleZ the angle in radians to rotate about the Z axis
     * @return the resulting quaternion
     */
    public FloatQuat rotateZYX(float angleX, float angleY, float angleZ) {
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
        return new FloatQuat(Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t22, -(this.z * _t20)), Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t20, -(this.x * _t22)), Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t19, -(this.y * _t21)), Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t19, -(this.x * _t21)))));
    }


    /**
     * Transform {@code v} by this quaternion, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transform(Float3 v) {
        return transform(v.x(), v.y(), v.z());
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by this quaternion, returning the result as a
     * value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transform(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.x, vY, -(this.y * vX));
        float _t10 = 2.0f * Math.fma(this.z, vX, -(this.x * vZ));
        float _t11 = 2.0f * Math.fma(this.y, vZ, -(this.z * vY));
        return new Float3(Math.fma(this.y, _t9, Math.fma(-this.z, _t10, Math.fma(this.w, _t11, vX))), Math.fma(this.z, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vY))), Math.fma(this.x, _t10, Math.fma(-this.y, _t11, Math.fma(this.w, _t9, vZ))));
    }


    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion), returning
     * the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 transformInverse(Float3 v) {
        return transformInverse(v.x(), v.y(), v.z());
    }


    /**
     * Transform ({@code vX}, {@code vY}, {@code vZ}) by the inverse of this quaternion (assumes a
     * unit quaternion), returning the result as a value.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Float3 transformInverse(float vX, float vY, float vZ) {
        float _t9 = 2.0f * Math.fma(this.x, vZ, -(this.z * vX));
        float _t10 = 2.0f * Math.fma(this.y, vX, -(this.x * vY));
        float _t11 = 2.0f * Math.fma(this.z, vY, -(this.y * vZ));
        return new Float3(Math.fma(this.z, _t9, Math.fma(-this.y, _t10, Math.fma(this.w, _t11, vX))), Math.fma(this.x, _t10, Math.fma(-this.z, _t11, Math.fma(this.w, _t9, vY))), Math.fma(this.y, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vZ))));
    }

    /** {@return a copy with the {@code x} component replaced by {@code v}} */
    public FloatQuat withX(float v) {
        return new FloatQuat(v, y, z, w);
    }

    /** {@return a copy with the {@code y} component replaced by {@code v}} */
    public FloatQuat withY(float v) {
        return new FloatQuat(x, v, z, w);
    }

    /** {@return a copy with the {@code z} component replaced by {@code v}} */
    public FloatQuat withZ(float v) {
        return new FloatQuat(x, y, v, w);
    }

    /** {@return a copy with the {@code w} component replaced by {@code v}} */
    public FloatQuat withW(float v) {
        return new FloatQuat(x, y, z, v);
    }

    @Override public String toString() {
        return "FloatQuat(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatQuat)) return false;
        FloatQuat o = (FloatQuat) obj;
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

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(x)
            && Float.isFinite(y)
            && Float.isFinite(z)
            && Float.isFinite(w);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatQuat other, float epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(w - other.w()) <= epsilon;
    }

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


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.w;
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
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        return new FloatQuat(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
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
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 4);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
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
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 16);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
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
     *
     * @param src the source memory segment
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(long offset, MemorySegment src) {
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
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.w;
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
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        return new FloatQuat(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position (the position is not modified).
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
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 4);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position (the position is not modified).
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
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeDoubleAbsolute(pos, buf);
        buf.position(pos + 32);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatQuat r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 32);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatQuat storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double}.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(MemorySegment dest) { return storeDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double},
     * starting at the given offset.
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
     *
     * @param src the source memory segment
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code FloatQuat} holding the loaded elements
     */
    public static FloatQuat loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(offset, src);
    }

}
