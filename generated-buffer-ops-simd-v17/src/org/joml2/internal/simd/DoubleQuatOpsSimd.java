package org.joml2.internal.simd;

import jdk.incubator.vector.*;
import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Vector-API isolation cell for {@link DoubleQuatOps}: every
 * {@code jdk.incubator.vector} reference of the Ops family lives in this class,
 * which is loaded and initialized only behind {@code SimdSupport.VECTOR_API}
 * guards - {@code DoubleQuatOps} and its kernel siblings link
 * and run without the incubator module. Not public API.
 */
public final class DoubleQuatOpsSimd {
    private DoubleQuatOpsSimd() {}
    private static final VectorSpecies<Double> SIMD_SPECIES = DoubleVector.SPECIES_256;
    private static final int PREFERRED_LANES = DoubleVector.SPECIES_PREFERRED.length();
    private static final DoubleVector UNIT_W = DoubleVector.fromArray(SIMD_SPECIES, new double[]{0.0, 0.0, 0.0, 1.0}, 0);

    public static double[] add(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset).add(DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] negate(double[] dest, int destOffset, double[] src, int srcOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).neg();
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] sub(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).sub(DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] set(double[] dest, int destOffset, double[] v, int vOffset) {
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, v, vOffset);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeFromMatrixMat3x3(double[] dest, int destOffset, double[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat3x3_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x3_mulAdd(dest, destOffset, m, mOffset);
    }

    public static double[] makeFromMatrixMat3x3_fma(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m11 = m[mOffset + 4];
        double _m22 = m[mOffset + 8];
        double _m21 = m[mOffset + 5];
        double _m12 = m[mOffset + 7];
        double _m01 = m[mOffset + 3];
        double _m10 = m[mOffset + 1];
        double _m02 = m[mOffset + 6];
        double _m20 = m[mOffset + 2];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeFromMatrixMat3x3_mulAdd(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m11 = m[mOffset + 4];
        double _m22 = m[mOffset + 8];
        double _m21 = m[mOffset + 5];
        double _m12 = m[mOffset + 7];
        double _m01 = m[mOffset + 3];
        double _m10 = m[mOffset + 1];
        double _m02 = m[mOffset + 6];
        double _m20 = m[mOffset + 2];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeFromMatrixMat3x4(double[] dest, int destOffset, double[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat3x4_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat3x4_mulAdd(dest, destOffset, m, mOffset);
    }

    public static double[] makeFromMatrixMat3x4_fma(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m11 = m[mOffset + 5];
        double _m22 = m[mOffset + 10];
        double _m21 = m[mOffset + 9];
        double _m12 = m[mOffset + 6];
        double _m01 = m[mOffset + 1];
        double _m10 = m[mOffset + 4];
        double _m02 = m[mOffset + 2];
        double _m20 = m[mOffset + 8];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeFromMatrixMat3x4_mulAdd(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m11 = m[mOffset + 5];
        double _m22 = m[mOffset + 10];
        double _m21 = m[mOffset + 9];
        double _m12 = m[mOffset + 6];
        double _m01 = m[mOffset + 1];
        double _m10 = m[mOffset + 4];
        double _m02 = m[mOffset + 2];
        double _m20 = m[mOffset + 8];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeFromMatrixMat4x4(double[] dest, int destOffset, double[] m, int mOffset) {
        if (SimdSupport.USE_FMA) return makeFromMatrixMat4x4_fma(dest, destOffset, m, mOffset);
        return makeFromMatrixMat4x4_mulAdd(dest, destOffset, m, mOffset);
    }

    public static double[] makeFromMatrixMat4x4_fma(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m11 = m[mOffset + 5];
        double _m22 = m[mOffset + 10];
        double _m21 = m[mOffset + 6];
        double _m12 = m[mOffset + 9];
        double _m01 = m[mOffset + 4];
        double _m10 = m[mOffset + 1];
        double _m02 = m[mOffset + 8];
        double _m20 = m[mOffset + 2];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeFromMatrixMat4x4_mulAdd(double[] dest, int destOffset, double[] m, int mOffset) {
        double _m00 = m[mOffset + 0];
        double _m11 = m[mOffset + 5];
        double _m22 = m[mOffset + 10];
        double _m21 = m[mOffset + 6];
        double _m12 = m[mOffset + 9];
        double _m01 = m[mOffset + 4];
        double _m10 = m[mOffset + 1];
        double _m02 = m[mOffset + 8];
        double _m20 = m[mOffset + 2];
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t4 = _m01 + _m10;
        double _t6 = _m02 + _m20;
        double _t7 = _m02 - _m20;
        double _t8 = _m12 + _m21;
        double _t9 = _m10 - _m01;
        double _t10 = _m22 + _t0;
        double _t14 = 1.0 + _t10;
        double _t15 = 1.0 + (_m00 - (_m11 + _m22));
        double _t16 = 1.0 + (_m11 - (_m00 + _m22));
        double _t17 = 1.0 + (_m22 - _t0);
        double _t21 = (1.0 / Math.sqrt(_t15));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (_t10  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t14)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t1).withLane(1, _t7).withLane(2, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t14)))))) : (_m00  >  Math.max(_m11, _m22) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t15)).withLane(1, _t4 * _t21).withLane(2, _t6 * _t21).withLane(3, _t1 * _t21)) : (_m11  >  _m22 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t4).withLane(2, _t8).withLane(3, _t7).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t16)))).withLane(1, Math.sqrt(_t16))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t6).withLane(1, _t8).withLane(3, _t9).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t17)))).withLane(2, Math.sqrt(_t17))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeZero(double[] dest, int destOffset) {
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, 0.0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] lerp(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, otherX, otherY, otherZ, otherW, t);
    }

    public static double[] lerp_fma(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, t).fma(DoubleVector.zero(SIMD_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0), _sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] lerp_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, t).mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, otherX).withLane(1, otherY).withLane(2, otherZ).withLane(3, otherW).sub(_sv0)).add(_sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] lerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        if (SimdSupport.USE_FMA) return lerp_fma(dest, destOffset, src, srcOffset, other, otherOffset, t);
        return lerp_mulAdd(dest, destOffset, src, srcOffset, other, otherOffset, t);
    }

    public static double[] lerp_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, t).fma(DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset).sub(_sv0), _sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] lerp_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset, double t) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, t).mul(DoubleVector.fromArray(SIMD_SPECIES, other, otherOffset).sub(_sv0)).add(_sv0);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] nlerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        if (SimdSupport.USE_FMA) return nlerp_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerp_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static double[] nlerp_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, alpha).fma(DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset).sub(_sv0), _sv0);
        double _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t11  >  0.0 ? _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t11)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] nlerp_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.broadcast(SIMD_SPECIES, alpha).mul(DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset).sub(_sv0)).add(_sv0);
        double _t11 = _sv1.mul(_sv1).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t11  >  0.0 ? _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t11)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] nlerpShortest(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        if (SimdSupport.USE_FMA) return nlerpShortest_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return nlerpShortest_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static double[] nlerpShortest_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, alpha).fma((-Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1])))  >  0.0 ? _sv0.neg() : _sv0).sub(_sv1), _sv1);
        double _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0 ? _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t24)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] nlerpShortest_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv2 = DoubleVector.broadcast(SIMD_SPECIES, alpha).mul((-Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1])))  >  0.0 ? _sv0.neg() : _sv0).sub(_sv1)).add(_sv1);
        double _t24 = _sv2.mul(_sv2).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t24  >  0.0 ? _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t24)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] slerp(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        if (SimdSupport.USE_FMA) return slerp_fma(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
        return slerp_mulAdd(dest, destOffset, src, srcOffset, targetX, targetY, targetZ, targetW, alpha);
    }

    public static double[] slerp_fma(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(src[srcOffset + 3], targetW, Math.fma(src[srcOffset + 2], targetZ, Math.fma(src[srcOffset + 0], targetX, src[srcOffset + 1] * targetY))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  0.0 ? _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0 * _t7)), _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] slerp_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(src[srcOffset + 3], targetW, Math.fma(src[srcOffset + 2], targetZ, Math.fma(src[srcOffset + 0], targetX, src[srcOffset + 1] * targetY))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.zero(SIMD_SPECIES).withLane(0, targetX).withLane(1, targetY).withLane(2, targetZ).withLane(3, targetW);
        var _c0 = (Math.abs(_t8)  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0 * _t7))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] slerp(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        if (SimdSupport.USE_FMA) return slerp_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerp_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static double[] slerp_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1]))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _c0 = (Math.abs(_t8)  >  0.0 ? _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0 * _t7)), _sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(SIMD_SPECIES, alpha).fma(_sv1, _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] slerp_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(src[srcOffset + 3], target[targetOffset + 3], Math.fma(src[srcOffset + 2], target[targetOffset + 2], Math.fma(src[srcOffset + 0], target[targetOffset + 0], src[srcOffset + 1] * target[targetOffset + 1]))))));
        double _t8 = Math.sin(_t7);
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _c0 = (Math.abs(_t8)  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0 * _t7))).add(_sv1.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(alpha * _t7)))).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / _t8)) : DoubleVector.broadcast(SIMD_SPECIES, alpha).mul(_sv1).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, _t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] slerpShortest(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        if (SimdSupport.USE_FMA) return slerpShortest_fma(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
        return slerpShortest_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, alpha);
    }

    public static double[] slerpShortest_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfw = src[srcOffset + 3];
        double _targetw = target[targetOffset + 3];
        double _selfz = src[srcOffset + 2];
        double _targetz = target[targetOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _targetx = target[targetOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _targety = target[targetOffset + 1];
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0 ? _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.sin((1.0 - alpha) * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), DoubleVector.broadcast(SIMD_SPECIES, Math.sin(alpha * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : DoubleVector.broadcast(SIMD_SPECIES, alpha).fma(_sv2, _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 - alpha))));
        double _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0 ? _sv3.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t49)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] slerpShortest_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double alpha) {
        double _selfw = src[srcOffset + 3];
        double _targetw = target[targetOffset + 3];
        double _selfz = src[srcOffset + 2];
        double _targetz = target[targetOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _targetx = target[targetOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _targety = target[targetOffset + 1];
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin((1.0 - alpha) * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(alpha * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))).mul(_sv2)).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : DoubleVector.broadcast(SIMD_SPECIES, alpha).mul(_sv2).add(_sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 - alpha))));
        double _t49 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t49  >  0.0 ? _sv3.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t49)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] calculateW(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        var _c0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, Math.sqrt(Math.max(0.0, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] difference(double[] dest, int destOffset, double[] src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfw = src[srcOffset + 3];
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _t3_inv = 1.0 / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(otherX, _selfw, -(otherW * _selfx))).withLane(2, Math.fma(otherX, _selfy, -(otherW * _selfz))).add(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(otherY, _selfz, -(otherZ * _selfy))).withLane(2, Math.fma(otherZ, _selfw, -(otherY * _selfx)))).withLane(3, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw)))).mul(DoubleVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] difference(double[] dest, int destOffset, double[] src, int srcOffset, double[] other, int otherOffset) {
        double _otherx = other[otherOffset + 0];
        double _selfw = src[srcOffset + 3];
        double _otherw = other[otherOffset + 3];
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfz = src[srcOffset + 2];
        double _othery = other[otherOffset + 1];
        double _otherz = other[otherOffset + 2];
        double _t3_inv = 1.0 / Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_otherx, _selfw, -(_otherw * _selfx))).withLane(2, Math.fma(_otherx, _selfy, -(_otherw * _selfz))).add(DoubleVector.broadcast(SIMD_SPECIES, Math.fma(_othery, _selfz, -(_otherz * _selfy))).withLane(2, Math.fma(_otherz, _selfw, -(_othery * _selfx)))).withLane(3, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw)))).mul(DoubleVector.broadcast(SIMD_SPECIES, _t3_inv)).withLane(1, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] exp(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfz = src[srcOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _t0 = Math.exp(src[srcOffset + 3]);
        double _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.sqrt(_t3);
        var _c0 = (_t3  >  0.0 ? DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).withLane(3, Math.cos(_t4)).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3))).withLane(3, _t0)) : DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, Math.cos(_t4) * _t0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] log(double[] dest, int destOffset, double[] src, int srcOffset) {
        double _selfw = src[srcOffset + 3];
        double _selfz = src[srcOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        var _c0 = (_t2  >  0.0 ? DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2)))).withLane(3, Math.log(Math.sqrt(_t4))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, Math.log(Math.sqrt(_t4))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] normalize(double[] dest, int destOffset, double[] src, int srcOffset) {
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        double _t3 = _sv0.mul(_sv0).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t3  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t3)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] pow(double[] dest, int destOffset, double[] src, int srcOffset, double t) {
        double _selfz = src[srcOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _selfw = src[srcOffset + 3];
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t11 = Math.exp(t * Math.log(Math.sqrt(_t4)));
        double _t12 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        double _t19 = t * (_t2 > 0.0 ? _selfz * _t12 : 0.0);
        double _t20 = t * (_t2 > 0.0 ? _selfx * _t12 : 0.0);
        double _t21 = t * (_t2 > 0.0 ? _selfy * _t12 : 0.0);
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = Math.sqrt(_t24);
        var _c0 = (_t24  >  0.0 ? DoubleVector.zero(SIMD_SPECIES).withLane(0, _t20).withLane(1, _t21).withLane(2, _t19).withLane(3, Math.cos(_t25)).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t25) * _t11 * (1.0 / Math.sqrt(_t24))).withLane(3, _t11)) : DoubleVector.broadcast(SIMD_SPECIES, 0.0).withLane(3, Math.cos(_t25) * _t11));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] rotateTowards(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double step) {
        if (SimdSupport.USE_FMA) return rotateTowards_fma(dest, destOffset, src, srcOffset, target, targetOffset, step);
        return rotateTowards_mulAdd(dest, destOffset, src, srcOffset, target, targetOffset, step);
    }

    public static double[] rotateTowards_fma(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double step) {
        double _selfw = src[srcOffset + 3];
        double _targetw = target[targetOffset + 3];
        double _selfz = src[srcOffset + 2];
        double _targetz = target[targetOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _targetx = target[targetOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _targety = target[targetOffset + 1];
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0 ? _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, Math.sin((1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0)) * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))), DoubleVector.broadcast(SIMD_SPECIES, Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0))).mul(_sv2)).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.fma(DoubleVector.broadcast(SIMD_SPECIES, 1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0)), _sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0))));
        double _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0 ? _sv3.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t53)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] rotateTowards_mulAdd(double[] dest, int destOffset, double[] src, int srcOffset, double[] target, int targetOffset, double step) {
        double _selfw = src[srcOffset + 3];
        double _targetw = target[targetOffset + 3];
        double _selfz = src[srcOffset + 2];
        double _targetz = target[targetOffset + 2];
        double _selfx = src[srcOffset + 0];
        double _targetx = target[targetOffset + 0];
        double _selfy = src[srcOffset + 1];
        double _targety = target[targetOffset + 1];
        var _sv0 = DoubleVector.fromArray(SIMD_SPECIES, src, srcOffset);
        var _sv1 = DoubleVector.fromArray(SIMD_SPECIES, target, targetOffset);
        var _sv2 = (-Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))  >  0.0 ? _sv1.neg() : _sv1);
        var _sv3 = (Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin((1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0)) * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))).add(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) * (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0))).mul(_sv2)).mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 / Math.sin(Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))))))) : _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, 1.0 - (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0))).add(_sv2.mul(DoubleVector.broadcast(SIMD_SPECIES, 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))) > 0.0 ? Math.min(1.0, step / (2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)))))))) : 0.0))));
        double _t53 = _sv3.mul(_sv3).reduceLanes(jdk.incubator.vector.VectorOperators.ADD);
        var _c0 = (_t53  >  0.0 ? _sv3.mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t53)))) : DoubleVector.broadcast(SIMD_SPECIES, 0.0));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationAxis(double[] dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        if (SimdSupport.USE_FMA) return makeRotationAxis_fma(dest, destOffset, angle, axisX, axisY, axisZ);
        return makeRotationAxis_mulAdd(dest, destOffset, angle, axisX, axisY, axisZ);
    }

    public static double[] makeRotationAxis_fma(double[] dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.cos(_t0)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationAxis_mulAdd(double[] dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.cos(_t0)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, axisX).withLane(1, axisY).withLane(2, axisZ).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationAxis(double[] dest, int destOffset, double[] axis, int axisOffset, double angle) {
        if (SimdSupport.USE_FMA) return makeRotationAxis_fma(dest, destOffset, axis, axisOffset, angle);
        return makeRotationAxis_mulAdd(dest, destOffset, axis, axisOffset, angle);
    }

    public static double[] makeRotationAxis_fma(double[] dest, int destOffset, double[] axis, int axisOffset, double angle) {
        double _t0 = 0.5 * angle;
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.cos(_t0)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, axis[axisOffset + 0]).withLane(1, axis[axisOffset + 1]).withLane(2, axis[axisOffset + 2]).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationAxis_mulAdd(double[] dest, int destOffset, double[] axis, int axisOffset, double angle) {
        double _t0 = 0.5 * angle;
        var _c0 = DoubleVector.broadcast(SIMD_SPECIES, Math.cos(_t0)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, axis[axisOffset + 0]).withLane(1, axis[axisOffset + 1]).withLane(2, axis[axisOffset + 2]).mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sin(_t0))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationLookAlong(double[] dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (SimdSupport.USE_FMA) return makeRotationLookAlong_fma(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
        return makeRotationLookAlong_mulAdd(dest, destOffset, dirX, dirY, dirZ, upX, upY, upZ);
    }

    public static double[] makeRotationLookAlong_fma(double[] dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? dirZ * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? dirY * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? dirX * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t60)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationLookAlong_mulAdd(double[] dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? dirZ * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? dirY * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? dirX * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t60)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationLookAlong(double[] dest, int destOffset, double[] dir, int dirOffset, double[] up, int upOffset) {
        if (SimdSupport.USE_FMA) return makeRotationLookAlong_fma(dest, destOffset, dir, dirOffset, up, upOffset);
        return makeRotationLookAlong_mulAdd(dest, destOffset, dir, dirOffset, up, upOffset);
    }

    public static double[] makeRotationLookAlong_fma(double[] dest, int destOffset, double[] dir, int dirOffset, double[] up, int upOffset) {
        double _dirz = dir[dirOffset + 2];
        double _dirx = dir[dirOffset + 0];
        double _diry = dir[dirOffset + 1];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? _dirz * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? _diry * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? _dirx * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t60)).fma(UNIT_W, DoubleVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationLookAlong_mulAdd(double[] dest, int destOffset, double[] dir, int dirOffset, double[] up, int upOffset) {
        double _dirz = dir[dirOffset + 2];
        double _dirx = dir[dirOffset + 0];
        double _diry = dir[dirOffset + 1];
        double _upx = up[upOffset + 0];
        double _upy = up[upOffset + 1];
        double _upz = up[upOffset + 2];
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7 = _t2 > 0.0 ? _dirz * _t3 : 0.0;
        double _t8 = _t2 > 0.0 ? _diry * _t3 : 0.0;
        double _t9 = _t2 > 0.0 ? _dirx * _t3 : 0.0;
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31 = _t26 > 0.0 ? _t22 * _t27 : 0.0;
        double _t32 = _t26 > 0.0 ? _t21 * _t27 : 0.0;
        double _t33 = _t26 > 0.0 ? _t23 * _t27 : 0.0;
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t67 = (1.0 / Math.sqrt(_t61));
        var _sv0 = DoubleVector.broadcast(SIMD_SPECIES, 0.5);
        var _c0 = (Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7))  >  0.0 ? _sv0.mul(DoubleVector.broadcast(SIMD_SPECIES, Math.sqrt(_t60)).mul(UNIT_W).add(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t55).withLane(1, _t38).withLane(2, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t60)))))) : (_t31  >  Math.max(_t49, _t7) ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, Math.sqrt(_t61)).withLane(1, _t57 * _t67).withLane(2, _t37 * _t67).withLane(3, _t55 * _t67)) : (_t49  >  _t7 ? _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t57).withLane(2, _t54).withLane(3, _t38).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t62)))).withLane(1, Math.sqrt(_t62))) : _sv0.mul(DoubleVector.zero(SIMD_SPECIES).withLane(0, _t37).withLane(1, _t54).withLane(3, _t58).mul(DoubleVector.broadcast(SIMD_SPECIES, (1.0 / Math.sqrt(_t63)))).withLane(2, Math.sqrt(_t63))))));
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationYXZ(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (SimdSupport.USE_FMA) return makeRotationYXZ_fma(dest, destOffset, angleX, angleY, angleZ);
        return makeRotationYXZ_mulAdd(dest, destOffset, angleX, angleY, angleZ);
    }

    public static double[] makeRotationYXZ_fma(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        var _c0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).fma(DoubleVector.broadcast(SIMD_SPECIES, _t5), DoubleVector.broadcast(SIMD_SPECIES, _t10).withLane(3, _t12).mul(DoubleVector.broadcast(SIMD_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _c0.intoArray(dest, destOffset);
        return dest;
    }

    public static double[] makeRotationYXZ_mulAdd(double[] dest, int destOffset, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t4;
        double _t12 = _t3 * _t6;
        var _c0 = DoubleVector.zero(SIMD_SPECIES).withLane(0, _t9).withLane(1, _t10).withLane(3, _t11).mul(DoubleVector.broadcast(SIMD_SPECIES, _t5)).add(DoubleVector.broadcast(SIMD_SPECIES, _t10).withLane(3, _t12).mul(DoubleVector.broadcast(SIMD_SPECIES, _t8)).withLane(1, -(_t9 * _t8))).withLane(2, _t11 * _t8 - _t12 * _t5);
        _c0.intoArray(dest, destOffset);
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
        if (PREFERRED_LANES >= 4) {
            DoubleVector.fromArray(DoubleVector.SPECIES_256, src, srcOffset).intoArray(dest, destOffset);
        }
        else {
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset).intoArray(dest, destOffset);
            DoubleVector.fromArray(DoubleVector.SPECIES_128, src, srcOffset + 2).intoArray(dest, destOffset + 2);
        }
    }


    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset) {
        copyArrArr_one(dest, destOffset, src, srcOffset);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, double[] src, int srcOffset, int count) {
        copyArrArr(dest, destOffset, src, srcOffset, count * 4);
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr_one(dest, destOffset, _srcArr, _srcOff);
        } else {
            for (int _i = 0; _i < 4; _i++)
                dest[destOffset + _i] = src.get(srcOffset + _i);
        }
        return dest;
    }

    public static double[] copy(double[] dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (src.hasArray()) {
            double[] _srcArr = src.array();
            int _srcOff = src.arrayOffset() + srcOffset;
            copyArrArr(dest, destOffset, _srcArr, _srcOff, count * 4);
        } else {
            for (int _i = 0; _i < count * 4; _i++)
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
            for (int _i = 0; _i < 4; _i++)
                dest.put(destOffset + _i, src[srcOffset + _i]);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, double[] src, int srcOffset, int count) {
        if (dest.hasArray()) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            copyArrArr(_destArr, _destOff, src, srcOffset, count * 4);
        } else {
            for (int _i = 0; _i < count * 4; _i++)
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
                for (int _i = 0; _i < 4; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                double[] _srcArr = src.array();
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

    public static java.nio.DoubleBuffer copy(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int count) {
        if (dest.hasArray()) {
            double[] _destArr = dest.array();
            int _destOff = dest.arrayOffset() + destOffset;
            if (src.hasArray()) {
                double[] _srcArr = src.array();
                int _srcOff = src.arrayOffset() + srcOffset;
                copyArrArr(_destArr, _destOff, _srcArr, _srcOff, count * 4);
            } else {
                for (int _i = 0; _i < count * 4; _i++)
                    _destArr[_destOff + _i] = src.get(srcOffset + _i);
            }
        } else {
            if (src.hasArray()) {
                double[] _srcArr = src.array();
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
