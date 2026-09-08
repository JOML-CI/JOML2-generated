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
 * Generated implementation of {@link FloatTriangle} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatTriangleImpl implements FloatTriangle {

    public float v0X;
    public float v0Y;
    public float v0Z;
    public float v1X;
    public float v1Y;
    public float v1Z;
    public float v2X;
    public float v2Y;
    public float v2Z;
    static final FloatTriangleSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleSegOpsUnsafe()
                    : new FloatTriangleSegOpsMS();
    static final FloatTriangleBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleBbOpsUnsafe()
                    : new FloatTriangleBbOpsApi();
    static final FloatTriangleRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleRawOpsUnsafe()
                    : new FloatTriangleRawOpsApi();

    public FloatTriangleImpl() {
    }


    /**
     * Set this triangle to the given values.
     *
     * @param v the triangle
     * @return this
     */
    public @Mutated FloatTriangle set(FloatTriangleR v) {
        return set(v.v0X(), v.v0Y(), v.v0Z(), v.v1X(), v.v1Y(), v.v1Z(), v.v2X(), v.v2Y(), v.v2Z());
    }


    /**
     * Set this triangle to the given values.
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
     * @return this
     */
    @Mutated public FloatTriangle set(float vV0X, float vV0Y, float vV0Z, float vV1X, float vV1Y, float vV1Z, float vV2X, float vV2Y, float vV2Z) {
        this.v0X = vV0X;
        this.v0Y = vV0Y;
        this.v0Z = vV0Z;
        this.v1X = vV1X;
        this.v1Y = vV1Y;
        this.v1Z = vV1Z;
        this.v2X = vV2X;
        this.v2Y = vV2Y;
        this.v2Z = vV2Z;
        return this;
    }


    /**
     * Convert this triangle to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle toDouble(@Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        d.v0X = this.v0X;
        d.v0Y = this.v0Y;
        d.v0Z = this.v0Z;
        d.v1X = this.v1X;
        d.v1Y = this.v1Y;
        d.v1Z = this.v1Z;
        d.v2X = this.v2X;
        d.v2Y = this.v2Y;
        d.v2Z = this.v2Z;
        return d;
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatTriangle transform(Float3x4R m, @Mutated FloatTriangle dest) {
        FloatTriangleImpl d = (FloatTriangleImpl) dest;
        float _buf0 = Math.fma(m.m02(), this.v0Z, Math.fma(m.m00(), this.v0X, Math.fma(m.m01(), this.v0Y, m.m03())));
        float _buf1 = Math.fma(m.m12(), this.v0Z, Math.fma(m.m10(), this.v0X, Math.fma(m.m11(), this.v0Y, m.m13())));
        d.v0Z = Math.fma(m.m22(), this.v0Z, Math.fma(m.m20(), this.v0X, Math.fma(m.m21(), this.v0Y, m.m23())));
        float _buf2 = Math.fma(m.m02(), this.v1Z, Math.fma(m.m00(), this.v1X, Math.fma(m.m01(), this.v1Y, m.m03())));
        float _buf3 = Math.fma(m.m12(), this.v1Z, Math.fma(m.m10(), this.v1X, Math.fma(m.m11(), this.v1Y, m.m13())));
        d.v1Z = Math.fma(m.m22(), this.v1Z, Math.fma(m.m20(), this.v1X, Math.fma(m.m21(), this.v1Y, m.m23())));
        float _buf4 = Math.fma(m.m02(), this.v2Z, Math.fma(m.m00(), this.v2X, Math.fma(m.m01(), this.v2Y, m.m03())));
        float _buf5 = Math.fma(m.m12(), this.v2Z, Math.fma(m.m10(), this.v2X, Math.fma(m.m11(), this.v2Y, m.m13())));
        d.v2Z = Math.fma(m.m22(), this.v2Z, Math.fma(m.m20(), this.v2X, Math.fma(m.m21(), this.v2Y, m.m23())));
        d.v0X = _buf0;
        d.v0Y = _buf1;
        d.v1X = _buf2;
        d.v1Y = _buf3;
        d.v2X = _buf4;
        d.v2Y = _buf5;
        return d;
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle transform(Float3x4R m, @Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        float _buf0 = Math.fma(m.m02(), this.v0Z, Math.fma(m.m00(), this.v0X, Math.fma(m.m01(), this.v0Y, m.m03())));
        float _buf1 = Math.fma(m.m12(), this.v0Z, Math.fma(m.m10(), this.v0X, Math.fma(m.m11(), this.v0Y, m.m13())));
        d.v0Z = Math.fma(m.m22(), this.v0Z, Math.fma(m.m20(), this.v0X, Math.fma(m.m21(), this.v0Y, m.m23())));
        float _buf2 = Math.fma(m.m02(), this.v1Z, Math.fma(m.m00(), this.v1X, Math.fma(m.m01(), this.v1Y, m.m03())));
        float _buf3 = Math.fma(m.m12(), this.v1Z, Math.fma(m.m10(), this.v1X, Math.fma(m.m11(), this.v1Y, m.m13())));
        d.v1Z = Math.fma(m.m22(), this.v1Z, Math.fma(m.m20(), this.v1X, Math.fma(m.m21(), this.v1Y, m.m23())));
        float _buf4 = Math.fma(m.m02(), this.v2Z, Math.fma(m.m00(), this.v2X, Math.fma(m.m01(), this.v2Y, m.m03())));
        float _buf5 = Math.fma(m.m12(), this.v2Z, Math.fma(m.m10(), this.v2X, Math.fma(m.m11(), this.v2Y, m.m13())));
        d.v2Z = Math.fma(m.m22(), this.v2Z, Math.fma(m.m20(), this.v2X, Math.fma(m.m21(), this.v2Y, m.m23())));
        d.v0X = _buf0;
        d.v0Y = _buf1;
        d.v1X = _buf2;
        d.v1Y = _buf3;
        d.v2X = _buf4;
        d.v2Y = _buf5;
        return d;
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatTriangle transform(Float4x4R m, @Mutated FloatTriangle dest) {
        FloatTriangleImpl d = (FloatTriangleImpl) dest;
        float _buf0 = Math.fma(m.m02(), this.v0Z, Math.fma(m.m00(), this.v0X, Math.fma(m.m01(), this.v0Y, m.m03())));
        float _buf1 = Math.fma(m.m12(), this.v0Z, Math.fma(m.m10(), this.v0X, Math.fma(m.m11(), this.v0Y, m.m13())));
        d.v0Z = Math.fma(m.m22(), this.v0Z, Math.fma(m.m20(), this.v0X, Math.fma(m.m21(), this.v0Y, m.m23())));
        float _buf2 = Math.fma(m.m02(), this.v1Z, Math.fma(m.m00(), this.v1X, Math.fma(m.m01(), this.v1Y, m.m03())));
        float _buf3 = Math.fma(m.m12(), this.v1Z, Math.fma(m.m10(), this.v1X, Math.fma(m.m11(), this.v1Y, m.m13())));
        d.v1Z = Math.fma(m.m22(), this.v1Z, Math.fma(m.m20(), this.v1X, Math.fma(m.m21(), this.v1Y, m.m23())));
        float _buf4 = Math.fma(m.m02(), this.v2Z, Math.fma(m.m00(), this.v2X, Math.fma(m.m01(), this.v2Y, m.m03())));
        float _buf5 = Math.fma(m.m12(), this.v2Z, Math.fma(m.m10(), this.v2X, Math.fma(m.m11(), this.v2Y, m.m13())));
        d.v2Z = Math.fma(m.m22(), this.v2Z, Math.fma(m.m20(), this.v2X, Math.fma(m.m21(), this.v2Y, m.m23())));
        d.v0X = _buf0;
        d.v0Y = _buf1;
        d.v1X = _buf2;
        d.v1Y = _buf3;
        d.v2X = _buf4;
        d.v2Y = _buf5;
        return d;
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
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
    public DoubleTriangle transform(Float4x4R m, @Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        float _buf0 = Math.fma(m.m02(), this.v0Z, Math.fma(m.m00(), this.v0X, Math.fma(m.m01(), this.v0Y, m.m03())));
        float _buf1 = Math.fma(m.m12(), this.v0Z, Math.fma(m.m10(), this.v0X, Math.fma(m.m11(), this.v0Y, m.m13())));
        d.v0Z = Math.fma(m.m22(), this.v0Z, Math.fma(m.m20(), this.v0X, Math.fma(m.m21(), this.v0Y, m.m23())));
        float _buf2 = Math.fma(m.m02(), this.v1Z, Math.fma(m.m00(), this.v1X, Math.fma(m.m01(), this.v1Y, m.m03())));
        float _buf3 = Math.fma(m.m12(), this.v1Z, Math.fma(m.m10(), this.v1X, Math.fma(m.m11(), this.v1Y, m.m13())));
        d.v1Z = Math.fma(m.m22(), this.v1Z, Math.fma(m.m20(), this.v1X, Math.fma(m.m21(), this.v1Y, m.m23())));
        float _buf4 = Math.fma(m.m02(), this.v2Z, Math.fma(m.m00(), this.v2X, Math.fma(m.m01(), this.v2Y, m.m03())));
        float _buf5 = Math.fma(m.m12(), this.v2Z, Math.fma(m.m10(), this.v2X, Math.fma(m.m11(), this.v2Y, m.m13())));
        d.v2Z = Math.fma(m.m22(), this.v2Z, Math.fma(m.m20(), this.v2X, Math.fma(m.m21(), this.v2Y, m.m23())));
        d.v0X = _buf0;
        d.v0Y = _buf1;
        d.v1X = _buf2;
        d.v1Y = _buf3;
        d.v2X = _buf4;
        d.v2Y = _buf5;
        return d;
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
     * Compute the barycentric coordinates of the given point with respect to this triangle and
     * store the result in {@code dest}.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Float3 barycentric(Float3R p, @Mutated Float3 dest) {
        return barycentric(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Compute the barycentric coordinates of the given point with respect to this triangle and
     * store the result in {@code dest}.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public Double3 barycentric(Float3R p, @Mutated Double3 dest) {
        return barycentric(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Compute the barycentric coordinates of the given point with respect to this triangle and
     * store the result in {@code dest}.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 barycentric(float pX, float pY, float pZ, @Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
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
        d.x = 1.0f - _t33 - _t34;
        d.y = _t33;
        d.z = _t34;
        return d;
    }


    /**
     * Compute the barycentric coordinates of the given point with respect to this triangle and
     * store the result in {@code dest}.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Double3 barycentric(float pX, float pY, float pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
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
        d.x = 1.0f - _t33 - _t34;
        d.y = _t33;
        d.z = _t34;
        return d;
    }


    /**
     * Get the centroid (the average of the vertices) of this triangle and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getCentroid(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = 0.33333334f * (this.v2X + (this.v0X + this.v1X));
        d.y = 0.33333334f * (this.v2Y + (this.v0Y + this.v1Y));
        d.z = 0.33333334f * (this.v2Z + (this.v0Z + this.v1Z));
        return d;
    }


    /**
     * Get the centroid (the average of the vertices) of this triangle and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCentroid(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.33333334f * (this.v2X + (this.v0X + this.v1X));
        d.y = 0.33333334f * (this.v2Y + (this.v0Y + this.v1Y));
        d.z = 0.33333334f * (this.v2Z + (this.v0Z + this.v1Z));
        return d;
    }


    /**
     * Get the normal of this triangle, i.e. the cross product {@code (v1 - v0) x (v2 - v0)} (not
     * unit length: its length is twice the triangle's area) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getNormal(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        float _t0 = this.v1Y - this.v0Y;
        float _t1 = this.v2Z - this.v0Z;
        float _t2 = this.v1Z - this.v0Z;
        float _t3 = this.v2Y - this.v0Y;
        float _t4 = this.v2X - this.v0X;
        float _t5 = this.v1X - this.v0X;
        d.x = Math.fma(_t0, _t1, -(_t2 * _t3));
        d.y = Math.fma(_t2, _t4, -(_t5 * _t1));
        d.z = Math.fma(_t5, _t3, -(_t0 * _t4));
        return d;
    }


    /**
     * Get the normal of this triangle, i.e. the cross product {@code (v1 - v0) x (v2 - v0)} (not
     * unit length: its length is twice the triangle's area) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getNormal(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        float _t0 = this.v1Y - this.v0Y;
        float _t1 = this.v2Z - this.v0Z;
        float _t2 = this.v1Z - this.v0Z;
        float _t3 = this.v2Y - this.v0Y;
        float _t4 = this.v2X - this.v0X;
        float _t5 = this.v1X - this.v0X;
        d.x = Math.fma(_t0, _t1, -(_t2 * _t3));
        d.y = Math.fma(_t2, _t4, -(_t5 * _t1));
        d.z = Math.fma(_t5, _t3, -(_t0 * _t4));
        return d;
    }


    /**
     * Get the first vertex of this triangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getV0(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.v0X;
        d.y = this.v0Y;
        d.z = this.v0Z;
        return d;
    }


    /**
     * Get the first vertex of this triangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getV0(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.v0X;
        d.y = this.v0Y;
        d.z = this.v0Z;
        return d;
    }


    /**
     * Get the second vertex of this triangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getV1(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.v1X;
        d.y = this.v1Y;
        d.z = this.v1Z;
        return d;
    }


    /**
     * Get the second vertex of this triangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getV1(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.v1X;
        d.y = this.v1Y;
        d.z = this.v1Z;
        return d;
    }


    /**
     * Get the third vertex of this triangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getV2(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.v2X;
        d.y = this.v2Y;
        d.z = this.v2Z;
        return d;
    }


    /**
     * Get the third vertex of this triangle and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getV2(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.v2X;
        d.y = this.v2Y;
        d.z = this.v2Z;
        return d;
    }

    public float v0X() { return this.v0X; }
    public float v0Y() { return this.v0Y; }
    public float v0Z() { return this.v0Z; }
    public float v1X() { return this.v1X; }
    public float v1Y() { return this.v1Y; }
    public float v1Z() { return this.v1Z; }
    public float v2X() { return this.v2X; }
    public float v2Y() { return this.v2Y; }
    public float v2Z() { return this.v2Z; }

    @Override public String toString() {
        return "FloatTriangle(" + v0X() + ", " + v0Y() + ", " + v0Z() + ", " + v1X() + ", " + v1Y() + ", " + v1Z() + ", " + v2X() + ", " + v2Y() + ", " + v2Z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatTriangleImpl)) return false;
        FloatTriangleImpl o = (FloatTriangleImpl) obj;
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

    @Override public boolean isFinite() {
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

    @Override public boolean equalsEpsilon(FloatTriangleR other, float epsilon) {
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

    public boolean containsPoint(float pX, float pY, float pZ) {
        return Intersectionf.testPointInTriangle(pX, pY, pZ, v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z());
    }

    public boolean containsPoint(Float3R p) {
        return containsPoint(p.x(), p.y(), p.z());
    }

    public boolean intersectsRay(FloatRayR ray, float epsilon) {
        return Intersectionf.testRayTriangle(ray.oX(), ray.oY(), ray.oZ(), ray.dX(), ray.dY(), ray.dZ(), v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), epsilon);
    }

    public boolean intersectsRayFront(FloatRayR ray, float epsilon) {
        return Intersectionf.testRayTriangleFront(ray.oX(), ray.oY(), ray.oZ(), ray.dX(), ray.dY(), ray.dZ(), v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), epsilon);
    }

    public Float3 closestPointToPoint(float pX, float pY, float pZ, @Mutated Float3 dest) {
        Intersectionf.findClosestPointOnTriangle(v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), pX, pY, pZ, dest);
        return dest;
    }

    public Float3 closestPointToPoint(Float3R p, @Mutated Float3 dest) {
        return closestPointToPoint(p.x(), p.y(), p.z(), dest);
    }

    public float[] store(@Mutated float[] dest, int offset) {
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
    public @Mutated FloatTriangle load(float[] src, int offset) {
        this.v0X = src[offset + 0];
        this.v0Y = src[offset + 1];
        this.v0Z = src[offset + 2];
        this.v1X = src[offset + 3];
        this.v1Y = src[offset + 4];
        this.v1Z = src[offset + 5];
        this.v2X = src[offset + 6];
        this.v2Y = src[offset + 7];
        this.v2Z = src[offset + 8];
        return this;
    }
    public FloatBuffer storeAbsolute(int index, @Mutated FloatBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatTriangle loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatTriangle loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatTriangle storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatTriangle loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public FloatTriangle load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public double[] store(@Mutated double[] dest, int offset) {
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
    public @Mutated FloatTriangle load(double[] src, int offset) {
        this.v0X = (float) src[offset + 0];
        this.v0Y = (float) src[offset + 1];
        this.v0Z = (float) src[offset + 2];
        this.v1X = (float) src[offset + 3];
        this.v1Y = (float) src[offset + 4];
        this.v1Z = (float) src[offset + 5];
        this.v2X = (float) src[offset + 6];
        this.v2Y = (float) src[offset + 7];
        this.v2Z = (float) src[offset + 8];
        return this;
    }
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public FloatTriangle loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatTriangle loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatTriangle storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatTriangle loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }
    public MemorySegment storeDouble(long offset, MemorySegment dest) {
        return SEG_OPS.storeDouble(this, offset, dest);
    }
    public FloatTriangle loadDouble(long offset, MemorySegment src) {
        return SEG_OPS.loadDouble(this, offset, src);
    }

}
