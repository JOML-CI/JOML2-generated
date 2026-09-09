package org.joml2;

import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable plane of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param a the {@code a} component
 * @param b the {@code b} component
 * @param c the {@code c} component
 * @param d the {@code d} component
 */
public record FloatPlane(float a, float b, float c, float d) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 16;

    /** Canonical constructor. */
    public FloatPlane(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * Create a new instance initialized to all zeros.
     */
    public FloatPlane() {
        this(0, 0, 0, 0);
    }

    /** {@return the {@code a} component} */
    public float a() { return a; }
    /** {@return the {@code b} component} */
    public float b() { return b; }
    /** {@return the {@code c} component} */
    public float c() { return c; }
    /** {@return the {@code d} component} */
    public float d() { return d; }


    /**
     * Create a new plane from the given values.
     *
     * @param v the plane
     * @return the resulting plane
     */
    public FloatPlane set(FloatPlane v) {
        return set(v.a(), v.b(), v.c(), v.d());
    }


    /**
     * Create a new plane from the given values.
     *
     * @param vA the {@code a} component of the plane {@code (vA, vB, vC, vD)}
     * @param vB the {@code b} component of the plane {@code (vA, vB, vC, vD)}
     * @param vC the {@code c} component of the plane {@code (vA, vB, vC, vD)}
     * @param vD the {@code d} component of the plane {@code (vA, vB, vC, vD)}
     * @return the resulting plane
     */
    public FloatPlane set(float vA, float vB, float vC, float vD) {
        return new FloatPlane(vA, vB, vC, vD);
    }


    /**
     * Set the normal of this plane to {@code n}, returning the result as a value.
     *
     * @param n the normal
     * @return the resulting plane
     */
    public FloatPlane setNormal(Float3 n) {
        return setNormal(n.x(), n.y(), n.z());
    }


    /**
     * Set the normal of this plane to ({@code nX}, {@code nY}, {@code nZ}), returning the result as
     * a value.
     *
     * @param nX the {@code x} component of the vector {@code (nX, nY, nZ)}
     * @param nY the {@code y} component of the vector {@code (nX, nY, nZ)}
     * @param nZ the {@code z} component of the vector {@code (nX, nY, nZ)}
     * @return the resulting plane
     */
    public FloatPlane setNormal(float nX, float nY, float nZ) {
        return new FloatPlane(nX, nY, nZ, this.d);
    }


    /**
     * Convert this plane to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code DoublePlane} holding the result
     */
    public DoublePlane toDouble() {
        return new DoublePlane(this.a, this.b, this.c, this.d);
    }


    /**
     * Normalize this plane, scaling {@code (a, b, c, d)} so that the normal {@code (a, b, c)} has
     * unit length, returning the result as a value.
     *
     * @return the resulting plane
     */
    public FloatPlane normalize() {
        float _t3 = (1.0f / (float) Math.sqrt(Math.fma(this.c, this.c, Math.fma(this.a, this.a, this.b * this.b))));
        return new FloatPlane(this.a * _t3, this.b * _t3, this.c * _t3, this.d * _t3);
    }


    /**
     * Compute the (unsigned) distance between this plane and the given point. The plane's normal
     * need not be of unit length: the result is divided by that normal's length.
     *
     * @param p the point
     * @return the (unsigned) distance between this plane and the given point. The plane's normal
     *        need not be of unit length: the result is divided by that normal's length
     */
    public float distanceToPoint(Float3 p) {
        return distanceToPoint(p.x(), p.y(), p.z());
    }


    /**
     * Compute the (unsigned) distance between this plane and the given point. The plane's normal
     * need not be of unit length: the result is divided by that normal's length.
     *
     * @param pX the {@code x} component of the point {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the point {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the point {@code (pX, pY, pZ)}
     * @return the (unsigned) distance between this plane and the given point. The plane's normal
     *        need not be of unit length: the result is divided by that normal's length
     */
    public float distanceToPoint(float pX, float pY, float pZ) {
        return (1.0f / (float) Math.sqrt(Math.fma(this.c, this.c, Math.fma(this.a, this.a, this.b * this.b)))) * Math.abs(Math.fma(pX, this.a, Math.fma(pY, this.b, Math.fma(pZ, this.c, this.d))));
    }


    /**
     * Get the normal of this plane, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getNormal() {
        return new Float3(this.a, this.b, this.c);
    }

    /**
     * Compute the signed distance of the given point to this plane. Delegates to the shared
     * {@code Intersectionf} kernels.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @return the signed distance from the given point to this plane - positive on the side the
     *        plane normal points to, and a true distance even when that normal is not unit length
     */
    public float signedDistance(float pX, float pY, float pZ) {
        return Intersectionf.distancePointPlane(pX, pY, pZ, a(), b(), c(), d());
    }

    /**
     * Compute the signed distance of the given point to this plane. Delegates to the shared
     * {@code Intersectionf} kernels.
     *
     * @param p the point
     * @return the signed distance from the given point to this plane - positive on the side the
     *        plane normal points to, and a true distance even when that normal is not unit length
     */
    public float signedDistance(Float3 p) {
        return signedDistance(p.x(), p.y(), p.z());
    }

    /**
     * Determine whether this plane contains the given point (boundary inclusive). Delegates to the
     * shared {@code Intersectionf} kernels.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @param epsilon the maximum distance from the plane at which the point still counts as lying
     *        on it
     * @return {@code true} if the given point lies within {@code epsilon} of this plane,
     *        {@code false} otherwise
     */
    public boolean containsPoint(float pX, float pY, float pZ, float epsilon) {
        return Math.abs(signedDistance(pX, pY, pZ)) <= epsilon;
    }

    /**
     * Determine whether this plane contains the given point (boundary inclusive). Delegates to the
     * shared {@code Intersectionf} kernels.
     *
     * @param p the point
     * @param epsilon the maximum distance from the plane at which the point still counts as lying
     *        on it
     * @return {@code true} if the given point lies within {@code epsilon} of this plane,
     *        {@code false} otherwise
     */
    public boolean containsPoint(Float3 p, float epsilon) {
        return containsPoint(p.x(), p.y(), p.z(), epsilon);
    }

    /**
     * Determine whether this plane intersects the given sphere. Delegates to the shared
     * {@code Intersectionf} kernels.
     *
     * @param sph the sphere
     * @return {@code true} if this plane and the given sphere intersect, {@code false} otherwise
     */
    public boolean intersectsSphere(FloatSphere sph) {
        return Intersectionf.testPlaneSphere(a(), b(), c(), d(), sph.x(), sph.y(), sph.z(), sph.r());
    }

    /**
     * Determine whether this plane intersects the given axis-aligned box. Delegates to the shared
     * {@code Intersectionf} kernels.
     *
     * @param box the axis-aligned box
     * @return {@code true} if this plane and the given axis-aligned box intersect, {@code false}
     *        otherwise
     */
    public boolean intersectsAABB(FloatAABB box) {
        return Intersectionf.testAabbPlane(box.minX(), box.minY(), box.minZ(), box.maxX(), box.maxY(), box.maxZ(), a(), b(), c(), d());
    }

    /**
     * Project the given point onto this plane. Delegates to the shared {@code Intersectionf}
     * kernels.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @return the orthogonal projection of the given point onto this plane
     */
    public Float3 projectPoint(float pX, float pY, float pZ) {
        return Intersectionf.projectPointOnPlane(pX, pY, pZ, a(), b(), c(), d());
    }

    /**
     * Project the given point onto this plane. Delegates to the shared {@code Intersectionf}
     * kernels.
     *
     * @param p the point
     * @return the orthogonal projection of the given point onto this plane
     */
    public Float3 projectPoint(Float3 p) {
        return projectPoint(p.x(), p.y(), p.z());
    }

    /** {@return a copy with the {@code a} component replaced by {@code v}} */
    public FloatPlane withA(float v) {
        return new FloatPlane(v, b, c, d);
    }

    /** {@return a copy with the {@code b} component replaced by {@code v}} */
    public FloatPlane withB(float v) {
        return new FloatPlane(a, v, c, d);
    }

    /** {@return a copy with the {@code c} component replaced by {@code v}} */
    public FloatPlane withC(float v) {
        return new FloatPlane(a, b, v, d);
    }

    /** {@return a copy with the {@code d} component replaced by {@code v}} */
    public FloatPlane withD(float v) {
        return new FloatPlane(a, b, c, v);
    }

    @Override public String toString() {
        return "FloatPlane(" + a() + ", " + b() + ", " + c() + ", " + d() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatPlane)) return false;
        FloatPlane o = (FloatPlane) obj;
        return Float.floatToIntBits(a) == Float.floatToIntBits(o.a)
            && Float.floatToIntBits(b) == Float.floatToIntBits(o.b)
            && Float.floatToIntBits(c) == Float.floatToIntBits(o.c)
            && Float.floatToIntBits(d) == Float.floatToIntBits(o.d);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(a);
        h = 31 * h + Float.floatToIntBits(b);
        h = 31 * h + Float.floatToIntBits(c);
        h = 31 * h + Float.floatToIntBits(d);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(a)
            && Float.isFinite(b)
            && Float.isFinite(c)
            && Float.isFinite(d);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatPlane other, float epsilon) {
        return Math.abs(a - other.a()) <= epsilon
            && Math.abs(b - other.b()) <= epsilon
            && Math.abs(c - other.c()) <= epsilon
            && Math.abs(d - other.d()) <= epsilon;
    }

    static final FloatPlaneBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatPlaneBbOpsUnsafe()
                    : new FloatPlaneBbOpsApi();
    static final FloatPlaneRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatPlaneRawOpsUnsafe()
                    : new FloatPlaneRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = this.a;
        dest[offset + 1] = this.b;
        dest[offset + 2] = this.c;
        dest[offset + 3] = this.d;
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
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        return new FloatPlane(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
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
     *
     * @param buf the source buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param buf the source buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatPlane r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
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
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatPlane r = loadAbsolute(pos, buf);
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
    public FloatPlane storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(address);
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
        dest[offset + 0] = this.a;
        dest[offset + 1] = this.b;
        dest[offset + 2] = this.c;
        dest[offset + 3] = this.d;
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
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        return new FloatPlane(_c0, _c1, _c2, _c3);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
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
     *
     * @param buf the source buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param buf the source buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatPlane r = loadAbsolute(pos, buf);
        buf.position(pos + 4);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position (the position is not modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
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
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     * <p>
     * A buffer in native byte order takes the fast path; any other byte order is honoured through
     * the slower API path.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatPlane r = loadDoubleAbsolute(pos, buf);
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
    public FloatPlane storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatPlane} holding the loaded elements
     */
    public static FloatPlane loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

}
