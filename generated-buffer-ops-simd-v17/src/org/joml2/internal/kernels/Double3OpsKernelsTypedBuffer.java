package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double3Ops} whose leading storage
 * parameter is a typed {@link java.nio.DoubleBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double3Ops} and its sibling kernel units. Not public API.
 */
public final class Double3OpsKernelsTypedBuffer {
    private Double3OpsKernelsTypedBuffer() {}

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.add_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, otherX + _selfx);
        dest.put(destOffset + 1, otherY + _selfy);
        dest.put(destOffset + 2, otherZ + _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, _otherx + _selfx);
        dest.put(destOffset + 1, _othery + _selfy);
        dest.put(destOffset + 2, _otherz + _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.div_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _rcp0 = 1.0 / scalar;
        dest.put(destOffset + 0, _selfx * _rcp0);
        dest.put(destOffset + 1, _selfy * _rcp0);
        dest.put(destOffset + 2, _selfz * _rcp0);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.div_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx / otherX);
        dest.put(destOffset + 1, _selfy / otherY);
        dest.put(destOffset + 2, _selfz / otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.div_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, _selfx / _otherx);
        dest.put(destOffset + 1, _selfy / _othery);
        dest.put(destOffset + 2, _selfz / _otherz);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double b, double cX, double cY, double cZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, b, cX, cY, cZ);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double b, double cX, double cY, double cZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(_selfx, b, cX));
        dest.put(destOffset + 1, Math.fma(_selfy, b, cY));
        dest.put(destOffset + 2, Math.fma(_selfz, b, cZ));
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer c, int cOffset, double b) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double3OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, _cBase, b);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer c, int cOffset, double b) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _cx = c.get(cOffset + 0);
        double _cy = c.get(cOffset + 1);
        double _cz = c.get(cOffset + 2);
        dest.put(destOffset + 0, Math.fma(_selfx, b, _cx));
        dest.put(destOffset + 1, Math.fma(_selfy, b, _cy));
        dest.put(destOffset + 2, Math.fma(_selfz, b, _cz));
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double cX, double cY, double cZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, bX, bY, bZ, cX, cY, cZ);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double cX, double cY, double cZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(_selfx, bX, cX));
        dest.put(destOffset + 1, Math.fma(_selfy, bY, cY));
        dest.put(destOffset + 2, Math.fma(_selfz, bZ, cZ));
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double3OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, _bBase, _cBase);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _bx = b.get(bOffset + 0);
        double _by = b.get(bOffset + 1);
        double _bz = b.get(bOffset + 2);
        double _cx = c.get(cOffset + 0);
        double _cy = c.get(cOffset + 1);
        double _cz = c.get(cOffset + 2);
        dest.put(destOffset + 0, Math.fma(_selfx, _bx, _cx));
        dest.put(destOffset + 1, Math.fma(_selfy, _by, _cy));
        dest.put(destOffset + 2, Math.fma(_selfz, _bz, _cz));
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, scalar * _selfx);
        dest.put(destOffset + 1, scalar * _selfy);
        dest.put(destOffset + 2, scalar * _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, otherX * _selfx);
        dest.put(destOffset + 1, otherY * _selfy);
        dest.put(destOffset + 2, otherZ * _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, _otherx * _selfx);
        dest.put(destOffset + 1, _othery * _selfy);
        dest.put(destOffset + 2, _otherz * _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, -_selfx);
        dest.put(destOffset + 1, -_selfy);
        dest.put(destOffset + 2, -_selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx - otherX);
        dest.put(destOffset + 1, _selfy - otherY);
        dest.put(destOffset + 2, _selfz - otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, _selfx - _otherx);
        dest.put(destOffset + 1, _selfy - _othery);
        dest.put(destOffset + 2, _selfz - _otherz);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3OpsKernelsAddress.set_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        dest.put(destOffset + 0, vX);
        dest.put(destOffset + 1, vY);
        dest.put(destOffset + 2, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        dest.put(destOffset + 0, _vx);
        dest.put(destOffset + 1, _vy);
        dest.put(destOffset + 2, _vz);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3OpsKernelsAddress.set_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, double s) {
        dest.put(destOffset + 0, s);
        dest.put(destOffset + 1, s);
        dest.put(destOffset + 2, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeZero_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3OpsKernelsAddress.makeZero_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeZero_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.bezier_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        dest.put(destOffset + 0, Math.fma(p1X, _t7, _selfx * _t8) + Math.fma(p2X, _t6, p3X * _t2));
        dest.put(destOffset + 1, Math.fma(p1Y, _t7, _selfy * _t8) + Math.fma(p2Y, _t6, p3Y * _t2));
        dest.put(destOffset + 2, Math.fma(p1Z, _t7, _selfz * _t8) + Math.fma(p2Z, _t6, p3Z * _t2));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double3OpsKernelsAddress.bezier_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _t0 = 1.0 - t;
        double _t1 = t * t;
        double _t2 = t * _t1;
        double _t3 = _t0 * _t0;
        double _t6 = 3.0 * _t0 * _t1;
        double _t7 = 3.0 * t * _t3;
        double _t8 = _t0 * _t3;
        dest.put(destOffset + 0, Math.fma(_p1x, _t7, _selfx * _t8) + Math.fma(_p2x, _t6, _p3x * _t2));
        dest.put(destOffset + 1, Math.fma(_p1y, _t7, _selfy * _t8) + Math.fma(_p2y, _t6, _p3y * _t2));
        dest.put(destOffset + 2, Math.fma(_p1z, _t7, _selfz * _t8) + Math.fma(_p2z, _t6, _p3z * _t2));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.bezier2_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        dest.put(destOffset + 0, Math.fma(p2X, _t0, Math.fma(p1X, _t3, _selfx * _t4)));
        dest.put(destOffset + 1, Math.fma(p2Y, _t0, Math.fma(p1Y, _t3, _selfy * _t4)));
        dest.put(destOffset + 2, Math.fma(p2Z, _t0, Math.fma(p1Z, _t3, _selfz * _t4)));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double3OpsKernelsAddress.bezier2_unsafe(_destBase, _srcBase, _p1Base, _p2Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        dest.put(destOffset + 0, Math.fma(_p2x, _t0, Math.fma(_p1x, _t3, _selfx * _t4)));
        dest.put(destOffset + 1, Math.fma(_p2y, _t0, Math.fma(_p1y, _t3, _selfy * _t4)));
        dest.put(destOffset + 2, Math.fma(_p2z, _t0, Math.fma(_p1z, _t3, _selfz * _t4)));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.bezier2Tangent_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        dest.put(destOffset + 0, Math.fma(p1X - _selfx, _t2, (p2X - p1X) * _t1));
        dest.put(destOffset + 1, Math.fma(p1Y - _selfy, _t2, (p2Y - p1Y) * _t1));
        dest.put(destOffset + 2, Math.fma(p1Z - _selfz, _t2, (p2Z - p1Z) * _t1));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double3OpsKernelsAddress.bezier2Tangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        dest.put(destOffset + 0, Math.fma(_p1x - _selfx, _t2, (_p2x - _p1x) * _t1));
        dest.put(destOffset + 1, Math.fma(_p1y - _selfy, _t2, (_p2y - _p1y) * _t1));
        dest.put(destOffset + 2, Math.fma(_p1z - _selfz, _t2, (_p2z - _p1z) * _t1));
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.bezierTangent_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        dest.put(destOffset + 0, Math.fma(p3X - p2X, _t2, Math.fma(p1X - _selfx, _t6, (p2X - p1X) * _t5)));
        dest.put(destOffset + 1, Math.fma(p3Y - p2Y, _t2, Math.fma(p1Y - _selfy, _t6, (p2Y - p1Y) * _t5)));
        dest.put(destOffset + 2, Math.fma(p3Z - p2Z, _t2, Math.fma(p1Z - _selfz, _t6, (p2Z - p1Z) * _t5)));
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double3OpsKernelsAddress.bezierTangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        dest.put(destOffset + 0, Math.fma(_p3x - _p2x, _t2, Math.fma(_p1x - _selfx, _t6, (_p2x - _p1x) * _t5)));
        dest.put(destOffset + 1, Math.fma(_p3y - _p2y, _t2, Math.fma(_p1y - _selfy, _t6, (_p2y - _p1y) * _t5)));
        dest.put(destOffset + 2, Math.fma(_p3z - _p2z, _t2, Math.fma(_p1z - _selfz, _t6, (_p2z - _p1z) * _t5)));
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.catmullRom_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = t * t;
        double _t1 = t * _t0;
        dest.put(destOffset + 0, 0.5 * (Math.fma(2.0, p1X, t * (p2X - _selfx)) + Math.fma(Math.fma(-5.0, p1X, Math.fma(2.0, _selfx, Math.fma(4.0, p2X, -p3X))), _t0, Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - _selfx)) * _t1)));
        dest.put(destOffset + 1, 0.5 * (Math.fma(2.0, p1Y, t * (p2Y - _selfy)) + Math.fma(Math.fma(-5.0, p1Y, Math.fma(2.0, _selfy, Math.fma(4.0, p2Y, -p3Y))), _t0, Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - _selfy)) * _t1)));
        dest.put(destOffset + 2, 0.5 * (Math.fma(2.0, p1Z, t * (p2Z - _selfz)) + Math.fma(Math.fma(-5.0, p1Z, Math.fma(2.0, _selfz, Math.fma(4.0, p2Z, -p3Z))), _t0, Math.fma(-3.0, p2Z, Math.fma(3.0, p1Z, p3Z - _selfz)) * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double3OpsKernelsAddress.catmullRom_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _t0 = t * t;
        double _t1 = t * _t0;
        dest.put(destOffset + 0, 0.5 * (Math.fma(2.0, _p1x, t * (_p2x - _selfx)) + Math.fma(Math.fma(-5.0, _p1x, Math.fma(2.0, _selfx, Math.fma(4.0, _p2x, -_p3x))), _t0, Math.fma(-3.0, _p2x, Math.fma(3.0, _p1x, _p3x - _selfx)) * _t1)));
        dest.put(destOffset + 1, 0.5 * (Math.fma(2.0, _p1y, t * (_p2y - _selfy)) + Math.fma(Math.fma(-5.0, _p1y, Math.fma(2.0, _selfy, Math.fma(4.0, _p2y, -_p3y))), _t0, Math.fma(-3.0, _p2y, Math.fma(3.0, _p1y, _p3y - _selfy)) * _t1)));
        dest.put(destOffset + 2, 0.5 * (Math.fma(2.0, _p1z, t * (_p2z - _selfz)) + Math.fma(Math.fma(-5.0, _p1z, Math.fma(2.0, _selfz, Math.fma(4.0, _p2z, -_p3z))), _t0, Math.fma(-3.0, _p2z, Math.fma(3.0, _p1z, _p3z - _selfz)) * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.catmullRomTangent_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z, p3X, p3Y, p3Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z, double p3X, double p3Y, double p3Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = t * t;
        dest.put(destOffset + 0, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1X, Math.fma(2.0, _selfx, Math.fma(4.0, p2X, -p3X))), Math.fma(3.0 * Math.fma(-3.0, p2X, Math.fma(3.0, p1X, p3X - _selfx)), _t0, p2X - _selfx)));
        dest.put(destOffset + 1, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Y, Math.fma(2.0, _selfy, Math.fma(4.0, p2Y, -p3Y))), Math.fma(3.0 * Math.fma(-3.0, p2Y, Math.fma(3.0, p1Y, p3Y - _selfy)), _t0, p2Y - _selfy)));
        dest.put(destOffset + 2, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, p1Z, Math.fma(2.0, _selfz, Math.fma(4.0, p2Z, -p3Z))), Math.fma(3.0 * Math.fma(-3.0, p2Z, Math.fma(3.0, p1Z, p3Z - _selfz)), _t0, p2Z - _selfz)));
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double3OpsKernelsAddress.catmullRomTangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _t0 = t * t;
        dest.put(destOffset + 0, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1x, Math.fma(2.0, _selfx, Math.fma(4.0, _p2x, -_p3x))), Math.fma(3.0 * Math.fma(-3.0, _p2x, Math.fma(3.0, _p1x, _p3x - _selfx)), _t0, _p2x - _selfx)));
        dest.put(destOffset + 1, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1y, Math.fma(2.0, _selfy, Math.fma(4.0, _p2y, -_p3y))), Math.fma(3.0 * Math.fma(-3.0, _p2y, Math.fma(3.0, _p1y, _p3y - _selfy)), _t0, _p2y - _selfy)));
        dest.put(destOffset + 2, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1z, Math.fma(2.0, _selfz, Math.fma(4.0, _p2z, -_p3z))), Math.fma(3.0 * Math.fma(-3.0, _p2z, Math.fma(3.0, _p1z, _p3z - _selfz)), _t0, _p2z - _selfz)));
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.hermite_unsafe(_destBase, _srcBase, t0X, t0Y, t0Z, v1X, v1Y, v1Z, t1X, t1Y, t1Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        dest.put(destOffset + 0, Math.fma(_selfx, _t10, t0X * _t7) + Math.fma(t1X, _t5, v1X * _t9));
        dest.put(destOffset + 1, Math.fma(_selfy, _t10, t0Y * _t7) + Math.fma(t1Y, _t5, v1Y * _t9));
        dest.put(destOffset + 2, Math.fma(_selfz, _t10, t0Z * _t7) + Math.fma(t1Z, _t5, v1Z * _t9));
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _t0Base = UnsafeOpsHolder.U.getLong(t0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t0Offset * 8L;
        long _v1Base = UnsafeOpsHolder.U.getLong(v1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) v1Offset * 8L;
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        Double3OpsKernelsAddress.hermite_unsafe(_destBase, _srcBase, _t0Base, _v1Base, _t1Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0x = t0.get(t0Offset + 0);
        double _t0y = t0.get(t0Offset + 1);
        double _t0z = t0.get(t0Offset + 2);
        double _v1x = v1.get(v1Offset + 0);
        double _v1y = v1.get(v1Offset + 1);
        double _v1z = v1.get(v1Offset + 2);
        double _t1x = t1.get(t1Offset + 0);
        double _t1y = t1.get(t1Offset + 1);
        double _t1z = t1.get(t1Offset + 2);
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        dest.put(destOffset + 0, Math.fma(_selfx, _t10, _t0x * _t7) + Math.fma(_t1x, _t5, _v1x * _t9));
        dest.put(destOffset + 1, Math.fma(_selfy, _t10, _t0y * _t7) + Math.fma(_t1y, _t5, _v1y * _t9));
        dest.put(destOffset + 2, Math.fma(_selfz, _t10, _t0z * _t7) + Math.fma(_t1z, _t5, _v1z * _t9));
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.hermiteTangent_unsafe(_destBase, _srcBase, t0X, t0Y, t0Z, v1X, v1Y, v1Z, t1X, t1Y, t1Z, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double v1X, double v1Y, double v1Z, double t1X, double t1Y, double t1Z, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        dest.put(destOffset + 0, Math.fma(_selfx, _t6, t0X * _t9) + Math.fma(t1X, _t8, v1X * _t7));
        dest.put(destOffset + 1, Math.fma(_selfy, _t6, t0Y * _t9) + Math.fma(t1Y, _t8, v1Y * _t7));
        dest.put(destOffset + 2, Math.fma(_selfz, _t6, t0Z * _t9) + Math.fma(t1Z, _t8, v1Z * _t7));
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _t0Base = UnsafeOpsHolder.U.getLong(t0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t0Offset * 8L;
        long _v1Base = UnsafeOpsHolder.U.getLong(v1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) v1Offset * 8L;
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        Double3OpsKernelsAddress.hermiteTangent_unsafe(_destBase, _srcBase, _t0Base, _v1Base, _t1Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0x = t0.get(t0Offset + 0);
        double _t0y = t0.get(t0Offset + 1);
        double _t0z = t0.get(t0Offset + 2);
        double _v1x = v1.get(v1Offset + 0);
        double _v1y = v1.get(v1Offset + 1);
        double _v1z = v1.get(v1Offset + 2);
        double _t1x = t1.get(t1Offset + 0);
        double _t1y = t1.get(t1Offset + 1);
        double _t1z = t1.get(t1Offset + 2);
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        dest.put(destOffset + 0, Math.fma(_selfx, _t6, _t0x * _t9) + Math.fma(_t1x, _t8, _v1x * _t7));
        dest.put(destOffset + 1, Math.fma(_selfy, _t6, _t0y * _t9) + Math.fma(_t1y, _t8, _v1y * _t7));
        dest.put(destOffset + 2, Math.fma(_selfz, _t6, _t0z * _t9) + Math.fma(_t1z, _t8, _v1z * _t7));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(t, otherX - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(t, otherY - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(t, otherZ - _selfz, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, Math.fma(t, _otherx - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(t, _othery - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(t, _otherz - _selfz, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double tX, double tY, double tZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, tX, tY, tZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double tX, double tY, double tZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(tX, otherX - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(tY, otherY - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(tZ, otherZ - _selfz, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 8L;
        Double3OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, _tBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer t, int tOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _tx = t.get(tOffset + 0);
        double _ty = t.get(tOffset + 1);
        double _tz = t.get(tOffset + 2);
        dest.put(destOffset + 0, Math.fma(_tx, _otherx - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(_ty, _othery - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(_tz, _otherz - _selfz, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer absolute_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.absolute_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer absolute_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.abs(_selfx));
        dest.put(destOffset + 1, Math.abs(_selfy));
        dest.put(destOffset + 2, Math.abs(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer acos_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.acos_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer acos_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.acos(_selfx));
        dest.put(destOffset + 1, Math.acos(_selfy));
        dest.put(destOffset + 2, Math.acos(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, bX, bY, bZ, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(scalar, bX, _selfx));
        dest.put(destOffset + 1, Math.fma(scalar, bY, _selfy));
        dest.put(destOffset + 2, Math.fma(scalar, bZ, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        Double3OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, _bBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _bx = b.get(bOffset + 0);
        double _by = b.get(bOffset + 1);
        double _bz = b.get(bOffset + 2);
        dest.put(destOffset + 0, Math.fma(scalar, _bx, _selfx));
        dest.put(destOffset + 1, Math.fma(scalar, _by, _selfy));
        dest.put(destOffset + 2, Math.fma(scalar, _bz, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double cX, double cY, double cZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, bX, bY, bZ, cX, cY, cZ);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double cX, double cY, double cZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(bX, cX, _selfx));
        dest.put(destOffset + 1, Math.fma(bY, cY, _selfy));
        dest.put(destOffset + 2, Math.fma(bZ, cZ, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double3OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, _bBase, _cBase);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _bx = b.get(bOffset + 0);
        double _by = b.get(bOffset + 1);
        double _bz = b.get(bOffset + 2);
        double _cx = c.get(cOffset + 0);
        double _cy = c.get(cOffset + 1);
        double _cz = c.get(cOffset + 2);
        dest.put(destOffset + 0, Math.fma(_bx, _cx, _selfx));
        dest.put(destOffset + 1, Math.fma(_by, _cy, _selfy));
        dest.put(destOffset + 2, Math.fma(_bz, _cz, _selfz));
        return dest;
    }

    public static double angleBetween_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.angleBetween_unsafe(_srcBase, otherX, otherY, otherZ);
    }

    public static double angleBetween_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)) * (1.0 / Math.sqrt(Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)))) * (1.0 / Math.sqrt(Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY)))))));
    }

    public static double angleBetween_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double3OpsKernelsAddress.angleBetween_unsafe(_srcBase, _otherBase);
    }

    public static double angleBetween_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        return Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)) * (1.0 / Math.sqrt(Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)))) * (1.0 / Math.sqrt(Math.fma(_otherz, _otherz, Math.fma(_otherx, _otherx, _othery * _othery)))))));
    }

    public static java.nio.DoubleBuffer asin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.asin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer asin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.asin(_selfx));
        dest.put(destOffset + 1, Math.asin(_selfy));
        dest.put(destOffset + 2, Math.asin(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer atan_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.atan_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer atan_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.atan(_selfx));
        dest.put(destOffset + 1, Math.atan(_selfy));
        dest.put(destOffset + 2, Math.atan(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, x);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.atan2(_selfx, x));
        dest.put(destOffset + 1, Math.atan2(_selfy, x));
        dest.put(destOffset + 2, Math.atan2(_selfz, x));
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xX, double xY, double xZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, xX, xY, xZ);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xX, double xY, double xZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.atan2(_selfx, xX));
        dest.put(destOffset + 1, Math.atan2(_selfy, xY));
        dest.put(destOffset + 2, Math.atan2(_selfz, xZ));
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer x, int xOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        Double3OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, _xBase);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer x, int xOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _xx = x.get(xOffset + 0);
        double _xy = x.get(xOffset + 1);
        double _xz = x.get(xOffset + 2);
        dest.put(destOffset + 0, Math.atan2(_selfx, _xx));
        dest.put(destOffset + 1, Math.atan2(_selfy, _xy));
        dest.put(destOffset + 2, Math.atan2(_selfz, _xz));
        return dest;
    }

    public static java.nio.DoubleBuffer cbrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.cbrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cbrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.cbrt(_selfx));
        dest.put(destOffset + 1, Math.cbrt(_selfy));
        dest.put(destOffset + 2, Math.cbrt(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer ceil_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.ceil_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer ceil_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.ceil(_selfx));
        dest.put(destOffset + 1, Math.ceil(_selfy));
        dest.put(destOffset + 2, Math.ceil(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double min, double max) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, min, max);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double min, double max) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.min(Math.max(_selfx, min), max));
        dest.put(destOffset + 1, Math.min(Math.max(_selfy, min), max));
        dest.put(destOffset + 2, Math.min(Math.max(_selfz, min), max));
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.min(Math.max(_selfx, minX), maxX));
        dest.put(destOffset + 1, Math.min(Math.max(_selfy, minY), maxY));
        dest.put(destOffset + 2, Math.min(Math.max(_selfz, minZ), maxZ));
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 8L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 8L;
        Double3OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, _minBase, _maxBase);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _minx = min.get(minOffset + 0);
        double _miny = min.get(minOffset + 1);
        double _minz = min.get(minOffset + 2);
        double _maxx = max.get(maxOffset + 0);
        double _maxy = max.get(maxOffset + 1);
        double _maxz = max.get(maxOffset + 2);
        dest.put(destOffset + 0, Math.min(Math.max(_selfx, _minx), _maxx));
        dest.put(destOffset + 1, Math.min(Math.max(_selfy, _miny), _maxy));
        dest.put(destOffset + 2, Math.min(Math.max(_selfz, _minz), _maxz));
        return dest;
    }

    public static java.nio.DoubleBuffer closestPointOnLine_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double lineStartX, double lineStartY, double lineStartZ, double lineEndX, double lineEndY, double lineEndZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.closestPointOnLine_unsafe(_destBase, _srcBase, lineStartX, lineStartY, lineStartZ, lineEndX, lineEndY, lineEndZ);
        return dest;
    }

    public static java.nio.DoubleBuffer closestPointOnLine_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double lineStartX, double lineStartY, double lineStartZ, double lineEndX, double lineEndY, double lineEndZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = lineEndZ - lineStartZ;
        double _t1 = lineEndX - lineStartX;
        double _t2 = lineEndY - lineStartY;
        double _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t14 = Math.max(0.0, Math.min(1.0, Math.fma(_t0, _selfz - lineStartZ, Math.fma(_t1, _selfx - lineStartX, _t2 * (_selfy - lineStartY))) / _t10));
        if (_t10 > 0.0) {
            dest.put(destOffset + 0, Math.fma(_t1, _t14, lineStartX));
            dest.put(destOffset + 1, Math.fma(_t2, _t14, lineStartY));
            dest.put(destOffset + 2, Math.fma(_t0, _t14, lineStartZ));
        } else {
            dest.put(destOffset + 0, lineStartX);
            dest.put(destOffset + 1, lineStartY);
            dest.put(destOffset + 2, lineStartZ);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer closestPointOnLine_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer lineStart, int lineStartOffset, java.nio.DoubleBuffer lineEnd, int lineEndOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _lineStartBase = UnsafeOpsHolder.U.getLong(lineStart, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) lineStartOffset * 8L;
        long _lineEndBase = UnsafeOpsHolder.U.getLong(lineEnd, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) lineEndOffset * 8L;
        Double3OpsKernelsAddress.closestPointOnLine_unsafe(_destBase, _srcBase, _lineStartBase, _lineEndBase);
        return dest;
    }

    public static java.nio.DoubleBuffer closestPointOnLine_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer lineStart, int lineStartOffset, java.nio.DoubleBuffer lineEnd, int lineEndOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _lineStartx = lineStart.get(lineStartOffset + 0);
        double _lineStarty = lineStart.get(lineStartOffset + 1);
        double _lineStartz = lineStart.get(lineStartOffset + 2);
        double _lineEndx = lineEnd.get(lineEndOffset + 0);
        double _lineEndy = lineEnd.get(lineEndOffset + 1);
        double _lineEndz = lineEnd.get(lineEndOffset + 2);
        double _t0 = _lineEndz - _lineStartz;
        double _t1 = _lineEndx - _lineStartx;
        double _t2 = _lineEndy - _lineStarty;
        double _t10 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        double _t14 = Math.max(0.0, Math.min(1.0, Math.fma(_t0, _selfz - _lineStartz, Math.fma(_t1, _selfx - _lineStartx, _t2 * (_selfy - _lineStarty))) / _t10));
        if (_t10 > 0.0) {
            dest.put(destOffset + 0, Math.fma(_t1, _t14, _lineStartx));
            dest.put(destOffset + 1, Math.fma(_t2, _t14, _lineStarty));
            dest.put(destOffset + 2, Math.fma(_t0, _t14, _lineStartz));
        } else {
            dest.put(destOffset + 0, _lineStartx);
            dest.put(destOffset + 1, _lineStarty);
            dest.put(destOffset + 2, _lineStartz);
        }
        return dest;
    }

    public static double compAdd_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.compAdd_unsafe(_srcBase);
    }

    public static double compAdd_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return _selfz + (_selfx + _selfy);
    }

    public static double compMax_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.compMax_unsafe(_srcBase);
    }

    public static double compMax_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.max(Math.max(_selfx, _selfy), _selfz);
    }

    public static double compMin_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.compMin_unsafe(_srcBase);
    }

    public static double compMin_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.min(Math.min(_selfx, _selfy), _selfz);
    }

    public static double compMul_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.compMul_unsafe(_srcBase);
    }

    public static double compMul_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return _selfz * _selfx * _selfy;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sign) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, sign);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sign) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.copySign(_selfx, sign));
        dest.put(destOffset + 1, Math.copySign(_selfy, sign));
        dest.put(destOffset + 2, Math.copySign(_selfz, sign));
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double signX, double signY, double signZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, signX, signY, signZ);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double signX, double signY, double signZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.copySign(_selfx, signX));
        dest.put(destOffset + 1, Math.copySign(_selfy, signY));
        dest.put(destOffset + 2, Math.copySign(_selfz, signZ));
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer sign, int signOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _signBase = UnsafeOpsHolder.U.getLong(sign, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) signOffset * 8L;
        Double3OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, _signBase);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer sign, int signOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _signx = sign.get(signOffset + 0);
        double _signy = sign.get(signOffset + 1);
        double _signz = sign.get(signOffset + 2);
        dest.put(destOffset + 0, Math.copySign(_selfx, _signx));
        dest.put(destOffset + 1, Math.copySign(_selfy, _signy));
        dest.put(destOffset + 2, Math.copySign(_selfz, _signz));
        return dest;
    }

    public static java.nio.DoubleBuffer cos_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.cos_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cos_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.cos(_selfx));
        dest.put(destOffset + 1, Math.cos(_selfy));
        dest.put(destOffset + 2, Math.cos(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer cosh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.cosh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cosh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.cosh(_selfx));
        dest.put(destOffset + 1, Math.cosh(_selfy));
        dest.put(destOffset + 2, Math.cosh(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer cross_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.cross_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer cross_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(otherZ, _selfy, -(otherY * _selfz)));
        dest.put(destOffset + 1, Math.fma(otherX, _selfz, -(otherZ * _selfx)));
        dest.put(destOffset + 2, Math.fma(otherY, _selfx, -(otherX * _selfy)));
        return dest;
    }

    public static java.nio.DoubleBuffer cross_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.cross_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cross_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, Math.fma(_otherz, _selfy, -(_othery * _selfz)));
        dest.put(destOffset + 1, Math.fma(_otherx, _selfz, -(_otherz * _selfx)));
        dest.put(destOffset + 2, Math.fma(_othery, _selfx, -(_otherx * _selfy)));
        return dest;
    }

    public static java.nio.DoubleBuffer degrees_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.degrees_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer degrees_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.toDegrees(_selfx));
        dest.put(destOffset + 1, Math.toDegrees(_selfy));
        dest.put(destOffset + 2, Math.toDegrees(_selfz));
        return dest;
    }

    public static double distance_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.distance_unsafe(_srcBase, otherX, otherY, otherZ);
    }

    public static double distance_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = _selfz - otherZ;
        double _t1 = _selfx - otherX;
        double _t2 = _selfy - otherY;
        return Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
    }

    public static double distance_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double3OpsKernelsAddress.distance_unsafe(_srcBase, _otherBase);
    }

    public static double distance_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _t0 = _selfz - _otherz;
        double _t1 = _selfx - _otherx;
        double _t2 = _selfy - _othery;
        return Math.sqrt(Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2)));
    }

    public static double distanceSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.distanceSquared_unsafe(_srcBase, otherX, otherY, otherZ);
    }

    public static double distanceSquared_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = _selfz - otherZ;
        double _t1 = _selfx - otherX;
        double _t2 = _selfy - otherY;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
    }

    public static double distanceSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double3OpsKernelsAddress.distanceSquared_unsafe(_srcBase, _otherBase);
    }

    public static double distanceSquared_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _t0 = _selfz - _otherz;
        double _t1 = _selfx - _otherx;
        double _t2 = _selfy - _othery;
        return Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
    }

    public static double dot_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.dot_unsafe(_srcBase, otherX, otherY, otherZ);
    }

    public static double dot_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy));
    }

    public static double dot_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double3OpsKernelsAddress.dot_unsafe(_srcBase, _otherBase);
    }

    public static double dot_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        return Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy));
    }

    public static java.nio.DoubleBuffer exp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.exp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer exp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.exp(_selfx));
        dest.put(destOffset + 1, Math.exp(_selfy));
        dest.put(destOffset + 2, Math.exp(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer exp2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.exp2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer exp2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.pow(2.0, _selfx));
        dest.put(destOffset + 1, Math.pow(2.0, _selfy));
        dest.put(destOffset + 2, Math.pow(2.0, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer expm1_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.expm1_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer expm1_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.expm1(_selfx));
        dest.put(destOffset + 1, Math.expm1(_selfy));
        dest.put(destOffset + 2, Math.expm1(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double IX, double IY, double IZ, double NrefX, double NrefY, double NrefZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.faceforward_unsafe(_destBase, _srcBase, IX, IY, IZ, NrefX, NrefY, NrefZ);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double IX, double IY, double IZ, double NrefX, double NrefY, double NrefZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t2 = Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY));
        if (_t2 < 0.0) {
            dest.put(destOffset + 0, _selfx);
            dest.put(destOffset + 1, _selfy);
            dest.put(destOffset + 2, _selfz);
        } else {
            dest.put(destOffset + 0, -_selfx);
            dest.put(destOffset + 1, -_selfy);
            dest.put(destOffset + 2, -_selfz);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer I, int IOffset, java.nio.DoubleBuffer Nref, int NrefOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _IBase = UnsafeOpsHolder.U.getLong(I, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) IOffset * 8L;
        long _NrefBase = UnsafeOpsHolder.U.getLong(Nref, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) NrefOffset * 8L;
        Double3OpsKernelsAddress.faceforward_unsafe(_destBase, _srcBase, _IBase, _NrefBase);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer I, int IOffset, java.nio.DoubleBuffer Nref, int NrefOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _Ix = I.get(IOffset + 0);
        double _Iy = I.get(IOffset + 1);
        double _Iz = I.get(IOffset + 2);
        double _Nrefx = Nref.get(NrefOffset + 0);
        double _Nrefy = Nref.get(NrefOffset + 1);
        double _Nrefz = Nref.get(NrefOffset + 2);
        double _t2 = Math.fma(_Iz, _Nrefz, Math.fma(_Ix, _Nrefx, _Iy * _Nrefy));
        if (_t2 < 0.0) {
            dest.put(destOffset + 0, _selfx);
            dest.put(destOffset + 1, _selfy);
            dest.put(destOffset + 2, _selfz);
        } else {
            dest.put(destOffset + 0, -_selfx);
            dest.put(destOffset + 1, -_selfy);
            dest.put(destOffset + 2, -_selfz);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer floor_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.floor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer floor_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.floor(_selfx));
        dest.put(destOffset + 1, Math.floor(_selfy));
        dest.put(destOffset + 2, Math.floor(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer fract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.fract_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer fract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx - Math.floor(_selfx));
        dest.put(destOffset + 1, _selfy - Math.floor(_selfy));
        dest.put(destOffset + 2, _selfz - Math.floor(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, y);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.hypot(_selfx, y));
        dest.put(destOffset + 1, Math.hypot(_selfy, y));
        dest.put(destOffset + 2, Math.hypot(_selfz, y));
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, yX, yY, yZ);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.hypot(_selfx, yX));
        dest.put(destOffset + 1, Math.hypot(_selfy, yY));
        dest.put(destOffset + 2, Math.hypot(_selfz, yZ));
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double3OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _yx = y.get(yOffset + 0);
        double _yy = y.get(yOffset + 1);
        double _yz = y.get(yOffset + 2);
        dest.put(destOffset + 0, Math.hypot(_selfx, _yx));
        dest.put(destOffset + 1, Math.hypot(_selfy, _yy));
        dest.put(destOffset + 2, Math.hypot(_selfz, _yz));
        return dest;
    }

    public static java.nio.DoubleBuffer inverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.inverse_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer inverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, 1.0 / _selfx);
        dest.put(destOffset + 1, 1.0 / _selfy);
        dest.put(destOffset + 2, 1.0 / _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer inverseSqrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.inverseSqrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer inverseSqrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, (1.0 / Math.sqrt(_selfx)));
        dest.put(destOffset + 1, (1.0 / Math.sqrt(_selfy)));
        dest.put(destOffset + 2, (1.0 / Math.sqrt(_selfz)));
        return dest;
    }

    public static double length_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.length_unsafe(_srcBase);
    }

    public static double length_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.sqrt(Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
    }

    public static double lengthSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.lengthSquared_unsafe(_srcBase);
    }

    public static double lengthSquared_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
    }

    public static java.nio.DoubleBuffer log_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.log_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.log(_selfx));
        dest.put(destOffset + 1, Math.log(_selfy));
        dest.put(destOffset + 2, Math.log(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer log10_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.log10_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log10_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.log10(_selfx));
        dest.put(destOffset + 1, Math.log10(_selfy));
        dest.put(destOffset + 2, Math.log10(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer log1p_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.log1p_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log1p_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.log1p(_selfx));
        dest.put(destOffset + 1, Math.log1p(_selfy));
        dest.put(destOffset + 2, Math.log1p(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer log2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.log2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = Math.log(2.0);
        double _t0_inv = 1.0 / _t0;
        dest.put(destOffset + 0, Math.log(_selfx) * _t0_inv);
        dest.put(destOffset + 1, Math.log(_selfy) * _t0_inv);
        dest.put(destOffset + 2, Math.log(_selfz) * _t0_inv);
        return dest;
    }

    public static double manhattanDistance_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.manhattanDistance_unsafe(_srcBase, otherX, otherY, otherZ);
    }

    public static double manhattanDistance_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.abs(_selfx - otherX) + Math.abs(_selfy - otherY) + Math.abs(_selfz - otherZ);
    }

    public static double manhattanDistance_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double3OpsKernelsAddress.manhattanDistance_unsafe(_srcBase, _otherBase);
    }

    public static double manhattanDistance_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        return Math.abs(_selfx - _otherx) + Math.abs(_selfy - _othery) + Math.abs(_selfz - _otherz);
    }

    public static double manhattanLength_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.manhattanLength_unsafe(_srcBase);
    }

    public static double manhattanLength_api(java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        return Math.abs(_selfx) + Math.abs(_selfy) + Math.abs(_selfz);
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.max_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.max(_selfx, scalar));
        dest.put(destOffset + 1, Math.max(_selfy, scalar));
        dest.put(destOffset + 2, Math.max(_selfz, scalar));
        return dest;
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.max_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.max(_selfx, otherX));
        dest.put(destOffset + 1, Math.max(_selfy, otherY));
        dest.put(destOffset + 2, Math.max(_selfz, otherZ));
        return dest;
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.max_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, Math.max(_selfx, _otherx));
        dest.put(destOffset + 1, Math.max(_selfy, _othery));
        dest.put(destOffset + 2, Math.max(_selfz, _otherz));
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.min_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.min(_selfx, scalar));
        dest.put(destOffset + 1, Math.min(_selfy, scalar));
        dest.put(destOffset + 2, Math.min(_selfz, scalar));
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.min_unsafe(_destBase, _srcBase, otherX, otherY, otherZ);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.min(_selfx, otherX));
        dest.put(destOffset + 1, Math.min(_selfy, otherY));
        dest.put(destOffset + 2, Math.min(_selfz, otherZ));
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3OpsKernelsAddress.min_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        dest.put(destOffset + 0, Math.min(_selfx, _otherx));
        dest.put(destOffset + 1, Math.min(_selfy, _othery));
        dest.put(destOffset + 2, Math.min(_selfz, _otherz));
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, y);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _rcp0 = 1.0 / y;
        dest.put(destOffset + 0, Math.fma(-y, Math.floor(_selfx * _rcp0), _selfx));
        dest.put(destOffset + 1, Math.fma(-y, Math.floor(_selfy * _rcp0), _selfy));
        dest.put(destOffset + 2, Math.fma(-y, Math.floor(_selfz * _rcp0), _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, yX, yY, yZ);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.fma(-yX, Math.floor(_selfx / yX), _selfx));
        dest.put(destOffset + 1, Math.fma(-yY, Math.floor(_selfy / yY), _selfy));
        dest.put(destOffset + 2, Math.fma(-yZ, Math.floor(_selfz / yZ), _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double3OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _yx = y.get(yOffset + 0);
        double _yy = y.get(yOffset + 1);
        double _yz = y.get(yOffset + 2);
        dest.put(destOffset + 0, Math.fma(-_yx, Math.floor(_selfx / _yx), _selfx));
        dest.put(destOffset + 1, Math.fma(-_yy, Math.floor(_selfy / _yy), _selfy));
        dest.put(destOffset + 2, Math.fma(-_yz, Math.floor(_selfz / _yz), _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer nextDown_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.nextDown_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer nextDown_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.nextDown(_selfx));
        dest.put(destOffset + 1, Math.nextDown(_selfy));
        dest.put(destOffset + 2, Math.nextDown(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer nextUp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.nextUp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer nextUp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.nextUp(_selfx));
        dest.put(destOffset + 1, Math.nextUp(_selfy));
        dest.put(destOffset + 2, Math.nextUp(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer normalize_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.normalize_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalize_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t3 = (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, _selfx * _t3);
            dest.put(destOffset + 1, _selfy * _t3);
            dest.put(destOffset + 2, _selfz * _t3);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer normalizeMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double length) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.normalizeMul_unsafe(_destBase, _srcBase, length);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizeMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double length) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t2 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t4 = length * (1.0 / Math.sqrt(_t2));
        if (_t2 > 0.0) {
            dest.put(destOffset + 0, _selfx * _t4);
            dest.put(destOffset + 1, _selfy * _t4);
            dest.put(destOffset + 2, _selfz * _t4);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static double orientedAngle_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double normalX, double normalY, double normalZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3OpsKernelsAddress.orientedAngle_unsafe(_srcBase, otherX, otherY, otherZ, normalX, normalY, normalZ);
    }

    public static double orientedAngle_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double normalX, double normalY, double normalZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t6 = Math.fma(otherZ, otherZ, Math.fma(otherX, otherX, otherY * otherY));
        double _t7 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t15 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(otherZ, _selfz, Math.fma(otherX, _selfx, otherY * _selfy)) * (1.0 / Math.sqrt(_t7)) * (1.0 / Math.sqrt(_t6)))));
        return Math.sqrt(_t6) * Math.sqrt(_t7) > 0.0 ? Math.fma(normalZ, Math.fma(otherY, _selfx, -(otherX * _selfy)), Math.fma(normalX, Math.fma(otherZ, _selfy, -(otherY * _selfz)), normalY * Math.fma(otherX, _selfz, -(otherZ * _selfx)))) < 0.0 ? -_t15 : _t15 : 0.0;
    }

    public static double orientedAngle_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        return Double3OpsKernelsAddress.orientedAngle_unsafe(_srcBase, _otherBase, _normalBase);
    }

    public static double orientedAngle_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _t6 = Math.fma(_otherz, _otherz, Math.fma(_otherx, _otherx, _othery * _othery));
        double _t7 = Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy));
        double _t15 = Math.acos(Math.min(1.0, Math.max(-1.0, Math.fma(_otherz, _selfz, Math.fma(_otherx, _selfx, _othery * _selfy)) * (1.0 / Math.sqrt(_t7)) * (1.0 / Math.sqrt(_t6)))));
        return Math.sqrt(_t6) * Math.sqrt(_t7) > 0.0 ? Math.fma(_normalz, Math.fma(_othery, _selfx, -(_otherx * _selfy)), Math.fma(_normalx, Math.fma(_otherz, _selfy, -(_othery * _selfz)), _normaly * Math.fma(_otherx, _selfz, -(_otherz * _selfx)))) < 0.0 ? -_t15 : _t15 : 0.0;
    }

    public static java.nio.DoubleBuffer outerProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rowX, double rowY, double rowZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.outerProduct_unsafe(_destBase, _srcBase, rowX, rowY, rowZ);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rowX, double rowY, double rowZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, rowX * _selfx);
        dest.put(destOffset + 1, rowX * _selfy);
        dest.put(destOffset + 2, rowX * _selfz);
        dest.put(destOffset + 3, rowY * _selfx);
        dest.put(destOffset + 4, rowY * _selfy);
        dest.put(destOffset + 5, rowY * _selfz);
        dest.put(destOffset + 6, rowZ * _selfx);
        dest.put(destOffset + 7, rowZ * _selfy);
        dest.put(destOffset + 8, rowZ * _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rowOffset * 8L;
        Double3OpsKernelsAddress.outerProduct_unsafe(_destBase, _srcBase, _rowBase);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer row, int rowOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _rowx = row.get(rowOffset + 0);
        double _rowy = row.get(rowOffset + 1);
        double _rowz = row.get(rowOffset + 2);
        dest.put(destOffset + 0, _rowx * _selfx);
        dest.put(destOffset + 1, _rowx * _selfy);
        dest.put(destOffset + 2, _rowx * _selfz);
        dest.put(destOffset + 3, _rowy * _selfx);
        dest.put(destOffset + 4, _rowy * _selfy);
        dest.put(destOffset + 5, _rowy * _selfz);
        dest.put(destOffset + 6, _rowz * _selfx);
        dest.put(destOffset + 7, _rowz * _selfy);
        dest.put(destOffset + 8, _rowz * _selfz);
        return dest;
    }

    public static java.nio.DoubleBuffer perpendicular_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.perpendicular_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer perpendicular_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t1 = Math.fma(_selfx, _selfx, _selfy * _selfy);
        if (_t1 > 0.0) {
            dest.put(destOffset + 0, _selfy);
            dest.put(destOffset + 1, -_selfx);
            dest.put(destOffset + 2, 0.0);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, _selfz);
            dest.put(destOffset + 2, -_selfy);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponent) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, exponent);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponent) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.pow(_selfx, exponent));
        dest.put(destOffset + 1, Math.pow(_selfy, exponent));
        dest.put(destOffset + 2, Math.pow(_selfz, exponent));
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponentX, double exponentY, double exponentZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, exponentX, exponentY, exponentZ);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponentX, double exponentY, double exponentZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.pow(_selfx, exponentX));
        dest.put(destOffset + 1, Math.pow(_selfy, exponentY));
        dest.put(destOffset + 2, Math.pow(_selfz, exponentZ));
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer exponent, int exponentOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _exponentBase = UnsafeOpsHolder.U.getLong(exponent, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) exponentOffset * 8L;
        Double3OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, _exponentBase);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer exponent, int exponentOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _exponentx = exponent.get(exponentOffset + 0);
        double _exponenty = exponent.get(exponentOffset + 1);
        double _exponentz = exponent.get(exponentOffset + 2);
        dest.put(destOffset + 0, Math.pow(_selfx, _exponentx));
        dest.put(destOffset + 1, Math.pow(_selfy, _exponenty));
        dest.put(destOffset + 2, Math.pow(_selfz, _exponentz));
        return dest;
    }

    public static java.nio.DoubleBuffer project_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double ontoX, double ontoY, double ontoZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.project_unsafe(_destBase, _srcBase, ontoX, ontoY, ontoZ);
        return dest;
    }

    public static java.nio.DoubleBuffer project_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double ontoX, double ontoY, double ontoZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t4 = Math.fma(ontoZ, _selfz, Math.fma(ontoX, _selfx, ontoY * _selfy));
        double _t5 = Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY));
        double _t5_inv = 1.0 / _t5;
        dest.put(destOffset + 0, ontoX * _t4 * _t5_inv);
        dest.put(destOffset + 1, ontoY * _t4 * _t5_inv);
        dest.put(destOffset + 2, ontoZ * _t4 * _t5_inv);
        return dest;
    }

    public static java.nio.DoubleBuffer project_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer onto, int ontoOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _ontoBase = UnsafeOpsHolder.U.getLong(onto, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) ontoOffset * 8L;
        Double3OpsKernelsAddress.project_unsafe(_destBase, _srcBase, _ontoBase);
        return dest;
    }

    public static java.nio.DoubleBuffer project_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer onto, int ontoOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _ontox = onto.get(ontoOffset + 0);
        double _ontoy = onto.get(ontoOffset + 1);
        double _ontoz = onto.get(ontoOffset + 2);
        double _t4 = Math.fma(_ontoz, _selfz, Math.fma(_ontox, _selfx, _ontoy * _selfy));
        double _t5 = Math.fma(_ontoz, _ontoz, Math.fma(_ontox, _ontox, _ontoy * _ontoy));
        double _t5_inv = 1.0 / _t5;
        dest.put(destOffset + 0, _ontox * _t4 * _t5_inv);
        dest.put(destOffset + 1, _ontoy * _t4 * _t5_inv);
        dest.put(destOffset + 2, _ontoz * _t4 * _t5_inv);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.projectOnPlane_unsafe(_destBase, _srcBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t2 = Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy));
        dest.put(destOffset + 0, Math.fma(-normalX, _t2, _selfx));
        dest.put(destOffset + 1, Math.fma(-normalY, _t2, _selfy));
        dest.put(destOffset + 2, Math.fma(-normalZ, _t2, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double3OpsKernelsAddress.projectOnPlane_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _t2 = Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy));
        dest.put(destOffset + 0, Math.fma(-_normalx, _t2, _selfx));
        dest.put(destOffset + 1, Math.fma(-_normaly, _t2, _selfy));
        dest.put(destOffset + 2, Math.fma(-_normalz, _t2, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer radians_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.radians_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer radians_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.toRadians(_selfx));
        dest.put(destOffset + 1, Math.toRadians(_selfy));
        dest.put(destOffset + 2, Math.toRadians(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t3 = 2.0 * Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy));
        dest.put(destOffset + 0, Math.fma(-normalX, _t3, _selfx));
        dest.put(destOffset + 1, Math.fma(-normalY, _t3, _selfy));
        dest.put(destOffset + 2, Math.fma(-normalZ, _t3, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double3OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _t3 = 2.0 * Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy));
        dest.put(destOffset + 0, Math.fma(-_normalx, _t3, _selfx));
        dest.put(destOffset + 1, Math.fma(-_normaly, _t3, _selfy));
        dest.put(destOffset + 2, Math.fma(-_normalz, _t3, _selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer refract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double eta) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.refract_unsafe(_destBase, _srcBase, normalX, normalY, normalZ, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double eta) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t3 = Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy));
        double _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0), eta * eta, 1.0);
        double _t10 = Math.fma(eta, _t3, Math.sqrt(Math.max(0.0, _t7)));
        if (_t7 >= 0.0) {
            dest.put(destOffset + 0, Math.fma(eta, _selfx, -(normalX * _t10)));
            dest.put(destOffset + 1, Math.fma(eta, _selfy, -(normalY * _t10)));
            dest.put(destOffset + 2, Math.fma(eta, _selfz, -(normalZ * _t10)));
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer refract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset, double eta) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double3OpsKernelsAddress.refract_unsafe(_destBase, _srcBase, _normalBase, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset, double eta) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _t3 = Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy));
        double _t7 = Math.fma(-Math.fma(-_t3, _t3, 1.0), eta * eta, 1.0);
        double _t10 = Math.fma(eta, _t3, Math.sqrt(Math.max(0.0, _t7)));
        if (_t7 >= 0.0) {
            dest.put(destOffset + 0, Math.fma(eta, _selfx, -(_normalx * _t10)));
            dest.put(destOffset + 1, Math.fma(eta, _selfy, -(_normaly * _t10)));
            dest.put(destOffset + 2, Math.fma(eta, _selfz, -(_normalz * _t10)));
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer round_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.round_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer round_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.rint(_selfx));
        dest.put(destOffset + 1, Math.rint(_selfy));
        dest.put(destOffset + 2, Math.rint(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer sign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.sign_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.signum(_selfx));
        dest.put(destOffset + 1, Math.signum(_selfy));
        dest.put(destOffset + 2, Math.signum(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer sin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.sin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.sin(_selfx));
        dest.put(destOffset + 1, Math.sin(_selfy));
        dest.put(destOffset + 2, Math.sin(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer sinh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.sinh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sinh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.sinh(_selfx));
        dest.put(destOffset + 1, Math.sinh(_selfy));
        dest.put(destOffset + 2, Math.sinh(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0, double edge1) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, edge0, edge1);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0, double edge1) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = edge1 - edge0;
        double _t0_inv = 1.0 / _t0;
        double _t10 = Math.max(0.0, Math.min(1.0, (_selfx - edge0) * _t0_inv));
        double _t11 = Math.max(0.0, Math.min(1.0, (_selfy - edge0) * _t0_inv));
        double _t12 = Math.max(0.0, Math.min(1.0, (_selfz - edge0) * _t0_inv));
        dest.put(destOffset + 0, Math.fma(-2.0, _t10, 3.0) * _t10 * _t10);
        dest.put(destOffset + 1, Math.fma(-2.0, _t11, 3.0) * _t11 * _t11);
        dest.put(destOffset + 2, Math.fma(-2.0, _t12, 3.0) * _t12 * _t12);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0X, double edge0Y, double edge0Z, double edge1X, double edge1Y, double edge1Z) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, edge0X, edge0Y, edge0Z, edge1X, edge1Y, edge1Z);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0X, double edge0Y, double edge0Z, double edge1X, double edge1Y, double edge1Z) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t12 = Math.max(0.0, Math.min(1.0, (_selfx - edge0X) / (edge1X - edge0X)));
        double _t13 = Math.max(0.0, Math.min(1.0, (_selfy - edge0Y) / (edge1Y - edge0Y)));
        double _t14 = Math.max(0.0, Math.min(1.0, (_selfz - edge0Z) / (edge1Z - edge0Z)));
        dest.put(destOffset + 0, Math.fma(-2.0, _t12, 3.0) * _t12 * _t12);
        dest.put(destOffset + 1, Math.fma(-2.0, _t13, 3.0) * _t13 * _t13);
        dest.put(destOffset + 2, Math.fma(-2.0, _t14, 3.0) * _t14 * _t14);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge0, int edge0Offset, java.nio.DoubleBuffer edge1, int edge1Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _edge0Base = UnsafeOpsHolder.U.getLong(edge0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edge0Offset * 8L;
        long _edge1Base = UnsafeOpsHolder.U.getLong(edge1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edge1Offset * 8L;
        Double3OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, _edge0Base, _edge1Base);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge0, int edge0Offset, java.nio.DoubleBuffer edge1, int edge1Offset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _edge0x = edge0.get(edge0Offset + 0);
        double _edge0y = edge0.get(edge0Offset + 1);
        double _edge0z = edge0.get(edge0Offset + 2);
        double _edge1x = edge1.get(edge1Offset + 0);
        double _edge1y = edge1.get(edge1Offset + 1);
        double _edge1z = edge1.get(edge1Offset + 2);
        double _t12 = Math.max(0.0, Math.min(1.0, (_selfx - _edge0x) / (_edge1x - _edge0x)));
        double _t13 = Math.max(0.0, Math.min(1.0, (_selfy - _edge0y) / (_edge1y - _edge0y)));
        double _t14 = Math.max(0.0, Math.min(1.0, (_selfz - _edge0z) / (_edge1z - _edge0z)));
        dest.put(destOffset + 0, Math.fma(-2.0, _t12, 3.0) * _t12 * _t12);
        dest.put(destOffset + 1, Math.fma(-2.0, _t13, 3.0) * _t13 * _t13);
        dest.put(destOffset + 2, Math.fma(-2.0, _t14, 3.0) * _t14 * _t14);
        return dest;
    }

    public static java.nio.DoubleBuffer sqrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.sqrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sqrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.sqrt(_selfx));
        dest.put(destOffset + 1, Math.sqrt(_selfy));
        dest.put(destOffset + 2, Math.sqrt(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.step_unsafe(_destBase, _srcBase, edge);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx < edge ? 0.0 : 1.0);
        dest.put(destOffset + 1, _selfy < edge ? 0.0 : 1.0);
        dest.put(destOffset + 2, _selfz < edge ? 0.0 : 1.0);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edgeX, double edgeY, double edgeZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.step_unsafe(_destBase, _srcBase, edgeX, edgeY, edgeZ);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edgeX, double edgeY, double edgeZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx < edgeX ? 0.0 : 1.0);
        dest.put(destOffset + 1, _selfy < edgeY ? 0.0 : 1.0);
        dest.put(destOffset + 2, _selfz < edgeZ ? 0.0 : 1.0);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge, int edgeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _edgeBase = UnsafeOpsHolder.U.getLong(edge, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edgeOffset * 8L;
        Double3OpsKernelsAddress.step_unsafe(_destBase, _srcBase, _edgeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge, int edgeOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _edgex = edge.get(edgeOffset + 0);
        double _edgey = edge.get(edgeOffset + 1);
        double _edgez = edge.get(edgeOffset + 2);
        dest.put(destOffset + 0, _selfx < _edgex ? 0.0 : 1.0);
        dest.put(destOffset + 1, _selfy < _edgey ? 0.0 : 1.0);
        dest.put(destOffset + 2, _selfz < _edgez ? 0.0 : 1.0);
        return dest;
    }

    public static java.nio.DoubleBuffer tan_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.tan_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer tan_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.tan(_selfx));
        dest.put(destOffset + 1, Math.tan(_selfy));
        dest.put(destOffset + 2, Math.tan(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer tanh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.tanh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer tanh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.tanh(_selfx));
        dest.put(destOffset + 1, Math.tanh(_selfy));
        dest.put(destOffset + 2, Math.tanh(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer triangleNormal_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.triangleNormal_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p2X, p2Y, p2Z);
        return dest;
    }

    public static java.nio.DoubleBuffer triangleNormal_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p2X, double p2Y, double p2Z) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = p1X - _selfx;
        double _t1 = p2Y - _selfy;
        double _t2 = p1Y - _selfy;
        double _t3 = p2X - _selfx;
        double _t4 = p2Z - _selfz;
        double _t5 = p1Z - _selfz;
        double _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        double _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        double _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        double _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        double _t18 = (1.0 / Math.sqrt(_t17));
        if (_t17 > 0.0) {
            dest.put(destOffset + 0, _t13 * _t18);
            dest.put(destOffset + 1, _t14 * _t18);
            dest.put(destOffset + 2, _t12 * _t18);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer triangleNormal_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double3OpsKernelsAddress.triangleNormal_unsafe(_destBase, _srcBase, _p1Base, _p2Base);
        return dest;
    }

    public static java.nio.DoubleBuffer triangleNormal_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _t0 = _p1x - _selfx;
        double _t1 = _p2y - _selfy;
        double _t2 = _p1y - _selfy;
        double _t3 = _p2x - _selfx;
        double _t4 = _p2z - _selfz;
        double _t5 = _p1z - _selfz;
        double _t12 = Math.fma(_t0, _t1, -(_t2 * _t3));
        double _t13 = Math.fma(_t2, _t4, -(_t5 * _t1));
        double _t14 = Math.fma(_t5, _t3, -(_t0 * _t4));
        double _t17 = Math.fma(_t12, _t12, Math.fma(_t13, _t13, _t14 * _t14));
        double _t18 = (1.0 / Math.sqrt(_t17));
        if (_t17 > 0.0) {
            dest.put(destOffset + 0, _t13 * _t18);
            dest.put(destOffset + 1, _t14 * _t18);
            dest.put(destOffset + 2, _t12 * _t18);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer trunc_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.trunc_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer trunc_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx >= 0.0 ? Math.floor(_selfx) : Math.ceil(_selfx));
        dest.put(destOffset + 1, _selfy >= 0.0 ? Math.floor(_selfy) : Math.ceil(_selfy));
        dest.put(destOffset + 2, _selfz >= 0.0 ? Math.floor(_selfz) : Math.ceil(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer ulp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.ulp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer ulp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, Math.ulp(_selfx));
        dest.put(destOffset + 1, Math.ulp(_selfy));
        dest.put(destOffset + 2, Math.ulp(_selfz));
        return dest;
    }

    public static java.nio.DoubleBuffer xyz0_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.xyz0_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer xyz0_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx);
        dest.put(destOffset + 1, _selfy);
        dest.put(destOffset + 2, _selfz);
        dest.put(destOffset + 3, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer xyz1_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.xyz1_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer xyz1_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        dest.put(destOffset + 0, _selfx);
        dest.put(destOffset + 1, _selfy);
        dest.put(destOffset + 2, _selfz);
        dest.put(destOffset + 3, 1.0);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double3OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _mat00 = mat.get(matOffset + 0);
        double _mat10 = mat.get(matOffset + 1);
        double _mat20 = mat.get(matOffset + 2);
        double _mat01 = mat.get(matOffset + 3);
        double _mat11 = mat.get(matOffset + 4);
        double _mat21 = mat.get(matOffset + 5);
        double _mat02 = mat.get(matOffset + 6);
        double _mat12 = mat.get(matOffset + 7);
        double _mat22 = mat.get(matOffset + 8);
        dest.put(destOffset + 0, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        dest.put(destOffset + 1, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        dest.put(destOffset + 2, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        return dest;
    }

    public static java.nio.DoubleBuffer preMulDirectionMat3x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double3OpsKernelsAddress.preMulDirectionMat3x4_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulDirectionMat3x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _mat00 = mat.get(matOffset + 0);
        double _mat01 = mat.get(matOffset + 1);
        double _mat02 = mat.get(matOffset + 2);
        double _mat10 = mat.get(matOffset + 4);
        double _mat11 = mat.get(matOffset + 5);
        double _mat12 = mat.get(matOffset + 6);
        double _mat20 = mat.get(matOffset + 8);
        double _mat21 = mat.get(matOffset + 9);
        double _mat22 = mat.get(matOffset + 10);
        dest.put(destOffset + 0, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        dest.put(destOffset + 1, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        dest.put(destOffset + 2, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        return dest;
    }

    public static java.nio.DoubleBuffer preMulDirectionMat4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double3OpsKernelsAddress.preMulDirectionMat4x4_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulDirectionMat4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _mat00 = mat.get(matOffset + 0);
        double _mat10 = mat.get(matOffset + 1);
        double _mat20 = mat.get(matOffset + 2);
        double _mat01 = mat.get(matOffset + 4);
        double _mat11 = mat.get(matOffset + 5);
        double _mat21 = mat.get(matOffset + 6);
        double _mat02 = mat.get(matOffset + 8);
        double _mat12 = mat.get(matOffset + 9);
        double _mat22 = mat.get(matOffset + 10);
        dest.put(destOffset + 0, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy)));
        dest.put(destOffset + 1, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy)));
        dest.put(destOffset + 2, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy)));
        return dest;
    }

    public static java.nio.DoubleBuffer preMulPositionMat3x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double3OpsKernelsAddress.preMulPositionMat3x4_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulPositionMat3x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _mat00 = mat.get(matOffset + 0);
        double _mat01 = mat.get(matOffset + 1);
        double _mat02 = mat.get(matOffset + 2);
        double _mat03 = mat.get(matOffset + 3);
        double _mat10 = mat.get(matOffset + 4);
        double _mat11 = mat.get(matOffset + 5);
        double _mat12 = mat.get(matOffset + 6);
        double _mat13 = mat.get(matOffset + 7);
        double _mat20 = mat.get(matOffset + 8);
        double _mat21 = mat.get(matOffset + 9);
        double _mat22 = mat.get(matOffset + 10);
        double _mat23 = mat.get(matOffset + 11);
        dest.put(destOffset + 0, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, Math.fma(_mat02, _selfz, _mat03))));
        dest.put(destOffset + 1, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, Math.fma(_mat12, _selfz, _mat13))));
        dest.put(destOffset + 2, Math.fma(_mat20, _selfx, Math.fma(_mat21, _selfy, Math.fma(_mat22, _selfz, _mat23))));
        return dest;
    }

    public static java.nio.DoubleBuffer preMulPositionMat4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double3OpsKernelsAddress.preMulPositionMat4x4_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulPositionMat4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _mat00 = mat.get(matOffset + 0);
        double _mat10 = mat.get(matOffset + 1);
        double _mat20 = mat.get(matOffset + 2);
        double _mat01 = mat.get(matOffset + 4);
        double _mat11 = mat.get(matOffset + 5);
        double _mat21 = mat.get(matOffset + 6);
        double _mat02 = mat.get(matOffset + 8);
        double _mat12 = mat.get(matOffset + 9);
        double _mat22 = mat.get(matOffset + 10);
        double _mat03 = mat.get(matOffset + 12);
        double _mat13 = mat.get(matOffset + 13);
        double _mat23 = mat.get(matOffset + 14);
        dest.put(destOffset + 0, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, Math.fma(_mat02, _selfz, _mat03))));
        dest.put(destOffset + 1, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, Math.fma(_mat12, _selfz, _mat13))));
        dest.put(destOffset + 2, Math.fma(_mat20, _selfx, Math.fma(_mat21, _selfy, Math.fma(_mat22, _selfz, _mat23))));
        return dest;
    }

    public static java.nio.DoubleBuffer preMulProject_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double3OpsKernelsAddress.preMulProject_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulProject_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _mat00 = mat.get(matOffset + 0);
        double _mat10 = mat.get(matOffset + 1);
        double _mat20 = mat.get(matOffset + 2);
        double _mat30 = mat.get(matOffset + 3);
        double _mat01 = mat.get(matOffset + 4);
        double _mat11 = mat.get(matOffset + 5);
        double _mat21 = mat.get(matOffset + 6);
        double _mat31 = mat.get(matOffset + 7);
        double _mat02 = mat.get(matOffset + 8);
        double _mat12 = mat.get(matOffset + 9);
        double _mat22 = mat.get(matOffset + 10);
        double _mat32 = mat.get(matOffset + 11);
        double _mat03 = mat.get(matOffset + 12);
        double _mat13 = mat.get(matOffset + 13);
        double _mat23 = mat.get(matOffset + 14);
        double _mat33 = mat.get(matOffset + 15);
        double _t2 = Math.fma(_mat30, _selfx, Math.fma(_mat31, _selfy, Math.fma(_mat32, _selfz, _mat33)));
        double _t2_inv = 1.0 / _t2;
        dest.put(destOffset + 0, Math.fma(_mat00, _selfx, Math.fma(_mat01, _selfy, Math.fma(_mat02, _selfz, _mat03))) * _t2_inv);
        dest.put(destOffset + 1, Math.fma(_mat10, _selfx, Math.fma(_mat11, _selfy, Math.fma(_mat12, _selfz, _mat13))) * _t2_inv);
        dest.put(destOffset + 2, Math.fma(_mat20, _selfx, Math.fma(_mat21, _selfy, Math.fma(_mat22, _selfz, _mat23))) * _t2_inv);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, quatX, quatY, quatZ, quatW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t9 = 2.0 * Math.fma(quatX, _selfy, -(quatY * _selfx));
        double _t10 = 2.0 * Math.fma(quatZ, _selfx, -(quatX * _selfz));
        double _t11 = 2.0 * Math.fma(quatY, _selfz, -(quatZ * _selfy));
        dest.put(destOffset + 0, Math.fma(quatY, _t9, Math.fma(-quatZ, _t10, Math.fma(quatW, _t11, _selfx))));
        dest.put(destOffset + 1, Math.fma(quatZ, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, _selfy))));
        dest.put(destOffset + 2, Math.fma(quatX, _t10, Math.fma(-quatY, _t11, Math.fma(quatW, _t9, _selfz))));
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _quatBase = UnsafeOpsHolder.U.getLong(quat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) quatOffset * 8L;
        Double3OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, _quatBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _quatx = quat.get(quatOffset + 0);
        double _quaty = quat.get(quatOffset + 1);
        double _quatz = quat.get(quatOffset + 2);
        double _quatw = quat.get(quatOffset + 3);
        double _t9 = 2.0 * Math.fma(_quatx, _selfy, -(_quaty * _selfx));
        double _t10 = 2.0 * Math.fma(_quatz, _selfx, -(_quatx * _selfz));
        double _t11 = 2.0 * Math.fma(_quaty, _selfz, -(_quatz * _selfy));
        dest.put(destOffset + 0, Math.fma(_quaty, _t9, Math.fma(-_quatz, _t10, Math.fma(_quatw, _t11, _selfx))));
        dest.put(destOffset + 1, Math.fma(_quatz, _t11, Math.fma(-_quatx, _t9, Math.fma(_quatw, _t10, _selfy))));
        dest.put(destOffset + 2, Math.fma(_quatx, _t10, Math.fma(-_quaty, _t11, Math.fma(_quatw, _t9, _selfz))));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t5 = Math.fma(axisZ, _selfz, Math.fma(axisX, _selfx, axisY * _selfy));
        dest.put(destOffset + 0, Math.fma(_t2, axisX * _t5, Math.fma(_selfx, _t0, Math.fma(axisY, _selfz, -(axisZ * _selfy)) * _t1)));
        dest.put(destOffset + 1, Math.fma(_t2, axisY * _t5, Math.fma(_selfy, _t0, Math.fma(axisZ, _selfx, -(axisX * _selfz)) * _t1)));
        dest.put(destOffset + 2, Math.fma(_t2, axisZ * _t5, Math.fma(_selfz, _t0, Math.fma(axisX, _selfy, -(axisY * _selfx)) * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double3OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _axisx = axis.get(axisOffset + 0);
        double _axisy = axis.get(axisOffset + 1);
        double _axisz = axis.get(axisOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        double _t2 = 1.0 - _t0;
        double _t5 = Math.fma(_axisz, _selfz, Math.fma(_axisx, _selfx, _axisy * _selfy));
        dest.put(destOffset + 0, Math.fma(_t2, _axisx * _t5, Math.fma(_selfx, _t0, Math.fma(_axisy, _selfz, -(_axisz * _selfy)) * _t1)));
        dest.put(destOffset + 1, Math.fma(_t2, _axisy * _t5, Math.fma(_selfy, _t0, Math.fma(_axisz, _selfx, -(_axisx * _selfz)) * _t1)));
        dest.put(destOffset + 2, Math.fma(_t2, _axisz * _t5, Math.fma(_selfz, _t0, Math.fma(_axisx, _selfy, -(_axisy * _selfx)) * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.rotateInverse_unsafe(_destBase, _srcBase, quatX, quatY, quatZ, quatW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t9 = 2.0 * Math.fma(quatX, _selfz, -(quatZ * _selfx));
        double _t10 = 2.0 * Math.fma(quatY, _selfx, -(quatX * _selfy));
        double _t11 = 2.0 * Math.fma(quatZ, _selfy, -(quatY * _selfz));
        dest.put(destOffset + 0, Math.fma(quatZ, _t9, Math.fma(-quatY, _t10, Math.fma(quatW, _t11, _selfx))));
        dest.put(destOffset + 1, Math.fma(quatX, _t10, Math.fma(-quatZ, _t11, Math.fma(quatW, _t9, _selfy))));
        dest.put(destOffset + 2, Math.fma(quatY, _t11, Math.fma(-quatX, _t9, Math.fma(quatW, _t10, _selfz))));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _quatBase = UnsafeOpsHolder.U.getLong(quat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) quatOffset * 8L;
        Double3OpsKernelsAddress.rotateInverse_unsafe(_destBase, _srcBase, _quatBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _quatx = quat.get(quatOffset + 0);
        double _quaty = quat.get(quatOffset + 1);
        double _quatz = quat.get(quatOffset + 2);
        double _quatw = quat.get(quatOffset + 3);
        double _t9 = 2.0 * Math.fma(_quatx, _selfz, -(_quatz * _selfx));
        double _t10 = 2.0 * Math.fma(_quaty, _selfx, -(_quatx * _selfy));
        double _t11 = 2.0 * Math.fma(_quatz, _selfy, -(_quaty * _selfz));
        dest.put(destOffset + 0, Math.fma(_quatz, _t9, Math.fma(-_quaty, _t10, Math.fma(_quatw, _t11, _selfx))));
        dest.put(destOffset + 1, Math.fma(_quatx, _t10, Math.fma(-_quatz, _t11, Math.fma(_quatw, _t9, _selfy))));
        dest.put(destOffset + 2, Math.fma(_quaty, _t11, Math.fma(-_quatx, _t9, Math.fma(_quatw, _t10, _selfz))));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, _selfx);
        dest.put(destOffset + 1, Math.fma(_selfy, _t0, -(_selfz * _t1)));
        dest.put(destOffset + 2, Math.fma(_selfy, _t1, _selfz * _t0));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_selfx, _t0, _selfz * _t1));
        dest.put(destOffset + 1, _selfy);
        dest.put(destOffset + 2, Math.fma(_selfz, _t0, -(_selfx * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _t0 = Math.cos(angle);
        double _t1 = Math.sin(angle);
        dest.put(destOffset + 0, Math.fma(_selfx, _t0, -(_selfy * _t1)));
        dest.put(destOffset + 1, Math.fma(_selfx, _t1, _selfy * _t0));
        dest.put(destOffset + 2, _selfz);
        return dest;
    }

}
