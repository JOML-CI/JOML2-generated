package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link DoubleQuatOps} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code DoubleQuatOps} and its sibling kernel units. Not public API.
 */
public final class DoubleQuatOpsKernelsAddress {
    private DoubleQuatOpsKernelsAddress() {}

    public static long invert_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(_selfx * _t3_inv));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(_selfy * _t3_inv));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(_selfz * _t3_inv));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw * _t3_inv);
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t21 = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz));
        double _t22 = Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy));
        double _t23 = Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx));
        double _t24 = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t21 * _t28_inv));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t23 * _t28_inv));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t22 * _t28_inv));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _t24 * _t28_inv);
        return dest;
    }

    public static long invertProduct_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        double _t21 = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz));
        double _t22 = Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy));
        double _t23 = Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx));
        double _t24 = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t21 * _t28_inv));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t23 * _t28_inv));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t22 * _t28_inv));
        UnsafeOpsHolder.U.putDouble(dest + 24L, _t24 * _t28_inv);
        return dest;
    }

    public static long add_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, otherX + _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, otherY + _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, otherZ + _selfz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, otherW + _selfw);
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _otherx + _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _othery + _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _otherz + _selfz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _otherw + _selfw);
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_selfz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, -_selfw);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx - otherX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy - otherY);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz - otherZ);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw - otherW);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx - _otherx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy - _othery);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz - _otherz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw - _otherw);
        return dest;
    }

    public static long set_unsafe(long dest, double vX, double vY, double vZ, double vW) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, vX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, vY);
        UnsafeOpsHolder.U.putDouble(dest + 16L, vZ);
        UnsafeOpsHolder.U.putDouble(dest + 24L, vW);
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        double _vw = UnsafeOpsHolder.U.getDouble(v + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _vx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _vy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _vz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _vw);
        return dest;
    }

    public static long makeFromDualQuat_unsafe(long dest, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, dqRX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, dqRY);
        UnsafeOpsHolder.U.putDouble(dest + 16L, dqRZ);
        UnsafeOpsHolder.U.putDouble(dest + 24L, dqRW);
        return dest;
    }

    public static long makeFromMatrixMat3x3_unsafe(long dest, long m) {
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 24L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 56L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 64L);
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
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
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t1 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t7 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t9 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t15));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t4 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t6 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t4 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t8 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t6 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t8 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long makeFromMatrixMat3x4_unsafe(long dest, long m) {
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 64L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 80L);
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
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
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t1 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t7 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t9 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t15));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t4 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t6 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t4 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t8 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t6 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t8 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long makeFromMatrixMat4x4_unsafe(long dest, long m) {
        double _m00 = UnsafeOpsHolder.U.getDouble(m + 0L);
        double _m10 = UnsafeOpsHolder.U.getDouble(m + 8L);
        double _m20 = UnsafeOpsHolder.U.getDouble(m + 16L);
        double _m01 = UnsafeOpsHolder.U.getDouble(m + 32L);
        double _m11 = UnsafeOpsHolder.U.getDouble(m + 40L);
        double _m21 = UnsafeOpsHolder.U.getDouble(m + 48L);
        double _m02 = UnsafeOpsHolder.U.getDouble(m + 64L);
        double _m12 = UnsafeOpsHolder.U.getDouble(m + 72L);
        double _m22 = UnsafeOpsHolder.U.getDouble(m + 80L);
        double _t0 = _m00 + _m11;
        double _t1 = _m21 - _m12;
        double _t2 = Math.max(_m11, _m22);
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
        double _t18 = (1.0 / Math.sqrt(_t14));
        double _t19 = (1.0 / Math.sqrt(_t16));
        double _t20 = (1.0 / Math.sqrt(_t17));
        double _t21 = (1.0 / Math.sqrt(_t15));
        if (_t10 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t1 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t7 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t9 * _t18);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t15));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t4 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t6 * _t21);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t4 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t16));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t8 * _t19);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t7 * _t19);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t6 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t8 * _t20);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t17));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static long toDualQuat_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 40L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 48L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        return dest;
    }

    public static long toMatrix_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfx, _selfy, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfx, _selfz, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 2.0 * Math.fma(_selfx, _selfy, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 2.0 * Math.fma(_selfx, _selfz, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 96L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 104L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 112L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 120L, 1.0);
        return dest;
    }

    public static long toMatrix3x3_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfx, _selfy, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfx, _selfz, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 2.0 * Math.fma(_selfx, _selfy, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 32L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 40L, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 2.0 * Math.fma(_selfx, _selfz, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 64L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        return dest;
    }

    public static long toMatrix3x4_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfx, _selfy, -_t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfx, _selfz, _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 32L, 2.0 * Math.fma(_selfx, _selfy, _t1));
        UnsafeOpsHolder.U.putDouble(dest + 40L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 48L, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 56L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 64L, 2.0 * Math.fma(_selfx, _selfz, -_t2));
        UnsafeOpsHolder.U.putDouble(dest + 72L, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putDouble(dest + 80L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 88L, 0.0);
        return dest;
    }

    public static long decomposeSwingTwist_unsafe(long swing, long twist, long src, double axisX, double axisY, double axisZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        UnsafeOpsHolder.U.putDouble(swing + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putDouble(swing + 8L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putDouble(swing + 16L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putDouble(swing + 24L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        UnsafeOpsHolder.U.putDouble(twist + 0L, _t12);
        UnsafeOpsHolder.U.putDouble(twist + 8L, _t13);
        UnsafeOpsHolder.U.putDouble(twist + 16L, _t14);
        UnsafeOpsHolder.U.putDouble(twist + 24L, _t11);
        return swing;
    }

    public static long decomposeSwingTwist_unsafe(long swing, long twist, long src, long axis) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = _axisx * _t7;
            _t13 = _axisy * _t7;
            _t14 = _axisz * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        UnsafeOpsHolder.U.putDouble(swing + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putDouble(swing + 8L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putDouble(swing + 16L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putDouble(swing + 24L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        UnsafeOpsHolder.U.putDouble(twist + 0L, _t12);
        UnsafeOpsHolder.U.putDouble(twist + 8L, _t13);
        UnsafeOpsHolder.U.putDouble(twist + 16L, _t14);
        UnsafeOpsHolder.U.putDouble(twist + 24L, _t11);
        return swing;
    }

    public static long getSwing_unsafe(long dest, long src, double axisX, double axisY, double axisZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = axisX * _t7;
            _t13 = axisY * _t7;
            _t14 = axisZ * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static long getSwing_unsafe(long dest, long src, long axis) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t7 = _t2 * _t5;
        double _t11, _t12, _t13, _t14;
        if (_t4 > 1.0E-30) {
            _t11 = _selfw * _t5;
            _t12 = _axisx * _t7;
            _t13 = _axisy * _t7;
            _t14 = _axisz * _t7;
        } else {
            _t11 = 1.0;
            _t12 = 0.0;
            _t13 = 0.0;
            _t14 = 0.0;
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static long getTwist_unsafe(long dest, long src, double axisX, double axisY, double axisZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, axisX * _t6);
            UnsafeOpsHolder.U.putDouble(dest + 8L, axisY * _t6);
            UnsafeOpsHolder.U.putDouble(dest + 16L, axisZ * _t6);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw * _t5);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 1.0);
        }
        return dest;
    }

    public static long getTwist_unsafe(long dest, long src, long axis) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _axisx * _t6);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _axisy * _t6);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _axisz * _t6);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw * _t5);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 1.0);
        }
        return dest;
    }

    public static long makeIdentity_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 1.0);
        return dest;
    }

    public static long makeZero_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(t, otherX - _selfx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(t, otherY - _selfy, _selfy));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(t, otherZ - _selfz, _selfz));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(t, otherW - _selfw, _selfw));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(t, _otherx - _selfx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(t, _othery - _selfy, _selfy));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(t, _otherz - _selfz, _selfz));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(t, _otherw - _selfw, _selfw));
        return dest;
    }

    public static long nlerp_unsafe(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t4 = Math.fma(alpha, targetW - _selfw, _selfw);
        double _t5 = Math.fma(alpha, targetZ - _selfz, _selfz);
        double _t6 = Math.fma(alpha, targetX - _selfx, _selfx);
        double _t7 = Math.fma(alpha, targetY - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t6 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t7 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t5 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t4 * _t12);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long nlerp_unsafe(long dest, long src, long target, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _targetx = UnsafeOpsHolder.U.getDouble(target + 0L);
        double _targety = UnsafeOpsHolder.U.getDouble(target + 8L);
        double _targetz = UnsafeOpsHolder.U.getDouble(target + 16L);
        double _targetw = UnsafeOpsHolder.U.getDouble(target + 24L);
        double _t4 = Math.fma(alpha, _targetw - _selfw, _selfw);
        double _t5 = Math.fma(alpha, _targetz - _selfz, _selfz);
        double _t6 = Math.fma(alpha, _targetx - _selfx, _selfx);
        double _t7 = Math.fma(alpha, _targety - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t6 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t7 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t5 * _t12);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t4 * _t12);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long nlerpShortest_unsafe(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t8 = -Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
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
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t19 * _t25);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t20 * _t25);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t18 * _t25);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t17 * _t25);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long nlerpShortest_unsafe(long dest, long src, long target, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _targetx = UnsafeOpsHolder.U.getDouble(target + 0L);
        double _targety = UnsafeOpsHolder.U.getDouble(target + 8L);
        double _targetz = UnsafeOpsHolder.U.getDouble(target + 16L);
        double _targetw = UnsafeOpsHolder.U.getDouble(target + 24L);
        double _t8 = -Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t17, _t18, _t19, _t20;
        if (_t8 > 0.0) {
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
        double _t24 = Math.fma(_t17, _t17, Math.fma(_t18, _t18, Math.fma(_t19, _t19, _t20 * _t20)));
        double _t25 = (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t19 * _t25);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t20 * _t25);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t18 * _t25);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t17 * _t25);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long slerp_unsafe(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t13, targetX * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t13, targetY * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfz, _t13, targetZ * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t13, targetW * _t11) * _t8_inv);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(alpha, targetX, _selfx * _t0));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(alpha, targetY, _selfy * _t0));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(alpha, targetZ, _selfz * _t0));
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(alpha, targetW, _selfw * _t0));
        }
        return dest;
    }

    public static long slerp_unsafe(long dest, long src, long target, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _targetx = UnsafeOpsHolder.U.getDouble(target + 0L);
        double _targety = UnsafeOpsHolder.U.getDouble(target + 8L);
        double _targetz = UnsafeOpsHolder.U.getDouble(target + 16L);
        double _targetw = UnsafeOpsHolder.U.getDouble(target + 24L);
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t13, _targetx * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t13, _targety * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfz, _t13, _targetz * _t11) * _t8_inv);
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t13, _targetw * _t11) * _t8_inv);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(alpha, _targetx, _selfx * _t0));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(alpha, _targety, _selfy * _t0));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(alpha, _targetz, _selfz * _t0));
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(alpha, _targetw, _selfw * _t0));
        }
        return dest;
    }

    public static long slerpShortest_unsafe(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        double _t14 = -_t12;
        double _t16 = Math.acos(Math.min(1.0, Math.abs(_t12)));
        double _t17 = Math.sin(_t16);
        double _t17_inv = 1.0 / _t17;
        double _t19 = Math.sin(alpha * _t16);
        double _t21, _t22, _t23, _t24;
        if (_t14 > 0.0) {
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
        double _t25 = Math.sin(_t0 * _t16);
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
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
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t50 * _t44);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t50 * _t45);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t50 * _t43);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t50 * _t42);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long slerpShortest_unsafe(long dest, long src, long target, double alpha) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _targetx = UnsafeOpsHolder.U.getDouble(target + 0L);
        double _targety = UnsafeOpsHolder.U.getDouble(target + 8L);
        double _targetz = UnsafeOpsHolder.U.getDouble(target + 16L);
        double _targetw = UnsafeOpsHolder.U.getDouble(target + 24L);
        double _t0 = 1.0 - alpha;
        double _t12 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t14 = -_t12;
        double _t16 = Math.acos(Math.min(1.0, Math.abs(_t12)));
        double _t17 = Math.sin(_t16);
        double _t17_inv = 1.0 / _t17;
        double _t19 = Math.sin(alpha * _t16);
        double _t21, _t22, _t23, _t24;
        if (_t14 > 0.0) {
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
        double _t25 = Math.sin(_t0 * _t16);
        double _t42, _t43, _t44, _t45;
        if (_t17 > 0.0) {
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
        double _t49 = Math.fma(_t42, _t42, Math.fma(_t43, _t43, Math.fma(_t44, _t44, _t45 * _t45)));
        double _t50 = (1.0 / Math.sqrt(_t49));
        if (_t49 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t50 * _t44);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t50 * _t45);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t50 * _t43);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t50 * _t42);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long squad_unsafe(long dest, long src, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 1.0 - t;
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(control0W, control1W, Math.fma(control0Z, control1Z, Math.fma(control0X, control1X, control0Y * control1Y))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        double _t35 = Math.sin(_t33);
        double _t35_inv = 1.0 / _t35;
        double _t36 = Math.sin(_t34);
        double _t36_inv = 1.0 / _t36;
        double _t37 = Math.abs(_t35);
        double _t39 = Math.abs(_t36);
        double _t41 = Math.sin(t * _t33);
        double _t42 = Math.sin(t * _t34);
        double _t45 = Math.sin(_t0 * _t33);
        double _t46 = Math.sin(_t0 * _t34);
        double _t71, _t73, _t75, _t77;
        if (_t37 > 0.0) {
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
        double _t72, _t74, _t76, _t78;
        if (_t39 > 0.0) {
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
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        if (_t87 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t14, _t76, _t13 * _t75));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t14, _t78, _t13 * _t77));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t14, _t74, _t13 * _t73));
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static long squad_unsafe(long dest, long src, long control0, long control1, long target, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _control0x = UnsafeOpsHolder.U.getDouble(control0 + 0L);
        double _control0y = UnsafeOpsHolder.U.getDouble(control0 + 8L);
        double _control0z = UnsafeOpsHolder.U.getDouble(control0 + 16L);
        double _control0w = UnsafeOpsHolder.U.getDouble(control0 + 24L);
        double _control1x = UnsafeOpsHolder.U.getDouble(control1 + 0L);
        double _control1y = UnsafeOpsHolder.U.getDouble(control1 + 8L);
        double _control1z = UnsafeOpsHolder.U.getDouble(control1 + 16L);
        double _control1w = UnsafeOpsHolder.U.getDouble(control1 + 24L);
        double _targetx = UnsafeOpsHolder.U.getDouble(target + 0L);
        double _targety = UnsafeOpsHolder.U.getDouble(target + 8L);
        double _targetz = UnsafeOpsHolder.U.getDouble(target + 16L);
        double _targetw = UnsafeOpsHolder.U.getDouble(target + 24L);
        double _t0 = 1.0 - t;
        double _t1 = 2.0 * t;
        double _t13 = _t0 * _t1;
        double _t14 = Math.fma(-_t0, _t1, 1.0);
        double _t33 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_control0w, _control1w, Math.fma(_control0z, _control1z, Math.fma(_control0x, _control1x, _control0y * _control1y))))));
        double _t34 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        double _t35 = Math.sin(_t33);
        double _t35_inv = 1.0 / _t35;
        double _t36 = Math.sin(_t34);
        double _t36_inv = 1.0 / _t36;
        double _t37 = Math.abs(_t35);
        double _t39 = Math.abs(_t36);
        double _t41 = Math.sin(t * _t33);
        double _t42 = Math.sin(t * _t34);
        double _t45 = Math.sin(_t0 * _t33);
        double _t46 = Math.sin(_t0 * _t34);
        double _t71, _t73, _t75, _t77;
        if (_t37 > 0.0) {
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
        double _t72, _t74, _t76, _t78;
        if (_t39 > 0.0) {
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
        double _t85 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_t71, _t72, Math.fma(_t73, _t74, Math.fma(_t75, _t76, _t77 * _t78))))));
        double _t86 = Math.sin(_t85);
        double _t86_inv = 1.0 / _t86;
        double _t87 = Math.abs(_t86);
        double _t89 = Math.sin(_t13 * _t85);
        double _t91 = Math.sin(_t14 * _t85);
        if (_t87 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t14, _t76, _t13 * _t75));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t14, _t78, _t13 * _t77));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t14, _t74, _t13 * _t73));
            UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static long mul_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherY, _selfz, -(otherZ * _selfy)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(otherY, _selfw, otherZ * _selfx) + Math.fma(otherW, _selfy, -(otherX * _selfz)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(otherX, _selfy, otherW * _selfz) + Math.fma(otherZ, _selfw, -(otherY * _selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_othery, _selfz, -(_otherz * _selfy)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_othery, _selfw, _otherz * _selfx) + Math.fma(_otherw, _selfy, -(_otherx * _selfz)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_otherx, _selfy, _otherw * _selfz) + Math.fma(_otherz, _selfw, -(_othery * _selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static double angle_unsafe(long src) {
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        return 2.0 * Math.acos(Math.min(1.0, Math.max(-1.0, _selfw)));
    }

    public static double angleTo_unsafe(long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy))))));
    }

    public static double angleTo_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy))))));
    }

    public static long axis_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz * _t3);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long calculateW_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.sqrt(Math.max(0.0, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0))))));
        return dest;
    }

    public static long conjugate_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, -_selfz);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw);
        return dest;
    }

    public static long conjugateBy_unsafe(long dest, long src, double qX, double qY, double qZ, double qW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t1 = -qY;
        double _t21 = Math.fma(qX, _selfy, qW * _selfz) + Math.fma(qZ, _selfw, -(qY * _selfx));
        double _t22 = Math.fma(qY, _selfw, qZ * _selfx) + Math.fma(qW, _selfy, -(qX * _selfz));
        double _t23 = Math.fma(qX, _selfw, qW * _selfx) + Math.fma(qY, _selfz, -(qZ * _selfy));
        double _t24 = Math.fma(-qZ, _selfz, Math.fma(_t1, _selfy, Math.fma(qW, _selfw, -(qX * _selfx))));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24))));
        return dest;
    }

    public static long conjugateBy_unsafe(long dest, long src, long q) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _qx = UnsafeOpsHolder.U.getDouble(q + 0L);
        double _qy = UnsafeOpsHolder.U.getDouble(q + 8L);
        double _qz = UnsafeOpsHolder.U.getDouble(q + 16L);
        double _qw = UnsafeOpsHolder.U.getDouble(q + 24L);
        double _t1 = -_qy;
        double _t21 = Math.fma(_qx, _selfy, _qw * _selfz) + Math.fma(_qz, _selfw, -(_qy * _selfx));
        double _t22 = Math.fma(_qy, _selfw, _qz * _selfx) + Math.fma(_qw, _selfy, -(_qx * _selfz));
        double _t23 = Math.fma(_qx, _selfw, _qw * _selfx) + Math.fma(_qy, _selfz, -(_qz * _selfy));
        double _t24 = Math.fma(-_qz, _selfz, Math.fma(_t1, _selfy, Math.fma(_qw, _selfw, -(_qx * _selfx))));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_qy, _t21, -(_qz * _t22)) + Math.fma(_qw, _t23, -(_qx * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_qz, _t23, -(_qy * _t24)) + Math.fma(_qw, _t22, -(_qx * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_qx, _t22, _qw * _t21) + Math.fma(_t1, _t23, -(_qz * _t24)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_qz, _t21, Math.fma(_qy, _t22, Math.fma(_qx, _t23, _qw * _t24))));
        return dest;
    }

    public static long difference_unsafe(long dest, long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, (Math.fma(otherX, _selfw, -(otherW * _selfx)) + Math.fma(otherY, _selfz, -(otherZ * _selfy))) * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 16L, (Math.fma(otherX, _selfy, -(otherW * _selfz)) + Math.fma(otherZ, _selfw, -(otherY * _selfx))) * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw))) * _t3_inv);
        return dest;
    }

    public static long difference_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, (Math.fma(_otherx, _selfw, -(_otherw * _selfx)) + Math.fma(_othery, _selfz, -(_otherz * _selfy))) * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 16L, (Math.fma(_otherx, _selfy, -(_otherw * _selfz)) + Math.fma(_otherz, _selfw, -(_othery * _selfx))) * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw))) * _t3_inv);
        return dest;
    }

    public static double dot_unsafe(long src, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        return Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)));
    }

    public static double dot_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _otherz = UnsafeOpsHolder.U.getDouble(other + 16L);
        double _otherw = UnsafeOpsHolder.U.getDouble(other + 24L);
        return Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)));
    }

    public static long exp_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = Math.exp(_selfw);
        double _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.sqrt(_t3);
        double _t8 = Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _t8);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _t8);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz * _t8);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t4) * _t0);
        return dest;
    }

    public static long getEulerAnglesXYZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t1 = _selfy * _selfz;
        double _t3 = _selfz * _selfz;
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t9 = 2.0 * Math.fma(_selfx, _selfw, -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(2.0 * Math.fma(_selfx, _selfw, _t1), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t3), 1.0)));
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_t9, _t10));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t3), 1.0)));
        }
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        return dest;
    }

    public static long getEulerAnglesXZY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfy * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _t1);
        double _t8 = 2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(2.0 * Math.fma(_selfx, _selfw, -_t1), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_t7, _t9));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0)));
        }
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        return dest;
    }

    public static long getEulerAnglesYXZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t3 = _selfz * _selfz;
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t9 = 2.0 * Math.fma(_selfx, _selfw, -(_selfy * _selfz));
        double _t10 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t3), 1.0)));
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_t8, _t10));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t3), 1.0)));
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.asin(Math.min(1.0, Math.max(-1.0, _t9))));
        return dest;
    }

    public static long getEulerAnglesYZX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(2.0 * Math.fma(_selfx, _selfw, -(_selfy * _selfz)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0)));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_t8, _t9));
        }
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.asin(Math.min(1.0, Math.max(-1.0, _t7))));
        return dest;
    }

    public static long getEulerAnglesZXY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t1 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t1), 1.0)));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(_t8, _t9));
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.asin(Math.min(1.0, Math.max(-1.0, _t7))));
        return dest;
    }

    public static long getEulerAnglesZYX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0)));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.atan2(_t7, _t9));
        }
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        return dest;
    }

    public static long integrate_unsafe(long dest, long src, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * dt;
        double _t1 = angularVelZ * _t0;
        double _t2 = angularVelX * _t0;
        double _t3 = angularVelY * _t0;
        double _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        double _t7 = Math.sqrt(_t6);
        double _t9 = Math.cos(_t7);
        double _t11 = Math.sin(_t7) * (1.0 / Math.sqrt(_t6));
        double _t15, _t16, _t17;
        if (_t6 > 0.0) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static long integrate_unsafe(long dest, long src, long angularVel, double dt) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _angularVelx = UnsafeOpsHolder.U.getDouble(angularVel + 0L);
        double _angularVely = UnsafeOpsHolder.U.getDouble(angularVel + 8L);
        double _angularVelz = UnsafeOpsHolder.U.getDouble(angularVel + 16L);
        double _t0 = 0.5 * dt;
        double _t1 = _angularVelz * _t0;
        double _t2 = _angularVelx * _t0;
        double _t3 = _angularVely * _t0;
        double _t6 = Math.fma(_t1, _t1, Math.fma(_t2, _t2, _t3 * _t3));
        double _t7 = Math.sqrt(_t6);
        double _t9 = Math.cos(_t7);
        double _t11 = Math.sin(_t7) * (1.0 / Math.sqrt(_t6));
        double _t15, _t16, _t17;
        if (_t6 > 0.0) {
            _t15 = _t2 * _t11;
            _t16 = _t3 * _t11;
            _t17 = _t1 * _t11;
        } else {
            _t15 = 0.0;
            _t16 = 0.0;
            _t17 = 0.0;
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static long invNegativeX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t9 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t8 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t7 * _t13));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long invNegativeY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t7 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t9 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t8 * _t13));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long invNegativeZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t8 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t7 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t9 * _t13));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long invNormalizedNegativeX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        return dest;
    }

    public static long invNormalizedNegativeY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        return dest;
    }

    public static long invNormalizedNegativeZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0));
        return dest;
    }

    public static long invNormalizedPositiveX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw));
        return dest;
    }

    public static long invNormalizedPositiveY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        return dest;
    }

    public static long invNormalizedPositiveZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        return dest;
    }

    public static long invPositiveX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t9 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t8 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t7 * _t13);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long invPositiveY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t7 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t9 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t8 * _t13);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long invPositiveZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t8 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t7 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t9 * _t13);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static double length_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        return Math.sqrt(Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy))));
    }

    public static double lengthSquared_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        return Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    public static long log_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t8 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _t8);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _t8);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz * _t8);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.log(Math.sqrt(_t4)));
        return dest;
    }

    public static long negativeX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t9 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t7 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t8 * _t13));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long negativeY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t8 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t9 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t7 * _t13));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long negativeZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -(_t7 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 8L, -(_t8 * _t13));
            UnsafeOpsHolder.U.putDouble(dest + 16L, -(_t9 * _t13));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, -0.0);
        }
        return dest;
    }

    public static long normalize_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _t4);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _t4);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _selfz * _t4);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _selfw * _t4);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long normalizedNegativeX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        return dest;
    }

    public static long normalizedNegativeY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0));
        UnsafeOpsHolder.U.putDouble(dest + 16L, -(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        return dest;
    }

    public static long normalizedNegativeZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, -(2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0));
        return dest;
    }

    public static long normalizedPositiveX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        return dest;
    }

    public static long normalizedPositiveY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        return dest;
    }

    public static long normalizedPositiveZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        return dest;
    }

    public static long positiveX_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t9 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t7 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t8 * _t13);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long positiveY_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t8 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t9 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t7 * _t13);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long positiveZ_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t7 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t8 * _t13);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t9 * _t13);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        return dest;
    }

    public static long pow_unsafe(long dest, long src, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t11 = Math.exp(t * Math.log(Math.sqrt(_t4)));
        double _t12 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        double _t19, _t20, _t21;
        if (_t2 > 0.0) {
            _t19 = t * _selfz * _t12;
            _t20 = t * _selfx * _t12;
            _t21 = t * _selfy * _t12;
        } else {
            _t19 = t * 0.0;
            _t20 = t * 0.0;
            _t21 = t * 0.0;
        }
        double _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        double _t25 = Math.sqrt(_t24);
        double _t29 = Math.sin(_t25) * _t11 * (1.0 / Math.sqrt(_t24));
        if (_t24 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t20 * _t29);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t21 * _t29);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t19 * _t29);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        }
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t25) * _t11);
        return dest;
    }

    public static long rotateTowards_unsafe(long dest, long src, double targetX, double targetY, double targetZ, double targetW, double step) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t7 = Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY)));
        double _t9 = -_t7;
        double _t11 = Math.acos(Math.min(1.0, Math.abs(_t7)));
        double _t12 = Math.sin(_t11);
        double _t12_inv = 1.0 / _t12;
        double _t13 = 2.0 * _t11;
        double _t15, _t16, _t17, _t18;
        if (_t9 > 0.0) {
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
        double _t20 = _t13 > 0.0 ? Math.min(1.0, step / _t13) : 0.0;
        double _t21 = 1.0 - _t20;
        double _t23 = Math.sin(_t11 * _t20);
        double _t25 = Math.sin(_t21 * _t11);
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
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
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t54 * _t48);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t54 * _t49);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t54 * _t47);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t54 * _t46);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long rotateTowards_unsafe(long dest, long src, long target, double step) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _targetx = UnsafeOpsHolder.U.getDouble(target + 0L);
        double _targety = UnsafeOpsHolder.U.getDouble(target + 8L);
        double _targetz = UnsafeOpsHolder.U.getDouble(target + 16L);
        double _targetw = UnsafeOpsHolder.U.getDouble(target + 24L);
        double _t7 = Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety)));
        double _t9 = -_t7;
        double _t11 = Math.acos(Math.min(1.0, Math.abs(_t7)));
        double _t12 = Math.sin(_t11);
        double _t12_inv = 1.0 / _t12;
        double _t13 = 2.0 * _t11;
        double _t15, _t16, _t17, _t18;
        if (_t9 > 0.0) {
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
        double _t20 = _t13 > 0.0 ? Math.min(1.0, step / _t13) : 0.0;
        double _t21 = 1.0 - _t20;
        double _t23 = Math.sin(_t11 * _t20);
        double _t25 = Math.sin(_t21 * _t11);
        double _t46, _t47, _t48, _t49;
        if (_t12 > 0.0) {
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
        double _t53 = Math.fma(_t46, _t46, Math.fma(_t47, _t47, Math.fma(_t48, _t48, _t49 * _t49)));
        double _t54 = (1.0 / Math.sqrt(_t53));
        if (_t53 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _t54 * _t48);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _t54 * _t49);
            UnsafeOpsHolder.U.putDouble(dest + 16L, _t54 * _t47);
            UnsafeOpsHolder.U.putDouble(dest + 24L, _t54 * _t46);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
        }
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static long lookAlong_unsafe(long dest, long src, long dir, long up) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _dirx = UnsafeOpsHolder.U.getDouble(dir + 0L);
        double _diry = UnsafeOpsHolder.U.getDouble(dir + 8L);
        double _dirz = UnsafeOpsHolder.U.getDouble(dir + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 - _t32;
        double _t38 = _t9 + _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.max(_t49, _t7);
        double _t56 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t57 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t58 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t65 = (1.0 / Math.sqrt(_t61));
        double _t66 = (1.0 / Math.sqrt(_t62));
        double _t67 = (1.0 / Math.sqrt(_t63));
        double _t68 = (1.0 / Math.sqrt(_t60));
        double _t108, _t109, _t110, _t111;
        if (_t59 > 0.0) {
            _t108 = 0.5 * _t57 * _t68;
            _t109 = 0.5 * _t37 * _t68;
            _t110 = 0.5 * Math.sqrt(_t60);
            _t111 = 0.5 * _t56 * _t68;
        } else {
            if (_t31 > _t55) {
                _t108 = 0.5 * _t38 * _t65;
                _t109 = 0.5 * _t58 * _t65;
                _t110 = 0.5 * _t56 * _t65;
                _t111 = 0.5 * Math.sqrt(_t61);
            } else {
                if (_t49 > _t7) {
                    _t108 = 0.5 * _t54 * _t66;
                    _t109 = 0.5 * Math.sqrt(_t62);
                    _t110 = 0.5 * _t37 * _t66;
                    _t111 = 0.5 * _t58 * _t66;
                } else {
                    _t108 = 0.5 * Math.sqrt(_t63);
                    _t109 = 0.5 * _t54 * _t67;
                    _t110 = 0.5 * _t57 * _t67;
                    _t111 = 0.5 * _t38 * _t67;
                }
            }
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, axisX * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 8L, axisY * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 16L, axisZ * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t0));
        return dest;
    }

    public static long makeRotationAxis_unsafe(long dest, long axis, double angle) {
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _axisx * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _axisy * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _axisz * _t1);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t0));
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _t2 = Math.fma(dirZ, dirZ, Math.fma(dirX, dirX, dirY * dirY));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = dirZ * _t3;
            _t8 = dirY * _t3;
            _t9 = dirX * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(upX, _t8, -(upY * _t9));
        double _t22 = Math.fma(upY, _t7, -(upZ * _t8));
        double _t23 = Math.fma(upZ, _t9, -(upX * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t55 * _t64);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t38 * _t64);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t58 * _t64);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t61));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t57 * _t67);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t37 * _t67);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t57 * _t65);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t62));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t54 * _t65);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t38 * _t65);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t37 * _t66);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t54 * _t66);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t63));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static long makeRotationLookAlong_unsafe(long dest, long dir, long up) {
        double _dirx = UnsafeOpsHolder.U.getDouble(dir + 0L);
        double _diry = UnsafeOpsHolder.U.getDouble(dir + 8L);
        double _dirz = UnsafeOpsHolder.U.getDouble(dir + 16L);
        double _upx = UnsafeOpsHolder.U.getDouble(up + 0L);
        double _upy = UnsafeOpsHolder.U.getDouble(up + 8L);
        double _upz = UnsafeOpsHolder.U.getDouble(up + 16L);
        double _t2 = Math.fma(_dirz, _dirz, Math.fma(_dirx, _dirx, _diry * _diry));
        double _t3 = (1.0 / Math.sqrt(_t2));
        double _t7, _t8, _t9;
        if (_t2 > 0.0) {
            _t7 = _dirz * _t3;
            _t8 = _diry * _t3;
            _t9 = _dirx * _t3;
        } else {
            _t7 = 0.0;
            _t8 = 0.0;
            _t9 = 0.0;
        }
        double _t10 = -_t9;
        double _t11 = -_t8;
        double _t12 = -_t7;
        double _t21 = Math.fma(_upx, _t8, -(_upy * _t9));
        double _t22 = Math.fma(_upy, _t7, -(_upz * _t8));
        double _t23 = Math.fma(_upz, _t9, -(_upx * _t7));
        double _t26 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        double _t27 = (1.0 / Math.sqrt(_t26));
        double _t31, _t32, _t33;
        if (_t26 > 0.0) {
            _t31 = _t22 * _t27;
            _t32 = _t21 * _t27;
            _t33 = _t23 * _t27;
        } else {
            _t31 = 0.0;
            _t32 = 0.0;
            _t33 = 0.0;
        }
        double _t34 = 1.0 + _t31;
        double _t37 = _t9 + _t32;
        double _t38 = _t9 - _t32;
        double _t49 = Math.fma(_t7, _t31, -(_t9 * _t32));
        double _t54 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t8));
        double _t55 = Math.fma(_t9, _t33, Math.fma(_t11, _t31, _t11));
        double _t56 = Math.max(_t49, _t7);
        double _t57 = Math.fma(_t8, _t32, Math.fma(_t12, _t33, _t33));
        double _t58 = Math.fma(_t11, _t32, Math.fma(_t7, _t33, _t33));
        double _t59 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t31 + _t7));
        double _t60 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, _t34 + _t7));
        double _t61 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, _t34 - _t7));
        double _t62 = Math.fma(_t7, _t31, Math.fma(_t10, _t32, 1.0 - _t7 - _t31));
        double _t63 = Math.fma(_t12, _t31, Math.fma(_t9, _t32, 1.0 + _t7 - _t31));
        double _t64 = (1.0 / Math.sqrt(_t60));
        double _t65 = (1.0 / Math.sqrt(_t62));
        double _t66 = (1.0 / Math.sqrt(_t63));
        double _t67 = (1.0 / Math.sqrt(_t61));
        if (_t59 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t55 * _t64);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t38 * _t64);
            UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t58 * _t64);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.sqrt(_t61));
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t57 * _t67);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t37 * _t67);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t57 * _t65);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.sqrt(_t62));
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * _t54 * _t65);
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t38 * _t65);
                } else {
                    UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * _t37 * _t66);
                    UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * _t54 * _t66);
                    UnsafeOpsHolder.U.putDouble(dest + 16L, 0.5 * Math.sqrt(_t63));
                    UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static long makeRotationTo_unsafe(long dest, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double _t4 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t6, _t8, _t9;
        if (_t4 > 0.0) {
            _t6 = fromDirY;
            _t8 = 0.0;
            _t9 = -fromDirX;
        } else {
            _t6 = 0.0;
            _t8 = -fromDirY;
            _t9 = fromDirZ;
        }
        double _t7 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0)));
        double _t10 = 2.0 * _t7;
        double _t11 = (1.0 / Math.sqrt(_t10));
        double _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        double _t15 = (1.0 / Math.sqrt(_t14));
        if (_t7 > 1.0E-6) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, _t15 * _t6);
                UnsafeOpsHolder.U.putDouble(dest + 8L, _t15 * _t9);
                UnsafeOpsHolder.U.putDouble(dest + 16L, _t15 * _t8);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
            } else {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
            }
        }
        return dest;
    }

    public static long makeRotationTo_unsafe(long dest, long fromDir, long toDir) {
        double _fromDirx = UnsafeOpsHolder.U.getDouble(fromDir + 0L);
        double _fromDiry = UnsafeOpsHolder.U.getDouble(fromDir + 8L);
        double _fromDirz = UnsafeOpsHolder.U.getDouble(fromDir + 16L);
        double _toDirx = UnsafeOpsHolder.U.getDouble(toDir + 0L);
        double _toDiry = UnsafeOpsHolder.U.getDouble(toDir + 8L);
        double _toDirz = UnsafeOpsHolder.U.getDouble(toDir + 16L);
        double _t4 = Math.fma(_fromDirx, _fromDirx, _fromDiry * _fromDiry);
        double _t6, _t8, _t9;
        if (_t4 > 0.0) {
            _t6 = _fromDiry;
            _t8 = 0.0;
            _t9 = -_fromDirx;
        } else {
            _t6 = 0.0;
            _t8 = -_fromDiry;
            _t9 = _fromDirz;
        }
        double _t7 = Math.fma(_fromDirx, _toDirx, Math.fma(_fromDiry, _toDiry, Math.fma(_fromDirz, _toDirz, 1.0)));
        double _t10 = 2.0 * _t7;
        double _t11 = (1.0 / Math.sqrt(_t10));
        double _t14 = Math.fma(_t8, _t8, Math.fma(_t6, _t6, _t9 * _t9));
        double _t15 = (1.0 / Math.sqrt(_t14));
        if (_t7 > 1.0E-6) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t11);
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t11);
            UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t11);
            UnsafeOpsHolder.U.putDouble(dest + 24L, 0.5 * Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0) {
                UnsafeOpsHolder.U.putDouble(dest + 0L, _t15 * _t6);
                UnsafeOpsHolder.U.putDouble(dest + 8L, _t15 * _t9);
                UnsafeOpsHolder.U.putDouble(dest + 16L, _t15 * _t8);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
            } else {
                UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
                UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
                UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
                UnsafeOpsHolder.U.putDouble(dest + 24L, 0.0);
            }
        }
        return dest;
    }

    public static long makeRotationX_unsafe(long dest, double angle) {
        double _t0 = 0.5 * angle;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.sin(_t0));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t0));
        return dest;
    }

    public static long makeRotationXYZ_unsafe(long dest, double angleX, double angleY, double angleZ) {
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
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t11, _t5, _t12 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static long makeRotationXZY_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t11, _t8, -(_t12 * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t9, _t8, _t10 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static long makeRotationY_unsafe(long dest, double angle) {
        double _t0 = 0.5 * angle;
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.sin(_t0));
        UnsafeOpsHolder.U.putDouble(dest + 16L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t0));
        return dest;
    }

    public static long makeRotationYXZ_unsafe(long dest, double angleX, double angleY, double angleZ) {
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
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t11, _t8, -(_t12 * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static long makeRotationYZX_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t11, _t5, _t12 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        return dest;
    }

    public static long makeRotationZ_unsafe(long dest, double angle) {
        double _t0 = 0.5 * angle;
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.sin(_t0));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.cos(_t0));
        return dest;
    }

    public static long makeRotationZXY_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t1);
        double _t7 = Math.cos(_t0);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t6;
        double _t12 = _t7 * _t4;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t11, _t5, _t12 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t9, _t8, _t10 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static long makeRotationZYX_unsafe(long dest, double angleX, double angleY, double angleZ) {
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_t11, _t8, _t12 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_t12, _t8, -(_t11 * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_t10, _t5, _t9 * _t8));
        return dest;
    }

    public static long preRotateX_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, -(_selfz * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t2, _selfz * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static long preRotateY_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, _selfz * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfz, _t1, -(_selfx * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static long preRotateZ_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, -(_selfy * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t2, _selfy * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfz, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, double angle, double axisX, double axisY, double axisZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, long axis, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _axisx = UnsafeOpsHolder.U.getDouble(axis + 0L);
        double _axisy = UnsafeOpsHolder.U.getDouble(axis + 8L);
        double _axisz = UnsafeOpsHolder.U.getDouble(axis + 16L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = _axisx * _t2;
        double _t4 = _axisz * _t2;
        double _t5 = _axisy * _t2;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static long rotateTo_unsafe(long dest, long src, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t10 = Math.fma(fromDirX, fromDirX, fromDirY * fromDirY);
        double _t15, _t17, _t18;
        if (_t10 > 0.0) {
            _t15 = fromDirY;
            _t17 = 0.0;
            _t18 = -fromDirX;
        } else {
            _t15 = 0.0;
            _t17 = -fromDirY;
            _t18 = fromDirZ;
        }
        double _t16 = Math.fma(fromDirX, toDirX, Math.fma(fromDirY, toDirY, Math.fma(fromDirZ, toDirZ, 1.0)));
        double _t19 = 2.0 * _t16;
        double _t21 = (1.0 / Math.sqrt(_t19));
        double _t27 = _t16 > 1.0E-6 ? 0.5 * Math.sqrt(_t19) : 0.0;
        double _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t37, _t38, _t39;
        if (_t16 > 1.0E-6) {
            _t37 = Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t21;
            _t38 = Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t21;
            _t39 = Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t21;
        } else {
            if (_t29 > 0.0) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0;
                _t38 = 0.0;
                _t39 = 0.0;
            }
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static long rotateTo_unsafe(long dest, long src, long fromDir, long toDir) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _fromDirx = UnsafeOpsHolder.U.getDouble(fromDir + 0L);
        double _fromDiry = UnsafeOpsHolder.U.getDouble(fromDir + 8L);
        double _fromDirz = UnsafeOpsHolder.U.getDouble(fromDir + 16L);
        double _toDirx = UnsafeOpsHolder.U.getDouble(toDir + 0L);
        double _toDiry = UnsafeOpsHolder.U.getDouble(toDir + 8L);
        double _toDirz = UnsafeOpsHolder.U.getDouble(toDir + 16L);
        double _t10 = Math.fma(_fromDirx, _fromDirx, _fromDiry * _fromDiry);
        double _t15, _t17, _t18;
        if (_t10 > 0.0) {
            _t15 = _fromDiry;
            _t17 = 0.0;
            _t18 = -_fromDirx;
        } else {
            _t15 = 0.0;
            _t17 = -_fromDiry;
            _t18 = _fromDirz;
        }
        double _t16 = Math.fma(_fromDirx, _toDirx, Math.fma(_fromDiry, _toDiry, Math.fma(_fromDirz, _toDirz, 1.0)));
        double _t19 = 2.0 * _t16;
        double _t21 = (1.0 / Math.sqrt(_t19));
        double _t27 = _t16 > 1.0E-6 ? 0.5 * Math.sqrt(_t19) : 0.0;
        double _t29 = Math.fma(_t17, _t17, Math.fma(_t15, _t15, _t18 * _t18));
        double _t30 = (1.0 / Math.sqrt(_t29));
        double _t37, _t38, _t39;
        if (_t16 > 1.0E-6) {
            _t37 = Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t21;
            _t38 = Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t21;
            _t39 = Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t21;
        } else {
            if (_t29 > 0.0) {
                _t37 = _t30 * _t15;
                _t38 = _t30 * _t17;
                _t39 = _t30 * _t18;
            } else {
                _t37 = 0.0;
                _t38 = 0.0;
                _t39 = 0.0;
            }
        }
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static long rotateX_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, _selfz * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfz, _t1, -(_selfy * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static long rotateXYZ_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t19 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t12, _t5, -(_t11 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static long rotateXZY_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t5, _t12 * _t8);
        double _t21 = Math.fma(_t11, _t8, -(_t12 * _t5));
        double _t22 = Math.fma(_t10, _t5, -(_t9 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static long rotateY_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, -(_selfz * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t2, _selfz * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static long rotateYXZ_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleY;
        double _t2 = 0.5 * angleZ;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t3 * _t7;
        double _t12 = _t4 * _t6;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t12, _t8, -(_t11 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t19, _selfw * _t20) + Math.fma(_selfy, _t21, -(_selfz * _t22)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t19, _selfz * _t20) + Math.fma(_selfw, _t22, -(_selfx * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t22, _selfw * _t21) + Math.fma(_selfz, _t19, -(_selfy * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t21, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t20)))));
        return dest;
    }

    public static long rotateYZX_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t7 * _t3;
        double _t12 = _t6 * _t4;
        double _t19 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t20 = Math.fma(_t12, _t5, _t11 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static long rotateZ_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t1, _selfy * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t1, -(_selfx * _t2)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfz, _t1, _selfw * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static long rotateZXY_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angleX;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleY;
        double _t3 = Math.cos(_t0);
        double _t4 = Math.cos(_t1);
        double _t5 = Math.cos(_t2);
        double _t6 = Math.sin(_t0);
        double _t7 = Math.sin(_t1);
        double _t8 = Math.sin(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t6 * _t4;
        double _t12 = _t7 * _t3;
        double _t19 = Math.fma(_t11, _t8, _t12 * _t5);
        double _t20 = Math.fma(_t10, _t5, _t9 * _t8);
        double _t21 = Math.fma(_t9, _t5, -(_t10 * _t8));
        double _t22 = Math.fma(_t11, _t5, -(_t12 * _t8));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t21, _selfw * _t22) + Math.fma(_selfy, _t19, -(_selfz * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t21, _selfz * _t22) + Math.fma(_selfw, _t20, -(_selfx * _t19)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t20, _selfw * _t19) + Math.fma(_selfz, _t21, -(_selfy * _t22)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t19, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t22)))));
        return dest;
    }

    public static long rotateZYX_unsafe(long dest, long src, double angleX, double angleY, double angleZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t0 = 0.5 * angleY;
        double _t1 = 0.5 * angleZ;
        double _t2 = 0.5 * angleX;
        double _t3 = Math.sin(_t0);
        double _t4 = Math.sin(_t1);
        double _t5 = Math.sin(_t2);
        double _t6 = Math.cos(_t0);
        double _t7 = Math.cos(_t1);
        double _t8 = Math.cos(_t2);
        double _t9 = _t3 * _t4;
        double _t10 = _t6 * _t7;
        double _t11 = _t4 * _t6;
        double _t12 = _t3 * _t7;
        double _t19 = Math.fma(_t9, _t5, _t10 * _t8);
        double _t20 = Math.fma(_t12, _t8, _t11 * _t5);
        double _t21 = Math.fma(_t10, _t5, -(_t9 * _t8));
        double _t22 = Math.fma(_t11, _t8, -(_t12 * _t5));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        UnsafeOpsHolder.U.putDouble(dest + 24L, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static long transform_unsafe(long dest, long src, double vX, double vY, double vZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t9 = 2.0 * Math.fma(_selfx, vY, -(_selfy * vX));
        double _t10 = 2.0 * Math.fma(_selfz, vX, -(_selfx * vZ));
        double _t11 = 2.0 * Math.fma(_selfy, vZ, -(_selfz * vY));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, vX))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vY))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, vZ))));
        return dest;
    }

    public static long transform_unsafe(long dest, long src, long v) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        double _t9 = 2.0 * Math.fma(_selfx, _vy, -(_selfy * _vx));
        double _t10 = 2.0 * Math.fma(_selfz, _vx, -(_selfx * _vz));
        double _t11 = 2.0 * Math.fma(_selfy, _vz, -(_selfz * _vy));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, _vx))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vy))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, _vz))));
        return dest;
    }

    public static long transformInverse_unsafe(long dest, long src, double vX, double vY, double vZ) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _t9 = 2.0 * Math.fma(_selfx, vZ, -(_selfz * vX));
        double _t10 = 2.0 * Math.fma(_selfy, vX, -(_selfx * vY));
        double _t11 = 2.0 * Math.fma(_selfz, vY, -(_selfy * vZ));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, vX))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, vY))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vZ))));
        return dest;
    }

    public static long transformInverse_unsafe(long dest, long src, long v) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _selfz = UnsafeOpsHolder.U.getDouble(src + 16L);
        double _selfw = UnsafeOpsHolder.U.getDouble(src + 24L);
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        double _vz = UnsafeOpsHolder.U.getDouble(v + 16L);
        double _t9 = 2.0 * Math.fma(_selfx, _vz, -(_selfz * _vx));
        double _t10 = 2.0 * Math.fma(_selfy, _vx, -(_selfx * _vy));
        double _t11 = 2.0 * Math.fma(_selfz, _vy, -(_selfy * _vz));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, _vx))));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, _vy))));
        UnsafeOpsHolder.U.putDouble(dest + 16L, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vz))));
        return dest;
    }

}
