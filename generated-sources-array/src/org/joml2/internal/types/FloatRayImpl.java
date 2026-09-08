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
 * Generated implementation of {@link FloatRay} backed by a {@code float[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatRayImpl implements FloatRay {

    public float[] data;
    static final FloatRaySegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRaySegOpsUnsafe()
                    : new FloatRaySegOpsMS();
    static final FloatRayBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRayBbOpsUnsafe()
                    : new FloatRayBbOpsApi();
    static final FloatRayRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatRayRawOpsUnsafe()
                    : new FloatRayRawOpsApi();

    public FloatRayImpl() {
        data = new float[6];
    }


    /**
     * Set this ray to the given values.
     *
     * @param v the ray
     * @return this
     */
    public @Mutated FloatRay set(FloatRayR v) {
        return set(v.oX(), v.oY(), v.oZ(), v.dX(), v.dY(), v.dZ());
    }


    /**
     * Set this ray to the given values.
     *
     * @param vOX the {@code oX} component of the ray {@code (vOX, vOY, vOZ, vDX, vDY, vDZ)}
     * @param vOY the {@code oY} component of the ray {@code (vOX, vOY, vOZ, vDX, vDY, vDZ)}
     * @param vOZ the {@code oZ} component of the ray {@code (vOX, vOY, vOZ, vDX, vDY, vDZ)}
     * @param vDX the {@code dX} component of the ray {@code (vOX, vOY, vOZ, vDX, vDY, vDZ)}
     * @param vDY the {@code dY} component of the ray {@code (vOX, vOY, vOZ, vDX, vDY, vDZ)}
     * @param vDZ the {@code dZ} component of the ray {@code (vOX, vOY, vOZ, vDX, vDY, vDZ)}
     * @return this
     */
    @Mutated public FloatRay set(float vOX, float vOY, float vOZ, float vDX, float vDY, float vDZ) {
        float[] dd = this.data;
        dd[0] = vOX;
        dd[1] = vOY;
        dd[2] = vOZ;
        dd[3] = vDX;
        dd[4] = vDY;
        dd[5] = vDZ;
        return this;
    }


    /**
     * Set the direction of this ray to {@code d} and store the result in {@code dest}.
     *
     * @param d the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay setDirection(Float3R d, @Mutated FloatRay dest) {
        return setDirection(d.x(), d.y(), d.z(), dest);
    }


    /**
     * Set the direction of this ray to {@code d} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param d the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay setDirection(Float3R d, @Mutated DoubleRay dest) {
        return setDirection(d.x(), d.y(), d.z(), dest);
    }


    /**
     * Set the direction of this ray to ({@code dX}, {@code dY}, {@code dZ}) and store the result in
     * {@code dest}.
     *
     * @param dX the {@code x} component of the vector {@code (dX, dY, dZ)}
     * @param dY the {@code y} component of the vector {@code (dX, dY, dZ)}
     * @param dZ the {@code z} component of the vector {@code (dX, dY, dZ)}
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay setDirection(float dX, float dY, float dZ, @Mutated FloatRay dest) {
        float[] sd = this.data;
        float[] dd = ((FloatRayImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = dX;
        dd[4] = dY;
        dd[5] = dZ;
        return dest;
    }


    /**
     * Set the direction of this ray to ({@code dX}, {@code dY}, {@code dZ}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dX the {@code x} component of the vector {@code (dX, dY, dZ)}
     * @param dY the {@code y} component of the vector {@code (dX, dY, dZ)}
     * @param dZ the {@code z} component of the vector {@code (dX, dY, dZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay setDirection(float dX, float dY, float dZ, @Mutated DoubleRay dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleRayImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = dX;
        dd[4] = dY;
        dd[5] = dZ;
        return dest;
    }


    /**
     * Set the origin of this ray to {@code o} and store the result in {@code dest}.
     *
     * @param o the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay setOrigin(Float3R o, @Mutated FloatRay dest) {
        return setOrigin(o.x(), o.y(), o.z(), dest);
    }


    /**
     * Set the origin of this ray to {@code o} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param o the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay setOrigin(Float3R o, @Mutated DoubleRay dest) {
        return setOrigin(o.x(), o.y(), o.z(), dest);
    }


    /**
     * Set the origin of this ray to ({@code oX}, {@code oY}, {@code oZ}) and store the result in
     * {@code dest}.
     *
     * @param oX the {@code x} component of the vector {@code (oX, oY, oZ)}
     * @param oY the {@code y} component of the vector {@code (oX, oY, oZ)}
     * @param oZ the {@code z} component of the vector {@code (oX, oY, oZ)}
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay setOrigin(float oX, float oY, float oZ, @Mutated FloatRay dest) {
        float[] sd = this.data;
        float[] dd = ((FloatRayImpl) dest).data;
        dd[0] = oX;
        dd[1] = oY;
        dd[2] = oZ;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        return dest;
    }


    /**
     * Set the origin of this ray to ({@code oX}, {@code oY}, {@code oZ}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param oX the {@code x} component of the vector {@code (oX, oY, oZ)}
     * @param oY the {@code y} component of the vector {@code (oX, oY, oZ)}
     * @param oZ the {@code z} component of the vector {@code (oX, oY, oZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay setOrigin(float oX, float oY, float oZ, @Mutated DoubleRay dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleRayImpl) dest).data;
        dd[0] = oX;
        dd[1] = oY;
        dd[2] = oZ;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        return dest;
    }


    /**
     * Convert this ray to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay toDouble(@Mutated DoubleRay dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleRayImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        return dest;
    }


    /**
     * Transform this ray by {@code m} and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay transform(Float3x4R m, @Mutated FloatRay dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float[] dd = ((FloatRayImpl) dest).data;
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        float _buf2 = Math.fma(mData[2], sd[5], Math.fma(mData[0], sd[3], mData[1] * sd[4]));
        float _buf3 = Math.fma(mData[6], sd[5], Math.fma(mData[4], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[8], sd[3], mData[9] * sd[4]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        return dest;
    }


    /**
     * Transform this ray by {@code m} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay transform(Float3x4R m, @Mutated DoubleRay dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        double[] dd = ((DoubleRayImpl) dest).data;
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        float _buf2 = Math.fma(mData[2], sd[5], Math.fma(mData[0], sd[3], mData[1] * sd[4]));
        float _buf3 = Math.fma(mData[6], sd[5], Math.fma(mData[4], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[8], sd[3], mData[9] * sd[4]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        return dest;
    }


    /**
     * Transform this ray by {@code m} and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay transform(Float4x4R m, @Mutated FloatRay dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float[] dd = ((FloatRayImpl) dest).data;
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        float _buf2 = Math.fma(mData[8], sd[5], Math.fma(mData[0], sd[3], mData[4] * sd[4]));
        float _buf3 = Math.fma(mData[9], sd[5], Math.fma(mData[1], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[2], sd[3], mData[6] * sd[4]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        return dest;
    }


    /**
     * Transform this ray by {@code m} and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay transform(Float4x4R m, @Mutated DoubleRay dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        double[] dd = ((DoubleRayImpl) dest).data;
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        float _buf2 = Math.fma(mData[8], sd[5], Math.fma(mData[0], sd[3], mData[4] * sd[4]));
        float _buf3 = Math.fma(mData[9], sd[5], Math.fma(mData[1], sd[3], mData[5] * sd[4]));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[2], sd[3], mData[6] * sd[4]));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        return dest;
    }


    /**
     * Compute the point on this ray at the parameter value {@code t} and store the result in
     * {@code dest}.
     *
     * @param t the distance along the ray, as a multiple of the ray direction
     * @param dest will hold the result
     * @return dest
     */
    public Float3 at(float t, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = Math.fma(t, sd[3], sd[0]);
        dd[1] = Math.fma(t, sd[4], sd[1]);
        dd[2] = Math.fma(t, sd[5], sd[2]);
        return dest;
    }


    /**
     * Compute the point on this ray at the parameter value {@code t} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param t the distance along the ray, as a multiple of the ray direction
     * @param dest will hold the result
     * @return dest
     */
    public Double3 at(float t, @Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = Math.fma(t, sd[3], sd[0]);
        dd[1] = Math.fma(t, sd[4], sd[1]);
        dd[2] = Math.fma(t, sd[5], sd[2]);
        return dest;
    }


    /**
     * Get the direction of this ray and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getDirection(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
    }


    /**
     * Get the direction of this ray and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getDirection(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
    }


    /**
     * Get the origin of this ray and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getOrigin(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
    }


    /**
     * Get the origin of this ray and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getOrigin(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
    }

    public float oX() { return data[0]; }
    public float oY() { return data[1]; }
    public float oZ() { return data[2]; }
    public float dX() { return data[3]; }
    public float dY() { return data[4]; }
    public float dZ() { return data[5]; }

    @Override public String toString() {
        return "FloatRay(" + oX() + ", " + oY() + ", " + oZ() + ", " + dX() + ", " + dY() + ", " + dZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatRayImpl)) return false;
        FloatRayImpl o = (FloatRayImpl) obj;
        return java.util.Arrays.equals(data, o.data);
    }

    @Override public int hashCode() {
        return java.util.Arrays.hashCode(data);
    }

    @Override public boolean isFinite() {
        return Float.isFinite(data[0])
            && Float.isFinite(data[1])
            && Float.isFinite(data[2])
            && Float.isFinite(data[3])
            && Float.isFinite(data[4])
            && Float.isFinite(data[5]);
    }

    @Override public boolean equalsEpsilon(FloatRayR other, float epsilon) {
        return Math.abs(data[0] - other.oX()) <= epsilon
            && Math.abs(data[1] - other.oY()) <= epsilon
            && Math.abs(data[2] - other.oZ()) <= epsilon
            && Math.abs(data[3] - other.dX()) <= epsilon
            && Math.abs(data[4] - other.dY()) <= epsilon
            && Math.abs(data[5] - other.dZ()) <= epsilon;
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        return dest;
    }
    public @Mutated FloatRay load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatRay loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatRay loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatRay storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatRay loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public FloatRay load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        return dest;
    }
    public @Mutated FloatRay load(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        this.data[4] = (float) src[offset + 4];
        this.data[5] = (float) src[offset + 5];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatRay loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatRay loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatRay storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatRay loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatRay loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
