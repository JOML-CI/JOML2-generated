package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable 3D vector of single-precision {@code float} components, declared as a value record.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance; as a value class, instances have no identity and may be flattened by the JVM.
 * <p>
 * {@code equals} compares the components element-wise and bitwise, as by
 * {@code Float.floatToIntBits}: {@code 0.0} and {@code -0.0} are not equal, and NaN is equal to
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
@jdk.internal.vm.annotation.LooselyConsistentValue
public value record Float3(float x, float y, float z) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 12;

    /** The zero vector (all components 0). */
    public static final Float3 ZERO = new Float3(0, 0, 0);

    /** Canonical constructor. */
    public Float3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Create a new instance initialized to all zeros.
     */
    public Float3() {
        this(0, 0, 0);
    }

    /** Create a vector with all components set to {@code s}. */
    public Float3(float s) {
        this(s, s, s);
    }

    /** Create a vector composed of the given parts, in order. */
    public Float3(float v0, Float2 v1) {
        this(v0, v1.x(), v1.y());
    }

    /** Create a vector composed of the given parts, in order. */
    public Float3(Float2 v0, float v1) {
        this(v0.x(), v0.y(), v1);
    }

    /** {@return the {@code x} component} */
    public float x() { return x; }
    /** {@return the {@code y} component} */
    public float y() { return y; }
    /** {@return the {@code z} component} */
    public float z() { return z; }


    /**
     * Add {@code other} to this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 add(Float3 other) {
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
    public Float3 add(float otherX, float otherY, float otherZ) {
        return new Float3(otherX + this.x, otherY + this.y, otherZ + this.z);
    }


    /**
     * Divide each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float3 div(float scalar) {
        return div(scalar, scalar, scalar);
    }


    /**
     * Divide this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 div(Float3 other) {
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
    public Float3 div(float otherX, float otherY, float otherZ) {
        return new Float3(this.x / otherX, this.y / otherY, this.z / otherZ);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Float3 fma(float b, Float3 c) {
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
    public Float3 fma(float b, float cX, float cY, float cZ) {
        return new Float3(Math.fma(this.x, b, cX), Math.fma(this.y, b, cY), Math.fma(this.z, b, cZ));
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Float3 fma(Float3 b, Float3 c) {
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
    public Float3 fma(float bX, float bY, float bZ, float cX, float cY, float cZ) {
        return new Float3(Math.fma(this.x, bX, cX), Math.fma(this.y, bY, cY), Math.fma(this.z, bZ, cZ));
    }


    /**
     * Multiply each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float3 mul(float scalar) {
        return mul(scalar, scalar, scalar);
    }


    /**
     * Multiply this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 mul(Float3 other) {
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
    public Float3 mul(float otherX, float otherY, float otherZ) {
        return new Float3(otherX * this.x, otherY * this.y, otherZ * this.z);
    }


    /**
     * Negate this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 negate() {
        return new Float3(-this.x, -this.y, -this.z);
    }


    /**
     * Subtract {@code other} from this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 sub(Float3 other) {
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
    public Float3 sub(float otherX, float otherY, float otherZ) {
        return new Float3(this.x - otherX, this.y - otherY, this.z - otherZ);
    }


    /**
     * Create a new vector from the given values.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float3 set(Float3 v) {
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
    public Float3 set(float vX, float vY, float vZ) {
        return new Float3(vX, vY, vZ);
    }


    /**
     * Set this vector to {@code s}, returning the result as a value.
     *
     * @param s the value assigned to every component
     * @return the resulting vector
     */
    public Float3 set(float s) {
        return new Float3(s, s, s);
    }


    /**
     * Convert this vector to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double3} holding the result
     */
    public Double3 toDouble() {
        return new Double3(this.x, this.y, this.z);
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
            case HALF_TOWARD_POSITIVE_INFINITY -> new Byte3((byte) Math.round(this.x), (byte) Math.round(this.y), (byte) Math.round(this.z));
            case HALF_AWAY_FROM_ZERO -> new Byte3((byte) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (byte) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (byte) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)));
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
            case HALF_TOWARD_POSITIVE_INFINITY -> new Short3((short) Math.round(this.x), (short) Math.round(this.y), (short) Math.round(this.z));
            case HALF_AWAY_FROM_ZERO -> new Short3((short) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (short) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (short) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)));
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
            case HALF_TOWARD_POSITIVE_INFINITY -> new Int3(Math.round(this.x), Math.round(this.y), Math.round(this.z));
            case HALF_AWAY_FROM_ZERO -> new Int3((int) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (int) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (int) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)));
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
            case HALF_TOWARD_POSITIVE_INFINITY -> new Long3(Math.round((double) (this.x)), Math.round((double) (this.y)), Math.round((double) (this.z)));
            case HALF_AWAY_FROM_ZERO -> new Long3((long) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (long) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (long) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)));
            case HALF_EVEN -> new Long3((long) Math.rint(this.x), (long) Math.rint(this.y), (long) Math.rint(this.z));
        };
    }


    /**
     * Create an all-zero vector.
     *
     * @return the resulting vector
     */
    public static Float3 makeZero() {
        return Float3.ZERO;
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
    public Float3 bezier(Float3 p1, Float3 p2, Float3 p3, float t) {
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
    public Float3 bezier(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        return new Float3(Math.fma(p1X, _t7, this.x * _t8) + Math.fma(p2X, _t6, p3X * _t2), Math.fma(p1Y, _t7, this.y * _t8) + Math.fma(p2Y, _t6, p3Y * _t2), Math.fma(p1Z, _t7, this.z * _t8) + Math.fma(p2Z, _t6, p3Z * _t2));
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
    public Float3 bezier2(Float3 p1, Float3 p2, float t) {
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
    public Float3 bezier2(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t) {
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        return new Float3(Math.fma(p2X, _t0, Math.fma(p1X, _t3, this.x * _t4)), Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, this.y * _t4)), Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, this.z * _t4)));
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
    public Float3 bezier2Tangent(Float3 p1, Float3 p2, float t) {
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
    public Float3 bezier2Tangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t) {
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        return new Float3(Math.fma(p1X - this.x, _t2, (p2X - p1X) * _t1), Math.fma(p1Y - this.y, _t2, (p2Y - p1Y) * _t1), Math.fma(p1Z - this.z, _t2, (p2Z - p1Z) * _t1));
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
    public Float3 bezierTangent(Float3 p1, Float3 p2, Float3 p3, float t) {
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
    public Float3 bezierTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        return new Float3(Math.fma(p3X - p2X, _t2, Math.fma(p1X - this.x, _t6, (p2X - p1X) * _t5)), Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - this.y, _t6, (p2Y - p1Y) * _t5)), Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - this.z, _t6, (p2Z - p1Z) * _t5)));
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
    public Float3 catmullRom(Float3 p1, Float3 p2, Float3 p3, float t) {
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
    public Float3 catmullRom(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _t0 = t * t;
        float _t1 = t * _t0;
        return new Float3(0.5f * (Math.fma(2.0f, p1X, t * (p2X - this.x)) + Math.fma(Math.fma(-5.0f, p1X, Math.fma(2.0f, this.x, Math.fma(4.0f, p2X, -p3X))), _t0, Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - this.x)) * _t1)), 0.5f * (Math.fma(2.0f, p1Y, t * (p2Y - this.y)) + Math.fma(Math.fma(-5.0f, p1Y, Math.fma(2.0f, this.y, Math.fma(4.0f, p2Y, -p3Y))), _t0, Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - this.y)) * _t1)), 0.5f * (Math.fma(2.0f, p1Z, t * (p2Z - this.z)) + Math.fma(Math.fma(-5.0f, p1Z, Math.fma(2.0f, this.z, Math.fma(4.0f, p2Z, -p3Z))), _t0, Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - this.z)) * _t1)));
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
    public Float3 catmullRomTangent(Float3 p1, Float3 p2, Float3 p3, float t) {
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
    public Float3 catmullRomTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _t0 = t * t;
        return new Float3(0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1X, Math.fma(2.0f, this.x, Math.fma(4.0f, p2X, -p3X))), Math.fma(3.0f * Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - this.x)), _t0, p2X - this.x)), 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Y, Math.fma(2.0f, this.y, Math.fma(4.0f, p2Y, -p3Y))), Math.fma(3.0f * Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - this.y)), _t0, p2Y - this.y)), 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Z, Math.fma(2.0f, this.z, Math.fma(4.0f, p2Z, -p3Z))), Math.fma(3.0f * Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - this.z)), _t0, p2Z - this.z)));
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
    public Float3 hermite(Float3 t0, Float3 v1, Float3 t1, float t) {
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
    public Float3 hermite(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t) {
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        return new Float3(Math.fma(this.x, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9), Math.fma(this.y, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9), Math.fma(this.z, _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9));
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
    public Float3 hermiteTangent(Float3 t0, Float3 v1, Float3 t1, float t) {
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
    public Float3 hermiteTangent(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t) {
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        return new Float3(Math.fma(this.x, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7), Math.fma(this.y, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7), Math.fma(this.z, _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float3 lerp(Float3 other, float t) {
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
    public Float3 lerp(float otherX, float otherY, float otherZ, float t) {
        return new Float3(Math.fma(t, otherX - this.x, this.x), Math.fma(t, otherY - this.y, this.y), Math.fma(t, otherZ - this.z, this.z));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float3 lerp(Float3 other, Float3 t) {
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
    public Float3 lerp(float otherX, float otherY, float otherZ, float tX, float tY, float tZ) {
        return new Float3(Math.fma(tX, otherX - this.x, this.x), Math.fma(tY, otherY - this.y, this.y), Math.fma(tZ, otherZ - this.z, this.z));
    }


    /**
     * Compute the absolute value of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 absolute() {
        return new Float3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }


    /**
     * Compute the arc cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 acos() {
        return new Float3((float) Math.acos(this.x), (float) Math.acos(this.y), (float) Math.acos(this.z));
    }


    /**
     * Add {@code b} scaled by {@code scalar} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float3 addScaled(Float3 b, float scalar) {
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
    public Float3 addScaled(float bX, float bY, float bZ, float scalar) {
        return new Float3(Math.fma(scalar, bX, this.x), Math.fma(scalar, bY, this.y), Math.fma(scalar, bZ, this.z));
    }


    /**
     * Add {@code b} scaled by {@code c} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param c the vector
     * @return the resulting vector
     */
    public Float3 addScaled(Float3 b, Float3 c) {
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
    public Float3 addScaled(float bX, float bY, float bZ, float cX, float cY, float cZ) {
        return new Float3(Math.fma(bX, cX, this.x), Math.fma(bY, cY, this.y), Math.fma(bZ, cZ, this.z));
    }


    /**
     * Compute the angle in radians between this vector and {@code other}.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @return the angle in radians between this vector and {@code other}
     */
    public float angleBetween(Float3 other) {
        return angleBetween(other.x(), other.y(), other.z());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public float angleBetween(float otherX, float otherY, float otherZ) {
        float _t6 = Math.fma(otherZ, this.y, -(otherY * this.z));
        float _t7 = Math.fma(otherY, this.x, -(otherX * this.y));
        float _t8 = Math.fma(otherZ, this.x, -(otherX * this.z));
        return (float) Math.atan2((float) Math.sqrt(Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8))), Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
    }


    /**
     * Compute the arc sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 asin() {
        return new Float3((float) Math.asin(this.x), (float) Math.asin(this.y), (float) Math.asin(this.z));
    }


    /**
     * Compute the arc tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 atan() {
        return new Float3((float) Math.atan(this.x), (float) Math.atan(this.y), (float) Math.atan(this.z));
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator), returning the result
     * as a value.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return the resulting vector
     */
    public Float3 atan2(float x) {
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
    public Float3 atan2(Float3 x) {
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
    public Float3 atan2(float xX, float xY, float xZ) {
        return new Float3((float) Math.atan2(this.x, xX), (float) Math.atan2(this.y, xY), (float) Math.atan2(this.z, xZ));
    }


    /**
     * Compute the cube root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 cbrt() {
        return new Float3((float) Math.cbrt(this.x), (float) Math.cbrt(this.y), (float) Math.cbrt(this.z));
    }


    /**
     * Compute the ceiling of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 ceil() {
        return new Float3((float) Math.ceil(this.x), (float) Math.ceil(this.y), (float) Math.ceil(this.z));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return the resulting vector
     */
    public Float3 clamp(float min, float max) {
        return new Float3(Math.min(Math.max(this.x, min), max), Math.min(Math.max(this.y, min), max), Math.min(Math.max(this.z, min), max));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @return the resulting vector
     */
    public Float3 clamp(Float3 min, Float3 max) {
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
    public Float3 clamp(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        return new Float3(Math.min(Math.max(this.x, minX), maxX), Math.min(Math.max(this.y, minY), maxY), Math.min(Math.max(this.z, minZ), maxZ));
    }


    /**
     * Compute the point on the line segment between {@code lineStart} and {@code lineEnd} that is
     * closest to this vector, returning the result as a value.
     *
     * @param lineStart the vector
     * @param lineEnd the vector
     * @return the resulting vector
     */
    public Float3 closestPointOnLine(Float3 lineStart, Float3 lineEnd) {
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
    public Float3 closestPointOnLine(float lineStartX, float lineStartY, float lineStartZ, float lineEndX, float lineEndY, float lineEndZ) {
        float _t0 = lineEndZ - lineStartZ;
        float _t1 = lineEndX - lineStartX;
        float _t2 = lineEndY - lineStartY;
        float _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t14 = Math.max(0.0f, Math.min(1.0f, Math.fma(_t0, this.z - lineStartZ, Math.fma(_t1, this.x - lineStartX, _t2 * (this.y - lineStartY))) / _t10));
        if (_t10 > 0.0f) {
            return new Float3(Math.fma(_t1, _t14, lineStartX), Math.fma(_t2, _t14, lineStartY), Math.fma(_t0, _t14, lineStartZ));
        } else {
            return new Float3(lineStartX, lineStartY, lineStartZ);
        }
    }


    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    public float compAdd() {
        return this.z + (this.x + this.y);
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public float compMax() {
        return Math.max(Math.max(this.x, this.y), this.z);
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public float compMin() {
        return Math.min(Math.min(this.x, this.y), this.z);
    }


    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    public float compMul() {
        return this.z * this.x * this.y;
    }


    /**
     * Copy the sign of {@code sign} onto each component of this vector, returning the result as a
     * value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Float3 copySign(float sign) {
        return copySign(sign, sign, sign);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector, returning the result as a value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Float3 copySign(Float3 sign) {
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
    public Float3 copySign(float signX, float signY, float signZ) {
        return new Float3(Math.copySign(this.x, signX), Math.copySign(this.y, signY), Math.copySign(this.z, signZ));
    }


    /**
     * Compute the cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 cos() {
        return new Float3((float) Math.cos(this.x), (float) Math.cos(this.y), (float) Math.cos(this.z));
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 cosh() {
        return new Float3((float) Math.cosh(this.x), (float) Math.cosh(this.y), (float) Math.cosh(this.z));
    }


    /**
     * Compute the cross product of this vector and {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 cross(Float3 other) {
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
    public Float3 cross(float otherX, float otherY, float otherZ) {
        return new Float3(Math.fma(otherZ, this.y, -(otherY * this.z)), Math.fma(otherX, this.z, -(otherZ * this.x)), Math.fma(otherY, this.x, -(otherX * this.y)));
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 degrees() {
        return new Float3((float) Math.toDegrees(this.x), (float) Math.toDegrees(this.y), (float) Math.toDegrees(this.z));
    }


    /**
     * Compute the distance between this vector and {@code other}.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the difference vector must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param other the other vector
     * @return the distance between this vector and {@code other}
     */
    public float distance(Float3 other) {
        return distance(other.x(), other.y(), other.z());
    }


    /**
     * Compute the distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the difference vector must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     */
    public float distance(float otherX, float otherY, float otherZ) {
        float _t0 = this.z - otherZ;
        float _t1 = this.x - otherX;
        float _t2 = this.y - otherY;
        return (float) Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public float distanceSquared(Float3 other) {
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
    public float distanceSquared(float otherX, float otherY, float otherZ) {
        float _t0 = this.z - otherZ;
        float _t1 = this.x - otherX;
        float _t2 = this.y - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public float dot(Float3 other) {
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
    public float dot(float otherX, float otherY, float otherZ) {
        return Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y));
    }


    /**
     * Compute the base-e exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 exp() {
        return new Float3((float) Math.exp(this.x), (float) Math.exp(this.y), (float) Math.exp(this.z));
    }


    /**
     * Compute the base-2 exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 exp2() {
        return new Float3((float) Math.pow(2.0f, this.x), (float) Math.pow(2.0f, this.y), (float) Math.pow(2.0f, this.z));
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Float3 expm1() {
        return new Float3((float) Math.expm1(this.x), (float) Math.expm1(this.y), (float) Math.expm1(this.z));
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
    public Float3 faceforward(Float3 I, Float3 Nref) {
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
    public Float3 faceforward(float IX, float IY, float IZ, float NrefX, float NrefY, float NrefZ) {
        float _t2 = Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY));
        if (_t2 < 0.0f) {
            return new Float3(this.x, this.y, this.z);
        } else {
            return new Float3(-this.x, -this.y, -this.z);
        }
    }


    /**
     * Compute the floor of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 floor() {
        return new Float3((float) Math.floor(this.x), (float) Math.floor(this.y), (float) Math.floor(this.z));
    }


    /**
     * Compute the fractional part of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 fract() {
        return new Float3(this.x - (float) Math.floor(this.x), this.y - (float) Math.floor(this.y), this.z - (float) Math.floor(this.z));
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y}, returning the result as a value.
     *
     * @param y the other operand
     * @return the resulting vector
     */
    public Float3 hypot(float y) {
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
    public Float3 hypot(Float3 y) {
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
    public Float3 hypot(float yX, float yY, float yZ) {
        return new Float3((float) Math.hypot(this.x, yX), (float) Math.hypot(this.y, yY), (float) Math.hypot(this.z, yZ));
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector, returning the result
     * as a value.
     *
     * @return the resulting vector
     */
    public Float3 inverse() {
        return new Float3(1.0f / this.x, 1.0f / this.y, 1.0f / this.z);
    }


    /**
     * Compute the inverse square root of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 inverseSqrt() {
        return new Float3((1.0f / (float) Math.sqrt(this.x)), (1.0f / (float) Math.sqrt(this.y)), (1.0f / (float) Math.sqrt(this.z)));
    }


    /**
     * Compute the length of this vector.
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of this vector must lie roughly between
     * {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @return the length of this vector
     */
    public float length() {
        return (float) Math.sqrt(Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public float lengthSquared() {
        return Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
    }


    /**
     * Compute the natural logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 log() {
        return new Float3((float) Math.log(this.x), (float) Math.log(this.y), (float) Math.log(this.z));
    }


    /**
     * Compute the base-10 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 log10() {
        return new Float3((float) Math.log10(this.x), (float) Math.log10(this.y), (float) Math.log10(this.z));
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 log1p() {
        return new Float3((float) Math.log1p(this.x), (float) Math.log1p(this.y), (float) Math.log1p(this.z));
    }


    /**
     * Compute the base-2 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 log2() {
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        return new Float3((float) Math.log(this.x) * _t0_inv, (float) Math.log(this.y) * _t0_inv, (float) Math.log(this.z) * _t0_inv);
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public float manhattanDistance(Float3 other) {
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
    public float manhattanDistance(float otherX, float otherY, float otherZ) {
        return Math.abs(this.x - otherX) + Math.abs(this.y - otherY) + Math.abs(this.z - otherZ);
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public float manhattanLength() {
        return Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float3 max(float scalar) {
        return max(scalar, scalar, scalar);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 max(Float3 other) {
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
    public Float3 max(float otherX, float otherY, float otherZ) {
        return new Float3(Math.max(this.x, otherX), Math.max(this.y, otherY), Math.max(this.z, otherZ));
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float3 min(float scalar) {
        return min(scalar, scalar, scalar);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float3 min(Float3 other) {
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
    public Float3 min(float otherX, float otherY, float otherZ) {
        return new Float3(Math.min(this.x, otherX), Math.min(this.y, otherY), Math.min(this.z, otherZ));
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
    public Float3 mod(float y) {
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
    public Float3 mod(Float3 y) {
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
    public Float3 mod(float yX, float yY, float yZ) {
        return new Float3(Math.fma(-yX, (float) Math.floor(this.x / yX), this.x), Math.fma(-yY, (float) Math.floor(this.y / yY), this.y), Math.fma(-yZ, (float) Math.floor(this.z / yZ), this.z));
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 nextDown() {
        return new Float3(Math.nextDown(this.x), Math.nextDown(this.y), Math.nextDown(this.z));
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 nextUp() {
        return new Float3(Math.nextUp(this.x), Math.nextUp(this.y), Math.nextUp(this.z));
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
    public Float3 normalize() {
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(this.x * _t3, this.y * _t3, this.z * _t3);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector), returning the result as a value.
     *
     * @param length the length to rescale to
     * @return the resulting vector
     */
    public Float3 normalizeMul(float length) {
        float _t2 = Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y));
        float _t4 = length * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            return new Float3(this.x * _t4, this.y * _t4, this.z * _t4);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Compute the signed angle in radians between this vector and {@code other}, positive when the
     * rotation from this vector to {@code other} is counter-clockwise as seen from the direction of
     * the given normal.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param other the other vector
     * @param normal the reference axis that defines the sign of the angle
     * @return the signed angle in radians between this vector and {@code other}, positive when the
     *        rotation from this vector to {@code other} is counter-clockwise as seen from the
     *        direction of the given normal
     */
    public float orientedAngle(Float3 other, Float3 normal) {
        return orientedAngle(other.x(), other.y(), other.z(), normal.x(), normal.y(), normal.z());
    }


    /**
     * Compute the signed angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}), positive when the rotation from this vector to ({@code otherX},
     * {@code otherY}, {@code otherZ}) is counter-clockwise as seen from the direction of the given
     * normal.
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
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
    public float orientedAngle(float otherX, float otherY, float otherZ, float normalX, float normalY, float normalZ) {
        float _t8 = Math.fma(otherY, this.x, -(otherX * this.y));
        float _t9 = Math.fma(otherZ, this.y, -(otherY * this.z));
        float _t10 = Math.fma(otherX, this.z, -(otherZ * this.x));
        float _t16 = (float) Math.atan2((float) Math.sqrt(Math.fma(_t8, _t8, Math.fma(_t10, _t10, _t9 * _t9))), Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
        return Math.fma(normalZ, _t8, Math.fma(normalX, _t9, normalY * _t10)) < 0.0f ? -_t16 : _t16;
    }


    /**
     * Compute the outer product of this vector and {@code row}, returning the result as a value.
     *
     * @param row the row vector (right operand)
     * @return the resulting matrix
     */
    public Float3x3 outerProduct(Float3 row) {
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
    public Float3x3 outerProduct(float rowX, float rowY, float rowZ) {
        return new Float3x3(rowX * this.x, rowY * this.x, rowZ * this.x, rowX * this.y, rowY * this.y, rowZ * this.y, rowX * this.z, rowY * this.z, rowZ * this.z, 0);
    }


    /**
     * Compute a vector perpendicular to this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 perpendicular() {
        float _t1 = Math.fma(this.x, this.x, this.y * this.y);
        if (_t1 > 0.0f) {
            return new Float3(this.y, -this.x, 0.0f);
        } else {
            return new Float3(0.0f, this.z, -this.y);
        }
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Float3 pow(float exponent) {
        return pow(exponent, exponent, exponent);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Float3 pow(Float3 exponent) {
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
    public Float3 pow(float exponentX, float exponentY, float exponentZ) {
        return new Float3((float) Math.pow(this.x, exponentX), (float) Math.pow(this.y, exponentY), (float) Math.pow(this.z, exponentZ));
    }


    /**
     * Project this vector onto {@code onto}, returning the result as a value.
     *
     * @param onto the vector to project onto
     * @return the resulting vector
     */
    public Float3 project(Float3 onto) {
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
    public Float3 project(float ontoX, float ontoY, float ontoZ) {
        float _t4 = Math.fma(ontoZ, this.z, Math.fma(ontoX, this.x, ontoY * this.y));
        float _t5 = Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY));
        float _t5_inv = 1.0f / _t5;
        return new Float3(ontoX * _t4 * _t5_inv, ontoY * _t4 * _t5_inv, ontoZ * _t4 * _t5_inv);
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Float3 projectOnPlane(Float3 normal) {
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
    public Float3 projectOnPlane(float normalX, float normalY, float normalZ) {
        float _t2 = Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y));
        return new Float3(Math.fma(-normalX, _t2, this.x), Math.fma(-normalY, _t2, this.y), Math.fma(-normalZ, _t2, this.z));
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 radians() {
        return new Float3((float) Math.toRadians(this.x), (float) Math.toRadians(this.y), (float) Math.toRadians(this.z));
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Float3 reflect(Float3 normal) {
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
    public Float3 reflect(float normalX, float normalY, float normalZ) {
        float _t3 = 2.0f * Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y));
        return new Float3(Math.fma(-normalX, _t3, this.x), Math.fma(-normalY, _t3, this.y), Math.fma(-normalZ, _t3, this.z));
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
    public Float3 refract(Float3 normal, float eta) {
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
    public Float3 refract(float normalX, float normalY, float normalZ, float eta) {
        float _t3 = Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y));
        float _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0f), eta * eta, 1.0f);
        float _t10 = Math.fma(eta, _t3, (float) Math.sqrt(Math.max(0.0f, _t7)));
        if (_t7 >= 0.0f) {
            return new Float3(Math.fma(eta, this.x, -(normalX * _t10)), Math.fma(eta, this.y, -(normalY * _t10)), Math.fma(eta, this.z, -(normalZ * _t10)));
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 round() {
        return new Float3((float) Math.rint(this.x), (float) Math.rint(this.y), (float) Math.rint(this.z));
    }


    /**
     * Compute the sign of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 sign() {
        return new Float3(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z));
    }


    /**
     * Compute the sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 sin() {
        return new Float3((float) Math.sin(this.x), (float) Math.sin(this.y), (float) Math.sin(this.z));
    }


    /**
     * Compute the hyperbolic sine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 sinh() {
        return new Float3((float) Math.sinh(this.x), (float) Math.sinh(this.y), (float) Math.sinh(this.z));
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
    public Float3 smoothstep(float edge0, float edge1) {
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t10 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0) * _t0_inv));
        float _t11 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0) * _t0_inv));
        float _t12 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0) * _t0_inv));
        return new Float3(Math.fma(-2.0f, _t10, 3.0f) * _t10 * _t10, Math.fma(-2.0f, _t11, 3.0f) * _t11 * _t11, Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12);
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
    public Float3 smoothstep(Float3 edge0, Float3 edge1) {
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
    public Float3 smoothstep(float edge0X, float edge0Y, float edge0Z, float edge1X, float edge1Y, float edge1Z) {
        float _t12 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0X) / (edge1X - edge0X)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0Y) / (edge1Y - edge0Y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0Z) / (edge1Z - edge0Z)));
        return new Float3(Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12, Math.fma(-2.0f, _t13, 3.0f) * _t13 * _t13, Math.fma(-2.0f, _t14, 3.0f) * _t14 * _t14);
    }


    /**
     * Compute the square root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 sqrt() {
        return new Float3((float) Math.sqrt(this.x), (float) Math.sqrt(this.y), (float) Math.sqrt(this.z));
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Float3 step(float edge) {
        return step(edge, edge, edge);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Float3 step(Float3 edge) {
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
    public Float3 step(float edgeX, float edgeY, float edgeZ) {
        return new Float3(this.x < edgeX ? 0.0f : 1.0f, this.y < edgeY ? 0.0f : 1.0f, this.z < edgeZ ? 0.0f : 1.0f);
    }


    /**
     * Compute the tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 tan() {
        return new Float3((float) Math.tan(this.x), (float) Math.tan(this.y), (float) Math.tan(this.z));
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 tanh() {
        return new Float3((float) Math.tanh(this.x), (float) Math.tanh(this.y), (float) Math.tanh(this.z));
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
    public Float3 triangleNormal(Float3 p1, Float3 p2) {
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
    public Float3 triangleNormal(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z) {
        float _t0 = p1X - this.x;
        float _t1 = p2Y - this.y;
        float _t2 = p1Y - this.y;
        float _t3 = p2X - this.x;
        float _t4 = p2Z - this.z;
        float _t5 = p1Z - this.z;
        float _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        float _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        float _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        float _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        float _t18 = (1.0f / (float) Math.sqrt(_t17));
        if (_t17 > 0.0f) {
            return new Float3(_t13 * _t18, _t14 * _t18, _t12 * _t18);
        } else {
            return Float3.ZERO;
        }
    }


    /**
     * Compute the truncated value of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 trunc() {
        return new Float3(this.x >= 0.0f ? (float) Math.floor(this.x) : (float) Math.ceil(this.x), this.y >= 0.0f ? (float) Math.floor(this.y) : (float) Math.ceil(this.y), this.z >= 0.0f ? (float) Math.floor(this.z) : (float) Math.ceil(this.z));
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Float3 ulp() {
        return new Float3(Math.ulp(this.x), Math.ulp(this.y), Math.ulp(this.z));
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 0}, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 xyz0() {
        return new Float4(this.x, this.y, this.z, 0.0f);
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1}, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 xyz1() {
        return new Float4(this.x, this.y, this.z, 1.0f);
    }


    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this}, returning the
     * result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float3 preMul(Float3x3 mat) {
        return new Float3(Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)), Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)), Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float3 preMulDirection(Float3x4 mat) {
        return new Float3(Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)), Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)), Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float3 preMulDirection(Float4x4 mat) {
        return new Float3(Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)), Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)), Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float3 preMulPosition(Float3x4 mat) {
        return new Float3(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, Math.fma(mat.m02(), this.z, mat.m03()))), Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m12(), this.z, mat.m13()))), Math.fma(mat.m20(), this.x, Math.fma(mat.m21(), this.y, Math.fma(mat.m22(), this.z, mat.m23()))));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float3 preMulPosition(Float4x4 mat) {
        return new Float3(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, Math.fma(mat.m02(), this.z, mat.m03()))), Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m12(), this.z, mat.m13()))), Math.fma(mat.m20(), this.x, Math.fma(mat.m21(), this.y, Math.fma(mat.m22(), this.z, mat.m23()))));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1},
     * then perform a perspective divide - i.e. compute {@code r = mat * (this, 1)} and return
     * {@code r.xyz / r.w}, returning the result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float3 preMulProject(Float4x4 mat) {
        float _t2 = Math.fma(mat.m30(), this.x, Math.fma(mat.m31(), this.y, Math.fma(mat.m32(), this.z, mat.m33())));
        float _t2_inv = 1.0f / _t2;
        return new Float3(Math.fma(mat.m00(), this.x, Math.fma(mat.m01(), this.y, Math.fma(mat.m02(), this.z, mat.m03()))) * _t2_inv, Math.fma(mat.m10(), this.x, Math.fma(mat.m11(), this.y, Math.fma(mat.m12(), this.z, mat.m13()))) * _t2_inv, Math.fma(mat.m20(), this.x, Math.fma(mat.m21(), this.y, Math.fma(mat.m22(), this.z, mat.m23()))) * _t2_inv);
    }


    /**
     * Rotate this vector by the quaternion {@code quat}, i.e. compute {@code q * this * q^-1},
     * returning the result as a value.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return the resulting vector
     */
    public Float3 rotate(FloatQuat quat) {
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
    public Float3 rotate(float quatX, float quatY, float quatZ, float quatW) {
        float _t9 = 2.0f * Math.fma(quatX, this.y, -(quatY * this.x));
        float _t10 = 2.0f * Math.fma(quatZ, this.x, -(quatX * this.z));
        float _t11 = 2.0f * Math.fma(quatY, this.z, -(quatZ * this.y));
        return new Float3(Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, this.x))), Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.y))), Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, this.z))));
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis}, returning the result
     * as a value.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting vector
     */
    public Float3 rotateAxis(float angle, Float3 axis) {
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
    public Float3 rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t5 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        return new Float3(Math.fma(_t2, axisX * _t5, Math.fma(this.x, _t0, Math.fma(axisY, this.z, -(axisZ * this.y)) * _t1)), Math.fma(_t2, axisY * _t5, Math.fma(this.y, _t0, Math.fma(axisZ, this.x, -(axisX * this.z)) * _t1)), Math.fma(_t2, axisZ * _t5, Math.fma(this.z, _t0, Math.fma(axisX, this.y, -(axisY * this.x)) * _t1)));
    }


    /**
     * Rotate this vector by the inverse of the given rotation, returning the result as a value.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return the resulting vector
     */
    public Float3 rotateInverse(FloatQuat quat) {
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
    public Float3 rotateInverse(float quatX, float quatY, float quatZ, float quatW) {
        float _t9 = 2.0f * Math.fma(quatX, this.z, -(quatZ * this.x));
        float _t10 = 2.0f * Math.fma(quatY, this.x, -(quatX * this.y));
        float _t11 = 2.0f * Math.fma(quatZ, this.y, -(quatY * this.z));
        return new Float3(Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, this.x))), Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, this.y))), Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.z))));
    }


    /**
     * Rotate this vector by {@code angle} radians about the X axis, returning the result as a
     * value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Float3 rotateX(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3(this.x, Math.fma(this.y, _t0, -(this.z * _t1)), Math.fma(this.y, _t1, this.z * _t0));
    }


    /**
     * Rotate this vector by {@code angle} radians about the Y axis, returning the result as a
     * value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Float3 rotateY(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3(Math.fma(this.x, _t0, this.z * _t1), this.y, Math.fma(this.z, _t0, -(this.x * _t1)));
    }


    /**
     * Rotate this vector by {@code angle} radians about the Z axis, returning the result as a
     * value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Float3 rotateZ(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float3(Math.fma(this.x, _t0, -(this.y * _t1)), Math.fma(this.x, _t1, this.y * _t0), this.z);
    }

    /** {@return a copy of this vector with the X component replaced by the given value} */
    public Float3 withX(float x) {
        return new Float3(x, this.y(), this.z());
    }

    /** {@return a copy of this vector with the Y component replaced by the given value} */
    public Float3 withY(float y) {
        return new Float3(this.x(), y, this.z());
    }

    /** {@return a copy of this vector with the XY components replaced by the given values} */
    public Float3 withXY(float x, float y) {
        return new Float3(x, y, this.z());
    }

    /** {@return a copy of this vector with the Z component replaced by the given value} */
    public Float3 withZ(float z) {
        return new Float3(this.x(), this.y(), z);
    }

    /** {@return a copy of this vector with the XZ components replaced by the given values} */
    public Float3 withXZ(float x, float z) {
        return new Float3(x, this.y(), z);
    }

    /** {@return a copy of this vector with the YZ components replaced by the given values} */
    public Float3 withYZ(float y, float z) {
        return new Float3(this.x(), y, z);
    }

    /** {@return a copy of this vector with the XYZ components replaced by the given values} */
    public Float3 withXYZ(float x, float y, float z) {
        return new Float3(x, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}) of this vector, in that order} */
    public Float2 xx() {
        return new Float2(x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}) of this vector, in that order} */
    public Float2 xy() {
        return new Float2(x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}) of this vector, in that order} */
    public Float2 xz() {
        return new Float2(x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}) of this vector, in that order} */
    public Float2 yx() {
        return new Float2(y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}) of this vector, in that order} */
    public Float2 yy() {
        return new Float2(y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}) of this vector, in that order} */
    public Float2 yz() {
        return new Float2(y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}) of this vector, in that order} */
    public Float2 zx() {
        return new Float2(z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}) of this vector, in that order} */
    public Float2 zy() {
        return new Float2(z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}) of this vector, in that order} */
    public Float2 zz() {
        return new Float2(z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Float3 xxx() {
        return new Float3(x, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Float3 xxy() {
        return new Float3(x, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Float3 xxz() {
        return new Float3(x, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Float3 xyx() {
        return new Float3(x, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Float3 xyy() {
        return new Float3(x, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Float3 xyz() {
        return new Float3(x, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Float3 xzx() {
        return new Float3(x, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Float3 xzy() {
        return new Float3(x, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Float3 xzz() {
        return new Float3(x, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Float3 yxx() {
        return new Float3(y, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Float3 yxy() {
        return new Float3(y, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Float3 yxz() {
        return new Float3(y, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Float3 yyx() {
        return new Float3(y, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Float3 yyy() {
        return new Float3(y, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Float3 yyz() {
        return new Float3(y, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Float3 yzx() {
        return new Float3(y, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Float3 yzy() {
        return new Float3(y, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Float3 yzz() {
        return new Float3(y, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Float3 zxx() {
        return new Float3(z, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Float3 zxy() {
        return new Float3(z, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Float3 zxz() {
        return new Float3(z, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Float3 zyx() {
        return new Float3(z, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Float3 zyy() {
        return new Float3(z, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Float3 zyz() {
        return new Float3(z, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Float3 zzx() {
        return new Float3(z, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Float3 zzy() {
        return new Float3(z, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Float3 zzz() {
        return new Float3(z, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 xxxx() {
        return new Float4(x, x, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 xxxy() {
        return new Float4(x, x, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 xxxz() {
        return new Float4(x, x, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 xxyx() {
        return new Float4(x, x, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 xxyy() {
        return new Float4(x, x, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 xxyz() {
        return new Float4(x, x, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 xxzx() {
        return new Float4(x, x, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 xxzy() {
        return new Float4(x, x, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 xxzz() {
        return new Float4(x, x, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 xyxx() {
        return new Float4(x, y, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 xyxy() {
        return new Float4(x, y, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 xyxz() {
        return new Float4(x, y, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 xyyx() {
        return new Float4(x, y, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 xyyy() {
        return new Float4(x, y, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 xyyz() {
        return new Float4(x, y, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 xyzx() {
        return new Float4(x, y, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 xyzy() {
        return new Float4(x, y, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 xyzz() {
        return new Float4(x, y, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 xzxx() {
        return new Float4(x, z, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 xzxy() {
        return new Float4(x, z, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 xzxz() {
        return new Float4(x, z, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 xzyx() {
        return new Float4(x, z, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 xzyy() {
        return new Float4(x, z, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 xzyz() {
        return new Float4(x, z, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 xzzx() {
        return new Float4(x, z, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 xzzy() {
        return new Float4(x, z, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 xzzz() {
        return new Float4(x, z, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 yxxx() {
        return new Float4(y, x, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 yxxy() {
        return new Float4(y, x, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 yxxz() {
        return new Float4(y, x, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 yxyx() {
        return new Float4(y, x, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 yxyy() {
        return new Float4(y, x, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 yxyz() {
        return new Float4(y, x, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 yxzx() {
        return new Float4(y, x, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 yxzy() {
        return new Float4(y, x, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 yxzz() {
        return new Float4(y, x, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 yyxx() {
        return new Float4(y, y, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 yyxy() {
        return new Float4(y, y, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 yyxz() {
        return new Float4(y, y, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 yyyx() {
        return new Float4(y, y, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 yyyy() {
        return new Float4(y, y, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 yyyz() {
        return new Float4(y, y, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 yyzx() {
        return new Float4(y, y, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 yyzy() {
        return new Float4(y, y, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 yyzz() {
        return new Float4(y, y, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 yzxx() {
        return new Float4(y, z, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 yzxy() {
        return new Float4(y, z, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 yzxz() {
        return new Float4(y, z, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 yzyx() {
        return new Float4(y, z, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 yzyy() {
        return new Float4(y, z, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 yzyz() {
        return new Float4(y, z, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 yzzx() {
        return new Float4(y, z, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 yzzy() {
        return new Float4(y, z, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 yzzz() {
        return new Float4(y, z, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 zxxx() {
        return new Float4(z, x, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 zxxy() {
        return new Float4(z, x, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 zxxz() {
        return new Float4(z, x, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 zxyx() {
        return new Float4(z, x, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 zxyy() {
        return new Float4(z, x, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 zxyz() {
        return new Float4(z, x, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 zxzx() {
        return new Float4(z, x, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 zxzy() {
        return new Float4(z, x, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 zxzz() {
        return new Float4(z, x, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 zyxx() {
        return new Float4(z, y, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 zyxy() {
        return new Float4(z, y, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 zyxz() {
        return new Float4(z, y, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 zyyx() {
        return new Float4(z, y, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 zyyy() {
        return new Float4(z, y, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 zyyz() {
        return new Float4(z, y, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 zyzx() {
        return new Float4(z, y, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 zyzy() {
        return new Float4(z, y, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 zyzz() {
        return new Float4(z, y, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 zzxx() {
        return new Float4(z, z, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 zzxy() {
        return new Float4(z, z, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 zzxz() {
        return new Float4(z, z, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 zzyx() {
        return new Float4(z, z, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 zzyy() {
        return new Float4(z, z, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 zzyz() {
        return new Float4(z, z, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 zzzx() {
        return new Float4(z, z, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 zzzy() {
        return new Float4(z, z, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 zzzz() {
        return new Float4(z, z, z, z);
    }

    @Override public String toString() {
        return "Float3(" + x() + ", " + y() + ", " + z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float3)) return false;
        Float3 o = (Float3) obj;
        return Float.floatToIntBits(x) == Float.floatToIntBits(o.x)
            && Float.floatToIntBits(y) == Float.floatToIntBits(o.y)
            && Float.floatToIntBits(z) == Float.floatToIntBits(o.z);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(x);
        h = 31 * h + Float.floatToIntBits(y);
        h = 31 * h + Float.floatToIntBits(z);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(x)
            && Float.isFinite(y)
            && Float.isFinite(z);
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
    public boolean equalsEpsilon(Float3 other, float epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon;
    }

    static final Float3SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3SegOpsUnsafe()
                    : new Float3SegOpsMS();
    static final Float3BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3BbOpsUnsafe()
                    : new Float3BbOpsApi();
    static final Float3RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float3RawOpsUnsafe()
                    : new Float3RawOpsApi();


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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        return new Float3(_c0, _c1, _c2);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(float[] src) { return load(src, 0); }

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
    public FloatBuffer store(FloatBuffer buf) {
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
    public FloatBuffer storeAbsolute(int index, FloatBuffer buf) {
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
    public FloatBuffer storeRelative(FloatBuffer buf) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(FloatBuffer buf) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadAbsolute(int index, FloatBuffer buf) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        Float3 r = loadAbsolute(pos, buf);
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
        buf.position(pos + 12);
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(ByteBuffer buf) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadAbsolute(int index, ByteBuffer buf) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3 r = loadAbsolute(pos, buf);
        buf.position(pos + 12);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadUnsafe(long address) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(long offset, MemorySegment src) {
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        return new Float3(_c0, _c1, _c2);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
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
    public DoubleBuffer store(DoubleBuffer buf) {
        return storeAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
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
    public DoubleBuffer storeAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
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
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 3);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param buf the source buffer
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Float3 r = loadAbsolute(pos, buf);
        buf.position(pos + 3);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
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
    public ByteBuffer storeDouble(ByteBuffer buf) {
        return storeDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
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
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
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
    public ByteBuffer storeDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeDoubleAbsolute(pos, buf);
        buf.position(pos + 24);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
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
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float3 r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 24);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public Float3 storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param dest the destination memory segment
     * @return dest
     */
    public MemorySegment storeDouble(MemorySegment dest) { return storeDouble(0L, dest); }

    /**
     * Store the elements into the given memory segment, converting each element to {@code double},
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
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double}.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param src the source memory segment
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadDouble(MemorySegment src) { return loadDouble(0L, src); }

    /**
     * Load the elements from the given memory segment, converting each element from {@code double},
     * starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float3} holding the loaded elements
     */
    public static Float3 loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(offset, src);
    }

}
