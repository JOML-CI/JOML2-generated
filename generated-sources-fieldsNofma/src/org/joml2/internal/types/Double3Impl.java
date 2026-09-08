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
 * Generated implementation of {@link Double3} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class Double3Impl implements Double3 {

    public double x;
    public double y;
    public double z;
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

    public Double3Impl() {
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 add(Double3R other, @Mutated Double3 dest) {
        return add(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}) to this vector and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 add(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        d.z = otherZ + this.z;
        return d;
    }


    /**
     * Divide each component of this vector by {@code scalar} and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(double scalar, @Mutated Double3 dest) {
        return div(scalar, scalar, scalar, dest);
    }


    /**
     * Divide this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(Double3R other, @Mutated Double3 dest) {
        return div(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ}) and
     * store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x / otherX;
        d.y = this.y / otherY;
        d.z = this.z / otherZ;
        return d;
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component and store the result in {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(double b, Double3R c, @Mutated Double3 dest) {
        return fma(b, c.x(), c.y(), c.z(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY},
     * {@code cZ}), i.e. compute {@code this * b + c} per component and store the result in
     * {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(double b, double cX, double cY, double cZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.x, b, cX);
        d.y = Math.fma(this.y, b, cY);
        d.z = Math.fma(this.z, b, cZ);
        return d;
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component and store the result in {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(Double3R b, Double3R c, @Mutated Double3 dest) {
        return fma(b.x(), b.y(), b.z(), c.x(), c.y(), c.z(), dest);
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * b + c} per component and
     * store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(double bX, double bY, double bZ, double cX, double cY, double cZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.fma(this.x, bX, cX);
        d.y = Math.fma(this.y, bY, cY);
        d.z = Math.fma(this.z, bZ, cZ);
        return d;
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(double scalar, @Mutated Double3 dest) {
        return mul(scalar, scalar, scalar, dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(Double3R other, @Mutated Double3 dest) {
        return mul(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ}) and
     * store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = otherX * this.x;
        d.y = otherY * this.y;
        d.z = otherZ * this.z;
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 negate(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        return d;
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sub(Double3R other, @Mutated Double3 dest) {
        return sub(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}) from this vector and store the
     * result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sub(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        d.z = this.z - otherZ;
        return d;
    }


    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double3 set(Double3R v) {
        return set(v.x(), v.y(), v.z());
    }


    /**
     * Set this vector to the given values.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ)}
     * @return this
     */
    @Mutated public Double3 set(double vX, double vY, double vZ) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        return this;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3 set(double s, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = s;
        d.y = s;
        d.z = s;
        return d;
    }


    /**
     * Convert this vector to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 toFloat(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) (this.x);
        d.y = (float) (this.y);
        d.z = (float) (this.z);
        return d;
    }


    /**
     * Convert this vector to {@code byte} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Byte3 toByte(@Mutated Byte3 dest) {
        Byte3Impl d = (Byte3Impl) dest;
        d.x = (byte) (this.x);
        d.y = (byte) (this.y);
        d.z = (byte) (this.z);
        return d;
    }


    /**
     * Convert this vector to {@code byte} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    public Byte3 toByte(RoundingMode roundingMode, @Mutated Byte3 dest) {
        Byte3Impl d = (Byte3Impl) dest;
        switch (roundingMode) {
            case TRUNCATE -> { return toByte(dest); }
            case FLOOR -> {
                d.x = (byte) Math.floor(this.x);
                d.y = (byte) Math.floor(this.y);
                d.z = (byte) Math.floor(this.z);
            }
            case CEILING -> {
                d.x = (byte) Math.ceil(this.x);
                d.y = (byte) Math.ceil(this.y);
                d.z = (byte) Math.ceil(this.z);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                d.x = (byte) Math.round(this.x);
                d.y = (byte) Math.round(this.y);
                d.z = (byte) Math.round(this.z);
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.x = (byte) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (byte) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (byte) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
            }
            case HALF_EVEN -> {
                d.x = (byte) Math.rint(this.x);
                d.y = (byte) Math.rint(this.y);
                d.z = (byte) Math.rint(this.z);
            }
        }
        return dest;
    }


    /**
     * Convert this vector to {@code short} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Short3 toShort(@Mutated Short3 dest) {
        Short3Impl d = (Short3Impl) dest;
        d.x = (short) (this.x);
        d.y = (short) (this.y);
        d.z = (short) (this.z);
        return d;
    }


    /**
     * Convert this vector to {@code short} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    public Short3 toShort(RoundingMode roundingMode, @Mutated Short3 dest) {
        Short3Impl d = (Short3Impl) dest;
        switch (roundingMode) {
            case TRUNCATE -> { return toShort(dest); }
            case FLOOR -> {
                d.x = (short) Math.floor(this.x);
                d.y = (short) Math.floor(this.y);
                d.z = (short) Math.floor(this.z);
            }
            case CEILING -> {
                d.x = (short) Math.ceil(this.x);
                d.y = (short) Math.ceil(this.y);
                d.z = (short) Math.ceil(this.z);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                d.x = (short) Math.round(this.x);
                d.y = (short) Math.round(this.y);
                d.z = (short) Math.round(this.z);
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.x = (short) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (short) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (short) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
            }
            case HALF_EVEN -> {
                d.x = (short) Math.rint(this.x);
                d.y = (short) Math.rint(this.y);
                d.z = (short) Math.rint(this.z);
            }
        }
        return dest;
    }


    /**
     * Convert this vector to {@code int} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Int3 toInt(@Mutated Int3 dest) {
        Int3Impl d = (Int3Impl) dest;
        d.x = (int) (this.x);
        d.y = (int) (this.y);
        d.z = (int) (this.z);
        return d;
    }


    /**
     * Convert this vector to {@code int} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    public Int3 toInt(RoundingMode roundingMode, @Mutated Int3 dest) {
        Int3Impl d = (Int3Impl) dest;
        switch (roundingMode) {
            case TRUNCATE -> { return toInt(dest); }
            case FLOOR -> {
                d.x = (int) Math.floor(this.x);
                d.y = (int) Math.floor(this.y);
                d.z = (int) Math.floor(this.z);
            }
            case CEILING -> {
                d.x = (int) Math.ceil(this.x);
                d.y = (int) Math.ceil(this.y);
                d.z = (int) Math.ceil(this.z);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                d.x = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x)));
                d.y = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y)));
                d.z = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z)));
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.x = (int) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (int) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (int) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
            }
            case HALF_EVEN -> {
                d.x = (int) Math.rint(this.x);
                d.y = (int) Math.rint(this.y);
                d.z = (int) Math.rint(this.z);
            }
        }
        return dest;
    }


    /**
     * Convert this vector to {@code long} precision and store the result in {@code dest}.
     * <p>
     * Each component is converted by a primitive cast, truncating toward zero.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Long3 toLong(@Mutated Long3 dest) {
        Long3Impl d = (Long3Impl) dest;
        d.x = (long) (this.x);
        d.y = (long) (this.y);
        d.z = (long) (this.z);
        return d;
    }


    /**
     * Convert this vector to {@code long} precision and store the result in {@code dest}.
     * <p>
     * Each component is rounded according to the given rounding mode.
     *
     * @param roundingMode the rounding mode to use
     * @param dest will hold the result
     * @return dest
     */
    public Long3 toLong(RoundingMode roundingMode, @Mutated Long3 dest) {
        Long3Impl d = (Long3Impl) dest;
        switch (roundingMode) {
            case TRUNCATE -> { return toLong(dest); }
            case FLOOR -> {
                d.x = (long) Math.floor(this.x);
                d.y = (long) Math.floor(this.y);
                d.z = (long) Math.floor(this.z);
            }
            case CEILING -> {
                d.x = (long) Math.ceil(this.x);
                d.y = (long) Math.ceil(this.y);
                d.z = (long) Math.ceil(this.z);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                d.x = Math.round(this.x);
                d.y = Math.round(this.y);
                d.z = Math.round(this.z);
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.x = (long) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (long) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (long) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
            }
            case HALF_EVEN -> {
                d.x = (long) Math.rint(this.x);
                d.y = (long) Math.rint(this.y);
                d.z = (long) Math.rint(this.z);
            }
        }
        return dest;
    }


    /**
     * Set all components of this vector to zero.
     *
     * @return this
     */
    @Mutated public Double3 makeZero() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        return this;
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return bezier(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        d.x = p1X * _t7 + this.x * _t8 + (p2X * _t6 + p3X * _t2);
        d.y = p1Y * _t7 + this.y * _t8 + (p2Y * _t6 + p3Y * _t2);
        d.z = p1Z * _t7 + this.z * _t8 + (p2Z * _t6 + p3Z * _t2);
        return d;
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2(Double3R p1, Double3R p2, double t, @Mutated Double3 dest) {
        return bezier2(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t, dest);
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t3 = 2.0 * t * _t0;
        double _t4 = _t0 * _t0;
        d.x = p1X * _t3 + this.x * _t4 + p2X * _t1;
        d.y = p1Y * _t3 + this.y * _t4 + p2Y * _t1;
        d.z = p1Z * _t3 + this.z * _t4 + p2Z * _t1;
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2Tangent(Double3R p1, Double3R p2, double t, @Mutated Double3 dest) {
        return bezier2Tangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2Tangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        d.x = (p1X - this.x) * _t2 + (p2X - p1X) * _t1;
        d.y = (p1Y - this.y) * _t2 + (p2Y - p1Y) * _t1;
        d.z = (p1Z - this.z) * _t2 + (p2Z - p1Z) * _t1;
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezierTangent(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return bezierTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezierTangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = 1.0 - t;
        double _t3 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t0;
        double _t6 = 3.0 * _t0 * _t0;
        d.x = (p1X - this.x) * _t6 + (p2X - p1X) * _t5 + (p3X - p2X) * _t3;
        d.y = (p1Y - this.y) * _t6 + (p2Y - p1Y) * _t5 + (p3Y - p2Y) * _t3;
        d.z = (p1Z - this.z) * _t6 + (p2Z - p1Z) * _t5 + (p3Z - p2Z) * _t3;
        return d;
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRom(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return catmullRom(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRom(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = t * t;
        double _t1 = t * _t0;
        d.x = 0.5 * (2.0 * p1X + t * (p2X - this.x) + ((-5.0 * p1X + (2.0 * this.x + (4.0 * p2X - p3X))) * _t0 + (3.0 * p1X + (p3X - this.x) - 3.0 * p2X) * _t1));
        d.y = 0.5 * (2.0 * p1Y + t * (p2Y - this.y) + ((-5.0 * p1Y + (2.0 * this.y + (4.0 * p2Y - p3Y))) * _t0 + (3.0 * p1Y + (p3Y - this.y) - 3.0 * p2Y) * _t1));
        d.z = 0.5 * (2.0 * p1Z + t * (p2Z - this.z) + ((-5.0 * p1Z + (2.0 * this.z + (4.0 * p2Z - p3Z))) * _t0 + (3.0 * p1Z + (p3Z - this.z) - 3.0 * p2Z) * _t1));
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRomTangent(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return catmullRomTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRomTangent(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = t * t;
        d.x = 0.5 * (t * 2.0 * (-5.0 * p1X + (2.0 * this.x + (4.0 * p2X - p3X))) + (3.0 * (3.0 * p1X + (p3X - this.x) - 3.0 * p2X) * _t0 + (p2X - this.x)));
        d.y = 0.5 * (t * 2.0 * (-5.0 * p1Y + (2.0 * this.y + (4.0 * p2Y - p3Y))) + (3.0 * (3.0 * p1Y + (p3Y - this.y) - 3.0 * p2Y) * _t0 + (p2Y - this.y)));
        d.z = 0.5 * (t * 2.0 * (-5.0 * p1Z + (2.0 * this.z + (4.0 * p2Z - p3Z))) + (3.0 * (3.0 * p1Z + (p3Z - this.z) - 3.0 * p2Z) * _t0 + (p2Z - this.z)));
        return d;
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermite(Double3R t0, Double3R v1, Double3R t1, double t, @Mutated Double3 dest) {
        return hermite(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t, dest);
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermite(double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = t * t;
        double _t3 = 3.0 * _t0;
        double _t5 = 2.0 * t * _t0;
        double _t8 = t * (_t0 - t);
        double _t9 = (t - 2.0) * _t0 + t;
        double _t10 = _t3 - _t5;
        double _t11 = _t5 + (1.0 - _t3);
        d.x = this.x * _t11 + t0X * _t9 + (t1X * _t8 + v1X * _t10);
        d.y = this.y * _t11 + t0Y * _t9 + (t1Y * _t8 + v1Y * _t10);
        d.z = this.z * _t11 + t0Z * _t9 + (t1Z * _t8 + v1Z * _t10);
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermiteTangent(Double3R t0, Double3R v1, Double3R t1, double t, @Mutated Double3 dest) {
        return hermiteTangent(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermiteTangent(double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = t * t;
        double _t4 = 3.0 * _t0;
        double _t7 = 6.0 * (_t0 - t);
        double _t8 = 6.0 * (t - _t0);
        double _t9 = _t4 - 2.0 * t;
        double _t10 = _t4 + (1.0 - 4.0 * t);
        d.x = this.x * _t7 + t0X * _t10 + (t1X * _t9 + v1X * _t8);
        d.y = this.y * _t7 + t0Y * _t10 + (t1Y * _t9 + v1Y * _t8);
        d.z = this.z * _t7 + t0Z * _t10 + (t1Z * _t9 + v1Z * _t8);
        return d;
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(Double3R other, double t, @Mutated Double3 dest) {
        return lerp(other.x(), other.y(), other.z(), t, dest);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor {@code t} and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(double otherX, double otherY, double otherZ, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = t * (otherX - this.x) + this.x;
        d.y = t * (otherY - this.y) + this.y;
        d.z = t * (otherZ - this.z) + this.z;
        return d;
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(Double3R other, Double3R t, @Mutated Double3 dest) {
        return lerp(other.x(), other.y(), other.z(), t.x(), t.y(), t.z(), dest);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor ({@code tX}, {@code tY}, {@code tZ}) and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(double otherX, double otherY, double otherZ, double tX, double tY, double tZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = tX * (otherX - this.x) + this.x;
        d.y = tY * (otherY - this.y) + this.y;
        d.z = tZ * (otherZ - this.z) + this.z;
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 absolute(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.abs(this.x);
        d.y = Math.abs(this.y);
        d.z = Math.abs(this.z);
        return d;
    }


    /**
     * Compute the arc cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 acos(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.acos(this.x);
        d.y = Math.acos(this.y);
        d.z = Math.acos(this.z);
        return d;
    }


    /**
     * Add {@code b} scaled by {@code scalar} to this vector and store the result in {@code dest}.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(Double3R b, double scalar, @Mutated Double3 dest) {
        return addScaled(b.x(), b.y(), b.z(), scalar, dest);
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by {@code scalar} to this vector and store
     * the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(double bX, double bY, double bZ, double scalar, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = scalar * bX + this.x;
        d.y = scalar * bY + this.y;
        d.z = scalar * bZ + this.z;
        return d;
    }


    /**
     * Add {@code b} scaled by {@code c} to this vector and store the result in {@code dest}.
     *
     * @param b the vector
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(Double3R b, Double3R c, @Mutated Double3 dest) {
        return addScaled(b.x(), b.y(), b.z(), c.x(), c.y(), c.z(), dest);
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by ({@code cX}, {@code cY}, {@code cZ}) to
     * this vector and store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(double bX, double bY, double bZ, double cX, double cY, double cZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = bX * cX + this.x;
        d.y = bY * cY + this.y;
        d.z = bZ * cZ + this.z;
        return d;
    }


    /**
     * Compute the angle in radians between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the angle in radians between this vector and {@code other}
     */
    public double angleBetween(Double3R other) {
        return angleBetween(other.x(), other.y(), other.z());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public double angleBetween(double otherX, double otherY, double otherZ) {
        return Math.acos(Math.min(1.0, Math.max(-1.0, (otherX * this.x + otherY * this.y + otherZ * this.z) * (1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z)) * (1.0 / Math.sqrt(otherX * otherX + otherY * otherY + otherZ * otherZ)))));
    }


    /**
     * Compute the arc sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 asin(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.asin(this.x);
        d.y = Math.asin(this.y);
        d.z = Math.asin(this.z);
        return d;
    }


    /**
     * Compute the arc tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.atan(this.x);
        d.y = Math.atan(this.y);
        d.z = Math.atan(this.z);
        return d;
    }


    /**
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
     * {@code dest}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(double x, @Mutated Double3 dest) {
        return atan2(x, x, x, dest);
    }


    /**
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
     * {@code dest}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(Double3R x, @Mutated Double3 dest) {
        return atan2(x.x(), x.y(), x.z(), dest);
    }


    /**
     * Compute the component-wise arc tangent of this vector over ({@code xX}, {@code xY},
     * {@code xZ}) and store the result in {@code dest}.
     *
     * @param xX the {@code x} component of the vector {@code (xX, xY, xZ)}
     * @param xY the {@code y} component of the vector {@code (xX, xY, xZ)}
     * @param xZ the {@code z} component of the vector {@code (xX, xY, xZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(double xX, double xY, double xZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.atan2(this.x, xX);
        d.y = Math.atan2(this.y, xY);
        d.z = Math.atan2(this.z, xZ);
        return d;
    }


    /**
     * Compute the cube root of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cbrt(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.cbrt(this.x);
        d.y = Math.cbrt(this.y);
        d.z = Math.cbrt(this.z);
        return d;
    }


    /**
     * Compute the ceiling of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 ceil(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.ceil(this.x);
        d.y = Math.ceil(this.y);
        d.z = Math.ceil(this.z);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Double3 clamp(double min, double max, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.min(Math.max(this.x, min), max);
        d.y = Math.min(Math.max(this.y, min), max);
        d.z = Math.min(Math.max(this.z, min), max);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     *
     * @param min the minimum corner
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    public Double3 clamp(Double3R min, Double3R max, @Mutated Double3 dest) {
        return clamp(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), dest);
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ}) and
     * ({@code maxX}, {@code maxY}, {@code maxZ}) and store the result in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 clamp(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.min(Math.max(this.x, minX), maxX);
        d.y = Math.min(Math.max(this.y, minY), maxY);
        d.z = Math.min(Math.max(this.z, minZ), maxZ);
        return d;
    }


    /**
     * Set this vector to the point closest to it on the line segment between {@code lineStart} and
     * {@code lineEnd} and store the result in {@code dest}.
     *
     * @param lineStart the vector
     * @param lineEnd the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointOnLine(Double3R lineStart, Double3R lineEnd, @Mutated Double3 dest) {
        return closestPointOnLine(lineStart.x(), lineStart.y(), lineStart.z(), lineEnd.x(), lineEnd.y(), lineEnd.z(), dest);
    }


    /**
     * Set this vector to the point closest to it on the line segment between ({@code lineStartX},
     * {@code lineStartY}, {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY},
     * {@code lineEndZ}) and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointOnLine(double lineStartX, double lineStartY, double lineStartZ, double lineEndX, double lineEndY, double lineEndZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = lineEndX - lineStartX;
        double _t1 = lineEndY - lineStartY;
        double _t2 = lineEndZ - lineStartZ;
        double _t14 = _t0 * _t0 + _t1 * _t1 + _t2 * _t2;
        double _t18 = Math.max(0.0, Math.min(1.0, (_t0 * (this.x - lineStartX) + _t1 * (this.y - lineStartY) + _t2 * (this.z - lineStartZ)) / _t14));
        if (_t14 > 0.0) {
            d.x = _t0 * _t18 + lineStartX;
            d.y = _t1 * _t18 + lineStartY;
            d.z = _t2 * _t18 + lineStartZ;
        } else {
            d.x = lineStartX;
            d.y = lineStartY;
            d.z = lineStartZ;
        }
        return d;
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
     * Copy the sign of {@code sign} onto each component of this vector and store the result in
     * {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Double3 copySign(double sign, @Mutated Double3 dest) {
        return copySign(sign, sign, sign, dest);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector and store the result in {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Double3 copySign(Double3R sign, @Mutated Double3 dest) {
        return copySign(sign.x(), sign.y(), sign.z(), dest);
    }


    /**
     * Copy the sign of each component of ({@code signX}, {@code signY}, {@code signZ}) onto the
     * corresponding component of this vector and store the result in {@code dest}.
     *
     * @param signX the {@code x} component of the vector {@code (signX, signY, signZ)}
     * @param signY the {@code y} component of the vector {@code (signX, signY, signZ)}
     * @param signZ the {@code z} component of the vector {@code (signX, signY, signZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 copySign(double signX, double signY, double signZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.copySign(this.x, signX);
        d.y = Math.copySign(this.y, signY);
        d.z = Math.copySign(this.z, signZ);
        return d;
    }


    /**
     * Compute the cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cos(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.cos(this.x);
        d.y = Math.cos(this.y);
        d.z = Math.cos(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cosh(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.cosh(this.x);
        d.y = Math.cosh(this.y);
        d.z = Math.cosh(this.z);
        return d;
    }


    /**
     * Compute the cross product of this vector and {@code other} and store the result in
     * {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cross(Double3R other, @Mutated Double3 dest) {
        return cross(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Compute the cross product of this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cross(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = otherZ * this.y - otherY * this.z;
        double _buf1 = otherX * this.z - otherZ * this.x;
        d.z = otherY * this.x - otherX * this.y;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 degrees(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.toDegrees(this.x);
        d.y = Math.toDegrees(this.y);
        d.z = Math.toDegrees(this.z);
        return d;
    }


    /**
     * Compute the distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the distance between this vector and {@code other}
     */
    public double distance(Double3R other) {
        return distance(other.x(), other.y(), other.z());
    }


    /**
     * Compute the distance between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     */
    public double distance(double otherX, double otherY, double otherZ) {
        double _t0 = this.x - otherX;
        double _t1 = this.y - otherY;
        double _t2 = this.z - otherZ;
        return Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2);
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public double distanceSquared(Double3R other) {
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
        double _t0 = this.x - otherX;
        double _t1 = this.y - otherY;
        double _t2 = this.z - otherZ;
        return _t0 * _t0 + _t1 * _t1 + _t2 * _t2;
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public double dot(Double3R other) {
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
        return otherX * this.x + otherY * this.y + otherZ * this.z;
    }


    /**
     * Compute the base-e exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 exp(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.exp(this.x);
        d.y = Math.exp(this.y);
        d.z = Math.exp(this.z);
        return d;
    }


    /**
     * Compute the base-2 exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 exp2(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.pow(2.0, this.x);
        d.y = Math.pow(2.0, this.y);
        d.z = Math.pow(2.0, this.z);
        return d;
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 expm1(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.expm1(this.x);
        d.y = Math.expm1(this.y);
        d.z = Math.expm1(this.z);
        return d;
    }


    /**
     * Return this vector unchanged when {@code dot(Nref, I)} is negative, and negated otherwise -
     * orienting it against the incident direction {@code I} as judged by the reference vector
     * {@code Nref} and store the result in {@code dest}.
     *
     * @param I the vector
     * @param Nref the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 faceforward(Double3R I, Double3R Nref, @Mutated Double3 dest) {
        return faceforward(I.x(), I.y(), I.z(), Nref.x(), Nref.y(), Nref.z(), dest);
    }


    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ), (IX, IY, IZ))} is
     * negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}) as judged by the reference vector ({@code NrefX}, {@code NrefY},
     * {@code NrefZ}) and store the result in {@code dest}.
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY, IZ)}
     * @param IY the {@code y} component of the vector {@code (IX, IY, IZ)}
     * @param IZ the {@code z} component of the vector {@code (IX, IY, IZ)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param NrefZ the {@code z} component of the vector {@code (NrefX, NrefY, NrefZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 faceforward(double IX, double IY, double IZ, double NrefX, double NrefY, double NrefZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t4 = IX * NrefX + IY * NrefY + IZ * NrefZ;
        if (_t4 < 0.0) {
            d.x = this.x;
            d.y = this.y;
            d.z = this.z;
        } else {
            d.x = -this.x;
            d.y = -this.y;
            d.z = -this.z;
        }
        return d;
    }


    /**
     * Compute the floor of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 floor(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.floor(this.x);
        d.y = Math.floor(this.y);
        d.z = Math.floor(this.z);
        return d;
    }


    /**
     * Compute the fractional part of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fract(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x - Math.floor(this.x);
        d.y = this.y - Math.floor(this.y);
        d.z = this.z - Math.floor(this.z);
        return d;
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(double y, @Mutated Double3 dest) {
        return hypot(y, y, y, dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(Double3R y, @Mutated Double3 dest) {
        return hypot(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * ({@code yX}, {@code yY}, {@code yZ}) and store the result in {@code dest}.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(double yX, double yY, double yZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.hypot(this.x, yX);
        d.y = Math.hypot(this.y, yY);
        d.z = Math.hypot(this.z, yZ);
        return d;
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 inverse(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 1.0 / this.x;
        d.y = 1.0 / this.y;
        d.z = 1.0 / this.z;
        return d;
    }


    /**
     * Compute the inverse square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 inverseSqrt(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (1.0 / Math.sqrt(this.x));
        d.y = (1.0 / Math.sqrt(this.y));
        d.z = (1.0 / Math.sqrt(this.z));
        return d;
    }


    /**
     * Compute the length of this vector.
     *
     * @return the length of this vector
     */
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }


    /**
     * Compute the natural logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.log(this.x);
        d.y = Math.log(this.y);
        d.z = Math.log(this.z);
        return d;
    }


    /**
     * Compute the base-10 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log10(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.log10(this.x);
        d.y = Math.log10(this.y);
        d.z = Math.log10(this.z);
        return d;
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log1p(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.log1p(this.x);
        d.y = Math.log1p(this.y);
        d.z = Math.log1p(this.z);
        return d;
    }


    /**
     * Compute the base-2 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log2(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.log(2.0);
        double _t0_inv = 1.0 / _t0;
        d.x = Math.log(this.x) * _t0_inv;
        d.y = Math.log(this.y) * _t0_inv;
        d.z = Math.log(this.z) * _t0_inv;
        return d;
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public double manhattanDistance(Double3R other) {
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
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 max(double scalar, @Mutated Double3 dest) {
        return max(scalar, scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 max(Double3R other, @Mutated Double3 dest) {
        return max(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 max(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.max(this.x, otherX);
        d.y = Math.max(this.y, otherY);
        d.z = Math.max(this.z, otherZ);
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 min(double scalar, @Mutated Double3 dest) {
        return min(scalar, scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 min(Double3R other, @Mutated Double3 dest) {
        return min(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 min(double otherX, double otherY, double otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.min(this.x, otherX);
        d.y = Math.min(this.y, otherY);
        d.z = Math.min(this.z, otherZ);
        return d;
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the divisor
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(double y, @Mutated Double3 dest) {
        return mod(y, y, y, dest);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the divisor
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(Double3R y, @Mutated Double3 dest) {
        return mod(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code yX}, {@code yY}, {@code yZ}) and store the result in
     * {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(double yX, double yY, double yZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x - yX * Math.floor(this.x / yX);
        d.y = this.y - yY * Math.floor(this.y / yY);
        d.z = this.z - yZ * Math.floor(this.z / yZ);
        return d;
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 nextDown(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.nextDown(this.x);
        d.y = Math.nextDown(this.y);
        d.z = Math.nextDown(this.z);
        return d;
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 nextUp(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.nextUp(this.x);
        d.y = Math.nextUp(this.y);
        d.z = Math.nextUp(this.z);
        return d;
    }


    /**
     * Normalize this vector to unit length (the zero vector yields the zero vector). <p> The
     * squared length is formed at the component precision, so components whose squares overflow or
     * underflow that precision are out of domain: the result is the zero vector rather than a unit
     * vector. Rescale such inputs before normalizing (the threshold is around 1.8e19 for
     * {@code float} and 1.3e154 for {@code double}) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalize(@Mutated Double3 dest) {
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
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector) and store the result in {@code dest}.
     *
     * @param length the length to rescale to
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizeMul(double length, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t6 = length * (1.0 / Math.sqrt(_t4));
        if (_t4 > 0.0) {
            d.x = this.x * _t6;
            d.y = this.y * _t6;
            d.z = this.z * _t6;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Compute the signed angle in radians between this vector and {@code other}, positive when the
     * rotation from this vector to {@code other} is counter-clockwise as seen from the direction of
     * the given normal.
     *
     * @param other the other vector
     * @param normal the reference axis that defines the sign of the angle
     * @return the signed angle in radians between this vector and {@code other}, positive when the
     *        rotation from this vector to {@code other} is counter-clockwise as seen from the
     *        direction of the given normal
     */
    public double orientedAngle(Double3R other, Double3R normal) {
        return orientedAngle(other.x(), other.y(), other.z(), normal.x(), normal.y(), normal.z());
    }


    /**
     * Compute the signed angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}), positive when the rotation from this vector to ({@code otherX},
     * {@code otherY}, {@code otherZ}) is counter-clockwise as seen from the direction of the given
     * normal.
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
        double _t12 = otherX * otherX + otherY * otherY + otherZ * otherZ;
        double _t13 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t21 = Math.acos(Math.min(1.0, Math.max(-1.0, (otherX * this.x + otherY * this.y + otherZ * this.z) * (1.0 / Math.sqrt(_t13)) * (1.0 / Math.sqrt(_t12)))));
        return Math.sqrt(_t12) * Math.sqrt(_t13) > 0.0 ? normalX * (otherZ * this.y - otherY * this.z) + normalY * (otherX * this.z - otherZ * this.x) + normalZ * (otherY * this.x - otherX * this.y) < 0.0 ? -_t21 : _t21 : 0.0;
    }


    /**
     * Compute the outer product of this vector and {@code row} and store the result in
     * {@code dest}.
     *
     * @param row the row vector (right operand)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 outerProduct(Double3R row, @Mutated Double3x3 dest) {
        return outerProduct(row.x(), row.y(), row.z(), dest);
    }


    /**
     * Compute the outer product of this vector and ({@code rowX}, {@code rowY}, {@code rowZ}) and
     * store the result in {@code dest}.
     *
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 outerProduct(double rowX, double rowY, double rowZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        double _buf0 = rowX * this.x;
        d.m10 = rowX * this.y;
        d.m20 = rowX * this.z;
        double _buf1 = rowY * this.x;
        d.m11 = rowY * this.y;
        d.m21 = rowY * this.z;
        double _buf2 = rowZ * this.x;
        d.m12 = rowZ * this.y;
        d.m22 = rowZ * this.z;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Set this vector to one of its perpendicular vectors and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 perpendicular(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t2 = this.x * this.x + this.y * this.y;
        if (_t2 > 0.0) {
            double _buf0 = this.y;
            double _buf1 = -this.x;
            d.z = 0.0;
            d.x = _buf0;
            d.y = _buf1;
        } else {
            double _buf0 = 0.0;
            double _buf1 = this.z;
            d.z = -this.y;
            d.x = _buf0;
            d.y = _buf1;
        }
        return d;
    }


    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    public Double3 pow(double exponent, @Mutated Double3 dest) {
        return pow(exponent, exponent, exponent, dest);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    public Double3 pow(Double3R exponent, @Mutated Double3 dest) {
        return pow(exponent.x(), exponent.y(), exponent.z(), dest);
    }


    /**
     * Raise each component of this vector to the power of ({@code exponentX}, {@code exponentY},
     * {@code exponentZ}) and store the result in {@code dest}.
     *
     * @param exponentX the {@code x} component of the vector
     *        {@code (exponentX, exponentY, exponentZ)}
     * @param exponentY the {@code y} component of the vector
     *        {@code (exponentX, exponentY, exponentZ)}
     * @param exponentZ the {@code z} component of the vector
     *        {@code (exponentX, exponentY, exponentZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 pow(double exponentX, double exponentY, double exponentZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.pow(this.x, exponentX);
        d.y = Math.pow(this.y, exponentY);
        d.z = Math.pow(this.z, exponentZ);
        return d;
    }


    /**
     * Project this vector onto {@code onto} and store the result in {@code dest}.
     *
     * @param onto the vector to project onto
     * @param dest will hold the result
     * @return dest
     */
    public Double3 project(Double3R onto, @Mutated Double3 dest) {
        return project(onto.x(), onto.y(), onto.z(), dest);
    }


    /**
     * Project this vector onto ({@code ontoX}, {@code ontoY}, {@code ontoZ}) and store the result
     * in {@code dest}.
     *
     * @param ontoX the {@code x} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param ontoY the {@code y} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param ontoZ the {@code z} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 project(double ontoX, double ontoY, double ontoZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t8 = ontoX * this.x + ontoY * this.y + ontoZ * this.z;
        double _t9 = ontoX * ontoX + ontoY * ontoY + ontoZ * ontoZ;
        double _t9_inv = 1.0 / _t9;
        d.x = ontoX * _t8 * _t9_inv;
        d.y = ontoY * _t8 * _t9_inv;
        d.z = ontoZ * _t8 * _t9_inv;
        return d;
    }


    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 projectOnPlane(Double3R normal, @Mutated Double3 dest) {
        return projectOnPlane(normal.x(), normal.y(), normal.z(), dest);
    }


    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 projectOnPlane(double normalX, double normalY, double normalZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t4 = normalX * this.x + normalY * this.y + normalZ * this.z;
        d.x = this.x - normalX * _t4;
        d.y = this.y - normalY * _t4;
        d.z = this.z - normalZ * _t4;
        return d;
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 radians(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.toRadians(this.x);
        d.y = Math.toRadians(this.y);
        d.z = Math.toRadians(this.z);
        return d;
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 reflect(Double3R normal, @Mutated Double3 dest) {
        return reflect(normal.x(), normal.y(), normal.z(), dest);
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 reflect(double normalX, double normalY, double normalZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t5 = 2.0 * (normalX * this.x + normalY * this.y + normalZ * this.z);
        d.x = this.x - normalX * _t5;
        d.y = this.y - normalY * _t5;
        d.z = this.z - normalZ * _t5;
        return d;
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @param dest will hold the result
     * @return dest
     */
    public Double3 refract(Double3R normal, double eta, @Mutated Double3 dest) {
        return refract(normal.x(), normal.y(), normal.z(), eta, dest);
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
     *
     * @param normalX the {@code x} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalY the {@code y} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param normalZ the {@code z} component of the vector {@code (normalX, normalY, normalZ)} (the
     *        vector must have unit length)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @param dest will hold the result
     * @return dest
     */
    public Double3 refract(double normalX, double normalY, double normalZ, double eta, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t5 = normalX * this.x + normalY * this.y + normalZ * this.z;
        double _t10 = 1.0 - (1.0 - _t5 * _t5) * eta * eta;
        double _t13 = eta * _t5 + Math.sqrt(Math.max(0.0, _t10));
        if (_t10 >= 0.0) {
            d.x = eta * this.x - normalX * _t13;
            d.y = eta * this.y - normalY * _t13;
            d.z = eta * this.z - normalZ * _t13;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Compute the rounded value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 round(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.rint(this.x);
        d.y = Math.rint(this.y);
        d.z = Math.rint(this.z);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sign(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.signum(this.x);
        d.y = Math.signum(this.y);
        d.z = Math.signum(this.z);
        return d;
    }


    /**
     * Compute the sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sin(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.sin(this.x);
        d.y = Math.sin(this.y);
        d.z = Math.sin(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic sine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sinh(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.sinh(this.x);
        d.y = Math.sinh(this.y);
        d.z = Math.sinh(this.z);
        return d;
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param dest will hold the result
     * @return dest
     */
    public Double3 smoothstep(double edge0, double edge1, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = edge1 - edge0;
        double _t0_inv = 1.0 / _t0;
        double _t10 = Math.max(0.0, Math.min(1.0, (this.x - edge0) * _t0_inv));
        double _t11 = Math.max(0.0, Math.min(1.0, (this.y - edge0) * _t0_inv));
        double _t12 = Math.max(0.0, Math.min(1.0, (this.z - edge0) * _t0_inv));
        d.x = (3.0 - 2.0 * _t10) * _t10 * _t10;
        d.y = (3.0 - 2.0 * _t11) * _t11 * _t11;
        d.z = (3.0 - 2.0 * _t12) * _t12 * _t12;
        return d;
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param dest will hold the result
     * @return dest
     */
    public Double3 smoothstep(Double3R edge0, Double3R edge1, @Mutated Double3 dest) {
        return smoothstep(edge0.x(), edge0.y(), edge0.z(), edge1.x(), edge1.y(), edge1.z(), dest);
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}) and the upper edge
     * ({@code edge1X}, {@code edge1Y}, {@code edge1Z}), yielding 0 at or below the lower edge and 1
     * at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge0Z the {@code z} component of the vector {@code (edge0X, edge0Y, edge0Z)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param edge1Z the {@code z} component of the vector {@code (edge1X, edge1Y, edge1Z)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 smoothstep(double edge0X, double edge0Y, double edge0Z, double edge1X, double edge1Y, double edge1Z, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t12 = Math.max(0.0, Math.min(1.0, (this.x - edge0X) / (edge1X - edge0X)));
        double _t13 = Math.max(0.0, Math.min(1.0, (this.y - edge0Y) / (edge1Y - edge0Y)));
        double _t14 = Math.max(0.0, Math.min(1.0, (this.z - edge0Z) / (edge1Z - edge0Z)));
        d.x = (3.0 - 2.0 * _t12) * _t12 * _t12;
        d.y = (3.0 - 2.0 * _t13) * _t13 * _t13;
        d.z = (3.0 - 2.0 * _t14) * _t14 * _t14;
        return d;
    }


    /**
     * Compute the square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sqrt(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.sqrt(this.x);
        d.y = Math.sqrt(this.y);
        d.z = Math.sqrt(this.z);
        return d;
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    public Double3 step(double edge, @Mutated Double3 dest) {
        return step(edge, edge, edge, dest);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    public Double3 step(Double3R edge, @Mutated Double3 dest) {
        return step(edge.x(), edge.y(), edge.z(), dest);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edgeX the {@code x} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param edgeY the {@code y} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param edgeZ the {@code z} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 step(double edgeX, double edgeY, double edgeZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x < edgeX ? 0.0 : 1.0;
        d.y = this.y < edgeY ? 0.0 : 1.0;
        d.z = this.z < edgeZ ? 0.0 : 1.0;
        return d;
    }


    /**
     * Compute the tangent of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 tan(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.tan(this.x);
        d.y = Math.tan(this.y);
        d.z = Math.tan(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 tanh(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.tanh(this.x);
        d.y = Math.tanh(this.y);
        d.z = Math.tanh(this.z);
        return d;
    }


    /**
     * Compute the normal of the triangle spanned by this vector and the two given points and store
     * the result in {@code dest}.
     *
     * @param p1 the vector
     * @param p2 the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 triangleNormal(Double3R p1, Double3R p2, @Mutated Double3 dest) {
        return triangleNormal(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), dest);
    }


    /**
     * Compute the normal of the triangle spanned by this vector and the two given points and store
     * the result in {@code dest}.
     *
     * @param p1X the {@code x} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Y the {@code y} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p1Z the {@code z} component of the vector {@code (p1X, p1Y, p1Z)}
     * @param p2X the {@code x} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Y the {@code y} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param p2Z the {@code z} component of the vector {@code (p2X, p2Y, p2Z)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 triangleNormal(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = p1Y - this.y;
        double _t1 = p2Z - this.z;
        double _t2 = p1Z - this.z;
        double _t3 = p2Y - this.y;
        double _t4 = p2X - this.x;
        double _t5 = p1X - this.x;
        double _t12 = _t0 * _t1 - _t2 * _t3;
        double _t13 = _t2 * _t4 - _t5 * _t1;
        double _t14 = _t5 * _t3 - _t0 * _t4;
        double _t19 = _t12 * _t12 + _t13 * _t13 + _t14 * _t14;
        double _t20 = (1.0 / Math.sqrt(_t19));
        if (_t19 > 0.0) {
            d.x = _t12 * _t20;
            d.y = _t13 * _t20;
            d.z = _t14 * _t20;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Compute the truncated value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 trunc(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x >= 0.0 ? Math.floor(this.x) : Math.ceil(this.x);
        d.y = this.y >= 0.0 ? Math.floor(this.y) : Math.ceil(this.y);
        d.z = this.z >= 0.0 ? Math.floor(this.z) : Math.ceil(this.z);
        return d;
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 ulp(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = Math.ulp(this.x);
        d.y = Math.ulp(this.y);
        d.z = Math.ulp(this.z);
        return d;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 0} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 xyz0(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = 0.0;
        return d;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 xyz1(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = 1.0;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMul(Double3x3R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        double _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
        d.z = mat.m20() * this.x + mat.m21() * this.y + mat.m22() * this.z;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulDirection(Double3x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        double _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
        d.z = mat.m20() * this.x + mat.m21() * this.y + mat.m22() * this.z;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulDirection(Double4x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        double _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
        d.z = mat.m20() * this.x + mat.m21() * this.y + mat.m22() * this.z;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulPosition(Double3x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()));
        double _buf1 = mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()));
        d.z = mat.m20() * this.x + (mat.m21() * this.y + (mat.m22() * this.z + mat.m23()));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulPosition(Double4x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _buf0 = mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()));
        double _buf1 = mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()));
        d.z = mat.m20() * this.x + (mat.m21() * this.y + (mat.m22() * this.z + mat.m23()));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1},
     * then perform a perspective divide - i.e. compute {@code r = mat * (this, 1)} and return
     * {@code r.xyz / r.w} and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulProject(Double4x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t5 = mat.m30() * this.x + (mat.m31() * this.y + (mat.m32() * this.z + mat.m33()));
        double _t5_inv = 1.0 / _t5;
        double _buf0 = (mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()))) * _t5_inv;
        double _buf1 = (mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()))) * _t5_inv;
        d.z = (mat.m20() * this.x + (mat.m21() * this.y + (mat.m22() * this.z + mat.m23()))) * _t5_inv;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Rotate this vector by the quaternion {@code quat}, i.e. compute {@code q * this * q^-1} and
     * store the result in {@code dest}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotate(DoubleQuatR quat, @Mutated Double3 dest) {
        return rotate(quat.x(), quat.y(), quat.z(), quat.w(), dest);
    }


    /**
     * Rotate this vector by the quaternion ({@code quatX}, {@code quatY}, {@code quatZ},
     * {@code quatW}), i.e. compute {@code q * this * q^-1} and store the result in {@code dest}.
     *
     * @param quatX the {@code x} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatY the {@code y} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatZ the {@code z} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatW the {@code w} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotate(double quatX, double quatY, double quatZ, double quatW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (quatX * this.y - quatY * this.x);
        double _t10 = 2.0 * (quatY * this.z - quatZ * this.y);
        double _t11 = 2.0 * (quatZ * this.x - quatX * this.z);
        d.x = quatY * _t9 + (quatW * _t10 + this.x - quatZ * _t11);
        d.y = quatZ * _t10 + (quatW * _t11 + this.y - quatX * _t9);
        d.z = quatX * _t11 + (quatW * _t9 + this.z - quatY * _t10);
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis} and store the result
     * in {@code dest}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateAxis(double angle, Double3R axis, @Mutated Double3 dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) and store the result in {@code dest}.
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
    public Double3 rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t7 = axisX * this.x + axisY * this.y + axisZ * this.z;
        double _buf0 = this.x * _t0 + (axisY * this.z - axisZ * this.y) * _t1 + _t2 * axisX * _t7;
        double _buf1 = this.y * _t0 + (axisZ * this.x - axisX * this.z) * _t1 + _t2 * axisY * _t7;
        d.z = this.z * _t0 + (axisX * this.y - axisY * this.x) * _t1 + _t2 * axisZ * _t7;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateInverse(DoubleQuatR quat, @Mutated Double3 dest) {
        return rotateInverse(quat.x(), quat.y(), quat.z(), quat.w(), dest);
    }


    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     *
     * @param quatX the {@code x} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatY the {@code y} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatZ the {@code z} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatW the {@code w} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateInverse(double quatX, double quatY, double quatZ, double quatW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t9 = 2.0 * (quatX * this.z - quatZ * this.x);
        double _t10 = 2.0 * (quatZ * this.y - quatY * this.z);
        double _t11 = 2.0 * (quatY * this.x - quatX * this.y);
        d.x = quatZ * _t9 + (quatW * _t10 + this.x - quatY * _t11);
        d.y = quatX * _t11 + (quatW * _t9 + this.y - quatZ * _t10);
        d.z = quatY * _t10 + (quatW * _t11 + this.z - quatX * _t9);
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the X axis and store the result in
     * {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateX(double angle, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.x = this.x;
        double _buf0 = this.y * _t0 - this.z * _t1;
        d.z = this.y * _t1 + this.z * _t0;
        d.y = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the Y axis and store the result in
     * {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateY(double angle, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = this.x * _t0 + this.z * _t1;
        d.y = this.y;
        d.z = this.z * _t0 - this.x * _t1;
        d.x = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the Z axis and store the result in
     * {@code dest}.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateZ(double angle, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = this.x * _t0 - this.y * _t1;
        d.y = this.x * _t1 + this.y * _t0;
        d.z = this.z;
        d.x = _buf0;
        return d;
    }

    public double x() { return this.x; }
    public double y() { return this.y; }
    public double z() { return this.z; }

    public Double2 xx(@Mutated Double2 dest) {
        double _v0 = this.x;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Double2 xy(@Mutated Double2 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 xz(@Mutated Double2 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 yx(@Mutated Double2 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 yy(@Mutated Double2 dest) {
        double _v0 = this.y;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Double2 yz(@Mutated Double2 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 zx(@Mutated Double2 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 zy(@Mutated Double2 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 zz(@Mutated Double2 dest) {
        double _v0 = this.z;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Double3 xxx(@Mutated Double3 dest) {
        double _v0 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Double3 xxy(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 xxz(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 xyx(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 xyy(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 xyz(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 xzx(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 xzy(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 xzz(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 yxx(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 yxy(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 yxz(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 yyx(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 yyy(@Mutated Double3 dest) {
        double _v0 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Double3 yyz(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 yzx(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 yzy(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 yzz(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 zxx(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 zxy(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 zxz(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 zyx(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 zyy(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 zyz(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 zzx(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 zzy(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 zzz(@Mutated Double3 dest) {
        double _v0 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Double4 xxxx(@Mutated Double4 dest) {
        double _v0 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 xxxy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 xxxz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 xxyx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 xxyy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 xxyz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xxzx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 xxzy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xxzz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 xyxx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 xyxy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 xyxz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 xyyx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 xyyy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 xyyz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xyzx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 xyzy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 xyzz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 xzxx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 xzxy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 xzxz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 xzyx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 xzyy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 xzyz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 xzzx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 xzzy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xzzz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 yxxx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 yxxy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 yxxz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yxyx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 yxyy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 yxyz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 yxzx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 yxzy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 yxzz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 yyxx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 yyxy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 yyxz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yyyx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 yyyy(@Mutated Double4 dest) {
        double _v0 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 yyyz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 yyzx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yyzy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 yyzz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 yzxx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 yzxy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 yzxz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 yzyx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 yzyy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 yzyz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 yzzx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yzzy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 yzzz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 zxxx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 zxxy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zxxz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 zxyx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 zxyy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 zxyz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 zxzx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 zxzy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 zxzz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 zyxx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 zyxy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 zyxz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 zyyx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zyyy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 zyyz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 zyzx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 zyzy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 zyzz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 zzxx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 zzxy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zzxz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 zzyx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zzyy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 zzyz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 zzzx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 zzzy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 zzzz(@Mutated Double4 dest) {
        double _v0 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    @Override public String toString() {
        return "Double3(" + x() + ", " + y() + ", " + z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double3Impl)) return false;
        Double3Impl o = (Double3Impl) obj;
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

    @Override public boolean isFinite() {
        return Double.isFinite(x)
            && Double.isFinite(y)
            && Double.isFinite(z);
    }

    @Override public boolean equalsEpsilon(Double3R other, double epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        return dest;
    }
    public @Mutated Double3 load(double[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Double3 loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public Double3 loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public Double3 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public Double3 loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public Double3 load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.x;
        dest[offset + 1] = (float) this.y;
        dest[offset + 2] = (float) this.z;
        return dest;
    }
    public @Mutated Double3 load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Double3 loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public Double3 loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public Double3 storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public Double3 loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public Double3 loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
