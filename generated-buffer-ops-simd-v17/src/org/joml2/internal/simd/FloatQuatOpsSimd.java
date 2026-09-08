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

    public static float[] negate(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] sub(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).sub(FloatVector.fromArray(SIMD_SPECIES, other, otherOffset));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] set(float[] dest, int destOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, v, vOffset);
        _c0.intoArray(dest, destOffset);
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

    public static float[] makeZero(float[] dest, int destOffset) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        _c0.intoArray(dest, destOffset);
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
        var _c0 = (Math.abs(_t8)  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] slerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src[srcOffset + 3], targetW, Math.fma(src[srcOffset + 2], targetZ, Math.fma(src[srcOffset + 0], targetX, src[srcOffset + 1] * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
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
        var _c0 = (Math.abs(_t8)  >  0.0f ? _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] slerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] target, int targetOffset, float alpha) {
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1]))))));
        float _t8 = (float) Math.sin(_t7);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _c0 = (Math.abs(_t8)  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(_t0 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(alpha * _t7)))).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t8)) : FloatVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
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

    public static float[] calculateW(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _selfx = src[srcOffset + 0];
        float _selfy = src[srcOffset + 1];
        float _selfz = src[srcOffset + 2];
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, (float) Math.sqrt(Math.max(0.0f, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0f))))));
        _c0.intoArray(dest, destOffset);
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

    public static float[] normalize(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        float _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t3  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t3)))) : FloatVector.broadcast(SIMD_SPECIES, 0.0f));
        _c0.intoArray(dest, destOffset);
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

    private static void copyArrArr_one(float[] dest, int destOffset, float[] src, int srcOffset) {
        FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset).intoArray(dest, destOffset);
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
            for (int _i = 0; _i < 4; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 4);
        } else {
            for (int _i = 0; _i < count * 4; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, float[] src, int srcOffset) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr_one(_destArr, _destOff, src, srcOffset);
        } else {
            for (int _i = 0; _i < 4; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, float[] src, int srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 4);
        } else {
            for (int _i = 0; _i < count * 4; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
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
                for (int _i = 0; _i < 4; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                for (int _i = 0; _i < 4; _i++)
                    dest.put(destOffset + _i, _srcArr[_srcOff + _i]);
            } else {
                for (int _i = 0; _i < 4; _i++)
                    dest.put(destOffset + _i, src.get(srcOffset + _i));
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
                for (int _i = 0; _i < count * 4; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                for (int _i = 0; _i < count * 4; _i++)
                    dest.put(destOffset + _i, _srcArr[_srcOff + _i]);
            } else {
                for (int _i = 0; _i < count * 4; _i++)
                    dest.put(destOffset + _i, src.get(srcOffset + _i));
            }
        }
        return dest;
    }
}
