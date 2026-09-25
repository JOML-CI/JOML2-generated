// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
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

    public FloatTriangleImpl(float v0X, float v0Y, float v0Z, float v1X, float v1Y, float v1Z, float v2X, float v2Y, float v2Z) {
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

    public FloatTriangleImpl(FloatTriangleR src) {
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

    /** Private store group 0 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s62bbd380_c0(FloatTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v0X = Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6)));
        _dst.v0Y = Math.fma(_r7, _r1, Math.fma(_r8, _r3, Math.fma(_r9, _r5, _r10)));
        _dst.v0Z = Math.fma(_r11, _r1, Math.fma(_r12, _r3, Math.fma(_r13, _r5, _r14)));
    }

    /** Private store group 1 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s62bbd380_c1(FloatTriangleImpl _dst, float _r0, float _r15, float _r2, float _r16, float _r4, float _r17, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v1X = Math.fma(_r0, _r15, Math.fma(_r2, _r16, Math.fma(_r4, _r17, _r6)));
        _dst.v1Y = Math.fma(_r7, _r15, Math.fma(_r8, _r16, Math.fma(_r9, _r17, _r10)));
        _dst.v1Z = Math.fma(_r11, _r15, Math.fma(_r12, _r16, Math.fma(_r13, _r17, _r14)));
    }

    /** Private store group 2 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s62bbd380_c2(FloatTriangleImpl _dst, float _r0, float _r18, float _r2, float _r19, float _r4, float _r20, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v2X = Math.fma(_r0, _r18, Math.fma(_r2, _r19, Math.fma(_r4, _r20, _r6)));
        _dst.v2Y = Math.fma(_r7, _r18, Math.fma(_r8, _r19, Math.fma(_r9, _r20, _r10)));
        _dst.v2Z = Math.fma(_r11, _r18, Math.fma(_r12, _r19, Math.fma(_r13, _r20, _r14)));
    }

    /** Private tail of {@code transform}; reached only through it. */
    private void transform_s62bbd380_tail(FloatTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14, float _r15, float _r16, float _r17, float _r18, float _r19) {
        float _r20 = this.v2Y;
        transform_s62bbd380_c0(_dst, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s62bbd380_c1(_dst, _r0, _r15, _r2, _r16, _r4, _r17, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s62bbd380_c2(_dst, _r0, _r18, _r2, _r19, _r4, _r20, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     *
     * @param m the transformation matrix to apply
     * @param dest will hold the result
     * @return dest
     */
    public FloatTriangle transform(Float3x4R m, @Mutated FloatTriangle dest) {
        FloatTriangleImpl d = (FloatTriangleImpl) dest;
        float _r0 = m.m02();
        float _r1 = this.v0Z;
        float _r2 = m.m00();
        float _r3 = this.v0X;
        float _r4 = m.m01();
        float _r5 = this.v0Y;
        float _r6 = m.m03();
        float _r7 = m.m12();
        float _r8 = m.m10();
        float _r9 = m.m11();
        float _r10 = m.m13();
        float _r11 = m.m22();
        float _r12 = m.m20();
        float _r13 = m.m21();
        float _r14 = m.m23();
        float _r15 = this.v1Z;
        float _r16 = this.v1X;
        float _r17 = this.v1Y;
        float _r18 = this.v2Z;
        float _r19 = this.v2X;
        transform_s62bbd380_tail(d, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14, _r15, _r16, _r17, _r18, _r19);
        return d;
    }

    /** Private store group 0 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s199ecae7_c0(DoubleTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v0X = Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6)));
        _dst.v0Y = Math.fma(_r7, _r1, Math.fma(_r8, _r3, Math.fma(_r9, _r5, _r10)));
        _dst.v0Z = Math.fma(_r11, _r1, Math.fma(_r12, _r3, Math.fma(_r13, _r5, _r14)));
    }

    /** Private store group 1 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s199ecae7_c1(DoubleTriangleImpl _dst, float _r0, float _r15, float _r2, float _r16, float _r4, float _r17, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v1X = Math.fma(_r0, _r15, Math.fma(_r2, _r16, Math.fma(_r4, _r17, _r6)));
        _dst.v1Y = Math.fma(_r7, _r15, Math.fma(_r8, _r16, Math.fma(_r9, _r17, _r10)));
        _dst.v1Z = Math.fma(_r11, _r15, Math.fma(_r12, _r16, Math.fma(_r13, _r17, _r14)));
    }

    /** Private store group 2 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s199ecae7_c2(DoubleTriangleImpl _dst, float _r0, float _r18, float _r2, float _r19, float _r4, float _r20, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v2X = Math.fma(_r0, _r18, Math.fma(_r2, _r19, Math.fma(_r4, _r20, _r6)));
        _dst.v2Y = Math.fma(_r7, _r18, Math.fma(_r8, _r19, Math.fma(_r9, _r20, _r10)));
        _dst.v2Z = Math.fma(_r11, _r18, Math.fma(_r12, _r19, Math.fma(_r13, _r20, _r14)));
    }

    /** Private tail of {@code transform}; reached only through it. */
    private void transform_s199ecae7_tail(DoubleTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14, float _r15, float _r16, float _r17, float _r18, float _r19) {
        float _r20 = this.v2Y;
        transform_s199ecae7_c0(_dst, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s199ecae7_c1(_dst, _r0, _r15, _r2, _r16, _r4, _r17, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s199ecae7_c2(_dst, _r0, _r18, _r2, _r19, _r4, _r20, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
    }


    /**
     * Transform this triangle by {@code m} and store the result in {@code dest}.
     * <p>
     * The computation is performed at {@code float} precision; each result component is widened to
     * {@code double} only when stored.
     *
     * @param m the transformation matrix to apply
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle transform(Float3x4R m, @Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        float _r0 = m.m02();
        float _r1 = this.v0Z;
        float _r2 = m.m00();
        float _r3 = this.v0X;
        float _r4 = m.m01();
        float _r5 = this.v0Y;
        float _r6 = m.m03();
        float _r7 = m.m12();
        float _r8 = m.m10();
        float _r9 = m.m11();
        float _r10 = m.m13();
        float _r11 = m.m22();
        float _r12 = m.m20();
        float _r13 = m.m21();
        float _r14 = m.m23();
        float _r15 = this.v1Z;
        float _r16 = this.v1X;
        float _r17 = this.v1Y;
        float _r18 = this.v2Z;
        float _r19 = this.v2X;
        transform_s199ecae7_tail(d, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14, _r15, _r16, _r17, _r18, _r19);
        return d;
    }

    /** Private store group 0 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s49949341_c0(FloatTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v0X = Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6)));
        _dst.v0Y = Math.fma(_r7, _r1, Math.fma(_r8, _r3, Math.fma(_r9, _r5, _r10)));
        _dst.v0Z = Math.fma(_r11, _r1, Math.fma(_r12, _r3, Math.fma(_r13, _r5, _r14)));
    }

    /** Private store group 1 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s49949341_c1(FloatTriangleImpl _dst, float _r0, float _r15, float _r2, float _r16, float _r4, float _r17, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v1X = Math.fma(_r0, _r15, Math.fma(_r2, _r16, Math.fma(_r4, _r17, _r6)));
        _dst.v1Y = Math.fma(_r7, _r15, Math.fma(_r8, _r16, Math.fma(_r9, _r17, _r10)));
        _dst.v1Z = Math.fma(_r11, _r15, Math.fma(_r12, _r16, Math.fma(_r13, _r17, _r14)));
    }

    /** Private store group 2 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_s49949341_c2(FloatTriangleImpl _dst, float _r0, float _r18, float _r2, float _r19, float _r4, float _r20, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v2X = Math.fma(_r0, _r18, Math.fma(_r2, _r19, Math.fma(_r4, _r20, _r6)));
        _dst.v2Y = Math.fma(_r7, _r18, Math.fma(_r8, _r19, Math.fma(_r9, _r20, _r10)));
        _dst.v2Z = Math.fma(_r11, _r18, Math.fma(_r12, _r19, Math.fma(_r13, _r20, _r14)));
    }

    /** Private tail of {@code transform}; reached only through it. */
    private void transform_s49949341_tail(FloatTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14, float _r15, float _r16, float _r17, float _r18, float _r19) {
        float _r20 = this.v2Y;
        transform_s49949341_c0(_dst, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s49949341_c1(_dst, _r0, _r15, _r2, _r16, _r4, _r17, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_s49949341_c2(_dst, _r0, _r18, _r2, _r19, _r4, _r20, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
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
    public FloatTriangle transform(Float4x4R m, @Mutated FloatTriangle dest) {
        FloatTriangleImpl d = (FloatTriangleImpl) dest;
        float _r0 = m.m02();
        float _r1 = this.v0Z;
        float _r2 = m.m00();
        float _r3 = this.v0X;
        float _r4 = m.m01();
        float _r5 = this.v0Y;
        float _r6 = m.m03();
        float _r7 = m.m12();
        float _r8 = m.m10();
        float _r9 = m.m11();
        float _r10 = m.m13();
        float _r11 = m.m22();
        float _r12 = m.m20();
        float _r13 = m.m21();
        float _r14 = m.m23();
        float _r15 = this.v1Z;
        float _r16 = this.v1X;
        float _r17 = this.v1Y;
        float _r18 = this.v2Z;
        float _r19 = this.v2X;
        transform_s49949341_tail(d, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14, _r15, _r16, _r17, _r18, _r19);
        return d;
    }

    /** Private store group 0 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_sdde0346_c0(DoubleTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v0X = Math.fma(_r0, _r1, Math.fma(_r2, _r3, Math.fma(_r4, _r5, _r6)));
        _dst.v0Y = Math.fma(_r7, _r1, Math.fma(_r8, _r3, Math.fma(_r9, _r5, _r10)));
        _dst.v0Z = Math.fma(_r11, _r1, Math.fma(_r12, _r3, Math.fma(_r13, _r5, _r14)));
    }

    /** Private store group 1 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_sdde0346_c1(DoubleTriangleImpl _dst, float _r0, float _r15, float _r2, float _r16, float _r4, float _r17, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v1X = Math.fma(_r0, _r15, Math.fma(_r2, _r16, Math.fma(_r4, _r17, _r6)));
        _dst.v1Y = Math.fma(_r7, _r15, Math.fma(_r8, _r16, Math.fma(_r9, _r17, _r10)));
        _dst.v1Z = Math.fma(_r11, _r15, Math.fma(_r12, _r16, Math.fma(_r13, _r17, _r14)));
    }

    /** Private store group 2 of {@code transform}: computes and stores it; reached only through it. */
    private void transform_sdde0346_c2(DoubleTriangleImpl _dst, float _r0, float _r18, float _r2, float _r19, float _r4, float _r20, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14) {
        _dst.v2X = Math.fma(_r0, _r18, Math.fma(_r2, _r19, Math.fma(_r4, _r20, _r6)));
        _dst.v2Y = Math.fma(_r7, _r18, Math.fma(_r8, _r19, Math.fma(_r9, _r20, _r10)));
        _dst.v2Z = Math.fma(_r11, _r18, Math.fma(_r12, _r19, Math.fma(_r13, _r20, _r14)));
    }

    /** Private tail of {@code transform}; reached only through it. */
    private void transform_sdde0346_tail(DoubleTriangleImpl _dst, float _r0, float _r1, float _r2, float _r3, float _r4, float _r5, float _r6, float _r7, float _r8, float _r9, float _r10, float _r11, float _r12, float _r13, float _r14, float _r15, float _r16, float _r17, float _r18, float _r19) {
        float _r20 = this.v2Y;
        transform_sdde0346_c0(_dst, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_sdde0346_c1(_dst, _r0, _r15, _r2, _r16, _r4, _r17, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
        transform_sdde0346_c2(_dst, _r0, _r18, _r2, _r19, _r4, _r20, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14);
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
     * @param m the transformation matrix to apply
     * @param dest will hold the result
     * @return dest
     */
    public DoubleTriangle transform(Float4x4R m, @Mutated DoubleTriangle dest) {
        DoubleTriangleImpl d = (DoubleTriangleImpl) dest;
        float _r0 = m.m02();
        float _r1 = this.v0Z;
        float _r2 = m.m00();
        float _r3 = this.v0X;
        float _r4 = m.m01();
        float _r5 = this.v0Y;
        float _r6 = m.m03();
        float _r7 = m.m12();
        float _r8 = m.m10();
        float _r9 = m.m11();
        float _r10 = m.m13();
        float _r11 = m.m22();
        float _r12 = m.m20();
        float _r13 = m.m21();
        float _r14 = m.m23();
        float _r15 = this.v1Z;
        float _r16 = this.v1X;
        float _r17 = this.v1Y;
        float _r18 = this.v2Z;
        float _r19 = this.v2X;
        transform_sdde0346_tail(d, _r0, _r1, _r2, _r3, _r4, _r5, _r6, _r7, _r8, _r9, _r10, _r11, _r12, _r13, _r14, _r15, _r16, _r17, _r18, _r19);
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
     * orthogonal projection onto the triangle's plane. The weights are formed with the
     * cross-product form (areas of the sub-triangles against the triangle's normal), which stays
     * accurate for thin triangles.
     *
     * @param p the point whose barycentric coordinates to compute
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
     * @param p the point whose barycentric coordinates to compute
     * @param dest will hold the result
     * @return dest
     */
    public Double3 barycentric(Float3R p, @Mutated Double3 dest) {
        return barycentric(p.x(), p.y(), p.z(), dest);
    }

    /** Private store group 0 of {@code barycentric}: computes and stores it; reached only through it. */
    private void barycentric_s36805c6c_c0(Float3Impl _dst, float _t45, float _t46) {
        _dst.x = 1.0f - _t45 - _t46;
        _dst.y = _t45;
        _dst.z = _t46;
    }

    /** Private tail of {@code barycentric}; reached only through it. */
    private void barycentric_s36805c6c_tail(Float3Impl _dst, float _t0, float _t1, float _t2, float _t3, float _t28, float _t6, float _t7, float _t30, float _t32, float _t43_inv, float _t4, float _t5, float _t8) {
        float _t45 = Math.fma(Math.fma(_t0, _t1, -(_t2 * _t3)), _t28, Math.fma(Math.fma(_t2, _t6, -(_t7 * _t1)), _t30, Math.fma(_t7, _t3, -(_t0 * _t6)) * _t32)) * _t43_inv;
        float _t46 = Math.fma(Math.fma(_t2, _t4, -(_t0 * _t5)), _t28, Math.fma(Math.fma(_t0, _t8, -(_t7 * _t4)), _t32, Math.fma(_t7, _t5, -(_t2 * _t8)) * _t30)) * _t43_inv;
        barycentric_s36805c6c_c0(_dst, _t45, _t46);
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
        Float3Impl d = (Float3Impl) dest;
        float _r0 = this.v0X;
        float _r1 = this.v2Y;
        float _r2 = this.v0Y;
        float _r3 = this.v2X;
        float _r4 = this.v1X;
        float _r5 = this.v1Y;
        float _r6 = this.v2Z;
        float _r7 = this.v0Z;
        float _r8 = this.v1Z;
        float _t0 = pX - _r0;
        float _t1 = _r1 - _r2;
        float _t2 = pY - _r2;
        float _t3 = _r3 - _r0;
        float _t4 = _r4 - _r0;
        float _t5 = _r5 - _r2;
        float _t6 = _r6 - _r7;
        float _t7 = pZ - _r7;
        float _t8 = _r8 - _r7;
        float _t28 = Math.fma(_t4, _t1, -(_t5 * _t3));
        float _t30 = Math.fma(_t5, _t6, -(_t8 * _t1));
        float _t32 = Math.fma(_t8, _t3, -(_t4 * _t6));
        float _t43 = Math.fma(_t28, _t28, Math.fma(_t30, _t30, _t32 * _t32));
        float _t43_inv = 1.0f / _t43;
        barycentric_s36805c6c_tail(d, _t0, _t1, _t2, _t3, _t28, _t6, _t7, _t30, _t32, _t43_inv, _t4, _t5, _t8);
        return d;
    }

    /** Private store group 0 of {@code barycentric}: computes and stores it; reached only through it. */
    private void barycentric_s496e6cff_c0(Double3Impl _dst, float _t45, float _t46) {
        _dst.x = 1.0f - _t45 - _t46;
        _dst.y = _t45;
        _dst.z = _t46;
    }

    /** Private tail of {@code barycentric}; reached only through it. */
    private void barycentric_s496e6cff_tail(Double3Impl _dst, float _t0, float _t1, float _t2, float _t3, float _t28, float _t6, float _t7, float _t30, float _t32, float _t43_inv, float _t4, float _t5, float _t8) {
        float _t45 = Math.fma(Math.fma(_t0, _t1, -(_t2 * _t3)), _t28, Math.fma(Math.fma(_t2, _t6, -(_t7 * _t1)), _t30, Math.fma(_t7, _t3, -(_t0 * _t6)) * _t32)) * _t43_inv;
        float _t46 = Math.fma(Math.fma(_t2, _t4, -(_t0 * _t5)), _t28, Math.fma(Math.fma(_t0, _t8, -(_t7 * _t4)), _t32, Math.fma(_t7, _t5, -(_t2 * _t8)) * _t30)) * _t43_inv;
        barycentric_s496e6cff_c0(_dst, _t45, _t46);
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
        Double3Impl d = (Double3Impl) dest;
        float _r0 = this.v0X;
        float _r1 = this.v2Y;
        float _r2 = this.v0Y;
        float _r3 = this.v2X;
        float _r4 = this.v1X;
        float _r5 = this.v1Y;
        float _r6 = this.v2Z;
        float _r7 = this.v0Z;
        float _r8 = this.v1Z;
        float _t0 = pX - _r0;
        float _t1 = _r1 - _r2;
        float _t2 = pY - _r2;
        float _t3 = _r3 - _r0;
        float _t4 = _r4 - _r0;
        float _t5 = _r5 - _r2;
        float _t6 = _r6 - _r7;
        float _t7 = pZ - _r7;
        float _t8 = _r8 - _r7;
        float _t28 = Math.fma(_t4, _t1, -(_t5 * _t3));
        float _t30 = Math.fma(_t5, _t6, -(_t8 * _t1));
        float _t32 = Math.fma(_t8, _t3, -(_t4 * _t6));
        float _t43 = Math.fma(_t28, _t28, Math.fma(_t30, _t30, _t32 * _t32));
        float _t43_inv = 1.0f / _t43;
        barycentric_s496e6cff_tail(d, _t0, _t1, _t2, _t3, _t28, _t6, _t7, _t30, _t32, _t43_inv, _t4, _t5, _t8);
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
