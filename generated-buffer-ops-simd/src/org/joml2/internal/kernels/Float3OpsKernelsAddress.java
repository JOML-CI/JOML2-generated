package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float3Ops} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float3Ops} and its sibling kernel units. Not public API.
 */
public final class Float3OpsKernelsAddress {
    private Float3OpsKernelsAddress() {}

    public static long add_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, otherX + _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, otherY + _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, otherZ + _selfz);
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _otherx + _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _othery + _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _otherz + _selfz);
        return dest;
    }

    public static long div_unsafe(long dest, long src, float scalar) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _rcp0 = 1.0f / scalar;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx * _rcp0);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy * _rcp0);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz * _rcp0);
        return dest;
    }

    public static long div_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx / otherX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy / otherY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz / otherZ);
        return dest;
    }

    public static long div_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx / _otherx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy / _othery);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz / _otherz);
        return dest;
    }

    public static long fma_unsafe(long dest, long src, float b, float cX, float cY, float cZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, b, cX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, b, cY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, b, cZ));
        return dest;
    }

    public static long fma_unsafe(long dest, long src, long c, float b) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _cx = UnsafeOpsHolder.U.getFloat(c + 0L);
        float _cy = UnsafeOpsHolder.U.getFloat(c + 4L);
        float _cz = UnsafeOpsHolder.U.getFloat(c + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, b, _cx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, b, _cy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, b, _cz));
        return dest;
    }

    public static long fma_unsafe(long dest, long src, float bX, float bY, float bZ, float cX, float cY, float cZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, bX, cX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, bY, cY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, bZ, cZ));
        return dest;
    }

    public static long fma_unsafe(long dest, long src, long b, long c) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _bx = UnsafeOpsHolder.U.getFloat(b + 0L);
        float _by = UnsafeOpsHolder.U.getFloat(b + 4L);
        float _bz = UnsafeOpsHolder.U.getFloat(b + 8L);
        float _cx = UnsafeOpsHolder.U.getFloat(c + 0L);
        float _cy = UnsafeOpsHolder.U.getFloat(c + 4L);
        float _cz = UnsafeOpsHolder.U.getFloat(c + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _bx, _cx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _by, _cy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _bz, _cz));
        return dest;
    }

    public static long mul_unsafe(long dest, long src, float scalar) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, scalar * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, scalar * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, scalar * _selfz);
        return dest;
    }

    public static long mul_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, otherX * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, otherY * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, otherZ * _selfz);
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _otherx * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _othery * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _otherz * _selfz);
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, -_selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, -_selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, -_selfz);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx - otherX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy - otherY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz - otherZ);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx - _otherx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy - _othery);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz - _otherz);
        return dest;
    }

    public static long set_unsafe(long dest, float vX, float vY, float vZ) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, vX);
        UnsafeOpsHolder.U.putFloat(dest + 4L, vY);
        UnsafeOpsHolder.U.putFloat(dest + 8L, vZ);
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        float _vx = UnsafeOpsHolder.U.getFloat(v + 0L);
        float _vy = UnsafeOpsHolder.U.getFloat(v + 4L);
        float _vz = UnsafeOpsHolder.U.getFloat(v + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _vx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _vy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _vz);
        return dest;
    }

    public static long set_unsafe(long dest, float s) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, s);
        UnsafeOpsHolder.U.putFloat(dest + 4L, s);
        UnsafeOpsHolder.U.putFloat(dest + 8L, s);
        return dest;
    }

    public static long makeZero_unsafe(long dest) {
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        return dest;
    }

    public static long bezier_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(p1X, _t7, _selfx * _t8) + Math.fma(p2X, _t6, p3X * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(p1Y, _t7, _selfy * _t8) + Math.fma(p2Y, _t6, p3Y * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(p1Z, _t7, _selfz * _t8) + Math.fma(p2Z, _t6, p3Z * _t2));
        return dest;
    }

    public static long bezier_unsafe(long dest, long src, long p1, long p2, long p3, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _p3x = UnsafeOpsHolder.U.getFloat(p3 + 0L);
        float _p3y = UnsafeOpsHolder.U.getFloat(p3 + 4L);
        float _p3z = UnsafeOpsHolder.U.getFloat(p3 + 8L);
        float _t0 = 1.0f - t;
        float _t1 = t * t;
        float _t2 = t * _t1;
        float _t3 = _t0 * _t0;
        float _t6 = 3.0f * _t0 * _t1;
        float _t7 = 3.0f * t * _t3;
        float _t8 = _t0 * _t3;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_p1x, _t7, _selfx * _t8) + Math.fma(_p2x, _t6, _p3x * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_p1y, _t7, _selfy * _t8) + Math.fma(_p2y, _t6, _p3y * _t2));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_p1z, _t7, _selfz * _t8) + Math.fma(_p2z, _t6, _p3z * _t2));
        return dest;
    }

    public static long bezier2_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(p2X, _t0, Math.fma(p1X, _t3, _selfx * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, _selfy * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, _selfz * _t4)));
        return dest;
    }

    public static long bezier2_unsafe(long dest, long src, long p1, long p2, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _t0 = t * t;
        float _t1 = 1.0f - t;
        float _t3 = 2.0f * t * _t1;
        float _t4 = _t1 * _t1;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_p2x, _t0, Math.fma(_p1x, _t3, _selfx * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_p2y, _t0, Math.fma(_p1y, _t3, _selfy * _t4)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_p2z, _t0, Math.fma(_p1z, _t3, _selfz * _t4)));
        return dest;
    }

    public static long bezier2Tangent_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(p1X - _selfx, _t2, (p2X - p1X) * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(p1Y - _selfy, _t2, (p2Y - p1Y) * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(p1Z - _selfz, _t2, (p2Z - p1Z) * _t1));
        return dest;
    }

    public static long bezier2Tangent_unsafe(long dest, long src, long p1, long p2, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _t1 = 2.0f * t;
        float _t2 = 2.0f * (1.0f - t);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_p1x - _selfx, _t2, (_p2x - _p1x) * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_p1y - _selfy, _t2, (_p2y - _p1y) * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_p1z - _selfz, _t2, (_p2z - _p1z) * _t1));
        return dest;
    }

    public static long bezierTangent_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(p3X - p2X, _t2, Math.fma(p1X - _selfx, _t6, (p2X - p1X) * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - _selfy, _t6, (p2Y - p1Y) * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - _selfz, _t6, (p2Z - p1Z) * _t5)));
        return dest;
    }

    public static long bezierTangent_unsafe(long dest, long src, long p1, long p2, long p3, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _p3x = UnsafeOpsHolder.U.getFloat(p3 + 0L);
        float _p3y = UnsafeOpsHolder.U.getFloat(p3 + 4L);
        float _p3z = UnsafeOpsHolder.U.getFloat(p3 + 8L);
        float _t1 = 1.0f - t;
        float _t2 = 3.0f * t * t;
        float _t5 = 6.0f * t * _t1;
        float _t6 = 3.0f * _t1 * _t1;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_p3x - _p2x, _t2, Math.fma(_p1x - _selfx, _t6, (_p2x - _p1x) * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_p3y - _p2y, _t2, Math.fma(_p1y - _selfy, _t6, (_p2y - _p1y) * _t5)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_p3z - _p2z, _t2, Math.fma(_p1z - _selfz, _t6, (_p2z - _p1z) * _t5)));
        return dest;
    }

    public static long catmullRom_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = t * t;
        float _t1 = t * _t0;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (Math.fma(2.0f, p1X, t * (p2X - _selfx)) + Math.fma(Math.fma(-5.0f, p1X, Math.fma(2.0f, _selfx, Math.fma(4.0f, p2X, -p3X))), _t0, Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - _selfx)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (Math.fma(2.0f, p1Y, t * (p2Y - _selfy)) + Math.fma(Math.fma(-5.0f, p1Y, Math.fma(2.0f, _selfy, Math.fma(4.0f, p2Y, -p3Y))), _t0, Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - _selfy)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (Math.fma(2.0f, p1Z, t * (p2Z - _selfz)) + Math.fma(Math.fma(-5.0f, p1Z, Math.fma(2.0f, _selfz, Math.fma(4.0f, p2Z, -p3Z))), _t0, Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - _selfz)) * _t1)));
        return dest;
    }

    public static long catmullRom_unsafe(long dest, long src, long p1, long p2, long p3, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _p3x = UnsafeOpsHolder.U.getFloat(p3 + 0L);
        float _p3y = UnsafeOpsHolder.U.getFloat(p3 + 4L);
        float _p3z = UnsafeOpsHolder.U.getFloat(p3 + 8L);
        float _t0 = t * t;
        float _t1 = t * _t0;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * (Math.fma(2.0f, _p1x, t * (_p2x - _selfx)) + Math.fma(Math.fma(-5.0f, _p1x, Math.fma(2.0f, _selfx, Math.fma(4.0f, _p2x, -_p3x))), _t0, Math.fma(-3.0f, _p2x, Math.fma(3.0f, _p1x, _p3x - _selfx)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * (Math.fma(2.0f, _p1y, t * (_p2y - _selfy)) + Math.fma(Math.fma(-5.0f, _p1y, Math.fma(2.0f, _selfy, Math.fma(4.0f, _p2y, -_p3y))), _t0, Math.fma(-3.0f, _p2y, Math.fma(3.0f, _p1y, _p3y - _selfy)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * (Math.fma(2.0f, _p1z, t * (_p2z - _selfz)) + Math.fma(Math.fma(-5.0f, _p1z, Math.fma(2.0f, _selfz, Math.fma(4.0f, _p2z, -_p3z))), _t0, Math.fma(-3.0f, _p2z, Math.fma(3.0f, _p1z, _p3z - _selfz)) * _t1)));
        return dest;
    }

    public static long catmullRomTangent_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z, float p3X, float p3Y, float p3Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = t * t;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1X, Math.fma(2.0f, _selfx, Math.fma(4.0f, p2X, -p3X))), Math.fma(3.0f * Math.fma(-3.0f, p2X, Math.fma(3.0f, p1X, p3X - _selfx)), _t0, p2X - _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Y, Math.fma(2.0f, _selfy, Math.fma(4.0f, p2Y, -p3Y))), Math.fma(3.0f * Math.fma(-3.0f, p2Y, Math.fma(3.0f, p1Y, p3Y - _selfy)), _t0, p2Y - _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, p1Z, Math.fma(2.0f, _selfz, Math.fma(4.0f, p2Z, -p3Z))), Math.fma(3.0f * Math.fma(-3.0f, p2Z, Math.fma(3.0f, p1Z, p3Z - _selfz)), _t0, p2Z - _selfz)));
        return dest;
    }

    public static long catmullRomTangent_unsafe(long dest, long src, long p1, long p2, long p3, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _p3x = UnsafeOpsHolder.U.getFloat(p3 + 0L);
        float _p3y = UnsafeOpsHolder.U.getFloat(p3 + 4L);
        float _p3z = UnsafeOpsHolder.U.getFloat(p3 + 8L);
        float _t0 = t * t;
        UnsafeOpsHolder.U.putFloat(dest + 0L, 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1x, Math.fma(2.0f, _selfx, Math.fma(4.0f, _p2x, -_p3x))), Math.fma(3.0f * Math.fma(-3.0f, _p2x, Math.fma(3.0f, _p1x, _p3x - _selfx)), _t0, _p2x - _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1y, Math.fma(2.0f, _selfy, Math.fma(4.0f, _p2y, -_p3y))), Math.fma(3.0f * Math.fma(-3.0f, _p2y, Math.fma(3.0f, _p1y, _p3y - _selfy)), _t0, _p2y - _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, 0.5f * Math.fma(t, 2.0f * Math.fma(-5.0f, _p1z, Math.fma(2.0f, _selfz, Math.fma(4.0f, _p2z, -_p3z))), Math.fma(3.0f * Math.fma(-3.0f, _p2z, Math.fma(3.0f, _p1z, _p3z - _selfz)), _t0, _p2z - _selfz)));
        return dest;
    }

    public static long hermite_unsafe(long dest, long src, float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9));
        return dest;
    }

    public static long hermite_unsafe(long dest, long src, long t0, long v1, long t1, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0x = UnsafeOpsHolder.U.getFloat(t0 + 0L);
        float _t0y = UnsafeOpsHolder.U.getFloat(t0 + 4L);
        float _t0z = UnsafeOpsHolder.U.getFloat(t0 + 8L);
        float _v1x = UnsafeOpsHolder.U.getFloat(v1 + 0L);
        float _v1y = UnsafeOpsHolder.U.getFloat(v1 + 4L);
        float _v1z = UnsafeOpsHolder.U.getFloat(v1 + 8L);
        float _t1x = UnsafeOpsHolder.U.getFloat(t1 + 0L);
        float _t1y = UnsafeOpsHolder.U.getFloat(t1 + 4L);
        float _t1z = UnsafeOpsHolder.U.getFloat(t1 + 8L);
        float _t0 = t * t;
        float _t2 = t * _t0;
        float _t5 = t * Math.fma(t, t, -t);
        float _t7 = Math.fma(t - 2.0f, _t0, t);
        float _t9 = Math.fma(3.0f, _t0, -(2.0f * _t2));
        float _t10 = Math.fma(2.0f, _t2, Math.fma(-3.0f, _t0, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t10, _t0x * _t7) + Math.fma(_t1x, _t5, _v1x * _t9));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t10, _t0y * _t7) + Math.fma(_t1y, _t5, _v1y * _t9));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t10, _t0z * _t7) + Math.fma(_t1z, _t5, _v1z * _t9));
        return dest;
    }

    public static long hermiteTangent_unsafe(long dest, long src, float t0X, float t0Y, float t0Z, float v1X, float v1Y, float v1Z, float t1X, float t1Y, float t1Z, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7));
        return dest;
    }

    public static long hermiteTangent_unsafe(long dest, long src, long t0, long v1, long t1, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0x = UnsafeOpsHolder.U.getFloat(t0 + 0L);
        float _t0y = UnsafeOpsHolder.U.getFloat(t0 + 4L);
        float _t0z = UnsafeOpsHolder.U.getFloat(t0 + 8L);
        float _v1x = UnsafeOpsHolder.U.getFloat(v1 + 0L);
        float _v1y = UnsafeOpsHolder.U.getFloat(v1 + 4L);
        float _v1z = UnsafeOpsHolder.U.getFloat(v1 + 8L);
        float _t1x = UnsafeOpsHolder.U.getFloat(t1 + 0L);
        float _t1y = UnsafeOpsHolder.U.getFloat(t1 + 4L);
        float _t1z = UnsafeOpsHolder.U.getFloat(t1 + 8L);
        float _t0 = t * t;
        float _t6 = 6.0f * Math.fma(t, t, -t);
        float _t7 = 6.0f * Math.fma(-t, t, t);
        float _t8 = Math.fma(3.0f, _t0, -(2.0f * t));
        float _t9 = Math.fma(3.0f, _t0, Math.fma(-4.0f, t, 1.0f));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t6, _t0x * _t9) + Math.fma(_t1x, _t8, _v1x * _t7));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t6, _t0y * _t9) + Math.fma(_t1y, _t8, _v1y * _t7));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t6, _t0z * _t9) + Math.fma(_t1z, _t8, _v1z * _t7));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(t, otherX - _selfx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(t, otherY - _selfy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(t, otherZ - _selfz, _selfz));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, float t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(t, _otherx - _selfx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(t, _othery - _selfy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(t, _otherz - _selfz, _selfz));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, float otherX, float otherY, float otherZ, float tX, float tY, float tZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(tX, otherX - _selfx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(tY, otherY - _selfy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(tZ, otherZ - _selfz, _selfz));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, long t) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _tx = UnsafeOpsHolder.U.getFloat(t + 0L);
        float _ty = UnsafeOpsHolder.U.getFloat(t + 4L);
        float _tz = UnsafeOpsHolder.U.getFloat(t + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_tx, _otherx - _selfx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_ty, _othery - _selfy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_tz, _otherz - _selfz, _selfz));
        return dest;
    }

    public static long absolute_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.abs(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.abs(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.abs(_selfz));
        return dest;
    }

    public static long acos_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.acos(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.acos(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.acos(_selfz));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, float bX, float bY, float bZ, float scalar) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(scalar, bX, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(scalar, bY, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(scalar, bZ, _selfz));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, long b, float scalar) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _bx = UnsafeOpsHolder.U.getFloat(b + 0L);
        float _by = UnsafeOpsHolder.U.getFloat(b + 4L);
        float _bz = UnsafeOpsHolder.U.getFloat(b + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(scalar, _bx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(scalar, _by, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(scalar, _bz, _selfz));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, float bX, float bY, float bZ, float cX, float cY, float cZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(bX, cX, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(bY, cY, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(bZ, cZ, _selfz));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, long b, long c) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _bx = UnsafeOpsHolder.U.getFloat(b + 0L);
        float _by = UnsafeOpsHolder.U.getFloat(b + 4L);
        float _bz = UnsafeOpsHolder.U.getFloat(b + 8L);
        float _cx = UnsafeOpsHolder.U.getFloat(c + 0L);
        float _cy = UnsafeOpsHolder.U.getFloat(c + 4L);
        float _cz = UnsafeOpsHolder.U.getFloat(c + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_bx, _cx, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_by, _cy, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_bz, _cz, _selfz));
        return dest;
    }

    public static float angleBetween_unsafe(long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)) * (1.0f / (float) Math.sqrt(Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)))) * (1.0f / (float) Math.sqrt(Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY)))))));
    }

    public static float angleBetween_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        return (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)) * (1.0f / (float) Math.sqrt(Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)))) * (1.0f / (float) Math.sqrt(Math.fma(_otherz, _otherz, Math.fma(_otherx, _otherx, _othery * _othery)))))));
    }

    public static long asin_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.asin(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.asin(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.asin(_selfz));
        return dest;
    }

    public static long atan_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan(_selfz));
        return dest;
    }

    public static long atan2_unsafe(long dest, long src, float x) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_selfx, x));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_selfy, x));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_selfz, x));
        return dest;
    }

    public static long atan2_unsafe(long dest, long src, float xX, float xY, float xZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_selfx, xX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_selfy, xY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_selfz, xZ));
        return dest;
    }

    public static long atan2_unsafe(long dest, long src, long x) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _xx = UnsafeOpsHolder.U.getFloat(x + 0L);
        float _xy = UnsafeOpsHolder.U.getFloat(x + 4L);
        float _xz = UnsafeOpsHolder.U.getFloat(x + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.atan2(_selfx, _xx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.atan2(_selfy, _xy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.atan2(_selfz, _xz));
        return dest;
    }

    public static long cbrt_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.cbrt(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.cbrt(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.cbrt(_selfz));
        return dest;
    }

    public static long ceil_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.ceil(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.ceil(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.ceil(_selfz));
        return dest;
    }

    public static long clamp_unsafe(long dest, long src, float min, float max) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.min(Math.max(_selfx, min), max));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.min(Math.max(_selfy, min), max));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.min(Math.max(_selfz, min), max));
        return dest;
    }

    public static long clamp_unsafe(long dest, long src, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.min(Math.max(_selfx, minX), maxX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.min(Math.max(_selfy, minY), maxY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.min(Math.max(_selfz, minZ), maxZ));
        return dest;
    }

    public static long clamp_unsafe(long dest, long src, long min, long max) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _minx = UnsafeOpsHolder.U.getFloat(min + 0L);
        float _miny = UnsafeOpsHolder.U.getFloat(min + 4L);
        float _minz = UnsafeOpsHolder.U.getFloat(min + 8L);
        float _maxx = UnsafeOpsHolder.U.getFloat(max + 0L);
        float _maxy = UnsafeOpsHolder.U.getFloat(max + 4L);
        float _maxz = UnsafeOpsHolder.U.getFloat(max + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.min(Math.max(_selfx, _minx), _maxx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.min(Math.max(_selfy, _miny), _maxy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.min(Math.max(_selfz, _minz), _maxz));
        return dest;
    }

    public static long closestPointOnLine_unsafe(long dest, long src, float lineStartX, float lineStartY, float lineStartZ, float lineEndX, float lineEndY, float lineEndZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = lineEndZ - lineStartZ;
        float _t1 = lineEndX - lineStartX;
        float _t2 = lineEndY - lineStartY;
        float _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t14 = Math.max(0.0f, Math.min(1.0f, Math.fma(_t0, _selfz - lineStartZ, Math.fma(_t1, _selfx - lineStartX, _t2 * (_selfy - lineStartY))) / _t10));
        if (_t10 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t1, _t14, lineStartX));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, _t14, lineStartY));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t0, _t14, lineStartZ));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, lineStartX);
            UnsafeOpsHolder.U.putFloat(dest + 4L, lineStartY);
            UnsafeOpsHolder.U.putFloat(dest + 8L, lineStartZ);
        }
        return dest;
    }

    public static long closestPointOnLine_unsafe(long dest, long src, long lineStart, long lineEnd) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _lineStartx = UnsafeOpsHolder.U.getFloat(lineStart + 0L);
        float _lineStarty = UnsafeOpsHolder.U.getFloat(lineStart + 4L);
        float _lineStartz = UnsafeOpsHolder.U.getFloat(lineStart + 8L);
        float _lineEndx = UnsafeOpsHolder.U.getFloat(lineEnd + 0L);
        float _lineEndy = UnsafeOpsHolder.U.getFloat(lineEnd + 4L);
        float _lineEndz = UnsafeOpsHolder.U.getFloat(lineEnd + 8L);
        float _t0 = _lineEndz - _lineStartz;
        float _t1 = _lineEndx - _lineStartx;
        float _t2 = _lineEndy - _lineStarty;
        float _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t14 = Math.max(0.0f, Math.min(1.0f, Math.fma(_t0, _selfz - _lineStartz, Math.fma(_t1, _selfx - _lineStartx, _t2 * (_selfy - _lineStarty))) / _t10));
        if (_t10 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t1, _t14, _lineStartx));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, _t14, _lineStarty));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t0, _t14, _lineStartz));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _lineStartx);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _lineStarty);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _lineStartz);
        }
        return dest;
    }

    public static float compAdd_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return _selfz + (_selfx + _selfy);
    }

    public static float compMax_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return Math.max(Math.max(_selfx, _selfy), _selfz);
    }

    public static float compMin_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return Math.min(Math.min(_selfx, _selfy), _selfz);
    }

    public static float compMul_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return _selfz * _selfx * _selfy;
    }

    public static long copySign_unsafe(long dest, long src, float sign) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.copySign(_selfx, sign));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.copySign(_selfy, sign));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.copySign(_selfz, sign));
        return dest;
    }

    public static long copySign_unsafe(long dest, long src, float signX, float signY, float signZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.copySign(_selfx, signX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.copySign(_selfy, signY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.copySign(_selfz, signZ));
        return dest;
    }

    public static long copySign_unsafe(long dest, long src, long sign) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _signx = UnsafeOpsHolder.U.getFloat(sign + 0L);
        float _signy = UnsafeOpsHolder.U.getFloat(sign + 4L);
        float _signz = UnsafeOpsHolder.U.getFloat(sign + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.copySign(_selfx, _signx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.copySign(_selfy, _signy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.copySign(_selfz, _signz));
        return dest;
    }

    public static long cos_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.cos(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.cos(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.cos(_selfz));
        return dest;
    }

    public static long cosh_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.cosh(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.cosh(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.cosh(_selfz));
        return dest;
    }

    public static long cross_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(otherZ, _selfy, -(otherY * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(otherX, _selfz, -(otherZ * _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(otherY, _selfx, -(otherX * _selfy)));
        return dest;
    }

    public static long cross_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_otherz, _selfy, -(_othery * _selfz)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_otherx, _selfz, -(_otherz * _selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_othery, _selfx, -(_otherx * _selfy)));
        return dest;
    }

    public static long degrees_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.toDegrees(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.toDegrees(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.toDegrees(_selfz));
        return dest;
    }

    public static float distance_unsafe(long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = _selfz - otherZ;
        float _t1 = _selfx - otherX;
        float _t2 = _selfy - otherY;
        return (float) Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
    }

    public static float distance_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _t0 = _selfz - _otherz;
        float _t1 = _selfx - _otherx;
        float _t2 = _selfy - _othery;
        return (float) Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
    }

    public static float distanceSquared_unsafe(long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = _selfz - otherZ;
        float _t1 = _selfx - otherX;
        float _t2 = _selfy - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
    }

    public static float distanceSquared_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _t0 = _selfz - _otherz;
        float _t1 = _selfx - _otherx;
        float _t2 = _selfy - _othery;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
    }

    public static float dot_unsafe(long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy));
    }

    public static float dot_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        return Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy));
    }

    public static long exp_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.exp(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.exp(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.exp(_selfz));
        return dest;
    }

    public static long exp2_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.pow(2.0f, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.pow(2.0f, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.pow(2.0f, _selfz));
        return dest;
    }

    public static long expm1_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.expm1(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.expm1(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.expm1(_selfz));
        return dest;
    }

    public static long faceforward_unsafe(long dest, long src, float IX, float IY, float IZ, float NrefX, float NrefY, float NrefZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t2 = Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY));
        if (_t2 < 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -_selfx);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -_selfy);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -_selfz);
        }
        return dest;
    }

    public static long faceforward_unsafe(long dest, long src, long I, long Nref) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _Ix = UnsafeOpsHolder.U.getFloat(I + 0L);
        float _Iy = UnsafeOpsHolder.U.getFloat(I + 4L);
        float _Iz = UnsafeOpsHolder.U.getFloat(I + 8L);
        float _Nrefx = UnsafeOpsHolder.U.getFloat(Nref + 0L);
        float _Nrefy = UnsafeOpsHolder.U.getFloat(Nref + 4L);
        float _Nrefz = UnsafeOpsHolder.U.getFloat(Nref + 8L);
        float _t2 = Math.fma(_Iz, _Nrefz, Math.fma(_Ix, _Nrefx, _Iy * _Nrefy));
        if (_t2 < 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, -_selfx);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -_selfy);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -_selfz);
        }
        return dest;
    }

    public static long floor_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.floor(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.floor(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.floor(_selfz));
        return dest;
    }

    public static long fract_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx - (float) Math.floor(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy - (float) Math.floor(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz - (float) Math.floor(_selfz));
        return dest;
    }

    public static long hypot_unsafe(long dest, long src, float y) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.hypot(_selfx, y));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.hypot(_selfy, y));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.hypot(_selfz, y));
        return dest;
    }

    public static long hypot_unsafe(long dest, long src, float yX, float yY, float yZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.hypot(_selfx, yX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.hypot(_selfy, yY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.hypot(_selfz, yZ));
        return dest;
    }

    public static long hypot_unsafe(long dest, long src, long y) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _yx = UnsafeOpsHolder.U.getFloat(y + 0L);
        float _yy = UnsafeOpsHolder.U.getFloat(y + 4L);
        float _yz = UnsafeOpsHolder.U.getFloat(y + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.hypot(_selfx, _yx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.hypot(_selfy, _yy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.hypot(_selfz, _yz));
        return dest;
    }

    public static long inverse_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, 1.0f / _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, 1.0f / _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, 1.0f / _selfz);
        return dest;
    }

    public static long inverseSqrt_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (1.0f / (float) Math.sqrt(_selfx)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (1.0f / (float) Math.sqrt(_selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (1.0f / (float) Math.sqrt(_selfz)));
        return dest;
    }

    public static float length_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return (float) Math.sqrt(Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    public static float lengthSquared_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
    }

    public static long log_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.log(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.log(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.log(_selfz));
        return dest;
    }

    public static long log10_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.log10(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.log10(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.log10(_selfz));
        return dest;
    }

    public static long log1p_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.log1p(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.log1p(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.log1p(_selfz));
        return dest;
    }

    public static long log2_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = (float) Math.log(2.0f);
        float _t0_inv = 1.0f / _t0;
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.log(_selfx) * _t0_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.log(_selfy) * _t0_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.log(_selfz) * _t0_inv);
        return dest;
    }

    public static float manhattanDistance_unsafe(long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return Math.abs(_selfx - otherX) + Math.abs(_selfy - otherY) + Math.abs(_selfz - otherZ);
    }

    public static float manhattanDistance_unsafe(long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        return Math.abs(_selfx - _otherx) + Math.abs(_selfy - _othery) + Math.abs(_selfz - _otherz);
    }

    public static float manhattanLength_unsafe(long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        return Math.abs(_selfx) + Math.abs(_selfy) + Math.abs(_selfz);
    }

    public static long max_unsafe(long dest, long src, float scalar) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.max(_selfx, scalar));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.max(_selfy, scalar));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.max(_selfz, scalar));
        return dest;
    }

    public static long max_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.max(_selfx, otherX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.max(_selfy, otherY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.max(_selfz, otherZ));
        return dest;
    }

    public static long max_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.max(_selfx, _otherx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.max(_selfy, _othery));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.max(_selfz, _otherz));
        return dest;
    }

    public static long min_unsafe(long dest, long src, float scalar) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.min(_selfx, scalar));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.min(_selfy, scalar));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.min(_selfz, scalar));
        return dest;
    }

    public static long min_unsafe(long dest, long src, float otherX, float otherY, float otherZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.min(_selfx, otherX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.min(_selfy, otherY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.min(_selfz, otherZ));
        return dest;
    }

    public static long min_unsafe(long dest, long src, long other) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.min(_selfx, _otherx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.min(_selfy, _othery));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.min(_selfz, _otherz));
        return dest;
    }

    public static long mod_unsafe(long dest, long src, float y) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _rcp0 = 1.0f / y;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-y, (float) Math.floor(_selfx * _rcp0), _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-y, (float) Math.floor(_selfy * _rcp0), _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-y, (float) Math.floor(_selfz * _rcp0), _selfz));
        return dest;
    }

    public static long mod_unsafe(long dest, long src, float yX, float yY, float yZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-yX, (float) Math.floor(_selfx / yX), _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-yY, (float) Math.floor(_selfy / yY), _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-yZ, (float) Math.floor(_selfz / yZ), _selfz));
        return dest;
    }

    public static long mod_unsafe(long dest, long src, long y) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _yx = UnsafeOpsHolder.U.getFloat(y + 0L);
        float _yy = UnsafeOpsHolder.U.getFloat(y + 4L);
        float _yz = UnsafeOpsHolder.U.getFloat(y + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-_yx, (float) Math.floor(_selfx / _yx), _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-_yy, (float) Math.floor(_selfy / _yy), _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-_yz, (float) Math.floor(_selfz / _yz), _selfz));
        return dest;
    }

    public static long nextDown_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.nextDown(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.nextDown(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.nextDown(_selfz));
        return dest;
    }

    public static long nextUp_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.nextUp(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.nextUp(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.nextUp(_selfz));
        return dest;
    }

    public static long normalize_unsafe(long dest, long src) {
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

    public static long normalizeMul_unsafe(long dest, long src, float length) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t4 = length * (1.0f / (float) Math.sqrt(_t2));
        if (_t2 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx * _t4);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy * _t4);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz * _t4);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static float orientedAngle_unsafe(long src, float otherX, float otherY, float otherZ, float normalX, float normalY, float normalZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t6 = Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY));
        float _t7 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t15 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)) * (1.0f / (float) Math.sqrt(_t7)) * (1.0f / (float) Math.sqrt(_t6)))));
        return (float) Math.sqrt(_t6) * (float) Math.sqrt(_t7) > 0.0f ? Math.fma(normalZ, Math.fma(otherY, _selfx, -(otherX * _selfy)), Math.fma(normalX, Math.fma(otherZ, _selfy, -(otherY * _selfz)), normalY * Math.fma(otherX, _selfz, -(otherZ * _selfx)))) < 0.0f ? -_t15 : _t15 : 0.0f;
    }

    public static float orientedAngle_unsafe(long src, long other, long normal) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _otherx = UnsafeOpsHolder.U.getFloat(other + 0L);
        float _othery = UnsafeOpsHolder.U.getFloat(other + 4L);
        float _otherz = UnsafeOpsHolder.U.getFloat(other + 8L);
        float _normalx = UnsafeOpsHolder.U.getFloat(normal + 0L);
        float _normaly = UnsafeOpsHolder.U.getFloat(normal + 4L);
        float _normalz = UnsafeOpsHolder.U.getFloat(normal + 8L);
        float _t6 = Math.fma(_otherz, _otherz, Math.fma(_otherx, _otherx, _othery * _othery));
        float _t7 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        float _t15 = (float) Math.acos(Math.min(1.0f, Math.max(-1.0f, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)) * (1.0f / (float) Math.sqrt(_t7)) * (1.0f / (float) Math.sqrt(_t6)))));
        return (float) Math.sqrt(_t6) * (float) Math.sqrt(_t7) > 0.0f ? Math.fma(_normalz, Math.fma(_othery, _selfx, -(_otherx * _selfy)), Math.fma(_normalx, Math.fma(_otherz, _selfy, -(_othery * _selfz)), _normaly * Math.fma(_otherx, _selfz, -(_otherz * _selfx)))) < 0.0f ? -_t15 : _t15 : 0.0f;
    }

    public static long outerProduct_unsafe(long dest, long src, float rowX, float rowY, float rowZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, rowX * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, rowX * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, rowX * _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, rowY * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, rowY * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 20L, rowY * _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 24L, rowZ * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 28L, rowZ * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, rowZ * _selfz);
        return dest;
    }

    public static long outerProduct_unsafe(long dest, long src, long row) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _rowx = UnsafeOpsHolder.U.getFloat(row + 0L);
        float _rowy = UnsafeOpsHolder.U.getFloat(row + 4L);
        float _rowz = UnsafeOpsHolder.U.getFloat(row + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _rowx * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _rowx * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _rowx * _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, _rowy * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 16L, _rowy * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 20L, _rowy * _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 24L, _rowz * _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 28L, _rowz * _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 32L, _rowz * _selfz);
        return dest;
    }

    public static long perpendicular_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t1 = Math.fma(_selfx, _selfx, _selfy * _selfy);
        if (_t1 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _selfy);
            UnsafeOpsHolder.U.putFloat(dest + 4L, -_selfx);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _selfz);
            UnsafeOpsHolder.U.putFloat(dest + 8L, -_selfy);
        }
        return dest;
    }

    public static long pow_unsafe(long dest, long src, float exponent) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.pow(_selfx, exponent));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.pow(_selfy, exponent));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.pow(_selfz, exponent));
        return dest;
    }

    public static long pow_unsafe(long dest, long src, float exponentX, float exponentY, float exponentZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.pow(_selfx, exponentX));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.pow(_selfy, exponentY));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.pow(_selfz, exponentZ));
        return dest;
    }

    public static long pow_unsafe(long dest, long src, long exponent) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _exponentx = UnsafeOpsHolder.U.getFloat(exponent + 0L);
        float _exponenty = UnsafeOpsHolder.U.getFloat(exponent + 4L);
        float _exponentz = UnsafeOpsHolder.U.getFloat(exponent + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.pow(_selfx, _exponentx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.pow(_selfy, _exponenty));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.pow(_selfz, _exponentz));
        return dest;
    }

    public static long project_unsafe(long dest, long src, float ontoX, float ontoY, float ontoZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t4 = Math.fma(ontoZ, _selfz, Math.fma(ontoX, _selfx, ontoY * _selfy));
        float _t5 = Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY));
        float _t5_inv = 1.0f / _t5;
        UnsafeOpsHolder.U.putFloat(dest + 0L, ontoX * _t4 * _t5_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, ontoY * _t4 * _t5_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, ontoZ * _t4 * _t5_inv);
        return dest;
    }

    public static long project_unsafe(long dest, long src, long onto) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _ontox = UnsafeOpsHolder.U.getFloat(onto + 0L);
        float _ontoy = UnsafeOpsHolder.U.getFloat(onto + 4L);
        float _ontoz = UnsafeOpsHolder.U.getFloat(onto + 8L);
        float _t4 = Math.fma(_ontoz, _selfz, Math.fma(_ontox, _selfx, _ontoy * _selfy));
        float _t5 = Math.fma(_ontoz, _ontoz, Math.fma(_ontox, _ontox, _ontoy * _ontoy));
        float _t5_inv = 1.0f / _t5;
        UnsafeOpsHolder.U.putFloat(dest + 0L, _ontox * _t4 * _t5_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _ontoy * _t4 * _t5_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _ontoz * _t4 * _t5_inv);
        return dest;
    }

    public static long projectOnPlane_unsafe(long dest, long src, float normalX, float normalY, float normalZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t2 = Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-normalX, _t2, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-normalY, _t2, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-normalZ, _t2, _selfz));
        return dest;
    }

    public static long projectOnPlane_unsafe(long dest, long src, long normal) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _normalx = UnsafeOpsHolder.U.getFloat(normal + 0L);
        float _normaly = UnsafeOpsHolder.U.getFloat(normal + 4L);
        float _normalz = UnsafeOpsHolder.U.getFloat(normal + 8L);
        float _t2 = Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-_normalx, _t2, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-_normaly, _t2, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-_normalz, _t2, _selfz));
        return dest;
    }

    public static long radians_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.toRadians(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.toRadians(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.toRadians(_selfz));
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, float normalX, float normalY, float normalZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t3 = 2.0f * Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-normalX, _t3, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-normalY, _t3, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-normalZ, _t3, _selfz));
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, long normal) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _normalx = UnsafeOpsHolder.U.getFloat(normal + 0L);
        float _normaly = UnsafeOpsHolder.U.getFloat(normal + 4L);
        float _normalz = UnsafeOpsHolder.U.getFloat(normal + 8L);
        float _t3 = 2.0f * Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-_normalx, _t3, _selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-_normaly, _t3, _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-_normalz, _t3, _selfz));
        return dest;
    }

    public static long refract_unsafe(long dest, long src, float normalX, float normalY, float normalZ, float eta) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t3 = Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy));
        float _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0f), eta * eta, 1.0f);
        float _t10 = Math.fma(eta, _t3, (float) Math.sqrt(Math.max(0.0f, _t7)));
        if (_t7 >= 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(eta, _selfx, -(normalX * _t10)));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(eta, _selfy, -(normalY * _t10)));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(eta, _selfz, -(normalZ * _t10)));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long refract_unsafe(long dest, long src, long normal, float eta) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _normalx = UnsafeOpsHolder.U.getFloat(normal + 0L);
        float _normaly = UnsafeOpsHolder.U.getFloat(normal + 4L);
        float _normalz = UnsafeOpsHolder.U.getFloat(normal + 8L);
        float _t3 = Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy));
        float _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0f), eta * eta, 1.0f);
        float _t10 = Math.fma(eta, _t3, (float) Math.sqrt(Math.max(0.0f, _t7)));
        if (_t7 >= 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(eta, _selfx, -(_normalx * _t10)));
            UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(eta, _selfy, -(_normaly * _t10)));
            UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(eta, _selfz, -(_normalz * _t10)));
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long round_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.rint(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.rint(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.rint(_selfz));
        return dest;
    }

    public static long sign_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.signum(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.signum(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.signum(_selfz));
        return dest;
    }

    public static long sin_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.sin(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sin(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sin(_selfz));
        return dest;
    }

    public static long sinh_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.sinh(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sinh(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sinh(_selfz));
        return dest;
    }

    public static long smoothstep_unsafe(long dest, long src, float edge0, float edge1) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = edge1 - edge0;
        float _t0_inv = 1.0f / _t0;
        float _t10 = Math.max(0.0f, Math.min(1.0f, (_selfx - edge0) * _t0_inv));
        float _t11 = Math.max(0.0f, Math.min(1.0f, (_selfy - edge0) * _t0_inv));
        float _t12 = Math.max(0.0f, Math.min(1.0f, (_selfz - edge0) * _t0_inv));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, _t10, 3.0f) * _t10 * _t10);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-2.0f, _t11, 3.0f) * _t11 * _t11);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12);
        return dest;
    }

    public static long smoothstep_unsafe(long dest, long src, float edge0X, float edge0Y, float edge0Z, float edge1X, float edge1Y, float edge1Z) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t12 = Math.max(0.0f, Math.min(1.0f, (_selfx - edge0X) / (edge1X - edge0X)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (_selfy - edge0Y) / (edge1Y - edge0Y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (_selfz - edge0Z) / (edge1Z - edge0Z)));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-2.0f, _t13, 3.0f) * _t13 * _t13);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-2.0f, _t14, 3.0f) * _t14 * _t14);
        return dest;
    }

    public static long smoothstep_unsafe(long dest, long src, long edge0, long edge1) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _edge0x = UnsafeOpsHolder.U.getFloat(edge0 + 0L);
        float _edge0y = UnsafeOpsHolder.U.getFloat(edge0 + 4L);
        float _edge0z = UnsafeOpsHolder.U.getFloat(edge0 + 8L);
        float _edge1x = UnsafeOpsHolder.U.getFloat(edge1 + 0L);
        float _edge1y = UnsafeOpsHolder.U.getFloat(edge1 + 4L);
        float _edge1z = UnsafeOpsHolder.U.getFloat(edge1 + 8L);
        float _t12 = Math.max(0.0f, Math.min(1.0f, (_selfx - _edge0x) / (_edge1x - _edge0x)));
        float _t13 = Math.max(0.0f, Math.min(1.0f, (_selfy - _edge0y) / (_edge1y - _edge0y)));
        float _t14 = Math.max(0.0f, Math.min(1.0f, (_selfz - _edge0z) / (_edge1z - _edge0z)));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(-2.0f, _t12, 3.0f) * _t12 * _t12);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(-2.0f, _t13, 3.0f) * _t13 * _t13);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(-2.0f, _t14, 3.0f) * _t14 * _t14);
        return dest;
    }

    public static long sqrt_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.sqrt(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.sqrt(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.sqrt(_selfz));
        return dest;
    }

    public static long step_unsafe(long dest, long src, float edge) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx < edge ? 0.0f : 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy < edge ? 0.0f : 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz < edge ? 0.0f : 1.0f);
        return dest;
    }

    public static long step_unsafe(long dest, long src, float edgeX, float edgeY, float edgeZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx < edgeX ? 0.0f : 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy < edgeY ? 0.0f : 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz < edgeZ ? 0.0f : 1.0f);
        return dest;
    }

    public static long step_unsafe(long dest, long src, long edge) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _edgex = UnsafeOpsHolder.U.getFloat(edge + 0L);
        float _edgey = UnsafeOpsHolder.U.getFloat(edge + 4L);
        float _edgez = UnsafeOpsHolder.U.getFloat(edge + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx < _edgex ? 0.0f : 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy < _edgey ? 0.0f : 1.0f);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz < _edgez ? 0.0f : 1.0f);
        return dest;
    }

    public static long tan_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.tan(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.tan(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.tan(_selfz));
        return dest;
    }

    public static long tanh_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, (float) Math.tanh(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, (float) Math.tanh(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, (float) Math.tanh(_selfz));
        return dest;
    }

    public static long triangleNormal_unsafe(long dest, long src, float p1X, float p1Y, float p1Z, float p2X, float p2Y, float p2Z) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = p1X - _selfx;
        float _t1 = p2Y - _selfy;
        float _t2 = p1Y - _selfy;
        float _t3 = p2X - _selfx;
        float _t4 = p2Z - _selfz;
        float _t5 = p1Z - _selfz;
        float _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        float _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        float _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        float _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        float _t18 = (1.0f / (float) Math.sqrt(_t17));
        if (_t17 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t13 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t14 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t12 * _t18);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long triangleNormal_unsafe(long dest, long src, long p1, long p2) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _p1x = UnsafeOpsHolder.U.getFloat(p1 + 0L);
        float _p1y = UnsafeOpsHolder.U.getFloat(p1 + 4L);
        float _p1z = UnsafeOpsHolder.U.getFloat(p1 + 8L);
        float _p2x = UnsafeOpsHolder.U.getFloat(p2 + 0L);
        float _p2y = UnsafeOpsHolder.U.getFloat(p2 + 4L);
        float _p2z = UnsafeOpsHolder.U.getFloat(p2 + 8L);
        float _t0 = _p1x - _selfx;
        float _t1 = _p2y - _selfy;
        float _t2 = _p1y - _selfy;
        float _t3 = _p2x - _selfx;
        float _t4 = _p2z - _selfz;
        float _t5 = _p1z - _selfz;
        float _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        float _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        float _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        float _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        float _t18 = (1.0f / (float) Math.sqrt(_t17));
        if (_t17 > 0.0f) {
            UnsafeOpsHolder.U.putFloat(dest + 0L, _t13 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 4L, _t14 * _t18);
            UnsafeOpsHolder.U.putFloat(dest + 8L, _t12 * _t18);
        } else {
            UnsafeOpsHolder.U.putFloat(dest + 0L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 4L, 0.0f);
            UnsafeOpsHolder.U.putFloat(dest + 8L, 0.0f);
        }
        return dest;
    }

    public static long trunc_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx >= 0.0f ? (float) Math.floor(_selfx) : (float) Math.ceil(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy >= 0.0f ? (float) Math.floor(_selfy) : (float) Math.ceil(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz >= 0.0f ? (float) Math.floor(_selfz) : (float) Math.ceil(_selfz));
        return dest;
    }

    public static long ulp_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.ulp(_selfx));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.ulp(_selfy));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.ulp(_selfz));
        return dest;
    }

    public static long xyz0_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 0.0f);
        return dest;
    }

    public static long xyz1_unsafe(long dest, long src) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        UnsafeOpsHolder.U.putFloat(dest + 12L, 1.0f);
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long mat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _mat00 = UnsafeOpsHolder.U.getFloat(mat + 0L);
        float _mat10 = UnsafeOpsHolder.U.getFloat(mat + 4L);
        float _mat20 = UnsafeOpsHolder.U.getFloat(mat + 8L);
        float _mat01 = UnsafeOpsHolder.U.getFloat(mat + 12L);
        float _mat11 = UnsafeOpsHolder.U.getFloat(mat + 16L);
        float _mat21 = UnsafeOpsHolder.U.getFloat(mat + 20L);
        float _mat02 = UnsafeOpsHolder.U.getFloat(mat + 24L);
        float _mat12 = UnsafeOpsHolder.U.getFloat(mat + 28L);
        float _mat22 = UnsafeOpsHolder.U.getFloat(mat + 32L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        return dest;
    }

    public static long preMulDirectionMat3x4_unsafe(long dest, long src, long mat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _mat00 = UnsafeOpsHolder.U.getFloat(mat + 0L);
        float _mat01 = UnsafeOpsHolder.U.getFloat(mat + 4L);
        float _mat02 = UnsafeOpsHolder.U.getFloat(mat + 8L);
        float _mat10 = UnsafeOpsHolder.U.getFloat(mat + 16L);
        float _mat11 = UnsafeOpsHolder.U.getFloat(mat + 20L);
        float _mat12 = UnsafeOpsHolder.U.getFloat(mat + 24L);
        float _mat20 = UnsafeOpsHolder.U.getFloat(mat + 32L);
        float _mat21 = UnsafeOpsHolder.U.getFloat(mat + 36L);
        float _mat22 = UnsafeOpsHolder.U.getFloat(mat + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        return dest;
    }

    public static long preMulDirectionMat4x4_unsafe(long dest, long src, long mat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _mat00 = UnsafeOpsHolder.U.getFloat(mat + 0L);
        float _mat10 = UnsafeOpsHolder.U.getFloat(mat + 4L);
        float _mat20 = UnsafeOpsHolder.U.getFloat(mat + 8L);
        float _mat01 = UnsafeOpsHolder.U.getFloat(mat + 16L);
        float _mat11 = UnsafeOpsHolder.U.getFloat(mat + 20L);
        float _mat21 = UnsafeOpsHolder.U.getFloat(mat + 24L);
        float _mat02 = UnsafeOpsHolder.U.getFloat(mat + 32L);
        float _mat12 = UnsafeOpsHolder.U.getFloat(mat + 36L);
        float _mat22 = UnsafeOpsHolder.U.getFloat(mat + 40L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        return dest;
    }

    public static long preMulPositionMat3x4_unsafe(long dest, long src, long mat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _mat00 = UnsafeOpsHolder.U.getFloat(mat + 0L);
        float _mat01 = UnsafeOpsHolder.U.getFloat(mat + 4L);
        float _mat02 = UnsafeOpsHolder.U.getFloat(mat + 8L);
        float _mat03 = UnsafeOpsHolder.U.getFloat(mat + 12L);
        float _mat10 = UnsafeOpsHolder.U.getFloat(mat + 16L);
        float _mat11 = UnsafeOpsHolder.U.getFloat(mat + 20L);
        float _mat12 = UnsafeOpsHolder.U.getFloat(mat + 24L);
        float _mat13 = UnsafeOpsHolder.U.getFloat(mat + 28L);
        float _mat20 = UnsafeOpsHolder.U.getFloat(mat + 32L);
        float _mat21 = UnsafeOpsHolder.U.getFloat(mat + 36L);
        float _mat22 = UnsafeOpsHolder.U.getFloat(mat + 40L);
        float _mat23 = UnsafeOpsHolder.U.getFloat(mat + 44L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, Math.fma(_mat02, _selfz, _mat03))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, Math.fma(_mat12, _selfz, _mat13))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_mat20, _selfx, Math.fma(_mat21, _selfy, Math.fma(_mat22, _selfz, _mat23))));
        return dest;
    }

    public static long preMulPositionMat4x4_unsafe(long dest, long src, long mat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _mat00 = UnsafeOpsHolder.U.getFloat(mat + 0L);
        float _mat10 = UnsafeOpsHolder.U.getFloat(mat + 4L);
        float _mat20 = UnsafeOpsHolder.U.getFloat(mat + 8L);
        float _mat01 = UnsafeOpsHolder.U.getFloat(mat + 16L);
        float _mat11 = UnsafeOpsHolder.U.getFloat(mat + 20L);
        float _mat21 = UnsafeOpsHolder.U.getFloat(mat + 24L);
        float _mat02 = UnsafeOpsHolder.U.getFloat(mat + 32L);
        float _mat12 = UnsafeOpsHolder.U.getFloat(mat + 36L);
        float _mat22 = UnsafeOpsHolder.U.getFloat(mat + 40L);
        float _mat03 = UnsafeOpsHolder.U.getFloat(mat + 48L);
        float _mat13 = UnsafeOpsHolder.U.getFloat(mat + 52L);
        float _mat23 = UnsafeOpsHolder.U.getFloat(mat + 56L);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, Math.fma(_mat02, _selfz, _mat03))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, Math.fma(_mat12, _selfz, _mat13))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_mat20, _selfx, Math.fma(_mat21, _selfy, Math.fma(_mat22, _selfz, _mat23))));
        return dest;
    }

    public static long preMulProject_unsafe(long dest, long src, long mat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _mat00 = UnsafeOpsHolder.U.getFloat(mat + 0L);
        float _mat10 = UnsafeOpsHolder.U.getFloat(mat + 4L);
        float _mat20 = UnsafeOpsHolder.U.getFloat(mat + 8L);
        float _mat30 = UnsafeOpsHolder.U.getFloat(mat + 12L);
        float _mat01 = UnsafeOpsHolder.U.getFloat(mat + 16L);
        float _mat11 = UnsafeOpsHolder.U.getFloat(mat + 20L);
        float _mat21 = UnsafeOpsHolder.U.getFloat(mat + 24L);
        float _mat31 = UnsafeOpsHolder.U.getFloat(mat + 28L);
        float _mat02 = UnsafeOpsHolder.U.getFloat(mat + 32L);
        float _mat12 = UnsafeOpsHolder.U.getFloat(mat + 36L);
        float _mat22 = UnsafeOpsHolder.U.getFloat(mat + 40L);
        float _mat32 = UnsafeOpsHolder.U.getFloat(mat + 44L);
        float _mat03 = UnsafeOpsHolder.U.getFloat(mat + 48L);
        float _mat13 = UnsafeOpsHolder.U.getFloat(mat + 52L);
        float _mat23 = UnsafeOpsHolder.U.getFloat(mat + 56L);
        float _mat33 = UnsafeOpsHolder.U.getFloat(mat + 60L);
        float _t2 = Math.fma(_mat30, _selfx, Math.fma(_mat31, _selfy, Math.fma(_mat32, _selfz, _mat33)));
        float _t2_inv = 1.0f / _t2;
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, Math.fma(_mat02, _selfz, _mat03))) * _t2_inv);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, Math.fma(_mat12, _selfz, _mat13))) * _t2_inv);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_mat20, _selfx, Math.fma(_mat21, _selfy, Math.fma(_mat22, _selfz, _mat23))) * _t2_inv);
        return dest;
    }

    public static long rotate_unsafe(long dest, long src, float quatX, float quatY, float quatZ, float quatW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t9 = 2.0f * Math.fma(quatX, _selfy, -(quatY * _selfx));
        float _t10 = 2.0f * Math.fma(quatZ, _selfx, -(quatX * _selfz));
        float _t11 = 2.0f * Math.fma(quatY, _selfz, -(quatZ * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, _selfx))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, _selfy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, _selfz))));
        return dest;
    }

    public static long rotate_unsafe(long dest, long src, long quat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _quatx = UnsafeOpsHolder.U.getFloat(quat + 0L);
        float _quaty = UnsafeOpsHolder.U.getFloat(quat + 4L);
        float _quatz = UnsafeOpsHolder.U.getFloat(quat + 8L);
        float _quatw = UnsafeOpsHolder.U.getFloat(quat + 12L);
        float _t9 = 2.0f * Math.fma(_quatx, _selfy, -(_quaty * _selfx));
        float _t10 = 2.0f * Math.fma(_quatz, _selfx, -(_quatx * _selfz));
        float _t11 = 2.0f * Math.fma(_quaty, _selfz, -(_quatz * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_quaty, _t9, Math.fma(-_quatz, _t10, Math.fma(_quatw, _t11, _selfx))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_quatz, _t11, Math.fma(-_quatx, _t9, Math.fma(_quatw, _t10, _selfy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_quatx, _t10, Math.fma(-_quaty, _t11, Math.fma(_quatw, _t9, _selfz))));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, float angle, float axisX, float axisY, float axisZ) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t5 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t2, axisX * _t5, Math.fma(_selfx, _t0, Math.fma(axisY, _selfz, -(axisZ * _selfy)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, axisY * _t5, Math.fma(_selfy, _t0, Math.fma(axisZ, _selfx, -(axisX * _selfz)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t2, axisZ * _t5, Math.fma(_selfz, _t0, Math.fma(axisX, _selfy, -(axisY * _selfx)) * _t1)));
        return dest;
    }

    public static long rotateAxis_unsafe(long dest, long src, long axis, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _axisx = UnsafeOpsHolder.U.getFloat(axis + 0L);
        float _axisy = UnsafeOpsHolder.U.getFloat(axis + 4L);
        float _axisz = UnsafeOpsHolder.U.getFloat(axis + 8L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        float _t2 = 1.0f - _t0;
        float _t5 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_t2, _axisx * _t5, Math.fma(_selfx, _t0, Math.fma(_axisy, _selfz, -(_axisz * _selfy)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_t2, _axisy * _t5, Math.fma(_selfy, _t0, Math.fma(_axisz, _selfx, -(_axisx * _selfz)) * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_t2, _axisz * _t5, Math.fma(_selfz, _t0, Math.fma(_axisx, _selfy, -(_axisy * _selfx)) * _t1)));
        return dest;
    }

    public static long rotateInverse_unsafe(long dest, long src, float quatX, float quatY, float quatZ, float quatW) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t9 = 2.0f * Math.fma(quatX, _selfz, -(quatZ * _selfx));
        float _t10 = 2.0f * Math.fma(quatY, _selfx, -(quatX * _selfy));
        float _t11 = 2.0f * Math.fma(quatZ, _selfy, -(quatY * _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, _selfx))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, _selfy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, _selfz))));
        return dest;
    }

    public static long rotateInverse_unsafe(long dest, long src, long quat) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _quatx = UnsafeOpsHolder.U.getFloat(quat + 0L);
        float _quaty = UnsafeOpsHolder.U.getFloat(quat + 4L);
        float _quatz = UnsafeOpsHolder.U.getFloat(quat + 8L);
        float _quatw = UnsafeOpsHolder.U.getFloat(quat + 12L);
        float _t9 = 2.0f * Math.fma(_quatx, _selfz, -(_quatz * _selfx));
        float _t10 = 2.0f * Math.fma(_quaty, _selfx, -(_quatx * _selfy));
        float _t11 = 2.0f * Math.fma(_quatz, _selfy, -(_quaty * _selfz));
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_quatz, _t9, Math.fma(-_quaty, _t10, Math.fma(_quatw, _t11, _selfx))));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_quatx, _t10, Math.fma(-_quatz, _t11, Math.fma(_quatw, _t9, _selfy))));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_quaty, _t11, Math.fma(-_quatx, _t9, Math.fma(_quatw, _t10, _selfz))));
        return dest;
    }

    public static long rotateX_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, _selfx);
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfy, _t0, -(_selfz * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfy, _t1, _selfz * _t0));
        return dest;
    }

    public static long rotateY_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t0, _selfz * _t1));
        UnsafeOpsHolder.U.putFloat(dest + 4L, _selfy);
        UnsafeOpsHolder.U.putFloat(dest + 8L, Math.fma(_selfz, _t0, -(_selfx * _t1)));
        return dest;
    }

    public static long rotateZ_unsafe(long dest, long src, float angle) {
        float _selfx = UnsafeOpsHolder.U.getFloat(src + 0L);
        float _selfy = UnsafeOpsHolder.U.getFloat(src + 4L);
        float _selfz = UnsafeOpsHolder.U.getFloat(src + 8L);
        float _t0 = (float) Math.cos(angle);
        float _t1 = (float) Math.sin(angle);
        UnsafeOpsHolder.U.putFloat(dest + 0L, Math.fma(_selfx, _t0, -(_selfy * _t1)));
        UnsafeOpsHolder.U.putFloat(dest + 4L, Math.fma(_selfx, _t1, _selfy * _t0));
        UnsafeOpsHolder.U.putFloat(dest + 8L, _selfz);
        return dest;
    }

}
