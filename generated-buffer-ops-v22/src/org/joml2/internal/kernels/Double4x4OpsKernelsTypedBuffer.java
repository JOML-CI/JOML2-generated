package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Double4x4Ops} whose leading storage
 * parameter is a typed {@link java.nio.DoubleBuffer}. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Double4x4Ops} and its sibling kernel units. Not public API.
 */
public final class Double4x4OpsKernelsTypedBuffer {
    private Double4x4OpsKernelsTypedBuffer() {}

    public static java.nio.DoubleBuffer getColumn_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int col) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getColumn_unsafe(_destBase, _srcBase, col);
        return dest;
    }

    public static java.nio.DoubleBuffer getColumn_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int col) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getColumn(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, col);
            return dest;
        }
        Double4x4OpsKernelsSegment.getColumn_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, col);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getEulerAnglesXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getEulerAnglesXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getEulerAnglesXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getEulerAnglesXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getEulerAnglesXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getEulerAnglesXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getEulerAnglesYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getEulerAnglesYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getEulerAnglesYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getEulerAnglesYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getEulerAnglesYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getEulerAnglesYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getEulerAnglesZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getEulerAnglesZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getEulerAnglesZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getEulerAnglesZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getEulerAnglesZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getEulerAnglesZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getEulerAnglesZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getNormalizedRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getNormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getNormalizedRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getNormalizedRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getNormalizedRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getRow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int row) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getRow_unsafe(_destBase, _srcBase, row);
        return dest;
    }

    public static java.nio.DoubleBuffer getRow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, int row) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getRow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, row);
            return dest;
        }
        Double4x4OpsKernelsSegment.getRow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, row);
        return dest;
    }

    public static java.nio.DoubleBuffer getScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getTranslation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer getUnnormalizedRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.getUnnormalizedRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer getUnnormalizedRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.getUnnormalizedRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.getUnnormalizedRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNormalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNormalizedNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNormalizedNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNormalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNormalizedNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNormalizedNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNormalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNormalizedNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNormalizedNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNormalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNormalizedPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNormalizedPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNormalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNormalizedPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNormalizedPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invNormalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invNormalizedPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invNormalizedPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invNormalizedPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.negativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.negativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.negativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.negativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.negativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.negativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.negativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.negativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.negativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normalizedNegativeX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normalizedNegativeX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normalizedNegativeX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normalizedNegativeY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normalizedNegativeY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normalizedNegativeY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normalizedNegativeZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedNegativeZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normalizedNegativeZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normalizedNegativeZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normalizedPositiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normalizedPositiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normalizedPositiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normalizedPositiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normalizedPositiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normalizedPositiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normalizedPositiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normalizedPositiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normalizedPositiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normalizedPositiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer origin_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.origin_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer origin_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.origin(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.origin_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer originAffine_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.originAffine_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer originAffine_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.originAffine(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.originAffine_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.positiveX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.positiveX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.positiveX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.positiveY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.positiveY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.positiveY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.positiveZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer positiveZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.positiveZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.positiveZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer cofactor_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.cofactor_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer cofactor_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.cofactor(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.cofactor_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double determinant_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.determinant_unsafe(_srcBase);
    }

    public static double determinant_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4x4Ops.determinant(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4x4OpsKernelsSegment.determinant_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static double frobeniusNorm_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.frobeniusNorm_unsafe(_srcBase);
    }

    public static double frobeniusNorm_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4x4Ops.frobeniusNorm(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4x4OpsKernelsSegment.frobeniusNorm_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer invert_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.invert_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invert_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.invert(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invert_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer invertProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.invertProduct_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer invertProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.invertProduct(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.invertProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer normal_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.normal_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer normal_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.normal(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.normal_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static double trace_unsafe(java.nio.DoubleBuffer src, int srcOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.trace_unsafe(_srcBase);
    }

    public static double trace_api(java.nio.DoubleBuffer src, int srcOffset) {
        if (src.hasArray()) {
            return Double4x4Ops.trace(src.array(), src.arrayOffset() + srcOffset);
        }
        return Double4x4OpsKernelsSegment.trace_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
    }

    public static java.nio.DoubleBuffer transpose_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.transpose_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transpose_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.transpose(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.transpose_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer add_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.add_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer add_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.add(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.add_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.negate_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer negate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.negate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.negate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.sub_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer sub_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.sub(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.sub_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer set_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.set_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer set_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double4x4Ops.set(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.set_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double4x4OpsKernelsAddress.setMat3x3_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (dest.hasArray() && m.hasArray()) {
            Double4x4Ops.setMat3x3(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.setMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double4x4OpsKernelsAddress.setMat3x4_unsafe(_destBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer setMat3x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (dest.hasArray() && m.hasArray()) {
            Double4x4Ops.setMat3x4(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.setMat3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double tX, double tY, double tZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, tX, tY, tZ);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double tX, double tY, double tZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.withTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, tX, tY, tZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.withTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, tX, tY, tZ);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t, int tOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _tBase = UnsafeOpsHolder.U.getLong(t, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) tOffset * 8L;
        Double4x4OpsKernelsAddress.withTranslation_unsafe(_destBase, _srcBase, _tBase);
        return dest;
    }

    public static java.nio.DoubleBuffer withTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer t, int tOffset) {
        if (dest.hasArray() && src.hasArray() && t.hasArray()) {
            Double4x4Ops.withTranslation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, t.array(), t.arrayOffset() + tOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.withTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(t.duplicate().position(0)), (long) tOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromRigid_unsafe(java.nio.DoubleBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFromRigid_unsafe(_destBase, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromRigid_api(java.nio.DoubleBuffer dest, int destOffset, double rTX, double rTY, double rTZ, double rRX, double rRY, double rRZ, double rRW) {
        if (dest.hasArray()) {
            Double4x4Ops.makeFromRigid(dest.array(), dest.arrayOffset() + destOffset, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFromRigid_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, rTX, rTY, rTZ, rRX, rRY, rRZ, rRW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromTransform_unsafe(java.nio.DoubleBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFromTransform_unsafe(_destBase, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromTransform_api(java.nio.DoubleBuffer dest, int destOffset, double tTX, double tTY, double tTZ, double tRX, double tRY, double tRZ, double tRW, double tSX, double tSY, double tSZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeFromTransform(dest.array(), dest.arrayOffset() + destOffset, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFromTransform_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, tTX, tTY, tTZ, tRX, tRY, tRZ, tRW, tSX, tSY, tSZ);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.to3x3_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.to3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.to3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.to3x4_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer to3x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.to3x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.to3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer toDualQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.toDualQuat_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toDualQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.toDualQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.toDualQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer toRigid_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.toRigid_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toRigid_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.toRigid(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.toRigid_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer toTransform_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.toTransform_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer toTransform_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.toTransform(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.toTransform_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeRotation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.decomposeRotation_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeRotation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.decomposeRotation(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.decomposeRotation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.decomposeScale_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.decomposeScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.decomposeScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeSkew_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.decomposeSkew_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeSkew_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.decomposeSkew(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.decomposeSkew_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer decomposeTRS_unsafe(java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.decomposeTRS_unsafe(_translationBase, _rotationBase, _scaleBase, _srcBase);
        return translation;
    }

    public static java.nio.DoubleBuffer decomposeTRS_api(java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (translation.hasArray() && rotation.hasArray() && scale.hasArray() && src.hasArray()) {
            Double4x4Ops.decomposeTRS(translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset, src.array(), src.arrayOffset() + srcOffset);
            return translation;
        }
        Double4x4OpsKernelsSegment.decomposeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return translation;
    }

    public static java.nio.DoubleBuffer frustumAabb_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumAabb_no_unsafe(dest, destOffset, src, srcOffset);
        return Double4x4OpsKernelsTypedBuffer.frustumAabb_no_api(dest, destOffset, src, srcOffset);
    }

    public static java.nio.DoubleBuffer frustumAabb_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumAabb_no_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumAabb_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumAabb_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumAabb_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumAabb_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumAabb_zo_unsafe(dest, destOffset, src, srcOffset);
        return Double4x4OpsKernelsTypedBuffer.frustumAabb_zo_api(dest, destOffset, src, srcOffset);
    }

    public static java.nio.DoubleBuffer frustumAabb_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumAabb_zo_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumAabb_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumAabb_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumAabb_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumCorner_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumCorner corner) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumCorner_no_unsafe(dest, destOffset, src, srcOffset, corner);
        return Double4x4OpsKernelsTypedBuffer.frustumCorner_no_api(dest, destOffset, src, srcOffset, corner);
    }

    public static java.nio.DoubleBuffer frustumCorner_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumCorner corner) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumCorner_no_unsafe(_destBase, _srcBase, corner);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumCorner_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumCorner corner) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumCorner_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, corner);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumCorner_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, corner);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumCorner_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumCorner corner) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumCorner_zo_unsafe(dest, destOffset, src, srcOffset, corner);
        return Double4x4OpsKernelsTypedBuffer.frustumCorner_zo_api(dest, destOffset, src, srcOffset, corner);
    }

    public static java.nio.DoubleBuffer frustumCorner_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumCorner corner) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumCorner_zo_unsafe(_destBase, _srcBase, corner);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumCorner_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumCorner corner) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumCorner_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, corner);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumCorner_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, corner);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumPlane_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumPlane plane) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumPlane_no_unsafe(dest, destOffset, src, srcOffset, plane);
        return Double4x4OpsKernelsTypedBuffer.frustumPlane_no_api(dest, destOffset, src, srcOffset, plane);
    }

    public static java.nio.DoubleBuffer frustumPlane_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumPlane plane) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumPlane_no_unsafe(_destBase, _srcBase, plane);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumPlane_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumPlane plane) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumPlane_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumPlane_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, plane);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumPlane_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumPlane plane) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumPlane_zo_unsafe(dest, destOffset, src, srcOffset, plane);
        return Double4x4OpsKernelsTypedBuffer.frustumPlane_zo_api(dest, destOffset, src, srcOffset, plane);
    }

    public static java.nio.DoubleBuffer frustumPlane_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumPlane plane) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumPlane_zo_unsafe(_destBase, _srcBase, plane);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumPlane_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, FrustumPlane plane) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumPlane_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumPlane_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, plane);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumRayDir_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumRayDir_no_unsafe(dest, destOffset, src, srcOffset, x, y);
        return Double4x4OpsKernelsTypedBuffer.frustumRayDir_no_api(dest, destOffset, src, srcOffset, x, y);
    }

    public static java.nio.DoubleBuffer frustumRayDir_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumRayDir_no_unsafe(_destBase, _srcBase, x, y);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumRayDir_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumRayDir_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x, y);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumRayDir_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, x, y);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumRayDir_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustumRayDir_zo_unsafe(dest, destOffset, src, srcOffset, x, y);
        return Double4x4OpsKernelsTypedBuffer.frustumRayDir_zo_api(dest, destOffset, src, srcOffset, x, y);
    }

    public static java.nio.DoubleBuffer frustumRayDir_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustumRayDir_zo_unsafe(_destBase, _srcBase, x, y);
        return dest;
    }

    public static java.nio.DoubleBuffer frustumRayDir_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustumRayDir_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x, y);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustumRayDir_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, x, y);
        return dest;
    }

    public static double testAabb_no(java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.testAabb_no_unsafe(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        return Double4x4OpsKernelsTypedBuffer.testAabb_no_api(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static double testAabb_no_unsafe(java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.testAabb_no_unsafe(_srcBase, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static double testAabb_no_api(java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (src.hasArray()) {
            return Double4x4OpsKernelsArray.testAabb_no(src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        }
        return Double4x4OpsKernelsSegment.testAabb_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static double testAabb_zo(java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.testAabb_zo_unsafe(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        return Double4x4OpsKernelsTypedBuffer.testAabb_zo_api(src, srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static double testAabb_zo_unsafe(java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.testAabb_zo_unsafe(_srcBase, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static double testAabb_zo_api(java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (src.hasArray()) {
            return Double4x4OpsKernelsArray.testAabb_zo(src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
        }
        return Double4x4OpsKernelsSegment.testAabb_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static double testAabb_no(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && min.isDirect() && max.isDirect()) return Double4x4OpsKernelsTypedBuffer.testAabb_no_unsafe(src, srcOffset, min, minOffset, max, maxOffset);
        return Double4x4OpsKernelsTypedBuffer.testAabb_no_api(src, srcOffset, min, minOffset, max, maxOffset);
    }

    public static double testAabb_no_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 8L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 8L;
        return Double4x4OpsKernelsAddress.testAabb_no_unsafe(_srcBase, _minBase, _maxBase);
    }

    public static double testAabb_no_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        if (src.hasArray() && min.hasArray() && max.hasArray()) {
            return Double4x4OpsKernelsArray.testAabb_no(src.array(), src.arrayOffset() + srcOffset, min.array(), min.arrayOffset() + minOffset, max.array(), max.arrayOffset() + maxOffset);
        }
        return Double4x4OpsKernelsSegment.testAabb_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(min.duplicate().position(0)), (long) minOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(max.duplicate().position(0)), (long) maxOffset * 8L);
    }

    public static double testAabb_zo(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && min.isDirect() && max.isDirect()) return Double4x4OpsKernelsTypedBuffer.testAabb_zo_unsafe(src, srcOffset, min, minOffset, max, maxOffset);
        return Double4x4OpsKernelsTypedBuffer.testAabb_zo_api(src, srcOffset, min, minOffset, max, maxOffset);
    }

    public static double testAabb_zo_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _minBase = UnsafeOpsHolder.U.getLong(min, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) minOffset * 8L;
        long _maxBase = UnsafeOpsHolder.U.getLong(max, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) maxOffset * 8L;
        return Double4x4OpsKernelsAddress.testAabb_zo_unsafe(_srcBase, _minBase, _maxBase);
    }

    public static double testAabb_zo_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer min, int minOffset, java.nio.DoubleBuffer max, int maxOffset) {
        if (src.hasArray() && min.hasArray() && max.hasArray()) {
            return Double4x4OpsKernelsArray.testAabb_zo(src.array(), src.arrayOffset() + srcOffset, min.array(), min.arrayOffset() + minOffset, max.array(), max.arrayOffset() + maxOffset);
        }
        return Double4x4OpsKernelsSegment.testAabb_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(min.duplicate().position(0)), (long) minOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(max.duplicate().position(0)), (long) maxOffset * 8L);
    }

    public static double testPoint_no(java.nio.DoubleBuffer src, int srcOffset, double pointX, double pointY, double pointZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.testPoint_no_unsafe(src, srcOffset, pointX, pointY, pointZ);
        return Double4x4OpsKernelsTypedBuffer.testPoint_no_api(src, srcOffset, pointX, pointY, pointZ);
    }

    public static double testPoint_no_unsafe(java.nio.DoubleBuffer src, int srcOffset, double pointX, double pointY, double pointZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.testPoint_no_unsafe(_srcBase, pointX, pointY, pointZ);
    }

    public static double testPoint_no_api(java.nio.DoubleBuffer src, int srcOffset, double pointX, double pointY, double pointZ) {
        if (src.hasArray()) {
            return Double4x4OpsKernelsArray.testPoint_no(src.array(), src.arrayOffset() + srcOffset, pointX, pointY, pointZ);
        }
        return Double4x4OpsKernelsSegment.testPoint_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, pointX, pointY, pointZ);
    }

    public static double testPoint_zo(java.nio.DoubleBuffer src, int srcOffset, double pointX, double pointY, double pointZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.testPoint_zo_unsafe(src, srcOffset, pointX, pointY, pointZ);
        return Double4x4OpsKernelsTypedBuffer.testPoint_zo_api(src, srcOffset, pointX, pointY, pointZ);
    }

    public static double testPoint_zo_unsafe(java.nio.DoubleBuffer src, int srcOffset, double pointX, double pointY, double pointZ) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.testPoint_zo_unsafe(_srcBase, pointX, pointY, pointZ);
    }

    public static double testPoint_zo_api(java.nio.DoubleBuffer src, int srcOffset, double pointX, double pointY, double pointZ) {
        if (src.hasArray()) {
            return Double4x4OpsKernelsArray.testPoint_zo(src.array(), src.arrayOffset() + srcOffset, pointX, pointY, pointZ);
        }
        return Double4x4OpsKernelsSegment.testPoint_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, pointX, pointY, pointZ);
    }

    public static double testPoint_no(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer point, int pointOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && point.isDirect()) return Double4x4OpsKernelsTypedBuffer.testPoint_no_unsafe(src, srcOffset, point, pointOffset);
        return Double4x4OpsKernelsTypedBuffer.testPoint_no_api(src, srcOffset, point, pointOffset);
    }

    public static double testPoint_no_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer point, int pointOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _pointBase = UnsafeOpsHolder.U.getLong(point, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointOffset * 8L;
        return Double4x4OpsKernelsAddress.testPoint_no_unsafe(_srcBase, _pointBase);
    }

    public static double testPoint_no_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer point, int pointOffset) {
        if (src.hasArray() && point.hasArray()) {
            return Double4x4OpsKernelsArray.testPoint_no(src.array(), src.arrayOffset() + srcOffset, point.array(), point.arrayOffset() + pointOffset);
        }
        return Double4x4OpsKernelsSegment.testPoint_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(point.duplicate().position(0)), (long) pointOffset * 8L);
    }

    public static double testPoint_zo(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer point, int pointOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && point.isDirect()) return Double4x4OpsKernelsTypedBuffer.testPoint_zo_unsafe(src, srcOffset, point, pointOffset);
        return Double4x4OpsKernelsTypedBuffer.testPoint_zo_api(src, srcOffset, point, pointOffset);
    }

    public static double testPoint_zo_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer point, int pointOffset) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _pointBase = UnsafeOpsHolder.U.getLong(point, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointOffset * 8L;
        return Double4x4OpsKernelsAddress.testPoint_zo_unsafe(_srcBase, _pointBase);
    }

    public static double testPoint_zo_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer point, int pointOffset) {
        if (src.hasArray() && point.hasArray()) {
            return Double4x4OpsKernelsArray.testPoint_zo(src.array(), src.arrayOffset() + srcOffset, point.array(), point.arrayOffset() + pointOffset);
        }
        return Double4x4OpsKernelsSegment.testPoint_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(point.duplicate().position(0)), (long) pointOffset * 8L);
    }

    public static double testSphere_no(java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double centerZ, double radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.testSphere_no_unsafe(src, srcOffset, centerX, centerY, centerZ, radius);
        return Double4x4OpsKernelsTypedBuffer.testSphere_no_api(src, srcOffset, centerX, centerY, centerZ, radius);
    }

    public static double testSphere_no_unsafe(java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double centerZ, double radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.testSphere_no_unsafe(_srcBase, centerX, centerY, centerZ, radius);
    }

    public static double testSphere_no_api(java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double centerZ, double radius) {
        if (src.hasArray()) {
            return Double4x4OpsKernelsArray.testSphere_no(src.array(), src.arrayOffset() + srcOffset, centerX, centerY, centerZ, radius);
        }
        return Double4x4OpsKernelsSegment.testSphere_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, centerX, centerY, centerZ, radius);
    }

    public static double testSphere_zo(java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double centerZ, double radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.testSphere_zo_unsafe(src, srcOffset, centerX, centerY, centerZ, radius);
        return Double4x4OpsKernelsTypedBuffer.testSphere_zo_api(src, srcOffset, centerX, centerY, centerZ, radius);
    }

    public static double testSphere_zo_unsafe(java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double centerZ, double radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        return Double4x4OpsKernelsAddress.testSphere_zo_unsafe(_srcBase, centerX, centerY, centerZ, radius);
    }

    public static double testSphere_zo_api(java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double centerZ, double radius) {
        if (src.hasArray()) {
            return Double4x4OpsKernelsArray.testSphere_zo(src.array(), src.arrayOffset() + srcOffset, centerX, centerY, centerZ, radius);
        }
        return Double4x4OpsKernelsSegment.testSphere_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, centerX, centerY, centerZ, radius);
    }

    public static double testSphere_no(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && center.isDirect()) return Double4x4OpsKernelsTypedBuffer.testSphere_no_unsafe(src, srcOffset, center, centerOffset, radius);
        return Double4x4OpsKernelsTypedBuffer.testSphere_no_api(src, srcOffset, center, centerOffset, radius);
    }

    public static double testSphere_no_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        return Double4x4OpsKernelsAddress.testSphere_no_unsafe(_srcBase, _centerBase, radius);
    }

    public static double testSphere_no_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius) {
        if (src.hasArray() && center.hasArray()) {
            return Double4x4OpsKernelsArray.testSphere_no(src.array(), src.arrayOffset() + srcOffset, center.array(), center.arrayOffset() + centerOffset, radius);
        }
        return Double4x4OpsKernelsSegment.testSphere_no_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, radius);
    }

    public static double testSphere_zo(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && src.isDirect() && center.isDirect()) return Double4x4OpsKernelsTypedBuffer.testSphere_zo_unsafe(src, srcOffset, center, centerOffset, radius);
        return Double4x4OpsKernelsTypedBuffer.testSphere_zo_api(src, srcOffset, center, centerOffset, radius);
    }

    public static double testSphere_zo_unsafe(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius) {
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        return Double4x4OpsKernelsAddress.testSphere_zo_unsafe(_srcBase, _centerBase, radius);
    }

    public static double testSphere_zo_api(java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius) {
        if (src.hasArray() && center.hasArray()) {
            return Double4x4OpsKernelsArray.testSphere_zo(src.array(), src.arrayOffset() + srcOffset, center.array(), center.arrayOffset() + centerOffset, radius);
        }
        return Double4x4OpsKernelsSegment.testSphere_zo_api(java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, radius);
    }

    public static java.nio.DoubleBuffer makeIdentity_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeIdentity_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeIdentity_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeIdentity(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeIdentity_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.lerp_unsafe(_destBase, _srcBase, _otherBase, t);
        return dest;
    }

    public static java.nio.DoubleBuffer lerp_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset, double t) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.lerp(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset, t);
            return dest;
        }
        Double4x4OpsKernelsSegment.lerp_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L, t);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double4x4OpsKernelsAddress.mul_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double4x4Ops.mul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double4x4OpsKernelsAddress.mulMat2x2_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double4x4Ops.mulMat2x2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mulMat2x2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double4x4OpsKernelsAddress.mulMat2x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat2x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double4x4Ops.mulMat2x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mulMat2x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double4x4OpsKernelsAddress.mulMat3x3_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double4x4Ops.mulMat3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mulMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat3x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rightBase = UnsafeOpsHolder.U.getLong(right, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rightOffset * 8L;
        Double4x4OpsKernelsAddress.mulMat3x4_unsafe(_destBase, _srcBase, _rightBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulMat3x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer right, int rightOffset) {
        if (dest.hasArray() && src.hasArray() && right.hasArray()) {
            Double4x4Ops.mulMat3x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, right.array(), right.arrayOffset() + rightOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mulMat3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(right.duplicate().position(0)), (long) rightOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.preMul_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.preMul(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x2_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.preMulMat2x2_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x2_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.preMulMat2x2(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preMulMat2x2_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.preMulMat2x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat2x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.preMulMat2x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preMulMat2x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat3x3_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.preMulMat3x3_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat3x3_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.preMulMat3x3(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preMulMat3x3_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat3x4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _otherBase = UnsafeOpsHolder.U.getLong(other, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) otherOffset * 8L;
        Double4x4OpsKernelsAddress.preMulMat3x4_unsafe(_destBase, _srcBase, _otherBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preMulMat3x4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer other, int otherOffset) {
        if (dest.hasArray() && src.hasArray() && other.hasArray()) {
            Double4x4Ops.preMulMat3x4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, other.array(), other.arrayOffset() + otherOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preMulMat3x4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(other.duplicate().position(0)), (long) otherOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOuterProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, double colX, double colY, double colZ, double colW, double rowX, double rowY, double rowZ, double rowW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, colX, colY, colZ, colW, rowX, rowY, rowZ, rowW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOuterProduct_api(java.nio.DoubleBuffer dest, int destOffset, double colX, double colY, double colZ, double colW, double rowX, double rowY, double rowZ, double rowW) {
        if (dest.hasArray()) {
            Double4x4Ops.makeOuterProduct(dest.array(), dest.arrayOffset() + destOffset, colX, colY, colZ, colW, rowX, rowY, rowZ, rowW);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOuterProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, colX, colY, colZ, colW, rowX, rowY, rowZ, rowW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOuterProduct_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer col, int colOffset, java.nio.DoubleBuffer row, int rowOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _colBase = UnsafeOpsHolder.U.getLong(col, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) colOffset * 8L;
        long _rowBase = UnsafeOpsHolder.U.getLong(row, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rowOffset * 8L;
        Double4x4OpsKernelsAddress.makeOuterProduct_unsafe(_destBase, _colBase, _rowBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOuterProduct_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer col, int colOffset, java.nio.DoubleBuffer row, int rowOffset) {
        if (dest.hasArray() && col.hasArray() && row.hasArray()) {
            Double4x4Ops.makeOuterProduct(dest.array(), dest.arrayOffset() + destOffset, col.array(), col.arrayOffset() + colOffset, row.array(), row.arrayOffset() + rowOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOuterProduct_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(col.duplicate().position(0)), (long) colOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(row.duplicate().position(0)), (long) rowOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer arcball_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double radius, double centerX, double centerY, double centerZ, double angleX, double angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.arcball_unsafe(_destBase, _srcBase, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer arcball_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double radius, double centerX, double centerY, double centerZ, double angleX, double angleY) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.arcball(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, radius, centerX, centerY, centerZ, angleX, angleY);
            return dest;
        }
        Double4x4OpsKernelsSegment.arcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer arcball_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius, double angleX, double angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        Double4x4OpsKernelsAddress.arcball_unsafe(_destBase, _srcBase, _centerBase, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer arcball_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer center, int centerOffset, double radius, double angleX, double angleY) {
        if (dest.hasArray() && src.hasArray() && center.hasArray()) {
            Double4x4Ops.arcball(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, center.array(), center.arrayOffset() + centerOffset, radius, angleX, angleY);
            return dest;
        }
        Double4x4OpsKernelsSegment.arcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer axonometricDimetric_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.axonometricDimetric_unsafe(_destBase, _srcBase, alpha);
        return dest;
    }

    public static java.nio.DoubleBuffer axonometricDimetric_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double alpha) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.axonometricDimetric(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, alpha);
            return dest;
        }
        Double4x4OpsKernelsSegment.axonometricDimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, alpha);
        return dest;
    }

    public static java.nio.DoubleBuffer axonometricIsometric_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.axonometricIsometric_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer axonometricIsometric_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.axonometricIsometric(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.axonometricIsometric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer axonometricTrimetric_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double alphaX, double alphaY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.axonometricTrimetric_unsafe(_destBase, _srcBase, alphaX, alphaY);
        return dest;
    }

    public static java.nio.DoubleBuffer axonometricTrimetric_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double alphaX, double alphaY) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.axonometricTrimetric(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, alphaX, alphaY);
            return dest;
        }
        Double4x4OpsKernelsSegment.axonometricTrimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, alphaX, alphaY);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_unsafe(java.nio.DoubleBuffer dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.composeTRS_unsafe(_destBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_api(java.nio.DoubleBuffer dest, int destOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.composeTRS(dest.array(), dest.arrayOffset() + destOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.composeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        Double4x4OpsKernelsAddress.composeTRS_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRS_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset) {
        if (dest.hasArray() && translation.hasArray() && rotation.hasArray() && scale.hasArray()) {
            Double4x4Ops.composeTRS(dest.array(), dest.arrayOffset() + destOffset, translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.composeTRS_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double4x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _mBase, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer m, int mOffset, double translationX, double translationY, double translationZ, double rotationX, double rotationY, double rotationZ, double rotationW, double scaleX, double scaleY, double scaleZ) {
        if (dest.hasArray() && m.hasArray()) {
            Double4x4Ops.composeTRSMul(dest.array(), dest.arrayOffset() + destOffset, m.array(), m.arrayOffset() + mOffset, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.composeTRSMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L, translationX, translationY, translationZ, rotationX, rotationY, rotationZ, rotationW, scaleX, scaleY, scaleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _translationBase = UnsafeOpsHolder.U.getLong(translation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) translationOffset * 8L;
        long _rotationBase = UnsafeOpsHolder.U.getLong(rotation, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotationOffset * 8L;
        long _scaleBase = UnsafeOpsHolder.U.getLong(scale, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) scaleOffset * 8L;
        long _mBase = UnsafeOpsHolder.U.getLong(m, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) mOffset * 8L;
        Double4x4OpsKernelsAddress.composeTRSMul_unsafe(_destBase, _translationBase, _rotationBase, _scaleBase, _mBase);
        return dest;
    }

    public static java.nio.DoubleBuffer composeTRSMul_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer translation, int translationOffset, java.nio.DoubleBuffer rotation, int rotationOffset, java.nio.DoubleBuffer scale, int scaleOffset, java.nio.DoubleBuffer m, int mOffset) {
        if (dest.hasArray() && translation.hasArray() && rotation.hasArray() && scale.hasArray() && m.hasArray()) {
            Double4x4Ops.composeTRSMul(dest.array(), dest.arrayOffset() + destOffset, translation.array(), translation.arrayOffset() + translationOffset, rotation.array(), rotation.arrayOffset() + rotationOffset, scale.array(), scale.arrayOffset() + scaleOffset, m.array(), m.arrayOffset() + mOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.composeTRSMul_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(translation.duplicate().position(0)), (long) translationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rotation.duplicate().position(0)), (long) rotationOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(scale.duplicate().position(0)), (long) scaleOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(m.duplicate().position(0)), (long) mOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustum_no_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.frustum_no_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer frustum_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustum_no_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustum_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustum_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustum_no_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.frustum_no_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer frustum_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustum_no_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustum_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustum_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.frustum_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.frustum_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer frustum_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustum_zo_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.frustum_zo_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer frustum_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustum_zo_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustum_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustum_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.frustum_zo_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.frustum_zo_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer frustum_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.frustum_zo_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.frustum_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.frustum_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer frustum_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.frustum_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.frustum_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer lookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.lookAlong(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, dirX, dirY, dirZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.lookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.lookAlong_unsafe(_destBase, _srcBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && dir.hasArray() && up.hasArray()) {
            Double4x4Ops.lookAlong(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, dir.array(), dir.arrayOffset() + dirOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.lookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(dir.duplicate().position(0)), (long) dirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double4x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer lookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.lookAt_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.lookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double4x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer lookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.lookAt_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.lookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double4x4OpsKernelsTypedBuffer.lookAt_lh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double4x4OpsKernelsTypedBuffer.lookAt_lh_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer lookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.lookAt_lh_unsafe(_destBase, _srcBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double4x4OpsKernelsArray.lookAt_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.lookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double4x4OpsKernelsTypedBuffer.lookAt_rh_unsafe(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double4x4OpsKernelsTypedBuffer.lookAt_rh_api(dest, destOffset, src, srcOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer lookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.lookAt_rh_unsafe(_destBase, _srcBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer lookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && src.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double4x4OpsKernelsArray.lookAt_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.lookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeArcball_unsafe(java.nio.DoubleBuffer dest, int destOffset, double radius, double centerX, double centerY, double centerZ, double angleX, double angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeArcball_unsafe(_destBase, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer makeArcball_api(java.nio.DoubleBuffer dest, int destOffset, double radius, double centerX, double centerY, double centerZ, double angleX, double angleY) {
        if (dest.hasArray()) {
            Double4x4Ops.makeArcball(dest.array(), dest.arrayOffset() + destOffset, radius, centerX, centerY, centerZ, angleX, angleY);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeArcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, radius, centerX, centerY, centerZ, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer makeArcball_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer center, int centerOffset, double radius, double angleX, double angleY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        Double4x4OpsKernelsAddress.makeArcball_unsafe(_destBase, _centerBase, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer makeArcball_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer center, int centerOffset, double radius, double angleX, double angleY) {
        if (dest.hasArray() && center.hasArray()) {
            Double4x4Ops.makeArcball(dest.array(), dest.arrayOffset() + destOffset, center.array(), center.arrayOffset() + centerOffset, radius, angleX, angleY);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeArcball_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, radius, angleX, angleY);
        return dest;
    }

    public static java.nio.DoubleBuffer makeAxonometricDimetric_unsafe(java.nio.DoubleBuffer dest, int destOffset, double alpha) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeAxonometricDimetric_unsafe(_destBase, alpha);
        return dest;
    }

    public static java.nio.DoubleBuffer makeAxonometricDimetric_api(java.nio.DoubleBuffer dest, int destOffset, double alpha) {
        if (dest.hasArray()) {
            Double4x4Ops.makeAxonometricDimetric(dest.array(), dest.arrayOffset() + destOffset, alpha);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeAxonometricDimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, alpha);
        return dest;
    }

    public static java.nio.DoubleBuffer makeAxonometricIsometric_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeAxonometricIsometric_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeAxonometricIsometric_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeAxonometricIsometric(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeAxonometricIsometric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeAxonometricTrimetric_unsafe(java.nio.DoubleBuffer dest, int destOffset, double alphaX, double alphaY) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeAxonometricTrimetric_unsafe(_destBase, alphaX, alphaY);
        return dest;
    }

    public static java.nio.DoubleBuffer makeAxonometricTrimetric_api(java.nio.DoubleBuffer dest, int destOffset, double alphaX, double alphaY) {
        if (dest.hasArray()) {
            Double4x4Ops.makeAxonometricTrimetric(dest.array(), dest.arrayOffset() + destOffset, alphaX, alphaY);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeAxonometricTrimetric_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, alphaX, alphaY);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeBillboardCylindrical(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeBillboardCylindrical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 8L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.makeBillboardCylindrical_unsafe(_destBase, _objPosBase, _targetPosBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardCylindrical_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray() && up.hasArray()) {
            Double4x4Ops.makeBillboardCylindrical(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeBillboardCylindrical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeBillboardSpherical(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeBillboardSpherical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 8L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.makeBillboardSpherical_unsafe(_destBase, _objPosBase, _targetPosBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSpherical_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray() && up.hasArray()) {
            Double4x4Ops.makeBillboardSpherical(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeBillboardSpherical_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_unsafe(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_api(java.nio.DoubleBuffer dest, int destOffset, double objPosX, double objPosY, double objPosZ, double targetPosX, double targetPosY, double targetPosZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeBillboardSphericalShortest(dest.array(), dest.arrayOffset() + destOffset, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeBillboardSphericalShortest_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, objPosX, objPosY, objPosZ, targetPosX, targetPosY, targetPosZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _objPosBase = UnsafeOpsHolder.U.getLong(objPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objPosOffset * 8L;
        long _targetPosBase = UnsafeOpsHolder.U.getLong(targetPos, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) targetPosOffset * 8L;
        Double4x4OpsKernelsAddress.makeBillboardSphericalShortest_unsafe(_destBase, _objPosBase, _targetPosBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeBillboardSphericalShortest_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer objPos, int objPosOffset, java.nio.DoubleBuffer targetPos, int targetPosOffset) {
        if (dest.hasArray() && objPos.hasArray() && targetPos.hasArray()) {
            Double4x4Ops.makeBillboardSphericalShortest(dest.array(), dest.arrayOffset() + destOffset, objPos.array(), objPos.arrayOffset() + objPosOffset, targetPos.array(), targetPos.arrayOffset() + targetPosOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeBillboardSphericalShortest_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(objPos.duplicate().position(0)), (long) objPosOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(targetPos.duplicate().position(0)), (long) targetPosOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromDualQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFromDualQuat_unsafe(_destBase, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFromDualQuat_api(java.nio.DoubleBuffer dest, int destOffset, double dqRX, double dqRY, double dqRZ, double dqRW, double dqDX, double dqDY, double dqDZ, double dqDW) {
        if (dest.hasArray()) {
            Double4x4Ops.makeFromDualQuat(dest.array(), dest.arrayOffset() + destOffset, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFromDualQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, dqRX, dqRY, dqRZ, dqRW, dqDX, dqDY, dqDZ, dqDW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_no_lh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeFrustum_no_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeFrustum_no_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeFrustum_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFrustum_no_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeFrustum_no_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFrustum_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_no_rh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeFrustum_no_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeFrustum_no_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeFrustum_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFrustum_no_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeFrustum_no_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFrustum_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_no(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makeFrustum_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makeFrustum_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer makeFrustum_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeFrustum_zo_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeFrustum_zo_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeFrustum_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFrustum_zo_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeFrustum_zo_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFrustum_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeFrustum_zo_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeFrustum_zo_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeFrustum_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeFrustum_zo_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeFrustum_zo_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeFrustum_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeFrustum_zo(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makeFrustum_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makeFrustum_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer makeLookAt_lh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double4x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeLookAt_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeLookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return Double4x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double centerX, double centerY, double centerZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeLookAt_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeLookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double4x4OpsKernelsTypedBuffer.makeLookAt_lh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double4x4OpsKernelsTypedBuffer.makeLookAt_lh_api(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.makeLookAt_lh_unsafe(_destBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double4x4OpsKernelsArray.makeLookAt_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeLookAt_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && center.isDirect() && up.isDirect()) return Double4x4OpsKernelsTypedBuffer.makeLookAt_rh_unsafe(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
        return Double4x4OpsKernelsTypedBuffer.makeLookAt_rh_api(dest, destOffset, eye, eyeOffset, center, centerOffset, up, upOffset);
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _centerBase = UnsafeOpsHolder.U.getLong(center, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) centerOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.makeLookAt_rh_unsafe(_destBase, _eyeBase, _centerBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeLookAt_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer center, int centerOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && eye.hasArray() && center.hasArray() && up.hasArray()) {
            Double4x4OpsKernelsArray.makeLookAt_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, center.array(), center.arrayOffset() + centerOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeLookAt_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(center.duplicate().position(0)), (long) centerOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXnYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXnYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXnZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingXnZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingXnZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYnXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYnXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYnZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingYnZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingYnZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZnXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZnXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZnYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingZnYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingZnYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXnYZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXnYZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXnYnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXnYnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXnZY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXnZY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnXnZnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnXnZnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnXnZnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYnXZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYnXZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYnXnZ_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYnXnZ(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYnZX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYnZX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnYnZnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnYnZnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnYnZnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZnXY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZnXY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZnXnY_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnXnY_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZnXnY(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZnYX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZnYX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeMappingnZnYnX_unsafe(_destBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeMappingnZnYnX_api(java.nio.DoubleBuffer dest, int destOffset) {
        if (dest.hasArray()) {
            Double4x4Ops.makeMappingnZnYnX(dest.array(), dest.arrayOffset() + destOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeMappingnZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeObliqueCabinet_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeObliqueCabinet_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeObliqueCabinet_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double4x4Ops.makeObliqueCabinet(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeObliqueCabinet_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeObliqueCavalier_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeObliqueCavalier_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeObliqueCavalier_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double4x4Ops.makeObliqueCavalier(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeObliqueCavalier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeObliqueMilitary_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeObliqueMilitary_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeObliqueMilitary_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double4x4Ops.makeObliqueMilitary(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeObliqueMilitary_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_no_lh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho_no_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho_no_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeOrtho_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho_no_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho_no_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_no_rh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho_no_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho_no_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeOrtho_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho_no_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho_no_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_no(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer makeOrtho_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho_zo_lh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho_zo_lh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeOrtho_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho_zo_lh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho_zo_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho_zo_rh_unsafe(dest, destOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho_zo_rh_api(dest, destOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer makeOrtho_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho_zo_rh_unsafe(_destBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho_zo_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho_zo(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no_lh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_no_lh_unsafe(dest, destOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_no_lh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho2D_no_lh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho2D_no_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho2D_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no_rh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_no_rh_unsafe(dest, destOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_no_rh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho2D_no_rh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho2D_no_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho2D_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_no(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_no_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_no_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_lh_unsafe(dest, destOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_lh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho2D_zo_lh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho2D_zo_lh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho2D_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_rh_unsafe(dest, destOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_rh_api(dest, destOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeOrtho2D_zo_rh_unsafe(_destBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makeOrtho2D_zo_rh(dest.array(), dest.arrayOffset() + destOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeOrtho2D_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer makeOrtho2D_zo(java.nio.DoubleBuffer dest, int destOffset, double left, double right, double bottom, double top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makeOrtho2D_zo_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.DoubleBuffer makePerspective_no_lh(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspective_no_lh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspective_no_lh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspective_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspective_no_lh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspective_no_lh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspective_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_no_rh(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspective_no_rh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspective_no_rh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspective_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspective_no_rh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspective_no_rh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspective_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_no(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspective_no_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspective_no_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer makePerspective_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspective_zo_lh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspective_zo_lh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspective_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspective_zo_lh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspective_zo_lh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspective_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspective_zo_rh_unsafe(dest, destOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspective_zo_rh_api(dest, destOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspective_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspective_zo_rh_unsafe(_destBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspective_zo_rh(dest.array(), dest.arrayOffset() + destOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspective_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspective_zo(java.nio.DoubleBuffer dest, int destOffset, double fovy, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspective_zo_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspective_zo_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no_lh(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_lh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_lh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveFovRange_no_lh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveFovRange_no_lh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveFovRange_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no_rh(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_rh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_rh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveFovRange_no_rh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveFovRange_no_rh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveFovRange_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_no(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_no_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_lh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_lh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveFovRange_zo_lh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveFovRange_zo_lh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveFovRange_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_rh_unsafe(dest, destOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_rh_api(dest, destOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveFovRange_zo_rh_unsafe(_destBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveFovRange_zo_rh(dest.array(), dest.arrayOffset() + destOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveFovRange_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveFovRange_zo(java.nio.DoubleBuffer dest, int destOffset, double angleMin, double angleMax, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveFovRange_zo_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no_lh(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_lh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_lh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterFov_no_lh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_lh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterFov_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no_rh(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_rh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_rh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterFov_no_rh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_rh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterFov_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_no(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_no_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_lh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_lh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterFov_zo_lh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_lh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterFov_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_rh_unsafe(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_rh_api(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterFov_zo_rh_unsafe(_destBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_rh(dest.array(), dest.arrayOffset() + destOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterFov_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterFov_zo(java.nio.DoubleBuffer dest, int destOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterFov_zo_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_lh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_rh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_lh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_rh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ, double nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_lh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_no_rh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_lh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleProj_zo_rh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset, nearFarDist);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleProj_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L, nearFarDist);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleProj_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset, double nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_lh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_lh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_lh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_lh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_rh(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_unsafe(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_api(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_rh_unsafe(_destBase, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_rh_api(java.nio.DoubleBuffer dest, int destOffset, double eyeX, double eyeY, double eyeZ, double pX, double pY, double pZ, double xX, double xY, double xZ, double yX, double yY, double yZ) {
        if (dest.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_rh(dest.array(), dest.arrayOffset() + destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_lh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_lh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_lh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && eye.isDirect() && p.isDirect() && x.isDirect() && y.isDirect()) return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_unsafe(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
        return Double4x4OpsKernelsTypedBuffer.makePerspectiveOffCenterRectangleView_rh_api(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset);
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _eyeBase = UnsafeOpsHolder.U.getLong(eye, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) eyeOffset * 8L;
        long _pBase = UnsafeOpsHolder.U.getLong(p, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pOffset * 8L;
        long _xBase = UnsafeOpsHolder.U.getLong(x, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) xOffset * 8L;
        long _yBase = UnsafeOpsHolder.U.getLong(y, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) yOffset * 8L;
        Double4x4OpsKernelsAddress.makePerspectiveOffCenterRectangleView_rh_unsafe(_destBase, _eyeBase, _pBase, _xBase, _yBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makePerspectiveOffCenterRectangleView_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer eye, int eyeOffset, java.nio.DoubleBuffer p, int pOffset, java.nio.DoubleBuffer x, int xOffset, java.nio.DoubleBuffer y, int yOffset) {
        if (dest.hasArray() && eye.hasArray() && p.hasArray() && x.hasArray() && y.hasArray()) {
            Double4x4OpsKernelsArray.makePerspectiveOffCenterRectangleView_rh(dest.array(), dest.arrayOffset() + destOffset, eye.array(), eye.arrayOffset() + eyeOffset, p.array(), p.arrayOffset() + pOffset, x.array(), x.arrayOffset() + xOffset, y.array(), y.arrayOffset() + yOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePerspectiveOffCenterRectangleView_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(eye.duplicate().position(0)), (long) eyeOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p.duplicate().position(0)), (long) pOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(x.duplicate().position(0)), (long) xOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(y.duplicate().position(0)), (long) yOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makePickMatrix_unsafe(java.nio.DoubleBuffer dest, int destOffset, double centerX, double centerY, double deltaX, double deltaY, double vpX, double vpY, double vpW, double vpH) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makePickMatrix_unsafe(_destBase, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.DoubleBuffer makePickMatrix_api(java.nio.DoubleBuffer dest, int destOffset, double centerX, double centerY, double deltaX, double deltaY, double vpX, double vpY, double vpW, double vpH) {
        if (dest.hasArray()) {
            Double4x4Ops.makePickMatrix(dest.array(), dest.arrayOffset() + destOffset, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
            return dest;
        }
        Double4x4OpsKernelsSegment.makePickMatrix_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_unsafe(java.nio.DoubleBuffer dest, int destOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeReflection_unsafe(_destBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_api(java.nio.DoubleBuffer dest, int destOffset, double normalX, double normalY, double normalZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeReflection(dest.array(), dest.arrayOffset() + destOffset, normalX, normalY, normalZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeReflection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double4x4OpsKernelsAddress.makeReflection_unsafe(_destBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeReflection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        if (dest.hasArray() && normal.hasArray()) {
            Double4x4Ops.makeReflection(dest.array(), dest.arrayOffset() + destOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeReflection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_api(java.nio.DoubleBuffer dest, int destOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationAxis(dest.array(), dest.arrayOffset() + destOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationAxis_unsafe(_destBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && axis.hasArray()) {
            Double4x4Ops.makeRotationAxis(dest.array(), dest.arrayOffset() + destOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_api(java.nio.DoubleBuffer dest, int destOffset, double dirX, double dirY, double dirZ, double upX, double upY, double upZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationLookAlong(dest.array(), dest.arrayOffset() + destOffset, dirX, dirY, dirZ, upX, upY, upZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationLookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, dirX, dirY, dirZ, upX, upY, upZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _dirBase = UnsafeOpsHolder.U.getLong(dir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) dirOffset * 8L;
        long _upBase = UnsafeOpsHolder.U.getLong(up, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) upOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationLookAlong_unsafe(_destBase, _dirBase, _upBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationLookAlong_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer dir, int dirOffset, java.nio.DoubleBuffer up, int upOffset) {
        if (dest.hasArray() && dir.hasArray() && up.hasArray()) {
            Double4x4Ops.makeRotationLookAlong(dest.array(), dest.arrayOffset() + destOffset, dir.array(), dir.arrayOffset() + dirOffset, up.array(), up.arrayOffset() + upOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationLookAlong_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(dir.duplicate().position(0)), (long) dirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(up.duplicate().position(0)), (long) upOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_api(java.nio.DoubleBuffer dest, int destOffset, double qX, double qY, double qZ, double qW) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationQuat(dest.array(), dest.arrayOffset() + destOffset, qX, qY, qZ, qW);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationQuat_unsafe(_destBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (dest.hasArray() && q.hasArray()) {
            Double4x4Ops.makeRotationQuat(dest.array(), dest.arrayOffset() + destOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationX_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationX_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationX(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationXYZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXYZ_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationXYZ(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationXZY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationXZY_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationXZY(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationY_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationY_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationY(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationYXZ_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYXZ_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationYXZ(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationYZX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationYZX_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationYZX(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationZ_unsafe(_destBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZ_api(java.nio.DoubleBuffer dest, int destOffset, double angle) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationZ(dest.array(), dest.arrayOffset() + destOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationZXY_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZXY_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationZXY(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeRotationZYX_unsafe(_destBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeRotationZYX_api(java.nio.DoubleBuffer dest, int destOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeRotationZYX(dest.array(), dest.arrayOffset() + destOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeRotationZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeScaling_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.makeScaling_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double4x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_unsafe(java.nio.DoubleBuffer dest, int destOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeScaling_unsafe(_destBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeScaling_api(java.nio.DoubleBuffer dest, int destOffset, double s) {
        if (dest.hasArray()) {
            Double4x4Ops.makeScaling(dest.array(), dest.arrayOffset() + destOffset, s);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeScaling_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer makeShadow_unsafe(java.nio.DoubleBuffer dest, int destOffset, double lightX, double lightY, double lightZ, double lightW, double planeX, double planeY, double planeZ, double planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeShadow_unsafe(_destBase, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeShadow_api(java.nio.DoubleBuffer dest, int destOffset, double lightX, double lightY, double lightZ, double lightW, double planeX, double planeY, double planeZ, double planeW) {
        if (dest.hasArray()) {
            Double4x4Ops.makeShadow(dest.array(), dest.arrayOffset() + destOffset, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeShadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer makeShadow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer light, int lightOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _lightBase = UnsafeOpsHolder.U.getLong(light, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) lightOffset * 8L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 8L;
        Double4x4OpsKernelsAddress.makeShadow_unsafe(_destBase, _lightBase, _planeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeShadow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer light, int lightOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (dest.hasArray() && light.hasArray() && plane.hasArray()) {
            Double4x4Ops.makeShadow(dest.array(), dest.arrayOffset() + destOffset, light.array(), light.arrayOffset() + lightOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeShadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(light.duplicate().position(0)), (long) lightOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeShear_unsafe(java.nio.DoubleBuffer dest, int destOffset, double xy, double xz, double yx, double yz, double zx, double zy) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeShear_unsafe(_destBase, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.DoubleBuffer makeShear_api(java.nio.DoubleBuffer dest, int destOffset, double xy, double xz, double yx, double yz, double zx, double zy) {
        if (dest.hasArray()) {
            Double4x4Ops.makeShear(dest.array(), dest.arrayOffset() + destOffset, xy, xz, yx, yz, zx, zy);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeShear_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTile_unsafe(java.nio.DoubleBuffer dest, int destOffset, double x, double y, double w, double h) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeTile_unsafe(_destBase, x, y, w, h);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTile_api(java.nio.DoubleBuffer dest, int destOffset, double x, double y, double w, double h) {
        if (dest.hasArray()) {
            Double4x4Ops.makeTile(dest.array(), dest.arrayOffset() + destOffset, x, y, w, h);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeTile_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, x, y, w, h);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_api(java.nio.DoubleBuffer dest, int destOffset, double vX, double vY, double vZ) {
        if (dest.hasArray()) {
            Double4x4Ops.makeTranslation(dest.array(), dest.arrayOffset() + destOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.makeTranslation_unsafe(_destBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTranslation_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && v.hasArray()) {
            Double4x4Ops.makeTranslation(dest.array(), dest.arrayOffset() + destOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeTranslation_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTrapezoidCrop_unsafe(java.nio.DoubleBuffer dest, int destOffset, double p0X, double p0Y, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        Double4x4OpsKernelsAddress.makeTrapezoidCrop_unsafe(_destBase, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTrapezoidCrop_api(java.nio.DoubleBuffer dest, int destOffset, double p0X, double p0Y, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y) {
        if (dest.hasArray()) {
            Double4x4Ops.makeTrapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeTrapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTrapezoidCrop_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer p0, int p0Offset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _p0Base = UnsafeOpsHolder.U.getLong(p0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p0Offset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double4x4OpsKernelsAddress.makeTrapezoidCrop_unsafe(_destBase, _p0Base, _p1Base, _p2Base, _p3Base);
        return dest;
    }

    public static java.nio.DoubleBuffer makeTrapezoidCrop_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer p0, int p0Offset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset) {
        if (dest.hasArray() && p0.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Double4x4Ops.makeTrapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, p0.array(), p0.arrayOffset() + p0Offset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset);
            return dest;
        }
        Double4x4OpsKernelsSegment.makeTrapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p0.duplicate().position(0)), (long) p0Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXnYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXnYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXnZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapXnZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapXnZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYnXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYnXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYnZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapYnZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapYnZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZnXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZnXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZnYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapZnYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapZnYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXnYZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXnYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXnYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXnYnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnYnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXnYnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXnYnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXnZY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXnZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXnZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnXnZnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnXnZnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnXnZnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnXnZnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYnXZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYnXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYnXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXnZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYnXnZ_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnXnZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYnXnZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYnXnZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYnZX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYnZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYnZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnYnZnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnYnZnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnYnZnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnYnZnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZnXY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZnXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZnXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXnY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZnXnY_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnXnY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZnXnY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZnXnY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZnYX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZnYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZnYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYnX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mapnZnYnX_unsafe(_destBase, _srcBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mapnZnYnX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mapnZnYnX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mapnZnYnX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueCabinet_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueCabinet_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueCabinet_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.obliqueCabinet(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueCabinet_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueCavalier_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueCavalier_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueCavalier_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.obliqueCavalier(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueCavalier_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueMilitary_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueMilitary_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueMilitary_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.obliqueMilitary(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueMilitary_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_lh_unsafe(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_lh_api(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
    }

    public static java.nio.DoubleBuffer obliqueZ_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_no_lh_unsafe(_destBase, _srcBase, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_rh_unsafe(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_rh_api(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
    }

    public static java.nio.DoubleBuffer obliqueZ_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_no_rh_unsafe(_destBase, _srcBase, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_lh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
            default -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_rh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
        }
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_lh_unsafe(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_lh_api(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_zo_lh_unsafe(_destBase, _srcBase, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_rh_unsafe(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_rh_api(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW);
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_zo_rh_unsafe(_destBase, _srcBase, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double planeX, double planeY, double planeZ, double planeW, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_lh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
            default -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_rh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
        }
    }

    public static java.nio.DoubleBuffer obliqueZ_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && plane.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_lh_unsafe(dest, destOffset, src, srcOffset, plane, planeOffset);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_lh_api(dest, destOffset, src, srcOffset, plane, planeOffset);
    }

    public static java.nio.DoubleBuffer obliqueZ_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_no_lh_unsafe(_destBase, _srcBase, _planeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && plane.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && plane.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_rh_unsafe(dest, destOffset, src, srcOffset, plane, planeOffset);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_rh_api(dest, destOffset, src, srcOffset, plane, planeOffset);
    }

    public static java.nio.DoubleBuffer obliqueZ_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_no_rh_unsafe(_destBase, _srcBase, _planeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && plane.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_lh(dest, destOffset, src, srcOffset, plane, planeOffset); }
            default -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_no_rh(dest, destOffset, src, srcOffset, plane, planeOffset); }
        }
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && plane.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_lh_unsafe(dest, destOffset, src, srcOffset, plane, planeOffset);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_lh_api(dest, destOffset, src, srcOffset, plane, planeOffset);
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_zo_lh_unsafe(_destBase, _srcBase, _planeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && plane.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && plane.isDirect()) return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_rh_unsafe(dest, destOffset, src, srcOffset, plane, planeOffset);
        return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_rh_api(dest, destOffset, src, srcOffset, plane, planeOffset);
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 8L;
        Double4x4OpsKernelsAddress.obliqueZ_zo_rh_unsafe(_destBase, _srcBase, _planeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && plane.hasArray()) {
            Double4x4OpsKernelsArray.obliqueZ_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.obliqueZ_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer obliqueZ_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer plane, int planeOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_lh(dest, destOffset, src, srcOffset, plane, planeOffset); }
            default -> { return Double4x4OpsKernelsTypedBuffer.obliqueZ_zo_rh(dest, destOffset, src, srcOffset, plane, planeOffset); }
        }
    }

    public static java.nio.DoubleBuffer ortho_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho_no_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.ortho_no_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer ortho_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho_no_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho_no_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.ortho_no_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer ortho_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho_no_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.ortho_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.ortho_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer ortho_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho_zo_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.ortho_zo_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer ortho_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho_zo_lh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho_zo_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
        return Double4x4OpsKernelsTypedBuffer.ortho_zo_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar);
    }

    public static java.nio.DoubleBuffer ortho_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho_zo_rh_unsafe(_destBase, _srcBase, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top, zNear, zFar);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top, zNear, zFar);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, double zNear, double zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.ortho_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Double4x4OpsKernelsTypedBuffer.ortho_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static java.nio.DoubleBuffer ortho2D_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho2D_no_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.ortho2D_no_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer ortho2D_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho2D_no_lh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho2D_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho2D_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho2D_no_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.ortho2D_no_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer ortho2D_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho2D_no_rh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho2D_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho2D_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.ortho2D_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Double4x4OpsKernelsTypedBuffer.ortho2D_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.DoubleBuffer ortho2D_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho2D_zo_lh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.ortho2D_zo_lh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer ortho2D_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho2D_zo_lh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho2D_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho2D_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.ortho2D_zo_rh_unsafe(dest, destOffset, src, srcOffset, left, right, bottom, top);
        return Double4x4OpsKernelsTypedBuffer.ortho2D_zo_rh_api(dest, destOffset, src, srcOffset, left, right, bottom, top);
    }

    public static java.nio.DoubleBuffer ortho2D_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.ortho2D_zo_rh_unsafe(_destBase, _srcBase, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.ortho2D_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, left, right, bottom, top);
            return dest;
        }
        Double4x4OpsKernelsSegment.ortho2D_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, left, right, bottom, top);
        return dest;
    }

    public static java.nio.DoubleBuffer ortho2D_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double left, double right, double bottom, double top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.ortho2D_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Double4x4OpsKernelsTypedBuffer.ortho2D_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static java.nio.DoubleBuffer orthoCrop_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.DoubleBuffer orthoCrop_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_no_lh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.DoubleBuffer orthoCrop_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_no_rh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_zo_lh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_api(dest, destOffset, src, srcOffset, view, viewOffset);
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_zo_rh_unsafe(_destBase, _srcBase, _viewBase);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static java.nio.DoubleBuffer orthoCrop_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_lh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.DoubleBuffer orthoCrop_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_no_lh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_rh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.DoubleBuffer orthoCrop_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_no_rh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_zo_lh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && view.isDirect()) return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_unsafe(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
        return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh_api(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ);
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _viewBase = UnsafeOpsHolder.U.getLong(view, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewOffset * 8L;
        Double4x4OpsKernelsAddress.orthoCrop_zo_rh_unsafe(_destBase, _srcBase, _viewBase, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ) {
        if (dest.hasArray() && src.hasArray() && view.hasArray()) {
            Double4x4OpsKernelsArray.orthoCrop_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, view.array(), view.arrayOffset() + viewOffset, minZ, maxZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.orthoCrop_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(view.duplicate().position(0)), (long) viewOffset * 8L, minZ, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer orthoCrop_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer view, int viewOffset, double minZ, double maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Double4x4OpsKernelsTypedBuffer.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static java.nio.DoubleBuffer perspective_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspective_no_lh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspective_no_lh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspective_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspective_no_lh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspective_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspective_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspective_no_rh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspective_no_rh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspective_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspective_no_rh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspective_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspective_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspective_no_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspective_no_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspective_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspective_zo_lh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspective_zo_lh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspective_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspective_zo_lh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspective_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspective_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspective_zo_rh_unsafe(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspective_zo_rh_api(dest, destOffset, src, srcOffset, fovy, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspective_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspective_zo_rh_unsafe(_destBase, _srcBase, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspective_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, fovy, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspective_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, fovy, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspective_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double fovy, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspective_zo_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspective_zo_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_lh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_lh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFovRange_no_lh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFovRange_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFovRange_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_rh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_rh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFovRange_no_rh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFovRange_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFovRange_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_no_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_lh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_lh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFovRange_zo_lh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFovRange_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFovRange_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_rh_unsafe(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_rh_api(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFovRange_zo_rh_unsafe(_destBase, _srcBase, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFovRange_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleMin, angleMax, aspect, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFovRange_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleMin, angleMax, aspect, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFovRange_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleMin, double angleMax, double aspect, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFovRange_zo_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_lh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_lh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFrustumSlice_no_lh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFrustumSlice_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFrustumSlice_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_rh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_rh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFrustumSlice_no_rh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFrustumSlice_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFrustumSlice_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_no_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_lh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_lh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFrustumSlice_zo_lh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFrustumSlice_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFrustumSlice_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_rh_unsafe(dest, destOffset, src, srcOffset, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_rh_api(dest, destOffset, src, srcOffset, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveFrustumSlice_zo_rh_unsafe(_destBase, _srcBase, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveFrustumSlice_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveFrustumSlice_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveFrustumSlice_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspectiveFrustumSlice_zo_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_lh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_lh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveOffCenterFov_no_lh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveOffCenterFov_no_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveOffCenterFov_no_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_rh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_rh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveOffCenterFov_no_rh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveOffCenterFov_no_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveOffCenterFov_no_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_no_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo_lh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_lh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_lh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo_lh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveOffCenterFov_zo_lh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo_lh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveOffCenterFov_zo_lh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveOffCenterFov_zo_lh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo_rh(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_rh_unsafe(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
        return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_rh_api(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo_rh_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.perspectiveOffCenterFov_zo_rh_unsafe(_destBase, _srcBase, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo_rh_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.perspectiveOffCenterFov_zo_rh(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far);
            return dest;
        }
        Double4x4OpsKernelsSegment.perspectiveOffCenterFov_zo_rh_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleLeft, angleRight, angleDown, angleUp, near, far);
        return dest;
    }

    public static java.nio.DoubleBuffer perspectiveOffCenterFov_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleLeft, double angleRight, double angleDown, double angleUp, double near, double far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Double4x4OpsKernelsTypedBuffer.perspectiveOffCenterFov_zo_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static java.nio.DoubleBuffer pickMatrix_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double deltaX, double deltaY, double vpX, double vpY, double vpW, double vpH) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.pickMatrix_unsafe(_destBase, _srcBase, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.DoubleBuffer pickMatrix_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double centerX, double centerY, double deltaX, double deltaY, double vpX, double vpY, double vpW, double vpH) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.pickMatrix(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
            return dest;
        }
        Double4x4OpsKernelsSegment.pickMatrix_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, centerX, centerY, deltaX, deltaY, vpX, vpY, vpW, vpH);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preRotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rotBase = UnsafeOpsHolder.U.getLong(rot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateAround_unsafe(_destBase, _srcBase, _rotBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && rot.hasArray() && pivot.hasArray()) {
            Double4x4Ops.preRotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rot.array(), rot.arrayOffset() + rotOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rot.duplicate().position(0)), (long) rotOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preRotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Double4x4Ops.preRotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preRotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, qX, qY, qZ, qW);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateQuat_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (dest.hasArray() && src.hasArray() && q.hasArray()) {
            Double4x4Ops.preRotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preRotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preRotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preRotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preRotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preRotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.preRotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preScale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preScale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        if (dest.hasArray() && src.hasArray() && pivot.hasArray()) {
            Double4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, pivot.array(), pivot.arrayOffset() + pivotOffset, s);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double4x4OpsKernelsAddress.preScaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preScaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && s.hasArray() && pivot.hasArray()) {
            Double4x4Ops.preScaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s.array(), s.arrayOffset() + sOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preScaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(s.duplicate().position(0)), (long) sOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.preTranslate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.preTranslate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.preTranslate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer preTranslate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.preTranslate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.preTranslate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer project_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double objX, double objY, double objZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.project_no_unsafe(dest, destOffset, src, srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.project_no_api(dest, destOffset, src, srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer project_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double objX, double objY, double objZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.project_no_unsafe(_destBase, _srcBase, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer project_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double objX, double objY, double objZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.project_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Double4x4OpsKernelsSegment.project_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer project_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double objX, double objY, double objZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.project_zo_unsafe(dest, destOffset, src, srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.project_zo_api(dest, destOffset, src, srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer project_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double objX, double objY, double objZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.project_zo_unsafe(_destBase, _srcBase, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer project_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double objX, double objY, double objZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.project_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Double4x4OpsKernelsSegment.project_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, objX, objY, objZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer project_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer obj, int objOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && obj.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.project_no_unsafe(dest, destOffset, src, srcOffset, obj, objOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.project_no_api(dest, destOffset, src, srcOffset, obj, objOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer project_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer obj, int objOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _objBase = UnsafeOpsHolder.U.getLong(obj, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.project_no_unsafe(_destBase, _srcBase, _objBase, _viewportBase);
        return dest;
    }

    public static java.nio.DoubleBuffer project_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer obj, int objOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && obj.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.project_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, obj.array(), obj.arrayOffset() + objOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.project_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(obj.duplicate().position(0)), (long) objOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer project_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer obj, int objOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && obj.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.project_zo_unsafe(dest, destOffset, src, srcOffset, obj, objOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.project_zo_api(dest, destOffset, src, srcOffset, obj, objOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer project_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer obj, int objOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _objBase = UnsafeOpsHolder.U.getLong(obj, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) objOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.project_zo_unsafe(_destBase, _srcBase, _objBase, _viewportBase);
        return dest;
    }

    public static java.nio.DoubleBuffer project_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer obj, int objOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && obj.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.project_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, obj.array(), obj.arrayOffset() + objOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.project_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(obj.duplicate().position(0)), (long) objOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double normalX, double normalY, double normalZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normalX, normalY, normalZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, normalX, normalY, normalZ);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _normalBase = UnsafeOpsHolder.U.getLong(normal, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) normalOffset * 8L;
        Double4x4OpsKernelsAddress.reflect_unsafe(_destBase, _srcBase, _normalBase);
        return dest;
    }

    public static java.nio.DoubleBuffer reflect_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer normal, int normalOffset) {
        if (dest.hasArray() && src.hasArray() && normal.hasArray()) {
            Double4x4Ops.reflect(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, normal.array(), normal.arrayOffset() + normalOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.reflect_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(normal.duplicate().position(0)), (long) normalOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double rotX, double rotY, double rotZ, double rotW, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, rotX, rotY, rotZ, rotW, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _rotBase = UnsafeOpsHolder.U.getLong(rot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rotOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double4x4OpsKernelsAddress.rotateAround_unsafe(_destBase, _srcBase, _rotBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer rot, int rotOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && rot.hasArray() && pivot.hasArray()) {
            Double4x4Ops.rotateAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, rot.array(), rot.arrayOffset() + rotOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rot.duplicate().position(0)), (long) rotOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle, double axisX, double axisY, double axisZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle, axisX, axisY, axisZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle, axisX, axisY, axisZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _axisBase = UnsafeOpsHolder.U.getLong(axis, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) axisOffset * 8L;
        Double4x4OpsKernelsAddress.rotateAxis_unsafe(_destBase, _srcBase, _axisBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateAxis_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer axis, int axisOffset, double angle) {
        if (dest.hasArray() && src.hasArray() && axis.hasArray()) {
            Double4x4Ops.rotateAxis(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, axis.array(), axis.arrayOffset() + axisOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateAxis_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(axis.duplicate().position(0)), (long) axisOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double qX, double qY, double qZ, double qW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, qX, qY, qZ, qW);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, qX, qY, qZ, qW);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _qBase = UnsafeOpsHolder.U.getLong(q, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) qOffset * 8L;
        Double4x4OpsKernelsAddress.rotateQuat_unsafe(_destBase, _srcBase, _qBase);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateQuat_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer q, int qOffset) {
        if (dest.hasArray() && src.hasArray() && q.hasArray()) {
            Double4x4Ops.rotateQuat(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, q.array(), q.arrayOffset() + qOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateQuat_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(q.duplicate().position(0)), (long) qOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateX_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXYZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateXYZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXYZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateXYZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateXYZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXZY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateXZY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateXZY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateXZY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateXZY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateY_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYXZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateYXZ_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYXZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateYXZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateYXZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYZX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateYZX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateYZX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateYZX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateYZX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateZ_unsafe(_destBase, _srcBase, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZ_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angle) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateZ(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angle);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateZ_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angle);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZXY_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateZXY_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZXY_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateZXY(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateZXY_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZYX_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.rotateZYX_unsafe(_destBase, _srcBase, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer rotateZYX_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double angleX, double angleY, double angleZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.rotateZYX(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, angleX, angleY, angleZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.rotateZYX_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, angleX, angleY, angleZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.scale_unsafe(_destBase, _srcBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scale_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.scale(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s);
            return dest;
        }
        Double4x4OpsKernelsSegment.scale_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double s, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, s, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _pivotBase, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer pivot, int pivotOffset, double s) {
        if (dest.hasArray() && src.hasArray() && pivot.hasArray()) {
            Double4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, pivot.array(), pivot.arrayOffset() + pivotOffset, s);
            return dest;
        }
        Double4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L, s);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double sX, double sY, double sZ, double pivotX, double pivotY, double pivotZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, sX, sY, sZ, pivotX, pivotY, pivotZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, sX, sY, sZ, pivotX, pivotY, pivotZ);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _sBase = UnsafeOpsHolder.U.getLong(s, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) sOffset * 8L;
        long _pivotBase = UnsafeOpsHolder.U.getLong(pivot, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pivotOffset * 8L;
        Double4x4OpsKernelsAddress.scaleAround_unsafe(_destBase, _srcBase, _sBase, _pivotBase);
        return dest;
    }

    public static java.nio.DoubleBuffer scaleAround_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer s, int sOffset, java.nio.DoubleBuffer pivot, int pivotOffset) {
        if (dest.hasArray() && src.hasArray() && s.hasArray() && pivot.hasArray()) {
            Double4x4Ops.scaleAround(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, s.array(), s.arrayOffset() + sOffset, pivot.array(), pivot.arrayOffset() + pivotOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.scaleAround_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(s.duplicate().position(0)), (long) sOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(pivot.duplicate().position(0)), (long) pivotOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer shadow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double lightX, double lightY, double lightZ, double lightW, double planeX, double planeY, double planeZ, double planeW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.shadow_unsafe(_destBase, _srcBase, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer shadow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double lightX, double lightY, double lightZ, double lightW, double planeX, double planeY, double planeZ, double planeW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.shadow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
            return dest;
        }
        Double4x4OpsKernelsSegment.shadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, lightX, lightY, lightZ, lightW, planeX, planeY, planeZ, planeW);
        return dest;
    }

    public static java.nio.DoubleBuffer shadow_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer light, int lightOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _lightBase = UnsafeOpsHolder.U.getLong(light, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) lightOffset * 8L;
        long _planeBase = UnsafeOpsHolder.U.getLong(plane, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) planeOffset * 8L;
        Double4x4OpsKernelsAddress.shadow_unsafe(_destBase, _srcBase, _lightBase, _planeBase);
        return dest;
    }

    public static java.nio.DoubleBuffer shadow_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer light, int lightOffset, java.nio.DoubleBuffer plane, int planeOffset) {
        if (dest.hasArray() && src.hasArray() && light.hasArray() && plane.hasArray()) {
            Double4x4Ops.shadow(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, light.array(), light.arrayOffset() + lightOffset, plane.array(), plane.arrayOffset() + planeOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.shadow_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(light.duplicate().position(0)), (long) lightOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(plane.duplicate().position(0)), (long) planeOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer shear_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xy, double xz, double yx, double yz, double zx, double zy) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.shear_unsafe(_destBase, _srcBase, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.DoubleBuffer shear_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double xy, double xz, double yx, double yz, double zx, double zy) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.shear(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, xy, xz, yx, yz, zx, zy);
            return dest;
        }
        Double4x4OpsKernelsSegment.shear_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, xy, xz, yx, yz, zx, zy);
        return dest;
    }

    public static java.nio.DoubleBuffer tile_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y, double w, double h) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.tile_unsafe(_destBase, _srcBase, x, y, w, h);
        return dest;
    }

    public static java.nio.DoubleBuffer tile_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double x, double y, double w, double h) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.tile(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, x, y, w, h);
            return dest;
        }
        Double4x4OpsKernelsSegment.tile_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, x, y, w, h);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.translate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.translate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.translate_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer translate_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.translate(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.translate_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer trapezoidCrop_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p0X, double p0Y, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.trapezoidCrop_unsafe(_destBase, _srcBase, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.DoubleBuffer trapezoidCrop_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double p0X, double p0Y, double p1X, double p1Y, double p2X, double p2Y, double p3X, double p3Y) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.trapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
            return dest;
        }
        Double4x4OpsKernelsSegment.trapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, p0X, p0Y, p1X, p1Y, p2X, p2Y, p3X, p3Y);
        return dest;
    }

    public static java.nio.DoubleBuffer trapezoidCrop_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p0, int p0Offset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _p0Base = UnsafeOpsHolder.U.getLong(p0, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p0Offset * 8L;
        long _p1Base = UnsafeOpsHolder.U.getLong(p1, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p1Offset * 8L;
        long _p2Base = UnsafeOpsHolder.U.getLong(p2, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p2Offset * 8L;
        long _p3Base = UnsafeOpsHolder.U.getLong(p3, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) p3Offset * 8L;
        Double4x4OpsKernelsAddress.trapezoidCrop_unsafe(_destBase, _srcBase, _p0Base, _p1Base, _p2Base, _p3Base);
        return dest;
    }

    public static java.nio.DoubleBuffer trapezoidCrop_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer p0, int p0Offset, java.nio.DoubleBuffer p1, int p1Offset, java.nio.DoubleBuffer p2, int p2Offset, java.nio.DoubleBuffer p3, int p3Offset) {
        if (dest.hasArray() && src.hasArray() && p0.hasArray() && p1.hasArray() && p2.hasArray() && p3.hasArray()) {
            Double4x4Ops.trapezoidCrop(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, p0.array(), p0.arrayOffset() + p0Offset, p1.array(), p1.arrayOffset() + p1Offset, p2.array(), p2.arrayOffset() + p2Offset, p3.array(), p3.arrayOffset() + p3Offset);
            return dest;
        }
        Double4x4OpsKernelsSegment.trapezoidCrop_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p0.duplicate().position(0)), (long) p0Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p1.duplicate().position(0)), (long) p1Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p2.duplicate().position(0)), (long) p2Offset * 8L, java.lang.foreign.MemorySegment.ofBuffer(p3.duplicate().position(0)), (long) p3Offset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unproject_no_unsafe(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unproject_no_api(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unproject_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unproject_no_unsafe(_destBase, _srcBase, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unproject_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Double4x4OpsKernelsSegment.unproject_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unproject_zo_unsafe(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unproject_zo_api(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unproject_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unproject_zo_unsafe(_destBase, _srcBase, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unproject_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Double4x4OpsKernelsSegment.unproject_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unproject_no_unsafe(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unproject_no_api(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unproject_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unproject_no_unsafe(_destBase, _srcBase, _winCoordsBase, _viewportBase);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unproject_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.unproject_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unproject_zo_unsafe(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unproject_zo_api(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unproject_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unproject_zo_unsafe(_destBase, _srcBase, _winCoordsBase, _viewportBase);
        return dest;
    }

    public static java.nio.DoubleBuffer unproject_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unproject_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.unproject_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInv_no_unsafe(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unprojectInv_no_api(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unprojectInv_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInv_no_unsafe(_destBase, _srcBase, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInv_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Double4x4OpsKernelsSegment.unprojectInv_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInv_zo_unsafe(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unprojectInv_zo_api(dest, destOffset, src, srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unprojectInv_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInv_zo_unsafe(_destBase, _srcBase, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double winCoordsZ, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInv_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
            return dest;
        }
        Double4x4OpsKernelsSegment.unprojectInv_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, winCoordsZ, viewportX, viewportY, viewportZ, viewportW);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_no(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInv_no_unsafe(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unprojectInv_no_api(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unprojectInv_no_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInv_no_unsafe(_destBase, _srcBase, _winCoordsBase, _viewportBase);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_no_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInv_no(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.unprojectInv_no_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_zo(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && dest.isDirect() && !dest.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInv_zo_unsafe(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unprojectInv_zo_api(dest, destOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unprojectInv_zo_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInv_zo_unsafe(_destBase, _srcBase, _winCoordsBase, _viewportBase);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInv_zo_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (dest.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInv_zo(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.unprojectInv_zo_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_no(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_no_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_no_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unprojectInvRay_no_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInvRay_no_unsafe(_rayOriginBase, _rayDirBase, _srcBase, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_no_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInvRay_no(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectInvRay_no_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_zo(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_zo_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_zo_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unprojectInvRay_zo_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInvRay_zo_unsafe(_rayOriginBase, _rayDirBase, _srcBase, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_zo_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInvRay_zo(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectInvRay_zo_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_no(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_no_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_no_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unprojectInvRay_no_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInvRay_no_unsafe(_rayOriginBase, _rayDirBase, _srcBase, _winCoordsBase, _viewportBase);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_no_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInvRay_no(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectInvRay_no_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_zo(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_zo_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unprojectInvRay_zo_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unprojectInvRay_zo_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectInvRay_zo_unsafe(_rayOriginBase, _rayDirBase, _srcBase, _winCoordsBase, _viewportBase);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectInvRay_zo_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unprojectInvRay_zo(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectInvRay_zo_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_no(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectRay_no_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unprojectRay_no_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unprojectRay_no_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectRay_no_unsafe(_rayOriginBase, _rayDirBase, _srcBase, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_no_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unprojectRay_no(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectRay_no_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_zo(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectRay_zo_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return Double4x4OpsKernelsTypedBuffer.unprojectRay_zo_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
    }

    public static java.nio.DoubleBuffer unprojectRay_zo_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectRay_zo_unsafe(_rayOriginBase, _rayDirBase, _srcBase, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_zo_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, double winCoordsX, double winCoordsY, double viewportX, double viewportY, double viewportZ, double viewportW) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray()) {
            Double4x4OpsKernelsArray.unprojectRay_zo(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectRay_zo_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, winCoordsX, winCoordsY, viewportX, viewportY, viewportZ, viewportW);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_no(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectRay_no_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unprojectRay_no_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unprojectRay_no_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectRay_no_unsafe(_rayOriginBase, _rayDirBase, _srcBase, _winCoordsBase, _viewportBase);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_no_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unprojectRay_no(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectRay_no_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_zo(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (Joml.STORE_LOAD_BACKEND == StoreLoadBackend.UNSAFE && rayOrigin.isDirect() && !rayOrigin.isReadOnly() && rayDir.isDirect() && !rayDir.isReadOnly() && src.isDirect() && winCoords.isDirect() && viewport.isDirect()) return Double4x4OpsKernelsTypedBuffer.unprojectRay_zo_unsafe(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
        return Double4x4OpsKernelsTypedBuffer.unprojectRay_zo_api(rayOrigin, rayOriginOffset, rayDir, rayDirOffset, src, srcOffset, winCoords, winCoordsOffset, viewport, viewportOffset);
    }

    public static java.nio.DoubleBuffer unprojectRay_zo_unsafe(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        long _rayOriginBase = UnsafeOpsHolder.U.getLong(rayOrigin, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayOriginOffset * 8L;
        long _rayDirBase = UnsafeOpsHolder.U.getLong(rayDir, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) rayDirOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _winCoordsBase = UnsafeOpsHolder.U.getLong(winCoords, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) winCoordsOffset * 8L;
        long _viewportBase = UnsafeOpsHolder.U.getLong(viewport, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) viewportOffset * 8L;
        Double4x4OpsKernelsAddress.unprojectRay_zo_unsafe(_rayOriginBase, _rayDirBase, _srcBase, _winCoordsBase, _viewportBase);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer unprojectRay_zo_api(java.nio.DoubleBuffer rayOrigin, int rayOriginOffset, java.nio.DoubleBuffer rayDir, int rayDirOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer winCoords, int winCoordsOffset, java.nio.DoubleBuffer viewport, int viewportOffset) {
        if (rayOrigin.hasArray() && rayDir.hasArray() && src.hasArray() && winCoords.hasArray() && viewport.hasArray()) {
            Double4x4OpsKernelsArray.unprojectRay_zo(rayOrigin.array(), rayOrigin.arrayOffset() + rayOriginOffset, rayDir.array(), rayDir.arrayOffset() + rayDirOffset, src.array(), src.arrayOffset() + srcOffset, winCoords.array(), winCoords.arrayOffset() + winCoordsOffset, viewport.array(), viewport.arrayOffset() + viewportOffset);
            return rayOrigin;
        }
        Double4x4OpsKernelsSegment.unprojectRay_zo_api(java.lang.foreign.MemorySegment.ofBuffer(rayOrigin.duplicate().position(0)), (long) rayOriginOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(rayDir.duplicate().position(0)), (long) rayDirOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(winCoords.duplicate().position(0)), (long) winCoordsOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(viewport.duplicate().position(0)), (long) viewportOffset * 8L);
        return rayOrigin;
    }

    public static java.nio.DoubleBuffer mulVec4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ, double vW) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ, double vW) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.mulVec4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ, vW);
            return dest;
        }
        Double4x4OpsKernelsSegment.mulVec4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ, vW);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.mulVec4_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer mulVec4_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.mulVec4(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.mulVec4_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformAabb_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.transformAabb_unsafe(_destBase, _srcBase, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformAabb_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.transformAabb(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, minX, minY, minZ, maxX, maxY, maxZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformAabb_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, minX, minY, minZ, maxX, maxY, maxZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.transformDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.transformDirection(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformDirection_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.transformPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.transformPosition(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformPosition_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformProject_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        Double4x4OpsKernelsAddress.transformProject_unsafe(_destBase, _srcBase, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformProject_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, double vX, double vY, double vZ) {
        if (dest.hasArray() && src.hasArray()) {
            Double4x4Ops.transformProject(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, vX, vY, vZ);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformProject_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, vX, vY, vZ);
        return dest;
    }

    public static java.nio.DoubleBuffer transformProject_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _srcBase = UnsafeOpsHolder.U.getLong(src, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) srcOffset * 8L;
        long _vBase = UnsafeOpsHolder.U.getLong(v, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) vOffset * 8L;
        Double4x4OpsKernelsAddress.transformProject_unsafe(_destBase, _srcBase, _vBase);
        return dest;
    }

    public static java.nio.DoubleBuffer transformProject_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer src, int srcOffset, java.nio.DoubleBuffer v, int vOffset) {
        if (dest.hasArray() && src.hasArray() && v.hasArray()) {
            Double4x4Ops.transformProject(dest.array(), dest.arrayOffset() + destOffset, src.array(), src.arrayOffset() + srcOffset, v.array(), v.arrayOffset() + vOffset);
            return dest;
        }
        Double4x4OpsKernelsSegment.transformProject_api(java.lang.foreign.MemorySegment.ofBuffer(dest.duplicate().position(0)), (long) destOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(src.duplicate().position(0)), (long) srcOffset * 8L, java.lang.foreign.MemorySegment.ofBuffer(v.duplicate().position(0)), (long) vOffset * 8L);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 8L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 8L;
        Double4x4OpsKernelsAddress.transformPosition_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer transformPosition_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        double _m00 = matrix.get(matrixOffset + 0);
        double _m01 = matrix.get(matrixOffset + 4);
        double _m02 = matrix.get(matrixOffset + 8);
        double _m03 = matrix.get(matrixOffset + 12);
        double _m10 = matrix.get(matrixOffset + 1);
        double _m11 = matrix.get(matrixOffset + 5);
        double _m12 = matrix.get(matrixOffset + 9);
        double _m13 = matrix.get(matrixOffset + 13);
        double _m20 = matrix.get(matrixOffset + 2);
        double _m21 = matrix.get(matrixOffset + 6);
        double _m22 = matrix.get(matrixOffset + 10);
        double _m23 = matrix.get(matrixOffset + 14);
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
        Double4x4OpsKernelsAddress.transformDirection_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer transformDirection_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        double _m00 = matrix.get(matrixOffset + 0);
        double _m01 = matrix.get(matrixOffset + 4);
        double _m02 = matrix.get(matrixOffset + 8);
        double _m10 = matrix.get(matrixOffset + 1);
        double _m11 = matrix.get(matrixOffset + 5);
        double _m12 = matrix.get(matrixOffset + 9);
        double _m20 = matrix.get(matrixOffset + 2);
        double _m21 = matrix.get(matrixOffset + 6);
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

    public static java.nio.DoubleBuffer transformProject_unsafe(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        long _destBase = UnsafeOpsHolder.U.getLong(dest, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) destOffset * 8L;
        long _matrixBase = UnsafeOpsHolder.U.getLong(matrix, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) matrixOffset * 8L;
        long _pointsBase = UnsafeOpsHolder.U.getLong(points, UnsafeCopy.BB_ADDRESS_OFFSET) + (long) pointsOffset * 8L;
        Double4x4OpsKernelsAddress.transformProject_unsafe(_destBase, _matrixBase, _pointsBase, count);
        return dest;
    }

    public static java.nio.DoubleBuffer transformProject_api(java.nio.DoubleBuffer dest, int destOffset, java.nio.DoubleBuffer matrix, int matrixOffset, java.nio.DoubleBuffer points, int pointsOffset, int count) {
        double _m00 = matrix.get(matrixOffset + 0);
        double _m01 = matrix.get(matrixOffset + 4);
        double _m02 = matrix.get(matrixOffset + 8);
        double _m03 = matrix.get(matrixOffset + 12);
        double _m10 = matrix.get(matrixOffset + 1);
        double _m11 = matrix.get(matrixOffset + 5);
        double _m12 = matrix.get(matrixOffset + 9);
        double _m13 = matrix.get(matrixOffset + 13);
        double _m20 = matrix.get(matrixOffset + 2);
        double _m21 = matrix.get(matrixOffset + 6);
        double _m22 = matrix.get(matrixOffset + 10);
        double _m23 = matrix.get(matrixOffset + 14);
        double _m30 = matrix.get(matrixOffset + 3);
        double _m31 = matrix.get(matrixOffset + 7);
        double _m32 = matrix.get(matrixOffset + 11);
        double _m33 = matrix.get(matrixOffset + 15);
        for (int _i = 0; _i < count; _i++) {
            int _po = pointsOffset + _i * 3;
            int _do = destOffset + _i * 3;
            double px = points.get(_po + 0), py = points.get(_po + 1), pz = points.get(_po + 2);
            double _w = Math.fma(_m30, px, Math.fma(_m31, py, Math.fma(_m32, pz, _m33)));
            double _inv = 1.0 / _w;
            dest.put(_do + 0, (Math.fma(_m00, px, Math.fma(_m01, py, Math.fma(_m02, pz, _m03)))) * _inv);
            dest.put(_do + 1, (Math.fma(_m10, px, Math.fma(_m11, py, Math.fma(_m12, pz, _m13)))) * _inv);
            dest.put(_do + 2, (Math.fma(_m20, px, Math.fma(_m21, py, Math.fma(_m22, pz, _m23)))) * _inv);
        }
        return dest;
    }

}
