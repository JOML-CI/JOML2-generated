package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float2x2Ops} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float2x2Ops} and its sibling kernel units. Not public API.
 */
public final class Float2x2OpsKernelsAddress {
    private Float2x2OpsKernelsAddress() {}

    public static long getColumn_unsafe(long dest, long src, int col) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _idxSw0;
        float _idxSw1;
        switch (col) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self10; break;
            case 1: _idxSw0 = _self01; _idxSw1 = _self11; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + col);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _idxSw1);
        return dest;
    }

    public static float getRotationAngle_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        return (float) Math.atan2(_self10, _self00);
    }

    public static long getRow_unsafe(long dest, long src, int row) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _idxSw0;
        float _idxSw1;
        switch (row) {
            case 0: _idxSw0 = _self00; _idxSw1 = _self01; break;
            case 1: _idxSw0 = _self10; _idxSw1 = _self11; break;
            default: throw new IndexOutOfBoundsException("Index out of range: " + row);
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, _idxSw0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _idxSw1);
        return dest;
    }

    public static long cofactor_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self00);
        return dest;
    }

    public static float determinant_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        return Math.fma(_self00, _self11, -(_self01 * _self10));
    }

    public static float frobeniusNorm_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        return (float) Math.sqrt(Math.fma(_self11, _self11, Math.fma(_self10, _self10, Math.fma(_self00, _self00, _self01 * _self01))));
    }

    public static long invert_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t2_inv = 1.0f / _t2;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self11 * _t2_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_self10 * _t2_inv));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_self01 * _t2_inv));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self00 * _t2_inv);
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _t4 = Math.fma(_other01, _self10, _other11 * _self11);
        float _t5 = Math.fma(_other00, _self00, _other10 * _self01);
        float _t6 = Math.fma(_other00, _self10, _other10 * _self11);
        float _t7 = Math.fma(_other01, _self00, _other11 * _self01);
        float _t10 = Math.fma(_t5, _t4, -(_t6 * _t7));
        float _t10_inv = 1.0f / _t10;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t4 * _t10_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t6 * _t10_inv));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t7 * _t10_inv));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _t5 * _t10_inv);
        return dest;
    }

    public static long normal_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(_self00, _self11, -(_self01 * _self10));
        float _t2_inv = 1.0f / _t2;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self11 * _t2_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_self01 * _t2_inv));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_self10 * _t2_inv));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self00 * _t2_inv);
        return dest;
    }

    public static float trace_unsafe(long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        return _self00 + _self11;
    }

    public static long transpose_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11);
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _other00 + _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _other10 + _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _other01 + _self01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _other11 + _self11);
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_self01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_self11);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 - _other00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 - _other10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01 - _other01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11 - _other11);
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        float _v00 = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _v10 = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _v01 = UnsafeOpsHolder.U.getFloat(v + 8L);
        float _v11 = UnsafeOpsHolder.U.getFloat(v + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _v00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _v10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _v01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _v11);
        return dest;
    }

    public static long setMat2x3_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _m11);
        return dest;
    }

    public static long setMat3x3_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 12L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 16L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _m00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _m10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _m01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _m11);
        return dest;
    }

    public static long to2x3_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        return dest;
    }

    public static long to3x3_unsafe(long dest, long src) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self01);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _self11);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 1.0f);
        return dest;
    }

    public static long makeIdentity_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 1.0f);
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, float t) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(t, _other00 - _self00, _self00));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(t, _other10 - _self10, _self10));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(t, _other01 - _self01, _self01));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(t, _other11 - _self11, _self11));
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long right) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _right00 = UnsafeOpsHolder.U.getFloat(right + 0L);
        float _right10 = UnsafeOpsHolder.U.getFloat(right + 4L);
        float _right01 = UnsafeOpsHolder.U.getFloat(right + 8L);
        float _right11 = UnsafeOpsHolder.U.getFloat(right + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_right00, _self00, _right10 * _self01));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_right00, _self10, _right10 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_right01, _self00, _right11 * _self01));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_right01, _self10, _right11 * _self11));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long other) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _other00 = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _other10 = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _other01 = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _other11 = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_other00, _self00, _other01 * _self10));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_other10, _self00, _other11 * _self10));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_other00, _self01, _other01 * _self11));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_other10, _self01, _other11 * _self11));
        return dest;
    }

    public static long makeOuterProduct_unsafe(long dest, float colX, float colY, float rowX, float rowY) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, colX * rowX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, colY * rowX);
        UnsafeOpsHolder.U.putFloat(dest + 8L, colX * rowY);
        UnsafeOpsHolder.U.putFloat(dest + 12L, colY * rowY);
        return dest;
    }

    public static long makeOuterProduct_unsafe(long dest, long col, long row) {
        float _colx = UnsafeOpsHolder.U.getFloat(col + 0L);
        float _coly = UnsafeOpsHolder.U.getFloat(col + 4L);
        float _rowx = UnsafeOpsHolder.U.getFloat(row + 0L);
        float _rowy = UnsafeOpsHolder.U.getFloat(row + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _colx * _rowx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _coly * _rowx);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _colx * _rowy);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _coly * _rowy);
        return dest;
    }

    public static long makeRotation_unsafe(long dest, float angle) {
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _t0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _t1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_t1);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _t0);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, float vX, float vY) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, vY);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _vy);
        return dest;
    }

    public static long makeScaling_unsafe(long dest, float s) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, s);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, s);
        return dest;
    }

    public static long preRotate_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, -(_self10 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self00, _t1, _self10 * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self01, _t0, -(_self11 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self01, _t1, _self11 * _t0));
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, float vX, float vY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11 * vY);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11 * _vy);
        return dest;
    }

    public static long preScale_unsafe(long dest, long src, float s) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, s * _self00);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s * _self10);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s * _self01);
        UnsafeOpsHolder.U.putFloat(dest + 12L, s * _self11);
        return dest;
    }

    public static long rotate_unsafe(long dest, long src, float angle) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _t0, _self01 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _t0, _self11 * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_self01, _t0, -(_self00 * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_self11, _t0, -(_self10 * _t1)));
        return dest;
    }

    public static long scale_unsafe(long dest, long src, float vX, float vY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * vX);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01 * vY);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11 * vY);
        return dest;
    }

    public static long scale_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _self00 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _self10 * _vx);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _self01 * _vy);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _self11 * _vy);
        return dest;
    }

    public static long mulVec2_unsafe(long dest, long src, float vX, float vY) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, vX, _self01 * vY));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, vX, _self11 * vY));
        return dest;
    }

    public static long mulVec2_unsafe(long dest, long src, long v) {
        float _self00 = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _self10 = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _self01 = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _self11 = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_self00, _vx, _self01 * _vy));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_self10, _vx, _self11 * _vy));
        return dest;
    }

}
