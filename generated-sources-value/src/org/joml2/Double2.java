package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Immutable 2D vector of double-precision {@code double} components, declared as a value record.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance; as a value class, instances have no identity and may be flattened by the JVM.
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
 */
@jdk.internal.vm.annotation.LooselyConsistentValue
public value record Double2(double x, double y) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** The zero vector (all components 0). */
    public static final Double2 ZERO = new Double2(0, 0);

    /** Canonical constructor. */
    public Double2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new instance initialized to all zeros.
     */
    public Double2() {
        this(0, 0);
    }

    /** Create a vector with all components set to {@code s}. */
    public Double2(double s) {
        this(s, s);
    }

    /** {@return the {@code x} component} */
    public double x() { return x; }
    /** {@return the {@code y} component} */
    public double y() { return y; }


    /**
     * Add {@code other} to this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double2 add(Double2 other) {
        return add(other.x(), other.y());
    }


    /**
     * Add ({@code otherX}, {@code otherY}) to this vector, returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the resulting vector
     */
    public Double2 add(double otherX, double otherY) {
        return new Double2(otherX + this.x, otherY + this.y);
    }


    /**
     * Divide each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double2 div(double scalar) {
        return div(scalar, scalar);
    }


    /**
     * Divide this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double2 div(Double2 other) {
        return div(other.x(), other.y());
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}), returning the result
     * as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the resulting vector
     */
    public Double2 div(double otherX, double otherY) {
        return new Double2(this.x / otherX, this.y / otherY);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Double2 fma(double b, Double2 c) {
        return fma(b, c.x(), c.y());
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY}), i.e.
     * compute {@code this * b + (cX, cY)} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param cX the {@code x} component of the vector {@code (cX, cY)}
     * @param cY the {@code y} component of the vector {@code (cX, cY)}
     * @return the resulting vector
     */
    public Double2 fma(double b, double cX, double cY) {
        return new Double2(Math.fma(this.x, b, cX), Math.fma(this.y, b, cY));
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Double2 fma(Double2 b, Double2 c) {
        return fma(b.x(), b.y(), c.x(), c.y());
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}) and add ({@code cX},
     * {@code cY}), i.e. compute {@code this * (bX, bY) + (cX, cY)} per component, returning the
     * result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY)}
     * @param bY the {@code y} component of the vector {@code (bX, bY)}
     * @param cX the {@code x} component of the vector {@code (cX, cY)}
     * @param cY the {@code y} component of the vector {@code (cX, cY)}
     * @return the resulting vector
     */
    public Double2 fma(double bX, double bY, double cX, double cY) {
        return new Double2(Math.fma(this.x, bX, cX), Math.fma(this.y, bY, cY));
    }


    /**
     * Multiply each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double2 mul(double scalar) {
        return mul(scalar, scalar);
    }


    /**
     * Multiply this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double2 mul(Double2 other) {
        return mul(other.x(), other.y());
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}), returning the result
     * as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the resulting vector
     */
    public Double2 mul(double otherX, double otherY) {
        return new Double2(otherX * this.x, otherY * this.y);
    }


    /**
     * Negate this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 negate() {
        return new Double2(-this.x, -this.y);
    }


    /**
     * Subtract {@code other} from this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double2 sub(Double2 other) {
        return sub(other.x(), other.y());
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}) from this vector, returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the resulting vector
     */
    public Double2 sub(double otherX, double otherY) {
        return new Double2(this.x - otherX, this.y - otherY);
    }


    /**
     * Create a new vector from the given values.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Double2 set(Double2 v) {
        return set(v.x(), v.y());
    }


    /**
     * Create a new vector from the given values.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY)}
     * @param vY the {@code y} component of the vector {@code (vX, vY)}
     * @return the resulting vector
     */
    public Double2 set(double vX, double vY) {
        return new Double2(vX, vY);
    }


    /**
     * Set this vector to {@code s}, returning the result as a value.
     *
     * @param s the value assigned to every component
     * @return the resulting vector
     */
    public Double2 set(double s) {
        return new Double2(s, s);
    }


    /**
     * Convert this vector to {@code float} precision, returning the result as a new instance.
     * <p>
     * The conversion may lose precision or range.
     *
     * @return a new {@code Float2} holding the result
     */
    public Float2 toFloat() {
        return new Float2((float) (this.x), (float) (this.y));
    }


    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Byte2} holding the result
     */
    public Byte2 toByte() {
        return new Byte2((byte) (this.x), (byte) (this.y));
    }


    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Byte2} holding the result
     */
    public Byte2 toByte(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toByte();
            case FLOOR -> new Byte2((byte) Math.floor(this.x), (byte) Math.floor(this.y));
            case CEILING -> new Byte2((byte) Math.ceil(this.x), (byte) Math.ceil(this.y));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Byte2((byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x))), (byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y))));
            case HALF_AWAY_FROM_ZERO -> new Byte2((byte) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (byte) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)));
            case HALF_EVEN -> new Byte2((byte) Math.rint(this.x), (byte) Math.rint(this.y));
        };
    }


    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Short2} holding the result
     */
    public Short2 toShort() {
        return new Short2((short) (this.x), (short) (this.y));
    }


    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Short2} holding the result
     */
    public Short2 toShort(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toShort();
            case FLOOR -> new Short2((short) Math.floor(this.x), (short) Math.floor(this.y));
            case CEILING -> new Short2((short) Math.ceil(this.x), (short) Math.ceil(this.y));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Short2((short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x))), (short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y))));
            case HALF_AWAY_FROM_ZERO -> new Short2((short) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (short) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)));
            case HALF_EVEN -> new Short2((short) Math.rint(this.x), (short) Math.rint(this.y));
        };
    }


    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Int2} holding the result
     */
    public Int2 toInt() {
        return new Int2((int) (this.x), (int) (this.y));
    }


    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Int2} holding the result
     */
    public Int2 toInt(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toInt();
            case FLOOR -> new Int2((int) Math.floor(this.x), (int) Math.floor(this.y));
            case CEILING -> new Int2((int) Math.ceil(this.x), (int) Math.ceil(this.y));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Int2((int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x))), (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y))));
            case HALF_AWAY_FROM_ZERO -> new Int2((int) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (int) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)));
            case HALF_EVEN -> new Int2((int) Math.rint(this.x), (int) Math.rint(this.y));
        };
    }


    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Long2} holding the result
     */
    public Long2 toLong() {
        return new Long2((long) (this.x), (long) (this.y));
    }


    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Long2} holding the result
     */
    public Long2 toLong(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toLong();
            case FLOOR -> new Long2((long) Math.floor(this.x), (long) Math.floor(this.y));
            case CEILING -> new Long2((long) Math.ceil(this.x), (long) Math.ceil(this.y));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Long2(Math.round(this.x), Math.round(this.y));
            case HALF_AWAY_FROM_ZERO -> new Long2((long) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x)), (long) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y)));
            case HALF_EVEN -> new Long2((long) Math.rint(this.x), (long) Math.rint(this.y));
        };
    }


    /**
     * Create an all-zero vector.
     *
     * @return the resulting vector
     */
    public static Double2 makeZero() {
        return Double2.ZERO;
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
    public Double2 bezier(Double2 p1, Double2 p2, Double2 p3, double t) {
        return bezier(p1.x(), p1.y(), p2.x(), p2.y(), p3.x(), p3.y(), t);
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 bezier(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        return new Double2(Math.fma(p1X, _t7, this.x * _t8) + Math.fma(p2X, _t6, p3X * _t2), Math.fma(p1Y, _t7, this.y * _t8) + Math.fma(p2Y, _t6, p3Y * _t2));
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
    public Double2 bezier2(Double2 p1, Double2 p2, double t) {
        return bezier2(p1.x(), p1.y(), p2.x(), p2.y(), t);
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points, returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 bezier2(double p1X, double p1Y, double p2X, double p2Y, double t) {
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        return new Double2(Math.fma(p2X, _t0, Math.fma(p1X, _t3, this.x * _t4)), Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, this.y * _t4)));
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
    public Double2 bezier2Tangent(Double2 p1, Double2 p2, double t) {
        return bezier2Tangent(p1.x(), p1.y(), p2.x(), p2.y(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}, returning the result
     * as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 bezier2Tangent(double p1X, double p1Y, double p2X, double p2Y, double t) {
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        return new Double2(Math.fma(p1X - this.x, _t2, (p2X - p1X) * _t1), Math.fma(p1Y - this.y, _t2, (p2Y - p1Y) * _t1));
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
    public Double2 bezierTangent(Double2 p1, Double2 p2, Double2 p3, double t) {
        return bezierTangent(p1.x(), p1.y(), p2.x(), p2.y(), p3.x(), p3.y(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 bezierTangent(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        return new Double2(Math.fma(p3X - p2X, _t2, Math.fma(p1X - this.x, _t6, (p2X - p1X) * _t5)), Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - this.y, _t6, (p2Y - p1Y) * _t5)));
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
    public Double2 catmullRom(Double2 p1, Double2 p2, Double2 p3, double t) {
        return catmullRom(p1.x(), p1.y(), p2.x(), p2.y(), p3.x(), p3.y(), t);
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 catmullRom(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _t0 = t * t;
        double _t1 = t * _t0;
        return new Double2(0.5 * (Math.fma(2.0, p1X, t * (p2X - this.x)) + Math.fma(Math.fma(-5.0, p1X, Math.fma(2.0, this.x, Math.fma(4.0, p2X, -p3X))), _t0, Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - this.x)) * _t1)), 0.5 * (Math.fma(2.0, p1Y, t * (p2Y - this.y)) + Math.fma(Math.fma(-5.0, p1Y, Math.fma(2.0, this.y, Math.fma(4.0, p2Y, -p3Y))), _t0, Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - this.y)) * _t1)));
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
    public Double2 catmullRomTangent(Double2 p1, Double2 p2, Double2 p3, double t) {
        return catmullRomTangent(p1.x(), p1.y(), p2.x(), p2.y(), p3.x(), p3.y(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 catmullRomTangent(double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _t0 = t * t;
        return new Double2(0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1X, Math.fma(2.0, this.x, Math.fma(4.0, p2X, -p3X))), Math.fma(3.0 * Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - this.x)), _t0, p2X - this.x)), 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Y, Math.fma(2.0, this.y, Math.fma(4.0, p2Y, -p3Y))), Math.fma(3.0 * Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - this.y)), _t0, p2Y - this.y)));
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
    public Double2 hermite(Double2 t0, Double2 v1, Double2 t1, double t) {
        return hermite(t0.x(), t0.y(), v1.x(), v1.y(), t1.x(), t1.y(), t);
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation,
     * returning the result as a value.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 hermite(double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        return new Double2(Math.fma(this.x, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9), Math.fma(this.y, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9));
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
    public Double2 hermiteTangent(Double2 t0, Double2 v1, Double2 t1, double t) {
        return hermiteTangent(t0.x(), t0.y(), v1.x(), v1.y(), t1.x(), t1.y(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}, returning the result as a
     * value.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 hermiteTangent(double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        return new Double2(Math.fma(this.x, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7), Math.fma(this.y, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 lerp(Double2 other, double t) {
        return lerp(other.x(), other.y(), t);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}) using the
     * interpolation factor {@code t}, returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 lerp(double otherX, double otherY, double t) {
        return new Double2(Math.fma(t, otherX - this.x, this.x), Math.fma(t, otherY - this.y, this.y));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Double2 lerp(Double2 other, Double2 t) {
        return lerp(other.x(), other.y(), t.x(), t.y());
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}) using the
     * interpolation factor ({@code tX}, {@code tY}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @param tX the {@code x} component of the vector {@code (tX, tY)}
     * @param tY the {@code y} component of the vector {@code (tX, tY)}
     * @return the resulting vector
     */
    public Double2 lerp(double otherX, double otherY, double tX, double tY) {
        return new Double2(Math.fma(tX, otherX - this.x, this.x), Math.fma(tY, otherY - this.y, this.y));
    }


    /**
     * Compute the absolute value of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 absolute() {
        return new Double2(Math.abs(this.x), Math.abs(this.y));
    }


    /**
     * Compute the arc cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 acos() {
        return new Double2(Math.acos(this.x), Math.acos(this.y));
    }


    /**
     * Add {@code b} scaled by {@code scalar} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double2 addScaled(Double2 b, double scalar) {
        return addScaled(b.x(), b.y(), scalar);
    }


    /**
     * Add ({@code bX}, {@code bY}) scaled by {@code scalar} to this vector, returning the result as
     * a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY)}
     * @param bY the {@code y} component of the vector {@code (bX, bY)}
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double2 addScaled(double bX, double bY, double scalar) {
        return new Double2(Math.fma(scalar, bX, this.x), Math.fma(scalar, bY, this.y));
    }


    /**
     * Add {@code b} scaled by {@code c} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param c the vector
     * @return the resulting vector
     */
    public Double2 addScaled(Double2 b, Double2 c) {
        return addScaled(b.x(), b.y(), c.x(), c.y());
    }


    /**
     * Add ({@code bX}, {@code bY}) scaled by ({@code cX}, {@code cY}) to this vector, returning the
     * result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY)}
     * @param bY the {@code y} component of the vector {@code (bX, bY)}
     * @param cX the {@code x} component of the vector {@code (cX, cY)}
     * @param cY the {@code y} component of the vector {@code (cX, cY)}
     * @return the resulting vector
     */
    public Double2 addScaled(double bX, double bY, double cX, double cY) {
        return new Double2(Math.fma(bX, cX, this.x), Math.fma(bY, cY, this.y));
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
    public double angleBetween(Double2 other) {
        return angleBetween(other.x(), other.y());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY})
     */
    public double angleBetween(double otherX, double otherY) {
        return Math.atan2(Math.abs(Math.fma(otherY, this.x, -(otherX * this.y))), Math.fma(otherX, this.x, otherY * this.y));
    }


    /**
     * Compute the arc sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 asin() {
        return new Double2(Math.asin(this.x), Math.asin(this.y));
    }


    /**
     * Compute the arc tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 atan() {
        return new Double2(Math.atan(this.x), Math.atan(this.y));
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator), returning the result
     * as a value.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return the resulting vector
     */
    public Double2 atan2(double x) {
        return atan2(x, x);
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator), returning the result as a value.
     *
     * @param x the vector of denominators, one per component
     * @return the resulting vector
     */
    public Double2 atan2(Double2 x) {
        return atan2(x.x(), x.y());
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code xX},
     * {@code xY}) (the denominator), returning the result as a value.
     *
     * @param xX the {@code x} component of the vector {@code (xX, xY)}
     * @param xY the {@code y} component of the vector {@code (xX, xY)}
     * @return the resulting vector
     */
    public Double2 atan2(double xX, double xY) {
        return new Double2(Math.atan2(this.x, xX), Math.atan2(this.y, xY));
    }


    /**
     * Compute the cube root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 cbrt() {
        return new Double2(Math.cbrt(this.x), Math.cbrt(this.y));
    }


    /**
     * Compute the ceiling of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 ceil() {
        return new Double2(Math.ceil(this.x), Math.ceil(this.y));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return the resulting vector
     */
    public Double2 clamp(double min, double max) {
        return new Double2(Math.min(Math.max(this.x, min), max), Math.min(Math.max(this.y, min), max));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @return the resulting vector
     */
    public Double2 clamp(Double2 min, Double2 max) {
        return clamp(min.x(), min.y(), max.x(), max.y());
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}) and ({@code maxX},
     * {@code maxY}), returning the result as a value.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY)}
     * @param minY the {@code y} component of the vector {@code (minX, minY)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY)}
     * @return the resulting vector
     */
    public Double2 clamp(double minX, double minY, double maxX, double maxY) {
        return new Double2(Math.min(Math.max(this.x, minX), maxX), Math.min(Math.max(this.y, minY), maxY));
    }


    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    public double compAdd() {
        return this.x + this.y;
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public double compMax() {
        return Math.max(this.x, this.y);
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public double compMin() {
        return Math.min(this.x, this.y);
    }


    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    public double compMul() {
        return this.x * this.y;
    }


    /**
     * Copy the sign of {@code sign} onto each component of this vector, returning the result as a
     * value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Double2 copySign(double sign) {
        return copySign(sign, sign);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector, returning the result as a value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Double2 copySign(Double2 sign) {
        return copySign(sign.x(), sign.y());
    }


    /**
     * Copy the sign of each component of ({@code signX}, {@code signY}) onto the corresponding
     * component of this vector, returning the result as a value.
     *
     * @param signX the {@code x} component of the vector {@code (signX, signY)}
     * @param signY the {@code y} component of the vector {@code (signX, signY)}
     * @return the resulting vector
     */
    public Double2 copySign(double signX, double signY) {
        return new Double2(Math.copySign(this.x, signX), Math.copySign(this.y, signY));
    }


    /**
     * Compute the cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 cos() {
        return new Double2(Math.cos(this.x), Math.cos(this.y));
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 cosh() {
        return new Double2(Math.cosh(this.x), Math.cosh(this.y));
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 degrees() {
        return new Double2(Math.toDegrees(this.x), Math.toDegrees(this.y));
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
    public double distance(Double2 other) {
        return distance(other.x(), other.y());
    }


    /**
     * Compute the distance between this vector and ({@code otherX}, {@code otherY}).
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the difference vector must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY})
     */
    public double distance(double otherX, double otherY) {
        double _t0 = this.x - otherX;
        double _t1 = this.y - otherY;
        return Math.sqrt(Math.fma(_t0, _t0, _t1 * _t1));
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public double distanceSquared(Double2 other) {
        return distanceSquared(other.x(), other.y());
    }


    /**
     * Compute the squared distance between this vector and ({@code otherX}, {@code otherY}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the squared distance between this vector and ({@code otherX}, {@code otherY})
     */
    public double distanceSquared(double otherX, double otherY) {
        double _t0 = this.x - otherX;
        double _t1 = this.y - otherY;
        return Math.fma(_t0, _t0, _t1 * _t1);
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public double dot(Double2 other) {
        return dot(other.x(), other.y());
    }


    /**
     * Compute the dot product of this vector and ({@code otherX}, {@code otherY}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the dot product of this vector and ({@code otherX}, {@code otherY})
     */
    public double dot(double otherX, double otherY) {
        return Math.fma(otherX, this.x, otherY * this.y);
    }


    /**
     * Compute the base-e exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 exp() {
        return new Double2(Math.exp(this.x), Math.exp(this.y));
    }


    /**
     * Compute the base-2 exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 exp2() {
        return new Double2(Math.pow(2.0, this.x), Math.pow(2.0, this.y));
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Double2 expm1() {
        return new Double2(Math.expm1(this.x), Math.expm1(this.y));
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
    public Double2 faceforward(Double2 I, Double2 Nref) {
        return faceforward(I.x(), I.y(), Nref.x(), Nref.y());
    }


    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY), (IX, IY))} is negative, and
     * negated otherwise - orienting it against the incident direction ({@code IX}, {@code IY}) as
     * judged by the reference vector ({@code NrefX}, {@code NrefY}), returning the result as a
     * value.
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY)}
     * @param IY the {@code y} component of the vector {@code (IX, IY)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY)}
     * @return the resulting vector
     */
    public Double2 faceforward(double IX, double IY, double NrefX, double NrefY) {
        double _t1 = Math.fma(IX, NrefX, IY * NrefY);
        if (_t1 < 0.0) {
            return new Double2(this.x, this.y);
        } else {
            return new Double2(-this.x, -this.y);
        }
    }


    /**
     * Compute the floor of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 floor() {
        return new Double2(Math.floor(this.x), Math.floor(this.y));
    }


    /**
     * Compute the fractional part of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 fract() {
        return new Double2(this.x - Math.floor(this.x), this.y - Math.floor(this.y));
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y}, returning the result as a value.
     *
     * @param y the other operand
     * @return the resulting vector
     */
    public Double2 hypot(double y) {
        return hypot(y, y);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y}, returning the result
     * as a value.
     *
     * @param y the vector of other operands, one per component
     * @return the resulting vector
     */
    public Double2 hypot(Double2 y) {
        return hypot(y.x(), y.y());
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code yX}, {@code yY}),
     * returning the result as a value.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY)}
     * @param yY the {@code y} component of the vector {@code (yX, yY)}
     * @return the resulting vector
     */
    public Double2 hypot(double yX, double yY) {
        return new Double2(Math.hypot(this.x, yX), Math.hypot(this.y, yY));
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector, returning the result
     * as a value.
     *
     * @return the resulting vector
     */
    public Double2 inverse() {
        return new Double2(1.0 / this.x, 1.0 / this.y);
    }


    /**
     * Compute the inverse square root of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 inverseSqrt() {
        return new Double2((1.0 / Math.sqrt(this.x)), (1.0 / Math.sqrt(this.y)));
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
        return Math.sqrt(Math.fma(this.x, this.x, this.y * this.y));
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public double lengthSquared() {
        return Math.fma(this.x, this.x, this.y * this.y);
    }


    /**
     * Compute the natural logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 log() {
        return new Double2(Math.log(this.x), Math.log(this.y));
    }


    /**
     * Compute the base-10 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 log10() {
        return new Double2(Math.log10(this.x), Math.log10(this.y));
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 log1p() {
        return new Double2(Math.log1p(this.x), Math.log1p(this.y));
    }


    /**
     * Compute the base-2 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 log2() {
        double _t0 = Math.log(2.0);
        double _t0_inv = 1.0 / _t0;
        return new Double2(Math.log(this.x) * _t0_inv, Math.log(this.y) * _t0_inv);
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public double manhattanDistance(Double2 other) {
        return manhattanDistance(other.x(), other.y());
    }


    /**
     * Compute the Manhattan distance between this vector and ({@code otherX}, {@code otherY}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the Manhattan distance between this vector and ({@code otherX}, {@code otherY})
     */
    public double manhattanDistance(double otherX, double otherY) {
        return Math.abs(this.x - otherX) + Math.abs(this.y - otherY);
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public double manhattanLength() {
        return Math.abs(this.x) + Math.abs(this.y);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double2 max(double scalar) {
        return max(scalar, scalar);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double2 max(Double2 other) {
        return max(other.x(), other.y());
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the resulting vector
     */
    public Double2 max(double otherX, double otherY) {
        return new Double2(Math.max(this.x, otherX), Math.max(this.y, otherY));
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Double2 min(double scalar) {
        return min(scalar, scalar);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Double2 min(Double2 other) {
        return min(other.x(), other.y());
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the resulting vector
     */
    public Double2 min(double otherX, double otherY) {
        return new Double2(Math.min(this.x, otherX), Math.min(this.y, otherY));
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
    public Double2 mod(double y) {
        return mod(y, y);
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
    public Double2 mod(Double2 y) {
        return mod(y.x(), y.y());
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code yX}, {@code yY}), returning the result as a value.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY)}
     * @param yY the {@code y} component of the vector {@code (yX, yY)}
     * @return the resulting vector
     */
    public Double2 mod(double yX, double yY) {
        return new Double2(Math.fma(-yX, Math.floor(this.x / yX), this.x), Math.fma(-yY, Math.floor(this.y / yY), this.y));
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 nextDown() {
        return new Double2(Math.nextDown(this.x), Math.nextDown(this.y));
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 nextUp() {
        return new Double2(Math.nextUp(this.x), Math.nextUp(this.y));
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
    public Double2 normalize() {
        double _t1 = Math.fma(this.x, this.x, this.y * this.y);
        double _t2 = (1.0 / Math.sqrt(_t1));
        if (_t1 > 0.0) {
            return new Double2(this.x * _t2, this.y * _t2);
        } else {
            return Double2.ZERO;
        }
    }


    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector), returning the result as a value.
     *
     * @param length the length to rescale to
     * @return the resulting vector
     */
    public Double2 normalizeMul(double length) {
        double _t1 = Math.fma(this.x, this.x, this.y * this.y);
        double _t3 = length * (1.0 / Math.sqrt(_t1));
        if (_t1 > 0.0) {
            return new Double2(this.x * _t3, this.y * _t3);
        } else {
            return Double2.ZERO;
        }
    }


    /**
     * Compute the signed angle in radians between this vector and {@code other}.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @return the signed angle in radians between this vector and {@code other}
     */
    public double orientedAngle(Double2 other) {
        return orientedAngle(other.x(), other.y());
    }


    /**
     * Compute the signed angle in radians between this vector and ({@code otherX}, {@code otherY}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY)}
     * @return the signed angle in radians between this vector and ({@code otherX}, {@code otherY})
     */
    public double orientedAngle(double otherX, double otherY) {
        return Math.atan2(Math.fma(otherY, this.x, -(otherX * this.y)), Math.fma(otherX, this.x, otherY * this.y));
    }


    /**
     * Compute the outer product of this vector and {@code row}, returning the result as a value.
     *
     * @param row the row vector (right operand)
     * @return the resulting matrix
     */
    public Double2x2 outerProduct(Double2 row) {
        return outerProduct(row.x(), row.y());
    }


    /**
     * Compute the outer product of this vector and ({@code rowX}, {@code rowY}), returning the
     * result as a value.
     *
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY)}
     * @return the resulting matrix
     */
    public Double2x2 outerProduct(double rowX, double rowY) {
        return new Double2x2(rowX * this.x, rowY * this.x, rowX * this.y, rowY * this.y, 0);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Double2 pow(double exponent) {
        return pow(exponent, exponent);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Double2 pow(Double2 exponent) {
        return pow(exponent.x(), exponent.y());
    }


    /**
     * Raise each component of this vector to the power of ({@code exponentX}, {@code exponentY}),
     * returning the result as a value.
     *
     * @param exponentX the {@code x} component of the vector {@code (exponentX, exponentY)}
     * @param exponentY the {@code y} component of the vector {@code (exponentX, exponentY)}
     * @return the resulting vector
     */
    public Double2 pow(double exponentX, double exponentY) {
        return new Double2(Math.pow(this.x, exponentX), Math.pow(this.y, exponentY));
    }


    /**
     * Project this vector onto {@code onto}, returning the result as a value.
     *
     * @param onto the vector to project onto
     * @return the resulting vector
     */
    public Double2 project(Double2 onto) {
        return project(onto.x(), onto.y());
    }


    /**
     * Project this vector onto ({@code ontoX}, {@code ontoY}), returning the result as a value.
     *
     * @param ontoX the {@code x} component of the vector {@code (ontoX, ontoY)}
     * @param ontoY the {@code y} component of the vector {@code (ontoX, ontoY)}
     * @return the resulting vector
     */
    public Double2 project(double ontoX, double ontoY) {
        double _t2 = Math.fma(ontoX, this.x, ontoY * this.y);
        double _t3 = Math.fma(ontoX, ontoX, ontoY * ontoY);
        double _t3_inv = 1.0 / _t3;
        return new Double2(ontoX * _t2 * _t3_inv, ontoY * _t2 * _t3_inv);
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Double2 projectOnPlane(Double2 normal) {
        return projectOnPlane(normal.x(), normal.y());
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY)} (the vector
     *        must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY)} (the vector
     *        must have unit length)
     * @return the resulting vector
     */
    public Double2 projectOnPlane(double normalX, double normalY) {
        double _t1 = Math.fma(normalX, this.x, normalY * this.y);
        return new Double2(Math.fma(-normalX, _t1, this.x), Math.fma(-normalY, _t1, this.y));
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 radians() {
        return new Double2(Math.toRadians(this.x), Math.toRadians(this.y));
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Double2 reflect(Double2 normal) {
        return reflect(normal.x(), normal.y());
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY)} (the vector
     *        must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY)} (the vector
     *        must have unit length)
     * @return the resulting vector
     */
    public Double2 reflect(double normalX, double normalY) {
        double _t2 = 2.0 * Math.fma(normalX, this.x, normalY * this.y);
        return new Double2(Math.fma(-normalX, _t2, this.x), Math.fma(-normalY, _t2, this.y));
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
    public Double2 refract(Double2 normal, double eta) {
        return refract(normal.x(), normal.y(), eta);
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY)} (the vector
     *        must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY)} (the vector
     *        must have unit length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return the resulting vector
     */
    public Double2 refract(double normalX, double normalY, double eta) {
        double _t2 = Math.fma(normalX, this.x, normalY * this.y);
        double _t6 = Math.fma(-Math.fma(-_t2, _t2, 1.0), eta * eta, 1.0);
        double _t9 = Math.fma(eta, _t2, Math.sqrt(Math.max(0.0, _t6)));
        if (_t6 >= 0.0) {
            return new Double2(Math.fma(eta, this.x, -(normalX * _t9)), Math.fma(eta, this.y, -(normalY * _t9)));
        } else {
            return Double2.ZERO;
        }
    }


    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 round() {
        return new Double2(Math.rint(this.x), Math.rint(this.y));
    }


    /**
     * Compute the sign of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 sign() {
        return new Double2(Math.signum(this.x), Math.signum(this.y));
    }


    /**
     * Compute the sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 sin() {
        return new Double2(Math.sin(this.x), Math.sin(this.y));
    }


    /**
     * Compute the hyperbolic sine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 sinh() {
        return new Double2(Math.sinh(this.x), Math.sinh(this.y));
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
    public Double2 smoothstep(double edge0, double edge1) {
        double _t0 = edge1 - edge0;
        double _t0_inv = 1.0 / _t0;
        double _t7 = Math.max(0.0, Math.min(1.0, (this.x - edge0) * _t0_inv));
        double _t8 = Math.max(0.0, Math.min(1.0, (this.y - edge0) * _t0_inv));
        return new Double2(Math.fma(-2.0, _t7, 3.0) * _t7 * _t7, Math.fma(-2.0, _t8, 3.0) * _t8 * _t8);
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
    public Double2 smoothstep(Double2 edge0, Double2 edge1) {
        return smoothstep(edge0.x(), edge0.y(), edge1.x(), edge1.y());
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}) and the upper edge ({@code edge1X},
     * {@code edge1Y}), yielding 0 at or below the lower edge and 1 at or above the upper edge,
     * returning the result as a value.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y)}
     * @return the resulting vector
     */
    public Double2 smoothstep(double edge0X, double edge0Y, double edge1X, double edge1Y) {
        double _t8 = Math.max(0.0, Math.min(1.0, (this.x - edge0X) / (edge1X - edge0X)));
        double _t9 = Math.max(0.0, Math.min(1.0, (this.y - edge0Y) / (edge1Y - edge0Y)));
        return new Double2(Math.fma(-2.0, _t8, 3.0) * _t8 * _t8, Math.fma(-2.0, _t9, 3.0) * _t9 * _t9);
    }


    /**
     * Compute the square root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 sqrt() {
        return new Double2(Math.sqrt(this.x), Math.sqrt(this.y));
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Double2 step(double edge) {
        return step(edge, edge);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Double2 step(Double2 edge) {
        return step(edge.x(), edge.y());
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edgeX the {@code x} component of the vector {@code (edgeX, edgeY)}
     * @param edgeY the {@code y} component of the vector {@code (edgeX, edgeY)}
     * @return the resulting vector
     */
    public Double2 step(double edgeX, double edgeY) {
        return new Double2(this.x < edgeX ? 0.0 : 1.0, this.y < edgeY ? 0.0 : 1.0);
    }


    /**
     * Compute the tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Double2 tan() {
        return new Double2(Math.tan(this.x), Math.tan(this.y));
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 tanh() {
        return new Double2(Math.tanh(this.x), Math.tanh(this.y));
    }


    /**
     * Compute the truncated value of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Double2 trunc() {
        return new Double2(this.x >= 0.0 ? Math.floor(this.x) : Math.ceil(this.x), this.y >= 0.0 ? Math.floor(this.y) : Math.ceil(this.y));
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Double2 ulp() {
        return new Double2(Math.ulp(this.x), Math.ulp(this.y));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this}, returning the
     * result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double2 preMul(Double2x2 mat) {
        return new Double2(Math.fma(mat.m00(), this.x, mat.m01() * this.y), Math.fma(mat.m10(), this.x, mat.m11() * this.y));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double2 preMulDirection(Double2x3 mat) {
        return new Double2(Math.fma(mat.m00(), this.x, mat.m01() * this.y), Math.fma(mat.m10(), this.x, mat.m11() * this.y));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Double2 preMulPosition(Double2x3 mat) {
        return new Double2(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, mat.m02())), Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, mat.m12())));
    }


    /**
     * Rotate this vector counter-clockwise about the origin by {@code angle} radians, returning the
     * result as a value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Double2 rotate(double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        return new Double2(Math.fma(this.x, _t0, -(this.y * _t1)), Math.fma(this.x, _t1, this.y * _t0));
    }

    /** {@return a copy of this vector with the X component replaced by the given value} */
    public Double2 withX(double x) {
        return new Double2(x, this.y());
    }

    /** {@return a copy of this vector with the Y component replaced by the given value} */
    public Double2 withY(double y) {
        return new Double2(this.x(), y);
    }

    /** {@return a copy of this vector with the XY components replaced by the given values} */
    public Double2 withXY(double x, double y) {
        return new Double2(x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}) of this vector, in that order} */
    public Double2 xx() {
        return new Double2(x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}) of this vector, in that order} */
    public Double2 xy() {
        return new Double2(x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}) of this vector, in that order} */
    public Double2 yx() {
        return new Double2(y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}) of this vector, in that order} */
    public Double2 yy() {
        return new Double2(y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double3 xxx() {
        return new Double3(x, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double3 xxy() {
        return new Double3(x, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double3 xyx() {
        return new Double3(x, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double3 xyy() {
        return new Double3(x, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double3 yxx() {
        return new Double3(y, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double3 yxy() {
        return new Double3(y, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double3 yyx() {
        return new Double3(y, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double3 yyy() {
        return new Double3(y, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 xxxx() {
        return new Double4(x, x, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 xxxy() {
        return new Double4(x, x, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 xxyx() {
        return new Double4(x, x, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 xxyy() {
        return new Double4(x, x, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 xyxx() {
        return new Double4(x, y, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 xyxy() {
        return new Double4(x, y, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 xyyx() {
        return new Double4(x, y, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 xyyy() {
        return new Double4(x, y, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 yxxx() {
        return new Double4(y, x, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 yxxy() {
        return new Double4(y, x, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 yxyx() {
        return new Double4(y, x, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 yxyy() {
        return new Double4(y, x, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Double4 yyxx() {
        return new Double4(y, y, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Double4 yyxy() {
        return new Double4(y, y, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Double4 yyyx() {
        return new Double4(y, y, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Double4 yyyy() {
        return new Double4(y, y, y, y);
    }

    @Override public String toString() {
        return "Double2(" + x() + ", " + y() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double2)) return false;
        Double2 o = (Double2) obj;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(o.x)
            && Double.doubleToLongBits(y) == Double.doubleToLongBits(o.y);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Double.isFinite(x)
            && Double.isFinite(y);
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
    public boolean equalsEpsilon(Double2 other, double epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon;
    }

    static final Double2SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double2SegOpsUnsafe()
                    : new Double2SegOpsMS();
    static final Double2BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double2BbOpsUnsafe()
                    : new Double2BbOpsApi();
    static final Double2RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double2RawOpsUnsafe()
                    : new Double2RawOpsApi();


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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(double[] src, int offset) {
        double _c0 = src[offset + 0];
        double _c1 = src[offset + 1];
        return new Double2(_c0, _c1);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(double[] src) { return load(src, 0); }

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
        buf.position(pos + 2);
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(DoubleBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadAbsolute(int index, DoubleBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Double2 r = loadAbsolute(pos, buf);
        buf.position(pos + 2);
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
        buf.position(pos + 16);
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(ByteBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadAbsolute(int index, ByteBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        Double2 r = loadAbsolute(pos, buf);
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
    public Double2 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadUnsafe(long address) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(long offset, MemorySegment src) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(float[] src, int offset) {
        double _c0 = src[offset + 0];
        double _c1 = src[offset + 1];
        return new Double2(_c0, _c1);
    }

    /**
     * Load the elements from the given array, converting each element from {@code float}.
     *
     * @param src the source array
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(float[] src) { return load(src, 0); }

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
        buf.position(pos + 2);
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 load(FloatBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadAbsolute(int index, FloatBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        Double2 r = loadAbsolute(pos, buf);
        buf.position(pos + 2);
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
        buf.position(pos + 8);
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadFloat(ByteBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadFloatAbsolute(int index, ByteBuffer buf) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadFloatRelative(ByteBuffer buf) {
        int pos = buf.position();
        Double2 r = loadFloatAbsolute(pos, buf);
        buf.position(pos + 8);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Double2 storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code float}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadFloatUnsafe(long address) {
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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadFloat(MemorySegment src) { return loadFloat(0L, src); }

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
     * @return a new {@code Double2} holding the loaded elements
     */
    public static Double2 loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(offset, src);
    }

}
