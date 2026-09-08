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
 * Generated implementation of {@link FloatSphere} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatSphereImpl implements FloatSphere {

    public float x;
    public float y;
    public float z;
    public float r;
    static final FloatSphereSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatSphereSegOpsUnsafe()
                    : new FloatSphereSegOpsMS();
    static final FloatSphereBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatSphereBbOpsUnsafe()
                    : new FloatSphereBbOpsApi();
    static final FloatSphereRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatSphereRawOpsUnsafe()
                    : new FloatSphereRawOpsApi();

    public FloatSphereImpl() {
    }


    /**
     * Set this sphere to the given values.
     *
     * @param v the sphere
     * @return this
     */
    public @Mutated FloatSphere set(FloatSphereR v) {
        return set(v.x(), v.y(), v.z(), v.r());
    }


    /**
     * Set this sphere to the given values.
     *
     * @param vX the {@code x} component of the sphere {@code (vX, vY, vZ, vR)}
     * @param vY the {@code y} component of the sphere {@code (vX, vY, vZ, vR)}
     * @param vZ the {@code z} component of the sphere {@code (vX, vY, vZ, vR)}
     * @param vR the {@code r} component of the sphere {@code (vX, vY, vZ, vR)}
     * @return this
     */
    @Mutated public FloatSphere set(float vX, float vY, float vZ, float vR) {
        this.x = vX;
        this.y = vY;
        this.z = vZ;
        this.r = vR;
        return this;
    }


    /**
     * Set the center of this sphere to {@code c} and store the result in {@code dest}.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere setCenter(Float3R c, @Mutated FloatSphere dest) {
        return setCenter(c.x(), c.y(), c.z(), dest);
    }


    /**
     * Set the center of this sphere to {@code c} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param c the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere setCenter(Float3R c, @Mutated DoubleSphere dest) {
        return setCenter(c.x(), c.y(), c.z(), dest);
    }


    /**
     * Set the center of this sphere to ({@code cX}, {@code cY}, {@code cZ}) and store the result in
     * {@code dest}.
     *
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere setCenter(float cX, float cY, float cZ, @Mutated FloatSphere dest) {
        FloatSphereImpl d = (FloatSphereImpl) dest;
        d.x = cX;
        d.y = cY;
        d.z = cZ;
        d.r = this.r;
        return d;
    }


    /**
     * Set the center of this sphere to ({@code cX}, {@code cY}, {@code cZ}) and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param cX the {@code x} component of the vector {@code (cX, cY, cZ)}
     * @param cY the {@code y} component of the vector {@code (cX, cY, cZ)}
     * @param cZ the {@code z} component of the vector {@code (cX, cY, cZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere setCenter(float cX, float cY, float cZ, @Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = cX;
        d.y = cY;
        d.z = cZ;
        d.r = this.r;
        return d;
    }


    /**
     * Set the radius of this sphere to {@code radius} and store the result in {@code dest}.
     *
     * @param radius the radius
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere setRadius(float radius, @Mutated FloatSphere dest) {
        FloatSphereImpl d = (FloatSphereImpl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.r = radius;
        return d;
    }


    /**
     * Set the radius of this sphere to {@code radius} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param radius the radius
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere setRadius(float radius, @Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.r = radius;
        return d;
    }


    /**
     * Convert this sphere to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere toDouble(@Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        d.r = this.r;
        return d;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere transform(Float3x4R m, @Mutated FloatSphere dest) {
        FloatSphereImpl d = (FloatSphereImpl) dest;
        float _t15 = Math.abs(m.m00() * m.m01() + m.m10() * m.m11() + m.m20() * m.m21());
        float _t16 = Math.abs(m.m00() * m.m02() + m.m10() * m.m12() + m.m20() * m.m22());
        float _t17 = Math.abs(m.m01() * m.m02() + m.m11() * m.m12() + m.m21() * m.m22());
        float _buf0 = m.m02() * this.z + (m.m00() * this.x + (m.m01() * this.y + m.m03()));
        float _buf1 = m.m12() * this.z + (m.m10() * this.x + (m.m11() * this.y + m.m13()));
        d.z = m.m22() * this.z + (m.m20() * this.x + (m.m21() * this.y + m.m23()));
        d.r = this.r * (float) Math.sqrt(Math.max(Math.max(m.m00() * m.m00() + (m.m10() * m.m10() + (m.m20() * m.m20() + (_t15 + _t16))), m.m01() * m.m01() + (m.m11() * m.m11() + (m.m21() * m.m21() + (_t15 + _t17)))), m.m02() * m.m02() + (m.m12() * m.m12() + (m.m22() * m.m22() + (_t16 + _t17)))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere transform(Float3x4R m, @Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        float _t15 = Math.abs(m.m00() * m.m01() + m.m10() * m.m11() + m.m20() * m.m21());
        float _t16 = Math.abs(m.m00() * m.m02() + m.m10() * m.m12() + m.m20() * m.m22());
        float _t17 = Math.abs(m.m01() * m.m02() + m.m11() * m.m12() + m.m21() * m.m22());
        float _buf0 = m.m02() * this.z + (m.m00() * this.x + (m.m01() * this.y + m.m03()));
        float _buf1 = m.m12() * this.z + (m.m10() * this.x + (m.m11() * this.y + m.m13()));
        d.z = m.m22() * this.z + (m.m20() * this.x + (m.m21() * this.y + m.m23()));
        d.r = this.r * (float) Math.sqrt(Math.max(Math.max(m.m00() * m.m00() + (m.m10() * m.m10() + (m.m20() * m.m20() + (_t15 + _t16))), m.m01() * m.m01() + (m.m11() * m.m11() + (m.m21() * m.m21() + (_t15 + _t17)))), m.m02() * m.m02() + (m.m12() * m.m12() + (m.m22() * m.m22() + (_t16 + _t17)))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere transform(Float4x4R m, @Mutated FloatSphere dest) {
        FloatSphereImpl d = (FloatSphereImpl) dest;
        float _t15 = Math.abs(m.m00() * m.m01() + m.m10() * m.m11() + m.m20() * m.m21());
        float _t16 = Math.abs(m.m00() * m.m02() + m.m10() * m.m12() + m.m20() * m.m22());
        float _t17 = Math.abs(m.m01() * m.m02() + m.m11() * m.m12() + m.m21() * m.m22());
        float _buf0 = m.m02() * this.z + (m.m00() * this.x + (m.m01() * this.y + m.m03()));
        float _buf1 = m.m12() * this.z + (m.m10() * this.x + (m.m11() * this.y + m.m13()));
        d.z = m.m22() * this.z + (m.m20() * this.x + (m.m21() * this.y + m.m23()));
        d.r = this.r * (float) Math.sqrt(Math.max(Math.max(m.m00() * m.m00() + (m.m10() * m.m10() + (m.m20() * m.m20() + (_t15 + _t16))), m.m01() * m.m01() + (m.m11() * m.m11() + (m.m21() * m.m21() + (_t15 + _t17)))), m.m02() * m.m02() + (m.m12() * m.m12() + (m.m22() * m.m22() + (_t16 + _t17)))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Transform this sphere by {@code m}, scaling the radius conservatively by the matrix's maximum
     * axis scale and store the result in {@code dest}.
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
    public DoubleSphere transform(Float4x4R m, @Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        float _t15 = Math.abs(m.m00() * m.m01() + m.m10() * m.m11() + m.m20() * m.m21());
        float _t16 = Math.abs(m.m00() * m.m02() + m.m10() * m.m12() + m.m20() * m.m22());
        float _t17 = Math.abs(m.m01() * m.m02() + m.m11() * m.m12() + m.m21() * m.m22());
        float _buf0 = m.m02() * this.z + (m.m00() * this.x + (m.m01() * this.y + m.m03()));
        float _buf1 = m.m12() * this.z + (m.m10() * this.x + (m.m11() * this.y + m.m13()));
        d.z = m.m22() * this.z + (m.m20() * this.x + (m.m21() * this.y + m.m23()));
        d.r = this.r * (float) Math.sqrt(Math.max(Math.max(m.m00() * m.m00() + (m.m10() * m.m10() + (m.m20() * m.m20() + (_t15 + _t16))), m.m01() * m.m01() + (m.m11() * m.m11() + (m.m21() * m.m21() + (_t15 + _t17)))), m.m02() * m.m02() + (m.m12() * m.m12() + (m.m22() * m.m22() + (_t16 + _t17)))));
        d.x = _buf0;
        d.y = _buf1;
        return d;
    }


    /**
     * Translate this sphere by {@code delta} and store the result in {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere translate(Float3R delta, @Mutated FloatSphere dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this sphere by {@code delta} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere translate(Float3R delta, @Mutated DoubleSphere dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this sphere by ({@code deltaX}, {@code deltaY}, {@code deltaZ}) and store the
     * result in {@code dest}.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param dest will hold the result
     * @return dest
     */
    public FloatSphere translate(float deltaX, float deltaY, float deltaZ, @Mutated FloatSphere dest) {
        FloatSphereImpl d = (FloatSphereImpl) dest;
        d.x = deltaX + this.x;
        d.y = deltaY + this.y;
        d.z = deltaZ + this.z;
        d.r = this.r;
        return d;
    }


    /**
     * Translate this sphere by ({@code deltaX}, {@code deltaY}, {@code deltaZ}) and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param deltaX the {@code x} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaY the {@code y} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param deltaZ the {@code z} component of the vector {@code (deltaX, deltaY, deltaZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleSphere translate(float deltaX, float deltaY, float deltaZ, @Mutated DoubleSphere dest) {
        DoubleSphereImpl d = (DoubleSphereImpl) dest;
        d.x = deltaX + this.x;
        d.y = deltaY + this.y;
        d.z = deltaZ + this.z;
        d.r = this.r;
        return d;
    }


    /**
     * Get the center of this sphere and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getCenter(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        return d;
    }


    /**
     * Get the center of this sphere and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCenter(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.x;
        d.y = this.y;
        d.z = this.z;
        return d;
    }


    /**
     * Determine whether this sphere is valid, i.e. its radius is not negative.
     *
     * @return {@code true} if this sphere is valid, i.e. its radius is not negative, {@code false}
     *        otherwise
     */
    public boolean isValid() {
        return this.r >= 0.0f;
    }

    public float x() { return this.x; }
    public float y() { return this.y; }
    public float z() { return this.z; }
    public float r() { return this.r; }

    @Override public String toString() {
        return "FloatSphere(" + x() + ", " + y() + ", " + z() + ", " + r() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatSphereImpl)) return false;
        FloatSphereImpl o = (FloatSphereImpl) obj;
        return Float.floatToIntBits(x) == Float.floatToIntBits(o.x)
            && Float.floatToIntBits(y) == Float.floatToIntBits(o.y)
            && Float.floatToIntBits(z) == Float.floatToIntBits(o.z)
            && Float.floatToIntBits(r) == Float.floatToIntBits(o.r);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(x);
        h = 31 * h + Float.floatToIntBits(y);
        h = 31 * h + Float.floatToIntBits(z);
        h = 31 * h + Float.floatToIntBits(r);
        return h;
    }

    @Override public boolean isFinite() {
        return Float.isFinite(x)
            && Float.isFinite(y)
            && Float.isFinite(z)
            && Float.isFinite(r);
    }

    @Override public boolean equalsEpsilon(FloatSphereR other, float epsilon) {
        return Math.abs(x - other.x()) <= epsilon
            && Math.abs(y - other.y()) <= epsilon
            && Math.abs(z - other.z()) <= epsilon
            && Math.abs(r - other.r()) <= epsilon;
    }

    public boolean containsPoint(float px, float py, float pz) {
        return Intersectionf.testPointSphere(px, py, pz, x(), y(), z(), r() * r());
    }

    public boolean containsPoint(Float3R p) {
        return Intersectionf.testPointSphere(p, this);
    }

    public boolean intersectsSphere(FloatSphereR o) {
        return Intersectionf.testSphereSphere(x(), y(), z(), r() * r(), o.x(), o.y(), o.z(), o.r() * o.r());
    }

    public boolean intersectsAABB(FloatAABBR aabb) {
        return Intersectionf.testAabbSphere(aabb, this);
    }

    public boolean intersectsPlane(FloatPlaneR plane) {
        return Intersectionf.testPlaneSphere(plane.a(), plane.b(), plane.c(), plane.d(), x(), y(), z(), r());
    }

    public boolean intersectsRay(FloatRayR ray) {
        return Intersectionf.testRaySphere(ray, this);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.r;
        return dest;
    }
    public @Mutated FloatSphere load(float[] src, int offset) {
        this.x = src[offset + 0];
        this.y = src[offset + 1];
        this.z = src[offset + 2];
        this.r = src[offset + 3];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatSphere loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatSphere loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatSphere storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatSphere loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public FloatSphere load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.x;
        dest[offset + 1] = this.y;
        dest[offset + 2] = this.z;
        dest[offset + 3] = this.r;
        return dest;
    }
    public @Mutated FloatSphere load(double[] src, int offset) {
        this.x = (float) src[offset + 0];
        this.y = (float) src[offset + 1];
        this.z = (float) src[offset + 2];
        this.r = (float) src[offset + 3];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatSphere loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatSphere loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatSphere storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatSphere loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatSphere loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
