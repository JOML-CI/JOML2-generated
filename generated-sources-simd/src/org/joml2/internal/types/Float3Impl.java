package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import jdk.incubator.vector.*;
import org.joml2.internal.simd.*;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link Float3} backed by a {@code float[]} array, with Vector API
 * SIMD kernels where profitable.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class Float3Impl implements Float3 {

    public float[] data;
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
        data = new float[3];
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = otherX + sd[0];
        dd[1] = otherY + sd[1];
        dd[2] = otherZ + sd[2];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = otherX + sd[0];
        dd[1] = otherY + sd[1];
        dd[2] = otherZ + sd[2];
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0] / otherX;
        dd[1] = sd[1] / otherY;
        dd[2] = sd[2] / otherZ;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0] / otherX;
        dd[1] = sd[1] / otherY;
        dd[2] = sd[2] / otherZ;
        return dest;
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
    public Float3 fma(float b, float cX, float cY, float cZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(sd[0], b, cX);
        dd[1] = Math.fma(sd[1], b, cY);
        dd[2] = Math.fma(sd[2], b, cZ);
        return dest;
    }


    /**
     * Multiply this vector component-wise by {@code b} and add ({@code cX}, {@code cY},
     * {@code cZ}), i.e. compute {@code this * b + c} per component and store the result in
     * {@code dest}.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(sd[0], b, cX);
        dd[1] = Math.fma(sd[1], b, cY);
        dd[2] = Math.fma(sd[2], b, cZ);
        return dest;
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
    public Float3 fma(float bX, float bY, float bZ, float cX, float cY, float cZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(sd[0], bX, cX);
        dd[1] = Math.fma(sd[1], bY, cY);
        dd[2] = Math.fma(sd[2], bZ, cZ);
        return dest;
    }


    /**
     * Multiply this vector component-wise by ({@code bX}, {@code bY}, {@code bZ}) and add
     * ({@code cX}, {@code cY}, {@code cZ}), i.e. compute {@code this * b + c} per component and
     * store the result in {@code dest}.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(sd[0], bX, cX);
        dd[1] = Math.fma(sd[1], bY, cY);
        dd[2] = Math.fma(sd[2], bZ, cZ);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = otherX * sd[0];
        dd[1] = otherY * sd[1];
        dd[2] = otherZ * sd[2];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = otherX * sd[0];
        dd[1] = otherY * sd[1];
        dd[2] = otherZ * sd[2];
        return dest;
    }


    /**
     * Negate this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 negate(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = -sd[0];
        dd[1] = -sd[1];
        dd[2] = -sd[2];
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0] - otherX;
        dd[1] = sd[1] - otherY;
        dd[2] = sd[2] - otherZ;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0] - otherX;
        dd[1] = sd[1] - otherY;
        dd[2] = sd[2] - otherZ;
        return dest;
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
        float[] dd = this.data;
        dd[0] = vX;
        dd[1] = vY;
        dd[2] = vZ;
        return this;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Float3 set(float s, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = s;
        dd[1] = s;
        dd[2] = s;
        return dest;
    }


    /**
     * Set this vector to {@code s} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param s the uniform scale factor
     * @param dest will hold the result
     * @return dest
     */
    public Double3 set(float s, @Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = s;
        dd[1] = s;
        dd[2] = s;
        return dest;
    }


    /**
     * Convert this vector to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 toDouble(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
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
        float[] sd = this.data;
        byte[] dd = ((Byte3Impl) dest).data;
        dd[0] = (byte) (sd[0]);
        dd[1] = (byte) (sd[1]);
        dd[2] = (byte) (sd[2]);
        return dest;
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
        float[] sd = this.data;
        byte[] dd = ((Byte3Impl) dest).data;
        switch (roundingMode) {
            case TRUNCATE -> { return toByte(dest); }
            case FLOOR -> {
                dd[0] = (byte) Math.floor(sd[0]);
                dd[1] = (byte) Math.floor(sd[1]);
                dd[2] = (byte) Math.floor(sd[2]);
            }
            case CEILING -> {
                dd[0] = (byte) Math.ceil(sd[0]);
                dd[1] = (byte) Math.ceil(sd[1]);
                dd[2] = (byte) Math.ceil(sd[2]);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                dd[0] = (byte) Math.round(sd[0]);
                dd[1] = (byte) Math.round(sd[1]);
                dd[2] = (byte) Math.round(sd[2]);
            }
            case HALF_AWAY_FROM_ZERO -> {
                dd[0] = (byte) (sd[0] >= 0 ? Math.floor(sd[0] + 0.5) : Math.ceil(sd[0] - 0.5));
                dd[1] = (byte) (sd[1] >= 0 ? Math.floor(sd[1] + 0.5) : Math.ceil(sd[1] - 0.5));
                dd[2] = (byte) (sd[2] >= 0 ? Math.floor(sd[2] + 0.5) : Math.ceil(sd[2] - 0.5));
            }
            case HALF_EVEN -> {
                dd[0] = (byte) Math.rint(sd[0]);
                dd[1] = (byte) Math.rint(sd[1]);
                dd[2] = (byte) Math.rint(sd[2]);
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
        float[] sd = this.data;
        short[] dd = ((Short3Impl) dest).data;
        dd[0] = (short) (sd[0]);
        dd[1] = (short) (sd[1]);
        dd[2] = (short) (sd[2]);
        return dest;
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
        float[] sd = this.data;
        short[] dd = ((Short3Impl) dest).data;
        switch (roundingMode) {
            case TRUNCATE -> { return toShort(dest); }
            case FLOOR -> {
                dd[0] = (short) Math.floor(sd[0]);
                dd[1] = (short) Math.floor(sd[1]);
                dd[2] = (short) Math.floor(sd[2]);
            }
            case CEILING -> {
                dd[0] = (short) Math.ceil(sd[0]);
                dd[1] = (short) Math.ceil(sd[1]);
                dd[2] = (short) Math.ceil(sd[2]);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                dd[0] = (short) Math.round(sd[0]);
                dd[1] = (short) Math.round(sd[1]);
                dd[2] = (short) Math.round(sd[2]);
            }
            case HALF_AWAY_FROM_ZERO -> {
                dd[0] = (short) (sd[0] >= 0 ? Math.floor(sd[0] + 0.5) : Math.ceil(sd[0] - 0.5));
                dd[1] = (short) (sd[1] >= 0 ? Math.floor(sd[1] + 0.5) : Math.ceil(sd[1] - 0.5));
                dd[2] = (short) (sd[2] >= 0 ? Math.floor(sd[2] + 0.5) : Math.ceil(sd[2] - 0.5));
            }
            case HALF_EVEN -> {
                dd[0] = (short) Math.rint(sd[0]);
                dd[1] = (short) Math.rint(sd[1]);
                dd[2] = (short) Math.rint(sd[2]);
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
        float[] sd = this.data;
        int[] dd = ((Int3Impl) dest).data;
        dd[0] = (int) (sd[0]);
        dd[1] = (int) (sd[1]);
        dd[2] = (int) (sd[2]);
        return dest;
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
        float[] sd = this.data;
        int[] dd = ((Int3Impl) dest).data;
        switch (roundingMode) {
            case TRUNCATE -> { return toInt(dest); }
            case FLOOR -> {
                dd[0] = (int) Math.floor(sd[0]);
                dd[1] = (int) Math.floor(sd[1]);
                dd[2] = (int) Math.floor(sd[2]);
            }
            case CEILING -> {
                dd[0] = (int) Math.ceil(sd[0]);
                dd[1] = (int) Math.ceil(sd[1]);
                dd[2] = (int) Math.ceil(sd[2]);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                dd[0] = Math.round(sd[0]);
                dd[1] = Math.round(sd[1]);
                dd[2] = Math.round(sd[2]);
            }
            case HALF_AWAY_FROM_ZERO -> {
                dd[0] = (int) (sd[0] >= 0 ? Math.floor(sd[0] + 0.5) : Math.ceil(sd[0] - 0.5));
                dd[1] = (int) (sd[1] >= 0 ? Math.floor(sd[1] + 0.5) : Math.ceil(sd[1] - 0.5));
                dd[2] = (int) (sd[2] >= 0 ? Math.floor(sd[2] + 0.5) : Math.ceil(sd[2] - 0.5));
            }
            case HALF_EVEN -> {
                dd[0] = (int) Math.rint(sd[0]);
                dd[1] = (int) Math.rint(sd[1]);
                dd[2] = (int) Math.rint(sd[2]);
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
        float[] sd = this.data;
        long[] dd = ((Long3Impl) dest).data;
        dd[0] = (long) (sd[0]);
        dd[1] = (long) (sd[1]);
        dd[2] = (long) (sd[2]);
        return dest;
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
        float[] sd = this.data;
        long[] dd = ((Long3Impl) dest).data;
        switch (roundingMode) {
            case TRUNCATE -> { return toLong(dest); }
            case FLOOR -> {
                dd[0] = (long) Math.floor(sd[0]);
                dd[1] = (long) Math.floor(sd[1]);
                dd[2] = (long) Math.floor(sd[2]);
            }
            case CEILING -> {
                dd[0] = (long) Math.ceil(sd[0]);
                dd[1] = (long) Math.ceil(sd[1]);
                dd[2] = (long) Math.ceil(sd[2]);
            }
            case HALF_TOWARD_POSITIVE_INFINITY -> {
                dd[0] = Math.round((double) (sd[0]));
                dd[1] = Math.round((double) (sd[1]));
                dd[2] = Math.round((double) (sd[2]));
            }
            case HALF_AWAY_FROM_ZERO -> {
                dd[0] = (long) (sd[0] >= 0 ? Math.floor(sd[0] + 0.5) : Math.ceil(sd[0] - 0.5));
                dd[1] = (long) (sd[1] >= 0 ? Math.floor(sd[1] + 0.5) : Math.ceil(sd[1] - 0.5));
                dd[2] = (long) (sd[2] >= 0 ? Math.floor(sd[2] + 0.5) : Math.ceil(sd[2] - 0.5));
            }
            case HALF_EVEN -> {
                dd[0] = (long) Math.rint(sd[0]);
                dd[1] = (long) Math.rint(sd[1]);
                dd[2] = (long) Math.rint(sd[2]);
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
        float[] dd = this.data;
        dd[0] = 0.0f;
        dd[1] = 0.0f;
        dd[2] = 0.0f;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        dd[0] = Math.fma(p1X, _t7, sd[0] * _t8) + Math.fma(p2X, _t6, p3X * _t2);
        dd[1] = Math.fma(p1Y, _t7, sd[1] * _t8) + Math.fma(p2Y, _t6, p3Y * _t2);
        dd[2] = Math.fma(p1Z, _t7, sd[2] * _t8) + Math.fma(p2Z, _t6, p3Z * _t2);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        dd[0] = Math.fma(p1X, _t7, sd[0] * _t8) + Math.fma(p2X, _t6, p3X * _t2);
        dd[1] = Math.fma(p1Y, _t7, sd[1] * _t8) + Math.fma(p2Y, _t6, p3Y * _t2);
        dd[2] = Math.fma(p1Z, _t7, sd[2] * _t8) + Math.fma(p2Z, _t6, p3Z * _t2);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        dd[0] = Math.fma(p2X, _t0, Math.fma(p1X, _t3, sd[0] * _t4));
        dd[1] = Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, sd[1] * _t4));
        dd[2] = Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, sd[2] * _t4));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        dd[0] = Math.fma(p2X, _t0, Math.fma(p1X, _t3, sd[0] * _t4));
        dd[1] = Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, sd[1] * _t4));
        dd[2] = Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, sd[2] * _t4));
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        dd[0] = Math.fma(p1X - sd[0], _t2, (p2X - p1X) * _t1);
        dd[1] = Math.fma(p1Y - sd[1], _t2, (p2Y - p1Y) * _t1);
        dd[2] = Math.fma(p1Z - sd[2], _t2, (p2Z - p1Z) * _t1);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        dd[0] = Math.fma(p1X - sd[0], _t2, (p2X - p1X) * _t1);
        dd[1] = Math.fma(p1Y - sd[1], _t2, (p2Y - p1Y) * _t1);
        dd[2] = Math.fma(p1Z - sd[2], _t2, (p2Z - p1Z) * _t1);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        dd[0] = Math.fma(p3X - p2X, _t2, Math.fma(p1X - sd[0], _t6, (p2X - p1X) * _t5));
        dd[1] = Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - sd[1], _t6, (p2Y - p1Y) * _t5));
        dd[2] = Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - sd[2], _t6, (p2Z - p1Z) * _t5));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        dd[0] = Math.fma(p3X - p2X, _t2, Math.fma(p1X - sd[0], _t6, (p2X - p1X) * _t5));
        dd[1] = Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - sd[1], _t6, (p2Y - p1Y) * _t5));
        dd[2] = Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - sd[2], _t6, (p2Z - p1Z) * _t5));
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = t * t;
        float _t1 = t * _t0;
        dd[0] = 0.5f * (Math.fma(2.0f, p1X, t * (p2X - sd[0])) + Math.fma(Math.fma(-5.0f, p1X, Math.fma(2.0f, sd[0], Math.fma(4.0f, p2X, -p3X))), _t0, Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - sd[0])) * _t1));
        dd[1] = 0.5f * (Math.fma(2.0f, p1Y, t * (p2Y - sd[1])) + Math.fma(Math.fma(-5.0f, p1Y, Math.fma(2.0f, sd[1], Math.fma(4.0f, p2Y, -p3Y))), _t0, Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - sd[1])) * _t1));
        dd[2] = 0.5f * (Math.fma(2.0f, p1Z, t * (p2Z - sd[2])) + Math.fma(Math.fma(-5.0f, p1Z, Math.fma(2.0f, sd[2], Math.fma(4.0f, p2Z, -p3Z))), _t0, Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - sd[2])) * _t1));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = t * t;
        float _t1 = t * _t0;
        dd[0] = 0.5f * (Math.fma(2.0f, p1X, t * (p2X - sd[0])) + Math.fma(Math.fma(-5.0f, p1X, Math.fma(2.0f, sd[0], Math.fma(4.0f, p2X, -p3X))), _t0, Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - sd[0])) * _t1));
        dd[1] = 0.5f * (Math.fma(2.0f, p1Y, t * (p2Y - sd[1])) + Math.fma(Math.fma(-5.0f, p1Y, Math.fma(2.0f, sd[1], Math.fma(4.0f, p2Y, -p3Y))), _t0, Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - sd[1])) * _t1));
        dd[2] = 0.5f * (Math.fma(2.0f, p1Z, t * (p2Z - sd[2])) + Math.fma(Math.fma(-5.0f, p1Z, Math.fma(2.0f, sd[2], Math.fma(4.0f, p2Z, -p3Z))), _t0, Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - sd[2])) * _t1));
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = t * t;
        dd[0] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1X, Math.fma(2.0f, sd[0], Math.fma(4.0f, p2X, -p3X))), Math.fma(3.0f * Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - sd[0])), _t0, p2X - sd[0]));
        dd[1] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Y, Math.fma(2.0f, sd[1], Math.fma(4.0f, p2Y, -p3Y))), Math.fma(3.0f * Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - sd[1])), _t0, p2Y - sd[1]));
        dd[2] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Z, Math.fma(2.0f, sd[2], Math.fma(4.0f, p2Z, -p3Z))), Math.fma(3.0f * Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - sd[2])), _t0, p2Z - sd[2]));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = t * t;
        dd[0] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1X, Math.fma(2.0f, sd[0], Math.fma(4.0f, p2X, -p3X))), Math.fma(3.0f * Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - sd[0])), _t0, p2X - sd[0]));
        dd[1] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Y, Math.fma(2.0f, sd[1], Math.fma(4.0f, p2Y, -p3Y))), Math.fma(3.0f * Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - sd[1])), _t0, p2Y - sd[1]));
        dd[2] = 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Z, Math.fma(2.0f, sd[2], Math.fma(4.0f, p2Z, -p3Z))), Math.fma(3.0f * Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - sd[2])), _t0, p2Z - sd[2]));
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        dd[0] = Math.fma(sd[0], _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9);
        dd[1] = Math.fma(sd[1], _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9);
        dd[2] = Math.fma(sd[2], _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        dd[0] = Math.fma(sd[0], _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9);
        dd[1] = Math.fma(sd[1], _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9);
        dd[2] = Math.fma(sd[2], _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        dd[0] = Math.fma(sd[0], _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7);
        dd[1] = Math.fma(sd[1], _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7);
        dd[2] = Math.fma(sd[2], _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        dd[0] = Math.fma(sd[0], _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7);
        dd[1] = Math.fma(sd[1], _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7);
        dd[2] = Math.fma(sd[2], _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(t, otherX - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherY - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherZ - sd[2], sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(t, otherX - sd[0], sd[0]);
        dd[1] = Math.fma(t, otherY - sd[1], sd[1]);
        dd[2] = Math.fma(t, otherZ - sd[2], sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(tX, otherX - sd[0], sd[0]);
        dd[1] = Math.fma(tY, otherY - sd[1], sd[1]);
        dd[2] = Math.fma(tZ, otherZ - sd[2], sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(tX, otherX - sd[0], sd[0]);
        dd[1] = Math.fma(tY, otherY - sd[1], sd[1]);
        dd[2] = Math.fma(tZ, otherZ - sd[2], sd[2]);
        return dest;
    }


    /**
     * Compute the absolute value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 absolute(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.abs(sd[0]);
        dd[1] = Math.abs(sd[1]);
        dd[2] = Math.abs(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.abs(sd[0]);
        dd[1] = Math.abs(sd[1]);
        dd[2] = Math.abs(sd[2]);
        return dest;
    }


    /**
     * Compute the arc cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 acos(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.acos(sd[0]);
        dd[1] = (float) Math.acos(sd[1]);
        dd[2] = (float) Math.acos(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.acos(sd[0]);
        dd[1] = (float) Math.acos(sd[1]);
        dd[2] = (float) Math.acos(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(scalar, bX, sd[0]);
        dd[1] = Math.fma(scalar, bY, sd[1]);
        dd[2] = Math.fma(scalar, bZ, sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(scalar, bX, sd[0]);
        dd[1] = Math.fma(scalar, bY, sd[1]);
        dd[2] = Math.fma(scalar, bZ, sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(bX, cX, sd[0]);
        dd[1] = Math.fma(bY, cY, sd[1]);
        dd[2] = Math.fma(bZ, cZ, sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(bX, cX, sd[0]);
        dd[1] = Math.fma(bY, cY, sd[1]);
        dd[2] = Math.fma(bZ, cZ, sd[2]);
        return dest;
    }


    /**
     * Compute the angle in radians between this vector and {@code other}.
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
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the angle in radians between this vector and ({@code otherX}, {@code otherY},
     *        {@code otherZ})
     */
    public float angleBetween(float otherX, float otherY, float otherZ) {
        float[] sd = this.data;
        return (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1])) * (1.0f / (float) Math.sqrt(Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])))) * (1.0f / (float) Math.sqrt(Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY)))))));
    }


    /**
     * Compute the arc sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 asin(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.asin(sd[0]);
        dd[1] = (float) Math.asin(sd[1]);
        dd[2] = (float) Math.asin(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.asin(sd[0]);
        dd[1] = (float) Math.asin(sd[1]);
        dd[2] = (float) Math.asin(sd[2]);
        return dest;
    }


    /**
     * Compute the arc tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 atan(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.atan(sd[0]);
        dd[1] = (float) Math.atan(sd[1]);
        dd[2] = (float) Math.atan(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.atan(sd[0]);
        dd[1] = (float) Math.atan(sd[1]);
        dd[2] = (float) Math.atan(sd[2]);
        return dest;
    }


    /**
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
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
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
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
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
     * {@code dest}.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    public Float3 atan2(Float3R x, @Mutated Float3 dest) {
        return atan2(x.x(), x.y(), x.z(), dest);
    }


    /**
     * Compute the component-wise arc tangent of this vector over {@code x} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param x the value to take the arc tangent over (the denominator)
     * @param dest will hold the result
     * @return dest
     */
    public Double3 atan2(Float3R x, @Mutated Double3 dest) {
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
    public Float3 atan2(float xX, float xY, float xZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.atan2(sd[0], xX);
        dd[1] = (float) Math.atan2(sd[1], xY);
        dd[2] = (float) Math.atan2(sd[2], xZ);
        return dest;
    }


    /**
     * Compute the component-wise arc tangent of this vector over ({@code xX}, {@code xY},
     * {@code xZ}) and store the result in {@code dest}.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.atan2(sd[0], xX);
        dd[1] = (float) Math.atan2(sd[1], xY);
        dd[2] = (float) Math.atan2(sd[2], xZ);
        return dest;
    }


    /**
     * Compute the cube root of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 cbrt(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.cbrt(sd[0]);
        dd[1] = (float) Math.cbrt(sd[1]);
        dd[2] = (float) Math.cbrt(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.cbrt(sd[0]);
        dd[1] = (float) Math.cbrt(sd[1]);
        dd[2] = (float) Math.cbrt(sd[2]);
        return dest;
    }


    /**
     * Compute the ceiling of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 ceil(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.ceil(sd[0]);
        dd[1] = (float) Math.ceil(sd[1]);
        dd[2] = (float) Math.ceil(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.ceil(sd[0]);
        dd[1] = (float) Math.ceil(sd[1]);
        dd[2] = (float) Math.ceil(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.min(Math.max(sd[0], min), max);
        dd[1] = Math.min(Math.max(sd[1], min), max);
        dd[2] = Math.min(Math.max(sd[2], min), max);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.min(Math.max(sd[0], min), max);
        dd[1] = Math.min(Math.max(sd[1], min), max);
        dd[2] = Math.min(Math.max(sd[2], min), max);
        return dest;
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
     * @param min the minimum corner
     * @param max the maximum corner
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.min(Math.max(sd[0], minX), maxX);
        dd[1] = Math.min(Math.max(sd[1], minY), maxY);
        dd[2] = Math.min(Math.max(sd[2], minZ), maxZ);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.min(Math.max(sd[0], minX), maxX);
        dd[1] = Math.min(Math.max(sd[1], minY), maxY);
        dd[2] = Math.min(Math.max(sd[2], minZ), maxZ);
        return dest;
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
    public Float3 closestPointOnLine(Float3R lineStart, Float3R lineEnd, @Mutated Float3 dest) {
        return closestPointOnLine(lineStart.x(), lineStart.y(), lineStart.z(), lineEnd.x(), lineEnd.y(), lineEnd.z(), dest);
    }


    /**
     * Set this vector to the point closest to it on the line segment between {@code lineStart} and
     * {@code lineEnd} and store the result in {@code dest}.
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
    public Float3 closestPointOnLine(float lineStartX, float lineStartY, float lineStartZ, float lineEndX, float lineEndY, float lineEndZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = lineEndZ - lineStartZ;
        float _t1 = lineEndX - lineStartX;
        float _t2 = lineEndY - lineStartY;
        float _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t14 = Math.max(0.0f, Math.min(1.0f, Math.fma(_t0, sd[2] - lineStartZ, Math.fma(_t1, sd[0] - lineStartX, _t2 * (sd[1] - lineStartY))) / _t10));
        if (_t10 > 0.0f) {
            dd[0] = Math.fma(_t1, _t14, lineStartX);
            dd[1] = Math.fma(_t2, _t14, lineStartY);
            dd[2] = Math.fma(_t0, _t14, lineStartZ);
        } else {
            dd[0] = lineStartX;
            dd[1] = lineStartY;
            dd[2] = lineStartZ;
        }
        return dest;
    }


    /**
     * Set this vector to the point closest to it on the line segment between ({@code lineStartX},
     * {@code lineStartY}, {@code lineStartZ}) and ({@code lineEndX}, {@code lineEndY},
     * {@code lineEndZ}) and store the result in {@code dest}.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = lineEndZ - lineStartZ;
        float _t1 = lineEndX - lineStartX;
        float _t2 = lineEndY - lineStartY;
        float _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t14 = Math.max(0.0f, Math.min(1.0f, Math.fma(_t0, sd[2] - lineStartZ, Math.fma(_t1, sd[0] - lineStartX, _t2 * (sd[1] - lineStartY))) / _t10));
        if (_t10 > 0.0f) {
            dd[0] = Math.fma(_t1, _t14, lineStartX);
            dd[1] = Math.fma(_t2, _t14, lineStartY);
            dd[2] = Math.fma(_t0, _t14, lineStartZ);
        } else {
            dd[0] = lineStartX;
            dd[1] = lineStartY;
            dd[2] = lineStartZ;
        }
        return dest;
    }


    /**
     * Compute the sum of all components of this vector.
     *
     * @return the sum of all components of this vector
     */
    public float compAdd() {
        float[] sd = this.data;
        return sd[2] + (sd[0] + sd[1]);
    }


    /**
     * Compute the largest component of this vector.
     *
     * @return the largest component of this vector
     */
    public float compMax() {
        float[] sd = this.data;
        return Math.max(Math.max(sd[0], sd[1]), sd[2]);
    }


    /**
     * Compute the smallest component of this vector.
     *
     * @return the smallest component of this vector
     */
    public float compMin() {
        float[] sd = this.data;
        return Math.min(Math.min(sd[0], sd[1]), sd[2]);
    }


    /**
     * Compute the product of all components of this vector.
     *
     * @return the product of all components of this vector
     */
    public float compMul() {
        float[] sd = this.data;
        return sd[2] * sd[0] * sd[1];
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.copySign(sd[0], signX);
        dd[1] = Math.copySign(sd[1], signY);
        dd[2] = Math.copySign(sd[2], signZ);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.copySign(sd[0], signX);
        dd[1] = Math.copySign(sd[1], signY);
        dd[2] = Math.copySign(sd[2], signZ);
        return dest;
    }


    /**
     * Compute the cosine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 cos(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.cos(sd[0]);
        dd[1] = (float) Math.cos(sd[1]);
        dd[2] = (float) Math.cos(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.cos(sd[0]);
        dd[1] = (float) Math.cos(sd[1]);
        dd[2] = (float) Math.cos(sd[2]);
        return dest;
    }


    /**
     * Compute the hyperbolic cosine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 cosh(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.cosh(sd[0]);
        dd[1] = (float) Math.cosh(sd[1]);
        dd[2] = (float) Math.cosh(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.cosh(sd[0]);
        dd[1] = (float) Math.cosh(sd[1]);
        dd[2] = (float) Math.cosh(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        float _buf1 = Math.fma(otherX, sd[2], -(otherZ * sd[0]));
        dd[2] = Math.fma(otherY, sd[0], -(otherX * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(otherZ, sd[1], -(otherY * sd[2]));
        float _buf1 = Math.fma(otherX, sd[2], -(otherZ * sd[0]));
        dd[2] = Math.fma(otherY, sd[0], -(otherX * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Compute the value converted from radians to degrees of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 degrees(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.toDegrees(sd[0]);
        dd[1] = (float) Math.toDegrees(sd[1]);
        dd[2] = (float) Math.toDegrees(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.toDegrees(sd[0]);
        dd[1] = (float) Math.toDegrees(sd[1]);
        dd[2] = (float) Math.toDegrees(sd[2]);
        return dest;
    }


    /**
     * Compute the distance between this vector and {@code other}.
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
     *
     * @param otherX the {@code x} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherY the {@code y} component of the vector {@code (otherX, otherY, otherZ)}
     * @param otherZ the {@code z} component of the vector {@code (otherX, otherY, otherZ)}
     * @return the distance between this vector and ({@code otherX}, {@code otherY}, {@code otherZ})
     */
    public float distance(float otherX, float otherY, float otherZ) {
        float[] sd = this.data;
        float _t0 = sd[2] - otherZ;
        float _t1 = sd[0] - otherX;
        float _t2 = sd[1] - otherY;
        return (float) Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
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
        float[] sd = this.data;
        float _t0 = sd[2] - otherZ;
        float _t1 = sd[0] - otherX;
        float _t2 = sd[1] - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
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
        float[] sd = this.data;
        return Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1]));
    }


    /**
     * Compute the base-e exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 exp(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.exp(sd[0]);
        dd[1] = (float) Math.exp(sd[1]);
        dd[2] = (float) Math.exp(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.exp(sd[0]);
        dd[1] = (float) Math.exp(sd[1]);
        dd[2] = (float) Math.exp(sd[2]);
        return dest;
    }


    /**
     * Compute the base-2 exponential of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 exp2(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.pow(2.0f, sd[0]);
        dd[1] = (float) Math.pow(2.0f, sd[1]);
        dd[2] = (float) Math.pow(2.0f, sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.pow(2.0f, sd[0]);
        dd[1] = (float) Math.pow(2.0f, sd[1]);
        dd[2] = (float) Math.pow(2.0f, sd[2]);
        return dest;
    }


    /**
     * Compute the base-e exponential minus one of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 expm1(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.expm1(sd[0]);
        dd[1] = (float) Math.expm1(sd[1]);
        dd[2] = (float) Math.expm1(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.expm1(sd[0]);
        dd[1] = (float) Math.expm1(sd[1]);
        dd[2] = (float) Math.expm1(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t2 = Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY));
        if (_t2 < 0.0f) {
            dd[0] = sd[0];
            dd[1] = sd[1];
            dd[2] = sd[2];
        } else {
            dd[0] = -sd[0];
            dd[1] = -sd[1];
            dd[2] = -sd[2];
        }
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t2 = Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY));
        if (_t2 < 0.0f) {
            dd[0] = sd[0];
            dd[1] = sd[1];
            dd[2] = sd[2];
        } else {
            dd[0] = -sd[0];
            dd[1] = -sd[1];
            dd[2] = -sd[2];
        }
        return dest;
    }


    /**
     * Compute the floor of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 floor(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.floor(sd[0]);
        dd[1] = (float) Math.floor(sd[1]);
        dd[2] = (float) Math.floor(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.floor(sd[0]);
        dd[1] = (float) Math.floor(sd[1]);
        dd[2] = (float) Math.floor(sd[2]);
        return dest;
    }


    /**
     * Compute the fractional part of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 fract(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0] - (float) Math.floor(sd[0]);
        dd[1] = sd[1] - (float) Math.floor(sd[1]);
        dd[2] = sd[2] - (float) Math.floor(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0] - (float) Math.floor(sd[0]);
        dd[1] = sd[1] - (float) Math.floor(sd[1]);
        dd[2] = sd[2] - (float) Math.floor(sd[2]);
        return dest;
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Float3 hypot(float y, @Mutated Float3 dest) {
        return hypot(y, y, y, dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
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
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Float3 hypot(Float3R y, @Mutated Float3 dest) {
        return hypot(y.x(), y.y(), y.z(), dest);
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * {@code y} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param y the other operand
     * @param dest will hold the result
     * @return dest
     */
    public Double3 hypot(Float3R y, @Mutated Double3 dest) {
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
    public Float3 hypot(float yX, float yY, float yZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.hypot(sd[0], yX);
        dd[1] = (float) Math.hypot(sd[1], yY);
        dd[2] = (float) Math.hypot(sd[2], yZ);
        return dest;
    }


    /**
     * Compute the component-wise Euclidean norm {@code sqrt(this² + other²)} of this vector and
     * ({@code yX}, {@code yY}, {@code yZ}) and store the result in {@code dest}.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.hypot(sd[0], yX);
        dd[1] = (float) Math.hypot(sd[1], yY);
        dd[2] = (float) Math.hypot(sd[2], yZ);
        return dest;
    }


    /**
     * Compute the reciprocal {@code 1 / x} of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 inverse(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = 1.0f / sd[0];
        dd[1] = 1.0f / sd[1];
        dd[2] = 1.0f / sd[2];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = 1.0f / sd[0];
        dd[1] = 1.0f / sd[1];
        dd[2] = 1.0f / sd[2];
        return dest;
    }


    /**
     * Compute the inverse square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 inverseSqrt(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (1.0f / (float) Math.sqrt(sd[0]));
        dd[1] = (1.0f / (float) Math.sqrt(sd[1]));
        dd[2] = (1.0f / (float) Math.sqrt(sd[2]));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (1.0f / (float) Math.sqrt(sd[0]));
        dd[1] = (1.0f / (float) Math.sqrt(sd[1]));
        dd[2] = (1.0f / (float) Math.sqrt(sd[2]));
        return dest;
    }


    /**
     * Compute the length of this vector.
     *
     * @return the length of this vector
     */
    public float length() {
        float[] sd = this.data;
        return (float) Math.sqrt(Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1])));
    }


    /**
     * Compute the squared length of this vector.
     *
     * @return the squared length of this vector
     */
    public float lengthSquared() {
        float[] sd = this.data;
        return Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
    }


    /**
     * Compute the natural logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.log(sd[0]);
        dd[1] = (float) Math.log(sd[1]);
        dd[2] = (float) Math.log(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.log(sd[0]);
        dd[1] = (float) Math.log(sd[1]);
        dd[2] = (float) Math.log(sd[2]);
        return dest;
    }


    /**
     * Compute the base-10 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log10(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.log10(sd[0]);
        dd[1] = (float) Math.log10(sd[1]);
        dd[2] = (float) Math.log10(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.log10(sd[0]);
        dd[1] = (float) Math.log10(sd[1]);
        dd[2] = (float) Math.log10(sd[2]);
        return dest;
    }


    /**
     * Compute the natural logarithm of one plus the value of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log1p(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.log1p(sd[0]);
        dd[1] = (float) Math.log1p(sd[1]);
        dd[2] = (float) Math.log1p(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.log1p(sd[0]);
        dd[1] = (float) Math.log1p(sd[1]);
        dd[2] = (float) Math.log1p(sd[2]);
        return dest;
    }


    /**
     * Compute the base-2 logarithm of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 log2(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        dd[0] = (float) Math.log(sd[0]) * _t0_inv;
        dd[1] = (float) Math.log(sd[1]) * _t0_inv;
        dd[2] = (float) Math.log(sd[2]) * _t0_inv;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        dd[0] = (float) Math.log(sd[0]) * _t0_inv;
        dd[1] = (float) Math.log(sd[1]) * _t0_inv;
        dd[2] = (float) Math.log(sd[2]) * _t0_inv;
        return dest;
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
        float[] sd = this.data;
        return Math.abs(sd[0] - otherX) + Math.abs(sd[1] - otherY) + Math.abs(sd[2] - otherZ);
    }


    /**
     * Compute the Manhattan length (sum of the absolute components) of this vector.
     *
     * @return the Manhattan length (sum of the absolute components) of this vector
     */
    public float manhattanLength() {
        float[] sd = this.data;
        return Math.abs(sd[0]) + Math.abs(sd[1]) + Math.abs(sd[2]);
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.max(sd[0], otherX);
        dd[1] = Math.max(sd[1], otherY);
        dd[2] = Math.max(sd[2], otherZ);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.max(sd[0], otherX);
        dd[1] = Math.max(sd[1], otherY);
        dd[2] = Math.max(sd[2], otherZ);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.min(sd[0], otherX);
        dd[1] = Math.min(sd[1], otherY);
        dd[2] = Math.min(sd[2], otherZ);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.min(sd[0], otherX);
        dd[1] = Math.min(sd[1], otherY);
        dd[2] = Math.min(sd[2], otherZ);
        return dest;
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
     * @param y the divisor
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
     * @param y the divisor
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(-yX, (float) Math.floor(sd[0] / yX), sd[0]);
        dd[1] = Math.fma(-yY, (float) Math.floor(sd[1] / yY), sd[1]);
        dd[2] = Math.fma(-yZ, (float) Math.floor(sd[2] / yZ), sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(-yX, (float) Math.floor(sd[0] / yX), sd[0]);
        dd[1] = Math.fma(-yY, (float) Math.floor(sd[1] / yY), sd[1]);
        dd[2] = Math.fma(-yZ, (float) Math.floor(sd[2] / yZ), sd[2]);
        return dest;
    }


    /**
     * Compute the next representable value toward negative infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 nextDown(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.nextDown(sd[0]);
        dd[1] = Math.nextDown(sd[1]);
        dd[2] = Math.nextDown(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.nextDown(sd[0]);
        dd[1] = Math.nextDown(sd[1]);
        dd[2] = Math.nextDown(sd[2]);
        return dest;
    }


    /**
     * Compute the next representable value toward positive infinity of each component of this
     * vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 nextUp(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.nextUp(sd[0]);
        dd[1] = Math.nextUp(sd[1]);
        dd[2] = Math.nextUp(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.nextUp(sd[0]);
        dd[1] = Math.nextUp(sd[1]);
        dd[2] = Math.nextUp(sd[2]);
        return dest;
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
    public Float3 normalize(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t3;
            dd[1] = sd[1] * _t3;
            dd[2] = sd[2] * _t3;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Normalize this vector to unit length (the zero vector yields the zero vector). <p> The
     * squared length is formed at the component precision, so components whose squares overflow or
     * underflow that precision are out of domain: the result is the zero vector rather than a unit
     * vector. Rescale such inputs before normalizing (the threshold is around 1.8e19 for
     * {@code float} and 1.3e154 for {@code double}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 normalize(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t3;
            dd[1] = sd[1] * _t3;
            dd[2] = sd[2] * _t3;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t4 = length * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t4;
            dd[1] = sd[1] * _t4;
            dd[2] = sd[2] * _t4;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t2 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t4 = length * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dd[0] = sd[0] * _t4;
            dd[1] = sd[1] * _t4;
            dd[2] = sd[2] * _t4;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
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
    public float orientedAngle(Float3R other, Float3R normal) {
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
    public float orientedAngle(float otherX, float otherY, float otherZ, float normalX, float normalY, float normalZ) {
        float[] sd = this.data;
        float _t6 = Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY));
        float _t7 = Math.fma(sd[2], sd[2], Math.fma(sd[0], sd[0], sd[1] * sd[1]));
        float _t15 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(otherZ, sd[2], Math.fma(otherX, sd[0], otherY * sd[1])) * (1.0f / (float) Math.sqrt(_t7)) * (1.0f / (float) Math.sqrt(_t6)))));
        return (float) Math.sqrt(_t6) * (float) Math.sqrt(_t7) > 0.0f ? Math.fma(normalZ, Math.fma(otherY, sd[0], -(otherX * sd[1])), Math.fma(normalX, Math.fma(otherZ, sd[1], -(otherY * sd[2])), normalY * Math.fma(otherX, sd[2], -(otherZ * sd[0])))) < 0.0f ? -_t15 : _t15 : 0.0f;
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
        float[] sd = this.data;
        float[] dd = ((Float3x3Impl) dest).data;
        float _buf0 = rowX * sd[0];
        dd[1] = rowX * sd[1];
        dd[2] = rowX * sd[2];
        float _buf1 = rowY * sd[0];
        dd[4] = rowY * sd[1];
        dd[5] = rowY * sd[2];
        float _buf2 = rowZ * sd[0];
        dd[7] = rowZ * sd[1];
        dd[8] = rowZ * sd[2];
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Float3x3Impl) dest).properties = 0;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3x3Impl) dest).data;
        float _buf0 = rowX * sd[0];
        dd[1] = rowX * sd[1];
        dd[2] = rowX * sd[2];
        float _buf1 = rowY * sd[0];
        dd[4] = rowY * sd[1];
        dd[5] = rowY * sd[2];
        float _buf2 = rowZ * sd[0];
        dd[7] = rowZ * sd[1];
        dd[8] = rowZ * sd[2];
        dd[0] = _buf0;
        dd[3] = _buf1;
        dd[6] = _buf2;
        ((Double3x3Impl) dest).properties = 0;
        return dest;
    }


    /**
     * Set this vector to one of its perpendicular vectors and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 perpendicular(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t1 = Math.fma(sd[0], sd[0], sd[1] * sd[1]);
        if (_t1 > 0.0f) {
            float _buf0 = sd[1];
            float _buf1 = -sd[0];
            dd[2] = 0.0f;
            dd[0] = _buf0;
            dd[1] = _buf1;
        } else {
            float _buf0 = 0.0f;
            float _buf1 = sd[2];
            dd[2] = -sd[1];
            dd[0] = _buf0;
            dd[1] = _buf1;
        }
        return dest;
    }


    /**
     * Set this vector to one of its perpendicular vectors and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 perpendicular(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t1 = Math.fma(sd[0], sd[0], sd[1] * sd[1]);
        if (_t1 > 0.0f) {
            float _buf0 = sd[1];
            float _buf1 = -sd[0];
            dd[2] = 0.0f;
            dd[0] = _buf0;
            dd[1] = _buf1;
        } else {
            float _buf0 = 0.0f;
            float _buf1 = sd[2];
            dd[2] = -sd[1];
            dd[0] = _buf0;
            dd[1] = _buf1;
        }
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.pow(sd[0], exponentX);
        dd[1] = (float) Math.pow(sd[1], exponentY);
        dd[2] = (float) Math.pow(sd[2], exponentZ);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.pow(sd[0], exponentX);
        dd[1] = (float) Math.pow(sd[1], exponentY);
        dd[2] = (float) Math.pow(sd[2], exponentZ);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t4 = Math.fma(ontoZ, sd[2], Math.fma(ontoX, sd[0], ontoY * sd[1]));
        float _t5 = Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY));
        float _t5_inv = 1.0f / _t5;
        dd[0] = ontoX * _t4 * _t5_inv;
        dd[1] = ontoY * _t4 * _t5_inv;
        dd[2] = ontoZ * _t4 * _t5_inv;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t4 = Math.fma(ontoZ, sd[2], Math.fma(ontoX, sd[0], ontoY * sd[1]));
        float _t5 = Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY));
        float _t5_inv = 1.0f / _t5;
        dd[0] = ontoX * _t4 * _t5_inv;
        dd[1] = ontoY * _t4 * _t5_inv;
        dd[2] = ontoZ * _t4 * _t5_inv;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t2 = Math.fma(normalZ, sd[2], Math.fma(normalX, sd[0], normalY * sd[1]));
        dd[0] = Math.fma(-normalX, _t2, sd[0]);
        dd[1] = Math.fma(-normalY, _t2, sd[1]);
        dd[2] = Math.fma(-normalZ, _t2, sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t2 = Math.fma(normalZ, sd[2], Math.fma(normalX, sd[0], normalY * sd[1]));
        dd[0] = Math.fma(-normalX, _t2, sd[0]);
        dd[1] = Math.fma(-normalY, _t2, sd[1]);
        dd[2] = Math.fma(-normalZ, _t2, sd[2]);
        return dest;
    }


    /**
     * Compute the value converted from degrees to radians of each component of this vector and
     * store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 radians(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.toRadians(sd[0]);
        dd[1] = (float) Math.toRadians(sd[1]);
        dd[2] = (float) Math.toRadians(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.toRadians(sd[0]);
        dd[1] = (float) Math.toRadians(sd[1]);
        dd[2] = (float) Math.toRadians(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t3 = 2.0f * Math.fma(normalZ, sd[2], Math.fma(normalX, sd[0], normalY * sd[1]));
        dd[0] = Math.fma(-normalX, _t3, sd[0]);
        dd[1] = Math.fma(-normalY, _t3, sd[1]);
        dd[2] = Math.fma(-normalZ, _t3, sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t3 = 2.0f * Math.fma(normalZ, sd[2], Math.fma(normalX, sd[0], normalY * sd[1]));
        dd[0] = Math.fma(-normalX, _t3, sd[0]);
        dd[1] = Math.fma(-normalY, _t3, sd[1]);
        dd[2] = Math.fma(-normalZ, _t3, sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t3 = Math.fma(normalZ, sd[2], Math.fma(normalX, sd[0], normalY * sd[1]));
        float _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0f), eta * eta, 1.0f);
        float _t10 = Math.fma(eta, _t3, (float) Math.sqrt(Math.max(0.0f, _t7)));
        if (_t7 >= 0.0f) {
            dd[0] = Math.fma(eta, sd[0], -(normalX * _t10));
            dd[1] = Math.fma(eta, sd[1], -(normalY * _t10));
            dd[2] = Math.fma(eta, sd[2], -(normalZ * _t10));
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t3 = Math.fma(normalZ, sd[2], Math.fma(normalX, sd[0], normalY * sd[1]));
        float _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0f), eta * eta, 1.0f);
        float _t10 = Math.fma(eta, _t3, (float) Math.sqrt(Math.max(0.0f, _t7)));
        if (_t7 >= 0.0f) {
            dd[0] = Math.fma(eta, sd[0], -(normalX * _t10));
            dd[1] = Math.fma(eta, sd[1], -(normalY * _t10));
            dd[2] = Math.fma(eta, sd[2], -(normalZ * _t10));
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Compute the rounded value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 round(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.rint(sd[0]);
        dd[1] = (float) Math.rint(sd[1]);
        dd[2] = (float) Math.rint(sd[2]);
        return dest;
    }


    /**
     * Compute the rounded value of each component of this vector and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 round(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.rint(sd[0]);
        dd[1] = (float) Math.rint(sd[1]);
        dd[2] = (float) Math.rint(sd[2]);
        return dest;
    }


    /**
     * Compute the sign of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sign(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.signum(sd[0]);
        dd[1] = Math.signum(sd[1]);
        dd[2] = Math.signum(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.signum(sd[0]);
        dd[1] = Math.signum(sd[1]);
        dd[2] = Math.signum(sd[2]);
        return dest;
    }


    /**
     * Compute the sine of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sin(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.sin(sd[0]);
        dd[1] = (float) Math.sin(sd[1]);
        dd[2] = (float) Math.sin(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.sin(sd[0]);
        dd[1] = (float) Math.sin(sd[1]);
        dd[2] = (float) Math.sin(sd[2]);
        return dest;
    }


    /**
     * Compute the hyperbolic sine of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sinh(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.sinh(sd[0]);
        dd[1] = (float) Math.sinh(sd[1]);
        dd[2] = (float) Math.sinh(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.sinh(sd[0]);
        dd[1] = (float) Math.sinh(sd[1]);
        dd[2] = (float) Math.sinh(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t10 = Math.max(0.0f, Math.min(1.0f, (sd[0] - edge0) * _t0_inv));
        float _t11 = Math.max(0.0f, Math.min(1.0f, (sd[1] - edge0) * _t0_inv));
        float _t12 = Math.max(0.0f, Math.min(1.0f, (sd[2] - edge0) * _t0_inv));
        dd[0] = Math.fma(-2.0f, _t10, 3.0f) * _t10 * _t10;
        dd[1] = Math.fma(-2.0f, _t11, 3.0f) * _t11 * _t11;
        dd[2] = Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t10 = Math.max(0.0f, Math.min(1.0f, (sd[0] - edge0) * _t0_inv));
        float _t11 = Math.max(0.0f, Math.min(1.0f, (sd[1] - edge0) * _t0_inv));
        float _t12 = Math.max(0.0f, Math.min(1.0f, (sd[2] - edge0) * _t0_inv));
        dd[0] = Math.fma(-2.0f, _t10, 3.0f) * _t10 * _t10;
        dd[1] = Math.fma(-2.0f, _t11, 3.0f) * _t11 * _t11;
        dd[2] = Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t12 = Math.max(0.0f, Math.min(1.0f, (sd[0] - edge0X) / (edge1X - edge0X)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (sd[1] - edge0Y) / (edge1Y - edge0Y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (sd[2] - edge0Z) / (edge1Z - edge0Z)));
        dd[0] = Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12;
        dd[1] = Math.fma(-2.0f, _t13, 3.0f) * _t13 * _t13;
        dd[2] = Math.fma(-2.0f, _t14, 3.0f) * _t14 * _t14;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t12 = Math.max(0.0f, Math.min(1.0f, (sd[0] - edge0X) / (edge1X - edge0X)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (sd[1] - edge0Y) / (edge1Y - edge0Y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (sd[2] - edge0Z) / (edge1Z - edge0Z)));
        dd[0] = Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12;
        dd[1] = Math.fma(-2.0f, _t13, 3.0f) * _t13 * _t13;
        dd[2] = Math.fma(-2.0f, _t14, 3.0f) * _t14 * _t14;
        return dest;
    }


    /**
     * Compute the square root of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 sqrt(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.sqrt(sd[0]);
        dd[1] = (float) Math.sqrt(sd[1]);
        dd[2] = (float) Math.sqrt(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.sqrt(sd[0]);
        dd[1] = (float) Math.sqrt(sd[1]);
        dd[2] = (float) Math.sqrt(sd[2]);
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0] < edgeX ? 0.0f : 1.0f;
        dd[1] = sd[1] < edgeY ? 0.0f : 1.0f;
        dd[2] = sd[2] < edgeZ ? 0.0f : 1.0f;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0] < edgeX ? 0.0f : 1.0f;
        dd[1] = sd[1] < edgeY ? 0.0f : 1.0f;
        dd[2] = sd[2] < edgeZ ? 0.0f : 1.0f;
        return dest;
    }


    /**
     * Compute the tangent of each component of this vector and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 tan(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.tan(sd[0]);
        dd[1] = (float) Math.tan(sd[1]);
        dd[2] = (float) Math.tan(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.tan(sd[0]);
        dd[1] = (float) Math.tan(sd[1]);
        dd[2] = (float) Math.tan(sd[2]);
        return dest;
    }


    /**
     * Compute the hyperbolic tangent of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 tanh(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = (float) Math.tanh(sd[0]);
        dd[1] = (float) Math.tanh(sd[1]);
        dd[2] = (float) Math.tanh(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = (float) Math.tanh(sd[0]);
        dd[1] = (float) Math.tanh(sd[1]);
        dd[2] = (float) Math.tanh(sd[2]);
        return dest;
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
    public Float3 triangleNormal(Float3R p1, Float3R p2, @Mutated Float3 dest) {
        return triangleNormal(p1.x(), p1.y(), p1.z(), p2.x(), p2.y(), p2.z(), dest);
    }


    /**
     * Compute the normal of the triangle spanned by this vector and the two given points and store
     * the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p1 the vector
     * @param p2 the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 triangleNormal(Float3R p1, Float3R p2, @Mutated Double3 dest) {
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
    public Float3 triangleNormal(float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = p1X - sd[0];
        float _t1 = p2Y - sd[1];
        float _t2 = p1Y - sd[1];
        float _t3 = p2X - sd[0];
        float _t4 = p2Z - sd[2];
        float _t5 = p1Z - sd[2];
        float _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        float _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        float _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        float _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        float _t18 = (1.0f / (float) Math.sqrt(_t17));
        if (_t17 > 0.0f) {
            dd[0] = _t13 * _t18;
            dd[1] = _t14 * _t18;
            dd[2] = _t12 * _t18;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Compute the normal of the triangle spanned by this vector and the two given points and store
     * the result in {@code dest}.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = p1X - sd[0];
        float _t1 = p2Y - sd[1];
        float _t2 = p1Y - sd[1];
        float _t3 = p2X - sd[0];
        float _t4 = p2Z - sd[2];
        float _t5 = p1Z - sd[2];
        float _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        float _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        float _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        float _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        float _t18 = (1.0f / (float) Math.sqrt(_t17));
        if (_t17 > 0.0f) {
            dd[0] = _t13 * _t18;
            dd[1] = _t14 * _t18;
            dd[2] = _t12 * _t18;
        } else {
            dd[0] = 0.0f;
            dd[1] = 0.0f;
            dd[2] = 0.0f;
        }
        return dest;
    }


    /**
     * Compute the truncated value of each component of this vector and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 trunc(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0] >= 0.0f ? (float) Math.floor(sd[0]) : (float) Math.ceil(sd[0]);
        dd[1] = sd[1] >= 0.0f ? (float) Math.floor(sd[1]) : (float) Math.ceil(sd[1]);
        dd[2] = sd[2] >= 0.0f ? (float) Math.floor(sd[2]) : (float) Math.ceil(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0] >= 0.0f ? (float) Math.floor(sd[0]) : (float) Math.ceil(sd[0]);
        dd[1] = sd[1] >= 0.0f ? (float) Math.floor(sd[1]) : (float) Math.ceil(sd[1]);
        dd[2] = sd[2] >= 0.0f ? (float) Math.floor(sd[2]) : (float) Math.ceil(sd[2]);
        return dest;
    }


    /**
     * Compute the unit in the last place (ulp) of each component of this vector and store the
     * result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 ulp(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.ulp(sd[0]);
        dd[1] = Math.ulp(sd[1]);
        dd[2] = Math.ulp(sd[2]);
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.ulp(sd[0]);
        dd[1] = Math.ulp(sd[1]);
        dd[2] = Math.ulp(sd[2]);
        return dest;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 0} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4 xyz0(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 0.0f;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double4Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 0.0f;
        return dest;
    }


    /**
     * Copy the {@code x}, {@code y} and {@code z} components of this vector into a 4D vector with
     * {@code w = 1} and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float4 xyz1(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0f;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double4Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = 1.0f;
        return dest;
    }


    /**
     * Pre-multiply {@code mat} onto this vector and store the result in {@code dest}.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Float3 preMul(Float3x3R mat, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] matData = ((Float3x3Impl) mat).data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(matData[6], sd[2], Math.fma(matData[0], sd[0], matData[3] * sd[1]));
        float _buf1 = Math.fma(matData[7], sd[2], Math.fma(matData[1], sd[0], matData[4] * sd[1]));
        dd[2] = Math.fma(matData[8], sd[2], Math.fma(matData[2], sd[0], matData[5] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
    }


    /**
     * Pre-multiply {@code mat} onto this vector and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param mat the matrix
     * @param dest will hold the result
     * @return dest
     */
    public Double3 preMul(Float3x3R mat, @Mutated Double3 dest) {
        float[] sd = this.data;
        float[] matData = ((Float3x3Impl) mat).data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(matData[6], sd[2], Math.fma(matData[0], sd[0], matData[3] * sd[1]));
        float _buf1 = Math.fma(matData[7], sd[2], Math.fma(matData[1], sd[0], matData[4] * sd[1]));
        dd[2] = Math.fma(matData[8], sd[2], Math.fma(matData[2], sd[0], matData[5] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float3x4Impl) mat).data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(matData[2], sd[2], Math.fma(matData[0], sd[0], matData[1] * sd[1]));
        float _buf1 = Math.fma(matData[6], sd[2], Math.fma(matData[4], sd[0], matData[5] * sd[1]));
        dd[2] = Math.fma(matData[10], sd[2], Math.fma(matData[8], sd[0], matData[9] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float3x4Impl) mat).data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(matData[2], sd[2], Math.fma(matData[0], sd[0], matData[1] * sd[1]));
        float _buf1 = Math.fma(matData[6], sd[2], Math.fma(matData[4], sd[0], matData[5] * sd[1]));
        dd[2] = Math.fma(matData[10], sd[2], Math.fma(matData[8], sd[0], matData[9] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float4x4Impl) mat).data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(matData[8], sd[2], Math.fma(matData[0], sd[0], matData[4] * sd[1]));
        float _buf1 = Math.fma(matData[9], sd[2], Math.fma(matData[1], sd[0], matData[5] * sd[1]));
        dd[2] = Math.fma(matData[10], sd[2], Math.fma(matData[2], sd[0], matData[6] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float4x4Impl) mat).data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(matData[8], sd[2], Math.fma(matData[0], sd[0], matData[4] * sd[1]));
        float _buf1 = Math.fma(matData[9], sd[2], Math.fma(matData[1], sd[0], matData[5] * sd[1]));
        dd[2] = Math.fma(matData[10], sd[2], Math.fma(matData[2], sd[0], matData[6] * sd[1]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float3x4Impl) mat).data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(matData[0], sd[0], Math.fma(matData[1], sd[1], Math.fma(matData[2], sd[2], matData[3])));
        float _buf1 = Math.fma(matData[4], sd[0], Math.fma(matData[5], sd[1], Math.fma(matData[6], sd[2], matData[7])));
        dd[2] = Math.fma(matData[8], sd[0], Math.fma(matData[9], sd[1], Math.fma(matData[10], sd[2], matData[11])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float3x4Impl) mat).data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(matData[0], sd[0], Math.fma(matData[1], sd[1], Math.fma(matData[2], sd[2], matData[3])));
        float _buf1 = Math.fma(matData[4], sd[0], Math.fma(matData[5], sd[1], Math.fma(matData[6], sd[2], matData[7])));
        dd[2] = Math.fma(matData[8], sd[0], Math.fma(matData[9], sd[1], Math.fma(matData[10], sd[2], matData[11])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float4x4Impl) mat).data;
        float[] dd = ((Float3Impl) dest).data;
        float _buf0 = Math.fma(matData[0], sd[0], Math.fma(matData[4], sd[1], Math.fma(matData[8], sd[2], matData[12])));
        float _buf1 = Math.fma(matData[1], sd[0], Math.fma(matData[5], sd[1], Math.fma(matData[9], sd[2], matData[13])));
        dd[2] = Math.fma(matData[2], sd[0], Math.fma(matData[6], sd[1], Math.fma(matData[10], sd[2], matData[14])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float4x4Impl) mat).data;
        double[] dd = ((Double3Impl) dest).data;
        float _buf0 = Math.fma(matData[0], sd[0], Math.fma(matData[4], sd[1], Math.fma(matData[8], sd[2], matData[12])));
        float _buf1 = Math.fma(matData[1], sd[0], Math.fma(matData[5], sd[1], Math.fma(matData[9], sd[2], matData[13])));
        dd[2] = Math.fma(matData[2], sd[0], Math.fma(matData[6], sd[1], Math.fma(matData[10], sd[2], matData[14])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float4x4Impl) mat).data;
        float[] dd = ((Float3Impl) dest).data;
        float _t2 = Math.fma(matData[3], sd[0], Math.fma(matData[7], sd[1], Math.fma(matData[11], sd[2], matData[15])));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = Math.fma(matData[0], sd[0], Math.fma(matData[4], sd[1], Math.fma(matData[8], sd[2], matData[12]))) * _t2_inv;
        float _buf1 = Math.fma(matData[1], sd[0], Math.fma(matData[5], sd[1], Math.fma(matData[9], sd[2], matData[13]))) * _t2_inv;
        dd[2] = Math.fma(matData[2], sd[0], Math.fma(matData[6], sd[1], Math.fma(matData[10], sd[2], matData[14]))) * _t2_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] matData = ((Float4x4Impl) mat).data;
        double[] dd = ((Double3Impl) dest).data;
        float _t2 = Math.fma(matData[3], sd[0], Math.fma(matData[7], sd[1], Math.fma(matData[11], sd[2], matData[15])));
        float _t2_inv = 1.0f / _t2;
        float _buf0 = Math.fma(matData[0], sd[0], Math.fma(matData[4], sd[1], Math.fma(matData[8], sd[2], matData[12]))) * _t2_inv;
        float _buf1 = Math.fma(matData[1], sd[0], Math.fma(matData[5], sd[1], Math.fma(matData[9], sd[2], matData[13]))) * _t2_inv;
        dd[2] = Math.fma(matData[2], sd[0], Math.fma(matData[6], sd[1], Math.fma(matData[10], sd[2], matData[14]))) * _t2_inv;
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(quatX, sd[1], -(quatY * sd[0]));
        float _t10 = 2.0f * Math.fma(quatZ, sd[0], -(quatX * sd[2]));
        float _t11 = 2.0f * Math.fma(quatY, sd[2], -(quatZ * sd[1]));
        dd[0] = Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, sd[0])));
        dd[1] = Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, sd[1])));
        dd[2] = Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, sd[2])));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(quatX, sd[1], -(quatY * sd[0]));
        float _t10 = 2.0f * Math.fma(quatZ, sd[0], -(quatX * sd[2]));
        float _t11 = 2.0f * Math.fma(quatY, sd[2], -(quatZ * sd[1]));
        dd[0] = Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, sd[0])));
        dd[1] = Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, sd[1])));
        dd[2] = Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, sd[2])));
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t5 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _buf0 = Math.fma(_t2, axisX * _t5, Math.fma(sd[0], _t0, Math.fma(axisY, sd[2], -(axisZ * sd[1])) * _t1));
        float _buf1 = Math.fma(_t2, axisY * _t5, Math.fma(sd[1], _t0, Math.fma(axisZ, sd[0], -(axisX * sd[2])) * _t1));
        dd[2] = Math.fma(_t2, axisZ * _t5, Math.fma(sd[2], _t0, Math.fma(axisX, sd[1], -(axisY * sd[0])) * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t5 = Math.fma(axisZ, sd[2], Math.fma(axisX, sd[0], axisY * sd[1]));
        float _buf0 = Math.fma(_t2, axisX * _t5, Math.fma(sd[0], _t0, Math.fma(axisY, sd[2], -(axisZ * sd[1])) * _t1));
        float _buf1 = Math.fma(_t2, axisY * _t5, Math.fma(sd[1], _t0, Math.fma(axisZ, sd[0], -(axisX * sd[2])) * _t1));
        dd[2] = Math.fma(_t2, axisZ * _t5, Math.fma(sd[2], _t0, Math.fma(axisX, sd[1], -(axisY * sd[0])) * _t1));
        dd[0] = _buf0;
        dd[1] = _buf1;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(quatX, sd[2], -(quatZ * sd[0]));
        float _t10 = 2.0f * Math.fma(quatY, sd[0], -(quatX * sd[1]));
        float _t11 = 2.0f * Math.fma(quatZ, sd[1], -(quatY * sd[2]));
        dd[0] = Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, sd[0])));
        dd[1] = Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, sd[1])));
        dd[2] = Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, sd[2])));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t9 = 2.0f * Math.fma(quatX, sd[2], -(quatZ * sd[0]));
        float _t10 = 2.0f * Math.fma(quatY, sd[0], -(quatX * sd[1]));
        float _t11 = 2.0f * Math.fma(quatZ, sd[1], -(quatY * sd[2]));
        dd[0] = Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, sd[0])));
        dd[1] = Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, sd[1])));
        dd[2] = Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, sd[2])));
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dd[0] = sd[0];
        float _buf0 = Math.fma(sd[1], _t0, -(sd[2] * _t1));
        dd[2] = Math.fma(sd[1], _t1, sd[2] * _t0);
        dd[1] = _buf0;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        dd[0] = sd[0];
        float _buf0 = Math.fma(sd[1], _t0, -(sd[2] * _t1));
        dd[2] = Math.fma(sd[1], _t1, sd[2] * _t0);
        dd[1] = _buf0;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        dd[1] = sd[1];
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        dd[0] = _buf0;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, sd[2] * _t1);
        dd[1] = sd[1];
        dd[2] = Math.fma(sd[2], _t0, -(sd[0] * _t1));
        dd[0] = _buf0;
        return dest;
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
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        dd[2] = sd[2];
        dd[0] = _buf0;
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _buf0 = Math.fma(sd[0], _t0, -(sd[1] * _t1));
        dd[1] = Math.fma(sd[0], _t1, sd[1] * _t0);
        dd[2] = sd[2];
        dd[0] = _buf0;
        return dest;
    }

    public float x() { return data[0]; }
    public float y() { return data[1]; }
    public float z() { return data[2]; }

    public Float2 xx(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        return dest;
    }

    public Float2 xy(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        return dest;
    }

    public Float2 xz(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        return dest;
    }

    public Float2 yx(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        return dest;
    }

    public Float2 yy(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        return dest;
    }

    public Float2 yz(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        return dest;
    }

    public Float2 zx(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        return dest;
    }

    public Float2 zy(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        return dest;
    }

    public Float2 zz(@Mutated Float2 dest) {
        float[] sd = this.data;
        float[] dd = ((Float2Impl) dest).data;
        float _v0 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        return dest;
    }

    public Float3 xxx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        return dest;
    }

    public Float3 xxy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        return dest;
    }

    public Float3 xxz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        return dest;
    }

    public Float3 xyx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        return dest;
    }

    public Float3 xyy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        return dest;
    }

    public Float3 xyz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        return dest;
    }

    public Float3 xzx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        return dest;
    }

    public Float3 xzy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        return dest;
    }

    public Float3 xzz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        return dest;
    }

    public Float3 yxx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        return dest;
    }

    public Float3 yxy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        return dest;
    }

    public Float3 yxz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        return dest;
    }

    public Float3 yyx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        return dest;
    }

    public Float3 yyy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        return dest;
    }

    public Float3 yyz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        return dest;
    }

    public Float3 yzx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        return dest;
    }

    public Float3 yzy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        return dest;
    }

    public Float3 yzz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        return dest;
    }

    public Float3 zxx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        return dest;
    }

    public Float3 zxy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        return dest;
    }

    public Float3 zxz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        return dest;
    }

    public Float3 zyx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        return dest;
    }

    public Float3 zyy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        return dest;
    }

    public Float3 zyz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        return dest;
    }

    public Float3 zzx(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        return dest;
    }

    public Float3 zzy(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        return dest;
    }

    public Float3 zzz(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _v0 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        return dest;
    }

    public Float4 xxxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xxxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xxxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xxyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xxyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xxyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xxzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xxzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xxzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xyxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xyxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xyxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xyyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xyyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xyyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xyzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xyzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xyzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[1];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xzxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xzxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xzxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xzyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xzyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xzyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v1;
        return dest;
    }

    public Float4 xzzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 xzzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 xzzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[0];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yxxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yxxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yxxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yxyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yxyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yxyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yxzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yxzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yxzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yyxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yyxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yyxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        float _v2 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yyyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yyyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yyyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yyzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yyzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yyzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yzxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yzxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yzxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yzyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yzyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yzyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 yzzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 yzzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 yzzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[1];
        float _v1 = sd[2];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zxxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zxxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zxxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zxyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zxyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zxyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zxzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zxzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zxzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zyxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zyxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zyxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v2;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zyyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zyyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zyyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zyzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zyzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zyzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v1;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zzxx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zzxy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        float _v2 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zzxz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zzyx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        float _v2 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v2;
        return dest;
    }

    public Float4 zzyy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zzyz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v1;
        dd[3] = _v0;
        return dest;
    }

    public Float4 zzzx(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[0];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zzzy(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        float _v1 = sd[1];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v1;
        return dest;
    }

    public Float4 zzzz(@Mutated Float4 dest) {
        float[] sd = this.data;
        float[] dd = ((Float4Impl) dest).data;
        float _v0 = sd[2];
        dd[0] = _v0;
        dd[1] = _v0;
        dd[2] = _v0;
        dd[3] = _v0;
        return dest;
    }

    @Override public String toString() {
        return "Float3(" + x() + ", " + y() + ", " + z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Float3Impl)) return false;
        Float3Impl o = (Float3Impl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Float.isFinite(data[0])
            && Float.isFinite(data[1])
            && Float.isFinite(data[2]);
    }

    @Override public boolean equalsEpsilon(Float3R other, float epsilon) {
        return Math.abs(data[0] - other.x()) <= epsilon
            && Math.abs(data[1] - other.y()) <= epsilon
            && Math.abs(data[2] - other.z()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        return dest;
    }
    public @Mutated Float3 load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
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
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        return dest;
    }
    public @Mutated Float3 load(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
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

    private static final VectorSpecies<Float> COL_SPECIES = FloatVector.SPECIES_128;

}
