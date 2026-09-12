package org.joml2;

import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable 4D vector of single-precision {@code float} components, declared as a value record.
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
 * @param w the {@code w} component
 */
@jdk.internal.vm.annotation.LooselyConsistentValue
public value record Float4(float x, float y, float z, float w) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** The zero vector (all components 0). */
    public static final Float4 ZERO = new Float4(0, 0, 0, 0);

    /** Canonical constructor. */
    public Float4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Create a new instance initialized to the homogeneous default {@code (0, 0, 0, 1)}.
     */
    public Float4() {
        this(0, 0, 0, 1);
    }

    /** Create a vector with all components set to {@code s}. */
    public Float4(float s) {
        this(s, s, s, s);
    }

    /** Create a vector composed of the given parts, in order. */
    public Float4(float v0, float v1, Float2 v2) {
        this(v0, v1, v2.x(), v2.y());
    }

    /** Create a vector composed of the given parts, in order. */
    public Float4(float v0, Float2 v1, float v2) {
        this(v0, v1.x(), v1.y(), v2);
    }

    /** Create a vector composed of the given parts, in order. */
    public Float4(float v0, Float3 v1) {
        this(v0, v1.x(), v1.y(), v1.z());
    }

    /** Create a vector composed of the given parts, in order. */
    public Float4(Float2 v0, float v1, float v2) {
        this(v0.x(), v0.y(), v1, v2);
    }

    /** Create a vector composed of the given parts, in order. */
    public Float4(Float2 v0, Float2 v1) {
        this(v0.x(), v0.y(), v1.x(), v1.y());
    }

    /** Create a vector composed of the given parts, in order. */
    public Float4(Float3 v0, float v1) {
        this(v0.x(), v0.y(), v0.z(), v1);
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
     * Add {@code other} to this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float4 add(Float4 other) {
        return add(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) to this vector,
     * returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting vector
     */
    public Float4 add(float otherX, float otherY, float otherZ, float otherW) {
        return new Float4(otherX + this.x, otherY + this.y, otherZ + this.z, otherW + this.w);
    }


    /**
     * Divide each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float4 div(float scalar) {
        return div(scalar, scalar, scalar, scalar);
    }


    /**
     * Divide this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float4 div(Float4 other) {
        return div(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting vector
     */
    public Float4 div(float otherX, float otherY, float otherZ, float otherW) {
        return new Float4(this.x / otherX, this.y / otherY, this.z / otherZ, this.w / otherW);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Float4 fma(float b, Float4 c) {
        return fma(b, c.x(), c.y(), c.z(), c.w());
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY}, {@code cZ},
     * {@code cW}), i.e. compute {@code this * b + (cX, cY, cZ, cW)} per component, returning the
     * result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cW the {@code w} component of the vector {@code (cX, cY, cZ, cW)}
     * @return the resulting vector
     */
    public Float4 fma(float b, float cX, float cY, float cZ, float cW) {
        return new Float4(Math.fma(this.x, b, cX), Math.fma(this.y, b, cY), Math.fma(this.z, b, cZ), Math.fma(this.w, b, cW));
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component, returning the result as a value.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @return the resulting vector
     */
    public Float4 fma(Float4 b, Float4 c) {
        return fma(b.x(), b.y(), b.z(), b.w(), c.x(), c.y(), c.z(), c.w());
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}, {@code bW}) and
     * add ({@code cX}, {@code cY}, {@code cZ}, {@code cW}), i.e. compute
     * {@code this * (bX, bY, bZ, bW) + (cX, cY, cZ, cW)} per component, returning the result as a
     * value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bW the {@code w} component of the vector {@code (bX, bY, bZ, bW)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cW the {@code w} component of the vector {@code (cX, cY, cZ, cW)}
     * @return the resulting vector
     */
    public Float4 fma(float bX, float bY, float bZ, float bW, float cX, float cY, float cZ, float cW) {
        return new Float4(Math.fma(this.x, bX, cX), Math.fma(this.y, bY, cY), Math.fma(this.z, bZ, cZ), Math.fma(this.w, bW, cW));
    }


    /**
     * Multiply each component of this vector by {@code scalar}, returning the result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float4 mul(float scalar) {
        return mul(scalar, scalar, scalar, scalar);
    }


    /**
     * Multiply this vector component-wise by {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float4 mul(Float4 other) {
        return mul(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting vector
     */
    public Float4 mul(float otherX, float otherY, float otherZ, float otherW) {
        return new Float4(otherX * this.x, otherY * this.y, otherZ * this.z, otherW * this.w);
    }


    /**
     * Negate this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 negate() {
        return new Float4(-this.x, -this.y, -this.z, -this.w);
    }


    /**
     * Subtract {@code other} from this vector, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float4 sub(Float4 other) {
        return sub(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) from this vector,
     * returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting vector
     */
    public Float4 sub(float otherX, float otherY, float otherZ, float otherW) {
        return new Float4(this.x - otherX, this.y - otherY, this.z - otherZ, this.w - otherW);
    }


    /**
     * Create a new vector from the given values.
     *
     * @param v the vector
     * @return the resulting vector
     */
    public Float4 set(Float4 v) {
        return set(v.x(), v.y(), v.z(), v.w());
    }


    /**
     * Create a new vector from the given values.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the vector {@code (vX, vY, vZ, vW)}
     * @return the resulting vector
     */
    public Float4 set(float vX, float vY, float vZ, float vW) {
        return new Float4(vX, vY, vZ, vW);
    }


    /**
     * Set this vector to {@code s}, returning the result as a value.
     *
     * @param s the value assigned to every component
     * @return the resulting vector
     */
    public Float4 set(float s) {
        return new Float4(s, s, s, s);
    }


    /**
     * Convert this vector to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code Double4} holding the result
     */
    public Double4 toDouble() {
        return new Double4(this.x, this.y, this.z, this.w);
    }


    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Byte4} holding the result
     */
    public Byte4 toByte() {
        return new Byte4((byte) (this.x), (byte) (this.y), (byte) (this.z), (byte) (this.w));
    }


    /**
     * Convert this vector to {@code byte} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Byte4} holding the result
     */
    public Byte4 toByte(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toByte();
            case FLOOR -> new Byte4((byte) Math.floor(this.x), (byte) Math.floor(this.y), (byte) Math.floor(this.z), (byte) Math.floor(this.w));
            case CEILING -> new Byte4((byte) Math.ceil(this.x), (byte) Math.ceil(this.y), (byte) Math.ceil(this.z), (byte) Math.ceil(this.w));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Byte4((byte) Math.round(this.x), (byte) Math.round(this.y), (byte) Math.round(this.z), (byte) Math.round(this.w));
            case HALF_AWAY_FROM_ZERO -> new Byte4((byte) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (byte) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (byte) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)), (byte) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5)));
            case HALF_EVEN -> new Byte4((byte) Math.rint(this.x), (byte) Math.rint(this.y), (byte) Math.rint(this.z), (byte) Math.rint(this.w));
        };
    }


    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Short4} holding the result
     */
    public Short4 toShort() {
        return new Short4((short) (this.x), (short) (this.y), (short) (this.z), (short) (this.w));
    }


    /**
     * Convert this vector to {@code short} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Short4} holding the result
     */
    public Short4 toShort(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toShort();
            case FLOOR -> new Short4((short) Math.floor(this.x), (short) Math.floor(this.y), (short) Math.floor(this.z), (short) Math.floor(this.w));
            case CEILING -> new Short4((short) Math.ceil(this.x), (short) Math.ceil(this.y), (short) Math.ceil(this.z), (short) Math.ceil(this.w));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Short4((short) Math.round(this.x), (short) Math.round(this.y), (short) Math.round(this.z), (short) Math.round(this.w));
            case HALF_AWAY_FROM_ZERO -> new Short4((short) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (short) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (short) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)), (short) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5)));
            case HALF_EVEN -> new Short4((short) Math.rint(this.x), (short) Math.rint(this.y), (short) Math.rint(this.z), (short) Math.rint(this.w));
        };
    }


    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Int4} holding the result
     */
    public Int4 toInt() {
        return new Int4((int) (this.x), (int) (this.y), (int) (this.z), (int) (this.w));
    }


    /**
     * Convert this vector to {@code int} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Int4} holding the result
     */
    public Int4 toInt(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toInt();
            case FLOOR -> new Int4((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z), (int) Math.floor(this.w));
            case CEILING -> new Int4((int) Math.ceil(this.x), (int) Math.ceil(this.y), (int) Math.ceil(this.z), (int) Math.ceil(this.w));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Int4(Math.round(this.x), Math.round(this.y), Math.round(this.z), Math.round(this.w));
            case HALF_AWAY_FROM_ZERO -> new Int4((int) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (int) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (int) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)), (int) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5)));
            case HALF_EVEN -> new Int4((int) Math.rint(this.x), (int) Math.rint(this.y), (int) Math.rint(this.z), (int) Math.rint(this.w));
        };
    }


    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @return a new {@code Long4} holding the result
     */
    public Long4 toLong() {
        return new Long4((long) (this.x), (long) (this.y), (long) (this.z), (long) (this.w));
    }


    /**
     * Convert this vector to {@code long} precision, returning the result as a new instance.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @return a new {@code Long4} holding the result
     */
    public Long4 toLong(RoundingMode roundingMode) {
        return switch (roundingMode) {
            case TRUNCATE -> toLong();
            case FLOOR -> new Long4((long) Math.floor(this.x), (long) Math.floor(this.y), (long) Math.floor(this.z), (long) Math.floor(this.w));
            case CEILING -> new Long4((long) Math.ceil(this.x), (long) Math.ceil(this.y), (long) Math.ceil(this.z), (long) Math.ceil(this.w));
            case HALF_TOWARD_POSITIVE_INFINITY -> new Long4(Math.round((double) (this.x)), Math.round((double) (this.y)), Math.round((double) (this.z)), Math.round((double) (this.w)));
            case HALF_AWAY_FROM_ZERO -> new Long4((long) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5)), (long) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5)), (long) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5)), (long) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5)));
            case HALF_EVEN -> new Long4((long) Math.rint(this.x), (long) Math.rint(this.y), (long) Math.rint(this.z), (long) Math.rint(this.w));
        };
    }


    /**
     * Create an all-zero vector.
     *
     * @return the resulting vector
     */
    public static Float4 makeZero() {
        return Float4.ZERO;
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
    public Float4 bezier(Float4 p1, Float4 p2, Float4 p3, float t) {
        return bezier(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t);
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1W the {@code w} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2W the {@code w} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3W the {@code w} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 bezier(float p1X, float p1Y, float p1Z, float p1W, float p2X, float p2Y, float p2Z, float p2W, float p3X, float p3Y, float p3Z, float p3W, float t) {
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        return new Float4(Math.fma(p1X, _t7, this.x * _t8) + Math.fma(p2X, _t6, p3X * _t2), Math.fma(p1Y, _t7, this.y * _t8) + Math.fma(p2Y, _t6, p3Y * _t2), Math.fma(p1Z, _t7, this.z * _t8) + Math.fma(p2Z, _t6, p3Z * _t2), Math.fma(p1W, _t7, this.w * _t8) + Math.fma(p2W, _t6, p3W * _t2));
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
    public Float4 bezier2(Float4 p1, Float4 p2, float t) {
        return bezier2(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), t);
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points, returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1W the {@code w} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2W the {@code w} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 bezier2(float p1X, float p1Y, float p1Z, float p1W, float p2X, float p2Y, float p2Z, float p2W, float t) {
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        return new Float4(Math.fma(p2X, _t0, Math.fma(p1X, _t3, this.x * _t4)), Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, this.y * _t4)), Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, this.z * _t4)), Math.fma(p2W, _t0, Math.fma(p1W, _t3, this.w * _t4)));
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
    public Float4 bezier2Tangent(Float4 p1, Float4 p2, float t) {
        return bezier2Tangent(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t}, returning the result
     * as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1W the {@code w} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2W the {@code w} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 bezier2Tangent(float p1X, float p1Y, float p1Z, float p1W, float p2X, float p2Y, float p2Z, float p2W, float t) {
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        return new Float4(Math.fma(p1X - this.x, _t2, (p2X - p1X) * _t1), Math.fma(p1Y - this.y, _t2, (p2Y - p1Y) * _t1), Math.fma(p1Z - this.z, _t2, (p2Z - p1Z) * _t1), Math.fma(p1W - this.w, _t2, (p2W - p1W) * _t1));
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
    public Float4 bezierTangent(Float4 p1, Float4 p2, Float4 p3, float t) {
        return bezierTangent(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1W the {@code w} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2W the {@code w} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3W the {@code w} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 bezierTangent(float p1X, float p1Y, float p1Z, float p1W, float p2X, float p2Y, float p2Z, float p2W, float p3X, float p3Y, float p3Z, float p3W, float t) {
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        return new Float4(Math.fma(p3X - p2X, _t2, Math.fma(p1X - this.x, _t6, (p2X - p1X) * _t5)), Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - this.y, _t6, (p2Y - p1Y) * _t5)), Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - this.z, _t6, (p2Z - p1Z) * _t5)), Math.fma(p3W - p2W, _t2, Math.fma(p1W - this.w, _t6, (p2W - p1W) * _t5)));
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
    public Float4 catmullRom(Float4 p1, Float4 p2, Float4 p3, float t) {
        return catmullRom(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t);
    }

    /** Private tail of {@code catmullRom}; reached only through it. */
    private Float4 catmullRom_s8bdfa76_tail(float p1Z, float t, float p2Z, float p3Z, float _t0, float _t1, float p1W, float p2W, float p3W, float _sfx0, float _sfx1) {
        float _sfx2 = 0.5f * (Math.fma(2.0f, p1Z, t * (p2Z - this.z)) + Math.fma(Math.fma(-5.0f, p1Z, Math.fma(2.0f, this.z, Math.fma(4.0f, p2Z, -p3Z))), _t0, Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - this.z)) * _t1));
        float _sfx3 = 0.5f * (Math.fma(2.0f, p1W, t * (p2W - this.w)) + Math.fma(Math.fma(-5.0f, p1W, Math.fma(2.0f, this.w, Math.fma(4.0f, p2W, -p3W))), _t0, Math.fma(-3.0f, p2W, Math.fma(3.0f, p1W, p3W - this.w)) * _t1));
        return new Float4(_sfx0, _sfx1, _sfx2, _sfx3);
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points,
     * returning the result as a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1W the {@code w} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2W the {@code w} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3W the {@code w} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 catmullRom(float p1X, float p1Y, float p1Z, float p1W, float p2X, float p2Y, float p2Z, float p2W, float p3X, float p3Y, float p3Z, float p3W, float t) {
        float _t0 = t * t;
        float _t1 = t * _t0;
        float _sfx0 = 0.5f * (Math.fma(2.0f, p1X, t * (p2X - this.x)) + Math.fma(Math.fma(-5.0f, p1X, Math.fma(2.0f, this.x, Math.fma(4.0f, p2X, -p3X))), _t0, Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - this.x)) * _t1));
        float _sfx1 = 0.5f * (Math.fma(2.0f, p1Y, t * (p2Y - this.y)) + Math.fma(Math.fma(-5.0f, p1Y, Math.fma(2.0f, this.y, Math.fma(4.0f, p2Y, -p3Y))), _t0, Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - this.y)) * _t1));
        return catmullRom_s8bdfa76_tail(p1Z, t, p2Z, p3Z, _t0, _t1, p1W, p2W, p3W, _sfx0, _sfx1);
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
    public Float4 catmullRomTangent(Float4 p1, Float4 p2, Float4 p3, float t) {
        return catmullRomTangent(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t}, returning the result as
     * a value.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p1W the {@code w} component of the vector {@code (p1X, p1Y, p1Z, p1W)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p2W the {@code w} component of the vector {@code (p2X, p2Y, p2Z, p2W)}
     * @param p3X the {@code x} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Y the {@code y} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3Z the {@code z} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param p3W the {@code w} component of the vector {@code (p3X, p3Y, p3Z, p3W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 catmullRomTangent(float p1X, float p1Y, float p1Z, float p1W, float p2X, float p2Y, float p2Z, float p2W, float p3X, float p3Y, float p3Z, float p3W, float t) {
        float _t0 = t * t;
        return new Float4(0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1X, Math.fma(2.0f, this.x, Math.fma(4.0f, p2X, -p3X))), Math.fma(3.0f * Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - this.x)), _t0, p2X - this.x)), 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Y, Math.fma(2.0f, this.y, Math.fma(4.0f, p2Y, -p3Y))), Math.fma(3.0f * Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - this.y)), _t0, p2Y - this.y)), 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Z, Math.fma(2.0f, this.z, Math.fma(4.0f, p2Z, -p3Z))), Math.fma(3.0f * Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - this.z)), _t0, p2Z - this.z)), 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1W, Math.fma(2.0f, this.w, Math.fma(4.0f, p2W, -p3W))), Math.fma(3.0f * Math.fma(-3.0f, p2W, Math.fma(3.0f, p1W, p3W - this.w)), _t0, p2W - this.w)));
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
    public Float4 hermite(Float4 t0, Float4 v1, Float4 t1, float t) {
        return hermite(t0.x(), t0.y(), t0.z(), t0.w(), v1.x(), v1.y(), v1.z(), v1.w(), t1.x(), t1.y(), t1.z(), t1.w(), t);
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation,
     * returning the result as a value.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param t0Z the {@code z} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param t0W the {@code w} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param v1Z the {@code z} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param v1W the {@code w} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t1Z the {@code z} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t1W the {@code w} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 hermite(float t0X, float t0Y, float t0Z, float t0W, float v1X, float v1Y, float v1Z, float v1W, float t1X, float t1Y, float t1Z, float t1W, float t) {
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        return new Float4(Math.fma(this.x, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9), Math.fma(this.y, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9), Math.fma(this.z, _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9), Math.fma(this.w, _t10, t0W * _t7) + Math.fma(t1W, _t5, v1W * _t9));
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
    public Float4 hermiteTangent(Float4 t0, Float4 v1, Float4 t1, float t) {
        return hermiteTangent(t0.x(), t0.y(), t0.z(), t0.w(), v1.x(), v1.y(), v1.z(), v1.w(), t1.x(), t1.y(), t1.z(), t1.w(), t);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t}, returning the result as a
     * value.
     *
     * @param t0X the {@code x} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param t0Y the {@code y} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param t0Z the {@code z} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param t0W the {@code w} component of the vector {@code (t0X, t0Y, t0Z, t0W)}
     * @param v1X the {@code x} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param v1Y the {@code y} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param v1Z the {@code z} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param v1W the {@code w} component of the vector {@code (v1X, v1Y, v1Z, v1W)}
     * @param t1X the {@code x} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t1Y the {@code y} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t1Z the {@code z} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t1W the {@code w} component of the vector {@code (t1X, t1Y, t1Z, t1W)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 hermiteTangent(float t0X, float t0Y, float t0Z, float t0W, float v1X, float v1Y, float v1Z, float v1W, float t1X, float t1Y, float t1Z, float t1W, float t) {
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        return new Float4(Math.fma(this.x, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7), Math.fma(this.y, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7), Math.fma(this.z, _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7), Math.fma(this.w, _t6, t0W * _t9) + Math.fma(t1W, _t8, v1W * _t7));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 lerp(Float4 other, float t) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) using the interpolation factor {@code t}, returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 lerp(float otherX, float otherY, float otherZ, float otherW, float t) {
        return new Float4(Math.fma(t, otherX - this.x, this.x), Math.fma(t, otherY - this.y, this.y), Math.fma(t, otherZ - this.z, this.z), Math.fma(t, otherW - this.w, this.w));
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}, returning the result as a value.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @return the resulting vector
     */
    public Float4 lerp(Float4 other, Float4 t) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t.x(), t.y(), t.z(), t.w());
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) using the interpolation factor ({@code tX}, {@code tY}, {@code tZ},
     * {@code tW}), returning the result as a value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ, tW)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ, tW)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ, tW)}
     * @param tW the {@code w} component of the vector {@code (tX, tY, tZ, tW)}
     * @return the resulting vector
     */
    public Float4 lerp(float otherX, float otherY, float otherZ, float otherW, float tX, float tY, float tZ, float tW) {
        return new Float4(Math.fma(tX, otherX - this.x, this.x), Math.fma(tY, otherY - this.y, this.y), Math.fma(tZ, otherZ - this.z, this.z), Math.fma(tW, otherW - this.w, this.w));
    }


    /**
     * Compute the absolute value of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 absolute() {
        return new Float4(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z), Math.abs(this.w));
    }


    /**
     * Compute the arc cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 acos() {
        return new Float4((float) Math.acos(this.x), (float) Math.acos(this.y), (float) Math.acos(this.z), (float) Math.acos(this.w));
    }


    /**
     * Add {@code b} scaled by {@code scalar} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float4 addScaled(Float4 b, float scalar) {
        return addScaled(b.x(), b.y(), b.z(), b.w(), scalar);
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}, {@code bW}) scaled by {@code scalar} to this vector,
     * returning the result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bW the {@code w} component of the vector {@code (bX, bY, bZ, bW)}
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float4 addScaled(float bX, float bY, float bZ, float bW, float scalar) {
        return new Float4(Math.fma(scalar, bX, this.x), Math.fma(scalar, bY, this.y), Math.fma(scalar, bZ, this.z), Math.fma(scalar, bW, this.w));
    }


    /**
     * Add {@code b} scaled by {@code c} to this vector, returning the result as a value.
     *
     * @param b the vector
     * @param c the vector
     * @return the resulting vector
     */
    public Float4 addScaled(Float4 b, Float4 c) {
        return addScaled(b.x(), b.y(), b.z(), b.w(), c.x(), c.y(), c.z(), c.w());
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}, {@code bW}) scaled by ({@code cX}, {@code cY},
     * {@code cZ}, {@code cW}) to this vector, returning the result as a value.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bW the {@code w} component of the vector {@code (bX, bY, bZ, bW)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cW the {@code w} component of the vector {@code (cX, cY, cZ, cW)}
     * @return the resulting vector
     */
    public Float4 addScaled(float bX, float bY, float bZ, float bW, float cX, float cY, float cZ, float cW) {
        return new Float4(Math.fma(bX, cX, this.x), Math.fma(bY, cY, this.y), Math.fma(bZ, cZ, this.z), Math.fma(bW, cW, this.w));
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
    public float angleBetween(Float4 other) {
        return angleBetween(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code float} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public float angleBetween(float otherX, float otherY, float otherZ, float otherW) {
        float _t12 = Math.fma(otherW, this.z, -(otherZ * this.w));
        float _t13 = Math.fma(otherW, this.y, -(otherY * this.w));
        float _t14 = Math.fma(otherZ, this.y, -(otherY * this.z));
        float _t15 = Math.fma(otherW, this.x, -(otherX * this.w));
        float _t16 = Math.fma(otherY, this.x, -(otherX * this.y));
        float _t17 = Math.fma(otherZ, this.x, -(otherX * this.z));
        return (float) Math.atan2((float) Math.sqrt(Math.fma(_t12, _t12, Math.fma(_t13, _t13, Math.fma(_t14, _t14, Math.fma(_t15, _t15, Math.fma(_t16, _t16, _t17 * _t17)))))), Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y))));
    }


    /**
     * Compute the arc sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 asin() {
        return new Float4((float) Math.asin(this.x), (float) Math.asin(this.y), (float) Math.asin(this.z), (float) Math.asin(this.w));
    }


    /**
     * Compute the arc tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 atan() {
        return new Float4((float) Math.atan(this.x), (float) Math.atan(this.y), (float) Math.atan(this.z), (float) Math.atan(this.w));
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator), returning the result
     * as a value.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @return the resulting vector
     */
    public Float4 atan2(float x) {
        return atan2(x, x, x, x);
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator), returning the result as a value.
     *
     * @param x the vector of denominators, one per component
     * @return the resulting vector
     */
    public Float4 atan2(Float4 x) {
        return atan2(x.x(), x.y(), x.z(), x.w());
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code xX},
     * {@code xY}, {@code xZ}, {@code xW}) (the denominator), returning the result as a value.
     *
     * @param xX the {@code x} component of the vector {@code (xX, xY, xZ, xW)}
     * @param xY the {@code y} component of the vector {@code (xX, xY, xZ, xW)}
     * @param xZ the {@code z} component of the vector {@code (xX, xY, xZ, xW)}
     * @param xW the {@code w} component of the vector {@code (xX, xY, xZ, xW)}
     * @return the resulting vector
     */
    public Float4 atan2(float xX, float xY, float xZ, float xW) {
        return new Float4((float) Math.atan2(this.x, xX), (float) Math.atan2(this.y, xY), (float) Math.atan2(this.z, xZ), (float) Math.atan2(this.w, xW));
    }


    /**
     * Compute the cube root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 cbrt() {
        return new Float4((float) Math.cbrt(this.x), (float) Math.cbrt(this.y), (float) Math.cbrt(this.z), (float) Math.cbrt(this.w));
    }


    /**
     * Compute the ceiling of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 ceil() {
        return new Float4((float) Math.ceil(this.x), (float) Math.ceil(this.y), (float) Math.ceil(this.z), (float) Math.ceil(this.w));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @return the resulting vector
     */
    public Float4 clamp(float min, float max) {
        return new Float4(Math.min(Math.max(this.x, min), max), Math.min(Math.max(this.y, min), max), Math.min(Math.max(this.z, min), max), Math.min(Math.max(this.w, min), max));
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max}, returning the result
     * as a value.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @return the resulting vector
     */
    public Float4 clamp(Float4 min, Float4 max) {
        return clamp(min.x(), min.y(), min.z(), min.w(), max.x(), max.y(), max.z(), max.w());
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ},
     * {@code minW}) and ({@code maxX}, {@code maxY}, {@code maxZ}, {@code maxW}), returning the
     * result as a value.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ, minW)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ, minW)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ, minW)}
     * @param minW the {@code w} component of the vector {@code (minX, minY, minZ, minW)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param maxW the {@code w} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @return the resulting vector
     */
    public Float4 clamp(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
        return new Float4(Math.min(Math.max(this.x, minX), maxX), Math.min(Math.max(this.y, minY), maxY), Math.min(Math.max(this.z, minZ), maxZ), Math.min(Math.max(this.w, minW), maxW));
    }


    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    public float compAdd() {
        return this.w + (this.z + (this.x + this.y));
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public float compMax() {
        return Math.max(Math.max(Math.max(this.x, this.y), this.z), this.w);
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public float compMin() {
        return Math.min(Math.min(Math.min(this.x, this.y), this.z), this.w);
    }


    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    public float compMul() {
        return this.w * this.z * this.x * this.y;
    }


    /**
     * Copy the sign of {@code sign} onto each component of this vector, returning the result as a
     * value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Float4 copySign(float sign) {
        return copySign(sign, sign, sign, sign);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector, returning the result as a value.
     *
     * @param sign the value whose sign is copied
     * @return the resulting vector
     */
    public Float4 copySign(Float4 sign) {
        return copySign(sign.x(), sign.y(), sign.z(), sign.w());
    }


    /**
     * Copy the sign of each component of ({@code signX}, {@code signY}, {@code signZ},
     * {@code signW}) onto the corresponding component of this vector, returning the result as a
     * value.
     *
     * @param signX the {@code x} component of the vector {@code (signX, signY, signZ, signW)}
     * @param signY the {@code y} component of the vector {@code (signX, signY, signZ, signW)}
     * @param signZ the {@code z} component of the vector {@code (signX, signY, signZ, signW)}
     * @param signW the {@code w} component of the vector {@code (signX, signY, signZ, signW)}
     * @return the resulting vector
     */
    public Float4 copySign(float signX, float signY, float signZ, float signW) {
        return new Float4(Math.copySign(this.x, signX), Math.copySign(this.y, signY), Math.copySign(this.z, signZ), Math.copySign(this.w, signW));
    }


    /**
     * Compute the cosine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 cos() {
        return new Float4((float) Math.cos(this.x), (float) Math.cos(this.y), (float) Math.cos(this.z), (float) Math.cos(this.w));
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 cosh() {
        return new Float4((float) Math.cosh(this.x), (float) Math.cosh(this.y), (float) Math.cosh(this.z), (float) Math.cosh(this.w));
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 degrees() {
        return new Float4((float) Math.toDegrees(this.x), (float) Math.toDegrees(this.y), (float) Math.toDegrees(this.z), (float) Math.toDegrees(this.w));
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
    public float distance(Float4 other) {
        return distance(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}).
     * <p>
     * The squared length is formed at {@code float} precision, so the result is exact only while it
     * stays within the {@code float} range: the magnitude of the difference vector must lie roughly
     * between {@code 1e-19} and {@code 1.8e19}. Rescale inputs outside that band first.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     *        {@code otherW})
     */
    public float distance(float otherX, float otherY, float otherZ, float otherW) {
        float _t0 = this.w - otherW;
        float _t1 = this.z - otherZ;
        float _t2 = this.x - otherX;
        float _t3 = this.y - otherY;
        return (float) Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3))));
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public float distanceSquared(Float4 other) {
        return distanceSquared(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the squared distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the squared distance between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public float distanceSquared(float otherX, float otherY, float otherZ, float otherW) {
        float _t0 = this.w - otherW;
        float _t1 = this.z - otherZ;
        float _t2 = this.x - otherX;
        float _t3 = this.y - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3)));
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public float dot(Float4 other) {
        return dot(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the dot product of this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the dot product of this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     *        {@code otherW})
     */
    public float dot(float otherX, float otherY, float otherZ, float otherW) {
        return Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
    }


    /**
     * Compute the base-e exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 exp() {
        return new Float4((float) Math.exp(this.x), (float) Math.exp(this.y), (float) Math.exp(this.z), (float) Math.exp(this.w));
    }


    /**
     * Compute the base-2 exponential of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 exp2() {
        return new Float4((float) Math.pow(2.0f, this.x), (float) Math.pow(2.0f, this.y), (float) Math.pow(2.0f, this.z), (float) Math.pow(2.0f, this.w));
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Float4 expm1() {
        return new Float4((float) Math.expm1(this.x), (float) Math.expm1(this.y), (float) Math.expm1(this.z), (float) Math.expm1(this.w));
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
    public Float4 faceforward(Float4 I, Float4 Nref) {
        return faceforward(I.x(), I.y(), I.z(), I.w(), Nref.x(), Nref.y(), Nref.z(), Nref.w());
    }


    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ, NrefW), (IX, IY, IZ, IW))}
     * is negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}, {@code IW}) as judged by the reference vector ({@code NrefX},
     * {@code NrefY}, {@code NrefZ}, {@code NrefW}), returning the result as a value.
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY, IZ, IW)}
     * @param IY the {@code y} component of the vector {@code (IX, IY, IZ, IW)}
     * @param IZ the {@code z} component of the vector {@code (IX, IY, IZ, IW)}
     * @param IW the {@code w} component of the vector {@code (IX, IY, IZ, IW)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param NrefZ the {@code z} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param NrefW the {@code w} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @return the resulting vector
     */
    public Float4 faceforward(float IX, float IY, float IZ, float IW, float NrefX, float NrefY, float NrefZ, float NrefW) {
        float _t3 = Math.fma(IW, NrefW, Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY)));
        if (_t3 < 0.0f) {
            return new Float4(this.x, this.y, this.z, this.w);
        } else {
            return new Float4(-this.x, -this.y, -this.z, -this.w);
        }
    }


    /**
     * Compute the floor of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 floor() {
        return new Float4((float) Math.floor(this.x), (float) Math.floor(this.y), (float) Math.floor(this.z), (float) Math.floor(this.w));
    }


    /**
     * Compute the fractional part of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 fract() {
        return new Float4(this.x - (float) Math.floor(this.x), this.y - (float) Math.floor(this.y), this.z - (float) Math.floor(this.z), this.w - (float) Math.floor(this.w));
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y}, returning the result as a value.
     *
     * @param y the other operand
     * @return the resulting vector
     */
    public Float4 hypot(float y) {
        return hypot(y, y, y, y);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y}, returning the result
     * as a value.
     *
     * @param y the vector of other operands, one per component
     * @return the resulting vector
     */
    public Float4 hypot(Float4 y) {
        return hypot(y.x(), y.y(), y.z(), y.w());
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code yX}, {@code yY},
     * {@code yZ}, {@code yW}), returning the result as a value.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yW the {@code w} component of the vector {@code (yX, yY, yZ, yW)}
     * @return the resulting vector
     */
    public Float4 hypot(float yX, float yY, float yZ, float yW) {
        return new Float4((float) Math.hypot(this.x, yX), (float) Math.hypot(this.y, yY), (float) Math.hypot(this.z, yZ), (float) Math.hypot(this.w, yW));
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector, returning the result
     * as a value.
     *
     * @return the resulting vector
     */
    public Float4 inverse() {
        return new Float4(1.0f / this.x, 1.0f / this.y, 1.0f / this.z, 1.0f / this.w);
    }


    /**
     * Compute the inverse square root of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 inverseSqrt() {
        return new Float4((1.0f / (float) Math.sqrt(this.x)), (1.0f / (float) Math.sqrt(this.y)), (1.0f / (float) Math.sqrt(this.z)), (1.0f / (float) Math.sqrt(this.w)));
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
        return (float) Math.sqrt(Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y))));
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public float lengthSquared() {
        return Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
    }


    /**
     * Compute the natural logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 log() {
        return new Float4((float) Math.log(this.x), (float) Math.log(this.y), (float) Math.log(this.z), (float) Math.log(this.w));
    }


    /**
     * Compute the base-10 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 log10() {
        return new Float4((float) Math.log10(this.x), (float) Math.log10(this.y), (float) Math.log10(this.z), (float) Math.log10(this.w));
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 log1p() {
        return new Float4((float) Math.log1p(this.x), (float) Math.log1p(this.y), (float) Math.log1p(this.z), (float) Math.log1p(this.w));
    }


    /**
     * Compute the base-2 logarithm of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 log2() {
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        return new Float4((float) Math.log(this.x) * _t0_inv, (float) Math.log(this.y) * _t0_inv, (float) Math.log(this.z) * _t0_inv, (float) Math.log(this.w) * _t0_inv);
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public float manhattanDistance(Float4 other) {
        return manhattanDistance(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the Manhattan distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the Manhattan distance between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public float manhattanDistance(float otherX, float otherY, float otherZ, float otherW) {
        return Math.abs(this.x - otherX) + Math.abs(this.y - otherY) + Math.abs(this.z - otherZ) + Math.abs(this.w - otherW);
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public float manhattanLength() {
        return Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z) + Math.abs(this.w);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float4 max(float scalar) {
        return max(scalar, scalar, scalar, scalar);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float4 max(Float4 other) {
        return max(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}), returning the result as a
     * value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting vector
     */
    public Float4 max(float otherX, float otherY, float otherZ, float otherW) {
        return new Float4(Math.max(this.x, otherX), Math.max(this.y, otherY), Math.max(this.z, otherZ), Math.max(this.w, otherW));
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar}, returning the
     * result as a value.
     *
     * @param scalar the scalar value
     * @return the resulting vector
     */
    public Float4 min(float scalar) {
        return min(scalar, scalar, scalar, scalar);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other}, returning the result as a value.
     *
     * @param other the other vector
     * @return the resulting vector
     */
    public Float4 min(Float4 other) {
        return min(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}), returning the result as a
     * value.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the resulting vector
     */
    public Float4 min(float otherX, float otherY, float otherZ, float otherW) {
        return new Float4(Math.min(this.x, otherX), Math.min(this.y, otherY), Math.min(this.z, otherZ), Math.min(this.w, otherW));
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
    public Float4 mod(float y) {
        return mod(y, y, y, y);
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
    public Float4 mod(Float4 y) {
        return mod(y.x(), y.y(), y.z(), y.w());
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code yX}, {@code yY}, {@code yZ}, {@code yW}), returning the result
     * as a value.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yW the {@code w} component of the vector {@code (yX, yY, yZ, yW)}
     * @return the resulting vector
     */
    public Float4 mod(float yX, float yY, float yZ, float yW) {
        return new Float4(Math.fma(-yX, (float) Math.floor(this.x / yX), this.x), Math.fma(-yY, (float) Math.floor(this.y / yY), this.y), Math.fma(-yZ, (float) Math.floor(this.z / yZ), this.z), Math.fma(-yW, (float) Math.floor(this.w / yW), this.w));
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 nextDown() {
        return new Float4(Math.nextDown(this.x), Math.nextDown(this.y), Math.nextDown(this.z), Math.nextDown(this.w));
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 nextUp() {
        return new Float4(Math.nextUp(this.x), Math.nextUp(this.y), Math.nextUp(this.z), Math.nextUp(this.w));
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
    public Float4 normalize() {
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            return new Float4(this.x * _t4, this.y * _t4, this.z * _t4, this.w * _t4);
        } else {
            return Float4.ZERO;
        }
    }


    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector), returning the result as a value.
     *
     * @param length the length to rescale to
     * @return the resulting vector
     */
    public Float4 normalizeMul(float length) {
        float _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        float _t5 = length * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            return new Float4(this.x * _t5, this.y * _t5, this.z * _t5, this.w * _t5);
        } else {
            return Float4.ZERO;
        }
    }


    /**
     * Compute the outer product of this vector and {@code row}, returning the result as a value.
     *
     * @param row the row vector (right operand)
     * @return the resulting matrix
     */
    public Float4x4 outerProduct(Float4 row) {
        return outerProduct(row.x(), row.y(), row.z(), row.w());
    }


    /**
     * Compute the outer product of this vector and ({@code rowX}, {@code rowY}, {@code rowZ},
     * {@code rowW}), returning the result as a value.
     *
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param rowW the {@code w} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @return the resulting matrix
     */
    public Float4x4 outerProduct(float rowX, float rowY, float rowZ, float rowW) {
        return new Float4x4(rowX * this.x, rowY * this.x, rowZ * this.x, rowW * this.x, rowX * this.y, rowY * this.y, rowZ * this.y, rowW * this.y, rowX * this.z, rowY * this.z, rowZ * this.z, rowW * this.z, rowX * this.w, rowY * this.w, rowZ * this.w, rowW * this.w, 0);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Float4 pow(float exponent) {
        return pow(exponent, exponent, exponent, exponent);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent}, returning the result as
     * a value.
     *
     * @param exponent the exponent
     * @return the resulting vector
     */
    public Float4 pow(Float4 exponent) {
        return pow(exponent.x(), exponent.y(), exponent.z(), exponent.w());
    }


    /**
     * Raise each component of this vector to the power of ({@code exponentX}, {@code exponentY},
     * {@code exponentZ}, {@code exponentW}), returning the result as a value.
     *
     * @param exponentX the {@code x} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param exponentY the {@code y} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param exponentZ the {@code z} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param exponentW the {@code w} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @return the resulting vector
     */
    public Float4 pow(float exponentX, float exponentY, float exponentZ, float exponentW) {
        return new Float4((float) Math.pow(this.x, exponentX), (float) Math.pow(this.y, exponentY), (float) Math.pow(this.z, exponentZ), (float) Math.pow(this.w, exponentW));
    }


    /**
     * Project this vector onto {@code onto}, returning the result as a value.
     *
     * @param onto the vector to project onto
     * @return the resulting vector
     */
    public Float4 project(Float4 onto) {
        return project(onto.x(), onto.y(), onto.z(), onto.w());
    }


    /**
     * Project this vector onto ({@code ontoX}, {@code ontoY}, {@code ontoZ}, {@code ontoW}),
     * returning the result as a value.
     *
     * @param ontoX the {@code x} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param ontoY the {@code y} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param ontoZ the {@code z} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param ontoW the {@code w} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @return the resulting vector
     */
    public Float4 project(float ontoX, float ontoY, float ontoZ, float ontoW) {
        float _t6 = Math.fma(ontoW, this.w, Math.fma(ontoZ, this.z, Math.fma(ontoX, this.x, ontoY * this.y)));
        float _t7 = Math.fma(ontoW, ontoW, Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY)));
        float _t7_inv = 1.0f / _t7;
        return new Float4(ontoX * _t6 * _t7_inv, ontoY * _t6 * _t7_inv, ontoZ * _t6 * _t7_inv, ontoW * _t6 * _t7_inv);
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Float4 projectOnPlane(Float4 normal) {
        return projectOnPlane(normal.x(), normal.y(), normal.z(), normal.w());
    }


    /**
     * Project this vector onto the plane with the given normal, returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalY the {@code y} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalZ the {@code z} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalW the {@code w} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @return the resulting vector
     */
    public Float4 projectOnPlane(float normalX, float normalY, float normalZ, float normalW) {
        float _t3 = Math.fma(normalW, this.w, Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y)));
        return new Float4(Math.fma(-normalX, _t3, this.x), Math.fma(-normalY, _t3, this.y), Math.fma(-normalZ, _t3, this.z), Math.fma(-normalW, _t3, this.w));
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector,
     * returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 radians() {
        return new Float4((float) Math.toRadians(this.x), (float) Math.toRadians(this.y), (float) Math.toRadians(this.z), (float) Math.toRadians(this.w));
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normal the normal (must be a unit vector)
     * @return the resulting vector
     */
    public Float4 reflect(Float4 normal) {
        return reflect(normal.x(), normal.y(), normal.z(), normal.w());
    }


    /**
     * Reflect this vector about the given normal, returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalY the {@code y} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalZ the {@code z} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalW the {@code w} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @return the resulting vector
     */
    public Float4 reflect(float normalX, float normalY, float normalZ, float normalW) {
        float _t4 = 2.0f * Math.fma(normalW, this.w, Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y)));
        return new Float4(Math.fma(-normalX, _t4, this.x), Math.fma(-normalY, _t4, this.y), Math.fma(-normalZ, _t4, this.z), Math.fma(-normalW, _t4, this.w));
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
    public Float4 refract(Float4 normal, float eta) {
        return refract(normal.x(), normal.y(), normal.z(), normal.w(), eta);
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), returning the result as a value.
     *
     * @param normalX the {@code x} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalY the {@code y} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalZ the {@code z} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalW the {@code w} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @return the resulting vector
     */
    public Float4 refract(float normalX, float normalY, float normalZ, float normalW, float eta) {
        float _t4 = Math.fma(normalW, this.w, Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y)));
        float _t8 = Math.fma(-Math.fma(-_t4, _t4, 1.0f), eta * eta, 1.0f);
        float _t11 = Math.fma(eta, _t4, (float) Math.sqrt(Math.max(0.0f, _t8)));
        if (_t8 >= 0.0f) {
            return new Float4(Math.fma(eta, this.x, -(normalX * _t11)), Math.fma(eta, this.y, -(normalY * _t11)), Math.fma(eta, this.z, -(normalZ * _t11)), Math.fma(eta, this.w, -(normalW * _t11)));
        } else {
            return Float4.ZERO;
        }
    }


    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 round() {
        return new Float4((float) Math.rint(this.x), (float) Math.rint(this.y), (float) Math.rint(this.z), (float) Math.rint(this.w));
    }


    /**
     * Compute the sign of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 sign() {
        return new Float4(Math.signum(this.x), Math.signum(this.y), Math.signum(this.z), Math.signum(this.w));
    }


    /**
     * Compute the sine of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 sin() {
        return new Float4((float) Math.sin(this.x), (float) Math.sin(this.y), (float) Math.sin(this.z), (float) Math.sin(this.w));
    }


    /**
     * Compute the hyperbolic sine of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 sinh() {
        return new Float4((float) Math.sinh(this.x), (float) Math.sinh(this.y), (float) Math.sinh(this.z), (float) Math.sinh(this.w));
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
    public Float4 smoothstep(float edge0, float edge1) {
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t13 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0) * _t0_inv));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0) * _t0_inv));
        float _t15 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0) * _t0_inv));
        float _t16 = Math.max(0.0f, Math.min(1.0f, (this.w - edge0) * _t0_inv));
        return new Float4(Math.fma(-2.0f, _t13, 3.0f) * _t13 * _t13, Math.fma(-2.0f, _t14, 3.0f) * _t14 * _t14, Math.fma(-2.0f, _t15, 3.0f) * _t15 * _t15, Math.fma(-2.0f, _t16, 3.0f) * _t16 * _t16);
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
    public Float4 smoothstep(Float4 edge0, Float4 edge1) {
        return smoothstep(edge0.x(), edge0.y(), edge0.z(), edge0.w(), edge1.x(), edge1.y(), edge1.z(), edge1.w());
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}, {@code edge0W}) and the upper
     * edge ({@code edge1X}, {@code edge1Y}, {@code edge1Z}, {@code edge1W}), yielding 0 at or below
     * the lower edge and 1 at or above the upper edge, returning the result as a value.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge0Z the {@code z} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge0W the {@code w} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param edge1Z the {@code z} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param edge1W the {@code w} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @return the resulting vector
     */
    public Float4 smoothstep(float edge0X, float edge0Y, float edge0Z, float edge0W, float edge1X, float edge1Y, float edge1Z, float edge1W) {
        float _t16 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0X) / (edge1X - edge0X)));
        float _t17 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0Y) / (edge1Y - edge0Y)));
        float _t18 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0Z) / (edge1Z - edge0Z)));
        float _t19 = Math.max(0.0f, Math.min(1.0f, (this.w - edge0W) / (edge1W - edge0W)));
        return new Float4(Math.fma(-2.0f, _t16, 3.0f) * _t16 * _t16, Math.fma(-2.0f, _t17, 3.0f) * _t17 * _t17, Math.fma(-2.0f, _t18, 3.0f) * _t18 * _t18, Math.fma(-2.0f, _t19, 3.0f) * _t19 * _t19);
    }


    /**
     * Compute the square root of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 sqrt() {
        return new Float4((float) Math.sqrt(this.x), (float) Math.sqrt(this.y), (float) Math.sqrt(this.z), (float) Math.sqrt(this.w));
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Float4 step(float edge) {
        return step(edge, edge, edge, edge);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edge the edge to compare each component against
     * @return the resulting vector
     */
    public Float4 step(Float4 edge) {
        return step(edge.x(), edge.y(), edge.z(), edge.w());
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise, returning the result as a value.
     *
     * @param edgeX the {@code x} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param edgeY the {@code y} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param edgeZ the {@code z} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param edgeW the {@code w} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @return the resulting vector
     */
    public Float4 step(float edgeX, float edgeY, float edgeZ, float edgeW) {
        return new Float4(this.x < edgeX ? 0.0f : 1.0f, this.y < edgeY ? 0.0f : 1.0f, this.z < edgeZ ? 0.0f : 1.0f, this.w < edgeW ? 0.0f : 1.0f);
    }


    /**
     * Compute the tangent of each component of this vector, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float4 tan() {
        return new Float4((float) Math.tan(this.x), (float) Math.tan(this.y), (float) Math.tan(this.z), (float) Math.tan(this.w));
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 tanh() {
        return new Float4((float) Math.tanh(this.x), (float) Math.tanh(this.y), (float) Math.tanh(this.z), (float) Math.tanh(this.w));
    }


    /**
     * Compute the truncated value of each component of this vector, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float4 trunc() {
        return new Float4(this.x >= 0.0f ? (float) Math.floor(this.x) : (float) Math.ceil(this.x), this.y >= 0.0f ? (float) Math.floor(this.y) : (float) Math.ceil(this.y), this.z >= 0.0f ? (float) Math.floor(this.z) : (float) Math.ceil(this.z), this.w >= 0.0f ? (float) Math.floor(this.w) : (float) Math.ceil(this.w));
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector, returning the
     * result as a value.
     *
     * @return the resulting vector
     */
    public Float4 ulp() {
        return new Float4(Math.ulp(this.x), Math.ulp(this.y), Math.ulp(this.z), Math.ulp(this.w));
    }


    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this}, returning the
     * result as a value.
     *
     * @param mat the matrix
     * @return the resulting vector
     */
    public Float4 preMul(Float4x4 mat) {
        return new Float4(Math.fma(mat.m03(), this.w, Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y))), Math.fma(mat.m13(), this.w, Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y))), Math.fma(mat.m23(), this.w, Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y))), Math.fma(mat.m33(), this.w, Math.fma(mat.m32(), this.z, Math.fma(mat.m30(), this.x, mat.m31() * this.y))));
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the quaternion {@code quat}, i.e.
     * compute {@code q * this.xyz * q^-1}, leaving {@code w} unchanged, returning the result as a
     * value.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return the resulting vector
     */
    public Float4 rotate(FloatQuat quat) {
        return rotate(quat.x(), quat.y(), quat.z(), quat.w());
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the quaternion ({@code quatX},
     * {@code quatY}, {@code quatZ}, {@code quatW}), i.e. compute {@code q * this.xyz * q^-1},
     * leaving {@code w} unchanged, returning the result as a value.
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
    public Float4 rotate(float quatX, float quatY, float quatZ, float quatW) {
        float _t9 = 2.0f * Math.fma(quatX, this.y, -(quatY * this.x));
        float _t10 = 2.0f * Math.fma(quatZ, this.x, -(quatX * this.z));
        float _t11 = 2.0f * Math.fma(quatY, this.z, -(quatZ * this.y));
        return new Float4(Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, this.x))), Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.y))), Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, this.z))), this.w);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the
     * axis {@code axis}, leaving {@code w} unchanged, returning the result as a value.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @return the resulting vector
     */
    public Float4 rotateAxis(float angle, Float3 axis) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z());
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the
     * axis ({@code axisX}, {@code axisY}, {@code axisZ}), leaving {@code w} unchanged, returning
     * the result as a value.
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
    public Float4 rotateAxis(float angle, float axisX, float axisY, float axisZ) {
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t5 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        return new Float4(Math.fma(_t2, axisX * _t5, Math.fma(this.x, _t0, Math.fma(axisY, this.z, -(axisZ * this.y)) * _t1)), Math.fma(_t2, axisY * _t5, Math.fma(this.y, _t0, Math.fma(axisZ, this.x, -(axisX * this.z)) * _t1)), Math.fma(_t2, axisZ * _t5, Math.fma(this.z, _t0, Math.fma(axisX, this.y, -(axisY * this.x)) * _t1)), this.w);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the inverse of the given rotation,
     * leaving {@code w} unchanged, returning the result as a value.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @return the resulting vector
     */
    public Float4 rotateInverse(FloatQuat quat) {
        return rotateInverse(quat.x(), quat.y(), quat.z(), quat.w());
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the inverse of the given rotation,
     * leaving {@code w} unchanged, returning the result as a value.
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
    public Float4 rotateInverse(float quatX, float quatY, float quatZ, float quatW) {
        float _t9 = 2.0f * Math.fma(quatX, this.z, -(quatZ * this.x));
        float _t10 = 2.0f * Math.fma(quatY, this.x, -(quatX * this.y));
        float _t11 = 2.0f * Math.fma(quatZ, this.y, -(quatY * this.z));
        return new Float4(Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, this.x))), Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, this.y))), Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.z))), this.w);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the X
     * axis, leaving {@code w} unchanged, returning the result as a value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Float4 rotateX(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float4(this.x, Math.fma(this.y, _t0, -(this.z * _t1)), Math.fma(this.y, _t1, this.z * _t0), this.w);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the Y
     * axis, leaving {@code w} unchanged, returning the result as a value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Float4 rotateY(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float4(Math.fma(this.x, _t0, this.z * _t1), this.y, Math.fma(this.z, _t0, -(this.x * _t1)), this.w);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the Z
     * axis, leaving {@code w} unchanged, returning the result as a value.
     *
     * @param angle the angle in radians
     * @return the resulting vector
     */
    public Float4 rotateZ(float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        return new Float4(Math.fma(this.x, _t0, -(this.y * _t1)), Math.fma(this.x, _t1, this.y * _t0), this.z, this.w);
    }

    /** {@return a copy of this vector with the X component replaced by the given value} */
    public Float4 withX(float x) {
        return new Float4(x, this.y(), this.z(), this.w());
    }

    /** {@return a copy of this vector with the Y component replaced by the given value} */
    public Float4 withY(float y) {
        return new Float4(this.x(), y, this.z(), this.w());
    }

    /** {@return a copy of this vector with the XY components replaced by the given values} */
    public Float4 withXY(float x, float y) {
        return new Float4(x, y, this.z(), this.w());
    }

    /** {@return a copy of this vector with the Z component replaced by the given value} */
    public Float4 withZ(float z) {
        return new Float4(this.x(), this.y(), z, this.w());
    }

    /** {@return a copy of this vector with the XZ components replaced by the given values} */
    public Float4 withXZ(float x, float z) {
        return new Float4(x, this.y(), z, this.w());
    }

    /** {@return a copy of this vector with the YZ components replaced by the given values} */
    public Float4 withYZ(float y, float z) {
        return new Float4(this.x(), y, z, this.w());
    }

    /** {@return a copy of this vector with the XYZ components replaced by the given values} */
    public Float4 withXYZ(float x, float y, float z) {
        return new Float4(x, y, z, this.w());
    }

    /** {@return a copy of this vector with the W component replaced by the given value} */
    public Float4 withW(float w) {
        return new Float4(this.x(), this.y(), this.z(), w);
    }

    /** {@return a copy of this vector with the XW components replaced by the given values} */
    public Float4 withXW(float x, float w) {
        return new Float4(x, this.y(), this.z(), w);
    }

    /** {@return a copy of this vector with the YW components replaced by the given values} */
    public Float4 withYW(float y, float w) {
        return new Float4(this.x(), y, this.z(), w);
    }

    /** {@return a copy of this vector with the XYW components replaced by the given values} */
    public Float4 withXYW(float x, float y, float w) {
        return new Float4(x, y, this.z(), w);
    }

    /** {@return a copy of this vector with the ZW components replaced by the given values} */
    public Float4 withZW(float z, float w) {
        return new Float4(this.x(), this.y(), z, w);
    }

    /** {@return a copy of this vector with the XZW components replaced by the given values} */
    public Float4 withXZW(float x, float z, float w) {
        return new Float4(x, this.y(), z, w);
    }

    /** {@return a copy of this vector with the YZW components replaced by the given values} */
    public Float4 withYZW(float y, float z, float w) {
        return new Float4(this.x(), y, z, w);
    }

    /** {@return a copy of this vector with the XYZW components replaced by the given values} */
    public Float4 withXYZW(float x, float y, float z, float w) {
        return new Float4(x, y, z, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code w}) of this vector, in that order} */
    public Float2 xw() {
        return new Float2(x, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code w}) of this vector, in that order} */
    public Float2 yw() {
        return new Float2(y, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code w}) of this vector, in that order} */
    public Float2 zw() {
        return new Float2(z, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}) of this vector, in that order} */
    public Float2 wx() {
        return new Float2(w, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}) of this vector, in that order} */
    public Float2 wy() {
        return new Float2(w, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}) of this vector, in that order} */
    public Float2 wz() {
        return new Float2(w, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}) of this vector, in that order} */
    public Float2 ww() {
        return new Float2(w, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code w}) of this vector, in that order} */
    public Float3 xxw() {
        return new Float3(x, x, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code w}) of this vector, in that order} */
    public Float3 xyw() {
        return new Float3(x, y, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code w}) of this vector, in that order} */
    public Float3 xzw() {
        return new Float3(x, z, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code x}) of this vector, in that order} */
    public Float3 xwx() {
        return new Float3(x, w, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code y}) of this vector, in that order} */
    public Float3 xwy() {
        return new Float3(x, w, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code z}) of this vector, in that order} */
    public Float3 xwz() {
        return new Float3(x, w, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code w}) of this vector, in that order} */
    public Float3 xww() {
        return new Float3(x, w, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code w}) of this vector, in that order} */
    public Float3 yxw() {
        return new Float3(y, x, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code w}) of this vector, in that order} */
    public Float3 yyw() {
        return new Float3(y, y, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code w}) of this vector, in that order} */
    public Float3 yzw() {
        return new Float3(y, z, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code x}) of this vector, in that order} */
    public Float3 ywx() {
        return new Float3(y, w, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code y}) of this vector, in that order} */
    public Float3 ywy() {
        return new Float3(y, w, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code z}) of this vector, in that order} */
    public Float3 ywz() {
        return new Float3(y, w, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code w}) of this vector, in that order} */
    public Float3 yww() {
        return new Float3(y, w, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code w}) of this vector, in that order} */
    public Float3 zxw() {
        return new Float3(z, x, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code w}) of this vector, in that order} */
    public Float3 zyw() {
        return new Float3(z, y, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code w}) of this vector, in that order} */
    public Float3 zzw() {
        return new Float3(z, z, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code x}) of this vector, in that order} */
    public Float3 zwx() {
        return new Float3(z, w, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code y}) of this vector, in that order} */
    public Float3 zwy() {
        return new Float3(z, w, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code z}) of this vector, in that order} */
    public Float3 zwz() {
        return new Float3(z, w, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code w}) of this vector, in that order} */
    public Float3 zww() {
        return new Float3(z, w, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code x}) of this vector, in that order} */
    public Float3 wxx() {
        return new Float3(w, x, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code y}) of this vector, in that order} */
    public Float3 wxy() {
        return new Float3(w, x, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code z}) of this vector, in that order} */
    public Float3 wxz() {
        return new Float3(w, x, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code w}) of this vector, in that order} */
    public Float3 wxw() {
        return new Float3(w, x, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code x}) of this vector, in that order} */
    public Float3 wyx() {
        return new Float3(w, y, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code y}) of this vector, in that order} */
    public Float3 wyy() {
        return new Float3(w, y, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code z}) of this vector, in that order} */
    public Float3 wyz() {
        return new Float3(w, y, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code w}) of this vector, in that order} */
    public Float3 wyw() {
        return new Float3(w, y, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code x}) of this vector, in that order} */
    public Float3 wzx() {
        return new Float3(w, z, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code y}) of this vector, in that order} */
    public Float3 wzy() {
        return new Float3(w, z, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code z}) of this vector, in that order} */
    public Float3 wzz() {
        return new Float3(w, z, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code w}) of this vector, in that order} */
    public Float3 wzw() {
        return new Float3(w, z, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code x}) of this vector, in that order} */
    public Float3 wwx() {
        return new Float3(w, w, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code y}) of this vector, in that order} */
    public Float3 wwy() {
        return new Float3(w, w, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code z}) of this vector, in that order} */
    public Float3 wwz() {
        return new Float3(w, w, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code w}) of this vector, in that order} */
    public Float3 www() {
        return new Float3(w, w, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 xxxw() {
        return new Float4(x, x, x, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 xxyw() {
        return new Float4(x, x, y, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 xxzw() {
        return new Float4(x, x, z, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 xxwx() {
        return new Float4(x, x, w, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 xxwy() {
        return new Float4(x, x, w, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 xxwz() {
        return new Float4(x, x, w, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code x}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 xxww() {
        return new Float4(x, x, w, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 xyxw() {
        return new Float4(x, y, x, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 xyyw() {
        return new Float4(x, y, y, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 xyzw() {
        return new Float4(x, y, z, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 xywx() {
        return new Float4(x, y, w, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 xywy() {
        return new Float4(x, y, w, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 xywz() {
        return new Float4(x, y, w, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code y}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 xyww() {
        return new Float4(x, y, w, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 xzxw() {
        return new Float4(x, z, x, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 xzyw() {
        return new Float4(x, z, y, w);
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

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 xzzw() {
        return new Float4(x, z, z, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 xzwx() {
        return new Float4(x, z, w, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 xzwy() {
        return new Float4(x, z, w, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 xzwz() {
        return new Float4(x, z, w, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code z}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 xzww() {
        return new Float4(x, z, w, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 xwxx() {
        return new Float4(x, w, x, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 xwxy() {
        return new Float4(x, w, x, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 xwxz() {
        return new Float4(x, w, x, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 xwxw() {
        return new Float4(x, w, x, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 xwyx() {
        return new Float4(x, w, y, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 xwyy() {
        return new Float4(x, w, y, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 xwyz() {
        return new Float4(x, w, y, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 xwyw() {
        return new Float4(x, w, y, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 xwzx() {
        return new Float4(x, w, z, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 xwzy() {
        return new Float4(x, w, z, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 xwzz() {
        return new Float4(x, w, z, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 xwzw() {
        return new Float4(x, w, z, w);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 xwwx() {
        return new Float4(x, w, w, x);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 xwwy() {
        return new Float4(x, w, w, y);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 xwwz() {
        return new Float4(x, w, w, z);
    }

    /** {@return a new vector holding the components ({@code x}, {@code w}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 xwww() {
        return new Float4(x, w, w, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 yxxw() {
        return new Float4(y, x, x, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 yxyw() {
        return new Float4(y, x, y, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 yxzw() {
        return new Float4(y, x, z, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 yxwx() {
        return new Float4(y, x, w, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 yxwy() {
        return new Float4(y, x, w, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 yxwz() {
        return new Float4(y, x, w, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code x}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 yxww() {
        return new Float4(y, x, w, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 yyxw() {
        return new Float4(y, y, x, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 yyyw() {
        return new Float4(y, y, y, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 yyzw() {
        return new Float4(y, y, z, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 yywx() {
        return new Float4(y, y, w, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 yywy() {
        return new Float4(y, y, w, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 yywz() {
        return new Float4(y, y, w, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code y}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 yyww() {
        return new Float4(y, y, w, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 yzxw() {
        return new Float4(y, z, x, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 yzyw() {
        return new Float4(y, z, y, w);
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

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 yzzw() {
        return new Float4(y, z, z, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 yzwx() {
        return new Float4(y, z, w, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 yzwy() {
        return new Float4(y, z, w, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 yzwz() {
        return new Float4(y, z, w, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code z}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 yzww() {
        return new Float4(y, z, w, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 ywxx() {
        return new Float4(y, w, x, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 ywxy() {
        return new Float4(y, w, x, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 ywxz() {
        return new Float4(y, w, x, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 ywxw() {
        return new Float4(y, w, x, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 ywyx() {
        return new Float4(y, w, y, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 ywyy() {
        return new Float4(y, w, y, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 ywyz() {
        return new Float4(y, w, y, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 ywyw() {
        return new Float4(y, w, y, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 ywzx() {
        return new Float4(y, w, z, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 ywzy() {
        return new Float4(y, w, z, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 ywzz() {
        return new Float4(y, w, z, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 ywzw() {
        return new Float4(y, w, z, w);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 ywwx() {
        return new Float4(y, w, w, x);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 ywwy() {
        return new Float4(y, w, w, y);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 ywwz() {
        return new Float4(y, w, w, z);
    }

    /** {@return a new vector holding the components ({@code y}, {@code w}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 ywww() {
        return new Float4(y, w, w, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 zxxw() {
        return new Float4(z, x, x, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 zxyw() {
        return new Float4(z, x, y, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 zxzw() {
        return new Float4(z, x, z, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 zxwx() {
        return new Float4(z, x, w, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 zxwy() {
        return new Float4(z, x, w, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 zxwz() {
        return new Float4(z, x, w, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code x}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 zxww() {
        return new Float4(z, x, w, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 zyxw() {
        return new Float4(z, y, x, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 zyyw() {
        return new Float4(z, y, y, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 zyzw() {
        return new Float4(z, y, z, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 zywx() {
        return new Float4(z, y, w, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 zywy() {
        return new Float4(z, y, w, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 zywz() {
        return new Float4(z, y, w, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code y}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 zyww() {
        return new Float4(z, y, w, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 zzxw() {
        return new Float4(z, z, x, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 zzyw() {
        return new Float4(z, z, y, w);
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

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 zzzw() {
        return new Float4(z, z, z, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 zzwx() {
        return new Float4(z, z, w, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 zzwy() {
        return new Float4(z, z, w, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 zzwz() {
        return new Float4(z, z, w, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code z}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 zzww() {
        return new Float4(z, z, w, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 zwxx() {
        return new Float4(z, w, x, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 zwxy() {
        return new Float4(z, w, x, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 zwxz() {
        return new Float4(z, w, x, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 zwxw() {
        return new Float4(z, w, x, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 zwyx() {
        return new Float4(z, w, y, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 zwyy() {
        return new Float4(z, w, y, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 zwyz() {
        return new Float4(z, w, y, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 zwyw() {
        return new Float4(z, w, y, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 zwzx() {
        return new Float4(z, w, z, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 zwzy() {
        return new Float4(z, w, z, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 zwzz() {
        return new Float4(z, w, z, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 zwzw() {
        return new Float4(z, w, z, w);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 zwwx() {
        return new Float4(z, w, w, x);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 zwwy() {
        return new Float4(z, w, w, y);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 zwwz() {
        return new Float4(z, w, w, z);
    }

    /** {@return a new vector holding the components ({@code z}, {@code w}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 zwww() {
        return new Float4(z, w, w, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 wxxx() {
        return new Float4(w, x, x, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 wxxy() {
        return new Float4(w, x, x, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 wxxz() {
        return new Float4(w, x, x, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 wxxw() {
        return new Float4(w, x, x, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 wxyx() {
        return new Float4(w, x, y, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 wxyy() {
        return new Float4(w, x, y, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 wxyz() {
        return new Float4(w, x, y, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 wxyw() {
        return new Float4(w, x, y, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 wxzx() {
        return new Float4(w, x, z, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 wxzy() {
        return new Float4(w, x, z, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 wxzz() {
        return new Float4(w, x, z, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 wxzw() {
        return new Float4(w, x, z, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 wxwx() {
        return new Float4(w, x, w, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 wxwy() {
        return new Float4(w, x, w, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 wxwz() {
        return new Float4(w, x, w, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code x}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 wxww() {
        return new Float4(w, x, w, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 wyxx() {
        return new Float4(w, y, x, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 wyxy() {
        return new Float4(w, y, x, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 wyxz() {
        return new Float4(w, y, x, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 wyxw() {
        return new Float4(w, y, x, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 wyyx() {
        return new Float4(w, y, y, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 wyyy() {
        return new Float4(w, y, y, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 wyyz() {
        return new Float4(w, y, y, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 wyyw() {
        return new Float4(w, y, y, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 wyzx() {
        return new Float4(w, y, z, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 wyzy() {
        return new Float4(w, y, z, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 wyzz() {
        return new Float4(w, y, z, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 wyzw() {
        return new Float4(w, y, z, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 wywx() {
        return new Float4(w, y, w, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 wywy() {
        return new Float4(w, y, w, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 wywz() {
        return new Float4(w, y, w, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code y}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 wyww() {
        return new Float4(w, y, w, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 wzxx() {
        return new Float4(w, z, x, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 wzxy() {
        return new Float4(w, z, x, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 wzxz() {
        return new Float4(w, z, x, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 wzxw() {
        return new Float4(w, z, x, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 wzyx() {
        return new Float4(w, z, y, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 wzyy() {
        return new Float4(w, z, y, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 wzyz() {
        return new Float4(w, z, y, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 wzyw() {
        return new Float4(w, z, y, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 wzzx() {
        return new Float4(w, z, z, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 wzzy() {
        return new Float4(w, z, z, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 wzzz() {
        return new Float4(w, z, z, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 wzzw() {
        return new Float4(w, z, z, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 wzwx() {
        return new Float4(w, z, w, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 wzwy() {
        return new Float4(w, z, w, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 wzwz() {
        return new Float4(w, z, w, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code z}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 wzww() {
        return new Float4(w, z, w, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code x}, {@code x}) of this vector, in that order} */
    public Float4 wwxx() {
        return new Float4(w, w, x, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code x}, {@code y}) of this vector, in that order} */
    public Float4 wwxy() {
        return new Float4(w, w, x, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code x}, {@code z}) of this vector, in that order} */
    public Float4 wwxz() {
        return new Float4(w, w, x, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code x}, {@code w}) of this vector, in that order} */
    public Float4 wwxw() {
        return new Float4(w, w, x, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code y}, {@code x}) of this vector, in that order} */
    public Float4 wwyx() {
        return new Float4(w, w, y, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code y}, {@code y}) of this vector, in that order} */
    public Float4 wwyy() {
        return new Float4(w, w, y, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code y}, {@code z}) of this vector, in that order} */
    public Float4 wwyz() {
        return new Float4(w, w, y, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code y}, {@code w}) of this vector, in that order} */
    public Float4 wwyw() {
        return new Float4(w, w, y, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code z}, {@code x}) of this vector, in that order} */
    public Float4 wwzx() {
        return new Float4(w, w, z, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code z}, {@code y}) of this vector, in that order} */
    public Float4 wwzy() {
        return new Float4(w, w, z, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code z}, {@code z}) of this vector, in that order} */
    public Float4 wwzz() {
        return new Float4(w, w, z, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code z}, {@code w}) of this vector, in that order} */
    public Float4 wwzw() {
        return new Float4(w, w, z, w);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code w}, {@code x}) of this vector, in that order} */
    public Float4 wwwx() {
        return new Float4(w, w, w, x);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code w}, {@code y}) of this vector, in that order} */
    public Float4 wwwy() {
        return new Float4(w, w, w, y);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code w}, {@code z}) of this vector, in that order} */
    public Float4 wwwz() {
        return new Float4(w, w, w, z);
    }

    /** {@return a new vector holding the components ({@code w}, {@code w}, {@code w}, {@code w}) of this vector, in that order} */
    public Float4 wwww() {
        return new Float4(w, w, w, w);
    }

    @Override public String toString() {
        return "Float4(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float4)) return false;
        Float4 o = (Float4) obj;
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
     * <p>
     * {@code equalsEpsilon} compares per component with a tolerance: an infinite component never
     * compares equal, not even to an equal infinity (the difference {@code Inf - Inf} is NaN), and
     * a NaN component never compares equal to anything.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(Float4 other, float epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(w - other.w()) <= epsilon;
    }

    static final Float4SegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float4SegOpsUnsafe()
                    : new Float4SegOpsMS();
    static final Float4BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float4BbOpsUnsafe()
                    : new Float4BbOpsApi();
    static final Float4RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Float4RawOpsUnsafe()
                    : new Float4RawOpsApi();


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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        return new Float4(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(float[] src) { return load(src, 0); }

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
        buf.position(pos + 4);
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(FloatBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadAbsolute(int index, FloatBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        Float4 r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(ByteBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadAbsolute(int index, ByteBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float4 r = loadAbsolute(pos, buf);
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
    public Float4 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadUnsafe(long address) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(MemorySegment src) { return load(0L, src); }

    /**
     * Load the elements from the given memory segment, starting at the given offset.
     * <p>
     * With the UNSAFE backend, offsets into direct buffers and native segments are not
     * bounds-checked and segment liveness / thread confinement is not verified; the API backend
     * performs the standard checks.
     *
     * @param offset the start offset into the memory segment, in bytes
     * @param src the source memory segment
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(long offset, MemorySegment src) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        return new Float4(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(double[] src) { return load(src, 0); }

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
        buf.position(pos + 4);
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 load(DoubleBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadAbsolute(int index, DoubleBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        Float4 r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
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
        buf.position(pos + 32);
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadDouble(ByteBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadDoubleAbsolute(int index, ByteBuffer buf) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        Float4 r = loadDoubleAbsolute(pos, buf);
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
    public Float4 storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadDoubleUnsafe(long address) {
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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadDouble(MemorySegment src) { return loadDouble(0L, src); }

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
     * @return a new {@code Float4} holding the loaded elements
     */
    public static Float4 loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(offset, src);
    }

}
