package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link Float3} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class Float3Impl implements Float3 {

    public float x;
    public float y;
    public float z;
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

    public Float3Impl() {
    }

    public Float3Impl(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Float3Impl(Float3R src) {
        this.x = src.x();
        this.y = src.y();
        this.z = src.z();
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 add(Float3R other, @Mutated Float3 dest) {
        return add(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Add {@code other} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 add(Float3R other, @Mutated Double3 dest) {
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
    public Float3 add(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = otherX + this.x;
        d.y = otherY + this.y;
        d.z = otherZ + this.z;
        return d;
    }


    /**
     * Add ({@code otherX}, {@code otherY}, {@code otherZ}) to this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 add(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
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
    public Float3 div(float scalar, @Mutated Float3 dest) {
        return div(scalar, scalar, scalar, dest);
    }


    /**
     * Divide each component of this vector by {@code scalar} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(float scalar, @Mutated Double3 dest) {
        return div(scalar, scalar, scalar, dest);
    }


    /**
     * Divide this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 div(Float3R other, @Mutated Float3 dest) {
        return div(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Divide this vector component-wise by {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(Float3R other, @Mutated Double3 dest) {
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
    public Float3 div(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x / otherX;
        d.y = this.y / otherY;
        d.z = this.z / otherZ;
        return d;
    }


    /**
     * Divide this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 div(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
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
    public Float3 fma(float b, Float3R c, @Mutated Float3 dest) {
        return fma(b, c.x(), c.y(), c.z(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(float b, Float3R c, @Mutated Double3 dest) {
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
    public Float3 fma(float b, float cX, float cY, float cZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.fma(this.x, b, cX);
        d.y = Math.fma(this.y, b, cY);
        d.z = Math.fma(this.z, b, cZ);
        return d;
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY},
     * {@code cZ}), i.e. compute {@code this * b + (cX, cY, cZ)} per component and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param b the factor to multiply this vector by
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(float b, float cX, float cY, float cZ, @Mutated Double3 dest) {
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
    public Float3 fma(Float3R b, Float3R c, @Mutated Float3 dest) {
        return fma(b.x(), b.y(), b.z(), c.x(), c.y(), c.z(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code b} and add {@code c}, i.e. compute
     * {@code this * b + c} per component and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param b the factor to multiply this vector by
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fma(Float3R b, Float3R c, @Mutated Double3 dest) {
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
    public Float3 fma(float bX, float bY, float bZ, float cX, float cY, float cZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.fma(this.x, bX, cX);
        d.y = Math.fma(this.y, bY, cY);
        d.z = Math.fma(this.z, bZ, cZ);
        return d;
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * (bX, bY, bZ) + (cX, cY, cZ)}
     * per component and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 fma(float bX, float bY, float bZ, float cX, float cY, float cZ, @Mutated Double3 dest) {
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
    public Float3 mul(float scalar, @Mutated Float3 dest) {
        return mul(scalar, scalar, scalar, dest);
    }


    /**
     * Multiply each component of this vector by {@code scalar} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(float scalar, @Mutated Double3 dest) {
        return mul(scalar, scalar, scalar, dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 mul(Float3R other, @Mutated Float3 dest) {
        return mul(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Multiply this vector component-wise by {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(Float3R other, @Mutated Double3 dest) {
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
    public Float3 mul(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = otherX * this.x;
        d.y = otherY * this.y;
        d.z = otherZ * this.z;
        return d;
    }


    /**
     * Multiply this vector component-wise by ({@code otherX}, {@code otherY}, {@code otherZ}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mul(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
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
    public Float3 negate(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = -this.x;
        d.y = -this.y;
        d.z = -this.z;
        return d;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 sub(Float3R other, @Mutated Float3 dest) {
        return sub(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Subtract {@code other} from this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sub(Float3R other, @Mutated Double3 dest) {
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
    public Float3 sub(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x - otherX;
        d.y = this.y - otherY;
        d.z = this.z - otherZ;
        return d;
    }


    /**
     * Subtract ({@code otherX}, {@code otherY}, {@code otherZ}) from this vector and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sub(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
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
    public @Mutated Float3 set(Float3R v) {
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
    @Mutated public Float3 set(float vX, float vY, float vZ) {
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
    public Float3 set(float s, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = s;
        d.y = s;
        d.z = s;
        return d;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the value assigned to every component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 set(float s, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = s;
        d.y = s;
        d.z = s;
        return d;
    }


    /**
     * Convert this vector to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 toDouble(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
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
                d.x = Math.round(this.x);
                d.y = Math.round(this.y);
                d.z = Math.round(this.z);
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
                d.x = Math.round((double) (this.x));
                d.y = Math.round((double) (this.y));
                d.z = Math.round((double) (this.z));
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
    @Mutated public Float3 makeZero() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
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
    public Float3 bezier(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Float3 dest) {
        return bezier(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Double3 dest) {
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
    public Float3 bezier(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        d.x = p1X * _t7 + this.x * _t8 + (p2X * _t6 + p3X * _t2);
        d.y = p1Y * _t7 + this.y * _t8 + (p2Y * _t6 + p3Y * _t2);
        d.z = p1Z * _t7 + this.z * _t8 + (p2Z * _t6 + p3Z * _t2);
        return d;
    }


    /**
     * Interpolate along the cubic Bézier curve defined by this vector and the given control points
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 bezier(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
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
    public Float3 bezier2(Float3R p1, Float3R p2, float t, @Mutated Float3 dest) {
        return bezier2(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t, dest);
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2(Float3R p1, Float3R p2, float t, @Mutated Double3 dest) {
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
    public Float3 bezier2(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t3 = 2.0f * t * _t0;
        float _t4 = _t0 * _t0;
        d.x = p1X * _t3 + this.x * _t4 + p2X * _t1;
        d.y = p1Y * _t3 + this.y * _t4 + p2Y * _t1;
        d.z = p1Z * _t3 + this.z * _t4 + p2Z * _t1;
        return d;
    }


    /**
     * Interpolate along the quadratic Bézier curve defined by this vector and the given control
     * points and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 bezier2(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t3 = 2.0f * t * _t0;
        float _t4 = _t0 * _t0;
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
    public Float3 bezier2Tangent(Float3R p1, Float3R p2, float t, @Mutated Float3 dest) {
        return bezier2Tangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the control point
     * @param p2 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezier2Tangent(Float3R p1, Float3R p2, float t, @Mutated Double3 dest) {
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
    public Float3 bezier2Tangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        d.x = (p1X - this.x) * _t2 + (p2X - p1X) * _t1;
        d.y = (p1Y - this.y) * _t2 + (p2Y - p1Y) * _t1;
        d.z = (p1Z - this.z) * _t2 + (p2Z - p1Z) * _t1;
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the quadratic Bézier curve defined
     * by this vector and the given control points, at the parameter {@code t} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 bezier2Tangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
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
    public Float3 bezierTangent(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Float3 dest) {
        return bezierTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the first control point
     * @param p2 the second control point
     * @param p3 the end point
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 bezierTangent(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Double3 dest) {
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
    public Float3 bezierTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = 1.0f - t;
        float _t3 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t0;
        float _t6 = 3.0f * _t0 * _t0;
        d.x = (p1X - this.x) * _t6 + (p2X - p1X) * _t5 + (p3X - p2X) * _t3;
        d.y = (p1Y - this.y) * _t6 + (p2Y - p1Y) * _t5 + (p3Y - p2Y) * _t3;
        d.z = (p1Z - this.z) * _t6 + (p2Z - p1Z) * _t5 + (p3Z - p2Z) * _t3;
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Bézier curve defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 bezierTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = 1.0f - t;
        float _t3 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t0;
        float _t6 = 3.0f * _t0 * _t0;
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
    public Float3 catmullRom(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Float3 dest) {
        return catmullRom(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRom(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Double3 dest) {
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
    public Float3 catmullRom(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = t * t;
        float _t1 = t * _t0;
        d.x = 0.5f * (2.0f * p1X + t * (p2X - this.x) + ((-5.0f * p1X + (2.0f * this.x + (4.0f * p2X - p3X))) * _t0 + (3.0f * p1X + (p3X - this.x) - 3.0f * p2X) * _t1));
        d.y = 0.5f * (2.0f * p1Y + t * (p2Y - this.y) + ((-5.0f * p1Y + (2.0f * this.y + (4.0f * p2Y - p3Y))) * _t0 + (3.0f * p1Y + (p3Y - this.y) - 3.0f * p2Y) * _t1));
        d.z = 0.5f * (2.0f * p1Z + t * (p2Z - this.z) + ((-5.0f * p1Z + (2.0f * this.z + (4.0f * p2Z - p3Z))) * _t0 + (3.0f * p1Z + (p3Z - this.z) - 3.0f * p2Z) * _t1));
        return d;
    }


    /**
     * Interpolate along the Catmull-Rom spline defined by this vector and the given control points
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 catmullRom(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = t * t;
        float _t1 = t * _t0;
        d.x = 0.5f * (2.0f * p1X + t * (p2X - this.x) + ((-5.0f * p1X + (2.0f * this.x + (4.0f * p2X - p3X))) * _t0 + (3.0f * p1X + (p3X - this.x) - 3.0f * p2X) * _t1));
        d.y = 0.5f * (2.0f * p1Y + t * (p2Y - this.y) + ((-5.0f * p1Y + (2.0f * this.y + (4.0f * p2Y - p3Y))) * _t0 + (3.0f * p1Y + (p3Y - this.y) - 3.0f * p2Y) * _t1));
        d.z = 0.5f * (2.0f * p1Z + t * (p2Z - this.z) + ((-5.0f * p1Z + (2.0f * this.z + (4.0f * p2Z - p3Z))) * _t0 + (3.0f * p1Z + (p3Z - this.z) - 3.0f * p2Z) * _t1));
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
    public Float3 catmullRomTangent(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Float3 dest) {
        return catmullRomTangent(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), p3.x(), p3.y(), p3.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the start point of the interpolated segment
     * @param p2 the end point of the interpolated segment
     * @param p3 the outer control point after the segment
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 catmullRomTangent(Float3R p1, Float3R p2, Float3R p3, float t, @Mutated Double3 dest) {
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
    public Float3 catmullRomTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = t * t;
        d.x = 0.5f * (t * 2.0f * (-5.0f * p1X + (2.0f * this.x + (4.0f * p2X - p3X))) + (3.0f * (3.0f * p1X + (p3X - this.x) - 3.0f * p2X) * _t0 + (p2X - this.x)));
        d.y = 0.5f * (t * 2.0f * (-5.0f * p1Y + (2.0f * this.y + (4.0f * p2Y - p3Y))) + (3.0f * (3.0f * p1Y + (p3Y - this.y) - 3.0f * p2Y) * _t0 + (p2Y - this.y)));
        d.z = 0.5f * (t * 2.0f * (-5.0f * p1Z + (2.0f * this.z + (4.0f * p2Z - p3Z))) + (3.0f * (3.0f * p1Z + (p3Z - this.z) - 3.0f * p2Z) * _t0 + (p2Z - this.z)));
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the Catmull-Rom spline defined by
     * this vector and the given control points, at the parameter {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 catmullRomTangent(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = t * t;
        d.x = 0.5f * (t * 2.0f * (-5.0f * p1X + (2.0f * this.x + (4.0f * p2X - p3X))) + (3.0f * (3.0f * p1X + (p3X - this.x) - 3.0f * p2X) * _t0 + (p2X - this.x)));
        d.y = 0.5f * (t * 2.0f * (-5.0f * p1Y + (2.0f * this.y + (4.0f * p2Y - p3Y))) + (3.0f * (3.0f * p1Y + (p3Y - this.y) - 3.0f * p2Y) * _t0 + (p2Y - this.y)));
        d.z = 0.5f * (t * 2.0f * (-5.0f * p1Z + (2.0f * this.z + (4.0f * p2Z - p3Z))) + (3.0f * (3.0f * p1Z + (p3Z - this.z) - 3.0f * p2Z) * _t0 + (p2Z - this.z)));
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
    public Float3 hermite(Float3R t0, Float3R v1, Float3R t1, float t, @Mutated Float3 dest) {
        return hermite(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t, dest);
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermite(Float3R t0, Float3R v1, Float3R t1, float t, @Mutated Double3 dest) {
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
    public Float3 hermite(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = t * t;
        float _t3 = 3.0f * _t0;
        float _t5 = 2.0f * t * _t0;
        float _t8 = t * (_t0 - t);
        float _t9 = (t - 2.0f) * _t0 + t;
        float _t10 = _t3 - _t5;
        float _t11 = _t5 + (1.0f - _t3);
        d.x = this.x * _t11 + t0X * _t9 + (t1X * _t8 + v1X * _t10);
        d.y = this.y * _t11 + t0Y * _t9 + (t1Y * _t8 + v1Y * _t10);
        d.z = this.z * _t11 + t0Z * _t9 + (t1Z * _t8 + v1Z * _t10);
        return d;
    }


    /**
     * Interpolate between this vector and the given endpoint using cubic Hermite interpolation and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 hermite(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = t * t;
        float _t3 = 3.0f * _t0;
        float _t5 = 2.0f * t * _t0;
        float _t8 = t * (_t0 - t);
        float _t9 = (t - 2.0f) * _t0 + t;
        float _t10 = _t3 - _t5;
        float _t11 = _t5 + (1.0f - _t3);
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
    public Float3 hermiteTangent(Float3R t0, Float3R v1, Float3R t1, float t, @Mutated Float3 dest) {
        return hermiteTangent(t0.x(), t0.y(), t0.z(), v1.x(), v1.y(), v1.z(), t1.x(), t1.y(), t1.z(), t, dest);
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t0 the tangent at this vector
     * @param v1 the endpoint
     * @param t1 the tangent at the endpoint
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hermiteTangent(Float3R t0, Float3R v1, Float3R t1, float t, @Mutated Double3 dest) {
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
    public Float3 hermiteTangent(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = t * t;
        float _t4 = 3.0f * _t0;
        float _t7 = 6.0f * (_t0 - t);
        float _t8 = 6.0f * (t - _t0);
        float _t9 = _t4 - 2.0f * t;
        float _t10 = _t4 + (1.0f - 4.0f * t);
        d.x = this.x * _t7 + t0X * _t10 + (t1X * _t9 + v1X * _t8);
        d.y = this.y * _t7 + t0Y * _t10 + (t1Y * _t9 + v1Y * _t8);
        d.z = this.z * _t7 + t0Z * _t10 + (t1Z * _t9 + v1Z * _t8);
        return d;
    }


    /**
     * Compute the tangent (the unnormalized first derivative) of the cubic Hermite curve between
     * this vector and the given endpoint, at the parameter {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 hermiteTangent(float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = t * t;
        float _t4 = 3.0f * _t0;
        float _t7 = 6.0f * (_t0 - t);
        float _t8 = 6.0f * (t - _t0);
        float _t9 = _t4 - 2.0f * t;
        float _t10 = _t4 + (1.0f - 4.0f * t);
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
    public Float3 lerp(Float3R other, float t, @Mutated Float3 dest) {
        return lerp(other.x(), other.y(), other.z(), t, dest);
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(Float3R other, float t, @Mutated Double3 dest) {
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
    public Float3 lerp(float otherX, float otherY, float otherZ, float t, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = t * (otherX - this.x) + this.x;
        d.y = t * (otherY - this.y) + this.y;
        d.z = t * (otherZ - this.z) + this.z;
        return d;
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param t the interpolation factor, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(float otherX, float otherY, float otherZ, float t, @Mutated Double3 dest) {
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
    public Float3 lerp(Float3R other, Float3R t, @Mutated Float3 dest) {
        return lerp(other.x(), other.y(), other.z(), t.x(), t.y(), t.z(), dest);
    }


    /**
     * Linearly interpolate between this vector and {@code other} using the interpolation factor
     * {@code t} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param t the per-component interpolation factors, typically within {@code [0, 1]}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 lerp(Float3R other, Float3R t, @Mutated Double3 dest) {
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
    public Float3 lerp(float otherX, float otherY, float otherZ, float tX, float tY, float tZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = tX * (otherX - this.x) + this.x;
        d.y = tY * (otherY - this.y) + this.y;
        d.z = tZ * (otherZ - this.z) + this.z;
        return d;
    }


    /**
     * Linearly interpolate between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * using the interpolation factor ({@code tX}, {@code tY}, {@code tZ}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 lerp(float otherX, float otherY, float otherZ, float tX, float tY, float tZ, @Mutated Double3 dest) {
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
    public Float3 absolute(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.abs(this.x);
        d.y = Math.abs(this.y);
        d.z = Math.abs(this.z);
        return d;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 acos(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.acos(this.x);
        d.y = (float) Math.acos(this.y);
        d.z = (float) Math.acos(this.z);
        return d;
    }


    /**
     * Compute the arc cosine of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 acos(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.acos(this.x);
        d.y = (float) Math.acos(this.y);
        d.z = (float) Math.acos(this.z);
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
    public Float3 addScaled(Float3R b, float scalar, @Mutated Float3 dest) {
        return addScaled(b.x(), b.y(), b.z(), scalar, dest);
    }


    /**
     * Add {@code b} scaled by {@code scalar} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param b the vector
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(Float3R b, float scalar, @Mutated Double3 dest) {
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
    public Float3 addScaled(float bX, float bY, float bZ, float scalar, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = scalar * bX + this.x;
        d.y = scalar * bY + this.y;
        d.z = scalar * bZ + this.z;
        return d;
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by {@code scalar} to this vector and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param bX the {@code x} component of the vector {@code (bX, bY, bZ)}
     * @param bY the {@code y} component of the vector {@code (bX, bY, bZ)}
     * @param bZ the {@code z} component of the vector {@code (bX, bY, bZ)}
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(float bX, float bY, float bZ, float scalar, @Mutated Double3 dest) {
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
    public Float3 addScaled(Float3R b, Float3R c, @Mutated Float3 dest) {
        return addScaled(b.x(), b.y(), b.z(), c.x(), c.y(), c.z(), dest);
    }


    /**
     * Add {@code b} scaled by {@code c} to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param b the vector
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 addScaled(Float3R b, Float3R c, @Mutated Double3 dest) {
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
    public Float3 addScaled(float bX, float bY, float bZ, float cX, float cY, float cZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = bX * cX + this.x;
        d.y = bY * cY + this.y;
        d.z = bZ * cZ + this.z;
        return d;
    }


    /**
     * Add ({@code bX}, {@code bY}, {@code bZ}) scaled by ({@code cX}, {@code cY}, {@code cZ}) to
     * this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 addScaled(float bX, float bY, float bZ, float cX, float cY, float cZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = bX * cX + this.x;
        d.y = bY * cY + this.y;
        d.z = bZ * cZ + this.z;
        return d;
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
    public float angleBetween(Float3R other) {
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
        float _t6 = otherY * this.x - otherX * this.y;
        float _t7 = otherZ * this.x - otherX * this.z;
        float _t8 = otherZ * this.y - otherY * this.z;
        return (float) Math.atan2((float) Math.sqrt(_t6 * _t6 + _t7 * _t7 + _t8 * _t8), otherX * this.x + otherY * this.y + otherZ * this.z);
    }


    /**
     * Compute the arc sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 asin(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.asin(this.x);
        d.y = (float) Math.asin(this.y);
        d.z = (float) Math.asin(this.z);
        return d;
    }


    /**
     * Compute the arc sine of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 asin(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.asin(this.x);
        d.y = (float) Math.asin(this.y);
        d.z = (float) Math.asin(this.z);
        return d;
    }


    /**
     * Compute the arc tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 atan(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.atan(this.x);
        d.y = (float) Math.atan(this.y);
        d.z = (float) Math.atan(this.z);
        return d;
    }


    /**
     * Compute the arc tangent of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.atan(this.x);
        d.y = (float) Math.atan(this.y);
        d.z = (float) Math.atan(this.z);
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
    public Float3 atan2(float x, @Mutated Float3 dest) {
        return atan2(x, x, x, dest);
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} {@code x} (the denominator) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(float x, @Mutated Double3 dest) {
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
    public Float3 atan2(Float3R x, @Mutated Float3 dest) {
        return atan2(x.x(), x.y(), x.z(), dest);
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of {@code x} (the
     * denominator) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the vector of denominators, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(Float3R x, @Mutated Double3 dest) {
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
    public Float3 atan2(float xX, float xY, float xZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.atan2(this.x, xX);
        d.y = (float) Math.atan2(this.y, xY);
        d.z = (float) Math.atan2(this.z, xZ);
        return d;
    }


    /**
     * Compute the component-wise arc tangent {@code atan2(a, b)} with {@code a} each component of
     * this vector (the numerator) and {@code b} the corresponding component of ({@code xX},
     * {@code xY}, {@code xZ}) (the denominator) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param xX the {@code x} component of the vector {@code (xX, xY, xZ)}
     * @param xY the {@code y} component of the vector {@code (xX, xY, xZ)}
     * @param xZ the {@code z} component of the vector {@code (xX, xY, xZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(float xX, float xY, float xZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.atan2(this.x, xX);
        d.y = (float) Math.atan2(this.y, xY);
        d.z = (float) Math.atan2(this.z, xZ);
        return d;
    }


    /**
     * Compute the cube root of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 cbrt(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.cbrt(this.x);
        d.y = (float) Math.cbrt(this.y);
        d.z = (float) Math.cbrt(this.z);
        return d;
    }


    /**
     * Compute the cube root of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cbrt(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.cbrt(this.x);
        d.y = (float) Math.cbrt(this.y);
        d.z = (float) Math.cbrt(this.z);
        return d;
    }


    /**
     * Compute the ceiling of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 ceil(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.ceil(this.x);
        d.y = (float) Math.ceil(this.y);
        d.z = (float) Math.ceil(this.z);
        return d;
    }


    /**
     * Compute the ceiling of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 ceil(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.ceil(this.x);
        d.y = (float) Math.ceil(this.y);
        d.z = (float) Math.ceil(this.z);
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
    public Float3 clamp(float min, float max, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.min(Math.max(this.x, min), max);
        d.y = Math.min(Math.max(this.y, min), max);
        d.z = Math.min(Math.max(this.z, min), max);
        return d;
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param min the lower bound
     * @param max the upper bound
     * @param dest will hold the result
     * @return dest
     */
    public Double3 clamp(float min, float max, @Mutated Double3 dest) {
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
    public Float3 clamp(Float3R min, Float3R max, @Mutated Float3 dest) {
        return clamp(min.x(), min.y(), min.z(), max.x(), max.y(), max.z(), dest);
    }


    /**
     * Clamp each component of this vector between {@code min} and {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param min the per-component lower bounds
     * @param max the per-component upper bounds
     * @param dest will hold the result
     * @return dest
     */
    public Double3 clamp(Float3R min, Float3R max, @Mutated Double3 dest) {
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
    public Float3 clamp(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.min(Math.max(this.x, minX), maxX);
        d.y = Math.min(Math.max(this.y, minY), maxY);
        d.z = Math.min(Math.max(this.z, minZ), maxZ);
        return d;
    }


    /**
     * Clamp each component of this vector between ({@code minX}, {@code minY}, {@code minZ}) and
     * ({@code maxX}, {@code maxY}, {@code maxZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 clamp(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, @Mutated Double3 dest) {
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
     * @param lineStart the vector
     * @param lineEnd the vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 closestPointOnLine(Float3R lineStart, Float3R lineEnd, @Mutated Float3 dest) {
        return closestPointOnLine(lineStart.x(), lineStart.y(), lineStart.z(), lineEnd.x(), lineEnd.y(), lineEnd.z(), dest);
    }


    /**
     * Compute the point on the line segment between {@code lineStart} and {@code lineEnd} that is
     * closest to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param lineStart the vector
     * @param lineEnd the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 closestPointOnLine(Float3R lineStart, Float3R lineEnd, @Mutated Double3 dest) {
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
    public Float3 closestPointOnLine(float lineStartX, float lineStartY, float lineStartZ, float lineEndX, float lineEndY, float lineEndZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = lineEndX - lineStartX;
        float _t1 = lineEndY - lineStartY;
        float _t2 = lineEndZ - lineStartZ;
        float _t14 = _t0 * _t0 + _t1 * _t1 + _t2 * _t2;
        float _t18 = Math.max(0.0f, Math.min(1.0f, (_t0 * (this.x - lineStartX) + _t1 * (this.y - lineStartY) + _t2 * (this.z - lineStartZ)) / _t14));
        if (_t14 > 0.0f) {
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
     * Compute the point on the line segment between ({@code lineStartX}, {@code lineStartY},
     * {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY}, {@code lineEndZ}) that is
     * closest to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 closestPointOnLine(float lineStartX, float lineStartY, float lineStartZ, float lineEndX, float lineEndY, float lineEndZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = lineEndX - lineStartX;
        float _t1 = lineEndY - lineStartY;
        float _t2 = lineEndZ - lineStartZ;
        float _t14 = _t0 * _t0 + _t1 * _t1 + _t2 * _t2;
        float _t18 = Math.max(0.0f, Math.min(1.0f, (_t0 * (this.x - lineStartX) + _t1 * (this.y - lineStartY) + _t2 * (this.z - lineStartZ)) / _t14));
        if (_t14 > 0.0f) {
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
     * Copy the sign of {@code sign} onto each component of this vector and store the result in
     * {@code dest}.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Float3 copySign(float sign, @Mutated Float3 dest) {
        return copySign(sign, sign, sign, dest);
    }


    /**
     * Copy the sign of {@code sign} onto each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Double3 copySign(float sign, @Mutated Double3 dest) {
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
    public Float3 copySign(Float3R sign, @Mutated Float3 dest) {
        return copySign(sign.x(), sign.y(), sign.z(), dest);
    }


    /**
     * Copy the sign of each component of {@code sign} onto the corresponding component of this
     * vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param sign the value whose sign is copied
     * @param dest will hold the result
     * @return dest
     */
    public Double3 copySign(Float3R sign, @Mutated Double3 dest) {
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
    public Float3 copySign(float signX, float signY, float signZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.copySign(this.x, signX);
        d.y = Math.copySign(this.y, signY);
        d.z = Math.copySign(this.z, signZ);
        return d;
    }


    /**
     * Copy the sign of each component of ({@code signX}, {@code signY}, {@code signZ}) onto the
     * corresponding component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param signX the {@code x} component of the vector {@code (signX, signY, signZ)}
     * @param signY the {@code y} component of the vector {@code (signX, signY, signZ)}
     * @param signZ the {@code z} component of the vector {@code (signX, signY, signZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 copySign(float signX, float signY, float signZ, @Mutated Double3 dest) {
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
    public Float3 cos(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.cos(this.x);
        d.y = (float) Math.cos(this.y);
        d.z = (float) Math.cos(this.z);
        return d;
    }


    /**
     * Compute the cosine of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cos(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.cos(this.x);
        d.y = (float) Math.cos(this.y);
        d.z = (float) Math.cos(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 cosh(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.cosh(this.x);
        d.y = (float) Math.cosh(this.y);
        d.z = (float) Math.cosh(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cosh(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.cosh(this.x);
        d.y = (float) Math.cosh(this.y);
        d.z = (float) Math.cosh(this.z);
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
    public Float3 cross(Float3R other, @Mutated Float3 dest) {
        return cross(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Compute the cross product of this vector and {@code other} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cross(Float3R other, @Mutated Double3 dest) {
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
    public Float3 cross(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = otherZ * this.y - otherY * this.z;
        float _buf1 = otherX * this.z - otherZ * this.x;
        d.z = otherY * this.x - otherX * this.y;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Compute the cross product of this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     * and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 cross(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = otherZ * this.y - otherY * this.z;
        float _buf1 = otherX * this.z - otherZ * this.x;
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
    public Float3 degrees(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.toDegrees(this.x);
        d.y = (float) Math.toDegrees(this.y);
        d.z = (float) Math.toDegrees(this.z);
        return d;
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 degrees(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.toDegrees(this.x);
        d.y = (float) Math.toDegrees(this.y);
        d.z = (float) Math.toDegrees(this.z);
        return d;
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
    public float distance(Float3R other) {
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
        float _t0 = this.x - otherX;
        float _t1 = this.y - otherY;
        float _t2 = this.z - otherZ;
        return (float) Math.sqrt(_t0 * _t0 + _t1 * _t1 + _t2 * _t2);
    }


    /**
     * Compute the squared distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the squared distance between this vector and {@code other}
     */
    public float distanceSquared(Float3R other) {
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
        float _t0 = this.x - otherX;
        float _t1 = this.y - otherY;
        float _t2 = this.z - otherZ;
        return _t0 * _t0 + _t1 * _t1 + _t2 * _t2;
    }


    /**
     * Compute the dot product of this vector and {@code other}.
     *
     * @param other the other vector
     * @return the dot product of this vector and {@code other}
     */
    public float dot(Float3R other) {
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
        return otherX * this.x + otherY * this.y + otherZ * this.z;
    }


    /**
     * Compute the base-e exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 exp(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.exp(this.x);
        d.y = (float) Math.exp(this.y);
        d.z = (float) Math.exp(this.z);
        return d;
    }


    /**
     * Compute the base-e exponential of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 exp(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.exp(this.x);
        d.y = (float) Math.exp(this.y);
        d.z = (float) Math.exp(this.z);
        return d;
    }


    /**
     * Compute the base-2 exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 exp2(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.pow(2.0f, this.x);
        d.y = (float) Math.pow(2.0f, this.y);
        d.z = (float) Math.pow(2.0f, this.z);
        return d;
    }


    /**
     * Compute the base-2 exponential of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 exp2(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.pow(2.0f, this.x);
        d.y = (float) Math.pow(2.0f, this.y);
        d.z = (float) Math.pow(2.0f, this.z);
        return d;
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 expm1(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.expm1(this.x);
        d.y = (float) Math.expm1(this.y);
        d.z = (float) Math.expm1(this.z);
        return d;
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 expm1(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.expm1(this.x);
        d.y = (float) Math.expm1(this.y);
        d.z = (float) Math.expm1(this.z);
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
    public Float3 faceforward(Float3R I, Float3R Nref, @Mutated Float3 dest) {
        return faceforward(I.x(), I.y(), I.z(), Nref.x(), Nref.y(), Nref.z(), dest);
    }


    /**
     * Return this vector unchanged when {@code dot(Nref, I)} is negative, and negated otherwise -
     * orienting it against the incident direction {@code I} as judged by the reference vector
     * {@code Nref} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param I the vector
     * @param Nref the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 faceforward(Float3R I, Float3R Nref, @Mutated Double3 dest) {
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
    public Float3 faceforward(float IX, float IY, float IZ, float NrefX, float NrefY, float NrefZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t4 = IX * NrefX + IY * NrefY + IZ * NrefZ;
        if (_t4 < 0.0f) {
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
     * Return this vector unchanged when {@code dot((NrefX, NrefY, NrefZ), (IX, IY, IZ))} is
     * negative, and negated otherwise - orienting it against the incident direction ({@code IX},
     * {@code IY}, {@code IZ}) as judged by the reference vector ({@code NrefX}, {@code NrefY},
     * {@code NrefZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 faceforward(float IX, float IY, float IZ, float NrefX, float NrefY, float NrefZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t4 = IX * NrefX + IY * NrefY + IZ * NrefZ;
        if (_t4 < 0.0f) {
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
    public Float3 floor(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.floor(this.x);
        d.y = (float) Math.floor(this.y);
        d.z = (float) Math.floor(this.z);
        return d;
    }


    /**
     * Compute the floor of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 floor(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.floor(this.x);
        d.y = (float) Math.floor(this.y);
        d.z = (float) Math.floor(this.z);
        return d;
    }


    /**
     * Compute the fractional part of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 fract(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x - (float) Math.floor(this.x);
        d.y = this.y - (float) Math.floor(this.y);
        d.z = this.z - (float) Math.floor(this.z);
        return d;
    }


    /**
     * Compute the fractional part of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 fract(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x - (float) Math.floor(this.x);
        d.y = this.y - (float) Math.floor(this.y);
        d.z = this.z - (float) Math.floor(this.z);
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
    public Float3 hypot(float y, @Mutated Float3 dest) {
        return hypot(y, y, y, dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} {@code y} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(float y, @Mutated Double3 dest) {
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
    public Float3 hypot(Float3R y, @Mutated Float3 dest) {
        return hypot(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of {@code y} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param y the vector of other operands, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(Float3R y, @Mutated Double3 dest) {
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
    public Float3 hypot(float yX, float yY, float yZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.hypot(this.x, yX);
        d.y = (float) Math.hypot(this.y, yY);
        d.z = (float) Math.hypot(this.z, yZ);
        return d;
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(a² + b²)} with {@code a} each component
     * of this vector and {@code b} the corresponding component of ({@code yX}, {@code yY},
     * {@code yZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(float yX, float yY, float yZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.hypot(this.x, yX);
        d.y = (float) Math.hypot(this.y, yY);
        d.z = (float) Math.hypot(this.z, yZ);
        return d;
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 inverse(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = 1.0f / this.x;
        d.y = 1.0f / this.y;
        d.z = 1.0f / this.z;
        return d;
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 inverse(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 1.0f / this.x;
        d.y = 1.0f / this.y;
        d.z = 1.0f / this.z;
        return d;
    }


    /**
     * Compute the inverse square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 inverseSqrt(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (1.0f / (float) Math.sqrt(this.x));
        d.y = (1.0f / (float) Math.sqrt(this.y));
        d.z = (1.0f / (float) Math.sqrt(this.z));
        return d;
    }


    /**
     * Compute the inverse square root of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 inverseSqrt(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (1.0f / (float) Math.sqrt(this.x));
        d.y = (1.0f / (float) Math.sqrt(this.y));
        d.z = (1.0f / (float) Math.sqrt(this.z));
        return d;
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
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }


    /**
     * Compute the natural logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.log(this.x);
        d.y = (float) Math.log(this.y);
        d.z = (float) Math.log(this.z);
        return d;
    }


    /**
     * Compute the natural logarithm of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.log(this.x);
        d.y = (float) Math.log(this.y);
        d.z = (float) Math.log(this.z);
        return d;
    }


    /**
     * Compute the base-10 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log10(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.log10(this.x);
        d.y = (float) Math.log10(this.y);
        d.z = (float) Math.log10(this.z);
        return d;
    }


    /**
     * Compute the base-10 logarithm of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log10(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.log10(this.x);
        d.y = (float) Math.log10(this.y);
        d.z = (float) Math.log10(this.z);
        return d;
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log1p(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.log1p(this.x);
        d.y = (float) Math.log1p(this.y);
        d.z = (float) Math.log1p(this.z);
        return d;
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log1p(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.log1p(this.x);
        d.y = (float) Math.log1p(this.y);
        d.z = (float) Math.log1p(this.z);
        return d;
    }


    /**
     * Compute the base-2 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log2(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        d.x = (float) Math.log(this.x) * _t0_inv;
        d.y = (float) Math.log(this.y) * _t0_inv;
        d.z = (float) Math.log(this.z) * _t0_inv;
        return d;
    }


    /**
     * Compute the base-2 logarithm of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 log2(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        d.x = (float) Math.log(this.x) * _t0_inv;
        d.y = (float) Math.log(this.y) * _t0_inv;
        d.z = (float) Math.log(this.z) * _t0_inv;
        return d;
    }


    /**
     * Compute the Manhattan distance between this vector and {@code other}.
     *
     * @param other the other vector
     * @return the Manhattan distance between this vector and {@code other}
     */
    public float manhattanDistance(Float3R other) {
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
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Float3 max(float scalar, @Mutated Float3 dest) {
        return max(scalar, scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the larger of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 max(float scalar, @Mutated Double3 dest) {
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
    public Float3 max(Float3R other, @Mutated Float3 dest) {
        return max(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 max(Float3R other, @Mutated Double3 dest) {
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
    public Float3 max(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.max(this.x, otherX);
        d.y = Math.max(this.y, otherY);
        d.z = Math.max(this.z, otherZ);
        return d;
    }


    /**
     * Set each component of this vector to the larger of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 max(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
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
    public Float3 min(float scalar, @Mutated Float3 dest) {
        return min(scalar, scalar, scalar, dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and {@code scalar} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param scalar the scalar value
     * @param dest will hold the result
     * @return dest
     */
    public Double3 min(float scalar, @Mutated Double3 dest) {
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
    public Float3 min(Float3R other, @Mutated Float3 dest) {
        return min(other.x(), other.y(), other.z(), dest);
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * {@code other} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 min(Float3R other, @Mutated Double3 dest) {
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
    public Float3 min(float otherX, float otherY, float otherZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.min(this.x, otherX);
        d.y = Math.min(this.y, otherY);
        d.z = Math.min(this.z, otherZ);
        return d;
    }


    /**
     * Set each component of this vector to the smaller of itself and the corresponding component of
     * ({@code otherX}, {@code otherY}, {@code otherZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 min(float otherX, float otherY, float otherZ, @Mutated Double3 dest) {
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
    public Float3 mod(float y, @Mutated Float3 dest) {
        return mod(y, y, y, dest);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param y the divisor
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(float y, @Mutated Double3 dest) {
        return mod(y, y, y, dest);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     *
     * @param y the vector of divisors, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Float3 mod(Float3R y, @Mutated Float3 dest) {
        return mod(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by {@code y} and store the result in {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param y the vector of divisors, one per component
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(Float3R y, @Mutated Double3 dest) {
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
    public Float3 mod(float yX, float yY, float yZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x - yX * (float) Math.floor(this.x / yX);
        d.y = this.y - yY * (float) Math.floor(this.y / yY);
        d.z = this.z - yZ * (float) Math.floor(this.z / yZ);
        return d;
    }


    /**
     * Compute the component-wise floor-modulo {@code x - y * floor(x / y)} (GLSL {@code mod}) of
     * this vector divided by ({@code yX}, {@code yY}, {@code yZ}) and store the result in
     * {@code dest}.
     * <p>
     * The result takes the sign of the divisor, unlike Java's {@code %} operator, which follows the
     * dividend.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param yX the {@code x} component of the vector {@code (yX, yY, yZ)}
     * @param yY the {@code y} component of the vector {@code (yX, yY, yZ)}
     * @param yZ the {@code z} component of the vector {@code (yX, yY, yZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 mod(float yX, float yY, float yZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x - yX * (float) Math.floor(this.x / yX);
        d.y = this.y - yY * (float) Math.floor(this.y / yY);
        d.z = this.z - yZ * (float) Math.floor(this.z / yZ);
        return d;
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 nextDown(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.nextDown(this.x);
        d.y = Math.nextDown(this.y);
        d.z = Math.nextDown(this.z);
        return d;
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 nextUp(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.nextUp(this.x);
        d.y = Math.nextUp(this.y);
        d.z = Math.nextUp(this.z);
        return d;
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 normalize(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        if (_t4 > 0.0f) {
            d.x = this.x * _t5;
            d.y = this.y * _t5;
            d.z = this.z * _t5;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
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
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalize(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        if (_t4 > 0.0f) {
            d.x = this.x * _t5;
            d.y = this.y * _t5;
            d.z = this.z * _t5;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
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
    public Float3 normalizeMul(float length, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t6 = length * (1.0f / (float) Math.sqrt(_t4));
        if (_t4 > 0.0f) {
            d.x = this.x * _t6;
            d.y = this.y * _t6;
            d.z = this.z * _t6;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
    }


    /**
     * Normalize this vector and multiply the result by {@code length}, i.e. rescale it to that
     * length (the zero vector yields the zero vector) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param length the length to rescale to
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalizeMul(float length, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t4 = this.x * this.x + this.y * this.y + this.z * this.z;
        float _t6 = length * (1.0f / (float) Math.sqrt(_t4));
        if (_t4 > 0.0f) {
            d.x = this.x * _t6;
            d.y = this.y * _t6;
            d.z = this.z * _t6;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
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
    public float orientedAngle(Float3R other, Float3R normal) {
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
        float _t9 = otherZ * this.y - otherY * this.z;
        float _t10 = otherX * this.z - otherZ * this.x;
        float _t11 = otherY * this.x - otherX * this.y;
        float _t20 = (float) Math.atan2((float) Math.sqrt(_t10 * _t10 + _t9 * _t9 + _t11 * _t11), otherX * this.x + otherY * this.y + otherZ * this.z);
        return normalX * _t9 + normalY * _t10 + normalZ * _t11 < 0.0f ? -_t20 : _t20;
    }


    /**
     * Compute the outer product of this vector and {@code row} and store the result in
     * {@code dest}.
     *
     * @param row the row vector (right operand)
     * @param dest will hold the result
     * @return dest
     */
    public Float3x3 outerProduct(Float3R row, @Mutated Float3x3 dest) {
        return outerProduct(row.x(), row.y(), row.z(), dest);
    }


    /**
     * Compute the outer product of this vector and {@code row} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param row the row vector (right operand)
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 outerProduct(Float3R row, @Mutated Double3x3 dest) {
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
    public Float3x3 outerProduct(float rowX, float rowY, float rowZ, @Mutated Float3x3 dest) {
        Float3x3Impl d = (Float3x3Impl) dest;
        float _buf0 = rowX * this.x;
        d.m10 = rowX * this.y;
        d.m20 = rowX * this.z;
        float _buf1 = rowY * this.x;
        d.m11 = rowY * this.y;
        d.m21 = rowY * this.z;
        float _buf2 = rowZ * this.x;
        d.m12 = rowZ * this.y;
        d.m22 = rowZ * this.z;
        d.m00 = _buf0;
        d.m01 = _buf1;
        d.m02 = _buf2;
        d.properties = 0;
        return d;
    }


    /**
     * Compute the outer product of this vector and ({@code rowX}, {@code rowY}, {@code rowZ}) and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param rowX the {@code x} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowY the {@code y} component of the vector {@code (rowX, rowY, rowZ)}
     * @param rowZ the {@code z} component of the vector {@code (rowX, rowY, rowZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3x3 outerProduct(float rowX, float rowY, float rowZ, @Mutated Double3x3 dest) {
        Double3x3Impl d = (Double3x3Impl) dest;
        float _buf0 = rowX * this.x;
        d.m10 = rowX * this.y;
        d.m20 = rowX * this.z;
        float _buf1 = rowY * this.x;
        d.m11 = rowY * this.y;
        d.m21 = rowY * this.z;
        float _buf2 = rowZ * this.x;
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
    public Float3 perpendicular(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t2 = this.x * this.x + this.y * this.y;
        if (_t2 > 0.0f) {
            float _buf0 = this.y;
            float _buf1 = -this.x;
            d.z = 0.0f;
            d.x = _buf0;
            d.y = _buf1;
        } else {
            float _buf0 = 0.0f;
            float _buf1 = this.z;
            d.z = -this.y;
            d.x = _buf0;
            d.y = _buf1;
        }
        return d;
    }


    /**
     * Compute a vector perpendicular to this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 perpendicular(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t2 = this.x * this.x + this.y * this.y;
        if (_t2 > 0.0f) {
            float _buf0 = this.y;
            float _buf1 = -this.x;
            d.z = 0.0f;
            d.x = _buf0;
            d.y = _buf1;
        } else {
            float _buf0 = 0.0f;
            float _buf1 = this.z;
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
    public Float3 pow(float exponent, @Mutated Float3 dest) {
        return pow(exponent, exponent, exponent, dest);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    public Double3 pow(float exponent, @Mutated Double3 dest) {
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
    public Float3 pow(Float3R exponent, @Mutated Float3 dest) {
        return pow(exponent.x(), exponent.y(), exponent.z(), dest);
    }


    /**
     * Raise each component of this vector to the power of {@code exponent} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param exponent the exponent
     * @param dest will hold the result
     * @return dest
     */
    public Double3 pow(Float3R exponent, @Mutated Double3 dest) {
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
    public Float3 pow(float exponentX, float exponentY, float exponentZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.pow(this.x, exponentX);
        d.y = (float) Math.pow(this.y, exponentY);
        d.z = (float) Math.pow(this.z, exponentZ);
        return d;
    }


    /**
     * Raise each component of this vector to the power of ({@code exponentX}, {@code exponentY},
     * {@code exponentZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 pow(float exponentX, float exponentY, float exponentZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.pow(this.x, exponentX);
        d.y = (float) Math.pow(this.y, exponentY);
        d.z = (float) Math.pow(this.z, exponentZ);
        return d;
    }


    /**
     * Project this vector onto {@code onto} and store the result in {@code dest}.
     *
     * @param onto the vector to project onto
     * @param dest will hold the result
     * @return dest
     */
    public Float3 project(Float3R onto, @Mutated Float3 dest) {
        return project(onto.x(), onto.y(), onto.z(), dest);
    }


    /**
     * Project this vector onto {@code onto} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param onto the vector to project onto
     * @param dest will hold the result
     * @return dest
     */
    public Double3 project(Float3R onto, @Mutated Double3 dest) {
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
    public Float3 project(float ontoX, float ontoY, float ontoZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t8 = ontoX * this.x + ontoY * this.y + ontoZ * this.z;
        float _t9 = ontoX * ontoX + ontoY * ontoY + ontoZ * ontoZ;
        float _t9_inv = 1.0f / _t9;
        d.x = ontoX * _t8 * _t9_inv;
        d.y = ontoY * _t8 * _t9_inv;
        d.z = ontoZ * _t8 * _t9_inv;
        return d;
    }


    /**
     * Project this vector onto ({@code ontoX}, {@code ontoY}, {@code ontoZ}) and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param ontoX the {@code x} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param ontoY the {@code y} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param ontoZ the {@code z} component of the vector {@code (ontoX, ontoY, ontoZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 project(float ontoX, float ontoY, float ontoZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t8 = ontoX * this.x + ontoY * this.y + ontoZ * this.z;
        float _t9 = ontoX * ontoX + ontoY * ontoY + ontoZ * ontoZ;
        float _t9_inv = 1.0f / _t9;
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
    public Float3 projectOnPlane(Float3R normal, @Mutated Float3 dest) {
        return projectOnPlane(normal.x(), normal.y(), normal.z(), dest);
    }


    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 projectOnPlane(Float3R normal, @Mutated Double3 dest) {
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
    public Float3 projectOnPlane(float normalX, float normalY, float normalZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t4 = normalX * this.x + normalY * this.y + normalZ * this.z;
        d.x = this.x - normalX * _t4;
        d.y = this.y - normalY * _t4;
        d.z = this.z - normalZ * _t4;
        return d;
    }


    /**
     * Project this vector onto the plane with the given normal and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 projectOnPlane(float normalX, float normalY, float normalZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t4 = normalX * this.x + normalY * this.y + normalZ * this.z;
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
    public Float3 radians(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.toRadians(this.x);
        d.y = (float) Math.toRadians(this.y);
        d.z = (float) Math.toRadians(this.z);
        return d;
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 radians(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.toRadians(this.x);
        d.y = (float) Math.toRadians(this.y);
        d.z = (float) Math.toRadians(this.z);
        return d;
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Float3 reflect(Float3R normal, @Mutated Float3 dest) {
        return reflect(normal.x(), normal.y(), normal.z(), dest);
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param normal the normal (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 reflect(Float3R normal, @Mutated Double3 dest) {
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
    public Float3 reflect(float normalX, float normalY, float normalZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t5 = 2.0f * (normalX * this.x + normalY * this.y + normalZ * this.z);
        d.x = this.x - normalX * _t5;
        d.y = this.y - normalY * _t5;
        d.z = this.z - normalZ * _t5;
        return d;
    }


    /**
     * Reflect this vector about the given normal and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 reflect(float normalX, float normalY, float normalZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t5 = 2.0f * (normalX * this.x + normalY * this.y + normalZ * this.z);
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
    public Float3 refract(Float3R normal, float eta, @Mutated Float3 dest) {
        return refract(normal.x(), normal.y(), normal.z(), eta, dest);
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param normal the normal (must be a unit vector)
     * @param eta the ratio of indices of refraction, i.e. the source medium's divided by the
     *        destination medium's
     * @param dest will hold the result
     * @return dest
     */
    public Double3 refract(Float3R normal, float eta, @Mutated Double3 dest) {
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
    public Float3 refract(float normalX, float normalY, float normalZ, float eta, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t5 = normalX * this.x + normalY * this.y + normalZ * this.z;
        float _t10 = 1.0f - (1.0f - _t5 * _t5) * eta * eta;
        float _t13 = eta * _t5 + (float) Math.sqrt(Math.max(0.0f, _t10));
        if (_t10 >= 0.0f) {
            d.x = eta * this.x - normalX * _t13;
            d.y = eta * this.y - normalY * _t13;
            d.z = eta * this.z - normalZ * _t13;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
    }


    /**
     * Refract this vector (which must have unit length) through the surface with the given normal,
     * using the given ratio of indices of refraction (the zero vector is returned on total internal
     * reflection), and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 refract(float normalX, float normalY, float normalZ, float eta, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t5 = normalX * this.x + normalY * this.y + normalZ * this.z;
        float _t10 = 1.0f - (1.0f - _t5 * _t5) * eta * eta;
        float _t13 = eta * _t5 + (float) Math.sqrt(Math.max(0.0f, _t10));
        if (_t10 >= 0.0f) {
            d.x = eta * this.x - normalX * _t13;
            d.y = eta * this.y - normalY * _t13;
            d.z = eta * this.z - normalZ * _t13;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
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
    public Float3 round(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.rint(this.x);
        d.y = (float) Math.rint(this.y);
        d.z = (float) Math.rint(this.z);
        return d;
    }


    /**
     * Compute the value rounded to the nearest integer, ties to even ({@code Math.rint}) of each
     * component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 round(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.rint(this.x);
        d.y = (float) Math.rint(this.y);
        d.z = (float) Math.rint(this.z);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sign(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.signum(this.x);
        d.y = Math.signum(this.y);
        d.z = Math.signum(this.z);
        return d;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float3 sin(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.sin(this.x);
        d.y = (float) Math.sin(this.y);
        d.z = (float) Math.sin(this.z);
        return d;
    }


    /**
     * Compute the sine of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sin(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.sin(this.x);
        d.y = (float) Math.sin(this.y);
        d.z = (float) Math.sin(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic sine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sinh(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.sinh(this.x);
        d.y = (float) Math.sinh(this.y);
        d.z = (float) Math.sinh(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic sine of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sinh(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.sinh(this.x);
        d.y = (float) Math.sinh(this.y);
        d.z = (float) Math.sinh(this.z);
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
    public Float3 smoothstep(float edge0, float edge1, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t10 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0) * _t0_inv));
        float _t11 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0) * _t0_inv));
        float _t12 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0) * _t0_inv));
        d.x = (3.0f - 2.0f * _t10) * _t10 * _t10;
        d.y = (3.0f - 2.0f * _t11) * _t11 * _t11;
        d.z = (3.0f - 2.0f * _t12) * _t12 * _t12;
        return d;
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param dest will hold the result
     * @return dest
     */
    public Double3 smoothstep(float edge0, float edge1, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t10 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0) * _t0_inv));
        float _t11 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0) * _t0_inv));
        float _t12 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0) * _t0_inv));
        d.x = (3.0f - 2.0f * _t10) * _t10 * _t10;
        d.y = (3.0f - 2.0f * _t11) * _t11 * _t11;
        d.z = (3.0f - 2.0f * _t12) * _t12 * _t12;
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
    public Float3 smoothstep(Float3R edge0, Float3R edge1, @Mutated Float3 dest) {
        return smoothstep(edge0.x(), edge0.y(), edge0.z(), edge1.x(), edge1.y(), edge1.z(), dest);
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge {@code edge0} and the upper edge {@code edge1}, yielding 0 at or below the lower
     * edge and 1 at or above the upper edge and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param edge0 the lower edge
     * @param edge1 the upper edge
     * @param dest will hold the result
     * @return dest
     */
    public Double3 smoothstep(Float3R edge0, Float3R edge1, @Mutated Double3 dest) {
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
    public Float3 smoothstep(float edge0X, float edge0Y, float edge0Z, float edge1X, float edge1Y, float edge1Z, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t12 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0X) / (edge1X - edge0X)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0Y) / (edge1Y - edge0Y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0Z) / (edge1Z - edge0Z)));
        d.x = (3.0f - 2.0f * _t12) * _t12 * _t12;
        d.y = (3.0f - 2.0f * _t13) * _t13 * _t13;
        d.z = (3.0f - 2.0f * _t14) * _t14 * _t14;
        return d;
    }


    /**
     * Compute the smooth Hermite step of each component of this vector as it ramps between the
     * lower edge ({@code edge0X}, {@code edge0Y}, {@code edge0Z}) and the upper edge
     * ({@code edge1X}, {@code edge1Y}, {@code edge1Z}), yielding 0 at or below the lower edge and 1
     * at or above the upper edge and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 smoothstep(float edge0X, float edge0Y, float edge0Z, float edge1X, float edge1Y, float edge1Z, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t12 = Math.max(0.0f, Math.min(1.0f, (this.x - edge0X) / (edge1X - edge0X)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (this.y - edge0Y) / (edge1Y - edge0Y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (this.z - edge0Z) / (edge1Z - edge0Z)));
        d.x = (3.0f - 2.0f * _t12) * _t12 * _t12;
        d.y = (3.0f - 2.0f * _t13) * _t13 * _t13;
        d.z = (3.0f - 2.0f * _t14) * _t14 * _t14;
        return d;
    }


    /**
     * Compute the square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sqrt(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.sqrt(this.x);
        d.y = (float) Math.sqrt(this.y);
        d.z = (float) Math.sqrt(this.z);
        return d;
    }


    /**
     * Compute the square root of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 sqrt(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.sqrt(this.x);
        d.y = (float) Math.sqrt(this.y);
        d.z = (float) Math.sqrt(this.z);
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
    public Float3 step(float edge, @Mutated Float3 dest) {
        return step(edge, edge, edge, dest);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than {@code edge}, and to
     * {@code 1} otherwise and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    public Double3 step(float edge, @Mutated Double3 dest) {
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
    public Float3 step(Float3R edge, @Mutated Float3 dest) {
        return step(edge.x(), edge.y(), edge.z(), dest);
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param edge the edge to compare each component against
     * @param dest will hold the result
     * @return dest
     */
    public Double3 step(Float3R edge, @Mutated Double3 dest) {
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
    public Float3 step(float edgeX, float edgeY, float edgeZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x < edgeX ? 0.0f : 1.0f;
        d.y = this.y < edgeY ? 0.0f : 1.0f;
        d.z = this.z < edgeZ ? 0.0f : 1.0f;
        return d;
    }


    /**
     * Set each component of this vector to {@code 0} when it is smaller than the corresponding
     * component of the given edge, and to {@code 1} otherwise and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param edgeX the {@code x} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param edgeY the {@code y} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param edgeZ the {@code z} component of the vector {@code (edgeX, edgeY, edgeZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 step(float edgeX, float edgeY, float edgeZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x < edgeX ? 0.0f : 1.0f;
        d.y = this.y < edgeY ? 0.0f : 1.0f;
        d.z = this.z < edgeZ ? 0.0f : 1.0f;
        return d;
    }


    /**
     * Compute the tangent of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 tan(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.tan(this.x);
        d.y = (float) Math.tan(this.y);
        d.z = (float) Math.tan(this.z);
        return d;
    }


    /**
     * Compute the tangent of each component of this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 tan(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.tan(this.x);
        d.y = (float) Math.tan(this.y);
        d.z = (float) Math.tan(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 tanh(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = (float) Math.tanh(this.x);
        d.y = (float) Math.tanh(this.y);
        d.z = (float) Math.tanh(this.z);
        return d;
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 tanh(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = (float) Math.tanh(this.x);
        d.y = (float) Math.tanh(this.y);
        d.z = (float) Math.tanh(this.z);
        return d;
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize((p1 - this) x (p2 - this))} - it points to the side from which the vertices
     * {@code this}, {@code p1}, {@code p2} appear counter-clockwise (a degenerate triangle yields
     * the zero vector) and store the result in {@code dest}.
     *
     * @param p1 the second vertex of the triangle (this vector is the first)
     * @param p2 the third vertex of the triangle
     * @param dest will hold the result
     * @return dest
     */
    public Float3 triangleNormal(Float3R p1, Float3R p2, @Mutated Float3 dest) {
        return triangleNormal(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), dest);
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize((p1 - this) x (p2 - this))} - it points to the side from which the vertices
     * {@code this}, {@code p1}, {@code p2} appear counter-clockwise (a degenerate triangle yields
     * the zero vector) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the second vertex of the triangle (this vector is the first)
     * @param p2 the third vertex of the triangle
     * @param dest will hold the result
     * @return dest
     */
    public Double3 triangleNormal(Float3R p1, Float3R p2, @Mutated Double3 dest) {
        return triangleNormal(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), dest);
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize(((p1X, p1Y, p1Z) - this) x ((p2X, p2Y, p2Z) - this))} - it points to the
     * side from which the vertices {@code this}, ({@code p1X}, {@code p1Y}, {@code p1Z}),
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) appear counter-clockwise (a degenerate triangle
     * yields the zero vector) and store the result in {@code dest}.
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
    public Float3 triangleNormal(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = p1Y - this.y;
        float _t1 = p2Z - this.z;
        float _t2 = p1Z - this.z;
        float _t3 = p2Y - this.y;
        float _t4 = p2X - this.x;
        float _t5 = p1X - this.x;
        float _t12 = _t0 * _t1 - _t2 * _t3;
        float _t13 = _t2 * _t4 - _t5 * _t1;
        float _t14 = _t5 * _t3 - _t0 * _t4;
        float _t19 = _t12 * _t12 + _t13 * _t13 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t12 * _t20;
            d.y = _t13 * _t20;
            d.z = _t14 * _t20;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
        }
        return d;
    }


    /**
     * Compute the unit normal of the triangle spanned by this vector and the two given points, i.e.
     * {@code normalize(((p1X, p1Y, p1Z) - this) x ((p2X, p2Y, p2Z) - this))} - it points to the
     * side from which the vertices {@code this}, ({@code p1X}, {@code p1Y}, {@code p1Z}),
     * ({@code p2X}, {@code p2Y}, {@code p2Z}) appear counter-clockwise (a degenerate triangle
     * yields the zero vector) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 triangleNormal(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = p1Y - this.y;
        float _t1 = p2Z - this.z;
        float _t2 = p1Z - this.z;
        float _t3 = p2Y - this.y;
        float _t4 = p2X - this.x;
        float _t5 = p1X - this.x;
        float _t12 = _t0 * _t1 - _t2 * _t3;
        float _t13 = _t2 * _t4 - _t5 * _t1;
        float _t14 = _t5 * _t3 - _t0 * _t4;
        float _t19 = _t12 * _t12 + _t13 * _t13 + _t14 * _t14;
        float _t20 = (1.0f / (float) Math.sqrt(_t19));
        if (_t19 > 0.0f) {
            d.x = _t12 * _t20;
            d.y = _t13 * _t20;
            d.z = _t14 * _t20;
        } else {
            d.x = 0.0f;
            d.y = 0.0f;
            d.z = 0.0f;
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
    public Float3 trunc(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x >= 0.0f ? (float) Math.floor(this.x) : (float) Math.ceil(this.x);
        d.y = this.y >= 0.0f ? (float) Math.floor(this.y) : (float) Math.ceil(this.y);
        d.z = this.z >= 0.0f ? (float) Math.floor(this.z) : (float) Math.ceil(this.z);
        return d;
    }


    /**
     * Compute the truncated value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 trunc(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x >= 0.0f ? (float) Math.floor(this.x) : (float) Math.ceil(this.x);
        d.y = this.y >= 0.0f ? (float) Math.floor(this.y) : (float) Math.ceil(this.y);
        d.z = this.z >= 0.0f ? (float) Math.floor(this.z) : (float) Math.ceil(this.z);
        return d;
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 ulp(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = Math.ulp(this.x);
        d.y = Math.ulp(this.y);
        d.z = Math.ulp(this.z);
        return d;
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Float4 xyz0(@Mutated Float4 dest) {
        Float4Impl d = (Float4Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = 0.0f;
        return d;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 0} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 xyz0(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = 0.0f;
        return d;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4 xyz1(@Mutated Float4 dest) {
        Float4Impl d = (Float4Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = 1.0f;
        return d;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double4 xyz1(@Mutated Double4 dest) {
        Double4Impl d = (Double4Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.w = 1.0f;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this} and store the
     * result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3 preMul(Float3x3R mat, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        float _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
        d.z = mat.m20() * this.x + mat.m21() * this.y + mat.m22() * this.z;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, i.e. compute {@code mat * this} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMul(Float3x3R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        float _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
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
    public Float3 preMulDirection(Float3x4R mat, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        float _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
        d.z = mat.m20() * this.x + mat.m21() * this.y + mat.m22() * this.z;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulDirection(Float3x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        float _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
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
    public Float3 preMulDirection(Float4x4R mat, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        float _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
        d.z = mat.m20() * this.x + mat.m21() * this.y + mat.m22() * this.z;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a direction with implicit {@code w = 0}
     * - i.e. compute {@code (mat * (this, 0)).xyz}, applying only rotation and scale and ignoring
     * translation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulDirection(Float4x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = mat.m00() * this.x + mat.m01() * this.y + mat.m02() * this.z;
        float _buf1 = mat.m10() * this.x + mat.m11() * this.y + mat.m12() * this.z;
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
    public Float3 preMulPosition(Float3x4R mat, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()));
        float _buf1 = mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()));
        d.z = mat.m20() * this.x + (mat.m21() * this.y + (mat.m22() * this.z + mat.m23()));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulPosition(Float3x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()));
        float _buf1 = mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()));
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
    public Float3 preMulPosition(Float4x4R mat, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _buf0 = mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()));
        float _buf1 = mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()));
        d.z = mat.m20() * this.x + (mat.m21() * this.y + (mat.m22() * this.z + mat.m23()));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1}
     * - i.e. compute {@code (mat * (this, 1)).xyz}, applying the full affine transform including
     * translation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulPosition(Float4x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _buf0 = mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()));
        float _buf1 = mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()));
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
    public Float3 preMulProject(Float4x4R mat, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t5 = mat.m30() * this.x + (mat.m31() * this.y + (mat.m32() * this.z + mat.m33()));
        float _t5_inv = 1.0f / _t5;
        float _buf0 = (mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()))) * _t5_inv;
        float _buf1 = (mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()))) * _t5_inv;
        d.z = (mat.m20() * this.x + (mat.m21() * this.y + (mat.m22() * this.z + mat.m23()))) * _t5_inv;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Pre-multiply {@code mat} onto this vector, treated as a position with implicit {@code w = 1},
     * then perform a perspective divide - i.e. compute {@code r = mat * (this, 1)} and return
     * {@code r.xyz / r.w} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMulProject(Float4x4R mat, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t5 = mat.m30() * this.x + (mat.m31() * this.y + (mat.m32() * this.z + mat.m33()));
        float _t5_inv = 1.0f / _t5;
        float _buf0 = (mat.m00() * this.x + (mat.m01() * this.y + (mat.m02() * this.z + mat.m03()))) * _t5_inv;
        float _buf1 = (mat.m10() * this.x + (mat.m11() * this.y + (mat.m12() * this.z + mat.m13()))) * _t5_inv;
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
    public Float3 rotate(FloatQuatR quat, @Mutated Float3 dest) {
        return rotate(quat.x(), quat.y(), quat.z(), quat.w(), dest);
    }


    /**
     * Rotate this vector by the quaternion {@code quat}, i.e. compute {@code q * this * q^-1} and
     * store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotate(FloatQuatR quat, @Mutated Double3 dest) {
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
    public Float3 rotate(float quatX, float quatY, float quatZ, float quatW, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * (quatX * this.y - quatY * this.x);
        float _t10 = 2.0f * (quatY * this.z - quatZ * this.y);
        float _t11 = 2.0f * (quatZ * this.x - quatX * this.z);
        d.x = quatY * _t9 + (quatW * _t10 + this.x - quatZ * _t11);
        d.y = quatZ * _t10 + (quatW * _t11 + this.y - quatX * _t9);
        d.z = quatX * _t11 + (quatW * _t9 + this.z - quatY * _t10);
        return d;
    }


    /**
     * Rotate this vector by the quaternion ({@code quatX}, {@code quatY}, {@code quatZ},
     * {@code quatW}), i.e. compute {@code q * this * q^-1} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 rotate(float quatX, float quatY, float quatZ, float quatW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * (quatX * this.y - quatY * this.x);
        float _t10 = 2.0f * (quatY * this.z - quatZ * this.y);
        float _t11 = 2.0f * (quatZ * this.x - quatX * this.z);
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
    public Float3 rotateAxis(float angle, Float3R axis, @Mutated Float3 dest) {
        return rotateAxis(angle, axis.x(), axis.y(), axis.z(), dest);
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis {@code axis} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param axis the rotation axis (must be a unit vector)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateAxis(float angle, Float3R axis, @Mutated Double3 dest) {
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
    public Float3 rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t7 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _buf0 = this.x * _t0 + (axisY * this.z - axisZ * this.y) * _t1 + _t2 * axisX * _t7;
        float _buf1 = this.y * _t0 + (axisZ * this.x - axisX * this.z) * _t1 + _t2 * axisY * _t7;
        d.z = this.z * _t0 + (axisX * this.y - axisY * this.x) * _t1 + _t2 * axisZ * _t7;
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the axis ({@code axisX}, {@code axisY},
     * {@code axisZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 rotateAxis(float angle, float axisX, float axisY, float axisZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t7 = axisX * this.x + axisY * this.y + axisZ * this.z;
        float _buf0 = this.x * _t0 + (axisY * this.z - axisZ * this.y) * _t1 + _t2 * axisX * _t7;
        float _buf1 = this.y * _t0 + (axisZ * this.x - axisX * this.z) * _t1 + _t2 * axisY * _t7;
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
    public Float3 rotateInverse(FloatQuatR quat, @Mutated Float3 dest) {
        return rotateInverse(quat.x(), quat.y(), quat.z(), quat.w(), dest);
    }


    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param quat the quaternion (must be a unit quaternion)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateInverse(FloatQuatR quat, @Mutated Double3 dest) {
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
    public Float3 rotateInverse(float quatX, float quatY, float quatZ, float quatW, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t9 = 2.0f * (quatX * this.z - quatZ * this.x);
        float _t10 = 2.0f * (quatZ * this.y - quatY * this.z);
        float _t11 = 2.0f * (quatY * this.x - quatX * this.y);
        d.x = quatZ * _t9 + (quatW * _t10 + this.x - quatY * _t11);
        d.y = quatX * _t11 + (quatW * _t9 + this.y - quatZ * _t10);
        d.z = quatY * _t10 + (quatW * _t11 + this.z - quatX * _t9);
        return d;
    }


    /**
     * Rotate this vector by the inverse of the given rotation and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public Double3 rotateInverse(float quatX, float quatY, float quatZ, float quatW, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t9 = 2.0f * (quatX * this.z - quatZ * this.x);
        float _t10 = 2.0f * (quatZ * this.y - quatY * this.z);
        float _t11 = 2.0f * (quatY * this.x - quatX * this.y);
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
    public Float3 rotateX(float angle, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.x = this.x;
        float _buf0 = this.y * _t0 - this.z * _t1;
        d.z = this.y * _t1 + this.z * _t0;
        d.y = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the X axis and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateX(float angle, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        d.x = this.x;
        float _buf0 = this.y * _t0 - this.z * _t1;
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
    public Float3 rotateY(float angle, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = this.x * _t0 + this.z * _t1;
        d.y = this.y;
        d.z = this.z * _t0 - this.x * _t1;
        d.x = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the Y axis and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateY(float angle, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = this.x * _t0 + this.z * _t1;
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
    public Float3 rotateZ(float angle, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = this.x * _t0 - this.y * _t1;
        d.y = this.x * _t1 + this.y * _t0;
        d.z = this.z;
        d.x = _buf0;
        return d;
    }


    /**
     * Rotate this vector by {@code angle} radians about the Z axis and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param angle the angle in radians
     * @param dest will hold the result
     * @return dest
     */
    public Double3 rotateZ(float angle, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = this.x * _t0 - this.y * _t1;
        d.y = this.x * _t1 + this.y * _t0;
        d.z = this.z;
        d.x = _buf0;
        return d;
    }

    public float x() { return this.x; }
    public float y() { return this.y; }
    public float z() { return this.z; }

    public Float2 xx(@Mutated Float2 dest) {
        float _v0 = this.x;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Float2 xy(@Mutated Float2 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Float2 xz(@Mutated Float2 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Float2 yx(@Mutated Float2 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Float2 yy(@Mutated Float2 dest) {
        float _v0 = this.y;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Float2 yz(@Mutated Float2 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Float2 zx(@Mutated Float2 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Float2 zy(@Mutated Float2 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v1;
        return dest;
    }

    public Float2 zz(@Mutated Float2 dest) {
        float _v0 = this.z;
        Float2Impl d = (Float2Impl) dest;
        d.x = _v0;
        d.y = _v0;
        return dest;
    }

    public Float3 xxx(@Mutated Float3 dest) {
        float _v0 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Float3 xxy(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Float3 xxz(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Float3 xyx(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Float3 xyy(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Float3 xyz(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Float3 xzx(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Float3 xzy(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Float3 xzz(@Mutated Float3 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Float3 yxx(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Float3 yxy(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Float3 yxz(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Float3 yyx(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Float3 yyy(@Mutated Float3 dest) {
        float _v0 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Float3 yyz(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Float3 yzx(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Float3 yzy(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Float3 yzz(@Mutated Float3 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Float3 zxx(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Float3 zxy(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Float3 zxz(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Float3 zyx(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        return dest;
    }

    public Float3 zyy(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        return dest;
    }

    public Float3 zyz(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        return dest;
    }

    public Float3 zzx(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Float3 zzy(@Mutated Float3 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        return dest;
    }

    public Float3 zzz(@Mutated Float3 dest) {
        float _v0 = this.z;
        Float3Impl d = (Float3Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        return dest;
    }

    public Float4 xxxx(@Mutated Float4 dest) {
        float _v0 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 xxxy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 xxxz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 xxyx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 xxyy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 xxyz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 xxzx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 xxzy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 xxzz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 xyxx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 xyxy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 xyxz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Float4 xyyx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 xyyy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 xyyz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 xyzx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Float4 xyzy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Float4 xyzz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.y;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Float4 xzxx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 xzxy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Float4 xzxz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 xzyx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Float4 xzyy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Float4 xzyz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Float4 xzzx(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 xzzy(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 xzzz(@Mutated Float4 dest) {
        float _v0 = this.x;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 yxxx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 yxxy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 yxxz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 yxyx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 yxyy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 yxyz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Float4 yxzx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Float4 yxzy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Float4 yxzz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Float4 yyxx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 yyxy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 yyxz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        float _v2 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 yyyx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 yyyy(@Mutated Float4 dest) {
        float _v0 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 yyyz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 yyzx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 yyzy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 yyzz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 yzxx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Float4 yzxy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Float4 yzxz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Float4 yzyx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Float4 yzyy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 yzyz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 yzzx(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 yzzy(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 yzzz(@Mutated Float4 dest) {
        float _v0 = this.y;
        float _v1 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 zxxx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 zxxy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 zxxz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 zxyx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Float4 zxyy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Float4 zxyz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Float4 zxzx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 zxzy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Float4 zxzz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 zyxx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v2;
        return dest;
    }

    public Float4 zyxy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v1;
        return dest;
    }

    public Float4 zyxz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v2;
        d.w = _v0;
        return dest;
    }

    public Float4 zyyx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 zyyy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 zyyz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 zyzx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v2;
        return dest;
    }

    public Float4 zyzy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 zyzz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v1;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    public Float4 zzxx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 zzxy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        float _v2 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 zzxz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 zzyx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        float _v2 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v2;
        return dest;
    }

    public Float4 zzyy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v1;
        return dest;
    }

    public Float4 zzyz(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v1;
        d.w = _v0;
        return dest;
    }

    public Float4 zzzx(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.x;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 zzzy(@Mutated Float4 dest) {
        float _v0 = this.z;
        float _v1 = this.y;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v1;
        return dest;
    }

    public Float4 zzzz(@Mutated Float4 dest) {
        float _v0 = this.z;
        Float4Impl d = (Float4Impl) dest;
        d.x = _v0;
        d.y = _v0;
        d.z = _v0;
        d.w = _v0;
        return dest;
    }

    @Override public String toString() {
        return "Float3(" + x() + ", " + y() + ", " + z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float3Impl)) return false;
        Float3Impl o = (Float3Impl) obj;
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

    @Override public boolean isFinite() {
        return Float.isFinite(x)
            && Float.isFinite(y)
            && Float.isFinite(z);
    }

    @Override public boolean equalsEpsilon(Float3R other, float epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        return dest;
    }
    public @Mutated Float3 load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Float3 loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public Float3 loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public Float3 storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public Float3 loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public Float3 load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        return dest;
    }
    public @Mutated Float3 load(double[] src, int offset) {
        this.x = (float) src[offset + 0];
        this.y = (float) src[offset + 1];
        this.z = (float) src[offset + 2];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public Float3 loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public Float3 loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public Float3 storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public Float3 loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public Float3 loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
