package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link DoubleQuatOps} whose leading storage
 * parameter is a {@link java.nio.ByteBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code DoubleQuatOps} and its sibling kernel units. Not public API.
 */
public final class DoubleQuatOpsKernelsByteBuffer {
    private DoubleQuatOpsKernelsByteBuffer() {}

    public static java.nio.ByteBuffer invert_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invert_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest.putDouble(destOffset + 0, -(_selfx * _t3_inv));
        dest.putDouble(destOffset + 8, -(_selfy * _t3_inv));
        dest.putDouble(destOffset + 16, -(_selfz * _t3_inv));
        dest.putDouble(destOffset + 24, _selfw * _t3_inv);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t21 = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz));
        double _t22 = Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy));
        double _t23 = Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx));
        double _t24 = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        dest.putDouble(destOffset + 0, -(_t21 * _t28_inv));
        dest.putDouble(destOffset + 8, -(_t23 * _t28_inv));
        dest.putDouble(destOffset + 16, -(_t22 * _t28_inv));
        dest.putDouble(destOffset + 24, _t24 * _t28_inv);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer invertProduct_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        double _t21 = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz));
        double _t22 = Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy));
        double _t23 = Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx));
        double _t24 = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        double _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        double _t28_inv = 1.0 / _t28;
        dest.putDouble(destOffset + 0, -(_t21 * _t28_inv));
        dest.putDouble(destOffset + 8, -(_t23 * _t28_inv));
        dest.putDouble(destOffset + 16, -(_t22 * _t28_inv));
        dest.putDouble(destOffset + 24, _t24 * _t28_inv);
        return dest;
    }

    public static java.nio.ByteBuffer add_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.add_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.ByteBuffer add_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, otherX + _selfx);
        dest.putDouble(destOffset + 8, otherY + _selfy);
        dest.putDouble(destOffset + 16, otherZ + _selfz);
        dest.putDouble(destOffset + 24, otherW + _selfw);
        return dest;
    }

    public static java.nio.ByteBuffer add_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer add_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        dest.putDouble(destOffset + 0, _otherx + _selfx);
        dest.putDouble(destOffset + 8, _othery + _selfy);
        dest.putDouble(destOffset + 16, _otherz + _selfz);
        dest.putDouble(destOffset + 24, _otherw + _selfw);
        return dest;
    }

    public static java.nio.ByteBuffer negate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, -_selfx);
        dest.putDouble(destOffset + 8, -_selfy);
        dest.putDouble(destOffset + 16, -_selfz);
        dest.putDouble(destOffset + 24, -_selfw);
        return dest;
    }

    public static java.nio.ByteBuffer sub_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.sub_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.ByteBuffer sub_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, _selfx - otherX);
        dest.putDouble(destOffset + 8, _selfy - otherY);
        dest.putDouble(destOffset + 16, _selfz - otherZ);
        dest.putDouble(destOffset + 24, _selfw - otherW);
        return dest;
    }

    public static java.nio.ByteBuffer sub_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer sub_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        dest.putDouble(destOffset + 0, _selfx - _otherx);
        dest.putDouble(destOffset + 8, _selfy - _othery);
        dest.putDouble(destOffset + 16, _selfz - _otherz);
        dest.putDouble(destOffset + 24, _selfw - _otherw);
        return dest;
    }

    public static java.nio.ByteBuffer set_unsafe(java.nio.ByteBuffer dest, int destOffset, double vX, double vY, double vZ, double vW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.set_unsafe(_destBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.ByteBuffer set_api(java.nio.ByteBuffer dest, int destOffset, double vX, double vY, double vZ, double vW) {
        dest.putDouble(destOffset + 0, vX);
        dest.putDouble(destOffset + 8, vY);
        dest.putDouble(destOffset + 16, vZ);
        dest.putDouble(destOffset + 24, vW);
        return dest;
    }

    public static java.nio.ByteBuffer set_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        DoubleQuatOpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer set_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer v, int vOffset) {
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        double _vz = v.getDouble(vOffset + 16);
        double _vw = v.getDouble(vOffset + 24);
        dest.putDouble(destOffset + 0, _vx);
        dest.putDouble(destOffset + 8, _vy);
        dest.putDouble(destOffset + 16, _vz);
        dest.putDouble(destOffset + 24, _vw);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromDualQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromDualQuat_api(java.nio.ByteBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        dest.putDouble(destOffset + 0, dqRX);
        dest.putDouble(destOffset + 8, dqRY);
        dest.putDouble(destOffset + 16, dqRZ);
        dest.putDouble(destOffset + 24, dqRW);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromMatrixMat3x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        DoubleQuatOpsKernelsAddress.makeFromMatrixMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromMatrixMat3x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m10 = m.getDouble(mOffset + 8);
        double _m20 = m.getDouble(mOffset + 16);
        double _m01 = m.getDouble(mOffset + 24);
        double _m11 = m.getDouble(mOffset + 32);
        double _m21 = m.getDouble(mOffset + 40);
        double _m02 = m.getDouble(mOffset + 48);
        double _m12 = m.getDouble(mOffset + 56);
        double _m22 = m.getDouble(mOffset + 64);
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
            dest.putDouble(destOffset + 0, 0.5 * _t1 * _t18);
            dest.putDouble(destOffset + 8, 0.5 * _t7 * _t18);
            dest.putDouble(destOffset + 16, 0.5 * _t9 * _t18);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t15));
                dest.putDouble(destOffset + 8, 0.5 * _t4 * _t21);
                dest.putDouble(destOffset + 16, 0.5 * _t6 * _t21);
                dest.putDouble(destOffset + 24, 0.5 * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    dest.putDouble(destOffset + 0, 0.5 * _t4 * _t19);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t16));
                    dest.putDouble(destOffset + 16, 0.5 * _t8 * _t19);
                    dest.putDouble(destOffset + 24, 0.5 * _t7 * _t19);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t6 * _t20);
                    dest.putDouble(destOffset + 8, 0.5 * _t8 * _t20);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t17));
                    dest.putDouble(destOffset + 24, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeFromMatrixMat3x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        DoubleQuatOpsKernelsAddress.makeFromMatrixMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromMatrixMat3x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m01 = m.getDouble(mOffset + 8);
        double _m02 = m.getDouble(mOffset + 16);
        double _m10 = m.getDouble(mOffset + 32);
        double _m11 = m.getDouble(mOffset + 40);
        double _m12 = m.getDouble(mOffset + 48);
        double _m20 = m.getDouble(mOffset + 64);
        double _m21 = m.getDouble(mOffset + 72);
        double _m22 = m.getDouble(mOffset + 80);
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
            dest.putDouble(destOffset + 0, 0.5 * _t1 * _t18);
            dest.putDouble(destOffset + 8, 0.5 * _t7 * _t18);
            dest.putDouble(destOffset + 16, 0.5 * _t9 * _t18);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t15));
                dest.putDouble(destOffset + 8, 0.5 * _t4 * _t21);
                dest.putDouble(destOffset + 16, 0.5 * _t6 * _t21);
                dest.putDouble(destOffset + 24, 0.5 * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    dest.putDouble(destOffset + 0, 0.5 * _t4 * _t19);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t16));
                    dest.putDouble(destOffset + 16, 0.5 * _t8 * _t19);
                    dest.putDouble(destOffset + 24, 0.5 * _t7 * _t19);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t6 * _t20);
                    dest.putDouble(destOffset + 8, 0.5 * _t8 * _t20);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t17));
                    dest.putDouble(destOffset + 24, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeFromMatrixMat4x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + mOffset;
        DoubleQuatOpsKernelsAddress.makeFromMatrixMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeFromMatrixMat4x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer m, int mOffset) {
        double _m00 = m.getDouble(mOffset + 0);
        double _m10 = m.getDouble(mOffset + 8);
        double _m20 = m.getDouble(mOffset + 16);
        double _m01 = m.getDouble(mOffset + 32);
        double _m11 = m.getDouble(mOffset + 40);
        double _m21 = m.getDouble(mOffset + 48);
        double _m02 = m.getDouble(mOffset + 64);
        double _m12 = m.getDouble(mOffset + 72);
        double _m22 = m.getDouble(mOffset + 80);
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
            dest.putDouble(destOffset + 0, 0.5 * _t1 * _t18);
            dest.putDouble(destOffset + 8, 0.5 * _t7 * _t18);
            dest.putDouble(destOffset + 16, 0.5 * _t9 * _t18);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t15));
                dest.putDouble(destOffset + 8, 0.5 * _t4 * _t21);
                dest.putDouble(destOffset + 16, 0.5 * _t6 * _t21);
                dest.putDouble(destOffset + 24, 0.5 * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    dest.putDouble(destOffset + 0, 0.5 * _t4 * _t19);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t16));
                    dest.putDouble(destOffset + 16, 0.5 * _t8 * _t19);
                    dest.putDouble(destOffset + 24, 0.5 * _t7 * _t19);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t6 * _t20);
                    dest.putDouble(destOffset + 8, 0.5 * _t8 * _t20);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t17));
                    dest.putDouble(destOffset + 24, 0.5 * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer toDualQuat_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toDualQuat_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, _selfx);
        dest.putDouble(destOffset + 8, _selfy);
        dest.putDouble(destOffset + 16, _selfz);
        dest.putDouble(destOffset + 24, _selfw);
        dest.putDouble(destOffset + 32, 0.0);
        dest.putDouble(destOffset + 40, 0.0);
        dest.putDouble(destOffset + 48, 0.0);
        dest.putDouble(destOffset + 56, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer toMatrix_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.toMatrix_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toMatrix_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfx, _selfy, _t1));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfx, _selfz, -_t2));
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 2.0 * Math.fma(_selfx, _selfy, -_t1));
        dest.putDouble(destOffset + 40, Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 2.0 * Math.fma(_selfx, _selfz, _t2));
        dest.putDouble(destOffset + 72, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.putDouble(destOffset + 80, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        dest.putDouble(destOffset + 88, 0.0);
        dest.putDouble(destOffset + 96, 0.0);
        dest.putDouble(destOffset + 104, 0.0);
        dest.putDouble(destOffset + 112, 0.0);
        dest.putDouble(destOffset + 120, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer toMatrix3x3_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.toMatrix3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toMatrix3x3_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfx, _selfy, _t1));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfx, _selfz, -_t2));
        dest.putDouble(destOffset + 24, 2.0 * Math.fma(_selfx, _selfy, -_t1));
        dest.putDouble(destOffset + 32, Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        dest.putDouble(destOffset + 40, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(_selfx, _selfz, _t2));
        dest.putDouble(destOffset + 56, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.putDouble(destOffset + 64, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer toMatrix3x4_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.toMatrix3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer toMatrix3x4_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfz * _selfw;
        double _t2 = _selfy * _selfw;
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfx, _selfy, -_t1));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfx, _selfz, _t2));
        dest.putDouble(destOffset + 24, 0.0);
        dest.putDouble(destOffset + 32, 2.0 * Math.fma(_selfx, _selfy, _t1));
        dest.putDouble(destOffset + 40, Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0));
        dest.putDouble(destOffset + 48, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.putDouble(destOffset + 56, 0.0);
        dest.putDouble(destOffset + 64, 2.0 * Math.fma(_selfx, _selfz, -_t2));
        dest.putDouble(destOffset + 72, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.putDouble(destOffset + 80, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        dest.putDouble(destOffset + 88, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer decomposeSwingTwist_unsafe(java.nio.ByteBuffer swing, int swingOffset, java.nio.ByteBuffer twist, int twistOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        long _swingBase = UnsafeOpsHolder.U.getLong(swing, UnsafeCopy.BB_ADDRESS_OFFSET) + swingOffset;
        long _twistBase = UnsafeOpsHolder.U.getLong(twist, UnsafeCopy.BB_ADDRESS_OFFSET) + twistOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.decomposeSwingTwist_unsafe(_swingBase, _twistBase, _srcBase, axisX, axisY, axisZ);
        return swing;
    }

    public static java.nio.ByteBuffer decomposeSwingTwist_api(java.nio.ByteBuffer swing, int swingOffset, java.nio.ByteBuffer twist, int twistOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        swing.putDouble(swingOffset + 0, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        swing.putDouble(swingOffset + 8, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        swing.putDouble(swingOffset + 16, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        swing.putDouble(swingOffset + 24, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        twist.putDouble(twistOffset + 0, _t12);
        twist.putDouble(twistOffset + 8, _t13);
        twist.putDouble(twistOffset + 16, _t14);
        twist.putDouble(twistOffset + 24, _t11);
        return swing;
    }

    public static java.nio.ByteBuffer decomposeSwingTwist_unsafe(java.nio.ByteBuffer swing, int swingOffset, java.nio.ByteBuffer twist, int twistOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        long _swingBase = UnsafeOpsHolder.U.getLong(swing, UnsafeCopy.BB_ADDRESS_OFFSET) + swingOffset;
        long _twistBase = UnsafeOpsHolder.U.getLong(twist, UnsafeCopy.BB_ADDRESS_OFFSET) + twistOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        DoubleQuatOpsKernelsAddress.decomposeSwingTwist_unsafe(_swingBase, _twistBase, _srcBase, _axisBase);
        return swing;
    }

    public static java.nio.ByteBuffer decomposeSwingTwist_api(java.nio.ByteBuffer swing, int swingOffset, java.nio.ByteBuffer twist, int twistOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
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
        swing.putDouble(swingOffset + 0, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        swing.putDouble(swingOffset + 8, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        swing.putDouble(swingOffset + 16, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        swing.putDouble(swingOffset + 24, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        twist.putDouble(twistOffset + 0, _t12);
        twist.putDouble(twistOffset + 8, _t13);
        twist.putDouble(twistOffset + 16, _t14);
        twist.putDouble(twistOffset + 24, _t11);
        return swing;
    }

    public static java.nio.ByteBuffer getSwing_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getSwing_unsafe(_destBase, _srcBase, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer getSwing_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        dest.putDouble(destOffset + 24, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static java.nio.ByteBuffer getSwing_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        DoubleQuatOpsKernelsAddress.getSwing_unsafe(_destBase, _srcBase, _axisBase);
        return dest;
    }

    public static java.nio.ByteBuffer getSwing_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        dest.putDouble(destOffset + 24, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static java.nio.ByteBuffer getTwist_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getTwist_unsafe(_destBase, _srcBase, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer getTwist_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double axisX, double axisY, double axisZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            dest.putDouble(destOffset + 0, axisX * _t6);
            dest.putDouble(destOffset + 8, axisY * _t6);
            dest.putDouble(destOffset + 16, axisZ * _t6);
            dest.putDouble(destOffset + 24, _selfw * _t5);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 1.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer getTwist_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        DoubleQuatOpsKernelsAddress.getTwist_unsafe(_destBase, _srcBase, _axisBase);
        return dest;
    }

    public static java.nio.ByteBuffer getTwist_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
        double _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        double _t5 = (1.0 / Math.sqrt(_t4));
        double _t6 = _t2 * _t5;
        if (_t4 > 1.0E-30) {
            dest.putDouble(destOffset + 0, _axisx * _t6);
            dest.putDouble(destOffset + 8, _axisy * _t6);
            dest.putDouble(destOffset + 16, _axisz * _t6);
            dest.putDouble(destOffset + 24, _selfw * _t5);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 1.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_unsafe(java.nio.ByteBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeIdentity_api(java.nio.ByteBuffer dest, int destOffset) {
        dest.putDouble(destOffset + 0, 0.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 1.0);
        return dest;
    }

    public static java.nio.ByteBuffer makeZero_unsafe(java.nio.ByteBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeZero_unsafe(_destBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeZero_api(java.nio.ByteBuffer dest, int destOffset) {
        dest.putDouble(destOffset + 0, 0.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, 0.0);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW, t);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(t, otherX - _selfx, _selfx));
        dest.putDouble(destOffset + 8, Math.fma(t, otherY - _selfy, _selfy));
        dest.putDouble(destOffset + 16, Math.fma(t, otherZ - _selfz, _selfz));
        dest.putDouble(destOffset + 24, Math.fma(t, otherW - _selfw, _selfw));
        return dest;
    }

    public static java.nio.ByteBuffer lerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.ByteBuffer lerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset, double t) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(t, _otherx - _selfx, _selfx));
        dest.putDouble(destOffset + 8, Math.fma(t, _othery - _selfy, _selfy));
        dest.putDouble(destOffset + 16, Math.fma(t, _otherz - _selfz, _selfz));
        dest.putDouble(destOffset + 24, Math.fma(t, _otherw - _selfw, _selfw));
        return dest;
    }

    public static java.nio.ByteBuffer nlerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.nlerp_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer nlerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t4 = Math.fma(alpha, targetW - _selfw, _selfw);
        double _t5 = Math.fma(alpha, targetZ - _selfz, _selfz);
        double _t6 = Math.fma(alpha, targetX - _selfx, _selfx);
        double _t7 = Math.fma(alpha, targetY - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.putDouble(destOffset + 0, _t6 * _t12);
            dest.putDouble(destOffset + 8, _t7 * _t12);
            dest.putDouble(destOffset + 16, _t5 * _t12);
            dest.putDouble(destOffset + 24, _t4 * _t12);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer nlerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _targetBase = UnsafeOpsHolder.U.getLong(target, UnsafeCopy.BB_ADDRESS_OFFSET) + targetOffset;
        DoubleQuatOpsKernelsAddress.nlerp_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer nlerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _targetx = target.getDouble(targetOffset + 0);
        double _targety = target.getDouble(targetOffset + 8);
        double _targetz = target.getDouble(targetOffset + 16);
        double _targetw = target.getDouble(targetOffset + 24);
        double _t4 = Math.fma(alpha, _targetw - _selfw, _selfw);
        double _t5 = Math.fma(alpha, _targetz - _selfz, _selfz);
        double _t6 = Math.fma(alpha, _targetx - _selfx, _selfx);
        double _t7 = Math.fma(alpha, _targety - _selfy, _selfy);
        double _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        double _t12 = (1.0 / Math.sqrt(_t11));
        if (_t11 > 0.0) {
            dest.putDouble(destOffset + 0, _t6 * _t12);
            dest.putDouble(destOffset + 8, _t7 * _t12);
            dest.putDouble(destOffset + 16, _t5 * _t12);
            dest.putDouble(destOffset + 24, _t4 * _t12);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer nlerpShortest_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.nlerpShortest_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer nlerpShortest_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
            dest.putDouble(destOffset + 0, _t19 * _t25);
            dest.putDouble(destOffset + 8, _t20 * _t25);
            dest.putDouble(destOffset + 16, _t18 * _t25);
            dest.putDouble(destOffset + 24, _t17 * _t25);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer nlerpShortest_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _targetBase = UnsafeOpsHolder.U.getLong(target, UnsafeCopy.BB_ADDRESS_OFFSET) + targetOffset;
        DoubleQuatOpsKernelsAddress.nlerpShortest_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer nlerpShortest_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _targetx = target.getDouble(targetOffset + 0);
        double _targety = target.getDouble(targetOffset + 8);
        double _targetz = target.getDouble(targetOffset + 16);
        double _targetw = target.getDouble(targetOffset + 24);
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
            dest.putDouble(destOffset + 0, _t19 * _t25);
            dest.putDouble(destOffset + 8, _t20 * _t25);
            dest.putDouble(destOffset + 16, _t18 * _t25);
            dest.putDouble(destOffset + 24, _t17 * _t25);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer slerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.slerp_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer slerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 0.0) {
            dest.putDouble(destOffset + 0, Math.fma(_selfx, _t13, targetX * _t11) * _t8_inv);
            dest.putDouble(destOffset + 8, Math.fma(_selfy, _t13, targetY * _t11) * _t8_inv);
            dest.putDouble(destOffset + 16, Math.fma(_selfz, _t13, targetZ * _t11) * _t8_inv);
            dest.putDouble(destOffset + 24, Math.fma(_selfw, _t13, targetW * _t11) * _t8_inv);
        } else {
            dest.putDouble(destOffset + 0, Math.fma(alpha, targetX, _selfx * _t0));
            dest.putDouble(destOffset + 8, Math.fma(alpha, targetY, _selfy * _t0));
            dest.putDouble(destOffset + 16, Math.fma(alpha, targetZ, _selfz * _t0));
            dest.putDouble(destOffset + 24, Math.fma(alpha, targetW, _selfw * _t0));
        }
        return dest;
    }

    public static java.nio.ByteBuffer slerp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _targetBase = UnsafeOpsHolder.U.getLong(target, UnsafeCopy.BB_ADDRESS_OFFSET) + targetOffset;
        DoubleQuatOpsKernelsAddress.slerp_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer slerp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _targetx = target.getDouble(targetOffset + 0);
        double _targety = target.getDouble(targetOffset + 8);
        double _targetz = target.getDouble(targetOffset + 16);
        double _targetw = target.getDouble(targetOffset + 24);
        double _t0 = 1.0 - alpha;
        double _t7 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        double _t8 = Math.sin(_t7);
        double _t8_inv = 1.0 / _t8;
        double _t9 = Math.abs(_t8);
        double _t11 = Math.sin(alpha * _t7);
        double _t13 = Math.sin(_t0 * _t7);
        if (_t9 > 0.0) {
            dest.putDouble(destOffset + 0, Math.fma(_selfx, _t13, _targetx * _t11) * _t8_inv);
            dest.putDouble(destOffset + 8, Math.fma(_selfy, _t13, _targety * _t11) * _t8_inv);
            dest.putDouble(destOffset + 16, Math.fma(_selfz, _t13, _targetz * _t11) * _t8_inv);
            dest.putDouble(destOffset + 24, Math.fma(_selfw, _t13, _targetw * _t11) * _t8_inv);
        } else {
            dest.putDouble(destOffset + 0, Math.fma(alpha, _targetx, _selfx * _t0));
            dest.putDouble(destOffset + 8, Math.fma(alpha, _targety, _selfy * _t0));
            dest.putDouble(destOffset + 16, Math.fma(alpha, _targetz, _selfz * _t0));
            dest.putDouble(destOffset + 24, Math.fma(alpha, _targetw, _selfw * _t0));
        }
        return dest;
    }

    public static java.nio.ByteBuffer slerpShortest_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.slerpShortest_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer slerpShortest_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
            dest.putDouble(destOffset + 0, _t50 * _t44);
            dest.putDouble(destOffset + 8, _t50 * _t45);
            dest.putDouble(destOffset + 16, _t50 * _t43);
            dest.putDouble(destOffset + 24, _t50 * _t42);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer slerpShortest_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _targetBase = UnsafeOpsHolder.U.getLong(target, UnsafeCopy.BB_ADDRESS_OFFSET) + targetOffset;
        DoubleQuatOpsKernelsAddress.slerpShortest_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.nio.ByteBuffer slerpShortest_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double alpha) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _targetx = target.getDouble(targetOffset + 0);
        double _targety = target.getDouble(targetOffset + 8);
        double _targetz = target.getDouble(targetOffset + 16);
        double _targetw = target.getDouble(targetOffset + 24);
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
            dest.putDouble(destOffset + 0, _t50 * _t44);
            dest.putDouble(destOffset + 8, _t50 * _t45);
            dest.putDouble(destOffset + 16, _t50 * _t43);
            dest.putDouble(destOffset + 24, _t50 * _t42);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer squad_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.squad_unsafe(_destBase, _srcBase, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        return dest;
    }

    public static java.nio.ByteBuffer squad_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double control0X, double control0Y, double control0Z, double control0W, double control1X, double control1Y, double control1Z, double control1W, double targetX, double targetY, double targetZ, double targetW, double t) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
            dest.putDouble(destOffset + 0, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            dest.putDouble(destOffset + 8, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            dest.putDouble(destOffset + 16, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            dest.putDouble(destOffset + 24, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            dest.putDouble(destOffset + 0, Math.fma(_t14, _t76, _t13 * _t75));
            dest.putDouble(destOffset + 8, Math.fma(_t14, _t78, _t13 * _t77));
            dest.putDouble(destOffset + 16, Math.fma(_t14, _t74, _t13 * _t73));
            dest.putDouble(destOffset + 24, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static java.nio.ByteBuffer squad_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer control0, int control0Offset, java.nio.ByteBuffer control1, int control1Offset, java.nio.ByteBuffer target, int targetOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _control0Base = UnsafeOpsHolder.U.getLong(control0, UnsafeCopy.BB_ADDRESS_OFFSET) + control0Offset;
        long _control1Base = UnsafeOpsHolder.U.getLong(control1, UnsafeCopy.BB_ADDRESS_OFFSET) + control1Offset;
        long _targetBase = UnsafeOpsHolder.U.getLong(target, UnsafeCopy.BB_ADDRESS_OFFSET) + targetOffset;
        DoubleQuatOpsKernelsAddress.squad_unsafe(_destBase, _srcBase, _control0Base, _control1Base, _targetBase, t);
        return dest;
    }

    public static java.nio.ByteBuffer squad_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer control0, int control0Offset, java.nio.ByteBuffer control1, int control1Offset, java.nio.ByteBuffer target, int targetOffset, double t) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _control0x = control0.getDouble(control0Offset + 0);
        double _control0y = control0.getDouble(control0Offset + 8);
        double _control0z = control0.getDouble(control0Offset + 16);
        double _control0w = control0.getDouble(control0Offset + 24);
        double _control1x = control1.getDouble(control1Offset + 0);
        double _control1y = control1.getDouble(control1Offset + 8);
        double _control1z = control1.getDouble(control1Offset + 16);
        double _control1w = control1.getDouble(control1Offset + 24);
        double _targetx = target.getDouble(targetOffset + 0);
        double _targety = target.getDouble(targetOffset + 8);
        double _targetz = target.getDouble(targetOffset + 16);
        double _targetw = target.getDouble(targetOffset + 24);
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
            dest.putDouble(destOffset + 0, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            dest.putDouble(destOffset + 8, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            dest.putDouble(destOffset + 16, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            dest.putDouble(destOffset + 24, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            dest.putDouble(destOffset + 0, Math.fma(_t14, _t76, _t13 * _t75));
            dest.putDouble(destOffset + 8, Math.fma(_t14, _t78, _t13 * _t77));
            dest.putDouble(destOffset + 16, Math.fma(_t14, _t74, _t13 * _t73));
            dest.putDouble(destOffset + 24, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static java.nio.ByteBuffer mul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.mul_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.ByteBuffer mul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz)));
        dest.putDouble(destOffset + 8, Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx)));
        dest.putDouble(destOffset + 16, Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy)));
        dest.putDouble(destOffset + 24, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static java.nio.ByteBuffer mul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer mul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz)));
        dest.putDouble(destOffset + 8, Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx)));
        dest.putDouble(destOffset + 16, Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy)));
        dest.putDouble(destOffset + 24, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static java.nio.ByteBuffer preMul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.ByteBuffer preMul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherY, _selfz, -(otherZ * _selfy)));
        dest.putDouble(destOffset + 8, Math.fma(otherY, _selfw, otherZ * _selfx) + Math.fma(otherW, _selfy, -(otherX * _selfz)));
        dest.putDouble(destOffset + 16, Math.fma(otherX, _selfy, otherW * _selfz) + Math.fma(otherZ, _selfw, -(otherY * _selfx)));
        dest.putDouble(destOffset + 24, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static java.nio.ByteBuffer preMul_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer preMul_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_othery, _selfz, -(_otherz * _selfy)));
        dest.putDouble(destOffset + 8, Math.fma(_othery, _selfw, _otherz * _selfx) + Math.fma(_otherw, _selfy, -(_otherx * _selfz)));
        dest.putDouble(destOffset + 16, Math.fma(_otherx, _selfy, _otherw * _selfz) + Math.fma(_otherz, _selfw, -(_othery * _selfx)));
        dest.putDouble(destOffset + 24, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static double angle_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return DoubleQuatOpsKernelsAddress.angle_unsafe(_srcBase);
    }

    public static double angle_api(java.nio.ByteBuffer src, int srcOffset) {
        double _selfw = src.getDouble(srcOffset + 24);
        return 2.0 * Math.acos(Math.min(1.0, Math.max(-1.0, _selfw)));
    }

    public static double angleTo_unsafe(java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return DoubleQuatOpsKernelsAddress.angleTo_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double angleTo_api(java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy))))));
    }

    public static double angleTo_unsafe(java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        return DoubleQuatOpsKernelsAddress.angleTo_unsafe(_srcBase, _otherBase);
    }

    public static double angleTo_api(java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        return 2.0 * Math.acos(Math.min(1.0, Math.abs(Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy))))));
    }

    public static java.nio.ByteBuffer axis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.axis_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer axis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.putDouble(destOffset + 0, _selfx * _t3);
            dest.putDouble(destOffset + 8, _selfy * _t3);
            dest.putDouble(destOffset + 16, _selfz * _t3);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer calculateW_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.calculateW_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer calculateW_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        dest.putDouble(destOffset + 0, _selfx);
        dest.putDouble(destOffset + 8, _selfy);
        dest.putDouble(destOffset + 16, _selfz);
        dest.putDouble(destOffset + 24, Math.sqrt(Math.max(0.0, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0))))));
        return dest;
    }

    public static java.nio.ByteBuffer conjugate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.conjugate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer conjugate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, -_selfx);
        dest.putDouble(destOffset + 8, -_selfy);
        dest.putDouble(destOffset + 16, -_selfz);
        dest.putDouble(destOffset + 24, _selfw);
        return dest;
    }

    public static java.nio.ByteBuffer conjugateBy_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.conjugateBy_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.ByteBuffer conjugateBy_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t1 = -qY;
        double _t21 = Math.fma(qX, _selfy, qW * _selfz) + Math.fma(qZ, _selfw, -(qY * _selfx));
        double _t22 = Math.fma(qY, _selfw, qZ * _selfx) + Math.fma(qW, _selfy, -(qX * _selfz));
        double _t23 = Math.fma(qX, _selfw, qW * _selfx) + Math.fma(qY, _selfz, -(qZ * _selfy));
        double _t24 = Math.fma(-qZ, _selfz, Math.fma(_t1, _selfy, Math.fma(qW, _selfw, -(qX * _selfx))));
        dest.putDouble(destOffset + 0, Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24)));
        dest.putDouble(destOffset + 8, Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21)));
        dest.putDouble(destOffset + 16, Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24)));
        dest.putDouble(destOffset + 24, Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24))));
        return dest;
    }

    public static java.nio.ByteBuffer conjugateBy_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + qOffset;
        DoubleQuatOpsKernelsAddress.conjugateBy_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.ByteBuffer conjugateBy_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer q, int qOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _qx = q.getDouble(qOffset + 0);
        double _qy = q.getDouble(qOffset + 8);
        double _qz = q.getDouble(qOffset + 16);
        double _qw = q.getDouble(qOffset + 24);
        double _t1 = -_qy;
        double _t21 = Math.fma(_qx, _selfy, _qw * _selfz) + Math.fma(_qz, _selfw, -(_qy * _selfx));
        double _t22 = Math.fma(_qy, _selfw, _qz * _selfx) + Math.fma(_qw, _selfy, -(_qx * _selfz));
        double _t23 = Math.fma(_qx, _selfw, _qw * _selfx) + Math.fma(_qy, _selfz, -(_qz * _selfy));
        double _t24 = Math.fma(-_qz, _selfz, Math.fma(_t1, _selfy, Math.fma(_qw, _selfw, -(_qx * _selfx))));
        dest.putDouble(destOffset + 0, Math.fma(_qy, _t21, -(_qz * _t22)) + Math.fma(_qw, _t23, -(_qx * _t24)));
        dest.putDouble(destOffset + 8, Math.fma(_qz, _t23, -(_qy * _t24)) + Math.fma(_qw, _t22, -(_qx * _t21)));
        dest.putDouble(destOffset + 16, Math.fma(_qx, _t22, _qw * _t21) + Math.fma(_t1, _t23, -(_qz * _t24)));
        dest.putDouble(destOffset + 24, Math.fma(_qz, _t21, Math.fma(_qy, _t22, Math.fma(_qx, _t23, _qw * _t24))));
        return dest;
    }

    public static java.nio.ByteBuffer difference_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.difference_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.ByteBuffer difference_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest.putDouble(destOffset + 0, (Math.fma(otherX, _selfw, -(otherW * _selfx)) + Math.fma(otherY, _selfz, -(otherZ * _selfy))) * _t3_inv);
        dest.putDouble(destOffset + 8, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        dest.putDouble(destOffset + 16, (Math.fma(otherX, _selfy, -(otherW * _selfz)) + Math.fma(otherZ, _selfw, -(otherY * _selfx))) * _t3_inv);
        dest.putDouble(destOffset + 24, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw))) * _t3_inv);
        return dest;
    }

    public static java.nio.ByteBuffer difference_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        DoubleQuatOpsKernelsAddress.difference_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.ByteBuffer difference_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t3_inv = 1.0 / _t3;
        dest.putDouble(destOffset + 0, (Math.fma(_otherx, _selfw, -(_otherw * _selfx)) + Math.fma(_othery, _selfz, -(_otherz * _selfy))) * _t3_inv);
        dest.putDouble(destOffset + 8, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        dest.putDouble(destOffset + 16, (Math.fma(_otherx, _selfy, -(_otherw * _selfz)) + Math.fma(_otherz, _selfw, -(_othery * _selfx))) * _t3_inv);
        dest.putDouble(destOffset + 24, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw))) * _t3_inv);
        return dest;
    }

    public static double dot_unsafe(java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return DoubleQuatOpsKernelsAddress.dot_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double dot_api(java.nio.ByteBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        return Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)));
    }

    public static double dot_unsafe(java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + otherOffset;
        return DoubleQuatOpsKernelsAddress.dot_unsafe(_srcBase, _otherBase);
    }

    public static double dot_api(java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer other, int otherOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _otherx = other.getDouble(otherOffset + 0);
        double _othery = other.getDouble(otherOffset + 8);
        double _otherz = other.getDouble(otherOffset + 16);
        double _otherw = other.getDouble(otherOffset + 24);
        return Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)));
    }

    public static java.nio.ByteBuffer exp_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.exp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer exp_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = Math.exp(_selfw);
        double _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.sqrt(_t3);
        double _t8 = Math.sin(_t4) * _t0 * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest.putDouble(destOffset + 0, _selfx * _t8);
            dest.putDouble(destOffset + 8, _selfy * _t8);
            dest.putDouble(destOffset + 16, _selfz * _t8);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        dest.putDouble(destOffset + 24, Math.cos(_t4) * _t0);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXYZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t1 = _selfy * _selfz;
        double _t3 = _selfz * _selfz;
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t9 = 2.0 * Math.fma(_selfx, _selfw, -_t1);
        double _t10 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        double _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            dest.putDouble(destOffset + 0, Math.atan2(2.0 * Math.fma(_selfx, _selfw, _t1), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t3), 1.0)));
            dest.putDouble(destOffset + 16, 0.0);
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(_t9, _t10));
            dest.putDouble(destOffset + 16, Math.atan2(2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t3), 1.0)));
        }
        dest.putDouble(destOffset + 8, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesXZY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = _selfz * _selfz;
        double _t1 = _selfy * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _t1);
        double _t8 = 2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest.putDouble(destOffset + 0, Math.atan2(2.0 * Math.fma(_selfx, _selfw, -_t1), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
            dest.putDouble(destOffset + 8, 0.0);
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(_t7, _t9));
            dest.putDouble(destOffset + 8, Math.atan2(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0)));
        }
        dest.putDouble(destOffset + 16, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYXZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t3 = _selfz * _selfz;
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t9 = 2.0 * Math.fma(_selfx, _selfw, -(_selfy * _selfz));
        double _t10 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        double _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-15;
        if (_t12 < _t14) {
            dest.putDouble(destOffset + 8, Math.atan2(2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t3), 1.0)));
            dest.putDouble(destOffset + 16, 0.0);
        } else {
            dest.putDouble(destOffset + 8, Math.atan2(_t8, _t10));
            dest.putDouble(destOffset + 16, Math.atan2(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t3), 1.0)));
        }
        dest.putDouble(destOffset + 0, Math.asin(Math.min(1.0, Math.max(-1.0, _t9))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesYZX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, Math.atan2(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(2.0 * Math.fma(_selfx, _selfw, -(_selfy * _selfz)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0)));
            dest.putDouble(destOffset + 8, Math.atan2(_t8, _t9));
        }
        dest.putDouble(destOffset + 16, Math.asin(Math.min(1.0, Math.max(-1.0, _t7))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZXY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t1 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _t1), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        double _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, Math.atan2(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0, Math.fma(_selfy, _selfy, _t1), 1.0)));
        } else {
            dest.putDouble(destOffset + 8, Math.atan2(2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
            dest.putDouble(destOffset + 16, Math.atan2(_t8, _t9));
        }
        dest.putDouble(destOffset + 0, Math.asin(Math.min(1.0, Math.max(-1.0, _t7))));
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer getEulerAnglesZYX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = _selfz * _selfz;
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _t0), 1.0);
        double _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        double _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-15;
        if (_t11 < _t13) {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 16, Math.atan2(2.0 * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0, Math.fma(_selfx, _selfx, _t0), 1.0)));
        } else {
            dest.putDouble(destOffset + 0, Math.atan2(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz), Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0)));
            dest.putDouble(destOffset + 16, Math.atan2(_t7, _t9));
        }
        dest.putDouble(destOffset + 8, Math.asin(Math.min(1.0, Math.max(-1.0, _t8))));
        return dest;
    }

    public static java.nio.ByteBuffer integrate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.integrate_unsafe(_destBase, _srcBase, angularVelX, angularVelY, angularVelZ, dt);
        return dest;
    }

    public static java.nio.ByteBuffer integrate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angularVelX, double angularVelY, double angularVelZ, double dt) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static java.nio.ByteBuffer integrate_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer angularVel, int angularVelOffset, double dt) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _angularVelBase = UnsafeOpsHolder.U.getLong(angularVel, UnsafeCopy.BB_ADDRESS_OFFSET) + angularVelOffset;
        DoubleQuatOpsKernelsAddress.integrate_unsafe(_destBase, _srcBase, _angularVelBase, dt);
        return dest;
    }

    public static java.nio.ByteBuffer integrate_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer angularVel, int angularVelOffset, double dt) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _angularVelx = angularVel.getDouble(angularVelOffset + 0);
        double _angularVely = angularVel.getDouble(angularVelOffset + 8);
        double _angularVelz = angularVel.getDouble(angularVelOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static java.nio.ByteBuffer invNegativeX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNegativeX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, -(_t9 * _t13));
            dest.putDouble(destOffset + 8, -(_t8 * _t13));
            dest.putDouble(destOffset + 16, -(_t7 * _t13));
        } else {
            dest.putDouble(destOffset + 0, -0.0);
            dest.putDouble(destOffset + 8, -0.0);
            dest.putDouble(destOffset + 16, -0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer invNegativeY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNegativeY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, -(_t7 * _t13));
            dest.putDouble(destOffset + 8, -(_t9 * _t13));
            dest.putDouble(destOffset + 16, -(_t8 * _t13));
        } else {
            dest.putDouble(destOffset + 0, -0.0);
            dest.putDouble(destOffset + 8, -0.0);
            dest.putDouble(destOffset + 16, -0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer invNegativeZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNegativeZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, -(_t8 * _t13));
            dest.putDouble(destOffset + 8, -(_t7 * _t13));
            dest.putDouble(destOffset + 16, -(_t9 * _t13));
        } else {
            dest.putDouble(destOffset + 0, -0.0);
            dest.putDouble(destOffset + 8, -0.0);
            dest.putDouble(destOffset + 16, -0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedNegativeX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNormalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedNegativeX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0));
        dest.putDouble(destOffset + 8, -(2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        dest.putDouble(destOffset + 16, -(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedNegativeY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNormalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedNegativeY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, -(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        dest.putDouble(destOffset + 8, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0));
        dest.putDouble(destOffset + 16, -(2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedNegativeZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNormalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedNegativeZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, -(2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        dest.putDouble(destOffset + 8, -(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        dest.putDouble(destOffset + 16, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0));
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedPositiveX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNormalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedPositiveX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw));
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedPositiveY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNormalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedPositiveY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw));
        dest.putDouble(destOffset + 8, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedPositiveZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invNormalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invNormalizedPositiveZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.putDouble(destOffset + 16, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer invPositiveX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invPositiveX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, _t9 * _t13);
            dest.putDouble(destOffset + 8, _t8 * _t13);
            dest.putDouble(destOffset + 16, _t7 * _t13);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer invPositiveY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invPositiveY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, _t7 * _t13);
            dest.putDouble(destOffset + 8, _t9 * _t13);
            dest.putDouble(destOffset + 16, _t8 * _t13);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer invPositiveZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.invPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer invPositiveZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, _t8 * _t13);
            dest.putDouble(destOffset + 8, _t7 * _t13);
            dest.putDouble(destOffset + 16, _t9 * _t13);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static double length_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return DoubleQuatOpsKernelsAddress.length_unsafe(_srcBase);
    }

    public static double length_api(java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        return Math.sqrt(Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy))));
    }

    public static double lengthSquared_unsafe(java.nio.ByteBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        return DoubleQuatOpsKernelsAddress.lengthSquared_unsafe(_srcBase);
    }

    public static double lengthSquared_api(java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        return Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    public static java.nio.ByteBuffer log_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.log_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer log_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = Math.fma(_selfw, _selfw, _t2);
        double _t8 = Math.acos(_selfw * (1.0 / Math.sqrt(_t4))) * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.putDouble(destOffset + 0, _selfx * _t8);
            dest.putDouble(destOffset + 8, _selfy * _t8);
            dest.putDouble(destOffset + 16, _selfz * _t8);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        dest.putDouble(destOffset + 24, Math.log(Math.sqrt(_t4)));
        return dest;
    }

    public static java.nio.ByteBuffer negativeX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.negativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negativeX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, -(_t9 * _t13));
            dest.putDouble(destOffset + 8, -(_t7 * _t13));
            dest.putDouble(destOffset + 16, -(_t8 * _t13));
        } else {
            dest.putDouble(destOffset + 0, -0.0);
            dest.putDouble(destOffset + 8, -0.0);
            dest.putDouble(destOffset + 16, -0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer negativeY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.negativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negativeY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, -(_t8 * _t13));
            dest.putDouble(destOffset + 8, -(_t9 * _t13));
            dest.putDouble(destOffset + 16, -(_t7 * _t13));
        } else {
            dest.putDouble(destOffset + 0, -0.0);
            dest.putDouble(destOffset + 8, -0.0);
            dest.putDouble(destOffset + 16, -0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer negativeZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.negativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer negativeZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, -(_t7 * _t13));
            dest.putDouble(destOffset + 8, -(_t8 * _t13));
            dest.putDouble(destOffset + 16, -(_t9 * _t13));
        } else {
            dest.putDouble(destOffset + 0, -0.0);
            dest.putDouble(destOffset + 8, -0.0);
            dest.putDouble(destOffset + 16, -0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer normalize_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalize_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalize_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest.putDouble(destOffset + 0, _selfx * _t4);
            dest.putDouble(destOffset + 8, _selfy * _t4);
            dest.putDouble(destOffset + 16, _selfz * _t4);
            dest.putDouble(destOffset + 24, _selfw * _t4);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer normalizedNegativeX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalizedNegativeX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0));
        dest.putDouble(destOffset + 8, -(2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        dest.putDouble(destOffset + 16, -(2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        return dest;
    }

    public static java.nio.ByteBuffer normalizedNegativeY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalizedNegativeY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, -(2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        dest.putDouble(destOffset + 8, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0));
        dest.putDouble(destOffset + 16, -(2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        return dest;
    }

    public static java.nio.ByteBuffer normalizedNegativeZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalizedNegativeZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, -(2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        dest.putDouble(destOffset + 8, -(2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        dest.putDouble(destOffset + 16, Math.fma(2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0));
        return dest;
    }

    public static java.nio.ByteBuffer normalizedPositiveX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalizedPositiveX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        return dest;
    }

    public static java.nio.ByteBuffer normalizedPositiveY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalizedPositiveY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        dest.putDouble(destOffset + 8, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0));
        dest.putDouble(destOffset + 16, 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz));
        return dest;
    }

    public static java.nio.ByteBuffer normalizedPositiveZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.normalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer normalizedPositiveZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        dest.putDouble(destOffset + 0, 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw));
        dest.putDouble(destOffset + 8, 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.putDouble(destOffset + 16, Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0));
        return dest;
    }

    public static java.nio.ByteBuffer positiveX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.positiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer positiveX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfy, _selfz * _selfw);
        double _t8 = 2.0 * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, _t9 * _t13);
            dest.putDouble(destOffset + 8, _t7 * _t13);
            dest.putDouble(destOffset + 16, _t8 * _t13);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer positiveY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.positiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer positiveY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfw, _selfy * _selfz);
        double _t8 = 2.0 * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0);
        double _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, _t8 * _t13);
            dest.putDouble(destOffset + 8, _t9 * _t13);
            dest.putDouble(destOffset + 16, _t7 * _t13);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer positiveZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.positiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.ByteBuffer positiveZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t7 = 2.0 * Math.fma(_selfx, _selfz, _selfy * _selfw);
        double _t8 = 2.0 * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        double _t9 = Math.fma(-2.0, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0);
        double _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        double _t13 = (1.0 / Math.sqrt(_t12));
        if (_t12 > 0.0) {
            dest.putDouble(destOffset + 0, _t7 * _t13);
            dest.putDouble(destOffset + 8, _t8 * _t13);
            dest.putDouble(destOffset + 16, _t9 * _t13);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer pow_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.pow_unsafe(_destBase, _srcBase, t);
        return dest;
    }

    public static java.nio.ByteBuffer pow_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double t) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
            dest.putDouble(destOffset + 0, _t20 * _t29);
            dest.putDouble(destOffset + 8, _t21 * _t29);
            dest.putDouble(destOffset + 16, _t19 * _t29);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
        }
        dest.putDouble(destOffset + 24, Math.cos(_t25) * _t11);
        return dest;
    }

    public static java.nio.ByteBuffer rotateTowards_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double step) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateTowards_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, step);
        return dest;
    }

    public static java.nio.ByteBuffer rotateTowards_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double targetX, double targetY, double targetZ, double targetW, double step) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
            dest.putDouble(destOffset + 0, _t54 * _t48);
            dest.putDouble(destOffset + 8, _t54 * _t49);
            dest.putDouble(destOffset + 16, _t54 * _t47);
            dest.putDouble(destOffset + 24, _t54 * _t46);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer rotateTowards_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double step) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _targetBase = UnsafeOpsHolder.U.getLong(target, UnsafeCopy.BB_ADDRESS_OFFSET) + targetOffset;
        DoubleQuatOpsKernelsAddress.rotateTowards_unsafe(_destBase, _srcBase, _targetBase, step);
        return dest;
    }

    public static java.nio.ByteBuffer rotateTowards_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer target, int targetOffset, double step) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _targetx = target.getDouble(targetOffset + 0);
        double _targety = target.getDouble(targetOffset + 8);
        double _targetz = target.getDouble(targetOffset + 16);
        double _targetw = target.getDouble(targetOffset + 24);
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
            dest.putDouble(destOffset + 0, _t54 * _t48);
            dest.putDouble(destOffset + 8, _t54 * _t49);
            dest.putDouble(destOffset + 16, _t54 * _t47);
            dest.putDouble(destOffset + 24, _t54 * _t46);
        } else {
            dest.putDouble(destOffset + 0, 0.0);
            dest.putDouble(destOffset + 8, 0.0);
            dest.putDouble(destOffset + 16, 0.0);
            dest.putDouble(destOffset + 24, 0.0);
        }
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + dirOffset;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + upOffset;
        DoubleQuatOpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.ByteBuffer lookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _dirx = dir.getDouble(dirOffset + 0);
        double _diry = dir.getDouble(dirOffset + 8);
        double _dirz = dir.getDouble(dirOffset + 16);
        double _upx = up.getDouble(upOffset + 0);
        double _upy = up.getDouble(upOffset + 8);
        double _upz = up.getDouble(upOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_api(java.nio.ByteBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, axisX * _t1);
        dest.putDouble(destOffset + 8, axisY * _t1);
        dest.putDouble(destOffset + 16, axisZ * _t1);
        dest.putDouble(destOffset + 24, Math.cos(_t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        DoubleQuatOpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
        double _t0 = 0.5 * angle;
        double _t1 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, _axisx * _t1);
        dest.putDouble(destOffset + 8, _axisy * _t1);
        dest.putDouble(destOffset + 16, _axisz * _t1);
        dest.putDouble(destOffset + 24, Math.cos(_t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_api(java.nio.ByteBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
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
            dest.putDouble(destOffset + 0, 0.5 * _t55 * _t64);
            dest.putDouble(destOffset + 8, 0.5 * _t38 * _t64);
            dest.putDouble(destOffset + 16, 0.5 * _t58 * _t64);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t61));
                dest.putDouble(destOffset + 8, 0.5 * _t57 * _t67);
                dest.putDouble(destOffset + 16, 0.5 * _t37 * _t67);
                dest.putDouble(destOffset + 24, 0.5 * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    dest.putDouble(destOffset + 0, 0.5 * _t57 * _t65);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t62));
                    dest.putDouble(destOffset + 16, 0.5 * _t54 * _t65);
                    dest.putDouble(destOffset + 24, 0.5 * _t38 * _t65);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t37 * _t66);
                    dest.putDouble(destOffset + 8, 0.5 * _t54 * _t66);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t63));
                    dest.putDouble(destOffset + 24, 0.5 * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + dirOffset;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + upOffset;
        DoubleQuatOpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationLookAlong_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer dir, int dirOffset, java.nio.ByteBuffer up, int upOffset) {
        double _dirx = dir.getDouble(dirOffset + 0);
        double _diry = dir.getDouble(dirOffset + 8);
        double _dirz = dir.getDouble(dirOffset + 16);
        double _upx = up.getDouble(upOffset + 0);
        double _upy = up.getDouble(upOffset + 8);
        double _upz = up.getDouble(upOffset + 16);
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
            dest.putDouble(destOffset + 0, 0.5 * _t55 * _t64);
            dest.putDouble(destOffset + 8, 0.5 * _t38 * _t64);
            dest.putDouble(destOffset + 16, 0.5 * _t58 * _t64);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                dest.putDouble(destOffset + 0, 0.5 * Math.sqrt(_t61));
                dest.putDouble(destOffset + 8, 0.5 * _t57 * _t67);
                dest.putDouble(destOffset + 16, 0.5 * _t37 * _t67);
                dest.putDouble(destOffset + 24, 0.5 * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    dest.putDouble(destOffset + 0, 0.5 * _t57 * _t65);
                    dest.putDouble(destOffset + 8, 0.5 * Math.sqrt(_t62));
                    dest.putDouble(destOffset + 16, 0.5 * _t54 * _t65);
                    dest.putDouble(destOffset + 24, 0.5 * _t38 * _t65);
                } else {
                    dest.putDouble(destOffset + 0, 0.5 * _t37 * _t66);
                    dest.putDouble(destOffset + 8, 0.5 * _t54 * _t66);
                    dest.putDouble(destOffset + 16, 0.5 * Math.sqrt(_t63));
                    dest.putDouble(destOffset + 24, 0.5 * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationTo_unsafe(java.nio.ByteBuffer dest, int destOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationTo_unsafe(_destBase, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationTo_api(java.nio.ByteBuffer dest, int destOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
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
            dest.putDouble(destOffset + 0, Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11);
            dest.putDouble(destOffset + 8, Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11);
            dest.putDouble(destOffset + 16, Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0) {
                dest.putDouble(destOffset + 0, _t15 * _t6);
                dest.putDouble(destOffset + 8, _t15 * _t9);
                dest.putDouble(destOffset + 16, _t15 * _t8);
                dest.putDouble(destOffset + 24, 0.0);
            } else {
                dest.putDouble(destOffset + 0, 0.0);
                dest.putDouble(destOffset + 8, 0.0);
                dest.putDouble(destOffset + 16, 0.0);
                dest.putDouble(destOffset + 24, 0.0);
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationTo_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer fromDir, int fromDirOffset, java.nio.ByteBuffer toDir, int toDirOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _fromDirBase = UnsafeOpsHolder.U.getLong(fromDir, UnsafeCopy.BB_ADDRESS_OFFSET) + fromDirOffset;
        long _toDirBase = UnsafeOpsHolder.U.getLong(toDir, UnsafeCopy.BB_ADDRESS_OFFSET) + toDirOffset;
        DoubleQuatOpsKernelsAddress.makeRotationTo_unsafe(_destBase, _fromDirBase, _toDirBase);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationTo_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer fromDir, int fromDirOffset, java.nio.ByteBuffer toDir, int toDirOffset) {
        double _fromDirx = fromDir.getDouble(fromDirOffset + 0);
        double _fromDiry = fromDir.getDouble(fromDirOffset + 8);
        double _fromDirz = fromDir.getDouble(fromDirOffset + 16);
        double _toDirx = toDir.getDouble(toDirOffset + 0);
        double _toDiry = toDir.getDouble(toDirOffset + 8);
        double _toDirz = toDir.getDouble(toDirOffset + 16);
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
            dest.putDouble(destOffset + 0, Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t11);
            dest.putDouble(destOffset + 8, Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t11);
            dest.putDouble(destOffset + 16, Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t11);
            dest.putDouble(destOffset + 24, 0.5 * Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0) {
                dest.putDouble(destOffset + 0, _t15 * _t6);
                dest.putDouble(destOffset + 8, _t15 * _t9);
                dest.putDouble(destOffset + 16, _t15 * _t8);
                dest.putDouble(destOffset + 24, 0.0);
            } else {
                dest.putDouble(destOffset + 0, 0.0);
                dest.putDouble(destOffset + 8, 0.0);
                dest.putDouble(destOffset + 16, 0.0);
                dest.putDouble(destOffset + 24, 0.0);
            }
        }
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationX_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationX_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = 0.5 * angle;
        dest.putDouble(destOffset + 0, Math.sin(_t0));
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, Math.cos(_t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXYZ_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
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
        dest.putDouble(destOffset + 0, Math.fma(_t9, _t5, _t10 * _t8));
        dest.putDouble(destOffset + 8, Math.fma(_t10, _t5, -(_t9 * _t8)));
        dest.putDouble(destOffset + 16, Math.fma(_t11, _t5, _t12 * _t8));
        dest.putDouble(destOffset + 24, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationXZY_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
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
        dest.putDouble(destOffset + 0, Math.fma(_t9, _t5, -(_t10 * _t8)));
        dest.putDouble(destOffset + 8, Math.fma(_t11, _t8, -(_t12 * _t5)));
        dest.putDouble(destOffset + 16, Math.fma(_t9, _t8, _t10 * _t5));
        dest.putDouble(destOffset + 24, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationY_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationY_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = 0.5 * angle;
        dest.putDouble(destOffset + 0, 0.0);
        dest.putDouble(destOffset + 8, Math.sin(_t0));
        dest.putDouble(destOffset + 16, 0.0);
        dest.putDouble(destOffset + 24, Math.cos(_t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYXZ_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
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
        dest.putDouble(destOffset + 0, Math.fma(_t9, _t5, _t10 * _t8));
        dest.putDouble(destOffset + 8, Math.fma(_t10, _t5, -(_t9 * _t8)));
        dest.putDouble(destOffset + 16, Math.fma(_t11, _t8, -(_t12 * _t5)));
        dest.putDouble(destOffset + 24, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationYZX_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
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
        dest.putDouble(destOffset + 0, Math.fma(_t9, _t5, _t10 * _t8));
        dest.putDouble(destOffset + 8, Math.fma(_t11, _t5, _t12 * _t8));
        dest.putDouble(destOffset + 16, Math.fma(_t12, _t5, -(_t11 * _t8)));
        dest.putDouble(destOffset + 24, Math.fma(_t10, _t5, -(_t9 * _t8)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZ_unsafe(java.nio.ByteBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationZ_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZ_api(java.nio.ByteBuffer dest, int destOffset, double angle) {
        double _t0 = 0.5 * angle;
        dest.putDouble(destOffset + 0, 0.0);
        dest.putDouble(destOffset + 8, 0.0);
        dest.putDouble(destOffset + 16, Math.sin(_t0));
        dest.putDouble(destOffset + 24, Math.cos(_t0));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZXY_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
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
        dest.putDouble(destOffset + 0, Math.fma(_t9, _t5, -(_t10 * _t8)));
        dest.putDouble(destOffset + 8, Math.fma(_t11, _t5, _t12 * _t8));
        dest.putDouble(destOffset + 16, Math.fma(_t9, _t8, _t10 * _t5));
        dest.putDouble(destOffset + 24, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        DoubleQuatOpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer makeRotationZYX_api(java.nio.ByteBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
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
        dest.putDouble(destOffset + 0, Math.fma(_t9, _t5, -(_t10 * _t8)));
        dest.putDouble(destOffset + 8, Math.fma(_t11, _t8, _t12 * _t5));
        dest.putDouble(destOffset + 16, Math.fma(_t12, _t8, -(_t11 * _t5)));
        dest.putDouble(destOffset + 24, Math.fma(_t10, _t5, _t9 * _t8));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, _selfw * _t2));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, -(_selfz * _t2)));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t2, _selfz * _t1));
        dest.putDouble(destOffset + 24, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, _selfz * _t2));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, _selfw * _t2));
        dest.putDouble(destOffset + 16, Math.fma(_selfz, _t1, -(_selfx * _t2)));
        dest.putDouble(destOffset + 24, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer preRotateZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.preRotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer preRotateZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, -(_selfy * _t2)));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t2, _selfy * _t1));
        dest.putDouble(destOffset + 16, Math.fma(_selfz, _t1, _selfw * _t2));
        dest.putDouble(destOffset + 24, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = axisX * _t2;
        double _t4 = axisZ * _t2;
        double _t5 = axisY * _t2;
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + axisOffset;
        DoubleQuatOpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateAxis_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer axis, int axisOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _axisx = axis.getDouble(axisOffset + 0);
        double _axisy = axis.getDouble(axisOffset + 8);
        double _axisz = axis.getDouble(axisOffset + 16);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        double _t3 = _axisx * _t2;
        double _t4 = _axisz * _t2;
        double _t5 = _axisy * _t2;
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateTo_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateTo_unsafe(_destBase, _srcBase, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateTo_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double fromDirX, double fromDirY, double fromDirZ, double toDirX, double toDirY, double toDirZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateTo_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer fromDir, int fromDirOffset, java.nio.ByteBuffer toDir, int toDirOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _fromDirBase = UnsafeOpsHolder.U.getLong(fromDir, UnsafeCopy.BB_ADDRESS_OFFSET) + fromDirOffset;
        long _toDirBase = UnsafeOpsHolder.U.getLong(toDir, UnsafeCopy.BB_ADDRESS_OFFSET) + toDirOffset;
        DoubleQuatOpsKernelsAddress.rotateTo_unsafe(_destBase, _srcBase, _fromDirBase, _toDirBase);
        return dest;
    }

    public static java.nio.ByteBuffer rotateTo_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer fromDir, int fromDirOffset, java.nio.ByteBuffer toDir, int toDirOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _fromDirx = fromDir.getDouble(fromDirOffset + 0);
        double _fromDiry = fromDir.getDouble(fromDirOffset + 8);
        double _fromDirz = fromDir.getDouble(fromDirOffset + 16);
        double _toDirx = toDir.getDouble(toDirOffset + 0);
        double _toDiry = toDir.getDouble(toDirOffset + 8);
        double _toDirz = toDir.getDouble(toDirOffset + 16);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, _selfw * _t2));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, _selfz * _t2));
        dest.putDouble(destOffset + 16, Math.fma(_selfz, _t1, -(_selfy * _t2)));
        dest.putDouble(destOffset + 24, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateXYZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXYZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateXZY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateXZY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, -(_selfz * _t2)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, _selfw * _t2));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t2, _selfz * _t1));
        dest.putDouble(destOffset + 24, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateYXZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYXZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t19, _selfw * _t20) + Math.fma(_selfy, _t21, -(_selfz * _t22)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t19, _selfz * _t20) + Math.fma(_selfw, _t22, -(_selfx * _t21)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t22, _selfw * _t21) + Math.fma(_selfz, _t19, -(_selfy * _t20)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t21, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t20)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateYZX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateYZX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZ_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angle) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t0 = 0.5 * angle;
        double _t1 = Math.cos(_t0);
        double _t2 = Math.sin(_t0);
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t1, _selfy * _t2));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t1, -(_selfx * _t2)));
        dest.putDouble(destOffset + 16, Math.fma(_selfz, _t1, _selfw * _t2));
        dest.putDouble(destOffset + 24, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZXY_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZXY_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t21, _selfw * _t22) + Math.fma(_selfy, _t19, -(_selfz * _t20)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t21, _selfz * _t22) + Math.fma(_selfw, _t20, -(_selfx * _t19)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t20, _selfw * _t19) + Math.fma(_selfz, _t21, -(_selfy * _t22)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t19, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t22)))));
        return dest;
    }

    public static java.nio.ByteBuffer rotateZYX_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.ByteBuffer rotateZYX_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
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
        dest.putDouble(destOffset + 0, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        dest.putDouble(destOffset + 8, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        dest.putDouble(destOffset + 24, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static java.nio.ByteBuffer transform_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.transform_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.ByteBuffer transform_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t9 = 2.0 * Math.fma(_selfx, vY, -(_selfy * vX));
        double _t10 = 2.0 * Math.fma(_selfz, vX, -(_selfx * vZ));
        double _t11 = 2.0 * Math.fma(_selfy, vZ, -(_selfz * vY));
        dest.putDouble(destOffset + 0, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, vX))));
        dest.putDouble(destOffset + 8, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vY))));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, vZ))));
        return dest;
    }

    public static java.nio.ByteBuffer transform_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        DoubleQuatOpsKernelsAddress.transform_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer transform_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        double _vz = v.getDouble(vOffset + 16);
        double _t9 = 2.0 * Math.fma(_selfx, _vy, -(_selfy * _vx));
        double _t10 = 2.0 * Math.fma(_selfz, _vx, -(_selfx * _vz));
        double _t11 = 2.0 * Math.fma(_selfy, _vz, -(_selfz * _vy));
        dest.putDouble(destOffset + 0, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, _vx))));
        dest.putDouble(destOffset + 8, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vy))));
        dest.putDouble(destOffset + 16, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, _vz))));
        return dest;
    }

    public static java.nio.ByteBuffer transformInverse_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        DoubleQuatOpsKernelsAddress.transformInverse_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.ByteBuffer transformInverse_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, double vX, double vY, double vZ) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _t9 = 2.0 * Math.fma(_selfx, vZ, -(_selfz * vX));
        double _t10 = 2.0 * Math.fma(_selfy, vX, -(_selfx * vY));
        double _t11 = 2.0 * Math.fma(_selfz, vY, -(_selfy * vZ));
        dest.putDouble(destOffset + 0, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, vX))));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, vY))));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vZ))));
        return dest;
    }

    public static java.nio.ByteBuffer transformInverse_unsafe(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + destOffset;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + srcOffset;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + vOffset;
        DoubleQuatOpsKernelsAddress.transformInverse_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.ByteBuffer transformInverse_api(java.nio.ByteBuffer dest, int destOffset, java.nio.ByteBuffer src, int srcOffset, java.nio.ByteBuffer v, int vOffset) {
        double _selfx = src.getDouble(srcOffset + 0);
        double _selfy = src.getDouble(srcOffset + 8);
        double _selfz = src.getDouble(srcOffset + 16);
        double _selfw = src.getDouble(srcOffset + 24);
        double _vx = v.getDouble(vOffset + 0);
        double _vy = v.getDouble(vOffset + 8);
        double _vz = v.getDouble(vOffset + 16);
        double _t9 = 2.0 * Math.fma(_selfx, _vz, -(_selfz * _vx));
        double _t10 = 2.0 * Math.fma(_selfy, _vx, -(_selfx * _vy));
        double _t11 = 2.0 * Math.fma(_selfz, _vy, -(_selfy * _vz));
        dest.putDouble(destOffset + 0, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, _vx))));
        dest.putDouble(destOffset + 8, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, _vy))));
        dest.putDouble(destOffset + 16, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vz))));
        return dest;
    }

}
