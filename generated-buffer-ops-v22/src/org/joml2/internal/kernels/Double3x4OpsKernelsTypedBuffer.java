package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double3x4Ops} whose leading storage
 * parameter is a typed {@link java.nio.DoubleBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double3x4Ops} and its sibling kernel units. Not public API.
 */
public final class Double3x4OpsKernelsTypedBuffer {
    private Double3x4OpsKernelsTypedBuffer() {}

    public static java.nio.DoubleBuffer getColumn_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.DoubleBuffer getColumn_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int col) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getColumn(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, col);
            return dest;
        }
        Double3x4OpsKernelsSegment.getColumn_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, col);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getEulerAnglesXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getEulerAnglesXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getEulerAnglesXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getEulerAnglesXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getEulerAnglesYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getEulerAnglesYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getEulerAnglesYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getEulerAnglesYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getEulerAnglesZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getEulerAnglesZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getEulerAnglesZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getEulerAnglesZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getNormalizedRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getNormalizedRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getNormalizedRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getNormalizedRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getRow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.DoubleBuffer getRow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int row) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getRow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, row);
            return dest;
        }
        Double3x4OpsKernelsSegment.getRow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, row);
        return dest;
    }

    public static java.nio.DoubleBuffer getScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getUnnormalizedRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getUnnormalizedRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.getUnnormalizedRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.getUnnormalizedRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNormalizedNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNormalizedNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNormalizedNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNormalizedNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNormalizedNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNormalizedNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNormalizedPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNormalizedPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNormalizedPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNormalizedPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invNormalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invNormalizedPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invNormalizedPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.negativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.negativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.negativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.negativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.negativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.negativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.normalizedNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.normalizedNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.normalizedNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.normalizedNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.normalizedNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.normalizedNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.normalizedPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.normalizedPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.normalizedPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.normalizedPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.normalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.normalizedPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.normalizedPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer origin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.origin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer origin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.origin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.origin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.positiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.positiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.positiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.positiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.positiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.positiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.positiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.positiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.positiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double determinant_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3x4OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static double determinant_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double3x4Ops.determinant(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double3x4OpsKernelsSegment.determinant_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double frobeniusNorm_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double3x4OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static double frobeniusNorm_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double3x4Ops.frobeniusNorm(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double3x4OpsKernelsSegment.frobeniusNorm_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer invert_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invert_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.invert(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invert_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invertProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invertProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.invertProduct(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.invertProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transpose_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transpose_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.transpose(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.transpose_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.add(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.add_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.negate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.negate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.sub(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.sub_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double3x4Ops.set(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.setMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (dest.hasArray() && m.hasArray()) {
            Double3x4Ops.setMat3x3(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.setMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.setMat4x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (dest.hasArray() && m.hasArray()) {
            Double3x4Ops.setMat4x4(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.setMat4x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double tX, double tY, double tZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY, tZ);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double tX, double tY, double tZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.withTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, tX, tY, tZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.withTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, tX, tY, tZ);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 8L;
        Double3x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t, int tOffset) {
        if (dest.hasArray() && src.hasArray() && t.hasArray()) {
            Double3x4Ops.withTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t.array(), t.arrayOffset() + tOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.withTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t.duplicate().position(0)), (long) tOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromRigid_unsafe(java.nio.DoubleBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromRigid_api(java.nio.DoubleBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        if (dest.hasArray()) {
            Double3x4Ops.makeFromRigid(dest.array(), dest.arrayOffset() + destOffset, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeFromRigid_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromTransform_unsafe(java.nio.DoubleBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromTransform_api(java.nio.DoubleBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeFromTransform(dest.array(), dest.arrayOffset() + destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeFromTransform_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.to3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.to3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.to3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer to4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.to4x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer to4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.to4x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.to4x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer toDualQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toDualQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.toDualQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.toDualQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer toRigid_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toRigid_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.toRigid(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.toRigid_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer toTransform_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toTransform_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.toTransform(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.toTransform_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.decomposeRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.decomposeRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.decomposeScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.decomposeScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeSkew_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeSkew_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.decomposeSkew(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.decomposeSkew_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeTRS_unsafe(java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.decomposeTRS_unsafe(_translationBase, _rotationBase, _scaleBase, _srcBase);
        return translation;
    }

    public static java.nio.DoubleBuffer decomposeTRS_api(java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (translation.hasArray() && rotation.hasArray() && scale.hasArray() && src.hasArray()) {
            Double3x4Ops.decomposeTRS(translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset, src.array(), src.arrayOffset() + srcOffset);
            return translation;
        }
        Double3x4OpsKernelsSegment.decomposeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return translation;
    }

    public static java.nio.DoubleBuffer makeIdentity_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeIdentity_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeIdentity(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeIdentity_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset, t);
            return dest;
        }
        Double3x4OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double3x4OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double3x4Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double3x4OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double3x4Ops.mulMat2x2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mulMat2x2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double3x4OpsKernelsAddress.mulMat2x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double3x4Ops.mulMat2x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mulMat2x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double3x4OpsKernelsAddress.mulMat3x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double3x4Ops.mulMat3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mulMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double3x4OpsKernelsAddress.mulMat4x4_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double3x4Ops.mulMat4x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mulMat4x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.preMul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.preMulMat2x2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preMulMat2x2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.preMulMat2x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.preMulMat2x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preMulMat2x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.preMulMat3x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.preMulMat3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preMulMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat4x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double3x4OpsKernelsAddress.preMulMat4x4_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat4x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double3x4Ops.preMulMat4x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preMulMat4x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_unsafe(java.nio.DoubleBuffer dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRS_unsafe(_destBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_api(java.nio.DoubleBuffer dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.composeTRS(dest.array(), dest.arrayOffset() + destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.composeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRS_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset) {
        if (dest.hasArray() && translation.hasArray() && rotation.hasArray() && scale.hasArray()) {
            Double3x4Ops.composeTRS(dest.array(), dest.arrayOffset() + destOffset, translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.composeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _mBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (dest.hasArray() && m.hasArray()) {
            Double3x4Ops.composeTRSMul(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.composeTRSMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (dest.hasArray() && translation.hasArray() && rotation.hasArray() && scale.hasArray() && m.hasArray()) {
            Double3x4Ops.composeTRSMul(dest.array(), dest.arrayOffset() + destOffset, translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.composeTRSMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.lookAlong(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.lookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && dir.hasArray() && up.hasArray()) {
            Double3x4Ops.lookAlong(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, dir.array(), dir.arrayOffset() + dirOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.lookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(dir.duplicate().position(0)), (long) dirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double3x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer lookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4OpsKernelsArray.lookAt_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.lookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double3x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer lookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4OpsKernelsArray.lookAt_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.lookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double3x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double3x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer lookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double3x4OpsKernelsArray.lookAt_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.lookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double3x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double3x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer lookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double3x4OpsKernelsArray.lookAt_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.lookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeBillboardCylindrical(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeBillboardCylindrical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 8L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, _objPosBase, _targetPosBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray() && up.hasArray()) {
            Double3x4Ops.makeBillboardCylindrical(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeBillboardCylindrical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeBillboardSpherical(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeBillboardSpherical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 8L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, _objPosBase, _targetPosBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray() && up.hasArray()) {
            Double3x4Ops.makeBillboardSpherical(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeBillboardSpherical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeBillboardSphericalShortest(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeBillboardSphericalShortest_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 8L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 8L;
        Double3x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, _objPosBase, _targetPosBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray()) {
            Double3x4Ops.makeBillboardSphericalShortest(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeBillboardSphericalShortest_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromDualQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromDualQuat_api(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        if (dest.hasArray()) {
            Double3x4Ops.makeFromDualQuat(dest.array(), dest.arrayOffset() + destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeFromDualQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double3x4OpsKernelsArray.makeLookAt_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeLookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double3x4OpsKernelsArray.makeLookAt_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeLookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double3x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double3x4OpsKernelsArray.makeLookAt_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeLookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double3x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double3x4OpsKernelsArray.makeLookAt_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeLookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXnYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXnYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXnZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingXnZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYnXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYnXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYnZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingYnZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZnXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZnXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZnYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingZnYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXnYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXnYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXnZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnXnZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYnXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYnXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYnZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnYnZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZnXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZnXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZnYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeMappingnZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double3x4Ops.makeMappingnZnYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeMappingnZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_unsafe(java.nio.DoubleBuffer dest, int destOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeReflection_unsafe(_destBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_api(java.nio.DoubleBuffer dest, int destOffset, double normalX, double normalY, double normalZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeReflection(dest.array(), dest.arrayOffset() + destOffset, normalX, normalY, normalZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeReflection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double3x4OpsKernelsAddress.makeReflection_unsafe(_destBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        if (dest.hasArray() && normal.hasArray()) {
            Double3x4Ops.makeReflection(dest.array(), dest.arrayOffset() + destOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeReflection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_api(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationAxis(dest.array(), dest.arrayOffset() + destOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && axis.hasArray()) {
            Double3x4Ops.makeRotationAxis(dest.array(), dest.arrayOffset() + destOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_api(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationLookAlong(dest.array(), dest.arrayOffset() + destOffset, dirX, dirY, dirZ, upX, upY, upZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationLookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && dir.hasArray() && up.hasArray()) {
            Double3x4Ops.makeRotationLookAlong(dest.array(), dest.arrayOffset() + destOffset, dir.array(), dir.arrayOffset() + dirOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationLookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(dir.duplicate().position(0)), (long) dirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_api(java.nio.DoubleBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationQuat(dest.array(), dest.arrayOffset() + destOffset, qX, qY, qZ, qW);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (dest.hasArray() && q.hasArray()) {
            Double3x4Ops.makeRotationQuat(dest.array(), dest.arrayOffset() + destOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationX_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationX(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXYZ_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationXYZ(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXZY_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationXZY(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationY_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationY(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYXZ_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationYXZ(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYZX_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationYZX(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationZ_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZ_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationZ(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZXY_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationZXY(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZYX_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeRotationZYX(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeRotationZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double3x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, double s) {
        if (dest.hasArray()) {
            Double3x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, s);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        if (dest.hasArray()) {
            Double3x4Ops.makeTranslation(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double3x4Ops.makeTranslation(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.makeTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXnYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXnYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXnZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapXnZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYnXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYnXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYnZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapYnZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZnXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZnXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZnYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapZnYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXnYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXnYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXnZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnXnZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYnXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYnXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYnZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnYnZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZnXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZnXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZnYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mapnZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mapnZnYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mapnZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preRotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rotBase = UnsafeOpsHolder.U.getLong(rot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _rotBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && rot.hasArray() && pivot.hasArray()) {
            Double3x4Ops.preRotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rot.array(), rot.arrayOffset() + rotOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rot.duplicate().position(0)), (long) rotOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preRotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Double3x4Ops.preRotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preRotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, qX, qY, qZ, qW);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (dest.hasArray() && src.hasArray() && q.hasArray()) {
            Double3x4Ops.preRotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preRotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preRotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preRotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preRotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.preRotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double3x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        if (dest.hasArray() && src.hasArray() && pivot.hasArray()) {
            Double3x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, pivot.array(), pivot.arrayOffset() + pivotOffset, s);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double3x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && s.hasArray() && pivot.hasArray()) {
            Double3x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s.array(), s.arrayOffset() + sOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(s.duplicate().position(0)), (long) sOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.preTranslate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.preTranslate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.preTranslate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.preTranslate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY, normalZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double3x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        if (dest.hasArray() && src.hasArray() && normal.hasArray()) {
            Double3x4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rotBase = UnsafeOpsHolder.U.getLong(rot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double3x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _rotBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && rot.hasArray() && pivot.hasArray()) {
            Double3x4Ops.rotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rot.array(), rot.arrayOffset() + rotOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rot.duplicate().position(0)), (long) rotOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double3x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Double3x4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, qX, qY, qZ, qW);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double3x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (dest.hasArray() && src.hasArray() && q.hasArray()) {
            Double3x4Ops.rotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.rotateZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.rotateZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s);
            return dest;
        }
        Double3x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double3x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        if (dest.hasArray() && src.hasArray() && pivot.hasArray()) {
            Double3x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, pivot.array(), pivot.arrayOffset() + pivotOffset, s);
            return dest;
        }
        Double3x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double3x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && s.hasArray() && pivot.hasArray()) {
            Double3x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s.array(), s.arrayOffset() + sOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(s.duplicate().position(0)), (long) sOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.translate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.translate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.translate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.translate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ, double vW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ, double vW) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.mulVec4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ, vW);
            return dest;
        }
        Double3x4OpsKernelsSegment.mulVec4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.mulVec4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.mulVec4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformAabb_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transformAabb_unsafe(_destBase, _srcBase, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformAabb_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.transformAabb(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.transformAabb_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.transformDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.transformDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.transformDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.transformDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double3x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double3x4Ops.transformPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double3x4OpsKernelsSegment.transformPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double3x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double3x4Ops.transformPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double3x4OpsKernelsSegment.transformPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 8L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 8L;
        Double3x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        double _m00 = matrix.get(matrixOffset + 0);
        double _m01 = matrix.get(matrixOffset + 1);
        double _m02 = matrix.get(matrixOffset + 2);
        double _m03 = matrix.get(matrixOffset + 3);
        double _m10 = matrix.get(matrixOffset + 4);
        double _m11 = matrix.get(matrixOffset + 5);
        double _m12 = matrix.get(matrixOffset + 6);
        double _m13 = matrix.get(matrixOffset + 7);
        double _m20 = matrix.get(matrixOffset + 8);
        double _m21 = matrix.get(matrixOffset + 9);
        double _m22 = matrix.get(matrixOffset + 10);
        double _m23 = matrix.get(matrixOffset + 11);
        for (int _i = 0; _i < count; _i++) {
            int _po = pointsOffset + _i * 3;
            int _do = destOffset + _i * 3;
            double px = points.get(_po + 0), py = points.get(_po + 1), pz = points.get(_po + 2);
            dest.put(_do + 0, Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03))));
            dest.put(_do + 1, Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13))));
            dest.put(_do + 2, Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23))));
        }
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 8L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 8L;
        Double3x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        double _m00 = matrix.get(matrixOffset + 0);
        double _m01 = matrix.get(matrixOffset + 1);
        double _m02 = matrix.get(matrixOffset + 2);
        double _m10 = matrix.get(matrixOffset + 4);
        double _m11 = matrix.get(matrixOffset + 5);
        double _m12 = matrix.get(matrixOffset + 6);
        double _m20 = matrix.get(matrixOffset + 8);
        double _m21 = matrix.get(matrixOffset + 9);
        double _m22 = matrix.get(matrixOffset + 10);
        for (int _i = 0; _i < count; _i++) {
            int _po = pointsOffset + _i * 3;
            int _do = destOffset + _i * 3;
            double px = points.get(_po + 0), py = points.get(_po + 1), pz = points.get(_po + 2);
            dest.put(_do + 0, Math.fma(_m02, pz, Math.fma(_m00, px, _m01 * py)));
            dest.put(_do + 1, Math.fma(_m12, pz, Math.fma(_m10, px, _m11 * py)));
            dest.put(_do + 2, Math.fma(_m22, pz, Math.fma(_m20, px, _m21 * py)));
        }
        return dest;
    }

    public static java.nio.DoubleBuffer lerpComposeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer t1, int t1Offset, java.nio.DoubleBuffer t2, int t2Offset, java.nio.DoubleBuffer q1, int q1Offset, java.nio.DoubleBuffer q2, int q2Offset, java.nio.DoubleBuffer s1, int s1Offset, java.nio.DoubleBuffer s2, int s2Offset, java.nio.DoubleBuffer m, int mOffset, double alpha, int count) {
        long _t1Base = UnsafeOpsHolder.U.getLong(t1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t1Offset * 8L;
        long _t2Base = UnsafeOpsHolder.U.getLong(t2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) t2Offset * 8L;
        long _q1Base = UnsafeOpsHolder.U.getLong(q1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) q1Offset * 8L;
        long _q2Base = UnsafeOpsHolder.U.getLong(q2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) q2Offset * 8L;
        long _s1Base = UnsafeOpsHolder.U.getLong(s1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) s1Offset * 8L;
        long _s2Base = UnsafeOpsHolder.U.getLong(s2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) s2Offset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.lerpComposeTRSMul_unsafe(_destBase, _t1Base, _t2Base, _q1Base, _q2Base, _s1Base, _s2Base, _mBase, alpha, count);
        return dest;
    }

    public static java.nio.DoubleBuffer lerpComposeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer t1, int t1Offset, java.nio.DoubleBuffer t2, int t2Offset, java.nio.DoubleBuffer q1, int q1Offset, java.nio.DoubleBuffer q2, int q2Offset, java.nio.DoubleBuffer s1, int s1Offset, java.nio.DoubleBuffer s2, int s2Offset, java.nio.DoubleBuffer m, int mOffset, double alpha, int count) {
        for (int _i = 0; _i < count; _i++) {
            int _t1o = t1Offset + _i * 3;
            int _t2o = t2Offset + _i * 3;
            int _q1o = q1Offset + _i * 4;
            int _q2o = q2Offset + _i * 4;
            int _s1o = s1Offset + _i * 3;
            int _s2o = s2Offset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            double _ax = t1.get(_t1o + 0), _ay = t1.get(_t1o + 1), _az = t1.get(_t1o + 2);
            double _tx = Math.fma(alpha, (t2.get(_t2o + 0)) - _ax, _ax);
            double _ty = Math.fma(alpha, (t2.get(_t2o + 1)) - _ay, _ay);
            double _tz = Math.fma(alpha, (t2.get(_t2o + 2)) - _az, _az);
            double _bx = s1.get(_s1o + 0), _by = s1.get(_s1o + 1), _bz = s1.get(_s1o + 2);
            double _sx = Math.fma(alpha, (s2.get(_s2o + 0)) - _bx, _bx);
            double _sy = Math.fma(alpha, (s2.get(_s2o + 1)) - _by, _by);
            double _sz = Math.fma(alpha, (s2.get(_s2o + 2)) - _bz, _bz);
            double _ux = q1.get(_q1o + 0), _uy = q1.get(_q1o + 1), _uz = q1.get(_q1o + 2), _uw = q1.get(_q1o + 3);
            double _vx = q2.get(_q2o + 0), _vy = q2.get(_q2o + 1), _vz = q2.get(_q2o + 2), _vw = q2.get(_q2o + 3);
            double _dot = Math.fma(_uw, _vw, Math.fma(_uz, _vz, Math.fma(_ux, _vx, _uy * _vy)));
            if (_dot < 0.0) { _vx = -_vx; _vy = -_vy; _vz = -_vz; _vw = -_vw; }
            double _qx = Math.fma(alpha, _vx - _ux, _ux);
            double _qy = Math.fma(alpha, _vy - _uy, _uy);
            double _qz = Math.fma(alpha, _vz - _uz, _uz);
            double _qw = Math.fma(alpha, _vw - _uw, _uw);
            double _len2 = (_qx * _qx + _qy * _qy) + (_qz * _qz + _qw * _qw);
            double _ninv = _len2 > 0.0 ? 1.0 / Math.sqrt(_len2) : 0.0;
            _qx *= _ninv; _qy *= _ninv; _qz *= _ninv; _qw *= _ninv;
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = m.get(_mo + 0), _m01 = m.get(_mo + 1), _m02 = m.get(_mo + 2), _m03 = m.get(_mo + 3);
            double _m10 = m.get(_mo + 4), _m11 = m.get(_mo + 5), _m12 = m.get(_mo + 6), _m13 = m.get(_mo + 7);
            double _m20 = m.get(_mo + 8), _m21 = m.get(_mo + 9), _m22 = m.get(_mo + 10), _m23 = m.get(_mo + 11);
            double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            dest.put(_do + 0, _e00);
            dest.put(_do + 1, _e01);
            dest.put(_do + 2, _e02);
            dest.put(_do + 3, _e03);
            dest.put(_do + 4, _e10);
            dest.put(_do + 5, _e11);
            dest.put(_do + 6, _e12);
            dest.put(_do + 7, _e13);
            dest.put(_do + 8, _e20);
            dest.put(_do + 9, _e21);
            dest.put(_do + 10, _e22);
            dest.put(_do + 11, _e23);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset, int count) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset, int count) {
        for (int _i = 0; _i < count; _i++) {
            int _translationo = translationOffset + _i * 3;
            int _rotationo = rotationOffset + _i * 4;
            int _scaleo = scaleOffset + _i * 3;
            int _mo = mOffset + _i * 12;
            int _do = destOffset + _i * 12;
            double _tx = translation.get(_translationo + 0), _ty = translation.get(_translationo + 1), _tz = translation.get(_translationo + 2);
            double _sx = scale.get(_scaleo + 0), _sy = scale.get(_scaleo + 1), _sz = scale.get(_scaleo + 2);
            double _qx = rotation.get(_rotationo + 0), _qy = rotation.get(_rotationo + 1), _qz = rotation.get(_rotationo + 2), _qw = rotation.get(_rotationo + 3);
            double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
            double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
            double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
            double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
            double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
            double _m00 = m.get(_mo + 0), _m01 = m.get(_mo + 1), _m02 = m.get(_mo + 2), _m03 = m.get(_mo + 3);
            double _m10 = m.get(_mo + 4), _m11 = m.get(_mo + 5), _m12 = m.get(_mo + 6), _m13 = m.get(_mo + 7);
            double _m20 = m.get(_mo + 8), _m21 = m.get(_mo + 9), _m22 = m.get(_mo + 10), _m23 = m.get(_mo + 11);
            double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
            double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
            double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
            dest.put(_do + 0, _e00);
            dest.put(_do + 1, _e01);
            dest.put(_do + 2, _e02);
            dest.put(_do + 3, _e03);
            dest.put(_do + 4, _e10);
            dest.put(_do + 5, _e11);
            dest.put(_do + 6, _e12);
            dest.put(_do + 7, _e13);
            dest.put(_do + 8, _e20);
            dest.put(_do + 9, _e21);
            dest.put(_do + 10, _e22);
            dest.put(_do + 11, _e23);
        }
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMulPadded_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double3x4OpsKernelsAddress.composeTRSMulPadded_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMulPadded_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        double _qx = rotation.get(rotationOffset + 0), _qy = rotation.get(rotationOffset + 1), _qz = rotation.get(rotationOffset + 2), _qw = rotation.get(rotationOffset + 3);
        double _tx = translation.get(translationOffset + 0), _ty = translation.get(translationOffset + 1), _tz = translation.get(translationOffset + 2);
        double _sx = scale.get(scaleOffset + 0), _sy = scale.get(scaleOffset + 1), _sz = scale.get(scaleOffset + 2);
        double _m00 = m.get(mOffset + 0), _m01 = m.get(mOffset + 1), _m02 = m.get(mOffset + 2), _m03 = m.get(mOffset + 3);
        double _m10 = m.get(mOffset + 4), _m11 = m.get(mOffset + 5), _m12 = m.get(mOffset + 6), _m13 = m.get(mOffset + 7);
        double _m20 = m.get(mOffset + 8), _m21 = m.get(mOffset + 9), _m22 = m.get(mOffset + 10), _m23 = m.get(mOffset + 11);
        double _xx = _qx * _qx, _yy = _qy * _qy, _zz = _qz * _qz;
        double _xy = _qx * _qy, _xz = _qx * _qz, _yz = _qy * _qz, _xw = _qx * _qw, _yw = _qy * _qw, _zw = _qz * _qw;
        double _t00 = (1 - 2 * (_yy + _zz)) * _sx, _t01 = (2 * (_xy - _zw)) * _sy, _t02 = (2 * (_xz + _yw)) * _sz;
        double _t10 = (2 * (_xy + _zw)) * _sx, _t11 = (1 - 2 * (_xx + _zz)) * _sy, _t12 = (2 * (_yz - _xw)) * _sz;
        double _t20 = (2 * (_xz - _yw)) * _sx, _t21 = (2 * (_yz + _xw)) * _sy, _t22 = (1 - 2 * (_xx + _yy)) * _sz;
        double _e00 = Math.fma(_t02, _m20, Math.fma(_t01, _m10, _t00 * _m00)), _e01 = Math.fma(_t02, _m21, Math.fma(_t01, _m11, _t00 * _m01)), _e02 = Math.fma(_t02, _m22, Math.fma(_t01, _m12, _t00 * _m02)), _e03 = (Math.fma(_t02, _m23, Math.fma(_t01, _m13, _t00 * _m03))) + _tx;
        double _e10 = Math.fma(_t12, _m20, Math.fma(_t11, _m10, _t10 * _m00)), _e11 = Math.fma(_t12, _m21, Math.fma(_t11, _m11, _t10 * _m01)), _e12 = Math.fma(_t12, _m22, Math.fma(_t11, _m12, _t10 * _m02)), _e13 = (Math.fma(_t12, _m23, Math.fma(_t11, _m13, _t10 * _m03))) + _ty;
        double _e20 = Math.fma(_t22, _m20, Math.fma(_t21, _m10, _t20 * _m00)), _e21 = Math.fma(_t22, _m21, Math.fma(_t21, _m11, _t20 * _m01)), _e22 = Math.fma(_t22, _m22, Math.fma(_t21, _m12, _t20 * _m02)), _e23 = (Math.fma(_t22, _m23, Math.fma(_t21, _m13, _t20 * _m03))) + _tz;
        dest.put(destOffset + 0, _e00);
        dest.put(destOffset + 1, _e01);
        dest.put(destOffset + 2, _e02);
        dest.put(destOffset + 3, _e03);
        dest.put(destOffset + 4, _e10);
        dest.put(destOffset + 5, _e11);
        dest.put(destOffset + 6, _e12);
        dest.put(destOffset + 7, _e13);
        dest.put(destOffset + 8, _e20);
        dest.put(destOffset + 9, _e21);
        dest.put(destOffset + 10, _e22);
        dest.put(destOffset + 11, _e23);
        return dest;
    }

}
