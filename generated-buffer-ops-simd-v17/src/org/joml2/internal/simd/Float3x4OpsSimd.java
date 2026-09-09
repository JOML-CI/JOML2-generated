package org.joml2.internal.simd;

import jdk.incubator.vector.*;
import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Vector-API isolation cell for {@link Float3x4Ops}: every
 * {@code jdk.incubator.vector} reference of the Ops family lives in this class,
 * which is loaded and initialized only behind {@code SimdSupport.VECTOR_API}
 * guards - {@code Float3x4Ops} and its kernel siblings link
 * and run without the incubator module. Not public API.
 */
public final class Float3x4OpsSimd {
    private Float3x4OpsSimd() {}
    private static final VectorSpecies<Float> SIMD_SPECIES = FloatVector.SPECIES_128;
    private static final int PREFERRED_LANES = FloatVector.SPECIES_PREFERRED.length();
    private static final FloatVector UNIT_W = FloatVector.fromArray(SIMD_SPECIES, new float[]{0.0f, 0.0f, 0.0f, 1.0f}, 0);

    public static float[] getNormalizedRotation(float[] dest, int destOffset, float[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return getNormalizedRotation_fma(dest, destOffset, src, srcOffset);
        return getNormalizedRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static float[] getNormalizedRotation_fma(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self21 = src[srcOffset + 9];
        float _self01 = src[srcOffset + 1];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 2];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 4];
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
        float _self21 = src[srcOffset + 9];
        float _self01 = src[srcOffset + 1];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 2];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 4];
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
        float _self21 = src[srcOffset + 9];
        float _self12 = src[srcOffset + 6];
        float _self01 = src[srcOffset + 1];
        float _self10 = src[srcOffset + 4];
        float _self02 = src[srcOffset + 2];
        float _self20 = src[srcOffset + 8];
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
        float _self21 = src[srcOffset + 9];
        float _self12 = src[srcOffset + 6];
        float _self01 = src[srcOffset + 1];
        float _self10 = src[srcOffset + 4];
        float _self02 = src[srcOffset + 2];
        float _self20 = src[srcOffset + 8];
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

    public static float[] invert(float[] dest, int destOffset, float[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return invert_fma(dest, destOffset, src, srcOffset);
        return invert_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static float[] invert_fma(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self23 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 3];
        float _self13 = src[srcOffset + 7];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self12 = src[srcOffset + 6];
        float _self21 = src[srcOffset + 9];
        float _self10 = src[srcOffset + 4];
        float _self20 = src[srcOffset + 8];
        float _self02 = src[srcOffset + 2];
        float _self01 = src[srcOffset + 1];
        float _self00 = src[srcOffset + 0];
        float _t20 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t21 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t23 = Math.fma(_self02, _self21, -(_self01 * _self22));
        float _t24 = Math.fma(_self01, _self12, -(_self02 * _self11));
        float _t25 = Math.fma(_self12, _self20, -(_self10 * _self22));
        float _t26 = Math.fma(_self00, _self22, -(_self02 * _self20));
        float _t27 = Math.fma(_self02, _self10, -(_self00 * _self12));
        float _t28 = Math.fma(_self01, _self20, -(_self00 * _self21));
        float _t29 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t33_inv = 1.0f / Math.fma(_self02, _t21, Math.fma(_self00, _t20, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _t33_inv);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t23).withLane(2, _t24).mul(_sv0));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t25).withLane(1, _t26).withLane(2, _t27).mul(_sv0));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t21).withLane(1, _t28).withLane(2, _t29).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] invert_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self23 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 3];
        float _self13 = src[srcOffset + 7];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self12 = src[srcOffset + 6];
        float _self21 = src[srcOffset + 9];
        float _self10 = src[srcOffset + 4];
        float _self20 = src[srcOffset + 8];
        float _self02 = src[srcOffset + 2];
        float _self01 = src[srcOffset + 1];
        float _self00 = src[srcOffset + 0];
        float _t20 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t21 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t23 = Math.fma(_self02, _self21, -(_self01 * _self22));
        float _t24 = Math.fma(_self01, _self12, -(_self02 * _self11));
        float _t25 = Math.fma(_self12, _self20, -(_self10 * _self22));
        float _t26 = Math.fma(_self00, _self22, -(_self02 * _self20));
        float _t27 = Math.fma(_self02, _self10, -(_self00 * _self12));
        float _t28 = Math.fma(_self01, _self20, -(_self00 * _self21));
        float _t29 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t33_inv = 1.0f / Math.fma(_self02, _t21, Math.fma(_self00, _t20, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _t33_inv);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t23).withLane(2, _t24).mul(_sv0));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t25).withLane(1, _t26).withLane(2, _t27).mul(_sv0));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t21).withLane(1, _t28).withLane(2, _t29).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] invertProduct(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return invertProduct_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return invertProduct_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] invertProduct_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _other21 = other[otherOffset + 9];
        float _self12 = src[srcOffset + 6];
        float _other01 = other[otherOffset + 1];
        float _self10 = src[srcOffset + 4];
        float _other11 = other[otherOffset + 5];
        float _self11 = src[srcOffset + 5];
        float _other22 = other[otherOffset + 10];
        float _self22 = src[srcOffset + 10];
        float _other02 = other[otherOffset + 2];
        float _self20 = src[srcOffset + 8];
        float _other12 = other[otherOffset + 6];
        float _self21 = src[srcOffset + 9];
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _other20 = other[otherOffset + 8];
        float _other00 = other[otherOffset + 0];
        float _other10 = other[otherOffset + 4];
        float _other03 = other[otherOffset + 3];
        float _other13 = other[otherOffset + 7];
        float _other23 = other[otherOffset + 11];
        float _t24 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        float _t25 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        float _t26 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        float _t27 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        float _t28 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        float _t29 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        float _t30 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        float _t31 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        float _t32 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        float _t33 = Math.fma(_other03, _self20, Math.fma(_other13, _self21, Math.fma(_other23, _self22, src[srcOffset + 11])));
        float _t34 = Math.fma(_other03, _self00, Math.fma(_other13, _self01, Math.fma(_other23, _self02, src[srcOffset + 3])));
        float _t35 = Math.fma(_other03, _self10, Math.fma(_other13, _self11, Math.fma(_other23, _self12, src[srcOffset + 7])));
        float _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        float _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        float _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        float _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        float _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        float _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        float _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        float _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        float _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        float _t69_inv = 1.0f / Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _t69_inv);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t56).withLane(1, _t59).withLane(2, _t60).mul(_sv0));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t61).withLane(1, _t62).withLane(2, _t63).mul(_sv0));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv)).fma(UNIT_W, FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(1, _t64).withLane(2, _t65).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] invertProduct_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        float _other21 = other[otherOffset + 9];
        float _self12 = src[srcOffset + 6];
        float _other01 = other[otherOffset + 1];
        float _self10 = src[srcOffset + 4];
        float _other11 = other[otherOffset + 5];
        float _self11 = src[srcOffset + 5];
        float _other22 = other[otherOffset + 10];
        float _self22 = src[srcOffset + 10];
        float _other02 = other[otherOffset + 2];
        float _self20 = src[srcOffset + 8];
        float _other12 = other[otherOffset + 6];
        float _self21 = src[srcOffset + 9];
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _other20 = other[otherOffset + 8];
        float _other00 = other[otherOffset + 0];
        float _other10 = other[otherOffset + 4];
        float _other03 = other[otherOffset + 3];
        float _other13 = other[otherOffset + 7];
        float _other23 = other[otherOffset + 11];
        float _t24 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        float _t25 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        float _t26 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        float _t27 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        float _t28 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        float _t29 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        float _t30 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        float _t31 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        float _t32 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        float _t33 = Math.fma(_other03, _self20, Math.fma(_other13, _self21, Math.fma(_other23, _self22, src[srcOffset + 11])));
        float _t34 = Math.fma(_other03, _self00, Math.fma(_other13, _self01, Math.fma(_other23, _self02, src[srcOffset + 3])));
        float _t35 = Math.fma(_other03, _self10, Math.fma(_other13, _self11, Math.fma(_other23, _self12, src[srcOffset + 7])));
        float _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        float _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        float _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        float _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        float _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        float _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        float _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        float _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        float _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        float _t69_inv = 1.0f / Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _t69_inv);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t56).withLane(1, _t59).withLane(2, _t60).mul(_sv0));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t61).withLane(1, _t62).withLane(2, _t63).mul(_sv0));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv)).mul(UNIT_W).add(FloatVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(1, _t64).withLane(2, _t65).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] transpose(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] add(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] negate(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).neg();
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] sub(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).sub(FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] set(float[] dest, int destOffset, float[] v, int vOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, v, (vOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] withTranslation(float[] dest, int destOffset, float[] src, int srcOffset, float tX, float tY, float tZ) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, tX);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(3, tY);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(3, tZ);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] withTranslation(float[] dest, int destOffset, float[] src, int srcOffset, float[] t, int tOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, t[tOffset + 0]);
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(3, t[tOffset + 1]);
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(3, t[tOffset + 2]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, tSX).withLane(1, tSY).withLane(2, tSZ);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, tTX).fma(UNIT_W, _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(tRX, tRY, -_t1)).withLane(2, 2.0f * Math.fma(tRX, tRZ, _t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, tTY).fma(UNIT_W, _sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRY, _t1)).withLane(2, Math.fma(tRY, tRZ, -(tRX * tRW)))).withLane(1, Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, tTZ).fma(UNIT_W, _sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRZ, -_t2)).withLane(1, Math.fma(tRX, tRW, tRY * tRZ))).withLane(2, Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] makeFromTransform_mulAdd(float[] dest, int destOffset, float tTX, float tTY, float tTZ, float tRX, float tRY, float tRZ, float tRW, float tSX, float tSY, float tSZ) {
        float _t0 = tRZ * tRZ;
        float _t1 = tRZ * tRW;
        float _t2 = tRY * tRW;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, tSX).withLane(1, tSY).withLane(2, tSZ);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, tTX).mul(UNIT_W).add(_sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(tRY, tRY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(tRX, tRY, -_t1)).withLane(2, 2.0f * Math.fma(tRX, tRZ, _t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, tTY).mul(UNIT_W).add(_sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRY, _t1)).withLane(2, Math.fma(tRY, tRZ, -(tRX * tRW)))).withLane(1, Math.fma(-2.0f, Math.fma(tRX, tRX, _t0), 1.0f))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, tTZ).mul(UNIT_W).add(_sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRZ, -_t2)).withLane(1, Math.fma(tRX, tRW, tRY * tRZ))).withLane(2, Math.fma(-2.0f, Math.fma(tRX, tRX, tRY * tRY), 1.0f))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] decomposeRotation(float[] dest, int destOffset, float[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return decomposeRotation_fma(dest, destOffset, src, srcOffset);
        return decomposeRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static float[] decomposeRotation_fma(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self20 = src[srcOffset + 8];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 4];
        float _self21 = src[srcOffset + 9];
        float _self01 = src[srcOffset + 1];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 2];
        float _self12 = src[srcOffset + 6];
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
        float _self20 = src[srcOffset + 8];
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 4];
        float _self21 = src[srcOffset + 9];
        float _self01 = src[srcOffset + 1];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self02 = src[srcOffset + 2];
        float _self12 = src[srcOffset + 6];
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
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, t).fma(FloatVector.fromArray(SIMD_SPECIES, other, (otherOffset + _li * 4)).sub(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))), FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] lerp_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset, float t) {
        for (int _li = 0; _li < 3; _li++) {
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
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, right, rightOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, right, rightOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, right, rightOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0]), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1]), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2])))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mul_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, right, rightOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, right, rightOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, right, rightOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2])))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mulMat2x3(float[] dest, int destOffset, float[] src, int srcOffset, float[] right, int rightOffset) {
        float _right00 = right[rightOffset + 0];
        float _right01 = right[rightOffset + 2];
        float _right10 = right[rightOffset + 1];
        float _right11 = right[rightOffset + 3];
        float _right02 = right[rightOffset + 4];
        float _right12 = right[rightOffset + 5];
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, _right00).withLane(1, _right01).mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).withLane(2, src[(srcOffset + _li * 4) + 2]).add(FloatVector.broadcast(SIMD_SPECIES, _right10).withLane(1, _right11).mul(FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])).withLane(2, _right02 * src[(srcOffset + _li * 4) + 0] + _right12 * src[(srcOffset + _li * 4) + 1])).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preMul(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMul_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMul_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] preMul_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 3]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 0]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 1]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 2]).mul(_sv2))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preMul_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 3]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 0]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 1]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 2]).mul(_sv2))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preMulMat2x2(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x2_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x2_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] preMulMat2x2_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv1));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preMulMat2x2_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv1));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preMulMat2x3(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] preMulMat2x3_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c2 = _sv0;
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preMulMat2x3_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c2 = _sv0;
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preMulMat3x3(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat3x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat3x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] preMulMat3x3_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 6]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 7]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).mul(_sv2)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 8]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).mul(_sv2)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preMulMat3x3_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 6]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 7]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).mul(_sv2)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 8]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).mul(_sv2)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preMulMat4x4(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat4x4_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat4x4_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static float[] preMulMat4x4_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 9]), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 1]), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 5]))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 10]), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 2]), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 6]))));
        var _c3 = _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]), FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 12))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        _c3.intoArray(dest, destOffset + 12);
        return dest;
    }

    public static float[] preMulMat4x4_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] other, int otherOffset) {
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 8])).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 0])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 9])).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 1])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 5]))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 10])).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 2])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 6]))));
        var _c3 = _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3])).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7])).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11])).add(FloatVector.fromArray(SIMD_SPECIES, other, otherOffset + 12))));
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
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, scaleX).withLane(1, scaleY).withLane(2, scaleZ);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translationX).fma(UNIT_W, _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(rotationX, rotationY, -_t1)).withLane(2, 2.0f * Math.fma(rotationX, rotationZ, _t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translationY).fma(UNIT_W, _sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t1)).withLane(2, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).withLane(1, Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translationZ).fma(UNIT_W, _sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t2)).withLane(1, Math.fma(rotationX, rotationW, rotationY * rotationZ))).withLane(2, Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRS_mulAdd(float[] dest, int destOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationZ * rotationZ;
        float _t1 = rotationZ * rotationW;
        float _t2 = rotationY * rotationW;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, scaleX).withLane(1, scaleY).withLane(2, scaleZ);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translationX).mul(UNIT_W).add(_sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(rotationX, rotationY, -_t1)).withLane(2, 2.0f * Math.fma(rotationX, rotationZ, _t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translationY).mul(UNIT_W).add(_sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t1)).withLane(2, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).withLane(1, Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t0), 1.0f))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translationZ).mul(UNIT_W).add(_sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t2)).withLane(1, Math.fma(rotationX, rotationW, rotationY * rotationZ))).withLane(2, Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRS(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        if (SimdSupport.USE_FMA) return composeTRS_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset);
        return composeTRS_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset);
    }

    public static float[] composeTRS_fma(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        float _scalex = scale[scaleOffset + 0];
        float _scaley = scale[scaleOffset + 1];
        float _scalez = scale[scaleOffset + 2];
        float _rotationy = rotation[rotationOffset + 1];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationz = rotation[rotationOffset + 2];
        float _rotationw = rotation[rotationOffset + 3];
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _scalex).withLane(1, _scaley).withLane(2, _scalez);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).fma(UNIT_W, _sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(_rotationx, _rotationy, -_t1)).withLane(2, 2.0f * Math.fma(_rotationx, _rotationz, _t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).fma(UNIT_W, _sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t1)).withLane(2, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).withLane(1, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).fma(UNIT_W, _sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t2)).withLane(1, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).withLane(2, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRS_mulAdd(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset) {
        float _scalex = scale[scaleOffset + 0];
        float _scaley = scale[scaleOffset + 1];
        float _scalez = scale[scaleOffset + 2];
        float _rotationy = rotation[rotationOffset + 1];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationz = rotation[rotationOffset + 2];
        float _rotationw = rotation[rotationOffset + 3];
        float _t0 = _rotationz * _rotationz;
        float _t1 = _rotationz * _rotationw;
        float _t2 = _rotationy * _rotationw;
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _scalex).withLane(1, _scaley).withLane(2, _scalez);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, 2.0f);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).mul(UNIT_W).add(_sv0.mul(FloatVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t0), 1.0f)).withLane(1, 2.0f * Math.fma(_rotationx, _rotationy, -_t1)).withLane(2, 2.0f * Math.fma(_rotationx, _rotationz, _t2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).mul(UNIT_W).add(_sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t1)).withLane(2, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).withLane(1, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t0), 1.0f))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).mul(UNIT_W).add(_sv0.mul(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t2)).withLane(1, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).withLane(2, Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRSMul(float[] dest, int destOffset, float[] m, int mOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return composeTRSMul_mulAdd(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
    }

    public static float[] composeTRSMul_fma(float[] dest, int destOffset, float[] m, int mOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationY * rotationW;
        float _t1 = rotationZ * rotationZ;
        float _t2 = rotationZ * rotationW;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translationX).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t2)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t1), 1.0f))))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translationY).fma(UNIT_W, _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, scaleX * 2.0f * Math.fma(rotationX, rotationY, _t2)), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW))), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t1), 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translationZ).fma(UNIT_W, _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t0)), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRSMul_mulAdd(float[] dest, int destOffset, float[] m, int mOffset, float translationX, float translationY, float translationZ, float rotationX, float rotationY, float rotationZ, float rotationW, float scaleX, float scaleY, float scaleZ) {
        float _t0 = rotationY * rotationW;
        float _t1 = rotationZ * rotationZ;
        float _t2 = rotationZ * rotationW;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translationX).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, scaleZ * 2.0f * Math.fma(rotationX, rotationZ, _t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, scaleY * 2.0f * Math.fma(rotationX, rotationY, -_t2))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, scaleX * Math.fma(-2.0f, Math.fma(rotationY, rotationY, _t1), 1.0f))))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translationY).mul(UNIT_W).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, scaleX * 2.0f * Math.fma(rotationX, rotationY, _t2))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, scaleZ * 2.0f * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, scaleY * Math.fma(-2.0f, Math.fma(rotationX, rotationX, _t1), 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translationZ).mul(UNIT_W).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, scaleY * 2.0f * Math.fma(rotationX, rotationW, rotationY * rotationZ))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, scaleX * 2.0f * Math.fma(rotationX, rotationZ, -_t0))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, scaleZ * Math.fma(-2.0f, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0f))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRSMul(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset, float[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
        return composeTRSMul_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
    }

    public static float[] composeTRSMul_fma(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset, float[] m, int mOffset) {
        float _scalez = scale[scaleOffset + 2];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationz = rotation[rotationOffset + 2];
        float _scaley = scale[scaleOffset + 1];
        float _rotationy = rotation[rotationOffset + 1];
        float _scalex = scale[scaleOffset + 0];
        float _rotationw = rotation[rotationOffset + 3];
        float _t0 = _rotationy * _rotationw;
        float _t1 = _rotationz * _rotationz;
        float _t2 = _rotationz * _rotationw;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _scalez * 2.0f * Math.fma(_rotationx, _rotationz, _t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _scaley * 2.0f * Math.fma(_rotationx, _rotationy, -_t2)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _scalex * Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t1), 1.0f))))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).fma(UNIT_W, _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _scalex * 2.0f * Math.fma(_rotationx, _rotationy, _t2)), _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _scalez * 2.0f * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw))), _sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _scaley * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t1), 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).fma(UNIT_W, _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _scaley * 2.0f * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz)), _sv2.fma(FloatVector.broadcast(SIMD_SPECIES, _scalex * 2.0f * Math.fma(_rotationx, _rotationz, -_t0)), _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _scalez * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] composeTRSMul_mulAdd(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset, float[] m, int mOffset) {
        float _scalez = scale[scaleOffset + 2];
        float _rotationx = rotation[rotationOffset + 0];
        float _rotationz = rotation[rotationOffset + 2];
        float _scaley = scale[scaleOffset + 1];
        float _rotationy = rotation[rotationOffset + 1];
        float _scalex = scale[scaleOffset + 0];
        float _rotationw = rotation[rotationOffset + 3];
        float _t0 = _rotationy * _rotationw;
        float _t1 = _rotationz * _rotationz;
        float _t2 = _rotationz * _rotationw;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _scalez * 2.0f * Math.fma(_rotationx, _rotationz, _t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _scaley * 2.0f * Math.fma(_rotationx, _rotationy, -_t2))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _scalex * Math.fma(-2.0f, Math.fma(_rotationy, _rotationy, _t1), 1.0f))))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).mul(UNIT_W).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _scalex * 2.0f * Math.fma(_rotationx, _rotationy, _t2))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _scalez * 2.0f * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _scaley * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _t1), 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).mul(UNIT_W).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _scaley * 2.0f * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _scalex * 2.0f * Math.fma(_rotationx, _rotationz, -_t0))).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _scalez * Math.fma(-2.0f, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0f))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static float[] lookAt_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
        float _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        float _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
        float _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        float _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static float[] lookAt_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13 = _t8 > 0.0f ? _t4 * _t9 : 0.0f;
        float _t14 = _t8 > 0.0f ? _t5 * _t9 : 0.0f;
        float _t15 = _t8 > 0.0f ? _t3 * _t9 : 0.0f;
        float _t24 = Math.fma(upY, _t13, -(upX * _t14));
        float _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        float _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        float _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35 = _t30 > 0.0f ? _t26 * _t31 : 0.0f;
        float _t36 = _t30 > 0.0f ? _t25 * _t31 : 0.0f;
        float _t37 = _t30 > 0.0f ? _t24 * _t31 : 0.0f;
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        float _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _t3 = centerZ - eyeZ;
        float _t4 = centerX - eyeX;
        float _t5 = centerY - eyeY;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13 = _t8 > 0.0f ? _t4 * _t9 : 0.0f;
        float _t14 = _t8 > 0.0f ? _t5 * _t9 : 0.0f;
        float _t15 = _t8 > 0.0f ? _t3 * _t9 : 0.0f;
        float _t24 = Math.fma(upY, _t13, -(upX * _t14));
        float _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        float _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        float _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35 = _t30 > 0.0f ? _t26 * _t31 : 0.0f;
        float _t36 = _t30 > 0.0f ? _t25 * _t31 : 0.0f;
        float _t37 = _t30 > 0.0f ? _t24 * _t31 : 0.0f;
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        float _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_lh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_lh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static float[] lookAt_lh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
        float _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        float _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_lh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
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
        float _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32 = _t27 > 0.0f ? _t22 * _t28 : 0.0f;
        float _t33 = _t27 > 0.0f ? _t21 * _t28 : 0.0f;
        float _t34 = _t27 > 0.0f ? _t23 * _t28 : 0.0f;
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        float _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return lookAt_rh_fma(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return lookAt_rh_mulAdd(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static float[] lookAt_rh_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _eyez = eye[eyeOffset + 2];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _upy = up[upOffset + 1];
        float _upx = up[upOffset + 0];
        float _upz = up[upOffset + 2];
        float _t3 = center[centerOffset + 2] - _eyez;
        float _t4 = center[centerOffset + 0] - _eyex;
        float _t5 = center[centerOffset + 1] - _eyey;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13 = _t8 > 0.0f ? _t4 * _t9 : 0.0f;
        float _t14 = _t8 > 0.0f ? _t5 * _t9 : 0.0f;
        float _t15 = _t8 > 0.0f ? _t3 * _t9 : 0.0f;
        float _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        float _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        float _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        float _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35 = _t30 > 0.0f ? _t26 * _t31 : 0.0f;
        float _t36 = _t30 > 0.0f ? _t25 * _t31 : 0.0f;
        float _t37 = _t30 > 0.0f ? _t24 * _t31 : 0.0f;
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        float _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv1, FloatVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] lookAt_rh_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self22 = src[srcOffset + 10];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _eyez = eye[eyeOffset + 2];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _upy = up[upOffset + 1];
        float _upx = up[upOffset + 0];
        float _upz = up[upOffset + 2];
        float _t3 = center[centerOffset + 2] - _eyez;
        float _t4 = center[centerOffset + 0] - _eyex;
        float _t5 = center[centerOffset + 1] - _eyey;
        float _t8 = Math.fma(_t3, _t3, Math.fma(_t4, _t4, _t5 * _t5));
        float _t9 = (1.0f / (float) Math.sqrt(_t8));
        float _t13 = _t8 > 0.0f ? _t4 * _t9 : 0.0f;
        float _t14 = _t8 > 0.0f ? _t5 * _t9 : 0.0f;
        float _t15 = _t8 > 0.0f ? _t3 * _t9 : 0.0f;
        float _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        float _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        float _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        float _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        float _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t31 = (1.0f / (float) Math.sqrt(_t30));
        float _t35 = _t30 > 0.0f ? _t26 * _t31 : 0.0f;
        float _t36 = _t30 > 0.0f ? _t25 * _t31 : 0.0f;
        float _t37 = _t30 > 0.0f ? _t24 * _t31 : 0.0f;
        float _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        float _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        float _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        float _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(FloatVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv1).add(FloatVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] mapXYZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mapXYnZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).withLane(2, -src[(srcOffset + _li * 4) + 2]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] mapXnYZ(float[] dest, int destOffset, float[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).withLane(1, -src[(srcOffset + _li * 4) + 1]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preRotateAround(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static float[] preRotateAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t1 = rotY * rotW;
        float _t2 = rotZ * rotZ;
        float _t3 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t2);
        float _t13 = Math.fma(rotX, rotX, _t2);
        float _t14 = Math.fma(rotX, rotX, rotY * rotY);
        float _t19 = 2.0f * Math.fma(rotX, rotZ, _t1);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t3);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotY, -_t3);
        float _t23 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t1);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t22)))).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t19), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t11, 1.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(pivotY, 2.0f * _t13, -(pivotX * _t20)))).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t23), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t20), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t13, 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t14, -(pivotX * _t24)))).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t14, 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t24), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _t0 = -pivotZ;
        float _t1 = rotY * rotW;
        float _t2 = rotZ * rotZ;
        float _t3 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t2);
        float _t13 = Math.fma(rotX, rotX, _t2);
        float _t14 = Math.fma(rotX, rotX, rotY * rotY);
        float _t19 = 2.0f * Math.fma(rotX, rotZ, _t1);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t3);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotY, -_t3);
        float _t23 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t24 = 2.0f * Math.fma(rotX, rotZ, -_t1);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t22)))).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t19)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t11, 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(pivotY, 2.0f * _t13, -(pivotX * _t20)))).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t23)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t20)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t13, 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t14, -(pivotX * _t24)))).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t14, 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t24)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static float[] preRotateAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _roty = rot[rotOffset + 1];
        float _rotw = rot[rotOffset + 3];
        float _rotz = rot[rotOffset + 2];
        float _rotx = rot[rotOffset + 0];
        float _t0 = -_pivotz;
        float _t1 = _roty * _rotw;
        float _t2 = _rotz * _rotz;
        float _t3 = _rotz * _rotw;
        float _t11 = Math.fma(_roty, _roty, _t2);
        float _t13 = Math.fma(_rotx, _rotx, _t2);
        float _t14 = Math.fma(_rotx, _rotx, _roty * _roty);
        float _t19 = 2.0f * Math.fma(_rotx, _rotz, _t1);
        float _t20 = 2.0f * Math.fma(_rotx, _roty, _t3);
        float _t21 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t22 = 2.0f * Math.fma(_rotx, _roty, -_t3);
        float _t23 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t24 = 2.0f * Math.fma(_rotx, _rotz, -_t1);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(_pivotx, 2.0f * _t11, -(_pivoty * _t22)))).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t19), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t11, 1.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(_pivoty, 2.0f * _t13, -(_pivotx * _t20)))).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t23), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t20), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t13, 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0f * _t14, -(_pivotx * _t24)))).fma(UNIT_W, _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t14, 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, _t24), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _roty = rot[rotOffset + 1];
        float _rotw = rot[rotOffset + 3];
        float _rotz = rot[rotOffset + 2];
        float _rotx = rot[rotOffset + 0];
        float _t0 = -_pivotz;
        float _t1 = _roty * _rotw;
        float _t2 = _rotz * _rotz;
        float _t3 = _rotz * _rotw;
        float _t11 = Math.fma(_roty, _roty, _t2);
        float _t13 = Math.fma(_rotx, _rotx, _t2);
        float _t14 = Math.fma(_rotx, _rotx, _roty * _roty);
        float _t19 = 2.0f * Math.fma(_rotx, _rotz, _t1);
        float _t20 = 2.0f * Math.fma(_rotx, _roty, _t3);
        float _t21 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t22 = 2.0f * Math.fma(_rotx, _roty, -_t3);
        float _t23 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t24 = 2.0f * Math.fma(_rotx, _rotz, -_t1);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(_pivotx, 2.0f * _t11, -(_pivoty * _t22)))).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t19)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t11, 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(_pivoty, 2.0f * _t13, -(_pivotx * _t20)))).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t23)).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t20)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t13, 1.0f))))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0f * _t14, -(_pivotx * _t24)))).mul(UNIT_W).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, _t14, 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, _t24)).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAxis(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    public static float[] preRotateAxis_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = axisX * axisZ;
        float _t5 = axisX * axisY;
        float _t7 = axisY * axisZ;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t2 * _t3)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisX * axisX, _t1)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(axisZ * _t0))))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(axisX * _t0))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t2 * _t5)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisY * axisY, _t1)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisZ * axisZ, _t1)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(axisY * _t0))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAxis_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = axisX * axisZ;
        float _t5 = axisX * axisY;
        float _t7 = axisY * axisZ;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t2 * _t3))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisX * axisX, _t1))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(axisZ * _t0))))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(axisX * _t0)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t2 * _t5))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisY * axisY, _t1)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisZ * axisZ, _t1))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(axisY * _t0)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAxis(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, axis, axisOffset, angle);
    }

    public static float[] preRotateAxis_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        float _axisy = axis[axisOffset + 1];
        float _axisx = axis[axisOffset + 0];
        float _axisz = axis[axisOffset + 2];
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = _axisx * _axisz;
        float _t5 = _axisx * _axisy;
        float _t7 = _axisy * _axisz;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t2 * _t3)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisx * _axisx, _t1)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(_axisz * _t0))))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(_axisx * _t0))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t2 * _t5)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisz * _axisz, _t1)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_axisy * _t0))), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateAxis_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] axis, int axisOffset, float angle) {
        float _axisy = axis[axisOffset + 1];
        float _axisx = axis[axisOffset + 0];
        float _axisz = axis[axisOffset + 2];
        float _t0 = (float) Math.sin(angle);
        float _t1 = (float) Math.cos(angle);
        float _t2 = 1.0f - _t1;
        float _t3 = _axisx * _axisz;
        float _t5 = _axisx * _axisy;
        float _t7 = _axisy * _axisz;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t2 * _t3))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisx * _axisx, _t1))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(_axisz * _t0))))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(_axisx * _t0)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t2 * _t5))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisz * _axisz, _t1))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_axisy * _t0)))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateQuat(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    public static float[] preRotateQuat_fma(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, _t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, -_t2)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qY, qZ, -(qX * qW))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, _t2)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, -_t0)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qW, qY * qZ)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateQuat_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float qX, float qY, float qZ, float qW) {
        float _t0 = qY * qW;
        float _t1 = qZ * qZ;
        float _t2 = qZ * qW;
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, _t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qY, qY, _t1), 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, -_t2)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qY, qZ, -(qX * qW)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qY, _t2))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, _t1), 1.0f)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(qX, qX, qY * qY), 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qZ, -_t0))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(qX, qW, qY * qZ)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateQuat(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, q, qOffset);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static float[] preRotateQuat_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
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
        var _c0 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, _t0)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qy, _qy, _t1), 1.0f)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, -_t2)))));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw))), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, _t2)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _t1), 1.0f)))));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f)), _sv1.fma(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, -_t0)), _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qw, _qy * _qz)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateQuat_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] q, int qOffset) {
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
        var _c0 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, _t0))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qy, _qy, _t1), 1.0f))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, -_t2)))));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qy, _qz, -(_qx * _qw)))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qy, _t2))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _t1), 1.0f)))));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, Math.fma(-2.0f, Math.fma(_qx, _qx, _qy * _qy), 1.0f))).add(_sv1.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qz, -_t0))).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, 2.0f * Math.fma(_qx, _qw, _qy * _qz)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateX(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return preRotateX_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateX_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] preRotateX_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c2 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t1), _sv2.mul(_sv1));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateX_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c2 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)).add(_sv2.mul(_sv1));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateY(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return preRotateY_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateY_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] preRotateY_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv2.fma(_sv1, _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateY_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv2.mul(_sv1).add(_sv0.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateZ(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        if (SimdSupport.USE_FMA) return preRotateZ_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateZ_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static float[] preRotateZ_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c1 = _sv0.fma(FloatVector.broadcast(SIMD_SPECIES, _t1), _sv2.mul(_sv1));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preRotateZ_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        var _sv0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = FloatVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(FloatVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c1 = _sv0.mul(FloatVector.broadcast(SIMD_SPECIES, _t1)).add(_sv2.mul(_sv1));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preScale(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, vX));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, vY));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, vZ));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preScale(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0]));
        var _c1 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1]));
        var _c2 = FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2]));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preScale(float[] dest, int destOffset, float[] src, int srcOffset, float s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, s).mul(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] preScaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-s, pivotX, Math.fma(s, src[srcOffset + 3], pivotX)));
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-s, pivotY, Math.fma(s, src[srcOffset + 7], pivotY)));
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-s, pivotZ, Math.fma(s, src[srcOffset + 11], pivotZ)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preScaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-s, _pivotx, Math.fma(s, src[srcOffset + 3], _pivotx)));
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-s, _pivoty, Math.fma(s, src[srcOffset + 7], _pivoty)));
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-s, _pivotz, Math.fma(s, src[srcOffset + 11], _pivotz)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preScaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, sX).mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-pivotX, sX, Math.fma(sX, src[srcOffset + 3], pivotX)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, sY).mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-pivotY, sY, Math.fma(sY, src[srcOffset + 7], pivotY)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, sZ).mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-pivotZ, sZ, Math.fma(sZ, src[srcOffset + 11], pivotZ)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preScaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] s, int sOffset, float[] pivot, int pivotOffset) {
        float _sx = s[sOffset + 0];
        float _pivotx = pivot[pivotOffset + 0];
        float _sy = s[sOffset + 1];
        float _pivoty = pivot[pivotOffset + 1];
        float _sz = s[sOffset + 2];
        float _pivotz = pivot[pivotOffset + 2];
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, _sx).mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-_pivotx, _sx, Math.fma(_sx, src[srcOffset + 3], _pivotx)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, _sy).mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-_pivoty, _sy, Math.fma(_sy, src[srcOffset + 7], _pivoty)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, _sz).mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-_pivotz, _sz, Math.fma(_sz, src[srcOffset + 11], _pivotz)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preTranslate(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        if (SimdSupport.USE_FMA) return preTranslate_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return preTranslate_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static float[] preTranslate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, vX).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, vY).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, vZ).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preTranslate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, vX).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, vY).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, vZ).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preTranslate(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return preTranslate_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return preTranslate_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] preTranslate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] preTranslate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 0]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 1]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, v[vOffset + 2]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] reflect(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normalX, normalY, normalZ);
    }

    public static float[] reflect_fma(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _t2 = -_self22;
        float _t9 = 2.0f * normalX * normalZ;
        float _t10 = 2.0f * normalX * normalY;
        float _t11 = 2.0f * normalY * normalZ;
        float _t12 = Math.fma(-2.0f, normalX * normalX, 1.0f);
        float _t13 = Math.fma(-2.0f, normalY * normalY, 1.0f);
        float _t14 = Math.fma(-2.0f, normalZ * normalZ, 1.0f);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] reflect_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float normalX, float normalY, float normalZ) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _t2 = -_self22;
        float _t9 = 2.0f * normalX * normalZ;
        float _t10 = 2.0f * normalX * normalY;
        float _t11 = 2.0f * normalY * normalZ;
        float _t12 = Math.fma(-2.0f, normalX * normalX, 1.0f);
        float _t13 = Math.fma(-2.0f, normalY * normalY, 1.0f);
        float _t14 = Math.fma(-2.0f, normalZ * normalZ, 1.0f);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] reflect(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        if (SimdSupport.USE_FMA) return reflect_fma(dest, destOffset, src, srcOffset, normal, normalOffset);
        return reflect_mulAdd(dest, destOffset, src, srcOffset, normal, normalOffset);
    }

    public static float[] reflect_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _normalx = normal[normalOffset + 0];
        float _normalz = normal[normalOffset + 2];
        float _normaly = normal[normalOffset + 1];
        float _t2 = -_self22;
        float _t9 = 2.0f * _normalx * _normalz;
        float _t10 = 2.0f * _normalx * _normaly;
        float _t11 = 2.0f * _normaly * _normalz;
        float _t12 = Math.fma(-2.0f, _normalx * _normalx, 1.0f);
        float _t13 = Math.fma(-2.0f, _normaly * _normaly, 1.0f);
        float _t14 = Math.fma(-2.0f, _normalz * _normalz, 1.0f);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] reflect_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] normal, int normalOffset) {
        float _self02 = src[srcOffset + 2];
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self12 = src[srcOffset + 6];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _normalx = normal[normalOffset + 0];
        float _normalz = normal[normalOffset + 2];
        float _normaly = normal[normalOffset + 1];
        float _t2 = -_self22;
        float _t9 = 2.0f * _normalx * _normalz;
        float _t10 = 2.0f * _normalx * _normaly;
        float _t11 = 2.0f * _normaly * _normalz;
        float _t12 = Math.fma(-2.0f, _normalx * _normalx, 1.0f);
        float _t13 = Math.fma(-2.0f, _normaly * _normaly, 1.0f);
        float _t14 = Math.fma(-2.0f, _normalz * _normalz, 1.0f);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t11).withLane(2, _t14);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, -_self02).withLane(2, _self02).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self00 * _t12).withLane(1, _self01 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self00 * _t10)).withLane(2, -_self01 * _t11 + -(_self00 * _t9))).withLane(3, src[srcOffset + 3]);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, -_self12).withLane(2, _self12).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self10 * _t12).withLane(1, _self11 * _t13).sub(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self10 * _t10)).withLane(2, -_self11 * _t11 + -(_self10 * _t9))).withLane(3, src[srcOffset + 7]);
        var _c2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t2 * _t9 + _self20 * _t12 - _self21 * _t10).withLane(1, _t2 * _t11 + (_self21 * _t13 - _self20 * _t10)).withLane(2, _self22 * _t14 + (-_self21 * _t11 + -(_self20 * _t9))).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] rotateAround(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static float[] rotateAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _t0 = -pivotZ;
        float _t2 = rotY * rotW;
        float _t3 = rotZ * rotZ;
        float _t4 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t3);
        float _t14 = Math.fma(rotX, rotX, _t3);
        float _t15 = Math.fma(rotX, rotX, rotY * rotY);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t4);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotZ, _t2);
        float _t26 = 2.0f * Math.fma(rotX, rotZ, -_t2);
        float _t27 = 2.0f * Math.fma(rotX, rotY, -_t4);
        float _t28 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t29 = Math.fma(-2.0f, _t11, 1.0f);
        float _t30 = Math.fma(-2.0f, _t14, 1.0f);
        float _t31 = Math.fma(-2.0f, _t15, 1.0f);
        float _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t27)));
        float _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0f * _t14, -(pivotX * _t20)));
        float _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t15, -(pivotX * _t26)));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, _sv0.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, _sv4.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, _sv5.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] rotateAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float rotX, float rotY, float rotZ, float rotW, float pivotX, float pivotY, float pivotZ) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _t0 = -pivotZ;
        float _t2 = rotY * rotW;
        float _t3 = rotZ * rotZ;
        float _t4 = rotZ * rotW;
        float _t11 = Math.fma(rotY, rotY, _t3);
        float _t14 = Math.fma(rotX, rotX, _t3);
        float _t15 = Math.fma(rotX, rotX, rotY * rotY);
        float _t20 = 2.0f * Math.fma(rotX, rotY, _t4);
        float _t21 = 2.0f * Math.fma(rotX, rotW, rotY * rotZ);
        float _t22 = 2.0f * Math.fma(rotX, rotZ, _t2);
        float _t26 = 2.0f * Math.fma(rotX, rotZ, -_t2);
        float _t27 = 2.0f * Math.fma(rotX, rotY, -_t4);
        float _t28 = 2.0f * Math.fma(rotY, rotZ, -(rotX * rotW));
        float _t29 = Math.fma(-2.0f, _t11, 1.0f);
        float _t30 = Math.fma(-2.0f, _t14, 1.0f);
        float _t31 = Math.fma(-2.0f, _t15, 1.0f);
        float _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0f * _t11, -(pivotY * _t27)));
        float _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0f * _t14, -(pivotX * _t20)));
        float _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0f * _t15, -(pivotX * _t26)));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(_sv0.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(_sv4.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(_sv5.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] rotateAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return rotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return rotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static float[] rotateAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _pivotz = pivot[pivotOffset + 2];
        float _roty = rot[rotOffset + 1];
        float _rotw = rot[rotOffset + 3];
        float _rotz = rot[rotOffset + 2];
        float _rotx = rot[rotOffset + 0];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _t0 = -_pivotz;
        float _t2 = _roty * _rotw;
        float _t3 = _rotz * _rotz;
        float _t4 = _rotz * _rotw;
        float _t11 = Math.fma(_roty, _roty, _t3);
        float _t14 = Math.fma(_rotx, _rotx, _t3);
        float _t15 = Math.fma(_rotx, _rotx, _roty * _roty);
        float _t20 = 2.0f * Math.fma(_rotx, _roty, _t4);
        float _t21 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t22 = 2.0f * Math.fma(_rotx, _rotz, _t2);
        float _t26 = 2.0f * Math.fma(_rotx, _rotz, -_t2);
        float _t27 = 2.0f * Math.fma(_rotx, _roty, -_t4);
        float _t28 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t29 = Math.fma(-2.0f, _t11, 1.0f);
        float _t30 = Math.fma(-2.0f, _t14, 1.0f);
        float _t31 = Math.fma(-2.0f, _t15, 1.0f);
        float _t41 = Math.fma(_t0, _t22, Math.fma(_pivotx, 2.0f * _t11, -(_pivoty * _t27)));
        float _t42 = Math.fma(_t0, _t28, Math.fma(_pivoty, 2.0f * _t14, -(_pivotx * _t20)));
        float _t43 = Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0f * _t15, -(_pivotx * _t26)));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, _sv0.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, _sv4.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, _sv5.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv2, FloatVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).fma(UNIT_W, FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] rotateAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] rot, int rotOffset, float[] pivot, int pivotOffset) {
        float _self00 = src[srcOffset + 0];
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self10 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self20 = src[srcOffset + 8];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _pivotz = pivot[pivotOffset + 2];
        float _roty = rot[rotOffset + 1];
        float _rotw = rot[rotOffset + 3];
        float _rotz = rot[rotOffset + 2];
        float _rotx = rot[rotOffset + 0];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _t0 = -_pivotz;
        float _t2 = _roty * _rotw;
        float _t3 = _rotz * _rotz;
        float _t4 = _rotz * _rotw;
        float _t11 = Math.fma(_roty, _roty, _t3);
        float _t14 = Math.fma(_rotx, _rotx, _t3);
        float _t15 = Math.fma(_rotx, _rotx, _roty * _roty);
        float _t20 = 2.0f * Math.fma(_rotx, _roty, _t4);
        float _t21 = 2.0f * Math.fma(_rotx, _rotw, _roty * _rotz);
        float _t22 = 2.0f * Math.fma(_rotx, _rotz, _t2);
        float _t26 = 2.0f * Math.fma(_rotx, _rotz, -_t2);
        float _t27 = 2.0f * Math.fma(_rotx, _roty, -_t4);
        float _t28 = 2.0f * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        float _t29 = Math.fma(-2.0f, _t11, 1.0f);
        float _t30 = Math.fma(-2.0f, _t14, 1.0f);
        float _t31 = Math.fma(-2.0f, _t15, 1.0f);
        float _t41 = Math.fma(_t0, _t22, Math.fma(_pivotx, 2.0f * _t11, -(_pivoty * _t27)));
        float _t42 = Math.fma(_t0, _t28, Math.fma(_pivoty, 2.0f * _t14, -(_pivotx * _t20)));
        float _t43 = Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0f * _t15, -(_pivotx * _t26)));
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = FloatVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = FloatVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(_sv0.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(_sv4.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(_sv5.mul(_sv1)).add(FloatVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv2).add(FloatVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).mul(UNIT_W).add(FloatVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] rotateYXZ(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        if (SimdSupport.USE_FMA) return rotateYXZ_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateYXZ_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static float[] rotateYXZ_fma(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t15);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t13).add(FloatVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t14 - _self01 * _t0)).withLane(3, src[srcOffset + 3]);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t13).add(FloatVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t14 - _self11 * _t0)).withLane(3, src[srcOffset + 7]);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]).fma(_sv0, FloatVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t13).add(FloatVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t14 - _self21 * _t0)).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] rotateYXZ_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float angleX, float angleY, float angleZ) {
        float _self01 = src[srcOffset + 1];
        float _self02 = src[srcOffset + 2];
        float _self11 = src[srcOffset + 5];
        float _self12 = src[srcOffset + 6];
        float _self21 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _t0 = (float) Math.sin(angleX);
        float _t1 = (float) Math.cos(angleY);
        float _t2 = (float) Math.sin(angleZ);
        float _t3 = (float) Math.sin(angleY);
        float _t4 = (float) Math.cos(angleZ);
        float _t5 = (float) Math.cos(angleX);
        float _t6 = _t0 * _t1;
        float _t8 = _t0 * _t3;
        float _t10 = _t2 * _t5;
        float _t13 = _t5 * _t4;
        float _t14 = _t5 * _t1;
        float _t15 = _t3 * _t5;
        float _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        float _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        float _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        float _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t15);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t13).add(FloatVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t14 - _self01 * _t0)).withLane(3, src[srcOffset + 3]);
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t13).add(FloatVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t14 - _self11 * _t0)).withLane(3, src[srcOffset + 7]);
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]).mul(_sv0).add(FloatVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t13).add(FloatVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t14 - _self21 * _t0)).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] scale(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return scale_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static float[] scale_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] scale_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] scale(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return scale_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] scale_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] scale_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(FloatVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] scale(float[] dest, int destOffset, float[] src, int srcOffset, float s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, s).mul(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4))).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float s, float pivotX, float pivotY, float pivotZ) {
        float _t0 = Math.fma(-s, pivotX, pivotX);
        float _t1 = Math.fma(-s, pivotY, pivotY);
        float _t2 = Math.fma(-s, pivotZ, pivotZ);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(src[srcOffset + 0], _t0, Math.fma(src[srcOffset + 1], _t1, Math.fma(src[srcOffset + 2], _t2, src[srcOffset + 3]))));
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(src[srcOffset + 4], _t0, Math.fma(src[srcOffset + 5], _t1, Math.fma(src[srcOffset + 6], _t2, src[srcOffset + 7]))));
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(src[srcOffset + 8], _t0, Math.fma(src[srcOffset + 9], _t1, Math.fma(src[srcOffset + 10], _t2, src[srcOffset + 11]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float[] pivot, int pivotOffset, float s) {
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t0 = Math.fma(-s, _pivotx, _pivotx);
        float _t1 = Math.fma(-s, _pivoty, _pivoty);
        float _t2 = Math.fma(-s, _pivotz, _pivotz);
        var _sv0 = FloatVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(src[srcOffset + 0], _t0, Math.fma(src[srcOffset + 1], _t1, Math.fma(src[srcOffset + 2], _t2, src[srcOffset + 3]))));
        var _c1 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(src[srcOffset + 4], _t0, Math.fma(src[srcOffset + 5], _t1, Math.fma(src[srcOffset + 6], _t2, src[srcOffset + 7]))));
        var _c2 = _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(src[srcOffset + 8], _t0, Math.fma(src[srcOffset + 9], _t1, Math.fma(src[srcOffset + 10], _t2, src[srcOffset + 11]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] scaleAround(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static float[] scaleAround_fma(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _t3 = Math.fma(-pivotX, sX, pivotX);
        float _t4 = Math.fma(-pivotY, sY, pivotY);
        float _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).fma(UNIT_W, _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).fma(UNIT_W, _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).fma(UNIT_W, _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] scaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float sX, float sY, float sZ, float pivotX, float pivotY, float pivotZ) {
        float _t3 = Math.fma(-pivotX, sX, pivotX);
        float _t4 = Math.fma(-pivotY, sY, pivotY);
        float _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).mul(UNIT_W).add(_sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).mul(UNIT_W).add(_sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).mul(UNIT_W).add(_sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        float _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        float _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).fma(UNIT_W, _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).fma(UNIT_W, _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).fma(UNIT_W, _sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] scaleAround_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] s, int sOffset, float[] pivot, int pivotOffset) {
        float _sx = s[sOffset + 0];
        float _sy = s[sOffset + 1];
        float _sz = s[sOffset + 2];
        float _pivotx = pivot[pivotOffset + 0];
        float _pivoty = pivot[pivotOffset + 1];
        float _pivotz = pivot[pivotOffset + 2];
        float _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        float _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        float _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        var _sv0 = FloatVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _c0 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).mul(UNIT_W).add(_sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).mul(UNIT_W).add(_sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = FloatVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).mul(UNIT_W).add(_sv0.mul(FloatVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static float[] translate(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        if (SimdSupport.USE_FMA) return translate_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return translate_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static float[] translate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * vX + (src[(srcOffset + _li * 4) + 1] * vY + src[(srcOffset + _li * 4) + 2] * vZ)).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] translate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float vX, float vY, float vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * vX + (src[(srcOffset + _li * 4) + 1] * vY + src[(srcOffset + _li * 4) + 2] * vZ)).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] translate(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return translate_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return translate_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static float[] translate_fma(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * _vx + (src[(srcOffset + _li * 4) + 1] * _vy + src[(srcOffset + _li * 4) + 2] * _vz)).fma(UNIT_W, FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] translate_mulAdd(float[] dest, int destOffset, float[] src, int srcOffset, float[] v, int vOffset) {
        float _vx = v[vOffset + 0];
        float _vy = v[vOffset + 1];
        float _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = FloatVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * _vx + (src[(srcOffset + _li * 4) + 1] * _vy + src[(srcOffset + _li * 4) + 2] * _vz)).mul(UNIT_W).add(FloatVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static float[] transformPosition_vecArr(float[] dest, int destOffset, float[] matrix, int matrixOffset, float[] points, int pointsOffset, int count) {
        float _m00 = matrix[matrixOffset + 0];
        float _m01 = matrix[matrixOffset + 1];
        float _m02 = matrix[matrixOffset + 2];
        float _m03 = matrix[matrixOffset + 3];
        float _m10 = matrix[matrixOffset + 4];
        float _m11 = matrix[matrixOffset + 5];
        float _m12 = matrix[matrixOffset + 6];
        float _m13 = matrix[matrixOffset + 7];
        float _m20 = matrix[matrixOffset + 8];
        float _m21 = matrix[matrixOffset + 9];
        float _m22 = matrix[matrixOffset + 10];
        float _m23 = matrix[matrixOffset + 11];
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
        float _m01 = matrix[matrixOffset + 1];
        float _m02 = matrix[matrixOffset + 2];
        float _m10 = matrix[matrixOffset + 4];
        float _m11 = matrix[matrixOffset + 5];
        float _m12 = matrix[matrixOffset + 6];
        float _m20 = matrix[matrixOffset + 8];
        float _m21 = matrix[matrixOffset + 9];
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

    private static final FloatVector LCTRS_UNIT_W = FloatVector.fromArray(FloatVector.SPECIES_128, new float[] {0.0f, 0.0f, 0.0f, 1.0f}, 0);

    public static float[] lerpComposeTRSMul_fma(float[] dest, int destOffset, float[] t1, int t1Offset, float[] t2, int t2Offset, float[] q1, int q1Offset, float[] q2, int q2Offset, float[] s1, int s1Offset, float[] s2, int s2Offset, float[] m, int mOffset, float alpha, int count) {
        var _sp = FloatVector.SPECIES_128;
        for (int _i = 0; _i < count; _i++) {
            int _t1o = t1Offset + _i * 3;
            int _t2o = t2Offset + _i * 3;
            int _q1o = q1Offset + _i * 4;
            int _q2o = q2Offset + _i * 4;
            int _s1o = s1Offset + _i * 3;
            int _s2o = s2Offset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            float _ax = t1[_t1o + 0], _ay = t1[_t1o + 1], _az = t1[_t1o + 2];
            float _tx = Math.fma(alpha, t2[_t2o + 0] - _ax, _ax);
            float _ty = Math.fma(alpha, t2[_t2o + 1] - _ay, _ay);
            float _tz = Math.fma(alpha, t2[_t2o + 2] - _az, _az);
            float _bx = s1[_s1o + 0], _by = s1[_s1o + 1], _bz = s1[_s1o + 2];
            float _sx = Math.fma(alpha, s2[_s2o + 0] - _bx, _bx);
            float _sy = Math.fma(alpha, s2[_s2o + 1] - _by, _by);
            float _sz = Math.fma(alpha, s2[_s2o + 2] - _bz, _bz);
            float _ux = q1[_q1o + 0], _uy = q1[_q1o + 1], _uz = q1[_q1o + 2], _uw = q1[_q1o + 3];
            float _vx = q2[_q2o + 0], _vy = q2[_q2o + 1], _vz = q2[_q2o + 2], _vw = q2[_q2o + 3];
            float _dot = Math.fma(_uw, _vw, Math.fma(_uz, _vz, Math.fma(_ux, _vx, _uy * _vy)));
            if (_dot < 0.0f) { _vx = -_vx; _vy = -_vy; _vz = -_vz; _vw = -_vw; }
            float _qx = Math.fma(alpha, _vx - _ux, _ux);
            float _qy = Math.fma(alpha, _vy - _uy, _uy);
            float _qz = Math.fma(alpha, _vz - _uz, _uz);
            float _qw = Math.fma(alpha, _vw - _uw, _uw);
            float _len2 = (_qx * _qx + _qy * _qy) + (_qz * _qz + _qw * _qw);
            float _ninv = _len2 > 0.0f ? 1.0f / (float) Math.sqrt(_len2) : 0.0f;
            _qx *= _ninv; _qy *= _ninv; _qz *= _ninv; _qw *= _ninv;
            float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            var _r0 = FloatVector.fromArray(_sp, m, _mo);
            var _r1 = FloatVector.fromArray(_sp, m, _mo + 4);
            var _r2 = FloatVector.fromArray(_sp, m, _mo + 8);
            var _c0 = FloatVector.broadcast(_sp, _tx).fma(LCTRS_UNIT_W, _r2.fma(FloatVector.broadcast(_sp, _t02), _r1.fma(FloatVector.broadcast(_sp, _t01), _r0.mul(FloatVector.broadcast(_sp, _t00)))));
            var _c1 = FloatVector.broadcast(_sp, _ty).fma(LCTRS_UNIT_W, _r2.fma(FloatVector.broadcast(_sp, _t12), _r1.fma(FloatVector.broadcast(_sp, _t11), _r0.mul(FloatVector.broadcast(_sp, _t10)))));
            var _c2 = FloatVector.broadcast(_sp, _tz).fma(LCTRS_UNIT_W, _r2.fma(FloatVector.broadcast(_sp, _t22), _r1.fma(FloatVector.broadcast(_sp, _t21), _r0.mul(FloatVector.broadcast(_sp, _t20)))));
            _c0.intoArray(dest, _do);
            _c1.intoArray(dest, _do + 4);
            _c2.intoArray(dest, _do + 8);
        }
        return dest;
    }

    public static float[] composeTRSMul_fma(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset, float[] m, int mOffset, int count) {
        var _sp = FloatVector.SPECIES_128;
        for (int _i = 0; _i < count; _i++) {
            int _translationo = translationOffset + _i * 3;
            int _rotationo = rotationOffset + _i * 4;
            int _scaleo = scaleOffset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            float _tx = translation[_translationo + 0], _ty = translation[_translationo + 1], _tz = translation[_translationo + 2];
            float _sx = scale[_scaleo + 0], _sy = scale[_scaleo + 1], _sz = scale[_scaleo + 2];
            float _qx = rotation[_rotationo + 0], _qy = rotation[_rotationo + 1], _qz = rotation[_rotationo + 2], _qw = rotation[_rotationo + 3];
            float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            float _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            float _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            float _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            var _r0 = FloatVector.fromArray(_sp, m, _mo);
            var _r1 = FloatVector.fromArray(_sp, m, _mo + 4);
            var _r2 = FloatVector.fromArray(_sp, m, _mo + 8);
            var _c0 = FloatVector.broadcast(_sp, _tx).fma(LCTRS_UNIT_W, _r2.fma(FloatVector.broadcast(_sp, _t02), _r1.fma(FloatVector.broadcast(_sp, _t01), _r0.mul(FloatVector.broadcast(_sp, _t00)))));
            var _c1 = FloatVector.broadcast(_sp, _ty).fma(LCTRS_UNIT_W, _r2.fma(FloatVector.broadcast(_sp, _t12), _r1.fma(FloatVector.broadcast(_sp, _t11), _r0.mul(FloatVector.broadcast(_sp, _t10)))));
            var _c2 = FloatVector.broadcast(_sp, _tz).fma(LCTRS_UNIT_W, _r2.fma(FloatVector.broadcast(_sp, _t22), _r1.fma(FloatVector.broadcast(_sp, _t21), _r0.mul(FloatVector.broadcast(_sp, _t20)))));
            _c0.intoArray(dest, _do);
            _c1.intoArray(dest, _do + 4);
            _c2.intoArray(dest, _do + 8);
        }
        return dest;
    }

    private static final VectorShuffle<Float> CTRSP_S0 = VectorShuffle.fromValues(SIMD_SPECIES, 0, 0, 0, 0);
    private static final VectorShuffle<Float> CTRSP_S1 = VectorShuffle.fromValues(SIMD_SPECIES, 1, 1, 1, 1);
    private static final VectorShuffle<Float> CTRSP_S2 = VectorShuffle.fromValues(SIMD_SPECIES, 2, 2, 2, 2);
    private static final VectorShuffle<Float> CTRSP_W0 = VectorShuffle.fromValues(SIMD_SPECIES, 3, 3, 3, 0);
    private static final VectorShuffle<Float> CTRSP_W1 = VectorShuffle.fromValues(SIMD_SPECIES, 3, 3, 3, 1);
    private static final VectorShuffle<Float> CTRSP_W2 = VectorShuffle.fromValues(SIMD_SPECIES, 3, 3, 3, 2);

    public static float[] composeTRSMulPadded_fma(float[] dest, int destOffset, float[] translation, int translationOffset, float[] rotation, int rotationOffset, float[] scale, int scaleOffset, float[] m, int mOffset) {
        float _qx = rotation[rotationOffset + 0], _qy = rotation[rotationOffset + 1], _qz = rotation[rotationOffset + 2], _qw = rotation[rotationOffset + 3];
        float _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        float _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        float _r00 = 1 - 2 * (_yy + _zz), _r01 = 2 * (_xy - _zw), _r02 = 2 * (_xz + _yw);
        float _r10 = 2 * (_xy + _zw), _r11 = 1 - 2 * (_xx + _zz), _r12 = 2 * (_yz - _xw);
        float _r20 = 2 * (_xz - _yw), _r21 = 2 * (_yz + _xw), _r22 = 1 - 2 * (_xx + _yy);
        var _sv = FloatVector.fromArray(SIMD_SPECIES, scale, scaleOffset);
        var _tv = FloatVector.fromArray(SIMD_SPECIES, translation, translationOffset);
        var _m0 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset).mul(_sv.rearrange(CTRSP_S0));
        var _m1 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 4).mul(_sv.rearrange(CTRSP_S1));
        var _m2 = FloatVector.fromArray(SIMD_SPECIES, m, mOffset + 8).mul(_sv.rearrange(CTRSP_S2));
        var _c0 = _m2.fma(FloatVector.broadcast(SIMD_SPECIES, _r02), _m1.fma(FloatVector.broadcast(SIMD_SPECIES, _r01), _m0.fma(FloatVector.broadcast(SIMD_SPECIES, _r00), _tv.rearrange(CTRSP_W0))));
        var _c1 = _m2.fma(FloatVector.broadcast(SIMD_SPECIES, _r12), _m1.fma(FloatVector.broadcast(SIMD_SPECIES, _r11), _m0.fma(FloatVector.broadcast(SIMD_SPECIES, _r10), _tv.rearrange(CTRSP_W1))));
        var _c2 = _m2.fma(FloatVector.broadcast(SIMD_SPECIES, _r22), _m1.fma(FloatVector.broadcast(SIMD_SPECIES, _r21), _m0.fma(FloatVector.broadcast(SIMD_SPECIES, _r20), _tv.rearrange(CTRSP_W2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        if (PREFERRED_LANES >= 8) {
            FloatVector.fromArray(FloatVector.SPECIES_256, src, srcOffset).intoArray(dest, destOffset);
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + 8).intoArray(dest, destOffset + 8);
        }
        else {
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset).intoArray(dest, destOffset);
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + 4).intoArray(dest, destOffset + 4);
            FloatVector.fromArray(FloatVector.SPECIES_128, src, srcOffset + 8).intoArray(dest, destOffset + 8);
        }
    }


    public static float[] copy(float[] dest, int destOffset, float[] src, int srcOffset) {
        copyArrArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, float[] src, int srcOffset, int count) {
        copyArrArr(dest, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            for (int _i = 0; _i < 12; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static float[] copy(float[] dest, int destOffset, java.nio.FloatBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            float[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 12);
        } else {
            for (int _i = 0; _i < count * 12; _i++)
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
            for (int _i = 0; _i < 12; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
        }
        return dest;
    }

    public static java.nio.FloatBuffer copy(java.nio.FloatBuffer dest, int destOffset, float[] src, int srcOffset, int count) {
        if (dest.hasArray()) {
            float[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 12);
        } else {
            for (int _i = 0; _i < count * 12; _i++)
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
                for (int _i = 0; _i < 12; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                for (int _i = 0; _i < 12; _i++)
                    dest.put(destOffset + _i, _srcArr[_srcOff + _i]);
            } else {
                for (int _i = 0; _i < 12; _i++)
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
                copyArrArr(_destArr, _destOff, _srcArr, _srcOff, count * 12);
            } else {
                for (int _i = 0; _i < count * 12; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                float[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                for (int _i = 0; _i < count * 12; _i++)
                    dest.put(destOffset + _i, _srcArr[_srcOff + _i]);
            } else {
                for (int _i = 0; _i < count * 12; _i++)
                    dest.put(destOffset + _i, src.get(srcOffset + _i));
            }
        }
        return dest;
    }
}
