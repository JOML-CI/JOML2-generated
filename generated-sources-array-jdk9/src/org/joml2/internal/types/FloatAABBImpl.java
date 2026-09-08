package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatAABB} backed by a {@code float[]} array.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatAABBImpl implements FloatAABB {

    public float[] data;
    static final FloatAABBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatAABBBbOpsUnsafe()
                    : new FloatAABBBbOpsApi();
    static final FloatAABBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatAABBRawOpsUnsafe()
                    : new FloatAABBRawOpsApi();

    public FloatAABBImpl() {
        data = new float[6];
        data[0] = Float.POSITIVE_INFINITY;
        data[1] = Float.POSITIVE_INFINITY;
        data[2] = Float.POSITIVE_INFINITY;
        data[3] = Float.NEGATIVE_INFINITY;
        data[4] = Float.NEGATIVE_INFINITY;
        data[5] = Float.NEGATIVE_INFINITY;
    }


    /**
     * Set this axis-aligned bounding box to the given values.
     *
     * @param v the axis-aligned bounding box
     * @return this
     */
    public @Mutated FloatAABB set(FloatAABBR v) {
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
    @Mutated public FloatAABB set(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float[] dd = this.data;
        dd[0] = minX;
        dd[1] = minY;
        dd[2] = minZ;
        dd[3] = maxX;
        dd[4] = maxY;
        dd[5] = maxZ;
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
    public FloatAABB setMax(Float3R max, @Mutated FloatAABB dest) {
        return setMax(max.x(), max.y(), max.z(), dest);
    }


    /**
     * Set the maximum corner of this axis-aligned bounding box to {@code max} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param max the maximum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMax(Float3R max, @Mutated DoubleAABB dest) {
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
    public FloatAABB setMax(float maxX, float maxY, float maxZ, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatAABBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = maxX;
        dd[4] = maxY;
        dd[5] = maxZ;
        return dest;
    }


    /**
     * Set the maximum corner of this axis-aligned bounding box to ({@code maxX}, {@code maxY},
     * {@code maxZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param maxX the {@code x} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxY the {@code y} component of the vector {@code (maxX, maxY, maxZ)}
     * @param maxZ the {@code z} component of the vector {@code (maxX, maxY, maxZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMax(float maxX, float maxY, float maxZ, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = maxX;
        dd[4] = maxY;
        dd[5] = maxZ;
        return dest;
    }


    /**
     * Set the minimum corner of this axis-aligned bounding box to {@code min} and store the result
     * in {@code dest}.
     *
     * @param min the minimum corner
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB setMin(Float3R min, @Mutated FloatAABB dest) {
        return setMin(min.x(), min.y(), min.z(), dest);
    }


    /**
     * Set the minimum corner of this axis-aligned bounding box to {@code min} and store the result
     * in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param min the minimum corner
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMin(Float3R min, @Mutated DoubleAABB dest) {
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
    public FloatAABB setMin(float minX, float minY, float minZ, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatAABBImpl) dest).data;
        dd[0] = minX;
        dd[1] = minY;
        dd[2] = minZ;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        return dest;
    }


    /**
     * Set the minimum corner of this axis-aligned bounding box to ({@code minX}, {@code minY},
     * {@code minZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param minX the {@code x} component of the vector {@code (minX, minY, minZ)}
     * @param minY the {@code y} component of the vector {@code (minX, minY, minZ)}
     * @param minZ the {@code z} component of the vector {@code (minX, minY, minZ)}
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB setMin(float minX, float minY, float minZ, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        dd[0] = minX;
        dd[1] = minY;
        dd[2] = minZ;
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        return dest;
    }


    /**
     * Convert this axis-aligned bounding box to {@code double} precision and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB toDouble(@Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        dd[3] = sd[3];
        dd[4] = sd[4];
        dd[5] = sd[5];
        return dest;
    }


    /**
     * Swap the minimum and maximum bounds of this axis-aligned bounding box where necessary so the
     * bounds are valid and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB correctBounds(@Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatAABBImpl) dest).data;
        float _buf0 = Math.min(sd[0], sd[3]);
        float _buf1 = Math.min(sd[1], sd[4]);
        float _buf2 = Math.min(sd[2], sd[5]);
        dd[3] = Math.max(sd[0], sd[3]);
        dd[4] = Math.max(sd[1], sd[4]);
        dd[5] = Math.max(sd[2], sd[5]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Swap the minimum and maximum bounds of this axis-aligned bounding box where necessary so the
     * bounds are valid and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB correctBounds(@Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        float _buf0 = Math.min(sd[0], sd[3]);
        float _buf1 = Math.min(sd[1], sd[4]);
        float _buf2 = Math.min(sd[2], sd[5]);
        dd[3] = Math.max(sd[0], sd[3]);
        dd[4] = Math.max(sd[1], sd[4]);
        dd[5] = Math.max(sd[2], sd[5]);
        dd[0] = _buf0;
        dd[1] = _buf1;
        dd[2] = _buf2;
        return dest;
    }


    /**
     * Transform this axis-aligned bounding box by {@code m} and set it to the axis-aligned box
     * enclosing the transformed box and store the result in {@code dest}.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB transform(Float3x4R m, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        float[] dd = ((FloatAABBImpl) dest).data;
        float _t9 = sd[2] + sd[5];
        float _t10 = sd[0] + sd[3];
        float _t11 = sd[1] + sd[4];
        float _t12 = sd[5] - sd[2];
        float _t13 = sd[3] - sd[0];
        float _t14 = sd[4] - sd[1];
        float _t15 = mData[2] * _t9;
        float _t17 = mData[6] * _t9;
        float _t19 = mData[10] * _t9;
        float _t24 = Math.fma(mData[0], _t10, mData[1] * _t11);
        float _t25 = Math.fma(mData[4], _t10, mData[5] * _t11);
        float _t26 = Math.fma(mData[8], _t10, mData[9] * _t11);
        float _t30 = Math.fma(_t12, Math.abs(mData[2]), Math.fma(_t13, Math.abs(mData[0]), _t14 * Math.abs(mData[1])));
        float _t31 = Math.fma(_t12, Math.abs(mData[6]), Math.fma(_t13, Math.abs(mData[4]), _t14 * Math.abs(mData[5])));
        float _t32 = Math.fma(_t12, Math.abs(mData[10]), Math.fma(_t13, Math.abs(mData[8]), _t14 * Math.abs(mData[9])));
        dd[0] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, mData[3])));
        dd[1] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, mData[7])));
        dd[2] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, mData[11])));
        dd[3] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, mData[3])));
        dd[4] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, mData[7])));
        dd[5] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, mData[11])));
        return dest;
    }


    /**
     * Transform this axis-aligned bounding box by {@code m} and set it to the axis-aligned box
     * enclosing the transformed box and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the matrix
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB transform(Float3x4R m, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        float[] mData = ((Float3x4Impl) m).data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        float _t9 = sd[2] + sd[5];
        float _t10 = sd[0] + sd[3];
        float _t11 = sd[1] + sd[4];
        float _t12 = sd[5] - sd[2];
        float _t13 = sd[3] - sd[0];
        float _t14 = sd[4] - sd[1];
        float _t15 = mData[2] * _t9;
        float _t17 = mData[6] * _t9;
        float _t19 = mData[10] * _t9;
        float _t24 = Math.fma(mData[0], _t10, mData[1] * _t11);
        float _t25 = Math.fma(mData[4], _t10, mData[5] * _t11);
        float _t26 = Math.fma(mData[8], _t10, mData[9] * _t11);
        float _t30 = Math.fma(_t12, Math.abs(mData[2]), Math.fma(_t13, Math.abs(mData[0]), _t14 * Math.abs(mData[1])));
        float _t31 = Math.fma(_t12, Math.abs(mData[6]), Math.fma(_t13, Math.abs(mData[4]), _t14 * Math.abs(mData[5])));
        float _t32 = Math.fma(_t12, Math.abs(mData[10]), Math.fma(_t13, Math.abs(mData[8]), _t14 * Math.abs(mData[9])));
        dd[0] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, mData[3])));
        dd[1] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, mData[7])));
        dd[2] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, mData[11])));
        dd[3] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, mData[3])));
        dd[4] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, mData[7])));
        dd[5] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, mData[11])));
        return dest;
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
    public FloatAABB transform(Float4x4R m, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        float[] dd = ((FloatAABBImpl) dest).data;
        float _t9 = sd[2] + sd[5];
        float _t10 = sd[0] + sd[3];
        float _t11 = sd[1] + sd[4];
        float _t12 = sd[5] - sd[2];
        float _t13 = sd[3] - sd[0];
        float _t14 = sd[4] - sd[1];
        float _t15 = mData[8] * _t9;
        float _t17 = mData[9] * _t9;
        float _t19 = mData[10] * _t9;
        float _t24 = Math.fma(mData[0], _t10, mData[4] * _t11);
        float _t25 = Math.fma(mData[1], _t10, mData[5] * _t11);
        float _t26 = Math.fma(mData[2], _t10, mData[6] * _t11);
        float _t30 = Math.fma(_t12, Math.abs(mData[8]), Math.fma(_t13, Math.abs(mData[0]), _t14 * Math.abs(mData[4])));
        float _t31 = Math.fma(_t12, Math.abs(mData[9]), Math.fma(_t13, Math.abs(mData[1]), _t14 * Math.abs(mData[5])));
        float _t32 = Math.fma(_t12, Math.abs(mData[10]), Math.fma(_t13, Math.abs(mData[2]), _t14 * Math.abs(mData[6])));
        dd[0] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, mData[12])));
        dd[1] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, mData[13])));
        dd[2] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, mData[14])));
        dd[3] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, mData[12])));
        dd[4] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, mData[13])));
        dd[5] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, mData[14])));
        return dest;
    }


    /**
     * Transform this axis-aligned bounding box by {@code m} and set it to the axis-aligned box
     * enclosing the transformed box and store the result in {@code dest}.
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
    public DoubleAABB transform(Float4x4R m, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        float[] mData = ((Float4x4Impl) m).data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        float _t9 = sd[2] + sd[5];
        float _t10 = sd[0] + sd[3];
        float _t11 = sd[1] + sd[4];
        float _t12 = sd[5] - sd[2];
        float _t13 = sd[3] - sd[0];
        float _t14 = sd[4] - sd[1];
        float _t15 = mData[8] * _t9;
        float _t17 = mData[9] * _t9;
        float _t19 = mData[10] * _t9;
        float _t24 = Math.fma(mData[0], _t10, mData[4] * _t11);
        float _t25 = Math.fma(mData[1], _t10, mData[5] * _t11);
        float _t26 = Math.fma(mData[2], _t10, mData[6] * _t11);
        float _t30 = Math.fma(_t12, Math.abs(mData[8]), Math.fma(_t13, Math.abs(mData[0]), _t14 * Math.abs(mData[4])));
        float _t31 = Math.fma(_t12, Math.abs(mData[9]), Math.fma(_t13, Math.abs(mData[1]), _t14 * Math.abs(mData[5])));
        float _t32 = Math.fma(_t12, Math.abs(mData[10]), Math.fma(_t13, Math.abs(mData[2]), _t14 * Math.abs(mData[6])));
        dd[0] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, mData[12])));
        dd[1] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, mData[13])));
        dd[2] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, mData[14])));
        dd[3] = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, mData[12])));
        dd[4] = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, mData[13])));
        dd[5] = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, mData[14])));
        return dest;
    }


    /**
     * Translate this axis-aligned bounding box by {@code delta} and store the result in
     * {@code dest}.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB translate(Float3R delta, @Mutated FloatAABB dest) {
        return translate(delta.x(), delta.y(), delta.z(), dest);
    }


    /**
     * Translate this axis-aligned bounding box by {@code delta} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param delta the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB translate(Float3R delta, @Mutated DoubleAABB dest) {
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
    public FloatAABB translate(float deltaX, float deltaY, float deltaZ, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatAABBImpl) dest).data;
        dd[0] = deltaX + sd[0];
        dd[1] = deltaY + sd[1];
        dd[2] = deltaZ + sd[2];
        dd[3] = deltaX + sd[3];
        dd[4] = deltaY + sd[4];
        dd[5] = deltaZ + sd[5];
        return dest;
    }


    /**
     * Translate this axis-aligned bounding box by ({@code deltaX}, {@code deltaY}, {@code deltaZ})
     * and store the result in {@code dest}.
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
    public DoubleAABB translate(float deltaX, float deltaY, float deltaZ, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        dd[0] = deltaX + sd[0];
        dd[1] = deltaY + sd[1];
        dd[2] = deltaZ + sd[2];
        dd[3] = deltaX + sd[3];
        dd[4] = deltaY + sd[4];
        dd[5] = deltaZ + sd[5];
        return dest;
    }


    /**
     * Set this axis-aligned bounding box to the union of itself and {@code other} and store the
     * result in {@code dest}.
     *
     * @param other the other axis-aligned bounding box
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB union(FloatAABBR other, @Mutated FloatAABB dest) {
        return union(other.minX(), other.minY(), other.minZ(), other.maxX(), other.maxY(), other.maxZ(), dest);
    }


    /**
     * Set this axis-aligned bounding box to the union of itself and {@code other} and store the
     * result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param other the other axis-aligned bounding box
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB union(FloatAABBR other, @Mutated DoubleAABB dest) {
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
    public FloatAABB union(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatAABBImpl) dest).data;
        dd[0] = Math.min(sd[0], minX);
        dd[1] = Math.min(sd[1], minY);
        dd[2] = Math.min(sd[2], minZ);
        dd[3] = Math.max(sd[3], maxX);
        dd[4] = Math.max(sd[4], maxY);
        dd[5] = Math.max(sd[5], maxZ);
        return dest;
    }


    /**
     * Set this axis-aligned bounding box to the union of itself and ({@code minX}, {@code minY},
     * {@code minZ}, {@code maxX}, {@code maxY}, {@code maxZ}) and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
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
    public DoubleAABB union(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        dd[0] = Math.min(sd[0], minX);
        dd[1] = Math.min(sd[1], minY);
        dd[2] = Math.min(sd[2], minZ);
        dd[3] = Math.max(sd[3], maxX);
        dd[4] = Math.max(sd[4], maxY);
        dd[5] = Math.max(sd[5], maxZ);
        return dest;
    }


    /**
     * Grow this axis-aligned bounding box to include the point {@code p} and store the result in
     * {@code dest}.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB union(Float3R p, @Mutated FloatAABB dest) {
        return union(p.x(), p.y(), p.z(), dest);
    }


    /**
     * Grow this axis-aligned bounding box to include the point {@code p} and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param p the vector
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB union(Float3R p, @Mutated DoubleAABB dest) {
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
    public FloatAABB union(float pX, float pY, float pZ, @Mutated FloatAABB dest) {
        float[] sd = this.data;
        float[] dd = ((FloatAABBImpl) dest).data;
        dd[0] = Math.min(sd[0], pX);
        dd[1] = Math.min(sd[1], pY);
        dd[2] = Math.min(sd[2], pZ);
        dd[3] = Math.max(sd[3], pX);
        dd[4] = Math.max(sd[4], pY);
        dd[5] = Math.max(sd[5], pZ);
        return dest;
    }


    /**
     * Grow this axis-aligned bounding box to include the point ({@code pX}, {@code pY}, {@code pZ})
     * and store the result in {@code dest}.
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
    public DoubleAABB union(float pX, float pY, float pZ, @Mutated DoubleAABB dest) {
        float[] sd = this.data;
        double[] dd = ((DoubleAABBImpl) dest).data;
        dd[0] = Math.min(sd[0], pX);
        dd[1] = Math.min(sd[1], pY);
        dd[2] = Math.min(sd[2], pZ);
        dd[3] = Math.max(sd[3], pX);
        dd[4] = Math.max(sd[4], pY);
        dd[5] = Math.max(sd[5], pZ);
        return dest;
    }


    /**
     * Get the center of this axis-aligned bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getCenter(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = 0.5f * (sd[0] + sd[3]);
        dd[1] = 0.5f * (sd[1] + sd[4]);
        dd[2] = 0.5f * (sd[2] + sd[5]);
        return dest;
    }


    /**
     * Get the center of this axis-aligned bounding box and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCenter(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = 0.5f * (sd[0] + sd[3]);
        dd[1] = 0.5f * (sd[1] + sd[4]);
        dd[2] = 0.5f * (sd[2] + sd[5]);
        return dest;
    }


    /**
     * Get the maximum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getMax(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
    }


    /**
     * Get the maximum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getMax(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[3];
        dd[1] = sd[4];
        dd[2] = sd[5];
        return dest;
    }


    /**
     * Get the minimum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getMin(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
    }


    /**
     * Get the minimum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getMin(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[0];
        dd[1] = sd[1];
        dd[2] = sd[2];
        return dest;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this axis-aligned
     * bounding box and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getSize(@Mutated Float3 dest) {
        float[] sd = this.data;
        float[] dd = ((Float3Impl) dest).data;
        dd[0] = sd[3] - sd[0];
        dd[1] = sd[4] - sd[1];
        dd[2] = sd[5] - sd[2];
        return dest;
    }


    /**
     * Get the size, i.e. the maximum minus the minimum corner per axis of this axis-aligned
     * bounding box and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getSize(@Mutated Double3 dest) {
        float[] sd = this.data;
        double[] dd = ((Double3Impl) dest).data;
        dd[0] = sd[3] - sd[0];
        dd[1] = sd[4] - sd[1];
        dd[2] = sd[5] - sd[2];
        return dest;
    }


    /**
     * Determine whether this axis-aligned bounding box is valid, i.e. no minimum bound exceeds its
     * maximum.
     *
     * @return {@code true} if this axis-aligned bounding box is valid, i.e. no minimum bound
     *        exceeds its maximum, {@code false} otherwise
     */
    public boolean isValid() {
        float[] sd = this.data;
        if (!(sd[0] <= sd[3])) return false;
        if (!(sd[1] <= sd[4])) return false;
        return sd[2] <= sd[5];
    }

    public float minX() { return data[0]; }
    public float minY() { return data[1]; }
    public float minZ() { return data[2]; }
    public float maxX() { return data[3]; }
    public float maxY() { return data[4]; }
    public float maxZ() { return data[5]; }

    @Override public String toString() {
        return "FloatAABB(" + minX() + ", " + minY() + ", " + minZ() + ", " + maxX() + ", " + maxY() + ", " + maxZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatAABBImpl)) return false;
        FloatAABBImpl o = (FloatAABBImpl) obj;
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

    @Override public boolean equalsEpsilon(FloatAABBR other, float epsilon) {
        return Math.abs(data[0] - other.minX()) <= epsilon
            && Math.abs(data[1] - other.minY()) <= epsilon
            && Math.abs(data[2] - other.minZ()) <= epsilon
            && Math.abs(data[3] - other.maxX()) <= epsilon
            && Math.abs(data[4] - other.maxY()) <= epsilon
            && Math.abs(data[5] - other.maxZ()) <= epsilon;
    }

    public boolean containsPoint(float x, float y, float z) {
        return Intersectionf.testPointAabb(x, y, z, minX(), minY(), minZ(), maxX(), maxY(), maxZ());
    }

    public boolean containsPoint(Float3R p) {
        return Intersectionf.testPointAabb(p, this);
    }

    public boolean containsAABB(FloatAABBR o) {
        return Intersectionf.testAabbAabbContains(this, o);
    }

    public boolean intersectsAABB(FloatAABBR o) {
        return Intersectionf.testAabbAabb(this, o);
    }

    public boolean intersectsSweptAABB(FloatAABBR other, float vX, float vY, float vZ) {
        return Intersectionf.testMovingAabbAabb(other.minX(), other.minY(), other.minZ(), other.maxX(), other.maxY(), other.maxZ(), vX, vY, vZ, minX(), minY(), minZ(), maxX(), maxY(), maxZ());
    }

    public boolean intersectsSweptAABB(FloatAABBR other, Float3R velocity) {
        return intersectsSweptAABB(other, velocity.x(), velocity.y(), velocity.z());
    }

    public boolean intersectsSphere(FloatSphereR sph) {
        return Intersectionf.testAabbSphere(this, sph);
    }

    public boolean intersectsPlane(FloatPlaneR plane) {
        return Intersectionf.testAabbPlane(minX(), minY(), minZ(), maxX(), maxY(), maxZ(), plane.a(), plane.b(), plane.c(), plane.d());
    }

    public boolean intersectsRay(FloatRayR r) {
        return Intersectionf.testRayAabb(r, this);
    }

    public boolean intersectRay(FloatRayR r, @Mutated Float2 dest) {
        return Intersectionf.intersectRayAabb(r, this, dest);
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
    public @Mutated FloatAABB load(float[] src, int offset) {
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
    @Mutated public FloatAABB loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public FloatAABB loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public FloatAABB storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public FloatAABB loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
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
    public @Mutated FloatAABB load(double[] src, int offset) {
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
    @Mutated public FloatAABB loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeDoubleAbsolute(this, index, buf);
    }
    public FloatAABB loadDoubleAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadDoubleAbsolute(this, index, buf);
    }
    public FloatAABB storeDoubleUnsafe(long address) {
        return RAW_OPS.storeDoubleUnsafe(this, address);
    }
    @Mutated public FloatAABB loadDoubleUnsafe(long address) {
        return RAW_OPS.loadDoubleUnsafe(this, address);
    }

}
