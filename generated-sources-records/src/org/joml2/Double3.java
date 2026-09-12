package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Immutable 3D vector of double-precision {@code double} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Double.doubleToLongBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
 * NaN. {@code hashCode} is consistent with it (derived from the same bit patterns).
 * <p>
 * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
 * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and a
 * NaN component never compares equal to anything.
 *
 * @param x the {@code x} component
 * @param y the {@code y} component
 * @param z the {@code z} component
 */
public record Double3(double x, double y, double z) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 24;

    /** The zero vector (all components 0). */
    public static final Double3 ZERO = new Double3(0, 0, 0);

    /** Canonical constructor. */
    public Double3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Create a new instance initialized to all zeros.
     */
    public Double3() {
        this(0, 0, 0);
    }

    /** Create a vector with all components set to {@code s}. */
    public Double3(double s) {
        this(s, s, s);
    }

    /** Create a vector composed of the given parts, in order. */
    public Double3(double v0, Double2 v1) {
        this(v0, v1.x(), v1.y());
    }

    /** Create a vector composed of the given parts, in order. */
    public Double3(Double2 v0, double v1) {
        this(v0.x(), v0.y(), v1);
    }

    /** {@return the {@code x} component} */
    public double x() { return x; }
    /** {@return the {@code y} component} */
    public double y() { return y; }
    /** {@return the {@code z} component} */
    public double z() { return z; }


    /**
     * Add {@code other} to this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 add(Double3 other) {
        return add(other.x(), other.y(), other.z());
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}) to this vector, returning the result as
     * a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 add(double otherX, double otherY, double otherZ) {
        return new Double3(otherX + this.x, otherY + this.y, otherZ + this.z);
    }


    /**
     * Divide each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double3 div(double scalar) {
        return div(scalar, scalar, scalar);
    }


    /**
     * Divide this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 div(Double3 other) {
        return div(other.x(), other.y(), other.z());
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ}),
     * returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 div(double otherX, double otherY, double otherZ) {
        return new Double3(this.x / otherX, this.y / otherY, this.z / otherZ);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Double3 fma(double b, Double3 c) {
        return fma(b, c.x(), c.y(), c.z());
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY},
     * {@code cZ}), i.e. compute {@code this * b + (cX, cY, cZ)} per component, returning the result
     * as a value.
     *
     * @param b the factor to multiply this vector by
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @return the resulting vector
     */
    public Double3 fma(double b, double cX, double cY, double cZ) {
        return new Double3(Math.fma(this.x, b, cX), Math.fma(this.y, b, cY), Math.fma(this.z, b, cZ));
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Double3 fma(Double3 b, Double3 c) {
        return fma(b.x(), b.y(), b.z(), c.x(), c.y(), c.z());
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * (bX, bY, bZ) + (cX, cY, cZ)}
     * per component, returning the result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @return the resulting vector
     */
    public Double3 fma(double bX, double bY, double bZ, double cX, double cY, double cZ) {
        return new Double3(Math.fma(this.x, bX, cX), Math.fma(this.y, bY, cY), Math.fma(this.z, bZ, cZ));
    }


    /**
     * Multiply each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double3 mul(double scalar) {
        return mul(scalar, scalar, scalar);
    }


    /**
     * Multiply this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 mul(Double3 other) {
        return mul(other.x(), other.y(), other.z());
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ}),
     * returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 mul(double otherX, double otherY, double otherZ) {
        return new Double3(otherX * this.x, otherY * this.y, otherZ * this.z);
    }


    /**
     * Negate this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 negate() {
        return new Double3(-this.x, -this.y, -this.z);
    }


    /**
     * Subtract {@code other} from this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 sub(Double3 other) {
        return sub(other.x(), other.y(), other.z());
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}) from this vector, returning the
     * result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 sub(double otherX, double otherY, double otherZ) {
        return new Double3(this.x - otherX, this.y - otherY, this.z - otherZ);
    }


    /**
     * Create a new vector from the given values.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Double3 set(Double3 v) {
        return set(v.x(), v.y(), v.z());
    }


    /**
     * Create a new vector from the given values.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return the resulting vector
     */
    public Double3 set(double vX, double vY, double vZ) {
        return new Double3(vX, vY, vZ);
    }


    /**
     * Set this vector to {@code s}, returning the result as a value.
     *
     * @param s the value assigned to every component
     * @return the resulting vector
     */
    public Double3 set(double s) {
        return new Double3(s, s, s);
    }


    /**
     * Convert this vector to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code Float3} holding the result
     */
    public Float3 toFloat() {
        return new Float3((float) (this.x), (float) (this.y), (float) (this.z));
    }


    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Byte3} holding the result
     */
    public Byte3 toByte() {
        return new Byte3((byte) (this.x), (byte) (this.y), (byte) (this.z));
    }


    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Byte3} holding the result
     */
    public Byte3 toByte(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toByte();
            case FLOOR -> new Byte3((byte) Math.floor(this.x), (byte) Math.floor(this.y), (byte) Math.floor(this.z));
            case CEILING -> new Byte3((byte) Math.ceil(this.x), (byte) Math.ceil(this.y), (byte) Math.ceil(this.z));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Byte3((byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x))), (byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y))), (byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z))));
            case HALF_AWAY_FROM_ZERO -> new Byte3((byte) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (byte) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)), (byte) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z)));
            case HALF_EVEN -> new Byte3((byte) Math.rint(this.x), (byte) Math.rint(this.y), (byte) Math.rint(this.z));
        };
    }


    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Short3} holding the result
     */
    public Short3 toShort() {
        return new Short3((short) (this.x), (short) (this.y), (short) (this.z));
    }


    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Short3} holding the result
     */
    public Short3 toShort(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toShort();
            case FLOOR -> new Short3((short) Math.floor(this.x), (short) Math.floor(this.y), (short) Math.floor(this.z));
            case CEILING -> new Short3((short) Math.ceil(this.x), (short) Math.ceil(this.y), (short) Math.ceil(this.z));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Short3((short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x))), (short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y))), (short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z))));
            case HALF_AWAY_FROM_ZERO -> new Short3((short) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (short) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)), (short) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z)));
            case HALF_EVEN -> new Short3((short) Math.rint(this.x), (short) Math.rint(this.y), (short) Math.rint(this.z));
        };
    }


    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Int3} holding the result
     */
    public Int3 toInt() {
        return new Int3((int) (this.x), (int) (this.y), (int) (this.z));
    }


    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Int3} holding the result
     */
    public Int3 toInt(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toInt();
            case FLOOR -> new Int3((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z));
            case CEILING -> new Int3((int) Math.ceil(this.x), (int) Math.ceil(this.y), (int) Math.ceil(this.z));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Int3((int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x))), (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y))), (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z))));
            case HALF_AWAY_FROM_ZERO -> new Int3((int) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (int) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)), (int) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z)));
            case HALF_EVEN -> new Int3((int) Math.rint(this.x), (int) Math.rint(this.y), (int) Math.rint(this.z));
        };
    }


    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Long3} holding the result
     */
    public Long3 toLong() {
        return new Long3((long) (this.x), (long) (this.y), (long) (this.z));
    }


    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Long3} holding the result
     */
    public Long3 toLong(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toLong();
            case FLOOR -> new Long3((long) Math.floor(this.x), (long) Math.floor(this.y), (long) Math.floor(this.z));
            case CEILING -> new Long3((long) Math.ceil(this.x), (long) Math.ceil(this.y), (long) Math.ceil(this.z));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Long3(Math.round(this.x), Math.round(this.y), Math.round(this.z));
            case HALF_AWAY_FROM_ZERO -> new Long3((long) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (long) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)), (long) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z)));
            case HALF_EVEN -> new Long3((long) Math.rint(this.x), (long) Math.rint(this.y), (long) Math.rint(this.z));
        };
    }


    /**
     * Create an all-zero vector.
     *
     * @return the resulting vector
     */
    public static Double3 makeZero() {
        return Double3.ZERO;
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezier(Double3 p1, Double3 p2, Double3 p3, double t) {
        return bezier(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t);
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezier(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        return new Double3(Math.fma(p1X, _t7, this.x * _t8) + Math.fma(p2X, _t6, p3X * _t2), Math.fma(p1Y, _t7, this.y * _t8) + Math.fma(p2Y, _t6, p3Y * _t2), Math.fma(p1Z, _t7, this.z * _t8) + Math.fma(p2Z, _t6, p3Z * _t2));
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points, returning the result as a value.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezier2(Double3 p1, Double3 p2, double t) {
        return bezier2(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t);
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points, returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezier2(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t) {
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        return new Double3(Math.fma(p2X, _t0, Math.fma(p1X, _t3, this.x * _t4)), Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, this.y * _t4)), Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, this.z * _t4)));
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}, returning the result
     * as a value.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezier2Tangent(Double3 p1, Double3 p2, double t) {
        return bezier2Tangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}, returning the result
     * as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezier2Tangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t) {
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        return new Double3(Math.fma(p1X - this.x, _t2, (p2X - p1X) * _t1), Math.fma(p1Y - this.y, _t2, (p2Y - p1Y) * _t1), Math.fma(p1Z - this.z, _t2, (p2Z - p1Z) * _t1));
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezierTangent(Double3 p1, Double3 p2, Double3 p3, double t) {
        return bezierTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 bezierTangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        return new Double3(Math.fma(p3X - p2X, _t2, Math.fma(p1X - this.x, _t6, (p2X - p1X) * _t5)), Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - this.y, _t6, (p2Y - p1Y) * _t5)), Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - this.z, _t6, (p2Z - p1Z) * _t5)));
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 catmullRom(Double3 p1, Double3 p2, Double3 p3, double t) {
        return catmullRom(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t);
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 catmullRom(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _t0 = t * t;
        double _t1 = t * _t0;
        return new Double3(0.5 * (Math.fma(2.0, p1X, t * (p2X - this.x)) + Math.fma(Math.fma(-5.0, p1X, Math.fma(2.0, this.x, Math.fma(4.0, p2X, -p3X))), _t0, Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - this.x)) * _t1)), 0.5 * (Math.fma(2.0, p1Y, t * (p2Y - this.y)) + Math.fma(Math.fma(-5.0, p1Y, Math.fma(2.0, this.y, Math.fma(4.0, p2Y, -p3Y))), _t0, Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - this.y)) * _t1)), 0.5 * (Math.fma(2.0, p1Z, t * (p2Z - this.z)) + Math.fma(Math.fma(-5.0, p1Z, Math.fma(2.0, this.z, Math.fma(4.0, p2Z, -p3Z))), _t0, Math.fma(-3.0, p2Z, Math.fma(3.0, p1Z, p3Z - this.z)) * _t1)));
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 catmullRomTangent(Double3 p1, Double3 p2, Double3 p3, double t) {
        return catmullRomTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 catmullRomTangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _t0 = t * t;
        return new Double3(0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1X, Math.fma(2.0, this.x, Math.fma(4.0, p2X, -p3X))), Math.fma(3.0 * Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - this.x)), _t0, p2X - this.x)), 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Y, Math.fma(2.0, this.y, Math.fma(4.0, p2Y, -p3Y))), Math.fma(3.0 * Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - this.y)), _t0, p2Y - this.y)), 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Z, Math.fma(2.0, this.z, Math.fma(4.0, p2Z, -p3Z))), Math.fma(3.0 * Math.fma(-3.0, p2Z, Math.fma(3.0, p1Z, p3Z - this.z)), _t0, p2Z - this.z)));
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation,
     * returning the result as a value.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 hermite(Double3 t0, Double3 v1, Double3 t1, double t) {
        return hermite(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t);
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation,
     * returning the result as a value.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Z the {@code z} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Z the {@code z} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Z the {@code z} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 hermite(double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t) {
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        return new Double3(Math.fma(this.x, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9), Math.fma(this.y, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9), Math.fma(this.z, _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9));
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}, returning the result as a
     * value.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 hermiteTangent(Double3 t0, Double3 v1, Double3 t1, double t) {
        return hermiteTangent(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}, returning the result as a
     * value.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param t0Z the {@code z} component of the vector {@code (t0X, t0Y, t0Z)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param v1Z the {@code z} component of the vector {@code (v1X, v1Y, v1Z)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t1Z the {@code z} component of the vector {@code (t1X, t1Y, t1Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 hermiteTangent(double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t) {
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        return new Double3(Math.fma(this.x, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7), Math.fma(this.y, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7), Math.fma(this.z, _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 lerp(Double3 other, double t) {
        return lerp(other.x(), other.y(), other.z(), t);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor {@code t}, returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 lerp(double otherX, double otherY, double otherZ, double t) {
        return new Double3(Math.fma(t, otherX - this.x, this.x), Math.fma(t, otherY - this.y, this.y), Math.fma(t, otherZ - this.z, this.z));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double3 lerp(Double3 other, Double3 t) {
        return lerp(other.x(), other.y(), other.z(), t.x(), t.y(), t.z());
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor ({@code tX}, {@code tY}, {@code tZ}), returning the result as
     * a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @return the resulting vector
     */
    public Double3 lerp(double otherX, double otherY, double otherZ, double tX, double tY, double tZ) {
        return new Double3(Math.fma(tX, otherX - this.x, this.x), Math.fma(tY, otherY - this.y, this.y), Math.fma(tZ, otherZ - this.z, this.z));
    }


    /**
     * Compute the absolute value of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 absolute() {
        return new Double3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }


    /**
     * Compute the arc cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 acos() {
        return new Double3(Math.acos(this.x), Math.acos(this.y), Math.acos(this.z));
    }


    /**
     * Add {@code b} scaled by {@code scalar} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double3 addScaled(Double3 b, double scalar) {
        return addScaled(b.x(), b.y(), b.z(), scalar);
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by {@code scalar} to this vector, returning
     * the result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double3 addScaled(double bX, double bY, double bZ, double scalar) {
        return new Double3(Math.fma(scalar, bX, this.x), Math.fma(scalar, bY, this.y), Math.fma(scalar, bZ, this.z));
    }


    /**
     * Add {@code b} scaled by {@code c} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param c the vector
     * @return the resulting vector
     */
    public Double3 addScaled(Double3 b, Double3 c) {
        return addScaled(b.x(), b.y(), b.z(), c.x(), c.y(), c.z());
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by ({@code cX}, {@code cY}, {@code cZ}) to
     * this vector, returning the result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @return the resulting vector
     */
    public Double3 addScaled(double bX, double bY, double bZ, double cX, double cY, double cZ) {
        return new Double3(Math.fma(bX, cX, this.x), Math.fma(bY, cY, this.y), Math.fma(bZ, cZ, this.z));
    }


    /**
     * Compute the angle in radians between this vector and {@code other}.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @return the angle in radians between this vector and {@code other}
     */
    public double angleBetween(Double3 other) {
        return angleBetween(other.x(), other.y(), other.z());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public double angleBetween(double otherX, double otherY, double otherZ) {
        double _t6 = Math.fma(otherZ, this.y, -(otherY * this.z));
        double _t7 = Math.fma(otherY, this.x, -(otherX * this.y));
        double _t8 = Math.fma(otherZ, this.x, -(otherX * this.z));
        return Math.atan2(Math.sqrt(Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8))), Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
    }


    /**
     * Compute the arc sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 asin() {
        return new Double3(Math.asin(this.x), Math.asin(this.y), Math.asin(this.z));
    }


    /**
     * Compute the arc tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 atan() {
        return new Double3(Math.atan(this.x), Math.atan(this.y), Math.atan(this.z));
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator), returning the result
     * as a value.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return the resulting vector
     */
    public Double3 atan2(double x) {
        return atan2(x, x, x);
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator), returning the result as a value.
     *
     * @param x the vector of denominators, one per component
     * @return the resulting vector
     */
    public Double3 atan2(Double3 x) {
        return atan2(x.x(), x.y(), x.z());
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code xX},
     * {@code xY}, {@code xZ}) (the denominator), returning the result as a value.
     *
     * @param xX the {@code x} component of the vector {@code (xX, xY, xZ)}
     * @param xY the {@code y} component of the vector {@code (xX, xY, xZ)}
     * @param xZ the {@code z} component of the vector {@code (xX, xY, xZ)}
     * @return the resulting vector
     */
    public Double3 atan2(double xX, double xY, double xZ) {
        return new Double3(Math.atan2(this.x, xX), Math.atan2(this.y, xY), Math.atan2(this.z, xZ));
    }


    /**
     * Compute the cube root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 cbrt() {
        return new Double3(Math.cbrt(this.x), Math.cbrt(this.y), Math.cbrt(this.z));
    }


    /**
     * Compute the ceiling of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 ceil() {
        return new Double3(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return the resulting vector
     */
    public Double3 clamp(double min, double max) {
        return new Double3(Math.min(Math.max(this.x, min), max), Math.min(Math.max(this.y, min), max), Math.min(Math.max(this.z, min), max));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @return the resulting vector
     */
    public Double3 clamp(Double3 min, Double3 max) {
        return clamp(min.x(), min.y(), min.z(), max.x(), max.y(), max.z());
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ}) and
     * ({@code maxX}, {@code maxY}, {@code maxZ}), returning the result as a value.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @return the resulting vector
     */
    public Double3 clamp(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return new Double3(Math.min(Math.max(this.x, minX), maxX), Math.min(Math.max(this.y, minY), maxY), Math.min(Math.max(this.z, minZ), maxZ));
    }


    /**
     * Compute the point on the line segment between {@code lineStart} and {@code lineEnd} that is
     * closest to this vector, returning the result as a value.
     *
     * @param lineStart the vector
     * @param lineEnd the vector
     * @return the resulting vector
     */
    public Double3 closestPointOnLine(Double3 lineStart, Double3 lineEnd) {
        return closestPointOnLine(lineStart.x(), lineStart.y(), lineStart.z(), lineEnd.x(), lineEnd.y(), lineEnd.z());
    }


    /**
     * Compute the point on the line segment between ({@code lineStartX}, {@code lineStartY},
     * {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY}, {@code lineEndZ}) that is
     * closest to this vector, returning the result as a value.
     *
     * @param lineStartX the {@code x} component of the vector
     *        {@code (lineStartX, lineStartY, lineStartZ)}
     * @param lineStartY the {@code y} component of the vector
     *        {@code (lineStartX, lineStartY, lineStartZ)}
     * @param lineStartZ the {@code z} component of the vector
     *        {@code (lineStartX, lineStartY, lineStartZ)}
     * @param lineEndX the {@code x} component of the vector {@code (lineEndX, lineEndY, lineEndZ)}
     * @param lineEndY the {@code y} component of the vector {@code (lineEndX, lineEndY, lineEndZ)}
     * @param lineEndZ the {@code z} component of the vector {@code (lineEndX, lineEndY, lineEndZ)}
     * @return the resulting vector
     */
    public Double3 closestPointOnLine(double lineStartX, double lineStartY, double lineStartZ, double lineEndX, double lineEndY, double lineEndZ) {
        double _t0 = lineEndZ - lineStartZ;
        double _t1 = lineEndX - lineStartX;
        double _t2 = lineEndY - lineStartY;
        double _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t14 = Math.max(0.0, Math.min(1.0, Math.fma(_t0, this.z - lineStartZ, Math.fma(_t1, this.x - lineStartX, _t2 * (this.y - lineStartY))) / _t10));
        if (_t10 > 0.0) {
            return new Double3(Math.fma(_t1, _t14, lineStartX), Math.fma(_t2, _t14, lineStartY), Math.fma(_t0, _t14, lineStartZ));
        } else {
            return new Double3(lineStartX, lineStartY, lineStartZ);
        }
    }


    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    public double compAdd() {
        return this.z + (this.x + this.y);
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public double compMax() {
        return Math.max(Math.max(this.x, this.y), this.z);
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public double compMin() {
        return Math.min(Math.min(this.x, this.y), this.z);
    }


    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    public double compMul() {
        return this.z * this.x * this.y;
    }


    /**
     * Copy the sign of {@code sign} onto each component of this vector, returning the result as a
     * value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Double3 copySign(double sign) {
        return copySign(sign, sign, sign);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector, returning the result as a value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Double3 copySign(Double3 sign) {
        return copySign(sign.x(), sign.y(), sign.z());
    }


    /**
     * Copy the sign of each component of ({@code signX}, {@code signY}, {@code signZ}) onto the
     * corresponding component of this vector, returning the result as a value.
     *
     * @param signX the {@code x} component of the vector {@code (signX, signY, signZ)}
     * @param signY the {@code y} component of the vector {@code (signX, signY, signZ)}
     * @param signZ the {@code z} component of the vector {@code (signX, signY, signZ)}
     * @return the resulting vector
     */
    public Double3 copySign(double signX, double signY, double signZ) {
        return new Double3(Math.copySign(this.x, signX), Math.copySign(this.y, signY), Math.copySign(this.z, signZ));
    }


    /**
     * Compute the cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 cos() {
        return new Double3(Math.cos(this.x), Math.cos(this.y), Math.cos(this.z));
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 cosh() {
        return new Double3(Math.cosh(this.x), Math.cosh(this.y), Math.cosh(this.z));
    }


    /**
     * Compute the cross product of this vector and {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 cross(Double3 other) {
        return cross(other.x(), other.y(), other.z());
    }


    /**
     * Compute the cross product of this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 cross(double otherX, double otherY, double otherZ) {
        return new Double3(Math.fma(otherZ, this.y, -(otherY * this.z)), Math.fma(otherX, this.z, -(otherZ * this.x)), Math.fma(otherY, this.x, -(otherX * this.y)));
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 degrees() {
        return new Double3(Math.toDegrees(this.x), Math.toDegrees(this.y), Math.toDegrees(this.z));
    }


    /**
     * Compute the distance between this vector and {@code other}.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the difference vector must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param other the other vector
     * @return the distance between this vector and {@code other}
     */
    public double distance(Double3 other) {
        return distance(other.x(), other.y(), other.z());
    }


    /**
     * Compute the distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the difference vector must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     */
    public double distance(double otherX, double otherY, double otherZ) {
        double _t0 = this.z - otherZ;
        double _t1 = this.x - otherX;
        double _t2 = this.y - otherY;
        return Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public double distanceSquared(Double3 other) {
        return distanceSquared(other.x(), other.y(), other.z());
    }


    /**
     * Compute the squared distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the squared distance between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public double distanceSquared(double otherX, double otherY, double otherZ) {
        double _t0 = this.z - otherZ;
        double _t1 = this.x - otherX;
        double _t2 = this.y - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public double dot(Double3 other) {
        return dot(other.x(), other.y(), other.z());
    }


    /**
     * Compute the dot product of this vector and ({@code otherX}, {@code otherY}, {@code otherZ}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the dot product of this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     */
    public double dot(double otherX, double otherY, double otherZ) {
        return Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y));
    }


    /**
     * Compute the base-e exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 exp() {
        return new Double3(Math.exp(this.x), Math.exp(this.y), Math.exp(this.z));
    }


    /**
     * Compute the base-2 exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 exp2() {
        return new Double3(Math.pow(2.0, this.x), Math.pow(2.0, this.y), Math.pow(2.0, this.z));
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Double3 expm1() {
        return new Double3(Math.expm1(this.x), Math.expm1(this.y), Math.expm1(this.z));
    }


    /**
     * Return this vector unchanged when {@code dot(Nref, I)} is negative, and negated otherwise -
     * orienting it against the incident direction {@code I} as judged by the reference vector
     * {@code Nref}, returning the result as a value.
     *
     * @param I the vector
     * @param Nref the vector
     * @return the resulting vector
     */
    public Double3 faceforward(Double3 I, Double3 Nref) {
        return faceforward(I.x(), I.y(), I.z(), Nref.x(), Nref.y(), Nref.z());
    }


    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ), (IX, IY, IZ))} is
     * negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}) as judged by the reference vector ({@code NrefX}, {@code NrefY},
     * {@code NrefZ}), returning the result as a value.
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY, IZ)}
     * @param IY the {@code y} component of the vector {@code (IX, IY, IZ)}
     * @param IZ the {@code z} component of the vector {@code (IX, IY, IZ)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefZ the {@code z} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @return the resulting vector
     */
    public Double3 faceforward(double IX, double IY, double IZ, double NrefX, double NrefY, double NrefZ) {
        double _t2 = Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY));
        if (_t2 < 0.0) {
            return new Double3(this.x, this.y, this.z);
        } else {
            return new Double3(-this.x, -this.y, -this.z);
        }
    }


    /**
     * Compute the floor of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 floor() {
        return new Double3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }


    /**
     * Compute the fractional part of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 fract() {
        return new Double3(this.x - Math.floor(this.x), this.y - Math.floor(this.y), this.z - Math.floor(this.z));
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y}, returning the result as a value.
     *
     * @param y the other operand
     * @return the resulting vector
     */
    public Double3 hypot(double y) {
        return hypot(y, y, y);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y}, returning the result
     * as a value.
     *
     * @param y the vector of other operands, one per component
     * @return the resulting vector
     */
    public Double3 hypot(Double3 y) {
        return hypot(y.x(), y.y(), y.z());
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code yX}, {@code yY},
     * {@code yZ}), returning the result as a value.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ)}
     * @return the resulting vector
     */
    public Double3 hypot(double yX, double yY, double yZ) {
        return new Double3(Math.hypot(this.x, yX), Math.hypot(this.y, yY), Math.hypot(this.z, yZ));
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector, returning the result
     * as a value.
     *
     * @return the resulting vector
     */
    public Double3 inverse() {
        return new Double3(1.0 / this.x, 1.0 / this.y, 1.0 / this.z);
    }


    /**
     * Compute the inverse square root of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 inverseSqrt() {
        return new Double3((1.0 / Math.sqrt(this.x)), (1.0 / Math.sqrt(this.y)), (1.0 / Math.sqrt(this.z)));
    }


    /**
     * Compute the length of this vector.
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this vector must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @return the length of this vector
     */
    public double length() {
        return Math.sqrt(Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public double lengthSquared() {
        return Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
    }


    /**
     * Compute the natural logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 log() {
        return new Double3(Math.log(this.x), Math.log(this.y), Math.log(this.z));
    }


    /**
     * Compute the base-10 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 log10() {
        return new Double3(Math.log10(this.x), Math.log10(this.y), Math.log10(this.z));
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 log1p() {
        return new Double3(Math.log1p(this.x), Math.log1p(this.y), Math.log1p(this.z));
    }


    /**
     * Compute the base-2 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 log2() {
        double _t0 = Math.log(2.0);
        double _t0_inv = 1.0 / _t0;
        return new Double3(Math.log(this.x) * _t0_inv, Math.log(this.y) * _t0_inv, Math.log(this.z) * _t0_inv);
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public double manhattanDistance(Double3 other) {
        return manhattanDistance(other.x(), other.y(), other.z());
    }


    /**
     * Compute the Manhattan distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the Manhattan distance between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public double manhattanDistance(double otherX, double otherY, double otherZ) {
        return Math.abs(this.x - otherX) + Math.abs(this.y - otherY) + Math.abs(this.z - otherZ);
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public double manhattanLength() {
        return Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double3 max(double scalar) {
        return max(scalar, scalar, scalar);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 max(Double3 other) {
        return max(other.x(), other.y(), other.z());
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 max(double otherX, double otherY, double otherZ) {
        return new Double3(Math.max(this.x, otherX), Math.max(this.y, otherY), Math.max(this.z, otherZ));
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double3 min(double scalar) {
        return min(scalar, scalar, scalar);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double3 min(Double3 other) {
        return min(other.x(), other.y(), other.z());
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the resulting vector
     */
    public Double3 min(double otherX, double otherY, double otherZ) {
        return new Double3(Math.min(this.x, otherX), Math.min(this.y, otherY), Math.min(this.z, otherZ));
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y}, returning the result as a value.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the divisor
     * @return the resulting vector
     */
    public Double3 mod(double y) {
        return mod(y, y, y);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y}, returning the result as a value.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the vector of divisors, one per component
     * @return the resulting vector
     */
    public Double3 mod(Double3 y) {
        return mod(y.x(), y.y(), y.z());
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code yX}, {@code yY}, {@code yZ}), returning the result as a value.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ)}
     * @return the resulting vector
     */
    public Double3 mod(double yX, double yY, double yZ) {
        return new Double3(Math.fma(-yX, Math.floor(this.x / yX), this.x), Math.fma(-yY, Math.floor(this.y / yY), this.y), Math.fma(-yZ, Math.floor(this.z / yZ), this.z));
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 nextDown() {
        return new Double3(Math.nextDown(this.x), Math.nextDown(this.y), Math.nextDown(this.z));
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 nextUp() {
        return new Double3(Math.nextUp(this.x), Math.nextUp(this.y), Math.nextUp(this.z));
    }


    /**
     * Normalize this vector to unit length (the zero vector yields the zero vector), returning the
     * result as a value.
     * <p>
     * The squared length is formed at the component precision, so components whose squares overflow
     * or underflow that precision are out of domain: the result is the zero vector rather than a
     * unit vector. Rescale such inputs before normalizing (the magnitude must lie roughly between
     * 1e-19 and 1.8e19 for {@code float}, 1.5e-154 and 1.3e154 for {@code double}).
     *
     * @return the resulting vector
     */
    public Double3 normalize() {
        double _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            return new Double3(this.x * _t3, this.y * _t3, this.z * _t3);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector), returning the result as a value.
     *
     * @param length the length to rescale to
     * @return the resulting vector
     */
    public Double3 normalizeMul(double length) {
        double _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        double _t4 = length * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            return new Double3(this.x * _t4, this.y * _t4, this.z * _t4);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Compute the signed angle in radians between this vector and {@code other}, positive when the
     * rotation from this vector to {@code other} is counter-clockwise as seen from the direction of
     * the given normal.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @param normal the reference axis that defines the sign of the angle
     * @return the signed angle in radians between this vector and {@code other}, positive when the
     *        rotation from this vector to {@code other} is counter-clockwise as seen from the
     *        direction of the given normal
     */
    public double orientedAngle(Double3 other, Double3 normal) {
        return orientedAngle(other.x(), other.y(), other.z(), normal.x(), normal.y(), normal.z());
    }


    /**
     * Compute the signed angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}), positive when the rotation from this vector to ({@code otherX},
     * {@code otherY}, {@code otherZ}) is counter-clockwise as seen from the direction of the given
     * normal.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)}
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)}
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)}
     * @return the signed angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ}), positive when the rotation from this vector to ({@code otherX},
     *        {@code otherY}, {@code otherZ}) is counter-clockwise as seen from the direction of the
     *        given normal
     */
    public double orientedAngle(double otherX, double otherY, double otherZ, double normalX, double normalY, double normalZ) {
        double _t8 = Math.fma(otherY, this.x, -(otherX * this.y));
        double _t9 = Math.fma(otherZ, this.y, -(otherY * this.z));
        double _t10 = Math.fma(otherX, this.z, -(otherZ * this.x));
        double _t16 = Math.atan2(Math.sqrt(Math.fma(_t8, _t8, Math.fma(_t10, _t10, _t9 * _t9))), Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
        return Math.fma(normalZ, _t8, Math.fma(normalX, _t9, normalY * _t10)) < 0.0 ? -_t16 : _t16;
    }


    /**
     * Compute the outer product of this vector and {@code row}, returning the result as a value.
     *
     * @param row the row vector (right operand)
     * @return the resulting matrix
     */
    public Double3x3 outerProduct(Double3 row) {
        return outerProduct(row.x(), row.y(), row.z());
    }


    /**
     * Compute the outer product of this vector and ({@code rowX}, {@code rowY}, {@code rowZ}),
     * returning the result as a value.
     *
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @return the resulting matrix
     */
    public Double3x3 outerProduct(double rowX, double rowY, double rowZ) {
        return new Double3x3(rowX * this.x, rowY * this.x, rowZ * this.x, rowX * this.y, rowY * this.y, rowZ * this.y, rowX * this.z, rowY * this.z, rowZ * this.z, 0);
    }


    /**
     * Compute a vector perpendicular to this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 perpendicular() {
        double _t1 = Math.fma(this.x, this.x, this.y * this.y);
        if (_t1 > 0.0) {
            return new Double3(this.y, -this.x, 0.0);
        } else {
            return new Double3(0.0, this.z, -this.y);
        }
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Double3 pow(double exponent) {
        return pow(exponent, exponent, exponent);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Double3 pow(Double3 exponent) {
        return pow(exponent.x(), exponent.y(), exponent.z());
    }


    /**
     * Raise each component of this vector to the power of ({@code exponentX}, {@code exponentY},
     * {@code exponentZ}), returning the result as a value.
     *
     * @param exponentX the {@code x} component of the vector
     *        {@code (exponentX, exponentY, exponentZ)}
     * @param exponentY the {@code y} component of the vector
     *        {@code (exponentX, exponentY, exponentZ)}
     * @param exponentZ the {@code z} component of the vector
     *        {@code (exponentX, exponentY, exponentZ)}
     * @return the resulting vector
     */
    public Double3 pow(double exponentX, double exponentY, double exponentZ) {
        return new Double3(Math.pow(this.x, exponentX), Math.pow(this.y, exponentY), Math.pow(this.z, exponentZ));
    }


    /**
     * Project this vector onto {@code onto}, returning the result as a value.
     *
     * @param onto the vector to project onto
     * @return the resulting vector
     */
    public Double3 project(Double3 onto) {
        return project(onto.x(), onto.y(), onto.z());
    }


    /**
     * Project this vector onto ({@code ontoX}, {@code ontoY}, {@code ontoZ}), returning the result
     * as a value.
     *
     * @param ontoX the {@code x} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param ontoY the {@code y} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param ontoZ the {@code z} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @return the resulting vector
     */
    public Double3 project(double ontoX, double ontoY, double ontoZ) {
        double _t4 = Math.fma(ontoZ, this.z, Math.fma(ontoX, this.x, ontoY * this.y));
        double _t5 = Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY));
        double _t5_inv = 1.0 / _t5;
        return new Double3(ontoX * _t4 * _t5_inv, ontoY * _t4 * _t5_inv, ontoZ * _t4 * _t5_inv);
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Double3 projectOnPlane(Double3 normal) {
        return projectOnPlane(normal.x(), normal.y(), normal.z());
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @return the resulting vector
     */
    public Double3 projectOnPlane(double normalX, double normalY, double normalZ) {
        double _t2 = Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y));
        return new Double3(Math.fma(-normalX, _t2, this.x), Math.fma(-normalY, _t2, this.y), Math.fma(-normalZ, _t2, this.z));
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 radians() {
        return new Double3(Math.toRadians(this.x), Math.toRadians(this.y), Math.toRadians(this.z));
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Double3 reflect(Double3 normal) {
        return reflect(normal.x(), normal.y(), normal.z());
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @return the resulting vector
     */
    public Double3 reflect(double normalX, double normalY, double normalZ) {
        double _t3 = 2.0 * Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y));
        return new Double3(Math.fma(-normalX, _t3, this.x), Math.fma(-normalY, _t3, this.y), Math.fma(-normalZ, _t3, this.z));
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return the resulting vector
     */
    public Double3 refract(Double3 normal, double eta) {
        return refract(normal.x(), normal.y(), normal.z(), eta);
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return the resulting vector
     */
    public Double3 refract(double normalX, double normalY, double normalZ, double eta) {
        double _t3 = Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y));
        double _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0), eta * eta, 1.0);
        double _t10 = Math.fma(eta, _t3, Math.sqrt(Math.max(0.0, _t7)));
        if (_t7 >= 0.0) {
            return new Double3(Math.fma(eta, this.x, -(normalX * _t10)), Math.fma(eta, this.y, -(normalY * _t10)), Math.fma(eta, this.z, -(normalZ * _t10)));
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 round() {
        return new Double3(Math.rint(this.x), Math.rint(this.y), Math.rint(this.z));
    }


    /**
     * Compute the sign of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 sign() {
        return new Double3(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z));
    }


    /**
     * Compute the sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 sin() {
        return new Double3(Math.sin(this.x), Math.sin(this.y), Math.sin(this.z));
    }


    /**
     * Compute the hyperbolic sine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 sinh() {
        return new Double3(Math.sinh(this.x), Math.sinh(this.y), Math.sinh(this.z));
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge, returning the result as a value.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @return the resulting vector
     */
    public Double3 smoothstep(double edge0, double edge1) {
        double _t0 = edge1 - edge0;
        double _t0_inv = 1.0 / _t0;
        double _t10 = Math.max(0.0, Math.min(1.0, (this.x - edge0) * _t0_inv));
        double _t11 = Math.max(0.0, Math.min(1.0, (this.y - edge0) * _t0_inv));
        double _t12 = Math.max(0.0, Math.min(1.0, (this.z - edge0) * _t0_inv));
        return new Double3(Math.fma(-2.0, _t10, 3.0) * _t10 * _t10, Math.fma(-2.0, _t11, 3.0) * _t11 * _t11, Math.fma(-2.0, _t12, 3.0) * _t12 * _t12);
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge, returning the result as a value.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @return the resulting vector
     */
    public Double3 smoothstep(Double3 edge0, Double3 edge1) {
        return smoothstep(edge0.x(), edge0.y(), edge0.z(), edge1.x(), edge1.y(), edge1.z());
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}) and the upper edge
     * ({@code edge1X}, {@code edge1Y}, {@code edge1Z}), yielding 0 at or below the lower edge and 1
     * at or above the upper edge, returning the result as a value.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Z the {@code z} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Z the {@code z} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @return the resulting vector
     */
    public Double3 smoothstep(double edge0X, double edge0Y, double edge0Z, double edge1X, double edge1Y, double edge1Z) {
        double _t12 = Math.max(0.0, Math.min(1.0, (this.x - edge0X) / (edge1X - edge0X)));
        double _t13 = Math.max(0.0, Math.min(1.0, (this.y - edge0Y) / (edge1Y - edge0Y)));
        double _t14 = Math.max(0.0, Math.min(1.0, (this.z - edge0Z) / (edge1Z - edge0Z)));
        return new Double3(Math.fma(-2.0, _t12, 3.0) * _t12 * _t12, Math.fma(-2.0, _t13, 3.0) * _t13 * _t13, Math.fma(-2.0, _t14, 3.0) * _t14 * _t14);
    }


    /**
     * Compute the square root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 sqrt() {
        return new Double3(Math.sqrt(this.x), Math.sqrt(this.y), Math.sqrt(this.z));
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Double3 step(double edge) {
        return step(edge, edge, edge);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Double3 step(Double3 edge) {
        return step(edge.x(), edge.y(), edge.z());
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edgeX the {@code x} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param edgeY the {@code y} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param edgeZ the {@code z} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @return the resulting vector
     */
    public Double3 step(double edgeX, double edgeY, double edgeZ) {
        return new Double3(this.x < edgeX ? 0.0 : 1.0, this.y < edgeY ? 0.0 : 1.0, this.z < edgeZ ? 0.0 : 1.0);
    }


    /**
     * Compute the tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double3 tan() {
        return new Double3(Math.tan(this.x), Math.tan(this.y), Math.tan(this.z));
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 tanh() {
        return new Double3(Math.tanh(this.x), Math.tanh(this.y), Math.tanh(this.z));
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize((p1 - this) x (p2 - this))} - it points to the side from which the vertices
     * {@code this}, {@code p1}, {@code p2} appear counter-clockwise (a degenerate triangle yields
     * the zero vector), returning the result as a value.
     *
     * @param p1 the second vertex of the triangle (this vector is the first)
     * @param p2 the third vertex of the triangle
     * @return the resulting vector
     */
    public Double3 triangleNormal(Double3 p1, Double3 p2) {
        return triangleNormal(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z());
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize(((p1X, p1Y, p1Z) - this) x ((p2X, p2Y, p2Z) - this))} - it points to the
     * side from which the vertices {@code this}, ({@code p1X}, {@code p1Y}, {@code p1Z}),
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) appear counter-clockwise (a degenerate triangle
     * yields the zero vector), returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @return the resulting vector
     */
    public Double3 triangleNormal(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z) {
        double _t0 = p1X - this.x;
        double _t1 = p2Y - this.y;
        double _t2 = p1Y - this.y;
        double _t3 = p2X - this.x;
        double _t4 = p2Z - this.z;
        double _t5 = p1Z - this.z;
        double _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        double _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        double _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        double _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        double _t18 = (1.0 / Math.sqrt(_t17));
        if (_t17 > 0.0) {
            return new Double3(_t13 * _t18, _t14 * _t18, _t12 * _t18);
        } else {
            return Double3.ZERO;
        }
    }


    /**
     * Compute the truncated value of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double3 trunc() {
        return new Double3(this.x >= 0.0 ? Math.floor(this.x) : Math.ceil(this.x), this.y >= 0.0 ? Math.floor(this.y) : Math.ceil(this.y), this.z >= 0.0 ? Math.floor(this.z) : Math.ceil(this.z));
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Double3 ulp() {
        return new Double3(Math.ulp(this.x), Math.ulp(this.y), Math.ulp(this.z));
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 0}, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double4 xyz0() {
        return new Double4(this.x, this.y, this.z, 0.0);
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1}, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double4 xyz1() {
        return new Double4(this.x, this.y, this.z, 1.0);
    }


    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this}, returning the
     * result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double3 preMul(Double3x3 mat) {
        return new Double3(Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)), Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)), Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double3 preMulDirection(Double3x4 mat) {
        return new Double3(Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)), Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)), Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double3 preMulDirection(Double4x4 mat) {
        return new Double3(Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)), Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)), Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double3 preMulPosition(Double3x4 mat) {
        return new Double3(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, Math.fma(mat.m02(), this.z, mat.m03()))), Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m12(), this.z, mat.m13()))), Math.fma(mat.m20(), this.x, Math.fma(mat.m21(), this.y, Math.fma(mat.m22(), this.z, mat.m23()))));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double3 preMulPosition(Double4x4 mat) {
        return new Double3(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, Math.fma(mat.m02(), this.z, mat.m03()))), Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m12(), this.z, mat.m13()))), Math.fma(mat.m20(), this.x, Math.fma(mat.m21(), this.y, Math.fma(mat.m22(), this.z, mat.m23()))));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1},
     * then perform a perspective divide - i.e. compute {@code r = mat * (this, 1)} and return
     * {@code r.xyz / r.w}, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double3 preMulProject(Double4x4 mat) {
        double _t2 = Math.fma(mat.m30(), this.x, Math.fma(mat.m31(), this.y, Math.fma(mat.m32(), this.z, mat.m33())));
        double _t2_inv = 1.0 / _t2;
        return new Double3(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, Math.fma(mat.m02(), this.z, mat.m03()))) * _t2_inv, Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m12(), this.z, mat.m13()))) * _t2_inv, Math.fma(mat.m20(), this.x, Math.fma(mat.m21(), this.y, Math.fma(mat.m22(), this.z, mat.m23()))) * _t2_inv);
    }


    /**
     * Rotate this vector by the quaternion {@code quat}, i.e. compute {@code q * this * q^-1},
     * returning the result as a value.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return the resulting vector
     */
    public Double3 rotate(DoubleQuat quat) {
        return rotate(quat.x(), quat.y(), quat.z(), quat.w());
    }


    /**
     * Rotate this vector by the quaternion ({@code quatX}, {@code quatY}, {@code quatZ},
     * {@code quatW}), i.e. compute {@code q * this * q^-1}, returning the result as a value.
     *
     * @param quatX the {@code x} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatY the {@code y} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatZ the {@code z} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatW the {@code w} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @return the resulting vector
     */
    public Double3 rotate(double quatX, double quatY, double quatZ, double quatW) {
        double _t9 = 2.0 * Math.fma(quatX, this.y, -(quatY * this.x));
        double _t10 = 2.0 * Math.fma(quatZ, this.x, -(quatX * this.z));
        double _t11 = 2.0 * Math.fma(quatY, this.z, -(quatZ * this.y));
        return new Double3(Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, this.x))), Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.y))), Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, this.z))));
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis}, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting vector
     */
    public Double3 rotateAxis(double angle, Double3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}), returning the result as a value.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @return the resulting vector
     */
    public Double3 rotateAxis(double angle, double axisX, double axisY, double axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t5 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        return new Double3(Math.fma(_t2, axisX * _t5, Math.fma(this.x, _t0, Math.fma(axisY, this.z, -(axisZ * this.y)) * _t1)), Math.fma(_t2, axisY * _t5, Math.fma(this.y, _t0, Math.fma(axisZ, this.x, -(axisX * this.z)) * _t1)), Math.fma(_t2, axisZ * _t5, Math.fma(this.z, _t0, Math.fma(axisX, this.y, -(axisY * this.x)) * _t1)));
    }


    /**
     * Rotate this vector by the inverse of the given rotation, returning the result as a value.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return the resulting vector
     */
    public Double3 rotateInverse(DoubleQuat quat) {
        return rotateInverse(quat.x(), quat.y(), quat.z(), quat.w());
    }


    /**
     * Rotate this vector by the inverse of the given rotation, returning the result as a value.
     *
     * @param quatX the {@code x} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatY the {@code y} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatZ the {@code z} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatW the {@code w} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @return the resulting vector
     */
    public Double3 rotateInverse(double quatX, double quatY, double quatZ, double quatW) {
        double _t9 = 2.0 * Math.fma(quatX, this.z, -(quatZ * this.x));
        double _t10 = 2.0 * Math.fma(quatY, this.x, -(quatX * this.y));
        double _t11 = 2.0 * Math.fma(quatZ, this.y, -(quatY * this.z));
        return new Double3(Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, this.x))), Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, this.y))), Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.z))));
    }


    /**
     * Rotate this vector by {@code angle} radians about the X axis, returning the result as a
     * value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Double3 rotateX(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        return new Double3(this.x, Math.fma(this.y, _t0, -(this.z * _t1)), Math.fma(this.y, _t1, this.z * _t0));
    }


    /**
     * Rotate this vector by {@code angle} radians about the Y axis, returning the result as a
     * value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Double3 rotateY(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        return new Double3(Math.fma(this.x, _t0, this.z * _t1), this.y, Math.fma(this.z, _t0, -(this.x * _t1)));
    }


    /**
     * Rotate this vector by {@code angle} radians about the Z axis, returning the result as a
     * value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Double3 rotateZ(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        return new Double3(Math.fma(this.x, _t0, -(this.y * _t1)), Math.fma(this.x, _t1, this.y * _t0), this.z);
    }

    /** {@return a copy of this vector with the X component replaced by the given value} */
    public Double3 withX(double x) {
        return new Double3(x, this.y(), this.z());
    }

    /** {@return a copy of this vector with the Y component replaced by the given value} */
    public Double3 withY(double y) {
        return new Double3(this.x(), y, this.z());
    }

    /** {@return a copy of this vector with the XY components replaced by the given values} */
    public Double3 withXY(double x, double y) {
        return new Double3(x, y, this.z());
    }

    /** {@return a copy of this vector with the Z component replaced by the given value} */
    public Double3 withZ(double z) {
        return new Double3(this.x(), this.y(), z);
    }

    /** {@return a copy of this vector with the XZ components replaced by the given values} */
    public Double3 withXZ(double x, double z) {
        return new Double3(x, this.y(), z);
    }

    /** {@return a copy of this vector with the YZ components replaced by the given values} */
    public Double3 withYZ(double y, double z) {
        return new Double3(this.x(), y, z);
    }

    /** {@return a copy of this vector with the XYZ components replaced by the given values} */
    public Double3 withXYZ(double x, double y, double z) {
        return new Double3(x, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}) of this vector, in that order} */
    public Double2 xx() {
        return new Double2(x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}) of this vector, in that order} */
    public Double2 xy() {
        return new Double2(x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}) of this vector, in that order} */
    public Double2 xz() {
        return new Double2(x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}) of this vector, in that order} */
    public Double2 yx() {
        return new Double2(y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}) of this vector, in that order} */
    public Double2 yy() {
        return new Double2(y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}) of this vector, in that order} */
    public Double2 yz() {
        return new Double2(y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}) of this vector, in that order} */
    public Double2 zx() {
        return new Double2(z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}) of this vector, in that order} */
    public Double2 zy() {
        return new Double2(z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}) of this vector, in that order} */
    public Double2 zz() {
        return new Double2(z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double3 xxx() {
        return new Double3(x, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double3 xxy() {
        return new Double3(x, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Double3 xxz() {
        return new Double3(x, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double3 xyx() {
        return new Double3(x, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double3 xyy() {
        return new Double3(x, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Double3 xyz() {
        return new Double3(x, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Double3 xzx() {
        return new Double3(x, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Double3 xzy() {
        return new Double3(x, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Double3 xzz() {
        return new Double3(x, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double3 yxx() {
        return new Double3(y, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double3 yxy() {
        return new Double3(y, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Double3 yxz() {
        return new Double3(y, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double3 yyx() {
        return new Double3(y, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double3 yyy() {
        return new Double3(y, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Double3 yyz() {
        return new Double3(y, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Double3 yzx() {
        return new Double3(y, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Double3 yzy() {
        return new Double3(y, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Double3 yzz() {
        return new Double3(y, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Double3 zxx() {
        return new Double3(z, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Double3 zxy() {
        return new Double3(z, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Double3 zxz() {
        return new Double3(z, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Double3 zyx() {
        return new Double3(z, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Double3 zyy() {
        return new Double3(z, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Double3 zyz() {
        return new Double3(z, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Double3 zzx() {
        return new Double3(z, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Double3 zzy() {
        return new Double3(z, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Double3 zzz() {
        return new Double3(z, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 xxxx() {
        return new Double4(x, x, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 xxxy() {
        return new Double4(x, x, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 xxxz() {
        return new Double4(x, x, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 xxyx() {
        return new Double4(x, x, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 xxyy() {
        return new Double4(x, x, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 xxyz() {
        return new Double4(x, x, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 xxzx() {
        return new Double4(x, x, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 xxzy() {
        return new Double4(x, x, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 xxzz() {
        return new Double4(x, x, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 xyxx() {
        return new Double4(x, y, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 xyxy() {
        return new Double4(x, y, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 xyxz() {
        return new Double4(x, y, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 xyyx() {
        return new Double4(x, y, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 xyyy() {
        return new Double4(x, y, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 xyyz() {
        return new Double4(x, y, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 xyzx() {
        return new Double4(x, y, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 xyzy() {
        return new Double4(x, y, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 xyzz() {
        return new Double4(x, y, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 xzxx() {
        return new Double4(x, z, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 xzxy() {
        return new Double4(x, z, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 xzxz() {
        return new Double4(x, z, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 xzyx() {
        return new Double4(x, z, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 xzyy() {
        return new Double4(x, z, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 xzyz() {
        return new Double4(x, z, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 xzzx() {
        return new Double4(x, z, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 xzzy() {
        return new Double4(x, z, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 xzzz() {
        return new Double4(x, z, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 yxxx() {
        return new Double4(y, x, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 yxxy() {
        return new Double4(y, x, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 yxxz() {
        return new Double4(y, x, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 yxyx() {
        return new Double4(y, x, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 yxyy() {
        return new Double4(y, x, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 yxyz() {
        return new Double4(y, x, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 yxzx() {
        return new Double4(y, x, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 yxzy() {
        return new Double4(y, x, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 yxzz() {
        return new Double4(y, x, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 yyxx() {
        return new Double4(y, y, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 yyxy() {
        return new Double4(y, y, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 yyxz() {
        return new Double4(y, y, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 yyyx() {
        return new Double4(y, y, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 yyyy() {
        return new Double4(y, y, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 yyyz() {
        return new Double4(y, y, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 yyzx() {
        return new Double4(y, y, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 yyzy() {
        return new Double4(y, y, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 yyzz() {
        return new Double4(y, y, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 yzxx() {
        return new Double4(y, z, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 yzxy() {
        return new Double4(y, z, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 yzxz() {
        return new Double4(y, z, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 yzyx() {
        return new Double4(y, z, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 yzyy() {
        return new Double4(y, z, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 yzyz() {
        return new Double4(y, z, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 yzzx() {
        return new Double4(y, z, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 yzzy() {
        return new Double4(y, z, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 yzzz() {
        return new Double4(y, z, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 zxxx() {
        return new Double4(z, x, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 zxxy() {
        return new Double4(z, x, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 zxxz() {
        return new Double4(z, x, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 zxyx() {
        return new Double4(z, x, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 zxyy() {
        return new Double4(z, x, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 zxyz() {
        return new Double4(z, x, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 zxzx() {
        return new Double4(z, x, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 zxzy() {
        return new Double4(z, x, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 zxzz() {
        return new Double4(z, x, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 zyxx() {
        return new Double4(z, y, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 zyxy() {
        return new Double4(z, y, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 zyxz() {
        return new Double4(z, y, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 zyyx() {
        return new Double4(z, y, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 zyyy() {
        return new Double4(z, y, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 zyyz() {
        return new Double4(z, y, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 zyzx() {
        return new Double4(z, y, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 zyzy() {
        return new Double4(z, y, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 zyzz() {
        return new Double4(z, y, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 zzxx() {
        return new Double4(z, z, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 zzxy() {
        return new Double4(z, z, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Double4 zzxz() {
        return new Double4(z, z, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 zzyx() {
        return new Double4(z, z, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 zzyy() {
        return new Double4(z, z, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Double4 zzyz() {
        return new Double4(z, z, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Double4 zzzx() {
        return new Double4(z, z, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Double4 zzzy() {
        return new Double4(z, z, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Double4 zzzz() {
        return new Double4(z, z, z, z);
    }

    @Override public String toString() {
        return "Double3(" + x() + ", " + y() + ", " + z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double3)) return false;
        Double3 o = (Double3) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(o.x)
            && Double.doubleToLongBits(y) == Double.doubleToLongBits(o.y)
            && Double.doubleToLongBits(z) == Double.doubleToLongBits(o.z);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z) >>> 32));
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Double.isFinite(x)
            && Double.isFinite(y)
            && Double.isFinite(z);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     * <p>
     * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
     * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and
     * a NaN component never compares equal to anything.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(Double3 other, double epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon;
    }

    static final Double3SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3SegOpsUnsafe()
                    : new Double3SegOpsMS();
    static final Double3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3BbOpsUnsafe()
                    : new Double3BbOpsApi();
    static final Double3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double3RawOpsUnsafe()
                    : new Double3RawOpsApi();


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
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(double[] src, int offset) {
        double _c0 = src[offset + 0];
        double _c1 = src[offset + 1];
        double _c2 = src[offset + 2];
        return new Double3(_c0, _c1, _c2);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 3);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Double3 r = loadAbsolute(pos, buf);
        buf.position(pos + 3);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 24);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        Double3 r = loadAbsolute(pos, buf);
        buf.position(pos + 24);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Double3 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment store(MemorySegment dest) { return store(0L, dest); }

    /**
     * Store the elements into the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(long offset, MemorySegment src) {
        return SEG_OPS.load(offset, src);
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
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(float[] src, int offset) {
        double _c0 = src[offset + 0];
        double _c1 = src[offset + 1];
        double _c2 = src[offset + 2];
        return new Double3(_c0, _c1, _c2);
    }

    /**
     * Load the elements from the given array, converting each element from {@code float}.
     *
     * @param src the source array
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code float}, starting
     * at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 3);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code float}, starting
     * at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code float}, starting
     * at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code float}, starting
     * at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        Double3 r = loadAbsolute(pos, buf);
        buf.position(pos + 3);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
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
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeFloatRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeFloatAbsolute(pos, buf);
        buf.position(pos + 12);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadFloat(ByteBuffer buf) {
        return loadFloatAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code float},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source byte buffer
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadFloatRelative(ByteBuffer buf) {
        int pos = buf.position();
        Double3 r = loadFloatAbsolute(pos, buf);
        buf.position(pos + 12);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Double3 storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code float}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeFloat(MemorySegment dest) { return storeFloat(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code float},
     * starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadFloat(MemorySegment src) { return loadFloat(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code float},
     * starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Double3} holding the loaded elements
     */
    public static Double3 loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(offset, src);
    }

}
