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
 * Generated implementation of {@link DoubleAABB} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleAABBImpl implements DoubleAABB {

    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;
    static final DoubleAABBSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleAABBSegOpsUnsafe()
                    : new DoubleAABBSegOpsMS();
    static final DoubleAABBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleAABBBbOpsUnsafe()
                    : new DoubleAABBBbOpsApi();
    static final DoubleAABBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleAABBRawOpsUnsafe()
                    : new DoubleAABBRawOpsApi();

    public DoubleAABBImpl() {
        minX = Double.POSITIVE_INFINITY;
        minY = Double.POSITIVE_INFINITY;
        minZ = Double.POSITIVE_INFINITY;
        maxX = Double.NEGATIVE_INFINITY;
        maxY = Double.NEGATIVE_INFINITY;
        maxZ = Double.NEGATIVE_INFINITY;
    }


    /**
     * Set this axis-aligned bounding box to the given values.
     *
     * @param v the axis-aligned bounding box
     * @return this
     */
    public @Mutated DoubleAABB set(DoubleAABBR v) {
        return set(v.minX(), v.minY(), v.minZ(), v.maxX(), v.maxY(), v.maxZ());
    }


    /**
     * Set this axis-aligned bounding box to the given values.
     *
     * @param minX the {@code minX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @return this
     */
    @Mutated public DoubleAABB set(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        return this;
    }


    /**
     * Set the maximum corner of this axis-aligned bounding box to {@code max} and store the result
     * in {@code dest}.
     *
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMax(Double3R max, @Mutated DoubleAABB dest) {
        return setMax(max.x(), max.y(), max.z(), dest);
    }


    /**
     * Set the maximum corner of this axis-aligned bounding box to ({@code maxX}, {@code maxY},
     * {@code maxZ}) and store the result in {@code dest}.
     *
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMax(double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.minZ = this.minZ;
        d.maxX = maxX;
        d.maxY = maxY;
        d.maxZ = maxZ;
        return d;
    }


    /**
     * Set the minimum corner of this axis-aligned bounding box to {@code min} and store the result
     * in {@code dest}.
     *
     * @param min the minimum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMin(Double3R min, @Mutated DoubleAABB dest) {
        return setMin(min.x(), min.y(), min.z(), dest);
    }


    /**
     * Set the minimum corner of this axis-aligned bounding box to ({@code minX}, {@code minY},
     * {@code minZ}) and store the result in {@code dest}.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMin(double minX, double minY, double minZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = minX;
        d.minY = minY;
        d.minZ = minZ;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        d.maxZ = this.maxZ;
        return d;
    }


    /**
     * Convert this axis-aligned bounding box to {@code float} precision and store the result in
     * {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB toFloat(@Mutated FloatAABB dest) {
        FloatAABBImpl d = (FloatAABBImpl) dest;
        d.minX = (float) (this.minX);
        d.minY = (float) (this.minY);
        d.minZ = (float) (this.minZ);
        d.maxX = (float) (this.maxX);
        d.maxY = (float) (this.maxY);
        d.maxZ = (float) (this.maxZ);
        return d;
    }


    /**
     * Swap the minimum and maximum bounds of this axis-aligned bounding box where necessary so the
     * bounds are valid and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB correctBounds(@Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        double _buf0 = Math.min(this.minX, this.maxX);
        double _buf1 = Math.min(this.minY, this.maxY);
        double _buf2 = Math.min(this.minZ, this.maxZ);
        d.maxX = Math.max(this.minX, this.maxX);
        d.maxY = Math.max(this.minY, this.maxY);
        d.maxZ = Math.max(this.minZ, this.maxZ);
        d.minX = _buf0;
        d.minY = _buf1;
        d.minZ = _buf2;
        return d;
    }


    /**
     * Transform this axis-aligned bounding box by {@code m} and set it to the axis-aligned box
     * enclosing the transformed box and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB transform(Double3x4R m, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        double _t9 = this.minZ + this.maxZ;
        double _t10 = this.minX + this.maxX;
        double _t11 = this.minY + this.maxY;
        double _t12 = this.maxX - this.minX;
        double _t13 = this.maxY - this.minY;
        double _t14 = this.maxZ - this.minZ;
        double _t33 = 0.5 * m.m02() * _t9;
        double _t34 = 0.5 * m.m12() * _t9;
        double _t35 = 0.5 * m.m22() * _t9;
        double _t39 = 0.5 * (m.m00() * _t10 + m.m01() * _t11);
        double _t41 = 0.5 * (m.m10() * _t10 + m.m11() * _t11);
        double _t43 = 0.5 * (m.m20() * _t10 + m.m21() * _t11);
        double _t48 = 0.5 * (_t12 * Math.abs(m.m00()) + _t13 * Math.abs(m.m01()) + _t14 * Math.abs(m.m02()));
        double _t49 = 0.5 * (_t12 * Math.abs(m.m10()) + _t13 * Math.abs(m.m11()) + _t14 * Math.abs(m.m12()));
        double _t50 = 0.5 * (_t12 * Math.abs(m.m20()) + _t13 * Math.abs(m.m21()) + _t14 * Math.abs(m.m22()));
        d.minX = _t33 + (_t39 + (m.m03() - _t48));
        d.minY = _t34 + (_t41 + (m.m13() - _t49));
        d.minZ = _t35 + (_t43 + (m.m23() - _t50));
        d.maxX = _t33 + (_t39 + (_t48 + m.m03()));
        d.maxY = _t34 + (_t41 + (_t49 + m.m13()));
        d.maxZ = _t35 + (_t43 + (_t50 + m.m23()));
        return d;
    }


    /**
     * Transform this axis-aligned bounding box by {@code m} and set it to the axis-aligned box
     * enclosing the transformed box and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB transform(Double4x4R m, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        double _t9 = this.minZ + this.maxZ;
        double _t10 = this.minX + this.maxX;
        double _t11 = this.minY + this.maxY;
        double _t12 = this.maxX - this.minX;
        double _t13 = this.maxY - this.minY;
        double _t14 = this.maxZ - this.minZ;
        double _t33 = 0.5 * m.m02() * _t9;
        double _t34 = 0.5 * m.m12() * _t9;
        double _t35 = 0.5 * m.m22() * _t9;
        double _t39 = 0.5 * (m.m00() * _t10 + m.m01() * _t11);
        double _t41 = 0.5 * (m.m10() * _t10 + m.m11() * _t11);
        double _t43 = 0.5 * (m.m20() * _t10 + m.m21() * _t11);
        double _t48 = 0.5 * (_t12 * Math.abs(m.m00()) + _t13 * Math.abs(m.m01()) + _t14 * Math.abs(m.m02()));
        double _t49 = 0.5 * (_t12 * Math.abs(m.m10()) + _t13 * Math.abs(m.m11()) + _t14 * Math.abs(m.m12()));
        double _t50 = 0.5 * (_t12 * Math.abs(m.m20()) + _t13 * Math.abs(m.m21()) + _t14 * Math.abs(m.m22()));
        d.minX = _t33 + (_t39 + (m.m03() - _t48));
        d.minY = _t34 + (_t41 + (m.m13() - _t49));
        d.minZ = _t35 + (_t43 + (m.m23() - _t50));
        d.maxX = _t33 + (_t39 + (_t48 + m.m03()));
        d.maxY = _t34 + (_t41 + (_t49 + m.m13()));
        d.maxZ = _t35 + (_t43 + (_t50 + m.m23()));
        return d;
    }


    /**
     * Translate this axis-aligned bounding box by {@code delta} and store the result in
     * {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB translate(Double3R delta, @Mutated DoubleAABB dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this axis-aligned bounding box by ({@code deltaX}, {@code deltaY}, {@code deltaZ})
     * and store the result in {@code dest}.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB translate(double deltaX, double deltaY, double deltaZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = deltaX + this.minX;
        d.minY = deltaY + this.minY;
        d.minZ = deltaZ + this.minZ;
        d.maxX = deltaX + this.maxX;
        d.maxY = deltaY + this.maxY;
        d.maxZ = deltaZ + this.maxZ;
        return d;
    }


    /**
     * Set this axis-aligned bounding box to the union of itself and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other axis-aligned bounding box
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB union(DoubleAABBR other, @Mutated DoubleAABB dest) {
        return union(other.minX(), other.minY(), other.minZ(), other.maxX(), other.maxY(), other.maxZ(), dest);
    }


    /**
     * Set this axis-aligned bounding box to the union of itself and ({@code minX}, {@code minY},
     * {@code minZ}, {@code maxX}, {@code maxY}, {@code maxZ}) and store the result in {@code dest}.
     *
     * @param minX the {@code minX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minY the {@code minY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param minZ the {@code minZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxX the {@code maxX} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxY the {@code maxY} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param maxZ the {@code maxZ} component of the axis-aligned bounding box
     *        {@code (minX, minY, minZ, maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB union(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = Math.min(this.minX, minX);
        d.minY = Math.min(this.minY, minY);
        d.minZ = Math.min(this.minZ, minZ);
        d.maxX = Math.max(this.maxX, maxX);
        d.maxY = Math.max(this.maxY, maxY);
        d.maxZ = Math.max(this.maxZ, maxZ);
        return d;
    }


    /**
     * Grow this axis-aligned bounding box to include the point {@code p} and store the result in
     * {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB union(Double3R p, @Mutated DoubleAABB dest) {
        return union(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Grow this axis-aligned bounding box to include the point ({@code pX}, {@code pY}, {@code pZ})
     * and store the result in {@code dest}.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB union(double pX, double pY, double pZ, @Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = Math.min(this.minX, pX);
        d.minY = Math.min(this.minY, pY);
        d.minZ = Math.min(this.minZ, pZ);
        d.maxX = Math.max(this.maxX, pX);
        d.maxY = Math.max(this.maxY, pY);
        d.maxZ = Math.max(this.maxZ, pZ);
        return d;
    }


    /**
     * Get the center of this axis-aligned bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCenter(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.5 * (this.minX + this.maxX);
        d.y = 0.5 * (this.minY + this.maxY);
        d.z = 0.5 * (this.minZ + this.maxZ);
        return d;
    }


    /**
     * Get the maximum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getMax(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.maxX;
        d.y = this.maxY;
        d.z = this.maxZ;
        return d;
    }


    /**
     * Get the minimum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getMin(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.minX;
        d.y = this.minY;
        d.z = this.minZ;
        return d;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this axis-aligned
     * bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getSize(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.maxX - this.minX;
        d.y = this.maxY - this.minY;
        d.z = this.maxZ - this.minZ;
        return d;
    }


    /**
     * Determine whether this axis-aligned bounding box is valid, i.e. no minimum bound exceeds its
     * maximum.
     *
     * @return {@code true} if this axis-aligned bounding box is valid, i.e. no minimum bound
     *        exceeds its maximum, {@code false} otherwise
     */
    public boolean isValid() {
        if (!(this.minX <= this.maxX)) return false;
        if (!(this.minY <= this.maxY)) return false;
        return this.minZ <= this.maxZ;
    }

    public double minX() { return this.minX; }
    public double minY() { return this.minY; }
    public double minZ() { return this.minZ; }
    public double maxX() { return this.maxX; }
    public double maxY() { return this.maxY; }
    public double maxZ() { return this.maxZ; }

    @Override public String toString() {
        return "DoubleAABB(" + minX() + ", " + minY() + ", " + minZ() + ", " + maxX() + ", " + maxY() + ", " + maxZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleAABBImpl)) return false;
        DoubleAABBImpl o = (DoubleAABBImpl) obj;
        return Double.doubleToLongBits(minX) == Double.doubleToLongBits(o.minX)
            && Double.doubleToLongBits(minY) == Double.doubleToLongBits(o.minY)
            && Double.doubleToLongBits(minZ) == Double.doubleToLongBits(o.minZ)
            && Double.doubleToLongBits(maxX) == Double.doubleToLongBits(o.maxX)
            && Double.doubleToLongBits(maxY) == Double.doubleToLongBits(o.maxY)
            && Double.doubleToLongBits(maxZ) == Double.doubleToLongBits(o.maxZ);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(minX) ^ (Double.doubleToLongBits(minX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(minY) ^ (Double.doubleToLongBits(minY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(minZ) ^ (Double.doubleToLongBits(minZ) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(maxX) ^ (Double.doubleToLongBits(maxX) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(maxY) ^ (Double.doubleToLongBits(maxY) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(maxZ) ^ (Double.doubleToLongBits(maxZ) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(minX)
            && Double.isFinite(minY)
            && Double.isFinite(minZ)
            && Double.isFinite(maxX)
            && Double.isFinite(maxY)
            && Double.isFinite(maxZ);
    }

    @Override public boolean equalsEpsilon(DoubleAABBR other, double epsilon) {
        return Math.abs(minX - other.minX()) <= epsilon
            && Math.abs(minY - other.minY()) <= epsilon
            && Math.abs(minZ - other.minZ()) <= epsilon
            && Math.abs(maxX - other.maxX()) <= epsilon
            && Math.abs(maxY - other.maxY()) <= epsilon
            && Math.abs(maxZ - other.maxZ()) <= epsilon;
    }

    public boolean containsPoint(double x, double y, double z) {
        return Intersectiond.testPointAabb(x, y, z, minX(), minY(), minZ(), maxX(), maxY(), maxZ());
    }

    public boolean containsPoint(Double3R p) {
        return Intersectiond.testPointAabb(p, this);
    }

    public boolean containsAABB(DoubleAABBR o) {
        return Intersectiond.testAabbAabbContains(this, o);
    }

    public boolean intersectsAABB(DoubleAABBR o) {
        return Intersectiond.testAabbAabb(this, o);
    }

    public boolean intersectsSweptAABB(DoubleAABBR other, double vX, double vY, double vZ) {
        return Intersectiond.testMovingAabbAabb(other.minX(), other.minY(), other.minZ(), other.maxX(), other.maxY(), other.maxZ(), vX, vY, vZ, minX(), minY(), minZ(), maxX(), maxY(), maxZ());
    }

    public boolean intersectsSweptAABB(DoubleAABBR other, Double3R velocity) {
        return intersectsSweptAABB(other, velocity.x(), velocity.y(), velocity.z());
    }

    public boolean intersectsSphere(DoubleSphereR sph) {
        return Intersectiond.testAabbSphere(this, sph);
    }

    public boolean intersectsPlane(DoublePlaneR plane) {
        return Intersectiond.testAabbPlane(minX(), minY(), minZ(), maxX(), maxY(), maxZ(), plane.a(), plane.b(), plane.c(), plane.d());
    }

    public boolean intersectsRay(DoubleRayR r) {
        return Intersectiond.testRayAabb(r, this);
    }

    public boolean intersectRay(DoubleRayR r, @Mutated Double2 dest) {
        return Intersectiond.intersectRayAabb(r, this, dest);
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.minZ;
        dest[offset + 3] = this.maxX;
        dest[offset + 4] = this.maxY;
        dest[offset + 5] = this.maxZ;
        return dest;
    }
    public @Mutated DoubleAABB load(double[] src, int offset) {
        this.minX = src[offset + 0];
        this.minY = src[offset + 1];
        this.minZ = src[offset + 2];
        this.maxX = src[offset + 3];
        this.maxY = src[offset + 4];
        this.maxZ = src[offset + 5];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleAABB loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleAABB loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleAABB storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleAABB loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleAABB load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.minX;
        dest[offset + 1] = (float) this.minY;
        dest[offset + 2] = (float) this.minZ;
        dest[offset + 3] = (float) this.maxX;
        dest[offset + 4] = (float) this.maxY;
        dest[offset + 5] = (float) this.maxZ;
        return dest;
    }
    public @Mutated DoubleAABB load(float[] src, int offset) {
        this.minX = src[offset + 0];
        this.minY = src[offset + 1];
        this.minZ = src[offset + 2];
        this.maxX = src[offset + 3];
        this.maxY = src[offset + 4];
        this.maxZ = src[offset + 5];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleAABB loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleAABB loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleAABB storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleAABB loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleAABB loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
