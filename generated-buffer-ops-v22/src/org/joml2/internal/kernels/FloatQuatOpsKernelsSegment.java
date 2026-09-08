package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link FloatQuatOps} whose leading storage
 * parameter is a {@link java.lang.foreign.MemorySegment}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code FloatQuatOps} and its sibling kernel units. Not public API.
 */
public final class FloatQuatOpsKernelsSegment {
    private FloatQuatOpsKernelsSegment() {}

    public static java.lang.foreign.MemorySegment invert_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invert_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t3_inv = 1.0f / _t3;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_selfx * _t3_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_selfy * _t3_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_selfz * _t3_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw * _t3_inv);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invertProduct_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invertProduct_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t21 = Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz));
        float _t22 = Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy));
        float _t23 = Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx));
        float _t24 = Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t21 * _t28_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t23 * _t28_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t22 * _t28_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t24 * _t28_inv);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invertProduct_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invertProduct_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        float _t21 = Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz));
        float _t22 = Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy));
        float _t23 = Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx));
        float _t24 = Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx))));
        float _t28 = Math.fma(_t24, _t24, Math.fma(_t22, _t22, Math.fma(_t23, _t23, _t21 * _t21)));
        float _t28_inv = 1.0f / _t28;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t21 * _t28_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t23 * _t28_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t22 * _t28_inv));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t24 * _t28_inv);
        return dest;
    }

    public static java.lang.foreign.MemorySegment add_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.add_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment add_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, otherX + _selfx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, otherY + _selfy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, otherZ + _selfz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, otherW + _selfw);
        return dest;
    }

    public static java.lang.foreign.MemorySegment add_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment add_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _otherx + _selfx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _othery + _selfy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _otherz + _selfz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _otherw + _selfw);
        return dest;
    }

    public static java.lang.foreign.MemorySegment negate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment negate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -_selfx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -_selfy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -_selfz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, -_selfw);
        return dest;
    }

    public static java.lang.foreign.MemorySegment sub_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.sub_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment sub_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx - otherX);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy - otherY);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz - otherZ);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw - otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment sub_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment sub_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx - _otherx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy - _othery);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz - _otherz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw - _otherw);
        return dest;
    }

    public static java.lang.foreign.MemorySegment set_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float vX, float vY, float vZ, float vW) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.set_unsafe(_destBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment set_api(java.lang.foreign.MemorySegment dest, long destOffset, float vX, float vY, float vZ, float vW) {
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, vX);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, vY);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, vZ);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, vW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment set_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _destBase = dest.address() + destOffset;
        long _vBase = v.address() + vOffset;
        FloatQuatOpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment set_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        float _vx = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 0L);
        float _vy = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 4L);
        float _vz = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 8L);
        float _vw = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _vx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _vy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _vz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _vw);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromDualQuat_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromDualQuat_api(java.lang.foreign.MemorySegment dest, long destOffset, float dqRX, float dqRY, float dqRZ, float dqRW, float dqDX, float dqDY, float dqDZ, float dqDW) {
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, dqRX);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, dqRY);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, dqRZ);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, dqRW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _destBase = dest.address() + destOffset;
        long _mBase = m.address() + mOffset;
        FloatQuatOpsKernelsAddress.makeFromMatrixMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x3_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 12L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 28L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t1 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t7 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t9 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * (float) Math.sqrt(_t15));
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t4 * _t21);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t6 * _t21);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t4 * _t19);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * (float) Math.sqrt(_t16));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t8 * _t19);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t7 * _t19);
                } else {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t6 * _t20);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t8 * _t20);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * (float) Math.sqrt(_t17));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _destBase = dest.address() + destOffset;
        long _mBase = m.address() + mOffset;
        FloatQuatOpsKernelsAddress.makeFromMatrixMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat3x4_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 36L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 40L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t1 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t7 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t9 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * (float) Math.sqrt(_t15));
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t4 * _t21);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t6 * _t21);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t4 * _t19);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * (float) Math.sqrt(_t16));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t8 * _t19);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t7 * _t19);
                } else {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t6 * _t20);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t8 * _t20);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * (float) Math.sqrt(_t17));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        long _destBase = dest.address() + destOffset;
        long _mBase = m.address() + mOffset;
        FloatQuatOpsKernelsAddress.makeFromMatrixMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeFromMatrixMat4x4_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment m, long mOffset) {
        float _m00 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 0L);
        float _m10 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 4L);
        float _m20 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 8L);
        float _m01 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 16L);
        float _m11 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 20L);
        float _m21 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 24L);
        float _m02 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 32L);
        float _m12 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 36L);
        float _m22 = m.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, mOffset + 40L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t1 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t7 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t9 * _t18);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t14));
        } else {
            if (_m00 > _t2) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * (float) Math.sqrt(_t15));
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t4 * _t21);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t6 * _t21);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t1 * _t21);
            } else {
                if (_m11 > _m22) {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t4 * _t19);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * (float) Math.sqrt(_t16));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t8 * _t19);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t7 * _t19);
                } else {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t6 * _t20);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t8 * _t20);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * (float) Math.sqrt(_t17));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t9 * _t20);
                }
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment toDualQuat_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment toDualQuat_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 16L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 20L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 24L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 28L, 0.0f);
        return dest;
    }

    public static java.lang.foreign.MemorySegment toMatrix_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.toMatrix_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment toMatrix_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfz * _selfw;
        float _t2 = _selfy * _selfw;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfx, _selfy, _t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfx, _selfz, -_t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 16L, 2.0f * Math.fma(_selfx, _selfy, -_t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 20L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 24L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 28L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 32L, 2.0f * Math.fma(_selfx, _selfz, _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 36L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 40L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 44L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 48L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 52L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 56L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 60L, 1.0f);
        return dest;
    }

    public static java.lang.foreign.MemorySegment toMatrix3x3_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.toMatrix3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment toMatrix3x3_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfz * _selfw;
        float _t2 = _selfy * _selfw;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfx, _selfy, _t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfx, _selfz, -_t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 2.0f * Math.fma(_selfx, _selfy, -_t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 16L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 20L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 24L, 2.0f * Math.fma(_selfx, _selfz, _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 28L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 32L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        return dest;
    }

    public static java.lang.foreign.MemorySegment toMatrix3x4_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.toMatrix3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment toMatrix3x4_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfz * _selfw;
        float _t2 = _selfy * _selfw;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfx, _selfy, -_t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfx, _selfz, _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 16L, 2.0f * Math.fma(_selfx, _selfy, _t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 20L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 24L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 28L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 32L, 2.0f * Math.fma(_selfx, _selfz, -_t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 36L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 40L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 44L, 0.0f);
        return dest;
    }

    public static java.lang.foreign.MemorySegment decomposeSwingTwist_unsafe(java.lang.foreign.MemorySegment swing, long swingOffset, java.lang.foreign.MemorySegment twist, long twistOffset, java.lang.foreign.MemorySegment src, long srcOffset, float axisX, float axisY, float axisZ) {
        long _swingBase = swing.address() + swingOffset;
        long _twistBase = twist.address() + twistOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.decomposeSwingTwist_unsafe(_swingBase, _twistBase, _srcBase, axisX, axisY, axisZ);
        return swing;
    }

    public static java.lang.foreign.MemorySegment decomposeSwingTwist_api(java.lang.foreign.MemorySegment swing, long swingOffset, java.lang.foreign.MemorySegment twist, long twistOffset, java.lang.foreign.MemorySegment src, long srcOffset, float axisX, float axisY, float axisZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 0L, _t12);
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 4L, _t13);
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 8L, _t14);
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 12L, _t11);
        return swing;
    }

    public static java.lang.foreign.MemorySegment decomposeSwingTwist_unsafe(java.lang.foreign.MemorySegment swing, long swingOffset, java.lang.foreign.MemorySegment twist, long twistOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        long _swingBase = swing.address() + swingOffset;
        long _twistBase = twist.address() + twistOffset;
        long _srcBase = src.address() + srcOffset;
        long _axisBase = axis.address() + axisOffset;
        FloatQuatOpsKernelsAddress.decomposeSwingTwist_unsafe(_swingBase, _twistBase, _srcBase, _axisBase);
        return swing;
    }

    public static java.lang.foreign.MemorySegment decomposeSwingTwist_api(java.lang.foreign.MemorySegment swing, long swingOffset, java.lang.foreign.MemorySegment twist, long twistOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L);
        float _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L);
        float _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L);
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
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        swing.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, swingOffset + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 0L, _t12);
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 4L, _t13);
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 8L, _t14);
        twist.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, twistOffset + 12L, _t11);
        return swing;
    }

    public static java.lang.foreign.MemorySegment getSwing_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float axisX, float axisY, float axisZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getSwing_unsafe(_destBase, _srcBase, axisX, axisY, axisZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getSwing_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float axisX, float axisY, float axisZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getSwing_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _axisBase = axis.address() + axisOffset;
        FloatQuatOpsKernelsAddress.getSwing_unsafe(_destBase, _srcBase, _axisBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getSwing_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L);
        float _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L);
        float _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t11, -(_selfw * _t12)) + Math.fma(_selfz, _t13, -(_selfy * _t14)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t14, -(_selfw * _t13)) + Math.fma(_selfy, _t11, -(_selfz * _t12)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t12, _selfz * _t11) + Math.fma(-_selfx, _t13, -(_selfw * _t14)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfz, _t14, Math.fma(_selfy, _t13, Math.fma(_selfx, _t12, _selfw * _t11))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getTwist_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float axisX, float axisY, float axisZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getTwist_unsafe(_destBase, _srcBase, axisX, axisY, axisZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getTwist_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float axisX, float axisY, float axisZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t2 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, axisX * _t6);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, axisY * _t6);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, axisZ * _t6);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw * _t5);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 1.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment getTwist_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _axisBase = axis.address() + axisOffset;
        FloatQuatOpsKernelsAddress.getTwist_unsafe(_destBase, _srcBase, _axisBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getTwist_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L);
        float _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L);
        float _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L);
        float _t2 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2 * _t2);
        float _t5 = (1.0f / (float) Math.sqrt(_t4));
        float _t6 = _t2 * _t5;
        if (_t4 > 1.0E-14f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _axisx * _t6);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _axisy * _t6);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _axisz * _t6);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw * _t5);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 1.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeIdentity_unsafe(java.lang.foreign.MemorySegment dest, long destOffset) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeIdentity_api(java.lang.foreign.MemorySegment dest, long destOffset) {
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 1.0f);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeZero_unsafe(java.lang.foreign.MemorySegment dest, long destOffset) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeZero_unsafe(_destBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeZero_api(java.lang.foreign.MemorySegment dest, long destOffset) {
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW, t);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW, float t) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(t, otherX - _selfx, _selfx));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(t, otherY - _selfy, _selfy));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(t, otherZ - _selfz, _selfz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(t, otherW - _selfw, _selfw));
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, float t) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lerp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset, float t) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(t, _otherx - _selfx, _selfx));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(t, _othery - _selfy, _selfy));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(t, _otherz - _selfz, _selfz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(t, _otherw - _selfw, _selfw));
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.nlerp_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t4 = Math.fma(alpha, targetW - _selfw, _selfw);
        float _t5 = Math.fma(alpha, targetZ - _selfz, _selfz);
        float _t6 = Math.fma(alpha, targetX - _selfx, _selfx);
        float _t7 = Math.fma(alpha, targetY - _selfy, _selfy);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t6 * _t12);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t7 * _t12);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t5 * _t12);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t4 * _t12);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        FloatQuatOpsKernelsAddress.nlerp_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
        float _t4 = Math.fma(alpha, _targetw - _selfw, _selfw);
        float _t5 = Math.fma(alpha, _targetz - _selfz, _selfz);
        float _t6 = Math.fma(alpha, _targetx - _selfx, _selfx);
        float _t7 = Math.fma(alpha, _targety - _selfy, _selfy);
        float _t11 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, Math.fma(_t6, _t6, _t7 * _t7)));
        float _t12 = (1.0f / (float) Math.sqrt(_t11));
        if (_t11 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t6 * _t12);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t7 * _t12);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t5 * _t12);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t4 * _t12);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.nlerpShortest_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t19 * _t25);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t20 * _t25);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t18 * _t25);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t17 * _t25);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        FloatQuatOpsKernelsAddress.nlerpShortest_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment nlerpShortest_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t19 * _t25);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t20 * _t25);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t18 * _t25);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t17 * _t25);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.slerp_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_selfw, targetW, Math.fma(_selfz, targetZ, Math.fma(_selfx, targetX, _selfy * targetY))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t13, targetX * _t11) * _t8_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t13, targetY * _t11) * _t8_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfz, _t13, targetZ * _t11) * _t8_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t13, targetW * _t11) * _t8_inv);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(alpha, targetX, _selfx * _t0));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(alpha, targetY, _selfy * _t0));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(alpha, targetZ, _selfz * _t0));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(alpha, targetW, _selfw * _t0));
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        FloatQuatOpsKernelsAddress.slerp_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
        float _t0 = 1.0f - alpha;
        float _t7 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_selfw, _targetw, Math.fma(_selfz, _targetz, Math.fma(_selfx, _targetx, _selfy * _targety))))));
        float _t8 = (float) Math.sin(_t7);
        float _t8_inv = 1.0f / _t8;
        float _t9 = Math.abs(_t8);
        float _t11 = (float) Math.sin(alpha * _t7);
        float _t13 = (float) Math.sin(_t0 * _t7);
        if (_t9 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t13, _targetx * _t11) * _t8_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t13, _targety * _t11) * _t8_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfz, _t13, _targetz * _t11) * _t8_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t13, _targetw * _t11) * _t8_inv);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(alpha, _targetx, _selfx * _t0));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(alpha, _targety, _selfy * _t0));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(alpha, _targetz, _selfz * _t0));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(alpha, _targetw, _selfw * _t0));
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.slerpShortest_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t50 * _t44);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t50 * _t45);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t50 * _t43);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t50 * _t42);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        FloatQuatOpsKernelsAddress.slerpShortest_unsafe(_destBase, _srcBase, _targetBase, alpha);
        return dest;
    }

    public static java.lang.foreign.MemorySegment slerpShortest_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float alpha) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t50 * _t44);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t50 * _t45);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t50 * _t43);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t50 * _t42);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment squad_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float control0X, float control0Y, float control0Z, float control0W, float control1X, float control1Y, float control1Z, float control1W, float targetX, float targetY, float targetZ, float targetW, float t) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.squad_unsafe(_destBase, _srcBase, control0X, control0Y, control0Z, control0W, control1X, control1Y, control1Z, control1W, targetX, targetY, targetZ, targetW, t);
        return dest;
    }

    public static java.lang.foreign.MemorySegment squad_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float control0X, float control0Y, float control0Z, float control0W, float control1X, float control1Y, float control1Z, float control1W, float targetX, float targetY, float targetZ, float targetW, float t) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        if (_t37 > 0.0f) {
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
        if (_t39 > 0.0f) {
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
        if (_t87 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t14, _t76, _t13 * _t75));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t14, _t78, _t13 * _t77));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t14, _t74, _t13 * _t73));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment squad_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment control0, long control0Offset, java.lang.foreign.MemorySegment control1, long control1Offset, java.lang.foreign.MemorySegment target, long targetOffset, float t) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _control0Base = control0.address() + control0Offset;
        long _control1Base = control1.address() + control1Offset;
        long _targetBase = target.address() + targetOffset;
        FloatQuatOpsKernelsAddress.squad_unsafe(_destBase, _srcBase, _control0Base, _control1Base, _targetBase, t);
        return dest;
    }

    public static java.lang.foreign.MemorySegment squad_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment control0, long control0Offset, java.lang.foreign.MemorySegment control1, long control1Offset, java.lang.foreign.MemorySegment target, long targetOffset, float t) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _control0x = control0.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control0Offset + 0L);
        float _control0y = control0.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control0Offset + 4L);
        float _control0z = control0.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control0Offset + 8L);
        float _control0w = control0.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control0Offset + 12L);
        float _control1x = control1.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control1Offset + 0L);
        float _control1y = control1.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control1Offset + 4L);
        float _control1z = control1.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control1Offset + 8L);
        float _control1w = control1.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, control1Offset + 12L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
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
        if (_t37 > 0.0f) {
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
        if (_t39 > 0.0f) {
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
        if (_t87 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t91, _t76, _t89 * _t75) * _t86_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t91, _t78, _t89 * _t77) * _t86_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t91, _t74, _t89 * _t73) * _t86_inv);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t91, _t72, _t89 * _t71) * _t86_inv);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t14, _t76, _t13 * _t75));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t14, _t78, _t13 * _t77));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t14, _t74, _t13 * _t73));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t14, _t72, _t13 * _t71));
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.mul_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherZ, _selfy, -(otherY * _selfz)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(otherX, _selfz, otherW * _selfy) + Math.fma(otherY, _selfw, -(otherZ * _selfx)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(otherY, _selfx, otherZ * _selfw) + Math.fma(otherW, _selfz, -(otherX * _selfy)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment mul_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_otherz, _selfy, -(_othery * _selfz)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_otherx, _selfz, _otherw * _selfy) + Math.fma(_othery, _selfw, -(_otherz * _selfx)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_othery, _selfx, _otherz * _selfw) + Math.fma(_otherw, _selfz, -(_otherx * _selfy)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(otherX, _selfw, otherW * _selfx) + Math.fma(otherY, _selfz, -(otherZ * _selfy)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(otherY, _selfw, otherZ * _selfx) + Math.fma(otherW, _selfy, -(otherX * _selfz)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(otherX, _selfy, otherW * _selfz) + Math.fma(otherZ, _selfw, -(otherY * _selfx)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-otherZ, _selfz, Math.fma(-otherY, _selfy, Math.fma(otherW, _selfw, -(otherX * _selfx)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preMul_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_otherx, _selfw, _otherw * _selfx) + Math.fma(_othery, _selfz, -(_otherz * _selfy)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_othery, _selfw, _otherz * _selfx) + Math.fma(_otherw, _selfy, -(_otherx * _selfz)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_otherx, _selfy, _otherw * _selfz) + Math.fma(_otherz, _selfw, -(_othery * _selfx)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_otherz, _selfz, Math.fma(-_othery, _selfy, Math.fma(_otherw, _selfw, -(_otherx * _selfx)))));
        return dest;
    }

    public static float angle_unsafe(java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        return FloatQuatOpsKernelsAddress.angle_unsafe(_srcBase);
    }

    public static float angle_api(java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, _selfw)));
    }

    public static float angleTo_unsafe(java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _srcBase = src.address() + srcOffset;
        return FloatQuatOpsKernelsAddress.angleTo_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static float angleTo_api(java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy))))));
    }

    public static float angleTo_unsafe(java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        return FloatQuatOpsKernelsAddress.angleTo_unsafe(_srcBase, _otherBase);
    }

    public static float angleTo_api(java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        return 2.0f * (float) Math.acos(Math.min(1.0f, Math.abs(Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy))))));
    }

    public static java.lang.foreign.MemorySegment axis_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.axis_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment axis_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t3 = (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx * _t3);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy * _t3);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz * _t3);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment calculateW_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.calculateW_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment calculateW_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.sqrt(Math.max(0.0f, Math.fma(-_selfx, _selfx, Math.fma(-_selfy, _selfy, Math.fma(-_selfz, _selfz, 1.0f))))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment conjugate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.conjugate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment conjugate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -_selfx);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -_selfy);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -_selfz);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw);
        return dest;
    }

    public static java.lang.foreign.MemorySegment conjugateBy_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float qX, float qY, float qZ, float qW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.conjugateBy_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment conjugateBy_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float qX, float qY, float qZ, float qW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t1 = -qY;
        float _t21 = Math.fma(qX, _selfy, qW * _selfz) + Math.fma(qZ, _selfw, -(qY * _selfx));
        float _t22 = Math.fma(qY, _selfw, qZ * _selfx) + Math.fma(qW, _selfy, -(qX * _selfz));
        float _t23 = Math.fma(qX, _selfw, qW * _selfx) + Math.fma(qY, _selfz, -(qZ * _selfy));
        float _t24 = Math.fma(-qZ, _selfz, Math.fma(_t1, _selfy, Math.fma(qW, _selfw, -(qX * _selfx))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(qY, _t21, -(qZ * _t22)) + Math.fma(qW, _t23, -(qX * _t24)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(qZ, _t23, -(qY * _t24)) + Math.fma(qW, _t22, -(qX * _t21)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(qX, _t22, qW * _t21) + Math.fma(_t1, _t23, -(qZ * _t24)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(qZ, _t21, Math.fma(qY, _t22, Math.fma(qX, _t23, qW * _t24))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment conjugateBy_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _qBase = q.address() + qOffset;
        FloatQuatOpsKernelsAddress.conjugateBy_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment conjugateBy_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment q, long qOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _qx = q.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, qOffset + 0L);
        float _qy = q.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, qOffset + 4L);
        float _qz = q.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, qOffset + 8L);
        float _qw = q.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, qOffset + 12L);
        float _t1 = -_qy;
        float _t21 = Math.fma(_qx, _selfy, _qw * _selfz) + Math.fma(_qz, _selfw, -(_qy * _selfx));
        float _t22 = Math.fma(_qy, _selfw, _qz * _selfx) + Math.fma(_qw, _selfy, -(_qx * _selfz));
        float _t23 = Math.fma(_qx, _selfw, _qw * _selfx) + Math.fma(_qy, _selfz, -(_qz * _selfy));
        float _t24 = Math.fma(-_qz, _selfz, Math.fma(_t1, _selfy, Math.fma(_qw, _selfw, -(_qx * _selfx))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_qy, _t21, -(_qz * _t22)) + Math.fma(_qw, _t23, -(_qx * _t24)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_qz, _t23, -(_qy * _t24)) + Math.fma(_qw, _t22, -(_qx * _t21)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_qx, _t22, _qw * _t21) + Math.fma(_t1, _t23, -(_qz * _t24)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_qz, _t21, Math.fma(_qy, _t22, Math.fma(_qx, _t23, _qw * _t24))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.difference_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t3_inv = 1.0f / _t3;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (Math.fma(otherX, _selfw, -(otherW * _selfx)) + Math.fma(otherY, _selfz, -(otherZ * _selfy))) * _t3_inv);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(otherW * _selfy * _t3_inv) - otherX * _selfz * _t3_inv + Math.fma(otherY, _selfw, otherZ * _selfx) * _t3_inv);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (Math.fma(otherX, _selfy, -(otherW * _selfz)) + Math.fma(otherZ, _selfw, -(otherY * _selfx))) * _t3_inv);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(otherZ, _selfz, Math.fma(otherY, _selfy, Math.fma(otherX, _selfx, otherW * _selfw))) * _t3_inv);
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        FloatQuatOpsKernelsAddress.difference_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment difference_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t3_inv = 1.0f / _t3;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (Math.fma(_otherx, _selfw, -(_otherw * _selfx)) + Math.fma(_othery, _selfz, -(_otherz * _selfy))) * _t3_inv);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_otherw * _selfy * _t3_inv) - _otherx * _selfz * _t3_inv + Math.fma(_othery, _selfw, _otherz * _selfx) * _t3_inv);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (Math.fma(_otherx, _selfy, -(_otherw * _selfz)) + Math.fma(_otherz, _selfw, -(_othery * _selfx))) * _t3_inv);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_otherz, _selfz, Math.fma(_othery, _selfy, Math.fma(_otherx, _selfx, _otherw * _selfw))) * _t3_inv);
        return dest;
    }

    public static float dot_unsafe(java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        long _srcBase = src.address() + srcOffset;
        return FloatQuatOpsKernelsAddress.dot_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static float dot_api(java.lang.foreign.MemorySegment src, long srcOffset, float otherX, float otherY, float otherZ, float otherW) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        return Math.fma(otherW, _selfw, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)));
    }

    public static float dot_unsafe(java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        long _srcBase = src.address() + srcOffset;
        long _otherBase = other.address() + otherOffset;
        return FloatQuatOpsKernelsAddress.dot_unsafe(_srcBase, _otherBase);
    }

    public static float dot_api(java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment other, long otherOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _otherx = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 0L);
        float _othery = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 4L);
        float _otherz = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 8L);
        float _otherw = other.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, otherOffset + 12L);
        return Math.fma(_otherw, _selfw, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)));
    }

    public static java.lang.foreign.MemorySegment exp_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.exp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment exp_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = (float) Math.exp(_selfw);
        float _t3 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = (float) Math.sqrt(_t3);
        float _t8 = (float) Math.sin(_t4) * _t0 * (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx * _t8);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy * _t8);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz * _t8);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t4) * _t0);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesXYZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesXYZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t1 = _selfy * _selfz;
        float _t3 = _selfz * _selfz;
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, -_t1);
        float _t10 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t9 * _t9);
        float _t14 = Math.fma(_t8, _t8, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, _t1), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t3), 1.0f)));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.atan2(_t9, _t10));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.atan2(2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t3), 1.0f)));
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesXZY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesXZY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = _selfz * _selfz;
        float _t1 = _selfy * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _t1);
        float _t8 = 2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, -_t1), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.atan2(_t7, _t9));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f)));
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesYXZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesYXZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t3 = _selfz * _selfz;
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t9 = 2.0f * Math.fma(_selfx, _selfw, -(_selfy * _selfz));
        float _t10 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t10, _t10, _t8 * _t8);
        float _t14 = Math.fma(_t9, _t9, _t12) * 1.0E-7f;
        if (_t12 < _t14) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.atan2(2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t3), 1.0f)));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.atan2(_t8, _t10));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t3), 1.0f)));
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t9))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesYZX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesYZX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = _selfz * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, -(_selfy * _selfz)), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f)));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.atan2(_t8, _t9));
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesZXY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesZXY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t1 = _selfz * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t8 = 2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t1), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t8 * _t8);
        float _t13 = Math.fma(_t7, _t7, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw), Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t1), 1.0f)));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.atan2(2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz)), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.atan2(_t8, _t9));
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t7))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesZYX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment getEulerAnglesZYX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = _selfz * _selfz;
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfw, -(_selfx * _selfz));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _t0), 1.0f);
        float _t11 = Math.fma(_t9, _t9, _t7 * _t7);
        float _t13 = Math.fma(_t8, _t8, _t11) * 1.0E-7f;
        if (_t11 < _t13) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.atan2(2.0f * Math.fma(_selfz, _selfw, -(_selfx * _selfy)), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _t0), 1.0f)));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.atan2(2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz), Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f)));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.atan2(_t7, _t9));
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.asin(Math.min(1.0f, Math.max(-1.0f, _t8))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment integrate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angularVelX, float angularVelY, float angularVelZ, float dt) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.integrate_unsafe(_destBase, _srcBase, angularVelX, angularVelY, angularVelZ, dt);
        return dest;
    }

    public static java.lang.foreign.MemorySegment integrate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angularVelX, float angularVelY, float angularVelZ, float dt) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment integrate_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment angularVel, long angularVelOffset, float dt) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _angularVelBase = angularVel.address() + angularVelOffset;
        FloatQuatOpsKernelsAddress.integrate_unsafe(_destBase, _srcBase, _angularVelBase, dt);
        return dest;
    }

    public static java.lang.foreign.MemorySegment integrate_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment angularVel, long angularVelOffset, float dt) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _angularVelx = angularVel.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, angularVelOffset + 0L);
        float _angularVely = angularVel.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, angularVelOffset + 4L);
        float _angularVelz = angularVel.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, angularVelOffset + 8L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t9, _selfw * _t15) + Math.fma(_selfz, _t16, -(_selfy * _t17)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t17, _selfw * _t16) + Math.fma(_selfy, _t9, -(_selfz * _t15)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t15, _selfz * _t9) + Math.fma(_selfw, _t17, -(_selfx * _t16)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t17, Math.fma(-_selfy, _t16, Math.fma(_selfw, _t9, -(_selfx * _t15)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNegativeX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNegativeX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t8 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t9 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t8 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t7 * _t13));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNegativeY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNegativeY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t7 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t9 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t8 * _t13));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNegativeZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNegativeZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t8 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t7 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t9 * _t13));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedNegativeX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNormalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedNegativeX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedNegativeY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNormalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedNegativeY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedNegativeZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNormalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedNegativeZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0f));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedPositiveX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNormalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedPositiveX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedPositiveY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNormalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedPositiveY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedPositiveZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invNormalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invNormalizedPositiveZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        return dest;
    }

    public static java.lang.foreign.MemorySegment invPositiveX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invPositiveX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t8 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t9 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t8 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t7 * _t13);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment invPositiveY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invPositiveY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t7 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t9 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t8 * _t13);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment invPositiveZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.invPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment invPositiveZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t8 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t7 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t9 * _t13);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static float length_unsafe(java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        return FloatQuatOpsKernelsAddress.length_unsafe(_srcBase);
    }

    public static float length_api(java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        return (float) Math.sqrt(Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy))));
    }

    public static float lengthSquared_unsafe(java.lang.foreign.MemorySegment src, long srcOffset) {
        long _srcBase = src.address() + srcOffset;
        return FloatQuatOpsKernelsAddress.lengthSquared_unsafe(_srcBase);
    }

    public static float lengthSquared_api(java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        return Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    public static java.lang.foreign.MemorySegment log_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.log_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment log_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = Math.fma(_selfw, _selfw, _t2);
        float _t8 = (float) Math.acos(_selfw * (1.0f / (float) Math.sqrt(_t4))) * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx * _t8);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy * _t8);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz * _t8);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.log((float) Math.sqrt(_t4)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment negativeX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.negativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment negativeX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t9 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t7 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t8 * _t13));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment negativeY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.negativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment negativeY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t8 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t8 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t9 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t7 * _t13));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment negativeZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.negativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment negativeZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(_t7 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(_t8 * _t13));
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(_t9 * _t13));
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalize_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalize_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalize_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        float _t4 = (1.0f / (float) Math.sqrt(_t3));
        if (_t3 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _selfx * _t4);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _selfy * _t4);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _selfz * _t4);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _selfw * _t4);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedNegativeX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedNegativeX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), -1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedNegativeY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedNegativeY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), -1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, -(2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedNegativeZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedNegativeZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, -(2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, -(2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), -1.0f));
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedPositiveX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedPositiveX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedPositiveY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedPositiveY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz));
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedPositiveZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.normalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment normalizedPositiveZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f));
        return dest;
    }

    public static java.lang.foreign.MemorySegment positiveX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.positiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment positiveX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfy, _selfz * _selfw);
        float _t8 = 2.0f * Math.fma(_selfx, _selfz, -(_selfy * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfy, _selfy, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t8, _t8, Math.fma(_t9, _t9, _t7 * _t7));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t9 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t7 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t8 * _t13);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment positiveY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.positiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment positiveY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfw, _selfy * _selfz);
        float _t8 = 2.0f * Math.fma(_selfx, _selfy, -(_selfz * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfz * _selfz), 1.0f);
        float _t12 = Math.fma(_t7, _t7, Math.fma(_t9, _t9, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t8 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t9 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t7 * _t13);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment positiveZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.positiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment positiveZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t7 = 2.0f * Math.fma(_selfx, _selfz, _selfy * _selfw);
        float _t8 = 2.0f * Math.fma(_selfy, _selfz, -(_selfx * _selfw));
        float _t9 = Math.fma(-2.0f, Math.fma(_selfx, _selfx, _selfy * _selfy), 1.0f);
        float _t12 = Math.fma(_t9, _t9, Math.fma(_t7, _t7, _t8 * _t8));
        float _t13 = (1.0f / (float) Math.sqrt(_t12));
        if (_t12 > 0.0f) {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t7 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t8 * _t13);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t9 * _t13);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment pow_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float t) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.pow_unsafe(_destBase, _srcBase, t);
        return dest;
    }

    public static java.lang.foreign.MemorySegment pow_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float t) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t20 * _t29);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t21 * _t29);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t19 * _t29);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        }
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t25) * _t11);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float step) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateTowards_unsafe(_destBase, _srcBase, targetX, targetY, targetZ, targetW, step);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float targetX, float targetY, float targetZ, float targetW, float step) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t54 * _t48);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t54 * _t49);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t54 * _t47);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t54 * _t46);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _targetBase = target.address() + targetOffset;
        FloatQuatOpsKernelsAddress.rotateTowards_unsafe(_destBase, _srcBase, _targetBase, step);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTowards_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment target, long targetOffset, float step) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _targetx = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 0L);
        float _targety = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 4L);
        float _targetz = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 8L);
        float _targetw = target.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, targetOffset + 12L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t54 * _t48);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t54 * _t49);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t54 * _t47);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, _t54 * _t46);
        } else {
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAlong_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAlong_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAlong_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _dirBase = dir.address() + dirOffset;
        long _upBase = up.address() + upOffset;
        FloatQuatOpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment lookAlong_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _dirx = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 0L);
        float _diry = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 4L);
        float _dirz = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 8L);
        float _upx = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 0L);
        float _upy = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 4L);
        float _upz = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 8L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t110, _selfw * _t111) + Math.fma(_selfy, _t108, -(_selfz * _t109)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t110, _selfz * _t111) + Math.fma(_selfw, _t109, -(_selfx * _t108)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t109, _selfw * _t108) + Math.fma(_selfz, _t110, -(_selfy * _t111)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t108, Math.fma(-_selfy, _t109, Math.fma(_selfw, _t110, -(_selfx * _t111)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_api(java.lang.foreign.MemorySegment dest, long destOffset, float angle, float axisX, float axisY, float axisZ) {
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, axisX * _t1);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, axisY * _t1);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, axisZ * _t1);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _axisBase = axis.address() + axisOffset;
        FloatQuatOpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationAxis_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        float _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L);
        float _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L);
        float _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _axisx * _t1);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _axisy * _t1);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _axisz * _t1);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_api(java.lang.foreign.MemorySegment dest, long destOffset, float dirX, float dirY, float dirZ, float upX, float upY, float upZ) {
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t55 * _t64);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t38 * _t64);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t58 * _t64);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * (float) Math.sqrt(_t61));
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t57 * _t67);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t37 * _t67);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t57 * _t65);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * (float) Math.sqrt(_t62));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t54 * _t65);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t38 * _t65);
                } else {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t37 * _t66);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t54 * _t66);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * (float) Math.sqrt(_t63));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        long _destBase = dest.address() + destOffset;
        long _dirBase = dir.address() + dirOffset;
        long _upBase = up.address() + upOffset;
        FloatQuatOpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationLookAlong_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment dir, long dirOffset, java.lang.foreign.MemorySegment up, long upOffset) {
        float _dirx = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 0L);
        float _diry = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 4L);
        float _dirz = dir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, dirOffset + 8L);
        float _upx = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 0L);
        float _upy = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 4L);
        float _upz = up.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, upOffset + 8L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t55 * _t64);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t38 * _t64);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t58 * _t64);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t60));
        } else {
            if (_t31 > _t56) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * (float) Math.sqrt(_t61));
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t57 * _t67);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t37 * _t67);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t55 * _t67);
            } else {
                if (_t49 > _t7) {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t57 * _t65);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * (float) Math.sqrt(_t62));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * _t54 * _t65);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t38 * _t65);
                } else {
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.5f * _t37 * _t66);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.5f * _t54 * _t66);
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.5f * (float) Math.sqrt(_t63));
                    dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * _t58 * _t66);
                }
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationTo_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationTo_unsafe(_destBase, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationTo_api(java.lang.foreign.MemorySegment dest, long destOffset, float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(fromDirY, toDirZ, -(fromDirZ * toDirY)) * _t11);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(fromDirZ, toDirX, -(fromDirX * toDirZ)) * _t11);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(fromDirX, toDirY, -(fromDirY * toDirX)) * _t11);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0f) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t15 * _t6);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t15 * _t9);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t15 * _t8);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
            } else {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationTo_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment fromDir, long fromDirOffset, java.lang.foreign.MemorySegment toDir, long toDirOffset) {
        long _destBase = dest.address() + destOffset;
        long _fromDirBase = fromDir.address() + fromDirOffset;
        long _toDirBase = toDir.address() + toDirOffset;
        FloatQuatOpsKernelsAddress.makeRotationTo_unsafe(_destBase, _fromDirBase, _toDirBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationTo_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment fromDir, long fromDirOffset, java.lang.foreign.MemorySegment toDir, long toDirOffset) {
        float _fromDirx = fromDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, fromDirOffset + 0L);
        float _fromDiry = fromDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, fromDirOffset + 4L);
        float _fromDirz = fromDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, fromDirOffset + 8L);
        float _toDirx = toDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, toDirOffset + 0L);
        float _toDiry = toDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, toDirOffset + 4L);
        float _toDirz = toDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, toDirOffset + 8L);
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
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_fromDiry, _toDirz, -(_fromDirz * _toDiry)) * _t11);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_fromDirz, _toDirx, -(_fromDirx * _toDirz)) * _t11);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_fromDirx, _toDiry, -(_fromDiry * _toDirx)) * _t11);
            dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.5f * (float) Math.sqrt(_t10));
        } else {
            if (_t14 > 0.0f) {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, _t15 * _t6);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, _t15 * _t9);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, _t15 * _t8);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
            } else {
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
                dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, 0.0f);
            }
        }
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationX_api(java.lang.foreign.MemorySegment dest, long destOffset, float angle) {
        float _t0 = 0.5f * angle;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, (float) Math.sin(_t0));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationXYZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationXYZ_api(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t11, _t5, _t12 * _t8));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationXZY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationXZY_api(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t11, _t8, -(_t12 * _t5)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t9, _t8, _t10 * _t5));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationY_api(java.lang.foreign.MemorySegment dest, long destOffset, float angle) {
        float _t0 = 0.5f * angle;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, (float) Math.sin(_t0));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationYXZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationYXZ_api(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t11, _t8, -(_t12 * _t5)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t12, _t8, _t11 * _t5));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationYZX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationYZX_api(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t9, _t5, _t10 * _t8));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t11, _t5, _t12 * _t8));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t10, _t5, -(_t9 * _t8)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationZ_unsafe(_destBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationZ_api(java.lang.foreign.MemorySegment dest, long destOffset, float angle) {
        float _t0 = 0.5f * angle;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, 0.0f);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, (float) Math.sin(_t0));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, (float) Math.cos(_t0));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationZXY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationZXY_api(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t11, _t5, _t12 * _t8));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t9, _t8, _t10 * _t5));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t12, _t5, -(_t11 * _t8)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationZYX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        FloatQuatOpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment makeRotationZYX_api(java.lang.foreign.MemorySegment dest, long destOffset, float angleX, float angleY, float angleZ) {
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_t9, _t5, -(_t10 * _t8)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_t11, _t8, _t12 * _t5));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_t12, _t8, -(_t11 * _t5)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_t10, _t5, _t9 * _t8));
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, _selfw * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, -(_selfz * _t2)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t2, _selfz * _t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, _selfz * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, _selfw * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfz, _t1, -(_selfx * _t2)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.preRotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment preRotateZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, -(_selfy * _t2)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t2, _selfy * _t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfz, _t1, _selfw * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAxis_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle, float axisX, float axisY, float axisZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAxis_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle, float axisX, float axisY, float axisZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = axisX * _t2;
        float _t4 = axisZ * _t2;
        float _t5 = axisY * _t2;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAxis_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _axisBase = axis.address() + axisOffset;
        FloatQuatOpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateAxis_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment axis, long axisOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _axisx = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 0L);
        float _axisy = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 4L);
        float _axisz = axis.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, axisOffset + 8L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        float _t3 = _axisx * _t2;
        float _t4 = _axisz * _t2;
        float _t5 = _axisy * _t2;
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, _selfw * _t3) + Math.fma(_selfy, _t4, -(_selfz * _t5)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, _selfz * _t3) + Math.fma(_selfw, _t5, -(_selfx * _t4)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t5, _selfw * _t4) + Math.fma(_selfz, _t1, -(_selfy * _t3)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t4, Math.fma(-_selfy, _t5, Math.fma(_selfw, _t1, -(_selfx * _t3)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTo_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateTo_unsafe(_destBase, _srcBase, fromDirX, fromDirY, fromDirZ, toDirX, toDirY, toDirZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTo_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float fromDirX, float fromDirY, float fromDirZ, float toDirX, float toDirY, float toDirZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTo_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment fromDir, long fromDirOffset, java.lang.foreign.MemorySegment toDir, long toDirOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _fromDirBase = fromDir.address() + fromDirOffset;
        long _toDirBase = toDir.address() + toDirOffset;
        FloatQuatOpsKernelsAddress.rotateTo_unsafe(_destBase, _srcBase, _fromDirBase, _toDirBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateTo_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment fromDir, long fromDirOffset, java.lang.foreign.MemorySegment toDir, long toDirOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _fromDirx = fromDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, fromDirOffset + 0L);
        float _fromDiry = fromDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, fromDirOffset + 4L);
        float _fromDirz = fromDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, fromDirOffset + 8L);
        float _toDirx = toDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, toDirOffset + 0L);
        float _toDiry = toDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, toDirOffset + 4L);
        float _toDirz = toDir.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, toDirOffset + 8L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t27, _selfw * _t37) + Math.fma(_selfy, _t38, -(_selfz * _t39)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t27, _selfz * _t37) + Math.fma(_selfw, _t39, -(_selfx * _t38)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t39, _selfw * _t38) + Math.fma(_selfz, _t27, -(_selfy * _t37)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t38, Math.fma(-_selfy, _t39, Math.fma(_selfw, _t27, -(_selfx * _t37)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, _selfw * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, _selfz * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfz, _t1, -(_selfy * _t2)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t1, -(_selfx * _t2)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateXYZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateXYZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateXZY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateXZY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t20, -(_selfz * _t22)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t22, -(_selfx * _t20)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t22, _selfw * _t20) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t20, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, -(_selfz * _t2)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, _selfw * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t2, _selfz * _t1));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t1, -(_selfy * _t2)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYXZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t19, _selfw * _t20) + Math.fma(_selfy, _t21, -(_selfz * _t22)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t19, _selfz * _t20) + Math.fma(_selfw, _t22, -(_selfx * _t21)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t22, _selfw * _t21) + Math.fma(_selfz, _t19, -(_selfy * _t20)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t21, Math.fma(-_selfy, _t22, Math.fma(_selfw, _t19, -(_selfx * _t20)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYZX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateYZX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t21, _selfw * _t19) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t21, _selfz * _t19) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t21, -(_selfy * _t19)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t19)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateZ_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateZ_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angle) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t0 = 0.5f * angle;
        float _t1 = (float) Math.cos(_t0);
        float _t2 = (float) Math.sin(_t0);
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t1, _selfy * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t1, -(_selfx * _t2)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfz, _t1, _selfw * _t2));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(_selfw, _t1, -(_selfz * _t2)));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateZXY_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateZXY_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t21, _selfw * _t22) + Math.fma(_selfy, _t19, -(_selfz * _t20)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t21, _selfz * _t22) + Math.fma(_selfw, _t20, -(_selfx * _t19)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t20, _selfw * _t19) + Math.fma(_selfz, _t21, -(_selfy * _t22)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t19, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t21, -(_selfx * _t22)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateZYX_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment rotateZYX_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float angleX, float angleY, float angleZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
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
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfx, _t19, _selfw * _t21) + Math.fma(_selfy, _t22, -(_selfz * _t20)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfy, _t19, _selfz * _t21) + Math.fma(_selfw, _t20, -(_selfx * _t22)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t20, _selfw * _t22) + Math.fma(_selfz, _t19, -(_selfy * _t21)));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 12L, Math.fma(-_selfz, _t22, Math.fma(-_selfy, _t20, Math.fma(_selfw, _t19, -(_selfx * _t21)))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment transform_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float vX, float vY, float vZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.transform_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment transform_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float vX, float vY, float vZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, vY, -(_selfy * vX));
        float _t10 = 2.0f * Math.fma(_selfz, vX, -(_selfx * vZ));
        float _t11 = 2.0f * Math.fma(_selfy, vZ, -(_selfz * vY));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, vX))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vY))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, vZ))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment transform_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _vBase = v.address() + vOffset;
        FloatQuatOpsKernelsAddress.transform_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment transform_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _vx = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 0L);
        float _vy = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 4L);
        float _vz = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 8L);
        float _t9 = 2.0f * Math.fma(_selfx, _vy, -(_selfy * _vx));
        float _t10 = 2.0f * Math.fma(_selfz, _vx, -(_selfx * _vz));
        float _t11 = 2.0f * Math.fma(_selfy, _vz, -(_selfz * _vy));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfy, _t9, Math.fma(-_selfz, _t10, Math.fma(_selfw, _t11, _vx))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfz, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vy))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfx, _t10, Math.fma(-_selfy, _t11, Math.fma(_selfw, _t9, _vz))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment transformInverse_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float vX, float vY, float vZ) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        FloatQuatOpsKernelsAddress.transformInverse_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.lang.foreign.MemorySegment transformInverse_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, float vX, float vY, float vZ) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _t9 = 2.0f * Math.fma(_selfx, vZ, -(_selfz * vX));
        float _t10 = 2.0f * Math.fma(_selfy, vX, -(_selfx * vY));
        float _t11 = 2.0f * Math.fma(_selfz, vY, -(_selfy * vZ));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, vX))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, vY))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, vZ))));
        return dest;
    }

    public static java.lang.foreign.MemorySegment transformInverse_unsafe(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        long _destBase = dest.address() + destOffset;
        long _srcBase = src.address() + srcOffset;
        long _vBase = v.address() + vOffset;
        FloatQuatOpsKernelsAddress.transformInverse_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.lang.foreign.MemorySegment transformInverse_api(java.lang.foreign.MemorySegment dest, long destOffset, java.lang.foreign.MemorySegment src, long srcOffset, java.lang.foreign.MemorySegment v, long vOffset) {
        float _selfx = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 0L);
        float _selfy = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 4L);
        float _selfz = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 8L);
        float _selfw = src.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, srcOffset + 12L);
        float _vx = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 0L);
        float _vy = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 4L);
        float _vz = v.get(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, vOffset + 8L);
        float _t9 = 2.0f * Math.fma(_selfx, _vz, -(_selfz * _vx));
        float _t10 = 2.0f * Math.fma(_selfy, _vx, -(_selfx * _vy));
        float _t11 = 2.0f * Math.fma(_selfz, _vy, -(_selfy * _vz));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 0L, Math.fma(_selfz, _t9, Math.fma(-_selfy, _t10, Math.fma(_selfw, _t11, _vx))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 4L, Math.fma(_selfx, _t10, Math.fma(-_selfz, _t11, Math.fma(_selfw, _t9, _vy))));
        dest.set(java.lang.foreign.ValueLayout.JAVA_FLOAT_UNALIGNED, destOffset + 8L, Math.fma(_selfy, _t11, Math.fma(-_selfx, _t9, Math.fma(_selfw, _t10, _vz))));
        return dest;
    }

}
