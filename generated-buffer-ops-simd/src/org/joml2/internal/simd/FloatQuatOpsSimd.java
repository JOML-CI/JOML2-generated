package org.joml2.internal.simd;

import jdk.incubator.vector.*;
import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Vector-API isolation cell for {@link FloatQuatOps}: every
 * {@code jdk.incubator.vector} reference of the Ops family lives in this class,
 * which is loaded and initialized only behind {@code SimdSupport.VECTOR_API}
 * guards - {@code FloatQuatOps} and its kernel siblings link
 * and run without the incubator module. Not public API.
 */
public final class FloatQuatOpsSimd {
    private FloatQuatOpsSimd() {}
    private static final VectorSpecies<Float> SIMD_SPECIES = FloatVector.SPECIES_128;
    private static final int PREFERRED_LANES = FloatVector.SPECIES_PREFERRED.length();
    private static final FloatVector UNIT_W = FloatVector.fromArray(SIMD_SPECIES, new float[]{0.0f, 0.0f, 0.0f, 1.0f}, 0);

    public static float[] add(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment add(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _c0 = FloatVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder()).add(FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] negate(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment negate(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        var _c0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).neg();
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] sub(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).sub(FloatVector.fromArray(SIMD_SPECIES, other, otherOffset));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment sub(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        var _c0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).sub(FloatVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder()));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] set(float[] dest, int destOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, v, vOffset);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment set(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        var _c0 = FloatVector.fromMemorySegment(SIMD_SPECIES, v, vOffset, java.nio.ByteOrder.nativeOrder());
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeFromMatrixMat3x3(float[] dest, int destOffset, float[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat3x3_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x3_mulAdd(dest, destOffset, m, mOffset);
    }

    public static float[] makeFromMatrixMat3x3_fma(float[] dest, int destOffset, float[] m, int mOffset) {
        float _m00 = m[mOffset + 0];
        float _m11 = m[mOffset + 4];
        float _m22 = m[mOffset + 8];
        float _m21 = m[mOffset + 5];
        float _m12 = m[mOffset + 7];
        float _m01 = m[mOffset + 3];
        float _m10 = m[mOffset + 1];
        float _m02 = m[mOffset + 6];
        float _m20 = m[mOffset + 2];
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeFromMatrixMat3x3_mulAdd(float[] dest, int destOffset, float[] m, int mOffset) {
        float _m00 = m[mOffset + 0];
        float _m11 = m[mOffset + 4];
        float _m22 = m[mOffset + 8];
        float _m21 = m[mOffset + 5];
        float _m12 = m[mOffset + 7];
        float _m01 = m[mOffset + 3];
        float _m10 = m[mOffset + 1];
        float _m02 = m[mOffset + 6];
        float _m20 = m[mOffset + 2];
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat3x3_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x3_mulAdd(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && m.isNative()) return makeFromMatrixMat3x3_fma_unsafe(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x3_fma_api(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _mBase = m.address() + mOffset;
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 16L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 28L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 24L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 28L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 12L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && m.isNative()) return makeFromMatrixMat3x3_mulAdd_unsafe(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x3_mulAdd_api(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _mBase = m.address() + mOffset;
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 16L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 28L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 12L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 24L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 28L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 12L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeFromMatrixMat3x4(float[] dest, int destOffset, float[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat3x4_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x4_mulAdd(dest, destOffset, m, mOffset);
    }

    public static float[] makeFromMatrixMat3x4_fma(float[] dest, int destOffset, float[] m, int mOffset) {
        float _m00 = m[mOffset + 0];
        float _m11 = m[mOffset + 5];
        float _m22 = m[mOffset + 10];
        float _m21 = m[mOffset + 9];
        float _m12 = m[mOffset + 6];
        float _m01 = m[mOffset + 1];
        float _m10 = m[mOffset + 4];
        float _m02 = m[mOffset + 2];
        float _m20 = m[mOffset + 8];
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeFromMatrixMat3x4_mulAdd(float[] dest, int destOffset, float[] m, int mOffset) {
        float _m00 = m[mOffset + 0];
        float _m11 = m[mOffset + 5];
        float _m22 = m[mOffset + 10];
        float _m21 = m[mOffset + 9];
        float _m12 = m[mOffset + 6];
        float _m01 = m[mOffset + 1];
        float _m10 = m[mOffset + 4];
        float _m02 = m[mOffset + 2];
        float _m20 = m[mOffset + 8];
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat3x4_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x4_mulAdd(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && m.isNative()) return makeFromMatrixMat3x4_fma_unsafe(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x4_fma_api(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _mBase = m.address() + mOffset;
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 20L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 40L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 36L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 24L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 4L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 16L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 8L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 32L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 40L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 36L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && m.isNative()) return makeFromMatrixMat3x4_mulAdd_unsafe(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x4_mulAdd_api(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _mBase = m.address() + mOffset;
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 20L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 40L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 36L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 24L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 4L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 16L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 8L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 32L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 40L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 36L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeFromMatrixMat4x4(float[] dest, int destOffset, float[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat4x4_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat4x4_mulAdd(dest, destOffset, m, mOffset);
    }

    public static float[] makeFromMatrixMat4x4_fma(float[] dest, int destOffset, float[] m, int mOffset) {
        float _m00 = m[mOffset + 0];
        float _m11 = m[mOffset + 5];
        float _m22 = m[mOffset + 10];
        float _m21 = m[mOffset + 6];
        float _m12 = m[mOffset + 9];
        float _m01 = m[mOffset + 4];
        float _m10 = m[mOffset + 1];
        float _m02 = m[mOffset + 8];
        float _m20 = m[mOffset + 2];
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeFromMatrixMat4x4_mulAdd(float[] dest, int destOffset, float[] m, int mOffset) {
        float _m00 = m[mOffset + 0];
        float _m11 = m[mOffset + 5];
        float _m22 = m[mOffset + 10];
        float _m21 = m[mOffset + 6];
        float _m12 = m[mOffset + 9];
        float _m01 = m[mOffset + 4];
        float _m10 = m[mOffset + 1];
        float _m02 = m[mOffset + 8];
        float _m20 = m[mOffset + 2];
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat4x4_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat4x4_mulAdd(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && m.isNative()) return makeFromMatrixMat4x4_fma_unsafe(dest, destOffset, m, mOffset);
        return makeFromMatrixMat4x4_fma_api(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _mBase = m.address() + mOffset;
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 20L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 40L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 24L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 36L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 16L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 32L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 40L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 36L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && m.isNative()) return makeFromMatrixMat4x4_mulAdd_unsafe(dest, destOffset, m, mOffset);
        return makeFromMatrixMat4x4_mulAdd_api(dest, destOffset, m, mOffset);
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _mBase = m.address() + mOffset;
        float _m00 = UnsafeOpsHolder.U.getFloat(_mBase + 0L);
        float _m11 = UnsafeOpsHolder.U.getFloat(_mBase + 20L);
        float _m22 = UnsafeOpsHolder.U.getFloat(_mBase + 40L);
        float _m21 = UnsafeOpsHolder.U.getFloat(_mBase + 24L);
        float _m12 = UnsafeOpsHolder.U.getFloat(_mBase + 36L);
        float _m01 = UnsafeOpsHolder.U.getFloat(_mBase + 16L);
        float _m10 = UnsafeOpsHolder.U.getFloat(_mBase + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(_mBase + 32L);
        float _m20 = UnsafeOpsHolder.U.getFloat(_mBase + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 40L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 36L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t4 = _m01 + _m10;
        float _t6 = _m02 + _m20;
        float _t7 = _m02 - _m20;
        float _t8 = _m12 + _m21;
        float _t9 = _m10 - _m01;
        float _t10 = _m22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_m00 - (_m11 + _m22));
        float _t16 = 1.0f + (_m11 - (_m00 + _m22));
        float _t17 = 1.0f + (_m22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeZero(float[] dest, int destOffset) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeZero(java.lang.foreign.MemorySegment dest, long destOffset) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] lerp(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
    }

    public static float[] lerp_fma(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).fma(FloatVector.zero(SIMD_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0), _sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] lerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0)).add(_sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
    }

    public static java.lang.foreign.MemorySegment lerp_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).fma(FloatVector.zero(SIMD_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0), _sv0);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0)).add(_sv0);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] lerp(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    public static float[] lerp_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).fma(FloatVector.fromArray(SIMD_SPECIES, other, otherOffset).sub(_sv0), _sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] lerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).mul(FloatVector.fromArray(SIMD_SPECIES, other, otherOffset).sub(_sv0)).add(_sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, float t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    public static java.lang.foreign.MemorySegment lerp_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, float t) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).fma(FloatVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder()).sub(_sv0), _sv0);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, float t) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, t).mul(FloatVector.fromMemorySegment(SIMD_SPECIES, other, otherOffset, java.nio.ByteOrder.nativeOrder()).sub(_sv0)).add(_sv0);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] nlerp(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return nlerp_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerp_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static float[] nlerp_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, alpha).fma(FloatVector.fromArray(SIMD_SPECIES, target, targetOffset).sub(_sv0), _sv0);
        float _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t11  >  0.0f ? _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t11)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] nlerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, alpha).mul(FloatVector.fromArray(SIMD_SPECIES, target, targetOffset).sub(_sv0)).add(_sv0);
        float _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t11  >  0.0f ? _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t11)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return nlerp_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerp_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment nlerp_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, alpha).fma(FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder()).sub(_sv0), _sv0);
        float _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t11  >  0.0f ? _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t11)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerp_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, alpha).mul(FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder()).sub(_sv0)).add(_sv0);
        float _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t11  >  0.0f ? _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t11)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] nlerpShortest(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return nlerpShortest_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerpShortest_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static float[] nlerpShortest_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, alpha).fma((-Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1])))  >  0.0f ? _sv0.neg() : _sv0).sub(_sv1), _sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0f ? _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] nlerpShortest_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, alpha).mul((-Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1])))  >  0.0f ? _sv0.neg() : _sv0).sub(_sv1)).add(_sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0f ? _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return nlerpShortest_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerpShortest_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return nlerpShortest_fma_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerpShortest_fma_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, alpha).fma((-Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 12L), UnsafeOpsHolder.U.getFloat(_targetBase + 12L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 8L), UnsafeOpsHolder.U.getFloat(_targetBase + 8L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 0L), UnsafeOpsHolder.U.getFloat(_targetBase + 0L), UnsafeOpsHolder.U.getFloat(_srcBase + 4L) * UnsafeOpsHolder.U.getFloat(_targetBase + 4L))))  >  0.0f ? _sv0.neg() : _sv0).sub(_sv1), _sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0f ? _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, alpha).fma((-Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L), src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L) * target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L))))  >  0.0f ? _sv0.neg() : _sv0).sub(_sv1), _sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0f ? _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return nlerpShortest_mulAdd_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerpShortest_mulAdd_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, alpha).mul((-Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 12L), UnsafeOpsHolder.U.getFloat(_targetBase + 12L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 8L), UnsafeOpsHolder.U.getFloat(_targetBase + 8L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 0L), UnsafeOpsHolder.U.getFloat(_targetBase + 0L), UnsafeOpsHolder.U.getFloat(_srcBase + 4L) * UnsafeOpsHolder.U.getFloat(_targetBase + 4L))))  >  0.0f ? _sv0.neg() : _sv0).sub(_sv1)).add(_sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0f ? _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, alpha).mul((-Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L), src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L) * target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L))))  >  0.0f ? _sv0.neg() : _sv0).sub(_sv1)).add(_sv1);
        float _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0f ? _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t24)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] slerp(float[] dest, int destOffset, float[] src, int srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        if (SimdSupport.USE_FMA) return slerp_fma(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return slerp_mulAdd(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    public static float[] slerp_fma(float[] dest, int destOffset, float[] src, int srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src[srcOffset + 3], targetW, Math.fma(src[srcOffset + 2], targetZ, Math.fma(src[srcOffset + 0], targetX, src[srcOffset + 1] * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] slerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src[srcOffset + 3], targetW, Math.fma(src[srcOffset + 2], targetZ, Math.fma(src[srcOffset + 0], targetX, src[srcOffset + 1] * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        if (SimdSupport.USE_FMA) return slerp_fma(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return slerp_mulAdd(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    public static java.lang.foreign.MemorySegment slerp_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return slerp_fma_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return slerp_fma_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    public static java.lang.foreign.MemorySegment slerp_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        long _srcBase = src.address() + srcOffset;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 12L), targetW, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 8L), targetZ, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 0L), targetX, UnsafeOpsHolder.U.getFloat(_srcBase + 4L) * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L), targetW, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L), targetZ, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L), targetX, src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L) * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return slerp_mulAdd_unsafe(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return slerp_mulAdd_api(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    public static java.lang.foreign.MemorySegment slerp_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        long _srcBase = src.address() + srcOffset;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 12L), targetW, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 8L), targetZ, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 0L), targetX, UnsafeOpsHolder.U.getFloat(_srcBase + 4L) * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L), targetW, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L), targetZ, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L), targetX, src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L) * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] slerp(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return slerp_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerp_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static float[] slerp_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1]))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] slerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1]))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return slerp_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerp_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment slerp_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return slerp_fma_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerp_fma_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment slerp_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 12L), UnsafeOpsHolder.U.getFloat(_targetBase + 12L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 8L), UnsafeOpsHolder.U.getFloat(_targetBase + 8L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 0L), UnsafeOpsHolder.U.getFloat(_targetBase + 0L), UnsafeOpsHolder.U.getFloat(_srcBase + 4L) * UnsafeOpsHolder.U.getFloat(_targetBase + 4L)))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L), src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L) * target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L)))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return slerp_mulAdd_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerp_mulAdd_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment slerp_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 12L), UnsafeOpsHolder.U.getFloat(_targetBase + 12L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 8L), UnsafeOpsHolder.U.getFloat(_targetBase + 8L), Math.fma(UnsafeOpsHolder.U.getFloat(_srcBase + 0L), UnsafeOpsHolder.U.getFloat(_targetBase + 0L), UnsafeOpsHolder.U.getFloat(_srcBase + 4L) * UnsafeOpsHolder.U.getFloat(_targetBase + 4L)))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L), Math.fma(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L), target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L), src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L) * target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L)))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _c0 = (Math.abs(_t8)  >  1.0E-6f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] slerpShortest(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return slerpShortest_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerpShortest_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static float[] slerpShortest_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        float _selfw = src[srcOffset + 3];
        float _targetw = target[targetOffset + 3];
        float _selfz = src[srcOffset + 2];
        float _targetz = target[targetOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _targetx = target[targetOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _targety = target[targetOffset + 1];
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv2, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] slerpShortest_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        float _selfw = src[srcOffset + 3];
        float _targetw = target[targetOffset + 3];
        float _selfz = src[srcOffset + 2];
        float _targetz = target[targetOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _targetx = target[targetOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _targety = target[targetOffset + 1];
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv2).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (SimdSupport.USE_FMA) return slerpShortest_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerpShortest_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment slerpShortest_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return slerpShortest_fma_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerpShortest_fma_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment slerpShortest_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _targetw = UnsafeOpsHolder.U.getFloat(_targetBase + 12L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _targetz = UnsafeOpsHolder.U.getFloat(_targetBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _targetx = UnsafeOpsHolder.U.getFloat(_targetBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _targety = UnsafeOpsHolder.U.getFloat(_targetBase + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv2, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv2, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return slerpShortest_mulAdd_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerpShortest_mulAdd_api(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static java.lang.foreign.MemorySegment slerpShortest_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _targetw = UnsafeOpsHolder.U.getFloat(_targetBase + 12L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _targetz = UnsafeOpsHolder.U.getFloat(_targetBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _targetx = UnsafeOpsHolder.U.getFloat(_targetBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _targety = UnsafeOpsHolder.U.getFloat(_targetBase + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv2).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - alpha) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv2).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - alpha))));
        float _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t49)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] calculateW(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, (float) Math.sqrt(Math.max(0.0f, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0f))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment calculateW(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return calculateW_unsafe(dest, destOffset, src, srcOffset);
        return calculateW_api(dest, destOffset, src, srcOffset);
    }

    public static java.lang.foreign.MemorySegment calculateW_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        var _c0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, (float) Math.sqrt(Math.max(0.0f, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0f))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment calculateW_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        var _c0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, (float) Math.sqrt(Math.max(0.0f, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0f))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] difference(float[] dest, int destOffset, float[] src, int srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfw = src[srcOffset + 3];
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _t3_inv = 1.0f / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(otherX, _selfw, -(otherW * _selfx))).withLane(2, Math.fma(otherX, _selfy, -(otherW * _selfz))).add(FloatVector.broadcast(SIMD_SPECIES, Math.fma(otherY, _selfz, -(otherZ * _selfy))).withLane(2, Math.fma(otherZ, _selfw, -(otherY * _selfx)))).withLane(3, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw)))).mul(FloatVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return difference_unsafe(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
        return difference_api(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW);
    }

    public static java.lang.foreign.MemorySegment difference_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _srcBase = src.address() + srcOffset;
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _t3_inv = 1.0f / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(otherX, _selfw, -(otherW * _selfx))).withLane(2, Math.fma(otherX, _selfy, -(otherW * _selfz))).add(FloatVector.broadcast(SIMD_SPECIES, Math.fma(otherY, _selfz, -(otherZ * _selfy))).withLane(2, Math.fma(otherZ, _selfw, -(otherY * _selfx)))).withLane(3, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw)))).mul(FloatVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _t3_inv = 1.0f / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(otherX, _selfw, -(otherW * _selfx))).withLane(2, Math.fma(otherX, _selfy, -(otherW * _selfz))).add(FloatVector.broadcast(SIMD_SPECIES, Math.fma(otherY, _selfz, -(otherZ * _selfy))).withLane(2, Math.fma(otherZ, _selfw, -(otherY * _selfx)))).withLane(3, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw)))).mul(FloatVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] difference(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _otherx = other[otherOffset + 0];
        float _selfw = src[srcOffset + 3];
        float _otherw = other[otherOffset + 3];
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        float _othery = other[otherOffset + 1];
        float _otherz = other[otherOffset + 2];
        float _t3_inv = 1.0f / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_otherx, _selfw, -(_otherw * _selfx))).withLane(2, Math.fma(_otherx, _selfy, -(_otherw * _selfz))).add(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_othery, _selfz, -(_otherz * _selfy))).withLane(2, Math.fma(_otherz, _selfw, -(_othery * _selfx)))).withLane(3, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw)))).mul(FloatVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && other.isNative()) return difference_unsafe(dest, destOffset, src, srcOffset, other, otherOffset);
        return difference_api(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static java.lang.foreign.MemorySegment difference_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        float _otherx = UnsafeOpsHolder.U.getFloat(_otherBase + 0L);
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _otherw = UnsafeOpsHolder.U.getFloat(_otherBase + 12L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _othery = UnsafeOpsHolder.U.getFloat(_otherBase + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(_otherBase + 8L);
        float _t3_inv = 1.0f / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_otherx, _selfw, -(_otherw * _selfx))).withLane(2, Math.fma(_otherx, _selfy, -(_otherw * _selfz))).add(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_othery, _selfz, -(_otherz * _selfy))).withLane(2, Math.fma(_otherz, _selfw, -(_othery * _selfx)))).withLane(3, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw)))).mul(FloatVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _t3_inv = 1.0f / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_otherx, _selfw, -(_otherw * _selfx))).withLane(2, Math.fma(_otherx, _selfy, -(_otherw * _selfz))).add(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_othery, _selfz, -(_otherz * _selfy))).withLane(2, Math.fma(_otherz, _selfw, -(_othery * _selfx)))).withLane(3, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw)))).mul(FloatVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] exp(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfz = src[srcOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _t0 = (float) Math.exp(src[srcOffset + 3]);
        float _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = (float) Math.sqrt(_t3);
        var _c0 = (_t3  >  0.0f ? FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, (float) Math.cos(_t4)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3))).withLane(3, _t0)) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t4) * _t0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment exp(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return exp_unsafe(dest, destOffset, src, srcOffset);
        return exp_api(dest, destOffset, src, srcOffset);
    }

    public static java.lang.foreign.MemorySegment exp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _t0 = (float) Math.exp(UnsafeOpsHolder.U.getFloat(_srcBase + 12L));
        float _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = (float) Math.sqrt(_t3);
        var _c0 = (_t3  >  0.0f ? FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, (float) Math.cos(_t4)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3))).withLane(3, _t0)) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t4) * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment exp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _t0 = (float) Math.exp(src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L));
        float _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = (float) Math.sqrt(_t3);
        var _c0 = (_t3  >  0.0f ? FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).withLane(3, (float) Math.cos(_t4)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3))).withLane(3, _t0)) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t4) * _t0));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] log(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfw = src[srcOffset + 3];
        float _selfz = src[srcOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        var _c0 = (_t2  >  0.0f ? FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2)))).withLane(3, (float) Math.log((float) Math.sqrt(_t4))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.log((float) Math.sqrt(_t4))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment log(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return log_unsafe(dest, destOffset, src, srcOffset);
        return log_api(dest, destOffset, src, srcOffset);
    }

    public static java.lang.foreign.MemorySegment log_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        var _c0 = (_t2  >  0.0f ? FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2)))).withLane(3, (float) Math.log((float) Math.sqrt(_t4))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.log((float) Math.sqrt(_t4))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment log_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        var _c0 = (_t2  >  0.0f ? FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder()).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2)))).withLane(3, (float) Math.log((float) Math.sqrt(_t4))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.log((float) Math.sqrt(_t4))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] normalize(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        float _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t3  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t3)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalize(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        float _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t3  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t3)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] pow(float[] dest, int destOffset, float[] src, int srcOffset, float t) {
        float _selfz = src[srcOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfw = src[srcOffset + 3];
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        float _t11 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t4)));
        float _t12 = (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        float _t19 = t * (_t2 > 0.0f ? _selfz * _t12 : 0.0f);
        float _t20 = t * (_t2 > 0.0f ? _selfx * _t12 : 0.0f);
        float _t21 = t * (_t2 > 0.0f ? _selfy * _t12 : 0.0f);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (float) Math.sqrt(_t24);
        var _c0 = (_t24  >  0.0f ? FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t21).withLane(2, _t19).withLane(3, (float) Math.cos(_t25)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t25) * _t11 * (1.0f / (float) Math.sqrt(_t24))).withLane(3, _t11)) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t25) * _t11));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment pow(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float t) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative()) return pow_unsafe(dest, destOffset, src, srcOffset, t);
        return pow_api(dest, destOffset, src, srcOffset, t);
    }

    public static java.lang.foreign.MemorySegment pow_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float t) {
        long _srcBase = src.address() + srcOffset;
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        float _t11 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t4)));
        float _t12 = (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        float _t19 = t * (_t2 > 0.0f ? _selfz * _t12 : 0.0f);
        float _t20 = t * (_t2 > 0.0f ? _selfx * _t12 : 0.0f);
        float _t21 = t * (_t2 > 0.0f ? _selfy * _t12 : 0.0f);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (float) Math.sqrt(_t24);
        var _c0 = (_t24  >  0.0f ? FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t21).withLane(2, _t19).withLane(3, (float) Math.cos(_t25)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t25) * _t11 * (1.0f / (float) Math.sqrt(_t24))).withLane(3, _t11)) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t25) * _t11));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment pow_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float t) {
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        float _t11 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t4)));
        float _t12 = (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        float _t19 = t * (_t2 > 0.0f ? _selfz * _t12 : 0.0f);
        float _t20 = t * (_t2 > 0.0f ? _selfx * _t12 : 0.0f);
        float _t21 = t * (_t2 > 0.0f ? _selfy * _t12 : 0.0f);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (float) Math.sqrt(_t24);
        var _c0 = (_t24  >  0.0f ? FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t21).withLane(2, _t19).withLane(3, (float) Math.cos(_t25)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t25) * _t11 * (1.0f / (float) Math.sqrt(_t24))).withLane(3, _t11)) : FloatVector.broadcast(SIMD_SPECIES, 0.0f).withLane(3, (float) Math.cos(_t25) * _t11));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] rotateTowards(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float step) {
        if (SimdSupport.USE_FMA) return rotateTowards_fma(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return rotateTowards_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    public static float[] rotateTowards_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float step) {
        float _selfw = src[srcOffset + 3];
        float _targetw = target[targetOffset + 3];
        float _selfz = src[srcOffset + 2];
        float _targetz = target[targetOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _targetx = target[targetOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _targety = target[targetOffset + 1];
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))));
        float _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t53)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] rotateTowards_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float step) {
        float _selfw = src[srcOffset + 3];
        float _targetw = target[targetOffset + 3];
        float _selfz = src[srcOffset + 2];
        float _targetz = target[targetOffset + 2];
        float _selfx = src[srcOffset + 0];
        float _targetx = target[targetOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _targety = target[targetOffset + 1];
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))));
        float _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t53)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        if (SimdSupport.USE_FMA) return rotateTowards_fma(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return rotateTowards_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    public static java.lang.foreign.MemorySegment rotateTowards_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return rotateTowards_fma_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return rotateTowards_fma_api(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    public static java.lang.foreign.MemorySegment rotateTowards_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _targetw = UnsafeOpsHolder.U.getFloat(_targetBase + 12L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _targetz = UnsafeOpsHolder.U.getFloat(_targetBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _targetx = UnsafeOpsHolder.U.getFloat(_targetBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _targety = UnsafeOpsHolder.U.getFloat(_targetBase + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))));
        float _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t53)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))));
        float _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t53)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isNative() && target.isNative()) return rotateTowards_mulAdd_unsafe(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return rotateTowards_mulAdd_api(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    public static java.lang.foreign.MemorySegment rotateTowards_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        float _selfw = UnsafeOpsHolder.U.getFloat(_srcBase + 12L);
        float _targetw = UnsafeOpsHolder.U.getFloat(_targetBase + 12L);
        float _selfz = UnsafeOpsHolder.U.getFloat(_srcBase + 8L);
        float _targetz = UnsafeOpsHolder.U.getFloat(_targetBase + 8L);
        float _selfx = UnsafeOpsHolder.U.getFloat(_srcBase + 0L);
        float _targetx = UnsafeOpsHolder.U.getFloat(_targetBase + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(_srcBase + 4L);
        float _targety = UnsafeOpsHolder.U.getFloat(_targetBase + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))));
        float _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t53)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        var _sv0 = FloatVector.fromMemorySegment(SIMD_SPECIES, src, srcOffset, java.nio.ByteOrder.nativeOrder());
        var _sv1 = FloatVector.fromMemorySegment(SIMD_SPECIES, target, targetOffset, java.nio.ByteOrder.nativeOrder());
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0f ? _sv1.neg() : _sv1);
        var _sv3 = ((float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f)) * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).mul(_sv2)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (float) Math.sin((float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f - (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0f ? Math.min(1.0f, step / (2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0f))));
        float _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0f ? _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t53)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeRotationAxis(float[] dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        if (SimdSupport.USE_FMA) return makeRotationAxis_fma(dest, destOffset, angle, axisX, axisY, axisZ);
        return makeRotationAxis_mulAdd(dest, destOffset, angle, axisX, axisY, axisZ);
    }

    public static float[] makeRotationAxis_fma(float[] dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeRotationAxis_mulAdd(float[] dest, int destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis(java.lang.foreign.MemorySegment dest, long destOffset, float angle, float axisX, float axisY, float axisZ) {
        if (SimdSupport.USE_FMA) return makeRotationAxis_fma(dest, destOffset, angle, axisX, axisY, axisZ);
        return makeRotationAxis_mulAdd(dest, destOffset, angle, axisX, axisY, axisZ);
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_fma(java.lang.foreign.MemorySegment dest, long destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeRotationAxis(float[] dest, int destOffset, float[] axis, int axisOffset, float angle) {
        if (SimdSupport.USE_FMA) return makeRotationAxis_fma(dest, destOffset, axis, axisOffset, angle);
        return makeRotationAxis_mulAdd(dest, destOffset, axis, axisOffset, angle);
    }

    public static float[] makeRotationAxis_fma(float[] dest, int destOffset, float[] axis, int axisOffset, float angle) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, axis[axisOffset + 0]).withLane(1, axis[axisOffset + 1]).withLane(2, axis[axisOffset + 2]).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeRotationAxis_mulAdd(float[] dest, int destOffset, float[] axis, int axisOffset, float angle) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, axis[axisOffset + 0]).withLane(1, axis[axisOffset + 1]).withLane(2, axis[axisOffset + 2]).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        if (SimdSupport.USE_FMA) return makeRotationAxis_fma(dest, destOffset, axis, axisOffset, angle);
        return makeRotationAxis_mulAdd(dest, destOffset, axis, axisOffset, angle);
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && axis.isNative()) return makeRotationAxis_fma_unsafe(dest, destOffset, axis, axisOffset, angle);
        return makeRotationAxis_fma_api(dest, destOffset, axis, axisOffset, angle);
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        long _axisBase = axis.address() + axisOffset;
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, UnsafeOpsHolder.U.getFloat(_axisBase + 0L)).withLane(1, UnsafeOpsHolder.U.getFloat(_axisBase + 4L)).withLane(2, UnsafeOpsHolder.U.getFloat(_axisBase + 8L)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L)).withLane(1, axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L)).withLane(2, axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && axis.isNative()) return makeRotationAxis_mulAdd_unsafe(dest, destOffset, axis, axisOffset, angle);
        return makeRotationAxis_mulAdd_api(dest, destOffset, axis, axisOffset, angle);
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        long _axisBase = axis.address() + axisOffset;
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, UnsafeOpsHolder.U.getFloat(_axisBase + 0L)).withLane(1, UnsafeOpsHolder.U.getFloat(_axisBase + 4L)).withLane(2, UnsafeOpsHolder.U.getFloat(_axisBase + 8L)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        float _t0 = 0.5f * angle;
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(_t0)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L)).withLane(1, axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L)).withLane(2, axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L)).mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeRotationLookAlong(float[] dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return makeRotationLookAlong_fma(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_mulAdd(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    public static float[] makeRotationLookAlong_fma(float[] dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeRotationLookAlong_mulAdd(float[] dest, int destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong(java.lang.foreign.MemorySegment dest, long destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return makeRotationLookAlong_fma(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_mulAdd(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_fma(java.lang.foreign.MemorySegment dest, long destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeRotationLookAlong(float[] dest, int destOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return makeRotationLookAlong_fma(dest, destOffset, dir, dirOffset, up, upOffset);
        return makeRotationLookAlong_mulAdd(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    public static float[] makeRotationLookAlong_fma(float[] dest, int destOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        float _dirz = dir[dirOffset + 2];
        float _dirx = dir[dirOffset + 0];
        float _diry = dir[dirOffset + 1];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeRotationLookAlong_mulAdd(float[] dest, int destOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        float _dirz = dir[dirOffset + 2];
        float _dirx = dir[dirOffset + 0];
        float _diry = dir[dirOffset + 1];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (SimdSupport.USE_FMA) return makeRotationLookAlong_fma(dest, destOffset, dir, dirOffset, up, upOffset);
        return makeRotationLookAlong_mulAdd(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_fma(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dir.isNative() && up.isNative()) return makeRotationLookAlong_fma_unsafe(dest, destOffset, dir, dirOffset, up, upOffset);
        return makeRotationLookAlong_fma_api(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_fma_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _dirBase = dir.address() + dirOffset;
        long _upBase = up.address() + upOffset;
        float _dirz = UnsafeOpsHolder.U.getFloat(_dirBase + 8L);
        float _dirx = UnsafeOpsHolder.U.getFloat(_dirBase + 0L);
        float _diry = UnsafeOpsHolder.U.getFloat(_dirBase + 4L);
        float _upx = UnsafeOpsHolder.U.getFloat(_upBase + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(_upBase + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(_upBase + 8L);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_fma_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        float _dirz = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 8L);
        float _dirx = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 0L);
        float _diry = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 4L);
        float _upx = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 0L);
        float _upy = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 4L);
        float _upz = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 8L);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dir.isNative() && up.isNative()) return makeRotationLookAlong_mulAdd_unsafe(dest, destOffset, dir, dirOffset, up, upOffset);
        return makeRotationLookAlong_mulAdd_api(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_mulAdd_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _dirBase = dir.address() + dirOffset;
        long _upBase = up.address() + upOffset;
        float _dirz = UnsafeOpsHolder.U.getFloat(_dirBase + 8L);
        float _dirx = UnsafeOpsHolder.U.getFloat(_dirBase + 0L);
        float _diry = UnsafeOpsHolder.U.getFloat(_dirBase + 4L);
        float _upx = UnsafeOpsHolder.U.getFloat(_upBase + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(_upBase + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(_upBase + 8L);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_mulAdd_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        float _dirz = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 8L);
        float _dirx = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 0L);
        float _diry = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 4L);
        float _upx = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 0L);
        float _upy = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 4L);
        float _upz = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 8L);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31 = _t26 > 0.0f ? _t22 * _t27 : 0.0f;
        float _t32 = _t26 > 0.0f ? _t21 * _t27 : 0.0f;
        float _t33 = _t26 > 0.0f ? _t23 * _t27 : 0.0f;
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t60)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))).withLane(1, (float) Math.sqrt(_t62))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t63)))).withLane(2, (float) Math.sqrt(_t63))))));
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static float[] makeRotationYXZ(float[] dest, int destOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return makeRotationYXZ_fma(dest, destOffset, angleX, angleY, angleZ);
        return makeRotationYXZ_mulAdd(dest, destOffset, angleX, angleY, angleZ);
    }

    public static float[] makeRotationYXZ_fma(float[] dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        var _c0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).fma(FloatVector.broadcast(SIMD_SPECIES, _t5), FloatVector.broadcast(SIMD_SPECIES, _t10).withLane(3, _t12).mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] makeRotationYXZ_mulAdd(float[] dest, int destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        var _c0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).mul(FloatVector.broadcast(SIMD_SPECIES, _t5)).add(FloatVector.broadcast(SIMD_SPECIES, _t10).withLane(3, _t12).mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationYXZ(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return makeRotationYXZ_fma(dest, destOffset, angleX, angleY, angleZ);
        return makeRotationYXZ_mulAdd(dest, destOffset, angleX, angleY, angleZ);
    }

    public static java.lang.foreign.MemorySegment makeRotationYXZ_fma(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        var _c0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).fma(FloatVector.broadcast(SIMD_SPECIES, _t5), FloatVector.broadcast(SIMD_SPECIES, _t10).withLane(3, _t12).mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationYXZ_mulAdd(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t4;
        float _t12 = _t3 * _t6;
        var _c0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).mul(FloatVector.broadcast(SIMD_SPECIES, _t5)).add(FloatVector.broadcast(SIMD_SPECIES, _t10).withLane(3, _t12).mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _c0.intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
        return dest;
    }

    private static void copyArrArr(float[] dest, int destOffset, float[] src, int srcOffset, int n) {
        var _sp = FloatVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            FloatVector.fromArray(_sp, src, srcOffset + _i).intoArray(dest, destOffset + _i);
        for (; _i <= n - 8; _i += 8)
            FloatVector.fromArray(FloatVector.SPECIES_256, src, srcOffset + _i).intoArray(dest, destOffset + _i);
        for (; _i <= n - 4; _i += 4)
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + _i).intoArray(dest, destOffset + _i);
        for (; _i < n; _i++)
            dest[destOffset + _i] = src[srcOffset + _i];
    }

    private static void copyArrSeg(float[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int n) {
        var _sp = FloatVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            FloatVector.fromMemorySegment(_sp, src, srcOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + _i);
        for (; _i <= n - 8; _i += 8)
            FloatVector.fromMemorySegment(FloatVector.SPECIES_256, src, srcOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + _i);
        for (; _i <= n - 4; _i += 4)
            FloatVector.fromMemorySegment(FloatVector.SPECIES_128, src, srcOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset + _i);
        for (; _i < n; _i++)
            dest[destOffset + _i] = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + (long) _i * 4L);
    }

    private static void copySegArr(java.lang.foreign.MemorySegment dest, long destOffset, float[] src, int srcOffset, int n) {
        var _sp = FloatVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            FloatVector.fromArray(_sp, src, srcOffset + _i).intoMemorySegment(dest, destOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder());
        for (; _i <= n - 8; _i += 8)
            FloatVector.fromArray(FloatVector.SPECIES_256, src, srcOffset + _i).intoMemorySegment(dest, destOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder());
        for (; _i <= n - 4; _i += 4)
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + _i).intoMemorySegment(dest, destOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder());
        for (; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + (long) _i * 4L, src[srcOffset + _i]);
    }

    private static void copySegSeg(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int n) {
        var _sp = FloatVector.SPECIES_PREFERRED;
        int _bound = _sp.loopBound(n);
        int _i = 0;
        for (; _i < _bound; _i += _sp.length())
            FloatVector.fromMemorySegment(_sp, src, srcOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder());
        for (; _i <= n - 8; _i += 8)
            FloatVector.fromMemorySegment(FloatVector.SPECIES_256, src, srcOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder());
        for (; _i <= n - 4; _i += 4)
            FloatVector.fromMemorySegment(FloatVector.SPECIES_128, src, srcOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset + (long) _i * 4L, java.nio.ByteOrder.nativeOrder());
        for (; _i < n; _i++)
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + (long) _i * 4L, src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + (long) _i * 4L));
    }

    private static void copyArrArr_one(float[] dest, int destOffset, float[] src, int srcOffset) {
        FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset).intoArray(dest, destOffset);
    }

    private static void copyArrSeg_one(float[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        FloatVector.fromMemorySegment(FloatVector.SPECIES_128, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoArray(dest, destOffset);
    }

    private static void copySegArr_one(java.lang.foreign.MemorySegment dest, long destOffset, float[] src, int srcOffset) {
        FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
    }

    private static void copySegSeg_one(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        FloatVector.fromMemorySegment(FloatVector.SPECIES_128, src, srcOffset, java.nio.ByteOrder.nativeOrder()).intoMemorySegment(dest, destOffset, java.nio.ByteOrder.nativeOrder());
    }


    public static float[] copy(float[] dest, int destOffset, float[] src, int srcOffset) {
        copyArrArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, float[] src, int srcOffset, int count) {
        copyArrArr(dest, destOffset, src, srcOffset, count * 4);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg_one(dest, destOffset, _srcSeg, (long) srcOffset * 4);
        }
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 4);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg(dest, destOffset, _srcSeg, (long) srcOffset * 4, count * 4);
        }
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copyArrSeg_one(dest, destOffset, _srcSeg, srcOffset);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
        copyArrSeg(dest, destOffset, _srcSeg, srcOffset, count * 4);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        copyArrSeg_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        copyArrSeg(dest, destOffset, src, srcOffset, count * 4);
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, float[] src, int srcOffset) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr_one(_destArr, _destOff, src, srcOffset);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegArr_one(_destSeg, (long) destOffset * 4, src, srcOffset);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, float[] src, int srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 4);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegArr(_destSeg, (long) destOffset * 4, src, srcOffset, count * 4);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr_one(_destArr, _destOff, _srcArr, _srcOff);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copyArrSeg_one(_destArr, _destOff, _srcSeg, (long) srcOffset * 4);
            }
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copySegArr_one(_destSeg, (long) destOffset * 4, _srcArr, _srcOff);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copySegSeg_one(_destSeg, (long) destOffset * 4, _srcSeg, (long) srcOffset * 4);
            }
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr(_destArr, _destOff, _srcArr, _srcOff, count * 4);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copyArrSeg(_destArr, _destOff, _srcSeg, (long) srcOffset * 4, count * 4);
            }
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copySegArr(_destSeg, (long) destOffset * 4, _srcArr, _srcOff, count * 4);
            } else {
                java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
                copySegSeg(_destSeg, (long) destOffset * 4, _srcSeg, (long) srcOffset * 4, count * 4);
            }
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg_one(_destArr, _destOff, _srcSeg, srcOffset);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg_one(_destSeg, (long) destOffset * 4, _srcSeg, srcOffset);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copyArrSeg(_destArr, _destOff, _srcSeg, srcOffset, count * 4);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg(_destSeg, (long) destOffset * 4, _srcSeg, srcOffset, count * 4);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrSeg_one(_destArr, _destOff, src, srcOffset);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegSeg_one(_destSeg, (long) destOffset * 4, src, srcOffset);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrSeg(_destArr, _destOff, src, srcOffset, count * 4);
        } else {
            java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
            copySegSeg(_destSeg, (long) destOffset * 4, src, srcOffset, count * 4);
        }
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, float[] src, int srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegArr_one(_destSeg, destOffset, src, srcOffset);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, float[] src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegArr(_destSeg, destOffset, src, srcOffset, count * 4);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr_one(_destSeg, destOffset, _srcArr, _srcOff);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg_one(_destSeg, destOffset, _srcSeg, (long) srcOffset * 4);
        }
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr(_destSeg, destOffset, _srcArr, _srcOff, count * 4);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg(_destSeg, destOffset, _srcSeg, (long) srcOffset * 4, count * 4);
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
        copySegSeg(_destSeg, destOffset, _srcSeg, srcOffset, count * 4);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegSeg_one(_destSeg, destOffset, src, srcOffset);
        return dest;
    }

    public static java.nio.ByteBuffer copy(java.nio.ByteBuffer dest, int destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        java.lang.foreign.MemorySegment _destSeg = java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0));
        copySegSeg(_destSeg, destOffset, src, srcOffset, count * 4);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, float[] src, int srcOffset) {
        copySegArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, float[] src, int srcOffset, int count) {
        copySegArr(dest, destOffset, src, srcOffset, count * 4);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg_one(dest, destOffset, _srcSeg, (long) srcOffset * 4);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copySegArr(dest, destOffset, _srcArr, _srcOff, count * 4);
        } else {
            java.lang.foreign.MemorySegment _srcSeg = java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0));
            copySegSeg(dest, destOffset, _srcSeg, (long) srcOffset * 4, count * 4);
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
        copySegSeg(dest, destOffset, _srcSeg, srcOffset, count * 4);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        copySegSeg_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static java.lang.foreign.MemorySegment copy(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, int count) {
        copySegSeg(dest, destOffset, src, srcOffset, count * 4);
        return dest;
    }
}
