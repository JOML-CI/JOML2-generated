package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

/**
 * Generated implementation of {@link Double4} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class Double4Impl implements Double4 {

    public double x;
    public double y;
    public double z;
    public double w;
    static final Double4BbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double4BbOpsUnsafe()
                    : new Double4BbOpsApi();
    static final Double4RawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new Double4RawOpsUnsafe()
                    : new Double4RawOpsApi();

    public Double4Impl() {
        w = 1;
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 add(Double4R other, @Mutated Double4 dest) {
        return add(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) to this vector and store
     * the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 add(double otherX, double otherY, double otherZ, double otherW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        d.z = otherZ + this.z;
        d.w = otherW + this.w;
        return d;
    }


    /**
     * Divide each component of this vector by {@code scalar} and store the result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double4 div(double scalar, @Mutated Double4 dest) {
        return div(scalar, scalar, scalar, scalar, dest);
    }


    /**
     * Divide this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 div(Double4R other, @Mutated Double4 dest) {
        return div(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 div(double otherX, double otherY, double otherZ, double otherW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x / otherX;
        d.y = this.y / otherY;
        d.z = this.z / otherZ;
        d.w = this.w / otherW;
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
    public Double4 fma(double b, Double4R c, @Mutated Double4 dest) {
        return fma(b, c.x(), c.y(), c.z(), c.w(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY}, {@code cZ},
     * {@code cW}), i.e. compute {@code this * b + c} per component and store the result in
     * {@code dest}.
     *
     * @param b the factor to multiply this vector by
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cW the {@code w} component of the vector {@code (cX, cY, cZ, cW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 fma(double b, double cX, double cY, double cZ, double cW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(this.x, b, cX);
        d.y = Math.fma(this.y, b, cY);
        d.z = Math.fma(this.z, b, cZ);
        d.w = Math.fma(this.w, b, cW);
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
    public Double4 fma(Double4R b, Double4R c, @Mutated Double4 dest) {
        return fma(b.x(), b.y(), b.z(), b.w(), c.x(), c.y(), c.z(), c.w(), dest);
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}, {@code bW}) and
     * add ({@code cX}, {@code cY}, {@code cZ}, {@code cW}), i.e. compute {@code this * b + c} per
     * component and store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bW the {@code w} component of the vector {@code (bX, bY, bZ, bW)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cW the {@code w} component of the vector {@code (cX, cY, cZ, cW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 fma(double bX, double bY, double bZ, double bW, double cX, double cY, double cZ, double cW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(this.x, bX, cX);
        d.y = Math.fma(this.y, bY, cY);
        d.z = Math.fma(this.z, bZ, cZ);
        d.w = Math.fma(this.w, bW, cW);
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
    public Double4 mul(double scalar, @Mutated Double4 dest) {
        return mul(scalar, scalar, scalar, scalar, dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mul(Double4R other, @Mutated Double4 dest) {
        return mul(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mul(double otherX, double otherY, double otherZ, double otherW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = otherX * this.x;
        d.y = otherY * this.y;
        d.z = otherZ * this.z;
        d.w = otherW * this.w;
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 negate(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        d.w = -this.w;
        return d;
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 sub(Double4R other, @Mutated Double4 dest) {
        return sub(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) from this vector
     * and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 sub(double otherX, double otherY, double otherZ, double otherW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        d.z = this.z - otherZ;
        d.w = this.w - otherW;
        return d;
    }


    /**
     * Set this vector to the given values.
     *
     * @param v the vector
     * @return this
     */
    public @Mutated Double4 set(Double4R v) {
        return set(v.x(), v.y(), v.z(), v.w());
    }


    /**
     * Set this vector to the given values.
     *
     * @param vX the {@code x} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vY the {@code y} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vZ the {@code z} component of the vector {@code (vX, vY, vZ, vW)}
     * @param vW the {@code w} component of the vector {@code (vX, vY, vZ, vW)}
     * @return this
     */
    @Mutated public Double4 set(double vX, double vY, double vZ, double vW) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.w = vW;
        return this;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double4 set(double s, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = s;
        d.y = s;
        d.z = s;
        d.w = s;
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
    public Float4 toFloat(@Mutated Float4 dest) {
        Float4Impl d = (Float4Impl) dest;
        d.x = (float) (this.x);
        d.y = (float) (this.y);
        d.z = (float) (this.z);
        d.w = (float) (this.w);
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
    public Byte4 toByte(@Mutated Byte4 dest) {
        Byte4Impl d = (Byte4Impl) dest;
        d.x = (byte) (this.x);
        d.y = (byte) (this.y);
        d.z = (byte) (this.z);
        d.w = (byte) (this.w);
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
    public Byte4 toByte(RoundingMode roundingMode, @Mutated Byte4 dest) {
        Byte4Impl d = (Byte4Impl) dest;
        switch (roundingMode) {
            case TRUNCATE: return toByte(dest);
            case FLOOR: {
                d.x = (byte) Math.floor(this.x);
                d.y = (byte) Math.floor(this.y);
                d.z = (byte) Math.floor(this.z);
                d.w = (byte) Math.floor(this.w);
            } break;
            case CEILING: {
                d.x = (byte) Math.ceil(this.x);
                d.y = (byte) Math.ceil(this.y);
                d.z = (byte) Math.ceil(this.z);
                d.w = (byte) Math.ceil(this.w);
            } break;
            case HALF_TOWARD_POSITIVE_INFINITY: {
                d.x = (byte) Math.round(this.x);
                d.y = (byte) Math.round(this.y);
                d.z = (byte) Math.round(this.z);
                d.w = (byte) Math.round(this.w);
            } break;
            case HALF_AWAY_FROM_ZERO: {
                d.x = (byte) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (byte) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (byte) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
                d.w = (byte) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5));
            } break;
            case HALF_EVEN: {
                d.x = (byte) Math.rint(this.x);
                d.y = (byte) Math.rint(this.y);
                d.z = (byte) Math.rint(this.z);
                d.w = (byte) Math.rint(this.w);
            } break;
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
    public Short4 toShort(@Mutated Short4 dest) {
        Short4Impl d = (Short4Impl) dest;
        d.x = (short) (this.x);
        d.y = (short) (this.y);
        d.z = (short) (this.z);
        d.w = (short) (this.w);
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
    public Short4 toShort(RoundingMode roundingMode, @Mutated Short4 dest) {
        Short4Impl d = (Short4Impl) dest;
        switch (roundingMode) {
            case TRUNCATE: return toShort(dest);
            case FLOOR: {
                d.x = (short) Math.floor(this.x);
                d.y = (short) Math.floor(this.y);
                d.z = (short) Math.floor(this.z);
                d.w = (short) Math.floor(this.w);
            } break;
            case CEILING: {
                d.x = (short) Math.ceil(this.x);
                d.y = (short) Math.ceil(this.y);
                d.z = (short) Math.ceil(this.z);
                d.w = (short) Math.ceil(this.w);
            } break;
            case HALF_TOWARD_POSITIVE_INFINITY: {
                d.x = (short) Math.round(this.x);
                d.y = (short) Math.round(this.y);
                d.z = (short) Math.round(this.z);
                d.w = (short) Math.round(this.w);
            } break;
            case HALF_AWAY_FROM_ZERO: {
                d.x = (short) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (short) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (short) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
                d.w = (short) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5));
            } break;
            case HALF_EVEN: {
                d.x = (short) Math.rint(this.x);
                d.y = (short) Math.rint(this.y);
                d.z = (short) Math.rint(this.z);
                d.w = (short) Math.rint(this.w);
            } break;
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
    public Int4 toInt(@Mutated Int4 dest) {
        Int4Impl d = (Int4Impl) dest;
        d.x = (int) (this.x);
        d.y = (int) (this.y);
        d.z = (int) (this.z);
        d.w = (int) (this.w);
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
    public Int4 toInt(RoundingMode roundingMode, @Mutated Int4 dest) {
        Int4Impl d = (Int4Impl) dest;
        switch (roundingMode) {
            case TRUNCATE: return toInt(dest);
            case FLOOR: {
                d.x = (int) Math.floor(this.x);
                d.y = (int) Math.floor(this.y);
                d.z = (int) Math.floor(this.z);
                d.w = (int) Math.floor(this.w);
            } break;
            case CEILING: {
                d.x = (int) Math.ceil(this.x);
                d.y = (int) Math.ceil(this.y);
                d.z = (int) Math.ceil(this.z);
                d.w = (int) Math.ceil(this.w);
            } break;
            case HALF_TOWARD_POSITIVE_INFINITY: {
                d.x = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.x)));
                d.y = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.y)));
                d.z = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.z)));
                d.w = (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Math.round(this.w)));
            } break;
            case HALF_AWAY_FROM_ZERO: {
                d.x = (int) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (int) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (int) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
                d.w = (int) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5));
            } break;
            case HALF_EVEN: {
                d.x = (int) Math.rint(this.x);
                d.y = (int) Math.rint(this.y);
                d.z = (int) Math.rint(this.z);
                d.w = (int) Math.rint(this.w);
            } break;
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
    public Long4 toLong(@Mutated Long4 dest) {
        Long4Impl d = (Long4Impl) dest;
        d.x = (long) (this.x);
        d.y = (long) (this.y);
        d.z = (long) (this.z);
        d.w = (long) (this.w);
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
    public Long4 toLong(RoundingMode roundingMode, @Mutated Long4 dest) {
        Long4Impl d = (Long4Impl) dest;
        switch (roundingMode) {
            case TRUNCATE: return toLong(dest);
            case FLOOR: {
                d.x = (long) Math.floor(this.x);
                d.y = (long) Math.floor(this.y);
                d.z = (long) Math.floor(this.z);
                d.w = (long) Math.floor(this.w);
            } break;
            case CEILING: {
                d.x = (long) Math.ceil(this.x);
                d.y = (long) Math.ceil(this.y);
                d.z = (long) Math.ceil(this.z);
                d.w = (long) Math.ceil(this.w);
            } break;
            case HALF_TOWARD_POSITIVE_INFINITY: {
                d.x = Math.round(this.x);
                d.y = Math.round(this.y);
                d.z = Math.round(this.z);
                d.w = Math.round(this.w);
            } break;
            case HALF_AWAY_FROM_ZERO: {
                d.x = (long) (this.x >= 0 ? Math.floor(this.x + 0.5) : Math.ceil(this.x - 0.5));
                d.y = (long) (this.y >= 0 ? Math.floor(this.y + 0.5) : Math.ceil(this.y - 0.5));
                d.z = (long) (this.z >= 0 ? Math.floor(this.z + 0.5) : Math.ceil(this.z - 0.5));
                d.w = (long) (this.w >= 0 ? Math.floor(this.w + 0.5) : Math.ceil(this.w - 0.5));
            } break;
            case HALF_EVEN: {
                d.x = (long) Math.rint(this.x);
                d.y = (long) Math.rint(this.y);
                d.z = (long) Math.rint(this.z);
                d.w = (long) Math.rint(this.w);
            } break;
        }
        return dest;
    }


    /**
     * Set all components of this vector to zero.
     *
     * @return this
     */
    @Mutated public Double4 makeZero() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 0.0;
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
    public Double4 bezier(Double4R p1, Double4R p2, Double4R p3, double t, @Mutated Double4 dest) {
        return bezier(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t, dest);
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 bezier(double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        d.x = Math.fma(p1X, _t7, this.x * _t8) + Math.fma(p2X, _t6, p3X * _t2);
        d.y = Math.fma(p1Y, _t7, this.y * _t8) + Math.fma(p2Y, _t6, p3Y * _t2);
        d.z = Math.fma(p1Z, _t7, this.z * _t8) + Math.fma(p2Z, _t6, p3Z * _t2);
        d.w = Math.fma(p1W, _t7, this.w * _t8) + Math.fma(p2W, _t6, p3W * _t2);
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
    public Double4 bezier2(Double4R p1, Double4R p2, double t, @Mutated Double4 dest) {
        return bezier2(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), t, dest);
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 bezier2(double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        d.x = Math.fma(p2X, _t0, Math.fma(p1X, _t3, this.x * _t4));
        d.y = Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, this.y * _t4));
        d.z = Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, this.z * _t4));
        d.w = Math.fma(p2W, _t0, Math.fma(p1W, _t3, this.w * _t4));
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
    public Double4 bezier2Tangent(Double4R p1, Double4R p2, double t, @Mutated Double4 dest) {
        return bezier2Tangent(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 bezier2Tangent(double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        d.x = Math.fma(p1X - this.x, _t2, (p2X - p1X) * _t1);
        d.y = Math.fma(p1Y - this.y, _t2, (p2Y - p1Y) * _t1);
        d.z = Math.fma(p1Z - this.z, _t2, (p2Z - p1Z) * _t1);
        d.w = Math.fma(p1W - this.w, _t2, (p2W - p1W) * _t1);
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
    public Double4 bezierTangent(Double4R p1, Double4R p2, Double4R p3, double t, @Mutated Double4 dest) {
        return bezierTangent(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 bezierTangent(double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        d.x = Math.fma(p3X - p2X, _t2, Math.fma(p1X - this.x, _t6, (p2X - p1X) * _t5));
        d.y = Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - this.y, _t6, (p2Y - p1Y) * _t5));
        d.z = Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - this.z, _t6, (p2Z - p1Z) * _t5));
        d.w = Math.fma(p3W - p2W, _t2, Math.fma(p1W - this.w, _t6, (p2W - p1W) * _t5));
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
    public Double4 catmullRom(Double4R p1, Double4R p2, Double4R p3, double t, @Mutated Double4 dest) {
        return catmullRom(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t, dest);
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 catmullRom(double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = t * t;
        double _t1 = t * _t0;
        d.x = 0.5 * (Math.fma(2.0, p1X, t * (p2X - this.x)) + Math.fma(Math.fma(-5.0, p1X, Math.fma(2.0, this.x, Math.fma(4.0, p2X, -p3X))), _t0, Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - this.x)) * _t1));
        d.y = 0.5 * (Math.fma(2.0, p1Y, t * (p2Y - this.y)) + Math.fma(Math.fma(-5.0, p1Y, Math.fma(2.0, this.y, Math.fma(4.0, p2Y, -p3Y))), _t0, Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - this.y)) * _t1));
        d.z = 0.5 * (Math.fma(2.0, p1Z, t * (p2Z - this.z)) + Math.fma(Math.fma(-5.0, p1Z, Math.fma(2.0, this.z, Math.fma(4.0, p2Z, -p3Z))), _t0, Math.fma(-3.0, p2Z, Math.fma(3.0, p1Z, p3Z - this.z)) * _t1));
        d.w = 0.5 * (Math.fma(2.0, p1W, t * (p2W - this.w)) + Math.fma(Math.fma(-5.0, p1W, Math.fma(2.0, this.w, Math.fma(4.0, p2W, -p3W))), _t0, Math.fma(-3.0, p2W, Math.fma(3.0, p1W, p3W - this.w)) * _t1));
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
    public Double4 catmullRomTangent(Double4R p1, Double4R p2, Double4R p3, double t, @Mutated Double4 dest) {
        return catmullRomTangent(p1.x(), p1.y(), p1.z(), p1.w(), p2.x(), p2.y(), p2.z(), p2.w(), p3.x(), p3.y(), p3.z(), p3.w(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 catmullRomTangent(double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = t * t;
        d.x = 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1X, Math.fma(2.0, this.x, Math.fma(4.0, p2X, -p3X))), Math.fma(3.0 * Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - this.x)), _t0, p2X - this.x));
        d.y = 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Y, Math.fma(2.0, this.y, Math.fma(4.0, p2Y, -p3Y))), Math.fma(3.0 * Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - this.y)), _t0, p2Y - this.y));
        d.z = 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Z, Math.fma(2.0, this.z, Math.fma(4.0, p2Z, -p3Z))), Math.fma(3.0 * Math.fma(-3.0, p2Z, Math.fma(3.0, p1Z, p3Z - this.z)), _t0, p2Z - this.z));
        d.w = 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1W, Math.fma(2.0, this.w, Math.fma(4.0, p2W, -p3W))), Math.fma(3.0 * Math.fma(-3.0, p2W, Math.fma(3.0, p1W, p3W - this.w)), _t0, p2W - this.w));
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
    public Double4 hermite(Double4R t0, Double4R v1, Double4R t1, double t, @Mutated Double4 dest) {
        return hermite(t0.x(), t0.y(), t0.z(), t0.w(), v1.x(), v1.y(), v1.z(), v1.w(), t1.x(), t1.y(), t1.z(), t1.w(), t, dest);
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 hermite(double t0X, double t0Y, double t0Z, double t0W, double v1X, double v1Y, double v1Z, double v1W, double t1X, double t1Y, double t1Z, double t1W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        d.x = Math.fma(this.x, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9);
        d.y = Math.fma(this.y, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9);
        d.z = Math.fma(this.z, _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9);
        d.w = Math.fma(this.w, _t10, t0W * _t7) + Math.fma(t1W, _t5, v1W * _t9);
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
    public Double4 hermiteTangent(Double4R t0, Double4R v1, Double4R t1, double t, @Mutated Double4 dest) {
        return hermiteTangent(t0.x(), t0.y(), t0.z(), t0.w(), v1.x(), v1.y(), v1.z(), v1.w(), t1.x(), t1.y(), t1.z(), t1.w(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 hermiteTangent(double t0X, double t0Y, double t0Z, double t0W, double v1X, double v1Y, double v1Z, double v1W, double t1X, double t1Y, double t1Z, double t1W, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        d.x = Math.fma(this.x, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7);
        d.y = Math.fma(this.y, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7);
        d.z = Math.fma(this.z, _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7);
        d.w = Math.fma(this.w, _t6, t0W * _t9) + Math.fma(t1W, _t8, v1W * _t7);
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
    public Double4 lerp(Double4R other, double t, @Mutated Double4 dest) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t, dest);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) using the interpolation factor {@code t} and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 lerp(double otherX, double otherY, double otherZ, double otherW, double t, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(t, otherX - this.x, this.x);
        d.y = Math.fma(t, otherY - this.y, this.y);
        d.z = Math.fma(t, otherZ - this.z, this.z);
        d.w = Math.fma(t, otherW - this.w, this.w);
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
    public Double4 lerp(Double4R other, Double4R t, @Mutated Double4 dest) {
        return lerp(other.x(), other.y(), other.z(), other.w(), t.x(), t.y(), t.z(), t.w(), dest);
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}) using the interpolation factor ({@code tX}, {@code tY}, {@code tZ},
     * {@code tW}) and store the result in {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param tX the {@code x} component of the vector {@code (tX, tY, tZ, tW)}
     * @param tY the {@code y} component of the vector {@code (tX, tY, tZ, tW)}
     * @param tZ the {@code z} component of the vector {@code (tX, tY, tZ, tW)}
     * @param tW the {@code w} component of the vector {@code (tX, tY, tZ, tW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 lerp(double otherX, double otherY, double otherZ, double otherW, double tX, double tY, double tZ, double tW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(tX, otherX - this.x, this.x);
        d.y = Math.fma(tY, otherY - this.y, this.y);
        d.z = Math.fma(tZ, otherZ - this.z, this.z);
        d.w = Math.fma(tW, otherW - this.w, this.w);
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 absolute(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.abs(this.x);
        d.y = Math.abs(this.y);
        d.z = Math.abs(this.z);
        d.w = Math.abs(this.w);
        return d;
    }


    /**
     * Compute the arc cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 acos(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.acos(this.x);
        d.y = Math.acos(this.y);
        d.z = Math.acos(this.z);
        d.w = Math.acos(this.w);
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
    public Double4 addScaled(Double4R b, double scalar, @Mutated Double4 dest) {
        return addScaled(b.x(), b.y(), b.z(), b.w(), scalar, dest);
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}, {@code bW}) scaled by {@code scalar} to this vector
     * and store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bW the {@code w} component of the vector {@code (bX, bY, bZ, bW)}
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double4 addScaled(double bX, double bY, double bZ, double bW, double scalar, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(scalar, bX, this.x);
        d.y = Math.fma(scalar, bY, this.y);
        d.z = Math.fma(scalar, bZ, this.z);
        d.w = Math.fma(scalar, bW, this.w);
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
    public Double4 addScaled(Double4R b, Double4R c, @Mutated Double4 dest) {
        return addScaled(b.x(), b.y(), b.z(), b.w(), c.x(), c.y(), c.z(), c.w(), dest);
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}, {@code bW}) scaled by ({@code cX}, {@code cY},
     * {@code cZ}, {@code cW}) to this vector and store the result in {@code dest}.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ, bW)}
     * @param bW the {@code w} component of the vector {@code (bX, bY, bZ, bW)}
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ, cW)}
     * @param cW the {@code w} component of the vector {@code (cX, cY, cZ, cW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 addScaled(double bX, double bY, double bZ, double bW, double cX, double cY, double cZ, double cW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(bX, cX, this.x);
        d.y = Math.fma(bY, cY, this.y);
        d.z = Math.fma(bZ, cZ, this.z);
        d.w = Math.fma(bW, cW, this.w);
        return d;
    }


    /**
     * Compute the angle in radians between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the angle in radians between this vector and {@code other}
     */
    public double angleBetween(Double4R other) {
        return angleBetween(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the angle in radians between this vector and ({@code otherX}, {@code otherY},
     * {@code otherZ}, {@code otherW}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ}, {@code otherW})
     */
    public double angleBetween(double otherX, double otherY, double otherZ, double otherW) {
        return Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y))) * (1.0 / Math.sqrt(Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y))))) * (1.0 / Math.sqrt(Math.fma(otherW, otherW, Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY))))))));
    }


    /**
     * Compute the arc sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 asin(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.asin(this.x);
        d.y = Math.asin(this.y);
        d.z = Math.asin(this.z);
        d.w = Math.asin(this.w);
        return d;
    }


    /**
     * Compute the arc tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 atan(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.atan(this.x);
        d.y = Math.atan(this.y);
        d.z = Math.atan(this.z);
        d.w = Math.atan(this.w);
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
    public Double4 atan2(double x, @Mutated Double4 dest) {
        return atan2(x, x, x, x, dest);
    }


    /**
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
     * {@code dest}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 atan2(Double4R x, @Mutated Double4 dest) {
        return atan2(x.x(), x.y(), x.z(), x.w(), dest);
    }


    /**
     * Compute the component-wise arc tangent of this vector over ({@code xX}, {@code xY},
     * {@code xZ}, {@code xW}) and store the result in {@code dest}.
     *
     * @param xX the {@code x} component of the vector {@code (xX, xY, xZ, xW)}
     * @param xY the {@code y} component of the vector {@code (xX, xY, xZ, xW)}
     * @param xZ the {@code z} component of the vector {@code (xX, xY, xZ, xW)}
     * @param xW the {@code w} component of the vector {@code (xX, xY, xZ, xW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 atan2(double xX, double xY, double xZ, double xW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.atan2(this.x, xX);
        d.y = Math.atan2(this.y, xY);
        d.z = Math.atan2(this.z, xZ);
        d.w = Math.atan2(this.w, xW);
        return d;
    }


    /**
     * Compute the cube root of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 cbrt(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.cbrt(this.x);
        d.y = Math.cbrt(this.y);
        d.z = Math.cbrt(this.z);
        d.w = Math.cbrt(this.w);
        return d;
    }


    /**
     * Compute the ceiling of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 ceil(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.ceil(this.x);
        d.y = Math.ceil(this.y);
        d.z = Math.ceil(this.z);
        d.w = Math.ceil(this.w);
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
    public Double4 clamp(double min, double max, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.min(Math.max(this.x, min), max);
        d.y = Math.min(Math.max(this.y, min), max);
        d.z = Math.min(Math.max(this.z, min), max);
        d.w = Math.min(Math.max(this.w, min), max);
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
    public Double4 clamp(Double4R min, Double4R max, @Mutated Double4 dest) {
        return clamp(min.x(), min.y(), min.z(), min.w(), max.x(), max.y(), max.z(), max.w(), dest);
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ},
     * {@code minW}) and ({@code maxX}, {@code maxY}, {@code maxZ}, {@code maxW}) and store the
     * result in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ, minW)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ, minW)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ, minW)}
     * @param minW the {@code w} component of the vector {@code (minX, minY, minZ, minW)}
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param maxW the {@code w} component of the vector {@code (maxX, maxY, maxZ, maxW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 clamp(double minX, double minY, double minZ, double minW, double maxX, double maxY, double maxZ, double maxW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.min(Math.max(this.x, minX), maxX);
        d.y = Math.min(Math.max(this.y, minY), maxY);
        d.z = Math.min(Math.max(this.z, minZ), maxZ);
        d.w = Math.min(Math.max(this.w, minW), maxW);
        return d;
    }


    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    public double compAdd() {
        return this.w + (this.z + (this.x + this.y));
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public double compMax() {
        return Math.max(Math.max(Math.max(this.x, this.y), this.z), this.w);
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public double compMin() {
        return Math.min(Math.min(Math.min(this.x, this.y), this.z), this.w);
    }


    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    public double compMul() {
        return this.w * this.z * this.x * this.y;
    }


    /**
     * Copy the sign of {@code sign} onto each component of this vector and store the result in
     * {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Double4 copySign(double sign, @Mutated Double4 dest) {
        return copySign(sign, sign, sign, sign, dest);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector and store the result in {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Double4 copySign(Double4R sign, @Mutated Double4 dest) {
        return copySign(sign.x(), sign.y(), sign.z(), sign.w(), dest);
    }


    /**
     * Copy the sign of each component of ({@code signX}, {@code signY}, {@code signZ},
     * {@code signW}) onto the corresponding component of this vector and store the result in
     * {@code dest}.
     *
     * @param signX the {@code x} component of the vector {@code (signX, signY, signZ, signW)}
     * @param signY the {@code y} component of the vector {@code (signX, signY, signZ, signW)}
     * @param signZ the {@code z} component of the vector {@code (signX, signY, signZ, signW)}
     * @param signW the {@code w} component of the vector {@code (signX, signY, signZ, signW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 copySign(double signX, double signY, double signZ, double signW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.copySign(this.x, signX);
        d.y = Math.copySign(this.y, signY);
        d.z = Math.copySign(this.z, signZ);
        d.w = Math.copySign(this.w, signW);
        return d;
    }


    /**
     * Compute the cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 cos(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.cos(this.x);
        d.y = Math.cos(this.y);
        d.z = Math.cos(this.z);
        d.w = Math.cos(this.w);
        return d;
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 cosh(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.cosh(this.x);
        d.y = Math.cosh(this.y);
        d.z = Math.cosh(this.z);
        d.w = Math.cosh(this.w);
        return d;
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 degrees(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.toDegrees(this.x);
        d.y = Math.toDegrees(this.y);
        d.z = Math.toDegrees(this.z);
        d.w = Math.toDegrees(this.w);
        return d;
    }


    /**
     * Compute the distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the distance between this vector and {@code other}
     */
    public double distance(Double4R other) {
        return distance(other.x(), other.y(), other.z(), other.w());
    }


    /**
     * Compute the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     * {@code otherW}).
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ},
     *        {@code otherW})
     */
    public double distance(double otherX, double otherY, double otherZ, double otherW) {
        double _t0 = this.w - otherW;
        double _t1 = this.z - otherZ;
        double _t2 = this.x - otherX;
        double _t3 = this.y - otherY;
        return Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3))));
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public double distanceSquared(Double4R other) {
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
    public double distanceSquared(double otherX, double otherY, double otherZ, double otherW) {
        double _t0 = this.w - otherW;
        double _t1 = this.z - otherZ;
        double _t2 = this.x - otherX;
        double _t3 = this.y - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3)));
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public double dot(Double4R other) {
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
    public double dot(double otherX, double otherY, double otherZ, double otherW) {
        return Math.fma(otherW, this.w, Math.fma(otherZ, this.z, Math.fma(otherX, this.x, otherY * this.y)));
    }


    /**
     * Compute the base-e exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 exp(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.exp(this.x);
        d.y = Math.exp(this.y);
        d.z = Math.exp(this.z);
        d.w = Math.exp(this.w);
        return d;
    }


    /**
     * Compute the base-2 exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 exp2(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.pow(2.0, this.x);
        d.y = Math.pow(2.0, this.y);
        d.z = Math.pow(2.0, this.z);
        d.w = Math.pow(2.0, this.w);
        return d;
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 expm1(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.expm1(this.x);
        d.y = Math.expm1(this.y);
        d.z = Math.expm1(this.z);
        d.w = Math.expm1(this.w);
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
    public Double4 faceforward(Double4R I, Double4R Nref, @Mutated Double4 dest) {
        return faceforward(I.x(), I.y(), I.z(), I.w(), Nref.x(), Nref.y(), Nref.z(), Nref.w(), dest);
    }


    /**
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ, NrefW), (IX, IY, IZ, IW))}
     * is negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}, {@code IW}) as judged by the reference vector ({@code NrefX},
     * {@code NrefY}, {@code NrefZ}, {@code NrefW}) and store the result in {@code dest}.
     *
     * @param IX the {@code x} component of the vector {@code (IX, IY, IZ, IW)}
     * @param IY the {@code y} component of the vector {@code (IX, IY, IZ, IW)}
     * @param IZ the {@code z} component of the vector {@code (IX, IY, IZ, IW)}
     * @param IW the {@code w} component of the vector {@code (IX, IY, IZ, IW)}
     * @param NrefX the {@code x} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param NrefY the {@code y} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param NrefZ the {@code z} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param NrefW the {@code w} component of the vector {@code (NrefX, NrefY, NrefZ, NrefW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 faceforward(double IX, double IY, double IZ, double IW, double NrefX, double NrefY, double NrefZ, double NrefW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t3 = Math.fma(IW, NrefW, Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY)));
        if (_t3 < 0.0) {
            d.x = this.x;
            d.y = this.y;
            d.z = this.z;
            d.w = this.w;
        } else {
            d.x = -this.x;
            d.y = -this.y;
            d.z = -this.z;
            d.w = -this.w;
        }
        return d;
    }


    /**
     * Compute the floor of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 floor(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.floor(this.x);
        d.y = Math.floor(this.y);
        d.z = Math.floor(this.z);
        d.w = Math.floor(this.w);
        return d;
    }


    /**
     * Compute the fractional part of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 fract(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x - Math.floor(this.x);
        d.y = this.y - Math.floor(this.y);
        d.z = this.z - Math.floor(this.z);
        d.w = this.w - Math.floor(this.w);
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
    public Double4 hypot(double y, @Mutated Double4 dest) {
        return hypot(y, y, y, y, dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Double4 hypot(Double4R y, @Mutated Double4 dest) {
        return hypot(y.x(), y.y(), y.z(), y.w(), dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * ({@code yX}, {@code yY}, {@code yZ}, {@code yW}) and store the result in {@code dest}.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yW the {@code w} component of the vector {@code (yX, yY, yZ, yW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 hypot(double yX, double yY, double yZ, double yW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.hypot(this.x, yX);
        d.y = Math.hypot(this.y, yY);
        d.z = Math.hypot(this.z, yZ);
        d.w = Math.hypot(this.w, yW);
        return d;
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 inverse(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = 1.0 / this.x;
        d.y = 1.0 / this.y;
        d.z = 1.0 / this.z;
        d.w = 1.0 / this.w;
        return d;
    }


    /**
     * Compute the inverse square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 inverseSqrt(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = (1.0 / Math.sqrt(this.x));
        d.y = (1.0 / Math.sqrt(this.y));
        d.z = (1.0 / Math.sqrt(this.z));
        d.w = (1.0 / Math.sqrt(this.w));
        return d;
    }


    /**
     * Compute the length of this vector.
     *
     * @return the length of this vector
     */
    public double length() {
        return Math.sqrt(Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y))));
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public double lengthSquared() {
        return Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
    }


    /**
     * Compute the natural logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 log(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.log(this.x);
        d.y = Math.log(this.y);
        d.z = Math.log(this.z);
        d.w = Math.log(this.w);
        return d;
    }


    /**
     * Compute the base-10 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 log10(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.log10(this.x);
        d.y = Math.log10(this.y);
        d.z = Math.log10(this.z);
        d.w = Math.log10(this.w);
        return d;
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 log1p(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.log1p(this.x);
        d.y = Math.log1p(this.y);
        d.z = Math.log1p(this.z);
        d.w = Math.log1p(this.w);
        return d;
    }


    /**
     * Compute the base-2 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 log2(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = Math.log(2.0);
        double _t0_inv = 1.0 / _t0;
        d.x = Math.log(this.x) * _t0_inv;
        d.y = Math.log(this.y) * _t0_inv;
        d.z = Math.log(this.z) * _t0_inv;
        d.w = Math.log(this.w) * _t0_inv;
        return d;
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public double manhattanDistance(Double4R other) {
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
    public double manhattanDistance(double otherX, double otherY, double otherZ, double otherW) {
        return Math.abs(this.x - otherX) + Math.abs(this.y - otherY) + Math.abs(this.z - otherZ) + Math.abs(this.w - otherW);
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public double manhattanLength() {
        return Math.abs(this.x) + Math.abs(this.y) + Math.abs(this.z) + Math.abs(this.w);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double4 max(double scalar, @Mutated Double4 dest) {
        return max(scalar, scalar, scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 max(Double4R other, @Mutated Double4 dest) {
        return max(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 max(double otherX, double otherY, double otherZ, double otherW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.max(this.x, otherX);
        d.y = Math.max(this.y, otherY);
        d.z = Math.max(this.z, otherZ);
        d.w = Math.max(this.w, otherW);
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
    public Double4 min(double scalar, @Mutated Double4 dest) {
        return min(scalar, scalar, scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double4 min(Double4R other, @Mutated Double4 dest) {
        return min(other.x(), other.y(), other.z(), other.w(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}, {@code otherW}) and store the result in
     * {@code dest}.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param otherW the {@code w} component of the vector {@code (otherX, otherY, otherZ, otherW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 min(double otherX, double otherY, double otherZ, double otherW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.min(this.x, otherX);
        d.y = Math.min(this.y, otherY);
        d.z = Math.min(this.z, otherZ);
        d.w = Math.min(this.w, otherW);
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
    public Double4 mod(double y, @Mutated Double4 dest) {
        return mod(y, y, y, y, dest);
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
    public Double4 mod(Double4R y, @Mutated Double4 dest) {
        return mod(y.x(), y.y(), y.z(), y.w(), dest);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code yX}, {@code yY}, {@code yZ}, {@code yW}) and store the result
     * in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ, yW)}
     * @param yW the {@code w} component of the vector {@code (yX, yY, yZ, yW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 mod(double yX, double yY, double yZ, double yW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.fma(-yX, Math.floor(this.x / yX), this.x);
        d.y = Math.fma(-yY, Math.floor(this.y / yY), this.y);
        d.z = Math.fma(-yZ, Math.floor(this.z / yZ), this.z);
        d.w = Math.fma(-yW, Math.floor(this.w / yW), this.w);
        return d;
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 nextDown(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.nextDown(this.x);
        d.y = Math.nextDown(this.y);
        d.z = Math.nextDown(this.z);
        d.w = Math.nextDown(this.w);
        return d;
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 nextUp(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.nextUp(this.x);
        d.y = Math.nextUp(this.y);
        d.z = Math.nextUp(this.z);
        d.w = Math.nextUp(this.w);
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
    public Double4 normalize(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            d.x = this.x * _t4;
            d.y = this.y * _t4;
            d.z = this.z * _t4;
            d.w = this.w * _t4;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
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
    public Double4 normalizeMul(double length, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t3 = Math.fma(this.w, this.w, Math.fma(this.z, this.z, Math.fma(this.x, this.x, this.y * this.y)));
        double _t5 = length * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            d.x = this.x * _t5;
            d.y = this.y * _t5;
            d.z = this.z * _t5;
            d.w = this.w * _t5;
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
        }
        return d;
    }


    /**
     * Compute the outer product of this vector and {@code row} and store the result in
     * {@code dest}.
     *
     * @param row the row vector (right operand)
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 outerProduct(Double4R row, @Mutated Double4x4 dest) {
        return outerProduct(row.x(), row.y(), row.z(), row.w(), dest);
    }


    /**
     * Compute the outer product of this vector and ({@code rowX}, {@code rowY}, {@code rowZ},
     * {@code rowW}) and store the result in {@code dest}.
     *
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param rowW the {@code w} component of the vector {@code (rowX, rowY, rowZ, rowW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4x4 outerProduct(double rowX, double rowY, double rowZ, double rowW, @Mutated Double4x4 dest) {
        Double4x4Impl d = (Double4x4Impl) dest;
        double _buf0 = rowX * this.x;
        d.m10 = rowX * this.y;
        d.m20 = rowX * this.z;
        d.m30 = rowX * this.w;
        double _buf1 = rowY * this.x;
        d.m11 = rowY * this.y;
        d.m21 = rowY * this.z;
        d.m31 = rowY * this.w;
        double _buf2 = rowZ * this.x;
        d.m12 = rowZ * this.y;
        d.m22 = rowZ * this.z;
        d.m32 = rowZ * this.w;
        double _buf3 = rowW * this.x;
        d.m13 = rowW * this.y;
        d.m23 = rowW * this.z;
        d.m33 = rowW * this.w;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.m03 = _buf3;
        d.properties = 0;
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
    public Double4 pow(double exponent, @Mutated Double4 dest) {
        return pow(exponent, exponent, exponent, exponent, dest);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    public Double4 pow(Double4R exponent, @Mutated Double4 dest) {
        return pow(exponent.x(), exponent.y(), exponent.z(), exponent.w(), dest);
    }


    /**
     * Raise each component of this vector to the power of ({@code exponentX}, {@code exponentY},
     * {@code exponentZ}, {@code exponentW}) and store the result in {@code dest}.
     *
     * @param exponentX the {@code x} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param exponentY the {@code y} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param exponentZ the {@code z} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param exponentW the {@code w} component of the vector
     *        {@code (exponentX, exponentY, exponentZ, exponentW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 pow(double exponentX, double exponentY, double exponentZ, double exponentW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.pow(this.x, exponentX);
        d.y = Math.pow(this.y, exponentY);
        d.z = Math.pow(this.z, exponentZ);
        d.w = Math.pow(this.w, exponentW);
        return d;
    }


    /**
     * Project this vector onto {@code onto} and store the result in {@code dest}.
     *
     * @param onto the vector to project onto
     * @param dest will hold the result
     * @return dest
     */
    public Double4 project(Double4R onto, @Mutated Double4 dest) {
        return project(onto.x(), onto.y(), onto.z(), onto.w(), dest);
    }


    /**
     * Project this vector onto ({@code ontoX}, {@code ontoY}, {@code ontoZ}, {@code ontoW}) and
     * store the result in {@code dest}.
     *
     * @param ontoX the {@code x} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param ontoY the {@code y} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param ontoZ the {@code z} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param ontoW the {@code w} component of the vector {@code (ontoX, ontoY, ontoZ, ontoW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 project(double ontoX, double ontoY, double ontoZ, double ontoW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t6 = Math.fma(ontoW, this.w, Math.fma(ontoZ, this.z, Math.fma(ontoX, this.x, ontoY * this.y)));
        double _t7 = Math.fma(ontoW, ontoW, Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY)));
        double _t7_inv = 1.0 / _t7;
        d.x = ontoX * _t6 * _t7_inv;
        d.y = ontoY * _t6 * _t7_inv;
        d.z = ontoZ * _t6 * _t7_inv;
        d.w = ontoW * _t6 * _t7_inv;
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
    public Double4 projectOnPlane(Double4R normal, @Mutated Double4 dest) {
        return projectOnPlane(normal.x(), normal.y(), normal.z(), normal.w(), dest);
    }


    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     *
     * @param normalX the {@code x} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalY the {@code y} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalZ the {@code z} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalW the {@code w} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 projectOnPlane(double normalX, double normalY, double normalZ, double normalW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t3 = Math.fma(normalW, this.w, Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y)));
        d.x = Math.fma(-normalX, _t3, this.x);
        d.y = Math.fma(-normalY, _t3, this.y);
        d.z = Math.fma(-normalZ, _t3, this.z);
        d.w = Math.fma(-normalW, _t3, this.w);
        return d;
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 radians(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.toRadians(this.x);
        d.y = Math.toRadians(this.y);
        d.z = Math.toRadians(this.z);
        d.w = Math.toRadians(this.w);
        return d;
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 reflect(Double4R normal, @Mutated Double4 dest) {
        return reflect(normal.x(), normal.y(), normal.z(), normal.w(), dest);
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param normalX the {@code x} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalY the {@code y} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalZ the {@code z} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param normalW the {@code w} component of the vector
     *        {@code (normalX, normalY, normalZ, normalW)} (the vector must have unit length)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 reflect(double normalX, double normalY, double normalZ, double normalW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t4 = 2.0 * Math.fma(normalW, this.w, Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y)));
        d.x = Math.fma(-normalX, _t4, this.x);
        d.y = Math.fma(-normalY, _t4, this.y);
        d.z = Math.fma(-normalZ, _t4, this.z);
        d.w = Math.fma(-normalW, _t4, this.w);
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
    public Double4 refract(Double4R normal, double eta, @Mutated Double4 dest) {
        return refract(normal.x(), normal.y(), normal.z(), normal.w(), eta, dest);
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
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
     * @param dest will hold the result
     * @return dest
     */
    public Double4 refract(double normalX, double normalY, double normalZ, double normalW, double eta, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t4 = Math.fma(normalW, this.w, Math.fma(normalZ, this.z, Math.fma(normalX, this.x, normalY * this.y)));
        double _t8 = Math.fma(-Math.fma(-_t4, _t4, 1.0), eta * eta, 1.0);
        double _t11 = Math.fma(eta, _t4, Math.sqrt(Math.max(0.0, _t8)));
        if (_t8 >= 0.0) {
            d.x = Math.fma(eta, this.x, -(normalX * _t11));
            d.y = Math.fma(eta, this.y, -(normalY * _t11));
            d.z = Math.fma(eta, this.z, -(normalZ * _t11));
            d.w = Math.fma(eta, this.w, -(normalW * _t11));
        } else {
            d.x = 0.0;
            d.y = 0.0;
            d.z = 0.0;
            d.w = 0.0;
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
    public Double4 round(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.rint(this.x);
        d.y = Math.rint(this.y);
        d.z = Math.rint(this.z);
        d.w = Math.rint(this.w);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 sign(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.signum(this.x);
        d.y = Math.signum(this.y);
        d.z = Math.signum(this.z);
        d.w = Math.signum(this.w);
        return d;
    }


    /**
     * Compute the sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 sin(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.sin(this.x);
        d.y = Math.sin(this.y);
        d.z = Math.sin(this.z);
        d.w = Math.sin(this.w);
        return d;
    }


    /**
     * Compute the hyperbolic sine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 sinh(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.sinh(this.x);
        d.y = Math.sinh(this.y);
        d.z = Math.sinh(this.z);
        d.w = Math.sinh(this.w);
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
    public Double4 smoothstep(double edge0, double edge1, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = edge1 - edge0;
        double _t0_inv = 1.0 / _t0;
        double _t13 = Math.max(0.0, Math.min(1.0, (this.x - edge0) * _t0_inv));
        double _t14 = Math.max(0.0, Math.min(1.0, (this.y - edge0) * _t0_inv));
        double _t15 = Math.max(0.0, Math.min(1.0, (this.z - edge0) * _t0_inv));
        double _t16 = Math.max(0.0, Math.min(1.0, (this.w - edge0) * _t0_inv));
        d.x = Math.fma(-2.0, _t13, 3.0) * _t13 * _t13;
        d.y = Math.fma(-2.0, _t14, 3.0) * _t14 * _t14;
        d.z = Math.fma(-2.0, _t15, 3.0) * _t15 * _t15;
        d.w = Math.fma(-2.0, _t16, 3.0) * _t16 * _t16;
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
    public Double4 smoothstep(Double4R edge0, Double4R edge1, @Mutated Double4 dest) {
        return smoothstep(edge0.x(), edge0.y(), edge0.z(), edge0.w(), edge1.x(), edge1.y(), edge1.z(), edge1.w(), dest);
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}, {@code edge0W}) and the upper
     * edge ({@code edge1X}, {@code edge1Y}, {@code edge1Z}, {@code edge1W}), yielding 0 at or below
     * the lower edge and 1 at or above the upper edge and store the result in {@code dest}.
     *
     * @param edge0X the {@code x} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge0Y the {@code y} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge0Z the {@code z} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge0W the {@code w} component of the vector {@code (edge0X, edge0Y, edge0Z, edge0W)}
     * @param edge1X the {@code x} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param edge1Y the {@code y} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param edge1Z the {@code z} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param edge1W the {@code w} component of the vector {@code (edge1X, edge1Y, edge1Z, edge1W)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 smoothstep(double edge0X, double edge0Y, double edge0Z, double edge0W, double edge1X, double edge1Y, double edge1Z, double edge1W, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t16 = Math.max(0.0, Math.min(1.0, (this.x - edge0X) / (edge1X - edge0X)));
        double _t17 = Math.max(0.0, Math.min(1.0, (this.y - edge0Y) / (edge1Y - edge0Y)));
        double _t18 = Math.max(0.0, Math.min(1.0, (this.z - edge0Z) / (edge1Z - edge0Z)));
        double _t19 = Math.max(0.0, Math.min(1.0, (this.w - edge0W) / (edge1W - edge0W)));
        d.x = Math.fma(-2.0, _t16, 3.0) * _t16 * _t16;
        d.y = Math.fma(-2.0, _t17, 3.0) * _t17 * _t17;
        d.z = Math.fma(-2.0, _t18, 3.0) * _t18 * _t18;
        d.w = Math.fma(-2.0, _t19, 3.0) * _t19 * _t19;
        return d;
    }


    /**
     * Compute the square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 sqrt(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.sqrt(this.x);
        d.y = Math.sqrt(this.y);
        d.z = Math.sqrt(this.z);
        d.w = Math.sqrt(this.w);
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
    public Double4 step(double edge, @Mutated Double4 dest) {
        return step(edge, edge, edge, edge, dest);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    public Double4 step(Double4R edge, @Mutated Double4 dest) {
        return step(edge.x(), edge.y(), edge.z(), edge.w(), dest);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     *
     * @param edgeX the {@code x} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param edgeY the {@code y} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param edgeZ the {@code z} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param edgeW the {@code w} component of the vector {@code (edgeX, edgeY, edgeZ, edgeW)}
     * @param dest will hold the result
     * @return dest
     */
    public Double4 step(double edgeX, double edgeY, double edgeZ, double edgeW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x < edgeX ? 0.0 : 1.0;
        d.y = this.y < edgeY ? 0.0 : 1.0;
        d.z = this.z < edgeZ ? 0.0 : 1.0;
        d.w = this.w < edgeW ? 0.0 : 1.0;
        return d;
    }


    /**
     * Compute the tangent of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 tan(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.tan(this.x);
        d.y = Math.tan(this.y);
        d.z = Math.tan(this.z);
        d.w = Math.tan(this.w);
        return d;
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 tanh(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.tanh(this.x);
        d.y = Math.tanh(this.y);
        d.z = Math.tanh(this.z);
        d.w = Math.tanh(this.w);
        return d;
    }


    /**
     * Compute the truncated value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 trunc(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x >= 0.0 ? Math.floor(this.x) : Math.ceil(this.x);
        d.y = this.y >= 0.0 ? Math.floor(this.y) : Math.ceil(this.y);
        d.z = this.z >= 0.0 ? Math.floor(this.z) : Math.ceil(this.z);
        d.w = this.w >= 0.0 ? Math.floor(this.w) : Math.ceil(this.w);
        return d;
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 ulp(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = Math.ulp(this.x);
        d.y = Math.ulp(this.y);
        d.z = Math.ulp(this.z);
        d.w = Math.ulp(this.w);
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double4 preMul(Double4x4R mat, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _buf0 = Math.fma(mat.m03(), this.w, Math.fma(mat.m02(), this.z, Math.fma(mat.m00(), this.x, mat.m01() * this.y)));
        double _buf1 = Math.fma(mat.m13(), this.w, Math.fma(mat.m12(), this.z, Math.fma(mat.m10(), this.x, mat.m11() * this.y)));
        double _buf2 = Math.fma(mat.m23(), this.w, Math.fma(mat.m22(), this.z, Math.fma(mat.m20(), this.x, mat.m21() * this.y)));
        d.w = Math.fma(mat.m33(), this.w, Math.fma(mat.m32(), this.z, Math.fma(mat.m30(), this.x, mat.m31() * this.y)));
        d.x = _buf0;
        d.y = _buf1;
        d.z = _buf2;
        return d;
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the quaternion {@code quat}, i.e.
     * compute {@code q * this.xyz * q^-1}, leaving {@code w} unchanged, and store the result in
     * {@code dest}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 rotate(DoubleQuatR quat, @Mutated Double4 dest) {
        return rotate(quat.x(), quat.y(), quat.z(), quat.w(), dest);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the quaternion ({@code quatX},
     * {@code quatY}, {@code quatZ}, {@code quatW}), i.e. compute {@code q * this.xyz * q^-1},
     * leaving {@code w} unchanged, and store the result in {@code dest}.
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
    public Double4 rotate(double quatX, double quatY, double quatZ, double quatW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t9 = 2.0 * Math.fma(quatX, this.y, -(quatY * this.x));
        double _t10 = 2.0 * Math.fma(quatZ, this.x, -(quatX * this.z));
        double _t11 = 2.0 * Math.fma(quatY, this.z, -(quatZ * this.y));
        d.x = Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, this.x)));
        d.y = Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.y)));
        d.z = Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, this.z)));
        d.w = this.w;
        return d;
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the
     * axis {@code axis}, leaving {@code w} unchanged, and store the result in {@code dest}.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 rotateAxis(double angle, Double3R axis, @Mutated Double4 dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by {@code angle} radians about the
     * axis ({@code axisX}, {@code axisY}, {@code axisZ}), leaving {@code w} unchanged, and store
     * the result in {@code dest}.
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
    public Double4 rotateAxis(double angle, double axisX, double axisY, double axisZ, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t5 = Math.fma(axisZ, this.z, Math.fma(axisX, this.x, axisY * this.y));
        double _buf0 = Math.fma(_t2, axisX * _t5, Math.fma(this.x, _t0, Math.fma(axisY, this.z, -(axisZ * this.y)) * _t1));
        double _buf1 = Math.fma(_t2, axisY * _t5, Math.fma(this.y, _t0, Math.fma(axisZ, this.x, -(axisX * this.z)) * _t1));
        d.z = Math.fma(_t2, axisZ * _t5, Math.fma(this.z, _t0, Math.fma(axisX, this.y, -(axisY * this.x)) * _t1));
        d.w = this.w;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the inverse of the given rotation,
     * leaving {@code w} unchanged, and store the result in {@code dest}.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double4 rotateInverse(DoubleQuatR quat, @Mutated Double4 dest) {
        return rotateInverse(quat.x(), quat.y(), quat.z(), quat.w(), dest);
    }


    /**
     * Rotate the {@code (x, y, z)} components of this vector by the inverse of the given rotation,
     * leaving {@code w} unchanged, and store the result in {@code dest}.
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
    public Double4 rotateInverse(double quatX, double quatY, double quatZ, double quatW, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t9 = 2.0 * Math.fma(quatX, this.z, -(quatZ * this.x));
        double _t10 = 2.0 * Math.fma(quatY, this.x, -(quatX * this.y));
        double _t11 = 2.0 * Math.fma(quatZ, this.y, -(quatY * this.z));
        d.x = Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, this.x)));
        d.y = Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, this.y)));
        d.z = Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, this.z)));
        d.w = this.w;
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
    public Double4 rotateX(double angle, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        d.x = this.x;
        double _buf0 = Math.fma(this.y, _t0, -(this.z * _t1));
        d.z = Math.fma(this.y, _t1, this.z * _t0);
        d.w = this.w;
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
    public Double4 rotateY(double angle, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(this.x, _t0, this.z * _t1);
        d.y = this.y;
        d.z = Math.fma(this.z, _t0, -(this.x * _t1));
        d.w = this.w;
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
    public Double4 rotateZ(double angle, @Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _buf0 = Math.fma(this.x, _t0, -(this.y * _t1));
        d.y = Math.fma(this.x, _t1, this.y * _t0);
        d.z = this.z;
        d.w = this.w;
        d.x = _buf0;
        return d;
    }

    public double x() { return this.x; }
    public double y() { return this.y; }
    public double z() { return this.z; }
    public double w() { return this.w; }

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

    public Double2 xw(@Mutated Double2 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
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

    public Double2 yw(@Mutated Double2 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
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

    public Double2 zw(@Mutated Double2 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 wx(@Mutated Double2 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 wy(@Mutated Double2 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 wz(@Mutated Double2 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double2Impl d = (Double2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Double2 ww(@Mutated Double2 dest) {
        double _v0 = this.w;
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

    public Double3 xxw(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
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

    public Double3 xyw(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
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

    public Double3 xzw(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 xwx(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 xwy(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 xwz(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 xww(@Mutated Double3 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
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

    public Double3 yxw(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
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

    public Double3 yyw(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
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

    public Double3 yzw(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 ywx(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 ywy(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 ywz(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 yww(@Mutated Double3 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
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

    public Double3 zxw(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
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

    public Double3 zyw(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
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

    public Double3 zzw(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 zwx(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 zwy(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 zwz(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 zww(@Mutated Double3 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 wxx(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 wxy(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 wxz(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 wxw(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 wyx(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 wyy(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 wyz(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 wyw(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 wzx(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 wzy(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Double3 wzz(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Double3 wzw(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Double3 wwx(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 wwy(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 wwz(@Mutated Double3 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double3Impl d = (Double3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Double3 www(@Mutated Double3 dest) {
        double _v0 = this.w;
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

    public Double4 xxxw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
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

    public Double4 xxyw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
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

    public Double4 xxzw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xxwx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 xxwy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xxwz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xxww(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
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

    public Double4 xyxw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
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

    public Double4 xyyw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
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

    public Double4 xyzw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.z;
        double _v3 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 xywx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 xywy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 xywz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
        double _v3 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 xyww(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.y;
        double _v2 = this.w;
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

    public Double4 xzxw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
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

    public Double4 xzyw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.y;
        double _v3 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
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

    public Double4 xzzw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xzwx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 xzwy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        double _v3 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 xzwz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 xzww(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 xwxx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 xwxy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 xwxz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 xwxw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 xwyx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 xwyy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 xwyz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        double _v3 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 xwyw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 xwzx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 xwzy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        double _v3 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 xwzz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 xwzw(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 xwwx(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 xwwy(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xwwz(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 xwww(@Mutated Double4 dest) {
        double _v0 = this.x;
        double _v1 = this.w;
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

    public Double4 yxxw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
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

    public Double4 yxyw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
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

    public Double4 yxzw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.z;
        double _v3 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 yxwx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 yxwy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 yxwz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
        double _v3 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 yxww(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
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

    public Double4 yyxw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.x;
        double _v2 = this.w;
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

    public Double4 yyyw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
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

    public Double4 yyzw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yywx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yywy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 yywz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yyww(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
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

    public Double4 yzxw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.x;
        double _v3 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
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

    public Double4 yzyw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
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

    public Double4 yzzw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 yzwx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        double _v3 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 yzwy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 yzwz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 yzww(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.z;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 ywxx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 ywxy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 ywxz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        double _v3 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 ywxw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 ywyx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 ywyy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 ywyz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 ywyw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 ywzx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        double _v3 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 ywzy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 ywzz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 ywzw(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 ywwx(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 ywwy(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 ywwz(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 ywww(@Mutated Double4 dest) {
        double _v0 = this.y;
        double _v1 = this.w;
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

    public Double4 zxxw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
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

    public Double4 zxyw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.y;
        double _v3 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
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

    public Double4 zxzw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 zxwx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 zxwy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        double _v3 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 zxwz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 zxww(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
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

    public Double4 zyxw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.x;
        double _v3 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
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

    public Double4 zyyw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
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

    public Double4 zyzw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 zywx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        double _v3 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 zywy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 zywz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 zyww(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
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

    public Double4 zzxw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.x;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
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

    public Double4 zzyw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.y;
        double _v2 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
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

    public Double4 zzzw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 zzwx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zzwy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zzwz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 zzww(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 zwxx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 zwxy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        double _v3 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 zwxz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 zwxw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 zwyx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        double _v3 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 zwyy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 zwyz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 zwyw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 zwzx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 zwzy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 zwzz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 zwzw(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 zwwx(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zwwy(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 zwwz(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 zwww(@Mutated Double4 dest) {
        double _v0 = this.z;
        double _v1 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wxxx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wxxy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wxxz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wxxw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 wxyx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 wxyy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 wxyz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        double _v3 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 wxyw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 wxzx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 wxzy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        double _v3 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 wxzz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 wxzw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 wxwx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 wxwy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 wxwz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 wxww(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 wyxx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 wyxy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 wyxz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        double _v3 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 wyxw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 wyyx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wyyy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wyyz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wyyw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 wyzx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        double _v3 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 wyzy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 wyzz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 wyzw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 wywx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 wywy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 wywz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 wyww(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 wzxx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 wzxy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        double _v3 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 wzxz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 wzxw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 wzyx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        double _v3 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v3;
        return dest;
    }

    public Double4 wzyy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Double4 wzyz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Double4 wzyw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Double4 wzzx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wzzy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wzzz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wzzw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 wzwx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 wzwy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Double4 wzwz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 wzww(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Double4 wwxx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wwxy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wwxz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wwxw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 wwyx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wwyy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wwyz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        double _v2 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wwyw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 wwzx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wwzy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        double _v2 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Double4 wwzz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Double4 wwzw(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Double4 wwwx(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.x;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 wwwy(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.y;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 wwwz(@Mutated Double4 dest) {
        double _v0 = this.w;
        double _v1 = this.z;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Double4 wwww(@Mutated Double4 dest) {
        double _v0 = this.w;
        Double4Impl d = (Double4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    @Override public String toString() {
        return "Double4(" + x() + ", " + y() + ", " + z() + ", " + w() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Double4Impl)) return false;
        Double4Impl o = (Double4Impl) obj;
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

    @Override public boolean equalsEpsilon(Double4R other, double epsilon) {
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
    public @Mutated Double4 load(double[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.w = src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Double4 loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public Double4 loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public Double4 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public Double4 loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.x;
        dest[offset + 1] = (float) this.y;
        dest[offset + 2] = (float) this.z;
        dest[offset + 3] = (float) this.w;
        return dest;
    }
    public @Mutated Double4 load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.w = src[offset + 3];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Double4 loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public Double4 loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public Double4 storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public Double4 loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }

}
