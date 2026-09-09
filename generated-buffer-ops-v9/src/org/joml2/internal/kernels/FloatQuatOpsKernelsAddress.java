package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link FloatQuatOps} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code FloatQuatOps} and its sibling kernel units. Not public API.
 */
public final class FloatQuatOpsKernelsAddress {
    private FloatQuatOpsKernelsAddress() {}

    public static long invert_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t3_inv = 1.0f / _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(_selfx * _t3_inv));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_selfy * _t3_inv));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_selfz * _t3_inv));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw * _t3_inv);
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t21 = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz));
        float _t22 = Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy));
        float _t23 = Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx));
        float _t24 = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t21 * _t28_inv));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t23 * _t28_inv));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t22 * _t28_inv));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _t24 * _t28_inv);
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _t21 = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz));
        float _t22 = Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy));
        float _t23 = Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx));
        float _t24 = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t21 * _t28_inv));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t23 * _t28_inv));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t22 * _t28_inv));
        UnsafeOpsHolder.U.putFloat(dest + 12L, _t24 * _t28_inv);
        return dest;
    }

    public static long add_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, otherX + _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, otherY + _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, otherZ + _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, otherW + _selfw);
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _otherx + _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _othery + _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _otherz + _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _otherw + _selfw);
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, -_selfw);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx - otherX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy - otherY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz - otherZ);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw - otherW);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx - _otherx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy - _othery);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz - _otherz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw - _otherw);
        return dest;
    }

    public static long set_unsafe(long dest, float vX, float vY, float vZ, float vW) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, vY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, vZ);
        UnsafeOpsHolder.U.putFloat(dest + 12L, vW);
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        float _vw = UnsafeOpsHolder.U.getFloat(v + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _vy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _vz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _vw);
        return dest;
    }

    public static long makeFromDualQuat_unsafe(long dest, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, dqRX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, dqRY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, dqRZ);
        UnsafeOpsHolder.U.putFloat(dest + 12L, dqRW);
        return dest;
    }

    public static long makeFromMatrixMat3x3_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 12L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 28L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t2 = Math.max(_m11, _m22);
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
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t1 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t7 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t9 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t15));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t4 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t6 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t4 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t8 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t6 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t8 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long makeFromMatrixMat3x4_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 40L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t2 = Math.max(_m11, _m22);
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
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t1 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t7 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t9 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t15));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t4 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t6 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t4 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t8 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t6 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t8 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long makeFromMatrixMat4x4_unsafe(long dest, long m) {
        float _m00 = UnsafeOpsHolder.U.getFloat(m + 0L);
        float _m10 = UnsafeOpsHolder.U.getFloat(m + 4L);
        float _m20 = UnsafeOpsHolder.U.getFloat(m + 8L);
        float _m01 = UnsafeOpsHolder.U.getFloat(m + 16L);
        float _m11 = UnsafeOpsHolder.U.getFloat(m + 20L);
        float _m21 = UnsafeOpsHolder.U.getFloat(m + 24L);
        float _m02 = UnsafeOpsHolder.U.getFloat(m + 32L);
        float _m12 = UnsafeOpsHolder.U.getFloat(m + 36L);
        float _m22 = UnsafeOpsHolder.U.getFloat(m + 40L);
        float _t0 = _m00 + _m11;
        float _t1 = _m21 - _m12;
        float _t2 = Math.max(_m11, _m22);
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
        float _t18 = (1.0f / (float) Math.sqrt(_t14));
        float _t19 = (1.0f / (float) Math.sqrt(_t16));
        float _t20 = (1.0f / (float) Math.sqrt(_t17));
        float _t21 = (1.0f / (float) Math.sqrt(_t15));
        if (_t10 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t1 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t7 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t9 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t15));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t4 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t6 * _t21);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t4 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t8 * _t19);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t6 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t8 * _t20);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long toDualQuat_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 20L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 24L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        return dest;
    }

    public static long toMatrix_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfz * _selfw;
        float _t2 = _selfy * _selfw;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfx, _selfy, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfx, _selfz, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * Math.fma(_selfx, _selfy, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 2.0f * Math.fma(_selfx, _selfz, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 48L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 52L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 56L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 60L, 1.0f);
        return dest;
    }

    public static long toMatrix3x3_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfz * _selfw;
        float _t2 = _selfy * _selfw;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfx, _selfy, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfx, _selfz, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 2.0f * Math.fma(_selfx, _selfy, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 16L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 20L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(_selfx, _selfz, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 32L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        return dest;
    }

    public static long toMatrix3x4_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfz * _selfw;
        float _t2 = _selfy * _selfw;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfx, _selfy, -_t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfx, _selfz, _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 16L, 2.0f * Math.fma(_selfx, _selfy, _t1));
        UnsafeOpsHolder.U.putFloat(dest + 20L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 24L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 28L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 32L, 2.0f * Math.fma(_selfx, _selfz, -_t2));
        UnsafeOpsHolder.U.putFloat(dest + 36L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 40L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 44L, 0.0f);
        return dest;
    }

    public static long decomposeSwingTwist_unsafe(long swing, long twist, long src, float axisX, float axisY, float axisZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = _selfw * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(swing + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putFloat(swing + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putFloat(swing + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putFloat(swing + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        UnsafeOpsHolder.U.putFloat(twist + 0L, _t12);
        UnsafeOpsHolder.U.putFloat(twist + 4L, _t13);
        UnsafeOpsHolder.U.putFloat(twist + 8L, _t14);
        UnsafeOpsHolder.U.putFloat(twist + 12L, _t11);
        return swing;
    }

    public static long decomposeSwingTwist_unsafe(long swing, long twist, long src, long axis) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = _selfw * _t5;
            _t12 = _axisx * _t7;
            _t13 = _axisy * _t7;
            _t14 = _axisz * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(swing + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putFloat(swing + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putFloat(swing + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putFloat(swing + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        UnsafeOpsHolder.U.putFloat(twist + 0L, _t12);
        UnsafeOpsHolder.U.putFloat(twist + 4L, _t13);
        UnsafeOpsHolder.U.putFloat(twist + 8L, _t14);
        UnsafeOpsHolder.U.putFloat(twist + 12L, _t11);
        return swing;
    }

    public static long getSwing_unsafe(long dest, long src, float axisX, float axisY, float axisZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = _selfw * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static long getSwing_unsafe(long dest, long src, long axis) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t7 = _t2 * _t5;
        float _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-14f) {
            _t11 = _selfw * _t5;
            _t12 = _axisx * _t7;
            _t13 = _axisy * _t7;
            _t14 = _axisz * _t7;
        } else {
            _t11 = 1.0f;
            _t12 = 0.0f;
            _t13 = 0.0f;
            _t14 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static long getTwist_unsafe(long dest, long src, float axisX, float axisY, float axisZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, axisX * _t6);
            UnsafeOpsHolder.U.putFloat(dest + 4L, axisY * _t6);
            UnsafeOpsHolder.U.putFloat(dest + 8L, axisZ * _t6);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw * _t5);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 1.0f);
        }
        return dest;
    }

    public static long getTwist_unsafe(long dest, long src, long axis) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _axisx * _t6);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _axisy * _t6);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _axisz * _t6);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw * _t5);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 1.0f);
        }
        return dest;
    }

    public static long makeIdentity_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 1.0f);
        return dest;
    }

    public static long makeZero_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(t, otherX - _selfx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(t, otherY - _selfy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(t, otherZ - _selfz, _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(t, otherW - _selfw, _selfw));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(t, _otherx - _selfx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(t, _othery - _selfy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(t, _otherz - _selfz, _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(t, _otherw - _selfw, _selfw));
        return dest;
    }

    public static long nlerp_unsafe(long dest, long src, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t4 = Math.fma(alpha, targetW - _selfw, _selfw);
        float _t5 = Math.fma(alpha, targetZ - _selfz, _selfz);
        float _t6 = Math.fma(alpha, targetX - _selfx, _selfx);
        float _t7 = Math.fma(alpha, targetY - _selfy, _selfy);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t6 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t7 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t5 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t4 * _t12);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long nlerp_unsafe(long dest, long src, long target, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _targetx = UnsafeOpsHolder.U.getFloat(target + 0L);
        float _targety = UnsafeOpsHolder.U.getFloat(target + 4L);
        float _targetz = UnsafeOpsHolder.U.getFloat(target + 8L);
        float _targetw = UnsafeOpsHolder.U.getFloat(target + 12L);
        float _t4 = Math.fma(alpha, _targetw - _selfw, _selfw);
        float _t5 = Math.fma(alpha, _targetz - _selfz, _selfz);
        float _t6 = Math.fma(alpha, _targetx - _selfx, _selfx);
        float _t7 = Math.fma(alpha, _targety - _selfy, _selfy);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t6 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t7 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t5 * _t12);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t4 * _t12);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long nlerpShortest_unsafe(long dest, long src, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t8 = -Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        float _t17, _t18, _t19, _t20;
        if (_t8 > 0.0f) {
            _t17 = Math.fma(alpha, -targetW - _selfw, _selfw);
            _t18 = Math.fma(alpha, -targetZ - _selfz, _selfz);
            _t19 = Math.fma(alpha, -targetX - _selfx, _selfx);
            _t20 = Math.fma(alpha, -targetY - _selfy, _selfy);
        } else {
            _t17 = Math.fma(alpha, targetW - _selfw, _selfw);
            _t18 = Math.fma(alpha, targetZ - _selfz, _selfz);
            _t19 = Math.fma(alpha, targetX - _selfx, _selfx);
            _t20 = Math.fma(alpha, targetY - _selfy, _selfy);
        }
        float _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t19 * _t25);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t20 * _t25);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t18 * _t25);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t17 * _t25);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long nlerpShortest_unsafe(long dest, long src, long target, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _targetx = UnsafeOpsHolder.U.getFloat(target + 0L);
        float _targety = UnsafeOpsHolder.U.getFloat(target + 4L);
        float _targetz = UnsafeOpsHolder.U.getFloat(target + 8L);
        float _targetw = UnsafeOpsHolder.U.getFloat(target + 12L);
        float _t8 = -Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        float _t17, _t18, _t19, _t20;
        if (_t8 > 0.0f) {
            _t17 = Math.fma(alpha, -_targetw - _selfw, _selfw);
            _t18 = Math.fma(alpha, -_targetz - _selfz, _selfz);
            _t19 = Math.fma(alpha, -_targetx - _selfx, _selfx);
            _t20 = Math.fma(alpha, -_targety - _selfy, _selfy);
        } else {
            _t17 = Math.fma(alpha, _targetw - _selfw, _selfw);
            _t18 = Math.fma(alpha, _targetz - _selfz, _selfz);
            _t19 = Math.fma(alpha, _targetx - _selfx, _selfx);
            _t20 = Math.fma(alpha, _targety - _selfy, _selfy);
        }
        float _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t19 * _t25);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t20 * _t25);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t18 * _t25);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t17 * _t25);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long slerp_unsafe(long dest, long src, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t13, targetX * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t13, targetY * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t13, targetZ * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t13, targetW * _t11) * _t8_inv);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(alpha, targetX, _selfx * _t0));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(alpha, targetY, _selfy * _t0));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(alpha, targetZ, _selfz * _t0));
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(alpha, targetW, _selfw * _t0));
        }
        return dest;
    }

    public static long slerp_unsafe(long dest, long src, long target, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _targetx = UnsafeOpsHolder.U.getFloat(target + 0L);
        float _targety = UnsafeOpsHolder.U.getFloat(target + 4L);
        float _targetz = UnsafeOpsHolder.U.getFloat(target + 8L);
        float _targetw = UnsafeOpsHolder.U.getFloat(target + 12L);
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 1.0E-6f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t13, _targetx * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t13, _targety * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t13, _targetz * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t13, _targetw * _t11) * _t8_inv);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(alpha, _targetx, _selfx * _t0));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(alpha, _targety, _selfy * _t0));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(alpha, _targetz, _selfz * _t0));
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(alpha, _targetw, _selfw * _t0));
        }
        return dest;
    }

    public static long slerpShortest_unsafe(long dest, long src, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 1.0f - alpha;
        float _t12 = Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        float _t14 = -_t12;
        float _t16 = (float) Math.acos(Math.min(1.0f, Math.abs(_t12)));
        float _t17 = (float) Math.sin(_t16);
        float _t17_inv = 1.0f / _t17;
        float _t19 = (float) Math.sin(alpha * _t16);
        float _t21, _t22, _t23, _t24;
        if (_t14 > 0.0f) {
            _t21 = -targetW;
            _t22 = -targetZ;
            _t23 = -targetX;
            _t24 = -targetY;
        } else {
            _t21 = targetW;
            _t22 = targetZ;
            _t23 = targetX;
            _t24 = targetY;
        }
        float _t25 = (float) Math.sin(_t0 * _t16);
        float _t42, _t43, _t44, _t45;
        if (_t17 > 0.0f) {
            _t42 = Math.fma(_selfw, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(_selfz, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(_selfx, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(_selfy, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, _selfw * _t0);
            _t43 = Math.fma(alpha, _t22, _selfz * _t0);
            _t44 = Math.fma(alpha, _t23, _selfx * _t0);
            _t45 = Math.fma(alpha, _t24, _selfy * _t0);
        }
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        if (_t49 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t50 * _t44);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t50 * _t45);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t50 * _t43);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t50 * _t42);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long slerpShortest_unsafe(long dest, long src, long target, float alpha) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _targetx = UnsafeOpsHolder.U.getFloat(target + 0L);
        float _targety = UnsafeOpsHolder.U.getFloat(target + 4L);
        float _targetz = UnsafeOpsHolder.U.getFloat(target + 8L);
        float _targetw = UnsafeOpsHolder.U.getFloat(target + 12L);
        float _t0 = 1.0f - alpha;
        float _t12 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        float _t14 = -_t12;
        float _t16 = (float) Math.acos(Math.min(1.0f, Math.abs(_t12)));
        float _t17 = (float) Math.sin(_t16);
        float _t17_inv = 1.0f / _t17;
        float _t19 = (float) Math.sin(alpha * _t16);
        float _t21, _t22, _t23, _t24;
        if (_t14 > 0.0f) {
            _t21 = -_targetw;
            _t22 = -_targetz;
            _t23 = -_targetx;
            _t24 = -_targety;
        } else {
            _t21 = _targetw;
            _t22 = _targetz;
            _t23 = _targetx;
            _t24 = _targety;
        }
        float _t25 = (float) Math.sin(_t0 * _t16);
        float _t42, _t43, _t44, _t45;
        if (_t17 > 0.0f) {
            _t42 = Math.fma(_selfw, _t25, _t19 * _t21) * _t17_inv;
            _t43 = Math.fma(_selfz, _t25, _t19 * _t22) * _t17_inv;
            _t44 = Math.fma(_selfx, _t25, _t19 * _t23) * _t17_inv;
            _t45 = Math.fma(_selfy, _t25, _t19 * _t24) * _t17_inv;
        } else {
            _t42 = Math.fma(alpha, _t21, _selfw * _t0);
            _t43 = Math.fma(alpha, _t22, _selfz * _t0);
            _t44 = Math.fma(alpha, _t23, _selfx * _t0);
            _t45 = Math.fma(alpha, _t24, _selfy * _t0);
        }
        float _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        float _t50 = (1.0f / (float) Math.sqrt(_t49));
        if (_t49 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t50 * _t44);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t50 * _t45);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t50 * _t43);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t50 * _t42);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long squad_unsafe(long dest, long src, float control0X, float control0Y, float control0Z, float control0W, float control1X, float control1Y, float control1Z, float control1W, float targetX, float targetY, float targetZ, float targetW, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        float _t35 = (float) Math.sin(_t33);
        float _t35_inv = 1.0f / _t35;
        float _t36 = (float) Math.sin(_t34);
        float _t36_inv = 1.0f / _t36;
        float _t37 = Math.abs(_t35);
        float _t39 = Math.abs(_t36);
        float _t41 = (float) Math.sin(t * _t33);
        float _t42 = (float) Math.sin(t * _t34);
        float _t45 = (float) Math.sin(_t0 * _t33);
        float _t46 = (float) Math.sin(_t0 * _t34);
        float _t71, _t73, _t75, _t77;
        if (_t37 > 1.0E-6f) {
            _t71 = Math.fma(control0W, _t45, control1W * _t41) * _t35_inv;
            _t73 = Math.fma(control0Z, _t45, control1Z * _t41) * _t35_inv;
            _t75 = Math.fma(control0X, _t45, control1X * _t41) * _t35_inv;
            _t77 = Math.fma(control0Y, _t45, control1Y * _t41) * _t35_inv;
        } else {
            _t71 = Math.fma(t, control1W, control0W * _t0);
            _t73 = Math.fma(t, control1Z, control0Z * _t0);
            _t75 = Math.fma(t, control1X, control0X * _t0);
            _t77 = Math.fma(t, control1Y, control0Y * _t0);
        }
        float _t72, _t74, _t76, _t78;
        if (_t39 > 1.0E-6f) {
            _t72 = Math.fma(_selfw, _t46, targetW * _t42) * _t36_inv;
            _t74 = Math.fma(_selfz, _t46, targetZ * _t42) * _t36_inv;
            _t76 = Math.fma(_selfx, _t46, targetX * _t42) * _t36_inv;
            _t78 = Math.fma(_selfy, _t46, targetY * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, targetW, _selfw * _t0);
            _t74 = Math.fma(t, targetZ, _selfz * _t0);
            _t76 = Math.fma(t, targetX, _selfx * _t0);
            _t78 = Math.fma(t, targetY, _selfy * _t0);
        }
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t14, _t76, _t13 * _t75));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t14, _t78, _t13 * _t77));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t14, _t74, _t13 * _t73));
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static long squad_unsafe(long dest, long src, long control0, long control1, long target, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _control0x = UnsafeOpsHolder.U.getFloat(control0 + 0L);
        float _control0y = UnsafeOpsHolder.U.getFloat(control0 + 4L);
        float _control0z = UnsafeOpsHolder.U.getFloat(control0 + 8L);
        float _control0w = UnsafeOpsHolder.U.getFloat(control0 + 12L);
        float _control1x = UnsafeOpsHolder.U.getFloat(control1 + 0L);
        float _control1y = UnsafeOpsHolder.U.getFloat(control1 + 4L);
        float _control1z = UnsafeOpsHolder.U.getFloat(control1 + 8L);
        float _control1w = UnsafeOpsHolder.U.getFloat(control1 + 12L);
        float _targetx = UnsafeOpsHolder.U.getFloat(target + 0L);
        float _targety = UnsafeOpsHolder.U.getFloat(target + 4L);
        float _targetz = UnsafeOpsHolder.U.getFloat(target + 8L);
        float _targetw = UnsafeOpsHolder.U.getFloat(target + 12L);
        float _t0 = 1.0f - t;
        float _t1 = 2.0f * t;
        float _t13 = _t0 * _t1;
        float _t14 = Math.fma(-_t0, _t1, 1.0f);
        float _t33 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_control0w, _control1w, Math.fma(_control0z, _control1z, Math.fma(_control0x, _control1x, _control0y * _control1y))))));
        float _t34 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        float _t35 = (float) Math.sin(_t33);
        float _t35_inv = 1.0f / _t35;
        float _t36 = (float) Math.sin(_t34);
        float _t36_inv = 1.0f / _t36;
        float _t37 = Math.abs(_t35);
        float _t39 = Math.abs(_t36);
        float _t41 = (float) Math.sin(t * _t33);
        float _t42 = (float) Math.sin(t * _t34);
        float _t45 = (float) Math.sin(_t0 * _t33);
        float _t46 = (float) Math.sin(_t0 * _t34);
        float _t71, _t73, _t75, _t77;
        if (_t37 > 1.0E-6f) {
            _t71 = Math.fma(_control0w, _t45, _control1w * _t41) * _t35_inv;
            _t73 = Math.fma(_control0z, _t45, _control1z * _t41) * _t35_inv;
            _t75 = Math.fma(_control0x, _t45, _control1x * _t41) * _t35_inv;
            _t77 = Math.fma(_control0y, _t45, _control1y * _t41) * _t35_inv;
        } else {
            _t71 = Math.fma(t, _control1w, _control0w * _t0);
            _t73 = Math.fma(t, _control1z, _control0z * _t0);
            _t75 = Math.fma(t, _control1x, _control0x * _t0);
            _t77 = Math.fma(t, _control1y, _control0y * _t0);
        }
        float _t72, _t74, _t76, _t78;
        if (_t39 > 1.0E-6f) {
            _t72 = Math.fma(_selfw, _t46, _targetw * _t42) * _t36_inv;
            _t74 = Math.fma(_selfz, _t46, _targetz * _t42) * _t36_inv;
            _t76 = Math.fma(_selfx, _t46, _targetx * _t42) * _t36_inv;
            _t78 = Math.fma(_selfy, _t46, _targety * _t42) * _t36_inv;
        } else {
            _t72 = Math.fma(t, _targetw, _selfw * _t0);
            _t74 = Math.fma(t, _targetz, _selfz * _t0);
            _t76 = Math.fma(t, _targetx, _selfx * _t0);
            _t78 = Math.fma(t, _targety, _selfy * _t0);
        }
        float _t85 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        float _t86 = (float) Math.sin(_t85);
        float _t86_inv = 1.0f / _t86;
        float _t87 = Math.abs(_t86);
        float _t89 = (float) Math.sin(_t13 * _t85);
        float _t91 = (float) Math.sin(_t14 * _t85);
        if (_t87 > 1.0E-6f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t14, _t76, _t13 * _t75));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t14, _t78, _t13 * _t77));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t14, _t74, _t13 * _t73));
            UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static long mul_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherY, _selfz, -(otherZ * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(otherY, _selfw, otherZ * _selfx) + Math.fma(otherW, _selfy, -(otherX * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(otherX, _selfy, otherW * _selfz) + Math.fma(otherZ, _selfw, -(otherY * _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_othery, _selfz, -(_otherz * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_othery, _selfw, _otherz * _selfx) + Math.fma(_otherw, _selfy, -(_otherx * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_otherx, _selfy, _otherw * _selfz) + Math.fma(_otherz, _selfw, -(_othery * _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static float angle_unsafe(long src) {
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, _selfw)));
    }

    public static float angleTo_unsafe(long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy))))));
    }

    public static float angleTo_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy))))));
    }

    public static long axis_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy * _t3);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz * _t3);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long calculateW_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.sqrt(Math.max(0.0f, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0f))))));
        return dest;
    }

    public static long conjugate_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw);
        return dest;
    }

    public static long conjugateBy_unsafe(long dest, long src, float qX, float qY, float qZ, float qW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t1 = -qY;
        float _t21 = Math.fma(qX, _selfy, qW * _selfz) + Math.fma(qZ, _selfw, -(qY * _selfx));
        float _t22 = Math.fma(qY, _selfw, qZ * _selfx) + Math.fma(qW, _selfy, -(qX * _selfz));
        float _t23 = Math.fma(qX, _selfw, qW * _selfx) + Math.fma(qY, _selfz, -(qZ * _selfy));
        float _t24 = Math.fma(-qZ, _selfz, Math.fma(_t1, _selfy, Math.fma(qW, _selfw, -(qX * _selfx))));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24))));
        return dest;
    }

    public static long conjugateBy_unsafe(long dest, long src, long q) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _qx = UnsafeOpsHolder.U.getFloat(q + 0L);
        float _qy = UnsafeOpsHolder.U.getFloat(q + 4L);
        float _qz = UnsafeOpsHolder.U.getFloat(q + 8L);
        float _qw = UnsafeOpsHolder.U.getFloat(q + 12L);
        float _t1 = -_qy;
        float _t21 = Math.fma(_qx, _selfy, _qw * _selfz) + Math.fma(_qz, _selfw, -(_qy * _selfx));
        float _t22 = Math.fma(_qy, _selfw, _qz * _selfx) + Math.fma(_qw, _selfy, -(_qx * _selfz));
        float _t23 = Math.fma(_qx, _selfw, _qw * _selfx) + Math.fma(_qy, _selfz, -(_qz * _selfy));
        float _t24 = Math.fma(-_qz, _selfz, Math.fma(_t1, _selfy, Math.fma(_qw, _selfw, -(_qx * _selfx))));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_qy, _t21, -(_qz * _t22)) + Math.fma(_qw, _t23, -(_qx * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_qz, _t23, -(_qy * _t24)) + Math.fma(_qw, _t22, -(_qx * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_qx, _t22, _qw * _t21) + Math.fma(_t1, _t23, -(_qz * _t24)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_qz, _t21, Math.fma(_qy, _t22, Math.fma(_qx, _t23, _qw * _t24))));
        return dest;
    }

    public static long difference_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t3_inv = 1.0f / _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, (Math.fma(otherX, _selfw, -(otherW * _selfx)) + Math.fma(otherY, _selfz, -(otherZ * _selfy))) * _t3_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, (Math.fma(otherX, _selfy, -(otherW * _selfz)) + Math.fma(otherZ, _selfw, -(otherY * _selfx))) * _t3_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw))) * _t3_inv);
        return dest;
    }

    public static long difference_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t3_inv = 1.0f / _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, (Math.fma(_otherx, _selfw, -(_otherw * _selfx)) + Math.fma(_othery, _selfz, -(_otherz * _selfy))) * _t3_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, (Math.fma(_otherx, _selfy, -(_otherw * _selfz)) + Math.fma(_otherz, _selfw, -(_othery * _selfx))) * _t3_inv);
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw))) * _t3_inv);
        return dest;
    }

    public static float dot_unsafe(long src, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        return Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)));
    }

    public static float dot_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _otherw = UnsafeOpsHolder.U.getFloat(other + 12L);
        return Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)));
    }

    public static long exp_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = (float) Math.exp(_selfw);
        float _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = (float) Math.sqrt(_t3);
        float _t8 = (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx * _t8);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy * _t8);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz * _t8);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t4) * _t0);
        return dest;
    }

    public static long getEulerAnglesXYZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t1 = _selfy * _selfz;
        float _t3 = _selfz * _selfz;
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, _t1), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t3), 1.0f)));
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_t9, _t10));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t3), 1.0f)));
        }
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        return dest;
    }

    public static long getEulerAnglesXZY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfy * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _t1);
        float _t8 = 2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, -_t1), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_t7, _t9));
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f)));
        }
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        return dest;
    }

    public static long getEulerAnglesYXZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t3 = _selfz * _selfz;
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, -(_selfy * _selfz));
        float _t10 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t3), 1.0f)));
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_t8, _t10));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t3), 1.0f)));
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t9))));
        return dest;
    }

    public static long getEulerAnglesYZX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = _selfz * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, -(_selfy * _selfz)), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f)));
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_t8, _t9));
        }
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        return dest;
    }

    public static long getEulerAnglesZXY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t1 = _selfz * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t8 = 2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t1), 1.0f)));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_t8, _t9));
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        return dest;
    }

    public static long getEulerAnglesZYX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = _selfz * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f)));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
            UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_t7, _t9));
        }
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        return dest;
    }

    public static long integrate_unsafe(long dest, long src, float angularVelX, float angularVelY, float angularVelZ, float dt) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * dt;
        float _t1 = angularVelZ * _t0;
        float _t2 = angularVelX * _t0;
        float _t3 = angularVelY * _t0;
        float _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        float _t7 = (float) Math.sqrt(_t6);
        float _t9 = (float) Math.cos(_t7);
        float _t11 = (float) Math.sin(_t7) * (1.0f / (float) Math.sqrt(_t6));
        float _t15, _t16, _t17;
        if (_t6 > 0.0f) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static long integrate_unsafe(long dest, long src, long angularVel, float dt) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _angularVelx = UnsafeOpsHolder.U.getFloat(angularVel + 0L);
        float _angularVely = UnsafeOpsHolder.U.getFloat(angularVel + 4L);
        float _angularVelz = UnsafeOpsHolder.U.getFloat(angularVel + 8L);
        float _t0 = 0.5f * dt;
        float _t1 = _angularVelz * _t0;
        float _t2 = _angularVelx * _t0;
        float _t3 = _angularVely * _t0;
        float _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        float _t7 = (float) Math.sqrt(_t6);
        float _t9 = (float) Math.cos(_t7);
        float _t11 = (float) Math.sin(_t7) * (1.0f / (float) Math.sqrt(_t6));
        float _t15, _t16, _t17;
        if (_t6 > 0.0f) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0f;
            _t16 = 0.0f;
            _t17 = 0.0f;
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static long invNegativeX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t10 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfx, _selfx, _selfw * _selfw)));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t12 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t10 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t9 * _t16));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long invNegativeY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t10 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t9 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t12 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t10 * _t16));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long invNegativeZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t10 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t12 = Math.fma(_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t10 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t9 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t12 * _t16));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long invNormalizedNegativeX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        return dest;
    }

    public static long invNormalizedNegativeY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        return dest;
    }

    public static long invNormalizedNegativeZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0f));
        return dest;
    }

    public static long invNormalizedPositiveX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw));
        return dest;
    }

    public static long invNormalizedPositiveY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        return dest;
    }

    public static long invNormalizedPositiveZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        return dest;
    }

    public static long invPositiveX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t10 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfx, _selfx, _selfw * _selfw)));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t12 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t10 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t9 * _t16);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long invPositiveY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t10 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t9 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t12 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t10 * _t16);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long invPositiveZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t10 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t12 = Math.fma(_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t10 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t9 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t12 * _t16);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static float length_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        return (float) Math.sqrt(Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy))));
    }

    public static float lengthSquared_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        return Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    public static long log_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        float _t8 = (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx * _t8);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy * _t8);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz * _t8);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.log((float) Math.sqrt(_t4)));
        return dest;
    }

    public static long negativeX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t10 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfx, _selfx, _selfw * _selfw)));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t12 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t9 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t10 * _t16));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long negativeY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t10 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t10 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t12 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t9 * _t16));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long negativeZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t10 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t12 = Math.fma(_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -(_t9 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 4L, -(_t10 * _t16));
            UnsafeOpsHolder.U.putFloat(dest + 8L, -(_t12 * _t16));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -0.0f);
        }
        return dest;
    }

    public static long normalize_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx * _t4);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy * _t4);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz * _t4);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _selfw * _t4);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long normalizedNegativeX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        return dest;
    }

    public static long normalizedNegativeY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 8L, -(2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        return dest;
    }

    public static long normalizedNegativeZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, -(2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0f));
        return dest;
    }

    public static long normalizedPositiveX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        return dest;
    }

    public static long normalizedPositiveY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        return dest;
    }

    public static long normalizedPositiveZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        return dest;
    }

    public static long positiveX_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t10 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfx, _selfx, _selfw * _selfw)));
        float _t15 = Math.fma(_t10, _t10, Math.fma(_t12, _t12, _t9 * _t9));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t12 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t9 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t10 * _t16);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long positiveY_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t10 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t12 = Math.fma(-_selfz, _selfz, Math.fma(_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t9, _t9, Math.fma(_t12, _t12, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t10 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t12 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t9 * _t16);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long positiveZ_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t10 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t12 = Math.fma(_selfz, _selfz, Math.fma(-_selfy, _selfy, Math.fma(_selfw, _selfw, -(_selfx * _selfx))));
        float _t15 = Math.fma(_t12, _t12, Math.fma(_t9, _t9, _t10 * _t10));
        float _t16 = (1.0f / (float) Math.sqrt(_t15));
        if (_t15 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t9 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t10 * _t16);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t12 * _t16);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long pow_unsafe(long dest, long src, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        float _t11 = (float) Math.exp(t * (float) Math.log((float) Math.sqrt(_t4)));
        float _t12 = (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        float _t19, _t20, _t21;
        if (_t2 > 0.0f) {
            _t19 = t * _selfz * _t12;
            _t20 = t * _selfx * _t12;
            _t21 = t * _selfy * _t12;
        } else {
            _t19 = t * 0.0f;
            _t20 = t * 0.0f;
            _t21 = t * 0.0f;
        }
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (float) Math.sqrt(_t24);
        float _t29 = (float) Math.sin(_t25) * _t11 * (1.0f / (float) Math.sqrt(_t24));
        if (_t24 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t20 * _t29);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t21 * _t29);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t19 * _t29);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t25) * _t11);
        return dest;
    }

    public static long rotateTowards_unsafe(long dest, long src, float targetX, float targetY, float targetZ, float targetW, float step) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t7 = Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        float _t9 = -_t7;
        float _t11 = (float) Math.acos(Math.min(1.0f, Math.abs(_t7)));
        float _t12 = (float) Math.sin(_t11);
        float _t12_inv = 1.0f / _t12;
        float _t13 = 2.0f * _t11;
        float _t15, _t16, _t17, _t18;
        if (_t9 > 0.0f) {
            _t15 = -targetW;
            _t16 = -targetZ;
            _t17 = -targetX;
            _t18 = -targetY;
        } else {
            _t15 = targetW;
            _t16 = targetZ;
            _t17 = targetX;
            _t18 = targetY;
        }
        float _t20 = _t13 > 0.0f ? Math.min(1.0f, step / _t13) : 0.0f;
        float _t21 = 1.0f - _t20;
        float _t23 = (float) Math.sin(_t11 * _t20);
        float _t25 = (float) Math.sin(_t21 * _t11);
        float _t46, _t47, _t48, _t49;
        if (_t12 > 0.0f) {
            _t46 = Math.fma(_selfw, _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(_selfz, _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(_selfx, _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(_selfy, _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(_selfw, _t21, _t15 * _t20);
            _t47 = Math.fma(_selfz, _t21, _t16 * _t20);
            _t48 = Math.fma(_selfx, _t21, _t17 * _t20);
            _t49 = Math.fma(_selfy, _t21, _t18 * _t20);
        }
        float _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        float _t54 = (1.0f / (float) Math.sqrt(_t53));
        if (_t53 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t54 * _t48);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t54 * _t49);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t54 * _t47);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t54 * _t46);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long rotateTowards_unsafe(long dest, long src, long target, float step) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _targetx = UnsafeOpsHolder.U.getFloat(target + 0L);
        float _targety = UnsafeOpsHolder.U.getFloat(target + 4L);
        float _targetz = UnsafeOpsHolder.U.getFloat(target + 8L);
        float _targetw = UnsafeOpsHolder.U.getFloat(target + 12L);
        float _t7 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        float _t9 = -_t7;
        float _t11 = (float) Math.acos(Math.min(1.0f, Math.abs(_t7)));
        float _t12 = (float) Math.sin(_t11);
        float _t12_inv = 1.0f / _t12;
        float _t13 = 2.0f * _t11;
        float _t15, _t16, _t17, _t18;
        if (_t9 > 0.0f) {
            _t15 = -_targetw;
            _t16 = -_targetz;
            _t17 = -_targetx;
            _t18 = -_targety;
        } else {
            _t15 = _targetw;
            _t16 = _targetz;
            _t17 = _targetx;
            _t18 = _targety;
        }
        float _t20 = _t13 > 0.0f ? Math.min(1.0f, step / _t13) : 0.0f;
        float _t21 = 1.0f - _t20;
        float _t23 = (float) Math.sin(_t11 * _t20);
        float _t25 = (float) Math.sin(_t21 * _t11);
        float _t46, _t47, _t48, _t49;
        if (_t12 > 0.0f) {
            _t46 = Math.fma(_selfw, _t25, _t23 * _t15) * _t12_inv;
            _t47 = Math.fma(_selfz, _t25, _t23 * _t16) * _t12_inv;
            _t48 = Math.fma(_selfx, _t25, _t23 * _t17) * _t12_inv;
            _t49 = Math.fma(_selfy, _t25, _t23 * _t18) * _t12_inv;
        } else {
            _t46 = Math.fma(_selfw, _t21, _t15 * _t20);
            _t47 = Math.fma(_selfz, _t21, _t16 * _t20);
            _t48 = Math.fma(_selfx, _t21, _t17 * _t20);
            _t49 = Math.fma(_selfy, _t21, _t18 * _t20);
        }
        float _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        float _t54 = (1.0f / (float) Math.sqrt(_t53));
        if (_t53 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t54 * _t48);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t54 * _t49);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t54 * _t47);
            UnsafeOpsHolder.U.putFloat(dest + 12L, _t54 * _t46);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        }
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 - _t32;
        float _t38 = _t9 + _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.max(_t49, _t7);
        float _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t65 = (1.0f / (float) Math.sqrt(_t61));
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t63));
        float _t68 = (1.0f / (float) Math.sqrt(_t60));
        float _t108, _t109, _t110, _t111;
        if (_t59 > 0.0f) {
            _t108 = 0.5f * _t57 * _t68;
            _t109 = 0.5f * _t37 * _t68;
            _t110 = 0.5f * (float) Math.sqrt(_t60);
            _t111 = 0.5f * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5f * _t38 * _t65;
                _t109 = 0.5f * _t58 * _t65;
                _t110 = 0.5f * _t56 * _t65;
                _t111 = 0.5f * (float) Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5f * _t54 * _t66;
                    _t109 = 0.5f * (float) Math.sqrt(_t62);
                    _t110 = 0.5f * _t37 * _t66;
                    _t111 = 0.5f * _t58 * _t66;
                } else {
                    _t108 = 0.5f * (float) Math.sqrt(_t63);
                    _t109 = 0.5f * _t54 * _t67;
                    _t110 = 0.5f * _t57 * _t67;
                    _t111 = 0.5f * _t38 * _t67;
                }
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, long dir, long up) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _dirx = UnsafeOpsHolder.U.getFloat(dir + 0L);
        float _diry = UnsafeOpsHolder.U.getFloat(dir + 4L);
        float _dirz = UnsafeOpsHolder.U.getFloat(dir + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 - _t32;
        float _t38 = _t9 + _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.max(_t49, _t7);
        float _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t65 = (1.0f / (float) Math.sqrt(_t61));
        float _t66 = (1.0f / (float) Math.sqrt(_t62));
        float _t67 = (1.0f / (float) Math.sqrt(_t63));
        float _t68 = (1.0f / (float) Math.sqrt(_t60));
        float _t108, _t109, _t110, _t111;
        if (_t59 > 0.0f) {
            _t108 = 0.5f * _t57 * _t68;
            _t109 = 0.5f * _t37 * _t68;
            _t110 = 0.5f * (float) Math.sqrt(_t60);
            _t111 = 0.5f * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5f * _t38 * _t65;
                _t109 = 0.5f * _t58 * _t65;
                _t110 = 0.5f * _t56 * _t65;
                _t111 = 0.5f * (float) Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5f * _t54 * _t66;
                    _t109 = 0.5f * (float) Math.sqrt(_t62);
                    _t110 = 0.5f * _t37 * _t66;
                    _t111 = 0.5f * _t58 * _t66;
                } else {
                    _t108 = 0.5f * (float) Math.sqrt(_t63);
                    _t109 = 0.5f * _t54 * _t67;
                    _t110 = 0.5f * _t57 * _t67;
                    _t111 = 0.5f * _t38 * _t67;
                }
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, axisX * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 4L, axisY * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, axisZ * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, long axis, float angle) {
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _axisx * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _axisy * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _axisz * _t1);
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(upX, _t8, -(upY * _t9));
        float _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        float _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t56 = Math.max(_t49, _t7);
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t64 = (1.0f / (float) Math.sqrt(_t60));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        if (_t59 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t55 * _t64);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t38 * _t64);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t58 * _t64);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t61));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t57 * _t67);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t37 * _t67);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t57 * _t65);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t62));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t54 * _t65);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t38 * _t65);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t37 * _t66);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t54 * _t66);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t63));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, long dir, long up) {
        float _dirx = UnsafeOpsHolder.U.getFloat(dir + 0L);
        float _diry = UnsafeOpsHolder.U.getFloat(dir + 4L);
        float _dirz = UnsafeOpsHolder.U.getFloat(dir + 8L);
        float _upx = UnsafeOpsHolder.U.getFloat(up + 0L);
        float _upy = UnsafeOpsHolder.U.getFloat(up + 4L);
        float _upz = UnsafeOpsHolder.U.getFloat(up + 8L);
        float _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        float _t7, _t8, _t9;
        if (_t2 > 0.0f) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0f;
            _t8 = 0.0f;
            _t9 = 0.0f;
        }
        float _t10 = -_t9;
        float _t11 = -_t8;
        float _t12 = -_t7;
        float _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        float _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        float _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        float _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t27 = (1.0f / (float) Math.sqrt(_t26));
        float _t31, _t32, _t33;
        if (_t26 > 0.0f) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0f;
            _t32 = 0.0f;
            _t33 = 0.0f;
        }
        float _t34 = 1.0f + _t31;
        float _t37 = _t9 + _t32;
        float _t38 = _t9 - _t32;
        float _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        float _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        float _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        float _t56 = Math.max(_t49, _t7);
        float _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        float _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        float _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        float _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        float _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        float _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0f - _t7 - _t31));
        float _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0f + _t7 - _t31));
        float _t64 = (1.0f / (float) Math.sqrt(_t60));
        float _t65 = (1.0f / (float) Math.sqrt(_t62));
        float _t66 = (1.0f / (float) Math.sqrt(_t63));
        float _t67 = (1.0f / (float) Math.sqrt(_t61));
        if (_t59 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t55 * _t64);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t38 * _t64);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t58 * _t64);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (float) Math.sqrt(_t61));
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t57 * _t67);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t37 * _t67);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t57 * _t65);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (float) Math.sqrt(_t62));
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * _t54 * _t65);
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t38 * _t65);
                } else {
                    UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * _t37 * _t66);
                    UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * _t54 * _t66);
                    UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (float) Math.sqrt(_t63));
                    UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static long makeRotationTo_unsafe(long dest, float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float _t4 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t6, _t8, _t9;
        if (_t4 > 0.0f) {
            _t6 = fromDirY;
            _t8 = 0.0f;
            _t9 = -fromDirX;
        } else {
            _t6 = 0.0f;
            _t8 = -fromDirY;
            _t9 = fromDirZ;
        }
        float _t7 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0f)));
        float _t10 = 2.0f * _t7;
        float _t11 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        if (_t7 > 1.0E-6f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11);
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11);
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0f) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, _t15 * _t6);
                UnsafeOpsHolder.U.putFloat(dest + 4L, _t15 * _t9);
                UnsafeOpsHolder.U.putFloat(dest + 8L, _t15 * _t8);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
            } else {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
            }
        }
        return dest;
    }

    public static long makeRotationTo_unsafe(long dest, long fromDir, long toDir) {
        float _fromDirx = UnsafeOpsHolder.U.getFloat(fromDir + 0L);
        float _fromDiry = UnsafeOpsHolder.U.getFloat(fromDir + 4L);
        float _fromDirz = UnsafeOpsHolder.U.getFloat(fromDir + 8L);
        float _toDirx = UnsafeOpsHolder.U.getFloat(toDir + 0L);
        float _toDiry = UnsafeOpsHolder.U.getFloat(toDir + 4L);
        float _toDirz = UnsafeOpsHolder.U.getFloat(toDir + 8L);
        float _t4 = Math.fma(_fromDirx, _fromDirx, _fromDiry * _fromDiry);
        float _t6, _t8, _t9;
        if (_t4 > 0.0f) {
            _t6 = _fromDiry;
            _t8 = 0.0f;
            _t9 = -_fromDirx;
        } else {
            _t6 = 0.0f;
            _t8 = -_fromDiry;
            _t9 = _fromDirz;
        }
        float _t7 = Math.fma(_fromDirx, _toDirx, Math.fma(_fromDiry, _toDiry, Math.fma(_fromDirz, _toDirz, 1.0f)));
        float _t10 = 2.0f * _t7;
        float _t11 = (1.0f / (float) Math.sqrt(_t10));
        float _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        float _t15 = (1.0f / (float) Math.sqrt(_t14));
        if (_t7 > 1.0E-6f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t11);
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t11);
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t11);
            UnsafeOpsHolder.U.putFloat(dest + 12L, 0.5f * (float) Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0f) {
                UnsafeOpsHolder.U.putFloat(dest + 0L, _t15 * _t6);
                UnsafeOpsHolder.U.putFloat(dest + 4L, _t15 * _t9);
                UnsafeOpsHolder.U.putFloat(dest + 8L, _t15 * _t8);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
            } else {
                UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
                UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
                UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
                UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
            }
        }
        return dest;
    }

    public static long makeRotationX_unsafe(long dest, float angle) {
        float _t0 = 0.5f * angle;
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.sin(_t0));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static long makeRotationXYZ_unsafe(long dest, float angleX, float angleY, float angleZ) {
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
        float _t11 = _t3 * _t6;
        float _t12 = _t7 * _t4;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t11, _t5, _t12 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static long makeRotationXZY_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t11, _t8, -(_t12 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t9, _t8, _t10 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static long makeRotationY_unsafe(long dest, float angle) {
        float _t0 = 0.5f * angle;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sin(_t0));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static long makeRotationYXZ_unsafe(long dest, float angleX, float angleY, float angleZ) {
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
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t11, _t8, -(_t12 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static long makeRotationYZX_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t11, _t5, _t12 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        return dest;
    }

    public static long makeRotationZ_unsafe(long dest, float angle) {
        float _t0 = 0.5f * angle;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sin(_t0));
        UnsafeOpsHolder.U.putFloat(dest + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static long makeRotationZXY_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t1);
        float _t7 = (float) Math.cos(_t0);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t6;
        float _t12 = _t7 * _t4;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t11, _t5, _t12 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t9, _t8, _t10 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static long makeRotationZYX_unsafe(long dest, float angleX, float angleY, float angleZ) {
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t11, _t8, _t12 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t12, _t8, -(_t11 * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_t10, _t5, _t9 * _t8));
        return dest;
    }

    public static long preRotateX_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, -(_selfz * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t2, _selfz * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static long preRotateY_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, _selfz * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t1, -(_selfx * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static long preRotateZ_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, -(_selfy * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t2, _selfy * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, float angle, float axisX, float axisY, float axisZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, long axis, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = _axisx * _t2;
        float _t4 = _axisz * _t2;
        float _t5 = _axisy * _t2;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static long rotateTo_unsafe(long dest, long src, float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t10 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        float _t15, _t17, _t18;
        if (_t10 > 0.0f) {
            _t15 = fromDirY;
            _t17 = 0.0f;
            _t18 = -fromDirX;
        } else {
            _t15 = 0.0f;
            _t17 = -fromDirY;
            _t18 = fromDirZ;
        }
        float _t16 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0f)));
        float _t19 = 2.0f * _t16;
        float _t21 = (1.0f / (float) Math.sqrt(_t19));
        float _t27 = _t16 > 1.0E-6f ? 0.5f * (float) Math.sqrt(_t19) : 0.0f;
        float _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t37, _t38, _t39;
        if (_t16 > 1.0E-6f) {
            _t37 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t21;
            _t38 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t21;
            _t39 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t21;
        } else {
            if (_t29 > 0.0f) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0f;
                _t38 = 0.0f;
                _t39 = 0.0f;
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static long rotateTo_unsafe(long dest, long src, long fromDir, long toDir) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _fromDirx = UnsafeOpsHolder.U.getFloat(fromDir + 0L);
        float _fromDiry = UnsafeOpsHolder.U.getFloat(fromDir + 4L);
        float _fromDirz = UnsafeOpsHolder.U.getFloat(fromDir + 8L);
        float _toDirx = UnsafeOpsHolder.U.getFloat(toDir + 0L);
        float _toDiry = UnsafeOpsHolder.U.getFloat(toDir + 4L);
        float _toDirz = UnsafeOpsHolder.U.getFloat(toDir + 8L);
        float _t10 = Math.fma(_fromDirx, _fromDirx, _fromDiry * _fromDiry);
        float _t15, _t17, _t18;
        if (_t10 > 0.0f) {
            _t15 = _fromDiry;
            _t17 = 0.0f;
            _t18 = -_fromDirx;
        } else {
            _t15 = 0.0f;
            _t17 = -_fromDiry;
            _t18 = _fromDirz;
        }
        float _t16 = Math.fma(_fromDirx, _toDirx, Math.fma(_fromDiry, _toDiry, Math.fma(_fromDirz, _toDirz, 1.0f)));
        float _t19 = 2.0f * _t16;
        float _t21 = (1.0f / (float) Math.sqrt(_t19));
        float _t27 = _t16 > 1.0E-6f ? 0.5f * (float) Math.sqrt(_t19) : 0.0f;
        float _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        float _t30 = (1.0f / (float) Math.sqrt(_t29));
        float _t37, _t38, _t39;
        if (_t16 > 1.0E-6f) {
            _t37 = Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t21;
            _t38 = Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t21;
            _t39 = Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t21;
        } else {
            if (_t29 > 0.0f) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0f;
                _t38 = 0.0f;
                _t39 = 0.0f;
            }
        }
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static long rotateX_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, _selfz * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t1, -(_selfy * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static long rotateXYZ_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        float _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        float _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        float _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static long rotateXZY_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        float _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        float _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static long rotateY_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, -(_selfz * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t2, _selfz * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static long rotateYXZ_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleY;
        float _t2 = 0.5f * angleZ;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t3 * _t7;
        float _t12 = _t4 * _t6;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        float _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        float _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t19, _selfw * _t20) + Math.fma(_selfy, _t21, -(_selfz * _t22)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t19, _selfz * _t20) + Math.fma(_selfw, _t22, -(_selfx * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t22, _selfw * _t21) + Math.fma(_selfz, _t19, -(_selfy * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t21, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t20)))));
        return dest;
    }

    public static long rotateYZX_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t7 * _t3;
        float _t12 = _t6 * _t4;
        float _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static long rotateZ_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t1, _selfy * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t1, -(_selfx * _t2)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static long rotateZXY_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angleX;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleY;
        float _t3 = (float) Math.cos(_t0);
        float _t4 = (float) Math.cos(_t1);
        float _t5 = (float) Math.cos(_t2);
        float _t6 = (float) Math.sin(_t0);
        float _t7 = (float) Math.sin(_t1);
        float _t8 = (float) Math.sin(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t6 * _t4;
        float _t12 = _t7 * _t3;
        float _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        float _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        float _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        float _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t21, _selfw * _t22) + Math.fma(_selfy, _t19, -(_selfz * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t21, _selfz * _t22) + Math.fma(_selfw, _t20, -(_selfx * _t19)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t20, _selfw * _t19) + Math.fma(_selfz, _t21, -(_selfy * _t22)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t19, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t22)))));
        return dest;
    }

    public static long rotateZYX_unsafe(long dest, long src, float angleX, float angleY, float angleZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t0 = 0.5f * angleY;
        float _t1 = 0.5f * angleZ;
        float _t2 = 0.5f * angleX;
        float _t3 = (float) Math.sin(_t0);
        float _t4 = (float) Math.sin(_t1);
        float _t5 = (float) Math.sin(_t2);
        float _t6 = (float) Math.cos(_t0);
        float _t7 = (float) Math.cos(_t1);
        float _t8 = (float) Math.cos(_t2);
        float _t9 = _t3 * _t4;
        float _t10 = _t6 * _t7;
        float _t11 = _t4 * _t6;
        float _t12 = _t3 * _t7;
        float _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        float _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        float _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        float _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        UnsafeOpsHolder.U.putFloat(dest + 12L, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static long transform_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, vY, -(_selfy * vX));
        float _t10 = 2.0f * Math.fma(_selfz, vX, -(_selfx * vZ));
        float _t11 = 2.0f * Math.fma(_selfy, vZ, -(_selfz * vY));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, vX))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vY))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, vZ))));
        return dest;
    }

    public static long transform_unsafe(long dest, long src, long v) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        float _t9 = 2.0f * Math.fma(_selfx, _vy, -(_selfy * _vx));
        float _t10 = 2.0f * Math.fma(_selfz, _vx, -(_selfx * _vz));
        float _t11 = 2.0f * Math.fma(_selfy, _vz, -(_selfz * _vy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, _vx))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, _vz))));
        return dest;
    }

    public static long transformInverse_unsafe(long dest, long src, float vX, float vY, float vZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, vZ, -(_selfz * vX));
        float _t10 = 2.0f * Math.fma(_selfy, vX, -(_selfx * vY));
        float _t11 = 2.0f * Math.fma(_selfz, vY, -(_selfy * vZ));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, vX))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, vY))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vZ))));
        return dest;
    }

    public static long transformInverse_unsafe(long dest, long src, long v) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _selfw = UnsafeOpsHolder.U.getFloat(src + 12L);
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        float _t9 = 2.0f * Math.fma(_selfx, _vz, -(_selfz * _vx));
        float _t10 = 2.0f * Math.fma(_selfy, _vx, -(_selfx * _vy));
        float _t11 = 2.0f * Math.fma(_selfz, _vy, -(_selfy * _vz));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, _vx))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, _vy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vz))));
        return dest;
    }

}
