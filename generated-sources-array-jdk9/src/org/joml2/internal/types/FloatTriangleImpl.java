package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatTriangle} backed by a {@code float[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatTriangleImpl implements FloatTriangle {

    public float[] data;
    static final FloatTriangleBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleBbOpsUnsafe()
                    : new FloatTriangleBbOpsApi();
    static final FloatTriangleRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatTriangleRawOpsUnsafe()
                    : new FloatTriangleRawOpsApi();

    public FloatTriangleImpl() {
        data = new float[9];
    }

    public FloatTriangleImpl(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z) {
        float[] dd = this.data = new float[9];
        dd[0] = v0X;
        dd[1] = v0Y;
        dd[2] = v0Z;
        dd[3] = v1X;
        dd[4] = v1Y;
        dd[5] = v1Z;
        dd[6] = v2X;
        dd[7] = v2Y;
        dd[8] = v2Z;
    }

    public FloatTriangleImpl(FloatTriangleR src) {
        float[] dd = this.data = new float[9];
        dd[0] = src.v0X();
        dd[1] = src.v0Y();
        dd[2] = src.v0Z();
        dd[3] = src.v1X();
        dd[4] = src.v1Y();
        dd[5] = src.v1Z();
        dd[6] = src.v2X();
        dd[7] = src.v2Y();
        dd[8] = src.v2Z();
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
        float[] dd = this.data;
        dd[0] = vV0X;
        dd[1] = vV0Y;
        dd[2] = vV0Z;
        dd[3] = vV1X;
        dd[4] = vV1Y;
        dd[5] = vV1Z;
        dd[6] = vV2X;
        dd[7] = vV2Y;
        dd[8] = vV2Z;
        return this;
    }


    /**
     * Convert this triangle to {@code double} precision and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle toDouble(@Mutated DoubleTriangle dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleTriangleImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        dd[6] = sd[6];
        dd[7] = sd[7];
        dd[8] = sd[8];
        return dest;
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatTriangle transform(Float3x4R m, @Mutated FloatTriangle dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float[] dd = ((FloatTriangleImpl) dest).data;
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        float _buf2 = Math.fma(mData[2], sd[5], Math.fma(mData[0], sd[3], Math.fma(mData[1], sd[4], mData[3])));
        float _buf3 = Math.fma(mData[6], sd[5], Math.fma(mData[4], sd[3], Math.fma(mData[5], sd[4], mData[7])));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[8], sd[3], Math.fma(mData[9], sd[4], mData[11])));
        float _buf4 = Math.fma(mData[2], sd[8], Math.fma(mData[0], sd[6], Math.fma(mData[1], sd[7], mData[3])));
        float _buf5 = Math.fma(mData[6], sd[8], Math.fma(mData[4], sd[6], Math.fma(mData[5], sd[7], mData[7])));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[8], sd[6], Math.fma(mData[9], sd[7], mData[11])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        return dest;
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
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        double[] dd = ((DoubleTriangleImpl) dest).data;
        float _buf0 = Math.fma(mData[2], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[1], sd[1], mData[3])));
        float _buf1 = Math.fma(mData[6], sd[2], Math.fma(mData[4], sd[0], Math.fma(mData[5], sd[1], mData[7])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[8], sd[0], Math.fma(mData[9], sd[1], mData[11])));
        float _buf2 = Math.fma(mData[2], sd[5], Math.fma(mData[0], sd[3], Math.fma(mData[1], sd[4], mData[3])));
        float _buf3 = Math.fma(mData[6], sd[5], Math.fma(mData[4], sd[3], Math.fma(mData[5], sd[4], mData[7])));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[8], sd[3], Math.fma(mData[9], sd[4], mData[11])));
        float _buf4 = Math.fma(mData[2], sd[8], Math.fma(mData[0], sd[6], Math.fma(mData[1], sd[7], mData[3])));
        float _buf5 = Math.fma(mData[6], sd[8], Math.fma(mData[4], sd[6], Math.fma(mData[5], sd[7], mData[7])));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[8], sd[6], Math.fma(mData[9], sd[7], mData[11])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        return dest;
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
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float[] dd = ((FloatTriangleImpl) dest).data;
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        float _buf2 = Math.fma(mData[8], sd[5], Math.fma(mData[0], sd[3], Math.fma(mData[4], sd[4], mData[12])));
        float _buf3 = Math.fma(mData[9], sd[5], Math.fma(mData[1], sd[3], Math.fma(mData[5], sd[4], mData[13])));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[2], sd[3], Math.fma(mData[6], sd[4], mData[14])));
        float _buf4 = Math.fma(mData[8], sd[8], Math.fma(mData[0], sd[6], Math.fma(mData[4], sd[7], mData[12])));
        float _buf5 = Math.fma(mData[9], sd[8], Math.fma(mData[1], sd[6], Math.fma(mData[5], sd[7], mData[13])));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[2], sd[6], Math.fma(mData[6], sd[7], mData[14])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        return dest;
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
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        double[] dd = ((DoubleTriangleImpl) dest).data;
        float _buf0 = Math.fma(mData[8], sd[2], Math.fma(mData[0], sd[0], Math.fma(mData[4], sd[1], mData[12])));
        float _buf1 = Math.fma(mData[9], sd[2], Math.fma(mData[1], sd[0], Math.fma(mData[5], sd[1], mData[13])));
        dd[2] = Math.fma(mData[10], sd[2], Math.fma(mData[2], sd[0], Math.fma(mData[6], sd[1], mData[14])));
        float _buf2 = Math.fma(mData[8], sd[5], Math.fma(mData[0], sd[3], Math.fma(mData[4], sd[4], mData[12])));
        float _buf3 = Math.fma(mData[9], sd[5], Math.fma(mData[1], sd[3], Math.fma(mData[5], sd[4], mData[13])));
        dd[5] = Math.fma(mData[10], sd[5], Math.fma(mData[2], sd[3], Math.fma(mData[6], sd[4], mData[14])));
        float _buf4 = Math.fma(mData[8], sd[8], Math.fma(mData[0], sd[6], Math.fma(mData[4], sd[7], mData[12])));
        float _buf5 = Math.fma(mData[9], sd[8], Math.fma(mData[1], sd[6], Math.fma(mData[5], sd[7], mData[13])));
        dd[8] = Math.fma(mData[10], sd[8], Math.fma(mData[2], sd[6], Math.fma(mData[6], sd[7], mData[14])));
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[3] = _buf2;
        dd[4] = _buf3;
        dd[6] = _buf4;
        dd[7] = _buf5;
        return dest;
    }


    /**
     * Compute the area of this triangle.
     *
     * @return the area of this triangle
     */
    public float area() {
        float[] sd = this.data;
        float _t0 = sd[3] - sd[0];
        float _t1 = sd[7] - sd[1];
        float _t2 = sd[4] - sd[1];
        float _t3 = sd[6] - sd[0];
        float _t4 = sd[8] - sd[2];
        float _t5 = sd[5] - sd[2];
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
     * orthogonal projection onto the triangle's plane. The weights are formed with the
     * cross-product form (areas of the sub-triangles against the triangle's normal), which stays
     * accurate for thin triangles.
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
     * orthogonal projection onto the triangle's plane. The weights are formed with the
     * cross-product form (areas of the sub-triangles against the triangle's normal), which stays
     * accurate for thin triangles.
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
     * orthogonal projection onto the triangle's plane. The weights are formed with the
     * cross-product form (areas of the sub-triangles against the triangle's normal), which stays
     * accurate for thin triangles.
     *
     * @param pX the {@code x} component of the vector {@code (pX, pY, pZ)}
     * @param pY the {@code y} component of the vector {@code (pX, pY, pZ)}
     * @param pZ the {@code z} component of the vector {@code (pX, pY, pZ)}
     * @param dest will hold the result
     * @return dest
     */
    public Float3 barycentric(float pX, float pY, float pZ, @Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = pX - sd[0];
        float _t1 = sd[7] - sd[1];
        float _t2 = pY - sd[1];
        float _t3 = sd[6] - sd[0];
        float _t4 = sd[3] - sd[0];
        float _t5 = sd[4] - sd[1];
        float _t6 = sd[8] - sd[2];
        float _t7 = pZ - sd[2];
        float _t8 = sd[5] - sd[2];
        float _t28 = Math.fma(_t4, _t1, -(_t5 * _t3));
        float _t30 = Math.fma(_t5, _t6, -(_t8 * _t1));
        float _t32 = Math.fma(_t8, _t3, -(_t4 * _t6));
        float _t43 = Math.fma(_t28, _t28, Math.fma(_t30, _t30, _t32 * _t32));
        float _t43_inv = 1.0f / _t43;
        float _t45 = Math.fma(Math.fma(_t0, _t1, -(_t2 * _t3)), _t28, Math.fma(Math.fma(_t2, _t6, -(_t7 * _t1)), _t30, Math.fma(_t7, _t3, -(_t0 * _t6)) * _t32)) * _t43_inv;
        float _t46 = Math.fma(Math.fma(_t2, _t4, -(_t0 * _t5)), _t28, Math.fma(Math.fma(_t0, _t8, -(_t7 * _t4)), _t32, Math.fma(_t7, _t5, -(_t2 * _t8)) * _t30)) * _t43_inv;
        dd[0] = 1.0f - _t45 - _t46;
        dd[1] = _t45;
        dd[2] = _t46;
        return dest;
    }


    /**
     * Compute the barycentric coordinates of the given point with respect to this triangle and
     * store the result in {@code dest}.
     * <p>
     * The three components weight the triangle's first, second and third vertex respectively and
     * sum to 1. A point that is not coplanar with the triangle yields the coordinates of its
     * orthogonal projection onto the triangle's plane. The weights are formed with the
     * cross-product form (areas of the sub-triangles against the triangle's normal), which stays
     * accurate for thin triangles.
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = pX - sd[0];
        float _t1 = sd[7] - sd[1];
        float _t2 = pY - sd[1];
        float _t3 = sd[6] - sd[0];
        float _t4 = sd[3] - sd[0];
        float _t5 = sd[4] - sd[1];
        float _t6 = sd[8] - sd[2];
        float _t7 = pZ - sd[2];
        float _t8 = sd[5] - sd[2];
        float _t28 = Math.fma(_t4, _t1, -(_t5 * _t3));
        float _t30 = Math.fma(_t5, _t6, -(_t8 * _t1));
        float _t32 = Math.fma(_t8, _t3, -(_t4 * _t6));
        float _t43 = Math.fma(_t28, _t28, Math.fma(_t30, _t30, _t32 * _t32));
        float _t43_inv = 1.0f / _t43;
        float _t45 = Math.fma(Math.fma(_t0, _t1, -(_t2 * _t3)), _t28, Math.fma(Math.fma(_t2, _t6, -(_t7 * _t1)), _t30, Math.fma(_t7, _t3, -(_t0 * _t6)) * _t32)) * _t43_inv;
        float _t46 = Math.fma(Math.fma(_t2, _t4, -(_t0 * _t5)), _t28, Math.fma(Math.fma(_t0, _t8, -(_t7 * _t4)), _t32, Math.fma(_t7, _t5, -(_t2 * _t8)) * _t30)) * _t43_inv;
        dd[0] = 1.0f - _t45 - _t46;
        dd[1] = _t45;
        dd[2] = _t46;
        return dest;
    }


    /**
     * Get the centroid (the average of the vertices) of this triangle and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getCentroid(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = 0.33333334f * (sd[6] + (sd[0] + sd[3]));
        dd[1] = 0.33333334f * (sd[7] + (sd[1] + sd[4]));
        dd[2] = 0.33333334f * (sd[8] + (sd[2] + sd[5]));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = 0.33333334f * (sd[6] + (sd[0] + sd[3]));
        dd[1] = 0.33333334f * (sd[7] + (sd[1] + sd[4]));
        dd[2] = 0.33333334f * (sd[8] + (sd[2] + sd[5]));
        return dest;
    }


    /**
     * Get the normal of this triangle, i.e. the cross product {@code (v1 - v0) x (v2 - v0)} (not
     * unit length: its length is twice the triangle's area) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getNormal(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        float _t0 = sd[4] - sd[1];
        float _t1 = sd[8] - sd[2];
        float _t2 = sd[5] - sd[2];
        float _t3 = sd[7] - sd[1];
        float _t4 = sd[6] - sd[0];
        float _t5 = sd[3] - sd[0];
        dd[0] = Math.fma(_t0, _t1, -(_t2 * _t3));
        dd[1] = Math.fma(_t2, _t4, -(_t5 * _t1));
        dd[2] = Math.fma(_t5, _t3, -(_t0 * _t4));
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        float _t0 = sd[4] - sd[1];
        float _t1 = sd[8] - sd[2];
        float _t2 = sd[5] - sd[2];
        float _t3 = sd[7] - sd[1];
        float _t4 = sd[6] - sd[0];
        float _t5 = sd[3] - sd[0];
        dd[0] = Math.fma(_t0, _t1, -(_t2 * _t3));
        dd[1] = Math.fma(_t2, _t4, -(_t5 * _t1));
        dd[2] = Math.fma(_t5, _t3, -(_t0 * _t4));
        return dest;
    }


    /**
     * Get the first vertex of this triangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getV0(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
    }


    /**
     * Get the second vertex of this triangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getV1(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
    }


    /**
     * Get the third vertex of this triangle and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getV2(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        dd[2] = sd[8];
        return dest;
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
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[6];
        dd[1] = sd[7];
        dd[2] = sd[8];
        return dest;
    }

    public float v0X() { return data[0]; }
    public float v0Y() { return data[1]; }
    public float v0Z() { return data[2]; }
    public float v1X() { return data[3]; }
    public float v1Y() { return data[4]; }
    public float v1Z() { return data[5]; }
    public float v2X() { return data[6]; }
    public float v2Y() { return data[7]; }
    public float v2Z() { return data[8]; }

    @Override public String toString() {
        return "FloatTriangle(" + v0X() + ", " + v0Y() + ", " + v0Z() + ", " + v1X() + ", " + v1Y() + ", " + v1Z() + ", " + v2X() + ", " + v2Y() + ", " + v2Z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatTriangleImpl)) return false;
        FloatTriangleImpl o = (FloatTriangleImpl) obj;
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
            && Float.isFinite(data[5])
            && Float.isFinite(data[6])
            && Float.isFinite(data[7])
            && Float.isFinite(data[8]);
    }

    @Override public boolean equalsEpsilon(FloatTriangleR other, float epsilon) {
        return Math.abs(data[0] - other.v0X()) <= epsilon
            && Math.abs(data[1] - other.v0Y()) <= epsilon
            && Math.abs(data[2] - other.v0Z()) <= epsilon
            && Math.abs(data[3] - other.v1X()) <= epsilon
            && Math.abs(data[4] - other.v1Y()) <= epsilon
            && Math.abs(data[5] - other.v1Z()) <= epsilon
            && Math.abs(data[6] - other.v2X()) <= epsilon
            && Math.abs(data[7] - other.v2Y()) <= epsilon
            && Math.abs(data[8] - other.v2Z()) <= epsilon;
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
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        dest[offset + 6] = this.data[6];
        dest[offset + 7] = this.data[7];
        dest[offset + 8] = this.data[8];
        return dest;
    }
    public @Mutated FloatTriangle load(float[] src, int offset) {
        this.data[0] = src[offset + 0];
        this.data[1] = src[offset + 1];
        this.data[2] = src[offset + 2];
        this.data[3] = src[offset + 3];
        this.data[4] = src[offset + 4];
        this.data[5] = src[offset + 5];
        this.data[6] = src[offset + 6];
        this.data[7] = src[offset + 7];
        this.data[8] = src[offset + 8];
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

    public double[] store(@Mutated double[] dest, int offset) {
        dest[offset + 0] = this.data[0];
        dest[offset + 1] = this.data[1];
        dest[offset + 2] = this.data[2];
        dest[offset + 3] = this.data[3];
        dest[offset + 4] = this.data[4];
        dest[offset + 5] = this.data[5];
        dest[offset + 6] = this.data[6];
        dest[offset + 7] = this.data[7];
        dest[offset + 8] = this.data[8];
        return dest;
    }
    public @Mutated FloatTriangle load(double[] src, int offset) {
        this.data[0] = (float) src[offset + 0];
        this.data[1] = (float) src[offset + 1];
        this.data[2] = (float) src[offset + 2];
        this.data[3] = (float) src[offset + 3];
        this.data[4] = (float) src[offset + 4];
        this.data[5] = (float) src[offset + 5];
        this.data[6] = (float) src[offset + 6];
        this.data[7] = (float) src[offset + 7];
        this.data[8] = (float) src[offset + 8];
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

}
