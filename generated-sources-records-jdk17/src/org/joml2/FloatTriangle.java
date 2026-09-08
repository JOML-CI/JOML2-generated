package org.joml2;

import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Immutable triangle of single-precision {@code float} components.
 * <p>
 * All operations leave the receiver unchanged and return their result as a value. An operation
 * whose result equals one of its operands may return that operand instead of allocating a new
 * instance.
 *
 * @param v0X the {@code v0X} component
 * @param v0Y the {@code v0Y} component
 * @param v0Z the {@code v0Z} component
 * @param v1X the {@code v1X} component
 * @param v1Y the {@code v1Y} component
 * @param v1Z the {@code v1Z} component
 * @param v2X the {@code v2X} component
 * @param v2Y the {@code v2Y} component
 * @param v2Z the {@code v2Z} component
 */
public record FloatTriangle(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z) {

    /** The number of bytes one instance occupies in the natural {@code store}/{@code load} layout. */
    public static final int SIZE_BYTES = 36;

    /** Canonical constructor. */
    public FloatTriangle(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z) {
        this.v0X = v0X;
        this.v0Y = v0Y;
        this.v0Z = v0Z;
        this.v1X = v1X;
        this.v1Y = v1Y;
        this.v1Z = v1Z;
        this.v2X = v2X;
        this.v2Y = v2Y;
        this.v2Z = v2Z;
    }

    /**
     * Create a new instance initialized to all zeros.
     */
    public FloatTriangle() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    /** {@return the {@code v0X} component} */
    public float v0X() { return v0X; }
    /** {@return the {@code v0Y} component} */
    public float v0Y() { return v0Y; }
    /** {@return the {@code v0Z} component} */
    public float v0Z() { return v0Z; }
    /** {@return the {@code v1X} component} */
    public float v1X() { return v1X; }
    /** {@return the {@code v1Y} component} */
    public float v1Y() { return v1Y; }
    /** {@return the {@code v1Z} component} */
    public float v1Z() { return v1Z; }
    /** {@return the {@code v2X} component} */
    public float v2X() { return v2X; }
    /** {@return the {@code v2Y} component} */
    public float v2Y() { return v2Y; }
    /** {@return the {@code v2Z} component} */
    public float v2Z() { return v2Z; }


    /**
     * Create a new triangle from the given values.
     *
     * @param v the triangle
     * @return the resulting triangle
     */
    public FloatTriangle set(FloatTriangle v) {
        return set(v.v0X(), v.v0Y(), v.v0Z(), v.v1X(), v.v1Y(), v.v1Z(), v.v2X(), v.v2Y(), v.v2Z());
    }


    /**
     * Create a new triangle from the given values.
     *
     * @param vV0X the {@code v0X} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV0Y the {@code v0Y} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV0Z the {@code v0Z} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV1X the {@code v1X} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV1Y the {@code v1Y} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV1Z the {@code v1Z} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV2X the {@code v2X} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV2Y the {@code v2Y} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @param vV2Z the {@code v2Z} component of the triangle
     *        {@code (vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z)}
     * @return the resulting triangle
     */
    public FloatTriangle set(float vV0X, float vV0Y, float vV0Z, float vV1X, float vV1Y, float vV1Z, float vV2X, float vV2Y, float vV2Z) {
        return new FloatTriangle(vV0X, vV0Y, vV0Z, vV1X, vV1Y, vV1Z, vV2X, vV2Y, vV2Z);
    }


    /**
     * Convert this triangle to {@code double} precision, returning the result as a new instance.
     *
     * @return a new {@code DoubleTriangle} holding the result
     */
    public DoubleTriangle toDouble() {
        return new DoubleTriangle(this.v0X, this.v0Y, this.v0Z, this.v1X, this.v1Y, this.v1Z, this.v2X, this.v2Y, this.v2Z);
    }


    /**
     * Transform this triangle by {@code m}, returning the result as a value.
     *
     * @param m the matrix
     * @return the resulting triangle
     */
    public FloatTriangle transform(Float3x4 m) {
        return new FloatTriangle(Math.fma(m.m02(), this.v0Z, Math.fma(m.m00(), this.v0X, Math.fma(m.m01(), this.v0Y, m.m03()))), Math.fma(m.m12(), this.v0Z, Math.fma(m.m10(), this.v0X, Math.fma(m.m11(), this.v0Y, m.m13()))), Math.fma(m.m22(), this.v0Z, Math.fma(m.m20(), this.v0X, Math.fma(m.m21(), this.v0Y, m.m23()))), Math.fma(m.m02(), this.v1Z, Math.fma(m.m00(), this.v1X, Math.fma(m.m01(), this.v1Y, m.m03()))), Math.fma(m.m12(), this.v1Z, Math.fma(m.m10(), this.v1X, Math.fma(m.m11(), this.v1Y, m.m13()))), Math.fma(m.m22(), this.v1Z, Math.fma(m.m20(), this.v1X, Math.fma(m.m21(), this.v1Y, m.m23()))), Math.fma(m.m02(), this.v2Z, Math.fma(m.m00(), this.v2X, Math.fma(m.m01(), this.v2Y, m.m03()))), Math.fma(m.m12(), this.v2Z, Math.fma(m.m10(), this.v2X, Math.fma(m.m11(), this.v2Y, m.m13()))), Math.fma(m.m22(), this.v2Z, Math.fma(m.m20(), this.v2X, Math.fma(m.m21(), this.v2Y, m.m23()))));
    }


    /**
     * Transform this triangle by {@code m}, returning the result as a value.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @return the resulting triangle
     */
    public FloatTriangle transform(Float4x4 m) {
        return new FloatTriangle(Math.fma(m.m02(), this.v0Z, Math.fma(m.m00(), this.v0X, Math.fma(m.m01(), this.v0Y, m.m03()))), Math.fma(m.m12(), this.v0Z, Math.fma(m.m10(), this.v0X, Math.fma(m.m11(), this.v0Y, m.m13()))), Math.fma(m.m22(), this.v0Z, Math.fma(m.m20(), this.v0X, Math.fma(m.m21(), this.v0Y, m.m23()))), Math.fma(m.m02(), this.v1Z, Math.fma(m.m00(), this.v1X, Math.fma(m.m01(), this.v1Y, m.m03()))), Math.fma(m.m12(), this.v1Z, Math.fma(m.m10(), this.v1X, Math.fma(m.m11(), this.v1Y, m.m13()))), Math.fma(m.m22(), this.v1Z, Math.fma(m.m20(), this.v1X, Math.fma(m.m21(), this.v1Y, m.m23()))), Math.fma(m.m02(), this.v2Z, Math.fma(m.m00(), this.v2X, Math.fma(m.m01(), this.v2Y, m.m03()))), Math.fma(m.m12(), this.v2Z, Math.fma(m.m10(), this.v2X, Math.fma(m.m11(), this.v2Y, m.m13()))), Math.fma(m.m22(), this.v2Z, Math.fma(m.m20(), this.v2X, Math.fma(m.m21(), this.v2Y, m.m23()))));
    }


    /**
     * Compute the area of this triangle.
     *
     * @return the area of this triangle
     */
    public float area() {
        float _t0 = this.v1X - this.v0X;
        float _t1 = this.v2Y - this.v0Y;
        float _t2 = this.v1Y - this.v0Y;
        float _t3 = this.v2X - this.v0X;
        float _t4 = this.v2Z - this.v0Z;
        float _t5 = this.v1Z - this.v0Z;
        float _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        float _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        float _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        return 0.5f * (float) Math.sqrt(Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14)));
    }


    /**
     * Compute the barycentric coordinates of the given point with respect to this triangle,
     * returning the result as a value.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane.
     *
     * @param p the vector
     * @return the resulting vector
     */
    public Float3 barycentric(Float3 p) {
        return barycentric(p.x(), p.y(), p.z());
    }


    /**
     * Compute the barycentric coordinates of the given point with respect to this triangle,
     * returning the result as a value.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @return the resulting vector
     */
    public Float3 barycentric(float pX, float pY, float pZ) {
        float _t0 = pZ - this.v0Z;
        float _t1 = this.v1Z - this.v0Z;
        float _t2 = pX - this.v0X;
        float _t3 = this.v1X - this.v0X;
        float _t4 = pY - this.v0Y;
        float _t5 = this.v1Y - this.v0Y;
        float _t6 = this.v2Z - this.v0Z;
        float _t7 = this.v2X - this.v0X;
        float _t8 = this.v2Y - this.v0Y;
        float _t19 = Math.fma(_t0, _t1, Math.fma(_t2, _t3, _t4 * _t5));
        float _t20 = Math.fma(_t6, _t6, Math.fma(_t7, _t7, _t8 * _t8));
        float _t21 = Math.fma(_t0, _t6, Math.fma(_t2, _t7, _t4 * _t8));
        float _t22 = Math.fma(_t1, _t6, Math.fma(_t3, _t7, _t5 * _t8));
        float _t23 = Math.fma(_t1, _t1, Math.fma(_t3, _t3, _t5 * _t5));
        float _t31 = Math.fma(_t23, _t20, -(_t22 * _t22));
        float _t31_inv = 1.0f / _t31;
        float _t33 = Math.fma(_t19, _t20, -(_t21 * _t22)) * _t31_inv;
        float _t34 = Math.fma(_t21, _t23, -(_t19 * _t22)) * _t31_inv;
        return new Float3(1.0f - _t33 - _t34, _t33, _t34);
    }


    /**
     * Get the centroid (the average of the vertices) of this triangle, returning the result as a
     * value.
     *
     * @return the resulting vector
     */
    public Float3 getCentroid() {
        return new Float3(0.33333334f * (this.v2X + (this.v0X + this.v1X)), 0.33333334f * (this.v2Y + (this.v0Y + this.v1Y)), 0.33333334f * (this.v2Z + (this.v0Z + this.v1Z)));
    }


    /**
     * Get the normal of this triangle, i.e. the cross product {@code (v1 - v0) x (v2 - v0)} (not
     * unit length: its length is twice the triangle's area), returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getNormal() {
        float _t0 = this.v1Y - this.v0Y;
        float _t1 = this.v2Z - this.v0Z;
        float _t2 = this.v1Z - this.v0Z;
        float _t3 = this.v2Y - this.v0Y;
        float _t4 = this.v2X - this.v0X;
        float _t5 = this.v1X - this.v0X;
        return new Float3(Math.fma(_t0, _t1, -(_t2 * _t3)), Math.fma(_t2, _t4, -(_t5 * _t1)), Math.fma(_t5, _t3, -(_t0 * _t4)));
    }


    /**
     * Get the first vertex of this triangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getV0() {
        return new Float3(this.v0X, this.v0Y, this.v0Z);
    }


    /**
     * Get the second vertex of this triangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getV1() {
        return new Float3(this.v1X, this.v1Y, this.v1Z);
    }


    /**
     * Get the third vertex of this triangle, returning the result as a value.
     *
     * @return the resulting vector
     */
    public Float3 getV2() {
        return new Float3(this.v2X, this.v2Y, this.v2Z);
    }

    /**
     * Determine whether this triangle contains the given point (boundary inclusive). Delegates to
     * the shared {@code Intersectionf} kernels.
     *
     * @param pX the x coordinate of the point
     * @param pY the y coordinate of the point
     * @param pZ the z coordinate of the point
     * @return {@code true} if the given point lies inside or on this triangle, {@code false}
     *        otherwise
     */
    public boolean containsPoint(float pX, float pY, float pZ) {
        return Intersectionf.testPointInTriangle(pX, pY, pZ, v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z());
    }

    /**
     * Determine whether this triangle contains the given point (boundary inclusive). Delegates to
     * the shared {@code Intersectionf} kernels.
     *
     * @param p the point
     * @return {@code true} if the given point lies inside or on this triangle, {@code false}
     *        otherwise
     */
    public boolean containsPoint(Float3 p) {
        return containsPoint(p.x(), p.y(), p.z());
    }

    /**
     * Determine whether this triangle intersects the given ray. Delegates to the shared
     * {@code Intersectionf} kernels.
     *
     * @param ray the ray
     * @param epsilon the tolerance below which the ray counts as parallel to the triangle's plane,
     *        guarding the near-zero determinant
     * @return {@code true} if this triangle and the given ray intersect, {@code false} otherwise
     */
    public boolean intersectsRay(FloatRay ray, float epsilon) {
        return Intersectionf.testRayTriangle(ray.oX(), ray.oY(), ray.oZ(), ray.dX(), ray.dY(), ray.dZ(), v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), epsilon);
    }

    /**
     * Determine whether this triangle intersects the given ray, front face only. Delegates to the
     * shared {@code Intersectionf} kernels.
     *
     * @param ray the ray
     * @param epsilon the tolerance below which the ray counts as parallel to the triangle's plane,
     *        guarding the near-zero determinant
     * @return {@code true} if the ray hits the front face of this triangle, {@code false} otherwise
     */
    public boolean intersectsRayFront(FloatRay ray, float epsilon) {
        return Intersectionf.testRayTriangleFront(ray.oX(), ray.oY(), ray.oZ(), ray.dX(), ray.dY(), ray.dZ(), v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), epsilon);
    }

    /**
     * Compute the point on this triangle closest to the given point. Delegates to the shared
     * {@code Intersectionf} kernels.
     *
     * @param p the point
     * @return the point on this triangle closest to the given point
     */
    public Float3 closestPointToPoint(Float3 p) {
        return Intersectionf.closestPointOnTriangle(v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), p.x(), p.y(), p.z());
    }

    /** {@return a copy with the {@code v0X} component replaced by {@code v}} */
    public FloatTriangle withV0X(float v) {
        return new FloatTriangle(v, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v0Y} component replaced by {@code v}} */
    public FloatTriangle withV0Y(float v) {
        return new FloatTriangle(v0X, v, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v0Z} component replaced by {@code v}} */
    public FloatTriangle withV0Z(float v) {
        return new FloatTriangle(v0X, v0Y, v, v1X, v1Y, v1Z, v2X, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v1X} component replaced by {@code v}} */
    public FloatTriangle withV1X(float v) {
        return new FloatTriangle(v0X, v0Y, v0Z, v, v1Y, v1Z, v2X, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v1Y} component replaced by {@code v}} */
    public FloatTriangle withV1Y(float v) {
        return new FloatTriangle(v0X, v0Y, v0Z, v1X, v, v1Z, v2X, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v1Z} component replaced by {@code v}} */
    public FloatTriangle withV1Z(float v) {
        return new FloatTriangle(v0X, v0Y, v0Z, v1X, v1Y, v, v2X, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v2X} component replaced by {@code v}} */
    public FloatTriangle withV2X(float v) {
        return new FloatTriangle(v0X, v0Y, v0Z, v1X, v1Y, v1Z, v, v2Y, v2Z);
    }

    /** {@return a copy with the {@code v2Y} component replaced by {@code v}} */
    public FloatTriangle withV2Y(float v) {
        return new FloatTriangle(v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v, v2Z);
    }

    /** {@return a copy with the {@code v2Z} component replaced by {@code v}} */
    public FloatTriangle withV2Z(float v) {
        return new FloatTriangle(v0X, v0Y, v0Z, v1X, v1Y, v1Z, v2X, v2Y, v);
    }

    @Override public String toString() {
        return "FloatTriangle(" + v0X() + ", " + v0Y() + ", " + v0Z() + ", " + v1X() + ", " + v1Y() + ", " + v1Z() + ", " + v2X() + ", " + v2Y() + ", " + v2Z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatTriangle)) return false;
        FloatTriangle o = (FloatTriangle) obj;
        return Float.floatToIntBits(v0X) == Float.floatToIntBits(o.v0X)
            && Float.floatToIntBits(v0Y) == Float.floatToIntBits(o.v0Y)
            && Float.floatToIntBits(v0Z) == Float.floatToIntBits(o.v0Z)
            && Float.floatToIntBits(v1X) == Float.floatToIntBits(o.v1X)
            && Float.floatToIntBits(v1Y) == Float.floatToIntBits(o.v1Y)
            && Float.floatToIntBits(v1Z) == Float.floatToIntBits(o.v1Z)
            && Float.floatToIntBits(v2X) == Float.floatToIntBits(o.v2X)
            && Float.floatToIntBits(v2Y) == Float.floatToIntBits(o.v2Y)
            && Float.floatToIntBits(v2Z) == Float.floatToIntBits(o.v2Z);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(v0X);
        h = 31 * h + Float.floatToIntBits(v0Y);
        h = 31 * h + Float.floatToIntBits(v0Z);
        h = 31 * h + Float.floatToIntBits(v1X);
        h = 31 * h + Float.floatToIntBits(v1Y);
        h = 31 * h + Float.floatToIntBits(v1Z);
        h = 31 * h + Float.floatToIntBits(v2X);
        h = 31 * h + Float.floatToIntBits(v2Y);
        h = 31 * h + Float.floatToIntBits(v2Z);
        return h;
    }

    /** {@return whether all components of this value are finite, i.e. neither NaN nor infinite} */
    public boolean isFinite() {
        return Float.isFinite(v0X)
            && Float.isFinite(v0Y)
            && Float.isFinite(v0Z)
            && Float.isFinite(v1X)
            && Float.isFinite(v1Y)
            && Float.isFinite(v1Z)
            && Float.isFinite(v2X)
            && Float.isFinite(v2Y)
            && Float.isFinite(v2Z);
    }

    /**
     * Compare this value component-wise against {@code other}, allowing a difference of at
     * most {@code epsilon} per component.
     *
     * @param other the value to compare against
     * @param epsilon the maximum allowed difference per component
     * @return {@code true} if all components differ by at most {@code epsilon}, {@code false} otherwise
     */
    public boolean equalsEpsilon(FloatTriangle other, float epsilon) {
        return Math.abs(v0X - other.v0X()) <= epsilon
            && Math.abs(v0Y - other.v0Y()) <= epsilon
            && Math.abs(v0Z - other.v0Z()) <= epsilon
            && Math.abs(v1X - other.v1X()) <= epsilon
            && Math.abs(v1Y - other.v1Y()) <= epsilon
            && Math.abs(v1Z - other.v1Z()) <= epsilon
            && Math.abs(v2X - other.v2X()) <= epsilon
            && Math.abs(v2Y - other.v2Y()) <= epsilon
            && Math.abs(v2Z - other.v2Z()) <= epsilon;
    }

    static final FloatTriangleBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleBbOpsUnsafe()
                    : new FloatTriangleBbOpsApi();
    static final FloatTriangleRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleRawOpsUnsafe()
                    : new FloatTriangleRawOpsApi();


    /**
     * Store the elements into the given array, starting at the given offset.
     *
     * @param dest the destination array
     * @param offset the start offset in the array, in elements
     * @return dest
     */
    public float[] store(float[] dest, int offset) {
        dest[offset + 0] = this.v0X;
        dest[offset + 1] = this.v0Y;
        dest[offset + 2] = this.v0Z;
        dest[offset + 3] = this.v1X;
        dest[offset + 4] = this.v1Y;
        dest[offset + 5] = this.v1Z;
        dest[offset + 6] = this.v2X;
        dest[offset + 7] = this.v2Y;
        dest[offset + 8] = this.v2Z;
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
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(float[] src, int offset) {
        float _c0 = src[offset + 0];
        float _c1 = src[offset + 1];
        float _c2 = src[offset + 2];
        float _c3 = src[offset + 3];
        float _c4 = src[offset + 4];
        float _c5 = src[offset + 5];
        float _c6 = src[offset + 6];
        float _c7 = src[offset + 7];
        float _c8 = src[offset + 8];
        return new FloatTriangle(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Load the elements from the given array.
     *
     * @param src the source array
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(float[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, starting at its current position (the position is
     * not modified).
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
     *
     * @param buf the destination buffer
     * @return buf
     */
    public FloatBuffer storeRelative(FloatBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 9);
        return buf;
    }

    /**
     * Load the elements from the given buffer, starting at its current position (the position is
     * not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(FloatBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, starting at the given absolute index (the position
     * is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, starting at its current position and advancing the
     * position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadRelative(FloatBuffer buf) {
        int pos = buf.position();
        FloatTriangle r = loadAbsolute(pos, buf);
        buf.position(pos + 9);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, starting at its current position (the position
     * is not modified).
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
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 36);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position (the position
     * is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(ByteBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at the given absolute index (the
     * position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, starting at its current position and advancing
     * the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatTriangle r = loadAbsolute(pos, buf);
        buf.position(pos + 36);
        return r;
    }

    /**
     * Store the elements into the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatTriangle storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address. No bounds or liveness checks are
     * performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadUnsafe(long address) {
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
        dest[offset + 0] = this.v0X;
        dest[offset + 1] = this.v0Y;
        dest[offset + 2] = this.v0Z;
        dest[offset + 3] = this.v1X;
        dest[offset + 4] = this.v1Y;
        dest[offset + 5] = this.v1Z;
        dest[offset + 6] = this.v2X;
        dest[offset + 7] = this.v2Y;
        dest[offset + 8] = this.v2Z;
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
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(double[] src, int offset) {
        float _c0 = (float) src[offset + 0];
        float _c1 = (float) src[offset + 1];
        float _c2 = (float) src[offset + 2];
        float _c3 = (float) src[offset + 3];
        float _c4 = (float) src[offset + 4];
        float _c5 = (float) src[offset + 5];
        float _c6 = (float) src[offset + 6];
        float _c7 = (float) src[offset + 7];
        float _c8 = (float) src[offset + 8];
        return new FloatTriangle(_c0, _c1, _c2, _c3, _c4, _c5, _c6, _c7, _c8);
    }

    /**
     * Load the elements from the given array, converting each element from {@code double}.
     *
     * @param src the source array
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(double[] src) { return load(src, 0); }

    /**
     * Store the elements into the given buffer, converting each element to {@code double}, starting
     * at its current position (the position is not modified).
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
     *
     * @param buf the destination buffer
     * @return buf
     */
    public DoubleBuffer storeRelative(DoubleBuffer buf) {
        int pos = buf.position();
        storeAbsolute(pos, buf);
        buf.position(pos + 9);
        return buf;
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle load(DoubleBuffer buf) {
        return loadAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute element index in the buffer
     * @param buf the source buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(index, buf);
    }

    /**
     * Load the elements from the given buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadRelative(DoubleBuffer buf) {
        int pos = buf.position();
        FloatTriangle r = loadAbsolute(pos, buf);
        buf.position(pos + 9);
        return r;
    }

    /**
     * Store the elements into the given byte buffer, converting each element to {@code double},
     * starting at its current position (the position is not modified).
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
     *
     * @param buf the destination byte buffer
     * @return buf
     */
    public ByteBuffer storeDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        storeDoubleAbsolute(pos, buf);
        buf.position(pos + 72);
        return buf;
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position (the position is not modified).
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadDouble(ByteBuffer buf) {
        return loadDoubleAbsolute(buf.position(), buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at the given absolute index (the position is not used or modified).
     *
     * @param index the absolute byte index in the byte buffer
     * @param buf the source byte buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(index, buf);
    }

    /**
     * Load the elements from the given byte buffer, converting each element from {@code double},
     * starting at its current position and advancing the position accordingly.
     *
     * @param buf the source byte buffer
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadDoubleRelative(ByteBuffer buf) {
        int pos = buf.position();
        FloatTriangle r = loadDoubleAbsolute(pos, buf);
        buf.position(pos + 72);
        return r;
    }

    /**
     * Store the elements into the given raw memory address, converting each element to
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return this
     */
    public FloatTriangle storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }

    /**
     * Load the elements from the given raw memory address, converting each element from
     * {@code double}. No bounds or liveness checks are performed.
     *
     * @param address the raw memory address
     * @return a new {@code FloatTriangle} holding the loaded elements
     */
    public static FloatTriangle loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(address);
    }

}
