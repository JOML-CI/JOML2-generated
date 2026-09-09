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

    public static double[] getNormalizedRotation(double[] dest, int destOffset, double[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return getNormalizedRotation_fma(dest, destOffset, src, srcOffset);
        return getNormalizedRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static double[] getNormalizedRotation_fma(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self21 = src[srcOffset + 9];
        double _self01 = src[srcOffset + 1];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self02 = src[srcOffset + 2];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self00 = src[srcOffset + 0];
        double _self10 = src[srcOffset + 4];
        double _t6 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t7 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t8 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t9 = (1.0 / Math.sqrt(_t6));
        double _t10 = (1.0 / Math.sqrt(_t7));
        double _t11 = (1.0 / Math.sqrt(_t8));
        double _t21 = _t6 > 0.0 ? _self01 * _t9 : 0.0;
        double _t22 = _t7 > 0.0 ? _self12 * _t10 : 0.0;
        double _t23 = _t6 > 0.0 ? _self11 * _t9 : 0.0;
        double _t24 = _t7 > 0.0 ? _self02 * _t10 : 0.0;
        double _t25 = _t8 > 0.0 ? _self20 * _t11 : 0.0;
        double _t26 = _t7 > 0.0 ? _self22 * _t10 : 0.0;
        double _t27 = _t6 > 0.0 ? _self21 * _t9 : 0.0;
        double _t28 = _t8 > 0.0 ? _self00 * _t11 : 0.0;
        double _t29 = _t8 > 0.0 ? _self10 * _t11 : 0.0;
        double _t36 = _t27 - _t22;
        double _t39 = _t27 + _t22;
        double _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        double _t49 = _t48 < 0.0 ? -_t28 : _t28;
        double _t50 = _t48 < 0.0 ? -_t29 : _t29;
        double _t51 = _t48 < 0.0 ? -_t25 : _t25;
        double _t52 = _t49 + _t23;
        double _t53 = _t50 + _t21;
        double _t55 = _t51 + _t24;
        double _t56 = _t24 - _t51;
        double _t57 = _t50 - _t21;
        double _t58 = _t52 + _t26;
        double _t62 = 1.0 + _t58;
        double _t63 = 1.0 + (_t49 - (_t23 + _t26));
        double _t64 = 1.0 + (_t23 - (_t49 + _t26));
        double _t65 = 1.0 + (_t26 - _t52);
        double _t69 = (1.0 / Math.sqrt(_t63));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t58  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t62)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t36).withLane(1, _t56).withLane(2, _t57).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t62)))))) : (_t49  >  Math.max(_t23, _t26) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t63)).withLane(1, _t53 * _t69).withLane(2, _t55 * _t69).withLane(3, _t36 * _t69)) : (_t23  >  _t26 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t53).withLane(2, _t39).withLane(3, _t56).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t64)))).withLane(1, Math.sqrt(_t64))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t39).withLane(3, _t57).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t65)))).withLane(2, Math.sqrt(_t65))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] getNormalizedRotation_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self21 = src[srcOffset + 9];
        double _self01 = src[srcOffset + 1];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self02 = src[srcOffset + 2];
        double _self12 = src[srcOffset + 6];
        double _self20 = src[srcOffset + 8];
        double _self00 = src[srcOffset + 0];
        double _self10 = src[srcOffset + 4];
        double _t6 = Math.fma(_self21, _self21, Math.fma(_self01, _self01, _self11 * _self11));
        double _t7 = Math.fma(_self22, _self22, Math.fma(_self02, _self02, _self12 * _self12));
        double _t8 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t9 = (1.0 / Math.sqrt(_t6));
        double _t10 = (1.0 / Math.sqrt(_t7));
        double _t11 = (1.0 / Math.sqrt(_t8));
        double _t21 = _t6 > 0.0 ? _self01 * _t9 : 0.0;
        double _t22 = _t7 > 0.0 ? _self12 * _t10 : 0.0;
        double _t23 = _t6 > 0.0 ? _self11 * _t9 : 0.0;
        double _t24 = _t7 > 0.0 ? _self02 * _t10 : 0.0;
        double _t25 = _t8 > 0.0 ? _self20 * _t11 : 0.0;
        double _t26 = _t7 > 0.0 ? _self22 * _t10 : 0.0;
        double _t27 = _t6 > 0.0 ? _self21 * _t9 : 0.0;
        double _t28 = _t8 > 0.0 ? _self00 * _t11 : 0.0;
        double _t29 = _t8 > 0.0 ? _self10 * _t11 : 0.0;
        double _t36 = _t27 - _t22;
        double _t39 = _t27 + _t22;
        double _t48 = Math.fma(Math.fma(_t21, _t22, -(_t23 * _t24)), _t25, Math.fma(Math.fma(_t23, _t26, -(_t27 * _t22)), _t28, Math.fma(_t27, _t24, -(_t21 * _t26)) * _t29));
        double _t49 = _t48 < 0.0 ? -_t28 : _t28;
        double _t50 = _t48 < 0.0 ? -_t29 : _t29;
        double _t51 = _t48 < 0.0 ? -_t25 : _t25;
        double _t52 = _t49 + _t23;
        double _t53 = _t50 + _t21;
        double _t55 = _t51 + _t24;
        double _t56 = _t24 - _t51;
        double _t57 = _t50 - _t21;
        double _t58 = _t52 + _t26;
        double _t62 = 1.0 + _t58;
        double _t63 = 1.0 + (_t49 - (_t23 + _t26));
        double _t64 = 1.0 + (_t23 - (_t49 + _t26));
        double _t65 = 1.0 + (_t26 - _t52);
        double _t69 = (1.0 / Math.sqrt(_t63));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t58  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t62)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t36).withLane(1, _t56).withLane(2, _t57).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t62)))))) : (_t49  >  Math.max(_t23, _t26) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t63)).withLane(1, _t53 * _t69).withLane(2, _t55 * _t69).withLane(3, _t36 * _t69)) : (_t23  >  _t26 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t53).withLane(2, _t39).withLane(3, _t56).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t64)))).withLane(1, Math.sqrt(_t64))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t39).withLane(3, _t57).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t65)))).withLane(2, Math.sqrt(_t65))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] getUnnormalizedRotation(double[] dest, int destOffset, double[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return getUnnormalizedRotation_fma(dest, destOffset, src, srcOffset);
        return getUnnormalizedRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static double[] getUnnormalizedRotation_fma(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self00 = src[srcOffset + 0];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self21 = src[srcOffset + 9];
        double _self12 = src[srcOffset + 6];
        double _self01 = src[srcOffset + 1];
        double _self10 = src[srcOffset + 4];
        double _self02 = src[srcOffset + 2];
        double _self20 = src[srcOffset + 8];
        double _t0 = _self00 + _self11;
        double _t1 = _self21 - _self12;
        double _t4 = _self01 + _self10;
        double _t6 = _self02 + _self20;
        double _t7 = _self02 - _self20;
        double _t8 = _self12 + _self21;
        double _t9 = _self10 - _self01;
        double _t10 = _self22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_self00 - (_self11 + _self22));
        double _t16 = 1.0 + (_self11 - (_self00 + _self22));
        double _t17 = 1.0 + (_self22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_self00  >  Math.max(_self11, _self22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_self11  >  _self22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] getUnnormalizedRotation_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self00 = src[srcOffset + 0];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self21 = src[srcOffset + 9];
        double _self12 = src[srcOffset + 6];
        double _self01 = src[srcOffset + 1];
        double _self10 = src[srcOffset + 4];
        double _self02 = src[srcOffset + 2];
        double _self20 = src[srcOffset + 8];
        double _t0 = _self00 + _self11;
        double _t1 = _self21 - _self12;
        double _t4 = _self01 + _self10;
        double _t6 = _self02 + _self20;
        double _t7 = _self02 - _self20;
        double _t8 = _self12 + _self21;
        double _t9 = _self10 - _self01;
        double _t10 = _self22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_self00 - (_self11 + _self22));
        double _t16 = 1.0 + (_self11 - (_self00 + _self22));
        double _t17 = 1.0 + (_self22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_self00  >  Math.max(_self11, _self22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_self11  >  _self22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] invert(double[] dest, int destOffset, double[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return invert_fma(dest, destOffset, src, srcOffset);
        return invert_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static double[] invert_fma(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self23 = src[srcOffset + 11];
        double _self03 = src[srcOffset + 3];
        double _self13 = src[srcOffset + 7];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self12 = src[srcOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self10 = src[srcOffset + 4];
        double _self20 = src[srcOffset + 8];
        double _self02 = src[srcOffset + 2];
        double _self01 = src[srcOffset + 1];
        double _self00 = src[srcOffset + 0];
        double _t20 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t21 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t23 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t24 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t25 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t26 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t27 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t28 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t29 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t33_inv = 1.0 / Math.fma(_self02, _t21, Math.fma(_self00, _t20, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _t33_inv);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t23).withLane(2, _t24).mul(_sv0));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t25).withLane(1, _t26).withLane(2, _t27).mul(_sv0));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t21).withLane(1, _t28).withLane(2, _t29).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] invert_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self23 = src[srcOffset + 11];
        double _self03 = src[srcOffset + 3];
        double _self13 = src[srcOffset + 7];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self12 = src[srcOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self10 = src[srcOffset + 4];
        double _self20 = src[srcOffset + 8];
        double _self02 = src[srcOffset + 2];
        double _self01 = src[srcOffset + 1];
        double _self00 = src[srcOffset + 0];
        double _t20 = Math.fma(_self11, _self22, -(_self12 * _self21));
        double _t21 = Math.fma(_self10, _self21, -(_self11 * _self20));
        double _t23 = Math.fma(_self02, _self21, -(_self01 * _self22));
        double _t24 = Math.fma(_self01, _self12, -(_self02 * _self11));
        double _t25 = Math.fma(_self12, _self20, -(_self10 * _self22));
        double _t26 = Math.fma(_self00, _self22, -(_self02 * _self20));
        double _t27 = Math.fma(_self02, _self10, -(_self00 * _self12));
        double _t28 = Math.fma(_self01, _self20, -(_self00 * _self21));
        double _t29 = Math.fma(_self00, _self11, -(_self01 * _self10));
        double _t33_inv = 1.0 / Math.fma(_self02, _t21, Math.fma(_self00, _t20, -(_self01 * Math.fma(_self10, _self22, -(_self12 * _self20)))));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _t33_inv);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t24, Math.fma(_self03, _t20, _self13 * _t23)) * _t33_inv)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t23).withLane(2, _t24).mul(_sv0));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t27, Math.fma(_self03, _t25, _self13 * _t26)) * _t33_inv)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t25).withLane(1, _t26).withLane(2, _t27).mul(_sv0));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_self23, _t29, Math.fma(_self03, _t21, _self13 * _t28)) * _t33_inv)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t21).withLane(1, _t28).withLane(2, _t29).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] invertProduct(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return invertProduct_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return invertProduct_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] invertProduct_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _other21 = other[otherOffset + 9];
        double _self12 = src[srcOffset + 6];
        double _other01 = other[otherOffset + 1];
        double _self10 = src[srcOffset + 4];
        double _other11 = other[otherOffset + 5];
        double _self11 = src[srcOffset + 5];
        double _other22 = other[otherOffset + 10];
        double _self22 = src[srcOffset + 10];
        double _other02 = other[otherOffset + 2];
        double _self20 = src[srcOffset + 8];
        double _other12 = other[otherOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _other20 = other[otherOffset + 8];
        double _other00 = other[otherOffset + 0];
        double _other10 = other[otherOffset + 4];
        double _other03 = other[otherOffset + 3];
        double _other13 = other[otherOffset + 7];
        double _other23 = other[otherOffset + 11];
        double _t24 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        double _t25 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        double _t26 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        double _t27 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        double _t28 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        double _t29 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        double _t30 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        double _t31 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        double _t32 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        double _t33 = Math.fma(_other03, _self20, Math.fma(_other13, _self21, Math.fma(_other23, _self22, src[srcOffset + 11])));
        double _t34 = Math.fma(_other03, _self00, Math.fma(_other13, _self01, Math.fma(_other23, _self02, src[srcOffset + 3])));
        double _t35 = Math.fma(_other03, _self10, Math.fma(_other13, _self11, Math.fma(_other23, _self12, src[srcOffset + 7])));
        double _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        double _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        double _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        double _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        double _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        double _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        double _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        double _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        double _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        double _t69_inv = 1.0 / Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _t69_inv);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t56).withLane(1, _t59).withLane(2, _t60).mul(_sv0));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t61).withLane(1, _t62).withLane(2, _t63).mul(_sv0));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(1, _t64).withLane(2, _t65).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] invertProduct_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _other21 = other[otherOffset + 9];
        double _self12 = src[srcOffset + 6];
        double _other01 = other[otherOffset + 1];
        double _self10 = src[srcOffset + 4];
        double _other11 = other[otherOffset + 5];
        double _self11 = src[srcOffset + 5];
        double _other22 = other[otherOffset + 10];
        double _self22 = src[srcOffset + 10];
        double _other02 = other[otherOffset + 2];
        double _self20 = src[srcOffset + 8];
        double _other12 = other[otherOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self02 = src[srcOffset + 2];
        double _self00 = src[srcOffset + 0];
        double _self01 = src[srcOffset + 1];
        double _other20 = other[otherOffset + 8];
        double _other00 = other[otherOffset + 0];
        double _other10 = other[otherOffset + 4];
        double _other03 = other[otherOffset + 3];
        double _other13 = other[otherOffset + 7];
        double _other23 = other[otherOffset + 11];
        double _t24 = Math.fma(_other21, _self12, Math.fma(_other01, _self10, _other11 * _self11));
        double _t25 = Math.fma(_other22, _self22, Math.fma(_other02, _self20, _other12 * _self21));
        double _t26 = Math.fma(_other21, _self22, Math.fma(_other01, _self20, _other11 * _self21));
        double _t27 = Math.fma(_other22, _self12, Math.fma(_other02, _self10, _other12 * _self11));
        double _t28 = Math.fma(_other22, _self02, Math.fma(_other02, _self00, _other12 * _self01));
        double _t29 = Math.fma(_other20, _self12, Math.fma(_other00, _self10, _other10 * _self11));
        double _t30 = Math.fma(_other20, _self22, Math.fma(_other00, _self20, _other10 * _self21));
        double _t31 = Math.fma(_other20, _self02, Math.fma(_other00, _self00, _other10 * _self01));
        double _t32 = Math.fma(_other21, _self02, Math.fma(_other01, _self00, _other11 * _self01));
        double _t33 = Math.fma(_other03, _self20, Math.fma(_other13, _self21, Math.fma(_other23, _self22, src[srcOffset + 11])));
        double _t34 = Math.fma(_other03, _self00, Math.fma(_other13, _self01, Math.fma(_other23, _self02, src[srcOffset + 3])));
        double _t35 = Math.fma(_other03, _self10, Math.fma(_other13, _self11, Math.fma(_other23, _self12, src[srcOffset + 7])));
        double _t56 = Math.fma(_t24, _t25, -(_t26 * _t27));
        double _t57 = Math.fma(_t29, _t26, -(_t30 * _t24));
        double _t59 = Math.fma(_t26, _t28, -(_t32 * _t25));
        double _t60 = Math.fma(_t32, _t27, -(_t24 * _t28));
        double _t61 = Math.fma(_t30, _t27, -(_t29 * _t25));
        double _t62 = Math.fma(_t31, _t25, -(_t30 * _t28));
        double _t63 = Math.fma(_t29, _t28, -(_t31 * _t27));
        double _t64 = Math.fma(_t30, _t32, -(_t31 * _t26));
        double _t65 = Math.fma(_t31, _t24, -(_t29 * _t32));
        double _t69_inv = 1.0 / Math.fma(_t28, _t57, Math.fma(_t31, _t56, -(_t32 * Math.fma(_t29, _t25, -(_t30 * _t27)))));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _t69_inv);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t60, Math.fma(_t34, _t56, _t35 * _t59)) * _t69_inv)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t56).withLane(1, _t59).withLane(2, _t60).mul(_sv0));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t63, Math.fma(_t34, _t61, _t35 * _t62)) * _t69_inv)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t61).withLane(1, _t62).withLane(2, _t63).mul(_sv0));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, -(Math.fma(_t33, _t65, Math.fma(_t34, _t57, _t35 * _t64)) * _t69_inv)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(1, _t64).withLane(2, _t65).mul(_sv0));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] transpose(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
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

    public static double[] negate(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).neg();
            _c.intoArray(dest, destOffset + _li * 4);
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

    public static double[] set(double[] dest, int destOffset, double[] v, int vOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, v, (vOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
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

    public static double[] withTranslation(double[] dest, int destOffset, double[] src, int srcOffset, double[] t, int tOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, t[tOffset + 0]);
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).withLane(3, t[tOffset + 1]);
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).withLane(3, t[tOffset + 2]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] makeFromTransform(double[] dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        if (SimdSupport.USE_FMA) return makeFromTransform_fma(dest, destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return makeFromTransform_mulAdd(dest, destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
    }

    public static double[] makeFromTransform_fma(double[] dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, tSX).withLane(1, tSY).withLane(2, tSZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 2.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, tTX).fma(UNIT_W, _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0)).withLane(1, 2.0 * Math.fma(tRX, tRY, -_t1)).withLane(2, 2.0 * Math.fma(tRX, tRZ, _t2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, tTY).fma(UNIT_W, _sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRY, _t1)).withLane(2, Math.fma(tRY, tRZ, -(tRX * tRW)))).withLane(1, Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, tTZ).fma(UNIT_W, _sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRZ, -_t2)).withLane(1, Math.fma(tRX, tRW, tRY * tRZ))).withLane(2, Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] makeFromTransform_mulAdd(double[] dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        double _t0 = tRZ * tRZ;
        double _t1 = tRZ * tRW;
        double _t2 = tRY * tRW;
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, tSX).withLane(1, tSY).withLane(2, tSZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 2.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, tTX).mul(UNIT_W).add(_sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0, Math.fma(tRY, tRY, _t0), 1.0)).withLane(1, 2.0 * Math.fma(tRX, tRY, -_t1)).withLane(2, 2.0 * Math.fma(tRX, tRZ, _t2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, tTY).mul(UNIT_W).add(_sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRY, _t1)).withLane(2, Math.fma(tRY, tRZ, -(tRX * tRW)))).withLane(1, Math.fma(-2.0, Math.fma(tRX, tRX, _t0), 1.0))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, tTZ).mul(UNIT_W).add(_sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(tRX, tRZ, -_t2)).withLane(1, Math.fma(tRX, tRW, tRY * tRZ))).withLane(2, Math.fma(-2.0, Math.fma(tRX, tRX, tRY * tRY), 1.0))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] decomposeRotation(double[] dest, int destOffset, double[] src, int srcOffset) {
        if (SimdSupport.USE_FMA) return decomposeRotation_fma(dest, destOffset, src, srcOffset);
        return decomposeRotation_mulAdd(dest, destOffset, src, srcOffset);
    }

    public static double[] decomposeRotation_fma(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self20 = src[srcOffset + 8];
        double _self00 = src[srcOffset + 0];
        double _self10 = src[srcOffset + 4];
        double _self21 = src[srcOffset + 9];
        double _self01 = src[srcOffset + 1];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self02 = src[srcOffset + 2];
        double _self12 = src[srcOffset + 6];
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? _self20 * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? _self00 * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? _self10 * _t3 : 0.0;
        double _t19 = -Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        double _t20 = -Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        double _t21 = Math.fma(_t19, _t7, _self21);
        double _t22 = Math.fma(_t19, _t8, _self01);
        double _t23 = Math.fma(_t19, _t9, _self11);
        double _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t34 = _t29 > 0.0 ? _t22 * _t30 : 0.0;
        double _t35 = _t29 > 0.0 ? _t21 * _t30 : 0.0;
        double _t36 = _t29 > 0.0 ? _t23 * _t30 : 0.0;
        double _t40 = -Math.fma(Math.fma(_t20, _t7, _self22), _t35, Math.fma(Math.fma(_t20, _t8, _self02), _t34, Math.fma(_t20, _t9, _self12) * _t36));
        double _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, _self22));
        double _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, _self02));
        double _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, _self12));
        double _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        double _t50 = (1.0 / Math.sqrt(_t49));
        double _t54 = _t49 > 0.0 ? _t46 * _t50 : 0.0;
        double _t55 = _t49 > 0.0 ? _t45 * _t50 : 0.0;
        double _t56 = _t49 > 0.0 ? _t44 * _t50 : 0.0;
        double _t60 = _t35 - _t54;
        double _t63 = _t35 + _t54;
        double _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        double _t73 = _t72 < 0.0 ? -_t8 : _t8;
        double _t74 = _t72 < 0.0 ? -_t9 : _t9;
        double _t75 = _t72 < 0.0 ? -_t7 : _t7;
        double _t76 = _t73 + _t36;
        double _t77 = _t74 + _t34;
        double _t78 = _t74 - _t34;
        double _t80 = _t75 + _t55;
        double _t81 = _t55 - _t75;
        double _t82 = _t76 + _t56;
        double _t86 = 1.0 + _t82;
        double _t87 = 1.0 + (_t73 - (_t36 + _t56));
        double _t88 = 1.0 + (_t36 - (_t73 + _t56));
        double _t89 = 1.0 + (_t56 - _t76);
        double _t93 = (1.0 / Math.sqrt(_t87));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t82  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t86)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t60).withLane(1, _t81).withLane(2, _t78).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t86)))))) : (_t73  >  Math.max(_t36, _t56) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t87)).withLane(1, _t77 * _t93).withLane(2, _t80 * _t93).withLane(3, _t60 * _t93)) : (_t36  >  _t56 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t77).withLane(2, _t63).withLane(3, _t81).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t88)))).withLane(1, Math.sqrt(_t88))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t80).withLane(1, _t63).withLane(3, _t78).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t89)))).withLane(2, Math.sqrt(_t89))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] decomposeRotation_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _self20 = src[srcOffset + 8];
        double _self00 = src[srcOffset + 0];
        double _self10 = src[srcOffset + 4];
        double _self21 = src[srcOffset + 9];
        double _self01 = src[srcOffset + 1];
        double _self11 = src[srcOffset + 5];
        double _self22 = src[srcOffset + 10];
        double _self02 = src[srcOffset + 2];
        double _self12 = src[srcOffset + 6];
        double _t2 = Math.fma(_self20, _self20, Math.fma(_self00, _self00, _self10 * _self10));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? _self20 * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? _self00 * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? _self10 * _t3 : 0.0;
        double _t19 = -Math.fma(_self21, _t7, Math.fma(_self01, _t8, _self11 * _t9));
        double _t20 = -Math.fma(_self22, _t7, Math.fma(_self02, _t8, _self12 * _t9));
        double _t21 = Math.fma(_t19, _t7, _self21);
        double _t22 = Math.fma(_t19, _t8, _self01);
        double _t23 = Math.fma(_t19, _t9, _self11);
        double _t29 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t34 = _t29 > 0.0 ? _t22 * _t30 : 0.0;
        double _t35 = _t29 > 0.0 ? _t21 * _t30 : 0.0;
        double _t36 = _t29 > 0.0 ? _t23 * _t30 : 0.0;
        double _t40 = -Math.fma(Math.fma(_t20, _t7, _self22), _t35, Math.fma(Math.fma(_t20, _t8, _self02), _t34, Math.fma(_t20, _t9, _self12) * _t36));
        double _t44 = Math.fma(_t20, _t7, Math.fma(_t40, _t35, _self22));
        double _t45 = Math.fma(_t20, _t8, Math.fma(_t40, _t34, _self02));
        double _t46 = Math.fma(_t20, _t9, Math.fma(_t40, _t36, _self12));
        double _t49 = Math.fma(_t44, _t44, Math.fma(_t45, _t45, _t46 * _t46));
        double _t50 = (1.0 / Math.sqrt(_t49));
        double _t54 = _t49 > 0.0 ? _t46 * _t50 : 0.0;
        double _t55 = _t49 > 0.0 ? _t45 * _t50 : 0.0;
        double _t56 = _t49 > 0.0 ? _t44 * _t50 : 0.0;
        double _t60 = _t35 - _t54;
        double _t63 = _t35 + _t54;
        double _t72 = Math.fma(Math.fma(_t34, _t54, -(_t36 * _t55)), _t7, Math.fma(Math.fma(_t36, _t56, -(_t35 * _t54)), _t8, Math.fma(_t35, _t55, -(_t34 * _t56)) * _t9));
        double _t73 = _t72 < 0.0 ? -_t8 : _t8;
        double _t74 = _t72 < 0.0 ? -_t9 : _t9;
        double _t75 = _t72 < 0.0 ? -_t7 : _t7;
        double _t76 = _t73 + _t36;
        double _t77 = _t74 + _t34;
        double _t78 = _t74 - _t34;
        double _t80 = _t75 + _t55;
        double _t81 = _t55 - _t75;
        double _t82 = _t76 + _t56;
        double _t86 = 1.0 + _t82;
        double _t87 = 1.0 + (_t73 - (_t36 + _t56));
        double _t88 = 1.0 + (_t36 - (_t73 + _t56));
        double _t89 = 1.0 + (_t56 - _t76);
        double _t93 = (1.0 / Math.sqrt(_t87));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t82  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t86)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t60).withLane(1, _t81).withLane(2, _t78).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t86)))))) : (_t73  >  Math.max(_t36, _t56) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t87)).withLane(1, _t77 * _t93).withLane(2, _t80 * _t93).withLane(3, _t60 * _t93)) : (_t36  >  _t56 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t77).withLane(2, _t63).withLane(3, _t81).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t88)))).withLane(1, Math.sqrt(_t88))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t80).withLane(1, _t63).withLane(3, _t78).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t89)))).withLane(2, Math.sqrt(_t89))))));
        _c0.intoArray(dest, destOffset);
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

    public static double[] mul(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        if (SimdSupport.USE_FMA) return mul_fma(dest, destOffset, src, srcOffset, right, rightOffset);
        return mul_mulAdd(dest, destOffset, src, srcOffset, right, rightOffset);
    }

    public static double[] mul_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0]), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1]), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2])))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] mul_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] right, int rightOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, right, rightOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 2])))));
            _c.intoArray(dest, destOffset + _li * 4);
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
            var _c = DoubleVector.broadcast(SIMD_SPECIES, _right00).withLane(1, _right01).mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0])).withLane(2, src[(srcOffset + _li * 4) + 2]).add(DoubleVector.broadcast(SIMD_SPECIES, _right10).withLane(1, _right11).mul(DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 1])).withLane(2, _right02 * src[(srcOffset + _li * 4) + 0] + _right12 * src[(srcOffset + _li * 4) + 1])).withLane(3, src[(srcOffset + _li * 4) + 3]);
            _c.intoArray(dest, destOffset + _li * 4);
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
            var _c = DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 3]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 0]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 1]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 2]).mul(_sv2))));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] preMul_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 3]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 0]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 1]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[(otherOffset + _li * 4) + 2]).mul(_sv2))));
            _c.intoArray(dest, destOffset + _li * 4);
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

    public static double[] preMulMat2x3(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        if (SimdSupport.USE_FMA) return preMulMat2x3_fma(dest, destOffset, src, srcOffset, other, otherOffset);
        return preMulMat2x3_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset);
    }

    public static double[] preMulMat2x3_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c2 = _sv0;
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preMulMat2x3_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 4]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 0]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 2]).mul(_sv2)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 5]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 1]).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, other[otherOffset + 3]).mul(_sv2)));
        var _c2 = _sv0;
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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

    public static double[] composeTRS(double[] dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (SimdSupport.USE_FMA) return composeTRS_fma(dest, destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return composeTRS_mulAdd(dest, destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
    }

    public static double[] composeTRS_fma(double[] dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationZ * rotationZ;
        double _t1 = rotationZ * rotationW;
        double _t2 = rotationY * rotationW;
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, scaleX).withLane(1, scaleY).withLane(2, scaleZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 2.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translationX).fma(UNIT_W, _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0, Math.fma(rotationY, rotationY, _t0), 1.0)).withLane(1, 2.0 * Math.fma(rotationX, rotationY, -_t1)).withLane(2, 2.0 * Math.fma(rotationX, rotationZ, _t2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translationY).fma(UNIT_W, _sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t1)).withLane(2, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).withLane(1, Math.fma(-2.0, Math.fma(rotationX, rotationX, _t0), 1.0))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translationZ).fma(UNIT_W, _sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t2)).withLane(1, Math.fma(rotationX, rotationW, rotationY * rotationZ))).withLane(2, Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRS_mulAdd(double[] dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationZ * rotationZ;
        double _t1 = rotationZ * rotationW;
        double _t2 = rotationY * rotationW;
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, scaleX).withLane(1, scaleY).withLane(2, scaleZ);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 2.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translationX).mul(UNIT_W).add(_sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0, Math.fma(rotationY, rotationY, _t0), 1.0)).withLane(1, 2.0 * Math.fma(rotationX, rotationY, -_t1)).withLane(2, 2.0 * Math.fma(rotationX, rotationZ, _t2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translationY).mul(UNIT_W).add(_sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationY, _t1)).withLane(2, Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).withLane(1, Math.fma(-2.0, Math.fma(rotationX, rotationX, _t0), 1.0))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translationZ).mul(UNIT_W).add(_sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(rotationX, rotationZ, -_t2)).withLane(1, Math.fma(rotationX, rotationW, rotationY * rotationZ))).withLane(2, Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRS(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset) {
        if (SimdSupport.USE_FMA) return composeTRS_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset);
        return composeTRS_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset);
    }

    public static double[] composeTRS_fma(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset) {
        double _scalex = scale[scaleOffset + 0];
        double _scaley = scale[scaleOffset + 1];
        double _scalez = scale[scaleOffset + 2];
        double _rotationy = rotation[rotationOffset + 1];
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationz = rotation[rotationOffset + 2];
        double _rotationw = rotation[rotationOffset + 3];
        double _t0 = _rotationz * _rotationz;
        double _t1 = _rotationz * _rotationw;
        double _t2 = _rotationy * _rotationw;
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _scalex).withLane(1, _scaley).withLane(2, _scalez);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 2.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).fma(UNIT_W, _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t0), 1.0)).withLane(1, 2.0 * Math.fma(_rotationx, _rotationy, -_t1)).withLane(2, 2.0 * Math.fma(_rotationx, _rotationz, _t2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).fma(UNIT_W, _sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t1)).withLane(2, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).withLane(1, Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t0), 1.0))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).fma(UNIT_W, _sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t2)).withLane(1, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).withLane(2, Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRS_mulAdd(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset) {
        double _scalex = scale[scaleOffset + 0];
        double _scaley = scale[scaleOffset + 1];
        double _scalez = scale[scaleOffset + 2];
        double _rotationy = rotation[rotationOffset + 1];
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationz = rotation[rotationOffset + 2];
        double _rotationw = rotation[rotationOffset + 3];
        double _t0 = _rotationz * _rotationz;
        double _t1 = _rotationz * _rotationw;
        double _t2 = _rotationy * _rotationw;
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _scalex).withLane(1, _scaley).withLane(2, _scalez);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, 2.0);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).mul(UNIT_W).add(_sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t0), 1.0)).withLane(1, 2.0 * Math.fma(_rotationx, _rotationy, -_t1)).withLane(2, 2.0 * Math.fma(_rotationx, _rotationz, _t2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).mul(UNIT_W).add(_sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationy, _t1)).withLane(2, Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).withLane(1, Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t0), 1.0))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).mul(UNIT_W).add(_sv0.mul(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_rotationx, _rotationz, -_t2)).withLane(1, Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).withLane(2, Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRSMul(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return composeTRSMul_mulAdd(dest, destOffset, m, mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
    }

    public static double[] composeTRSMul_fma(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationY * rotationW;
        double _t1 = rotationZ * rotationZ;
        double _t2 = rotationZ * rotationW;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translationX).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t2)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t1), 1.0))))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translationY).fma(UNIT_W, _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, scaleX * 2.0 * Math.fma(rotationX, rotationY, _t2)), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW))), _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t1), 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translationZ).fma(UNIT_W, _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t0)), _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRSMul_mulAdd(double[] dest, int destOffset, double[] m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        double _t0 = rotationY * rotationW;
        double _t1 = rotationZ * rotationZ;
        double _t2 = rotationZ * rotationW;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translationX).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleZ * 2.0 * Math.fma(rotationX, rotationZ, _t0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleY * 2.0 * Math.fma(rotationX, rotationY, -_t2))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleX * Math.fma(-2.0, Math.fma(rotationY, rotationY, _t1), 1.0))))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translationY).mul(UNIT_W).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleX * 2.0 * Math.fma(rotationX, rotationY, _t2))).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleZ * 2.0 * Math.fma(rotationY, rotationZ, -(rotationX * rotationW)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleY * Math.fma(-2.0, Math.fma(rotationX, rotationX, _t1), 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translationZ).mul(UNIT_W).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleY * 2.0 * Math.fma(rotationX, rotationW, rotationY * rotationZ))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleX * 2.0 * Math.fma(rotationX, rotationZ, -_t0))).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, scaleZ * Math.fma(-2.0, Math.fma(rotationX, rotationX, rotationY * rotationY), 1.0))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRSMul(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return composeTRSMul_fma(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
        return composeTRSMul_mulAdd(dest, destOffset, translation, translationOffset, rotation, rotationOffset, scale, scaleOffset, m, mOffset);
    }

    public static double[] composeTRSMul_fma(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _scalez = scale[scaleOffset + 2];
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationz = rotation[rotationOffset + 2];
        double _scaley = scale[scaleOffset + 1];
        double _rotationy = rotation[rotationOffset + 1];
        double _scalex = scale[scaleOffset + 0];
        double _rotationw = rotation[rotationOffset + 3];
        double _t0 = _rotationy * _rotationw;
        double _t1 = _rotationz * _rotationz;
        double _t2 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _scalez * 2.0 * Math.fma(_rotationx, _rotationz, _t0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _scaley * 2.0 * Math.fma(_rotationx, _rotationy, -_t2)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalex * Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t1), 1.0))))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).fma(UNIT_W, _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _scalex * 2.0 * Math.fma(_rotationx, _rotationy, _t2)), _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _scalez * 2.0 * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw))), _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _scaley * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t1), 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).fma(UNIT_W, _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _scaley * 2.0 * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz)), _sv2.fma(DoubleVector.broadcast(SIMD_SPECIES, _scalex * 2.0 * Math.fma(_rotationx, _rotationz, -_t0)), _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalez * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] composeTRSMul_mulAdd(double[] dest, int destOffset, double[] translation, int translationOffset, double[] rotation, int rotationOffset, double[] scale, int scaleOffset, double[] m, int mOffset) {
        double _scalez = scale[scaleOffset + 2];
        double _rotationx = rotation[rotationOffset + 0];
        double _rotationz = rotation[rotationOffset + 2];
        double _scaley = scale[scaleOffset + 1];
        double _rotationy = rotation[rotationOffset + 1];
        double _scalex = scale[scaleOffset + 0];
        double _rotationw = rotation[rotationOffset + 3];
        double _t0 = _rotationy * _rotationw;
        double _t1 = _rotationz * _rotationz;
        double _t2 = _rotationz * _rotationw;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset + 4);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, m, mOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 0]).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalez * 2.0 * Math.fma(_rotationx, _rotationz, _t0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _scaley * 2.0 * Math.fma(_rotationx, _rotationy, -_t2))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalex * Math.fma(-2.0, Math.fma(_rotationy, _rotationy, _t1), 1.0))))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 1]).mul(UNIT_W).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalex * 2.0 * Math.fma(_rotationx, _rotationy, _t2))).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalez * 2.0 * Math.fma(_rotationy, _rotationz, -(_rotationx * _rotationw)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _scaley * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _t1), 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, translation[translationOffset + 2]).mul(UNIT_W).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _scaley * 2.0 * Math.fma(_rotationx, _rotationw, _rotationy * _rotationz))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalex * 2.0 * Math.fma(_rotationx, _rotationz, -_t0))).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _scalez * Math.fma(-2.0, Math.fma(_rotationx, _rotationx, _rotationy * _rotationy), 1.0))))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        double _t10 = _t5 > 0.0 ? _t1 * _t6 : 0.0;
        double _t11 = _t5 > 0.0 ? _t2 * _t6 : 0.0;
        double _t12 = _t5 > 0.0 ? _t0 * _t6 : 0.0;
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32 = _t27 > 0.0 ? _t22 * _t28 : 0.0;
        double _t33 = _t27 > 0.0 ? _t21 * _t28 : 0.0;
        double _t34 = _t27 > 0.0 ? _t23 * _t28 : 0.0;
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
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
        double _t10 = _t5 > 0.0 ? _t1 * _t6 : 0.0;
        double _t11 = _t5 > 0.0 ? _t2 * _t6 : 0.0;
        double _t12 = _t5 > 0.0 ? _t0 * _t6 : 0.0;
        double _t21 = Math.fma(upX, _t11, -(upY * _t10));
        double _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        double _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        double _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32 = _t27 > 0.0 ? _t22 * _t28 : 0.0;
        double _t33 = _t27 > 0.0 ? _t21 * _t28 : 0.0;
        double _t34 = _t27 > 0.0 ? _t23 * _t28 : 0.0;
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        double _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
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
        double _t13 = _t8 > 0.0 ? _t4 * _t9 : 0.0;
        double _t14 = _t8 > 0.0 ? _t5 * _t9 : 0.0;
        double _t15 = _t8 > 0.0 ? _t3 * _t9 : 0.0;
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35 = _t30 > 0.0 ? _t26 * _t31 : 0.0;
        double _t36 = _t30 > 0.0 ? _t25 * _t31 : 0.0;
        double _t37 = _t30 > 0.0 ? _t24 * _t31 : 0.0;
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
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
        double _t13 = _t8 > 0.0 ? _t4 * _t9 : 0.0;
        double _t14 = _t8 > 0.0 ? _t5 * _t9 : 0.0;
        double _t15 = _t8 > 0.0 ? _t3 * _t9 : 0.0;
        double _t24 = Math.fma(upY, _t13, -(upX * _t14));
        double _t25 = Math.fma(upX, _t15, -(upZ * _t13));
        double _t26 = Math.fma(upZ, _t14, -(upY * _t15));
        double _t27 = Math.fma(eyeZ, _t15, Math.fma(eyeX, _t13, eyeY * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35 = _t30 > 0.0 ? _t26 * _t31 : 0.0;
        double _t36 = _t30 > 0.0 ? _t25 * _t31 : 0.0;
        double _t37 = _t30 > 0.0 ? _t24 * _t31 : 0.0;
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(eyeZ, _t37, Math.fma(eyeX, _t35, eyeY * _t36));
        double _t52 = Math.fma(eyeZ, _t48, Math.fma(eyeX, _t46, eyeY * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        double _t10 = _t5 > 0.0 ? _t1 * _t6 : 0.0;
        double _t11 = _t5 > 0.0 ? _t2 * _t6 : 0.0;
        double _t12 = _t5 > 0.0 ? _t0 * _t6 : 0.0;
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32 = _t27 > 0.0 ? _t22 * _t28 : 0.0;
        double _t33 = _t27 > 0.0 ? _t21 * _t28 : 0.0;
        double _t34 = _t27 > 0.0 ? _t23 * _t28 : 0.0;
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
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
        double _t10 = _t5 > 0.0 ? _t1 * _t6 : 0.0;
        double _t11 = _t5 > 0.0 ? _t2 * _t6 : 0.0;
        double _t12 = _t5 > 0.0 ? _t0 * _t6 : 0.0;
        double _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        double _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        double _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        double _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        double _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t28 = (1.0 / Math.sqrt(_t27));
        double _t32 = _t27 > 0.0 ? _t22 * _t28 : 0.0;
        double _t33 = _t27 > 0.0 ? _t21 * _t28 : 0.0;
        double _t34 = _t27 > 0.0 ? _t23 * _t28 : 0.0;
        double _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        double _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        double _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        double _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        double _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t32).withLane(1, _t34).withLane(2, _t33);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t43).withLane(1, _t44).withLane(2, _t45).withLane(3, _t47);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t10).withLane(1, _t11).withLane(2, _t12);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, -_self00).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self01 * _t49 + -_self02 * _t24).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, -_self10).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self11 * _t49 + -_self12 * _t24).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, -_self20).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self21 * _t49 + -_self22 * _t24).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv2))));
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
        double _t13 = _t8 > 0.0 ? _t4 * _t9 : 0.0;
        double _t14 = _t8 > 0.0 ? _t5 * _t9 : 0.0;
        double _t15 = _t8 > 0.0 ? _t3 * _t9 : 0.0;
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35 = _t30 > 0.0 ? _t26 * _t31 : 0.0;
        double _t36 = _t30 > 0.0 ? _t25 * _t31 : 0.0;
        double _t37 = _t30 > 0.0 ? _t24 * _t31 : 0.0;
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).fma(_sv1, DoubleVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
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
        double _t13 = _t8 > 0.0 ? _t4 * _t9 : 0.0;
        double _t14 = _t8 > 0.0 ? _t5 * _t9 : 0.0;
        double _t15 = _t8 > 0.0 ? _t3 * _t9 : 0.0;
        double _t24 = Math.fma(_upy, _t13, -(_upx * _t14));
        double _t25 = Math.fma(_upx, _t15, -(_upz * _t13));
        double _t26 = Math.fma(_upz, _t14, -(_upy * _t15));
        double _t27 = Math.fma(_eyez, _t15, Math.fma(_eyex, _t13, _eyey * _t14));
        double _t30 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        double _t31 = (1.0 / Math.sqrt(_t30));
        double _t35 = _t30 > 0.0 ? _t26 * _t31 : 0.0;
        double _t36 = _t30 > 0.0 ? _t25 * _t31 : 0.0;
        double _t37 = _t30 > 0.0 ? _t24 * _t31 : 0.0;
        double _t46 = Math.fma(_t15, _t36, -(_t14 * _t37));
        double _t47 = Math.fma(_t13, _t37, -(_t15 * _t35));
        double _t48 = Math.fma(_t14, _t35, -(_t13 * _t36));
        double _t50 = Math.fma(_eyez, _t37, Math.fma(_eyex, _t35, _eyey * _t36));
        double _t52 = Math.fma(_eyez, _t48, Math.fma(_eyex, _t46, _eyey * _t47));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t13).withLane(1, _t14).withLane(2, _t15);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t35).withLane(1, _t36).withLane(2, _t37).withLane(3, _t27);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t46).withLane(1, _t47).withLane(2, _t48);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, -_self02).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self00).withLane(3, _self02).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self00 * _t50 + -_self01 * _t52).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).mul(_sv2))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, -_self12).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self10).withLane(3, _self12).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self10 * _t50 + -_self11 * _t52).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).mul(_sv2))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, -_self22).mul(_sv0)).add(DoubleVector.broadcast(SIMD_SPECIES, _self20).withLane(3, _self22).mul(_sv1).add(DoubleVector.broadcast(SIMD_SPECIES, -_self20 * _t50 + -_self21 * _t52).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).mul(_sv2))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] mapXYZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4));
            _c.intoArray(dest, destOffset + _li * 4);
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

    public static double[] mapXnYZ(double[] dest, int destOffset, double[] src, int srcOffset) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).withLane(1, -src[(srcOffset + _li * 4) + 1]);
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] preRotateAround(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
    }

    public static double[] preRotateAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _t0 = -pivotZ;
        double _t1 = rotY * rotW;
        double _t2 = rotZ * rotZ;
        double _t3 = rotZ * rotW;
        double _t11 = Math.fma(rotY, rotY, _t2);
        double _t13 = Math.fma(rotX, rotX, _t2);
        double _t14 = Math.fma(rotX, rotX, rotY * rotY);
        double _t19 = 2.0 * Math.fma(rotX, rotZ, _t1);
        double _t20 = 2.0 * Math.fma(rotX, rotY, _t3);
        double _t21 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t22 = 2.0 * Math.fma(rotX, rotY, -_t3);
        double _t23 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t24 = 2.0 * Math.fma(rotX, rotZ, -_t1);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(pivotX, 2.0 * _t11, -(pivotY * _t22)))).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t11, 1.0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(pivotY, 2.0 * _t13, -(pivotX * _t20)))).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t23), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t13, 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0 * _t14, -(pivotX * _t24)))).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t14, 1.0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t24), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        double _t0 = -pivotZ;
        double _t1 = rotY * rotW;
        double _t2 = rotZ * rotZ;
        double _t3 = rotZ * rotW;
        double _t11 = Math.fma(rotY, rotY, _t2);
        double _t13 = Math.fma(rotX, rotX, _t2);
        double _t14 = Math.fma(rotX, rotX, rotY * rotY);
        double _t19 = 2.0 * Math.fma(rotX, rotZ, _t1);
        double _t20 = 2.0 * Math.fma(rotX, rotY, _t3);
        double _t21 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t22 = 2.0 * Math.fma(rotX, rotY, -_t3);
        double _t23 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t24 = 2.0 * Math.fma(rotX, rotZ, -_t1);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(pivotX, 2.0 * _t11, -(pivotY * _t22)))).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t11, 1.0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(pivotY, 2.0 * _t13, -(pivotX * _t20)))).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t23)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t13, 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0 * _t14, -(pivotX * _t24)))).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t14, 1.0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t24)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        if (SimdSupport.USE_FMA) return preRotateAround_fma(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
        return preRotateAround_mulAdd(dest, destOffset, src, srcOffset, rot, rotOffset, pivot, pivotOffset);
    }

    public static double[] preRotateAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _roty = rot[rotOffset + 1];
        double _rotw = rot[rotOffset + 3];
        double _rotz = rot[rotOffset + 2];
        double _rotx = rot[rotOffset + 0];
        double _t0 = -_pivotz;
        double _t1 = _roty * _rotw;
        double _t2 = _rotz * _rotz;
        double _t3 = _rotz * _rotw;
        double _t11 = Math.fma(_roty, _roty, _t2);
        double _t13 = Math.fma(_rotx, _rotx, _t2);
        double _t14 = Math.fma(_rotx, _rotx, _roty * _roty);
        double _t19 = 2.0 * Math.fma(_rotx, _rotz, _t1);
        double _t20 = 2.0 * Math.fma(_rotx, _roty, _t3);
        double _t21 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t22 = 2.0 * Math.fma(_rotx, _roty, -_t3);
        double _t23 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t24 = 2.0 * Math.fma(_rotx, _rotz, -_t1);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(_pivotx, 2.0 * _t11, -(_pivoty * _t22)))).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t19), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t11, 1.0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(_pivoty, 2.0 * _t13, -(_pivotx * _t20)))).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t23), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t20), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t13, 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0 * _t14, -(_pivotx * _t24)))).fma(UNIT_W, _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t14, 1.0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, _t24), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] rot, int rotOffset, double[] pivot, int pivotOffset) {
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _roty = rot[rotOffset + 1];
        double _rotw = rot[rotOffset + 3];
        double _rotz = rot[rotOffset + 2];
        double _rotx = rot[rotOffset + 0];
        double _t0 = -_pivotz;
        double _t1 = _roty * _rotw;
        double _t2 = _rotz * _rotz;
        double _t3 = _rotz * _rotw;
        double _t11 = Math.fma(_roty, _roty, _t2);
        double _t13 = Math.fma(_rotx, _rotx, _t2);
        double _t14 = Math.fma(_rotx, _rotx, _roty * _roty);
        double _t19 = 2.0 * Math.fma(_rotx, _rotz, _t1);
        double _t20 = 2.0 * Math.fma(_rotx, _roty, _t3);
        double _t21 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t22 = 2.0 * Math.fma(_rotx, _roty, -_t3);
        double _t23 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t24 = 2.0 * Math.fma(_rotx, _rotz, -_t1);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t19, Math.fma(_pivotx, 2.0 * _t11, -(_pivoty * _t22)))).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t19)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t11, 1.0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t22)))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t0, _t23, Math.fma(_pivoty, 2.0 * _t13, -(_pivotx * _t20)))).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t23)).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t20)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t13, 1.0))))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0 * _t14, -(_pivotx * _t24)))).mul(UNIT_W).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, _t14, 1.0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, _t24)).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t21)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAxis(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (SimdSupport.USE_FMA) return preRotateAxis_fma(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
        return preRotateAxis_mulAdd(dest, destOffset, src, srcOffset, angle, axisX, axisY, axisZ);
    }

    public static double[] preRotateAxis_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = axisX * axisZ;
        double _t5 = axisX * axisY;
        double _t7 = axisY * axisZ;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t2 * _t3)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisX * axisX, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(axisZ * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(axisX * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t2 * _t5)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisY * axisY, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisZ * axisZ, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(axisY * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateAxis_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = Math.sin(angle);
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = axisX * axisZ;
        double _t5 = axisX * axisY;
        double _t7 = axisY * axisZ;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisY, _t0, _t2 * _t3))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisX * axisX, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(axisZ * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(axisX * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisZ, _t0, _t2 * _t5))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisY * axisY, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, axisZ * axisZ, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(axisY * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(axisX, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = _axisx * _axisz;
        double _t5 = _axisx * _axisy;
        double _t7 = _axisy * _axisz;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t2 * _t3)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisx * _axisx, _t1)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(_axisz * _t0))))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(_axisx * _t0))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t2 * _t5)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisz * _axisz, _t1)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_axisy * _t0))), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t2 * _t7)))));
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
        double _t1 = Math.cos(angle);
        double _t2 = 1.0 - _t1;
        double _t3 = _axisx * _axisz;
        double _t5 = _axisx * _axisy;
        double _t7 = _axisy * _axisz;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisy, _t0, _t2 * _t3))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisx * _axisx, _t1))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t5, -(_axisz * _t0))))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t7, -(_axisx * _t0)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisz, _t0, _t2 * _t5))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisy * _axisy, _t1)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _axisz * _axisz, _t1))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_t2, _t3, -(_axisy * _t0)))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_axisx, _t0, _t2 * _t7)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateQuat(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, qX, qY, qZ, qW);
    }

    public static double[] preRotateQuat_fma(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = qY * qW;
        double _t1 = qZ * qZ;
        double _t2 = qZ * qW;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qZ, _t0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(qY, qY, _t1), 1.0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qY, -_t2)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qY, qZ, -(qX * qW))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qY, _t2)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(qX, qX, _t1), 1.0)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qZ, -_t0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qW, qY * qZ)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateQuat_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _t0 = qY * qW;
        double _t1 = qZ * qZ;
        double _t2 = qZ * qW;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qZ, _t0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(qY, qY, _t1), 1.0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qY, -_t2)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qY, qZ, -(qX * qW)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qY, _t2))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(qX, qX, _t1), 1.0)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(qX, qX, qY * qY), 1.0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qZ, -_t0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(qX, qW, qY * qZ)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateQuat(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        if (SimdSupport.USE_FMA) return preRotateQuat_fma(dest, destOffset, src, srcOffset, q, qOffset);
        return preRotateQuat_mulAdd(dest, destOffset, src, srcOffset, q, qOffset);
    }

    public static double[] preRotateQuat_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        double _qx = q[qOffset + 0];
        double _qz = q[qOffset + 2];
        double _qy = q[qOffset + 1];
        double _qw = q[qOffset + 3];
        double _t0 = _qy * _qw;
        double _t1 = _qz * _qz;
        double _t2 = _qz * _qw;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qz, _t0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(_qy, _qy, _t1), 1.0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qy, -_t2)))));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qy, _qz, -(_qx * _qw))), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qy, _t2)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(_qx, _qx, _t1), 1.0)))));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0)), _sv1.fma(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qz, -_t0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qw, _qy * _qz)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateQuat_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] q, int qOffset) {
        double _qx = q[qOffset + 0];
        double _qz = q[qOffset + 2];
        double _qy = q[qOffset + 1];
        double _qw = q[qOffset + 3];
        double _t0 = _qy * _qw;
        double _t1 = _qz * _qz;
        double _t2 = _qz * _qw;
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qz, _t0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(_qy, _qy, _t1), 1.0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qy, -_t2)))));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qy, _qz, -(_qx * _qw)))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qy, _t2))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(_qx, _qx, _t1), 1.0)))));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(-2.0, Math.fma(_qx, _qx, _qy * _qy), 1.0))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qz, -_t0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.fma(_qx, _qw, _qy * _qz)))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateX(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateX_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateX_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static double[] preRotateX_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c2 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t1), _sv2.mul(_sv1));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateX_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c1 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c2 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t1)).add(_sv2.mul(_sv1));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateY(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateY_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateY_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static double[] preRotateY_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t1)));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv2.fma(_sv1, _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t1)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateY_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, _t1)));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c2 = _sv2.mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t1)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateZ(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        if (SimdSupport.USE_FMA) return preRotateZ_fma(dest, destOffset, src, srcOffset, angle);
        return preRotateZ_mulAdd(dest, destOffset, src, srcOffset, angle);
    }

    public static double[] preRotateZ_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.fma(_sv1, _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c1 = _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, _t1), _sv2.mul(_sv1));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preRotateZ_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angle) {
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, _t0);
        var _sv2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4);
        var _c0 = _sv0.mul(_sv1).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, -_t1)));
        var _c1 = _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t1)).add(_sv2.mul(_sv1));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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

    public static double[] preScale(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 0]));
        var _c1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4).mul(DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 1]));
        var _c2 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8).mul(DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 2]));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScale(double[] dest, int destOffset, double[] src, int srcOffset, double s) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, s).mul(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-s, pivotX, Math.fma(s, src[srcOffset + 3], pivotX)));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-s, pivotY, Math.fma(s, src[srcOffset + 7], pivotY)));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-s, pivotZ, Math.fma(s, src[srcOffset + 11], pivotZ)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-s, _pivotx, Math.fma(s, src[srcOffset + 3], _pivotx)));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-s, _pivoty, Math.fma(s, src[srcOffset + 7], _pivoty)));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-s, _pivotz, Math.fma(s, src[srcOffset + 11], _pivotz)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, sX).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-pivotX, sX, Math.fma(sX, src[srcOffset + 3], pivotX)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, sY).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-pivotY, sY, Math.fma(sY, src[srcOffset + 7], pivotY)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, sZ).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-pivotZ, sZ, Math.fma(sZ, src[srcOffset + 11], pivotZ)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preScaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _sx = s[sOffset + 0];
        double _pivotx = pivot[pivotOffset + 0];
        double _sy = s[sOffset + 1];
        double _pivoty = pivot[pivotOffset + 1];
        double _sz = s[sOffset + 2];
        double _pivotz = pivot[pivotOffset + 2];
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, _sx).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(-_pivotx, _sx, Math.fma(_sx, src[srcOffset + 3], _pivotx)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, _sy).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(-_pivoty, _sy, Math.fma(_sy, src[srcOffset + 7], _pivoty)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, _sz).mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(-_pivotz, _sz, Math.fma(_sz, src[srcOffset + 11], _pivotz)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preTranslate(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        if (SimdSupport.USE_FMA) return preTranslate_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return preTranslate_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static double[] preTranslate_fma(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, vX).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, vY).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, vZ).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preTranslate_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, vX).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, vY).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, vZ).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preTranslate(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return preTranslate_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return preTranslate_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static double[] preTranslate_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 0]).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 1]).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 2]).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] preTranslate_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 0]).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 1]).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, v[vOffset + 2]).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        double _t9 = 2.0 * normalX * normalZ;
        double _t10 = 2.0 * normalX * normalY;
        double _t11 = 2.0 * normalY * normalZ;
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
        double _t9 = 2.0 * normalX * normalZ;
        double _t10 = 2.0 * normalX * normalY;
        double _t11 = 2.0 * normalY * normalZ;
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
        double _t9 = 2.0 * _normalx * _normalz;
        double _t10 = 2.0 * _normalx * _normaly;
        double _t11 = 2.0 * _normaly * _normalz;
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
        double _t9 = 2.0 * _normalx * _normalz;
        double _t10 = 2.0 * _normalx * _normaly;
        double _t11 = 2.0 * _normaly * _normalz;
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
        double _t0 = -pivotZ;
        double _t2 = rotY * rotW;
        double _t3 = rotZ * rotZ;
        double _t4 = rotZ * rotW;
        double _t11 = Math.fma(rotY, rotY, _t3);
        double _t14 = Math.fma(rotX, rotX, _t3);
        double _t15 = Math.fma(rotX, rotX, rotY * rotY);
        double _t20 = 2.0 * Math.fma(rotX, rotY, _t4);
        double _t21 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t22 = 2.0 * Math.fma(rotX, rotZ, _t2);
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t2);
        double _t27 = 2.0 * Math.fma(rotX, rotY, -_t4);
        double _t28 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t29 = Math.fma(-2.0, _t11, 1.0);
        double _t30 = Math.fma(-2.0, _t14, 1.0);
        double _t31 = Math.fma(-2.0, _t15, 1.0);
        double _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0 * _t11, -(pivotY * _t27)));
        double _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0 * _t14, -(pivotX * _t20)));
        double _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0 * _t15, -(pivotX * _t26)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, _sv0.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, _sv4.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, _sv5.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
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
        double _t0 = -pivotZ;
        double _t2 = rotY * rotW;
        double _t3 = rotZ * rotZ;
        double _t4 = rotZ * rotW;
        double _t11 = Math.fma(rotY, rotY, _t3);
        double _t14 = Math.fma(rotX, rotX, _t3);
        double _t15 = Math.fma(rotX, rotX, rotY * rotY);
        double _t20 = 2.0 * Math.fma(rotX, rotY, _t4);
        double _t21 = 2.0 * Math.fma(rotX, rotW, rotY * rotZ);
        double _t22 = 2.0 * Math.fma(rotX, rotZ, _t2);
        double _t26 = 2.0 * Math.fma(rotX, rotZ, -_t2);
        double _t27 = 2.0 * Math.fma(rotX, rotY, -_t4);
        double _t28 = 2.0 * Math.fma(rotY, rotZ, -(rotX * rotW));
        double _t29 = Math.fma(-2.0, _t11, 1.0);
        double _t30 = Math.fma(-2.0, _t14, 1.0);
        double _t31 = Math.fma(-2.0, _t15, 1.0);
        double _t41 = Math.fma(_t0, _t22, Math.fma(pivotX, 2.0 * _t11, -(pivotY * _t27)));
        double _t42 = Math.fma(_t0, _t28, Math.fma(pivotY, 2.0 * _t14, -(pivotX * _t20)));
        double _t43 = Math.fma(-pivotY, _t21, Math.fma(pivotZ, 2.0 * _t15, -(pivotX * _t26)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(_sv0.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(_sv4.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(_sv5.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        double _pivotz = pivot[pivotOffset + 2];
        double _roty = rot[rotOffset + 1];
        double _rotw = rot[rotOffset + 3];
        double _rotz = rot[rotOffset + 2];
        double _rotx = rot[rotOffset + 0];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _t0 = -_pivotz;
        double _t2 = _roty * _rotw;
        double _t3 = _rotz * _rotz;
        double _t4 = _rotz * _rotw;
        double _t11 = Math.fma(_roty, _roty, _t3);
        double _t14 = Math.fma(_rotx, _rotx, _t3);
        double _t15 = Math.fma(_rotx, _rotx, _roty * _roty);
        double _t20 = 2.0 * Math.fma(_rotx, _roty, _t4);
        double _t21 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t22 = 2.0 * Math.fma(_rotx, _rotz, _t2);
        double _t26 = 2.0 * Math.fma(_rotx, _rotz, -_t2);
        double _t27 = 2.0 * Math.fma(_rotx, _roty, -_t4);
        double _t28 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t29 = Math.fma(-2.0, _t11, 1.0);
        double _t30 = Math.fma(-2.0, _t14, 1.0);
        double _t31 = Math.fma(-2.0, _t15, 1.0);
        double _t41 = Math.fma(_t0, _t22, Math.fma(_pivotx, 2.0 * _t11, -(_pivoty * _t27)));
        double _t42 = Math.fma(_t0, _t28, Math.fma(_pivoty, 2.0 * _t14, -(_pivotx * _t20)));
        double _t43 = Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0 * _t15, -(_pivotx * _t26)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).fma(UNIT_W, _sv0.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).fma(UNIT_W, _sv4.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).fma(UNIT_W, _sv5.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).fma(_sv2, DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).fma(UNIT_W, DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
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
        double _pivotz = pivot[pivotOffset + 2];
        double _roty = rot[rotOffset + 1];
        double _rotw = rot[rotOffset + 3];
        double _rotz = rot[rotOffset + 2];
        double _rotx = rot[rotOffset + 0];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _t0 = -_pivotz;
        double _t2 = _roty * _rotw;
        double _t3 = _rotz * _rotz;
        double _t4 = _rotz * _rotw;
        double _t11 = Math.fma(_roty, _roty, _t3);
        double _t14 = Math.fma(_rotx, _rotx, _t3);
        double _t15 = Math.fma(_rotx, _rotx, _roty * _roty);
        double _t20 = 2.0 * Math.fma(_rotx, _roty, _t4);
        double _t21 = 2.0 * Math.fma(_rotx, _rotw, _roty * _rotz);
        double _t22 = 2.0 * Math.fma(_rotx, _rotz, _t2);
        double _t26 = 2.0 * Math.fma(_rotx, _rotz, -_t2);
        double _t27 = 2.0 * Math.fma(_rotx, _roty, -_t4);
        double _t28 = 2.0 * Math.fma(_roty, _rotz, -(_rotx * _rotw));
        double _t29 = Math.fma(-2.0, _t11, 1.0);
        double _t30 = Math.fma(-2.0, _t14, 1.0);
        double _t31 = Math.fma(-2.0, _t15, 1.0);
        double _t41 = Math.fma(_t0, _t22, Math.fma(_pivotx, 2.0 * _t11, -(_pivoty * _t27)));
        double _t42 = Math.fma(_t0, _t28, Math.fma(_pivoty, 2.0 * _t14, -(_pivotx * _t20)));
        double _t43 = Math.fma(-_pivoty, _t21, Math.fma(_pivotz, 2.0 * _t15, -(_pivotx * _t26)));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, _self00);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t29).withLane(1, _t27).withLane(2, _t22);
        var _sv2 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t30).withLane(2, _t28).withLane(3, _t41);
        var _sv3 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t26).withLane(1, _t21).withLane(2, _t31);
        var _sv4 = DoubleVector.broadcast(SIMD_SPECIES, _self10);
        var _sv5 = DoubleVector.broadcast(SIMD_SPECIES, _self20);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 3]).mul(UNIT_W).add(_sv0.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self01).withLane(3, _self00).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t42 + _self02 * _t43).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self02).mul(_sv3))));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 7]).mul(UNIT_W).add(_sv4.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self11).withLane(3, _self10).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t42 + _self12 * _t43).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self12).mul(_sv3))));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 11]).mul(UNIT_W).add(_sv5.mul(_sv1)).add(DoubleVector.broadcast(SIMD_SPECIES, _self21).withLane(3, _self20).mul(_sv2).add(DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t42 + _self22 * _t43).mul(UNIT_W).add(DoubleVector.broadcast(SIMD_SPECIES, _self22).mul(_sv3))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] rotateYXZ(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (SimdSupport.USE_FMA) return rotateYXZ_fma(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
        return rotateYXZ_mulAdd(dest, destOffset, src, srcOffset, angleX, angleY, angleZ);
    }

    public static double[] rotateYXZ_fma(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = Math.sin(angleX);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t13 = _t5 * _t4;
        double _t14 = _t5 * _t1;
        double _t15 = _t3 * _t5;
        double _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        double _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t15);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t13).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t14 - _self01 * _t0)).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t13).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t14 - _self11 * _t0)).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]).fma(_sv0, DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t13).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t14 - _self21 * _t0)).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] rotateYXZ_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _self01 = src[srcOffset + 1];
        double _self02 = src[srcOffset + 2];
        double _self11 = src[srcOffset + 5];
        double _self12 = src[srcOffset + 6];
        double _self21 = src[srcOffset + 9];
        double _self22 = src[srcOffset + 10];
        double _t0 = Math.sin(angleX);
        double _t1 = Math.cos(angleY);
        double _t2 = Math.sin(angleZ);
        double _t3 = Math.sin(angleY);
        double _t4 = Math.cos(angleZ);
        double _t5 = Math.cos(angleX);
        double _t6 = _t0 * _t1;
        double _t8 = _t0 * _t3;
        double _t10 = _t2 * _t5;
        double _t13 = _t5 * _t4;
        double _t14 = _t5 * _t1;
        double _t15 = _t3 * _t5;
        double _t18 = Math.fma(_t8, _t2, _t1 * _t4);
        double _t19 = Math.fma(_t6, _t4, _t3 * _t2);
        double _t20 = Math.fma(_t6, _t2, -(_t3 * _t4));
        double _t21 = Math.fma(_t8, _t4, -(_t2 * _t1));
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t18).withLane(1, _t21).withLane(2, _t15);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 0]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self01 * _t10).withLane(1, _self01 * _t13).add(DoubleVector.broadcast(SIMD_SPECIES, _self02 * _t20).withLane(1, _self02 * _t19)).withLane(2, _self02 * _t14 - _self01 * _t0)).withLane(3, src[srcOffset + 3]);
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 4]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self11 * _t10).withLane(1, _self11 * _t13).add(DoubleVector.broadcast(SIMD_SPECIES, _self12 * _t20).withLane(1, _self12 * _t19)).withLane(2, _self12 * _t14 - _self11 * _t0)).withLane(3, src[srcOffset + 7]);
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, src[srcOffset + 8]).mul(_sv0).add(DoubleVector.broadcast(SIMD_SPECIES, _self21 * _t10).withLane(1, _self21 * _t13).add(DoubleVector.broadcast(SIMD_SPECIES, _self22 * _t20).withLane(1, _self22 * _t19)).withLane(2, _self22 * _t14 - _self21 * _t0)).withLane(3, src[srcOffset + 11]);
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scale(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        if (SimdSupport.USE_FMA) return scale_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return scale_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static double[] scale_fma(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] scale_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, vX).withLane(1, vY).withLane(2, vZ)));
            _c.intoArray(dest, destOffset + _li * 4);
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
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] scale_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 3]).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _vx).withLane(1, _vy).withLane(2, _vz)));
            _c.intoArray(dest, destOffset + _li * 4);
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

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        double _t0 = Math.fma(-s, pivotX, pivotX);
        double _t1 = Math.fma(-s, pivotY, pivotY);
        double _t2 = Math.fma(-s, pivotZ, pivotZ);
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(src[srcOffset + 0], _t0, Math.fma(src[srcOffset + 1], _t1, Math.fma(src[srcOffset + 2], _t2, src[srcOffset + 3]))));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(src[srcOffset + 4], _t0, Math.fma(src[srcOffset + 5], _t1, Math.fma(src[srcOffset + 6], _t2, src[srcOffset + 7]))));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(src[srcOffset + 8], _t0, Math.fma(src[srcOffset + 9], _t1, Math.fma(src[srcOffset + 10], _t2, src[srcOffset + 11]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double[] pivot, int pivotOffset, double s) {
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _t0 = Math.fma(-s, _pivotx, _pivotx);
        double _t1 = Math.fma(-s, _pivoty, _pivoty);
        double _t2 = Math.fma(-s, _pivotz, _pivotz);
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, s);
        var _c0 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)).withLane(3, Math.fma(src[srcOffset + 0], _t0, Math.fma(src[srcOffset + 1], _t1, Math.fma(src[srcOffset + 2], _t2, src[srcOffset + 3]))));
        var _c1 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)).withLane(3, Math.fma(src[srcOffset + 4], _t0, Math.fma(src[srcOffset + 5], _t1, Math.fma(src[srcOffset + 6], _t2, src[srcOffset + 7]))));
        var _c2 = _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)).withLane(3, Math.fma(src[srcOffset + 8], _t0, Math.fma(src[srcOffset + 9], _t1, Math.fma(src[srcOffset + 10], _t2, src[srcOffset + 11]))));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scaleAround(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (SimdSupport.USE_FMA) return scaleAround_fma(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return scaleAround_mulAdd(dest, destOffset, src, srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
    }

    public static double[] scaleAround_fma(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _t3 = Math.fma(-pivotX, sX, pivotX);
        double _t4 = Math.fma(-pivotY, sY, pivotY);
        double _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).fma(UNIT_W, _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).fma(UNIT_W, _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).fma(UNIT_W, _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        double _t3 = Math.fma(-pivotX, sX, pivotX);
        double _t4 = Math.fma(-pivotY, sY, pivotY);
        double _t5 = Math.fma(-pivotZ, sZ, pivotZ);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, sX).withLane(1, sY).withLane(2, sZ);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).mul(UNIT_W).add(_sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).mul(UNIT_W).add(_sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).mul(UNIT_W).add(_sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
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
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        double _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).fma(UNIT_W, _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).fma(UNIT_W, _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).fma(UNIT_W, _sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] scaleAround_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] s, int sOffset, double[] pivot, int pivotOffset) {
        double _sx = s[sOffset + 0];
        double _sy = s[sOffset + 1];
        double _sz = s[sOffset + 2];
        double _pivotx = pivot[pivotOffset + 0];
        double _pivoty = pivot[pivotOffset + 1];
        double _pivotz = pivot[pivotOffset + 2];
        double _t3 = Math.fma(-_pivotx, _sx, _pivotx);
        double _t4 = Math.fma(-_pivoty, _sy, _pivoty);
        double _t5 = Math.fma(-_pivotz, _sz, _pivotz);
        var _sv0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _sx).withLane(1, _sy).withLane(2, _sz);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 0], _t3, Math.fma(src[srcOffset + 1], _t4, Math.fma(src[srcOffset + 2], _t5, src[srcOffset + 3])))).mul(UNIT_W).add(_sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset)));
        var _c1 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 4], _t3, Math.fma(src[srcOffset + 5], _t4, Math.fma(src[srcOffset + 6], _t5, src[srcOffset + 7])))).mul(UNIT_W).add(_sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 4)));
        var _c2 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(src[srcOffset + 8], _t3, Math.fma(src[srcOffset + 9], _t4, Math.fma(src[srcOffset + 10], _t5, src[srcOffset + 11])))).mul(UNIT_W).add(_sv0.mul(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset + 8)));
        _c0.intoArray(dest, destOffset);
        _c1.intoArray(dest, destOffset + 4);
        _c2.intoArray(dest, destOffset + 8);
        return dest;
    }

    public static double[] translate(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        if (SimdSupport.USE_FMA) return translate_fma(dest, destOffset, src, srcOffset, vX, vY, vZ);
        return translate_mulAdd(dest, destOffset, src, srcOffset, vX, vY, vZ);
    }

    public static double[] translate_fma(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * vX + (src[(srcOffset + _li * 4) + 1] * vY + src[(srcOffset + _li * 4) + 2] * vZ)).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] translate_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double vX, double vY, double vZ) {
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * vX + (src[(srcOffset + _li * 4) + 1] * vY + src[(srcOffset + _li * 4) + 2] * vZ)).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] translate(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        if (SimdSupport.USE_FMA) return translate_fma(dest, destOffset, src, srcOffset, v, vOffset);
        return translate_mulAdd(dest, destOffset, src, srcOffset, v, vOffset);
    }

    public static double[] translate_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * _vx + (src[(srcOffset + _li * 4) + 1] * _vy + src[(srcOffset + _li * 4) + 2] * _vz)).fma(UNIT_W, DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
        }
        return dest;
    }

    public static double[] translate_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] v, int vOffset) {
        double _vx = v[vOffset + 0];
        double _vy = v[vOffset + 1];
        double _vz = v[vOffset + 2];
        for (int _li = 0; _li < 3; _li++) {
            var _c = DoubleVector.broadcast(SIMD_SPECIES, src[(srcOffset + _li * 4) + 0] * _vx + (src[(srcOffset + _li * 4) + 1] * _vy + src[(srcOffset + _li * 4) + 2] * _vz)).mul(UNIT_W).add(DoubleVector.fromArray(SIMD_SPECIES, src, (srcOffset + _li * 4)));
            _c.intoArray(dest, destOffset + _li * 4);
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


    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset) {
        copyArrArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset, int count) {
        copyArrArr(dest, destOffset, src, srcOffset, count * 12);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            for (int _i = 0; _i < 12; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 12);
        } else {
            for (int _i = 0; _i < count * 12; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset) {
        if (dest.hasArray()) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr_one(_destArr, _destOff, src, srcOffset);
        } else {
            for (int _i = 0; _i < 12; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset, int count) {
        if (dest.hasArray()) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 12);
        } else {
            for (int _i = 0; _i < count * 12; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray()) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray()) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr_one(_destArr, _destOff, _srcArr, _srcOff);
            } else {
                for (int _i = 0; _i < 12; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                double[] _srcArr = src.array();
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

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (dest.hasArray()) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray()) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr(_destArr, _destOff, _srcArr, _srcOff, count * 12);
            } else {
                for (int _i = 0; _i < count * 12; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                double[] _srcArr = src.array();
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
