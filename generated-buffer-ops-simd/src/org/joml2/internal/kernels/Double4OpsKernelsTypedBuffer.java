package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double4Ops} whose leading storage
 * parameter is a typed {@link java.nio.DoubleBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double4Ops} and its sibling kernel units. Not public API.
 */
public final class Double4OpsKernelsTypedBuffer {
    private Double4OpsKernelsTypedBuffer() {}

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.add_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.add(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
            return dest;
        }
        Double4OpsKernelsSegment.add_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, _otherx + _selfx);
        dest.put(destOffset + 1, _othery + _selfy);
        dest.put(destOffset + 2, _otherz + _selfz);
        dest.put(destOffset + 3, _otherw + _selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.div_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _rcp0 = 1.0 / scalar;
        dest.put(destOffset + 0, _selfx * _rcp0);
        dest.put(destOffset + 1, _selfy * _rcp0);
        dest.put(destOffset + 2, _selfz * _rcp0);
        dest.put(destOffset + 3, _selfw * _rcp0);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.div_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.div(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
            return dest;
        }
        Double4OpsKernelsSegment.div_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.div_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, _selfx / _otherx);
        dest.put(destOffset + 1, _selfy / _othery);
        dest.put(destOffset + 2, _selfz / _otherz);
        dest.put(destOffset + 3, _selfw / _otherw);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double b, double cX, double cY, double cZ, double cW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, b, cX, cY, cZ, cW);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double b, double cX, double cY, double cZ, double cW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.fma(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, b, cX, cY, cZ, cW);
            return dest;
        }
        Double4OpsKernelsSegment.fma_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, b, cX, cY, cZ, cW);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer c, int cOffset, double b) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double4OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, _cBase, b);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer c, int cOffset, double b) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _cx = c.get(cOffset + 0);
        double _cy = c.get(cOffset + 1);
        double _cz = c.get(cOffset + 2);
        double _cw = c.get(cOffset + 3);
        dest.put(destOffset + 0, Math.fma(_selfx, b, _cx));
        dest.put(destOffset + 1, Math.fma(_selfy, b, _cy));
        dest.put(destOffset + 2, Math.fma(_selfz, b, _cz));
        dest.put(destOffset + 3, Math.fma(_selfw, b, _cw));
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double bW, double cX, double cY, double cZ, double cW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, bX, bY, bZ, bW, cX, cY, cZ, cW);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double bW, double cX, double cY, double cZ, double cW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.fma(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, bX, bY, bZ, bW, cX, cY, cZ, cW);
            return dest;
        }
        Double4OpsKernelsSegment.fma_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, bX, bY, bZ, bW, cX, cY, cZ, cW);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double4OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, _bBase, _cBase);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _bx = b.get(bOffset + 0);
        double _by = b.get(bOffset + 1);
        double _bz = b.get(bOffset + 2);
        double _bw = b.get(bOffset + 3);
        double _cx = c.get(cOffset + 0);
        double _cy = c.get(cOffset + 1);
        double _cz = c.get(cOffset + 2);
        double _cw = c.get(cOffset + 3);
        dest.put(destOffset + 0, Math.fma(_selfx, _bx, _cx));
        dest.put(destOffset + 1, Math.fma(_selfy, _by, _cy));
        dest.put(destOffset + 2, Math.fma(_selfz, _bz, _cz));
        dest.put(destOffset + 3, Math.fma(_selfw, _bw, _cw));
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, scalar * _selfx);
        dest.put(destOffset + 1, scalar * _selfy);
        dest.put(destOffset + 2, scalar * _selfz);
        dest.put(destOffset + 3, scalar * _selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
            return dest;
        }
        Double4OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, _otherx * _selfx);
        dest.put(destOffset + 1, _othery * _selfy);
        dest.put(destOffset + 2, _otherz * _selfz);
        dest.put(destOffset + 3, _otherw * _selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, -_selfx);
        dest.put(destOffset + 1, -_selfy);
        dest.put(destOffset + 2, -_selfz);
        dest.put(destOffset + 3, -_selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.sub(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
            return dest;
        }
        Double4OpsKernelsSegment.sub_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, _selfx - _otherx);
        dest.put(destOffset + 1, _selfy - _othery);
        dest.put(destOffset + 2, _selfz - _otherz);
        dest.put(destOffset + 3, _selfw - _otherw);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ, double vW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4OpsKernelsAddress.set_unsafe(_destBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ, double vW) {
        if (dest.hasArray()) {
            Double4Ops.set(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ, vW);
            return dest;
        }
        Double4OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        double _vx = v.get(vOffset + 0);
        double _vy = v.get(vOffset + 1);
        double _vz = v.get(vOffset + 2);
        double _vw = v.get(vOffset + 3);
        dest.put(destOffset + 0, _vx);
        dest.put(destOffset + 1, _vy);
        dest.put(destOffset + 2, _vz);
        dest.put(destOffset + 3, _vw);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4OpsKernelsAddress.set_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, double s) {
        dest.put(destOffset + 0, s);
        dest.put(destOffset + 1, s);
        dest.put(destOffset + 2, s);
        dest.put(destOffset + 3, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeZero_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4OpsKernelsAddress.makeZero_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeZero_api(java.nio.DoubleBuffer dest, int destOffset) {
        dest.put(destOffset + 0, 0.0);
        dest.put(destOffset + 1, 0.0);
        dest.put(destOffset + 2, 0.0);
        dest.put(destOffset + 3, 0.0);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.bezier_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.bezier(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
            return dest;
        }
        Double4OpsKernelsSegment.bezier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double4OpsKernelsAddress.bezier_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p1w = p1.get(p1Offset + 3);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p2w = p2.get(p2Offset + 3);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _p3w = p3.get(p3Offset + 3);
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
        dest.put(destOffset + 3, Math.fma(_p1w, _t7, _selfw * _t8) + Math.fma(_p2w, _t6, _p3w * _t2));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.bezier2_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.bezier2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, t);
            return dest;
        }
        Double4OpsKernelsSegment.bezier2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double4OpsKernelsAddress.bezier2_unsafe(_destBase, _srcBase, _p1Base, _p2Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p1w = p1.get(p1Offset + 3);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p2w = p2.get(p2Offset + 3);
        double _t0 = t * t;
        double _t1 = 1.0 - t;
        double _t3 = 2.0 * t * _t1;
        double _t4 = _t1 * _t1;
        dest.put(destOffset + 0, Math.fma(_p2x, _t0, Math.fma(_p1x, _t3, _selfx * _t4)));
        dest.put(destOffset + 1, Math.fma(_p2y, _t0, Math.fma(_p1y, _t3, _selfy * _t4)));
        dest.put(destOffset + 2, Math.fma(_p2z, _t0, Math.fma(_p1z, _t3, _selfz * _t4)));
        dest.put(destOffset + 3, Math.fma(_p2w, _t0, Math.fma(_p1w, _t3, _selfw * _t4)));
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.bezier2Tangent_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.bezier2Tangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, t);
            return dest;
        }
        Double4OpsKernelsSegment.bezier2Tangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double4OpsKernelsAddress.bezier2Tangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p1w = p1.get(p1Offset + 3);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p2w = p2.get(p2Offset + 3);
        double _t1 = 2.0 * t;
        double _t2 = 2.0 * (1.0 - t);
        dest.put(destOffset + 0, Math.fma(_p1x - _selfx, _t2, (_p2x - _p1x) * _t1));
        dest.put(destOffset + 1, Math.fma(_p1y - _selfy, _t2, (_p2y - _p1y) * _t1));
        dest.put(destOffset + 2, Math.fma(_p1z - _selfz, _t2, (_p2z - _p1z) * _t1));
        dest.put(destOffset + 3, Math.fma(_p1w - _selfw, _t2, (_p2w - _p1w) * _t1));
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.bezierTangent_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.bezierTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
            return dest;
        }
        Double4OpsKernelsSegment.bezierTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double4OpsKernelsAddress.bezierTangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p1w = p1.get(p1Offset + 3);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p2w = p2.get(p2Offset + 3);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _p3w = p3.get(p3Offset + 3);
        double _t1 = 1.0 - t;
        double _t2 = 3.0 * t * t;
        double _t5 = 6.0 * t * _t1;
        double _t6 = 3.0 * _t1 * _t1;
        dest.put(destOffset + 0, Math.fma(_p3x - _p2x, _t2, Math.fma(_p1x - _selfx, _t6, (_p2x - _p1x) * _t5)));
        dest.put(destOffset + 1, Math.fma(_p3y - _p2y, _t2, Math.fma(_p1y - _selfy, _t6, (_p2y - _p1y) * _t5)));
        dest.put(destOffset + 2, Math.fma(_p3z - _p2z, _t2, Math.fma(_p1z - _selfz, _t6, (_p2z - _p1z) * _t5)));
        dest.put(destOffset + 3, Math.fma(_p3w - _p2w, _t2, Math.fma(_p1w - _selfw, _t6, (_p2w - _p1w) * _t5)));
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.catmullRom_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.catmullRom(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
            return dest;
        }
        Double4OpsKernelsSegment.catmullRom_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double4OpsKernelsAddress.catmullRom_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p1w = p1.get(p1Offset + 3);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p2w = p2.get(p2Offset + 3);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _p3w = p3.get(p3Offset + 3);
        double _t0 = t * t;
        double _t1 = t * _t0;
        dest.put(destOffset + 0, 0.5 * (Math.fma(2.0, _p1x, t * (_p2x - _selfx)) + Math.fma(Math.fma(-5.0, _p1x, Math.fma(2.0, _selfx, Math.fma(4.0, _p2x, -_p3x))), _t0, Math.fma(-3.0, _p2x, Math.fma(3.0, _p1x, _p3x - _selfx)) * _t1)));
        dest.put(destOffset + 1, 0.5 * (Math.fma(2.0, _p1y, t * (_p2y - _selfy)) + Math.fma(Math.fma(-5.0, _p1y, Math.fma(2.0, _selfy, Math.fma(4.0, _p2y, -_p3y))), _t0, Math.fma(-3.0, _p2y, Math.fma(3.0, _p1y, _p3y - _selfy)) * _t1)));
        dest.put(destOffset + 2, 0.5 * (Math.fma(2.0, _p1z, t * (_p2z - _selfz)) + Math.fma(Math.fma(-5.0, _p1z, Math.fma(2.0, _selfz, Math.fma(4.0, _p2z, -_p3z))), _t0, Math.fma(-3.0, _p2z, Math.fma(3.0, _p1z, _p3z - _selfz)) * _t1)));
        dest.put(destOffset + 3, 0.5 * (Math.fma(2.0, _p1w, t * (_p2w - _selfw)) + Math.fma(Math.fma(-5.0, _p1w, Math.fma(2.0, _selfw, Math.fma(4.0, _p2w, -_p3w))), _t0, Math.fma(-3.0, _p2w, Math.fma(3.0, _p1w, _p3w - _selfw)) * _t1)));
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.catmullRomTangent_unsafe(_destBase, _srcBase, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p1Z, double p1W, double p2X, double p2Y, double p2Z, double p2W, double p3X, double p3Y, double p3Z, double p3W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.catmullRomTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
            return dest;
        }
        Double4OpsKernelsSegment.catmullRomTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p1Z, p1W, p2X, p2Y, p2Z, p2W, p3X, p3Y, p3Z, p3W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double4OpsKernelsAddress.catmullRomTangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _p1x = p1.get(p1Offset + 0);
        double _p1y = p1.get(p1Offset + 1);
        double _p1z = p1.get(p1Offset + 2);
        double _p1w = p1.get(p1Offset + 3);
        double _p2x = p2.get(p2Offset + 0);
        double _p2y = p2.get(p2Offset + 1);
        double _p2z = p2.get(p2Offset + 2);
        double _p2w = p2.get(p2Offset + 3);
        double _p3x = p3.get(p3Offset + 0);
        double _p3y = p3.get(p3Offset + 1);
        double _p3z = p3.get(p3Offset + 2);
        double _p3w = p3.get(p3Offset + 3);
        double _t0 = t * t;
        dest.put(destOffset + 0, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1x, Math.fma(2.0, _selfx, Math.fma(4.0, _p2x, -_p3x))), Math.fma(3.0 * Math.fma(-3.0, _p2x, Math.fma(3.0, _p1x, _p3x - _selfx)), _t0, _p2x - _selfx)));
        dest.put(destOffset + 1, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1y, Math.fma(2.0, _selfy, Math.fma(4.0, _p2y, -_p3y))), Math.fma(3.0 * Math.fma(-3.0, _p2y, Math.fma(3.0, _p1y, _p3y - _selfy)), _t0, _p2y - _selfy)));
        dest.put(destOffset + 2, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1z, Math.fma(2.0, _selfz, Math.fma(4.0, _p2z, -_p3z))), Math.fma(3.0 * Math.fma(-3.0, _p2z, Math.fma(3.0, _p1z, _p3z - _selfz)), _t0, _p2z - _selfz)));
        dest.put(destOffset + 3, 0.5 * Math.fma(t, 2.0 * Math.fma(-5.0, _p1w, Math.fma(2.0, _selfw, Math.fma(4.0, _p2w, -_p3w))), Math.fma(3.0 * Math.fma(-3.0, _p2w, Math.fma(3.0, _p1w, _p3w - _selfw)), _t0, _p2w - _selfw)));
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double t0W, double v1X, double v1Y, double v1Z, double v1W, double t1X, double t1Y, double t1Z, double t1W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.hermite_unsafe(_destBase, _srcBase, t0X, t0Y, t0Z, t0W, v1X, v1Y, v1Z, v1W, t1X, t1Y, t1Z, t1W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double t0W, double v1X, double v1Y, double v1Z, double v1W, double t1X, double t1Y, double t1Z, double t1W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.hermite(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t0X, t0Y, t0Z, t0W, v1X, v1Y, v1Z, v1W, t1X, t1Y, t1Z, t1W, t);
            return dest;
        }
        Double4OpsKernelsSegment.hermite_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, t0X, t0Y, t0Z, t0W, v1X, v1Y, v1Z, v1W, t1X, t1Y, t1Z, t1W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _t0Base = UnsafeOpsHolder.U.getLong(t0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t0Offset * 8L;
        long _v1Base = UnsafeOpsHolder.U.getLong(v1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) v1Offset * 8L;
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        Double4OpsKernelsAddress.hermite_unsafe(_destBase, _srcBase, _t0Base, _v1Base, _t1Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t0x = t0.get(t0Offset + 0);
        double _t0y = t0.get(t0Offset + 1);
        double _t0z = t0.get(t0Offset + 2);
        double _t0w = t0.get(t0Offset + 3);
        double _v1x = v1.get(v1Offset + 0);
        double _v1y = v1.get(v1Offset + 1);
        double _v1z = v1.get(v1Offset + 2);
        double _v1w = v1.get(v1Offset + 3);
        double _t1x = t1.get(t1Offset + 0);
        double _t1y = t1.get(t1Offset + 1);
        double _t1z = t1.get(t1Offset + 2);
        double _t1w = t1.get(t1Offset + 3);
        double _t0 = t * t;
        double _t2 = t * _t0;
        double _t5 = t * Math.fma(t, t, -t);
        double _t7 = Math.fma(t - 2.0, _t0, t);
        double _t9 = Math.fma(3.0, _t0, -(2.0 * _t2));
        double _t10 = Math.fma(2.0, _t2, Math.fma(-3.0, _t0, 1.0));
        dest.put(destOffset + 0, Math.fma(_selfx, _t10, _t0x * _t7) + Math.fma(_t1x, _t5, _v1x * _t9));
        dest.put(destOffset + 1, Math.fma(_selfy, _t10, _t0y * _t7) + Math.fma(_t1y, _t5, _v1y * _t9));
        dest.put(destOffset + 2, Math.fma(_selfz, _t10, _t0z * _t7) + Math.fma(_t1z, _t5, _v1z * _t9));
        dest.put(destOffset + 3, Math.fma(_selfw, _t10, _t0w * _t7) + Math.fma(_t1w, _t5, _v1w * _t9));
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double t0W, double v1X, double v1Y, double v1Z, double v1W, double t1X, double t1Y, double t1Z, double t1W, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.hermiteTangent_unsafe(_destBase, _srcBase, t0X, t0Y, t0Z, t0W, v1X, v1Y, v1Z, v1W, t1X, t1Y, t1Z, t1W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double t0Z, double t0W, double v1X, double v1Y, double v1Z, double v1W, double t1X, double t1Y, double t1Z, double t1W, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.hermiteTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t0X, t0Y, t0Z, t0W, v1X, v1Y, v1Z, v1W, t1X, t1Y, t1Z, t1W, t);
            return dest;
        }
        Double4OpsKernelsSegment.hermiteTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, t0X, t0Y, t0Z, t0W, v1X, v1Y, v1Z, v1W, t1X, t1Y, t1Z, t1W, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _t0Base = UnsafeOpsHolder.U.getLong(t0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t0Offset * 8L;
        long _v1Base = UnsafeOpsHolder.U.getLong(v1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) v1Offset * 8L;
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        Double4OpsKernelsAddress.hermiteTangent_unsafe(_destBase, _srcBase, _t0Base, _v1Base, _t1Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t0x = t0.get(t0Offset + 0);
        double _t0y = t0.get(t0Offset + 1);
        double _t0z = t0.get(t0Offset + 2);
        double _t0w = t0.get(t0Offset + 3);
        double _v1x = v1.get(v1Offset + 0);
        double _v1y = v1.get(v1Offset + 1);
        double _v1z = v1.get(v1Offset + 2);
        double _v1w = v1.get(v1Offset + 3);
        double _t1x = t1.get(t1Offset + 0);
        double _t1y = t1.get(t1Offset + 1);
        double _t1z = t1.get(t1Offset + 2);
        double _t1w = t1.get(t1Offset + 3);
        double _t0 = t * t;
        double _t6 = 6.0 * Math.fma(t, t, -t);
        double _t7 = 6.0 * Math.fma(-t, t, t);
        double _t8 = Math.fma(3.0, _t0, -(2.0 * t));
        double _t9 = Math.fma(3.0, _t0, Math.fma(-4.0, t, 1.0));
        dest.put(destOffset + 0, Math.fma(_selfx, _t6, _t0x * _t9) + Math.fma(_t1x, _t8, _v1x * _t7));
        dest.put(destOffset + 1, Math.fma(_selfy, _t6, _t0y * _t9) + Math.fma(_t1y, _t8, _v1y * _t7));
        dest.put(destOffset + 2, Math.fma(_selfz, _t6, _t0z * _t9) + Math.fma(_t1z, _t8, _v1z * _t7));
        dest.put(destOffset + 3, Math.fma(_selfw, _t6, _t0w * _t9) + Math.fma(_t1w, _t8, _v1w * _t7));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, Math.fma(t, otherX - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(t, otherY - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(t, otherZ - _selfz, _selfz));
        dest.put(destOffset + 3, Math.fma(t, otherW - _selfw, _selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, Math.fma(t, _otherx - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(t, _othery - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(t, _otherz - _selfz, _selfz));
        dest.put(destOffset + 3, Math.fma(t, _otherw - _selfw, _selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double tX, double tY, double tZ, double tW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW, tX, tY, tZ, tW);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW, double tX, double tY, double tZ, double tW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW, tX, tY, tZ, tW);
            return dest;
        }
        Double4OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW, tX, tY, tZ, tW);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 8L;
        Double4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, _tBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer t, int tOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        double _tx = t.get(tOffset + 0);
        double _ty = t.get(tOffset + 1);
        double _tz = t.get(tOffset + 2);
        double _tw = t.get(tOffset + 3);
        dest.put(destOffset + 0, Math.fma(_tx, _otherx - _selfx, _selfx));
        dest.put(destOffset + 1, Math.fma(_ty, _othery - _selfy, _selfy));
        dest.put(destOffset + 2, Math.fma(_tz, _otherz - _selfz, _selfz));
        dest.put(destOffset + 3, Math.fma(_tw, _otherw - _selfw, _selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer absolute_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.absolute_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer absolute_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, Math.abs(_selfx));
        dest.put(destOffset + 1, Math.abs(_selfy));
        dest.put(destOffset + 2, Math.abs(_selfz));
        dest.put(destOffset + 3, Math.abs(_selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer acos_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.acos_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer acos_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.acos(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.acos_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double bW, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, bX, bY, bZ, bW, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double bW, double scalar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.addScaled(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, bX, bY, bZ, bW, scalar);
            return dest;
        }
        Double4OpsKernelsSegment.addScaled_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, bX, bY, bZ, bW, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        Double4OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, _bBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _bx = b.get(bOffset + 0);
        double _by = b.get(bOffset + 1);
        double _bz = b.get(bOffset + 2);
        double _bw = b.get(bOffset + 3);
        dest.put(destOffset + 0, Math.fma(scalar, _bx, _selfx));
        dest.put(destOffset + 1, Math.fma(scalar, _by, _selfy));
        dest.put(destOffset + 2, Math.fma(scalar, _bz, _selfz));
        dest.put(destOffset + 3, Math.fma(scalar, _bw, _selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double bW, double cX, double cY, double cZ, double cW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, bX, bY, bZ, bW, cX, cY, cZ, cW);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double bZ, double bW, double cX, double cY, double cZ, double cW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.addScaled(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, bX, bY, bZ, bW, cX, cY, cZ, cW);
            return dest;
        }
        Double4OpsKernelsSegment.addScaled_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, bX, bY, bZ, bW, cX, cY, cZ, cW);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double4OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, _bBase, _cBase);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _bx = b.get(bOffset + 0);
        double _by = b.get(bOffset + 1);
        double _bz = b.get(bOffset + 2);
        double _bw = b.get(bOffset + 3);
        double _cx = c.get(cOffset + 0);
        double _cy = c.get(cOffset + 1);
        double _cz = c.get(cOffset + 2);
        double _cw = c.get(cOffset + 3);
        dest.put(destOffset + 0, Math.fma(_bx, _cx, _selfx));
        dest.put(destOffset + 1, Math.fma(_by, _cy, _selfy));
        dest.put(destOffset + 2, Math.fma(_bz, _cz, _selfz));
        dest.put(destOffset + 3, Math.fma(_bw, _cw, _selfw));
        return dest;
    }

    public static double angleBetween_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.angleBetween_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double angleBetween_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (src.hasArray()) {
            return Double4Ops.angleBetween(src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
        }
        return Double4OpsKernelsSegment.angleBetween_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
    }

    public static double angleBetween_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double4OpsKernelsAddress.angleBetween_unsafe(_srcBase, _otherBase);
    }

    public static double angleBetween_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double4Ops.angleBetween(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double4OpsKernelsSegment.angleBetween_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static java.nio.DoubleBuffer asin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.asin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer asin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.asin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.asin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer atan_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.atan_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer atan_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.atan(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.atan_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, x);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.atan2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x);
            return dest;
        }
        Double4OpsKernelsSegment.atan2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, x);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xX, double xY, double xZ, double xW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, xX, xY, xZ, xW);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xX, double xY, double xZ, double xW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.atan2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, xX, xY, xZ, xW);
            return dest;
        }
        Double4OpsKernelsSegment.atan2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, xX, xY, xZ, xW);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer x, int xOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        Double4OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, _xBase);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer x, int xOffset) {
        if (dest.hasArray() && src.hasArray() && x.hasArray()) {
            Double4Ops.atan2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x.array(), x.arrayOffset() + xOffset);
            return dest;
        }
        Double4OpsKernelsSegment.atan2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cbrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.cbrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cbrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.cbrt(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.cbrt_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer ceil_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.ceil_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer ceil_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.ceil(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.ceil_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double min, double max) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, min, max);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double min, double max) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, Math.min(Math.max(_selfx, min), max));
        dest.put(destOffset + 1, Math.min(Math.max(_selfy, min), max));
        dest.put(destOffset + 2, Math.min(Math.max(_selfz, min), max));
        dest.put(destOffset + 3, Math.min(Math.max(_selfw, min), max));
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double minW, double maxX, double maxY, double maxZ, double maxW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double minW, double maxX, double maxY, double maxZ, double maxW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.clamp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
            return dest;
        }
        Double4OpsKernelsSegment.clamp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 8L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 8L;
        Double4OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, _minBase, _maxBase);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _minx = min.get(minOffset + 0);
        double _miny = min.get(minOffset + 1);
        double _minz = min.get(minOffset + 2);
        double _minw = min.get(minOffset + 3);
        double _maxx = max.get(maxOffset + 0);
        double _maxy = max.get(maxOffset + 1);
        double _maxz = max.get(maxOffset + 2);
        double _maxw = max.get(maxOffset + 3);
        dest.put(destOffset + 0, Math.min(Math.max(_selfx, _minx), _maxx));
        dest.put(destOffset + 1, Math.min(Math.max(_selfy, _miny), _maxy));
        dest.put(destOffset + 2, Math.min(Math.max(_selfz, _minz), _maxz));
        dest.put(destOffset + 3, Math.min(Math.max(_selfw, _minw), _maxw));
        return dest;
    }

    public static double compAdd_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.compAdd_unsafe(_srcBase);
    }

    public static double compAdd_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.compAdd(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.compAdd_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double compMax_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.compMax_unsafe(_srcBase);
    }

    public static double compMax_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.compMax(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.compMax_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double compMin_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.compMin_unsafe(_srcBase);
    }

    public static double compMin_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.compMin(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.compMin_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double compMul_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.compMul_unsafe(_srcBase);
    }

    public static double compMul_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.compMul(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.compMul_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sign) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, sign);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sign) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.copySign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sign);
            return dest;
        }
        Double4OpsKernelsSegment.copySign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, sign);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double signX, double signY, double signZ, double signW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, signX, signY, signZ, signW);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double signX, double signY, double signZ, double signW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.copySign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, signX, signY, signZ, signW);
            return dest;
        }
        Double4OpsKernelsSegment.copySign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, signX, signY, signZ, signW);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer sign, int signOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _signBase = UnsafeOpsHolder.U.getLong(sign, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) signOffset * 8L;
        Double4OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, _signBase);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer sign, int signOffset) {
        if (dest.hasArray() && src.hasArray() && sign.hasArray()) {
            Double4Ops.copySign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sign.array(), sign.arrayOffset() + signOffset);
            return dest;
        }
        Double4OpsKernelsSegment.copySign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(sign.duplicate().position(0)), (long) signOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cos_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.cos_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cos_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.cos(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.cos_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cosh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.cosh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cosh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.cosh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.cosh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer degrees_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.degrees_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer degrees_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.degrees(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.degrees_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double distance_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.distance_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double distance_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (src.hasArray()) {
            return Double4Ops.distance(src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
        }
        return Double4OpsKernelsSegment.distance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
    }

    public static double distance_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double4OpsKernelsAddress.distance_unsafe(_srcBase, _otherBase);
    }

    public static double distance_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double4Ops.distance(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double4OpsKernelsSegment.distance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static double distanceSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.distanceSquared_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double distanceSquared_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (src.hasArray()) {
            return Double4Ops.distanceSquared(src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
        }
        return Double4OpsKernelsSegment.distanceSquared_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
    }

    public static double distanceSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double4OpsKernelsAddress.distanceSquared_unsafe(_srcBase, _otherBase);
    }

    public static double distanceSquared_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double4Ops.distanceSquared(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double4OpsKernelsSegment.distanceSquared_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static double dot_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.dot_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double dot_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (src.hasArray()) {
            return Double4Ops.dot(src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
        }
        return Double4OpsKernelsSegment.dot_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
    }

    public static double dot_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double4OpsKernelsAddress.dot_unsafe(_srcBase, _otherBase);
    }

    public static double dot_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double4Ops.dot(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double4OpsKernelsSegment.dot_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static java.nio.DoubleBuffer exp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.exp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer exp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.exp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.exp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer exp2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.exp2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer exp2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.exp2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.exp2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer expm1_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.expm1_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer expm1_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.expm1(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.expm1_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double IX, double IY, double IZ, double IW, double NrefX, double NrefY, double NrefZ, double NrefW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.faceforward_unsafe(_destBase, _srcBase, IX, IY, IZ, IW, NrefX, NrefY, NrefZ, NrefW);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double IX, double IY, double IZ, double IW, double NrefX, double NrefY, double NrefZ, double NrefW) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t3 = Math.fma(IW, NrefW, Math.fma(IZ, NrefZ, Math.fma(IX, NrefX, IY * NrefY)));
        if (_t3 < 0.0) {
            dest.put(destOffset + 0, _selfx);
            dest.put(destOffset + 1, _selfy);
            dest.put(destOffset + 2, _selfz);
            dest.put(destOffset + 3, _selfw);
        } else {
            dest.put(destOffset + 0, -_selfx);
            dest.put(destOffset + 1, -_selfy);
            dest.put(destOffset + 2, -_selfz);
            dest.put(destOffset + 3, -_selfw);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer I, int IOffset, java.nio.DoubleBuffer Nref, int NrefOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _IBase = UnsafeOpsHolder.U.getLong(I, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) IOffset * 8L;
        long _NrefBase = UnsafeOpsHolder.U.getLong(Nref, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) NrefOffset * 8L;
        Double4OpsKernelsAddress.faceforward_unsafe(_destBase, _srcBase, _IBase, _NrefBase);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer I, int IOffset, java.nio.DoubleBuffer Nref, int NrefOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _Ix = I.get(IOffset + 0);
        double _Iy = I.get(IOffset + 1);
        double _Iz = I.get(IOffset + 2);
        double _Iw = I.get(IOffset + 3);
        double _Nrefx = Nref.get(NrefOffset + 0);
        double _Nrefy = Nref.get(NrefOffset + 1);
        double _Nrefz = Nref.get(NrefOffset + 2);
        double _Nrefw = Nref.get(NrefOffset + 3);
        double _t3 = Math.fma(_Iw, _Nrefw, Math.fma(_Iz, _Nrefz, Math.fma(_Ix, _Nrefx, _Iy * _Nrefy)));
        if (_t3 < 0.0) {
            dest.put(destOffset + 0, _selfx);
            dest.put(destOffset + 1, _selfy);
            dest.put(destOffset + 2, _selfz);
            dest.put(destOffset + 3, _selfw);
        } else {
            dest.put(destOffset + 0, -_selfx);
            dest.put(destOffset + 1, -_selfy);
            dest.put(destOffset + 2, -_selfz);
            dest.put(destOffset + 3, -_selfw);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer floor_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.floor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer floor_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.floor(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.floor_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer fract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.fract_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer fract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.fract(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.fract_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, y);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.hypot(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y);
            return dest;
        }
        Double4OpsKernelsSegment.hypot_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, y);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ, double yW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, yX, yY, yZ, yW);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ, double yW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.hypot(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, yX, yY, yZ, yW);
            return dest;
        }
        Double4OpsKernelsSegment.hypot_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, yX, yY, yZ, yW);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (dest.hasArray() && src.hasArray() && y.hasArray()) {
            Double4Ops.hypot(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Double4OpsKernelsSegment.hypot_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer inverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.inverse_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer inverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, 1.0 / _selfx);
        dest.put(destOffset + 1, 1.0 / _selfy);
        dest.put(destOffset + 2, 1.0 / _selfz);
        dest.put(destOffset + 3, 1.0 / _selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer inverseSqrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.inverseSqrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer inverseSqrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.inverseSqrt(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.inverseSqrt_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double length_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.length_unsafe(_srcBase);
    }

    public static double length_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.length(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.length_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double lengthSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.lengthSquared_unsafe(_srcBase);
    }

    public static double lengthSquared_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.lengthSquared(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.lengthSquared_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer log_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.log_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.log(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.log_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer log10_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.log10_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log10_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.log10(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.log10_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer log1p_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.log1p_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log1p_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.log1p(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.log1p_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer log2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.log2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.log2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.log2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double manhattanDistance_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.manhattanDistance_unsafe(_srcBase, otherX, otherY, otherZ, otherW);
    }

    public static double manhattanDistance_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (src.hasArray()) {
            return Double4Ops.manhattanDistance(src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
        }
        return Double4OpsKernelsSegment.manhattanDistance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
    }

    public static double manhattanDistance_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double4OpsKernelsAddress.manhattanDistance_unsafe(_srcBase, _otherBase);
    }

    public static double manhattanDistance_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double4Ops.manhattanDistance(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double4OpsKernelsSegment.manhattanDistance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static double manhattanLength_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4OpsKernelsAddress.manhattanLength_unsafe(_srcBase);
    }

    public static double manhattanLength_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4Ops.manhattanLength(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4OpsKernelsSegment.manhattanLength_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.max_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, Math.max(_selfx, scalar));
        dest.put(destOffset + 1, Math.max(_selfy, scalar));
        dest.put(destOffset + 2, Math.max(_selfz, scalar));
        dest.put(destOffset + 3, Math.max(_selfw, scalar));
        return dest;
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.max_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.max(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
            return dest;
        }
        Double4OpsKernelsSegment.max_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.max_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, Math.max(_selfx, _otherx));
        dest.put(destOffset + 1, Math.max(_selfy, _othery));
        dest.put(destOffset + 2, Math.max(_selfz, _otherz));
        dest.put(destOffset + 3, Math.max(_selfw, _otherw));
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.min_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, Math.min(_selfx, scalar));
        dest.put(destOffset + 1, Math.min(_selfy, scalar));
        dest.put(destOffset + 2, Math.min(_selfz, scalar));
        dest.put(destOffset + 3, Math.min(_selfw, scalar));
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.min_unsafe(_destBase, _srcBase, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double otherZ, double otherW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.min(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, otherZ, otherW);
            return dest;
        }
        Double4OpsKernelsSegment.min_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, otherZ, otherW);
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4OpsKernelsAddress.min_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _otherx = other.get(otherOffset + 0);
        double _othery = other.get(otherOffset + 1);
        double _otherz = other.get(otherOffset + 2);
        double _otherw = other.get(otherOffset + 3);
        dest.put(destOffset + 0, Math.min(_selfx, _otherx));
        dest.put(destOffset + 1, Math.min(_selfy, _othery));
        dest.put(destOffset + 2, Math.min(_selfz, _otherz));
        dest.put(destOffset + 3, Math.min(_selfw, _otherw));
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, y);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.mod(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y);
            return dest;
        }
        Double4OpsKernelsSegment.mod_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, y);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ, double yW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, yX, yY, yZ, yW);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY, double yZ, double yW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.mod(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, yX, yY, yZ, yW);
            return dest;
        }
        Double4OpsKernelsSegment.mod_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, yX, yY, yZ, yW);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (dest.hasArray() && src.hasArray() && y.hasArray()) {
            Double4Ops.mod(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Double4OpsKernelsSegment.mod_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer nextDown_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.nextDown_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer nextDown_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.nextDown(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.nextDown_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer nextUp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.nextUp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer nextUp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.nextUp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.nextUp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalize_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.normalize_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalize_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t4 = (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest.put(destOffset + 0, _selfx * _t4);
            dest.put(destOffset + 1, _selfy * _t4);
            dest.put(destOffset + 2, _selfz * _t4);
            dest.put(destOffset + 3, _selfw * _t4);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
            dest.put(destOffset + 3, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer normalizeMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double length) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.normalizeMul_unsafe(_destBase, _srcBase, length);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizeMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double length) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t3 = Math.fma(_selfw, _selfw, Math.fma(_selfz, _selfz, Math.fma(_selfx, _selfx, _selfy * _selfy)));
        double _t5 = length * (1.0 / Math.sqrt(_t3));
        if (_t3 > 0.0) {
            dest.put(destOffset + 0, _selfx * _t5);
            dest.put(destOffset + 1, _selfy * _t5);
            dest.put(destOffset + 2, _selfz * _t5);
            dest.put(destOffset + 3, _selfw * _t5);
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
            dest.put(destOffset + 3, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rowX, double rowY, double rowZ, double rowW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.outerProduct_unsafe(_destBase, _srcBase, rowX, rowY, rowZ, rowW);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rowX, double rowY, double rowZ, double rowW) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, rowX * _selfx);
        dest.put(destOffset + 1, rowX * _selfy);
        dest.put(destOffset + 2, rowX * _selfz);
        dest.put(destOffset + 3, rowX * _selfw);
        dest.put(destOffset + 4, rowY * _selfx);
        dest.put(destOffset + 5, rowY * _selfy);
        dest.put(destOffset + 6, rowY * _selfz);
        dest.put(destOffset + 7, rowY * _selfw);
        dest.put(destOffset + 8, rowZ * _selfx);
        dest.put(destOffset + 9, rowZ * _selfy);
        dest.put(destOffset + 10, rowZ * _selfz);
        dest.put(destOffset + 11, rowZ * _selfw);
        dest.put(destOffset + 12, rowW * _selfx);
        dest.put(destOffset + 13, rowW * _selfy);
        dest.put(destOffset + 14, rowW * _selfz);
        dest.put(destOffset + 15, rowW * _selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rowOffset * 8L;
        Double4OpsKernelsAddress.outerProduct_unsafe(_destBase, _srcBase, _rowBase);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer row, int rowOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _rowx = row.get(rowOffset + 0);
        double _rowy = row.get(rowOffset + 1);
        double _rowz = row.get(rowOffset + 2);
        double _roww = row.get(rowOffset + 3);
        dest.put(destOffset + 0, _rowx * _selfx);
        dest.put(destOffset + 1, _rowx * _selfy);
        dest.put(destOffset + 2, _rowx * _selfz);
        dest.put(destOffset + 3, _rowx * _selfw);
        dest.put(destOffset + 4, _rowy * _selfx);
        dest.put(destOffset + 5, _rowy * _selfy);
        dest.put(destOffset + 6, _rowy * _selfz);
        dest.put(destOffset + 7, _rowy * _selfw);
        dest.put(destOffset + 8, _rowz * _selfx);
        dest.put(destOffset + 9, _rowz * _selfy);
        dest.put(destOffset + 10, _rowz * _selfz);
        dest.put(destOffset + 11, _rowz * _selfw);
        dest.put(destOffset + 12, _roww * _selfx);
        dest.put(destOffset + 13, _roww * _selfy);
        dest.put(destOffset + 14, _roww * _selfz);
        dest.put(destOffset + 15, _roww * _selfw);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponent) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, exponent);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponent) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.pow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, exponent);
            return dest;
        }
        Double4OpsKernelsSegment.pow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, exponent);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponentX, double exponentY, double exponentZ, double exponentW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, exponentX, exponentY, exponentZ, exponentW);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponentX, double exponentY, double exponentZ, double exponentW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.pow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, exponentX, exponentY, exponentZ, exponentW);
            return dest;
        }
        Double4OpsKernelsSegment.pow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, exponentX, exponentY, exponentZ, exponentW);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer exponent, int exponentOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _exponentBase = UnsafeOpsHolder.U.getLong(exponent, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) exponentOffset * 8L;
        Double4OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, _exponentBase);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer exponent, int exponentOffset) {
        if (dest.hasArray() && src.hasArray() && exponent.hasArray()) {
            Double4Ops.pow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, exponent.array(), exponent.arrayOffset() + exponentOffset);
            return dest;
        }
        Double4OpsKernelsSegment.pow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(exponent.duplicate().position(0)), (long) exponentOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer project_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double ontoX, double ontoY, double ontoZ, double ontoW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.project_unsafe(_destBase, _srcBase, ontoX, ontoY, ontoZ, ontoW);
        return dest;
    }

    public static java.nio.DoubleBuffer project_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double ontoX, double ontoY, double ontoZ, double ontoW) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t6 = Math.fma(ontoW, _selfw, Math.fma(ontoZ, _selfz, Math.fma(ontoX, _selfx, ontoY * _selfy)));
        double _t7 = Math.fma(ontoW, ontoW, Math.fma(ontoZ, ontoZ, Math.fma(ontoX, ontoX, ontoY * ontoY)));
        double _t7_inv = 1.0 / _t7;
        dest.put(destOffset + 0, ontoX * _t6 * _t7_inv);
        dest.put(destOffset + 1, ontoY * _t6 * _t7_inv);
        dest.put(destOffset + 2, ontoZ * _t6 * _t7_inv);
        dest.put(destOffset + 3, ontoW * _t6 * _t7_inv);
        return dest;
    }

    public static java.nio.DoubleBuffer project_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer onto, int ontoOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _ontoBase = UnsafeOpsHolder.U.getLong(onto, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) ontoOffset * 8L;
        Double4OpsKernelsAddress.project_unsafe(_destBase, _srcBase, _ontoBase);
        return dest;
    }

    public static java.nio.DoubleBuffer project_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer onto, int ontoOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _ontox = onto.get(ontoOffset + 0);
        double _ontoy = onto.get(ontoOffset + 1);
        double _ontoz = onto.get(ontoOffset + 2);
        double _ontow = onto.get(ontoOffset + 3);
        double _t6 = Math.fma(_ontow, _selfw, Math.fma(_ontoz, _selfz, Math.fma(_ontox, _selfx, _ontoy * _selfy)));
        double _t7 = Math.fma(_ontow, _ontow, Math.fma(_ontoz, _ontoz, Math.fma(_ontox, _ontox, _ontoy * _ontoy)));
        double _t7_inv = 1.0 / _t7;
        dest.put(destOffset + 0, _ontox * _t6 * _t7_inv);
        dest.put(destOffset + 1, _ontoy * _t6 * _t7_inv);
        dest.put(destOffset + 2, _ontoz * _t6 * _t7_inv);
        dest.put(destOffset + 3, _ontow * _t6 * _t7_inv);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double normalW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.projectOnPlane_unsafe(_destBase, _srcBase, normalX, normalY, normalZ, normalW);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double normalW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.projectOnPlane(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY, normalZ, normalW);
            return dest;
        }
        Double4OpsKernelsSegment.projectOnPlane_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY, normalZ, normalW);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double4OpsKernelsAddress.projectOnPlane_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _normalw = normal.get(normalOffset + 3);
        double _t3 = Math.fma(_normalw, _selfw, Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy)));
        dest.put(destOffset + 0, Math.fma(-_normalx, _t3, _selfx));
        dest.put(destOffset + 1, Math.fma(-_normaly, _t3, _selfy));
        dest.put(destOffset + 2, Math.fma(-_normalz, _t3, _selfz));
        dest.put(destOffset + 3, Math.fma(-_normalw, _t3, _selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer radians_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.radians_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer radians_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.radians(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.radians_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double normalW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY, normalZ, normalW);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double normalW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY, normalZ, normalW);
            return dest;
        }
        Double4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY, normalZ, normalW);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _normalw = normal.get(normalOffset + 3);
        double _t4 = 2.0 * Math.fma(_normalw, _selfw, Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy)));
        dest.put(destOffset + 0, Math.fma(-_normalx, _t4, _selfx));
        dest.put(destOffset + 1, Math.fma(-_normaly, _t4, _selfy));
        dest.put(destOffset + 2, Math.fma(-_normalz, _t4, _selfz));
        dest.put(destOffset + 3, Math.fma(-_normalw, _t4, _selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer refract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double normalW, double eta) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.refract_unsafe(_destBase, _srcBase, normalX, normalY, normalZ, normalW, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ, double normalW, double eta) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _t4 = Math.fma(normalW, _selfw, Math.fma(normalZ, _selfz, Math.fma(normalX, _selfx, normalY * _selfy)));
        double _t8 = Math.fma(-Math.fma(-_t4, _t4, 1.0), eta * eta, 1.0);
        double _t11 = Math.fma(eta, _t4, Math.sqrt(Math.max(0.0, _t8)));
        if (_t8 >= 0.0) {
            dest.put(destOffset + 0, Math.fma(eta, _selfx, -(normalX * _t11)));
            dest.put(destOffset + 1, Math.fma(eta, _selfy, -(normalY * _t11)));
            dest.put(destOffset + 2, Math.fma(eta, _selfz, -(normalZ * _t11)));
            dest.put(destOffset + 3, Math.fma(eta, _selfw, -(normalW * _t11)));
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
            dest.put(destOffset + 3, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer refract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset, double eta) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double4OpsKernelsAddress.refract_unsafe(_destBase, _srcBase, _normalBase, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset, double eta) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        double _normalx = normal.get(normalOffset + 0);
        double _normaly = normal.get(normalOffset + 1);
        double _normalz = normal.get(normalOffset + 2);
        double _normalw = normal.get(normalOffset + 3);
        double _t4 = Math.fma(_normalw, _selfw, Math.fma(_normalz, _selfz, Math.fma(_normalx, _selfx, _normaly * _selfy)));
        double _t8 = Math.fma(-Math.fma(-_t4, _t4, 1.0), eta * eta, 1.0);
        double _t11 = Math.fma(eta, _t4, Math.sqrt(Math.max(0.0, _t8)));
        if (_t8 >= 0.0) {
            dest.put(destOffset + 0, Math.fma(eta, _selfx, -(_normalx * _t11)));
            dest.put(destOffset + 1, Math.fma(eta, _selfy, -(_normaly * _t11)));
            dest.put(destOffset + 2, Math.fma(eta, _selfz, -(_normalz * _t11)));
            dest.put(destOffset + 3, Math.fma(eta, _selfw, -(_normalw * _t11)));
        } else {
            dest.put(destOffset + 0, 0.0);
            dest.put(destOffset + 1, 0.0);
            dest.put(destOffset + 2, 0.0);
            dest.put(destOffset + 3, 0.0);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer round_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.round_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer round_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.round(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.round_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.sign_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.sign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.sign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.sin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.sin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.sin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sinh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.sinh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sinh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.sinh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.sinh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0, double edge1) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, edge0, edge1);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0, double edge1) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.smoothstep(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge0, edge1);
            return dest;
        }
        Double4OpsKernelsSegment.smoothstep_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edge0, edge1);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0X, double edge0Y, double edge0Z, double edge0W, double edge1X, double edge1Y, double edge1Z, double edge1W) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, edge0X, edge0Y, edge0Z, edge0W, edge1X, edge1Y, edge1Z, edge1W);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0X, double edge0Y, double edge0Z, double edge0W, double edge1X, double edge1Y, double edge1Z, double edge1W) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.smoothstep(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge0X, edge0Y, edge0Z, edge0W, edge1X, edge1Y, edge1Z, edge1W);
            return dest;
        }
        Double4OpsKernelsSegment.smoothstep_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edge0X, edge0Y, edge0Z, edge0W, edge1X, edge1Y, edge1Z, edge1W);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge0, int edge0Offset, java.nio.DoubleBuffer edge1, int edge1Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _edge0Base = UnsafeOpsHolder.U.getLong(edge0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edge0Offset * 8L;
        long _edge1Base = UnsafeOpsHolder.U.getLong(edge1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edge1Offset * 8L;
        Double4OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, _edge0Base, _edge1Base);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge0, int edge0Offset, java.nio.DoubleBuffer edge1, int edge1Offset) {
        if (dest.hasArray() && src.hasArray() && edge0.hasArray() && edge1.hasArray()) {
            Double4Ops.smoothstep(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge0.array(), edge0.arrayOffset() + edge0Offset, edge1.array(), edge1.arrayOffset() + edge1Offset);
            return dest;
        }
        Double4OpsKernelsSegment.smoothstep_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(edge0.duplicate().position(0)), (long) edge0Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(edge1.duplicate().position(0)), (long) edge1Offset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sqrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.sqrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sqrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
        dest.put(destOffset + 0, Math.sqrt(_selfx));
        dest.put(destOffset + 1, Math.sqrt(_selfy));
        dest.put(destOffset + 2, Math.sqrt(_selfz));
        dest.put(destOffset + 3, Math.sqrt(_selfw));
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.step_unsafe(_destBase, _srcBase, edge);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.step(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge);
            return dest;
        }
        Double4OpsKernelsSegment.step_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edge);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edgeX, double edgeY, double edgeZ, double edgeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.step_unsafe(_destBase, _srcBase, edgeX, edgeY, edgeZ, edgeW);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edgeX, double edgeY, double edgeZ, double edgeW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.step(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edgeX, edgeY, edgeZ, edgeW);
            return dest;
        }
        Double4OpsKernelsSegment.step_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edgeX, edgeY, edgeZ, edgeW);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge, int edgeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _edgeBase = UnsafeOpsHolder.U.getLong(edge, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edgeOffset * 8L;
        Double4OpsKernelsAddress.step_unsafe(_destBase, _srcBase, _edgeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge, int edgeOffset) {
        if (dest.hasArray() && src.hasArray() && edge.hasArray()) {
            Double4Ops.step(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge.array(), edge.arrayOffset() + edgeOffset);
            return dest;
        }
        Double4OpsKernelsSegment.step_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(edge.duplicate().position(0)), (long) edgeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer tan_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.tan_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer tan_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.tan(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.tan_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer tanh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.tanh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer tanh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.tanh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.tanh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer trunc_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.trunc_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer trunc_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.trunc(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.trunc_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer ulp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.ulp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer ulp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.ulp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4OpsKernelsSegment.ulp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double4OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        double _selfx = src.get(srcOffset + 0);
        double _selfy = src.get(srcOffset + 1);
        double _selfz = src.get(srcOffset + 2);
        double _selfw = src.get(srcOffset + 3);
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
        dest.put(destOffset + 0, Math.fma(_mat03, _selfw, Math.fma(_mat02, _selfz, Math.fma(_mat00, _selfx, _mat01 * _selfy))));
        dest.put(destOffset + 1, Math.fma(_mat13, _selfw, Math.fma(_mat12, _selfz, Math.fma(_mat10, _selfx, _mat11 * _selfy))));
        dest.put(destOffset + 2, Math.fma(_mat23, _selfw, Math.fma(_mat22, _selfz, Math.fma(_mat20, _selfx, _mat21 * _selfy))));
        dest.put(destOffset + 3, Math.fma(_mat33, _selfw, Math.fma(_mat32, _selfz, Math.fma(_mat30, _selfx, _mat31 * _selfy))));
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, quatX, quatY, quatZ, quatW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.rotate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, quatX, quatY, quatZ, quatW);
            return dest;
        }
        Double4OpsKernelsSegment.rotate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, quatX, quatY, quatZ, quatW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _quatBase = UnsafeOpsHolder.U.getLong(quat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) quatOffset * 8L;
        Double4OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, _quatBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        if (dest.hasArray() && src.hasArray() && quat.hasArray()) {
            Double4Ops.rotate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, quat.array(), quat.arrayOffset() + quatOffset);
            return dest;
        }
        Double4OpsKernelsSegment.rotate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(quat.duplicate().position(0)), (long) quatOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Double4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.rotateInverse_unsafe(_destBase, _srcBase, quatX, quatY, quatZ, quatW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double quatX, double quatY, double quatZ, double quatW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.rotateInverse(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, quatX, quatY, quatZ, quatW);
            return dest;
        }
        Double4OpsKernelsSegment.rotateInverse_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, quatX, quatY, quatZ, quatW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _quatBase = UnsafeOpsHolder.U.getLong(quat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) quatOffset * 8L;
        Double4OpsKernelsAddress.rotateInverse_unsafe(_destBase, _srcBase, _quatBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateInverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer quat, int quatOffset) {
        if (dest.hasArray() && src.hasArray() && quat.hasArray()) {
            Double4Ops.rotateInverse(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, quat.array(), quat.arrayOffset() + quatOffset);
            return dest;
        }
        Double4OpsKernelsSegment.rotateInverse_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(quat.duplicate().position(0)), (long) quatOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.rotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4OpsKernelsSegment.rotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.rotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4OpsKernelsSegment.rotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4Ops.rotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4OpsKernelsSegment.rotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

}
