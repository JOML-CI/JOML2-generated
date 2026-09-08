package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;
import org.joml2.internal.simd.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double2Ops} whose leading storage
 * parameter is a typed {@link java.nio.DoubleBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double2Ops} and its sibling kernel units. Not public API.
 */
public final class Double2OpsKernelsTypedBuffer {
    private Double2OpsKernelsTypedBuffer() {}

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.add_unsafe(_destBase, _srcBase, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.add(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
            return dest;
        }
        Double2OpsKernelsSegment.add_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.add(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double2OpsKernelsSegment.add_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.div_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.div(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, scalar);
            return dest;
        }
        Double2OpsKernelsSegment.div_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.div_unsafe(_destBase, _srcBase, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.div(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
            return dest;
        }
        Double2OpsKernelsSegment.div_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer div_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.div_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer div_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.div(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double2OpsKernelsSegment.div_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double b, double cX, double cY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, b, cX, cY);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double b, double cX, double cY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.fma(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, b, cX, cY);
            return dest;
        }
        Double2OpsKernelsSegment.fma_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, b, cX, cY);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer c, int cOffset, double b) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double2OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, _cBase, b);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer c, int cOffset, double b) {
        if (dest.hasArray() && src.hasArray() && c.hasArray()) {
            Double2Ops.fma(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, c.array(), c.arrayOffset() + cOffset, b);
            return dest;
        }
        Double2OpsKernelsSegment.fma_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(c.duplicate().position(0)), (long) cOffset * 8L, b);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double cX, double cY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, bX, bY, cX, cY);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double cX, double cY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.fma(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, bX, bY, cX, cY);
            return dest;
        }
        Double2OpsKernelsSegment.fma_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, bX, bY, cX, cY);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double2OpsKernelsAddress.fma_unsafe(_destBase, _srcBase, _bBase, _cBase);
        return dest;
    }

    public static java.nio.DoubleBuffer fma_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        if (dest.hasArray() && src.hasArray() && b.hasArray() && c.hasArray()) {
            Double2Ops.fma(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, b.array(), b.arrayOffset() + bOffset, c.array(), c.arrayOffset() + cOffset);
            return dest;
        }
        Double2OpsKernelsSegment.fma_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(b.duplicate().position(0)), (long) bOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(c.duplicate().position(0)), (long) cOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, scalar);
            return dest;
        }
        Double2OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
            return dest;
        }
        Double2OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double2OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.negate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.negate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.sub(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
            return dest;
        }
        Double2OpsKernelsSegment.sub_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.sub(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double2OpsKernelsSegment.sub_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double2OpsKernelsAddress.set_unsafe(_destBase, vX, vY);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY) {
        if (dest.hasArray()) {
            Double2Ops.set(dest.array(), dest.arrayOffset() + destOffset, vX, vY);
            return dest;
        }
        Double2OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, vX, vY);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double2OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double2Ops.set(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double2OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double2OpsKernelsAddress.set_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, double s) {
        if (dest.hasArray()) {
            Double2Ops.set(dest.array(), dest.arrayOffset() + destOffset, s);
            return dest;
        }
        Double2OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeZero_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double2OpsKernelsAddress.makeZero_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeZero_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double2Ops.makeZero(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double2OpsKernelsSegment.makeZero_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.bezier_unsafe(_destBase, _srcBase, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.bezier(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double2OpsKernelsAddress.bezier_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        if (dest.hasArray() && src.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Double2Ops.bezier(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.bezier2_unsafe(_destBase, _srcBase, p1X, p1Y, p2X, p2Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.bezier2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p2X, p2Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezier2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p2X, p2Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double2OpsKernelsAddress.bezier2_unsafe(_destBase, _srcBase, _p1Base, _p2Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        if (dest.hasArray() && src.hasArray() && p1.hasArray() && p2.hasArray()) {
            Double2Ops.bezier2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezier2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.bezier2Tangent_unsafe(_destBase, _srcBase, p1X, p1Y, p2X, p2Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.bezier2Tangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p2X, p2Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezier2Tangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p2X, p2Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        Double2OpsKernelsAddress.bezier2Tangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezier2Tangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, double t) {
        if (dest.hasArray() && src.hasArray() && p1.hasArray() && p2.hasArray()) {
            Double2Ops.bezier2Tangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezier2Tangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.bezierTangent_unsafe(_destBase, _srcBase, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.bezierTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezierTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double2OpsKernelsAddress.bezierTangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer bezierTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        if (dest.hasArray() && src.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Double2Ops.bezierTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.bezierTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.catmullRom_unsafe(_destBase, _srcBase, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.catmullRom(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.catmullRom_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double2OpsKernelsAddress.catmullRom_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRom_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        if (dest.hasArray() && src.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Double2Ops.catmullRom(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.catmullRom_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.catmullRomTangent_unsafe(_destBase, _srcBase, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.catmullRomTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.catmullRomTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p1X, p1Y, p2X, p2Y, p3X, p3Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double2OpsKernelsAddress.catmullRomTangent_unsafe(_destBase, _srcBase, _p1Base, _p2Base, _p3Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer catmullRomTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset, double t) {
        if (dest.hasArray() && src.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Double2Ops.catmullRomTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.catmullRomTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.hermite_unsafe(_destBase, _srcBase, t0X, t0Y, v1X, v1Y, t1X, t1Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.hermite(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t0X, t0Y, v1X, v1Y, t1X, t1Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.hermite_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, t0X, t0Y, v1X, v1Y, t1X, t1Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _t0Base = UnsafeOpsHolder.U.getLong(t0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t0Offset * 8L;
        long _v1Base = UnsafeOpsHolder.U.getLong(v1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) v1Offset * 8L;
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        Double2OpsKernelsAddress.hermite_unsafe(_destBase, _srcBase, _t0Base, _v1Base, _t1Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermite_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        if (dest.hasArray() && src.hasArray() && t0.hasArray() && v1.hasArray() && t1.hasArray()) {
            Double2Ops.hermite(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t0.array(), t0.arrayOffset() + t0Offset, v1.array(), v1.arrayOffset() + v1Offset, t1.array(), t1.arrayOffset() + t1Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.hermite_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t0.duplicate().position(0)), (long) t0Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v1.duplicate().position(0)), (long) v1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t1.duplicate().position(0)), (long) t1Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.hermiteTangent_unsafe(_destBase, _srcBase, t0X, t0Y, v1X, v1Y, t1X, t1Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double t0X, double t0Y, double v1X, double v1Y, double t1X, double t1Y, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.hermiteTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t0X, t0Y, v1X, v1Y, t1X, t1Y, t);
            return dest;
        }
        Double2OpsKernelsSegment.hermiteTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, t0X, t0Y, v1X, v1Y, t1X, t1Y, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _t0Base = UnsafeOpsHolder.U.getLong(t0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t0Offset * 8L;
        long _v1Base = UnsafeOpsHolder.U.getLong(v1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) v1Offset * 8L;
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        Double2OpsKernelsAddress.hermiteTangent_unsafe(_destBase, _srcBase, _t0Base, _v1Base, _t1Base, t);
        return dest;
    }

    public static java.nio.DoubleBuffer hermiteTangent_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t0, int t0Offset, java.nio.DoubleBuffer v1, int v1Offset, java.nio.DoubleBuffer t1, int t1Offset, double t) {
        if (dest.hasArray() && src.hasArray() && t0.hasArray() && v1.hasArray() && t1.hasArray()) {
            Double2Ops.hermiteTangent(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t0.array(), t0.arrayOffset() + t0Offset, v1.array(), v1.arrayOffset() + v1Offset, t1.array(), t1.arrayOffset() + t1Offset, t);
            return dest;
        }
        Double2OpsKernelsSegment.hermiteTangent_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t0.duplicate().position(0)), (long) t0Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v1.duplicate().position(0)), (long) v1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t1.duplicate().position(0)), (long) t1Offset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double t) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, t);
            return dest;
        }
        Double2OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset, t);
            return dest;
        }
        Double2OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double tX, double tY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, otherX, otherY, tX, tY);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY, double tX, double tY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY, tX, tY);
            return dest;
        }
        Double2OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY, tX, tY);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 8L;
        Double2OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, _tBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, java.nio.DoubleBuffer t, int tOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray() && t.hasArray()) {
            Double2Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset, t.array(), t.arrayOffset() + tOffset);
            return dest;
        }
        Double2OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t.duplicate().position(0)), (long) tOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer absolute_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.absolute_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer absolute_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.absolute(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.absolute_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer acos_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.acos_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer acos_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.acos(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.acos_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, bX, bY, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double scalar) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.addScaled(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, bX, bY, scalar);
            return dest;
        }
        Double2OpsKernelsSegment.addScaled_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, bX, bY, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        Double2OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, _bBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, double scalar) {
        if (dest.hasArray() && src.hasArray() && b.hasArray()) {
            Double2Ops.addScaled(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, b.array(), b.arrayOffset() + bOffset, scalar);
            return dest;
        }
        Double2OpsKernelsSegment.addScaled_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(b.duplicate().position(0)), (long) bOffset * 8L, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double cX, double cY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, bX, bY, cX, cY);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double bX, double bY, double cX, double cY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.addScaled(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, bX, bY, cX, cY);
            return dest;
        }
        Double2OpsKernelsSegment.addScaled_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, bX, bY, cX, cY);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _bBase = UnsafeOpsHolder.U.getLong(b, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) bOffset * 8L;
        long _cBase = UnsafeOpsHolder.U.getLong(c, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) cOffset * 8L;
        Double2OpsKernelsAddress.addScaled_unsafe(_destBase, _srcBase, _bBase, _cBase);
        return dest;
    }

    public static java.nio.DoubleBuffer addScaled_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer b, int bOffset, java.nio.DoubleBuffer c, int cOffset) {
        if (dest.hasArray() && src.hasArray() && b.hasArray() && c.hasArray()) {
            Double2Ops.addScaled(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, b.array(), b.arrayOffset() + bOffset, c.array(), c.arrayOffset() + cOffset);
            return dest;
        }
        Double2OpsKernelsSegment.addScaled_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(b.duplicate().position(0)), (long) bOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(c.duplicate().position(0)), (long) cOffset * 8L);
        return dest;
    }

    public static double angleBetween_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.angleBetween_unsafe(_srcBase, otherX, otherY);
    }

    public static double angleBetween_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (src.hasArray()) {
            return Double2Ops.angleBetween(src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
        }
        return Double2OpsKernelsSegment.angleBetween_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
    }

    public static double angleBetween_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double2OpsKernelsAddress.angleBetween_unsafe(_srcBase, _otherBase);
    }

    public static double angleBetween_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double2Ops.angleBetween(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double2OpsKernelsSegment.angleBetween_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static java.nio.DoubleBuffer asin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.asin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer asin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.asin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.asin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer atan_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.atan_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer atan_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.atan(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.atan_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, x);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.atan2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x);
            return dest;
        }
        Double2OpsKernelsSegment.atan2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, x);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xX, double xY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, xX, xY);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xX, double xY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.atan2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, xX, xY);
            return dest;
        }
        Double2OpsKernelsSegment.atan2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, xX, xY);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer x, int xOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        Double2OpsKernelsAddress.atan2_unsafe(_destBase, _srcBase, _xBase);
        return dest;
    }

    public static java.nio.DoubleBuffer atan2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer x, int xOffset) {
        if (dest.hasArray() && src.hasArray() && x.hasArray()) {
            Double2Ops.atan2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x.array(), x.arrayOffset() + xOffset);
            return dest;
        }
        Double2OpsKernelsSegment.atan2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cbrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.cbrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cbrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.cbrt(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.cbrt_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer ceil_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.ceil_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer ceil_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.ceil(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.ceil_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double min, double max) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, min, max);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double min, double max) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.clamp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, min, max);
            return dest;
        }
        Double2OpsKernelsSegment.clamp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, min, max);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double maxX, double maxY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, minX, minY, maxX, maxY);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double maxX, double maxY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.clamp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, minX, minY, maxX, maxY);
            return dest;
        }
        Double2OpsKernelsSegment.clamp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, minX, minY, maxX, maxY);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 8L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 8L;
        Double2OpsKernelsAddress.clamp_unsafe(_destBase, _srcBase, _minBase, _maxBase);
        return dest;
    }

    public static java.nio.DoubleBuffer clamp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        if (dest.hasArray() && src.hasArray() && min.hasArray() && max.hasArray()) {
            Double2Ops.clamp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, min.array(), min.arrayOffset() + minOffset, max.array(), max.arrayOffset() + maxOffset);
            return dest;
        }
        Double2OpsKernelsSegment.clamp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(min.duplicate().position(0)), (long) minOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(max.duplicate().position(0)), (long) maxOffset * 8L);
        return dest;
    }

    public static double compAdd_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.compAdd_unsafe(_srcBase);
    }

    public static double compAdd_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.compAdd(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.compAdd_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double compMax_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.compMax_unsafe(_srcBase);
    }

    public static double compMax_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.compMax(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.compMax_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double compMin_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.compMin_unsafe(_srcBase);
    }

    public static double compMin_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.compMin(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.compMin_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double compMul_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.compMul_unsafe(_srcBase);
    }

    public static double compMul_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.compMul(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.compMul_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sign) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, sign);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sign) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.copySign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sign);
            return dest;
        }
        Double2OpsKernelsSegment.copySign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, sign);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double signX, double signY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, signX, signY);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double signX, double signY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.copySign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, signX, signY);
            return dest;
        }
        Double2OpsKernelsSegment.copySign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, signX, signY);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer sign, int signOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _signBase = UnsafeOpsHolder.U.getLong(sign, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) signOffset * 8L;
        Double2OpsKernelsAddress.copySign_unsafe(_destBase, _srcBase, _signBase);
        return dest;
    }

    public static java.nio.DoubleBuffer copySign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer sign, int signOffset) {
        if (dest.hasArray() && src.hasArray() && sign.hasArray()) {
            Double2Ops.copySign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sign.array(), sign.arrayOffset() + signOffset);
            return dest;
        }
        Double2OpsKernelsSegment.copySign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(sign.duplicate().position(0)), (long) signOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cos_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.cos_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cos_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.cos(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.cos_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cosh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.cosh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cosh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.cosh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.cosh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer degrees_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.degrees_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer degrees_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.degrees(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.degrees_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double distance_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.distance_unsafe(_srcBase, otherX, otherY);
    }

    public static double distance_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (src.hasArray()) {
            return Double2Ops.distance(src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
        }
        return Double2OpsKernelsSegment.distance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
    }

    public static double distance_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double2OpsKernelsAddress.distance_unsafe(_srcBase, _otherBase);
    }

    public static double distance_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double2Ops.distance(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double2OpsKernelsSegment.distance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static double distanceSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.distanceSquared_unsafe(_srcBase, otherX, otherY);
    }

    public static double distanceSquared_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (src.hasArray()) {
            return Double2Ops.distanceSquared(src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
        }
        return Double2OpsKernelsSegment.distanceSquared_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
    }

    public static double distanceSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double2OpsKernelsAddress.distanceSquared_unsafe(_srcBase, _otherBase);
    }

    public static double distanceSquared_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double2Ops.distanceSquared(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double2OpsKernelsSegment.distanceSquared_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static double dot_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.dot_unsafe(_srcBase, otherX, otherY);
    }

    public static double dot_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (src.hasArray()) {
            return Double2Ops.dot(src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
        }
        return Double2OpsKernelsSegment.dot_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
    }

    public static double dot_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double2OpsKernelsAddress.dot_unsafe(_srcBase, _otherBase);
    }

    public static double dot_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double2Ops.dot(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double2OpsKernelsSegment.dot_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static java.nio.DoubleBuffer exp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.exp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer exp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.exp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.exp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer exp2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.exp2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer exp2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.exp2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.exp2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer expm1_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.expm1_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer expm1_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.expm1(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.expm1_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double IX, double IY, double NrefX, double NrefY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.faceforward_unsafe(_destBase, _srcBase, IX, IY, NrefX, NrefY);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double IX, double IY, double NrefX, double NrefY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.faceforward(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, IX, IY, NrefX, NrefY);
            return dest;
        }
        Double2OpsKernelsSegment.faceforward_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, IX, IY, NrefX, NrefY);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer I, int IOffset, java.nio.DoubleBuffer Nref, int NrefOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _IBase = UnsafeOpsHolder.U.getLong(I, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) IOffset * 8L;
        long _NrefBase = UnsafeOpsHolder.U.getLong(Nref, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) NrefOffset * 8L;
        Double2OpsKernelsAddress.faceforward_unsafe(_destBase, _srcBase, _IBase, _NrefBase);
        return dest;
    }

    public static java.nio.DoubleBuffer faceforward_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer I, int IOffset, java.nio.DoubleBuffer Nref, int NrefOffset) {
        if (dest.hasArray() && src.hasArray() && I.hasArray() && Nref.hasArray()) {
            Double2Ops.faceforward(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, I.array(), I.arrayOffset() + IOffset, Nref.array(), Nref.arrayOffset() + NrefOffset);
            return dest;
        }
        Double2OpsKernelsSegment.faceforward_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(I.duplicate().position(0)), (long) IOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(Nref.duplicate().position(0)), (long) NrefOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer floor_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.floor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer floor_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.floor(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.floor_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer fract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.fract_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer fract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.fract(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.fract_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, y);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.hypot(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y);
            return dest;
        }
        Double2OpsKernelsSegment.hypot_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, y);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, yX, yY);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.hypot(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, yX, yY);
            return dest;
        }
        Double2OpsKernelsSegment.hypot_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, yX, yY);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double2OpsKernelsAddress.hypot_unsafe(_destBase, _srcBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer hypot_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (dest.hasArray() && src.hasArray() && y.hasArray()) {
            Double2Ops.hypot(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Double2OpsKernelsSegment.hypot_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer inverse_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.inverse_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer inverse_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.inverse(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.inverse_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer inverseSqrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.inverseSqrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer inverseSqrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.inverseSqrt(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.inverseSqrt_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double length_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.length_unsafe(_srcBase);
    }

    public static double length_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.length(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.length_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double lengthSquared_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.lengthSquared_unsafe(_srcBase);
    }

    public static double lengthSquared_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.lengthSquared(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.lengthSquared_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer log_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.log_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.log(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.log_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer log10_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.log10_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log10_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.log10(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.log10_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer log1p_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.log1p_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log1p_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.log1p(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.log1p_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer log2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.log2_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer log2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.log2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.log2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double manhattanDistance_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.manhattanDistance_unsafe(_srcBase, otherX, otherY);
    }

    public static double manhattanDistance_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (src.hasArray()) {
            return Double2Ops.manhattanDistance(src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
        }
        return Double2OpsKernelsSegment.manhattanDistance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
    }

    public static double manhattanDistance_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double2OpsKernelsAddress.manhattanDistance_unsafe(_srcBase, _otherBase);
    }

    public static double manhattanDistance_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double2Ops.manhattanDistance(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double2OpsKernelsSegment.manhattanDistance_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static double manhattanLength_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.manhattanLength_unsafe(_srcBase);
    }

    public static double manhattanLength_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double2Ops.manhattanLength(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double2OpsKernelsSegment.manhattanLength_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.max_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.max(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, scalar);
            return dest;
        }
        Double2OpsKernelsSegment.max_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.max_unsafe(_destBase, _srcBase, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.max(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
            return dest;
        }
        Double2OpsKernelsSegment.max_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer max_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.max_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer max_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.max(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double2OpsKernelsSegment.max_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.min_unsafe(_destBase, _srcBase, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double scalar) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.min(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, scalar);
            return dest;
        }
        Double2OpsKernelsSegment.min_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, scalar);
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.min_unsafe(_destBase, _srcBase, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.min(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
            return dest;
        }
        Double2OpsKernelsSegment.min_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
        return dest;
    }

    public static java.nio.DoubleBuffer min_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double2OpsKernelsAddress.min_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer min_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double2Ops.min(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double2OpsKernelsSegment.min_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, y);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double y) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.mod(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y);
            return dest;
        }
        Double2OpsKernelsSegment.mod_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, y);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, yX, yY);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double yX, double yY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.mod(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, yX, yY);
            return dest;
        }
        Double2OpsKernelsSegment.mod_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, yX, yY);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double2OpsKernelsAddress.mod_unsafe(_destBase, _srcBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mod_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (dest.hasArray() && src.hasArray() && y.hasArray()) {
            Double2Ops.mod(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Double2OpsKernelsSegment.mod_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer nextDown_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.nextDown_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer nextDown_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.nextDown(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.nextDown_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer nextUp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.nextUp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer nextUp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.nextUp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.nextUp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalize_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.normalize_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalize_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.normalize(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.normalize_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizeMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double length) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.normalizeMul_unsafe(_destBase, _srcBase, length);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizeMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double length) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.normalizeMul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, length);
            return dest;
        }
        Double2OpsKernelsSegment.normalizeMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, length);
        return dest;
    }

    public static double orientedAngle_unsafe(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double2OpsKernelsAddress.orientedAngle_unsafe(_srcBase, otherX, otherY);
    }

    public static double orientedAngle_api(java.nio.DoubleBuffer src, int srcOffset, double otherX, double otherY) {
        if (src.hasArray()) {
            return Double2Ops.orientedAngle(src.array(), src.arrayOffset() + srcOffset, otherX, otherY);
        }
        return Double2OpsKernelsSegment.orientedAngle_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, otherX, otherY);
    }

    public static double orientedAngle_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        return Double2OpsKernelsAddress.orientedAngle_unsafe(_srcBase, _otherBase);
    }

    public static double orientedAngle_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (src.hasArray() && other.hasArray()) {
            return Double2Ops.orientedAngle(src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
        }
        return Double2OpsKernelsSegment.orientedAngle_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
    }

    public static java.nio.DoubleBuffer outerProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rowX, double rowY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.outerProduct_unsafe(_destBase, _srcBase, rowX, rowY);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rowX, double rowY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.outerProduct(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rowX, rowY);
            return dest;
        }
        Double2OpsKernelsSegment.outerProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, rowX, rowY);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rowOffset * 8L;
        Double2OpsKernelsAddress.outerProduct_unsafe(_destBase, _srcBase, _rowBase);
        return dest;
    }

    public static java.nio.DoubleBuffer outerProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer row, int rowOffset) {
        if (dest.hasArray() && src.hasArray() && row.hasArray()) {
            Double2Ops.outerProduct(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, row.array(), row.arrayOffset() + rowOffset);
            return dest;
        }
        Double2OpsKernelsSegment.outerProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(row.duplicate().position(0)), (long) rowOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponent) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, exponent);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponent) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.pow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, exponent);
            return dest;
        }
        Double2OpsKernelsSegment.pow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, exponent);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponentX, double exponentY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, exponentX, exponentY);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double exponentX, double exponentY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.pow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, exponentX, exponentY);
            return dest;
        }
        Double2OpsKernelsSegment.pow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, exponentX, exponentY);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer exponent, int exponentOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _exponentBase = UnsafeOpsHolder.U.getLong(exponent, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) exponentOffset * 8L;
        Double2OpsKernelsAddress.pow_unsafe(_destBase, _srcBase, _exponentBase);
        return dest;
    }

    public static java.nio.DoubleBuffer pow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer exponent, int exponentOffset) {
        if (dest.hasArray() && src.hasArray() && exponent.hasArray()) {
            Double2Ops.pow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, exponent.array(), exponent.arrayOffset() + exponentOffset);
            return dest;
        }
        Double2OpsKernelsSegment.pow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(exponent.duplicate().position(0)), (long) exponentOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer project_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double ontoX, double ontoY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.project_unsafe(_destBase, _srcBase, ontoX, ontoY);
        return dest;
    }

    public static java.nio.DoubleBuffer project_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double ontoX, double ontoY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.project(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, ontoX, ontoY);
            return dest;
        }
        Double2OpsKernelsSegment.project_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, ontoX, ontoY);
        return dest;
    }

    public static java.nio.DoubleBuffer project_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer onto, int ontoOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _ontoBase = UnsafeOpsHolder.U.getLong(onto, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) ontoOffset * 8L;
        Double2OpsKernelsAddress.project_unsafe(_destBase, _srcBase, _ontoBase);
        return dest;
    }

    public static java.nio.DoubleBuffer project_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer onto, int ontoOffset) {
        if (dest.hasArray() && src.hasArray() && onto.hasArray()) {
            Double2Ops.project(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, onto.array(), onto.arrayOffset() + ontoOffset);
            return dest;
        }
        Double2OpsKernelsSegment.project_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(onto.duplicate().position(0)), (long) ontoOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.projectOnPlane_unsafe(_destBase, _srcBase, normalX, normalY);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.projectOnPlane(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY);
            return dest;
        }
        Double2OpsKernelsSegment.projectOnPlane_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double2OpsKernelsAddress.projectOnPlane_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer projectOnPlane_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        if (dest.hasArray() && src.hasArray() && normal.hasArray()) {
            Double2Ops.projectOnPlane(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Double2OpsKernelsSegment.projectOnPlane_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer radians_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.radians_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer radians_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.radians(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.radians_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY);
            return dest;
        }
        Double2OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double2OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        if (dest.hasArray() && src.hasArray() && normal.hasArray()) {
            Double2Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Double2OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double eta) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.refract_unsafe(_destBase, _srcBase, normalX, normalY, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double eta) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.refract(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY, eta);
            return dest;
        }
        Double2OpsKernelsSegment.refract_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset, double eta) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double2OpsKernelsAddress.refract_unsafe(_destBase, _srcBase, _normalBase, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer refract_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset, double eta) {
        if (dest.hasArray() && src.hasArray() && normal.hasArray()) {
            Double2Ops.refract(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normal.array(), normal.arrayOffset() + normalOffset, eta);
            return dest;
        }
        Double2OpsKernelsSegment.refract_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L, eta);
        return dest;
    }

    public static java.nio.DoubleBuffer round_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.round_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer round_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.round(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.round_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sign_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.sign_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sign_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.sign(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.sign_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.sin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.sin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.sin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sinh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.sinh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sinh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.sinh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.sinh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0, double edge1) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, edge0, edge1);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0, double edge1) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.smoothstep(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge0, edge1);
            return dest;
        }
        Double2OpsKernelsSegment.smoothstep_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edge0, edge1);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0X, double edge0Y, double edge1X, double edge1Y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, edge0X, edge0Y, edge1X, edge1Y);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge0X, double edge0Y, double edge1X, double edge1Y) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.smoothstep(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge0X, edge0Y, edge1X, edge1Y);
            return dest;
        }
        Double2OpsKernelsSegment.smoothstep_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edge0X, edge0Y, edge1X, edge1Y);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge0, int edge0Offset, java.nio.DoubleBuffer edge1, int edge1Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _edge0Base = UnsafeOpsHolder.U.getLong(edge0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edge0Offset * 8L;
        long _edge1Base = UnsafeOpsHolder.U.getLong(edge1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edge1Offset * 8L;
        Double2OpsKernelsAddress.smoothstep_unsafe(_destBase, _srcBase, _edge0Base, _edge1Base);
        return dest;
    }

    public static java.nio.DoubleBuffer smoothstep_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge0, int edge0Offset, java.nio.DoubleBuffer edge1, int edge1Offset) {
        if (dest.hasArray() && src.hasArray() && edge0.hasArray() && edge1.hasArray()) {
            Double2Ops.smoothstep(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge0.array(), edge0.arrayOffset() + edge0Offset, edge1.array(), edge1.arrayOffset() + edge1Offset);
            return dest;
        }
        Double2OpsKernelsSegment.smoothstep_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(edge0.duplicate().position(0)), (long) edge0Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(edge1.duplicate().position(0)), (long) edge1Offset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sqrt_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.sqrt_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sqrt_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.sqrt(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.sqrt_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.step_unsafe(_destBase, _srcBase, edge);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edge) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.step(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge);
            return dest;
        }
        Double2OpsKernelsSegment.step_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edge);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edgeX, double edgeY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.step_unsafe(_destBase, _srcBase, edgeX, edgeY);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double edgeX, double edgeY) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.step(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edgeX, edgeY);
            return dest;
        }
        Double2OpsKernelsSegment.step_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, edgeX, edgeY);
        return dest;
    }

    public static java.nio.DoubleBuffer step_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge, int edgeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _edgeBase = UnsafeOpsHolder.U.getLong(edge, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) edgeOffset * 8L;
        Double2OpsKernelsAddress.step_unsafe(_destBase, _srcBase, _edgeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer step_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer edge, int edgeOffset) {
        if (dest.hasArray() && src.hasArray() && edge.hasArray()) {
            Double2Ops.step(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, edge.array(), edge.arrayOffset() + edgeOffset);
            return dest;
        }
        Double2OpsKernelsSegment.step_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(edge.duplicate().position(0)), (long) edgeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer tan_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.tan_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer tan_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.tan(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.tan_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer tanh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.tanh_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer tanh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.tanh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.tanh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer trunc_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.trunc_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer trunc_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.trunc(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.trunc_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer ulp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.ulp_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer ulp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.ulp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double2OpsKernelsSegment.ulp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double2OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        if (dest.hasArray() && src.hasArray() && mat.hasArray()) {
            Double2Ops.preMul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, mat.array(), mat.arrayOffset() + matOffset);
            return dest;
        }
        Double2OpsKernelsSegment.preMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(mat.duplicate().position(0)), (long) matOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double2OpsKernelsAddress.preMulDirection_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        if (dest.hasArray() && src.hasArray() && mat.hasArray()) {
            Double2Ops.preMulDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, mat.array(), mat.arrayOffset() + matOffset);
            return dest;
        }
        Double2OpsKernelsSegment.preMulDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(mat.duplicate().position(0)), (long) matOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _matBase = UnsafeOpsHolder.U.getLong(mat, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matOffset * 8L;
        Double2OpsKernelsAddress.preMulPosition_unsafe(_destBase, _srcBase, _matBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer mat, int matOffset) {
        if (dest.hasArray() && src.hasArray() && mat.hasArray()) {
            Double2Ops.preMulPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, mat.array(), mat.arrayOffset() + matOffset);
            return dest;
        }
        Double2OpsKernelsSegment.preMulPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(mat.duplicate().position(0)), (long) matOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double2OpsKernelsAddress.rotate_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double2Ops.rotate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double2OpsKernelsSegment.rotate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

}
