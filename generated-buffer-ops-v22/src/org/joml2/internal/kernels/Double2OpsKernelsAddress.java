package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double2Ops} whose leading storage
 * parameter is a raw {@code long} native address (the shared Unsafe kernels). Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double2Ops} and its sibling kernel units. Not public API.
 */
public final class Double2OpsKernelsAddress {
    private Double2OpsKernelsAddress() {}

    public static long add_unsafe(long dest, long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, otherX + _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, otherY + _selfy);
        return dest;
    }

    public static long add_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _otherx + _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _othery + _selfy);
        return dest;
    }

    public static long div_unsafe(long dest, long src, double scalar) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _rcp0 = 1.0 / scalar;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _rcp0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _rcp0);
        return dest;
    }

    public static long div_unsafe(long dest, long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx / otherX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy / otherY);
        return dest;
    }

    public static long div_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx / _otherx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy / _othery);
        return dest;
    }

    public static long fma_unsafe(long dest, long src, double b, double cX, double cY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, b, cX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, b, cY));
        return dest;
    }

    public static long fma_unsafe(long dest, long src, long c, double b) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _cx = UnsafeOpsHolder.U.getDouble(c + 0L);
        double _cy = UnsafeOpsHolder.U.getDouble(c + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, b, _cx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, b, _cy));
        return dest;
    }

    public static long fma_unsafe(long dest, long src, double bX, double bY, double cX, double cY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, bX, cX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, bY, cY));
        return dest;
    }

    public static long fma_unsafe(long dest, long src, long b, long c) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _bx = UnsafeOpsHolder.U.getDouble(b + 0L);
        double _by = UnsafeOpsHolder.U.getDouble(b + 8L);
        double _cx = UnsafeOpsHolder.U.getDouble(c + 0L);
        double _cy = UnsafeOpsHolder.U.getDouble(c + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _bx, _cx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _by, _cy));
        return dest;
    }

    public static long mul_unsafe(long dest, long src, double scalar) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, scalar * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, scalar * _selfy);
        return dest;
    }

    public static long mul_unsafe(long dest, long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, otherX * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, otherY * _selfy);
        return dest;
    }

    public static long mul_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _otherx * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _othery * _selfy);
        return dest;
    }

    public static long negate_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, -_selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, -_selfy);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx - otherX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy - otherY);
        return dest;
    }

    public static long sub_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx - _otherx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy - _othery);
        return dest;
    }

    public static long set_unsafe(long dest, double vX, double vY) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, vX);
        UnsafeOpsHolder.U.putDouble(dest + 8L, vY);
        return dest;
    }

    public static long set_unsafe(long dest, long v) {
        double _vx = UnsafeOpsHolder.U.getDouble(v + 0L);
        double _vy = UnsafeOpsHolder.U.getDouble(v + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _vx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _vy);
        return dest;
    }

    public static long set_unsafe(long dest, double s) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, s);
        UnsafeOpsHolder.U.putDouble(dest + 8L, s);
        return dest;
    }

    public static long makeZero_unsafe(long dest) {
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        return dest;
    }

    public static long bezier_unsafe(long dest, long src, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(p1X, _t7, _selfx * _t8) + Math.fma(p2X, _t6, p3X * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(p1Y, _t7, _selfy * _t8) + Math.fma(p2Y, _t6, p3Y * _t2));
        return dest;
    }

    public static long bezier_unsafe(long dest, long src, long p1, long p2, long p3, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _p1x = UnsafeOpsHolder.U.getDouble(p1 + 0L);
        double _p1y = UnsafeOpsHolder.U.getDouble(p1 + 8L);
        double _p2x = UnsafeOpsHolder.U.getDouble(p2 + 0L);
        double _p2y = UnsafeOpsHolder.U.getDouble(p2 + 8L);
        double _p3x = UnsafeOpsHolder.U.getDouble(p3 + 0L);
        double _p3y = UnsafeOpsHolder.U.getDouble(p3 + 8L);
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_p1x, _t7, _selfx * _t8) + Math.fma(_p2x, _t6, _p3x * _t2));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_p1y, _t7, _selfy * _t8) + Math.fma(_p2y, _t6, _p3y * _t2));
        return dest;
    }

    public static long bezier2_unsafe(long dest, long src, double p1X, double p1Y, double p2X, double p2Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(p2X, _t0, Math.fma(p1X, _t3, _selfx * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, _selfy * _t4)));
        return dest;
    }

    public static long bezier2_unsafe(long dest, long src, long p1, long p2, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _p1x = UnsafeOpsHolder.U.getDouble(p1 + 0L);
        double _p1y = UnsafeOpsHolder.U.getDouble(p1 + 8L);
        double _p2x = UnsafeOpsHolder.U.getDouble(p2 + 0L);
        double _p2y = UnsafeOpsHolder.U.getDouble(p2 + 8L);
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_p2x, _t0, Math.fma(_p1x, _t3, _selfx * _t4)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_p2y, _t0, Math.fma(_p1y, _t3, _selfy * _t4)));
        return dest;
    }

    public static long bezier2Tangent_unsafe(long dest, long src, double p1X, double p1Y, double p2X, double p2Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(p1X - _selfx, _t2, (p2X - p1X) * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(p1Y - _selfy, _t2, (p2Y - p1Y) * _t1));
        return dest;
    }

    public static long bezier2Tangent_unsafe(long dest, long src, long p1, long p2, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _p1x = UnsafeOpsHolder.U.getDouble(p1 + 0L);
        double _p1y = UnsafeOpsHolder.U.getDouble(p1 + 8L);
        double _p2x = UnsafeOpsHolder.U.getDouble(p2 + 0L);
        double _p2y = UnsafeOpsHolder.U.getDouble(p2 + 8L);
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_p1x - _selfx, _t2, (_p2x - _p1x) * _t1));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_p1y - _selfy, _t2, (_p2y - _p1y) * _t1));
        return dest;
    }

    public static long bezierTangent_unsafe(long dest, long src, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(p3X - p2X, _t2, Math.fma(p1X - _selfx, _t6, (p2X - p1X) * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - _selfy, _t6, (p2Y - p1Y) * _t5)));
        return dest;
    }

    public static long bezierTangent_unsafe(long dest, long src, long p1, long p2, long p3, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _p1x = UnsafeOpsHolder.U.getDouble(p1 + 0L);
        double _p1y = UnsafeOpsHolder.U.getDouble(p1 + 8L);
        double _p2x = UnsafeOpsHolder.U.getDouble(p2 + 0L);
        double _p2y = UnsafeOpsHolder.U.getDouble(p2 + 8L);
        double _p3x = UnsafeOpsHolder.U.getDouble(p3 + 0L);
        double _p3y = UnsafeOpsHolder.U.getDouble(p3 + 8L);
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_p3x - _p2x, _t2, Math.fma(_p1x - _selfx, _t6, (_p2x - _p1x) * _t5)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_p3y - _p2y, _t2, Math.fma(_p1y - _selfy, _t6, (_p2y - _p1y) * _t5)));
        return dest;
    }

    public static long catmullRom_unsafe(long dest, long src, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = t * t;
        double _t1 = t * _t0;
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * (Math.fma(2.0, p1X, t * (p2X - _selfx)) + Math.fma(Math.fma(-5.0, p1X, Math.fma(2.0, _selfx, Math.fma(4.0, p2X, -p3X))), _t0, Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - _selfx)) * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * (Math.fma(2.0, p1Y, t * (p2Y - _selfy)) + Math.fma(Math.fma(-5.0, p1Y, Math.fma(2.0, _selfy, Math.fma(4.0, p2Y, -p3Y))), _t0, Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - _selfy)) * _t1)));
        return dest;
    }

    public static long catmullRom_unsafe(long dest, long src, long p1, long p2, long p3, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _p1x = UnsafeOpsHolder.U.getDouble(p1 + 0L);
        double _p1y = UnsafeOpsHolder.U.getDouble(p1 + 8L);
        double _p2x = UnsafeOpsHolder.U.getDouble(p2 + 0L);
        double _p2y = UnsafeOpsHolder.U.getDouble(p2 + 8L);
        double _p3x = UnsafeOpsHolder.U.getDouble(p3 + 0L);
        double _p3y = UnsafeOpsHolder.U.getDouble(p3 + 8L);
        double _t0 = t * t;
        double _t1 = t * _t0;
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * (Math.fma(2.0, _p1x, t * (_p2x - _selfx)) + Math.fma(Math.fma(-5.0, _p1x, Math.fma(2.0, _selfx, Math.fma(4.0, _p2x, -_p3x))), _t0, Math.fma(-3.0, _p2x, Math.fma(3.0, _p1x, _p3x - _selfx)) * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * (Math.fma(2.0, _p1y, t * (_p2y - _selfy)) + Math.fma(Math.fma(-5.0, _p1y, Math.fma(2.0, _selfy, Math.fma(4.0, _p2y, -_p3y))), _t0, Math.fma(-3.0, _p2y, Math.fma(3.0, _p1y, _p3y - _selfy)) * _t1)));
        return dest;
    }

    public static long catmullRomTangent_unsafe(long dest, long src, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = t * t;
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1X, Math.fma(2.0, _selfx, Math.fma(4.0, p2X, -p3X))), Math.fma(3.0 * Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - _selfx)), _t0, p2X - _selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Y, Math.fma(2.0, _selfy, Math.fma(4.0, p2Y, -p3Y))), Math.fma(3.0 * Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - _selfy)), _t0, p2Y - _selfy)));
        return dest;
    }

    public static long catmullRomTangent_unsafe(long dest, long src, long p1, long p2, long p3, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _p1x = UnsafeOpsHolder.U.getDouble(p1 + 0L);
        double _p1y = UnsafeOpsHolder.U.getDouble(p1 + 8L);
        double _p2x = UnsafeOpsHolder.U.getDouble(p2 + 0L);
        double _p2y = UnsafeOpsHolder.U.getDouble(p2 + 8L);
        double _p3x = UnsafeOpsHolder.U.getDouble(p3 + 0L);
        double _p3y = UnsafeOpsHolder.U.getDouble(p3 + 8L);
        double _t0 = t * t;
        UnsafeOpsHolder.U.putDouble(dest + 0L, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1x, Math.fma(2.0, _selfx, Math.fma(4.0, _p2x, -_p3x))), Math.fma(3.0 * Math.fma(-3.0, _p2x, Math.fma(3.0, _p1x, _p3x - _selfx)), _t0, _p2x - _selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1y, Math.fma(2.0, _selfy, Math.fma(4.0, _p2y, -_p3y))), Math.fma(3.0 * Math.fma(-3.0, _p2y, Math.fma(3.0, _p1y, _p3y - _selfy)), _t0, _p2y - _selfy)));
        return dest;
    }

    public static long hermite_unsafe(long dest, long src, double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9));
        return dest;
    }

    public static long hermite_unsafe(long dest, long src, long t0, long v1, long t1, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0x = UnsafeOpsHolder.U.getDouble(t0 + 0L);
        double _t0y = UnsafeOpsHolder.U.getDouble(t0 + 8L);
        double _v1x = UnsafeOpsHolder.U.getDouble(v1 + 0L);
        double _v1y = UnsafeOpsHolder.U.getDouble(v1 + 8L);
        double _t1x = UnsafeOpsHolder.U.getDouble(t1 + 0L);
        double _t1y = UnsafeOpsHolder.U.getDouble(t1 + 8L);
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t10, _t0x * _t7) + Math.fma(_t1x, _t5, _v1x * _t9));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t10, _t0y * _t7) + Math.fma(_t1y, _t5, _v1y * _t9));
        return dest;
    }

    public static long hermiteTangent_unsafe(long dest, long src, double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7));
        return dest;
    }

    public static long hermiteTangent_unsafe(long dest, long src, long t0, long v1, long t1, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0x = UnsafeOpsHolder.U.getDouble(t0 + 0L);
        double _t0y = UnsafeOpsHolder.U.getDouble(t0 + 8L);
        double _v1x = UnsafeOpsHolder.U.getDouble(v1 + 0L);
        double _v1y = UnsafeOpsHolder.U.getDouble(v1 + 8L);
        double _t1x = UnsafeOpsHolder.U.getDouble(t1 + 0L);
        double _t1y = UnsafeOpsHolder.U.getDouble(t1 + 8L);
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t6, _t0x * _t9) + Math.fma(_t1x, _t8, _v1x * _t7));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfy, _t6, _t0y * _t9) + Math.fma(_t1y, _t8, _v1y * _t7));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, double otherX, double otherY, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(t, otherX - _selfx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(t, otherY - _selfy, _selfy));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, double t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(t, _otherx - _selfx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(t, _othery - _selfy, _selfy));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, double otherX, double otherY, double tX, double tY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(tX, otherX - _selfx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(tY, otherY - _selfy, _selfy));
        return dest;
    }

    public static long lerp_unsafe(long dest, long src, long other, long t) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _tx = UnsafeOpsHolder.U.getDouble(t + 0L);
        double _ty = UnsafeOpsHolder.U.getDouble(t + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_tx, _otherx - _selfx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_ty, _othery - _selfy, _selfy));
        return dest;
    }

    public static long absolute_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.abs(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.abs(_selfy));
        return dest;
    }

    public static long acos_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.acos(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.acos(_selfy));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, double bX, double bY, double scalar) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(scalar, bX, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(scalar, bY, _selfy));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, long b, double scalar) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _bx = UnsafeOpsHolder.U.getDouble(b + 0L);
        double _by = UnsafeOpsHolder.U.getDouble(b + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(scalar, _bx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(scalar, _by, _selfy));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, double bX, double bY, double cX, double cY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(bX, cX, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(bY, cY, _selfy));
        return dest;
    }

    public static long addScaled_unsafe(long dest, long src, long b, long c) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _bx = UnsafeOpsHolder.U.getDouble(b + 0L);
        double _by = UnsafeOpsHolder.U.getDouble(b + 8L);
        double _cx = UnsafeOpsHolder.U.getDouble(c + 0L);
        double _cy = UnsafeOpsHolder.U.getDouble(c + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_bx, _cx, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_by, _cy, _selfy));
        return dest;
    }

    public static double angleBetween_unsafe(long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.atan2(Math.abs(Math.fma(otherY, _selfx, -(otherX * _selfy))), Math.fma(otherX, _selfx, otherY * _selfy));
    }

    public static double angleBetween_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        return Math.atan2(Math.abs(Math.fma(_othery, _selfx, -(_otherx * _selfy))), Math.fma(_otherx, _selfx, _othery * _selfy));
    }

    public static long asin_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.asin(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.asin(_selfy));
        return dest;
    }

    public static long atan_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan(_selfy));
        return dest;
    }

    public static long atan2_unsafe(long dest, long src, double x) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_selfx, x));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_selfy, x));
        return dest;
    }

    public static long atan2_unsafe(long dest, long src, double xX, double xY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_selfx, xX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_selfy, xY));
        return dest;
    }

    public static long atan2_unsafe(long dest, long src, long x) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _xx = UnsafeOpsHolder.U.getDouble(x + 0L);
        double _xy = UnsafeOpsHolder.U.getDouble(x + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.atan2(_selfx, _xx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.atan2(_selfy, _xy));
        return dest;
    }

    public static long cbrt_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.cbrt(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.cbrt(_selfy));
        return dest;
    }

    public static long ceil_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.ceil(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.ceil(_selfy));
        return dest;
    }

    public static long clamp_unsafe(long dest, long src, double min, double max) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.min(Math.max(_selfx, min), max));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.min(Math.max(_selfy, min), max));
        return dest;
    }

    public static long clamp_unsafe(long dest, long src, double minX, double minY, double maxX, double maxY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.min(Math.max(_selfx, minX), maxX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.min(Math.max(_selfy, minY), maxY));
        return dest;
    }

    public static long clamp_unsafe(long dest, long src, long min, long max) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _minx = UnsafeOpsHolder.U.getDouble(min + 0L);
        double _miny = UnsafeOpsHolder.U.getDouble(min + 8L);
        double _maxx = UnsafeOpsHolder.U.getDouble(max + 0L);
        double _maxy = UnsafeOpsHolder.U.getDouble(max + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.min(Math.max(_selfx, _minx), _maxx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.min(Math.max(_selfy, _miny), _maxy));
        return dest;
    }

    public static double compAdd_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return _selfx + _selfy;
    }

    public static double compMax_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.max(_selfx, _selfy);
    }

    public static double compMin_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.min(_selfx, _selfy);
    }

    public static double compMul_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return _selfx * _selfy;
    }

    public static long copySign_unsafe(long dest, long src, double sign) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.copySign(_selfx, sign));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.copySign(_selfy, sign));
        return dest;
    }

    public static long copySign_unsafe(long dest, long src, double signX, double signY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.copySign(_selfx, signX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.copySign(_selfy, signY));
        return dest;
    }

    public static long copySign_unsafe(long dest, long src, long sign) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _signx = UnsafeOpsHolder.U.getDouble(sign + 0L);
        double _signy = UnsafeOpsHolder.U.getDouble(sign + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.copySign(_selfx, _signx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.copySign(_selfy, _signy));
        return dest;
    }

    public static long cos_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.cos(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.cos(_selfy));
        return dest;
    }

    public static long cosh_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.cosh(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.cosh(_selfy));
        return dest;
    }

    public static long degrees_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.toDegrees(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.toDegrees(_selfy));
        return dest;
    }

    public static double distance_unsafe(long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = _selfx - otherX;
        double _t1 = _selfy - otherY;
        return Math.sqrt(Math.fma(_t0, _t0, _t1 * _t1));
    }

    public static double distance_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _t0 = _selfx - _otherx;
        double _t1 = _selfy - _othery;
        return Math.sqrt(Math.fma(_t0, _t0, _t1 * _t1));
    }

    public static double distanceSquared_unsafe(long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = _selfx - otherX;
        double _t1 = _selfy - otherY;
        return Math.fma(_t0, _t0, _t1 * _t1);
    }

    public static double distanceSquared_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        double _t0 = _selfx - _otherx;
        double _t1 = _selfy - _othery;
        return Math.fma(_t0, _t0, _t1 * _t1);
    }

    public static double dot_unsafe(long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.fma(otherX, _selfx, otherY * _selfy);
    }

    public static double dot_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        return Math.fma(_otherx, _selfx, _othery * _selfy);
    }

    public static long exp_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.exp(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.exp(_selfy));
        return dest;
    }

    public static long exp2_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.pow(2.0, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.pow(2.0, _selfy));
        return dest;
    }

    public static long expm1_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.expm1(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.expm1(_selfy));
        return dest;
    }

    public static long faceforward_unsafe(long dest, long src, double IX, double IY, double NrefX, double NrefY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t1 = Math.fma(IX, NrefX, IY * NrefY);
        if (_t1 < 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -_selfx);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -_selfy);
        }
        return dest;
    }

    public static long faceforward_unsafe(long dest, long src, long I, long Nref) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _Ix = UnsafeOpsHolder.U.getDouble(I + 0L);
        double _Iy = UnsafeOpsHolder.U.getDouble(I + 8L);
        double _Nrefx = UnsafeOpsHolder.U.getDouble(Nref + 0L);
        double _Nrefy = UnsafeOpsHolder.U.getDouble(Nref + 8L);
        double _t1 = Math.fma(_Ix, _Nrefx, _Iy * _Nrefy);
        if (_t1 < 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, -_selfx);
            UnsafeOpsHolder.U.putDouble(dest + 8L, -_selfy);
        }
        return dest;
    }

    public static long floor_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.floor(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.floor(_selfy));
        return dest;
    }

    public static long fract_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx - Math.floor(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy - Math.floor(_selfy));
        return dest;
    }

    public static long hypot_unsafe(long dest, long src, double y) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.hypot(_selfx, y));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.hypot(_selfy, y));
        return dest;
    }

    public static long hypot_unsafe(long dest, long src, double yX, double yY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.hypot(_selfx, yX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.hypot(_selfy, yY));
        return dest;
    }

    public static long hypot_unsafe(long dest, long src, long y) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _yx = UnsafeOpsHolder.U.getDouble(y + 0L);
        double _yy = UnsafeOpsHolder.U.getDouble(y + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.hypot(_selfx, _yx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.hypot(_selfy, _yy));
        return dest;
    }

    public static long inverse_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, 1.0 / _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, 1.0 / _selfy);
        return dest;
    }

    public static long inverseSqrt_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, (1.0 / Math.sqrt(_selfx)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, (1.0 / Math.sqrt(_selfy)));
        return dest;
    }

    public static double length_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.sqrt(Math.fma(_selfx, _selfx, _selfy * _selfy));
    }

    public static double lengthSquared_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.fma(_selfx, _selfx, _selfy * _selfy);
    }

    public static long log_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.log(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.log(_selfy));
        return dest;
    }

    public static long log10_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.log10(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.log10(_selfy));
        return dest;
    }

    public static long log1p_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.log1p(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.log1p(_selfy));
        return dest;
    }

    public static long log2_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = Math.log(2.0);
        double _t0_inv = 1.0 / _t0;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.log(_selfx) * _t0_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.log(_selfy) * _t0_inv);
        return dest;
    }

    public static double manhattanDistance_unsafe(long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.abs(_selfx - otherX) + Math.abs(_selfy - otherY);
    }

    public static double manhattanDistance_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        return Math.abs(_selfx - _otherx) + Math.abs(_selfy - _othery);
    }

    public static double manhattanLength_unsafe(long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.abs(_selfx) + Math.abs(_selfy);
    }

    public static long max_unsafe(long dest, long src, double scalar) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.max(_selfx, scalar));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.max(_selfy, scalar));
        return dest;
    }

    public static long max_unsafe(long dest, long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.max(_selfx, otherX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.max(_selfy, otherY));
        return dest;
    }

    public static long max_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.max(_selfx, _otherx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.max(_selfy, _othery));
        return dest;
    }

    public static long min_unsafe(long dest, long src, double scalar) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.min(_selfx, scalar));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.min(_selfy, scalar));
        return dest;
    }

    public static long min_unsafe(long dest, long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.min(_selfx, otherX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.min(_selfy, otherY));
        return dest;
    }

    public static long min_unsafe(long dest, long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.min(_selfx, _otherx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.min(_selfy, _othery));
        return dest;
    }

    public static long mod_unsafe(long dest, long src, double y) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _rcp0 = 1.0 / y;
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-y, Math.floor(_selfx * _rcp0), _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-y, Math.floor(_selfy * _rcp0), _selfy));
        return dest;
    }

    public static long mod_unsafe(long dest, long src, double yX, double yY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-yX, Math.floor(_selfx / yX), _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-yY, Math.floor(_selfy / yY), _selfy));
        return dest;
    }

    public static long mod_unsafe(long dest, long src, long y) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _yx = UnsafeOpsHolder.U.getDouble(y + 0L);
        double _yy = UnsafeOpsHolder.U.getDouble(y + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-_yx, Math.floor(_selfx / _yx), _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-_yy, Math.floor(_selfy / _yy), _selfy));
        return dest;
    }

    public static long nextDown_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.nextDown(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.nextDown(_selfy));
        return dest;
    }

    public static long nextUp_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.nextUp(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.nextUp(_selfy));
        return dest;
    }

    public static long normalize_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t1 = Math.fma(_selfx, _selfx, _selfy * _selfy);
        double _t2 = (1.0 / Math.sqrt(_t1));
        if (_t1 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _t2);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _t2);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        }
        return dest;
    }

    public static long normalizeMul_unsafe(long dest, long src, double length) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t1 = Math.fma(_selfx, _selfx, _selfy * _selfy);
        double _t3 = length * (1.0 / Math.sqrt(_t1));
        if (_t1 > 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx * _t3);
            UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy * _t3);
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        }
        return dest;
    }

    public static double orientedAngle_unsafe(long src, double otherX, double otherY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        return Math.atan2(Math.fma(otherY, _selfx, -(otherX * _selfy)), Math.fma(otherX, _selfx, otherY * _selfy));
    }

    public static double orientedAngle_unsafe(long src, long other) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _otherx = UnsafeOpsHolder.U.getDouble(other + 0L);
        double _othery = UnsafeOpsHolder.U.getDouble(other + 8L);
        return Math.atan2(Math.fma(_othery, _selfx, -(_otherx * _selfy)), Math.fma(_otherx, _selfx, _othery * _selfy));
    }

    public static long outerProduct_unsafe(long dest, long src, double rowX, double rowY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, rowX * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, rowX * _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, rowY * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 24L, rowY * _selfy);
        return dest;
    }

    public static long outerProduct_unsafe(long dest, long src, long row) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _rowx = UnsafeOpsHolder.U.getDouble(row + 0L);
        double _rowy = UnsafeOpsHolder.U.getDouble(row + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _rowx * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _rowx * _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 16L, _rowy * _selfx);
        UnsafeOpsHolder.U.putDouble(dest + 24L, _rowy * _selfy);
        return dest;
    }

    public static long pow_unsafe(long dest, long src, double exponent) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.pow(_selfx, exponent));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.pow(_selfy, exponent));
        return dest;
    }

    public static long pow_unsafe(long dest, long src, double exponentX, double exponentY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.pow(_selfx, exponentX));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.pow(_selfy, exponentY));
        return dest;
    }

    public static long pow_unsafe(long dest, long src, long exponent) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _exponentx = UnsafeOpsHolder.U.getDouble(exponent + 0L);
        double _exponenty = UnsafeOpsHolder.U.getDouble(exponent + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.pow(_selfx, _exponentx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.pow(_selfy, _exponenty));
        return dest;
    }

    public static long project_unsafe(long dest, long src, double ontoX, double ontoY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t2 = Math.fma(ontoX, _selfx, ontoY * _selfy);
        double _t3 = Math.fma(ontoX, ontoX, ontoY * ontoY);
        double _t3_inv = 1.0 / _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, ontoX * _t2 * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, ontoY * _t2 * _t3_inv);
        return dest;
    }

    public static long project_unsafe(long dest, long src, long onto) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _ontox = UnsafeOpsHolder.U.getDouble(onto + 0L);
        double _ontoy = UnsafeOpsHolder.U.getDouble(onto + 8L);
        double _t2 = Math.fma(_ontox, _selfx, _ontoy * _selfy);
        double _t3 = Math.fma(_ontox, _ontox, _ontoy * _ontoy);
        double _t3_inv = 1.0 / _t3;
        UnsafeOpsHolder.U.putDouble(dest + 0L, _ontox * _t2 * _t3_inv);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _ontoy * _t2 * _t3_inv);
        return dest;
    }

    public static long projectOnPlane_unsafe(long dest, long src, double normalX, double normalY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t1 = Math.fma(normalX, _selfx, normalY * _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-normalX, _t1, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-normalY, _t1, _selfy));
        return dest;
    }

    public static long projectOnPlane_unsafe(long dest, long src, long normal) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _normalx = UnsafeOpsHolder.U.getDouble(normal + 0L);
        double _normaly = UnsafeOpsHolder.U.getDouble(normal + 8L);
        double _t1 = Math.fma(_normalx, _selfx, _normaly * _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-_normalx, _t1, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-_normaly, _t1, _selfy));
        return dest;
    }

    public static long radians_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.toRadians(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.toRadians(_selfy));
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, double normalX, double normalY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t2 = 2.0 * Math.fma(normalX, _selfx, normalY * _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-normalX, _t2, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-normalY, _t2, _selfy));
        return dest;
    }

    public static long reflect_unsafe(long dest, long src, long normal) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _normalx = UnsafeOpsHolder.U.getDouble(normal + 0L);
        double _normaly = UnsafeOpsHolder.U.getDouble(normal + 8L);
        double _t2 = 2.0 * Math.fma(_normalx, _selfx, _normaly * _selfy);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-_normalx, _t2, _selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-_normaly, _t2, _selfy));
        return dest;
    }

    public static long refract_unsafe(long dest, long src, double normalX, double normalY, double eta) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t2 = Math.fma(normalX, _selfx, normalY * _selfy);
        double _t6 = Math.fma(-Math.fma(-_t2, _t2, 1.0), eta * eta, 1.0);
        double _t9 = Math.fma(eta, _t2, Math.sqrt(Math.max(0.0, _t6)));
        if (_t6 >= 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(eta, _selfx, -(normalX * _t9)));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(eta, _selfy, -(normalY * _t9)));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        }
        return dest;
    }

    public static long refract_unsafe(long dest, long src, long normal, double eta) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _normalx = UnsafeOpsHolder.U.getDouble(normal + 0L);
        double _normaly = UnsafeOpsHolder.U.getDouble(normal + 8L);
        double _t2 = Math.fma(_normalx, _selfx, _normaly * _selfy);
        double _t6 = Math.fma(-Math.fma(-_t2, _t2, 1.0), eta * eta, 1.0);
        double _t9 = Math.fma(eta, _t2, Math.sqrt(Math.max(0.0, _t6)));
        if (_t6 >= 0.0) {
            UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(eta, _selfx, -(_normalx * _t9)));
            UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(eta, _selfy, -(_normaly * _t9)));
        } else {
            UnsafeOpsHolder.U.putDouble(dest + 0L, 0.0);
            UnsafeOpsHolder.U.putDouble(dest + 8L, 0.0);
        }
        return dest;
    }

    public static long round_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.rint(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.rint(_selfy));
        return dest;
    }

    public static long sign_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.signum(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.signum(_selfy));
        return dest;
    }

    public static long sin_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.sin(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.sin(_selfy));
        return dest;
    }

    public static long sinh_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.sinh(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.sinh(_selfy));
        return dest;
    }

    public static long smoothstep_unsafe(long dest, long src, double edge0, double edge1) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = edge1 - edge0;
        double _t0_inv = 1.0 / _t0;
        double _t7 = Math.max(0.0, Math.min(1.0, (_selfx - edge0) * _t0_inv));
        double _t8 = Math.max(0.0, Math.min(1.0, (_selfy - edge0) * _t0_inv));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, _t7, 3.0) * _t7 * _t7);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-2.0, _t8, 3.0) * _t8 * _t8);
        return dest;
    }

    public static long smoothstep_unsafe(long dest, long src, double edge0X, double edge0Y, double edge1X, double edge1Y) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t8 = Math.max(0.0, Math.min(1.0, (_selfx - edge0X) / (edge1X - edge0X)));
        double _t9 = Math.max(0.0, Math.min(1.0, (_selfy - edge0Y) / (edge1Y - edge0Y)));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, _t8, 3.0) * _t8 * _t8);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-2.0, _t9, 3.0) * _t9 * _t9);
        return dest;
    }

    public static long smoothstep_unsafe(long dest, long src, long edge0, long edge1) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _edge0x = UnsafeOpsHolder.U.getDouble(edge0 + 0L);
        double _edge0y = UnsafeOpsHolder.U.getDouble(edge0 + 8L);
        double _edge1x = UnsafeOpsHolder.U.getDouble(edge1 + 0L);
        double _edge1y = UnsafeOpsHolder.U.getDouble(edge1 + 8L);
        double _t8 = Math.max(0.0, Math.min(1.0, (_selfx - _edge0x) / (_edge1x - _edge0x)));
        double _t9 = Math.max(0.0, Math.min(1.0, (_selfy - _edge0y) / (_edge1y - _edge0y)));
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(-2.0, _t8, 3.0) * _t8 * _t8);
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(-2.0, _t9, 3.0) * _t9 * _t9);
        return dest;
    }

    public static long sqrt_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.sqrt(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.sqrt(_selfy));
        return dest;
    }

    public static long step_unsafe(long dest, long src, double edge) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx < edge ? 0.0 : 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy < edge ? 0.0 : 1.0);
        return dest;
    }

    public static long step_unsafe(long dest, long src, double edgeX, double edgeY) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx < edgeX ? 0.0 : 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy < edgeY ? 0.0 : 1.0);
        return dest;
    }

    public static long step_unsafe(long dest, long src, long edge) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _edgex = UnsafeOpsHolder.U.getDouble(edge + 0L);
        double _edgey = UnsafeOpsHolder.U.getDouble(edge + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx < _edgex ? 0.0 : 1.0);
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy < _edgey ? 0.0 : 1.0);
        return dest;
    }

    public static long tan_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.tan(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.tan(_selfy));
        return dest;
    }

    public static long tanh_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.tanh(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.tanh(_selfy));
        return dest;
    }

    public static long trunc_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, _selfx >= 0.0 ? Math.floor(_selfx) : Math.ceil(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, _selfy >= 0.0 ? Math.floor(_selfy) : Math.ceil(_selfy));
        return dest;
    }

    public static long ulp_unsafe(long dest, long src) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.ulp(_selfx));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.ulp(_selfy));
        return dest;
    }

    public static long preMul_unsafe(long dest, long src, long mat) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _mat00 = UnsafeOpsHolder.U.getDouble(mat + 0L);
        double _mat10 = UnsafeOpsHolder.U.getDouble(mat + 8L);
        double _mat01 = UnsafeOpsHolder.U.getDouble(mat + 16L);
        double _mat11 = UnsafeOpsHolder.U.getDouble(mat + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_mat00, _selfx, _mat01 * _selfy));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_mat10, _selfx, _mat11 * _selfy));
        return dest;
    }

    public static long preMulDirection_unsafe(long dest, long src, long mat) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _mat00 = UnsafeOpsHolder.U.getDouble(mat + 0L);
        double _mat10 = UnsafeOpsHolder.U.getDouble(mat + 8L);
        double _mat01 = UnsafeOpsHolder.U.getDouble(mat + 16L);
        double _mat11 = UnsafeOpsHolder.U.getDouble(mat + 24L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_mat00, _selfx, _mat01 * _selfy));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_mat10, _selfx, _mat11 * _selfy));
        return dest;
    }

    public static long preMulPosition_unsafe(long dest, long src, long mat) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _mat00 = UnsafeOpsHolder.U.getDouble(mat + 0L);
        double _mat10 = UnsafeOpsHolder.U.getDouble(mat + 8L);
        double _mat01 = UnsafeOpsHolder.U.getDouble(mat + 16L);
        double _mat11 = UnsafeOpsHolder.U.getDouble(mat + 24L);
        double _mat02 = UnsafeOpsHolder.U.getDouble(mat + 32L);
        double _mat12 = UnsafeOpsHolder.U.getDouble(mat + 40L);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, _mat02)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, _mat12)));
        return dest;
    }

    public static long rotate_unsafe(long dest, long src, double angle) {
        double _selfx = UnsafeOpsHolder.U.getDouble(src + 0L);
        double _selfy = UnsafeOpsHolder.U.getDouble(src + 8L);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        UnsafeOpsHolder.U.putDouble(dest + 0L, Math.fma(_selfx, _t0, -(_selfy * _t1)));
        UnsafeOpsHolder.U.putDouble(dest + 8L, Math.fma(_selfx, _t1, _selfy * _t0));
        return dest;
    }

}
