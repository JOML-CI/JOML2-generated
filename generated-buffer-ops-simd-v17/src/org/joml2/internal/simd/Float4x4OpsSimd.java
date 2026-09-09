package org.joml2.internal.simd;

import jdk.incubator.vector.*;
import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Vector-API isolation cell for {@link Float4x4Ops}: every
 * {@code jdk.incubator.vector} reference of the Ops family lives in this class,
 * which is loaded and initialized only behind {@code SimdSupport.VECTOR_API}
 * guards - {@code Float4x4Ops} and its kernel siblings link
 * and run without the incubator module. Not public API.
 */
public final class Float4x4OpsSimd {
    private Float4x4OpsSimd() {}
    private static final VectorSpecies<Float> SIMD_SPECIES = FloatVector.SPECIES_128;
    private static final int PREFERRED_LANES = FloatVector.SPECIES_PREFERRED.length();
    private static final FloatVector UNIT_W = FloatVector.fromArray(SIMD_SPECIES, new float[]{0.0f, 0.0f, 0.0f, 1.0f}, 0);

    public static float[] getNormalizedRotation(float[] dest, int destOffset, float[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return getNormalizedRotation_fma(dest, destOffset, src, srcOffset);
        return getNormalizedRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static float[] getNormalizedRotation_fma(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self21 = src[srcOffset + 6];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self20 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _t6 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        float _t7 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        float _t8 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t9 = (1.0f / (float) Math.sqrt(_t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t7));
        float _t11 = (1.0f / (float) Math.sqrt(_t8));
        float _t21 = _t6 > 0.0f ? _self01 * _t9 : 0.0f;
        float _t22 = _t7 > 0.0f ? _self12 * _t10 : 0.0f;
        float _t23 = _t6 > 0.0f ? _self11 * _t9 : 0.0f;
        float _t24 = _t7 > 0.0f ? _self02 * _t10 : 0.0f;
        float _t25 = _t8 > 0.0f ? _self20 * _t11 : 0.0f;
        float _t26 = _t7 > 0.0f ? _self22 * _t10 : 0.0f;
        float _t27 = _t6 > 0.0f ? _self21 * _t9 : 0.0f;
        float _t28 = _t8 > 0.0f ? _self00 * _t11 : 0.0f;
        float _t29 = _t8 > 0.0f ? _self10 * _t11 : 0.0f;
        float _t36 = _t27 - _t22;
        float _t39 = _t27 + _t22;
        float _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        float _t49 = _t48 < 0.0f ? -_t28 : _t28;
        float _t50 = _t48 < 0.0f ? -_t29 : _t29;
        float _t51 = _t48 < 0.0f ? -_t25 : _t25;
        float _t52 = _t49 + _t23;
        float _t53 = _t50 + _t21;
        float _t55 = _t51 + _t24;
        float _t56 = _t24 - _t51;
        float _t57 = _t50 - _t21;
        float _t58 = _t52 + _t26;
        float _t62 = 1.0f + _t58;
        float _t63 = 1.0f + (_t49 - (_t23 + _t26));
        float _t64 = 1.0f + (_t23 - (_t49 + _t26));
        float _t65 = 1.0f + (_t26 - _t52);
        float _t69 = (1.0f / (float) Math.sqrt(_t63));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t58  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t62)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t36).withLane(1, _t56).withLane(2, _t57).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))))) : (_t49  >  Math.max(_t23, _t26) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t63)).withLane(1, _t53 * _t69).withLane(2, _t55 * _t69).withLane(3, _t36 * _t69)) : (_t23  >  _t26 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t53).withLane(2, _t39).withLane(3, _t56).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t64)))).withLane(1, (float) Math.sqrt(_t64))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t39).withLane(3, _t57).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t65)))).withLane(2, (float) Math.sqrt(_t65))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] getNormalizedRotation_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self21 = src[srcOffset + 6];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self20 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _t6 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        float _t7 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        float _t8 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t9 = (1.0f / (float) Math.sqrt(_t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t7));
        float _t11 = (1.0f / (float) Math.sqrt(_t8));
        float _t21 = _t6 > 0.0f ? _self01 * _t9 : 0.0f;
        float _t22 = _t7 > 0.0f ? _self12 * _t10 : 0.0f;
        float _t23 = _t6 > 0.0f ? _self11 * _t9 : 0.0f;
        float _t24 = _t7 > 0.0f ? _self02 * _t10 : 0.0f;
        float _t25 = _t8 > 0.0f ? _self20 * _t11 : 0.0f;
        float _t26 = _t7 > 0.0f ? _self22 * _t10 : 0.0f;
        float _t27 = _t6 > 0.0f ? _self21 * _t9 : 0.0f;
        float _t28 = _t8 > 0.0f ? _self00 * _t11 : 0.0f;
        float _t29 = _t8 > 0.0f ? _self10 * _t11 : 0.0f;
        float _t36 = _t27 - _t22;
        float _t39 = _t27 + _t22;
        float _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        float _t49 = _t48 < 0.0f ? -_t28 : _t28;
        float _t50 = _t48 < 0.0f ? -_t29 : _t29;
        float _t51 = _t48 < 0.0f ? -_t25 : _t25;
        float _t52 = _t49 + _t23;
        float _t53 = _t50 + _t21;
        float _t55 = _t51 + _t24;
        float _t56 = _t24 - _t51;
        float _t57 = _t50 - _t21;
        float _t58 = _t52 + _t26;
        float _t62 = 1.0f + _t58;
        float _t63 = 1.0f + (_t49 - (_t23 + _t26));
        float _t64 = 1.0f + (_t23 - (_t49 + _t26));
        float _t65 = 1.0f + (_t26 - _t52);
        float _t69 = (1.0f / (float) Math.sqrt(_t63));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t58  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t62)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t36).withLane(1, _t56).withLane(2, _t57).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t62)))))) : (_t49  >  Math.max(_t23, _t26) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t63)).withLane(1, _t53 * _t69).withLane(2, _t55 * _t69).withLane(3, _t36 * _t69)) : (_t23  >  _t26 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t53).withLane(2, _t39).withLane(3, _t56).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t64)))).withLane(1, (float) Math.sqrt(_t64))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t39).withLane(3, _t57).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t65)))).withLane(2, (float) Math.sqrt(_t65))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] getUnnormalizedRotation(float[] dest, int destOffset, float[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return getUnnormalizedRotation_fma(dest, destOffset, src, srcOffset);
        return getUnnormalizedRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static float[] getUnnormalizedRotation_fma(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self21 = src[srcOffset + 6];
        float _self12 = src[srcOffset + 9];
        float _self01 = src[srcOffset + 4];
        float _self10 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 8];
        float _self20 = src[srcOffset + 2];
        float _t0 = _self00 + _self11;
        float _t1 = _self21 - _self12;
        float _t4 = _self01 + _self10;
        float _t6 = _self02 + _self20;
        float _t7 = _self02 - _self20;
        float _t8 = _self12 + _self21;
        float _t9 = _self10 - _self01;
        float _t10 = _self22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_self00 - (_self11 + _self22));
        float _t16 = 1.0f + (_self11 - (_self00 + _self22));
        float _t17 = 1.0f + (_self22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_self00  >  Math.max(_self11, _self22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_self11  >  _self22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] getUnnormalizedRotation_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self21 = src[srcOffset + 6];
        float _self12 = src[srcOffset + 9];
        float _self01 = src[srcOffset + 4];
        float _self10 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 8];
        float _self20 = src[srcOffset + 2];
        float _t0 = _self00 + _self11;
        float _t1 = _self21 - _self12;
        float _t4 = _self01 + _self10;
        float _t6 = _self02 + _self20;
        float _t7 = _self02 - _self20;
        float _t8 = _self12 + _self21;
        float _t9 = _self10 - _self01;
        float _t10 = _self22 + _t0;
        float _t14 = 1.0f + _t10;
        float _t15 = 1.0f + (_self00 - (_self11 + _self22));
        float _t16 = 1.0f + (_self11 - (_self00 + _self22));
        float _t17 = 1.0f + (_self22 - _t0);
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t10  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t14)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t14)))))) : (_self00  >  Math.max(_self11, _self22) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_self11  >  _self22 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t16)))).withLane(1, (float) Math.sqrt(_t16))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t17)))).withLane(2, (float) Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] add(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] negate(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).neg();
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] sub(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).sub(FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] set(float[] dest, int destOffset, float[] v, int vOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, v, (vOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] makeFromTransform(float[] dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        if (SimdSupport.USE_FMA) return makeFromTransform_fma(dest, destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return makeFromTransform_mulAdd(dest, destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
    }

    public static float[] makeFromTransform_fma(float[] dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = _sv0.fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, tSX).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(tRX, tRY, _t1)).withLane(2, 2.0f * Math.fma(tRX, tRZ, -_t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, tSY).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRY, -_t1)).withLane(2, Math.fma(tRX, tRW, tRY * tRZ))).withLane(1, Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f))).withLane(3, 0.0f);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, tSZ).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRZ, _t2)).withLane(1, Math.fma(tRY, tRZ, -(tRX * tRW)))).withLane(2, Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f))).withLane(3, 0.0f);
        var _c3 = FloatVector.zero(SIMD_SPECIES).withLane(0, tTX).withLane(1, tTY).withLane(2, tTZ).withLane(3, 1.0f);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] makeFromTransform_mulAdd(float[] dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = _sv0.mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, tSX).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(tRX, tRY, _t1)).withLane(2, 2.0f * Math.fma(tRX, tRZ, -_t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, tSY).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRY, -_t1)).withLane(2, Math.fma(tRX, tRW, tRY * tRZ))).withLane(1, Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f))).withLane(3, 0.0f);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, tSZ).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRZ, _t2)).withLane(1, Math.fma(tRY, tRZ, -(tRX * tRW)))).withLane(2, Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f))).withLane(3, 0.0f);
        var _c3 = FloatVector.zero(SIMD_SPECIES).withLane(0, tTX).withLane(1, tTY).withLane(2, tTZ).withLane(3, 1.0f);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] decomposeRotation(float[] dest, int destOffset, float[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return decomposeRotation_fma(dest, destOffset, src, srcOffset);
        return decomposeRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static float[] decomposeRotation_fma(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self20 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self21 = src[srcOffset + 6];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _self20 * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _self00 * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _self10 * _t3 : 0.0f;
        float _t19 = -Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        float _t20 = -Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        float _t21 = Math.fma(_t19, _t7, _self21);
        float _t22 = Math.fma(_t19, _t8, _self01);
        float _t23 = Math.fma(_t19, _t9, _self11);
        float _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t34 = _t29 > 0.0f ? _t22 * _t30 : 0.0f;
        float _t35 = _t29 > 0.0f ? _t21 * _t30 : 0.0f;
        float _t36 = _t29 > 0.0f ? _t23 * _t30 : 0.0f;
        float _t40 = -Math.fma(Math.fma(_t20, _t7, _self22), _t35, Math.fma(Math.fma(_t20, _t8, _self02), _t34, Math.fma(_t20, _t9, _self12) * _t36));
        float _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, _self22));
        float _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, _self02));
        float _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, _self12));
        float _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _t54 = _t49 > 0.0f ? _t46 * _t50 : 0.0f;
        float _t55 = _t49 > 0.0f ? _t45 * _t50 : 0.0f;
        float _t56 = _t49 > 0.0f ? _t44 * _t50 : 0.0f;
        float _t60 = _t35 - _t54;
        float _t63 = _t35 + _t54;
        float _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        float _t73 = _t72 < 0.0f ? -_t8 : _t8;
        float _t74 = _t72 < 0.0f ? -_t9 : _t9;
        float _t75 = _t72 < 0.0f ? -_t7 : _t7;
        float _t76 = _t73 + _t36;
        float _t77 = _t74 + _t34;
        float _t78 = _t74 - _t34;
        float _t80 = _t75 + _t55;
        float _t81 = _t55 - _t75;
        float _t82 = _t76 + _t56;
        float _t86 = 1.0f + _t82;
        float _t87 = 1.0f + (_t73 - (_t36 + _t56));
        float _t88 = 1.0f + (_t36 - (_t73 + _t56));
        float _t89 = 1.0f + (_t56 - _t76);
        float _t93 = (1.0f / (float) Math.sqrt(_t87));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t82  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t86)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t60).withLane(1, _t81).withLane(2, _t78).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t86)))))) : (_t73  >  Math.max(_t36, _t56) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t87)).withLane(1, _t77 * _t93).withLane(2, _t80 * _t93).withLane(3, _t60 * _t93)) : (_t36  >  _t56 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t77).withLane(2, _t63).withLane(3, _t81).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t88)))).withLane(1, (float) Math.sqrt(_t88))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t80).withLane(1, _t63).withLane(3, _t78).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t89)))).withLane(2, (float) Math.sqrt(_t89))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] decomposeRotation_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self20 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self21 = src[srcOffset + 6];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _self20 * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _self00 * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _self10 * _t3 : 0.0f;
        float _t19 = -Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        float _t20 = -Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        float _t21 = Math.fma(_t19, _t7, _self21);
        float _t22 = Math.fma(_t19, _t8, _self01);
        float _t23 = Math.fma(_t19, _t9, _self11);
        float _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t34 = _t29 > 0.0f ? _t22 * _t30 : 0.0f;
        float _t35 = _t29 > 0.0f ? _t21 * _t30 : 0.0f;
        float _t36 = _t29 > 0.0f ? _t23 * _t30 : 0.0f;
        float _t40 = -Math.fma(Math.fma(_t20, _t7, _self22), _t35, Math.fma(Math.fma(_t20, _t8, _self02), _t34, Math.fma(_t20, _t9, _self12) * _t36));
        float _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, _self22));
        float _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, _self02));
        float _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, _self12));
        float _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        float _t54 = _t49 > 0.0f ? _t46 * _t50 : 0.0f;
        float _t55 = _t49 > 0.0f ? _t45 * _t50 : 0.0f;
        float _t56 = _t49 > 0.0f ? _t44 * _t50 : 0.0f;
        float _t60 = _t35 - _t54;
        float _t63 = _t35 + _t54;
        float _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        float _t73 = _t72 < 0.0f ? -_t8 : _t8;
        float _t74 = _t72 < 0.0f ? -_t9 : _t9;
        float _t75 = _t72 < 0.0f ? -_t7 : _t7;
        float _t76 = _t73 + _t36;
        float _t77 = _t74 + _t34;
        float _t78 = _t74 - _t34;
        float _t80 = _t75 + _t55;
        float _t81 = _t55 - _t75;
        float _t82 = _t76 + _t56;
        float _t86 = 1.0f + _t82;
        float _t87 = 1.0f + (_t73 - (_t36 + _t56));
        float _t88 = 1.0f + (_t36 - (_t73 + _t56));
        float _t89 = 1.0f + (_t56 - _t76);
        float _t93 = (1.0f / (float) Math.sqrt(_t87));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _c0 = (_t82  >  0.0f ? _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sqrt(_t86)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t60).withLane(1, _t81).withLane(2, _t78).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t86)))))) : (_t73  >  Math.max(_t36, _t56) ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, (float) Math.sqrt(_t87)).withLane(1, _t77 * _t93).withLane(2, _t80 * _t93).withLane(3, _t60 * _t93)) : (_t36  >  _t56 ? _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t77).withLane(2, _t63).withLane(3, _t81).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t88)))).withLane(1, (float) Math.sqrt(_t88))) : _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _t80).withLane(1, _t63).withLane(3, _t78).mul(FloatVector.broadcast(SIMD_SPECIES, (1.0f / (float) Math.sqrt(_t89)))).withLane(2, (float) Math.sqrt(_t89))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] lerp(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    public static float[] lerp_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, t).fma(FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))), FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] lerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, t).mul(FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)))).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mul(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mul_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mul_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static float[] mul_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 3]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 2]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 0]).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 1]).mul(_sv3))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mul_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 3]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 2]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 0]).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, right[(rightOffset + _li * 4) + 1]).mul(_sv3))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mulMat2x2(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mulMat2x2_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mulMat2x2_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static float[] mulMat2x2_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv1));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).mul(_sv1));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat2x2_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv1));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).mul(_sv1));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat2x3(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mulMat2x3_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mulMat2x3_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static float[] mulMat2x3_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv1));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).mul(_sv1));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 4]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 5]).fma(_sv1, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat2x3_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv1));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).mul(_sv1));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 4]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 5]).mul(_sv1).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat3x3(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mulMat3x3_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mulMat3x3_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static float[] mulMat3x3_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 5]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 4]).mul(_sv2)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 8]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 6]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 7]).mul(_sv2)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat3x3_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 5]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 4]).mul(_sv2)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 8]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 6]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 7]).mul(_sv2)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat3x4(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mulMat3x4_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mulMat3x4_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static float[] mulMat3x4_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 8]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 4]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 9]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 5]).mul(_sv2)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 10]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 6]).mul(_sv2)));
        var _c3 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 7]).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 11]).fma(_sv0, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulMat3x4_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 8]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 0]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 4]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 9]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 1]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 5]).mul(_sv2)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 10]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 2]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 6]).mul(_sv2)));
        var _c3 = FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 3]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 7]).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, right[rightOffset + 11]).mul(_sv0).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preMul(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMul_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMul_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] preMul_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 12);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 8);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 4);
        for (int _li = 0; _li < 4; _li++) {
            var _c = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2]), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0]), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preMul_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 12);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 8);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 4);
        for (int _li = 0; _li < 4; _li++) {
            var _c = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3])).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] makeOuterProduct(float[] dest, int destOffset, float[] col, int colOffset, float[] row, int rowOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, col, colOffset);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, row[rowOffset + 0]));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, row[rowOffset + 1]));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, row[rowOffset + 2]));
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, row[rowOffset + 3]));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] arcball(float[] dest, int destOffset, float[] src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        if (SimdSupport.USE_FMA) return arcball_fma(dest, destOffset, src, srcOffset, radius, centerX, centerY, centerZ, angleX, angleY);
        return arcball_mulAdd(dest, destOffset, src, srcOffset, radius, centerX, centerY, centerZ, angleX, angleY);
    }

    public static float[] arcball_fma(float[] dest, int destOffset, float[] src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = -centerZ;
        float _t5 = -centerY;
        float _t6 = _t0 * _t1;
        float _t7 = _t3 * _t0;
        float _t8 = _t1 * _t2;
        float _t9 = _t3 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -_t6), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t2), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c1 = _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _t1), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3)));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t8), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t9))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t4, _t0, -(centerX * _t2))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(centerZ, _t9, Math.fma(_t5, _t1, -(centerX * _t7)))), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(centerX, _t6, Math.fma(_t5, _t3, Math.fma(_t4, _t8, -radius)))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] arcball_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float radius, float centerX, float centerY, float centerZ, float angleX, float angleY) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = -centerZ;
        float _t5 = -centerY;
        float _t6 = _t0 * _t1;
        float _t7 = _t3 * _t0;
        float _t8 = _t1 * _t2;
        float _t9 = _t3 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t6)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t2)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c1 = _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3)));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t9))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t4, _t0, -(centerX * _t2)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(centerZ, _t9, Math.fma(_t5, _t1, -(centerX * _t7))))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(centerX, _t6, Math.fma(_t5, _t3, Math.fma(_t4, _t8, -radius))))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] arcball(float[] dest, int destOffset, float[] src, int srcOffset, float[] center, int centerOffset, float radius, float angleX, float angleY) {
        if (SimdSupport.USE_FMA) return arcball_fma(dest, destOffset, src, srcOffset, center, centerOffset, radius, angleX, angleY);
        return arcball_mulAdd(dest, destOffset, src, srcOffset, center, centerOffset, radius, angleX, angleY);
    }

    public static float[] arcball_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] center, int centerOffset, float radius, float angleX, float angleY) {
        float _centerx = center[centerOffset + 0];
        float _centerz = center[centerOffset + 2];
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = -_centerz;
        float _t5 = -center[centerOffset + 1];
        float _t6 = _t0 * _t1;
        float _t7 = _t3 * _t0;
        float _t8 = _t1 * _t2;
        float _t9 = _t3 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -_t6), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t2), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c1 = _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _t1), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3)));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t8), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t9))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t4, _t0, -(_centerx * _t2))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_centerz, _t9, Math.fma(_t5, _t1, -(_centerx * _t7)))), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_centerx, _t6, Math.fma(_t5, _t3, Math.fma(_t4, _t8, -radius)))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] arcball_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] center, int centerOffset, float radius, float angleX, float angleY) {
        float _centerx = center[centerOffset + 0];
        float _centerz = center[centerOffset + 2];
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleX);
        float _t4 = -_centerz;
        float _t5 = -center[centerOffset + 1];
        float _t6 = _t0 * _t1;
        float _t7 = _t3 * _t0;
        float _t8 = _t1 * _t2;
        float _t9 = _t3 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t6)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t2)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c1 = _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3)));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t9))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t4, _t0, -(_centerx * _t2)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_centerz, _t9, Math.fma(_t5, _t1, -(_centerx * _t7))))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_centerx, _t6, Math.fma(_t5, _t3, Math.fma(_t4, _t8, -radius))))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] axonometricDimetric(float[] dest, int destOffset, float[] src, int srcOffset, float alpha) {
        if (SimdSupport.USE_FMA) return axonometricDimetric_fma(dest, destOffset, src, srcOffset, alpha);
        return axonometricDimetric_mulAdd(dest, destOffset, src, srcOffset, alpha);
    }

    public static float[] axonometricDimetric_fma(float[] dest, int destOffset, float[] src, int srcOffset, float alpha) {
        float _t0 = (float) Math.cos(alpha);
        float _t1 = (float) Math.sqrt(2.0f);
        float _t2 = (float) Math.sin(alpha);
        float _t5 = src[srcOffset + 0] * _t1;
        float _t6 = src[srcOffset + 1] * _t1;
        float _t7 = src[srcOffset + 2] * _t1;
        float _t8 = src[srcOffset + 3] * _t1;
        float _t9 = 0.5f * _t0 * _t1;
        float _t10 = 0.5f * _t2 * _t1;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _sv3 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t5).withLane(1, _t6).withLane(2, _t7).withLane(3, _t8);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -_t9), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t10), _sv2.mul(_sv3)));
        var _c1 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t0), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t2)));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t9), _sv2.fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t10))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] axonometricDimetric_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float alpha) {
        float _t0 = (float) Math.cos(alpha);
        float _t1 = (float) Math.sqrt(2.0f);
        float _t2 = (float) Math.sin(alpha);
        float _t5 = src[srcOffset + 0] * _t1;
        float _t6 = src[srcOffset + 1] * _t1;
        float _t7 = src[srcOffset + 2] * _t1;
        float _t8 = src[srcOffset + 3] * _t1;
        float _t9 = 0.5f * _t0 * _t1;
        float _t10 = 0.5f * _t2 * _t1;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _sv3 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t5).withLane(1, _t6).withLane(2, _t7).withLane(3, _t8);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t9)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t10)).add(_sv2.mul(_sv3)));
        var _c1 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0)).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t2)));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t9)).add(_sv2.mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t10))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] axonometricTrimetric(float[] dest, int destOffset, float[] src, int srcOffset, float alphaX, float alphaY) {
        if (SimdSupport.USE_FMA) return axonometricTrimetric_fma(dest, destOffset, src, srcOffset, alphaX, alphaY);
        return axonometricTrimetric_mulAdd(dest, destOffset, src, srcOffset, alphaX, alphaY);
    }

    public static float[] axonometricTrimetric_fma(float[] dest, int destOffset, float[] src, int srcOffset, float alphaX, float alphaY) {
        float _t0 = (float) Math.sin(alphaY);
        float _t1 = (float) Math.cos(alphaX);
        float _t2 = (float) Math.cos(alphaY);
        float _t3 = (float) Math.sin(alphaX);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t1)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t2), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t0))));
        var _c1 = _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _t1), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3)));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t2), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t0), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t3 * _t2)))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] axonometricTrimetric_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float alphaX, float alphaY) {
        float _t0 = (float) Math.sin(alphaY);
        float _t1 = (float) Math.cos(alphaX);
        float _t2 = (float) Math.cos(alphaY);
        float _t3 = (float) Math.sin(alphaX);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t1))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t2)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t0))));
        var _c1 = _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3)));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t2)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t3 * _t2)))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] composeTRS(float[] dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        if (SimdSupport.USE_FMA) return composeTRS_fma(dest, destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return composeTRS_mulAdd(dest, destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
    }

    public static float[] composeTRS_fma(float[] dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = _sv0.fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, scaleX).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(rotationX, rotationY, _t1)).withLane(2, 2.0f * Math.fma(rotationX, rotationZ, -_t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, scaleY).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, -_t1)).withLane(2, Math.fma(rotationX, rotationW, rotationY * rotationZ))).withLane(1, Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f))).withLane(3, 0.0f);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, scaleZ).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, _t2)).withLane(1, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).withLane(2, Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f))).withLane(3, 0.0f);
        var _c3 = FloatVector.zero(SIMD_SPECIES).withLane(0, translationX).withLane(1, translationY).withLane(2, translationZ).withLane(3, 1.0f);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] composeTRS_mulAdd(float[] dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = _sv0.mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, scaleX).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(rotationX, rotationY, _t1)).withLane(2, 2.0f * Math.fma(rotationX, rotationZ, -_t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, scaleY).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, -_t1)).withLane(2, Math.fma(rotationX, rotationW, rotationY * rotationZ))).withLane(1, Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f))).withLane(3, 0.0f);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, scaleZ).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, _t2)).withLane(1, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).withLane(2, Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f))).withLane(3, 0.0f);
        var _c3 = FloatVector.zero(SIMD_SPECIES).withLane(0, translationX).withLane(1, translationY).withLane(2, translationZ).withLane(3, 1.0f);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] composeTRS(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        if (SimdSupport.USE_FMA) return composeTRS_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset);
        return composeTRS_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset);
    }

    public static float[] composeTRS_fma(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        float _rotationy = rotation[rotationOffset + 1];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationz = rotation[rotationOffset + 2];
        float _rotationw = rotation[rotationOffset + 3];
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = _sv0.fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, scale[scaleOffset + 0]).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(_rotationx, _rotationy, _t1)).withLane(2, 2.0f * Math.fma(_rotationx, _rotationz, -_t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, scale[scaleOffset + 1]).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t1)).withLane(2, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).withLane(1, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f))).withLane(3, 0.0f);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, scale[scaleOffset + 2]).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t2)).withLane(1, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).withLane(2, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f))).withLane(3, 0.0f);
        var _c3 = FloatVector.zero(SIMD_SPECIES).withLane(0, translation[translationOffset + 0]).withLane(1, translation[translationOffset + 1]).withLane(2, translation[translationOffset + 2]).withLane(3, 1.0f);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] composeTRS_mulAdd(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        float _rotationy = rotation[rotationOffset + 1];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationz = rotation[rotationOffset + 2];
        float _rotationw = rotation[rotationOffset + 3];
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 0.0f);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = _sv0.mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, scale[scaleOffset + 0]).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(_rotationx, _rotationy, _t1)).withLane(2, 2.0f * Math.fma(_rotationx, _rotationz, -_t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, scale[scaleOffset + 1]).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, -_t1)).withLane(2, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).withLane(1, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f))).withLane(3, 0.0f);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, scale[scaleOffset + 2]).mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, _t2)).withLane(1, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).withLane(2, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f))).withLane(3, 0.0f);
        var _c3 = FloatVector.zero(SIMD_SPECIES).withLane(0, translation[translationOffset + 0]).withLane(1, translation[translationOffset + 1]).withLane(2, translation[translationOffset + 2]).withLane(3, 1.0f);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return frustum_no_lh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return frustum_no_lh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_no_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t4_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? 1.0f : zNear == Float.POSITIVE_INFINITY ? -1.0f : -((zFar + zNear) * _t4_inv)), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv4, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -_t0 : zNear == Float.POSITIVE_INFINITY ? 2.0f * zFar : 2.0f * zFar * zNear * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_no_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t4_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? 1.0f : zNear == Float.POSITIVE_INFINITY ? -1.0f : -((zFar + zNear) * _t4_inv))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv4).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -_t0 : zNear == Float.POSITIVE_INFINITY ? 2.0f * zFar : 2.0f * zFar * zNear * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return frustum_no_rh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return frustum_no_rh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_no_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t4_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -1.0f : zNear == Float.POSITIVE_INFINITY ? 1.0f : (zFar + zNear) * _t4_inv), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).fma(_sv2, _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, bottom + top)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -_t0 : zNear == Float.POSITIVE_INFINITY ? 2.0f * zFar : 2.0f * zFar * zNear * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_no_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t4_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -1.0f : zNear == Float.POSITIVE_INFINITY ? 1.0f : (zFar + zNear) * _t4_inv)).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(_sv2).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, bottom + top)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -_t0 : zNear == Float.POSITIVE_INFINITY ? 2.0f * zFar : 2.0f * zFar * zNear * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return frustum_zo_lh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return frustum_zo_lh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_zo_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t3_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? 1.0f : zNear == Float.POSITIVE_INFINITY ? 0.0f : -(zFar * _t3_inv)), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv4, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -zNear : zNear == Float.POSITIVE_INFINITY ? zFar : zFar * zNear * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_zo_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t3_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? 1.0f : zNear == Float.POSITIVE_INFINITY ? 0.0f : -(zFar * _t3_inv))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv4).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -zNear : zNear == Float.POSITIVE_INFINITY ? zFar : zFar * zNear * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return frustum_zo_rh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return frustum_zo_rh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] frustum_zo_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t3_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -1.0f : zNear == Float.POSITIVE_INFINITY ? 0.0f : zFar * _t3_inv), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).fma(_sv2, _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, bottom + top)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -zNear : zNear == Float.POSITIVE_INFINITY ? zFar : zFar * zNear * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] frustum_zo_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1_inv = 1.0f / (right - left);
        float _t2_inv = 1.0f / (top - bottom);
        float _t3_inv = 1.0f / (zNear - zFar);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv3.mul(_sv1).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -1.0f : zNear == Float.POSITIVE_INFINITY ? 0.0f : zFar * _t3_inv)).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(_sv2).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, bottom + top)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, zFar == Float.POSITIVE_INFINITY ? -zNear : zNear == Float.POSITIVE_INFINITY ? zFar : zFar * zNear * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAlong(float[] dest, int destOffset, float[] src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return lookAlong_fma(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return lookAlong_mulAdd(dest, destOffset, src, srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    public static float[] lookAlong_fma(float[] dest, int destOffset, float[] src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26 = _t21 > 0.0f ? _t16 * _t22 : 0.0f;
        float _t27 = _t21 > 0.0f ? _t17 * _t22 : 0.0f;
        float _t28 = _t21 > 0.0f ? _t18 * _t22 : 0.0f;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t26), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t27), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t28, -(_t7 * _t27))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t7, _t26, -(_t9 * _t28))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t27, -(_t8 * _t26))))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t9), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t8), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAlong_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? dirY * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? dirX * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? dirZ * _t3 : 0.0f;
        float _t16 = Math.fma(upX, _t7, -(upY * _t8));
        float _t17 = Math.fma(upY, _t9, -(upZ * _t7));
        float _t18 = Math.fma(upZ, _t8, -(upX * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26 = _t21 > 0.0f ? _t16 * _t22 : 0.0f;
        float _t27 = _t21 > 0.0f ? _t17 * _t22 : 0.0f;
        float _t28 = _t21 > 0.0f ? _t18 * _t22 : 0.0f;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t26)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t27)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t28, -(_t7 * _t27)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t7, _t26, -(_t9 * _t28)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t27, -(_t8 * _t26))))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t9)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAlong(float[] dest, int destOffset, float[] src, int srcOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAlong_fma(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
        return lookAlong_mulAdd(dest, destOffset, src, srcOffset, dir, dirOffset, up, upOffset);
    }

    public static float[] lookAlong_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        float _dirz = dir[dirOffset + 2];
        float _dirx = dir[dirOffset + 0];
        float _diry = dir[dirOffset + 1];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t16 = Math.fma(_upx, _t7, -(_upy * _t8));
        float _t17 = Math.fma(_upy, _t9, -(_upz * _t7));
        float _t18 = Math.fma(_upz, _t8, -(_upx * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26 = _t21 > 0.0f ? _t16 * _t22 : 0.0f;
        float _t27 = _t21 > 0.0f ? _t17 * _t22 : 0.0f;
        float _t28 = _t21 > 0.0f ? _t18 * _t22 : 0.0f;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t26), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t27), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t28, -(_t7 * _t27))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t7, _t26, -(_t9 * _t28))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t27, -(_t8 * _t26))))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t9), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t8), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAlong_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] dir, int dirOffset, float[] up, int upOffset) {
        float _dirz = dir[dirOffset + 2];
        float _dirx = dir[dirOffset + 0];
        float _diry = dir[dirOffset + 1];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7 = _t2 > 0.0f ? _diry * _t3 : 0.0f;
        float _t8 = _t2 > 0.0f ? _dirx * _t3 : 0.0f;
        float _t9 = _t2 > 0.0f ? _dirz * _t3 : 0.0f;
        float _t16 = Math.fma(_upx, _t7, -(_upy * _t8));
        float _t17 = Math.fma(_upy, _t9, -(_upz * _t7));
        float _t18 = Math.fma(_upz, _t8, -(_upx * _t9));
        float _t21 = Math.fma(_t16, _t16, Math.fma(_t17, _t17, _t18 * _t18));
        float _t22 = (1.0f / (float) Math.sqrt(_t21));
        float _t26 = _t21 > 0.0f ? _t16 * _t22 : 0.0f;
        float _t27 = _t21 > 0.0f ? _t17 * _t22 : 0.0f;
        float _t28 = _t21 > 0.0f ? _t18 * _t22 : 0.0f;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t26)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t27)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t28, -(_t7 * _t27)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t7, _t26, -(_t9 * _t28)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t27, -(_t8 * _t26))))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t9)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t8)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t7))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static float[] lookAt_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10 = _t5 > 0.0f ? _t1 * _t6 : 0.0f;
        float _t11 = _t5 > 0.0f ? _t2 * _t6 : 0.0f;
        float _t12 = _t5 > 0.0f ? _t0 * _t6 : 0.0f;
        float _t21 = Math.fma(upX, _t11, -(upY * _t10));
        float _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        float _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t10), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t32), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t43))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t11), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t34), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t44))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t12), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t33), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t45))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44))), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10 = _t5 > 0.0f ? _t1 * _t6 : 0.0f;
        float _t11 = _t5 > 0.0f ? _t2 * _t6 : 0.0f;
        float _t12 = _t5 > 0.0f ? _t0 * _t6 : 0.0f;
        float _t21 = Math.fma(upX, _t11, -(upY * _t10));
        float _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        float _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t10)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t32)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t43))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t11)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t34)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t44))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t12)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t33)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t45))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44)))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static float[] lookAt_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t4 = centerZ - eyeZ;
        float _t5 = centerX - eyeX;
        float _t6 = centerY - eyeY;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14 = _t9 > 0.0f ? _t5 * _t10 : 0.0f;
        float _t15 = _t9 > 0.0f ? _t6 * _t10 : 0.0f;
        float _t16 = _t9 > 0.0f ? _t4 * _t10 : 0.0f;
        float _t25 = Math.fma(upY, _t14, -(upX * _t15));
        float _t26 = Math.fma(upX, _t16, -(upZ * _t14));
        float _t27 = Math.fma(upZ, _t15, -(upY * _t16));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36 = _t31 > 0.0f ? _t27 * _t32 : 0.0f;
        float _t37 = _t31 > 0.0f ? _t26 * _t32 : 0.0f;
        float _t38 = _t31 > 0.0f ? _t25 * _t32 : 0.0f;
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t14), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t36), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t47))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t15), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t37), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t48))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t38), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t49))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t38, Math.fma(eyeX, _t36, eyeY * _t37))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t49, Math.fma(eyeX, _t47, eyeY * _t48))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(eyeZ, _t16, Math.fma(eyeX, _t14, eyeY * _t15))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t4 = centerZ - eyeZ;
        float _t5 = centerX - eyeX;
        float _t6 = centerY - eyeY;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14 = _t9 > 0.0f ? _t5 * _t10 : 0.0f;
        float _t15 = _t9 > 0.0f ? _t6 * _t10 : 0.0f;
        float _t16 = _t9 > 0.0f ? _t4 * _t10 : 0.0f;
        float _t25 = Math.fma(upY, _t14, -(upX * _t15));
        float _t26 = Math.fma(upX, _t16, -(upZ * _t14));
        float _t27 = Math.fma(upZ, _t15, -(upY * _t16));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36 = _t31 > 0.0f ? _t27 * _t32 : 0.0f;
        float _t37 = _t31 > 0.0f ? _t26 * _t32 : 0.0f;
        float _t38 = _t31 > 0.0f ? _t25 * _t32 : 0.0f;
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t14)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t36)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t47))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t15)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t37)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t48))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t38)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t49))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t38, Math.fma(eyeX, _t36, eyeY * _t37)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(eyeZ, _t49, Math.fma(eyeX, _t47, eyeY * _t48)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(eyeZ, _t16, Math.fma(eyeX, _t14, eyeY * _t15)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static float[] lookAt_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyez = eye[eyeOffset + 2];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t0 = center[centerOffset + 2] - _eyez;
        float _t1 = center[centerOffset + 0] - _eyex;
        float _t2 = center[centerOffset + 1] - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10 = _t5 > 0.0f ? _t1 * _t6 : 0.0f;
        float _t11 = _t5 > 0.0f ? _t2 * _t6 : 0.0f;
        float _t12 = _t5 > 0.0f ? _t0 * _t6 : 0.0f;
        float _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        float _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        float _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t10), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t32), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t43))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t11), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t34), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t44))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t12), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t33), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t45))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44))), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyez = eye[eyeOffset + 2];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t0 = center[centerOffset + 2] - _eyez;
        float _t1 = center[centerOffset + 0] - _eyex;
        float _t2 = center[centerOffset + 1] - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10 = _t5 > 0.0f ? _t1 * _t6 : 0.0f;
        float _t11 = _t5 > 0.0f ? _t2 * _t6 : 0.0f;
        float _t12 = _t5 > 0.0f ? _t0 * _t6 : 0.0f;
        float _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        float _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        float _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t10)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t32)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t43))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t11)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t34)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t44))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t12)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t33)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t45))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44)))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static float[] lookAt_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyez = eye[eyeOffset + 2];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _upy = up[upOffset + 1];
        float _upx = up[upOffset + 0];
        float _upz = up[upOffset + 2];
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t4 = center[centerOffset + 2] - _eyez;
        float _t5 = center[centerOffset + 0] - _eyex;
        float _t6 = center[centerOffset + 1] - _eyey;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14 = _t9 > 0.0f ? _t5 * _t10 : 0.0f;
        float _t15 = _t9 > 0.0f ? _t6 * _t10 : 0.0f;
        float _t16 = _t9 > 0.0f ? _t4 * _t10 : 0.0f;
        float _t25 = Math.fma(_upy, _t14, -(_upx * _t15));
        float _t26 = Math.fma(_upx, _t16, -(_upz * _t14));
        float _t27 = Math.fma(_upz, _t15, -(_upy * _t16));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36 = _t31 > 0.0f ? _t27 * _t32 : 0.0f;
        float _t37 = _t31 > 0.0f ? _t26 * _t32 : 0.0f;
        float _t38 = _t31 > 0.0f ? _t25 * _t32 : 0.0f;
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t14), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t36), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t47))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t15), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t37), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t48))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t16), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t38), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t49))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t38, Math.fma(_eyex, _t36, _eyey * _t37))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t49, Math.fma(_eyex, _t47, _eyey * _t48))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_eyez, _t16, Math.fma(_eyex, _t14, _eyey * _t15))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] lookAt_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyez = eye[eyeOffset + 2];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _upy = up[upOffset + 1];
        float _upx = up[upOffset + 0];
        float _upz = up[upOffset + 2];
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t4 = center[centerOffset + 2] - _eyez;
        float _t5 = center[centerOffset + 0] - _eyex;
        float _t6 = center[centerOffset + 1] - _eyey;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14 = _t9 > 0.0f ? _t5 * _t10 : 0.0f;
        float _t15 = _t9 > 0.0f ? _t6 * _t10 : 0.0f;
        float _t16 = _t9 > 0.0f ? _t4 * _t10 : 0.0f;
        float _t25 = Math.fma(_upy, _t14, -(_upx * _t15));
        float _t26 = Math.fma(_upx, _t16, -(_upz * _t14));
        float _t27 = Math.fma(_upz, _t15, -(_upy * _t16));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36 = _t31 > 0.0f ? _t27 * _t32 : 0.0f;
        float _t37 = _t31 > 0.0f ? _t26 * _t32 : 0.0f;
        float _t38 = _t31 > 0.0f ? _t25 * _t32 : 0.0f;
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t14)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t36)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t47))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t15)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t37)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t48))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t16)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t38)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t49))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t38, Math.fma(_eyex, _t36, _eyey * _t37)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -Math.fma(_eyez, _t49, Math.fma(_eyex, _t47, _eyey * _t48)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_eyez, _t16, Math.fma(_eyex, _t14, _eyey * _t15)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXYZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mapXYnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXZY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXZnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXnYZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXnYnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXnZY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapXnZnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYXZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYXnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYZX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYZnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYnXZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYnXnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYnZX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapYnZnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZXY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZXnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZYX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZYnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZnXY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZnXnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZnYX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapZnYnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXYZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXYnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXZY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXZnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXnYZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXnYnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXnZY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnXnZnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYXZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYXnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYZX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYZnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYnXZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYnXnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYnZX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnYnZnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZXY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZXnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZYX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZYnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZnXY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZnXnY(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZnYX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mapnZnYnX(float[] dest, int destOffset, float[] src, int srcOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).neg();
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueCabinet(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return obliqueCabinet_fma(dest, destOffset, src, srcOffset, angle);
        return obliqueCabinet_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] obliqueCabinet_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -(0.5f * (float) Math.cos(angle))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, -(0.5f * (float) Math.sin(angle))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueCabinet_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(0.5f * (float) Math.cos(angle)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(0.5f * (float) Math.sin(angle)))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueCavalier(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return obliqueCavalier_fma(dest, destOffset, src, srcOffset, angle);
        return obliqueCavalier_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] obliqueCavalier_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -(float) Math.cos(angle)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, -(float) Math.sin(angle)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueCavalier_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(float) Math.cos(angle))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(float) Math.sin(angle))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueMilitary(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return obliqueMilitary_fma(dest, destOffset, src, srcOffset, angle);
        return obliqueMilitary_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] obliqueMilitary_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0;
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(angle)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(angle)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg()));
        var _c2 = _sv1;
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueMilitary_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0;
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.cos(angle))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, (float) Math.sin(angle))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg()));
        var _c2 = _sv1;
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self23 = src[srcOffset + 14];
        float _t0 = 2.0f * _self23;
        float _t15_inv = 1.0f / Math.fma(planeW, 1.0f - src[srcOffset + 10], _self23 * (planeZ + (planeX * ((planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 8]) / src[srcOffset + 0] + planeY * ((planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 9]) / src[srcOffset + 5])));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, planeX * _t0 * _t15_inv - src[srcOffset + 3]);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, planeY * _t0 * _t15_inv - src[srcOffset + 7]);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, planeZ * _t0 * _t15_inv - src[srcOffset + 11]);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, planeW * _t0 * _t15_inv - src[srcOffset + 15]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self23 = src[srcOffset + 14];
        float _t0 = 2.0f * _self23;
        float _t15_inv = 1.0f / Math.fma(planeW, 1.0f + src[srcOffset + 10], _self23 * (planeX * (src[srcOffset + 8] + (planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 0] + planeY * (src[srcOffset + 9] + (planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 5] - planeZ));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, planeX * _t0 * _t15_inv - src[srcOffset + 3]);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, planeY * _t0 * _t15_inv - src[srcOffset + 7]);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, planeZ * _t0 * _t15_inv - src[srcOffset + 11]);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, planeW * _t0 * _t15_inv - src[srcOffset + 15]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self23 = src[srcOffset + 14];
        float _t14_inv = 1.0f / Math.fma(planeW, 1.0f - src[srcOffset + 10], _self23 * (planeZ + (planeX * ((planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 8]) / src[srcOffset + 0] + planeY * ((planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 9]) / src[srcOffset + 5])));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, planeX * _self23 * _t14_inv);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, planeY * _self23 * _t14_inv);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, planeZ * _self23 * _t14_inv);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, planeW * _self23 * _t14_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self23 = src[srcOffset + 14];
        float _t14_inv = 1.0f / Math.fma(planeW, 1.0f + src[srcOffset + 10], _self23 * (planeX * (src[srcOffset + 8] + (planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 0] + planeY * (src[srcOffset + 9] + (planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 5] - planeZ));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, planeX * _self23 * _t14_inv);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, planeY * _self23 * _t14_inv);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, planeZ * _self23 * _t14_inv);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, planeW * _self23 * _t14_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _self23 = src[srcOffset + 14];
        float _t0 = 2.0f * _self23;
        float _t15_inv = 1.0f / Math.fma(_planew, 1.0f - src[srcOffset + 10], _self23 * (_planez + (_planex * ((_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 8]) / src[srcOffset + 0] + _planey * ((_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 9]) / src[srcOffset + 5])));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, _planex * _t0 * _t15_inv - src[srcOffset + 3]);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, _planey * _t0 * _t15_inv - src[srcOffset + 7]);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, _planez * _t0 * _t15_inv - src[srcOffset + 11]);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, _planew * _t0 * _t15_inv - src[srcOffset + 15]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _self23 = src[srcOffset + 14];
        float _t0 = 2.0f * _self23;
        float _t15_inv = 1.0f / Math.fma(_planew, 1.0f + src[srcOffset + 10], _self23 * (_planex * (src[srcOffset + 8] + (_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 0] + _planey * (src[srcOffset + 9] + (_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 5] - _planez));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, _planex * _t0 * _t15_inv - src[srcOffset + 3]);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, _planey * _t0 * _t15_inv - src[srcOffset + 7]);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, _planez * _t0 * _t15_inv - src[srcOffset + 11]);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, _planew * _t0 * _t15_inv - src[srcOffset + 15]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _planex = plane[planeOffset + 0];
        float _self23 = src[srcOffset + 14];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t14_inv = 1.0f / Math.fma(_planew, 1.0f - src[srcOffset + 10], _self23 * (_planez + (_planex * ((_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 8]) / src[srcOffset + 0] + _planey * ((_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f) - src[srcOffset + 9]) / src[srcOffset + 5])));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, _planex * _self23 * _t14_inv);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, _planey * _self23 * _t14_inv);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, _planez * _self23 * _t14_inv);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, _planew * _self23 * _t14_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] obliqueZ_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _planex = plane[planeOffset + 0];
        float _self23 = src[srcOffset + 14];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t14_inv = 1.0f / Math.fma(_planew, 1.0f + src[srcOffset + 10], _self23 * (_planex * (src[srcOffset + 8] + (_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 0] + _planey * (src[srcOffset + 9] + (_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f)) / src[srcOffset + 5] - _planez));
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(2, _planex * _self23 * _t14_inv);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(2, _planey * _self23 * _t14_inv);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, _planez * _self23 * _t14_inv);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, _planew * _self23 * _t14_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return ortho_no_lh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return ortho_no_lh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_no_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = _sv0.mul(_sv4).mul(_sv5);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, -(zFar + zNear))).fma(_sv5, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_no_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = _sv0.mul(_sv4).mul(_sv5);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, -(zFar + zNear))).mul(_sv5).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return ortho_no_rh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return ortho_no_rh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_no_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -2.0f).mul(_sv4).mul(_sv5);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, -(zFar + zNear))).fma(_sv5, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_no_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -2.0f).mul(_sv4).mul(_sv5);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, -(zFar + zNear))).mul(_sv5).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return ortho_zo_lh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return ortho_zo_lh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_zo_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = _sv4.mul(_sv5);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(FloatVector.broadcast(SIMD_SPECIES, -zNear).mul(_sv4).fma(_sv5, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_zo_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _t2_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = _sv4.mul(_sv5);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(FloatVector.broadcast(SIMD_SPECIES, -zNear).mul(_sv4).mul(_sv5).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        if (SimdSupport.USE_FMA) return ortho_zo_rh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return ortho_zo_rh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static float[] ortho_zo_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = _sv4.mul(FloatVector.broadcast(SIMD_SPECIES, -_t2_inv));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(FloatVector.broadcast(SIMD_SPECIES, -zNear).mul(_sv4).fma(FloatVector.broadcast(SIMD_SPECIES, _t2_inv), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho_zo_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        float _t2_inv = 1.0f / (zFar - zNear);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv4 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = _sv4.mul(FloatVector.broadcast(SIMD_SPECIES, -_t2_inv));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(FloatVector.broadcast(SIMD_SPECIES, -zNear).mul(_sv4).mul(FloatVector.broadcast(SIMD_SPECIES, _t2_inv)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.USE_FMA) return ortho2D_no_lh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return ortho2D_no_lh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_no_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_no_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.USE_FMA) return ortho2D_no_rh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return ortho2D_no_rh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_no_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv3, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_no_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _c0 = _sv0.mul(_sv1).mul(FloatVector.broadcast(SIMD_SPECIES, _t0_inv));
        var _c1 = _sv0.mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).neg();
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv3).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, left + right)).mul(FloatVector.broadcast(SIMD_SPECIES, -_t0_inv))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.USE_FMA) return ortho2D_zo_lh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return ortho2D_zo_lh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_zo_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t0_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _sv6 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.mul(_sv6);
        var _c3 = _sv5.fma(_sv6, _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv4, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_zo_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t0_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, 0.5f);
        var _sv6 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.mul(_sv6);
        var _c3 = _sv5.mul(_sv6).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv4).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        if (SimdSupport.USE_FMA) return ortho2D_zo_rh_fma(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return ortho2D_zo_rh_mulAdd(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static float[] ortho2D_zo_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t0_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -0.5f).mul(_sv5);
        var _c3 = FloatVector.broadcast(SIMD_SPECIES, 0.5f).fma(_sv5, _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).fma(_sv4, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] ortho2D_zo_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _t0_inv = 1.0f / (right - left);
        float _t1_inv = 1.0f / (top - bottom);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t0_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t1_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -0.5f).mul(_sv5);
        var _c3 = FloatVector.broadcast(SIMD_SPECIES, 0.5f).mul(_sv5).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(bottom + top))).mul(_sv4).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(left + right))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspective_no_lh_fma(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return perspective_no_lh_mulAdd(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_no_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t2_inv = 1.0f / (near - far);
        float _t6 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t6)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t6));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t2_inv)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12));
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_no_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t2_inv = 1.0f / (near - far);
        float _t6 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t6)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t6));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t2_inv))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12));
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspective_no_rh_fma(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return perspective_no_rh_mulAdd(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_no_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t2_inv = 1.0f / (near - far);
        float _t6 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t6)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t6));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t2_inv), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg());
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_no_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t2_inv = 1.0f / (near - far);
        float _t6 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t6)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t6));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t2_inv)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg());
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspective_zo_lh_fma(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return perspective_zo_lh_mulAdd(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_zo_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t1_inv = 1.0f / (near - far);
        float _t3 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t3)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t3));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t1_inv)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12));
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t1_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_zo_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t1_inv = 1.0f / (near - far);
        float _t3 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t3)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t3));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t1_inv))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12));
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t1_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspective_zo_rh_fma(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return perspective_zo_rh_mulAdd(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static float[] perspective_zo_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t1_inv = 1.0f / (near - far);
        float _t3 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t3)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t3));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t1_inv), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg());
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t1_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspective_zo_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _t1_inv = 1.0f / (near - far);
        float _t3 = (float) Math.tan(0.5f * fovy);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t3)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / _t3));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t1_inv)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg());
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t1_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveFovRange_no_lh_fma(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return perspectiveFovRange_no_lh_mulAdd(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_no_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3_inv = 1.0f / (near - far);
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t8_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t8)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t3_inv)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 + _t1))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_no_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3_inv = 1.0f / (near - far);
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t8_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t8)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t3_inv))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 + _t1))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveFovRange_no_rh_fma(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return perspectiveFovRange_no_rh_mulAdd(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_no_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3_inv = 1.0f / (near - far);
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t8_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t8)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t3_inv), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0 + _t1)).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg()));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_no_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3_inv = 1.0f / (near - far);
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t8_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t8)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t3_inv)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0 + _t1)).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg()));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t3_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveFovRange_zo_lh_fma(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return perspectiveFovRange_zo_lh_mulAdd(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_zo_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2_inv = 1.0f / (near - far);
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t4_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t4)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t2_inv)), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 + _t1))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_zo_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2_inv = 1.0f / (near - far);
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t4_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t4)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t2_inv))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 + _t1))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveFovRange_zo_rh_fma(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return perspectiveFovRange_zo_rh_mulAdd(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static float[] perspectiveFovRange_zo_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2_inv = 1.0f / (near - far);
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t4_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t4)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t2_inv), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0 + _t1)).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg()));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFovRange_zo_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2_inv = 1.0f / (near - far);
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t4_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).mul(FloatVector.broadcast(SIMD_SPECIES, 1.0f / (aspect * _t4)));
        var _c1 = _sv0.mul(_sv1).mul(_sv2);
        var _c2 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t2_inv)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t0 + _t1)).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).neg()));
        var _c3 = _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t2_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFrustumSlice_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _t0_inv = 1.0f / (near - far);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t0_inv));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t0_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFrustumSlice_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _t0_inv = 1.0f / (near - far);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t0_inv);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t0_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFrustumSlice_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _t0_inv = 1.0f / (near - far);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t0_inv));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t0_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveFrustumSlice_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _t0_inv = 1.0f / (near - far);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(2, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t0_inv);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).withLane(2, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t0_inv);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveOffCenterFov_no_lh_fma(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return perspectiveOffCenterFov_no_lh_mulAdd(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_no_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5_inv = 1.0f / (near - far);
        float _t10_inv = 1.0f / (_t0 - _t1);
        float _t11_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t10_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t11_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t5_inv)), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t3 + _t2))).fma(_sv4, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t1 + _t0))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t5_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5_inv = 1.0f / (near - far);
        float _t10_inv = 1.0f / (_t0 - _t1);
        float _t11_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t10_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t11_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? -1.0f : -((far + near) * _t5_inv))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t3 + _t2))).mul(_sv4).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t1 + _t0))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t5_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveOffCenterFov_no_rh_fma(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return perspectiveOffCenterFov_no_rh_mulAdd(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_no_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5_inv = 1.0f / (near - far);
        float _t10_inv = 1.0f / (_t0 - _t1);
        float _t11_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t10_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t11_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t5_inv), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 + _t0)).fma(_sv2, _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 + _t2)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t5_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5_inv = 1.0f / (near - far);
        float _t10_inv = 1.0f / (_t0 - _t1);
        float _t11_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t10_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t11_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 1.0f : (far + near) * _t5_inv)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 + _t0)).mul(_sv2).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 + _t2)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -(2.0f * near) : near == Float.POSITIVE_INFINITY ? 2.0f * far : 2.0f * far * near * _t5_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveOffCenterFov_zo_lh_fma(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return perspectiveOffCenterFov_zo_lh_mulAdd(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_zo_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4_inv = 1.0f / (near - far);
        float _t6_inv = 1.0f / (_t0 - _t1);
        float _t7_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t6_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t7_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t4_inv)), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t3 + _t2))).fma(_sv4, _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t1 + _t0))).fma(_sv2, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4_inv = 1.0f / (near - far);
        float _t6_inv = 1.0f / (_t0 - _t1);
        float _t7_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t6_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t7_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? 1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : -(far * _t4_inv))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t3 + _t2))).mul(_sv4).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t1 + _t0))).mul(_sv2).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        if (SimdSupport.USE_FMA) return perspectiveOffCenterFov_zo_rh_fma(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return perspectiveOffCenterFov_zo_rh_mulAdd(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static float[] perspectiveOffCenterFov_zo_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4_inv = 1.0f / (near - far);
        float _t6_inv = 1.0f / (_t0 - _t1);
        float _t7_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t6_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t7_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.fma(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t4_inv), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 + _t0)).fma(_sv2, _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 + _t2)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4_inv = 1.0f / (near - far);
        float _t6_inv = 1.0f / (_t0 - _t1);
        float _t7_inv = 1.0f / (_t2 - _t3);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.broadcast(SIMD_SPECIES, _t6_inv);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _t7_inv);
        var _sv5 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).mul(_sv2);
        var _c1 = _sv0.mul(_sv3).mul(_sv4);
        var _c2 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -1.0f : near == Float.POSITIVE_INFINITY ? 0.0f : far * _t4_inv)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 + _t0)).mul(_sv2).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 + _t2)).mul(_sv4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        var _c3 = _sv5.mul(FloatVector.broadcast(SIMD_SPECIES, far == Float.POSITIVE_INFINITY ? -near : near == Float.POSITIVE_INFINITY ? far : far * near * _t4_inv));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] pickMatrix(float[] dest, int destOffset, float[] src, int srcOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        if (SimdSupport.USE_FMA) return pickMatrix_fma(dest, destOffset, src, srcOffset, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return pickMatrix_mulAdd(dest, destOffset, src, srcOffset, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
    }

    public static float[] pickMatrix_fma(float[] dest, int destOffset, float[] src, int srcOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        float _rcp0 = 1.0f / deltaX;
        float _rcp1 = 1.0f / deltaY;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _rcp0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _rcp1);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, vpW).mul(_sv0).mul(_sv1);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, vpH).mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, centerX - vpX, vpW))).fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, centerY - vpY, vpH))).mul(_sv3)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] pickMatrix_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float centerX, float centerY, float deltaX, float deltaY, float vpX, float vpY, float vpW, float vpH) {
        float _rcp0 = 1.0f / deltaX;
        float _rcp1 = 1.0f / deltaY;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _rcp0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _rcp1);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, vpW).mul(_sv0).mul(_sv1);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, vpH).mul(_sv2).mul(_sv3);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, centerX - vpX, vpW))).mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, centerY - vpY, vpH))).mul(_sv3)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preScale(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        if (SimdSupport.USE_FMA) return preScale_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return preScale_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static float[] preScale_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preScale_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preScale(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return preScale_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return preScale_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] preScale_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, v[vOffset + 0]).withLane(1, v[vOffset + 1]).withLane(2, v[vOffset + 2])));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preScale_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, v[vOffset + 0]).withLane(1, v[vOffset + 1]).withLane(2, v[vOffset + 2])));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preScale(float[] dest, int destOffset, float[] src, int srcOffset, float s) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, s).mul(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preScaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
    }

    public static float[] preScaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _self30 = src[srcOffset + 3];
        float _self31 = src[srcOffset + 7];
        float _self32 = src[srcOffset + 11];
        float _self33 = src[srcOffset + 15];
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _self30);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _self31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self32);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self33);
        var _c0 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv1.mul(_sv2)).withLane(3, _self30);
        var _c1 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv3.mul(_sv2)).withLane(3, _self31);
        var _c2 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv4.mul(_sv2)).withLane(3, _self32);
        var _c3 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12), _sv5.mul(_sv2)).withLane(3, _self33);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preScaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _self30 = src[srcOffset + 3];
        float _self31 = src[srcOffset + 7];
        float _self32 = src[srcOffset + 11];
        float _self33 = src[srcOffset + 15];
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _self30);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _self31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self32);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self33);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv1.mul(_sv2)).withLane(3, _self30);
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv3.mul(_sv2)).withLane(3, _self31);
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv4.mul(_sv2)).withLane(3, _self32);
        var _c3 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)).add(_sv5.mul(_sv2)).withLane(3, _self33);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preScaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        if (SimdSupport.USE_FMA) return preScaleAround_fma(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return preScaleAround_mulAdd(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static float[] preScaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _self30 = src[srcOffset + 3];
        float _self31 = src[srcOffset + 7];
        float _self32 = src[srcOffset + 11];
        float _self33 = src[srcOffset + 15];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _self30);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _self31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self32);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self33);
        var _c0 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset), _sv1.mul(_sv2)).withLane(3, _self30);
        var _c1 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4), _sv3.mul(_sv2)).withLane(3, _self31);
        var _c2 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8), _sv4.mul(_sv2)).withLane(3, _self32);
        var _c3 = _sv0.fma(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12), _sv5.mul(_sv2)).withLane(3, _self33);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preScaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _self30 = src[srcOffset + 3];
        float _self31 = src[srcOffset + 7];
        float _self32 = src[srcOffset + 11];
        float _self33 = src[srcOffset + 15];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _self30);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, _self31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self32);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self33);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).add(_sv1.mul(_sv2)).withLane(3, _self30);
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).add(_sv3.mul(_sv2)).withLane(3, _self31);
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).add(_sv4.mul(_sv2)).withLane(3, _self32);
        var _c3 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)).add(_sv5.mul(_sv2)).withLane(3, _self33);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preTranslate(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        if (SimdSupport.USE_FMA) return preTranslate_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return preTranslate_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static float[] preTranslate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(FloatVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ), FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preTranslate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preTranslate(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return preTranslate_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return preTranslate_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] preTranslate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(FloatVector.zero(SIMD_SPECIES).withLane(0, v[vOffset + 0]).withLane(1, v[vOffset + 1]).withLane(2, v[vOffset + 2]), FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preTranslate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        for (int _li = 0; _li < 4; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, v[vOffset + 0]).withLane(1, v[vOffset + 1]).withLane(2, v[vOffset + 2])).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] reflect(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
    }

    public static float[] reflect_fma(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t10 = 2.0f * normalX * normalZ;
        float _t11 = 2.0f * normalX * normalY;
        float _t12 = 2.0f * normalY * normalZ;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, -_t11);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t10), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, normalX * normalX, 1.0f)), _sv2.mul(_sv3)));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t12), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, normalY * normalY, 1.0f)), _sv1.mul(_sv3)));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, normalZ * normalZ, 1.0f)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, -_t12), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t10))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] reflect_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t10 = 2.0f * normalX * normalZ;
        float _t11 = 2.0f * normalX * normalY;
        float _t12 = 2.0f * normalY * normalZ;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, -_t11);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t10)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, normalX * normalX, 1.0f))).add(_sv2.mul(_sv3)));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t12)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, normalY * normalY, 1.0f))).add(_sv1.mul(_sv3)));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, normalZ * normalZ, 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t12)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t10))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] reflect(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normal, normalOffset);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normal, normalOffset);
    }

    public static float[] reflect_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t10 = 2.0f * _normalx * _normalz;
        float _t11 = 2.0f * _normalx * _normaly;
        float _t12 = 2.0f * _normaly * _normalz;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, -_t11);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t10), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _normalx * _normalx, 1.0f)), _sv2.mul(_sv3)));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t12), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _normaly * _normaly, 1.0f)), _sv1.mul(_sv3)));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _normalz * _normalz, 1.0f)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, -_t12), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t10))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] reflect_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _normalx = normal[normalOffset + 0];
        float _normaly = normal[normalOffset + 1];
        float _normalz = normal[normalOffset + 2];
        float _t0 = -src[srcOffset + 8];
        float _t1 = -src[srcOffset + 9];
        float _t2 = -src[srcOffset + 10];
        float _t3 = -src[srcOffset + 11];
        float _t10 = 2.0f * _normalx * _normalz;
        float _t11 = 2.0f * _normalx * _normaly;
        float _t12 = 2.0f * _normaly * _normalz;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t1).withLane(2, _t2).withLane(3, _t3);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.broadcast(SIMD_SPECIES, -_t11);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t10)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _normalx * _normalx, 1.0f))).add(_sv2.mul(_sv3)));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t12)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _normaly * _normaly, 1.0f))).add(_sv1.mul(_sv3)));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _normalz * _normalz, 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t12)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t10))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAround(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static float[] rotateAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotX;
        float _t1 = -pivotY;
        float _t2 = -pivotZ;
        float _t3 = rotY * rotW;
        float _t4 = rotZ * rotZ;
        float _t5 = rotZ * rotW;
        float _t21 = 2.0f * Math.fma(rotX, rotY, _t5);
        float _t22 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t23 = 2.0f * Math.fma(rotX, rotZ, _t3);
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t3);
        float _t25 = 2.0f * Math.fma(rotX, rotY, -_t5);
        float _t26 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t27 = Math.fma(-2.0f, Math.fma(rotY, rotY, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(rotX, rotX, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(rotX, rotX, rotY * rotY), 1.0f);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t24), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t27), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t22), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t25), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t29), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t23), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t26))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, pivotX)))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, pivotY)))), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, pivotZ)))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotX;
        float _t1 = -pivotY;
        float _t2 = -pivotZ;
        float _t3 = rotY * rotW;
        float _t4 = rotZ * rotZ;
        float _t5 = rotZ * rotW;
        float _t21 = 2.0f * Math.fma(rotX, rotY, _t5);
        float _t22 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t23 = 2.0f * Math.fma(rotX, rotZ, _t3);
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t3);
        float _t25 = 2.0f * Math.fma(rotX, rotY, -_t5);
        float _t26 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t27 = Math.fma(-2.0f, Math.fma(rotY, rotY, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(rotX, rotX, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(rotX, rotX, rotY * rotY), 1.0f);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t24)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t27)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t22)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t25)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t29)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t23)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t26))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, pivotX))))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, pivotY))))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, pivotZ))))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static float[] rotateAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _roty = rot[rotOffset + 1];
        float _rotw = rot[rotOffset + 3];
        float _rotz = rot[rotOffset + 2];
        float _rotx = rot[rotOffset + 0];
        float _t0 = -_pivotx;
        float _t1 = -_pivoty;
        float _t2 = -_pivotz;
        float _t3 = _roty * _rotw;
        float _t4 = _rotz * _rotz;
        float _t5 = _rotz * _rotw;
        float _t21 = 2.0f * Math.fma(_rotx, _roty, _t5);
        float _t22 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t23 = 2.0f * Math.fma(_rotx, _rotz, _t3);
        float _t24 = 2.0f * Math.fma(_rotx, _rotz, -_t3);
        float _t25 = 2.0f * Math.fma(_rotx, _roty, -_t5);
        float _t26 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t27 = Math.fma(-2.0f, Math.fma(_roty, _roty, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _roty * _roty), 1.0f);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t24), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t27), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t22), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t25), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t29), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t23), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t26))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, _pivotx)))), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, _pivoty)))), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, _pivotz)))), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _roty = rot[rotOffset + 1];
        float _rotw = rot[rotOffset + 3];
        float _rotz = rot[rotOffset + 2];
        float _rotx = rot[rotOffset + 0];
        float _t0 = -_pivotx;
        float _t1 = -_pivoty;
        float _t2 = -_pivotz;
        float _t3 = _roty * _rotw;
        float _t4 = _rotz * _rotz;
        float _t5 = _rotz * _rotw;
        float _t21 = 2.0f * Math.fma(_rotx, _roty, _t5);
        float _t22 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t23 = 2.0f * Math.fma(_rotx, _rotz, _t3);
        float _t24 = 2.0f * Math.fma(_rotx, _rotz, -_t3);
        float _t25 = 2.0f * Math.fma(_rotx, _roty, -_t5);
        float _t26 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t27 = Math.fma(-2.0f, Math.fma(_roty, _roty, _t4), 1.0f);
        float _t28 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _t4), 1.0f);
        float _t29 = Math.fma(-2.0f, Math.fma(_rotx, _rotx, _roty * _roty), 1.0f);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t24)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t27)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t22)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t25)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t28))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t29)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t23)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t26))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t27, Math.fma(_t1, _t25, Math.fma(_t2, _t23, _pivotx))))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t21, Math.fma(_t1, _t28, Math.fma(_t2, _t26, _pivoty))))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t24, Math.fma(_t1, _t22, Math.fma(_t2, _t29, _pivotz))))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAxis(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        if (SimdSupport.USE_FMA) return rotateAxis_fma(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return rotateAxis_mulAdd(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    public static float[] rotateAxis_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(axisY * _t1))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisX * axisX, _t0)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t1, _t2 * _t6)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t1, _t2 * _t7)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t6, -(axisZ * _t1))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisY * axisY, _t0)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisZ * axisZ, _t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t1, _t2 * _t3)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(axisX * _t1))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAxis_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = axisX * axisZ;
        float _t6 = axisX * axisY;
        float _t7 = axisY * axisZ;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(axisY * _t1)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisX * axisX, _t0))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t1, _t2 * _t6)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t1, _t2 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t6, -(axisZ * _t1)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisY * axisY, _t0)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisZ * axisZ, _t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t1, _t2 * _t3))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(axisX * _t1))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAxis(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        if (SimdSupport.USE_FMA) return rotateAxis_fma(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return rotateAxis_mulAdd(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    public static float[] rotateAxis_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        float _axisy = axis[axisOffset + 1];
        float _axisx = axis[axisOffset + 0];
        float _axisz = axis[axisOffset + 2];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = _axisx * _axisz;
        float _t6 = _axisx * _axisy;
        float _t7 = _axisy * _axisz;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_axisy * _t1))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisx * _axisx, _t0)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t1, _t2 * _t6)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t1, _t2 * _t7)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t6, -(_axisz * _t1))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisy * _axisy, _t0)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisz * _axisz, _t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t1, _t2 * _t3)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(_axisx * _t1))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateAxis_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        float _axisy = axis[axisOffset + 1];
        float _axisx = axis[axisOffset + 0];
        float _axisz = axis[axisOffset + 2];
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t3 = _axisx * _axisz;
        float _t6 = _axisx * _axisy;
        float _t7 = _axisy * _axisz;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_axisy * _t1)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisx * _axisx, _t0))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t1, _t2 * _t6)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t1, _t2 * _t7))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t6, -(_axisz * _t1)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisy * _axisy, _t0)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisz * _axisz, _t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t1, _t2 * _t3))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(_axisx * _t1))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateQuat(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        if (SimdSupport.USE_FMA) return rotateQuat_fma(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return rotateQuat_mulAdd(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    public static float[] rotateQuat_fma(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, -_t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, _t2)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qW, qY * qZ)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, -_t2)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, _t0)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qY, qZ, -(qX * qW))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateQuat_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, -_t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, _t2)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qW, qY * qZ))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, -_t2))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, _t0))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qY, qZ, -(qX * qW))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateQuat(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
        if (SimdSupport.USE_FMA) return rotateQuat_fma(dest, destOffset, src, srcOffset, q, qOffset);
        return rotateQuat_mulAdd(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static float[] rotateQuat_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
        float _qx = q[qOffset + 0];
        float _qz = q[qOffset + 2];
        float _qy = q[qOffset + 1];
        float _qw = q[qOffset + 3];
        float _t0 = _qy * _qw;
        float _t1 = _qz * _qz;
        float _t2 = _qz * _qw;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, -_t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qy, _qy, _t1), 1.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, _t2)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qw, _qy * _qz)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, -_t2)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _t1), 1.0f)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, _t0)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateQuat_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
        float _qx = q[qOffset + 0];
        float _qz = q[qOffset + 2];
        float _qy = q[qOffset + 1];
        float _qw = q[qOffset + 3];
        float _t0 = _qy * _qw;
        float _t1 = _qz * _qz;
        float _t2 = _qz * _qw;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, -_t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qy, _qy, _t1), 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, _t2)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qw, _qy * _qz))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, -_t2))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _t1), 1.0f)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, _t0))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateX(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return rotateX_fma(dest, destOffset, src, srcOffset, angle);
        return rotateX_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] rotateX_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)));
        var _c2 = _sv2.fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateX_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)));
        var _c2 = _sv2.mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateXYZ(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateXYZ_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateXYZ_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateXYZ_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t8 = _t0 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t1, -(_t6 * _t4))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t4), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t4, _t1 * _t3)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t1, _t0 * _t4)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, -(_t8 * _t1))), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t1 * _t5)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t5), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t2), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t5)))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateXYZ_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.sin(angleY);
        float _t3 = (float) Math.cos(angleX);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleY);
        float _t6 = _t2 * _t3;
        float _t8 = _t0 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t1, -(_t6 * _t4)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t4)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t4, _t1 * _t3)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t1, _t0 * _t4))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t3, _t4, -(_t8 * _t1)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t1 * _t5)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t5)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t2)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t5)))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateXZY(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateXZY_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateXZY_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateXZY_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t9 = _t1 * _t4;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t2, -(_t3 * _t4))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t2 * _t5), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t2, _t0 * _t3)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t0 * _t5), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _t4 * _t5), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t3, _t4 * _t2)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t5), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t3, -(_t0 * _t2))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateXZY_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.sin(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.cos(angleZ);
        float _t6 = _t0 * _t1;
        float _t9 = _t1 * _t4;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t2, -(_t3 * _t4)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t2 * _t5)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t2, _t0 * _t3)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t0 * _t5)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t4 * _t5)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t3, _t4 * _t2))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t5)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t3, -(_t0 * _t2))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateY(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return rotateY_fma(dest, destOffset, src, srcOffset, angle);
        return rotateY_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] rotateY_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t1), _sv2.mul(_sv1));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateY_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)).add(_sv2.mul(_sv1));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateYXZ(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateYXZ_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateYXZ_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateYXZ_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t2, -(_t3 * _t4))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t2, _t1 * _t4)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t2 * _t5))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t4, _t3 * _t2)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t4, -(_t2 * _t1))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t4))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t1), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t5), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t0))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateYXZ_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t2, -(_t3 * _t4)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t2, _t1 * _t4))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t2 * _t5))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t6, _t4, _t3 * _t2))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t4, -(_t2 * _t1)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t4))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t1)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t5)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t0))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateYZX(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateYZX_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateYZX_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateYZX_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t1)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t2 * _t1), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t3))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t4, _t5 * _t2)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t5, _t0, -(_t10 * _t4))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t4 * _t1))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t4, _t2, -(_t8 * _t5))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t10, _t5, _t0 * _t4)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t5 * _t1)))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateYZX_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleZ);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.cos(angleX);
        float _t5 = (float) Math.sin(angleX);
        float _t8 = _t0 * _t3;
        float _t10 = _t3 * _t2;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t1))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t2 * _t1)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t3))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t4, _t5 * _t2))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t5, _t0, -(_t10 * _t4)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t4 * _t1))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t4, _t2, -(_t8 * _t5)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t10, _t5, _t0 * _t4))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t5 * _t1)))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateZ(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return rotateZ_fma(dest, destOffset, src, srcOffset, angle);
        return rotateZ_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] rotateZ_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)));
        var _c1 = _sv2.fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateZ_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)));
        var _c1 = _sv2.mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateZXY(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateZXY_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateZXY_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateZXY_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t1)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_t7 * _t0))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t0, _t5 * _t2)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t4), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t3), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t5 * _t1)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t2), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t7, _t2, _t0 * _t3)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, -(_t8 * _t2))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateZXY_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleX);
        float _t2 = (float) Math.cos(angleY);
        float _t3 = (float) Math.cos(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.sin(angleZ);
        float _t7 = _t4 * _t5;
        float _t8 = _t4 * _t3;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t0 * _t1))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_t7 * _t0)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t8, _t0, _t5 * _t2)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t4)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t3)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, -(_t5 * _t1)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t2)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t7, _t2, _t0 * _t3))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t5, -(_t8 * _t2))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateZYX(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateZYX_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateZYX_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateZYX_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, -_t0), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t2), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t1))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t4 * _t1), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t4, -(_t3 * _t5))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, _t5 * _t2)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t1), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t5, _t4 * _t3)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t5, -(_t4 * _t2))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] rotateZYX_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _t0 = (float) Math.sin(angleY);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.cos(angleZ);
        float _t3 = (float) Math.sin(angleZ);
        float _t4 = (float) Math.sin(angleX);
        float _t5 = (float) Math.cos(angleX);
        float _t9 = _t0 * _t2;
        float _t11 = _t0 * _t3;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t0)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t1 * _t2)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t3 * _t1))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t4 * _t1)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t4, -(_t3 * _t5)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t4, _t5 * _t2)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t5 * _t1)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t9, _t5, _t4 * _t3))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t11, _t5, -(_t4 * _t2))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scale(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, vX));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, vY));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, vZ));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scale(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0]));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1]));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2]));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scale(float[] dest, int destOffset, float[] src, int srcOffset, float s) {
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, s, pivotX, pivotY, pivotZ);
    }

    public static float[] scaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1);
        var _c1 = _sv0.mul(_sv2);
        var _c2 = _sv0.mul(_sv3);
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, pivotX, pivotX)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, pivotY, pivotY)), _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, pivotZ, pivotZ)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1);
        var _c1 = _sv0.mul(_sv2);
        var _c2 = _sv0.mul(_sv3);
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, pivotX, pivotX))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, pivotY, pivotY))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, pivotZ, pivotZ))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, pivot, pivotOffset, s);
    }

    public static float[] scaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1);
        var _c1 = _sv0.mul(_sv2);
        var _c2 = _sv0.mul(_sv3);
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, _pivotx, _pivotx)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, _pivoty, _pivoty)), _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, _pivotz, _pivotz)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1);
        var _c1 = _sv0.mul(_sv2);
        var _c2 = _sv0.mul(_sv3);
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, _pivotx, _pivotx))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, _pivoty, _pivoty))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-s, _pivotz, _pivotz))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static float[] scaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, sX).mul(_sv0);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, sY).mul(_sv1);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, sZ).mul(_sv2);
        var _c3 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotX, sX, pivotX)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotY, sY, pivotY)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotZ, sZ, pivotZ)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, sX).mul(_sv0);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, sY).mul(_sv1);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, sZ).mul(_sv2);
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotX, sX, pivotX))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotY, sY, pivotY))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotZ, sZ, pivotZ))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] s, int sOffset, float[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, s, sOffset, pivot, pivotOffset);
    }

    public static float[] scaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] s, int sOffset, float[] pivot, int pivotOffset) {
        float _sx = s[sOffset + 0];
        float _sy = s[sOffset + 1];
        float _sz = s[sOffset + 2];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, _sx).mul(_sv0);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, _sy).mul(_sv1);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, _sz).mul(_sv2);
        var _c3 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivotx, _sx, _pivotx)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivoty, _sy, _pivoty)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivotz, _sz, _pivotz)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] scaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] s, int sOffset, float[] pivot, int pivotOffset) {
        float _sx = s[sOffset + 0];
        float _sy = s[sOffset + 1];
        float _sz = s[sOffset + 2];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, _sx).mul(_sv0);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, _sy).mul(_sv1);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, _sz).mul(_sv2);
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivotx, _sx, _pivotx))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivoty, _sy, _pivoty))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivotz, _sz, _pivotz))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] shadow(float[] dest, int destOffset, float[] src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        if (SimdSupport.USE_FMA) return shadow_fma(dest, destOffset, src, srcOffset, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return shadow_mulAdd(dest, destOffset, src, srcOffset, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
    }

    public static float[] shadow_fma(float[] dest, int destOffset, float[] src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        float _t0 = -src[srcOffset + 12];
        float _t1 = -src[srcOffset + 8];
        float _t5 = -src[srcOffset + 4];
        float _t7 = -src[srcOffset + 13];
        float _t8 = -src[srcOffset + 9];
        float _t9 = -src[srcOffset + 5];
        float _t10 = -src[srcOffset + 14];
        float _t11 = -src[srcOffset + 10];
        float _t12 = -src[srcOffset + 6];
        float _t13 = -src[srcOffset + 15];
        float _t14 = -src[srcOffset + 11];
        float _t15 = -src[srcOffset + 7];
        float _t32 = Math.fma(lightX, planeX, lightY * planeY) + Math.fma(lightZ, planeZ, lightW * planeW);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t7).withLane(2, _t10).withLane(3, _t13);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t8).withLane(2, _t11).withLane(3, _t14);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t5).withLane(1, _t9).withLane(2, _t12).withLane(3, _t15);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, lightW * planeX), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, lightZ * planeX), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightX, planeX, _t32)), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightY * planeX))))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, lightW * planeY), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, lightZ * planeY), _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightY, planeY, _t32)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightX * planeY))))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, lightW * planeZ), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightZ, planeZ, _t32)), _sv4.fma(FloatVector.broadcast(SIMD_SPECIES, lightY * planeZ), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightX * planeZ))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightW, planeW, _t32)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, lightZ * planeW), _sv4.fma(FloatVector.broadcast(SIMD_SPECIES, lightY * planeW), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightX * planeW))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] shadow_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float lightX, float lightY, float lightZ, float lightW, float planeX, float planeY, float planeZ, float planeW) {
        float _t0 = -src[srcOffset + 12];
        float _t1 = -src[srcOffset + 8];
        float _t5 = -src[srcOffset + 4];
        float _t7 = -src[srcOffset + 13];
        float _t8 = -src[srcOffset + 9];
        float _t9 = -src[srcOffset + 5];
        float _t10 = -src[srcOffset + 14];
        float _t11 = -src[srcOffset + 10];
        float _t12 = -src[srcOffset + 6];
        float _t13 = -src[srcOffset + 15];
        float _t14 = -src[srcOffset + 11];
        float _t15 = -src[srcOffset + 7];
        float _t32 = Math.fma(lightX, planeX, lightY * planeY) + Math.fma(lightZ, planeZ, lightW * planeW);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t7).withLane(2, _t10).withLane(3, _t13);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t8).withLane(2, _t11).withLane(3, _t14);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t5).withLane(1, _t9).withLane(2, _t12).withLane(3, _t15);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, lightW * planeX)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, lightZ * planeX)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightX, planeX, _t32))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightY * planeX))))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, lightW * planeY)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, lightZ * planeY)).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightY, planeY, _t32))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightX * planeY))))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, lightW * planeZ)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightZ, planeZ, _t32))).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, lightY * planeZ)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightX * planeZ))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-lightW, planeW, _t32))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, lightZ * planeW)).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, lightY * planeW)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(lightX * planeW))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] shadow(float[] dest, int destOffset, float[] src, int srcOffset, float[] light, int lightOffset, float[] plane, int planeOffset) {
        if (SimdSupport.USE_FMA) return shadow_fma(dest, destOffset, src, srcOffset, light, lightOffset, plane, planeOffset);
        return shadow_mulAdd(dest, destOffset, src, srcOffset, light, lightOffset, plane, planeOffset);
    }

    public static float[] shadow_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] light, int lightOffset, float[] plane, int planeOffset) {
        float _lightw = light[lightOffset + 3];
        float _planex = plane[planeOffset + 0];
        float _lightz = light[lightOffset + 2];
        float _lightx = light[lightOffset + 0];
        float _lighty = light[lightOffset + 1];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t0 = -src[srcOffset + 12];
        float _t1 = -src[srcOffset + 8];
        float _t5 = -src[srcOffset + 4];
        float _t7 = -src[srcOffset + 13];
        float _t8 = -src[srcOffset + 9];
        float _t9 = -src[srcOffset + 5];
        float _t10 = -src[srcOffset + 14];
        float _t11 = -src[srcOffset + 10];
        float _t12 = -src[srcOffset + 6];
        float _t13 = -src[srcOffset + 15];
        float _t14 = -src[srcOffset + 11];
        float _t15 = -src[srcOffset + 7];
        float _t32 = Math.fma(_lightx, _planex, _lighty * _planey) + Math.fma(_lightz, _planez, _lightw * _planew);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t7).withLane(2, _t10).withLane(3, _t13);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t8).withLane(2, _t11).withLane(3, _t14);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t5).withLane(1, _t9).withLane(2, _t12).withLane(3, _t15);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _lightw * _planex), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _lightz * _planex), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lightx, _planex, _t32)), _sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lighty * _planex))))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _lightw * _planey), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _lightz * _planey), _sv3.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lighty, _planey, _t32)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lightx * _planey))))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _lightw * _planez), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lightz, _planez, _t32)), _sv4.fma(FloatVector.broadcast(SIMD_SPECIES, _lighty * _planez), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lightx * _planez))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lightw, _planew, _t32)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _lightz * _planew), _sv4.fma(FloatVector.broadcast(SIMD_SPECIES, _lighty * _planew), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lightx * _planew))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] shadow_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] light, int lightOffset, float[] plane, int planeOffset) {
        float _lightw = light[lightOffset + 3];
        float _planex = plane[planeOffset + 0];
        float _lightz = light[lightOffset + 2];
        float _lightx = light[lightOffset + 0];
        float _lighty = light[lightOffset + 1];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t0 = -src[srcOffset + 12];
        float _t1 = -src[srcOffset + 8];
        float _t5 = -src[srcOffset + 4];
        float _t7 = -src[srcOffset + 13];
        float _t8 = -src[srcOffset + 9];
        float _t9 = -src[srcOffset + 5];
        float _t10 = -src[srcOffset + 14];
        float _t11 = -src[srcOffset + 10];
        float _t12 = -src[srcOffset + 6];
        float _t13 = -src[srcOffset + 15];
        float _t14 = -src[srcOffset + 11];
        float _t15 = -src[srcOffset + 7];
        float _t32 = Math.fma(_lightx, _planex, _lighty * _planey) + Math.fma(_lightz, _planez, _lightw * _planew);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t0).withLane(1, _t7).withLane(2, _t10).withLane(3, _t13);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t8).withLane(2, _t11).withLane(3, _t14);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv4 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t5).withLane(1, _t9).withLane(2, _t12).withLane(3, _t15);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _lightw * _planex)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _lightz * _planex)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lightx, _planex, _t32))).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lighty * _planex))))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _lightw * _planey)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _lightz * _planey)).add(_sv3.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lighty, _planey, _t32))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lightx * _planey))))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _lightw * _planez)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lightz, _planez, _t32))).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, _lighty * _planez)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lightx * _planez))))));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_lightw, _planew, _t32))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _lightz * _planew)).add(_sv4.mul(FloatVector.broadcast(SIMD_SPECIES, _lighty * _planew)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -(_lightx * _planew))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] shear(float[] dest, int destOffset, float[] src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        if (SimdSupport.USE_FMA) return shear_fma(dest, destOffset, src, srcOffset, xy, xz, yx, yz, zx, zy);
        return shear_mulAdd(dest, destOffset, src, srcOffset, xy, xz, yx, yz, zx, zy);
    }

    public static float[] shear_fma(float[] dest, int destOffset, float[] src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, yx).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, zx).fma(_sv1, _sv2));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, xy).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, zy).fma(_sv1, _sv0));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, xz).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, yz).fma(_sv0, _sv1));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] shear_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float xy, float xz, float yx, float yz, float zx, float zy) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, yx).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, zx).mul(_sv1).add(_sv2));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, xy).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, zy).mul(_sv1).add(_sv0));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, xz).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, yz).mul(_sv0).add(_sv1));
        var _c3 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] tile(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y, float w, float h) {
        if (SimdSupport.USE_FMA) return tile_fma(dest, destOffset, src, srcOffset, x, y, w, h);
        return tile_mulAdd(dest, destOffset, src, srcOffset, x, y, w, h);
    }

    public static float[] tile_fma(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y, float w, float h) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, w).mul(_sv0);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, h).mul(_sv1);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, x, w - 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, y, h - 1.0f)), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] tile_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y, float w, float h) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, w).mul(_sv0);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, h).mul(_sv1);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, x, w - 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, y, h - 1.0f))).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] translate(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        if (SimdSupport.USE_FMA) return translate_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return translate_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static float[] translate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv2;
        var _c3 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, vX), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, vY), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, vZ), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] translate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv2;
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, vX)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, vY)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, vZ)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] translate(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return translate_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return translate_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] translate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv2;
        var _c3 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0]), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1]), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2]), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] translate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0;
        var _c1 = _sv1;
        var _c2 = _sv2;
        var _c3 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0])).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2])).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] mulVec4(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ, float vW) {
        if (SimdSupport.USE_FMA) return mulVec4_fma(dest, destOffset, src, srcOffset, vX, vY, vZ, vW);
        return mulVec4_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ, vW);
    }

    public static float[] mulVec4_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ, float vW) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).fma(FloatVector.broadcast(SIMD_SPECIES, vW), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, vZ), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).fma(FloatVector.broadcast(SIMD_SPECIES, vX), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, vY)))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] mulVec4_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ, float vW) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).mul(FloatVector.broadcast(SIMD_SPECIES, vW)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, vZ)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, vX)).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, vY)))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] mulVec4(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return mulVec4_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return mulVec4_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] mulVec4_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).fma(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 3]), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).fma(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2]), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).fma(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0]), FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1])))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] mulVec4_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 12).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 3])).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2])).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0])).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1])))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static float[] transformPosition_vecArr(float[] dest, int destOffset, float[] matrix, int matrixOffset, float[] points, int pointsOffset, int count) {
        float _m00 = matrix[matrixOffset + 0];
        float _m01 = matrix[matrixOffset + 4];
        float _m02 = matrix[matrixOffset + 8];
        float _m03 = matrix[matrixOffset + 12];
        float _m10 = matrix[matrixOffset + 1];
        float _m11 = matrix[matrixOffset + 5];
        float _m12 = matrix[matrixOffset + 9];
        float _m13 = matrix[matrixOffset + 13];
        float _m20 = matrix[matrixOffset + 2];
        float _m21 = matrix[matrixOffset + 6];
        float _m22 = matrix[matrixOffset + 10];
        float _m23 = matrix[matrixOffset + 14];
        var _sp = FloatVector.SPECIES_128;
        var _c0 = FloatVector.zero(_sp).withLane(0, _m00).withLane(1, _m10).withLane(2, _m20);
        var _c1 = FloatVector.zero(_sp).withLane(0, _m01).withLane(1, _m11).withLane(2, _m21);
        var _c2 = FloatVector.zero(_sp).withLane(0, _m02).withLane(1, _m12).withLane(2, _m22);
        var _c3 = FloatVector.zero(_sp).withLane(0, _m03).withLane(1, _m13).withLane(2, _m23);
        float px = points[pointsOffset + 0], py = points[pointsOffset + 1], pz = points[pointsOffset + 2];
        int _i = 0;
        for (; _i < count - 1; _i++) {
            var _v = FloatVector.broadcast(_sp, px).fma(_c0, FloatVector.broadcast(_sp, py).fma(_c1, FloatVector.broadcast(_sp, pz).fma(_c2, _c3)));
            int _pn = pointsOffset + (_i + 1) * 3;
            px = points[_pn + 0]; py = points[_pn + 1]; pz = points[_pn + 2];
            _v.intoArray(dest, destOffset + _i * 3);
        }
        int _do = destOffset + _i * 3;
        dest[_do + 0] = Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03)));
        dest[_do + 1] = Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13)));
        dest[_do + 2] = Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23)));
        return dest;
    }

    public static float[] transformDirection_vecArr(float[] dest, int destOffset, float[] matrix, int matrixOffset, float[] points, int pointsOffset, int count) {
        float _m00 = matrix[matrixOffset + 0];
        float _m01 = matrix[matrixOffset + 4];
        float _m02 = matrix[matrixOffset + 8];
        float _m10 = matrix[matrixOffset + 1];
        float _m11 = matrix[matrixOffset + 5];
        float _m12 = matrix[matrixOffset + 9];
        float _m20 = matrix[matrixOffset + 2];
        float _m21 = matrix[matrixOffset + 6];
        float _m22 = matrix[matrixOffset + 10];
        var _sp = FloatVector.SPECIES_128;
        var _c0 = FloatVector.zero(_sp).withLane(0, _m00).withLane(1, _m10).withLane(2, _m20);
        var _c1 = FloatVector.zero(_sp).withLane(0, _m01).withLane(1, _m11).withLane(2, _m21);
        var _c2 = FloatVector.zero(_sp).withLane(0, _m02).withLane(1, _m12).withLane(2, _m22);
        float px = points[pointsOffset + 0], py = points[pointsOffset + 1], pz = points[pointsOffset + 2];
        int _i = 0;
        for (; _i < count - 1; _i++) {
            var _v = FloatVector.broadcast(_sp, pz).fma(_c2, FloatVector.broadcast(_sp, px).fma(_c0, FloatVector.broadcast(_sp, py).mul(_c1)));
            int _pn = pointsOffset + (_i + 1) * 3;
            px = points[_pn + 0]; py = points[_pn + 1]; pz = points[_pn + 2];
            _v.intoArray(dest, destOffset + _i * 3);
        }
        int _do = destOffset + _i * 3;
        dest[_do + 0] = Math.fma(_m02, pz, Math.fma(_m00, px, _m01 * py));
        dest[_do + 1] = Math.fma(_m12, pz, Math.fma(_m10, px, _m11 * py));
        dest[_do + 2] = Math.fma(_m22, pz, Math.fma(_m20, px, _m21 * py));
        return dest;
    }

    public static float[] transformProject_vecArr(float[] dest, int destOffset, float[] matrix, int matrixOffset, float[] points, int pointsOffset, int count) {
        float _m00 = matrix[matrixOffset + 0];
        float _m01 = matrix[matrixOffset + 4];
        float _m02 = matrix[matrixOffset + 8];
        float _m03 = matrix[matrixOffset + 12];
        float _m10 = matrix[matrixOffset + 1];
        float _m11 = matrix[matrixOffset + 5];
        float _m12 = matrix[matrixOffset + 9];
        float _m13 = matrix[matrixOffset + 13];
        float _m20 = matrix[matrixOffset + 2];
        float _m21 = matrix[matrixOffset + 6];
        float _m22 = matrix[matrixOffset + 10];
        float _m23 = matrix[matrixOffset + 14];
        float _m30 = matrix[matrixOffset + 3];
        float _m31 = matrix[matrixOffset + 7];
        float _m32 = matrix[matrixOffset + 11];
        float _m33 = matrix[matrixOffset + 15];
        var _sp = FloatVector.SPECIES_128;
        var _c0 = FloatVector.zero(_sp).withLane(0, _m00).withLane(1, _m10).withLane(2, _m20).withLane(3, _m30);
        var _c1 = FloatVector.zero(_sp).withLane(0, _m01).withLane(1, _m11).withLane(2, _m21).withLane(3, _m31);
        var _c2 = FloatVector.zero(_sp).withLane(0, _m02).withLane(1, _m12).withLane(2, _m22).withLane(3, _m32);
        var _c3 = FloatVector.zero(_sp).withLane(0, _m03).withLane(1, _m13).withLane(2, _m23).withLane(3, _m33);
        float px = points[pointsOffset + 0], py = points[pointsOffset + 1], pz = points[pointsOffset + 2];
        int _i = 0;
        for (; _i < count - 1; _i++) {
            var _v = FloatVector.broadcast(_sp, px).fma(_c0, FloatVector.broadcast(_sp, py).fma(_c1, FloatVector.broadcast(_sp, pz).fma(_c2, _c3)));
            float _inv = 1.0f / _v.lane(3);
            _v = _v.mul(FloatVector.broadcast(_sp, _inv));
            int _pn = pointsOffset + (_i + 1) * 3;
            px = points[_pn + 0]; py = points[_pn + 1]; pz = points[_pn + 2];
            _v.intoArray(dest, destOffset + _i * 3);
        }
        int _do = destOffset + _i * 3;
        float _w = Math.fma(_m30, px, Math.fma(_m31, py, Math.fma(_m32, pz, _m33)));
        float _inv = 1.0f / _w;
        dest[_do + 0] = (Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03)))) * _inv;
        dest[_do + 1] = (Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13)))) * _inv;
        dest[_do + 2] = (Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23)))) * _inv;
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
        if (PREFERRED_LANES >= 16) {
            FloatVector.fromArray(FloatVector.SPECIES_512, src, srcOffset).intoArray(dest, destOffset);
        }
        else if (PREFERRED_LANES >= 8) {
            FloatVector.fromArray(FloatVector.SPECIES_256, src, srcOffset).intoArray(dest, destOffset);
            FloatVector.fromArray(FloatVector.SPECIES_256, src, srcOffset + 8).intoArray(dest, destOffset + 8);
        }
        else {
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset).intoArray(dest, destOffset);
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + 4).intoArray(dest, destOffset + 4);
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + 8).intoArray(dest, destOffset + 8);
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + 12).intoArray(dest, destOffset + 12);
        }
    }


    public static float[] copy(float[] dest, int destOffset, float[] src, int srcOffset) {
        copyArrArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, float[] src, int srcOffset, int count) {
        copyArrArr(dest, destOffset, src, srcOffset, count * 16);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            for (int _i = 0; _i < 16; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 16);
        } else {
            for (int _i = 0; _i < count * 16; _i++)
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
            for (int _i = 0; _i < 16; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, float[] src, int srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 16);
        } else {
            for (int _i = 0; _i < count * 16; _i++)
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
                for (int _i = 0; _i < 16; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                for (int _i = 0; _i < 16; _i++)
                    dest.put(destOffset + _i, _srcArr[_srcOff + _i]);
            } else {
                for (int _i = 0; _i < 16; _i++)
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
                copyArrArr(_destArr, _destOff, _srcArr, _srcOff, count * 16);
            } else {
                for (int _i = 0; _i < count * 16; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                for (int _i = 0; _i < count * 16; _i++)
                    dest.put(destOffset + _i, _srcArr[_srcOff + _i]);
            } else {
                for (int _i = 0; _i < count * 16; _i++)
                    dest.put(destOffset + _i, src.get(srcOffset + _i));
            }
        }
        return dest;
    }
}
