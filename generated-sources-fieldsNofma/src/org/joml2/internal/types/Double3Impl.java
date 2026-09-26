// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
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

    public Double3Impl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double3Impl(Double3R src) {
        this.x = src.x();
        this.y = src.y();
        this.z = src.z();
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the vector to add
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
     * @param scalar the divisor
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(double scalar, @Mutated Double3 dest) {
        return div(scalar, scalar, scalar, dest);
    }


    /**
     * Divide this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the vector of per-component divisors
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
     * @param c the vector to add
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(double b, Double3R c, @Mutated Double3 dest) {
        return fma(b, c.x(), c.y(), c.z(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY},
     * {@code cZ}), i.e. compute {@code this * b + (cX, cY, cZ)} per component and store the result
     * in {@code dest}.
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
     * @param c the vector to add
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(Double3R b, Double3R c, @Mutated Double3 dest) {
        return fma(b.x(), b.y(), b.z(), c.x(), c.y(), c.z(), dest);
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * (bX, bY, bZ) + (cX, cY, cZ)}
     * per component and store the result in {@code dest}.
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
     * @param scalar the factor to multiply each component by
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(double scalar, @Mutated Double3 dest) {
        return mul(scalar, scalar, scalar, dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the vector of per-component factors
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
     * @param other the vector to subtract
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
     * Set this vector to the unit vector {@code (r cos(2 PI v), r sin(2 PI v), 2u - 1)} with
     * {@code r = 2 sqrt(u (1 - u))}: samples uniformly distributed in {@code [0, 1)} give a
     * direction uniformly distributed on the unit sphere ({@code makeRandomDirection} draws them
     * from a {@link java.util.Random}).
     *
     * @param u the sample that sets the height {@code z = 2u - 1}, uniformly distributed in
     *        {@code [0, 1)} for a uniformly distributed direction
     * @param v the fraction of a full turn about the z axis, counter-clockwise from the x axis,
     *        uniformly distributed in {@code [0, 1)} for a uniformly distributed direction
     * @return this
     */
    @Mutated public Double3 makeUniformDirection(double u, double v) {
        double _t1 = v * 6.283185307179586;
        double _t2 = Math.sin(_t1);
        double _t5 = 2.0 * Math.sqrt(u * (1.0 - u));
        this.x = _t5 * Math.cosFromSin(_t2, _t1);
        this.y = _t5 * _t2;
        this.z = u + u - 1.0;
        return this;
    }


    /**
     * Set this vector to the given values.
     *
     * @param v the vector to copy
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
     * @param s the value assigned to every component
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
                d.x = (byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x)));
                d.y = (byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y)));
                d.z = (byte) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z)));
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.x = (byte) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x));
                d.y = (byte) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y));
                d.z = (byte) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z));
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
                d.x = (short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x)));
                d.y = (short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y)));
                d.z = (short) (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z)));
            }
            case HALF_AWAY_FROM_ZERO -> {
                d.x = (short) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x));
                d.y = (short) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y));
                d.z = (short) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z));
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
                d.x = (int) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x));
                d.y = (int) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y));
                d.z = (int) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z));
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
                d.x = (long) (Math.abs(this.x - Math.rint(this.x)) == 0.5 ? this.x + Math.copySign(0.5, this.x) : Math.rint(this.x));
                d.y = (long) (Math.abs(this.y - Math.rint(this.y)) == 0.5 ? this.y + Math.copySign(0.5, this.y) : Math.rint(this.y));
                d.z = (long) (Math.abs(this.z - Math.rint(this.z)) == 0.5 ? this.z + Math.copySign(0.5, this.z) : Math.rint(this.z));
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
     * Interpolate along the cubic Bézier curve that starts at this vector, is shaped by the control
     * points {@code p1} and {@code p2} and ends at {@code p3} and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through {@code p3} at
     * {@code t = 1}; the control points {@code p1} and {@code p2} pull it towards themselves but
     * are generally not on the curve.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point of the curve
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return bezier(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Interpolate along the cubic Bézier curve that starts at this vector, is shaped by the control
     * points ({@code p1X}, {@code p1Y}, {@code p1Z}) and ({@code p2X}, {@code p2Y}, {@code p2Z})
     * and ends at ({@code p3X}, {@code p3Y}, {@code p3Z}) and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through ({@code p3X}, {@code p3Y},
     * {@code p3Z}) at {@code t = 1}; the control points ({@code p1X}, {@code p1Y}, {@code p1Z}) and
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) pull it towards themselves but are generally not on
     * the curve.
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
     * Interpolate along the quadratic Bézier curve that starts at this vector, is shaped by the
     * control point {@code p1} and ends at {@code p2} and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through {@code p2} at
     * {@code t = 1}; the control point {@code p1} pulls it towards itself but is generally not on
     * the curve.
     *
     * @param p1 the control point
     * @param p2 the end point of the curve
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2(Double3R p1, Double3R p2, double t, @Mutated Double3 dest) {
        return bezier2(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t, dest);
    }


    /**
     * Interpolate along the quadratic Bézier curve that starts at this vector, is shaped by the
     * control point ({@code p1X}, {@code p1Y}, {@code p1Z}) and ends at ({@code p2X}, {@code p2Y},
     * {@code p2Z}) and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through ({@code p2X}, {@code p2Y},
     * {@code p2Z}) at {@code t = 1}; the control point ({@code p1X}, {@code p1Y}, {@code p1Z})
     * pulls it towards itself but is generally not on the curve.
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
        double _t3 = (t + t) * _t0;
        double _t4 = _t0 * _t0;
        d.x = p1X * _t3 + this.x * _t4 + p2X * _t1;
        d.y = p1Y * _t3 + this.y * _t4 + p2Y * _t1;
        d.z = p1Z * _t3 + this.z * _t4 + p2Z * _t1;
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * quadratic Bézier curve that starts at this vector, is shaped by the control point {@code p1}
     * and ends at {@code p2} and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through {@code p2} at
     * {@code t = 1}; the control point {@code p1} pulls it towards itself but is generally not on
     * the curve.
     *
     * @param p1 the control point
     * @param p2 the end point of the curve
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2Tangent(Double3R p1, Double3R p2, double t, @Mutated Double3 dest) {
        return bezier2Tangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * quadratic Bézier curve that starts at this vector, is shaped by the control point
     * ({@code p1X}, {@code p1Y}, {@code p1Z}) and ends at ({@code p2X}, {@code p2Y}, {@code p2Z})
     * and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through ({@code p2X}, {@code p2Y},
     * {@code p2Z}) at {@code t = 1}; the control point ({@code p1X}, {@code p1Y}, {@code p1Z})
     * pulls it towards itself but is generally not on the curve.
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
        double _t1 = t + t;
        double _t2 = 2.0 * (1.0 - t);
        d.x = (p1X - this.x) * _t2 + (p2X - p1X) * _t1;
        d.y = (p1Y - this.y) * _t2 + (p2Y - p1Y) * _t1;
        d.z = (p1Z - this.z) * _t2 + (p2Z - p1Z) * _t1;
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * cubic Bézier curve that starts at this vector, is shaped by the control points {@code p1} and
     * {@code p2} and ends at {@code p3} and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through {@code p3} at
     * {@code t = 1}; the control points {@code p1} and {@code p2} pull it towards themselves but
     * are generally not on the curve.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point of the curve
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezierTangent(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return bezierTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * cubic Bézier curve that starts at this vector, is shaped by the control points ({@code p1X},
     * {@code p1Y}, {@code p1Z}) and ({@code p2X}, {@code p2Y}, {@code p2Z}) and ends at
     * ({@code p3X}, {@code p3Y}, {@code p3Z}) and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through ({@code p3X}, {@code p3Y},
     * {@code p3Z}) at {@code t = 1}; the control points ({@code p1X}, {@code p1Y}, {@code p1Z}) and
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) pull it towards themselves but are generally not on
     * the curve.
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
     * Interpolate along the Catmull-Rom spline segment from {@code p1} to {@code p2}, with this
     * vector as the control point before the segment and {@code p3} as the control point after it
     * and store the result in {@code dest}.
     * <p>
     * The curve passes through {@code p1} at {@code t = 0} and through {@code p2} at {@code t = 1}.
     * This vector and {@code p3} are the spline's neighbouring points, i.e. the point before
     * {@code p1} and the point after {@code p2}: they only shape the tangents at the segment's two
     * end points and are not themselves on the segment. For a spline through the points
     * {@code p[0..n]}, the segment from {@code p[i]} to {@code p[i+1]} is therefore interpolated
     * with {@code p[i-1]} in the role of this vector and {@code p[i]}, {@code p[i+1]},
     * {@code p[i+2]} as the three given points.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the control point after the segment, i.e. the spline point following {@code p2}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRom(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return catmullRom(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Interpolate along the Catmull-Rom spline segment from ({@code p1X}, {@code p1Y}, {@code p1Z})
     * to ({@code p2X}, {@code p2Y}, {@code p2Z}), with this vector as the control point before the
     * segment and ({@code p3X}, {@code p3Y}, {@code p3Z}) as the control point after it and store
     * the result in {@code dest}.
     * <p>
     * The curve passes through ({@code p1X}, {@code p1Y}, {@code p1Z}) at {@code t = 0} and through
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) at {@code t = 1}. This vector and ({@code p3X},
     * {@code p3Y}, {@code p3Z}) are the spline's neighbouring points, i.e. the point before
     * ({@code p1X}, {@code p1Y}, {@code p1Z}) and the point after ({@code p2X}, {@code p2Y},
     * {@code p2Z}): they only shape the tangents at the segment's two end points and are not
     * themselves on the segment. For a spline through the points {@code p[0..n]}, the segment from
     * {@code p[i]} to {@code p[i+1]} is therefore interpolated with {@code p[i-1]} in the role of
     * this vector and {@code p[i]}, {@code p[i+1]}, {@code p[i+2]} as the three given points.
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
        d.x = 0.5 * (p1X + p1X + t * (p2X - this.x) + ((-5.0 * p1X + (this.x + this.x + (4.0 * p2X - p3X))) * _t0 + (3.0 * p1X + (p3X - this.x) - 3.0 * p2X) * _t1));
        d.y = 0.5 * (p1Y + p1Y + t * (p2Y - this.y) + ((-5.0 * p1Y + (this.y + this.y + (4.0 * p2Y - p3Y))) * _t0 + (3.0 * p1Y + (p3Y - this.y) - 3.0 * p2Y) * _t1));
        d.z = 0.5 * (p1Z + p1Z + t * (p2Z - this.z) + ((-5.0 * p1Z + (this.z + this.z + (4.0 * p2Z - p3Z))) * _t0 + (3.0 * p1Z + (p3Z - this.z) - 3.0 * p2Z) * _t1));
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * Catmull-Rom spline segment from {@code p1} to {@code p2}, with this vector as the control
     * point before the segment and {@code p3} as the control point after it and store the result in
     * {@code dest}.
     * <p>
     * The curve passes through {@code p1} at {@code t = 0} and through {@code p2} at {@code t = 1}.
     * This vector and {@code p3} are the spline's neighbouring points, i.e. the point before
     * {@code p1} and the point after {@code p2}: they only shape the tangents at the segment's two
     * end points and are not themselves on the segment. For a spline through the points
     * {@code p[0..n]}, the segment from {@code p[i]} to {@code p[i+1]} is therefore interpolated
     * with {@code p[i-1]} in the role of this vector and {@code p[i]}, {@code p[i+1]},
     * {@code p[i+2]} as the three given points.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the control point after the segment, i.e. the spline point following {@code p2}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRomTangent(Double3R p1, Double3R p2, Double3R p3, double t, @Mutated Double3 dest) {
        return catmullRomTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * Catmull-Rom spline segment from ({@code p1X}, {@code p1Y}, {@code p1Z}) to ({@code p2X},
     * {@code p2Y}, {@code p2Z}), with this vector as the control point before the segment and
     * ({@code p3X}, {@code p3Y}, {@code p3Z}) as the control point after it and store the result in
     * {@code dest}.
     * <p>
     * The curve passes through ({@code p1X}, {@code p1Y}, {@code p1Z}) at {@code t = 0} and through
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) at {@code t = 1}. This vector and ({@code p3X},
     * {@code p3Y}, {@code p3Z}) are the spline's neighbouring points, i.e. the point before
     * ({@code p1X}, {@code p1Y}, {@code p1Z}) and the point after ({@code p2X}, {@code p2Y},
     * {@code p2Z}): they only shape the tangents at the segment's two end points and are not
     * themselves on the segment. For a spline through the points {@code p[0..n]}, the segment from
     * {@code p[i]} to {@code p[i+1]} is therefore interpolated with {@code p[i-1]} in the role of
     * this vector and {@code p[i]}, {@code p[i+1]}, {@code p[i+2]} as the three given points.
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
        double _sp0 = t + t;
        double _sp1 = 3.0 * t * t;
        d.x = 0.5 * (_sp0 * (-5.0 * p1X + (this.x + this.x + (4.0 * p2X - p3X))) + (_sp1 * (3.0 * p1X + (p3X - this.x) - 3.0 * p2X) + (p2X - this.x)));
        d.y = 0.5 * (_sp0 * (-5.0 * p1Y + (this.y + this.y + (4.0 * p2Y - p3Y))) + (_sp1 * (3.0 * p1Y + (p3Y - this.y) - 3.0 * p2Y) + (p2Y - this.y)));
        d.z = 0.5 * (_sp0 * (-5.0 * p1Z + (this.z + this.z + (4.0 * p2Z - p3Z))) + (_sp1 * (3.0 * p1Z + (p3Z - this.z) - 3.0 * p2Z) + (p2Z - this.z)));
        return d;
    }


    /**
     * Interpolate along the cubic Hermite curve that starts at this vector with the tangent
     * {@code t0} and ends at {@code v1} with the tangent {@code t1} and store the result in
     * {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through {@code v1} at
     * {@code t = 1}; the two tangents set its direction and speed at those end points.
     *
     * @param t0 the tangent at the start point, i.e. at this vector
     * @param v1 the end point of the curve
     * @param t1 the tangent at the end point {@code v1}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermite(Double3R t0, Double3R v1, Double3R t1, double t, @Mutated Double3 dest) {
        return hermite(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t, dest);
    }


    /**
     * Interpolate along the cubic Hermite curve that starts at this vector with the tangent
     * ({@code t0X}, {@code t0Y}, {@code t0Z}) and ends at ({@code v1X}, {@code v1Y}, {@code v1Z})
     * with the tangent ({@code t1X}, {@code t1Y}, {@code t1Z}) and store the result in
     * {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through ({@code v1X}, {@code v1Y},
     * {@code v1Z}) at {@code t = 1}; the two tangents set its direction and speed at those end
     * points.
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
        double _t5 = (t + t) * _t0;
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
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * cubic Hermite curve that starts at this vector with the tangent {@code t0} and ends at
     * {@code v1} with the tangent {@code t1} and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through {@code v1} at
     * {@code t = 1}; the two tangents set its direction and speed at those end points.
     *
     * @param t0 the tangent at the start point, i.e. at this vector
     * @param v1 the end point of the curve
     * @param t1 the tangent at the end point {@code v1}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermiteTangent(Double3R t0, Double3R v1, Double3R t1, double t, @Mutated Double3 dest) {
        return hermiteTangent(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) at the parameter {@code t} of the
     * cubic Hermite curve that starts at this vector with the tangent ({@code t0X}, {@code t0Y},
     * {@code t0Z}) and ends at ({@code v1X}, {@code v1Y}, {@code v1Z}) with the tangent
     * ({@code t1X}, {@code t1Y}, {@code t1Z}) and store the result in {@code dest}.
     * <p>
     * The curve passes through this vector at {@code t = 0} and through ({@code v1X}, {@code v1Y},
     * {@code v1Z}) at {@code t = 1}; the two tangents set its direction and speed at those end
     * points.
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
        double _t9 = _t4 - (t + t);
        double _t10 = _t4 + (1.0 - 4.0 * t);
        d.x = this.x * _t7 + t0X * _t10 + (t1X * _t9 + v1X * _t8);
        d.y = this.y * _t7 + t0Y * _t10 + (t1Y * _t9 + v1Y * _t8);
        d.z = this.z * _t7 + t0Z * _t10 + (t1Z * _t9 + v1Z * _t8);
        return d;
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The interpolation starts at this vector (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the vector to interpolate towards
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
     * <p>
     * The interpolation starts at this vector (interpolation factor {@code 0}) and ends at
     * ({@code otherX}, {@code otherY}, {@code otherZ}) (interpolation factor {@code 1}).
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
     * <p>
     * The interpolation starts at this vector (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the vector to interpolate towards
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
     * <p>
     * The interpolation starts at this vector (interpolation factor {@code 0}) and ends at
     * ({@code otherX}, {@code otherY}, {@code otherZ}) (interpolation factor {@code 1}).
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
     * Spherically interpolate between this vector and {@code other} using the interpolation factor
     * {@code t}: the direction turns at a constant rate along the shorter arc between the two
     * directions, and the length changes linearly between the two lengths and store the result in
     * {@code dest}.
     * <p>
     * For unit vectors this is the usual {@code slerp} of directions. A zero vector has no
     * direction, so the result is then the linear interpolation; for two vectors pointing in
     * opposite directions, whose arc lies in no particular plane, the direction turns through a
     * perpendicular of this vector. The angle is computed with {@code atan2}, and vectors of any
     * finite length are handled: when their squared lengths leave the {@code double} range, they
     * are first scaled exactly by powers of two.
     * <p>
     * The interpolation starts at this vector (interpolation factor {@code 0}) and ends at
     * {@code other} (interpolation factor {@code 1}).
     *
     * @param other the vector to interpolate towards
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 slerp(Double3R other, double t, @Mutated Double3 dest) {
        return slerp(other.x(), other.y(), other.z(), t, dest);
    }


    /**
     * Spherically interpolate between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}) using the interpolation factor {@code t}: the direction turns at a constant
     * rate along the shorter arc between the two directions, and the length changes linearly
     * between the two lengths and store the result in {@code dest}.
     * <p>
     * For unit vectors this is the usual {@code slerp} of directions. A zero vector has no
     * direction, so the result is then the linear interpolation; for two vectors pointing in
     * opposite directions, whose arc lies in no particular plane, the direction turns through a
     * perpendicular of this vector. The angle is computed with {@code atan2}, and vectors of any
     * finite length are handled: when their squared lengths leave the {@code double} range, they
     * are first scaled exactly by powers of two.
     * <p>
     * The interpolation starts at this vector (interpolation factor {@code 0}) and ends at
     * ({@code otherX}, {@code otherY}, {@code otherZ}) (interpolation factor {@code 1}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 slerp(double otherX, double otherY, double otherZ, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _ct0 = this.x * this.x + this.y * this.y + this.z * this.z;
        if (!(_ct0 > 2.2250738585072014E-308 && _ct0 < Double.POSITIVE_INFINITY)) return slerp_degenerate(otherX, otherY, otherZ, t, dest);
        double _t10 = _ct0;
        double _ct1 = otherX * otherX + otherY * otherY + otherZ * otherZ;
        if (!(_ct1 > 2.2250738585072014E-308 && _ct1 < Double.POSITIVE_INFINITY)) return slerp_degenerate(otherX, otherY, otherZ, t, dest);
        double _t11 = _ct1;
        double _t14 = Math.sqrt(_t10);
        double _t12 = 1.0 / _t14;
        double _t15 = (1.0 / Math.sqrt(_t11));
        double _t16 = this.x * _t12;
        double _t17 = otherX * _t15;
        double _t18 = otherY * _t15;
        double _t19 = this.y * _t12;
        double _t20 = otherZ * _t15;
        double _t21 = this.z * _t12;
        double _t27 = t * (Math.sqrt(_t11) - _t14) + _t14;
        double _t29 = _t17 * _t16 + _t18 * _t19 + _t20 * _t21;
        double _t33 = _t17 - _t29 * _t16;
        double _t34 = _t18 - _t29 * _t19;
        double _t35 = _t20 - _t29 * _t21;
        double _t40 = _t33 * _t16 + _t34 * _t19 + _t35 * _t21;
        double _t44 = _t33 - _t40 * _t16;
        double _t45 = _t34 - _t40 * _t19;
        double _t46 = _t35 - _t40 * _t21;
        double _ct2 = _t44 * _t44 + _t45 * _t45 + _t46 * _t46;
        if (!(_ct2 > 2.2250738585072014E-308 && _ct2 < Double.POSITIVE_INFINITY)) return slerp_degenerate(otherX, otherY, otherZ, t, dest);
        double _t52 = _ct2;
        double _t56 = t * Math.atan2(Math.sqrt(_t52), _t29);
        double _t57 = Math.sin(_t56);
        double _sp0 = _t27 * _t57 * (1.0 / Math.sqrt(_t52));
        double _t60 = _t27 * Math.cosFromSin(_t57, _t56);
        d.x = _t16 * _t60 + _sp0 * _t44;
        d.y = _t19 * _t60 + _sp0 * _t45;
        d.z = _t21 * _t60 + _sp0 * _t46;
        return d;
    }


    /**
     * Degenerate-input path of {@code slerp}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private Double3 slerp_degenerate(Double3R other, double t, @Mutated Double3 dest) {
        return slerp_degenerate(other.x(), other.y(), other.z(), t, dest);
    }

    /** Private store group 0 of {@code slerp_degenerate}: computes and stores it; reached only through it. */
    private void slerp_degenerate_s56f5a5dd_c0(Double3Impl _dst, double _t40, double _t94, double _t88, double _t90, double _t81, double _t67, double _t47, double _t96, double _t31, double t, double otherX, double _r0, double _t82, double _t50, double _t33, double otherY, double _r1, double _t83, double _t48, double _t35, double otherZ, double _r2) {
        _dst.x = _t40 > 0.0 ? _t94 * (_t88 > 0.0 ? _t90 * _t81 : _t67 * _t47) + _t96 * _t31 : t * (otherX - _r0) + _r0;
        _dst.y = _t40 > 0.0 ? _t94 * (_t88 > 0.0 ? _t90 * _t82 : _t67 * _t50) + _t96 * _t33 : t * (otherY - _r1) + _r1;
        _dst.z = _t40 > 0.0 ? _t94 * (_t88 > 0.0 ? _t90 * _t83 : _t67 * _t48) + _t96 * _t35 : t * (otherZ - _r2) + _r2;
    }

    /** Private tail of {@code slerp_degenerate}; reached only through it. */
    private void slerp_degenerate_s56f5a5dd_tail(Double3Impl _dst, double t, double _t22, double _t0, double _t29, double _t36, double _t37, double _t33, double _t31, double _t35, double _t30, double _t32, double _t34, double _t40, double otherX, double _r0, double otherY, double _r1, double otherZ, double _r2) {
        double _t46 = t * (Math.sqrt(_t22) / _t0 - _t29) + _t29;
        double _t47, _t48, _t50;
        if (_t36 < _t37) {
            _t47 = _t33;
            _t48 = 0.0;
            _t50 = -_t31;
        } else {
            _t47 = 0.0;
            _t48 = -_t33;
            _t50 = _t35;
        }
        double _t51 = _t30 * _t31 + _t32 * _t33 + _t34 * _t35;
        double _t57 = _t30 - _t51 * _t31;
        double _t58 = _t32 - _t51 * _t33;
        double _t59 = _t34 - _t51 * _t35;
        double _t67 = (1.0 / Math.sqrt(_t50 * _t50 + _t47 * _t47 + _t48 * _t48));
        double _t68 = _t57 * _t31 + _t58 * _t33 + _t59 * _t35;
        double _t72 = _t57 - _t68 * _t31;
        double _t73 = _t58 - _t68 * _t33;
        double _t74 = _t59 - _t68 * _t35;
        double _t75 = unitScale(_t72, _t73, _t74);
        slerp_degenerate_s56f5a5dd_tail2(_dst, _t72, _t75, _t73, _t74, t, _t51, _t46, _t40, _t67, _t47, _t31, otherX, _r0, _t50, _t33, otherY, _r1, _t48, _t35, otherZ, _r2);
    }

    /** Private tail of {@code slerp_degenerate}; reached only through it. */
    private void slerp_degenerate_s56f5a5dd_tail2(Double3Impl _dst, double _t72, double _t75, double _t73, double _t74, double t, double _t51, double _t46, double _t40, double _t67, double _t47, double _t31, double otherX, double _r0, double _t50, double _t33, double otherY, double _r1, double _t48, double _t35, double otherZ, double _r2) {
        double _t81 = _t72 * _t75;
        double _t82 = _t73 * _t75;
        double _t83 = _t74 * _t75;
        double _t88 = _t81 * _t81 + _t82 * _t82 + _t83 * _t83;
        double _t90 = (1.0 / Math.sqrt(_t88));
        double _t92 = t * Math.atan2(Math.sqrt(_t88), _t51 * _t75);
        double _t93 = Math.sin(_t92);
        double _t94 = _t46 * _t93;
        double _t96 = _t46 * Math.cosFromSin(_t93, _t92);
        slerp_degenerate_s56f5a5dd_c0(_dst, _t40, _t94, _t88, _t90, _t81, _t67, _t47, _t96, _t31, t, otherX, _r0, _t82, _t50, _t33, otherY, _r1, _t83, _t48, _t35, otherZ, _r2);
    }


    /**
     * Degenerate-input path of {@code slerp}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    private Double3 slerp_degenerate(double otherX, double otherY, double otherZ, double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _r0 = this.x;
        double _r1 = this.y;
        double _r2 = this.z;
        double _t0 = unitScale(otherX, otherY, otherZ);
        double _t1 = unitScale(_r0, _r1, _r2);
        double _t8 = otherX * _t0;
        double _t9 = otherY * _t0;
        double _t10 = otherZ * _t0;
        double _t11 = _r0 * _t1;
        double _t12 = _r1 * _t1;
        double _t13 = _r2 * _t1;
        double _t22 = _t8 * _t8 + _t9 * _t9 + _t10 * _t10;
        double _t23 = _t11 * _t11 + _t12 * _t12 + _t13 * _t13;
        double _t26 = (1.0 / Math.sqrt(_t22));
        double _t27 = (1.0 / Math.sqrt(_t23));
        double _t29 = Math.sqrt(_t23) / _t1;
        double _t30 = _t26 * _t8;
        double _t31 = _t27 * _t11;
        double _t32 = _t26 * _t9;
        double _t33 = _t27 * _t12;
        double _t34 = _t26 * _t10;
        double _t35 = _t27 * _t13;
        double _t36 = Math.abs(_t35);
        double _t37 = Math.abs(_t31);
        double _t40 = _t22 * _t23;
        slerp_degenerate_s56f5a5dd_tail(d, t, _t22, _t0, _t29, _t36, _t37, _t33, _t31, _t35, _t30, _t32, _t34, _t40, otherX, _r0, otherY, _r1, otherZ, _r2);
        return d;
    }


    /**
     * Degenerate-input path of {@code slerp}: its methods leave here when their input spans no
     * proper basis (a zero direction, an up vector parallel to it or zero, NaN); reached only
     * through them.
     */
    @Mutated private Double3 slerp_degenerate(double otherX, double otherY, double otherZ, double t) {
        return slerp_degenerate(otherX, otherY, otherZ, t, Joml.RETURN_NEW ? Joml.double3() : this);
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
     * @param b the vector to scale and add
     * @param scalar the factor to scale {@code b} by before adding
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
     * @param scalar the factor to scale ({@code bX}, {@code bY}, {@code bZ}) by before adding
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
     * @param b the vector to scale and add
     * @param c the per-component factors to scale {@code b} by before adding
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
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles). It holds for
     * vectors of any finite length: when the squared length of their cross product would leave the
     * {@code double} range, the vectors are first scaled exactly by powers of two.
     *
     * @param other the vector to measure the angle to
     * @return the angle in radians between this vector and {@code other}
     */
    public double angleBetween(Double3R other) {
        return angleBetween(other.x(), other.y(), other.z());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}).
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles). It holds for
     * vectors of any finite length: when the squared length of their cross product would leave the
     * {@code double} range, the vectors are first scaled exactly by powers of two.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public double angleBetween(double otherX, double otherY, double otherZ) {
        double _t6 = otherY * this.x - otherX * this.y;
        double _t7 = otherZ * this.x - otherX * this.z;
        double _t8 = otherZ * this.y - otherY * this.z;
        double _ct0 = _t6 * _t6 + _t7 * _t7 + _t8 * _t8;
        if (!(_ct0 > 2.2250738585072014E-308 && _ct0 < Double.POSITIVE_INFINITY)) return angleBetween_degenerate(otherX, otherY, otherZ);
        return Math.atan2(Math.sqrt(_ct0), otherX * this.x + otherY * this.y + otherZ * this.z);
    }


    /**
     * Out-of-range path of {@code angleBetween}: its methods leave here when the squared length of
     * the cross product they form is zero, NaN or outside the normal floating-point range; reached
     * only through them.
     */
    private double angleBetween_degenerate(Double3R other) {
        return angleBetween_degenerate(other.x(), other.y(), other.z());
    }


    /**
     * Out-of-range path of {@code angleBetween}: its methods leave here when the squared length of
     * the cross product they form is zero, NaN or outside the normal floating-point range; reached
     * only through them.
     */
    private double angleBetween_degenerate(double otherX, double otherY, double otherZ) {
        double _t0 = unitScale(otherX, otherY, otherZ);
        double _t1 = unitScale(this.x, this.y, this.z);
        double _t8 = otherY * _t0;
        double _t9 = this.x * _t1;
        double _t10 = otherX * _t0;
        double _t11 = this.y * _t1;
        double _t12 = otherZ * _t0;
        double _t13 = this.z * _t1;
        double _t20 = _t8 * _t9 - _t10 * _t11;
        double _t21 = _t12 * _t9 - _t10 * _t13;
        double _t22 = _t12 * _t11 - _t8 * _t13;
        double _t23 = unitScale(_t20, _t21, _t22);
        double _t27 = _t20 * _t23;
        double _t28 = _t21 * _t23;
        double _t29 = _t22 * _t23;
        return Math.atan2(Math.sqrt(_t27 * _t27 + _t28 * _t28 + _t29 * _t29), (_t10 * _t9 + _t8 * _t11 + _t12 * _t13) * _t23);
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
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator) and store the result in
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
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator) and store the result in {@code dest}.
     *
     * @param x the vector of denominators, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(Double3R x, @Mutated Double3 dest) {
        return atan2(x.x(), x.y(), x.z(), dest);
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code xX},
     * {@code xY}, {@code xZ}) (the denominator) and store the result in {@code dest}.
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
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
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
     * Compute the point on the line segment between {@code lineStart} and {@code lineEnd} that is
     * closest to this vector and store the result in {@code dest}.
     *
     * @param lineStart the start point of the line segment
     * @param lineEnd the end point of the line segment
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointOnLine(Double3R lineStart, Double3R lineEnd, @Mutated Double3 dest) {
        return closestPointOnLine(lineStart.x(), lineStart.y(), lineStart.z(), lineEnd.x(), lineEnd.y(), lineEnd.z(), dest);
    }


    /**
     * Compute the point on the line segment between ({@code lineStartX}, {@code lineStartY},
     * {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY}, {@code lineEndZ}) that is
     * closest to this vector and store the result in {@code dest}.
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
     * Compute the cross product of this vector and {@code other}, in that order
     * ({@code this x other}) and store the result in {@code dest}.
     *
     * @param other the right operand of the cross product
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cross(Double3R other, @Mutated Double3 dest) {
        return cross(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Compute the cross product of this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}), in that order ({@code this x (otherX, otherY, otherZ)}) and store the result
     * in {@code dest}.
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
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of the difference vector must lie
     * roughly between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
     *
     * @param other the vector to measure the distance to
     * @return the distance between this vector and {@code other}
     */
    public double distance(Double3R other) {
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
        double _t0 = this.x - otherX;
        double _t1 = this.y - otherY;
        double _t2 = this.z - otherZ;
        return Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2);
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the vector to measure the distance to
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
     * @param other the other operand of the dot product
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
     * @param I the incident direction
     * @param Nref the reference vector the incident direction is tested against
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
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(double y, @Mutated Double3 dest) {
        return hypot(y, y, y, dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y} and store the result in
     * {@code dest}.
     *
     * @param y the vector of other operands, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(Double3R y, @Mutated Double3 dest) {
        return hypot(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code yX}, {@code yY},
     * {@code yZ}) and store the result in {@code dest}.
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
     * <p>
     * The squared length is formed at {@code double} precision, so the result is exact only while
     * it stays within the {@code double} range: the magnitude of this vector must lie roughly
     * between {@code 1.5e-154} and {@code 1.3e154}. Rescale inputs outside that band first.
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
     * @param other the vector to measure the distance to
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
     * @param scalar the value to take the component-wise maximum with
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
     * @param other the vector to take the component-wise maximum with
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
     * @param scalar the value to take the component-wise minimum with
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
     * @param other the vector to take the component-wise minimum with
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
     * Compute the component-wise floored modulo of this vector divided by {@code y} ({@code x % y},
     * plus {@code y} when that remainder is non-zero and its sign differs from {@code y}'s -
     * exactly Kotlin's {@code mod}) and store the result in {@code dest}.
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
     * Compute the component-wise floored modulo of this vector divided by {@code y} ({@code x % y},
     * plus {@code y} when that remainder is non-zero and its sign differs from {@code y}'s -
     * exactly Kotlin's {@code mod}) and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the vector of divisors, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(Double3R y, @Mutated Double3 dest) {
        return mod(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise floored modulo of this vector divided by ({@code yX}, {@code yY},
     * {@code yZ}) ({@code x % y}, plus {@code y} when that remainder is non-zero and its sign
     * differs from {@code y}'s - exactly Kotlin's {@code mod}) and store the result in
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
        d.x = flooredMod(this.x, yX);
        d.y = flooredMod(this.y, yY);
        d.z = flooredMod(this.z, yZ);
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
     * Normalize this vector to unit length (the zero vector yields the zero vector) and store the
     * result in {@code dest}.
     * <p>
     * The squared length is formed at the component precision, so components whose squares overflow
     * or underflow that precision are out of domain: the result is the zero vector rather than a
     * unit vector. Rescale such inputs before normalizing (the magnitude must lie roughly between
     * 1e-19 and 1.8e19 for {@code float}, 1.5e-154 and 1.3e154 for {@code double}).
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalize(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        double _t5 = (1.0 / Math.sqrt(_t4));
        if (_t4 != 0.0) {
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
        if (_t4 != 0.0) {
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
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles). It holds for
     * vectors of any finite length: when the squared length of their cross product would leave the
     * {@code double} range, the vectors are first scaled exactly by powers of two.
     *
     * @param other the vector to measure the signed angle to
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
     * <p>
     * The angle is computed with {@code atan2}, so it keeps full {@code double} resolution all the
     * way down to 0 (an {@code acos}-based form loses precision for small angles). It holds for
     * vectors of any finite length: when the squared length of their cross product would leave the
     * {@code double} range, the vectors are first scaled exactly by powers of two.
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
        double _t9 = otherZ * this.y - otherY * this.z;
        double _t10 = otherX * this.z - otherZ * this.x;
        double _t11 = otherY * this.x - otherX * this.y;
        double _ct0 = _t10 * _t10 + _t9 * _t9 + _t11 * _t11;
        if (!(_ct0 > 2.2250738585072014E-308 && _ct0 < Double.POSITIVE_INFINITY)) return orientedAngle_degenerate(otherX, otherY, otherZ, normalX, normalY, normalZ);
        double _t21 = Math.atan2(Math.sqrt(_ct0), otherX * this.x + otherY * this.y + otherZ * this.z);
        return normalX * _t9 + normalY * _t10 + normalZ * _t11 < 0.0 ? -_t21 : _t21;
    }


    /**
     * Out-of-range path of {@code orientedAngle}: its methods leave here when the squared length of
     * the cross product they form is zero, NaN or outside the normal floating-point range; reached
     * only through them.
     */
    private double orientedAngle_degenerate(Double3R other, Double3R normal) {
        return orientedAngle_degenerate(other.x(), other.y(), other.z(), normal.x(), normal.y(), normal.z());
    }

    /** Private tail of {@code orientedAngle_degenerate}; reached only through it. */
    private double orientedAngle_degenerate_s1c8ffe1d_tail(double _t24, double _t25, double _t26, double _t13, double _t14, double _t11, double _t10, double _t9, double _t12, double normalX, double _t0, double normalY, double normalZ) {
        double _t29 = unitScale(_t24, _t25, _t26);
        double _t33 = _t24 * _t29;
        double _t34 = _t25 * _t29;
        double _t35 = _t26 * _t29;
        double _t44 = Math.atan2(Math.sqrt(_t34 * _t34 + _t33 * _t33 + _t35 * _t35), (_t13 * _t14 + _t11 * _t10 + _t9 * _t12) * _t29);
        return normalX * _t0 * _t33 + normalY * _t0 * _t34 + normalZ * _t0 * _t35 < 0.0 ? -_t44 : _t44;
    }


    /**
     * Out-of-range path of {@code orientedAngle}: its methods leave here when the squared length of
     * the cross product they form is zero, NaN or outside the normal floating-point range; reached
     * only through them.
     */
    private double orientedAngle_degenerate(double otherX, double otherY, double otherZ, double normalX, double normalY, double normalZ) {
        double _t0 = unitScale(normalX, normalY, normalZ);
        double _t1 = unitScale(otherX, otherY, otherZ);
        double _t2 = unitScale(this.x, this.y, this.z);
        double _t9 = otherZ * _t1;
        double _t10 = this.y * _t2;
        double _t11 = otherY * _t1;
        double _t12 = this.z * _t2;
        double _t13 = otherX * _t1;
        double _t14 = this.x * _t2;
        double _t24 = _t9 * _t10 - _t11 * _t12;
        double _t25 = _t13 * _t12 - _t9 * _t14;
        double _t26 = _t11 * _t14 - _t13 * _t10;
        return orientedAngle_degenerate_s1c8ffe1d_tail(_t24, _t25, _t26, _t13, _t14, _t11, _t10, _t9, _t12, normalX, _t0, normalY, normalZ);
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
     * Compute a vector perpendicular to this vector and store the result in {@code dest}.
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
        double _sp0 = (ontoX * this.x + ontoY * this.y + ontoZ * this.z) / (ontoX * ontoX + ontoY * ontoY + ontoZ * ontoZ);
        d.x = ontoX * _sp0;
        d.y = ontoY * _sp0;
        d.z = ontoZ * _sp0;
        return d;
    }


    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     *
     * @param normal the normal of the plane to project onto (must be a unit vector)
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
     * @param normal the normal of the plane to reflect about (must be a unit vector)
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
     * <p>
     * As in GLSL, the normal must face against this vector ({@code dot(this, normal) <= 0}): a
     * normal on the far side of the surface bends the vector the wrong way, and with a ratio of 1
     * it comes back reversed. Negate the normal for a vector leaving through the surface.
     *
     * @param normal the normal of the refracting surface (must be a unit vector)
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
     * <p>
     * As in GLSL, the normal must face against this vector ({@code dot(this, normal) <= 0}): a
     * normal on the far side of the surface bends the vector the wrong way, and with a ratio of 1
     * it comes back reversed. Negate the normal for a vector leaving through the surface.
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
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector and store the result in {@code dest}.
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
        d.x = (3.0 - (_t10 + _t10)) * _t10 * _t10;
        d.y = (3.0 - (_t11 + _t11)) * _t11 * _t11;
        d.z = (3.0 - (_t12 + _t12)) * _t12 * _t12;
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
        d.x = (3.0 - (_t12 + _t12)) * _t12 * _t12;
        d.y = (3.0 - (_t13 + _t13)) * _t13 * _t13;
        d.z = (3.0 - (_t14 + _t14)) * _t14 * _t14;
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
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize((p1 - this) x (p2 - this))} - it points to the side from which the vertices
     * {@code this}, {@code p1}, {@code p2} appear counter-clockwise (a degenerate triangle yields
     * the zero vector) and store the result in {@code dest}.
     * <p>
     * It holds for triangles of any finite size and shape: when the squared length of the edges'
     * cross product would leave the {@code double} range, the edges are first scaled exactly by
     * powers of two.
     *
     * @param p1 the second vertex of the triangle (this vector is the first)
     * @param p2 the third vertex of the triangle
     * @param dest will hold the result
     * @return dest
     */
    public Double3 triangleNormal(Double3R p1, Double3R p2, @Mutated Double3 dest) {
        return triangleNormal(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), dest);
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize(((p1X, p1Y, p1Z) - this) x ((p2X, p2Y, p2Z) - this))} - it points to the
     * side from which the vertices {@code this}, ({@code p1X}, {@code p1Y}, {@code p1Z}),
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) appear counter-clockwise (a degenerate triangle
     * yields the zero vector) and store the result in {@code dest}.
     * <p>
     * It holds for triangles of any finite size and shape: when the squared length of the edges'
     * cross product would leave the {@code double} range, the edges are first scaled exactly by
     * powers of two.
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
        double _ct0 = _t12 * _t12 + _t13 * _t13 + _t14 * _t14;
        if (!(_ct0 > 2.2250738585072014E-308 && _ct0 < Double.POSITIVE_INFINITY)) return triangleNormal_degenerate(p1X, p1Y, p1Z, p2X, p2Y, p2Z, dest);
        double _t21 = (1.0 / Math.sqrt(_ct0));
        d.x = _t12 * _t21;
        d.y = _t13 * _t21;
        d.z = _t14 * _t21;
        return d;
    }


    /**
     * Out-of-range path of {@code triangleNormal}: its methods leave here when the squared length
     * of the cross product they form is zero, NaN or outside the normal floating-point range;
     * reached only through them.
     */
    private Double3 triangleNormal_degenerate(Double3R p1, Double3R p2, @Mutated Double3 dest) {
        return triangleNormal_degenerate(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), dest);
    }


    /**
     * Out-of-range path of {@code triangleNormal}: its methods leave here when the squared length
     * of the cross product they form is zero, NaN or outside the normal floating-point range;
     * reached only through them.
     */
    private Double3 triangleNormal_degenerate(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = p1Y - this.y;
        double _t1 = p1X - this.x;
        double _t2 = p1Z - this.z;
        double _t3 = p2Z - this.z;
        double _t4 = p2X - this.x;
        double _t5 = p2Y - this.y;
        double _t6 = unitScale(_t1, _t0, _t2);
        double _t7 = unitScale(_t4, _t5, _t3);
        double _t14 = _t0 * _t6;
        double _t15 = _t3 * _t7;
        double _t16 = _t2 * _t6;
        double _t17 = _t5 * _t7;
        double _t18 = _t4 * _t7;
        double _t19 = _t1 * _t6;
        double _t26 = _t14 * _t15 - _t16 * _t17;
        double _t27 = _t16 * _t18 - _t19 * _t15;
        double _t28 = _t19 * _t17 - _t14 * _t18;
        double _t29 = unitScale(_t26, _t27, _t28);
        double _t33 = _t26 * _t29;
        double _t34 = _t27 * _t29;
        double _t35 = _t28 * _t29;
        double _t40 = _t33 * _t33 + _t34 * _t34 + _t35 * _t35;
        double _t41 = (1.0 / Math.sqrt(_t40));
        if (_t40 != 0.0) {
            d.x = _t41 * _t33;
            d.y = _t41 * _t34;
            d.z = _t41 * _t35;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
        }
        return d;
    }


    /**
     * Out-of-range path of {@code triangleNormal}: its methods leave here when the squared length
     * of the cross product they form is zero, NaN or outside the normal floating-point range;
     * reached only through them.
     */
    @Mutated private Double3 triangleNormal_degenerate(double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z) {
        return triangleNormal_degenerate(p1X, p1Y, p1Z, p2X, p2Y, p2Z, Joml.RETURN_NEW ? Joml.double3() : this);
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
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this} and store the
     * result in {@code dest}.
     *
     * @param mat the matrix to apply
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
     * @param mat the matrix to apply
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
     * @param mat the matrix to apply
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
     * @param mat the matrix to apply
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
     * @param mat the matrix to apply
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
     * @param mat the matrix to apply
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
     * @param quat the rotation to apply (must be a unit quaternion)
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
     * Rotate this vector by the quaternion {@code quat} about the point {@code pivot}, i.e. compute
     * {@code p + q * (this - p) * q^-1} for the point {@code p} and store the result in
     * {@code dest}.
     *
     * @param quat the rotation to apply (must be a unit quaternion)
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateAround(DoubleQuatR quat, Double3R pivot, @Mutated Double3 dest) {
        return rotateAround(quat.x(), quat.y(), quat.z(), quat.w(), pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Rotate this vector by the quaternion ({@code quatX}, {@code quatY}, {@code quatZ},
     * {@code quatW}) about the point ({@code pivotX}, {@code pivotY}, {@code pivotZ}), i.e. compute
     * {@code p + q * (this - p) * q^-1} for the point {@code p} and store the result in
     * {@code dest}.
     *
     * @param quatX the {@code x} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatY the {@code y} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatZ the {@code z} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param quatW the {@code w} component of the quaternion {@code (quatX, quatY, quatZ, quatW)}
     *        (the quaternion must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateAround(double quatX, double quatY, double quatZ, double quatW, double pivotX, double pivotY, double pivotZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.y - pivotY;
        double _t1 = this.x - pivotX;
        double _t2 = this.z - pivotZ;
        double _t12 = 2.0 * (quatX * _t0 - quatY * _t1);
        double _t13 = 2.0 * (quatY * _t2 - quatZ * _t0);
        double _t14 = 2.0 * (quatZ * _t1 - quatX * _t2);
        d.x = quatY * _t12 + (quatW * _t13 + (pivotX + this.x - pivotX) - quatZ * _t14);
        d.y = quatZ * _t13 + (quatW * _t14 + (pivotY + this.y - pivotY) - quatX * _t12);
        d.z = quatX * _t14 + (quatW * _t12 + (pivotZ + this.z - pivotZ) - quatY * _t13);
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
        if (axisY == 0 && axisZ == 0 && Math.abs(axisX) == 1) return rotateX(axisX * angle, dest);
        if (axisX == 0 && axisZ == 0 && Math.abs(axisY) == 1) return rotateY(axisY * angle, dest);
        if (axisX == 0 && axisY == 0 && Math.abs(axisZ) == 1) return rotateZ(axisZ * angle, dest);
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _sp0 = (1.0 - _t1) * (axisX * this.x + axisY * this.y + axisZ * this.z);
        double _buf0 = this.x * _t1 + (axisY * this.z - axisZ * this.y) * _t0 + _sp0 * axisX;
        double _buf1 = this.y * _t1 + (axisZ * this.x - axisX * this.z) * _t0 + _sp0 * axisY;
        d.z = this.z * _t1 + (axisX * this.y - axisY * this.x) * _t0 + _sp0 * axisZ;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis} through the point
     * {@code pivot} and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateAxisAround(double angle, Double3R axis, Double3R pivot, @Mutated Double3 dest) {
        return rotateAxisAround(angle, axis.x(), axis.y(), axis.z(), pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) through the point ({@code pivotX}, {@code pivotY}, {@code pivotZ}) and store
     * the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param axisX the {@code x} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisY the {@code y} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param axisZ the {@code z} component of the rotation axis {@code (axisX, axisY, axisZ)} (the
     *        vector must have unit length)
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateAxisAround(double angle, double axisX, double axisY, double axisZ, double pivotX, double pivotY, double pivotZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = this.x - pivotX;
        double _t3 = this.z - pivotZ;
        double _t4 = this.y - pivotY;
        double _sp0 = (1.0 - _t1) * (axisX * _t2 + axisY * _t4 + axisZ * _t3);
        d.x = _t2 * _t1 + ((axisY * _t3 - axisZ * _t4) * _t0 + (_sp0 * axisX + pivotX));
        d.y = _t4 * _t1 + ((axisZ * _t2 - axisX * _t3) * _t0 + (_sp0 * axisY + pivotY));
        d.z = _t3 * _t1 + ((axisX * _t4 - axisY * _t2) * _t0 + (_sp0 * axisZ + pivotZ));
        return d;
    }


    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     *
     * @param quat the rotation whose inverse to apply (must be a unit quaternion)
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
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        d.x = this.x;
        double _buf0 = this.y * _t1 - this.z * _t0;
        d.z = this.y * _t0 + this.z * _t1;
        d.y = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the X axis through the point {@code pivot}
     * and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateXAround(double angle, Double3R pivot, @Mutated Double3 dest) {
        return rotateXAround(angle, pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Rotate this vector by {@code angle} radians about the X axis through the point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateXAround(double angle, double pivotX, double pivotY, double pivotZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = this.y - pivotY;
        double _t3 = this.z - pivotZ;
        d.x = pivotX + (this.x - pivotX);
        d.y = _t2 * _t1 + (pivotY - _t3 * _t0);
        d.z = _t2 * _t0 + (_t3 * _t1 + pivotZ);
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
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _buf0 = this.x * _t1 + this.z * _t0;
        d.y = this.y;
        d.z = this.z * _t1 - this.x * _t0;
        d.x = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the Y axis through the point {@code pivot}
     * and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateYAround(double angle, Double3R pivot, @Mutated Double3 dest) {
        return rotateYAround(angle, pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Rotate this vector by {@code angle} radians about the Y axis through the point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateYAround(double angle, double pivotX, double pivotY, double pivotZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = this.x - pivotX;
        double _t3 = this.z - pivotZ;
        d.x = _t2 * _t1 + (_t3 * _t0 + pivotX);
        d.y = pivotY + (this.y - pivotY);
        d.z = _t3 * _t1 + (pivotZ - _t2 * _t0);
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
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _buf0 = this.x * _t1 - this.y * _t0;
        d.y = this.x * _t0 + this.y * _t1;
        d.z = this.z;
        d.x = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the Z axis through the point {@code pivot}
     * and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param pivot the pivot point
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateZAround(double angle, Double3R pivot, @Mutated Double3 dest) {
        return rotateZAround(angle, pivot.x(), pivot.y(), pivot.z(), dest);
    }


    /**
     * Rotate this vector by {@code angle} radians about the Z axis through the point
     * ({@code pivotX}, {@code pivotY}, {@code pivotZ}) and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param pivotX the {@code x} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotY the {@code y} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param pivotZ the {@code z} component of the vector {@code (pivotX, pivotY, pivotZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateZAround(double angle, double pivotX, double pivotY, double pivotZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = this.x - pivotX;
        double _t3 = this.y - pivotY;
        d.x = _t2 * _t1 + (pivotX - _t3 * _t0);
        d.y = _t2 * _t0 + (_t3 * _t1 + pivotY);
        d.z = pivotZ + (this.z - pivotZ);
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

    /**
     * The power of two that brings max(|a|, |b|, |c|) into [1, 2), from the largest exponent
     * field: multiplying by it is exact. Clamped to [2^-126, 2^126], so zero and subnormal
     * values scale up without overflow and the largest floats land in [2, 4).
     */
    private static float unitScale(float a, float b, float c) {
        int e = java.lang.Math.max(java.lang.Math.max(Float.floatToRawIntBits(a) & 0x7F800000,
                Float.floatToRawIntBits(b) & 0x7F800000), Float.floatToRawIntBits(c) & 0x7F800000);
        return Float.intBitsToFloat(0x7F000000 - java.lang.Math.min(java.lang.Math.max(e, 0x00800000), 0x7E800000));
    }

    /** Double-precision twin of {@link #unitScale(float, float, float)}. */
    private static double unitScale(double a, double b, double c) {
        long e = java.lang.Math.max(java.lang.Math.max(Double.doubleToRawLongBits(a) & 0x7FF0000000000000L,
                Double.doubleToRawLongBits(b) & 0x7FF0000000000000L), Double.doubleToRawLongBits(c) & 0x7FF0000000000000L);
        return Double.longBitsToDouble(0x7FE0000000000000L
                - java.lang.Math.min(java.lang.Math.max(e, 0x0010000000000000L), 0x7FD0000000000000L));
    }

    /**
     * The floored remainder of x and y, exactly kotlin.Float.mod: q = floor(x / y) is off by
     * at most one (too large) while it fits the mantissa, so x - y * q with one correction is
     * the floored remainder; % (a runtime call) only when it does not fit or y is infinite.
     */
    private static float flooredMod(float x, float y) {
        float q = (float) Math.floor(x / y);
        if (java.lang.Math.abs(q) < 0x1p24f && java.lang.Math.abs(y) <= Float.MAX_VALUE) {
            float r = x - y * q;
            return r * java.lang.Math.signum(y) < 0 ? x - y * (q - 1.0f) : r;
        }
        float r = x % y;
        return r * java.lang.Math.signum(y) < 0 ? r + y : r;
    }

    /** Double-precision twin of {@link #flooredMod(float, float)}. */
    private static double flooredMod(double x, double y) {
        double q = Math.floor(x / y);
        if (java.lang.Math.abs(q) < 0x1p53 && java.lang.Math.abs(y) <= Double.MAX_VALUE) {
            double r = x - y * q;
            return r * java.lang.Math.signum(y) < 0 ? x - y * (q - 1.0) : r;
        }
        double r = x % y;
        return r * java.lang.Math.signum(y) < 0 ? r + y : r;
    }
}
