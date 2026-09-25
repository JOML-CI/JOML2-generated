// Copyright (c) 2015-2026 JOML
// SPDX-License-Identifier: MIT
package org.joml2.internal.simd;

import jdk.incubator.vector.*;
import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Vector-API isolation cell for {@link Double3x4Ops}: every
 * {@code jdk.incubator.vector} reference of the Ops family lives in this class,
 * which is loaded and initialized only behind {@code SimdSupport.VECTOR_API}
 * guards - {@code Double3x4Ops} and its kernel siblings link
 * and run without the incubator module. Not public API.
 */
public final class Double3x4OpsSimd {
    private Double3x4OpsSimd() {}
    private static final VectorSpecies<Double> SIMD_SPECIES = DoubleVector.SPECIES_256;
    private static final int PREFERRED_LANES = DoubleVector.SPECIES_PREFERRED.length();
    private static final DoubleVector UNIT_W = DoubleVector.fromArray(SIMD_SPECIES, new double[]{0.0, 0.0, 0.0, 1.0}, 0);

    public static double[] transpose(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment transpose(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder());
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] add(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).add(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment add(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, (otherOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).add(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] negate(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).neg();
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment negate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).neg();
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] sub(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).sub(DoubleVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment sub(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).sub(DoubleVector.fromMemorySegment(SIMD_SPECIES, other, (otherOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] set(double[] dest, int destOffset, double[] v, int vOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, v, (vOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment set(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, v, (vOffset + _li * 32L), java.nio.ByteOrder.nativeOrder());
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] withTranslation(double[] dest, int destOffset, double[] src, int srcOffset, double tX, double tY, double tZ) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, tX);
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(3, tY);
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(3, tZ);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment withTranslation(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double tX, double tY, double tZ) {
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, tX);
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).withLane(3, tY);
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).withLane(3, tZ);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] withTranslation(double[] dest, int destOffset, double[] src, int srcOffset, double[] t, int tOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, t[tOffset + 0]);
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(3, t[tOffset + 1]);
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(3, t[tOffset + 2]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment withTranslation(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment t, long tOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && t.isNative()) return withTranslation_unsafe(dest, destOffset, src, srcOffset, t, tOffset);
        return withTranslation_api(dest, destOffset, src, srcOffset, t, tOffset);
    }

    public static java.lang.foreign.MemorySegment withTranslation_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment t, long tOffset) {
        long _tBase = t.address() + tOffset;
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, UnsafeOpsHolder.U.getDouble(_tBase + 0L));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).withLane(3, UnsafeOpsHolder.U.getDouble(_tBase + 8L));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).withLane(3, UnsafeOpsHolder.U.getDouble(_tBase + 16L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment withTranslation_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment t, long tOffset) {
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, t.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, tOffset + 0L));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).withLane(3, t.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, tOffset + 8L));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).withLane(3, t.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, tOffset + 16L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] lerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    public static double[] lerp_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, t).fma(DoubleVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).sub(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))), DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] lerp_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, t).mul(DoubleVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).sub(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)))).add(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, double t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    public static java.lang.foreign.MemorySegment lerp_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, double t) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, t).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, other, (otherOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).sub(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder())), DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, double t) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, t).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, other, (otherOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).sub(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()))).add(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] mul(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mul_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mul_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static double[] mul_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0]), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1]), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2]), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 3]))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] mul_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2])).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 3]))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        if (SimdSupport.USE_FMA) return mul_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mul_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static java.lang.foreign.MemorySegment mul_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return mul_fma_unsafe(dest, destOffset, src, srcOffset, right, rightOffset);
        return mul_fma_api(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static java.lang.foreign.MemorySegment mul_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        long _srcBase = src.address() + srcOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 0L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 16L)), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 0L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 16L)), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return mul_mulAdd_unsafe(dest, destOffset, src, srcOffset, right, rightOffset);
        return mul_mulAdd_api(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static java.lang.foreign.MemorySegment mul_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        long _srcBase = src.address() + srcOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 0L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 16L))).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, right, rightOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 0L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 16L))).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] mulMat2x3(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        double _right00 = right[rightOffset + 0];
        double _right01 = right[rightOffset + 2];
        double _right10 = right[rightOffset + 1];
        double _right11 = right[rightOffset + 3];
        double _right02 = right[rightOffset + 4];
        double _right12 = right[rightOffset + 5];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, _right00).withLane(1, _right01).mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).withLane(3, src[(srcOffset + _li * 4) + 3]).add(DoubleVector.broadcast(SIMD_SPECIES, _right10).withLane(1, _right11).mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])).withLane(3, _right02 * src[(srcOffset + _li * 4) + 0] + _right12 * src[(srcOffset + _li * 4) + 1])).withLane(2, src[(srcOffset + _li * 4) + 2]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mulMat2x3(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && right.isNative()) return mulMat2x3_unsafe(dest, destOffset, src, srcOffset, right, rightOffset);
        return mulMat2x3_api(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static java.lang.foreign.MemorySegment mulMat2x3_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        long _srcBase = src.address() + srcOffset;
        long _rightBase = right.address() + rightOffset;
        double _right00 = UnsafeOpsHolder.U.getDouble(_rightBase + 0L);
        double _right01 = UnsafeOpsHolder.U.getDouble(_rightBase + 16L);
        double _right10 = UnsafeOpsHolder.U.getDouble(_rightBase + 8L);
        double _right11 = UnsafeOpsHolder.U.getDouble(_rightBase + 24L);
        double _right02 = UnsafeOpsHolder.U.getDouble(_rightBase + 32L);
        double _right12 = UnsafeOpsHolder.U.getDouble(_rightBase + 40L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, _right00).withLane(1, _right01).mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 0L))).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)).add(DoubleVector.broadcast(SIMD_SPECIES, _right10).withLane(1, _right11).mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L))).withLane(3, _right02 * UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 0L) + _right12 * UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L))).withLane(2, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 16L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mulMat2x3_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment right, long rightOffset) {
        double _right00 = right.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rightOffset + 0L);
        double _right01 = right.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rightOffset + 16L);
        double _right10 = right.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rightOffset + 8L);
        double _right11 = right.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rightOffset + 24L);
        double _right02 = right.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rightOffset + 32L);
        double _right12 = right.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rightOffset + 40L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, _right00).withLane(1, _right01).mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 0L))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)).add(DoubleVector.broadcast(SIMD_SPECIES, _right10).withLane(1, _right11).mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L))).withLane(3, _right02 * src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 0L) + _right12 * src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L))).withLane(2, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 16L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] preMul(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMul_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMul_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] preMul_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 0]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 1]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 2]).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, other[(otherOffset + _li * 4) + 3]))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] preMul_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 0]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 1]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 2]).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, other[(otherOffset + _li * 4) + 3]))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (SimdSupport.USE_FMA) return preMul_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMul_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMul_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMul_fma_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMul_fma_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMul_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 8L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 16L)).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 8L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 16L)).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMul_mulAdd_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMul_mulAdd_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMul_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 8L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 16L)).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_otherBase + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 8L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 16L)).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (otherOffset + _li * 32L) + 24L)))));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] preMulMat2x2(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x2_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x2_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] preMulMat2x2_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv1));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preMulMat2x2_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv1));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x2_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x2_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMulMat2x2_fma_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x2_fma_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 16L)).mul(_sv1));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 8L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 24L)).mul(_sv1));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 16L)).mul(_sv1));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 8L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 24L)).mul(_sv1));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMulMat2x2_mulAdd_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x2_mulAdd_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 16L)).mul(_sv1));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 8L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 24L)).mul(_sv1));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x2_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 16L)).mul(_sv1));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 8L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 24L)).mul(_sv1));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preMulMat2x3(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] preMulMat2x3_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).fma(_sv1, _sv2.withLane(3, other[otherOffset + 4])));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).fma(_sv1, _sv2.withLane(3, other[otherOffset + 5])));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preMulMat2x3_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1).add(_sv2.withLane(3, other[otherOffset + 4])));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv1).add(_sv2.withLane(3, other[otherOffset + 5])));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMulMat2x3_fma_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x3_fma_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 16L)).fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_otherBase + 32L))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 8L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 24L)).fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_otherBase + 40L))));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 16L)).fma(_sv1, _sv2.withLane(3, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 32L))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 8L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 24L)).fma(_sv1, _sv2.withLane(3, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 40L))));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMulMat2x3_mulAdd_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x3_mulAdd_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 16L)).mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_otherBase + 32L))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 8L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 24L)).mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_otherBase + 40L))));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat2x3_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 16L)).mul(_sv1).add(_sv2.withLane(3, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 32L))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 8L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 24L)).mul(_sv1).add(_sv2.withLane(3, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 40L))));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preMulMat3x3(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat3x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat3x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] preMulMat3x3_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 6]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 7]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).mul(_sv2)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 8]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).mul(_sv2)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preMulMat3x3_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 6]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 7]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).mul(_sv2)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 8]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).mul(_sv2)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat3x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat3x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMulMat3x3_fma_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat3x3_fma_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 48L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 0L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 24L)).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 56L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 8L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 32L)).mul(_sv2)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 64L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 16L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 40L)).mul(_sv2)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 48L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 0L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 24L)).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 56L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 8L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 32L)).mul(_sv2)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 64L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 16L)).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 40L)).mul(_sv2)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && other.isNative()) return preMulMat3x3_mulAdd_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat3x3_mulAdd_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _otherBase = other.address() + otherOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 48L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 0L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 24L)).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 56L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 8L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 32L)).mul(_sv2)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 64L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 16L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_otherBase + 40L)).mul(_sv2)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat3x3_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 48L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 0L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 24L)).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 56L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 8L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 32L)).mul(_sv2)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 64L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 16L)).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, otherOffset + 40L)).mul(_sv2)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preMulMat4x4(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat4x4_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat4x4_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] preMulMat4x4_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 9]), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 1]), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 5]))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 10]), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 2]), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 6]))));
        var _c3 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]), DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static double[] preMulMat4x4_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 8])).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 0])).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 9])).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 1])).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 5]))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 10])).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 2])).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 6]))));
        var _c3 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3])).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7])).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11])).add(DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat4x4_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat4x4_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return preMulMat4x4_fma_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat4x4_fma_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _srcBase = src.address() + srcOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 64L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 0L)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 32L)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 72L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 8L)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 40L)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 80L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 16L)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 48L)))));
        var _c3 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 24L)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 56L)), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 88L)), DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 96L, java.nio.ByteOrder.nativeOrder()))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c3.intoMemorySegment(dest, destOffset + 96L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L)))));
        var _c3 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L)), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L)), DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 96L, java.nio.ByteOrder.nativeOrder()))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c3.intoMemorySegment(dest, destOffset + 96L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return preMulMat4x4_mulAdd_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat4x4_mulAdd_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _srcBase = src.address() + srcOffset;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 64L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 0L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 32L)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 72L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 8L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 40L)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 80L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 16L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 48L)))));
        var _c3 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 96L, java.nio.ByteOrder.nativeOrder()))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c3.intoMemorySegment(dest, destOffset + 96L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMulMat4x4_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L)))));
        var _c3 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset + 96L, java.nio.ByteOrder.nativeOrder()))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c3.intoMemorySegment(dest, destOffset + 96L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] composeTRSMul(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return composeTRSMul_mulAdd(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
    }

    public static double[] composeTRSMul_fma(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = scaleZ + scaleZ;
        double _t1 = scaleX + scaleX;
        double _t2 = scaleY + scaleY;
        double _t3 = rotationY * rotationW;
        double _t4 = rotationZ * rotationZ;
        double _t5 = rotationZ * rotationW;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, _t3) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, -_t5) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationY, rotationY, _t4), _t1, scaleX)), _sv3.withLane(3, translationX))));
        var _c1 = _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t5) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, _t4), _t2, scaleY)), _sv3.withLane(3, translationY))));
        var _c2 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationW, rotationY * rotationZ) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t3) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, rotationY * rotationY), _t0, scaleZ)), _sv3.withLane(3, translationZ))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRSMul_mulAdd(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = scaleZ + scaleZ;
        double _t1 = scaleX + scaleX;
        double _t2 = scaleY + scaleY;
        double _t3 = rotationY * rotationW;
        double _t4 = rotationZ * rotationZ;
        double _t5 = rotationZ * rotationW;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, _t3) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, -_t5) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationY, rotationY, _t4), _t1, scaleX))).add(_sv3.withLane(3, translationX))));
        var _c1 = _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t5) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, _t4), _t2, scaleY))).add(_sv3.withLane(3, translationY))));
        var _c2 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationW, rotationY * rotationZ) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t3) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, rotationY * rotationY), _t0, scaleZ))).add(_sv3.withLane(3, translationZ))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment composeTRSMul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return composeTRSMul_mulAdd(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = scaleZ + scaleZ;
        double _t1 = scaleX + scaleX;
        double _t2 = scaleY + scaleY;
        double _t3 = rotationY * rotationW;
        double _t4 = rotationZ * rotationZ;
        double _t5 = rotationZ * rotationW;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, _t3) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, -_t5) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationY, rotationY, _t4), _t1, scaleX)), _sv3.withLane(3, translationX))));
        var _c1 = _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t5) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, _t4), _t2, scaleY)), _sv3.withLane(3, translationY))));
        var _c2 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationW, rotationY * rotationZ) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t3) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, rotationY * rotationY), _t0, scaleZ)), _sv3.withLane(3, translationZ))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = scaleZ + scaleZ;
        double _t1 = scaleX + scaleX;
        double _t2 = scaleY + scaleY;
        double _t3 = rotationY * rotationW;
        double _t4 = rotationZ * rotationZ;
        double _t5 = rotationZ * rotationW;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, _t3) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, -_t5) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationY, rotationY, _t4), _t1, scaleX))).add(_sv3.withLane(3, translationX))));
        var _c1 = _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t5) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, _t4), _t2, scaleY))).add(_sv3.withLane(3, translationY))));
        var _c2 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationW, rotationY * rotationZ) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t3) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(rotationX, rotationX, rotationY * rotationY), _t0, scaleZ))).add(_sv3.withLane(3, translationZ))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] composeTRSMul(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
        return composeTRSMul_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
    }

    public static double[] composeTRSMul_fma(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationz = rotation[rotationOffset + 2];
        double _rotationy = rotation[rotationOffset + 1];
        double _scalex = scale[scaleOffset + 0];
        double _rotationw = rotation[rotationOffset + 3];
        double _scaley = scale[scaleOffset + 1];
        double _scalez = scale[scaleOffset + 2];
        double _t0 = _scalez + _scalez;
        double _t1 = _scalex + _scalex;
        double _t2 = _scaley + _scaley;
        double _t3 = _rotationy * _rotationw;
        double _t4 = _rotationz * _rotationz;
        double _t5 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t3) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t5) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationy, _rotationy, _t4), _t1, _scalex)), _sv3.withLane(3, translation[translationOffset + 0]))));
        var _c1 = _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t5) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _t4), _t2, _scaley)), _sv3.withLane(3, translation[translationOffset + 1]))));
        var _c2 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t3) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), _t0, _scalez)), _sv3.withLane(3, translation[translationOffset + 2]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRSMul_mulAdd(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationz = rotation[rotationOffset + 2];
        double _rotationy = rotation[rotationOffset + 1];
        double _scalex = scale[scaleOffset + 0];
        double _rotationw = rotation[rotationOffset + 3];
        double _scaley = scale[scaleOffset + 1];
        double _scalez = scale[scaleOffset + 2];
        double _t0 = _scalez + _scalez;
        double _t1 = _scalex + _scalex;
        double _t2 = _scaley + _scaley;
        double _t3 = _rotationy * _rotationw;
        double _t4 = _rotationz * _rotationz;
        double _t5 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t3) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t5) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationy, _rotationy, _t4), _t1, _scalex))).add(_sv3.withLane(3, translation[translationOffset + 0]))));
        var _c1 = _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t5) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _t4), _t2, _scaley))).add(_sv3.withLane(3, translation[translationOffset + 1]))));
        var _c2 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t3) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), _t0, _scalez))).add(_sv3.withLane(3, translation[translationOffset + 2]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment composeTRSMul(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
        return composeTRSMul_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && translation.isNative() && rotation.isNative() && scale.isNative()) return composeTRSMul_fma_unsafe(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
        return composeTRSMul_fma_api(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _translationBase = translation.address() + translationOffset;
        long _rotationBase = rotation.address() + rotationOffset;
        long _scaleBase = scale.address() + scaleOffset;
        double _rotationx = UnsafeOpsHolder.U.getDouble(_rotationBase + 0L);
        double _rotationz = UnsafeOpsHolder.U.getDouble(_rotationBase + 16L);
        double _rotationy = UnsafeOpsHolder.U.getDouble(_rotationBase + 8L);
        double _scalex = UnsafeOpsHolder.U.getDouble(_scaleBase + 0L);
        double _rotationw = UnsafeOpsHolder.U.getDouble(_rotationBase + 24L);
        double _scaley = UnsafeOpsHolder.U.getDouble(_scaleBase + 8L);
        double _scalez = UnsafeOpsHolder.U.getDouble(_scaleBase + 16L);
        double _t0 = _scalez + _scalez;
        double _t1 = _scalex + _scalex;
        double _t2 = _scaley + _scaley;
        double _t3 = _rotationy * _rotationw;
        double _t4 = _rotationz * _rotationz;
        double _t5 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t3) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t5) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationy, _rotationy, _t4), _t1, _scalex)), _sv3.withLane(3, UnsafeOpsHolder.U.getDouble(_translationBase + 0L)))));
        var _c1 = _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t5) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _t4), _t2, _scaley)), _sv3.withLane(3, UnsafeOpsHolder.U.getDouble(_translationBase + 8L)))));
        var _c2 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t3) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), _t0, _scalez)), _sv3.withLane(3, UnsafeOpsHolder.U.getDouble(_translationBase + 16L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        double _rotationx = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 0L);
        double _rotationz = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 16L);
        double _rotationy = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 8L);
        double _scalex = scale.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, scaleOffset + 0L);
        double _rotationw = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 24L);
        double _scaley = scale.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, scaleOffset + 8L);
        double _scalez = scale.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, scaleOffset + 16L);
        double _t0 = _scalez + _scalez;
        double _t1 = _scalex + _scalex;
        double _t2 = _scaley + _scaley;
        double _t3 = _rotationy * _rotationw;
        double _t4 = _rotationz * _rotationz;
        double _t5 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t3) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t5) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationy, _rotationy, _t4), _t1, _scalex)), _sv3.withLane(3, translation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, translationOffset + 0L)))));
        var _c1 = _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t5) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)) * _t0), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _t4), _t2, _scaley)), _sv3.withLane(3, translation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, translationOffset + 8L)))));
        var _c2 = _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz) * _t2), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t3) * _t1), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), _t0, _scalez)), _sv3.withLane(3, translation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, translationOffset + 16L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && translation.isNative() && rotation.isNative() && scale.isNative()) return composeTRSMul_mulAdd_unsafe(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
        return composeTRSMul_mulAdd_api(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _translationBase = translation.address() + translationOffset;
        long _rotationBase = rotation.address() + rotationOffset;
        long _scaleBase = scale.address() + scaleOffset;
        double _rotationx = UnsafeOpsHolder.U.getDouble(_rotationBase + 0L);
        double _rotationz = UnsafeOpsHolder.U.getDouble(_rotationBase + 16L);
        double _rotationy = UnsafeOpsHolder.U.getDouble(_rotationBase + 8L);
        double _scalex = UnsafeOpsHolder.U.getDouble(_scaleBase + 0L);
        double _rotationw = UnsafeOpsHolder.U.getDouble(_rotationBase + 24L);
        double _scaley = UnsafeOpsHolder.U.getDouble(_scaleBase + 8L);
        double _scalez = UnsafeOpsHolder.U.getDouble(_scaleBase + 16L);
        double _t0 = _scalez + _scalez;
        double _t1 = _scalex + _scalex;
        double _t2 = _scaley + _scaley;
        double _t3 = _rotationy * _rotationw;
        double _t4 = _rotationz * _rotationz;
        double _t5 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t3) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t5) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationy, _rotationy, _t4), _t1, _scalex))).add(_sv3.withLane(3, UnsafeOpsHolder.U.getDouble(_translationBase + 0L)))));
        var _c1 = _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t5) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _t4), _t2, _scaley))).add(_sv3.withLane(3, UnsafeOpsHolder.U.getDouble(_translationBase + 8L)))));
        var _c2 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t3) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), _t0, _scalez))).add(_sv3.withLane(3, UnsafeOpsHolder.U.getDouble(_translationBase + 16L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment composeTRSMul_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment translation, long translationOffset, java.lang.foreign.MemorySegment rotation, long rotationOffset, java.lang.foreign.MemorySegment scale, long scaleOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        double _rotationx = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 0L);
        double _rotationz = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 16L);
        double _rotationy = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 8L);
        double _scalex = scale.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, scaleOffset + 0L);
        double _rotationw = rotation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotationOffset + 24L);
        double _scaley = scale.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, scaleOffset + 8L);
        double _scalez = scale.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, scaleOffset + 16L);
        double _t0 = _scalez + _scalez;
        double _t1 = _scalex + _scalex;
        double _t2 = _scaley + _scaley;
        double _t3 = _rotationy * _rotationw;
        double _t4 = _rotationz * _rotationz;
        double _t5 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, m, mOffset, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t3) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t5) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationy, _rotationy, _t4), _t1, _scalex))).add(_sv3.withLane(3, translation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, translationOffset + 0L)))));
        var _c1 = _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t5) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)) * _t0)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _t4), _t2, _scaley))).add(_sv3.withLane(3, translation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, translationOffset + 8L)))));
        var _c2 = _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz) * _t2)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t3) * _t1)).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), _t0, _scalez))).add(_sv3.withLane(3, translation.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, translationOffset + 16L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] lookAt_lh(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static double[] lookAt_lh_fma(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).fma(_sv0, _sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv3, _sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).fma(_sv0, _sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv3, _sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).fma(_sv0, _sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv3, _sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] lookAt_lh_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3).add(_sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3).add(_sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3).add(_sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] lookAt_rh(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static double[] lookAt_rh_fma(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).fma(_sv0, _sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01).fma(_sv3, _sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).fma(_sv0, _sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11).fma(_sv3, _sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).fma(_sv0, _sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21).fma(_sv3, _sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] lookAt_rh_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv3).add(_sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv3).add(_sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv3).add(_sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return lookAt_lh_fma_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_fma_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _srcBase = src.address() + srcOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv3, _sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv3, _sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv3, _sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv3, _sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv3, _sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv3, _sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return lookAt_lh_mulAdd_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_mulAdd_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _srcBase = src.address() + srcOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3).add(_sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3).add(_sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3).add(_sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t0 = centerZ - eyeZ;
        double _t1 = centerX - eyeX;
        double _t2 = centerY - eyeY;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3).add(_sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3).add(_sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3).add(_sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return lookAt_rh_fma_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_fma_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _srcBase = src.address() + srcOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01).fma(_sv3, _sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11).fma(_sv3, _sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21).fma(_sv3, _sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01).fma(_sv3, _sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11).fma(_sv3, _sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21).fma(_sv3, _sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return lookAt_rh_mulAdd_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_mulAdd_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _srcBase = src.address() + srcOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv3).add(_sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv3).add(_sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv3).add(_sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _t3 = centerZ - eyeZ;
        double _t4 = centerX - eyeX;
        double _t5 = centerY - eyeY;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv3).add(_sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv3).add(_sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv3).add(_sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] lookAt_lh(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static double[] lookAt_lh_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _eyez = eye[eyeOffset + 2];
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t0 = center[centerOffset + 2] - _eyez;
        double _t1 = center[centerOffset + 0] - _eyex;
        double _t2 = center[centerOffset + 1] - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).fma(_sv0, _sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv3, _sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).fma(_sv0, _sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv3, _sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).fma(_sv0, _sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv3, _sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] lookAt_lh_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _eyez = eye[eyeOffset + 2];
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t0 = center[centerOffset + 2] - _eyez;
        double _t1 = center[centerOffset + 0] - _eyex;
        double _t2 = center[centerOffset + 1] - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3).add(_sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3).add(_sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3).add(_sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] lookAt_rh(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static double[] lookAt_rh_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _eyez = eye[eyeOffset + 2];
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _upy = up[upOffset + 1];
        double _upx = up[upOffset + 0];
        double _upz = up[upOffset + 2];
        double _t3 = center[centerOffset + 2] - _eyez;
        double _t4 = center[centerOffset + 0] - _eyex;
        double _t5 = center[centerOffset + 1] - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).fma(_sv0, _sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01).fma(_sv3, _sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).fma(_sv0, _sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11).fma(_sv3, _sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).fma(_sv0, _sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21).fma(_sv3, _sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] lookAt_rh_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] eye, int eyeOffset, double[] center, int centerOffset, double[] up, int upOffset) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _eyez = eye[eyeOffset + 2];
        double _eyex = eye[eyeOffset + 0];
        double _eyey = eye[eyeOffset + 1];
        double _upy = up[upOffset + 1];
        double _upx = up[upOffset + 0];
        double _upz = up[upOffset + 2];
        double _t3 = center[centerOffset + 2] - _eyez;
        double _t4 = center[centerOffset + 0] - _eyex;
        double _t5 = center[centerOffset + 1] - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv3).add(_sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv3).add(_sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0).add(_sv1.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv3).add(_sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && eye.isNative() && center.isNative() && up.isNative()) return lookAt_lh_fma_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_lh_fma_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _srcBase = src.address() + srcOffset;
        long _eyeBase = eye.address() + eyeOffset;
        long _centerBase = center.address() + centerOffset;
        long _upBase = up.address() + upOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _eyez = UnsafeOpsHolder.U.getDouble(_eyeBase + 16L);
        double _eyex = UnsafeOpsHolder.U.getDouble(_eyeBase + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(_eyeBase + 8L);
        double _upx = UnsafeOpsHolder.U.getDouble(_upBase + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(_upBase + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(_upBase + 16L);
        double _t0 = UnsafeOpsHolder.U.getDouble(_centerBase + 16L) - _eyez;
        double _t1 = UnsafeOpsHolder.U.getDouble(_centerBase + 0L) - _eyex;
        double _t2 = UnsafeOpsHolder.U.getDouble(_centerBase + 8L) - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv3, _sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv3, _sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv3, _sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _eyez = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 16L);
        double _eyex = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 0L);
        double _eyey = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 8L);
        double _upx = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 0L);
        double _upy = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 8L);
        double _upz = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 16L);
        double _t0 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 16L) - _eyez;
        double _t1 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 0L) - _eyex;
        double _t2 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 8L) - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv3, _sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv3, _sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv3, _sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && eye.isNative() && center.isNative() && up.isNative()) return lookAt_lh_mulAdd_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_lh_mulAdd_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _srcBase = src.address() + srcOffset;
        long _eyeBase = eye.address() + eyeOffset;
        long _centerBase = center.address() + centerOffset;
        long _upBase = up.address() + upOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _eyez = UnsafeOpsHolder.U.getDouble(_eyeBase + 16L);
        double _eyex = UnsafeOpsHolder.U.getDouble(_eyeBase + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(_eyeBase + 8L);
        double _upx = UnsafeOpsHolder.U.getDouble(_upBase + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(_upBase + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(_upBase + 16L);
        double _t0 = UnsafeOpsHolder.U.getDouble(_centerBase + 16L) - _eyez;
        double _t1 = UnsafeOpsHolder.U.getDouble(_centerBase + 0L) - _eyex;
        double _t2 = UnsafeOpsHolder.U.getDouble(_centerBase + 8L) - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3).add(_sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3).add(_sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3).add(_sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_lh_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _eyez = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 16L);
        double _eyex = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 0L);
        double _eyey = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 8L);
        double _upx = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 0L);
        double _upy = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 8L);
        double _upz = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 16L);
        double _t0 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 16L) - _eyez;
        double _t1 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 0L) - _eyex;
        double _t2 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 8L) - _eyey;
        double _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t6 = (1.0 / Math.sqrt(_t5));
        double _t10, _t11, _t12;
        if (_t5 != 0.0) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0;
            _t11 = 0.0;
            _t12 = 0.0;
        }
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32, _t33, _t34;
        if (_t27 != 0.0) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0;
            _t33 = 0.0;
            _t34 = 0.0;
        }
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3).add(_sv1.withLane(3, -_self01 * _t49 + -_self02 * _t24))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3).add(_sv1.withLane(3, -_self11 * _t49 + -_self12 * _t24))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3).add(_sv1.withLane(3, -_self21 * _t49 + -_self22 * _t24))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && eye.isNative() && center.isNative() && up.isNative()) return lookAt_rh_fma_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_rh_fma_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _srcBase = src.address() + srcOffset;
        long _eyeBase = eye.address() + eyeOffset;
        long _centerBase = center.address() + centerOffset;
        long _upBase = up.address() + upOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _eyez = UnsafeOpsHolder.U.getDouble(_eyeBase + 16L);
        double _eyex = UnsafeOpsHolder.U.getDouble(_eyeBase + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(_eyeBase + 8L);
        double _upy = UnsafeOpsHolder.U.getDouble(_upBase + 8L);
        double _upx = UnsafeOpsHolder.U.getDouble(_upBase + 0L);
        double _upz = UnsafeOpsHolder.U.getDouble(_upBase + 16L);
        double _t3 = UnsafeOpsHolder.U.getDouble(_centerBase + 16L) - _eyez;
        double _t4 = UnsafeOpsHolder.U.getDouble(_centerBase + 0L) - _eyex;
        double _t5 = UnsafeOpsHolder.U.getDouble(_centerBase + 8L) - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01).fma(_sv3, _sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11).fma(_sv3, _sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).fma(_sv0, _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21).fma(_sv3, _sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _eyez = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 16L);
        double _eyex = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 0L);
        double _eyey = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 8L);
        double _upy = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 8L);
        double _upx = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 0L);
        double _upz = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 16L);
        double _t3 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 16L) - _eyez;
        double _t4 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 0L) - _eyex;
        double _t5 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 8L) - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01).fma(_sv3, _sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11).fma(_sv3, _sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).fma(_sv0, _sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21).fma(_sv3, _sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && eye.isNative() && center.isNative() && up.isNative()) return lookAt_rh_mulAdd_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_rh_mulAdd_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _srcBase = src.address() + srcOffset;
        long _eyeBase = eye.address() + eyeOffset;
        long _centerBase = center.address() + centerOffset;
        long _upBase = up.address() + upOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _eyez = UnsafeOpsHolder.U.getDouble(_eyeBase + 16L);
        double _eyex = UnsafeOpsHolder.U.getDouble(_eyeBase + 0L);
        double _eyey = UnsafeOpsHolder.U.getDouble(_eyeBase + 8L);
        double _upy = UnsafeOpsHolder.U.getDouble(_upBase + 8L);
        double _upx = UnsafeOpsHolder.U.getDouble(_upBase + 0L);
        double _upz = UnsafeOpsHolder.U.getDouble(_upBase + 16L);
        double _t3 = UnsafeOpsHolder.U.getDouble(_centerBase + 16L) - _eyez;
        double _t4 = UnsafeOpsHolder.U.getDouble(_centerBase + 0L) - _eyex;
        double _t5 = UnsafeOpsHolder.U.getDouble(_centerBase + 8L) - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv3).add(_sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv3).add(_sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv3).add(_sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAt_rh_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment eye, long eyeOffset, java.lang.foreign.MemorySegment center, long centerOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _eyez = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 16L);
        double _eyex = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 0L);
        double _eyey = eye.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, eyeOffset + 8L);
        double _upy = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 8L);
        double _upx = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 0L);
        double _upz = up.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, upOffset + 16L);
        double _t3 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 16L) - _eyez;
        double _t4 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 0L) - _eyex;
        double _t5 = center.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, centerOffset + 8L) - _eyey;
        double _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        double _t9 = (1.0 / Math.sqrt(_t8));
        double _t13, _t14, _t15;
        if (_t8 != 0.0) {
            _t13 = _t4 * _t9;
            _t14 = _t5 * _t9;
            _t15 = _t3 * _t9;
        } else {
            _t13 = 0.0;
            _t14 = 0.0;
            _t15 = 0.0;
        }
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35, _t36, _t37;
        if (_t30 != 0.0) {
            _t35 = _t26 * _t31;
            _t36 = _t25 * _t31;
            _t37 = _t24 * _t31;
        } else {
            _t35 = 0.0;
            _t36 = 0.0;
            _t37 = 0.0;
        }
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv3).add(_sv1.withLane(3, -_self00 * _t50 + -_self01 * _t52))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv3).add(_sv1.withLane(3, -_self10 * _t50 + -_self11 * _t52))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0).add(_sv1.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv3).add(_sv1.withLane(3, -_self20 * _t50 + -_self21 * _t52))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] mapXYZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mapXYZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder());
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] mapXYnZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).withLane(2, -src[(srcOffset + _li * 4) + 2]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mapXYnZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return mapXYnZ_unsafe(dest, destOffset, src, srcOffset);
        return mapXYnZ_api(dest, destOffset, src, srcOffset);
    }

    public static java.lang.foreign.MemorySegment mapXYnZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).withLane(2, -UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 16L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mapXYnZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).withLane(2, -src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 16L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] mapXnYZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).withLane(1, -src[(srcOffset + _li * 4) + 1]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mapXnYZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return mapXnYZ_unsafe(dest, destOffset, src, srcOffset);
        return mapXnYZ_api(dest, destOffset, src, srcOffset);
    }

    public static java.lang.foreign.MemorySegment mapXnYZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).withLane(1, -UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mapXnYZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).withLane(1, -src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] preRotateAround(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static double[] preRotateAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _t0 = -rotY;
        double _t2 = -pivotZ;
        double _t3 = -rotX;
        double _t4 = rotX + rotX;
        double _t5 = rotY + rotY;
        double _t6 = rotZ + rotZ;
        double _t7 = rotW * _t5;
        double _t8 = rotW * _t6;
        double _t9 = rotZ * _t6;
        double _t10 = rotW * _t4;
        double _t14 = Math.fma(-rotZ, _t6, 1.0);
        double _t16 = Math.fma(rotZ, _t4, _t7);
        double _t17 = Math.fma(rotY, _t4, _t8);
        double _t18 = Math.fma(rotZ, _t5, _t10);
        double _t19 = Math.fma(rotY, _t4, -_t8);
        double _t20 = Math.fma(rotZ, _t5, -_t10);
        double _t21 = Math.fma(rotZ, _t4, -_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(pivotX, Math.fma(rotY, _t5, _t9), -(pivotY * _t19)))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t17), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14)), _sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(pivotY, Math.fma(rotX, _t4, _t9), -(pivotX * _t17)))))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t21), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t18), _sv3.withLane(3, Math.fma(-pivotY, _t18, Math.fma(pivotZ, Math.fma(rotX, _t4, rotY * _t5), -(pivotX * _t21)))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _t0 = -rotY;
        double _t2 = -pivotZ;
        double _t3 = -rotX;
        double _t4 = rotX + rotX;
        double _t5 = rotY + rotY;
        double _t6 = rotZ + rotZ;
        double _t7 = rotW * _t5;
        double _t8 = rotW * _t6;
        double _t9 = rotZ * _t6;
        double _t10 = rotW * _t4;
        double _t14 = Math.fma(-rotZ, _t6, 1.0);
        double _t16 = Math.fma(rotZ, _t4, _t7);
        double _t17 = Math.fma(rotY, _t4, _t8);
        double _t18 = Math.fma(rotZ, _t5, _t10);
        double _t19 = Math.fma(rotY, _t4, -_t8);
        double _t20 = Math.fma(rotZ, _t5, -_t10);
        double _t21 = Math.fma(rotZ, _t4, -_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(pivotX, Math.fma(rotY, _t5, _t9), -(pivotY * _t19)))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t17)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14))).add(_sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(pivotY, Math.fma(rotX, _t4, _t9), -(pivotX * _t17)))))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t18)).add(_sv3.withLane(3, Math.fma(-pivotY, _t18, Math.fma(pivotZ, Math.fma(rotX, _t4, rotY * _t5), -(pivotX * _t21)))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment preRotateAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _t0 = -rotY;
        double _t2 = -pivotZ;
        double _t3 = -rotX;
        double _t4 = rotX + rotX;
        double _t5 = rotY + rotY;
        double _t6 = rotZ + rotZ;
        double _t7 = rotW * _t5;
        double _t8 = rotW * _t6;
        double _t9 = rotZ * _t6;
        double _t10 = rotW * _t4;
        double _t14 = Math.fma(-rotZ, _t6, 1.0);
        double _t16 = Math.fma(rotZ, _t4, _t7);
        double _t17 = Math.fma(rotY, _t4, _t8);
        double _t18 = Math.fma(rotZ, _t5, _t10);
        double _t19 = Math.fma(rotY, _t4, -_t8);
        double _t20 = Math.fma(rotZ, _t5, -_t10);
        double _t21 = Math.fma(rotZ, _t4, -_t7);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(pivotX, Math.fma(rotY, _t5, _t9), -(pivotY * _t19)))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t17), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14)), _sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(pivotY, Math.fma(rotX, _t4, _t9), -(pivotX * _t17)))))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t21), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t18), _sv3.withLane(3, Math.fma(-pivotY, _t18, Math.fma(pivotZ, Math.fma(rotX, _t4, rotY * _t5), -(pivotX * _t21)))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _t0 = -rotY;
        double _t2 = -pivotZ;
        double _t3 = -rotX;
        double _t4 = rotX + rotX;
        double _t5 = rotY + rotY;
        double _t6 = rotZ + rotZ;
        double _t7 = rotW * _t5;
        double _t8 = rotW * _t6;
        double _t9 = rotZ * _t6;
        double _t10 = rotW * _t4;
        double _t14 = Math.fma(-rotZ, _t6, 1.0);
        double _t16 = Math.fma(rotZ, _t4, _t7);
        double _t17 = Math.fma(rotY, _t4, _t8);
        double _t18 = Math.fma(rotZ, _t5, _t10);
        double _t19 = Math.fma(rotY, _t4, -_t8);
        double _t20 = Math.fma(rotZ, _t5, -_t10);
        double _t21 = Math.fma(rotZ, _t4, -_t7);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(pivotX, Math.fma(rotY, _t5, _t9), -(pivotY * _t19)))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t17)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14))).add(_sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(pivotY, Math.fma(rotX, _t4, _t9), -(pivotX * _t17)))))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t18)).add(_sv3.withLane(3, Math.fma(-pivotY, _t18, Math.fma(pivotZ, Math.fma(rotX, _t4, rotY * _t5), -(pivotX * _t21)))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static double[] preRotateAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _pivotx = pivot[pivotOffset + 0];
        double _roty = rot[rotOffset + 1];
        double _pivoty = pivot[pivotOffset + 1];
        double _rotx = rot[rotOffset + 0];
        double _pivotz = pivot[pivotOffset + 2];
        double _rotz = rot[rotOffset + 2];
        double _rotw = rot[rotOffset + 3];
        double _t0 = -_roty;
        double _t2 = -_pivotz;
        double _t3 = -_rotx;
        double _t4 = _rotx + _rotx;
        double _t5 = _roty + _roty;
        double _t6 = _rotz + _rotz;
        double _t7 = _rotw * _t5;
        double _t8 = _rotw * _t6;
        double _t9 = _rotz * _t6;
        double _t10 = _rotw * _t4;
        double _t14 = Math.fma(-_rotz, _t6, 1.0);
        double _t16 = Math.fma(_rotz, _t4, _t7);
        double _t17 = Math.fma(_roty, _t4, _t8);
        double _t18 = Math.fma(_rotz, _t5, _t10);
        double _t19 = Math.fma(_roty, _t4, -_t8);
        double _t20 = Math.fma(_rotz, _t5, -_t10);
        double _t21 = Math.fma(_rotz, _t4, -_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(_pivotx, Math.fma(_roty, _t5, _t9), -(_pivoty * _t19)))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t17), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14)), _sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(_pivoty, Math.fma(_rotx, _t4, _t9), -(_pivotx * _t17)))))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t21), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t18), _sv3.withLane(3, Math.fma(-_pivoty, _t18, Math.fma(_pivotz, Math.fma(_rotx, _t4, _roty * _t5), -(_pivotx * _t21)))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _pivotx = pivot[pivotOffset + 0];
        double _roty = rot[rotOffset + 1];
        double _pivoty = pivot[pivotOffset + 1];
        double _rotx = rot[rotOffset + 0];
        double _pivotz = pivot[pivotOffset + 2];
        double _rotz = rot[rotOffset + 2];
        double _rotw = rot[rotOffset + 3];
        double _t0 = -_roty;
        double _t2 = -_pivotz;
        double _t3 = -_rotx;
        double _t4 = _rotx + _rotx;
        double _t5 = _roty + _roty;
        double _t6 = _rotz + _rotz;
        double _t7 = _rotw * _t5;
        double _t8 = _rotw * _t6;
        double _t9 = _rotz * _t6;
        double _t10 = _rotw * _t4;
        double _t14 = Math.fma(-_rotz, _t6, 1.0);
        double _t16 = Math.fma(_rotz, _t4, _t7);
        double _t17 = Math.fma(_roty, _t4, _t8);
        double _t18 = Math.fma(_rotz, _t5, _t10);
        double _t19 = Math.fma(_roty, _t4, -_t8);
        double _t20 = Math.fma(_rotz, _t5, -_t10);
        double _t21 = Math.fma(_rotz, _t4, -_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(_pivotx, Math.fma(_roty, _t5, _t9), -(_pivoty * _t19)))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t17)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14))).add(_sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(_pivoty, Math.fma(_rotx, _t4, _t9), -(_pivotx * _t17)))))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t18)).add(_sv3.withLane(3, Math.fma(-_pivoty, _t18, Math.fma(_pivotz, Math.fma(_rotx, _t4, _roty * _t5), -(_pivotx * _t21)))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment preRotateAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rot.isNative() && pivot.isNative()) return preRotateAround_fma_unsafe(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return preRotateAround_fma_api(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment preRotateAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _rotBase = rot.address() + rotOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _pivotx = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L);
        double _roty = UnsafeOpsHolder.U.getDouble(_rotBase + 8L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L);
        double _rotx = UnsafeOpsHolder.U.getDouble(_rotBase + 0L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L);
        double _rotz = UnsafeOpsHolder.U.getDouble(_rotBase + 16L);
        double _rotw = UnsafeOpsHolder.U.getDouble(_rotBase + 24L);
        double _t0 = -_roty;
        double _t2 = -_pivotz;
        double _t3 = -_rotx;
        double _t4 = _rotx + _rotx;
        double _t5 = _roty + _roty;
        double _t6 = _rotz + _rotz;
        double _t7 = _rotw * _t5;
        double _t8 = _rotw * _t6;
        double _t9 = _rotz * _t6;
        double _t10 = _rotw * _t4;
        double _t14 = Math.fma(-_rotz, _t6, 1.0);
        double _t16 = Math.fma(_rotz, _t4, _t7);
        double _t17 = Math.fma(_roty, _t4, _t8);
        double _t18 = Math.fma(_rotz, _t5, _t10);
        double _t19 = Math.fma(_roty, _t4, -_t8);
        double _t20 = Math.fma(_rotz, _t5, -_t10);
        double _t21 = Math.fma(_rotz, _t4, -_t7);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(_pivotx, Math.fma(_roty, _t5, _t9), -(_pivoty * _t19)))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t17), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14)), _sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(_pivoty, Math.fma(_rotx, _t4, _t9), -(_pivotx * _t17)))))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t21), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t18), _sv3.withLane(3, Math.fma(-_pivoty, _t18, Math.fma(_pivotz, Math.fma(_rotx, _t4, _roty * _t5), -(_pivotx * _t21)))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _pivotx = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L);
        double _roty = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 8L);
        double _pivoty = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L);
        double _rotx = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 0L);
        double _pivotz = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L);
        double _rotz = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 16L);
        double _rotw = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 24L);
        double _t0 = -_roty;
        double _t2 = -_pivotz;
        double _t3 = -_rotx;
        double _t4 = _rotx + _rotx;
        double _t5 = _roty + _roty;
        double _t6 = _rotz + _rotz;
        double _t7 = _rotw * _t5;
        double _t8 = _rotw * _t6;
        double _t9 = _rotz * _t6;
        double _t10 = _rotw * _t4;
        double _t14 = Math.fma(-_rotz, _t6, 1.0);
        double _t16 = Math.fma(_rotz, _t4, _t7);
        double _t17 = Math.fma(_roty, _t4, _t8);
        double _t18 = Math.fma(_rotz, _t5, _t10);
        double _t19 = Math.fma(_roty, _t4, -_t8);
        double _t20 = Math.fma(_rotz, _t5, -_t10);
        double _t21 = Math.fma(_rotz, _t4, -_t7);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(_pivotx, Math.fma(_roty, _t5, _t9), -(_pivoty * _t19)))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t17), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14)), _sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(_pivoty, Math.fma(_rotx, _t4, _t9), -(_pivotx * _t17)))))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t21), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _t18), _sv3.withLane(3, Math.fma(-_pivoty, _t18, Math.fma(_pivotz, Math.fma(_rotx, _t4, _roty * _t5), -(_pivotx * _t21)))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rot.isNative() && pivot.isNative()) return preRotateAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return preRotateAround_mulAdd_api(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment preRotateAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _rotBase = rot.address() + rotOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _pivotx = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L);
        double _roty = UnsafeOpsHolder.U.getDouble(_rotBase + 8L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L);
        double _rotx = UnsafeOpsHolder.U.getDouble(_rotBase + 0L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L);
        double _rotz = UnsafeOpsHolder.U.getDouble(_rotBase + 16L);
        double _rotw = UnsafeOpsHolder.U.getDouble(_rotBase + 24L);
        double _t0 = -_roty;
        double _t2 = -_pivotz;
        double _t3 = -_rotx;
        double _t4 = _rotx + _rotx;
        double _t5 = _roty + _roty;
        double _t6 = _rotz + _rotz;
        double _t7 = _rotw * _t5;
        double _t8 = _rotw * _t6;
        double _t9 = _rotz * _t6;
        double _t10 = _rotw * _t4;
        double _t14 = Math.fma(-_rotz, _t6, 1.0);
        double _t16 = Math.fma(_rotz, _t4, _t7);
        double _t17 = Math.fma(_roty, _t4, _t8);
        double _t18 = Math.fma(_rotz, _t5, _t10);
        double _t19 = Math.fma(_roty, _t4, -_t8);
        double _t20 = Math.fma(_rotz, _t5, -_t10);
        double _t21 = Math.fma(_rotz, _t4, -_t7);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(_pivotx, Math.fma(_roty, _t5, _t9), -(_pivoty * _t19)))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t17)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14))).add(_sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(_pivoty, Math.fma(_rotx, _t4, _t9), -(_pivotx * _t17)))))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t18)).add(_sv3.withLane(3, Math.fma(-_pivoty, _t18, Math.fma(_pivotz, Math.fma(_rotx, _t4, _roty * _t5), -(_pivotx * _t21)))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _pivotx = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L);
        double _roty = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 8L);
        double _pivoty = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L);
        double _rotx = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 0L);
        double _pivotz = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L);
        double _rotz = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 16L);
        double _rotw = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 24L);
        double _t0 = -_roty;
        double _t2 = -_pivotz;
        double _t3 = -_rotx;
        double _t4 = _rotx + _rotx;
        double _t5 = _roty + _roty;
        double _t6 = _rotz + _rotz;
        double _t7 = _rotw * _t5;
        double _t8 = _rotw * _t6;
        double _t9 = _rotz * _t6;
        double _t10 = _rotw * _t4;
        double _t14 = Math.fma(-_rotz, _t6, 1.0);
        double _t16 = Math.fma(_rotz, _t4, _t7);
        double _t17 = Math.fma(_roty, _t4, _t8);
        double _t18 = Math.fma(_rotz, _t5, _t10);
        double _t19 = Math.fma(_roty, _t4, -_t8);
        double _t20 = Math.fma(_rotz, _t5, -_t10);
        double _t21 = Math.fma(_rotz, _t4, -_t7);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv3 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, _t14))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv3.withLane(3, Math.fma(_t2, _t16, Math.fma(_pivotx, Math.fma(_roty, _t5, _t9), -(_pivoty * _t19)))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t17)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, _t14))).add(_sv3.withLane(3, Math.fma(_t2, _t20, Math.fma(_pivoty, Math.fma(_rotx, _t4, _t9), -(_pivotx * _t17)))))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, Math.fma(_t0, _t5, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t18)).add(_sv3.withLane(3, Math.fma(-_pivoty, _t18, Math.fma(_pivotz, Math.fma(_rotx, _t4, _roty * _t5), -(_pivotx * _t21)))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateAxis(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    public static double[] preRotateAxis_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = axisX * axisZ;
        double _t4 = axisX * axisY;
        double _t6 = axisY * axisZ;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t11 * _t2)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisX * axisX, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(axisZ * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(axisX * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t11 * _t4)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisY * axisY, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisZ * axisZ, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(axisY * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t11 * _t6)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAxis_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = axisX * axisZ;
        double _t4 = axisX * axisY;
        double _t6 = axisY * axisZ;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t11 * _t2))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisX * axisX, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(axisZ * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(axisX * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t11 * _t4))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisY * axisY, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisZ * axisZ, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(axisY * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t11 * _t6)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAxis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = axisX * axisZ;
        double _t4 = axisX * axisY;
        double _t6 = axisY * axisZ;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t11 * _t2)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisX * axisX, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(axisZ * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(axisX * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t11 * _t4)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisY * axisY, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisZ * axisZ, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(axisY * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t11 * _t6)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = axisX * axisZ;
        double _t4 = axisX * axisY;
        double _t6 = axisY * axisZ;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t11 * _t2))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisX * axisX, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(axisZ * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(axisX * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t11 * _t4))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisY * axisY, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, axisZ * axisZ, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(axisY * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t11 * _t6)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateAxis(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    public static double[] preRotateAxis_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset, double angle) {
        double _axisy = axis[axisOffset + 1];
        double _axisx = axis[axisOffset + 0];
        double _axisz = axis[axisOffset + 2];
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = _axisx * _axisz;
        double _t4 = _axisx * _axisy;
        double _t6 = _axisy * _axisz;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t11 * _t2)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisx * _axisx, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(_axisz * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(_axisx * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t11 * _t4)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisz * _axisz, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(_axisy * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t11 * _t6)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAxis_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] axis, int axisOffset, double angle) {
        double _axisy = axis[axisOffset + 1];
        double _axisx = axis[axisOffset + 0];
        double _axisz = axis[axisOffset + 2];
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = _axisx * _axisz;
        double _t4 = _axisx * _axisy;
        double _t6 = _axisy * _axisz;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t11 * _t2))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisx * _axisx, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(_axisz * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(_axisx * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t11 * _t4))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisz * _axisz, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(_axisy * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t11 * _t6)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAxis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && axis.isNative()) return preRotateAxis_fma_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return preRotateAxis_fma_api(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        long _axisBase = axis.address() + axisOffset;
        double _axisy = UnsafeOpsHolder.U.getDouble(_axisBase + 8L);
        double _axisx = UnsafeOpsHolder.U.getDouble(_axisBase + 0L);
        double _axisz = UnsafeOpsHolder.U.getDouble(_axisBase + 16L);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = _axisx * _axisz;
        double _t4 = _axisx * _axisy;
        double _t6 = _axisy * _axisz;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t11 * _t2)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisx * _axisx, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(_axisz * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(_axisx * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t11 * _t4)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisz * _axisz, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(_axisy * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t11 * _t6)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        double _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, axisOffset + 8L);
        double _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, axisOffset + 0L);
        double _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, axisOffset + 16L);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = _axisx * _axisz;
        double _t4 = _axisx * _axisy;
        double _t6 = _axisy * _axisz;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t11 * _t2)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisx * _axisx, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(_axisz * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(_axisx * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t11 * _t4)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisz * _axisz, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(_axisy * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t11 * _t6)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && axis.isNative()) return preRotateAxis_mulAdd_unsafe(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return preRotateAxis_mulAdd_api(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        long _axisBase = axis.address() + axisOffset;
        double _axisy = UnsafeOpsHolder.U.getDouble(_axisBase + 8L);
        double _axisx = UnsafeOpsHolder.U.getDouble(_axisBase + 0L);
        double _axisz = UnsafeOpsHolder.U.getDouble(_axisBase + 16L);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = _axisx * _axisz;
        double _t4 = _axisx * _axisy;
        double _t6 = _axisy * _axisz;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t11 * _t2))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisx * _axisx, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(_axisz * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(_axisx * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t11 * _t4))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisz * _axisz, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(_axisy * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t11 * _t6)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateAxis_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, double angle) {
        double _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, axisOffset + 8L);
        double _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, axisOffset + 0L);
        double _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, axisOffset + 16L);
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        double _t2 = _axisx * _axisz;
        double _t4 = _axisx * _axisy;
        double _t6 = _axisy * _axisz;
        double _t11 = 1.0 - _t1;
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t11 * _t2))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisx * _axisx, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, -(_axisz * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t6, -(_axisx * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t11 * _t4))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _axisz * _axisz, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t2, -(_axisy * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t11 * _t6)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateQuat(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    public static double[] preRotateQuat_fma(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = -qY;
        double _t2 = -qX;
        double _t3 = qX + qX;
        double _t4 = qY + qY;
        double _t5 = qZ + qZ;
        double _t6 = qW * _t4;
        double _t7 = qW * _t5;
        double _t8 = qW * _t3;
        double _t12 = Math.fma(-qZ, _t5, 1.0);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, _t6)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, -_t7)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, -_t8)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, _t7)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, -_t6)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, _t8)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateQuat_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = -qY;
        double _t2 = -qX;
        double _t3 = qX + qX;
        double _t4 = qY + qY;
        double _t5 = qZ + qZ;
        double _t6 = qW * _t4;
        double _t7 = qW * _t5;
        double _t8 = qW * _t3;
        double _t12 = Math.fma(-qZ, _t5, 1.0);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, _t6))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, -_t7)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, -_t8))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, _t7))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, -_t6))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, _t8)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateQuat(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double qX, double qY, double qZ, double qW) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = -qY;
        double _t2 = -qX;
        double _t3 = qX + qX;
        double _t4 = qY + qY;
        double _t5 = qZ + qZ;
        double _t6 = qW * _t4;
        double _t7 = qW * _t5;
        double _t8 = qW * _t3;
        double _t12 = Math.fma(-qZ, _t5, 1.0);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, _t6)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, -_t7)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, -_t8)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, _t7)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, -_t6)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, _t8)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = -qY;
        double _t2 = -qX;
        double _t3 = qX + qX;
        double _t4 = qY + qY;
        double _t5 = qZ + qZ;
        double _t6 = qW * _t4;
        double _t7 = qW * _t5;
        double _t8 = qW * _t3;
        double _t12 = Math.fma(-qZ, _t5, 1.0);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, _t6))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, -_t7)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, -_t8))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qY, _t3, _t7))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t3, -_t6))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(qZ, _t4, _t8)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateQuat(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, q, qOffset);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static double[] preRotateQuat_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        double _qz = q[qOffset + 2];
        double _qy = q[qOffset + 1];
        double _qx = q[qOffset + 0];
        double _qw = q[qOffset + 3];
        double _t0 = -_qy;
        double _t2 = -_qx;
        double _t3 = _qx + _qx;
        double _t4 = _qy + _qy;
        double _t5 = _qz + _qz;
        double _t6 = _qw * _t4;
        double _t7 = _qw * _t5;
        double _t8 = _qw * _t3;
        double _t12 = Math.fma(-_qz, _t5, 1.0);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, _t6)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, -_t7)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, -_t8)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, _t7)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, -_t6)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, _t8)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateQuat_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        double _qz = q[qOffset + 2];
        double _qy = q[qOffset + 1];
        double _qx = q[qOffset + 0];
        double _qw = q[qOffset + 3];
        double _t0 = -_qy;
        double _t2 = -_qx;
        double _t3 = _qx + _qx;
        double _t4 = _qy + _qy;
        double _t5 = _qz + _qz;
        double _t6 = _qw * _t4;
        double _t7 = _qw * _t5;
        double _t8 = _qw * _t3;
        double _t12 = Math.fma(-_qz, _t5, 1.0);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, _t6))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, -_t7)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, -_t8))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, _t7))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, -_t6))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, _t8)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateQuat(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, q, qOffset);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && q.isNative()) return preRotateQuat_fma_unsafe(dest, destOffset, src, srcOffset, q, qOffset);
        return preRotateQuat_fma_api(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        long _qBase = q.address() + qOffset;
        double _qz = UnsafeOpsHolder.U.getDouble(_qBase + 16L);
        double _qy = UnsafeOpsHolder.U.getDouble(_qBase + 8L);
        double _qx = UnsafeOpsHolder.U.getDouble(_qBase + 0L);
        double _qw = UnsafeOpsHolder.U.getDouble(_qBase + 24L);
        double _t0 = -_qy;
        double _t2 = -_qx;
        double _t3 = _qx + _qx;
        double _t4 = _qy + _qy;
        double _t5 = _qz + _qz;
        double _t6 = _qw * _t4;
        double _t7 = _qw * _t5;
        double _t8 = _qw * _t3;
        double _t12 = Math.fma(-_qz, _t5, 1.0);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, _t6)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, -_t7)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, -_t8)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, _t7)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, -_t6)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, _t8)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        double _qz = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 16L);
        double _qy = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 8L);
        double _qx = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 0L);
        double _qw = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 24L);
        double _t0 = -_qy;
        double _t2 = -_qx;
        double _t3 = _qx + _qx;
        double _t4 = _qy + _qy;
        double _t5 = _qz + _qz;
        double _t6 = _qw * _t4;
        double _t7 = _qw * _t5;
        double _t8 = _qw * _t3;
        double _t12 = Math.fma(-_qz, _t5, 1.0);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, _t6)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, -_t7)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, -_t8)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, _t7)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, -_t6)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, _t8)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && q.isNative()) return preRotateQuat_mulAdd_unsafe(dest, destOffset, src, srcOffset, q, qOffset);
        return preRotateQuat_mulAdd_api(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        long _qBase = q.address() + qOffset;
        double _qz = UnsafeOpsHolder.U.getDouble(_qBase + 16L);
        double _qy = UnsafeOpsHolder.U.getDouble(_qBase + 8L);
        double _qx = UnsafeOpsHolder.U.getDouble(_qBase + 0L);
        double _qw = UnsafeOpsHolder.U.getDouble(_qBase + 24L);
        double _t0 = -_qy;
        double _t2 = -_qx;
        double _t3 = _qx + _qx;
        double _t4 = _qy + _qy;
        double _t5 = _qz + _qz;
        double _t6 = _qw * _t4;
        double _t7 = _qw * _t5;
        double _t8 = _qw * _t3;
        double _t12 = Math.fma(-_qz, _t5, 1.0);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, _t6))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, -_t7)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, -_t8))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, _t7))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, -_t6))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, _t8)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateQuat_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        double _qz = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 16L);
        double _qy = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 8L);
        double _qx = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 0L);
        double _qw = q.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, qOffset + 24L);
        double _t0 = -_qy;
        double _t2 = -_qx;
        double _t3 = _qx + _qx;
        double _t4 = _qy + _qy;
        double _t5 = _qz + _qz;
        double _t6 = _qw * _t4;
        double _t7 = _qw * _t5;
        double _t8 = _qw * _t3;
        double _t12 = Math.fma(-_qz, _t5, 1.0);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, _t6))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t4, _t12))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, -_t7)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, -_t8))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qy, _t3, _t7))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, _t12)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, Math.fma(_t0, _t4, 1.0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t3, -_t6))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_qz, _t4, _t8)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateX(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateX_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateX_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static double[] preRotateX_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(_sv1));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateX_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(_sv1));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateX(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateX_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateX_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static java.lang.foreign.MemorySegment preRotateX_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _c1 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(_sv1));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateX_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _c1 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(_sv1));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateY(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateY_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateY_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static double[] preRotateY_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv2.fma(_sv1, _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateY_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv2.mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateY(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateY_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateY_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static java.lang.foreign.MemorySegment preRotateY_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c2 = _sv2.fma(_sv1, _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateY_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c2 = _sv2.mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preRotateZ(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateZ_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateZ_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static double[] preRotateZ_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(_sv1));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateZ_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(_sv1));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateZ_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateZ_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static java.lang.foreign.MemorySegment preRotateZ_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(_sv1));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateZ_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angle) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cosFromSin(_t0, angle);
        var _sv0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t1);
        var _sv2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder());
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t0)));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(_sv1));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preScale(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(DoubleVector.broadcast(SIMD_SPECIES, vX));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(DoubleVector.broadcast(SIMD_SPECIES, vY));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(DoubleVector.broadcast(SIMD_SPECIES, vZ));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScale(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, vX));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, vY));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, vZ));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preScale(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 0]));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 1]));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 2]));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScale(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && v.isNative()) return preScale_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return preScale_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static java.lang.foreign.MemorySegment preScale_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _vBase = v.address() + vOffset;
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_vBase + 0L)));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_vBase + 8L)));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_vBase + 16L)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScale_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 0L)));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 8L)));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.broadcast(SIMD_SPECIES, v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 16L)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preScale(double[] dest, int destOffset, double[] src, int srcOffset, double s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, s).mul(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScale(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, s).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
    }

    public static double[] preScaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv1.withLane(3, pivotX * _t0));
        var _c1 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv1.withLane(3, pivotY * _t0));
        var _c2 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv1.withLane(3, pivotZ * _t0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv1.withLane(3, pivotX * _t0));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv1.withLane(3, pivotY * _t0));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv1.withLane(3, pivotZ * _t0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, pivotX * _t0));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, pivotY * _t0));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, pivotZ * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, pivotX * _t0));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, pivotY * _t0));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, pivotZ * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static double[] preScaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv1.withLane(3, pivot[pivotOffset + 0] * _t0));
        var _c1 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv1.withLane(3, pivot[pivotOffset + 1] * _t0));
        var _c2 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv1.withLane(3, pivot[pivotOffset + 2] * _t0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv1.withLane(3, pivot[pivotOffset + 0] * _t0));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv1.withLane(3, pivot[pivotOffset + 1] * _t0));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv1.withLane(3, pivot[pivotOffset + 2] * _t0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && pivot.isNative()) return preScaleAround_fma_unsafe(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return preScaleAround_fma_api(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        long _pivotBase = pivot.address() + pivotOffset;
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * _t0));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * _t0));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * _t0));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * _t0));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && pivot.isNative()) return preScaleAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return preScaleAround_mulAdd_api(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        long _pivotBase = pivot.address() + pivotOffset;
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * _t0));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * _t0));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        double _t0 = 1.0 - s;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * _t0));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * _t0));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static double[] preScaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, sX).fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv0.withLane(3, pivotX * (1.0 - sX)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, sY).fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv0.withLane(3, pivotY * (1.0 - sY)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, sZ).fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv0.withLane(3, pivotZ * (1.0 - sZ)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, sX).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv0.withLane(3, pivotX * (1.0 - sX)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, sY).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv0.withLane(3, pivotY * (1.0 - sY)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, sZ).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv0.withLane(3, pivotZ * (1.0 - sZ)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, sX).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, pivotX * (1.0 - sX)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, sY).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, pivotY * (1.0 - sY)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, sZ).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, pivotZ * (1.0 - sZ)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, sX).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, pivotX * (1.0 - sX)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, sY).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, pivotY * (1.0 - sY)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, sZ).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, pivotZ * (1.0 - sZ)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static double[] preScaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv0.withLane(3, pivot[pivotOffset + 0] * (1.0 - _sx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv0.withLane(3, pivot[pivotOffset + 1] * (1.0 - _sy)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv0.withLane(3, pivot[pivotOffset + 2] * (1.0 - _sz)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv0.withLane(3, pivot[pivotOffset + 0] * (1.0 - _sx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv0.withLane(3, pivot[pivotOffset + 1] * (1.0 - _sy)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv0.withLane(3, pivot[pivotOffset + 2] * (1.0 - _sz)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && s.isNative() && pivot.isNative()) return preScaleAround_fma_unsafe(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return preScaleAround_fma_api(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _sBase = s.address() + sOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _sx = UnsafeOpsHolder.U.getDouble(_sBase + 0L);
        double _sy = UnsafeOpsHolder.U.getDouble(_sBase + 8L);
        double _sz = UnsafeOpsHolder.U.getDouble(_sBase + 16L);
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * (1.0 - _sx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * (1.0 - _sy)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * (1.0 - _sz)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _sx = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 0L);
        double _sy = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 8L);
        double _sz = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 16L);
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * (1.0 - _sx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * (1.0 - _sy)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv0.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * (1.0 - _sz)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && s.isNative() && pivot.isNative()) return preScaleAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return preScaleAround_mulAdd_api(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _sBase = s.address() + sOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _sx = UnsafeOpsHolder.U.getDouble(_sBase + 0L);
        double _sy = UnsafeOpsHolder.U.getDouble(_sBase + 8L);
        double _sz = UnsafeOpsHolder.U.getDouble(_sBase + 16L);
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * (1.0 - _sx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * (1.0 - _sy)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * (1.0 - _sz)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preScaleAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _sx = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 0L);
        double _sy = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 8L);
        double _sz = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 16L);
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * (1.0 - _sx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * (1.0 - _sy)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv0.withLane(3, pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * (1.0 - _sz)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preTranslate(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).add(_sv0.withLane(3, vX));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).add(_sv0.withLane(3, vY));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).add(_sv0.withLane(3, vZ));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preTranslate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, vX));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, vY));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, vZ));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] preTranslate(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).add(_sv0.withLane(3, v[vOffset + 0]));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).add(_sv0.withLane(3, v[vOffset + 1]));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).add(_sv0.withLane(3, v[vOffset + 2]));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preTranslate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && v.isNative()) return preTranslate_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return preTranslate_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static java.lang.foreign.MemorySegment preTranslate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _vBase = v.address() + vOffset;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_vBase + 0L)));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_vBase + 8L)));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, UnsafeOpsHolder.U.getDouble(_vBase + 16L)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment preTranslate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 0L)));
        var _c1 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 8L)));
        var _c2 = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).add(_sv0.withLane(3, v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 16L)));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] reflect(double[] dest, int destOffset, double[] src, int srcOffset, double normalX, double normalY, double normalZ) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
    }

    public static double[] reflect_fma(double[] dest, int destOffset, double[] src, int srcOffset, double normalX, double normalY, double normalZ) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t2 = -_self22;
        double _t9 = (normalX + normalX) * normalZ;
        double _t10 = (normalX + normalX) * normalY;
        double _t11 = (normalY + normalY) * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] reflect_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double normalX, double normalY, double normalZ) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t2 = -_self22;
        double _t9 = (normalX + normalX) * normalZ;
        double _t10 = (normalX + normalX) * normalY;
        double _t11 = (normalY + normalY) * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
    }

    public static java.lang.foreign.MemorySegment reflect_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return reflect_fma_unsafe(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
        return reflect_fma_api(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
    }

    public static java.lang.foreign.MemorySegment reflect_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        long _srcBase = src.address() + srcOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t2 = -_self22;
        double _t9 = (normalX + normalX) * normalZ;
        double _t10 = (normalX + normalX) * normalY;
        double _t11 = (normalY + normalY) * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t2 = -_self22;
        double _t9 = (normalX + normalX) * normalZ;
        double _t10 = (normalX + normalX) * normalY;
        double _t11 = (normalY + normalY) * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return reflect_mulAdd_unsafe(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
        return reflect_mulAdd_api(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
    }

    public static java.lang.foreign.MemorySegment reflect_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        long _srcBase = src.address() + srcOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t2 = -_self22;
        double _t9 = (normalX + normalX) * normalZ;
        double _t10 = (normalX + normalX) * normalY;
        double _t11 = (normalY + normalY) * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double normalX, double normalY, double normalZ) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t2 = -_self22;
        double _t9 = (normalX + normalX) * normalZ;
        double _t10 = (normalX + normalX) * normalY;
        double _t11 = (normalY + normalY) * normalZ;
        double _t12 = Math.fma(-2.0, normalX * normalX, 1.0);
        double _t13 = Math.fma(-2.0, normalY * normalY, 1.0);
        double _t14 = Math.fma(-2.0, normalZ * normalZ, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] reflect(double[] dest, int destOffset, double[] src, int srcOffset, double[] normal, int normalOffset) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normal, normalOffset);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normal, normalOffset);
    }

    public static double[] reflect_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] normal, int normalOffset) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _normalx = normal[normalOffset + 0];
        double _normalz = normal[normalOffset + 2];
        double _normaly = normal[normalOffset + 1];
        double _t2 = -_self22;
        double _t9 = (_normalx + _normalx) * _normalz;
        double _t10 = (_normalx + _normalx) * _normaly;
        double _t11 = (_normaly + _normaly) * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] reflect_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] normal, int normalOffset) {
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self12 = src[srcOffset + 6];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _normalx = normal[normalOffset + 0];
        double _normalz = normal[normalOffset + 2];
        double _normaly = normal[normalOffset + 1];
        double _t2 = -_self22;
        double _t9 = (_normalx + _normalx) * _normalz;
        double _t10 = (_normalx + _normalx) * _normaly;
        double _t11 = (_normaly + _normaly) * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normal, normalOffset);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normal, normalOffset);
    }

    public static java.lang.foreign.MemorySegment reflect_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && normal.isNative()) return reflect_fma_unsafe(dest, destOffset, src, srcOffset, normal, normalOffset);
        return reflect_fma_api(dest, destOffset, src, srcOffset, normal, normalOffset);
    }

    public static java.lang.foreign.MemorySegment reflect_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        long _srcBase = src.address() + srcOffset;
        long _normalBase = normal.address() + normalOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _normalx = UnsafeOpsHolder.U.getDouble(_normalBase + 0L);
        double _normalz = UnsafeOpsHolder.U.getDouble(_normalBase + 16L);
        double _normaly = UnsafeOpsHolder.U.getDouble(_normalBase + 8L);
        double _t2 = -_self22;
        double _t9 = (_normalx + _normalx) * _normalz;
        double _t10 = (_normalx + _normalx) * _normaly;
        double _t11 = (_normaly + _normaly) * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _normalx = normal.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, normalOffset + 0L);
        double _normalz = normal.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, normalOffset + 16L);
        double _normaly = normal.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, normalOffset + 8L);
        double _t2 = -_self22;
        double _t9 = (_normalx + _normalx) * _normalz;
        double _t10 = (_normalx + _normalx) * _normaly;
        double _t11 = (_normaly + _normaly) * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && normal.isNative()) return reflect_mulAdd_unsafe(dest, destOffset, src, srcOffset, normal, normalOffset);
        return reflect_mulAdd_api(dest, destOffset, src, srcOffset, normal, normalOffset);
    }

    public static java.lang.foreign.MemorySegment reflect_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        long _srcBase = src.address() + srcOffset;
        long _normalBase = normal.address() + normalOffset;
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _normalx = UnsafeOpsHolder.U.getDouble(_normalBase + 0L);
        double _normalz = UnsafeOpsHolder.U.getDouble(_normalBase + 16L);
        double _normaly = UnsafeOpsHolder.U.getDouble(_normalBase + 8L);
        double _t2 = -_self22;
        double _t9 = (_normalx + _normalx) * _normalz;
        double _t10 = (_normalx + _normalx) * _normaly;
        double _t11 = (_normaly + _normaly) * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment reflect_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment normal, long normalOffset) {
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _normalx = normal.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, normalOffset + 0L);
        double _normalz = normal.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, normalOffset + 16L);
        double _normaly = normal.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, normalOffset + 8L);
        double _t2 = -_self22;
        double _t9 = (_normalx + _normalx) * _normalz;
        double _t10 = (_normalx + _normalx) * _normaly;
        double _t11 = (_normaly + _normaly) * _normalz;
        double _t12 = Math.fma(-2.0, _normalx * _normalx, 1.0);
        double _t13 = Math.fma(-2.0, _normaly * _normaly, 1.0);
        double _t14 = Math.fma(-2.0, _normalz * _normalz, 1.0);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L));
        var _c2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] rotateAround(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static double[] rotateAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = -rotY;
        double _t2 = -rotX;
        double _t3 = -pivotZ;
        double _t5 = rotX + rotX;
        double _t6 = rotY + rotY;
        double _t7 = rotZ + rotZ;
        double _t8 = rotW * _t6;
        double _t9 = rotW * _t7;
        double _t10 = rotW * _t5;
        double _t11 = rotZ * _t7;
        double _t16 = Math.fma(-rotZ, _t7, 1.0);
        double _t18 = Math.fma(rotY, _t5, _t9);
        double _t19 = Math.fma(rotZ, _t6, _t10);
        double _t20 = Math.fma(rotZ, _t5, _t8);
        double _t24 = Math.fma(rotZ, _t5, -_t8);
        double _t25 = Math.fma(rotY, _t5, -_t9);
        double _t26 = Math.fma(rotZ, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(pivotX, Math.fma(rotY, _t6, _t11), -(pivotY * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(pivotY, Math.fma(rotX, _t5, _t11), -(pivotX * _t18)));
        double _t41 = Math.fma(-pivotY, _t19, Math.fma(pivotZ, Math.fma(rotX, _t5, rotY * _t6), -(pivotX * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.fma(_sv1, _sv2.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv4, _sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.fma(_sv1, _sv2.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv4, _sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.fma(_sv1, _sv2.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv4, _sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] rotateAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = -rotY;
        double _t2 = -rotX;
        double _t3 = -pivotZ;
        double _t5 = rotX + rotX;
        double _t6 = rotY + rotY;
        double _t7 = rotZ + rotZ;
        double _t8 = rotW * _t6;
        double _t9 = rotW * _t7;
        double _t10 = rotW * _t5;
        double _t11 = rotZ * _t7;
        double _t16 = Math.fma(-rotZ, _t7, 1.0);
        double _t18 = Math.fma(rotY, _t5, _t9);
        double _t19 = Math.fma(rotZ, _t6, _t10);
        double _t20 = Math.fma(rotZ, _t5, _t8);
        double _t24 = Math.fma(rotZ, _t5, -_t8);
        double _t25 = Math.fma(rotY, _t5, -_t9);
        double _t26 = Math.fma(rotZ, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(pivotX, Math.fma(rotY, _t6, _t11), -(pivotY * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(pivotY, Math.fma(rotX, _t5, _t11), -(pivotX * _t18)));
        double _t41 = Math.fma(-pivotY, _t19, Math.fma(pivotZ, Math.fma(rotX, _t5, rotY * _t6), -(pivotX * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.mul(_sv1).add(_sv2.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv4).add(_sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.mul(_sv1).add(_sv2.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv4).add(_sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.mul(_sv1).add(_sv2.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv4).add(_sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment rotateAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return rotateAround_fma_unsafe(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_fma_api(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment rotateAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _srcBase = src.address() + srcOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t0 = -rotY;
        double _t2 = -rotX;
        double _t3 = -pivotZ;
        double _t5 = rotX + rotX;
        double _t6 = rotY + rotY;
        double _t7 = rotZ + rotZ;
        double _t8 = rotW * _t6;
        double _t9 = rotW * _t7;
        double _t10 = rotW * _t5;
        double _t11 = rotZ * _t7;
        double _t16 = Math.fma(-rotZ, _t7, 1.0);
        double _t18 = Math.fma(rotY, _t5, _t9);
        double _t19 = Math.fma(rotZ, _t6, _t10);
        double _t20 = Math.fma(rotZ, _t5, _t8);
        double _t24 = Math.fma(rotZ, _t5, -_t8);
        double _t25 = Math.fma(rotY, _t5, -_t9);
        double _t26 = Math.fma(rotZ, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(pivotX, Math.fma(rotY, _t6, _t11), -(pivotY * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(pivotY, Math.fma(rotX, _t5, _t11), -(pivotX * _t18)));
        double _t41 = Math.fma(-pivotY, _t19, Math.fma(pivotZ, Math.fma(rotX, _t5, rotY * _t6), -(pivotX * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv4, _sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv4, _sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv4, _sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t0 = -rotY;
        double _t2 = -rotX;
        double _t3 = -pivotZ;
        double _t5 = rotX + rotX;
        double _t6 = rotY + rotY;
        double _t7 = rotZ + rotZ;
        double _t8 = rotW * _t6;
        double _t9 = rotW * _t7;
        double _t10 = rotW * _t5;
        double _t11 = rotZ * _t7;
        double _t16 = Math.fma(-rotZ, _t7, 1.0);
        double _t18 = Math.fma(rotY, _t5, _t9);
        double _t19 = Math.fma(rotZ, _t6, _t10);
        double _t20 = Math.fma(rotZ, _t5, _t8);
        double _t24 = Math.fma(rotZ, _t5, -_t8);
        double _t25 = Math.fma(rotY, _t5, -_t9);
        double _t26 = Math.fma(rotZ, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(pivotX, Math.fma(rotY, _t6, _t11), -(pivotY * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(pivotY, Math.fma(rotX, _t5, _t11), -(pivotX * _t18)));
        double _t41 = Math.fma(-pivotY, _t19, Math.fma(pivotZ, Math.fma(rotX, _t5, rotY * _t6), -(pivotX * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.fma(_sv1, _sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv4, _sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.fma(_sv1, _sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv4, _sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.fma(_sv1, _sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv4, _sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return rotateAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_mulAdd_api(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment rotateAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _srcBase = src.address() + srcOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t0 = -rotY;
        double _t2 = -rotX;
        double _t3 = -pivotZ;
        double _t5 = rotX + rotX;
        double _t6 = rotY + rotY;
        double _t7 = rotZ + rotZ;
        double _t8 = rotW * _t6;
        double _t9 = rotW * _t7;
        double _t10 = rotW * _t5;
        double _t11 = rotZ * _t7;
        double _t16 = Math.fma(-rotZ, _t7, 1.0);
        double _t18 = Math.fma(rotY, _t5, _t9);
        double _t19 = Math.fma(rotZ, _t6, _t10);
        double _t20 = Math.fma(rotZ, _t5, _t8);
        double _t24 = Math.fma(rotZ, _t5, -_t8);
        double _t25 = Math.fma(rotY, _t5, -_t9);
        double _t26 = Math.fma(rotZ, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(pivotX, Math.fma(rotY, _t6, _t11), -(pivotY * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(pivotY, Math.fma(rotX, _t5, _t11), -(pivotX * _t18)));
        double _t41 = Math.fma(-pivotY, _t19, Math.fma(pivotZ, Math.fma(rotX, _t5, rotY * _t6), -(pivotX * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv4).add(_sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv4).add(_sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv4).add(_sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t0 = -rotY;
        double _t2 = -rotX;
        double _t3 = -pivotZ;
        double _t5 = rotX + rotX;
        double _t6 = rotY + rotY;
        double _t7 = rotZ + rotZ;
        double _t8 = rotW * _t6;
        double _t9 = rotW * _t7;
        double _t10 = rotW * _t5;
        double _t11 = rotZ * _t7;
        double _t16 = Math.fma(-rotZ, _t7, 1.0);
        double _t18 = Math.fma(rotY, _t5, _t9);
        double _t19 = Math.fma(rotZ, _t6, _t10);
        double _t20 = Math.fma(rotZ, _t5, _t8);
        double _t24 = Math.fma(rotZ, _t5, -_t8);
        double _t25 = Math.fma(rotY, _t5, -_t9);
        double _t26 = Math.fma(rotZ, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(pivotX, Math.fma(rotY, _t6, _t11), -(pivotY * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(pivotY, Math.fma(rotX, _t5, _t11), -(pivotX * _t18)));
        double _t41 = Math.fma(-pivotY, _t19, Math.fma(pivotZ, Math.fma(rotX, _t5, rotY * _t6), -(pivotX * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.mul(_sv1).add(_sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv4).add(_sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.mul(_sv1).add(_sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv4).add(_sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.mul(_sv1).add(_sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv4).add(_sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] rotateAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static double[] rotateAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _roty = rot[rotOffset + 1];
        double _rotx = rot[rotOffset + 0];
        double _pivotz = pivot[pivotOffset + 2];
        double _rotz = rot[rotOffset + 2];
        double _rotw = rot[rotOffset + 3];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _t0 = -_roty;
        double _t2 = -_rotx;
        double _t3 = -_pivotz;
        double _t5 = _rotx + _rotx;
        double _t6 = _roty + _roty;
        double _t7 = _rotz + _rotz;
        double _t8 = _rotw * _t6;
        double _t9 = _rotw * _t7;
        double _t10 = _rotw * _t5;
        double _t11 = _rotz * _t7;
        double _t16 = Math.fma(-_rotz, _t7, 1.0);
        double _t18 = Math.fma(_roty, _t5, _t9);
        double _t19 = Math.fma(_rotz, _t6, _t10);
        double _t20 = Math.fma(_rotz, _t5, _t8);
        double _t24 = Math.fma(_rotz, _t5, -_t8);
        double _t25 = Math.fma(_roty, _t5, -_t9);
        double _t26 = Math.fma(_rotz, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(_pivotx, Math.fma(_roty, _t6, _t11), -(_pivoty * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(_pivoty, Math.fma(_rotx, _t5, _t11), -(_pivotx * _t18)));
        double _t41 = Math.fma(-_pivoty, _t19, Math.fma(_pivotz, Math.fma(_rotx, _t5, _roty * _t6), -(_pivotx * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.fma(_sv1, _sv2.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv4, _sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.fma(_sv1, _sv2.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv4, _sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.fma(_sv1, _sv2.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv4, _sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] rotateAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self10 = src[srcOffset + 4];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _roty = rot[rotOffset + 1];
        double _rotx = rot[rotOffset + 0];
        double _pivotz = pivot[pivotOffset + 2];
        double _rotz = rot[rotOffset + 2];
        double _rotw = rot[rotOffset + 3];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _t0 = -_roty;
        double _t2 = -_rotx;
        double _t3 = -_pivotz;
        double _t5 = _rotx + _rotx;
        double _t6 = _roty + _roty;
        double _t7 = _rotz + _rotz;
        double _t8 = _rotw * _t6;
        double _t9 = _rotw * _t7;
        double _t10 = _rotw * _t5;
        double _t11 = _rotz * _t7;
        double _t16 = Math.fma(-_rotz, _t7, 1.0);
        double _t18 = Math.fma(_roty, _t5, _t9);
        double _t19 = Math.fma(_rotz, _t6, _t10);
        double _t20 = Math.fma(_rotz, _t5, _t8);
        double _t24 = Math.fma(_rotz, _t5, -_t8);
        double _t25 = Math.fma(_roty, _t5, -_t9);
        double _t26 = Math.fma(_rotz, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(_pivotx, Math.fma(_roty, _t6, _t11), -(_pivoty * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(_pivoty, Math.fma(_rotx, _t5, _t11), -(_pivotx * _t18)));
        double _t41 = Math.fma(-_pivoty, _t19, Math.fma(_pivotz, Math.fma(_rotx, _t5, _roty * _t6), -(_pivotx * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.mul(_sv1).add(_sv2.withLane(3, src[srcOffset + 3])).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv4).add(_sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.mul(_sv1).add(_sv2.withLane(3, src[srcOffset + 7])).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv4).add(_sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.mul(_sv1).add(_sv2.withLane(3, src[srcOffset + 11])).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv4).add(_sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment rotateAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && rot.isNative() && pivot.isNative()) return rotateAround_fma_unsafe(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return rotateAround_fma_api(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment rotateAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _srcBase = src.address() + srcOffset;
        long _rotBase = rot.address() + rotOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _roty = UnsafeOpsHolder.U.getDouble(_rotBase + 8L);
        double _rotx = UnsafeOpsHolder.U.getDouble(_rotBase + 0L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L);
        double _rotz = UnsafeOpsHolder.U.getDouble(_rotBase + 16L);
        double _rotw = UnsafeOpsHolder.U.getDouble(_rotBase + 24L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L);
        double _t0 = -_roty;
        double _t2 = -_rotx;
        double _t3 = -_pivotz;
        double _t5 = _rotx + _rotx;
        double _t6 = _roty + _roty;
        double _t7 = _rotz + _rotz;
        double _t8 = _rotw * _t6;
        double _t9 = _rotw * _t7;
        double _t10 = _rotw * _t5;
        double _t11 = _rotz * _t7;
        double _t16 = Math.fma(-_rotz, _t7, 1.0);
        double _t18 = Math.fma(_roty, _t5, _t9);
        double _t19 = Math.fma(_rotz, _t6, _t10);
        double _t20 = Math.fma(_rotz, _t5, _t8);
        double _t24 = Math.fma(_rotz, _t5, -_t8);
        double _t25 = Math.fma(_roty, _t5, -_t9);
        double _t26 = Math.fma(_rotz, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(_pivotx, Math.fma(_roty, _t6, _t11), -(_pivoty * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(_pivoty, Math.fma(_rotx, _t5, _t11), -(_pivotx * _t18)));
        double _t41 = Math.fma(-_pivoty, _t19, Math.fma(_pivotz, Math.fma(_rotx, _t5, _roty * _t6), -(_pivotx * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv4, _sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv4, _sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.fma(_sv1, _sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv4, _sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _roty = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 8L);
        double _rotx = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 0L);
        double _pivotz = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L);
        double _rotz = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 16L);
        double _rotw = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 24L);
        double _pivotx = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L);
        double _pivoty = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L);
        double _t0 = -_roty;
        double _t2 = -_rotx;
        double _t3 = -_pivotz;
        double _t5 = _rotx + _rotx;
        double _t6 = _roty + _roty;
        double _t7 = _rotz + _rotz;
        double _t8 = _rotw * _t6;
        double _t9 = _rotw * _t7;
        double _t10 = _rotw * _t5;
        double _t11 = _rotz * _t7;
        double _t16 = Math.fma(-_rotz, _t7, 1.0);
        double _t18 = Math.fma(_roty, _t5, _t9);
        double _t19 = Math.fma(_rotz, _t6, _t10);
        double _t20 = Math.fma(_rotz, _t5, _t8);
        double _t24 = Math.fma(_rotz, _t5, -_t8);
        double _t25 = Math.fma(_roty, _t5, -_t9);
        double _t26 = Math.fma(_rotz, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(_pivotx, Math.fma(_roty, _t6, _t11), -(_pivoty * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(_pivoty, Math.fma(_rotx, _t5, _t11), -(_pivotx * _t18)));
        double _t41 = Math.fma(-_pivoty, _t19, Math.fma(_pivotz, Math.fma(_rotx, _t5, _roty * _t6), -(_pivotx * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.fma(_sv1, _sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self02).fma(_sv4, _sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.fma(_sv1, _sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self12).fma(_sv4, _sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.fma(_sv1, _sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv3, DoubleVector.broadcast(SIMD_SPECIES, _self22).fma(_sv4, _sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && rot.isNative() && pivot.isNative()) return rotateAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return rotateAround_mulAdd_api(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment rotateAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _srcBase = src.address() + srcOffset;
        long _rotBase = rot.address() + rotOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _self00 = UnsafeOpsHolder.U.getDouble(_srcBase + 0L);
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self10 = UnsafeOpsHolder.U.getDouble(_srcBase + 32L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self20 = UnsafeOpsHolder.U.getDouble(_srcBase + 64L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _roty = UnsafeOpsHolder.U.getDouble(_rotBase + 8L);
        double _rotx = UnsafeOpsHolder.U.getDouble(_rotBase + 0L);
        double _pivotz = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L);
        double _rotz = UnsafeOpsHolder.U.getDouble(_rotBase + 16L);
        double _rotw = UnsafeOpsHolder.U.getDouble(_rotBase + 24L);
        double _pivotx = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L);
        double _pivoty = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L);
        double _t0 = -_roty;
        double _t2 = -_rotx;
        double _t3 = -_pivotz;
        double _t5 = _rotx + _rotx;
        double _t6 = _roty + _roty;
        double _t7 = _rotz + _rotz;
        double _t8 = _rotw * _t6;
        double _t9 = _rotw * _t7;
        double _t10 = _rotw * _t5;
        double _t11 = _rotz * _t7;
        double _t16 = Math.fma(-_rotz, _t7, 1.0);
        double _t18 = Math.fma(_roty, _t5, _t9);
        double _t19 = Math.fma(_rotz, _t6, _t10);
        double _t20 = Math.fma(_rotz, _t5, _t8);
        double _t24 = Math.fma(_rotz, _t5, -_t8);
        double _t25 = Math.fma(_roty, _t5, -_t9);
        double _t26 = Math.fma(_rotz, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(_pivotx, Math.fma(_roty, _t6, _t11), -(_pivoty * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(_pivoty, Math.fma(_rotx, _t5, _t11), -(_pivotx * _t18)));
        double _t41 = Math.fma(-_pivoty, _t19, Math.fma(_pivotz, Math.fma(_rotx, _t5, _roty * _t6), -(_pivotx * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv4).add(_sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv4).add(_sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.mul(_sv1).add(_sv2.withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv4).add(_sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment rot, long rotOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _self00 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L);
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self10 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self20 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _roty = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 8L);
        double _rotx = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 0L);
        double _pivotz = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L);
        double _rotz = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 16L);
        double _rotw = rot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, rotOffset + 24L);
        double _pivotx = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L);
        double _pivoty = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L);
        double _t0 = -_roty;
        double _t2 = -_rotx;
        double _t3 = -_pivotz;
        double _t5 = _rotx + _rotx;
        double _t6 = _roty + _roty;
        double _t7 = _rotz + _rotz;
        double _t8 = _rotw * _t6;
        double _t9 = _rotw * _t7;
        double _t10 = _rotw * _t5;
        double _t11 = _rotz * _t7;
        double _t16 = Math.fma(-_rotz, _t7, 1.0);
        double _t18 = Math.fma(_roty, _t5, _t9);
        double _t19 = Math.fma(_rotz, _t6, _t10);
        double _t20 = Math.fma(_rotz, _t5, _t8);
        double _t24 = Math.fma(_rotz, _t5, -_t8);
        double _t25 = Math.fma(_roty, _t5, -_t9);
        double _t26 = Math.fma(_rotz, _t6, -_t10);
        double _t27 = Math.fma(_t0, _t6, _t16);
        double _t28 = Math.fma(_t2, _t5, _t16);
        double _t29 = Math.fma(_t2, _t5, Math.fma(_t0, _t6, 1.0));
        double _t39 = Math.fma(_t3, _t20, Math.fma(_pivotx, Math.fma(_roty, _t6, _t11), -(_pivoty * _t25)));
        double _t40 = Math.fma(_t3, _t26, Math.fma(_pivoty, Math.fma(_rotx, _t5, _t11), -(_pivotx * _t18)));
        double _t41 = Math.fma(-_pivoty, _t19, Math.fma(_pivotz, Math.fma(_rotx, _t5, _roty * _t6), -(_pivotx * _t24)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t27).withLane(1, _t25).withLane(2, _t20);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t28).withLane(2, _t26).withLane(3, _t39);
        var _sv4 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t24).withLane(1, _t19).withLane(2, _t29);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv6 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = _sv0.mul(_sv1).add(_sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv4).add(_sv2.withLane(3, _self01 * _t40 + _self02 * _t41))));
        var _c1 = _sv5.mul(_sv1).add(_sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv4).add(_sv2.withLane(3, _self11 * _t40 + _self12 * _t41))));
        var _c2 = _sv6.mul(_sv1).add(_sv2.withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv3).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv4).add(_sv2.withLane(3, _self21 * _t40 + _self22 * _t41))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] rotateYXZ(double[] dest, int destOffset, double[] src, int srcOffset, double angleY, double angleX, double angleZ) {
        if (SimdSupport.USE_FMA) return rotateYXZ_fma(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
        return rotateYXZ_mulAdd(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
    }

    public static double[] rotateYXZ_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angleY, double angleX, double angleZ) {
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cosFromSin(_t1, angleY);
        double _t4 = Math.cosFromSin(_t2, angleZ);
        double _t5 = Math.cosFromSin(_t0, angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t12 = _t1 * _t5;
        double _t16 = _t5 * _t4;
        double _t17 = _t5 * _t3;
        double _t18 = Math.fma(_t6, _t2, _t3 * _t4);
        double _t19 = Math.fma(_t8, _t4, _t1 * _t2);
        double _t20 = Math.fma(_t8, _t2, -(_t1 * _t4));
        double _t21 = Math.fma(_t6, _t4, -(_t2 * _t3));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t17 - _self01 * _t0)).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t17 - _self11 * _t0)).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t17 - _self21 * _t0)).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] rotateYXZ_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angleY, double angleX, double angleZ) {
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cosFromSin(_t1, angleY);
        double _t4 = Math.cosFromSin(_t2, angleZ);
        double _t5 = Math.cosFromSin(_t0, angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t12 = _t1 * _t5;
        double _t16 = _t5 * _t4;
        double _t17 = _t5 * _t3;
        double _t18 = Math.fma(_t6, _t2, _t3 * _t4);
        double _t19 = Math.fma(_t8, _t4, _t1 * _t2);
        double _t20 = Math.fma(_t8, _t2, -(_t1 * _t4));
        double _t21 = Math.fma(_t6, _t4, -(_t2 * _t3));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t17 - _self01 * _t0)).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t17 - _self11 * _t0)).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t17 - _self21 * _t0)).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYXZ(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        if (SimdSupport.USE_FMA) return rotateYXZ_fma(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
        return rotateYXZ_mulAdd(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return rotateYXZ_fma_unsafe(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
        return rotateYXZ_fma_api(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        long _srcBase = src.address() + srcOffset;
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cosFromSin(_t1, angleY);
        double _t4 = Math.cosFromSin(_t2, angleZ);
        double _t5 = Math.cosFromSin(_t0, angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t12 = _t1 * _t5;
        double _t16 = _t5 * _t4;
        double _t17 = _t5 * _t3;
        double _t18 = Math.fma(_t6, _t2, _t3 * _t4);
        double _t19 = Math.fma(_t8, _t4, _t1 * _t2);
        double _t20 = Math.fma(_t8, _t2, -(_t1 * _t4));
        double _t21 = Math.fma(_t6, _t4, -(_t2 * _t3));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t17 - _self01 * _t0)).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 32L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t17 - _self11 * _t0)).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 64L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t17 - _self21 * _t0)).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cosFromSin(_t1, angleY);
        double _t4 = Math.cosFromSin(_t2, angleZ);
        double _t5 = Math.cosFromSin(_t0, angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t12 = _t1 * _t5;
        double _t16 = _t5 * _t4;
        double _t17 = _t5 * _t3;
        double _t18 = Math.fma(_t6, _t2, _t3 * _t4);
        double _t19 = Math.fma(_t8, _t4, _t1 * _t2);
        double _t20 = Math.fma(_t8, _t2, -(_t1 * _t4));
        double _t21 = Math.fma(_t6, _t4, -(_t2 * _t3));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t17 - _self01 * _t0)).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t17 - _self11 * _t0)).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L)).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t17 - _self21 * _t0)).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return rotateYXZ_mulAdd_unsafe(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
        return rotateYXZ_mulAdd_api(dest, destOffset, src, srcOffset, angleY, angleX, angleZ);
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        long _srcBase = src.address() + srcOffset;
        double _self01 = UnsafeOpsHolder.U.getDouble(_srcBase + 8L);
        double _self02 = UnsafeOpsHolder.U.getDouble(_srcBase + 16L);
        double _self11 = UnsafeOpsHolder.U.getDouble(_srcBase + 40L);
        double _self12 = UnsafeOpsHolder.U.getDouble(_srcBase + 48L);
        double _self21 = UnsafeOpsHolder.U.getDouble(_srcBase + 72L);
        double _self22 = UnsafeOpsHolder.U.getDouble(_srcBase + 80L);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cosFromSin(_t1, angleY);
        double _t4 = Math.cosFromSin(_t2, angleZ);
        double _t5 = Math.cosFromSin(_t0, angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t12 = _t1 * _t5;
        double _t16 = _t5 * _t4;
        double _t17 = _t5 * _t3;
        double _t18 = Math.fma(_t6, _t2, _t3 * _t4);
        double _t19 = Math.fma(_t8, _t4, _t1 * _t2);
        double _t20 = Math.fma(_t8, _t2, -(_t1 * _t4));
        double _t21 = Math.fma(_t6, _t4, -(_t2 * _t3));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t17 - _self01 * _t0)).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 32L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t17 - _self11 * _t0)).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, UnsafeOpsHolder.U.getDouble(_srcBase + 64L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t17 - _self21 * _t0)).withLane(3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double angleY, double angleX, double angleZ) {
        double _self01 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L);
        double _self02 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L);
        double _self11 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L);
        double _self12 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L);
        double _self21 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L);
        double _self22 = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L);
        double _t0 = Math.sin(angleX);
        double _t1 = Math.sin(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.cosFromSin(_t1, angleY);
        double _t4 = Math.cosFromSin(_t2, angleZ);
        double _t5 = Math.cosFromSin(_t0, angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t12 = _t1 * _t5;
        double _t16 = _t5 * _t4;
        double _t17 = _t5 * _t3;
        double _t18 = Math.fma(_t6, _t2, _t3 * _t4);
        double _t19 = Math.fma(_t8, _t4, _t1 * _t2);
        double _t20 = Math.fma(_t8, _t2, -(_t1 * _t4));
        double _t21 = Math.fma(_t6, _t4, -(_t2 * _t3));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t17 - _self01 * _t0)).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t17 - _self11 * _t0)).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L)).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t16).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t17 - _self21 * _t0)).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] scale(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return scale_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static double[] scale_fma(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 3]));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] scale_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 3]));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return scale_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static java.lang.foreign.MemorySegment scale_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return scale_fma_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return scale_fma_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static java.lang.foreign.MemorySegment scale_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        long _srcBase = src.address() + srcOffset;
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return scale_mulAdd_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return scale_mulAdd_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static java.lang.foreign.MemorySegment scale_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        long _srcBase = src.address() + srcOffset;
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] scale(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return scale_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static double[] scale_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 3]));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] scale_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 3]));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return scale_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static java.lang.foreign.MemorySegment scale_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && v.isNative()) return scale_fma_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return scale_fma_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static java.lang.foreign.MemorySegment scale_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _srcBase = src.address() + srcOffset;
        long _vBase = v.address() + vOffset;
        double _vx = UnsafeOpsHolder.U.getDouble(_vBase + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(_vBase + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(_vBase + 16L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        double _vx = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 0L);
        double _vy = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 8L);
        double _vz = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 16L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz), DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && v.isNative()) return scale_mulAdd_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return scale_mulAdd_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static java.lang.foreign.MemorySegment scale_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _srcBase = src.address() + srcOffset;
        long _vBase = v.address() + vOffset;
        double _vx = UnsafeOpsHolder.U.getDouble(_vBase + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(_vBase + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(_vBase + 16L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        double _vx = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 0L);
        double _vy = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 8L);
        double _vz = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 16L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] scale(double[] dest, int destOffset, double[] src, int srcOffset, double s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, s).mul(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return scale_unsafe(dest, destOffset, src, srcOffset, s);
        return scale_api(dest, destOffset, src, srcOffset, s);
    }

    public static java.lang.foreign.MemorySegment scale_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s) {
        long _srcBase = src.address() + srcOffset;
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, s).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder())).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 24L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment scale_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, s).mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder())).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 24L));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = 1.0 - s;
        double _t1 = pivotX * _t0;
        double _t2 = pivotY * _t0;
        double _t3 = pivotZ * _t0;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(src[srcOffset + 0], _t1, Math.fma(src[srcOffset + 1], _t2, Math.fma(src[srcOffset + 2], _t3, src[srcOffset + 3]))));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(src[srcOffset + 4], _t1, Math.fma(src[srcOffset + 5], _t2, Math.fma(src[srcOffset + 6], _t3, src[srcOffset + 7]))));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(src[srcOffset + 8], _t1, Math.fma(src[srcOffset + 9], _t2, Math.fma(src[srcOffset + 10], _t3, src[srcOffset + 11]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return scaleAround_unsafe(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
        return scaleAround_api(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment scaleAround_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _srcBase = src.address() + srcOffset;
        double _t0 = 1.0 - s;
        double _t1 = pivotX * _t0;
        double _t2 = pivotY * _t0;
        double _t3 = pivotZ * _t0;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 0L), _t1, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 8L), _t2, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 16L), _t3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L)))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 32L), _t1, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 40L), _t2, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 48L), _t3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L)))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 64L), _t1, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 72L), _t2, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 80L), _t3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = 1.0 - s;
        double _t1 = pivotX * _t0;
        double _t2 = pivotY * _t0;
        double _t3 = pivotZ * _t0;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L), _t1, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L), _t2, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L), _t3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L)))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L), _t1, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L), _t2, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L), _t3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L)))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L), _t1, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L), _t2, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L), _t3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _t0 = 1.0 - s;
        double _t1 = pivot[pivotOffset + 0] * _t0;
        double _t2 = pivot[pivotOffset + 1] * _t0;
        double _t3 = pivot[pivotOffset + 2] * _t0;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(src[srcOffset + 0], _t1, Math.fma(src[srcOffset + 1], _t2, Math.fma(src[srcOffset + 2], _t3, src[srcOffset + 3]))));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(src[srcOffset + 4], _t1, Math.fma(src[srcOffset + 5], _t2, Math.fma(src[srcOffset + 6], _t3, src[srcOffset + 7]))));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(src[srcOffset + 8], _t1, Math.fma(src[srcOffset + 9], _t2, Math.fma(src[srcOffset + 10], _t3, src[srcOffset + 11]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && pivot.isNative()) return scaleAround_unsafe(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return scaleAround_api(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static java.lang.foreign.MemorySegment scaleAround_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        long _srcBase = src.address() + srcOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _t0 = 1.0 - s;
        double _t1 = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * _t0;
        double _t2 = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * _t0;
        double _t3 = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * _t0;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 0L), _t1, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 8L), _t2, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 16L), _t3, UnsafeOpsHolder.U.getDouble(_srcBase + 24L)))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 32L), _t1, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 40L), _t2, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 48L), _t3, UnsafeOpsHolder.U.getDouble(_srcBase + 56L)))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 64L), _t1, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 72L), _t2, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 80L), _t3, UnsafeOpsHolder.U.getDouble(_srcBase + 88L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset, double s) {
        double _t0 = 1.0 - s;
        double _t1 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * _t0;
        double _t2 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * _t0;
        double _t3 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * _t0;
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L), _t1, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L), _t2, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L), _t3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L)))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L), _t1, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L), _t2, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L), _t3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L)))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L), _t1, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L), _t2, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L), _t3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L)))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static double[] scaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _t3 = pivotX * (1.0 - sX);
        double _t4 = pivotY * (1.0 - sY);
        double _t5 = pivotZ * (1.0 - sZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv1.withLane(3, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))));
        var _c1 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv1.withLane(3, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))));
        var _c2 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv1.withLane(3, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _t3 = pivotX * (1.0 - sX);
        double _t4 = pivotY * (1.0 - sY);
        double _t5 = pivotZ * (1.0 - sZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv1.withLane(3, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv1.withLane(3, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv1.withLane(3, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment scaleAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return scaleAround_fma_unsafe(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_fma_api(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment scaleAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _srcBase = src.address() + srcOffset;
        double _t3 = pivotX * (1.0 - sX);
        double _t4 = pivotY * (1.0 - sY);
        double _t5 = pivotZ * (1.0 - sZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 0L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 8L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 16L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))))));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 32L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 40L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 48L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))))));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 64L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 72L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 80L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _t3 = pivotX * (1.0 - sX);
        double _t4 = pivotY * (1.0 - sY);
        double _t5 = pivotZ * (1.0 - sZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))))));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))))));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return scaleAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd_api(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static java.lang.foreign.MemorySegment scaleAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _srcBase = src.address() + srcOffset;
        double _t3 = pivotX * (1.0 - sX);
        double _t4 = pivotY * (1.0 - sY);
        double _t5 = pivotZ * (1.0 - sZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 0L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 8L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 16L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 32L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 40L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 48L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 64L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 72L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 80L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _t3 = pivotX * (1.0 - sX);
        double _t4 = pivotY * (1.0 - sY);
        double _t5 = pivotZ * (1.0 - sZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static double[] scaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        double _t3 = pivot[pivotOffset + 0] * (1.0 - _sx);
        double _t4 = pivot[pivotOffset + 1] * (1.0 - _sy);
        double _t5 = pivot[pivotOffset + 2] * (1.0 - _sz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv1.withLane(3, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))));
        var _c1 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv1.withLane(3, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))));
        var _c2 = _sv0.fma(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv1.withLane(3, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        double _t3 = pivot[pivotOffset + 0] * (1.0 - _sx);
        double _t4 = pivot[pivotOffset + 1] * (1.0 - _sy);
        double _t5 = pivot[pivotOffset + 2] * (1.0 - _sz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv1.withLane(3, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv1.withLane(3, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv1.withLane(3, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment scaleAround_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && s.isNative() && pivot.isNative()) return scaleAround_fma_unsafe(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return scaleAround_fma_api(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment scaleAround_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _srcBase = src.address() + srcOffset;
        long _sBase = s.address() + sOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _sx = UnsafeOpsHolder.U.getDouble(_sBase + 0L);
        double _sy = UnsafeOpsHolder.U.getDouble(_sBase + 8L);
        double _sz = UnsafeOpsHolder.U.getDouble(_sBase + 16L);
        double _t3 = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * (1.0 - _sx);
        double _t4 = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * (1.0 - _sy);
        double _t5 = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * (1.0 - _sz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 0L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 8L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 16L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))))));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 32L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 40L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 48L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))))));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 64L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 72L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 80L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _sx = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 0L);
        double _sy = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 8L);
        double _sz = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 16L);
        double _t3 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * (1.0 - _sx);
        double _t4 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * (1.0 - _sy);
        double _t5 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * (1.0 - _sz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))))));
        var _c1 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))))));
        var _c2 = _sv0.fma(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()), _sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && s.isNative() && pivot.isNative()) return scaleAround_mulAdd_unsafe(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return scaleAround_mulAdd_api(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static java.lang.foreign.MemorySegment scaleAround_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        long _srcBase = src.address() + srcOffset;
        long _sBase = s.address() + sOffset;
        long _pivotBase = pivot.address() + pivotOffset;
        double _sx = UnsafeOpsHolder.U.getDouble(_sBase + 0L);
        double _sy = UnsafeOpsHolder.U.getDouble(_sBase + 8L);
        double _sz = UnsafeOpsHolder.U.getDouble(_sBase + 16L);
        double _t3 = UnsafeOpsHolder.U.getDouble(_pivotBase + 0L) * (1.0 - _sx);
        double _t4 = UnsafeOpsHolder.U.getDouble(_pivotBase + 8L) * (1.0 - _sy);
        double _t5 = UnsafeOpsHolder.U.getDouble(_pivotBase + 16L) * (1.0 - _sz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 0L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 8L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 16L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 24L))))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 32L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 40L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 48L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 56L))))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 64L), _t3, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 72L), _t4, Math.fma(UnsafeOpsHolder.U.getDouble(_srcBase + 80L), _t5, UnsafeOpsHolder.U.getDouble(_srcBase + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment scaleAround_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment s, long sOffset, java.lang.foreign.MemorySegment pivot, long pivotOffset) {
        double _sx = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 0L);
        double _sy = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 8L);
        double _sz = s.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, sOffset + 16L);
        double _t3 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 0L) * (1.0 - _sx);
        double _t4 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 8L) * (1.0 - _sy);
        double _t5 = pivot.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, pivotOffset + 16L) * (1.0 - _sz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        var _c0 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 0L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 8L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 16L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 24L))))));
        var _c1 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 32L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 40L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 48L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 56L))))));
        var _c2 = _sv0.mul(DoubleVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder())).add(_sv1.withLane(3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 64L), _t3, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 72L), _t4, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 80L), _t5, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + 88L))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        _c1.intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
        _c2.intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static double[] translate(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 0] * vX + (src[(srcOffset + _li * 4) + 1] * vY + src[(srcOffset + _li * 4) + 2] * vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment translate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return translate_unsafe(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return translate_api(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static java.lang.foreign.MemorySegment translate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        long _srcBase = src.address() + srcOffset;
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 0L) * vX + (UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L) * vY + UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 16L) * vZ)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment translate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 0L) * vX + (src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L) * vY + src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 16L) * vZ)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static double[] translate(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src[(srcOffset + _li * 4) + 0] * _vx + (src[(srcOffset + _li * 4) + 1] * _vy + src[(srcOffset + _li * 4) + 2] * _vz)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment translate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && v.isNative()) return translate_unsafe(dest, destOffset, src, srcOffset, v, vOffset);
        return translate_api(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static java.lang.foreign.MemorySegment translate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _srcBase = src.address() + srcOffset;
        long _vBase = v.address() + vOffset;
        double _vx = UnsafeOpsHolder.U.getDouble(_vBase + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(_vBase + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(_vBase + 16L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 0L) * _vx + (UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 8L) * _vy + UnsafeOpsHolder.U.getDouble((_srcBase + _li * 32L) + 16L) * _vz)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment translate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        double _vx = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 0L);
        double _vy = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 8L);
        double _vz = v.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, vOffset + 16L);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromMemorySegment(SIMD_SPECIES, src, (srcOffset + _li * 32L), java.nio.ByteOrder.nativeOrder()).add(DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 0L) * _vx + (src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 8L) * _vy + src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, (srcOffset + _li * 32L) + 16L) * _vz)));
            _c.intoMemorySegment(dest, destOffset + _li * 32L, java.nio.ByteOrder.nativeOrder());
        }
        return dest;
    }

    private static void copyArrArr(double[] dest, int destOffset, double[] src, int srcOffset, int n) {
        var _sp = DoubleVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            DoubleVector.fromArray(_sp, src, srcOffset + _i).intoArray(dest, destOffset + _i);
        for (; _i <= n - 4; _i += 4)
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + _i).intoArray(dest, destOffset + _i);
        for (; _i < n; _i++)
            dest[destOffset + _i] = src[srcOffset + _i];
    }

    private static void copyArrSeg(double[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int n) {
        var _sp = DoubleVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            DoubleVector.fromMemorySegment(_sp, src, srcOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + _i);
        for (; _i <= n - 4; _i += 4)
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + _i);
        for (; _i < n; _i++)
            dest[destOffset + _i] = src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + (long) _i * 8L);
    }

    private static void copySegArr(java.lang.foreign.MemorySegment dest, long destOffset, double[] src, int srcOffset, int n) {
        var _sp = DoubleVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            DoubleVector.fromArray(_sp, src, srcOffset + _i).intoMemorySegment(dest, destOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder());
        for (; _i <= n - 4; _i += 4)
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + _i).intoMemorySegment(dest, destOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder());
        for (; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, destOffset + (long) _i * 8L, src[srcOffset + _i]);
    }

    private static void copySegSeg(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int n) {
        var _sp = DoubleVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            DoubleVector.fromMemorySegment(_sp, src, srcOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder());
        for (; _i <= n - 4; _i += 4)
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + (long) _i * 8L, java.nio.ByteOrder.nativeOrder());
        for (; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, destOffset + (long) _i * 8L, src.get(java.lang.foreign.ValueLayout.JAVA_DOUBLE_UNALIGNED, srcOffset + (long) _i * 8L));
    }

    private static void copyArrArr_one(double[] dest, int destOffset, double[] src, int srcOffset) {
        if (PREFERRED_LANES >= 8) {
            DoubleVector.fromArray(DoubleVector.SPECIES_512, src, srcOffset).intoArray(dest, destOffset);
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + 8).intoArray(dest, destOffset + 8);
        }
        else if (PREFERRED_LANES >= 4) {
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset).intoArray(dest, destOffset);
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + 4).intoArray(dest, destOffset + 4);
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + 8).intoArray(dest, destOffset + 8);
        }
        else {
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset).intoArray(dest, destOffset);
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 2).intoArray(dest, destOffset + 2);
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 4).intoArray(dest, destOffset + 4);
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 6).intoArray(dest, destOffset + 6);
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 8).intoArray(dest, destOffset + 8);
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 10).intoArray(dest, destOffset + 10);
        }
    }

    private static void copyArrSeg_one(double[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (PREFERRED_LANES >= 8) {
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_512, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 8);
        }
        else if (PREFERRED_LANES >= 4) {
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 4);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 8);
        }
        else {
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 16L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 2);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 4);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 48L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 6);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 8);
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 80L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + 10);
        }
    }

    private static void copySegArr_one(java.lang.foreign.MemorySegment dest, long destOffset, double[] src, int srcOffset) {
        if (PREFERRED_LANES >= 8) {
            DoubleVector.fromArray(DoubleVector.SPECIES_512, src, srcOffset).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + 8).intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        }
        else if (PREFERRED_LANES >= 4) {
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + 4).intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset + 8).intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        }
        else {
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 2).intoMemorySegment(dest, destOffset + 16L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 4).intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 6).intoMemorySegment(dest, destOffset + 48L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 8).intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 10).intoMemorySegment(dest, destOffset + 80L, java.nio.ByteOrder.nativeOrder());
        }
    }

    private static void copySegSeg_one(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (PREFERRED_LANES >= 8) {
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_512, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        }
        else if (PREFERRED_LANES >= 4) {
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_256, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
        }
        else {
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 16L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 16L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 32L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 32L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 48L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 48L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 64L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 64L, java.nio.ByteOrder.nativeOrder());
            DoubleVector.fromMemorySegment(DoubleVector.SPECIES_128, src, srcOffset + 80L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + 80L, java.nio.ByteOrder.nativeOrder());
        }
    }


    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset) {
        copyArrArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset, int count) {
        copyArrArr(dest, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray() && srcOffset >= 0 && srcOffset <= src.limit() - 12) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg_one(dest, destOffset, _srcSeg, (long) srcOffset * 8);
        }
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (src.hasArray() && srcOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && srcOffset <= src.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 12);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg(dest, destOffset, _srcSeg, (long) srcOffset * 8, count * 12);
        }
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copyArrSeg_one(dest, destOffset, _srcSeg, srcOffset);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copyArrSeg(dest, destOffset, _srcSeg, srcOffset, count * 12);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        copyArrSeg_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        copyArrSeg(dest, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset) {
        if (dest.hasArray() && destOffset >= 0 && destOffset <= dest.limit() - 12) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr_one(_destArr, _destOff, src, srcOffset);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegArr_one(_destSeg, (long) destOffset * 8, src, srcOffset);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset, int count) {
        if (dest.hasArray() && destOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && destOffset <= dest.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 12);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegArr(_destSeg, (long) destOffset * 8, src, srcOffset, count * 12);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && destOffset >= 0 && destOffset <= dest.limit() - 12) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray() && srcOffset >= 0 && srcOffset <= src.limit() - 12) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr_one(_destArr, _destOff, _srcArr, _srcOff);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copyArrSeg_one(_destArr, _destOff, _srcSeg, (long) srcOffset * 8);
            }
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            if (src.hasArray() && srcOffset >= 0 && srcOffset <= src.limit() - 12) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copySegArr_one(_destSeg, (long) destOffset * 8, _srcArr, _srcOff);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copySegSeg_one(_destSeg, (long) destOffset * 8, _srcSeg, (long) srcOffset * 8);
            }
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (dest.hasArray() && destOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && destOffset <= dest.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray() && srcOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && srcOffset <= src.limit() - (count > 178956970 ? -1 : count * 12)) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr(_destArr, _destOff, _srcArr, _srcOff, count * 12);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copyArrSeg(_destArr, _destOff, _srcSeg, (long) srcOffset * 8, count * 12);
            }
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            if (src.hasArray() && srcOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && srcOffset <= src.limit() - (count > 178956970 ? -1 : count * 12)) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copySegArr(_destSeg, (long) destOffset * 8, _srcArr, _srcOff, count * 12);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copySegSeg(_destSeg, (long) destOffset * 8, _srcSeg, (long) srcOffset * 8, count * 12);
            }
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (dest.hasArray() && destOffset >= 0 && destOffset <= dest.limit() - 12) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg_one(_destArr, _destOff, _srcSeg, srcOffset);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg_one(_destSeg, (long) destOffset * 8, _srcSeg, srcOffset);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (dest.hasArray() && destOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && destOffset <= dest.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg(_destArr, _destOff, _srcSeg, srcOffset, count * 12);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg(_destSeg, (long) destOffset * 8, _srcSeg, srcOffset, count * 12);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (dest.hasArray() && destOffset >= 0 && destOffset <= dest.limit() - 12) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrSeg_one(_destArr, _destOff, src, srcOffset);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegSeg_one(_destSeg, (long) destOffset * 8, src, srcOffset);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (dest.hasArray() && destOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && destOffset <= dest.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrSeg(_destArr, _destOff, src, srcOffset, count * 12);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegSeg(_destSeg, (long) destOffset * 8, src, srcOffset, count * 12);
        }
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, double[] src, int srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegArr_one(_destSeg, destOffset, src, srcOffset);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, double[] src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegArr(_destSeg, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        if (src.hasArray() && srcOffset >= 0 && srcOffset <= src.limit() - 12) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr_one(_destSeg, destOffset, _srcArr, _srcOff);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg_one(_destSeg, destOffset, _srcSeg, (long) srcOffset * 8);
        }
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        if (src.hasArray() && srcOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && srcOffset <= src.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr(_destSeg, destOffset, _srcArr, _srcOff, count * 12);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg(_destSeg, destOffset, _srcSeg, (long) srcOffset * 8, count * 12);
        }
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copySegSeg_one(_destSeg, destOffset, _srcSeg, srcOffset);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copySegSeg(_destSeg, destOffset, _srcSeg, srcOffset, count * 12);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegSeg_one(_destSeg, destOffset, src, srcOffset);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegSeg(_destSeg, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, double[] src, int srcOffset) {
        copySegArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, double[] src, int srcOffset, int count) {
        copySegArr(dest, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray() && srcOffset >= 0 && srcOffset <= src.limit() - 12) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg_one(dest, destOffset, _srcSeg, (long) srcOffset * 8);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (src.hasArray() && srcOffset >= 0 && (count > 178956970 ? -1 : count * 12) >= 0 && srcOffset <= src.limit() - (count > 178956970 ? -1 : count * 12)) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr(dest, destOffset, _srcArr, _srcOff, count * 12);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg(dest, destOffset, _srcSeg, (long) srcOffset * 8, count * 12);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.ByteBuffer src, int srcOffset) {
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copySegSeg_one(dest, destOffset, _srcSeg, srcOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copySegSeg(dest, destOffset, _srcSeg, srcOffset, count * 12);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        copySegSeg_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        copySegSeg(dest, destOffset, src, srcOffset, count * 12);
        return dest;
    }
}
