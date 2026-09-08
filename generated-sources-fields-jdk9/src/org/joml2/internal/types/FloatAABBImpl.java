package org.joml2.internal.types;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.storeload.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.DoubleBuffer;

/**
 * Generated implementation of {@link FloatAABB} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class FloatAABBImpl implements FloatAABB {

    public float minX;
    public float minY;
    public float minZ;
    public float maxX;
    public float maxY;
    public float maxZ;
    static final FloatAABBBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatAABBBbOpsUnsafe()
                    : new FloatAABBBbOpsApi();
    static final FloatAABBRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new FloatAABBRawOpsUnsafe()
                    : new FloatAABBRawOpsApi();

    public FloatAABBImpl() {
        minX = Float.POSITIVE_INFINITY;
        minY = Float.POSITIVE_INFINITY;
        minZ = Float.POSITIVE_INFINITY;
        maxX = Float.NEGATIVE_INFINITY;
        maxY = Float.NEGATIVE_INFINITY;
        maxZ = Float.NEGATIVE_INFINITY;
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
        FloatAABBImpl d = (FloatAABBImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.minZ = this.minZ;
        d.maxX = maxX;
        d.maxY = maxY;
        d.maxZ = maxZ;
        return d;
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
        FloatAABBImpl d = (FloatAABBImpl) dest;
        d.minX = minX;
        d.minY = minY;
        d.minZ = minZ;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        d.maxZ = this.maxZ;
        return d;
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
     * Convert this axis-aligned bounding box to {@code double} precision and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public DoubleAABB toDouble(@Mutated DoubleAABB dest) {
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        d.minX = this.minX;
        d.minY = this.minY;
        d.minZ = this.minZ;
        d.maxX = this.maxX;
        d.maxY = this.maxY;
        d.maxZ = this.maxZ;
        return d;
    }


    /**
     * Swap the minimum and maximum bounds of this axis-aligned bounding box where necessary so the
     * bounds are valid and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatAABB correctBounds(@Mutated FloatAABB dest) {
        FloatAABBImpl d = (FloatAABBImpl) dest;
        float _buf0 = Math.min(this.minX, this.maxX);
        float _buf1 = Math.min(this.minY, this.maxY);
        float _buf2 = Math.min(this.minZ, this.maxZ);
        d.maxX = Math.max(this.minX, this.maxX);
        d.maxY = Math.max(this.minY, this.maxY);
        d.maxZ = Math.max(this.minZ, this.maxZ);
        d.minX = _buf0;
        d.minY = _buf1;
        d.minZ = _buf2;
        return d;
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
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        float _buf0 = Math.min(this.minX, this.maxX);
        float _buf1 = Math.min(this.minY, this.maxY);
        float _buf2 = Math.min(this.minZ, this.maxZ);
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
    public FloatAABB transform(Float3x4R m, @Mutated FloatAABB dest) {
        FloatAABBImpl d = (FloatAABBImpl) dest;
        float _t9 = this.minZ + this.maxZ;
        float _t10 = this.minX + this.maxX;
        float _t11 = this.minY + this.maxY;
        float _t12 = this.maxZ - this.minZ;
        float _t13 = this.maxX - this.minX;
        float _t14 = this.maxY - this.minY;
        float _t15 = m.m02() * _t9;
        float _t17 = m.m12() * _t9;
        float _t19 = m.m22() * _t9;
        float _t24 = Math.fma(m.m00(), _t10, m.m01() * _t11);
        float _t25 = Math.fma(m.m10(), _t10, m.m11() * _t11);
        float _t26 = Math.fma(m.m20(), _t10, m.m21() * _t11);
        float _t30 = Math.fma(_t12, Math.abs(m.m02()), Math.fma(_t13, Math.abs(m.m00()), _t14 * Math.abs(m.m01())));
        float _t31 = Math.fma(_t12, Math.abs(m.m12()), Math.fma(_t13, Math.abs(m.m10()), _t14 * Math.abs(m.m11())));
        float _t32 = Math.fma(_t12, Math.abs(m.m22()), Math.fma(_t13, Math.abs(m.m20()), _t14 * Math.abs(m.m21())));
        d.minX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, m.m03())));
        d.minY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, m.m13())));
        d.minZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, m.m23())));
        d.maxX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, m.m03())));
        d.maxY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, m.m13())));
        d.maxZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, m.m23())));
        return d;
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
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        float _t9 = this.minZ + this.maxZ;
        float _t10 = this.minX + this.maxX;
        float _t11 = this.minY + this.maxY;
        float _t12 = this.maxZ - this.minZ;
        float _t13 = this.maxX - this.minX;
        float _t14 = this.maxY - this.minY;
        float _t15 = m.m02() * _t9;
        float _t17 = m.m12() * _t9;
        float _t19 = m.m22() * _t9;
        float _t24 = Math.fma(m.m00(), _t10, m.m01() * _t11);
        float _t25 = Math.fma(m.m10(), _t10, m.m11() * _t11);
        float _t26 = Math.fma(m.m20(), _t10, m.m21() * _t11);
        float _t30 = Math.fma(_t12, Math.abs(m.m02()), Math.fma(_t13, Math.abs(m.m00()), _t14 * Math.abs(m.m01())));
        float _t31 = Math.fma(_t12, Math.abs(m.m12()), Math.fma(_t13, Math.abs(m.m10()), _t14 * Math.abs(m.m11())));
        float _t32 = Math.fma(_t12, Math.abs(m.m22()), Math.fma(_t13, Math.abs(m.m20()), _t14 * Math.abs(m.m21())));
        d.minX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, m.m03())));
        d.minY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, m.m13())));
        d.minZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, m.m23())));
        d.maxX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, m.m03())));
        d.maxY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, m.m13())));
        d.maxZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, m.m23())));
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
    public FloatAABB transform(Float4x4R m, @Mutated FloatAABB dest) {
        FloatAABBImpl d = (FloatAABBImpl) dest;
        float _t9 = this.minZ + this.maxZ;
        float _t10 = this.minX + this.maxX;
        float _t11 = this.minY + this.maxY;
        float _t12 = this.maxZ - this.minZ;
        float _t13 = this.maxX - this.minX;
        float _t14 = this.maxY - this.minY;
        float _t15 = m.m02() * _t9;
        float _t17 = m.m12() * _t9;
        float _t19 = m.m22() * _t9;
        float _t24 = Math.fma(m.m00(), _t10, m.m01() * _t11);
        float _t25 = Math.fma(m.m10(), _t10, m.m11() * _t11);
        float _t26 = Math.fma(m.m20(), _t10, m.m21() * _t11);
        float _t30 = Math.fma(_t12, Math.abs(m.m02()), Math.fma(_t13, Math.abs(m.m00()), _t14 * Math.abs(m.m01())));
        float _t31 = Math.fma(_t12, Math.abs(m.m12()), Math.fma(_t13, Math.abs(m.m10()), _t14 * Math.abs(m.m11())));
        float _t32 = Math.fma(_t12, Math.abs(m.m22()), Math.fma(_t13, Math.abs(m.m20()), _t14 * Math.abs(m.m21())));
        d.minX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, m.m03())));
        d.minY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, m.m13())));
        d.minZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, m.m23())));
        d.maxX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, m.m03())));
        d.maxY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, m.m13())));
        d.maxZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, m.m23())));
        return d;
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
        DoubleAABBImpl d = (DoubleAABBImpl) dest;
        float _t9 = this.minZ + this.maxZ;
        float _t10 = this.minX + this.maxX;
        float _t11 = this.minY + this.maxY;
        float _t12 = this.maxZ - this.minZ;
        float _t13 = this.maxX - this.minX;
        float _t14 = this.maxY - this.minY;
        float _t15 = m.m02() * _t9;
        float _t17 = m.m12() * _t9;
        float _t19 = m.m22() * _t9;
        float _t24 = Math.fma(m.m00(), _t10, m.m01() * _t11);
        float _t25 = Math.fma(m.m10(), _t10, m.m11() * _t11);
        float _t26 = Math.fma(m.m20(), _t10, m.m21() * _t11);
        float _t30 = Math.fma(_t12, Math.abs(m.m02()), Math.fma(_t13, Math.abs(m.m00()), _t14 * Math.abs(m.m01())));
        float _t31 = Math.fma(_t12, Math.abs(m.m12()), Math.fma(_t13, Math.abs(m.m10()), _t14 * Math.abs(m.m11())));
        float _t32 = Math.fma(_t12, Math.abs(m.m22()), Math.fma(_t13, Math.abs(m.m20()), _t14 * Math.abs(m.m21())));
        d.minX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(-0.5f, _t30, m.m03())));
        d.minY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(-0.5f, _t31, m.m13())));
        d.minZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(-0.5f, _t32, m.m23())));
        d.maxX = Math.fma(0.5f, _t15, Math.fma(0.5f, _t24, Math.fma(0.5f, _t30, m.m03())));
        d.maxY = Math.fma(0.5f, _t17, Math.fma(0.5f, _t25, Math.fma(0.5f, _t31, m.m13())));
        d.maxZ = Math.fma(0.5f, _t19, Math.fma(0.5f, _t26, Math.fma(0.5f, _t32, m.m23())));
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
        FloatAABBImpl d = (FloatAABBImpl) dest;
        d.minX = deltaX + this.minX;
        d.minY = deltaY + this.minY;
        d.minZ = deltaZ + this.minZ;
        d.maxX = deltaX + this.maxX;
        d.maxY = deltaY + this.maxY;
        d.maxZ = deltaZ + this.maxZ;
        return d;
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
        FloatAABBImpl d = (FloatAABBImpl) dest;
        d.minX = Math.min(this.minX, minX);
        d.minY = Math.min(this.minY, minY);
        d.minZ = Math.min(this.minZ, minZ);
        d.maxX = Math.max(this.maxX, maxX);
        d.maxY = Math.max(this.maxY, maxY);
        d.maxZ = Math.max(this.maxZ, maxZ);
        return d;
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
        FloatAABBImpl d = (FloatAABBImpl) dest;
        d.minX = Math.min(this.minX, pX);
        d.minY = Math.min(this.minY, pY);
        d.minZ = Math.min(this.minZ, pZ);
        d.maxX = Math.max(this.maxX, pX);
        d.maxY = Math.max(this.maxY, pY);
        d.maxZ = Math.max(this.maxZ, pZ);
        return d;
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
    public Float3 getCenter(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = 0.5f * (this.minX + this.maxX);
        d.y = 0.5f * (this.minY + this.maxY);
        d.z = 0.5f * (this.minZ + this.maxZ);
        return d;
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
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.5f * (this.minX + this.maxX);
        d.y = 0.5f * (this.minY + this.maxY);
        d.z = 0.5f * (this.minZ + this.maxZ);
        return d;
    }


    /**
     * Get the maximum corner of this axis-aligned bounding box and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Float3 getMax(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.maxX;
        d.y = this.maxY;
        d.z = this.maxZ;
        return d;
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
    public Float3 getMin(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.minX;
        d.y = this.minY;
        d.z = this.minZ;
        return d;
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
    public Float3 getSize(@Mutated Float3 dest) {
        Float3Impl d = (Float3Impl) dest;
        d.x = this.maxX - this.minX;
        d.y = this.maxY - this.minY;
        d.z = this.maxZ - this.minZ;
        return d;
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

    public float minX() { return this.minX; }
    public float minY() { return this.minY; }
    public float minZ() { return this.minZ; }
    public float maxX() { return this.maxX; }
    public float maxY() { return this.maxY; }
    public float maxZ() { return this.maxZ; }

    @Override public String toString() {
        return "FloatAABB(" + minX() + ", " + minY() + ", " + minZ() + ", " + maxX() + ", " + maxY() + ", " + maxZ() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof FloatAABBImpl)) return false;
        FloatAABBImpl o = (FloatAABBImpl) obj;
        return Float.floatToIntBits(minX) == Float.floatToIntBits(o.minX)
            && Float.floatToIntBits(minY) == Float.floatToIntBits(o.minY)
            && Float.floatToIntBits(minZ) == Float.floatToIntBits(o.minZ)
            && Float.floatToIntBits(maxX) == Float.floatToIntBits(o.maxX)
            && Float.floatToIntBits(maxY) == Float.floatToIntBits(o.maxY)
            && Float.floatToIntBits(maxZ) == Float.floatToIntBits(o.maxZ);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + Float.floatToIntBits(minX);
        h = 31 * h + Float.floatToIntBits(minY);
        h = 31 * h + Float.floatToIntBits(minZ);
        h = 31 * h + Float.floatToIntBits(maxX);
        h = 31 * h + Float.floatToIntBits(maxY);
        h = 31 * h + Float.floatToIntBits(maxZ);
        return h;
    }

    @Override public boolean isFinite() {
        return Float.isFinite(minX)
            && Float.isFinite(minY)
            && Float.isFinite(minZ)
            && Float.isFinite(maxX)
            && Float.isFinite(maxY)
            && Float.isFinite(maxZ);
    }

    @Override public boolean equalsEpsilon(FloatAABBR other, float epsilon) {
        return Math.abs(minX - other.minX()) <= epsilon
            && Math.abs(minY - other.minY()) <= epsilon
            && Math.abs(minZ - other.minZ()) <= epsilon
            && Math.abs(maxX - other.maxX()) <= epsilon
            && Math.abs(maxY - other.maxY()) <= epsilon
            && Math.abs(maxZ - other.maxZ()) <= epsilon;
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
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.minZ;
        dest[offset + 3] = this.maxX;
        dest[offset + 4] = this.maxY;
        dest[offset + 5] = this.maxZ;
        return dest;
    }
    public @Mutated FloatAABB load(float[] src, int offset) {
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
        dest[offset + 0] = this.minX;
        dest[offset + 1] = this.minY;
        dest[offset + 2] = this.minZ;
        dest[offset + 3] = this.maxX;
        dest[offset + 4] = this.maxY;
        dest[offset + 5] = this.maxZ;
        return dest;
    }
    public @Mutated FloatAABB load(double[] src, int offset) {
        this.minX = (float) src[offset + 0];
        this.minY = (float) src[offset + 1];
        this.minZ = (float) src[offset + 2];
        this.maxX = (float) src[offset + 3];
        this.maxY = (float) src[offset + 4];
        this.maxZ = (float) src[offset + 5];
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
