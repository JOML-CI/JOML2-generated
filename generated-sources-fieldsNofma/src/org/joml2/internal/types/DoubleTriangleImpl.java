// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
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
 * Generated implementation of {@link DoubleTriangle} backed by individual scalar fields.
 * <p>
 * Not part of the public API - obtain instances through the {@link Joml} factory methods.
 */
public final class DoubleTriangleImpl implements DoubleTriangle {

    public double v0X;
    public double v0Y;
    public double v0Z;
    public double v1X;
    public double v1Y;
    public double v1Z;
    public double v2X;
    public double v2Y;
    public double v2Z;
    static final DoubleTriangleSegOps SEG_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleTriangleSegOpsUnsafe()
                    : new DoubleTriangleSegOpsMS();
    static final DoubleTriangleBbOps BB_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleTriangleBbOpsUnsafe()
                    : new DoubleTriangleBbOpsApi();
    static final DoubleTriangleRawOps RAW_OPS =
            Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE
                    ? new DoubleTriangleRawOpsUnsafe()
                    : new DoubleTriangleRawOpsApi();

    public DoubleTriangleImpl() {
    }

    public DoubleTriangleImpl(double v0X, double v0Y, double v0Z, double v1X, double v1Y, double v1Z, double v2X, double v2Y, double v2Z) {
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

    public DoubleTriangleImpl(DoubleTriangleR src) {
        this.v0X = src.v0X();
        this.v0Y = src.v0Y();
        this.v0Z = src.v0Z();
        this.v1X = src.v1X();
        this.v1Y = src.v1Y();
        this.v1Z = src.v1Z();
        this.v2X = src.v2X();
        this.v2Y = src.v2Y();
        this.v2Z = src.v2Z();
    }


    /**
     * Set this triangle to the given values.
     *
     * @param v the triangle to copy
     * @return this
     */
    public @Mutated DoubleTriangle set(DoubleTriangleR v) {
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
    @Mutated public DoubleTriangle set(double vV0X, double vV0Y, double vV0Z, double vV1X, double vV1Y, double vV1Z, double vV2X, double vV2Y, double vV2Z) {
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
     * Convert this triangle to {@code float} precision and store the result in {@code dest}.
     * <p>
     * The conversion may lose precision or range.
     *
     * @param dest will hold the result
     * @return dest
     */
    public FloatTriangle toFloat(@Mutated FloatTriangle dest) {
        FloatTriangleImpl d = (FloatTriangleImpl) dest;
        d.v0X = (float) (this.v0X);
        d.v0Y = (float) (this.v0Y);
        d.v0Z = (float) (this.v0Z);
        d.v1X = (float) (this.v1X);
        d.v1Y = (float) (this.v1Y);
        d.v1Z = (float) (this.v1Z);
        d.v2X = (float) (this.v2X);
        d.v2Y = (float) (this.v2Y);
        d.v2Z = (float) (this.v2Z);
        return d;
    }

    /** Private store group 0 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s78e00a1c_c0(DoubleTriangleImpl _dst, double _r0, double _r1, double _r2, double _r3, double _r4, double _r5, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14) {
        _dst.v0X = _r0 * _r1 + (_r2 * _r3 + (_r4 * _r5 + _r6));
        _dst.v0Y = _r7 * _r1 + (_r8 * _r3 + (_r9 * _r5 + _r10));
        _dst.v0Z = _r11 * _r1 + (_r12 * _r3 + (_r13 * _r5 + _r14));
    }

    /** Private store group 1 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s78e00a1c_c1(DoubleTriangleImpl _dst, double _r0, double _r15, double _r2, double _r16, double _r4, double _r17, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14) {
        _dst.v1X = _r0 * _r15 + (_r2 * _r16 + (_r4 * _r17 + _r6));
        _dst.v1Y = _r7 * _r15 + (_r8 * _r16 + (_r9 * _r17 + _r10));
        _dst.v1Z = _r11 * _r15 + (_r12 * _r16 + (_r13 * _r17 + _r14));
    }

    /** Private store group 2 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s78e00a1c_c2(DoubleTriangleImpl _dst, double _r0, double _r18, double _r2, double _r19, double _r4, double _r20, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14) {
        _dst.v2X = _r0 * _r18 + (_r2 * _r19 + (_r4 * _r20 + _r6));
        _dst.v2Y = _r7 * _r18 + (_r8 * _r19 + (_r9 * _r20 + _r10));
        _dst.v2Z = _r11 * _r18 + (_r12 * _r19 + (_r13 * _r20 + _r14));
    }

    /** Private tail of {@code transform}; reached only through it. */
    private void transform_s78e00a1c_tail(DoubleTriangleImpl _dst, double _r0, double _r1, double _r2, double _r3, double _r4, double _r5, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14, double _r15, double _r16, double _r17, double _r18, double _r19) {
        double _r20 = this.v2Y;
        transform_s78e00a1c_c0(_dst, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s78e00a1c_c1(_dst, _r0, _r15, _r2, _r16, _r4, _r17, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s78e00a1c_c2(_dst, _r0, _r18, _r2, _r19, _r4, _r20, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     *
     * @param m the transformation matrix to apply
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle transform(Double3x4R m, @Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        double _r0 = m.m02();
        double _r1 = this.v0Z;
        double _r2 = m.m00();
        double _r3 = this.v0X;
        double _r4 = m.m01();
        double _r5 = this.v0Y;
        double _r6 = m.m03();
        double _r7 = m.m12();
        double _r8 = m.m10();
        double _r9 = m.m11();
        double _r10 = m.m13();
        double _r11 = m.m22();
        double _r12 = m.m20();
        double _r13 = m.m21();
        double _r14 = m.m23();
        double _r15 = this.v1Z;
        double _r16 = this.v1X;
        double _r17 = this.v1Y;
        double _r18 = this.v2Z;
        double _r19 = this.v2X;
        transform_s78e00a1c_tail(d, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14, _r15, _r16, _r17, _r18, _r19);
        return d;
    }

    /** Private store group 0 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s6d1f427b_c0(DoubleTriangleImpl _dst, double _r0, double _r1, double _r2, double _r3, double _r4, double _r5, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14) {
        _dst.v0X = _r0 * _r1 + (_r2 * _r3 + (_r4 * _r5 + _r6));
        _dst.v0Y = _r7 * _r1 + (_r8 * _r3 + (_r9 * _r5 + _r10));
        _dst.v0Z = _r11 * _r1 + (_r12 * _r3 + (_r13 * _r5 + _r14));
    }

    /** Private store group 1 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s6d1f427b_c1(DoubleTriangleImpl _dst, double _r0, double _r15, double _r2, double _r16, double _r4, double _r17, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14) {
        _dst.v1X = _r0 * _r15 + (_r2 * _r16 + (_r4 * _r17 + _r6));
        _dst.v1Y = _r7 * _r15 + (_r8 * _r16 + (_r9 * _r17 + _r10));
        _dst.v1Z = _r11 * _r15 + (_r12 * _r16 + (_r13 * _r17 + _r14));
    }

    /** Private store group 2 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s6d1f427b_c2(DoubleTriangleImpl _dst, double _r0, double _r18, double _r2, double _r19, double _r4, double _r20, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14) {
        _dst.v2X = _r0 * _r18 + (_r2 * _r19 + (_r4 * _r20 + _r6));
        _dst.v2Y = _r7 * _r18 + (_r8 * _r19 + (_r9 * _r20 + _r10));
        _dst.v2Z = _r11 * _r18 + (_r12 * _r19 + (_r13 * _r20 + _r14));
    }

    /** Private tail of {@code transform}; reached only through it. */
    private void transform_s6d1f427b_tail(DoubleTriangleImpl _dst, double _r0, double _r1, double _r2, double _r3, double _r4, double _r5, double _r6, double _r7, double _r8, double _r9, double _r10, double _r11, double _r12, double _r13, double _r14, double _r15, double _r16, double _r17, double _r18, double _r19) {
        double _r20 = this.v2Y;
        transform_s6d1f427b_c0(_dst, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s6d1f427b_c1(_dst, _r0, _r15, _r2, _r16, _r4, _r17, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s6d1f427b_c2(_dst, _r0, _r18, _r2, _r19, _r4, _r20, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     * <p>
     * Only the affine part of {@code m} is used: the last row is assumed to be
     * {@code (0, 0, 0, 1)}, so any projective component is ignored.
     *
     * @param m the transformation matrix to apply
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle transform(Double4x4R m, @Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        double _r0 = m.m02();
        double _r1 = this.v0Z;
        double _r2 = m.m00();
        double _r3 = this.v0X;
        double _r4 = m.m01();
        double _r5 = this.v0Y;
        double _r6 = m.m03();
        double _r7 = m.m12();
        double _r8 = m.m10();
        double _r9 = m.m11();
        double _r10 = m.m13();
        double _r11 = m.m22();
        double _r12 = m.m20();
        double _r13 = m.m21();
        double _r14 = m.m23();
        double _r15 = this.v1Z;
        double _r16 = this.v1X;
        double _r17 = this.v1Y;
        double _r18 = this.v2Z;
        double _r19 = this.v2X;
        transform_s6d1f427b_tail(d, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14, _r15, _r16, _r17, _r18, _r19);
        return d;
    }


    /**
     * Compute the area of this triangle.
     *
     * @return the area of this triangle
     */
    public double area() {
        double _t0 = this.v1Y - this.v0Y;
        double _t1 = this.v2Z - this.v0Z;
        double _t2 = this.v1Z - this.v0Z;
        double _t3 = this.v2Y - this.v0Y;
        double _t4 = this.v2X - this.v0X;
        double _t5 = this.v1X - this.v0X;
        double _t12 = _t0 * _t1 - _t2 * _t3;
        double _t13 = _t2 * _t4 - _t5 * _t1;
        double _t14 = _t5 * _t3 - _t0 * _t4;
        return 0.5 * Math.sqrt(_t12 * _t12 + _t13 * _t13 + _t14 * _t14);
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
     * @param p the point whose barycentric coordinates to compute
     * @param dest will hold the result
     * @return dest
     */
    public Double3 barycentric(Double3R p, @Mutated Double3 dest) {
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
    public Double3 barycentric(double pX, double pY, double pZ, @Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = pY - this.v0Y;
        double _t1 = this.v2Z - this.v0Z;
        double _t2 = pZ - this.v0Z;
        double _t3 = this.v2Y - this.v0Y;
        double _t4 = this.v1Y - this.v0Y;
        double _t5 = this.v1Z - this.v0Z;
        double _t6 = this.v2X - this.v0X;
        double _t7 = pX - this.v0X;
        double _t8 = this.v1X - this.v0X;
        double _t28 = _t4 * _t1 - _t5 * _t3;
        double _t30 = _t5 * _t6 - _t8 * _t1;
        double _t32 = _t8 * _t3 - _t4 * _t6;
        double _t49 = _t28 * _t28 + _t30 * _t30 + _t32 * _t32;
        double _t49_inv = 1.0 / _t49;
        double _t51 = ((_t0 * _t1 - _t2 * _t3) * _t28 + (_t2 * _t6 - _t7 * _t1) * _t30 + (_t7 * _t3 - _t0 * _t6) * _t32) * _t49_inv;
        double _t52 = ((_t7 * _t5 - _t2 * _t8) * _t30 + (_t2 * _t4 - _t0 * _t5) * _t28 + (_t0 * _t8 - _t7 * _t4) * _t32) * _t49_inv;
        d.x = 1.0 - _t51 - _t52;
        d.y = _t51;
        d.z = _t52;
        return d;
    }


    /**
     * Get the centroid (the average of the vertices) of this triangle and store the result in
     * {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getCentroid(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = 0.3333333333333333 * (this.v2X + (this.v0X + this.v1X));
        d.y = 0.3333333333333333 * (this.v2Y + (this.v0Y + this.v1Y));
        d.z = 0.3333333333333333 * (this.v2Z + (this.v0Z + this.v1Z));
        return d;
    }


    /**
     * Get the normal of this triangle, i.e. the cross product {@code (v1 - v0) x (v2 - v0)} (not
     * unit length: its length is twice the triangle's area) and store the result in {@code dest}.
     *
     * @param dest will hold the result
     * @return dest
     */
    public Double3 getNormal(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        double _t0 = this.v1Y - this.v0Y;
        double _t1 = this.v2Z - this.v0Z;
        double _t2 = this.v1Z - this.v0Z;
        double _t3 = this.v2Y - this.v0Y;
        double _t4 = this.v2X - this.v0X;
        double _t5 = this.v1X - this.v0X;
        d.x = _t0 * _t1 - _t2 * _t3;
        d.y = _t2 * _t4 - _t5 * _t1;
        d.z = _t5 * _t3 - _t0 * _t4;
        return d;
    }


    /**
     * Get the first vertex of this triangle and store the result in {@code dest}.
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
    public Double3 getV2(@Mutated Double3 dest) {
        Double3Impl d = (Double3Impl) dest;
        d.x = this.v2X;
        d.y = this.v2Y;
        d.z = this.v2Z;
        return d;
    }

    public double v0X() { return this.v0X; }
    public double v0Y() { return this.v0Y; }
    public double v0Z() { return this.v0Z; }
    public double v1X() { return this.v1X; }
    public double v1Y() { return this.v1Y; }
    public double v1Z() { return this.v1Z; }
    public double v2X() { return this.v2X; }
    public double v2Y() { return this.v2Y; }
    public double v2Z() { return this.v2Z; }

    @Override public String toString() {
        return "DoubleTriangle(" + v0X() + ", " + v0Y() + ", " + v0Z() + ", " + v1X() + ", " + v1Y() + ", " + v1Z() + ", " + v2X() + ", " + v2Y() + ", " + v2Z() + ")";
    }

    @Override public boolean equals(@org.jspecify.annotations.Nullable Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DoubleTriangleImpl)) return false;
        DoubleTriangleImpl o = (DoubleTriangleImpl) obj;
        return Double.doubleToLongBits(v0X) == Double.doubleToLongBits(o.v0X)
            && Double.doubleToLongBits(v0Y) == Double.doubleToLongBits(o.v0Y)
            && Double.doubleToLongBits(v0Z) == Double.doubleToLongBits(o.v0Z)
            && Double.doubleToLongBits(v1X) == Double.doubleToLongBits(o.v1X)
            && Double.doubleToLongBits(v1Y) == Double.doubleToLongBits(o.v1Y)
            && Double.doubleToLongBits(v1Z) == Double.doubleToLongBits(o.v1Z)
            && Double.doubleToLongBits(v2X) == Double.doubleToLongBits(o.v2X)
            && Double.doubleToLongBits(v2Y) == Double.doubleToLongBits(o.v2Y)
            && Double.doubleToLongBits(v2Z) == Double.doubleToLongBits(o.v2Z);
    }

    @Override public int hashCode() {
        int h = 1;
        h = 31 * h + (int)(Double.doubleToLongBits(v0X) ^ (Double.doubleToLongBits(v0X) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v0Y) ^ (Double.doubleToLongBits(v0Y) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v0Z) ^ (Double.doubleToLongBits(v0Z) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v1X) ^ (Double.doubleToLongBits(v1X) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v1Y) ^ (Double.doubleToLongBits(v1Y) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v1Z) ^ (Double.doubleToLongBits(v1Z) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v2X) ^ (Double.doubleToLongBits(v2X) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v2Y) ^ (Double.doubleToLongBits(v2Y) >>> 32));
        h = 31 * h + (int)(Double.doubleToLongBits(v2Z) ^ (Double.doubleToLongBits(v2Z) >>> 32));
        return h;
    }

    @Override public boolean isFinite() {
        return Double.isFinite(v0X)
            && Double.isFinite(v0Y)
            && Double.isFinite(v0Z)
            && Double.isFinite(v1X)
            && Double.isFinite(v1Y)
            && Double.isFinite(v1Z)
            && Double.isFinite(v2X)
            && Double.isFinite(v2Y)
            && Double.isFinite(v2Z);
    }

    @Override public boolean equalsEpsilon(DoubleTriangleR other, double epsilon) {
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

    public boolean containsPoint(double pX, double pY, double pZ) {
        return Intersectiond.testPointInTriangle(pX, pY, pZ, v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z());
    }

    public boolean containsPoint(Double3R p) {
        return containsPoint(p.x(), p.y(), p.z());
    }

    public boolean intersectsRay(DoubleRayR ray, double epsilon) {
        return Intersectiond.testRayTriangle(ray.oX(), ray.oY(), ray.oZ(), ray.dX(), ray.dY(), ray.dZ(), v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), epsilon);
    }

    public boolean intersectsRayFront(DoubleRayR ray, double epsilon) {
        return Intersectiond.testRayTriangleFront(ray.oX(), ray.oY(), ray.oZ(), ray.dX(), ray.dY(), ray.dZ(), v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), epsilon);
    }

    public Double3 closestPointToPoint(double pX, double pY, double pZ, @Mutated Double3 dest) {
        Intersectiond.findClosestPointOnTriangle(v0X(), v0Y(), v0Z(), v1X(), v1Y(), v1Z(), v2X(), v2Y(), v2Z(), pX, pY, pZ, dest);
        return dest;
    }

    public Double3 closestPointToPoint(Double3R p, @Mutated Double3 dest) {
        return closestPointToPoint(p.x(), p.y(), p.z(), dest);
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
    public @Mutated DoubleTriangle load(double[] src, int offset) {
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
    public DoubleBuffer storeAbsolute(int index, @Mutated DoubleBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    @Mutated public DoubleTriangle loadAbsolute(int index, DoubleBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeAbsolute(this, index, buf);
    }
    public DoubleTriangle loadAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public DoubleTriangle storeUnsafe(long address) {
        return RAW_OPS.storeUnsafe(this, address);
    }
    @Mutated public DoubleTriangle loadUnsafe(long address) {
        return RAW_OPS.loadUnsafe(this, address);
    }
    public MemorySegment store(long offset, MemorySegment dest) {
        return SEG_OPS.store(this, offset, dest);
    }
    public DoubleTriangle load(long offset, MemorySegment src) {
        return SEG_OPS.load(this, offset, src);
    }

    public float[] store(@Mutated float[] dest, int offset) {
        dest[offset + 0] = (float) this.v0X;
        dest[offset + 1] = (float) this.v0Y;
        dest[offset + 2] = (float) this.v0Z;
        dest[offset + 3] = (float) this.v1X;
        dest[offset + 4] = (float) this.v1Y;
        dest[offset + 5] = (float) this.v1Z;
        dest[offset + 6] = (float) this.v2X;
        dest[offset + 7] = (float) this.v2Y;
        dest[offset + 8] = (float) this.v2Z;
        return dest;
    }
    public @Mutated DoubleTriangle load(float[] src, int offset) {
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
    @Mutated public DoubleTriangle loadAbsolute(int index, FloatBuffer buf) {
        return BB_OPS.loadAbsolute(this, index, buf);
    }
    public ByteBuffer storeFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.storeFloatAbsolute(this, index, buf);
    }
    public DoubleTriangle loadFloatAbsolute(int index, ByteBuffer buf) {
        return BB_OPS.loadFloatAbsolute(this, index, buf);
    }
    public DoubleTriangle storeFloatUnsafe(long address) {
        return RAW_OPS.storeFloatUnsafe(this, address);
    }
    @Mutated public DoubleTriangle loadFloatUnsafe(long address) {
        return RAW_OPS.loadFloatUnsafe(this, address);
    }
    public MemorySegment storeFloat(long offset, MemorySegment dest) {
        return SEG_OPS.storeFloat(this, offset, dest);
    }
    public DoubleTriangle loadFloat(long offset, MemorySegment src) {
        return SEG_OPS.loadFloat(this, offset, src);
    }

}
