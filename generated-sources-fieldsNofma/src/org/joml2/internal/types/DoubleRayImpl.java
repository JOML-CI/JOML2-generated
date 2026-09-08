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
 * Generated implementation of {@link DoubleRay} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleRayImpl implements DoubleRay {

    public double oX;
    public double oY;
    public double oZ;
    public double dX;
    public double dY;
    public double dZ;
    static final DoubleRaySegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRaySegOpsUnsafe()
                    : new DoubleRaySegOpsMS();
    static final DoubleRayBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRayBbOpsUnsafe()
                    : new DoubleRayBbOpsApi();
    static final DoubleRayRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleRayRawOpsUnsafe()
                    : new DoubleRayRawOpsApi();

    public DoubleRayImpl() {
    }


    /**
     * Set this ray to the given values.
     *
     * @param v the ray
     * @return this
     */
    public @Mutated DoubleRay set(DoubleRayR v) {
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
    @Mutated public DoubleRay set(double vOX, double vOY, double vOZ, double vDX, double vDY, double vDZ) {
        this.oX = vOX;
        this.oY = vOY;
        this.oZ = vOZ;
        this.dX = vDX;
        this.dY = vDY;
        this.dZ = vDZ;
        return this;
    }


    /**
     * Set the direction of this ray to {@code d} and store the result in {@code dest}.
     *
     * @param d the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay setDirection(Double3R d, @Mutated DoubleRay dest) {
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
    public DoubleRay setDirection(double dX, double dY, double dZ, @Mutated DoubleRay dest) {
        DoubleRayImpl d = (DoubleRayImpl) dest;
        d.oX = this.oX;
        d.oY = this.oY;
        d.oZ = this.oZ;
        d.dX = dX;
        d.dY = dY;
        d.dZ = dZ;
        return d;
    }


    /**
     * Set the origin of this ray to {@code o} and store the result in {@code dest}.
     *
     * @param o the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay setOrigin(Double3R o, @Mutated DoubleRay dest) {
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
    public DoubleRay setOrigin(double oX, double oY, double oZ, @Mutated DoubleRay dest) {
        DoubleRayImpl d = (DoubleRayImpl) dest;
        d.oX = oX;
        d.oY = oY;
        d.oZ = oZ;
        d.dX = this.dX;
        d.dY = this.dY;
        d.dZ = this.dZ;
        return d;
    }


    /**
     * Convert this ray to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatRay toFloat(@Mutated FloatRay dest) {
        FloatRayImpl d = (FloatRayImpl) dest;
        d.oX = (float) (this.oX);
        d.oY = (float) (this.oY);
        d.oZ = (float) (this.oZ);
        d.dX = (float) (this.dX);
        d.dY = (float) (this.dY);
        d.dZ = (float) (this.dZ);
        return d;
    }


    /**
     * Transform this ray by {@code m} and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleRay transform(Double3x4R m, @Mutated DoubleRay dest) {
        DoubleRayImpl d = (DoubleRayImpl) dest;
        double _buf0 = m.m02() * this.oZ + (m.m00() * this.oX + (m.m01() * this.oY + m.m03()));
        double _buf1 = m.m12() * this.oZ + (m.m10() * this.oX + (m.m11() * this.oY + m.m13()));
        d.oZ = m.m22() * this.oZ + (m.m20() * this.oX + (m.m21() * this.oY + m.m23()));
        double _buf2 = m.m00() * this.dX + m.m01() * this.dY + m.m02() * this.dZ;
        double _buf3 = m.m10() * this.dX + m.m11() * this.dY + m.m12() * this.dZ;
        d.dZ = m.m20() * this.dX + m.m21() * this.dY + m.m22() * this.dZ;
        d.oX = _buf0;
        d.oY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
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
    public DoubleRay transform(Double4x4R m, @Mutated DoubleRay dest) {
        DoubleRayImpl d = (DoubleRayImpl) dest;
        double _buf0 = m.m02() * this.oZ + (m.m00() * this.oX + (m.m01() * this.oY + m.m03()));
        double _buf1 = m.m12() * this.oZ + (m.m10() * this.oX + (m.m11() * this.oY + m.m13()));
        d.oZ = m.m22() * this.oZ + (m.m20() * this.oX + (m.m21() * this.oY + m.m23()));
        double _buf2 = m.m00() * this.dX + m.m01() * this.dY + m.m02() * this.dZ;
        double _buf3 = m.m10() * this.dX + m.m11() * this.dY + m.m12() * this.dZ;
        d.dZ = m.m20() * this.dX + m.m21() * this.dY + m.m22() * this.dZ;
        d.oX = _buf0;
        d.oY = _buf1;
        d.dX = _buf2;
        d.dY = _buf3;
        return d;
    }


    /**
     * Compute the point on this ray at the parameter value {@code t} and store the result in
     * {@code dest}.
     *
     * @param t the distance along the ray, as a multiple of the ray direction
     * @param dest will hold the result
     * @return dest
     */
    public Double3 at(double t, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = t * this.dX + this.oX;
        d.y = t * this.dY + this.oY;
        d.z = t * this.dZ + this.oZ;
        return d;
    }


    /**
     * Get the direction of this ray and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getDirection(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.dX;
        d.y = this.dY;
        d.z = this.dZ;
        return d;
    }


    /**
     * Get the origin of this ray and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getOrigin(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.oX;
        d.y = this.oY;
        d.z = this.oZ;
        return d;
    }

    public double oX() { return this.oX; }
    public double oY() { return this.oY; }
    public double oZ() { return this.oZ; }
    public double dX() { return this.dX; }
    public double dY() { return this.dY; }
    public double dZ() { return this.dZ; }

    @Override public String toString() {
        return "DoubleRay(" + oX() + ", " + oY() + ", " + oZ() + ", " + dX() + ", " + dY() + ", " + dZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleRayImpl)) return false;
        DoubleRayImpl o = (DoubleRayImpl) obj;
        return Double.doubleToLongBits(oX) == Double.doubleToLongBits(o.oX)
            && Double.doubleToLongBits(oY) == Double.doubleToLongBits(o.oY)
            && Double.doubleToLongBits(oZ) == Double.doubleToLongBits(o.oZ)
            && Double.doubleToLongBits(dX) == Double.doubleToLongBits(o.dX)
            && Double.doubleToLongBits(dY) == Double.doubleToLongBits(o.dY)
            && Double.doubleToLongBits(dZ) == Double.doubleToLongBits(o.dZ);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(oX) ^ (Double.doubleToLongBits(oX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(oY) ^ (Double.doubleToLongBits(oY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(oZ) ^ (Double.doubleToLongBits(oZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dX) ^ (Double.doubleToLongBits(dX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dY) ^ (Double.doubleToLongBits(dY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(dZ) ^ (Double.doubleToLongBits(dZ) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(oX)
            && Double.isFinite(oY)
            && Double.isFinite(oZ)
            && Double.isFinite(dX)
            && Double.isFinite(dY)
            && Double.isFinite(dZ);
    }

    @Override public boolean equalsEpsilon(DoubleRayR other, double epsilon) {
        return Math.abs(oX - other.oX()) <= epsilon
            && Math.abs(oY - other.oY()) <= epsilon
            && Math.abs(oZ - other.oZ()) <= epsilon
            && Math.abs(dX - other.dX()) <= epsilon
            && Math.abs(dY - other.dY()) <= epsilon
            && Math.abs(dZ - other.dZ()) <= epsilon;
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.oX;
        dest[offset + 1] = this.oY;
        dest[offset + 2] = this.oZ;
        dest[offset + 3] = this.dX;
        dest[offset + 4] = this.dY;
        dest[offset + 5] = this.dZ;
        return dest;
    }
    public @Mutated DoubleRay load(double[] src, int offset) {
        this.oX = src[offset + 0];
        this.oY = src[offset + 1];
        this.oZ = src[offset + 2];
        this.dX = src[offset + 3];
        this.dY = src[offset + 4];
        this.dZ = src[offset + 5];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleRay loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleRay loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleRay storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleRay loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleRay load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.oX;
        dest[offset + 1] = (float) this.oY;
        dest[offset + 2] = (float) this.oZ;
        dest[offset + 3] = (float) this.dX;
        dest[offset + 4] = (float) this.dY;
        dest[offset + 5] = (float) this.dZ;
        return dest;
    }
    public @Mutated DoubleRay load(float[] src, int offset) {
        this.oX = src[offset + 0];
        this.oY = src[offset + 1];
        this.oZ = src[offset + 2];
        this.dX = src[offset + 3];
        this.dY = src[offset + 4];
        this.dZ = src[offset + 5];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleRay loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleRay loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleRay storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleRay loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleRay loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
