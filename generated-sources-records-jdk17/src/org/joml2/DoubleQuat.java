package org.joml2;

import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Immutable quaternion of double-precision {@code double} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param x the {@code x} component
 * @param y the {@code y} component
 * @param z the {@code z} component
 * @param w the {@code w} component
 */
public record DoubleQuat(double x, double y, double z, double w) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 32;

    /** The zero quaternion (all components 0). */
    public static final DoubleQuat ZERO = new DoubleQuat(0, 0, 0, 0);

    /** The identity quaternion. */
    public static final DoubleQuat IDENTITY = new DoubleQuat();

    /** Canonical constructor. */
    public DoubleQuat(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Create a new instance initialized to the identity.
     */
    public DoubleQuat() {
        this(0, 0, 0, 1);
    }

    /** {@return the {@code x} component} */
    public double x() { return x; }
    /** {@return the {@code y} component} */
    public double y() { return y; }
    /** {@return the {@code z} component} */
    public double z() { return z; }
    /** {@return the {@code w} component} */
    public double w() { return w; }


    /**
     * Invert this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat invert() {
        double _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        double _t3_inv = 1.0 / _t3;
        return new DoubleQuat(-(this.x * _t3_inv), -(this.y * _t3_inv), -(this.z * _t3_inv), this.w * _t3_inv);
    }


    /**
     * Compute the inverse of the product of this quaternion and {@code other}, i.e.
     * {@code (this * other)^-1}, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public DoubleQuat invertProduct(DoubleQuat other) {
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
    public DoubleQuat invertProduct(double otherX, double otherY, double otherZ, double otherW) {
        double _t21 = Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z));
        double _t22 = Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y));
        double _t23 = Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x));
        double _t24 = Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        return new DoubleQuat(-(_t21 * _t28_inv), -(_t23 * _t28_inv), -(_t22 * _t28_inv), _t24 * _t28_inv);
    }


    /**
     * Add {@code other} to this quaternion, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public DoubleQuat add(DoubleQuat other) {
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
    public DoubleQuat add(double otherX, double otherY, double otherZ, double otherW) {
        return new DoubleQuat(otherX + this.x, otherY + this.y, otherZ + this.z, otherW + this.w);
    }


    /**
     * Negate this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat negate() {
        return new DoubleQuat(-this.x, -this.y, -this.z, -this.w);
    }


    /**
     * Subtract {@code other} from this quaternion, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public DoubleQuat sub(DoubleQuat other) {
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
    public DoubleQuat sub(double otherX, double otherY, double otherZ, double otherW) {
        return new DoubleQuat(this.x - otherX, this.y - otherY, this.z - otherZ, this.w - otherW);
    }


    /**
     * Create a new quaternion from the given values.
     *
     * @param v the quaternion
     * @return the resulting quaternion
     */
    public DoubleQuat set(DoubleQuat v) {
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
    public DoubleQuat set(double vX, double vY, double vZ, double vW) {
        return new DoubleQuat(vX, vY, vZ, vW);
    }


    /**
     * Convert this quaternion to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code FloatQuat} holding the result
     */
    public FloatQuat toFloat() {
        return new FloatQuat((float) (this.x), (float) (this.y), (float) (this.z), (float) (this.w));
    }


    /**
     * Create the rotation (real) part of the unit dual quaternion {@code dq}.
     *
     * @param dq the dual quaternion
     * @return the resulting quaternion
     */
    public static DoubleQuat makeFromDualQuat(DoubleDualQuat dq) {
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
    public static DoubleQuat makeFromDualQuat(double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        return new DoubleQuat(dqRX, dqRY, dqRZ, dqRW);
    }


    /**
     * Create the rotation represented by the given matrix.
     *
     * @param m the matrix
     * @return the resulting quaternion
     */
    public static DoubleQuat makeFromMatrix(Double3x3 m) {
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
            return new DoubleQuat(0.5 * _t1 * _t18, 0.5 * _t7 * _t18, 0.5 * _t9 * _t18, 0.5 * Math.sqrt(_t14));
        } else {
            if (m.m00() > _t2) {
                return new DoubleQuat(0.5 * Math.sqrt(_t15), 0.5 * _t4 * _t21, 0.5 * _t6 * _t21, 0.5 * _t1 * _t21);
            } else {
                if (m.m11() > m.m22()) {
                    return new DoubleQuat(0.5 * _t4 * _t19, 0.5 * Math.sqrt(_t16), 0.5 * _t8 * _t19, 0.5 * _t7 * _t19);
                } else {
                    return new DoubleQuat(0.5 * _t6 * _t20, 0.5 * _t8 * _t20, 0.5 * Math.sqrt(_t17), 0.5 * _t9 * _t20);
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
    public static DoubleQuat makeFromMatrix(Double3x4 m) {
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
            return new DoubleQuat(0.5 * _t1 * _t18, 0.5 * _t7 * _t18, 0.5 * _t9 * _t18, 0.5 * Math.sqrt(_t14));
        } else {
            if (m.m00() > _t2) {
                return new DoubleQuat(0.5 * Math.sqrt(_t15), 0.5 * _t4 * _t21, 0.5 * _t6 * _t21, 0.5 * _t1 * _t21);
            } else {
                if (m.m11() > m.m22()) {
                    return new DoubleQuat(0.5 * _t4 * _t19, 0.5 * Math.sqrt(_t16), 0.5 * _t8 * _t19, 0.5 * _t7 * _t19);
                } else {
                    return new DoubleQuat(0.5 * _t6 * _t20, 0.5 * _t8 * _t20, 0.5 * Math.sqrt(_t17), 0.5 * _t9 * _t20);
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
    public static DoubleQuat makeFromMatrix(Double4x4 m) {
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
            return new DoubleQuat(0.5 * _t1 * _t18, 0.5 * _t7 * _t18, 0.5 * _t9 * _t18, 0.5 * Math.sqrt(_t14));
        } else {
            if (m.m00() > _t2) {
                return new DoubleQuat(0.5 * Math.sqrt(_t15), 0.5 * _t4 * _t21, 0.5 * _t6 * _t21, 0.5 * _t1 * _t21);
            } else {
                if (m.m11() > m.m22()) {
                    return new DoubleQuat(0.5 * _t4 * _t19, 0.5 * Math.sqrt(_t16), 0.5 * _t8 * _t19, 0.5 * _t7 * _t19);
                } else {
                    return new DoubleQuat(0.5 * _t6 * _t20, 0.5 * _t8 * _t20, 0.5 * Math.sqrt(_t17), 0.5 * _t9 * _t20);
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
    public DoubleDualQuat toDualQuat() {
        return new DoubleDualQuat(this.x, this.y, this.z, this.w, 0.0, 0.0, 0.0, 0.0);
    }


    /**
     * Compute the matrix representation of this quaternion, returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Double4x4 toMatrix() {
        double _t0 = this.z * this.z;
        double _t1 = this.z * this.w;
        double _t2 = this.y * this.w;
        return new Double4x4(Math.fma(-2.0, Math.fma(this.y, this.y, _t0), 1.0), 2.0 * Math.fma(this.x, this.y, -_t1), 2.0 * Math.fma(this.x, this.z, _t2), 0.0, 2.0 * Math.fma(this.x, this.y, _t1), Math.fma(-2.0, Math.fma(this.x, this.x, _t0), 1.0), 2.0 * Math.fma(this.y, this.z, -(this.x * this.w)), 0.0, 2.0 * Math.fma(this.x, this.z, -_t2), 2.0 * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0), 0.0, 0.0, 0.0, 0.0, 1.0, 0);
    }


    /**
     * Compute the 3x3 rotation matrix representation of this quaternion, returning the result as a
     * value.
     *
     * @return the resulting matrix
     */
    public Double3x3 toMatrix3x3() {
        double _t0 = this.z * this.z;
        double _t1 = this.z * this.w;
        double _t2 = this.y * this.w;
        return new Double3x3(Math.fma(-2.0, Math.fma(this.y, this.y, _t0), 1.0), 2.0 * Math.fma(this.x, this.y, -_t1), 2.0 * Math.fma(this.x, this.z, _t2), 2.0 * Math.fma(this.x, this.y, _t1), Math.fma(-2.0, Math.fma(this.x, this.x, _t0), 1.0), 2.0 * Math.fma(this.y, this.z, -(this.x * this.w)), 2.0 * Math.fma(this.x, this.z, -_t2), 2.0 * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0), 0);
    }


    /**
     * Compute the 3x4 matrix representation of this quaternion (the omitted last row is implicitly
     * {@code 0, 0, 0, 1}), returning the result as a value.
     *
     * @return the resulting matrix
     */
    public Double3x4 toMatrix3x4() {
        double _t0 = this.z * this.z;
        double _t1 = this.z * this.w;
        double _t2 = this.y * this.w;
        return new Double3x4(Math.fma(-2.0, Math.fma(this.y, this.y, _t0), 1.0), 2.0 * Math.fma(this.x, this.y, -_t1), 2.0 * Math.fma(this.x, this.z, _t2), 0.0, 2.0 * Math.fma(this.x, this.y, _t1), Math.fma(-2.0, Math.fma(this.x, this.x, _t0), 1.0), 2.0 * Math.fma(this.y, this.z, -(this.x * this.w)), 0.0, 2.0 * Math.fma(this.x, this.z, -_t2), 2.0 * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0), 0.0, 0);
    }

    /** Result value of {@code decomposeSwingTwist}. */
    public record DecomposeSwingTwistResult(DoubleQuat swing, DoubleQuat twist) {
        /** Canonical constructor. */
        public DecomposeSwingTwistResult(DoubleQuat swing, DoubleQuat twist) {
            this.swing = swing;
            this.twist = twist;
        }
        /** {@return the {@code swing} component} */
        public DoubleQuat swing() { return swing; }
        /** {@return the {@code twist} component} */
        public DoubleQuat twist() { return twist; }
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
    public DecomposeSwingTwistResult decomposeSwingTwist(Double3 axis) {
        double _t2 = Math.fma(axis.z(), this.z, Math.fma(axis.x(), this.x, axis.y() * this.y));
        double _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = this.w * _t5;
            _t12 = axis.x() * _t7;
            _t13 = axis.y() * _t7;
            _t14 = axis.z() * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        return new DecomposeSwingTwistResult(new DoubleQuat(Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14)), Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12)), Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14)), Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11)))), new DoubleQuat(_t12, _t13, _t14, _t11));
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
    public DoubleQuat getSwing(Double3 axis) {
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
    public DoubleQuat getSwing(double axisX, double axisY, double axisZ) {
        double _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        double _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = this.w * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        return new DoubleQuat(Math.fma(this.x, _t11, -(this.w * _t12)) + Math.fma(this.z, _t13, -(this.y * _t14)), Math.fma(this.x, _t14, -(this.w * _t13)) + Math.fma(this.y, _t11, -(this.z * _t12)), Math.fma(this.y, _t12, this.z * _t11) + Math.fma(-this.x, _t13, -(this.w * _t14)), Math.fma(this.z, _t14, Math.fma(this.y, _t13, Math.fma(this.x, _t12, this.w * _t11))));
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
    public DoubleQuat getTwist(Double3 axis) {
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
    public DoubleQuat getTwist(double axisX, double axisY, double axisZ) {
        double _t2 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        double _t4 = Math.fma(this.w, this.w, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            return new DoubleQuat(axisX * _t6, axisY * _t6, axisZ * _t6, this.w * _t5);
        } else {
            return new DoubleQuat(0.0, 0.0, 0.0, 1.0);
        }
    }


    /**
     * Create an identity quaternion.
     *
     * @return the resulting quaternion
     */
    public static DoubleQuat makeIdentity() {
        return new DoubleQuat(0.0, 0.0, 0.0, 1.0);
    }


    /**
     * Create an all-zero quaternion.
     *
     * @return the resulting quaternion
     */
    public static DoubleQuat makeZero() {
        return DoubleQuat.ZERO;
    }


    /**
     * Linearly interpolate between this quaternion and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other quaternion
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public DoubleQuat lerp(DoubleQuat other, double t) {
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
    public DoubleQuat lerp(double otherX, double otherY, double otherZ, double otherW, double t) {
        return new DoubleQuat(Math.fma(t, otherX - this.x, this.x), Math.fma(t, otherY - this.y, this.y), Math.fma(t, otherZ - this.z, this.z), Math.fma(t, otherW - this.w, this.w));
    }


    /**
     * Interpolate between this quaternion and {@code target} using the interpolation factor
     * {@code alpha} and normalize the result, returning the result as a value.
     *
     * @param target the target rotation
     * @param alpha the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting quaternion
     */
    public DoubleQuat nlerp(DoubleQuat target, double alpha) {
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
    public DoubleQuat nlerp(double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _t4 = Math.fma(alpha, targetW - this.w, this.w);
        double _t5 = Math.fma(alpha, targetZ - this.z, this.z);
        double _t6 = Math.fma(alpha, targetX - this.x, this.x);
        double _t7 = Math.fma(alpha, targetY - this.y, this.y);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            return new DoubleQuat(_t6 * _t12, _t7 * _t12, _t5 * _t12, _t4 * _t12);
        } else {
            return DoubleQuat.ZERO;
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
    public DoubleQuat nlerpShortest(DoubleQuat target, double alpha) {
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
    public DoubleQuat nlerpShortest(double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _t8 = -Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
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
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            return new DoubleQuat(_t19 * _t25, _t20 * _t25, _t18 * _t25, _t17 * _t25);
        } else {
            return DoubleQuat.ZERO;
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
    public DoubleQuat slerp(DoubleQuat target, double alpha) {
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
    public DoubleQuat slerp(double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6) {
            return new DoubleQuat(Math.fma(this.x, _t13, targetX * _t11) * _t8_inv, Math.fma(this.y, _t13, targetY * _t11) * _t8_inv, Math.fma(this.z, _t13, targetZ * _t11) * _t8_inv, Math.fma(this.w, _t13, targetW * _t11) * _t8_inv);
        } else {
            return new DoubleQuat(Math.fma(alpha, targetX, this.x * _t0), Math.fma(alpha, targetY, this.y * _t0), Math.fma(alpha, targetZ, this.z * _t0), Math.fma(alpha, targetW, this.w * _t0));
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
    public DoubleQuat slerpShortest(DoubleQuat target, double alpha) {
        return slerpShortest(target.x(), target.y(), target.z(), target.w(), alpha);
    }

    /** Private tail of {@code slerpShortest}; reached only through it. */
    private DoubleQuat slerpShortest_s66703101_tail(double _t17, double _t25, double _t19, double _t21, double _t17_inv, double alpha, double _t0, double _t22, double _t23, double _t24) {
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
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
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 > 0.0) {
            return new DoubleQuat(_t50 * _t44, _t50 * _t45, _t50 * _t43, _t50 * _t42);
        } else {
            return DoubleQuat.ZERO;
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
    public DoubleQuat slerpShortest(double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
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
        return slerpShortest_s66703101_tail(_t17, _t25, _t19, _t21, _t17_inv, alpha, _t0, _t22, _t23, _t24);
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
    public DoubleQuat squad(DoubleQuat control0, DoubleQuat control1, DoubleQuat target, double t) {
        return squad(control0.x(), control0.y(), control0.z(), control0.w(), control1.x(), control1.y(), control1.z(), control1.w(), target.x(), target.y(), target.z(), target.w(), t);
    }

    /** Private tail of {@code squad}; reached only through it. */
    private DoubleQuat squad_s59cffae7_tail(double _t39, double _t46, double targetW, double _t42, double _t36_inv, double t, double _t0, double _t37, double control0Z, double _t45, double control1Z, double _t41, double _t35_inv, double targetZ, double control0X, double control1X, double targetX, double control0Y, double control1Y, double targetY, double _t71, double _t13, double _t14) {
        double _t72, _t74, _t76;
        if (_t39 > 1.0E-6) {
            _t72 = Math.fma(this.w, _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(this.z, _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(this.x, _t46, targetX * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, this.w * _t0);
            _t74 = Math.fma(t, targetZ, this.z * _t0);
            _t76 = Math.fma(t, targetX, this.x * _t0);
        }
        double _t73, _t75, _t77;
        if (_t37 > 1.0E-6) {
            _t73 = Math.fma(control0Z, _t45, control1Z * _t41) * _t35_inv;
            _t75 = Math.fma(control0X, _t45, control1X * _t41) * _t35_inv;
            _t77 = Math.fma(control0Y, _t45, control1Y * _t41) * _t35_inv;
        } else {
            _t73 = Math.fma(t, control1Z, control0Z * _t0);
            _t75 = Math.fma(t, control1X, control0X * _t0);
            _t77 = Math.fma(t, control1Y, control0Y * _t0);
        }
        return squad_s59cffae7_tail2(_t39, _t46, targetY, _t42, _t36_inv, t, _t0, _t71, _t72, _t73, _t74, _t75, _t76, _t77, _t13, _t14);
    }

    /** Private tail of {@code squad}; reached only through it. */
    private DoubleQuat squad_s59cffae7_tail2(double _t39, double _t46, double targetY, double _t42, double _t36_inv, double t, double _t0, double _t71, double _t72, double _t73, double _t74, double _t75, double _t76, double _t77, double _t13, double _t14) {
        double _t78 = _t39 > 1.0E-6 ? Math.fma(this.y, _t46, targetY * _t42) * _t36_inv : Math.fma(t, targetY, this.y * _t0);
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        double _sfx0, _sfx1, _sfx2, _sfx3;
        if (_t87 > 1.0E-6) {
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
        return new DoubleQuat(_sfx0, _sfx1, _sfx2, _sfx3);
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
    public DoubleQuat squad(double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        double _t0 = 1.0 - t;
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY))))));
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
        double _t71 = _t37 > 1.0E-6 ? Math.fma(control0W, _t45, control1W * _t41) * _t35_inv : Math.fma(t, control1W, control0W * _t0);
        return squad_s59cffae7_tail(_t39, _t46, targetW, _t42, _t36_inv, t, _t0, _t37, control0Z, _t45, control1Z, _t41, _t35_inv, targetZ, control0X, control1X, targetX, control0Y, control1Y, targetY, _t71, _t13, _t14);
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
    public DoubleQuat mul(DoubleQuat other) {
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
    public DoubleQuat mul(double otherX, double otherY, double otherZ, double otherW) {
        return new DoubleQuat(Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherZ, this.y, -(otherY * this.z)), Math.fma(otherX, this.z, otherW * this.y) + Math.fma(otherY, this.w, -(otherZ * this.x)), Math.fma(otherY, this.x, otherZ * this.w) + Math.fma(otherW, this.z, -(otherX * this.y)), Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x)))));
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
    public DoubleQuat preMul(DoubleQuat other) {
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
    public DoubleQuat preMul(double otherX, double otherY, double otherZ, double otherW) {
        return new DoubleQuat(Math.fma(otherX, this.w, otherW * this.x) + Math.fma(otherY, this.z, -(otherZ * this.y)), Math.fma(otherY, this.w, otherZ * this.x) + Math.fma(otherW, this.y, -(otherX * this.z)), Math.fma(otherX, this.y, otherW * this.z) + Math.fma(otherZ, this.w, -(otherY * this.x)), Math.fma(-otherZ, this.z, Math.fma(-otherY, this.y, Math.fma(otherW, this.w, -(otherX * this.x)))));
    }


    /**
     * Compute the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     * unit length).
     *
     * @return the rotation angle in radians of this quaternion, within {@code [0, 2*PI]} (assumes
     *        unit length)
     */
    public double angle() {
        return 2.0 * Math.acos(Math.min(1.0, Math.max(-1.0, this.w)));
    }


    /**
     * Compute the angle in radians between this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the angle in radians between this quaternion and {@code other}
     */
    public double angleTo(DoubleQuat other) {
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
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y))))));
    }


    /**
     * Get the normalized rotation axis of this quaternion (zero when the rotation angle is zero),
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 axis() {
        double _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            return new Double3(this.x * _t3, this.y * _t3, this.z * _t3);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Recompute the {@code w} component of this quaternion from {@code x}, {@code y} and {@code z},
     * assuming unit length (the positive square root is chosen), returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat calculateW() {
        return new DoubleQuat(this.x, this.y, this.z, Math.sqrt(Math.max(0.0, Math.fma(-this.x, this.x, Math.fma(-this.y, this.y, Math.fma(-this.z, this.z, 1.0))))));
    }


    /**
     * Conjugate this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat conjugate() {
        return new DoubleQuat(-this.x, -this.y, -this.z, this.w);
    }


    /**
     * Conjugate this quaternion by {@code q}, i.e. compute {@code q * this * conj(q)} where
     * {@code q} is the given quaternion (equal to {@code q * this * q^-1} when it has unit length),
     * returning the result as a value.
     *
     * @param q the quaternion
     * @return the resulting quaternion
     */
    public DoubleQuat conjugateBy(DoubleQuat q) {
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
    public DoubleQuat conjugateBy(double qX, double qY, double qZ, double qW) {
        double _t1 = -qY;
        double _t21 = Math.fma(qX, this.y, qW * this.z) + Math.fma(qZ, this.w, -(qY * this.x));
        double _t22 = Math.fma(qY, this.w, qZ * this.x) + Math.fma(qW, this.y, -(qX * this.z));
        double _t23 = Math.fma(qX, this.w, qW * this.x) + Math.fma(qY, this.z, -(qZ * this.y));
        double _t24 = Math.fma(-qZ, this.z, Math.fma(_t1, this.y, Math.fma(qW, this.w, -(qX * this.x))));
        return new DoubleQuat(Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24)), Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21)), Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24)), Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24))));
    }


    /**
     * Compute the difference between this quaternion and {@code other}, i.e. the rotation that,
     * applied after {@code this}, results in {@code other}, returning the result as a value.
     *
     * @param other the other quaternion
     * @return the resulting quaternion
     */
    public DoubleQuat difference(DoubleQuat other) {
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
    public DoubleQuat difference(double otherX, double otherY, double otherZ, double otherW) {
        double _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        double _t3_inv = 1.0 / _t3;
        return new DoubleQuat((Math.fma(otherX, this.w, -(otherW * this.x)) + Math.fma(otherY, this.z, -(otherZ * this.y))) * _t3_inv, -(otherW * this.y * _t3_inv) - otherX * this.z * _t3_inv + Math.fma(otherY, this.w, otherZ * this.x) * _t3_inv, (Math.fma(otherX, this.y, -(otherW * this.z)) + Math.fma(otherZ, this.w, -(otherY * this.x))) * _t3_inv, Math.fma(otherZ, this.z, Math.fma(otherY, this.y, Math.fma(otherX, this.x, otherW * this.w))) * _t3_inv);
    }


    /**
     * Compute the dot product of this quaternion and {@code other}.
     *
     * @param other the other quaternion
     * @return the dot product of this quaternion and {@code other}
     */
    public double dot(DoubleQuat other) {
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
        return Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
    }


    /**
     * Compute the exponential of this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat exp() {
        double _t0 = Math.exp(this.w);
        double _t3 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        double _t4 = Math.sqrt(_t3);
        double _t8 = Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            return new DoubleQuat(this.x * _t8, this.y * _t8, this.z * _t8, Math.cos(_t4) * _t0);
        } else {
            return new DoubleQuat(0.0, 0.0, 0.0, Math.cos(_t4) * _t0);
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
    public Double3 getEulerAnglesXYZ() {
        double _t1 = this.y * this.z;
        double _t3 = this.z * this.z;
        double _t8 = 2.0 * Math.fma(this.x, this.z, this.y * this.w);
        double _t9 = 2.0 * Math.fma(this.x, this.w, -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            return new Double3(Math.atan2(2.0 * Math.fma(this.x, this.w, _t1), Math.fma(-2.0, Math.fma(this.x, this.x, _t3), 1.0)), Math.asin(Math.min(1.0, Math.max(-1.0, _t8))), 0.0);
        } else {
            return new Double3(Math.atan2(_t9, _t10), Math.asin(Math.min(1.0, Math.max(-1.0, _t8))), Math.atan2(2.0 * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0, Math.fma(this.y, this.y, _t3), 1.0)));
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
    public Double3 getEulerAnglesXZY() {
        double _t0 = this.z * this.z;
        double _t1 = this.y * this.z;
        double _t7 = 2.0 * Math.fma(this.x, this.w, _t1);
        double _t8 = 2.0 * Math.fma(this.z, this.w, -(this.x * this.y));
        double _t9 = Math.fma(-2.0, Math.fma(this.x, this.x, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            return new Double3(Math.atan2(2.0 * Math.fma(this.x, this.w, -_t1), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0)), 0.0, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        } else {
            return new Double3(Math.atan2(_t7, _t9), Math.atan2(2.0 * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0, Math.fma(this.y, this.y, _t0), 1.0)), Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
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
    public Double3 getEulerAnglesYXZ() {
        double _t3 = this.z * this.z;
        double _t8 = 2.0 * Math.fma(this.x, this.z, this.y * this.w);
        double _t9 = 2.0 * Math.fma(this.x, this.w, -(this.y * this.z));
        double _t10 = Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            return new Double3(Math.asin(Math.min(1.0, Math.max(-1.0, _t9))), Math.atan2(2.0 * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0, Math.fma(this.y, this.y, _t3), 1.0)), 0.0);
        } else {
            return new Double3(Math.asin(Math.min(1.0, Math.max(-1.0, _t9))), Math.atan2(_t8, _t10), Math.atan2(2.0 * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0, Math.fma(this.x, this.x, _t3), 1.0)));
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
    public Double3 getEulerAnglesYZX() {
        double _t0 = this.z * this.z;
        double _t7 = 2.0 * Math.fma(this.x, this.y, this.z * this.w);
        double _t8 = 2.0 * Math.fma(this.y, this.w, -(this.x * this.z));
        double _t9 = Math.fma(-2.0, Math.fma(this.y, this.y, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            return new Double3(0.0, Math.atan2(2.0 * Math.fma(this.x, this.z, this.y * this.w), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0)), Math.asin(Math.min(1.0, Math.max(-1.0, _t7))));
        } else {
            return new Double3(Math.atan2(2.0 * Math.fma(this.x, this.w, -(this.y * this.z)), Math.fma(-2.0, Math.fma(this.x, this.x, _t0), 1.0)), Math.atan2(_t8, _t9), Math.asin(Math.min(1.0, Math.max(-1.0, _t7))));
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
    public Double3 getEulerAnglesZXY() {
        double _t1 = this.z * this.z;
        double _t7 = 2.0 * Math.fma(this.x, this.w, this.y * this.z);
        double _t8 = 2.0 * Math.fma(this.z, this.w, -(this.x * this.y));
        double _t9 = Math.fma(-2.0, Math.fma(this.x, this.x, _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            return new Double3(Math.asin(Math.min(1.0, Math.max(-1.0, _t7))), 0.0, Math.atan2(2.0 * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0, Math.fma(this.y, this.y, _t1), 1.0)));
        } else {
            return new Double3(Math.asin(Math.min(1.0, Math.max(-1.0, _t7))), Math.atan2(2.0 * Math.fma(this.y, this.w, -(this.x * this.z)), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0)), Math.atan2(_t8, _t9));
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
    public Double3 getEulerAnglesZYX() {
        double _t0 = this.z * this.z;
        double _t7 = 2.0 * Math.fma(this.x, this.y, this.z * this.w);
        double _t8 = 2.0 * Math.fma(this.y, this.w, -(this.x * this.z));
        double _t9 = Math.fma(-2.0, Math.fma(this.y, this.y, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            return new Double3(0.0, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))), Math.atan2(2.0 * Math.fma(this.z, this.w, -(this.x * this.y)), Math.fma(-2.0, Math.fma(this.x, this.x, _t0), 1.0)));
        } else {
            return new Double3(Math.atan2(2.0 * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0)), Math.asin(Math.min(1.0, Math.max(-1.0, _t8))), Math.atan2(_t7, _t9));
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
    public DoubleQuat integrate(Double3 angularVel, double dt) {
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
    public DoubleQuat integrate(double angularVelX, double angularVelY, double angularVelZ, double dt) {
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
        return new DoubleQuat(Math.fma(this.x, _t9, this.w * _t15) + Math.fma(this.z, _t16, -(this.y * _t17)), Math.fma(this.x, _t17, this.w * _t16) + Math.fma(this.y, _t9, -(this.z * _t15)), Math.fma(this.y, _t15, this.z * _t9) + Math.fma(this.w, _t17, -(this.x * _t16)), Math.fma(-this.z, _t17, Math.fma(-this.y, _t16, Math.fma(this.w, _t9, -(this.x * _t15)))));
    }


    /**
     * Obtain the direction of {@code -X} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 invNegativeX() {
        double _t9 = 2.0 * Math.fma(this.x, this.z, this.y * this.w);
        double _t10 = 2.0 * Math.fma(this.x, this.y, -(this.z * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(-(_t12 * _t16), -(_t10 * _t16), -(_t9 * _t16));
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Y} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 invNegativeY() {
        double _t9 = 2.0 * Math.fma(this.x, this.y, this.z * this.w);
        double _t10 = 2.0 * Math.fma(this.y, this.z, -(this.x * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(-(_t9 * _t16), -(_t12 * _t16), -(_t10 * _t16));
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Z} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 invNegativeZ() {
        double _t9 = 2.0 * Math.fma(this.x, this.w, this.y * this.z);
        double _t10 = 2.0 * Math.fma(this.x, this.z, -(this.y * this.w));
        double _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(-(_t10 * _t16), -(_t9 * _t16), -(_t12 * _t16));
        } else {
            return Double3.ZERO;
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
    public Double3 invNormalizedNegativeX() {
        return new Double3(Math.fma(2.0, Math.fma(this.y, this.y, this.z * this.z), -1.0), -(2.0 * Math.fma(this.x, this.y, -(this.z * this.w))), -(2.0 * Math.fma(this.x, this.z, this.y * this.w)));
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
    public Double3 invNormalizedNegativeY() {
        return new Double3(-(2.0 * Math.fma(this.x, this.y, this.z * this.w)), Math.fma(2.0, Math.fma(this.x, this.x, this.z * this.z), -1.0), -(2.0 * Math.fma(this.y, this.z, -(this.x * this.w))));
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
    public Double3 invNormalizedNegativeZ() {
        return new Double3(-(2.0 * Math.fma(this.x, this.z, -(this.y * this.w))), -(2.0 * Math.fma(this.x, this.w, this.y * this.z)), Math.fma(2.0, Math.fma(this.x, this.x, this.y * this.y), -1.0));
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
    public Double3 invNormalizedPositiveX() {
        return new Double3(Math.fma(-2.0, Math.fma(this.y, this.y, this.z * this.z), 1.0), 2.0 * Math.fma(this.x, this.y, -(this.z * this.w)), 2.0 * Math.fma(this.x, this.z, this.y * this.w));
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
    public Double3 invNormalizedPositiveY() {
        return new Double3(2.0 * Math.fma(this.x, this.y, this.z * this.w), Math.fma(-2.0, Math.fma(this.x, this.x, this.z * this.z), 1.0), 2.0 * Math.fma(this.y, this.z, -(this.x * this.w)));
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
    public Double3 invNormalizedPositiveZ() {
        return new Double3(2.0 * Math.fma(this.x, this.z, -(this.y * this.w)), 2.0 * Math.fma(this.x, this.w, this.y * this.z), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0));
    }


    /**
     * Obtain the direction of {@code +X} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 invPositiveX() {
        double _t9 = 2.0 * Math.fma(this.x, this.z, this.y * this.w);
        double _t10 = 2.0 * Math.fma(this.x, this.y, -(this.z * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(_t12 * _t16, _t10 * _t16, _t9 * _t16);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Y} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 invPositiveY() {
        double _t9 = 2.0 * Math.fma(this.x, this.y, this.z * this.w);
        double _t10 = 2.0 * Math.fma(this.y, this.z, -(this.x * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(_t9 * _t16, _t12 * _t16, _t10 * _t16);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Z} before the transformation represented by this quaternion
     * is applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 invPositiveZ() {
        double _t9 = 2.0 * Math.fma(this.x, this.w, this.y * this.z);
        double _t10 = 2.0 * Math.fma(this.x, this.z, -(this.y * this.w));
        double _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(_t10 * _t16, _t9 * _t16, _t12 * _t16);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Compute the length of this quaternion.
     *
     * @return the length of this quaternion
     */
    public double length() {
        return Math.sqrt(Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y))));
    }


    /**
     * Compute the squared length of this quaternion.
     *
     * @return the squared length of this quaternion
     */
    public double lengthSquared() {
        return Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
    }


    /**
     * Compute the natural logarithm of this quaternion, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat log() {
        double _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        double _t4 = Math.fma(this.w, this.w, _t2);
        double _t8 = Math.acos(this.w * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            return new DoubleQuat(this.x * _t8, this.y * _t8, this.z * _t8, Math.log(Math.sqrt(_t4)));
        } else {
            return new DoubleQuat(0.0, 0.0, 0.0, Math.log(Math.sqrt(_t4)));
        }
    }


    /**
     * Obtain the direction of {@code -X} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 negativeX() {
        double _t9 = 2.0 * Math.fma(this.x, this.y, this.z * this.w);
        double _t10 = 2.0 * Math.fma(this.x, this.z, -(this.y * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(-(_t12 * _t16), -(_t9 * _t16), -(_t10 * _t16));
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Y} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 negativeY() {
        double _t9 = 2.0 * Math.fma(this.x, this.w, this.y * this.z);
        double _t10 = 2.0 * Math.fma(this.x, this.y, -(this.z * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(-(_t10 * _t16), -(_t12 * _t16), -(_t9 * _t16));
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code -Z} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 negativeZ() {
        double _t9 = 2.0 * Math.fma(this.x, this.z, this.y * this.w);
        double _t10 = 2.0 * Math.fma(this.y, this.z, -(this.x * this.w));
        double _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(-(_t9 * _t16), -(_t10 * _t16), -(_t12 * _t16));
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Normalize this quaternion to unit length, returning the result as a value.
     *
     * @return the resulting quaternion
     */
    public DoubleQuat normalize() {
        double _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            return new DoubleQuat(this.x * _t4, this.y * _t4, this.z * _t4, this.w * _t4);
        } else {
            return DoubleQuat.ZERO;
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
    public Double3 normalizedNegativeX() {
        return new Double3(Math.fma(2.0, Math.fma(this.y, this.y, this.z * this.z), -1.0), -(2.0 * Math.fma(this.x, this.y, this.z * this.w)), -(2.0 * Math.fma(this.x, this.z, -(this.y * this.w))));
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
    public Double3 normalizedNegativeY() {
        return new Double3(-(2.0 * Math.fma(this.x, this.y, -(this.z * this.w))), Math.fma(2.0, Math.fma(this.x, this.x, this.z * this.z), -1.0), -(2.0 * Math.fma(this.x, this.w, this.y * this.z)));
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
    public Double3 normalizedNegativeZ() {
        return new Double3(-(2.0 * Math.fma(this.x, this.z, this.y * this.w)), -(2.0 * Math.fma(this.y, this.z, -(this.x * this.w))), Math.fma(2.0, Math.fma(this.x, this.x, this.y * this.y), -1.0));
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
    public Double3 normalizedPositiveX() {
        return new Double3(Math.fma(-2.0, Math.fma(this.y, this.y, this.z * this.z), 1.0), 2.0 * Math.fma(this.x, this.y, this.z * this.w), 2.0 * Math.fma(this.x, this.z, -(this.y * this.w)));
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
    public Double3 normalizedPositiveY() {
        return new Double3(2.0 * Math.fma(this.x, this.y, -(this.z * this.w)), Math.fma(-2.0, Math.fma(this.x, this.x, this.z * this.z), 1.0), 2.0 * Math.fma(this.x, this.w, this.y * this.z));
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
    public Double3 normalizedPositiveZ() {
        return new Double3(2.0 * Math.fma(this.x, this.z, this.y * this.w), 2.0 * Math.fma(this.y, this.z, -(this.x * this.w)), Math.fma(-2.0, Math.fma(this.x, this.x, this.y * this.y), 1.0));
    }


    /**
     * Obtain the direction of {@code +X} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 positiveX() {
        double _t9 = 2.0 * Math.fma(this.x, this.y, this.z * this.w);
        double _t10 = 2.0 * Math.fma(this.x, this.z, -(this.y * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.x, this.x, this.w * this.w)));
        double _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(_t12 * _t16, _t9 * _t16, _t10 * _t16);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Y} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 positiveY() {
        double _t9 = 2.0 * Math.fma(this.x, this.w, this.y * this.z);
        double _t10 = 2.0 * Math.fma(this.x, this.y, -(this.z * this.w));
        double _t12 = Math.fma(-this.z, this.z, Math.fma(this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(_t10 * _t16, _t12 * _t16, _t9 * _t16);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Obtain the direction of {@code +Z} after the transformation represented by this quaternion is
     * applied, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 positiveZ() {
        double _t9 = 2.0 * Math.fma(this.x, this.z, this.y * this.w);
        double _t10 = 2.0 * Math.fma(this.y, this.z, -(this.x * this.w));
        double _t12 = Math.fma(this.z, this.z, Math.fma(-this.y, this.y, Math.fma(this.w, this.w, -(this.x * this.x))));
        double _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        double _t16 = (1.0 / Math.sqrt(_t15));
        if (_t15 > 0.0) {
            return new Double3(_t9 * _t16, _t10 * _t16, _t12 * _t16);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Raise this quaternion to the power of {@code t}, i.e. compute {@code exp(t * log(this))},
     * returning the result as a value.
     *
     * @param t the exponent
     * @return the resulting quaternion
     */
    public DoubleQuat pow(double t) {
        double _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        double _t4 = Math.fma(this.w, this.w, _t2);
        double _t11 = Math.exp(t * Math.log(Math.sqrt(_t4)));
        double _t12 = Math.acos(this.w * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        double _t19, _t20, _t21;
        if (_t2 > 0.0) {
            _t19 = t * this.z * _t12;
            _t20 = t * this.x * _t12;
            _t21 = t * this.y * _t12;
        } else {
            _t19 = t * 0.0;
            _t20 = t * 0.0;
            _t21 = t * 0.0;
        }
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = Math.sqrt(_t24);
        double _t29 = Math.sin(_t25) * _t11 * (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            return new DoubleQuat(_t20 * _t29, _t21 * _t29, _t19 * _t29, Math.cos(_t25) * _t11);
        } else {
            return new DoubleQuat(0.0, 0.0, 0.0, Math.cos(_t25) * _t11);
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
    public DoubleQuat premul(DoubleQuat other) {
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
    public DoubleQuat premul(double otherX, double otherY, double otherZ, double otherW) {
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
    public DoubleQuat rotateTowards(DoubleQuat target, double step) {
        return rotateTowards(target.x(), target.y(), target.z(), target.w(), step);
    }

    /** Private tail of {@code rotateTowards}; reached only through it. */
    private DoubleQuat rotateTowards_s287f86c9_tail(double _t12, double _t25, double _t23, double _t15, double _t12_inv, double _t21, double _t20, double _t16, double _t17, double _t18) {
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
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
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            return new DoubleQuat(_t54 * _t48, _t54 * _t49, _t54 * _t47, _t54 * _t46);
        } else {
            return DoubleQuat.ZERO;
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
    public DoubleQuat rotateTowards(double targetX, double targetY, double targetZ, double targetW, double step) {
        double _t7 = Math.fma(this.w, targetW, Math.fma(this.z, targetZ, Math.fma(this.x, targetX, this.y * targetY)));
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
        return rotateTowards_s287f86c9_tail(_t12, _t25, _t23, _t15, _t12_inv, _t21, _t20, _t16, _t17, _t18);
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
    public DoubleQuat lookAlong(Double3 dir, Double3 up) {
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
    public DoubleQuat lookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t110, this.w * _t111) + Math.fma(this.y, _t108, -(this.z * _t109)), Math.fma(this.y, _t110, this.z * _t111) + Math.fma(this.w, _t109, -(this.x * _t108)), Math.fma(this.x, _t109, this.w * _t108) + Math.fma(this.z, _t110, -(this.y * _t111)), Math.fma(-this.z, _t108, Math.fma(-this.y, _t109, Math.fma(this.w, _t110, -(this.x * _t111)))));
    }


    /**
     * Create a rotation of {@code angle} radians about the axis {@code axis}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting quaternion
     */
    public static DoubleQuat makeRotationAxis(double angle, Double3 axis) {
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
    public static DoubleQuat makeRotationAxis(double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        return new DoubleQuat(axisX * _t1, axisY * _t1, axisZ * _t1, Math.cos(_t0));
    }


    /**
     * Create a rotation that makes {@code +z} point along {@code dir}.
     *
     * @param dir the direction
     * @param up the direction of "up"
     * @return the resulting quaternion
     */
    public static DoubleQuat makeRotationLookAlong(Double3 dir, Double3 up) {
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
    public static DoubleQuat makeRotationLookAlong(double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
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
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            return new DoubleQuat(0.5 * _t55 * _t64, 0.5 * _t38 * _t64, 0.5 * _t58 * _t64, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                return new DoubleQuat(0.5 * Math.sqrt(_t61), 0.5 * _t57 * _t67, 0.5 * _t37 * _t67, 0.5 * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    return new DoubleQuat(0.5 * _t57 * _t65, 0.5 * Math.sqrt(_t62), 0.5 * _t54 * _t65, 0.5 * _t38 * _t65);
                } else {
                    return new DoubleQuat(0.5 * _t37 * _t66, 0.5 * _t54 * _t66, 0.5 * Math.sqrt(_t63), 0.5 * _t58 * _t66);
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
    public static DoubleQuat makeRotationTo(Double3 fromDir, Double3 toDir) {
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
    public static DoubleQuat makeRotationTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
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
            return new DoubleQuat(Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11, Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11, Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11, 0.5 * Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0) {
                return new DoubleQuat(_t15 * _t6, _t15 * _t9, _t15 * _t8, 0.0);
            } else {
                return DoubleQuat.ZERO;
            }
        }
    }


    /**
     * Create a rotation of {@code angle} radians about the X axis.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public static DoubleQuat makeRotationX(double angle) {
        double _t0 = 0.5 * angle;
        return new DoubleQuat(Math.sin(_t0), 0.0, 0.0, Math.cos(_t0));
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
    public static DoubleQuat makeRotationXYZ(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)));
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
    public static DoubleQuat makeRotationXZY(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t8, _t11 * _t5));
    }


    /**
     * Create a rotation of {@code angle} radians about the Y axis.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public static DoubleQuat makeRotationY(double angle) {
        double _t0 = 0.5 * angle;
        return new DoubleQuat(0.0, Math.sin(_t0), 0.0, Math.cos(_t0));
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
    public static DoubleQuat makeRotationYXZ(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t10, _t5, -(_t9 * _t8)), Math.fma(_t11, _t8, -(_t12 * _t5)), Math.fma(_t12, _t8, _t11 * _t5));
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
    public static DoubleQuat makeRotationYZX(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(_t9, _t5, _t10 * _t8), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t12, _t5, -(_t11 * _t8)), Math.fma(_t10, _t5, -(_t9 * _t8)));
    }


    /**
     * Create a rotation of {@code angle} radians about the Z axis.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public static DoubleQuat makeRotationZ(double angle) {
        double _t0 = 0.5 * angle;
        return new DoubleQuat(0.0, 0.0, Math.sin(_t0), Math.cos(_t0));
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
    public static DoubleQuat makeRotationZXY(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t5, _t12 * _t8), Math.fma(_t9, _t8, _t10 * _t5), Math.fma(_t12, _t5, -(_t11 * _t8)));
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
    public static DoubleQuat makeRotationZYX(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(_t9, _t5, -(_t10 * _t8)), Math.fma(_t11, _t8, _t12 * _t5), Math.fma(_t12, _t8, -(_t11 * _t5)), Math.fma(_t10, _t5, _t9 * _t8));
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
    public DoubleQuat preRotateX(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        return new DoubleQuat(Math.fma(this.x, _t1, this.w * _t2), Math.fma(this.y, _t1, -(this.z * _t2)), Math.fma(this.y, _t2, this.z * _t1), Math.fma(this.w, _t1, -(this.x * _t2)));
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
    public DoubleQuat preRotateY(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        return new DoubleQuat(Math.fma(this.x, _t1, this.z * _t2), Math.fma(this.y, _t1, this.w * _t2), Math.fma(this.z, _t1, -(this.x * _t2)), Math.fma(this.w, _t1, -(this.y * _t2)));
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
    public DoubleQuat preRotateZ(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        return new DoubleQuat(Math.fma(this.x, _t1, -(this.y * _t2)), Math.fma(this.x, _t2, this.y * _t1), Math.fma(this.z, _t1, this.w * _t2), Math.fma(this.w, _t1, -(this.z * _t2)));
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
    public DoubleQuat rotateAxis(double angle, Double3 axis) {
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
    public DoubleQuat rotateAxis(double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        return new DoubleQuat(Math.fma(this.x, _t1, this.w * _t3) + Math.fma(this.y, _t4, -(this.z * _t5)), Math.fma(this.y, _t1, this.z * _t3) + Math.fma(this.w, _t5, -(this.x * _t4)), Math.fma(this.x, _t5, this.w * _t4) + Math.fma(this.z, _t1, -(this.y * _t3)), Math.fma(-this.z, _t4, Math.fma(-this.y, _t5, Math.fma(this.w, _t1, -(this.x * _t3)))));
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
    public DoubleQuat rotateTo(Double3 fromDir, Double3 toDir) {
        return rotateTo(fromDir.x(), fromDir.y(), fromDir.z(), toDir.x(), toDir.y(), toDir.z());
    }

    /** Private tail of {@code rotateTo}; reached only through it. */
    private DoubleQuat rotateTo_s6ca4b61d_tail(double _t16, double fromDirY, double toDirZ, double fromDirZ, double toDirY, double _t21, double _t29, double _t30, double _t15, double fromDirX, double toDirX, double _t17, double _t18, double _t27) {
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
        return new DoubleQuat(Math.fma(this.x, _t27, this.w * _t37) + Math.fma(this.y, _t38, -(this.z * _t39)), Math.fma(this.y, _t27, this.z * _t37) + Math.fma(this.w, _t39, -(this.x * _t38)), Math.fma(this.x, _t39, this.w * _t38) + Math.fma(this.z, _t27, -(this.y * _t37)), Math.fma(-this.z, _t38, Math.fma(-this.y, _t39, Math.fma(this.w, _t27, -(this.x * _t37)))));
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
    public DoubleQuat rotateTo(double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
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
        return rotateTo_s6ca4b61d_tail(_t16, fromDirY, toDirZ, fromDirZ, toDirY, _t21, _t29, _t30, _t15, fromDirX, toDirX, _t17, _t18, _t27);
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local X axis, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public DoubleQuat rotateX(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        return new DoubleQuat(Math.fma(this.x, _t1, this.w * _t2), Math.fma(this.y, _t1, this.z * _t2), Math.fma(this.z, _t1, -(this.y * _t2)), Math.fma(this.w, _t1, -(this.x * _t2)));
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
    public DoubleQuat rotateXYZ(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t20, -(this.z * _t22)), Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t22, -(this.x * _t20)), Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t21, -(this.y * _t19)), Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t21, -(this.x * _t19)))));
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
    public DoubleQuat rotateXZY(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t20, -(this.z * _t22)), Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t22, -(this.x * _t20)), Math.fma(this.x, _t22, this.w * _t20) + Math.fma(this.z, _t19, -(this.y * _t21)), Math.fma(-this.z, _t20, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t21)))));
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Y axis, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public DoubleQuat rotateY(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        return new DoubleQuat(Math.fma(this.x, _t1, -(this.z * _t2)), Math.fma(this.y, _t1, this.w * _t2), Math.fma(this.x, _t2, this.z * _t1), Math.fma(this.w, _t1, -(this.y * _t2)));
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
    public DoubleQuat rotateYXZ(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t19, this.w * _t20) + Math.fma(this.y, _t21, -(this.z * _t22)), Math.fma(this.y, _t19, this.z * _t20) + Math.fma(this.w, _t22, -(this.x * _t21)), Math.fma(this.x, _t22, this.w * _t21) + Math.fma(this.z, _t19, -(this.y * _t20)), Math.fma(-this.z, _t21, Math.fma(-this.y, _t22, Math.fma(this.w, _t19, -(this.x * _t20)))));
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
    public DoubleQuat rotateYZX(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t21, this.w * _t19) + Math.fma(this.y, _t22, -(this.z * _t20)), Math.fma(this.y, _t21, this.z * _t19) + Math.fma(this.w, _t20, -(this.x * _t22)), Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t21, -(this.y * _t19)), Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t19)))));
    }


    /**
     * Rotate this quaternion by {@code angle} radians about the local Z axis, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @return the resulting quaternion
     */
    public DoubleQuat rotateZ(double angle) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        return new DoubleQuat(Math.fma(this.x, _t1, this.y * _t2), Math.fma(this.y, _t1, -(this.x * _t2)), Math.fma(this.z, _t1, this.w * _t2), Math.fma(this.w, _t1, -(this.z * _t2)));
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
    public DoubleQuat rotateZXY(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t21, this.w * _t22) + Math.fma(this.y, _t19, -(this.z * _t20)), Math.fma(this.y, _t21, this.z * _t22) + Math.fma(this.w, _t20, -(this.x * _t19)), Math.fma(this.x, _t20, this.w * _t19) + Math.fma(this.z, _t21, -(this.y * _t22)), Math.fma(-this.z, _t19, Math.fma(-this.y, _t20, Math.fma(this.w, _t21, -(this.x * _t22)))));
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
    public DoubleQuat rotateZYX(double angleX, double angleY, double angleZ) {
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
        return new DoubleQuat(Math.fma(this.x, _t19, this.w * _t21) + Math.fma(this.y, _t22, -(this.z * _t20)), Math.fma(this.y, _t19, this.z * _t21) + Math.fma(this.w, _t20, -(this.x * _t22)), Math.fma(this.x, _t20, this.w * _t22) + Math.fma(this.z, _t19, -(this.y * _t21)), Math.fma(-this.z, _t22, Math.fma(-this.y, _t20, Math.fma(this.w, _t19, -(this.x * _t21)))));
    }


    /**
     * Transform {@code v} by this quaternion, returning the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Double3 transform(Double3 v) {
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
    public Double3 transform(double vX, double vY, double vZ) {
        double _t9 = 2.0 * Math.fma(this.x, vY, -(this.y * vX));
        double _t10 = 2.0 * Math.fma(this.z, vX, -(this.x * vZ));
        double _t11 = 2.0 * Math.fma(this.y, vZ, -(this.z * vY));
        return new Double3(Math.fma(this.y, _t9, Math.fma(-this.z, _t10, Math.fma(this.w, _t11, vX))), Math.fma(this.z, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vY))), Math.fma(this.x, _t10, Math.fma(-this.y, _t11, Math.fma(this.w, _t9, vZ))));
    }


    /**
     * Transform {@code v} by the inverse of this quaternion (assumes a unit quaternion), returning
     * the result as a value.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Double3 transformInverse(Double3 v) {
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
    public Double3 transformInverse(double vX, double vY, double vZ) {
        double _t9 = 2.0 * Math.fma(this.x, vZ, -(this.z * vX));
        double _t10 = 2.0 * Math.fma(this.y, vX, -(this.x * vY));
        double _t11 = 2.0 * Math.fma(this.z, vY, -(this.y * vZ));
        return new Double3(Math.fma(this.z, _t9, Math.fma(-this.y, _t10, Math.fma(this.w, _t11, vX))), Math.fma(this.x, _t10, Math.fma(-this.z, _t11, Math.fma(this.w, _t9, vY))), Math.fma(this.y, _t11, Math.fma(-this.x, _t9, Math.fma(this.w, _t10, vZ))));
    }

    /** {@return a copy with the {@code x} component replaced by {@code v}} */
    public DoubleQuat withX(double v) {
        return new DoubleQuat(v, y, z, w);
    }

    /** {@return a copy with the {@code y} component replaced by {@code v}} */
    public DoubleQuat withY(double v) {
        return new DoubleQuat(x, v, z, w);
    }

    /** {@return a copy with the {@code z} component replaced by {@code v}} */
    public DoubleQuat withZ(double v) {
        return new DoubleQuat(x, y, v, w);
    }

    /** {@return a copy with the {@code w} component replaced by {@code v}} */
    public DoubleQuat withW(double v) {
        return new DoubleQuat(x, y, z, v);
    }

    @Override public String toString() {
        return "DoubleQuat(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleQuat)) return false;
        DoubleQuat o = (DoubleQuat) obj;
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

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Double.isFinite(x)
            && Double.isFinite(y)
            && Double.isFinite(z)
            && Double.isFinite(w);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(DoubleQuat other, double epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(w - other.w()) <= epsilon;
    }

    static final DoubleQuatBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleQuatBbOpsUnsafe()
                    : new DoubleQuatBbOpsApi();
    static final DoubleQuatRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleQuatRawOpsUnsafe()
                    : new DoubleQuatRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
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
     * Store the elements into the given array.
     *
     * @param dest the destination array
     * @return dest
     */
    public double[] store(double[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, starting at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(double[] src, int offset) {
        double _c0 = src[offset + 0];
        double _c1 = src[offset + 1];
        double _c2 = src[offset + 2];
        double _c3 = src[offset + 3];
        return new DoubleQuat(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer store(DoubleBuffer buf) {
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
    public DoubleBuffer storeAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, starting at its current position and advancing the
     * position accordingly.
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
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the source buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        DoubleQuat r = loadAbsolute(pos, buf);
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
        buf.position(pos + 32);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        DoubleQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 32);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public DoubleQuat storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }


    /**
     * Store the elements into the given array, converting each element to {@code float}, starting
     * at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = (float) this.x;
        dest[offset + 1] = (float) this.y;
        dest[offset + 2] = (float) this.z;
        dest[offset + 3] = (float) this.w;
        return dest;
    }

    /**
     * Store the elements into the given array, converting each element to {@code float}.
     *
     * @param dest the destination array
     * @return dest
     */
    public float[] store(float[] dest) { return store(dest, 0); }

    /**
     * Load the elements from the given array, converting each element from {@code float}, starting
     * at the given offset.
     *
     * @param src the source array
     * @param offset the start offset in the array, in elements
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(float[] src, int offset) {
        double _c0 = src[offset + 0];
        double _c1 = src[offset + 1];
        double _c2 = src[offset + 2];
        double _c3 = src[offset + 3];
        return new DoubleQuat(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array, converting each element from {@code float}.
     *
     * @param src the source array
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code float}, starting
     * at its current position (the position is not modified).
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer store(FloatBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code float}, starting
     * at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code float}, starting
     * at its current position and advancing the position accordingly.
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
     * Load the elements from the given buffer, converting each element from {@code float}, starting
     * at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code float}, starting
     * at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code float}, starting
     * at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        DoubleQuat r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeFloat(ByteBuffer buf) {
        return storeFloatAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeFloatRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeFloatAbsolute(pos, buf);
        buf.position(pos + 16);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadFloat(ByteBuffer buf) {
        return loadFloatAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadFloatRelative(ByteBuffer buf) {
        int pos = buf.position();
        DoubleQuat r = loadFloatAbsolute(pos, buf);
        buf.position(pos + 16);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public DoubleQuat storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code DoubleQuat} holding the loaded elements
     */
    public static DoubleQuat loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(address);
    }

}
